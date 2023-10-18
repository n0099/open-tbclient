package com.baidu.searchbox.live.interfaces.service;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.IDuMediaInstallListener;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0006J%\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "Lkotlin/Any;", "", "roomId", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "createBackPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "Lcom/baidu/searchbox/live/interfaces/player/BuildParams;", "params", "createPlayer", "(Lcom/baidu/searchbox/live/interfaces/player/BuildParams;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "Lcom/baidu/searchbox/live/interfaces/player/IDuMediaInstallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "installType", "", "initPlayerEvn", "(Lcom/baidu/searchbox/live/interfaces/player/IDuMediaInstallListener;I)V", StatConstants.KEY_EXT_ERR_CODE, "", "isAuthError", "(I)Z", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILivePlayerService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int INIT_PLAYER_EVN_CYBER = 1;
    public static final int INIT_PLAYER_EVN_DURTC = 10;
    public static final int V_MEDIA_SOURCE_TYPE_DEF = 0;
    public static final int V_MEDIA_SOURCE_TYPE_DURTC = 2;
    public static final int V_MEDIA_SOURCE_TYPE_FLOATING = 5;
    public static final int V_MEDIA_SOURCE_TYPE_FLOATING_PLAYBACK = 6;
    public static final int V_MEDIA_SOURCE_TYPE_PLAYBACK = 1;
    public static final int V_MEDIA_SOURCE_TYPE_VR = 3;
    public static final int V_MEDIA_SOURCE_TYPE_VR_PLAYBACK = 4;

    @Deprecated(message = "please use createPlayer(playerType: Int, roomId: String)")
    LivePlayer createBackPlayer(String str);

    LivePlayer createPlayer(BuildParams buildParams);

    @Deprecated(message = "please use createPlayer(playerType: Int, roomId: String)")
    LivePlayer createPlayer(String str);

    void initPlayerEvn(IDuMediaInstallListener iDuMediaInstallListener, int i);

    boolean isAuthError(int i);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService$Companion;", "", "INIT_PLAYER_EVN_CYBER", "I", "INIT_PLAYER_EVN_DURTC", "NEW_PLAY_AUTH_CODE", "OLD_PLAY_AUTH_CODE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "V_MEDIA_SOURCE_TYPE_DEF", "V_MEDIA_SOURCE_TYPE_DURTC", "V_MEDIA_SOURCE_TYPE_FLOATING", "V_MEDIA_SOURCE_TYPE_FLOATING_PLAYBACK", "V_MEDIA_SOURCE_TYPE_PLAYBACK", "V_MEDIA_SOURCE_TYPE_VR", "V_MEDIA_SOURCE_TYPE_VR_PLAYBACK", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final int INIT_PLAYER_EVN_CYBER = 1;
        public static final int INIT_PLAYER_EVN_DURTC = 10;
        public static final int NEW_PLAY_AUTH_CODE = -33403;
        public static final int OLD_PLAY_AUTH_CODE = -2403;
        public static final int V_MEDIA_SOURCE_TYPE_DEF = 0;
        public static final int V_MEDIA_SOURCE_TYPE_DURTC = 2;
        public static final int V_MEDIA_SOURCE_TYPE_FLOATING = 5;
        public static final int V_MEDIA_SOURCE_TYPE_FLOATING_PLAYBACK = 6;
        public static final int V_MEDIA_SOURCE_TYPE_PLAYBACK = 1;
        public static final int V_MEDIA_SOURCE_TYPE_VR = 3;
        public static final int V_MEDIA_SOURCE_TYPE_VR_PLAYBACK = 4;
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_PLAYER);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isAuthError(ILivePlayerService iLivePlayerService, int i) {
            return i == -2403 || i == -33403;
        }

        public static /* synthetic */ void initPlayerEvn$default(ILivePlayerService iLivePlayerService, IDuMediaInstallListener iDuMediaInstallListener, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    iDuMediaInstallListener = null;
                }
                if ((i2 & 2) != 0) {
                    i = 1;
                }
                iLivePlayerService.initPlayerEvn(iDuMediaInstallListener, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initPlayerEvn");
        }
    }
}
