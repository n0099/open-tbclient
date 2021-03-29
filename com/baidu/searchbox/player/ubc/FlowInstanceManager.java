package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FlowInstanceManager {
    public static final ConcurrentHashMap<String, Flow> FLOW_FETCHERS = new ConcurrentHashMap<>();
    public static UBCManager sUBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    public static void cancelFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            sUBCManager.flowCancel(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void clear() {
        FLOW_FETCHERS.clear();
    }

    public static void createFlow(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hasCreateFlow(str)) {
            endFlow(str);
        }
        UBCManager uBCManager = sUBCManager;
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
            sUBCManager.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void endFlowPart(@Nullable String str, @NonNull String str2) {
        Flow flow;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (flow = FLOW_FETCHERS.get(str)) == null) {
            return;
        }
        sUBCManager.flowEndSlot(flow, str2);
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

    public static void setValueAndEndFlow(@Nullable String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Flow flow = FLOW_FETCHERS.get(str);
        if (flow != null) {
            sUBCManager.flowSetValueWithDuration(flow, str2);
            sUBCManager.flowEnd(flow);
        }
        FLOW_FETCHERS.remove(str);
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2) {
        startFlowPart(str, str2, null);
    }

    public static void startFlowPart(@Nullable String str, @NonNull String str2, JSONObject jSONObject) {
        Flow flow;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (flow = FLOW_FETCHERS.get(str)) == null) {
            return;
        }
        sUBCManager.flowStartSlot(flow, str2, jSONObject);
    }
}
