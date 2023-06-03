package com.baidu.searchbox.player.plugin;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.DumediaInitPlugin;
import com.baidu.searchbox.player.utils.BdVideoLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/player/plugin/DumediaInitPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "()V", "interceptor", "Lcom/baidu/searchbox/player/plugin/DumediaInitPlugin$InstallInterceptor;", "isStarted", "", "sourceEvent", "Lcom/baidu/searchbox/player/event/VideoEvent;", "addInterceptor", "", "attachManager", "manager", "Lcom/baidu/searchbox/player/plugin/PluginManager;", "dumediaInstallType", "", "getSubscribeEvent", "", "installDumedia", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function0;", "isBreakInterceptor", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "isDumediaLoaded", "onControlEventNotify", "event", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "onPluginRelease", "resetSourceEvent", "InstallInterceptor", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DumediaInitPlugin extends AbsPlugin {
    public final InstallInterceptor interceptor = new InstallInterceptor();
    public boolean isStarted;
    public VideoEvent sourceEvent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.STOP.ordinal()] = 1;
            iArr[PlayerStatus.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public int dumediaInstallType() {
        return 23;
    }

    public abstract void installDumedia(Function0<Unit> function0);

    public boolean isBreakInterceptor(BasicVideoSeries series) {
        Intrinsics.checkNotNullParameter(series, "series");
        return false;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/plugin/DumediaInitPlugin$InstallInterceptor;", "Lcom/baidu/searchbox/player/interfaces/IVideoEventInterceptor;", "(Lcom/baidu/searchbox/player/plugin/DumediaInitPlugin;)V", "getInterceptorLayer", "Lcom/baidu/searchbox/player/interfaces/INeuron;", "onInterceptorEvent", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final class InstallInterceptor implements IVideoEventInterceptor {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public InstallInterceptor() {
        }

        @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
        public INeuron getInterceptorLayer() {
            return DumediaInitPlugin.this;
        }

        @Override // com.baidu.searchbox.player.interfaces.IVideoEventInterceptor
        public boolean onInterceptorEvent(VideoEvent event) {
            BDVideoPlayer bindPlayer;
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.getAction(), PlayerEvent.ACTION_SET_DATA_SOURCE) && !DumediaInitPlugin.this.isDumediaLoaded()) {
                BdVideoLog.d(DumediaInitPluginKt.TAG, "dumedia kernel need install, begin installing");
                DumediaInitPlugin.this.isStarted = false;
                Object extra = event.getExtra(3);
                if (!(extra instanceof BasicVideoSeries)) {
                    extra = null;
                }
                BasicVideoSeries basicVideoSeries = (BasicVideoSeries) extra;
                if (basicVideoSeries != null && !DumediaInitPlugin.this.isBreakInterceptor(basicVideoSeries)) {
                    DumediaInitPlugin.this.sourceEvent = VideoEvent.copy(event);
                    if (basicVideoSeries.isNeedPrepare() && (bindPlayer = DumediaInitPlugin.this.getBindPlayer()) != null) {
                        bindPlayer.syncStatus(PlayerStatus.PREPARING);
                    }
                    final DumediaInitPlugin dumediaInitPlugin = DumediaInitPlugin.this;
                    dumediaInitPlugin.installDumedia(new Function0<Unit>() { // from class: com.baidu.searchbox.player.plugin.DumediaInitPlugin$InstallInterceptor$onInterceptorEvent$1
                        {
                            super(0);
                        }

                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            VideoEvent videoEvent;
                            VideoEvent videoEvent2;
                            boolean z;
                            BDVideoPlayer bindPlayer2;
                            DumediaInitPlugin.InstallInterceptor installInterceptor;
                            BDVideoPlayer bindPlayer3 = DumediaInitPlugin.this.getBindPlayer();
                            boolean z2 = true;
                            if ((bindPlayer3 == null || !bindPlayer3.isPreparing()) ? false : false) {
                                videoEvent = DumediaInitPlugin.this.sourceEvent;
                                if (videoEvent != null) {
                                    BdVideoLog.d(DumediaInitPluginKt.TAG, "begin resume play");
                                    DumediaInitPlugin dumediaInitPlugin2 = DumediaInitPlugin.this;
                                    videoEvent2 = dumediaInitPlugin2.sourceEvent;
                                    dumediaInitPlugin2.sendEvent(videoEvent2);
                                    BDVideoPlayer bindPlayer4 = DumediaInitPlugin.this.getBindPlayer();
                                    if (bindPlayer4 != null) {
                                        installInterceptor = DumediaInitPlugin.this.interceptor;
                                        bindPlayer4.removeInterceptor(installInterceptor);
                                    }
                                    z = DumediaInitPlugin.this.isStarted;
                                    if (z && (bindPlayer2 = DumediaInitPlugin.this.getBindPlayer()) != null) {
                                        bindPlayer2.start();
                                    }
                                }
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        }
    }

    private final void addInterceptor() {
        if (isDumediaLoaded()) {
            return;
        }
        BdVideoLog.d(DumediaInitPluginKt.TAG, "dumedia kernel is not installed, begin watching play action for install");
        BDVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            bindPlayer.addInterceptor(this.interceptor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDumediaLoaded() {
        return CyberPlayerManager.isCoreLoaded(dumediaInstallType());
    }

    private final void resetSourceEvent() {
        VideoEvent videoEvent = this.sourceEvent;
        if (videoEvent != null) {
            videoEvent.recycle();
        }
        this.sourceEvent = null;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{4, 2};
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginRelease() {
        super.onPluginRelease();
        resetSourceEvent();
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin
    public void attachManager(PluginManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.attachManager(manager);
        addInterceptor();
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(old, "old");
        super.onPlayerStatusChanged(status, old);
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1 || i == 2) {
            resetSourceEvent();
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onControlEventNotify(event);
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 723345051) {
            if (hashCode == 1547354793 && action.equals(ControlEvent.ACTION_STOP)) {
                this.isStarted = false;
            }
        } else if (action.equals(ControlEvent.ACTION_START)) {
            this.isStarted = true;
        }
    }
}
