package com.baidu.searchbox.live.model.repository;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniPluginUtils;
import com.baidu.searchbox.live.data.constant.MixUrlConfigKt;
import com.baidu.searchbox.live.data.req.LiveListParamsMix;
import com.baidu.searchbox.live.domain.SlideListInfo;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.list.plugin.LiveRoomInfoStatPlugin;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.requester.MixRequesterKt;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;", "listParams", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/domain/SlideListInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "fetchLiveSlideList", "(Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "", "responseString", "parseSlideListData", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/domain/SlideListInfo;", "", "isRequestIng", "Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixListRepository {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRequestIng;

    public MixListRepository() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SlideListInfo parseSlideListData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            SlideListInfo slideListInfo = new SlideListInfo();
            slideListInfo.loadFromJson(str);
            return slideListInfo;
        }
        return (SlideListInfo) invokeL.objValue;
    }

    public final void fetchLiveSlideList(LiveListParamsMix liveListParamsMix, final OnMixDataLoaded<MixResult<SlideListInfo>> onMixDataLoaded) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, liveListParamsMix, onMixDataLoaded) == null) || this.isRequestIng) {
            return;
        }
        this.isRequestIng = true;
        LiveRoomInfoStatPlugin.StatService statService = (LiveRoomInfoStatPlugin.StatService) ServiceLocator.Companion.getGlobalService(LiveRoomInfoStatPlugin.StatService.class);
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("room_id", liveListParamsMix.getRoomId());
        pairArr[1] = TuplesKt.to("page_session", liveListParamsMix.getPageSession());
        pairArr[2] = TuplesKt.to("ext", liveListParamsMix.getExt());
        pairArr[3] = TuplesKt.to("source", liveListParamsMix.getSource());
        pairArr[4] = TuplesKt.to("upload_ids", String.valueOf(statService != null ? statService.getUploadIds() : null));
        pairArr[5] = TuplesKt.to("device_static_score", String.valueOf(ListExtKt.getStaticDeviceScore(MiniShellRuntime.INSTANCE.getAppContext())));
        pairArr[6] = TuplesKt.to("video_play_score", String.valueOf(ListExtKt.getPlayQualityScore()));
        pairArr[7] = TuplesKt.to(MiniPluginUtils.INSTANCE.getPluginVerPostParamKey(), MiniPluginUtils.INSTANCE.getPluginVerPostParamValue());
        Map mapOf = MapsKt__MapsKt.mapOf(pairArr);
        MediaLivePluginLogger.Companion.getInstance().logListSlideStartToSendReqNet();
        MixRequesterKt.fetchData(MixUrlConfigKt.getSlideListUrl(), mapOf, new MixNetCallback<SlideListInfo>(this, onMixDataLoaded) { // from class: com.baidu.searchbox.live.model.repository.MixListRepository$fetchLiveSlideList$1
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ OnMixDataLoaded $callback;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MixListRepository this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, onMixDataLoaded};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.$callback = onMixDataLoaded;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public void onNetResponse(NetResponse netResponse, SlideListInfo slideListInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netResponse, slideListInfo) == null) {
                    MediaLivePluginLogger.Companion.getInstance().logListSlideReqNetEndAndStartParse();
                    this.this$0.isRequestIng = false;
                    if (netResponse != null && netResponse.isSuccessful() && slideListInfo != null) {
                        MixResultStatData mixResultStatData = new MixResultStatData();
                        NetStatData netStatData = netResponse.statData;
                        mixResultStatData.requestTime = netStatData != null ? netStatData.requestTimestamp : 0L;
                        NetStatData netStatData2 = netResponse.statData;
                        mixResultStatData.responseTime = netStatData2 != null ? netStatData2.responseTimestamp : 0L;
                        this.$callback.onMixDataLoaded(new MixResult.MixSuccess(slideListInfo, mixResultStatData));
                        return;
                    }
                    OnMixDataLoaded onMixDataLoaded2 = this.$callback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchGoodsListInfo Invalid, ");
                    sb.append("code = ");
                    sb.append(netResponse != null ? Integer.valueOf(netResponse.responseCode) : null);
                    onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(new Exception(sb.toString()), null, null, 6, null));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public SlideListInfo onParseResponseInBackground(NetResponse netResponse) {
                InterceptResult invokeL;
                SlideListInfo parseSlideListData;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                    this.this$0.isRequestIng = false;
                    if (netResponse == null || !netResponse.isSuccessful()) {
                        return null;
                    }
                    MixListRepository mixListRepository = this.this$0;
                    String str = netResponse.decodedResponseStr;
                    if (str == null) {
                        str = "";
                    }
                    parseSlideListData = mixListRepository.parseSlideListData(str);
                    return parseSlideListData;
                }
                return (SlideListInfo) invokeL.objValue;
            }
        }, (r19 & 8) != 0 ? 0 : 17, (r19 & 16) != 0 ? 0 : 111, (r19 & 32) != 0 ? false : true, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? false : false);
    }
}
