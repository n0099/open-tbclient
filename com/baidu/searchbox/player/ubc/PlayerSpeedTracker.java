package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        VideoSessionManager.getInstance().getSessionId(str);
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

    public static void endInitItemPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_ITEM);
    }

    public static void endInitLayerPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
    }

    public static void endInitListPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LIST);
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

    public static void endPrepareResourcePart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_PREPARE_RESOURCE);
    }

    public static void endSchemeDispatchPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_VIDEO_SCHEME_DISPATCH);
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
    }

    public static void endUnitedSchemeDispatchPart(@NonNull String str) {
        FlowInstanceManager.endFlowPart(str, PlayerSpeedMonitorConstants.PART_UNITED_SCHEME_DISPATCH);
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_VIDEO_SCHEME_DISPATCH);
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

    public static void startInitItemPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_ITEM);
    }

    public static void startInitLayerPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LAYER);
    }

    public static void startInitListPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_LIST);
    }

    public static void startInitPlayerEnvPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLAYER_ENV);
    }

    public static void startInitPluginPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_INIT_PLUGIN);
    }

    public static void startPrepareResourcePart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_PREPARE_RESOURCE);
    }

    public static void startSchemeDispatchPart(@NonNull String str) {
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_SCHEME_DISPATCH);
        FlowInstanceManager.startFlowPart(str, PlayerSpeedMonitorConstants.PART_UNITED_SCHEME_DISPATCH);
    }

    public static void endCustomPart(@NonNull String str, @NonNull String str2) {
        FlowInstanceManager.endFlowPart(str, str2);
    }

    public static void startCustomPart(@NonNull String str, @NonNull String str2) {
        FlowInstanceManager.startFlowPart(str, str2);
    }

    public static void endTrack(@NonNull String str, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj, long j) {
        FlowInstanceManager.setValueAndEndFlow(str, getPerformanceString(bDVideoPlayerUbcContent, obj, j));
    }

    @NonNull
    public static String getPerformanceString(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable Object obj, long j) {
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
        jSONObject.put("value", extStatisticsLogClone.optString(BasicVideoParserKt.PD_REC));
        return BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject);
    }
}
