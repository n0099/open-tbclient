package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDVideoPlayerUbcHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BDVideoPlayerUbcHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String networkClass = NetUtils.getNetworkClass();
            if (networkClass.equals("no") || networkClass.equals("unknown")) {
                return ImageViewerConfig.FROM_OTHER;
            }
            return networkClass;
        }
        return (String) invokeV.objValue;
    }

    public static void appendSessionContent(@NonNull JSONObject jSONObject, @NonNull IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, iUbcPlayerStatusFetcher) == null) {
            String sessionId = iUbcPlayerStatusFetcher.getSessionId();
            String kernelLogId = iUbcPlayerStatusFetcher.getKernelLogId();
            String traceId = iUbcPlayerStatusFetcher.getTraceId();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("plogid", sessionId);
                jSONObject2.put("klogid", kernelLogId);
                jSONObject2.put("traceid", traceId);
                jSONObject.put("player_log", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void appendUrlContent(@NonNull JSONObject jSONObject, @NonNull IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, jSONObject, iUbcPlayerStatusFetcher) != null) || !TextUtils.isEmpty(jSONObject.optString("url"))) {
            return;
        }
        try {
            jSONObject.put("url", iUbcPlayerStatusFetcher.getPlayUrl());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bDVideoPlayerUbcContent, jSONObject)) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
            jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
            if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
                jSONObject.put("type", bDVideoPlayerUbcContent.getType());
            }
            jSONObject.put("network", getNetType());
            JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
            extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
            extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
            appendSessionContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
            appendUrlContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
            jSONObject.put("ext", extStatisticsLog.toString());
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, bDVideoPlayerUbcContent, jSONObject, str)) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
            } else {
                jSONObject.put("page", str);
            }
            if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
                jSONObject.put("type", bDVideoPlayerUbcContent.getType());
            }
            jSONObject.put("network", getNetType());
            JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
            extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
            extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
            appendSessionContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
            appendUrlContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
            jSONObject.put("ext", extStatisticsLog.toString());
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @NonNull
    public static String getUbcContent(@NonNull JSONObject jSONObject, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, jSONObject, bDVideoPlayerUbcContent, jSONObject2)) == null) {
            if (jSONObject2 == null) {
                try {
                    jSONObject2 = new JSONObject();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject2.put("from", bDVideoPlayerUbcContent.getFrom());
            jSONObject2.put("page", bDVideoPlayerUbcContent.getPage());
            jSONObject2.put("network", getNetType());
            if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
                jSONObject2.put("type", bDVideoPlayerUbcContent.getType());
            }
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
            appendSessionContent(jSONObject, bDVideoPlayerUbcContent.getPlayerFetcher());
            appendUrlContent(jSONObject, bDVideoPlayerUbcContent.getPlayerFetcher());
            jSONObject2.put("ext", jSONObject.toString());
            return jSONObject2.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static int positive(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return Math.max(i, 0);
        }
        return invokeI.intValue;
    }
}
