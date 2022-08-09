package com.baidu.searchbox.live.model.repository;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.data.constant.MixUrlConfigKt;
import com.baidu.searchbox.live.data.pojo.LiveTypeData;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.net.NetStatData;
import com.baidu.searchbox.live.model.net.MixNetCallback;
import com.baidu.searchbox.live.model.requester.MixRequesterKt;
import com.baidu.searchbox.live.model.res.MixResult;
import com.baidu.searchbox.live.model.res.MixResultStatData;
import com.baidu.searchbox.live.model.res.OnMixDataLoaded;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/model/repository/MixTypeRepository;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;", "Lcom/baidu/searchbox/live/model/res/MixResult;", "Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", WebChromeClient.KEY_ARG_CALLBACK, "", "fetchLiveType", "(Ljava/lang/String;Lcom/baidu/searchbox/live/model/res/OnMixDataLoaded;)V", "responseString", "parseLiveTypeResult", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "", "isRequestIng", "Z", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixTypeRepository {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRequestIng;

    public MixTypeRepository() {
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
    public final LiveTypeData parseLiveTypeResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            LiveTypeData liveTypeData = new LiveTypeData();
            liveTypeData.loadFromJson(str);
            return liveTypeData;
        }
        return (LiveTypeData) invokeL.objValue;
    }

    public final void fetchLiveType(String str, final OnMixDataLoaded<MixResult<LiveTypeData>> onMixDataLoaded) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, onMixDataLoaded) == null) || this.isRequestIng) {
            return;
        }
        this.isRequestIng = true;
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("room_id", str));
        MediaLivePluginLogger.Companion.getInstance().logListGetLiveTypeStartToSendReqNet();
        MediaLivePlayLogger.Companion.getInstance().logLiveRoomStartGetLiveTypeTime();
        MixRequesterKt.fetchData(MixUrlConfigKt.getLiveTypeUrl(), mapOf, new MixNetCallback<LiveTypeData>(this, onMixDataLoaded) { // from class: com.baidu.searchbox.live.model.repository.MixTypeRepository$fetchLiveType$1
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ OnMixDataLoaded $callback;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MixTypeRepository this$0;

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
            public void onNetResponse(NetResponse netResponse, LiveTypeData liveTypeData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netResponse, liveTypeData) == null) {
                    this.this$0.isRequestIng = false;
                    MediaLivePluginLogger.Companion.getInstance().logGetLiveTypeNetEndAndStartParse();
                    if (netResponse != null && netResponse.isSuccessful() && liveTypeData != null) {
                        MixResultStatData mixResultStatData = new MixResultStatData();
                        NetStatData netStatData = netResponse.statData;
                        mixResultStatData.requestTime = netStatData != null ? netStatData.requestTimestamp : 0L;
                        NetStatData netStatData2 = netResponse.statData;
                        mixResultStatData.responseTime = netStatData2 != null ? netStatData2.responseTimestamp : 0L;
                        this.$callback.onMixDataLoaded(new MixResult.MixSuccess(liveTypeData, mixResultStatData));
                        return;
                    }
                    OnMixDataLoaded onMixDataLoaded2 = this.$callback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchGoodsListInfo Invalid, code = ");
                    sb.append(netResponse != null ? Integer.valueOf(netResponse.responseCode) : null);
                    onMixDataLoaded2.onMixDataLoaded(new MixResult.MixError(new Exception(sb.toString()), null, null, 6, null));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.live.model.net.MixNetCallback
            public LiveTypeData onParseResponseInBackground(NetResponse netResponse) {
                InterceptResult invokeL;
                LiveTypeData parseLiveTypeResult;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                    this.this$0.isRequestIng = false;
                    if (netResponse == null || !netResponse.isSuccessful()) {
                        return null;
                    }
                    MixTypeRepository mixTypeRepository = this.this$0;
                    String str2 = netResponse.decodedResponseStr;
                    if (str2 == null) {
                        str2 = "";
                    }
                    parseLiveTypeResult = mixTypeRepository.parseLiveTypeResult(str2);
                    return parseLiveTypeResult;
                }
                return (LiveTypeData) invokeL.objValue;
            }
        }, (r16 & 8) != 0 ? 0 : 17, (r16 & 16) != 0 ? 0 : 141, (r16 & 32) != 0 ? false : true, (r16 & 64) != 0 ? null : null);
    }
}
