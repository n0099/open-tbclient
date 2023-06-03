package com.baidu.searchbox.player.ubc;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.utils.TraceUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/ubc/DumediaStatExtPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "createPageInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExpectOrder", "", "getSubscribeEvent", "", "onPlayerEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "setPageInfo", "setTraceInfo", "bdvideoplayer-stat-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
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
        BasicVideoSeries videoSeries;
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (videoSeries = bindPlayer.getVideoSeries()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "24322");
            hashMap.put("plogid", TraceUtil.getSessionId(videoSeries));
            hashMap.put("traceid", TraceUtil.getTraceId(videoSeries));
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
