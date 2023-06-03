package com.baidu.searchbox.player.ubc;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/ubc/ErrorBusinessStatPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "ubcContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "kotlin.jvm.PlatformType", "ubcService", "Lcom/baidu/ubc/UBCManager;", "getSubscribeEvent", "", "onPlayerEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onVideoEventNotify", "uploadBusinessError", "errorCode", "", "bdvideoplayer-stat-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorBusinessStatPlugin extends AbsPlugin {
    public final UBCManager ubcService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent ubcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{6, 4};
    }

    private final void uploadBusinessError(int i) {
        JSONObject extStatisticsLogClone = this.ubcContent.getExtStatisticsLogClone();
        Intrinsics.checkNotNullExpressionValue(extStatisticsLogClone, "ubcContent.extStatisticsLogClone");
        extStatisticsLogClone.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, i);
        extStatisticsLogClone.put("sub_errorNo", i);
        String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.ubcContent, (JSONObject) null);
        Intrinsics.checkNotNullExpressionValue(ubcContent, "getUbcContent(extLog, ubcContent, null)");
        this.ubcService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_BUSINESS_ERROR, ubcContent);
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onPlayerEventNotify(event);
        String action = event.getAction();
        if (action.hashCode() == -882902390 && action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
            Object extra = event.getExtra(3);
            if (!(extra instanceof BasicVideoSeries)) {
                extra = null;
            }
            BasicVideoSeries basicVideoSeries = (BasicVideoSeries) extra;
            if (basicVideoSeries != null) {
                if (basicVideoSeries.getPlayUrl().length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    uploadBusinessError(10005);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onVideoEventNotify(event);
        String action = event.getAction();
        if (action.hashCode() == -2127352417 && action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
            Object extra = event.getExtra(13);
            if (extra != null) {
                this.ubcContent = (BDVideoPlayerUbcContent) extra;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent");
        }
    }
}
