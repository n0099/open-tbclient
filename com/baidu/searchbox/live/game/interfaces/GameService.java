package com.baidu.searchbox.live.game.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010J)\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService;", "Lkotlin/Any;", "", "", "params", "", "callHostMsgSendAPI", "(Ljava/util/Map;)V", "clearCachedHostMsgSendAPI", "()V", "Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initHostMsgSendAPI", "(Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;)V", "releaseHostMsgSendAPI", "Companion", "MsgSendListener", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface GameService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void callHostMsgSendAPI(Map<String, String> map);

    void clearCachedHostMsgSendAPI();

    void initHostMsgSendAPI(MsgSendListener msgSendListener);

    void releaseHostMsgSendAPI();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\b\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;", "Lkotlin/Any;", "", "", "result", "", "onFailed", "(Ljava/util/Map;)V", "onSuccess", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface MsgSendListener {
        void onFailed(Map<String, String> map);

        void onSuccess(Map<String, String> map);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.game.interfaces.GameService$MsgSendListener */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void onFailed$default(MsgSendListener msgSendListener, Map map, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        map = null;
                    }
                    msgSendListener.onFailed(map);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.game.interfaces.GameService$MsgSendListener */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void onSuccess$default(MsgSendListener msgSendListener, Map map, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        map = null;
                    }
                    msgSendListener.onSuccess(map);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("common");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.live.game.interfaces.GameService */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void callHostMsgSendAPI$default(GameService gameService, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = null;
                }
                gameService.callHostMsgSendAPI(map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callHostMsgSendAPI");
        }

        public static /* synthetic */ void initHostMsgSendAPI$default(GameService gameService, MsgSendListener msgSendListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    msgSendListener = null;
                }
                gameService.initHostMsgSendAPI(msgSendListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initHostMsgSendAPI");
        }
    }
}
