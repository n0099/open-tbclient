package com.baidu.searchbox.player.ubc;

import com.baidu.ubc.Flow;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IUbcFlow {
    public static final String TYPE_EMPTY_FLOW = "PlayerEmptyFlow";
    public static final String TYPE_LOADING_FLOW = "PlayerLoadingFlow";
    public static final String TYPE_PERFORMANCE_FLOW = "PlayerPerformanceFlow";
    public static final String TYPE_SPEED_DURATION_FLOW = "PlayerSpeedDurationFlow";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FlowType {
    }

    void cancelFlow();

    void createFlow();

    void endSlot(String str);

    Flow getFlow();

    String getFlowType();

    void resetFlow();

    void startSlot(String str, JSONObject jSONObject);

    void uploadFlow(BDVideoPlayerUbcContent bDVideoPlayerUbcContent, JSONObject jSONObject, JSONObject jSONObject2);
}
