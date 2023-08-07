package com.baidu.live.mix.interfaces.service;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u0007J\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/live/mix/interfaces/service/LiveBridgeService;", "Lkotlin/Any;", "", "getAudioLive", "()Ljava/lang/Boolean;", "", "getCreateAudioRoomScheme", "()Ljava/lang/String;", "getRecommendMoreChosenTabChannelId", "getRecommendMoreChosenTabType", "getRoomId", "", "getRoomStatus", "()Ljava/lang/Integer;", "needShowCreateAudioRoom", "()Z", "needShowRecommend", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface LiveBridgeService {
    Boolean getAudioLive();

    String getCreateAudioRoomScheme();

    String getRecommendMoreChosenTabChannelId();

    String getRecommendMoreChosenTabType();

    String getRoomId();

    Integer getRoomStatus();

    boolean needShowCreateAudioRoom();

    boolean needShowRecommend();
}
