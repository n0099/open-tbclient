package com.baidu.searchbox.live.interfaces.player;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.searchbox.player.IBVideoPlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001gJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\u0017J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J-\u0010(\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010%*\u0004\u0018\u00010$2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&H&¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b*\u0010\u0019J\u000f\u0010+\u001a\u00020\u001eH&¢\u0006\u0004\b+\u0010 J\u0011\u0010,\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b,\u0010\u001dJ\u0011\u0010-\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b-\u0010\u001dJ\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0013H&¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H&¢\u0006\u0004\b1\u0010\u0017J\u000f\u00102\u001a\u00020\u0013H&¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0013H&¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\u0013H&¢\u0006\u0004\b5\u00103J\u000f\u00106\u001a\u00020\u0013H&¢\u0006\u0004\b6\u00103J\u000f\u00107\u001a\u00020\u0013H&¢\u0006\u0004\b7\u00103J'\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001eH&¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0013H&¢\u0006\u0004\b>\u00100J+\u0010A\u001a\u00020\u00062\u0012\u0010?\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010$\u0018\u00010&2\u0006\u0010@\u001a\u00020$H&¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H&¢\u0006\u0004\bC\u0010\u0017J\u0017\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\bD\u0010\bJ\u000f\u0010E\u001a\u00020\u0006H&¢\u0006\u0004\bE\u0010\u0017J\u0017\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0013H&¢\u0006\u0004\bG\u00100J\u000f\u0010H\u001a\u00020\u0006H&¢\u0006\u0004\bH\u0010\u0017J\u0017\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0013H&¢\u0006\u0004\bJ\u00100J\u000f\u0010K\u001a\u00020\u0006H&¢\u0006\u0004\bK\u0010\u0017J\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020LH&¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0013H&¢\u0006\u0004\bS\u00100J\u0019\u0010V\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010TH&¢\u0006\u0004\bV\u0010WJ\u0017\u0010Z\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020XH&¢\u0006\u0004\bZ\u0010[J\u0017\u0010^\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\\H&¢\u0006\u0004\b^\u0010_J7\u0010c\u001a\u00020\u00062&\u0010b\u001a\"\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0011\u0018\u00010`j\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0011\u0018\u0001`aH&¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0006H&¢\u0006\u0004\be\u0010\u0017J\u000f\u0010f\u001a\u00020\u0006H&¢\u0006\u0004\bf\u0010\u0017¨\u0006h"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "Lcom/baidu/searchbox/player/IBVideoPlayer;", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;", "listener", "", "addProgressListener", "(Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;)V", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "kernelLayer", "attachKernelLayer", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;)V", "Landroid/view/ViewGroup;", "holder", "attachToContainer", "(Landroid/view/ViewGroup;)V", "", "mode", "", "checkMode", "(Ljava/lang/String;)Z", "detachFromContainer", "()V", "detachKernelLayer", "()Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "disableOrientationEventHelper", "enableOrientationEventHelper", "getCurrentMode", "()Ljava/lang/String;", "", "getDuration", "()I", "Lcom/baidu/searchbox/player/callback/UniversalPlayerCallbackManager;", "getPlayerCallbackManager", "()Lcom/baidu/searchbox/player/callback/UniversalPlayerCallbackManager;", "Lcom/baidu/searchbox/player/context/IPlayerContext;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getPlayerContext", "(Ljava/lang/Class;)Lcom/baidu/searchbox/player/context/IPlayerContext;", "getPlayerKernelLayer", "getPosition", "getServerIpInfo", "getVideoUrl", "isForeground", "goBackOrForeground", "(Z)V", "imCloseTimeStatistics", "isComplete", "()Z", "isError", "isFloatingMode", "isPause", "isReverseLandscape", "progress", "buffer", "max", "onUpdateProgress", "(III)V", "isUserClick", "pauseInternal", "key", "context", "registerContext", "(Ljava/lang/Class;Lcom/baidu/searchbox/player/context/IPlayerContext;)V", "release", "removeProgressListener", "resetDefaultSwitchHelper", "isForce", "resume", "resumeFromError", "isClearPos", "resumePlayer", "saveProgressToDb", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "sendEvent", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "setMode", "(Ljava/lang/String;)V", "lock", "setOrientationLock", "Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;", "callback", "setPlayerListener", "(Lcom/baidu/searchbox/player/callback/IVideoPlayerCallback;)V", "", "i", "setSpeed", "(F)V", "Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;", "helper", "setStyleSwitchHelper", "(Lcom/baidu/searchbox/player/helper/IPlayerStyleSwitchHelper;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "videoInfo", "setVideoInfo", "(Ljava/util/HashMap;)V", "stopTimeStatistics", "switchToHalf", "OnProgressChangeListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LivePlayer extends IBVideoPlayer, IKernelPlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/LivePlayer$OnProgressChangeListener;", "Lkotlin/Any;", "", "progress", "buffer", "max", "", "onUpdateProgress", "(III)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnProgressChangeListener {
        void onUpdateProgress(int i, int i2, int i3);
    }

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

    void onUpdateProgress(int i, int i2, int i3);

    void pauseInternal(boolean z);

    void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext);

    void release();

    void removeProgressListener(OnProgressChangeListener onProgressChangeListener);

    void resetDefaultSwitchHelper();

    void resume(boolean z);

    void resumeFromError();

    void resumePlayer(boolean z);

    void saveProgressToDb();

    void sendEvent(VideoEvent videoEvent);

    void setMode(String str);

    void setOrientationLock(boolean z);

    void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback);

    void setSpeed(float f2);

    void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper);

    void setVideoInfo(HashMap<Integer, String> hashMap);

    void stopTimeStatistics();

    void switchToHalf();
}
