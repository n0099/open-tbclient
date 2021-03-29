package com.baidu.searchbox.live.interfaces.service;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J%\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "Lkotlin/Any;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "createBackPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "createPlayer", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener;", "listener", "", "installType", "", "initPlayerEvn", "(Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener;I)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILivePlayerService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_PLAYER);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void initPlayerEvn$default(ILivePlayerService iLivePlayerService, CyberPlayerManager.InstallListener installListener, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    installListener = null;
                }
                if ((i2 & 2) != 0) {
                    i = 1;
                }
                iLivePlayerService.initPlayerEvn(installListener, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initPlayerEvn");
        }
    }

    LivePlayer createBackPlayer(String str);

    LivePlayer createPlayer(String str);

    void initPlayerEvn(CyberPlayerManager.InstallListener installListener, int i);
}
