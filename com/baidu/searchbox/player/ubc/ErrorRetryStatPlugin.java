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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/player/ubc/ErrorRetryStatPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "", "checkData", "()Z", "", "getSubscribeEvent", "()[I", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "", "onVideoEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "uploadRetryError", "()V", "", "errorCode", "I", "isErrorRetry", "Z", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "kotlin.jvm.PlatformType", "ubcContent", "Lcom/baidu/searchbox/player/ubc/BDVideoPlayerUbcContent;", "Lcom/baidu/ubc/UBCManager;", "ubcService", "Lcom/baidu/ubc/UBCManager;", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
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
            BDVideoPlayerUbcContent ubcContent = this.ubcContent;
            Intrinsics.checkNotNullExpressionValue(ubcContent, "ubcContent");
            JSONObject extStatisticsLogClone = ubcContent.getExtStatisticsLogClone();
            Intrinsics.checkNotNullExpressionValue(extStatisticsLogClone, "ubcContent.extStatisticsLogClone");
            extStatisticsLogClone.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, this.errorCode);
            extStatisticsLogClone.put("sub_errorNo", this.errorCode);
            extStatisticsLogClone.put("isRetryError", 1);
            String ubcContent2 = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.ubcContent, (JSONObject) null);
            Intrinsics.checkNotNullExpressionValue(ubcContent2, "BDVideoPlayerUbcHelper.g…extLog, ubcContent, null)");
            this.ubcService.onEvent("36", ubcContent2);
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
