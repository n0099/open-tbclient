package com.baidu.searchbox.live.model.repository;

import com.baidu.searchbox.live.data.constant.MixUrlConfigKt;
import com.baidu.searchbox.live.data.pojo.LiveTypeData;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.requester.MixRequesterKt;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "", "roomId", "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", WebChromeClient.KEY_ARG_CALLBACK, "", "fetchLiveType", "(Ljava/lang/String;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "responseString", "parseLiveTypeResult", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "", "isRequestIng", "Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MixTypeRepository {
    public boolean isRequestIng;

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveTypeData parseLiveTypeResult(String str) {
        LiveTypeData liveTypeData = new LiveTypeData();
        liveTypeData.loadFromJson(str);
        return liveTypeData;
    }

    public final void fetchLiveType(String str, final OnMixDataLoaded<MixResult<LiveTypeData>> onMixDataLoaded) {
        if (this.isRequestIng) {
            return;
        }
        this.isRequestIng = true;
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("room_id", str));
        MediaLivePluginLogger.Companion.getInstance().logListGetLiveTypeStartToSendReqNet();
        MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartGetLiveTypeTime();
        MixRequesterKt.fetchData$default(MixUrlConfigKt.getLiveTypeUrl(), mapOf, new MixNetCallback<LiveTypeData>() { // from class: com.baidu.searchbox.live.model.repository.MixTypeRepository$fetchLiveType$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public void onNetResponse(NetResponse netResponse, LiveTypeData liveTypeData) {
                Integer num;
                Integer num2;
                long j;
                MixTypeRepository.this.isRequestIng = false;
                MediaLivePluginLogger.Companion.getInstance().logGetLiveTypeNetEndAndStartParse();
                if (netResponse != null && netResponse.isSuccessful() && liveTypeData != null) {
                    if (liveTypeData.getErrno() == 0) {
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
                        onMixDataLoaded.onMixDataLoaded(new MixResult.MixSuccess(liveTypeData, mixResultStatData));
                        return;
                    }
                    onMixDataLoaded.onMixDataLoaded(new MixResult.MixError(new Exception("fetchRoomTypeInfo Invalid, code = " + netResponse.responseCode + ", logid: " + liveTypeData.getLogId()), Integer.valueOf(liveTypeData.getErrno()), null, 4, null));
                    return;
                }
                OnMixDataLoaded onMixDataLoaded2 = onMixDataLoaded;
                StringBuilder sb = new StringBuilder();
                sb.append("fetchRoomTypeInfo Invalid, code = ");
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
            public LiveTypeData onParseResponseInBackground(NetResponse netResponse) {
                LiveTypeData parseLiveTypeResult;
                MixTypeRepository.this.isRequestIng = false;
                if (netResponse != null && netResponse.isSuccessful()) {
                    MixTypeRepository mixTypeRepository = MixTypeRepository.this;
                    String str2 = netResponse.decodedResponseStr;
                    if (str2 == null) {
                        str2 = "";
                    }
                    parseLiveTypeResult = mixTypeRepository.parseLiveTypeResult(str2);
                    return parseLiveTypeResult;
                }
                return null;
            }
        }, 17, 141, true, null, false, 192, null);
    }
}
