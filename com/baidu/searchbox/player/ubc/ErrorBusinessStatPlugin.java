package com.baidu.searchbox.player.ubc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/ubc/ErrorBusinessStatPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "", "getSubscribeEvent", "()[I", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "", "onPlayerEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "onVideoEventNotify", "", "errorCode", "uploadBusinessError", "(I)V", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "kotlin.jvm.PlatformType", "ubcContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "Lcom/baidu/ubc/UBCManager;", "ubcService", "Lcom/baidu/ubc/UBCManager;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ErrorBusinessStatPlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BDVideoPlayerUbcContent ubcContent;
    public final UBCManager ubcService;

    public ErrorBusinessStatPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ubcService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.ubcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    }

    private final void uploadBusinessError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            BDVideoPlayerUbcContent ubcContent = this.ubcContent;
            Intrinsics.checkNotNullExpressionValue(ubcContent, "ubcContent");
            JSONObject extStatisticsLogClone = ubcContent.getExtStatisticsLogClone();
            Intrinsics.checkNotNullExpressionValue(extStatisticsLogClone, "ubcContent.extStatisticsLogClone");
            extStatisticsLogClone.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, i2);
            extStatisticsLogClone.put("sub_errorNo", i2);
            String ubcContent2 = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.ubcContent, (JSONObject) null);
            Intrinsics.checkNotNullExpressionValue(ubcContent2, "BDVideoPlayerUbcHelper.g…extLog, ubcContent, null)");
            this.ubcService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_BUSINESS_ERROR, ubcContent2);
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{6, 4} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onPlayerEventNotify(event);
            String action = event.getAction();
            if (action.hashCode() == -882902390 && action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                Object extra = event.getExtra(3);
                if (!(extra instanceof VideoUrlModel)) {
                    extra = null;
                }
                VideoUrlModel videoUrlModel = (VideoUrlModel) extra;
                if (videoUrlModel != null) {
                    String str = videoUrlModel.videoUrl;
                    if (str == null || str.length() == 0) {
                        uploadBusinessError(10005);
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onVideoEventNotify(event);
            String action = event.getAction();
            if (action.hashCode() == -2127352417 && action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                Object extra = event.getExtra(13);
                if (extra == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent");
                }
                this.ubcContent = (BDVideoPlayerUbcContent) extra;
            }
        }
    }
}
