package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.utils.TraceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/player/plugin/TraceInfoPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "lastSessionId", "", "attachManager", "", "manager", "Lcom/baidu/searchbox/player/plugin/PluginManager;", "getSubscribeEvent", "", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TraceInfoPlugin extends AbsPlugin {
    public String lastSessionId = "";

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{4, 3, 5};
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin
    public void attachManager(PluginManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.attachManager(manager);
        final BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            bindPlayer.addInterceptor(new IVideoEventInterceptor() { // from class: com.baidu.searchbox.player.plugin.TraceInfoPlugin$attachManager$1$1
                @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
                public INeuron getInterceptorLayer() {
                    return this;
                }

                /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
                    if (r5 != false) goto L32;
                 */
                @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onInterceptorEvent(VideoEvent event) {
                    boolean z;
                    String str;
                    String str2;
                    BasicVideoSeries videoSeries;
                    String str3;
                    Intrinsics.checkNotNullParameter(event, "event");
                    String action = event.getAction();
                    int hashCode = action.hashCode();
                    boolean z2 = true;
                    if (hashCode != -882902390) {
                        if (hashCode != 1370689931) {
                            if (hashCode == 1939755256 && action.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                                TraceInfoPlugin traceInfoPlugin = this;
                                String createSessionId = BDVideoPlayer.this.createSessionId();
                                Intrinsics.checkNotNullExpressionValue(createSessionId, "createSessionId()");
                                traceInfoPlugin.lastSessionId = createSessionId;
                                BasicVideoSeries videoSeries2 = BDVideoPlayer.this.getVideoSeries();
                                str3 = this.lastSessionId;
                                TraceUtil.setSessionId(videoSeries2, str3);
                                TraceUtil.setLogId(BDVideoPlayer.this.getVideoSeries(), "");
                            }
                        } else if (action.equals(PlayerEvent.ACTION_ON_INFO) && event.getIntExtra(1) == 11008 && (videoSeries = BDVideoPlayer.this.getVideoSeries()) != null) {
                            TraceUtil.setLogId(videoSeries, event.getStringExtra(3));
                        }
                    } else if (action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        BasicVideoSeries videoSeries3 = BDVideoPlayer.this.getVideoSeries();
                        if (videoSeries3 != null) {
                            z = videoSeries3.isNeedPrepare();
                        } else {
                            z = false;
                        }
                        if (z) {
                            TraceUtil.setLogId(BDVideoPlayer.this.getVideoSeries(), "");
                        }
                        if (!z) {
                            str2 = this.lastSessionId;
                            if (str2.length() != 0) {
                                z2 = false;
                            }
                        }
                        TraceInfoPlugin traceInfoPlugin2 = this;
                        String createSessionId2 = BDVideoPlayer.this.createSessionId();
                        Intrinsics.checkNotNullExpressionValue(createSessionId2, "createSessionId()");
                        traceInfoPlugin2.lastSessionId = createSessionId2;
                        BasicVideoSeries videoSeries4 = BDVideoPlayer.this.getVideoSeries();
                        str = this.lastSessionId;
                        TraceUtil.setSessionId(videoSeries4, str);
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        BasicVideoSeries basicVideoSeries;
        BasicVideoSeries basicVideoSeries2;
        boolean z;
        String str;
        BaseKernelLayer playerKernelLayer;
        VideoUrlModel videoUrlModel;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(old, "old");
        if (status == PlayerStatus.PLAYING) {
            BDVideoPlayer bindPlayer = getBindPlayer();
            BasicVideoSeries basicVideoSeries3 = null;
            if (bindPlayer != null) {
                basicVideoSeries = bindPlayer.getVideoSeries();
            } else {
                basicVideoSeries = null;
            }
            if (basicVideoSeries != null) {
                BDVideoPlayer bindPlayer2 = getBindPlayer();
                if (bindPlayer2 != null) {
                    basicVideoSeries2 = bindPlayer2.getVideoSeries();
                } else {
                    basicVideoSeries2 = null;
                }
                if (TraceUtil.getLogId(basicVideoSeries2).length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    BDVideoPlayer bindPlayer3 = getBindPlayer();
                    if (bindPlayer3 != null && (playerKernelLayer = bindPlayer3.getPlayerKernelLayer()) != null && (videoUrlModel = playerKernelLayer.getVideoUrlModel()) != null) {
                        str = videoUrlModel.getKLogId();
                    } else {
                        str = null;
                    }
                    BDVideoPlayer bindPlayer4 = getBindPlayer();
                    if (bindPlayer4 != null) {
                        basicVideoSeries3 = bindPlayer4.getVideoSeries();
                    }
                    if (str == null) {
                        str = "";
                    }
                    TraceUtil.setLogId(basicVideoSeries3, str);
                }
            }
        }
    }
}
