package com.baidu.spswitch.emotion.resource;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class EmotionResourceInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JSON_KEY_MAX_HOST_VER = "max_host_ver";
    public static final String JSON_KEY_MIN_HOST_VER = "min_host_ver";
    public static final String JSON_KEY_PKG_NAME = "pkg_name";
    public static final String JSON_KEY_RES_SAVE_PATH = "res_save_path";
    public static final String JSON_KEY_VERSION = "version";
    public static final String TAG = "EmotionResourceInfo";
    public static final int VERSION_LENGTH = 4;
    public static final String VERSION_NAME_SEPARATOR_REGEX = "\\.";
    public static final int VERSION_RADIX = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public final String mDownloadFilePath;
    public String mEmotionResSavePath;
    public final String mMaxHostVer;
    public final String mMinHostVer;
    public final String mPkgName;
    public IResourceProvider mProvider;
    public final long mVersion;

    public EmotionResourceInfo(String str, String str2, String str3, long j, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPkgName = str;
        this.mDownloadFilePath = str2;
        this.mEmotionResSavePath = str3;
        this.mVersion = j;
        this.mMinHostVer = str4;
        this.mMaxHostVer = str5;
        this.mAppContext = AppRuntime.getAppContext();
    }

    private boolean checkHostVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TextUtils.isEmpty(this.mPkgName) && !TextUtils.isEmpty(this.mDownloadFilePath) && !TextUtils.isEmpty(this.mMinHostVer) && !TextUtils.isEmpty(this.mMaxHostVer)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private long convertToLongValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
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
        return invokeL.longValue;
    }

    public static EmotionResourceInfo valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new EmotionResourceInfo(jSONObject.optString(JSON_KEY_PKG_NAME), "", jSONObject.optString(JSON_KEY_RES_SAVE_PATH), jSONObject.optLong("version"), jSONObject.optString(JSON_KEY_MIN_HOST_VER), jSONObject.optString(JSON_KEY_MAX_HOST_VER));
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (EmotionResourceInfo) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EmotionResourceInfo.class != obj.getClass()) {
                return false;
            }
            EmotionResourceInfo emotionResourceInfo = (EmotionResourceInfo) obj;
            if (this.mVersion != emotionResourceInfo.mVersion || !TextUtils.equals(this.mPkgName, emotionResourceInfo.mPkgName) || !TextUtils.equals(this.mEmotionResSavePath, emotionResourceInfo.mEmotionResSavePath) || !TextUtils.equals(this.mMinHostVer, emotionResourceInfo.mMinHostVer)) {
                return false;
            }
            return TextUtils.equals(this.mMaxHostVer, emotionResourceInfo.mMaxHostVer);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        int hashCode2;
        int hashCode3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            if (TextUtils.isEmpty(this.mPkgName)) {
                hashCode = 0;
            } else {
                hashCode = this.mPkgName.hashCode();
            }
            int i2 = hashCode * 31;
            if (TextUtils.isEmpty(this.mEmotionResSavePath)) {
                hashCode2 = 0;
            } else {
                hashCode2 = this.mEmotionResSavePath.hashCode();
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
        return invokeV.intValue;
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!new File(this.mEmotionResSavePath).exists() || !checkHostVersion()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return toJSONString();
        }
        return (String) invokeV.objValue;
    }

    public String toJSONString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(JSON_KEY_PKG_NAME, this.mPkgName);
                jSONObject.put(JSON_KEY_RES_SAVE_PATH, this.mEmotionResSavePath);
                jSONObject.put("version", this.mVersion);
                jSONObject.put(JSON_KEY_MIN_HOST_VER, this.mMinHostVer);
                jSONObject.put(JSON_KEY_MAX_HOST_VER, this.mMaxHostVer);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
