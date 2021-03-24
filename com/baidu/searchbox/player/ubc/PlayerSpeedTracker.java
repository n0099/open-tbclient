package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PlayerSpeedTracker {
    public static void beginCallPlayerStart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
    }

    public static void beginInitPlayer(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAYER);
    }

    public static void beginTrack(@NonNull String str) {
        FlowInstanceManager.createFlow(str);
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_CALL_PLAYER);
    }

    public static void cancelTrack(@NonNull String str) {
        FlowInstanceManager.endFlow(str);
    }

    public static void endActivityCreatePart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
    }

    public static void endAfterInitToPlayPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
    }

    public static void endInitLayerPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
    }

    public static void endInitPlayerEnvPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
    }

    public static void endInitPluginPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
    }

    public static void endPlayCore(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_START_PLAY_TO_FIRST_FRAME_DISPLAY);
    }

    public static void endSchemeDispatchPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
    }

    public static void endTrack(@NonNull String str, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj) {
        FlowInstanceManager.setValueAndEndFlow(str, getPerformanceString(bDVideoPlayerUbcContent, obj));
    }

    @NonNull
    public static String getPerformanceString(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj) {
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

    public static boolean hasCreateFlow(@Nullable String str) {
        return FlowInstanceManager.hasCreateFlow(str);
    }

    public static void startActivityCreatePart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_ACTIVITY_CREATE);
    }

    public static void startAfterInitToPlayPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_AFTER_INIT_PLAYER_TO_START);
    }

    public static void startInitLayerPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
    }

    public static void startInitPlayerEnvPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
    }

    public static void startInitPluginPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
    }

    public static void startSchemeDispatchPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
    }
}
