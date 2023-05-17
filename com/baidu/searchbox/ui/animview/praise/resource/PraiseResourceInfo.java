package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class PraiseResourceInfo {
    public static final String JSON_KEY_MAX_HOST_VER = "max_host_ver";
    public static final String JSON_KEY_MIN_HOST_VER = "min_host_ver";
    public static final String JSON_KEY_PKG_NAME = "pkg_name";
    public static final String JSON_KEY_RES_SAVE_PATH = "res_save_path";
    public static final String JSON_KEY_VERSION = "version";
    public static final String TAG = "PraiseResourceInfo";
    public static final int VERSION_LENGTH = 4;
    public static final String VERSION_NAME_SEPARATOR_REGEX = "\\.";
    public static final int VERSION_RADIX = 100;
    public Context mAppContext = AppRuntime.getAppContext();
    public final String mDownloadFilePath;
    public final String mMaxHostVer;
    public final String mMinHostVer;
    public final String mPkgName;
    public String mPraiseResSavePath;
    public IResourceProvider mProvider;
    public final long mVersion;

    public PraiseResourceInfo(String str, String str2, String str3, long j, String str4, String str5) {
        this.mPkgName = str;
        this.mDownloadFilePath = str2;
        this.mPraiseResSavePath = str3;
        this.mVersion = j;
        this.mMinHostVer = str4;
        this.mMaxHostVer = str5;
    }

    private boolean checkHostVersion() {
        try {
            PackageInfo packageInfo = this.mAppContext.getPackageManager().getPackageInfo(this.mAppContext.getPackageName(), 0);
            if (packageInfo == null) {
                return false;
            }
            long convertToLongValue = convertToLongValue(packageInfo.versionName);
            if (convertToLongValue(this.mMinHostVer) > convertToLongValue || convertToLongValue > convertToLongValue(this.mMaxHostVer)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean isAvailable() {
        if (!new File(this.mPraiseResSavePath).exists() || !checkHostVersion()) {
            return false;
        }
        return true;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.mPkgName) && !TextUtils.isEmpty(this.mDownloadFilePath) && !TextUtils.isEmpty(this.mMinHostVer) && !TextUtils.isEmpty(this.mMaxHostVer)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return toJSONString();
    }

    private long convertToLongValue(String str) {
        String[] split = str.split("\\.");
        long j = 0;
        for (int i = 0; i < 4; i++) {
            try {
                if (i < split.length) {
                    j = (j * 100) + Integer.valueOf(split[i]).intValue();
                } else {
                    j *= 100;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return j;
    }

    public static PraiseResourceInfo valueOf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new PraiseResourceInfo(jSONObject.optString("pkg_name"), "", jSONObject.optString("res_save_path"), jSONObject.optLong("version"), jSONObject.optString("min_host_ver"), jSONObject.optString("max_host_ver"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PraiseResourceInfo.class != obj.getClass()) {
            return false;
        }
        PraiseResourceInfo praiseResourceInfo = (PraiseResourceInfo) obj;
        if (this.mVersion != praiseResourceInfo.mVersion || !TextUtils.equals(this.mPkgName, praiseResourceInfo.mPkgName) || !TextUtils.equals(this.mPraiseResSavePath, praiseResourceInfo.mPraiseResSavePath) || !TextUtils.equals(this.mMinHostVer, praiseResourceInfo.mMinHostVer)) {
            return false;
        }
        return TextUtils.equals(this.mMaxHostVer, praiseResourceInfo.mMaxHostVer);
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i = 0;
        if (TextUtils.isEmpty(this.mPkgName)) {
            hashCode = 0;
        } else {
            hashCode = this.mPkgName.hashCode();
        }
        int i2 = hashCode * 31;
        if (TextUtils.isEmpty(this.mPraiseResSavePath)) {
            hashCode2 = 0;
        } else {
            hashCode2 = this.mPraiseResSavePath.hashCode();
        }
        long j = this.mVersion;
        int i3 = (((i2 + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        if (TextUtils.isEmpty(this.mMinHostVer)) {
            hashCode3 = 0;
        } else {
            hashCode3 = this.mMinHostVer.hashCode();
        }
        int i4 = (i3 + hashCode3) * 31;
        if (!TextUtils.isEmpty(this.mMaxHostVer)) {
            i = this.mMaxHostVer.hashCode();
        }
        return i4 + i;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkg_name", this.mPkgName);
            jSONObject.put("res_save_path", this.mPraiseResSavePath);
            jSONObject.put("version", this.mVersion);
            jSONObject.put("min_host_ver", this.mMinHostVer);
            jSONObject.put("max_host_ver", this.mMaxHostVer);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
