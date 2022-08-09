package com.baidu.searchbox.live.list.controller;

import android.os.Handler;
import com.baidu.searchbox.live.data.req.RoomEnterParams;
import com.baidu.searchbox.live.data.resp.LiveRoomEnterRespData;
import com.baidu.searchbox.live.model.MixModel;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.service.MixRequestService;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/baidu/searchbox/live/list/controller/ListController$registerMixRequestService$1", "Lcom/baidu/searchbox/live/service/MixRequestService;", "Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "params", "", "useCache", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/resp/LiveRoomEnterRespData;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestRoomEnter", "(Lcom/baidu/searchbox/live/data/req/RoomEnterParams;ZLcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListController$registerMixRequestService$1 implements MixRequestService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ListController this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public ListController$registerMixRequestService$1(ListController listController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = listController;
    }

    @Override // com.baidu.searchbox.live.service.MixRequestService
    public void requestRoomEnter(final RoomEnterParams roomEnterParams, boolean z, final OnMixDataLoaded<MixResult<LiveRoomEnterRespData>> onMixDataLoaded) {
        MixModel mixModel;
        final LiveRoomEnterRespData preReqRoomEnterData;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{roomEnterParams, Boolean.valueOf(z), onMixDataLoaded}) == null) {
            if (z && (preReqRoomEnterData = this.this$0.getPreReqRoomEnterData()) != null) {
                JSONObject respJsonObj = preReqRoomEnterData.getRespJsonObj();
                String str = null;
                JSONObject optJSONObject3 = respJsonObj != null ? respJsonObj.optJSONObject("data") : null;
                if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("room")) != null) {
                    str = optJSONObject2.optString("room_id");
                }
                if (Intrinsics.areEqual(str, roomEnterParams.getId())) {
                    long currentTimeMillis = System.currentTimeMillis() - preReqRoomEnterData.getConstructTimeMills();
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(SetImageWatermarkTypeReqMsg.SWITCH);
                    if (currentTimeMillis <= ((optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("sdk_loading")) == null) ? 5000L : optJSONObject.optLong("enter_expire"))) {
                        if (this.this$0.getHandler() == null) {
                            this.this$0.setHandler(new Handler());
                        }
                        Handler handler = this.this$0.getHandler();
                        if (handler != null) {
                            handler.post(new Runnable(preReqRoomEnterData, this, roomEnterParams, onMixDataLoaded) { // from class: com.baidu.searchbox.live.list.controller.ListController$registerMixRequestService$1$requestRoomEnter$$inlined$let$lambda$1
                                public static /* synthetic */ Interceptable $ic;
                                public final /* synthetic */ OnMixDataLoaded $callback$inlined;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ LiveRoomEnterRespData $it;
                                public final /* synthetic */ RoomEnterParams $params$inlined;
                                public final /* synthetic */ ListController$registerMixRequestService$1 this$0;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {preReqRoomEnterData, this, roomEnterParams, onMixDataLoaded};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.$it = preReqRoomEnterData;
                                    this.this$0 = this;
                                    this.$params$inlined = roomEnterParams;
                                    this.$callback$inlined = onMixDataLoaded;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        LiveRoomEnterRespData liveRoomEnterRespData = new LiveRoomEnterRespData(this.$it.getRespJsonObj());
                                        liveRoomEnterRespData.setHitCache(true);
                                        liveRoomEnterRespData.setConstructTimeMills(this.$it.getConstructTimeMills());
                                        OnMixDataLoaded onMixDataLoaded2 = this.$callback$inlined;
                                        if (onMixDataLoaded2 != null) {
                                            onMixDataLoaded2.onMixDataLoaded(new MixResult.MixSuccess(liveRoomEnterRespData, this.this$0.this$0.getPreReqStatData()));
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
            }
            mixModel = this.this$0.mNetModel;
            if (mixModel != null) {
                mixModel.reqRoomEnter(roomEnterParams, onMixDataLoaded);
            }
        }
    }
}
