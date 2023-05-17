package com.baidu.searchbox.live.model.repository;

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
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.json.JSONArray;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/model/repository/MixListRepository;", "Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;", "listParams", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/domain/SlideListInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "fetchLiveSlideList", "(Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "", "responseString", "parseSlideListData", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/domain/SlideListInfo;", "", "isRequestIng", "Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MixListRepository {
    public boolean isRequestIng;

    /* JADX INFO: Access modifiers changed from: private */
    public final SlideListInfo parseSlideListData(String str) {
        SlideListInfo slideListInfo = new SlideListInfo();
        slideListInfo.loadFromJson(str);
        return slideListInfo;
    }

    public final void fetchLiveSlideList(LiveListParamsMix liveListParamsMix, final OnMixDataLoaded<MixResult<SlideListInfo>> onMixDataLoaded) {
        JSONArray jSONArray;
        if (this.isRequestIng) {
            return;
        }
        this.isRequestIng = true;
        LiveRoomInfoStatPlugin.StatService statService = (LiveRoomInfoStatPlugin.StatService) ServiceLocator.Companion.getGlobalService(LiveRoomInfoStatPlugin.StatService.class);
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("room_id", liveListParamsMix.getRoomId());
        pairArr[1] = TuplesKt.to("page_session", liveListParamsMix.getPageSession());
        pairArr[2] = TuplesKt.to("ext", liveListParamsMix.getExt());
        pairArr[3] = TuplesKt.to("source", liveListParamsMix.getSource());
        if (statService != null) {
            jSONArray = statService.getUploadIds();
        } else {
            jSONArray = null;
        }
        pairArr[4] = TuplesKt.to("upload_ids", String.valueOf(jSONArray));
        pairArr[5] = TuplesKt.to("device_static_score", String.valueOf(ListExtKt.getStaticDeviceScore(MiniShellRuntime.INSTANCE.getAppContext())));
        pairArr[6] = TuplesKt.to("video_play_score", String.valueOf(ListExtKt.getPlayQualityScore()));
        pairArr[7] = TuplesKt.to(MiniPluginUtils.INSTANCE.getPluginVerPostParamKey(), MiniPluginUtils.INSTANCE.getPluginVerPostParamValue());
        Map mapOf = MapsKt__MapsKt.mapOf(pairArr);
        MediaLivePluginLogger.Companion.getInstance().logListSlideStartToSendReqNet();
        MixRequesterKt.fetchData$default(MixUrlConfigKt.getSlideListUrl(), mapOf, new MixNetCallback<SlideListInfo>() { // from class: com.baidu.searchbox.live.model.repository.MixListRepository$fetchLiveSlideList$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public void onNetResponse(NetResponse netResponse, SlideListInfo slideListInfo) {
                Integer num;
                Integer num2;
                long j;
                MediaLivePluginLogger.Companion.getInstance().logListSlideReqNetEndAndStartParse();
                MixListRepository.this.isRequestIng = false;
                if (netResponse != null && netResponse.isSuccessful() && slideListInfo != null) {
                    if (slideListInfo.errno == 0) {
                        MixResultStatData mixResultStatData = new MixResultStatData();
                        NetStatData netStatData = netResponse.statData;
                        long j2 = 0;
                        if (netStatData != null) {
                            j = netStatData.requestTimestamp;
                        } else {
                            j = 0;
                        }
                        mixResultStatData.requestTime = j;
                        NetStatData netStatData2 = netResponse.statData;
                        if (netStatData2 != null) {
                            j2 = netStatData2.responseTimestamp;
                        }
                        mixResultStatData.responseTime = j2;
                        onMixDataLoaded.onMixDataLoaded(new MixResult.MixSuccess(slideListInfo, mixResultStatData));
                        return;
                    }
                    onMixDataLoaded.onMixDataLoaded(new MixResult.MixError(new Exception("fetchGoodsListInfo Invalid, code = " + netResponse.responseCode + " logid: " + slideListInfo.logId), Integer.valueOf(slideListInfo.errno), null, 4, null));
                    return;
                }
                OnMixDataLoaded onMixDataLoaded2 = onMixDataLoaded;
                StringBuilder sb = new StringBuilder();
                sb.append("fetchGoodsListInfo Invalid, ");
                sb.append("code = ");
                if (netResponse != null) {
                    num = Integer.valueOf(netResponse.responseCode);
                } else {
                    num = null;
                }
                sb.append(num);
                Exception exc = new Exception(sb.toString());
                if (netResponse != null) {
                    num2 = Integer.valueOf(netResponse.netErrorCode);
                } else {
                    num2 = null;
                }
                onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(exc, num2, null, 4, null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public SlideListInfo onParseResponseInBackground(NetResponse netResponse) {
                SlideListInfo parseSlideListData;
                MixListRepository.this.isRequestIng = false;
                if (netResponse != null && netResponse.isSuccessful()) {
                    MixListRepository mixListRepository = MixListRepository.this;
                    String str = netResponse.decodedResponseStr;
                    if (str == null) {
                        str = "";
                    }
                    parseSlideListData = mixListRepository.parseSlideListData(str);
                    return parseSlideListData;
                }
                return null;
            }
        }, 17, 111, true, null, false, 192, null);
    }
}
