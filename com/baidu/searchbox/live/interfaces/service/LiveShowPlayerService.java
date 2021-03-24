package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerCallback;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerStatusCallback;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u0000 D2\u00020\u0001:\u0001DJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\nH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000fH&¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b'\u0010&J\u001f\u0010(\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\nH&¢\u0006\u0004\b(\u0010\u000eJ\u0017\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b+\u0010*J\u001f\u0010-\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000fH&¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0006H&¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b3\u00104J!\u00103\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u000105H&¢\u0006\u0004\b3\u00106J\u001f\u00108\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0004H&¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000fH&¢\u0006\u0004\b:\u0010.J\u001f\u0010;\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000fH&¢\u0006\u0004\b;\u0010.J/\u0010?\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u001eH&¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\bA\u0010*J\u0017\u0010B\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\bB\u0010*J\u0017\u0010C\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\bC\u0010*¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveShowPlayerService;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "url", "", "createPlayerWithUrl", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", DI.LIVE_PLAYER, "", IntentConfig.STOP, "", "dismissFloating", "(Ljava/lang/Object;Z)V", "", LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, "(Ljava/lang/Object;)I", "getDuration", "getLivePlayer", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/view/View;", "getPlayerView", "(Ljava/lang/Object;)Landroid/view/View;", "getVideoHeight", "getVideoPath", "(Ljava/lang/Object;)Ljava/lang/String;", "getVideoWidth", "hasFloatingPermission", "()Z", "Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerCallback;", "callback", "type", "initCyberCore", "(Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerCallback;I)V", "isCoreLoaded", "(I)Z", "isFloatShowing", "(Ljava/lang/Object;)Z", "isPlaying", "mute", "pause", "(Ljava/lang/Object;)V", "resume", "mode", "setDecodeMode", "(Ljava/lang/Object;I)V", "key", "value", "setExternalInfo", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", "setPlayerCallback", "(Ljava/lang/Object;Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerCallback;)V", "Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerStatusCallback;", "(Ljava/lang/Object;Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerStatusCallback;)V", "path", "setVideoPath", "(Ljava/lang/Object;Ljava/lang/String;)V", "setVideoRotation", "setVideoScalingMode", "v", "liveInfo", "cb", "showFloating", "(Ljava/lang/Object;Landroid/view/View;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/liveshowplayer/LiveShowPlayerCallback;)Ljava/lang/Object;", IntentConfig.START, "stopPlayback", "switchNormal", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface LiveShowPlayerService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveShowPlayerService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_SHOW_VIDEO_PLAYER);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    Object createPlayerWithUrl(Context context, String str);

    void dismissFloating(Object obj, boolean z);

    int getCurrentPosition(Object obj);

    int getDuration(Object obj);

    Object getLivePlayer(Context context);

    View getPlayerView(Object obj);

    int getVideoHeight(Object obj);

    String getVideoPath(Object obj);

    int getVideoWidth(Object obj);

    boolean hasFloatingPermission();

    void initCyberCore(LiveShowPlayerCallback liveShowPlayerCallback, int i);

    boolean isCoreLoaded(int i);

    boolean isFloatShowing(Object obj);

    boolean isPlaying(Object obj);

    void mute(Object obj, boolean z);

    void pause(Object obj);

    void resume(Object obj);

    void setDecodeMode(Object obj, int i);

    void setExternalInfo(Object obj, String str, Object obj2);

    void setPlayerCallback(Object obj, LiveShowPlayerCallback liveShowPlayerCallback);

    void setPlayerCallback(Object obj, LiveShowPlayerStatusCallback liveShowPlayerStatusCallback);

    void setVideoPath(Object obj, String str);

    void setVideoRotation(Object obj, int i);

    void setVideoScalingMode(Object obj, int i);

    Object showFloating(Object obj, View view, String str, LiveShowPlayerCallback liveShowPlayerCallback);

    void start(Object obj);

    void stopPlayback(Object obj);

    void switchNormal(Object obj);
}
