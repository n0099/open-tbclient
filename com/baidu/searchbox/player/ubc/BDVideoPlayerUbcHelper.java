package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BDVideoPlayerUbcHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static float sPlayerCurrentSpreed = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1464196636, "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1464196636, "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcHelper;");
        }
    }

    public BDVideoPlayerUbcHelper() {
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

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String networkClass = NetUtils.getNetworkClass();
            return (networkClass.equals("no") || networkClass.equals("unknown")) ? "other" : networkClass;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bDVideoPlayerUbcContent, jSONObject)) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
            jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
            jSONObject.put("network", getNetType());
            JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
            extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
            extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
            jSONObject.put("ext", extStatisticsLog.toString());
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static int positive(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? Math.max(i2, 0) : invokeI.intValue;
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bDVideoPlayerUbcContent, jSONObject, str)) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
            } else {
                jSONObject.put("page", str);
            }
            jSONObject.put("network", getNetType());
            JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
            extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
            extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
            jSONObject.put("ext", extStatisticsLog.toString());
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @NonNull
    public static String getUbcContent(@NonNull JSONObject jSONObject, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, bDVideoPlayerUbcContent, jSONObject2)) == null) {
            if (jSONObject2 == null) {
                try {
                    jSONObject2 = new JSONObject();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject2.put("from", bDVideoPlayerUbcContent.getFrom());
            jSONObject2.put("page", bDVideoPlayerUbcContent.getPage());
            jSONObject2.put("network", getNetType());
            jSONObject.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
            jSONObject.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
            float launchSpeedScore = bDVideoPlayerUbcContent.getPlayerFetcher().getLaunchSpeedScore();
            if (launchSpeedScore >= 0.0f) {
                jSONObject.put("launchScore", launchSpeedScore);
            }
            float staticDeviceScore = bDVideoPlayerUbcContent.getPlayerFetcher().getStaticDeviceScore();
            if (staticDeviceScore >= 0.0f) {
                jSONObject.put("staticScore", staticDeviceScore);
            }
            jSONObject2.put("ext", jSONObject.toString());
            return jSONObject2.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
