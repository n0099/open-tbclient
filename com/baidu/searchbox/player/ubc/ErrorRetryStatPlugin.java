package com.baidu.searchbox.player.ubc;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/ubc/ErrorRetryStatPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "errorCode", "", "isErrorRetry", "", "ubcContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "kotlin.jvm.PlatformType", "ubcService", "Lcom/baidu/ubc/UBCManager;", "checkData", "getSubscribeEvent", "", "onVideoEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "uploadRetryError", "bdvideoplayer-stat-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorRetryStatPlugin extends AbsPlugin {
    public int errorCode;
    public boolean isErrorRetry;
    public final UBCManager ubcService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent ubcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private final boolean checkData() {
        if (this.isErrorRetry && this.errorCode != 0) {
            return true;
        }
        return false;
    }

    private final void uploadRetryError() {
        if (!checkData()) {
            return;
        }
        try {
            JSONObject extStatisticsLogClone = this.ubcContent.getExtStatisticsLogClone();
            Intrinsics.checkNotNullExpressionValue(extStatisticsLogClone, "ubcContent.extStatisticsLogClone");
            extStatisticsLogClone.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, this.errorCode);
            extStatisticsLogClone.put("sub_errorNo", this.errorCode);
            extStatisticsLogClone.put("isRetryError", 1);
            String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.ubcContent, (JSONObject) null);
            Intrinsics.checkNotNullExpressionValue(ubcContent, "getUbcContent(extLog, ubcContent, null)");
            this.ubcService.onEvent("36", ubcContent);
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onVideoEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case -2127352417:
                if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                    Object extra = event.getExtra(13);
                    if (extra != null) {
                        this.ubcContent = (BDVideoPlayerUbcContent) extra;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent");
                }
                return;
            case -812593525:
                if (!action.equals(StatisticsEvent.ACTION_ERROR_RETRY_END)) {
                    return;
                }
                break;
            case -168110661:
                if (!action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                    return;
                }
                break;
            case 794779154:
                if (action.equals(StatisticsEvent.ACTION_ERROR_RETRY_START)) {
                    this.isErrorRetry = true;
                    this.errorCode = event.getIntExtra(4);
                    return;
                }
                return;
            case 2082163910:
                if (!action.equals(StatisticsEvent.ACTION_PLAYER_ERROR)) {
                    return;
                }
                break;
            case 2095136544:
                if (!action.equals(StatisticsEvent.ACTION_PLAYER_START)) {
                    return;
                }
                break;
            case 2145795460:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    uploadRetryError();
                    return;
                }
                return;
            default:
                return;
        }
        this.isErrorRetry = false;
    }
}
