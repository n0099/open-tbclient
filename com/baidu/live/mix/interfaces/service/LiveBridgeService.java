package com.baidu.live.mix.interfaces.service;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/baidu/live/mix/interfaces/service/LiveBridgeService;", "Lkotlin/Any;", "", "getAudioLive", "()Ljava/lang/Boolean;", "", "getCreateAudioRoomScheme", "()Ljava/lang/String;", "getRecommendMoreChosenTabChannelId", "getRecommendMoreChosenTabType", "getRoomId", "needShowCreateAudioRoom", "()Z", "needShowRecommend", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveBridgeService {
    Boolean getAudioLive();

    String getCreateAudioRoomScheme();

    String getRecommendMoreChosenTabChannelId();

    String getRecommendMoreChosenTabType();

    String getRoomId();

    boolean needShowCreateAudioRoom();

    boolean needShowRecommend();
}
