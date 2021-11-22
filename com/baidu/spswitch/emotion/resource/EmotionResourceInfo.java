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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                return convertToLongValue(this.mMinHostVer) <= convertToLongValue && convertToLongValue <= convertToLongValue(this.mMaxHostVer);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private long convertToLongValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String[] split = str.split(VERSION_NAME_SEPARATOR_REGEX);
            int i2 = 0;
            long j = 0;
            while (i2 < 4) {
                try {
                    j = i2 < split.length ? (j * 100) + Integer.valueOf(split[i2]).intValue() : j * 100;
                    i2++;
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
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            if (this.mVersion == emotionResourceInfo.mVersion && TextUtils.equals(this.mPkgName, emotionResourceInfo.mPkgName) && TextUtils.equals(this.mEmotionResSavePath, emotionResourceInfo.mEmotionResSavePath) && TextUtils.equals(this.mMinHostVer, emotionResourceInfo.mMinHostVer)) {
                return TextUtils.equals(this.mMaxHostVer, emotionResourceInfo.mMaxHostVer);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int hashCode = (TextUtils.isEmpty(this.mPkgName) ? 0 : this.mPkgName.hashCode()) * 31;
            int hashCode2 = TextUtils.isEmpty(this.mEmotionResSavePath) ? 0 : this.mEmotionResSavePath.hashCode();
            long j = this.mVersion;
            return ((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (TextUtils.isEmpty(this.mMinHostVer) ? 0 : this.mMinHostVer.hashCode())) * 31) + (TextUtils.isEmpty(this.mMaxHostVer) ? 0 : this.mMaxHostVer.hashCode());
        }
        return invokeV.intValue;
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new File(this.mEmotionResSavePath).exists() && checkHostVersion() : invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (TextUtils.isEmpty(this.mPkgName) || TextUtils.isEmpty(this.mDownloadFilePath) || TextUtils.isEmpty(this.mMinHostVer) || TextUtils.isEmpty(this.mMaxHostVer)) ? false : true : invokeV.booleanValue;
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
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? toJSONString() : (String) invokeV.objValue;
    }
}
