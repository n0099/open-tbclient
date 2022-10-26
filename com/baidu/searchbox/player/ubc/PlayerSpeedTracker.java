package com.baidu.searchbox.player.ubc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.session.VideoSessionManager;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void beginCallPlayerStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
        }
    }

    public static void beginInitPlayer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
        }
    }

    public static void beginTrack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            FlowInstanceManager.createFlow(str);
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
            VideoSessionManager.getInstance().getSessionId(str);
        }
    }

    public static void cancelTrack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            FlowInstanceManager.endFlow(str);
        }
    }

    public static void endActivityCreatePart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
        }
    }

    public static void endAfterInitToPlayPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
        }
    }

    public static void endInitLayerPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
        }
    }

    public static void endInitPlayerEnvPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
        }
    }

    public static void endInitPluginPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
        }
    }

    public static void endPlayCore(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
        }
    }

    public static void endPrepareResourcePart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_PREPARE_RESOURCE);
        }
    }

    public static void endSchemeDispatchPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
        }
    }

    public static boolean hasCreateFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            return FlowInstanceManager.hasCreateFlow(str);
        }
        return invokeL.booleanValue;
    }

    public static void startActivityCreatePart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
        }
    }

    public static void startAfterInitToPlayPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
        }
    }

    public static void startInitLayerPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
        }
    }

    public static void startInitPlayerEnvPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
        }
    }

    public static void startInitPluginPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
        }
    }

    public static void startPrepareResourcePart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_PREPARE_RESOURCE);
        }
    }

    public static void startSchemeDispatchPart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
        }
    }

    public static void endCustomPart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            FlowInstanceManager.endFlowPart(str, str2);
        }
    }

    public static void startCustomPart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) {
            FlowInstanceManager.startFlowPart(str, str2);
        }
    }

    public static void endTrack(String str, BDVideoPlayerUbcContent bDVideoPlayerUbcContent, Object obj, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{str, bDVideoPlayerUbcContent, obj, Long.valueOf(j)}) == null) {
            FlowInstanceManager.setValueAndEndFlow(str, getPerformanceString(bDVideoPlayerUbcContent, obj, j));
        }
    }

    public static String getPerformanceString(BDVideoPlayerUbcContent bDVideoPlayerUbcContent, Object obj, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{bDVideoPlayerUbcContent, obj, Long.valueOf(j)})) == null) {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                try {
                    extStatisticsLogClone.put("statistic", obj.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (j > 0) {
                extStatisticsLogClone.put("msgChannelCost", j);
            }
            if (bDVideoPlayerUbcContent.getPlayerPrepareTime() > 0) {
                extStatisticsLogClone.put("prepareTime", bDVideoPlayerUbcContent.getPlayerPrepareTime());
            }
            jSONObject.put("source", extStatisticsLogClone.optString("mtNew"));
            jSONObject.put("value", extStatisticsLogClone.optString("pdRec"));
            return BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject);
        }
        return (String) invokeCommon.objValue;
    }
}
