package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.mix.MixRoomInfo;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/service/LiveMixRoomInfoService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "getRoomInfo", "()Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "info", "", "updateRoomInfo", "(Lcom/baidu/searchbox/live/mix/MixRoomInfo;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface LiveMixRoomInfoService extends IService {
    MixRoomInfo getRoomInfo();

    void updateRoomInfo(MixRoomInfo mixRoomInfo);
}
