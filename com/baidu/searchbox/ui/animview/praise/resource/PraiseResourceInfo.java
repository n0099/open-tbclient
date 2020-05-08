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
/* loaded from: classes13.dex */
public final class PraiseResourceInfo {
    private static final String JSON_KEY_MAX_HOST_VER = "max_host_ver";
    private static final String JSON_KEY_MIN_HOST_VER = "min_host_ver";
    private static final String JSON_KEY_PKG_NAME = "pkg_name";
    private static final String JSON_KEY_RES_SAVE_PATH = "res_save_path";
    private static final String JSON_KEY_VERSION = "version";
    private static final String TAG = "PraiseResourceInfo";
    private static final int VERSION_LENGTH = 4;
    private static final String VERSION_NAME_SEPARATOR_REGEX = "\\.";
    private static final int VERSION_RADIX = 100;
    private Context mAppContext = AppRuntime.getAppContext();
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

    public static PraiseResourceInfo valueOf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new PraiseResourceInfo(jSONObject.optString(JSON_KEY_PKG_NAME), "", jSONObject.optString(JSON_KEY_RES_SAVE_PATH), jSONObject.optLong("version"), jSONObject.optString(JSON_KEY_MIN_HOST_VER), jSONObject.optString(JSON_KEY_MAX_HOST_VER));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mPkgName) || TextUtils.isEmpty(this.mDownloadFilePath) || TextUtils.isEmpty(this.mMinHostVer) || TextUtils.isEmpty(this.mMaxHostVer)) ? false : true;
    }

    public boolean isAvailable() {
        return new File(this.mPraiseResSavePath).exists() && checkHostVersion();
    }

    private boolean checkHostVersion() {
        try {
            PackageInfo packageInfo = this.mAppContext.getPackageManager().getPackageInfo(this.mAppContext.getPackageName(), 0);
            if (packageInfo == null) {
                return false;
            }
            long convertToLongValue = convertToLongValue(packageInfo.versionName);
            return convertToLongValue(this.mMinHostVer) <= convertToLongValue && convertToLongValue <= convertToLongValue(this.mMaxHostVer);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private long convertToLongValue(String str) {
        String[] split = str.split(VERSION_NAME_SEPARATOR_REGEX);
        long j = 0;
        for (int i = 0; i < 4; i++) {
            try {
                if (i < split.length) {
                    j = (j * 100) + Integer.valueOf(split[i]).intValue();
                } else {
                    j *= 100;
                }
            } catch (NumberFormatException e) {
                return 0L;
            }
        }
        return j;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_KEY_PKG_NAME, this.mPkgName);
            jSONObject.put(JSON_KEY_RES_SAVE_PATH, this.mPraiseResSavePath);
            jSONObject.put("version", this.mVersion);
            jSONObject.put(JSON_KEY_MIN_HOST_VER, this.mMinHostVer);
            jSONObject.put(JSON_KEY_MAX_HOST_VER, this.mMaxHostVer);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String toString() {
        return toJSONString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PraiseResourceInfo praiseResourceInfo = (PraiseResourceInfo) obj;
        if (this.mVersion == praiseResourceInfo.mVersion && TextUtils.equals(this.mPkgName, praiseResourceInfo.mPkgName) && TextUtils.equals(this.mPraiseResSavePath, praiseResourceInfo.mPraiseResSavePath) && TextUtils.equals(this.mMinHostVer, praiseResourceInfo.mMinHostVer)) {
            return TextUtils.equals(this.mMaxHostVer, praiseResourceInfo.mMaxHostVer);
        }
        return false;
    }

    public int hashCode() {
        return (TextUtils.isEmpty(this.mMaxHostVer) ? "".hashCode() : this.mMaxHostVer.hashCode()) + (((TextUtils.isEmpty(this.mMinHostVer) ? "".hashCode() : this.mMinHostVer.hashCode()) + (((((TextUtils.isEmpty(this.mPraiseResSavePath) ? "".hashCode() : this.mPraiseResSavePath.hashCode()) + ((TextUtils.isEmpty(this.mPkgName) ? "".hashCode() : this.mPkgName.hashCode()) * 31)) * 31) + ((int) (this.mVersion ^ (this.mVersion >>> 32)))) * 31)) * 31);
    }
}
