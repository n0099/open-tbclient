package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PlayerSpeedTracker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlayerSpeedTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void beginCallPlayerStart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
        }
    }

    public static void beginInitPlayer(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
        }
    }

    public static void beginTrack(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            FlowInstanceManager.createFlow(str);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
        }
    }

    public static void cancelTrack(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            FlowInstanceManager.endFlow(str);
        }
    }

    public static void endActivityCreatePart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
        }
    }

    public static void endAfterInitToPlayPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
        }
    }

    public static void endInitLayerPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
        }
    }

    public static void endInitPlayerEnvPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
        }
    }

    public static void endInitPluginPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
        }
    }

    public static void endPlayCore(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
        }
    }

    public static void endSchemeDispatchPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
        }
    }

    public static void endTrack(@NonNull String str, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, bDVideoPlayerUbcContent, obj) == null) {
            FlowInstanceManager.setValueAndEndFlow(str, getPerformanceString(bDVideoPlayerUbcContent, obj));
        }
    }

    @NonNull
    public static String getPerformanceString(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, bDVideoPlayerUbcContent, obj)) == null) {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                try {
                    extStatisticsLogClone.put("statistic", obj.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (bDVideoPlayerUbcContent.getPlayerPrepareTime() > 0) {
                extStatisticsLogClone.put("prepareTime", bDVideoPlayerUbcContent.getPlayerPrepareTime());
            }
            jSONObject.put("source", extStatisticsLogClone.optString("mtNew"));
            jSONObject.put("value", extStatisticsLogClone.optString("pdRec"));
            return BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean hasCreateFlow(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? FlowInstanceManager.hasCreateFlow(str) : invokeL.booleanValue;
    }

    public static void startActivityCreatePart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
        }
    }

    public static void startAfterInitToPlayPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
        }
    }

    public static void startInitLayerPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
        }
    }

    public static void startInitPlayerEnvPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
        }
    }

    public static void startInitPluginPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
        }
    }

    public static void startSchemeDispatchPart(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
        }
    }
}
