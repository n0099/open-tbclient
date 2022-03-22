package com.baidu.minivideo.plugin.capture.db;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.minivideo.plugin.capture.utils.PreferenceUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UgcSharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_ROINTS_LIST = "audio_points_list";
    public static final String CAPTURE_CONFIG = "capture_config";
    public static final String ENCODE_HARD_SUPPORT_MAX_H = "encode_max_h";
    public static final String ENCODE_HARD_SUPPORT_MAX_W = "encode_max_w";
    public static final String FRONT_OR_BACK_CAMERA = "front_or_back_camera";
    public static final String KEY_BEAUTIFUL_LEVEL = "key_beautiful_level";
    public static final String KEY_CONFIG_DISPLAY_TIMES = "winDisplayTimes";
    public static final String KEY_FILTER = "key_filter";
    public static final String KEY_SAVE_VIDEO_LOACL = "save_video_local";
    public static final String KEY_THIN_FACE_LEVEL = "key_thin_face_level";
    public static final String LAST_CAPTURE_CONFIG_TIME = "last_capture_update_config";
    public static final String MUSIC_INFO = "music_info";
    public static final String PREF = "bdminivideo_capture_sdk";
    public static final String SYNC_VIDEO_PUBLISH_CONFIG = "sync_video_publish_config";
    public static final String TAG = "UgcSharedPreferencesTAG";
    public static SharedPreferences sPref;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343127436, "Lcom/baidu/minivideo/plugin/capture/db/UgcSharedPreferences;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343127436, "Lcom/baidu/minivideo/plugin/capture/db/UgcSharedPreferences;");
                return;
            }
        }
        sPref = Application.get().getSharedPreferences(PREF, 0);
    }

    public UgcSharedPreferences() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getBeautifulLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sPref.getInt(KEY_BEAUTIFUL_LEVEL, 65) : invokeV.intValue;
    }

    public static String getCaptureConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sPref.getString(CAPTURE_CONFIG, "") : (String) invokeV.objValue;
    }

    public static Point getEncodeSupportMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sPref.contains(ENCODE_HARD_SUPPORT_MAX_W)) {
                return new Point(sPref.getInt(ENCODE_HARD_SUPPORT_MAX_W, 0), sPref.getInt(ENCODE_HARD_SUPPORT_MAX_H, 0));
            }
            return null;
        }
        return (Point) invokeV.objValue;
    }

    public static String getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? sPref.getString(KEY_FILTER, null) : (String) invokeV.objValue;
    }

    public static long getLastCaptureConfigTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? sPref.getLong(LAST_CAPTURE_CONFIG_TIME, 0L) : invokeV.longValue;
    }

    public static int getSaveVideoLocalStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sPref.getInt(KEY_SAVE_VIDEO_LOACL, -1) : invokeV.intValue;
    }

    public static int getShootDisplayLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sPref.getInt(KEY_CONFIG_DISPLAY_TIMES, 0) : invokeV.intValue;
    }

    public static int getSyncIconCloseTimes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? sPref.getInt(str, 0) : invokeL.intValue;
    }

    public static String getSyncVideoPublishConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? sPref.getString(SYNC_VIDEO_PUBLISH_CONFIG, "") : (String) invokeV.objValue;
    }

    public static int getThinFaceLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? sPref.getInt(KEY_THIN_FACE_LEVEL, 65) : invokeV.intValue;
    }

    public static boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sPref.getBoolean(FRONT_OR_BACK_CAMERA, true) : invokeV.booleanValue;
    }

    public static void setBeautifulLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            sPref.edit().putInt(KEY_BEAUTIFUL_LEVEL, i).apply();
        }
    }

    public static void setCameraFront(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            sPref.edit().putBoolean(FRONT_OR_BACK_CAMERA, z).apply();
        }
    }

    public static void setCaptureConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(CAPTURE_CONFIG, str).apply();
    }

    public static void setCreatorCenterConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("creatorCenter");
            if (optJSONObject != null) {
                LogUtils.d("mini_ugc_creator_center(app) --> " + optJSONObject.toString());
                PreferenceUtils.putString("mini_ugc_creator_center", optJSONObject.toString());
            } else {
                PreferenceUtils.putString("mini_ugc_creator_center", "");
            }
        } catch (Exception unused) {
            PreferenceUtils.putString("mini_ugc_creator_center", "");
        }
    }

    public static void setEncodeSupportMaxSize(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, point) == null) {
            SharedPreferences.Editor edit = sPref.edit();
            if (point != null) {
                edit.putInt(ENCODE_HARD_SUPPORT_MAX_W, point.x);
                edit.putInt(ENCODE_HARD_SUPPORT_MAX_H, point.y).apply();
                return;
            }
            edit.remove(ENCODE_HARD_SUPPORT_MAX_W);
            edit.remove(ENCODE_HARD_SUPPORT_MAX_H).apply();
        }
    }

    public static void setFilter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            sPref.edit().putString(KEY_FILTER, str).apply();
        }
    }

    public static void setLastCaptureConfigTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65555, null, j) == null) {
            sPref.edit().putLong(LAST_CAPTURE_CONFIG_TIME, j).apply();
        }
    }

    public static void setSaveVideoLocalStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, null, i) == null) {
            sPref.edit().putInt(KEY_SAVE_VIDEO_LOACL, i).apply();
        }
    }

    public static void setShootDisplayLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i) == null) {
            sPref.edit().putInt(KEY_CONFIG_DISPLAY_TIMES, i).apply();
        }
    }

    public static void setSyncIconCloseTimes(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65558, null, str, i) == null) {
            sPref.edit().putInt(str, i).apply();
        }
    }

    public static void setSyncVideoPublishConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(SYNC_VIDEO_PUBLISH_CONFIG, str).apply();
    }

    public static void setThinFaceLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, null, i) == null) {
            sPref.edit().putInt(KEY_THIN_FACE_LEVEL, i).apply();
        }
    }
}
