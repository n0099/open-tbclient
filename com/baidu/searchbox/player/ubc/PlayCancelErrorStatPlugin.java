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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/ubc/PlayCancelErrorStatPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "isHasStart", "", "isShowFirstFrame", "ubcContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "kotlin.jvm.PlatformType", "ubcService", "Lcom/baidu/ubc/UBCManager;", "getSubscribeEvent", "", "onVideoEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "uploadPlayCancelError", "bdvideoplayer-stat-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayCancelErrorStatPlugin extends AbsPlugin {
    public boolean isHasStart;
    public boolean isShowFirstFrame;
    public final UBCManager ubcService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public BDVideoPlayerUbcContent ubcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private final void uploadPlayCancelError() {
        if (!this.isHasStart || this.isShowFirstFrame) {
            return;
        }
        try {
            JSONObject extStatisticsLogClone = this.ubcContent.getExtStatisticsLogClone();
            Intrinsics.checkNotNullExpressionValue(extStatisticsLogClone, "ubcContent.extStatisticsLogClone");
            extStatisticsLogClone.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, ErrorStatConstantKt.ERR0R_CODE_PLAY_CANCEL);
            extStatisticsLogClone.put("sub_errorNo", ErrorStatConstantKt.ERR0R_CODE_PLAY_CANCEL);
            extStatisticsLogClone.put("is_cancel", 1);
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
                    if (!(extra instanceof BDVideoPlayerUbcContent)) {
                        extra = null;
                    }
                    BDVideoPlayerUbcContent bDVideoPlayerUbcContent = (BDVideoPlayerUbcContent) extra;
                    if (bDVideoPlayerUbcContent != null) {
                        this.ubcContent = bDVideoPlayerUbcContent;
                        return;
                    }
                    return;
                }
                return;
            case -1771982113:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY)) {
                    this.isHasStart = true;
                    this.isShowFirstFrame = true;
                    return;
                }
                return;
            case 2082163910:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_ERROR)) {
                    this.isHasStart = false;
                    return;
                }
                return;
            case 2095136544:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_START)) {
                    this.isHasStart = true;
                    this.isShowFirstFrame = false;
                    return;
                }
                return;
            case 2145795460:
                if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    uploadPlayCancelError();
                    this.isHasStart = false;
                    this.isShowFirstFrame = false;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
