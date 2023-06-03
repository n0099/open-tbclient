package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.ubc.PlayerStatConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/plugin/KernelAutoSwitchPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "attachManager", "", "manager", "Lcom/baidu/searchbox/player/plugin/PluginManager;", "getSubscribeEvent", "", "performSwitchKernel", PlayerStatConstants.STAT_KEY_KERNEL_TYPE, "", "switchKernel", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KernelAutoSwitchPlugin extends AbsPlugin {
    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{4};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchKernel() {
        BasicVideoSeries videoSeries;
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null && (videoSeries = bindPlayer.getVideoSeries()) != null) {
            performSwitchKernel(videoSeries.getKernelType());
        }
    }

    private final void performSwitchKernel(String str) {
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            bindPlayer.getReuseHelper().performSwitchKernel(bindPlayer, str);
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin
    public void attachManager(PluginManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.attachManager(manager);
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            bindPlayer.addInterceptor(new IVideoEventInterceptor() { // from class: com.baidu.searchbox.player.plugin.KernelAutoSwitchPlugin$attachManager$1
                @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
                public boolean onInterceptorEvent(VideoEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (!Intrinsics.areEqual(event.getAction(), PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        return false;
                    }
                    KernelAutoSwitchPlugin.this.switchKernel();
                    return false;
                }

                @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
                public INeuron getInterceptorLayer() {
                    return KernelAutoSwitchPlugin.this;
                }
            });
        }
    }
}
