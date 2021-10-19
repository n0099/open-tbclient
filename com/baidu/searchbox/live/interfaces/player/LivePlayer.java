package com.baidu.searchbox.live.interfaces.player;

import android.view.ViewGroup;
import com.alipay.sdk.sys.a;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.searchbox.player.IBVideoPlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0003stuJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001aJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J-\u0010)\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J-\u00102\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010/*\u0004\u0018\u00010.2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000100H&¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b4\u0010\u001cJ\u000f\u00105\u001a\u00020!H&¢\u0006\u0004\b5\u0010#J\u0011\u00106\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b6\u0010 J\u0011\u00107\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b7\u0010 J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0016H&¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0005H&¢\u0006\u0004\b;\u0010\u001aJ\u000f\u0010<\u001a\u00020\u0016H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0016H&¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\u0016H&¢\u0006\u0004\b?\u0010=J\u000f\u0010@\u001a\u00020\u0016H&¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020\u0016H&¢\u0006\u0004\bA\u0010=J\u0017\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0016H&¢\u0006\u0004\bC\u0010:J\u000f\u0010D\u001a\u00020\u0005H&¢\u0006\u0004\bD\u0010\u001aJ+\u0010F\u001a\u00020\u00052\u0012\u0010%\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010.\u0018\u0001002\u0006\u0010E\u001a\u00020.H&¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0005H&¢\u0006\u0004\bH\u0010\u001aJ\u0017\u0010I\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\bI\u0010\u0007J\u0017\u0010J\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\bJ\u0010\u000bJ\u000f\u0010K\u001a\u00020\u0005H&¢\u0006\u0004\bK\u0010\u001aJ\u0017\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0016H&¢\u0006\u0004\bM\u0010:J\u000f\u0010N\u001a\u00020\u0005H&¢\u0006\u0004\bN\u0010\u001aJ\u0017\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0016H&¢\u0006\u0004\bP\u0010:J\u000f\u0010Q\u001a\u00020\u0005H&¢\u0006\u0004\bQ\u0010\u001aJ\u001f\u0010T\u001a\u00020\u00052\u0006\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020!H&¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020VH&¢\u0006\u0004\bX\u0010YJ7\u0010]\u001a\u00020\u00052&\u0010\\\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`[H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u0016H&¢\u0006\u0004\bb\u0010:J\u0019\u0010e\u001a\u00020\u00052\b\u0010d\u001a\u0004\u0018\u00010cH&¢\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\u00052\u0006\u0010h\u001a\u00020gH&¢\u0006\u0004\bi\u0010jJ\u0017\u0010m\u001a\u00020\u00052\u0006\u0010l\u001a\u00020kH&¢\u0006\u0004\bm\u0010nJ7\u0010p\u001a\u00020\u00052&\u0010o\u001a\"\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0014\u0018\u00010Zj\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0014\u0018\u0001`[H&¢\u0006\u0004\bp\u0010^J\u000f\u0010q\u001a\u00020\u0005H&¢\u0006\u0004\bq\u0010\u001aJ\u000f\u0010r\u001a\u00020\u0005H&¢\u0006\u0004\br\u0010\u001a¨\u0006v"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "Lcom/baidu/searchbox/player/IBVideoPlayer;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnInfoListener;", "onInfoListener", "", "addOnInfoListener", "(Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnInfoListener;)V", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;", "listener", "addProgressListener", "(Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;)V", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "kernelLayer", "attachKernelLayer", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;)V", "Landroid/view/ViewGroup;", "holder", "attachToContainer", "(Landroid/view/ViewGroup;)V", "", "mode", "", "checkMode", "(Ljava/lang/String;)Z", "detachFromContainer", "()V", "detachKernelLayer", "()Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "disableOrientationEventHelper", "enableOrientationEventHelper", "getCurrentMode", "()Ljava/lang/String;", "", "getDuration", "()I", "", "key", "data", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback;", "cb", "getInfo", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback;)Ljava/lang/Object;", "Lcom/baidu/searchbox/player/callback/UniversalPlayerCallbackManager;", "getPlayerCallbackManager", "()Lcom/baidu/searchbox/player/callback/UniversalPlayerCallbackManager;", "Lcom/baidu/searchbox/player/context/IPlayerContext;", "T", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getPlayerContext", "(Ljava/lang/Class;)Lcom/baidu/searchbox/player/context/IPlayerContext;", "getPlayerKernelLayer", "getPosition", "getServerIpInfo", "getVideoUrl", "isForeground", "goBackOrForeground", "(Z)V", "imCloseTimeStatistics", "isComplete", "()Z", "isError", "isFloatingMode", "isPause", "isReverseLandscape", "isUserClick", "pauseInternal", "prePlay", "context", "registerContext", "(Ljava/lang/Class;Lcom/baidu/searchbox/player/context/IPlayerContext;)V", "release", "removeOnInfoListener", "removeProgressListener", "resetDefaultSwitchHelper", "isForce", "resume", "resumeFromError", "isClearPos", "resumePlayer", "saveProgressToDb", "msec", "seekmode", "seekTo", "(II)V", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "sendEvent", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", a.v, "setExtInfoStatistics", "(Ljava/util/HashMap;)V", "setMode", "(Ljava/lang/String;)V", "lock", "setOrientationLock", "Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;", "callback", "setPlayerListener", "(Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;)V", "", "i", "setSpeed", "(F)V", "Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;", "helper", "setStyleSwitchHelper", "(Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;)V", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "setVideoInfo", "stopTimeStatistics", "switchToHalf", "InfoCallback", "OnInfoListener", "OnProgressChangeListener", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public interface LivePlayer extends IBVideoPlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void setExtInfoStatistics(LivePlayer livePlayer, HashMap<String, String> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, livePlayer, hashMap) == null) {
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback;", "Lkotlin/Any;", "", "result", "", "data", "", "onResult", "(ILjava/lang/Object;)V", "Companion", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public interface InfoCallback {
        public static final String ACTION_PLAYER_CARLTON = "statistics_player_carlton";
        public static final String BDRTC_VIDEO_OUTPUT_FPS = "video_fps";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int STATUS_CODE_INTERCEPT = -4;
        public static final int STATUS_CODE_LOAD_CLASS_ERROR = -3;
        public static final int STATUS_CODE_NOT_INSTALL = -2;
        public static final int STATUS_CODE_NOT_SUPPORT = -1;
        public static final int STATUS_CODE_SUCCESS = 0;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback$Companion;", "", "ACTION_PLAYER_CARLTON", "Ljava/lang/String;", "BDRTC_VIDEO_OUTPUT_FPS", "", "STATUS_CODE_INTERCEPT", "I", "STATUS_CODE_LOAD_CLASS_ERROR", "STATUS_CODE_NOT_INSTALL", "STATUS_CODE_NOT_SUPPORT", "STATUS_CODE_SUCCESS", "<init>", "()V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes5.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE;
            public static /* synthetic */ Interceptable $ic = null;
            public static final String ACTION_PLAYER_CARLTON = "statistics_player_carlton";
            public static final String BDRTC_VIDEO_OUTPUT_FPS = "video_fps";
            public static final int STATUS_CODE_INTERCEPT = -4;
            public static final int STATUS_CODE_LOAD_CLASS_ERROR = -3;
            public static final int STATUS_CODE_NOT_INSTALL = -2;
            public static final int STATUS_CODE_NOT_SUPPORT = -1;
            public static final int STATUS_CODE_SUCCESS = 0;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138717109, "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback$Companion;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-2138717109, "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$InfoCallback$Companion;");
                        return;
                    }
                }
                $$INSTANCE = new Companion();
            }

            public Companion() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }

        void onResult(int i2, Object obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnInfoListener;", "Lkotlin/Any;", "", "what", "extra", "", "object", "onInfo", "(IILjava/lang/Object;)Ljava/lang/Object;", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public interface OnInfoListener {
        Object onInfo(int i2, int i3, Object obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;", "Lkotlin/Any;", "", "progress", "buffer", "max", "", "onUpdateProgress", "(III)V", "lib-live-interfaces_debug"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
    public interface OnProgressChangeListener {
        void onUpdateProgress(int i2, int i3, int i4);
    }

    void addOnInfoListener(OnInfoListener onInfoListener);

    void addProgressListener(OnProgressChangeListener onProgressChangeListener);

    void attachKernelLayer(BaseKernelLayer baseKernelLayer);

    void attachToContainer(ViewGroup viewGroup);

    boolean checkMode(String str);

    void detachFromContainer();

    BaseKernelLayer detachKernelLayer();

    void disableOrientationEventHelper();

    void enableOrientationEventHelper();

    String getCurrentMode();

    int getDuration();

    Object getInfo(Object obj, Object obj2, InfoCallback infoCallback);

    UniversalPlayerCallbackManager getPlayerCallbackManager();

    <T extends IPlayerContext> T getPlayerContext(Class<T> cls);

    BaseKernelLayer getPlayerKernelLayer();

    int getPosition();

    String getServerIpInfo();

    String getVideoUrl();

    void goBackOrForeground(boolean z);

    void imCloseTimeStatistics();

    boolean isComplete();

    boolean isError();

    boolean isFloatingMode();

    boolean isPause();

    boolean isReverseLandscape();

    void pauseInternal(boolean z);

    void prePlay();

    void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext);

    void release();

    void removeOnInfoListener(OnInfoListener onInfoListener);

    void removeProgressListener(OnProgressChangeListener onProgressChangeListener);

    void resetDefaultSwitchHelper();

    void resume(boolean z);

    void resumeFromError();

    void resumePlayer(boolean z);

    void saveProgressToDb();

    void seekTo(int i2, int i3);

    void sendEvent(VideoEvent videoEvent);

    void setExtInfoStatistics(HashMap<String, String> hashMap);

    void setMode(String str);

    void setOrientationLock(boolean z);

    void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback);

    void setSpeed(float f2);

    void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper);

    void setVideoInfo(HashMap<Integer, String> hashMap);

    void stopTimeStatistics();

    void switchToHalf();
}
