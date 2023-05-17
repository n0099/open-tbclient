package com.baidu.live.mix.interfaces;

import com.baidu.live.mix.interfaces.service.LeftSlidOutService;
import com.baidu.live.mix.interfaces.service.LiveBridgeService;
import com.baidu.live.mix.interfaces.service.LiveRoomMotionService;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixLiveOtherInterface;", "Lkotlin/Any;", "", "key", "Lorg/json/JSONObject;", "data", "", "dispatchListActionToRoom", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Lcom/baidu/live/mix/interfaces/service/LeftSlidOutService;", "getLeftSlideOutService", "()Lcom/baidu/live/mix/interfaces/service/LeftSlidOutService;", "Lcom/baidu/live/mix/interfaces/service/LiveBridgeService;", "getLiveBridgeService", "()Lcom/baidu/live/mix/interfaces/service/LiveBridgeService;", "Lcom/baidu/live/mix/interfaces/service/LiveRoomMotionService;", "getLiveRoomMotionService", "()Lcom/baidu/live/mix/interfaces/service/LiveRoomMotionService;", "Lcom/baidu/live/mix/interfaces/InvokeAbility;", "ability", "setInvokeListener", "(Lcom/baidu/live/mix/interfaces/InvokeAbility;)V", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface MixLiveOtherInterface {
    void dispatchListActionToRoom(String str, JSONObject jSONObject);

    LeftSlidOutService getLeftSlideOutService();

    LiveBridgeService getLiveBridgeService();

    LiveRoomMotionService getLiveRoomMotionService();

    void setInvokeListener(InvokeAbility invokeAbility);
}
