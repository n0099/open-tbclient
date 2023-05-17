package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FlowInstanceManager {
    public static final ConcurrentHashMap<String, Flow> FLOW_FETCHERS = new ConcurrentHashMap<>();
    public static final UBCManager UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    public static void clear() {
        FLOW_FETCHERS.clear();
    }

    public static void cancelFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            UBC_MANAGER.flowCancel(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void createFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hasCreateFlow(str)) {
            endFlow(str);
        }
        UBCManager uBCManager = UBC_MANAGER;
        if (uBCManager != null) {
            FLOW_FETCHERS.put(str, uBCManager.beginFlow(VideoPlayerUbcConstants.UBC_PLAY_PERFORMANCE_ID));
        }
    }

    public static void endFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            UBC_MANAGER.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    @Nullable
    public static Flow getFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return FLOW_FETCHERS.get(str);
    }

    public static boolean hasCreateFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return FLOW_FETCHERS.containsKey(str);
    }

    public static void endFlowPart(@Nullable String str, @NonNull String str2) {
        Flow flow;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (flow = FLOW_FETCHERS.get(str)) != null) {
            UBC_MANAGER.flowEndSlot(flow, str2);
        }
    }

    public static void setValueAndEndFlow(@Nullable String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            UBC_MANAGER.flowSetValueWithDuration(flow, str2);
            UBC_MANAGER.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2) {
        startFlowPart(str, str2, null);
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2, JSONObject jSONObject) {
        Flow flow;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (flow = FLOW_FETCHERS.get(str)) != null) {
            UBC_MANAGER.flowStartSlot(flow, str2, jSONObject);
        }
    }
}
