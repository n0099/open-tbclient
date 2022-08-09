package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/service/MixRequestService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "params", "", "useCache", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestRoomEnter", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;ZLcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixRequestService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void requestRoomEnter$default(MixRequestService mixRequestService, RoomEnterParams roomEnterParams, boolean z, OnMixDataLoaded onMixDataLoaded, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                mixRequestService.requestRoomEnter(roomEnterParams, z, onMixDataLoaded);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestRoomEnter");
        }
    }

    void requestRoomEnter(RoomEnterParams roomEnterParams, boolean z, OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded);
}
