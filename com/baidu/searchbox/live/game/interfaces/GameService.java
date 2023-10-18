package com.baidu.searchbox.live.game.interfaces;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dJ)\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService;", "Lkotlin/Any;", "", "", "params", "", "callHostMsgSendAPI", "(Ljava/util/Map;)V", "clearCachedHostMsgSendAPI", "()V", "Landroid/content/Context;", "context", "url", LiveYYPluginManager.USE_FROM_DISPATCH_YY_ROUTER, "(Landroid/content/Context;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/game/interfaces/GameService$GameAuthCallback;", WebChromeClient.KEY_ARG_CALLBACK, "doAuth", "(Ljava/util/Map;Lcom/baidu/searchbox/live/game/interfaces/GameService$GameAuthCallback;)V", "Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initHostMsgSendAPI", "(Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;)V", "data", "logTiebaStatic", "(Ljava/lang/String;Ljava/util/Map;)V", "releaseHostMsgSendAPI", "Companion", "GameAuthCallback", "MsgSendListener", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface GameService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService$GameAuthCallback;", "Lkotlin/Any;", "", "code", "", "msg", "", "onFail", "(ILjava/lang/String;)V", "onSuccess", "()V", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface GameAuthCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    void callHostMsgSendAPI(Map<String, String> map);

    void clearCachedHostMsgSendAPI();

    void dispatchYYLiveRouter(Context context, String str);

    void doAuth(Map<String, String> map, GameAuthCallback gameAuthCallback);

    void initHostMsgSendAPI(MsgSendListener msgSendListener);

    void logTiebaStatic(String str, Map<String, String> map);

    void releaseHostMsgSendAPI();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\b\u001a\u00020\u00052\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/game/interfaces/GameService$MsgSendListener;", "Lkotlin/Any;", "", "", "result", "", "onFailed", "(Ljava/util/Map;)V", "onSuccess", "lib-game-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface MsgSendListener {
        void onFailed(Map<String, String> map);

        void onSuccess(Map<String, String> map);

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
        /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("common");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void logTiebaStatic(GameService gameService, String str, Map<String, String> map) {
        }

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
