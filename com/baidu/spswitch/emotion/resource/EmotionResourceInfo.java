package com.baidu.spswitch.emotion.resource;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class EmotionResourceInfo {
    public static final String JSON_KEY_MAX_HOST_VER = "max_host_ver";
    public static final String JSON_KEY_MIN_HOST_VER = "min_host_ver";
    public static final String JSON_KEY_PKG_NAME = "pkg_name";
    public static final String JSON_KEY_RES_SAVE_PATH = "res_save_path";
    public static final String JSON_KEY_VERSION = "version";
    public static final String TAG = "EmotionResourceInfo";
    public static final int VERSION_LENGTH = 4;
    public static final String VERSION_NAME_SEPARATOR_REGEX = "\\.";
    public static final int VERSION_RADIX = 100;
    public Context mAppContext = AppRuntime.getAppContext();
    public final String mDownloadFilePath;
    public String mEmotionResSavePath;
    public final String mMaxHostVer;
    public final String mMinHostVer;
    public final String mPkgName;
    public IResourceProvider mProvider;
    public final long mVersion;

    public EmotionResourceInfo(String str, String str2, String str3, long j, String str4, String str5) {
        this.mPkgName = str;
        this.mDownloadFilePath = str2;
        this.mEmotionResSavePath = str3;
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
            return convertToLongValue(this.mMinHostVer) <= convertToLongValue && convertToLongValue <= convertToLongValue(this.mMaxHostVer);
        } catch (PackageManager.NameNotFoundException unused) {
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
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return j;
    }

    public static EmotionResourceInfo valueOf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new EmotionResourceInfo(jSONObject.optString(JSON_KEY_PKG_NAME), "", jSONObject.optString(JSON_KEY_RES_SAVE_PATH), jSONObject.optLong("version"), jSONObject.optString(JSON_KEY_MIN_HOST_VER), jSONObject.optString(JSON_KEY_MAX_HOST_VER));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EmotionResourceInfo.class != obj.getClass()) {
            return false;
        }
        EmotionResourceInfo emotionResourceInfo = (EmotionResourceInfo) obj;
        if (this.mVersion == emotionResourceInfo.mVersion && TextUtils.equals(this.mPkgName, emotionResourceInfo.mPkgName) && TextUtils.equals(this.mEmotionResSavePath, emotionResourceInfo.mEmotionResSavePath) && TextUtils.equals(this.mMinHostVer, emotionResourceInfo.mMinHostVer)) {
            return TextUtils.equals(this.mMaxHostVer, emotionResourceInfo.mMaxHostVer);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (TextUtils.isEmpty(this.mPkgName) ? 0 : this.mPkgName.hashCode()) * 31;
        int hashCode2 = TextUtils.isEmpty(this.mEmotionResSavePath) ? 0 : this.mEmotionResSavePath.hashCode();
        long j = this.mVersion;
        return ((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (TextUtils.isEmpty(this.mMinHostVer) ? 0 : this.mMinHostVer.hashCode())) * 31) + (TextUtils.isEmpty(this.mMaxHostVer) ? 0 : this.mMaxHostVer.hashCode());
    }

    public boolean isAvailable() {
        return new File(this.mEmotionResSavePath).exists() && checkHostVersion();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mPkgName) || TextUtils.isEmpty(this.mDownloadFilePath) || TextUtils.isEmpty(this.mMinHostVer) || TextUtils.isEmpty(this.mMaxHostVer)) ? false : true;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_KEY_PKG_NAME, this.mPkgName);
            jSONObject.put(JSON_KEY_RES_SAVE_PATH, this.mEmotionResSavePath);
            jSONObject.put("version", this.mVersion);
            jSONObject.put(JSON_KEY_MIN_HOST_VER, this.mMinHostVer);
            jSONObject.put(JSON_KEY_MAX_HOST_VER, this.mMaxHostVer);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String toString() {
        return toJSONString();
    }
}
