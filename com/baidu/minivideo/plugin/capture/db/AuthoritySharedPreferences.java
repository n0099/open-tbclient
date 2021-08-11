package com.baidu.minivideo.plugin.capture.db;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AuthoritySharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FIRSTSHOT_CONFIG = "firstshot_config";
    public static final String KEY_AUTHORITY_AUDIO_RATIONALE = "key_authority_audio_rationale";
    public static final String KEY_AUTHORITY_AUDIO_RESULT = "key_authority_album";
    public static final String KEY_AUTHORITY_CAMERA_RATIONALE = "key_authority_camera_rationale";
    public static final String KEY_AUTHORITY_CONFIG_TIMESTAMP = "authority_config_timestamp";
    public static final String KEY_AUTHORITY_STORAGE_RATIONALE = "key_authority_storage_rationale";
    public static final String KEY_CONFIG_FIRSTSHOT = "firstShot";
    public static final String KEY_CONFIG_FIRSTSHOT_GUIDE = "guide";
    public static final String KEY_CONFIG_FIRSTSHOT_IMAGE = "image";
    public static final String KEY_CONFIG_PRIVILEGE = "privilege";
    public static final String KEY_CONFIG_PRIVILEGE_APPLY = "apply";
    public static final String KEY_CONFIG_PRIVILEGE_DONE = "done";
    public static final String KEY_CONFIG_PRIVILEGE_OPENCAMERA = "openCamera";
    public static final String KEY_CONFIG_PRIVILEGE_OPENMICROPHONE = "openMicrophone";
    public static final String KEY_CONFIG_PRIVILEGE_OPENSHOT = "openShot";
    public static final String PREF = "authority_config";
    public static final String PRIVILEGE_CONFIG = "privilege_config";
    public static final String TAG = "AuthoritySharedPreferencesTAG";
    public static SharedPreferences sPref;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1294531866, "Lcom/baidu/minivideo/plugin/capture/db/AuthoritySharedPreferences;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1294531866, "Lcom/baidu/minivideo/plugin/capture/db/AuthoritySharedPreferences;");
                return;
            }
        }
        sPref = Application.get().getSharedPreferences(PREF, 0);
    }

    public AuthoritySharedPreferences() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean getAuthorityAlbumResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sPref.getBoolean(KEY_AUTHORITY_AUDIO_RESULT, true) : invokeV.booleanValue;
    }

    public static boolean getAuthorityAudioResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sPref.getBoolean(KEY_AUTHORITY_AUDIO_RATIONALE, true) : invokeV.booleanValue;
    }

    public static boolean getAuthorityCameraResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sPref.getBoolean(KEY_AUTHORITY_CAMERA_RATIONALE, true) : invokeV.booleanValue;
    }

    public static long getAuthorityConfigTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? sPref.getLong(KEY_AUTHORITY_CONFIG_TIMESTAMP, 0L) : invokeV.longValue;
    }

    public static boolean getAuthorityStorageResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sPref.getBoolean(KEY_AUTHORITY_STORAGE_RATIONALE, true) : invokeV.booleanValue;
    }

    public static String getFirstShotConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sPref.getString(FIRSTSHOT_CONFIG, "") : (String) invokeV.objValue;
    }

    public static String getFirstShotImage() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String firstShotConfig = getFirstShotConfig();
            if (TextUtils.isEmpty(firstShotConfig)) {
                return "";
            }
            try {
                JSONObject jSONObject2 = new JSONObject(firstShotConfig);
                return (!jSONObject2.has(KEY_CONFIG_FIRSTSHOT_GUIDE) || (jSONObject = jSONObject2.getJSONObject(KEY_CONFIG_FIRSTSHOT_GUIDE)) == null) ? "" : jSONObject.optString("image");
            } catch (JSONException | Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getPrivilegeConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? sPref.getString(PRIVILEGE_CONFIG, "") : (String) invokeV.objValue;
    }

    public static void setAuthorityAlbumResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            sPref.edit().putBoolean(KEY_AUTHORITY_AUDIO_RESULT, z).apply();
        }
    }

    public static void setAuthorityAudioResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            sPref.edit().putBoolean(KEY_AUTHORITY_AUDIO_RATIONALE, z).apply();
        }
    }

    public static void setAuthorityCameraResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            sPref.edit().putBoolean(KEY_AUTHORITY_CAMERA_RATIONALE, z).apply();
        }
    }

    public static void setAuthorityConfigTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j2) == null) {
            sPref.edit().putLong(KEY_AUTHORITY_CONFIG_TIMESTAMP, j2).apply();
        }
    }

    public static void setAuthorityStorageResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            sPref.edit().putBoolean(KEY_AUTHORITY_STORAGE_RATIONALE, z).apply();
        }
    }

    public static void setFirstShotConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(FIRSTSHOT_CONFIG, str).apply();
    }

    public static void setPrivilegeConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(PRIVILEGE_CONFIG, str).apply();
    }
}
