package com.baidu.searchbox.player.ubc;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0013J/\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/ubc/DumediaStatExtPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createPageInfoMap", "()Ljava/util/HashMap;", "", "getExpectOrder", "()I", "", "getSubscribeEvent", "()[I", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "", "onPlayerEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "setPageInfo", "()V", "setTraceInfo", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class DumediaStatExtPlugin extends AbsPlugin {
    public HashMap<String, String> createPageInfoMap() {
        return null;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public int getExpectOrder() {
        return 2;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{4};
    }

    private final void setPageInfo() {
        BDVideoPlayer bindPlayer;
        HashMap<String, String> createPageInfoMap = createPageInfoMap();
        if (createPageInfoMap != null && (bindPlayer = getBindPlayer()) != null) {
            bindPlayer.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, createPageInfoMap);
        }
    }

    private final void setTraceInfo() {
        VideoTask videoTask;
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (videoTask = bindPlayer.getVideoTask()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_PLAY_COMMON));
            String str = videoTask.sessionId;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("plogid", str);
            String str3 = videoTask.traceId;
            if (str3 != null) {
                str2 = str3;
            }
            hashMap.put("traceid", str2);
            BDVideoPlayer bindPlayer2 = getBindPlayer();
            if (bindPlayer2 != null) {
                bindPlayer2.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            }
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onPlayerEventNotify(event);
        String action = event.getAction();
        if (action.hashCode() == -882902390 && action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
            setPageInfo();
            setTraceInfo();
        }
    }
}
