package com.baidu.searchbox.player.layer;

import android.view.Surface;
import android.view.View;
import androidx.annotation.CallSuper;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.InternalSyncControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.interfaces.OnMediaRuntimeInfoListener;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesExt;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.OptionState;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.pool.VideoKernelPool;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.ubc.PlayerStatConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0002³\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0016J\u000e\u0010Z\u001a\u00020W2\u0006\u0010[\u001a\u00020\\J\b\u0010]\u001a\u00020WH\u0014J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0006\u0010`\u001a\u00020\u000fJ\u0010\u0010a\u001a\u00020W2\b\u0010b\u001a\u0004\u0018\u00010cJ\b\u0010d\u001a\u00020eH\u0016J\u000e\u0010f\u001a\u00020W2\u0006\u0010g\u001a\u00020\tJ\u0010\u0010h\u001a\u00020W2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020W2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010l\u001a\u00020WH\u0016J\u0010\u0010m\u001a\u00020W2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010n\u001a\u00020W2\u0006\u0010i\u001a\u00020jH\u0016J\u001c\u0010o\u001a\u00020W2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010p\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010q\u001a\u00020W2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010r\u001a\u00020WJ\u000e\u0010s\u001a\u00020W2\u0006\u0010N\u001a\u00020\u0003J\u0006\u0010t\u001a\u00020WJ\u0010\u0010u\u001a\u00020W2\u0006\u0010[\u001a\u00020\\H\u0015J\u0006\u0010v\u001a\u00020WJ\b\u0010w\u001a\u00020WH\u0002J\u0006\u0010x\u001a\u00020WJ$\u0010y\u001a\u00020W2\u0006\u0010z\u001a\u00020\u000f2\b\b\u0002\u0010{\u001a\u00020\u000f2\b\b\u0002\u0010|\u001a\u00020\u000fH\u0017J$\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u000f2\b\b\u0002\u0010{\u001a\u00020\u000f2\b\b\u0002\u0010|\u001a\u00020\u000fH\u0017J\u0011\u0010\u007f\u001a\u00020W2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003J\u000f\u0010\u0081\u0001\u001a\u00020W2\u0006\u0010|\u001a\u00020\u000fJ\u001b\u0010\u0082\u0001\u001a\u00020W2\u0007\u0010\u0083\u0001\u001a\u00020\u00032\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003J\u001e\u0010\u0085\u0001\u001a\u00020W2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00032\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0086\u0001J0\u0010\u0087\u0001\u001a\u00020W2'\u0010\u0088\u0001\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000100j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`1J\u0013\u0010\u0089\u0001\u001a\u00020W2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001J\u0010\u0010\u008c\u0001\u001a\u00020W2\u0007\u0010\u008d\u0001\u001a\u00020\tJ\u001d\u0010\u008e\u0001\u001a\u00020W2\u0007\u0010\u0083\u0001\u001a\u00020\u00032\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020W2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\u0011\u0010\u0091\u0001\u001a\u00020W2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001J\u0010\u0010\u0094\u0001\u001a\u00020W2\u0007\u0010\u0095\u0001\u001a\u00020\tJ\u0011\u0010\u0096\u0001\u001a\u00020W2\b\u0010\u0097\u0001\u001a\u00030\u0093\u0001J\u0013\u0010\u0098\u0001\u001a\u00020W2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001J\u0012\u0010\u009b\u0001\u001a\u00020W2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003J7\u0010\u009d\u0001\u001a\u00020W2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00032#\u0010\u009f\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000300j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`1J\u0010\u0010 \u0001\u001a\u00020W2\u0007\u0010¡\u0001\u001a\u00020\u000fJ\u0010\u0010¢\u0001\u001a\u00020W2\u0007\u0010£\u0001\u001a\u00020\u000fJ\u0011\u0010¤\u0001\u001a\u00020W2\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010¥\u0001\u001a\u00020W2\u0007\u0010¦\u0001\u001a\u00020\tJ\u0007\u0010§\u0001\u001a\u00020WJ\t\u0010¨\u0001\u001a\u00020WH\u0016J\u0007\u0010©\u0001\u001a\u00020WJ\u0012\u0010ª\u0001\u001a\u00020W2\u0007\u0010«\u0001\u001a\u00020\u000fH\u0007J\u0018\u0010ª\u0001\u001a\u00020W2\u0007\u0010«\u0001\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000fJ\u000f\u0010¬\u0001\u001a\u00020W2\u0006\u0010<\u001a\u00020=J\u001d\u0010\u00ad\u0001\u001a\u00020\t2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u00012\b\u0010°\u0001\u001a\u00030\u0093\u0001J\u0012\u0010±\u0001\u001a\u00020W2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\t\u0010²\u0001\u001a\u00020\tH\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001f\u0010\"\u001a\u00060#R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b$\u0010%R\u001f\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R7\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000300j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`18BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b2\u00103R\u0011\u00105\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b6\u0010\u0011R\u0011\u00107\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b8\u0010\u0011R\u0013\u00109\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bA\u0010\u0011R\u0011\u0010B\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bC\u0010;R\u0011\u0010D\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bE\u0010\u0011R\u001e\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010;R\u0011\u0010P\u001a\u00020Q8F¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bU\u0010\u0011¨\u0006´\u0001"}, d2 = {"Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "Lcom/baidu/searchbox/player/layer/AbsLayer;", PlayerStatConstants.STAT_KEY_KERNEL_TYPE, "", "(Ljava/lang/String;)V", "kernel", "Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "(Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;)V", "acceptVolumeChange", "", "getAcceptVolumeChange", "()Z", "setAcceptVolumeChange", "(Z)V", "bufferingPosition", "", "getBufferingPosition", "()I", "duration", "getDuration", "durationMs", "getDurationMs", "extraBundle", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getExtraBundle", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "extraBundle$delegate", "Lkotlin/Lazy;", "gestureDetector", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "getGestureDetector", "()Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "setGestureDetector", "(Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;)V", "internalEventDispatcher", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer$Dispatcher;", "getInternalEventDispatcher", "()Lcom/baidu/searchbox/player/layer/BaseKernelLayer$Dispatcher;", "internalEventDispatcher$delegate", "kernelInfo", "", "getKernelInfo", "()Ljava/util/Map;", "kernelMediaInfo", "Lcom/baidu/searchbox/player/model/KernelMediaInfo;", "getKernelMediaInfo", "()Lcom/baidu/searchbox/player/model/KernelMediaInfo;", "optionList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getOptionList", "()Ljava/util/HashMap;", "optionList$delegate", CriusAttrConstants.POSITION, "getPosition", "positionMs", "getPositionMs", "serverIpInfo", "getServerIpInfo", "()Ljava/lang/String;", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "getStatus", "()Lcom/baidu/searchbox/player/constants/PlayerStatus;", "syncPositionMs", "getSyncPositionMs", "vid", "getVid", "videoHeight", "getVideoHeight", "<set-?>", "videoKernel", "getVideoKernel", "()Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "videoSession", "Lcom/baidu/searchbox/player/session/VideoSession;", "getVideoSession", "()Lcom/baidu/searchbox/player/session/VideoSession;", "videoUrl", "getVideoUrl", "videoUrlModel", "Lcom/baidu/searchbox/player/model/VideoUrlModel;", "getVideoUrlModel", "()Lcom/baidu/searchbox/player/model/VideoUrlModel;", "videoWidth", "getVideoWidth", "attachMessenger", "", "courier", "Lcom/baidu/searchbox/player/message/IMessenger;", "changePlayUrl", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "detachMessenger", "getContentView", "Landroid/view/View;", "getDecodeMode", "getMediaRuntimeInfo", "runtimeInfoListener", "Lcom/baidu/searchbox/player/interfaces/OnMediaRuntimeInfoListener;", "getSubscribeEvent", "", "mute", "isMute", "onControlEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onInteractiveEventNotify", "onLayerDetach", "onLayerEventNotify", "onPlayerEventNotify", "onPlayerStatusChanged", "old", "onSystemEventNotify", DownloadStatisticConstants.UBC_TYPE_PAUSE, "play", "prepare", "processOption", "release", "requestAudioFocus", DownloadStatisticConstants.UBC_TYPE_RESUME, "seekTo", "progress", "seekToDelta", "mode", "seekToMs", "targetProgress", "setClarityInfo", "clarityInfo", "setDecodeMode", "setDynamicOption", "key", "value", "setExternalInfo", "", "setHttpHeader", "httpHeader", "setKernelCallBack", "callBack", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "setLooping", "loop", "setOption", "setProxy", "proxy", "setRadius", "radius", "", "setRemote", "isOpen", "setSpeed", "i", "setSurface", "surface", "Landroid/view/Surface;", "setUserAgent", "ua", "setVideoFormatOptions", "format", "options", "setVideoRotation", "rotate", "setVideoScalingMode", "scalingMode", "setVideoSeries", "setZOrderMediaOverlay", "isMediaOverlay", "start", "stop", "stopPlayback", "switchMediaSource", MultiRatePlayUrlHelper.RANK, "syncStatus", "takeSnapshotAsync", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/interfaces/OnSnapShotFrameListener;", "scale", "updateFreeProxy", "usePackageOptionMode", com.baidu.android.imsdk.internal.Dispatcher.TAG, "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BaseKernelLayer extends AbsLayer {
    public boolean acceptVolumeChange;
    public final Lazy extraBundle$delegate;
    public IKernelGestureDetector gestureDetector;
    public final Lazy internalEventDispatcher$delegate;
    public final Lazy optionList$delegate;
    public AbsVideoKernel videoKernel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.ERROR.ordinal()] = 1;
            iArr[PlayerStatus.STOP.ordinal()] = 2;
            iArr[PlayerStatus.COMPLETE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmOverloads
    public final void seekTo(int i) {
        seekTo$default(this, i, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void seekTo(int i, int i2) {
        seekTo$default(this, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public final void seekToMs(int i) {
        seekToMs$default(this, i, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void seekToMs(int i, int i2) {
        seekToMs$default(this, i, i2, 0, 4, null);
    }

    public boolean usePackageOptionMode() {
        return false;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/layer/BaseKernelLayer$Dispatcher;", "Lcom/baidu/searchbox/player/interfaces/InternalEventDispatcher;", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;)V", "getExpectOrder", "", "onVideoEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final class Dispatcher implements InternalEventDispatcher {
        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public int getExpectOrder() {
            return 1;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public Dispatcher() {
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public void onVideoEventNotify(VideoEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BaseKernelLayer.this.getVideoSession().accessEventNotify(event);
        }
    }

    public BaseKernelLayer(AbsVideoKernel kernel) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        this.videoKernel = kernel;
        this.acceptVolumeChange = true;
        this.internalEventDispatcher$delegate = BdPlayerUtils.lazyNone(new Function0<Dispatcher>() { // from class: com.baidu.searchbox.player.layer.BaseKernelLayer$internalEventDispatcher$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseKernelLayer.Dispatcher invoke() {
                return new BaseKernelLayer.Dispatcher();
            }
        });
        this.extraBundle$delegate = BdPlayerUtils.lazyNone(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.layer.BaseKernelLayer$extraBundle$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StringArrayBundle invoke() {
                return new StringArrayBundle(0, 1, null);
            }
        });
        this.optionList$delegate = BdPlayerUtils.lazyNone(new Function0<HashMap<String, String>>() { // from class: com.baidu.searchbox.player.layer.BaseKernelLayer$optionList$2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, String> invoke() {
                return new HashMap<>(20);
            }
        });
        initLayer();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void attachMessenger(IMessenger courier) {
        Intrinsics.checkNotNullParameter(courier, "courier");
        super.attachMessenger(courier);
        courier.addInternalDispatcher(getInternalEventDispatcher());
        this.videoKernel.bindMessenger(courier);
    }

    public final void changePlayUrl(BasicVideoSeries series) {
        Intrinsics.checkNotNullParameter(series, "series");
        processOption(series);
        this.videoKernel.changePlayUrl(series, getOptionList());
    }

    public final void getMediaRuntimeInfo(OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        this.videoKernel.getMediaRuntimeInfo(onMediaRuntimeInfoListener);
    }

    public final void mute(boolean z) {
        this.videoKernel.mute(z);
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInteractiveEventNotify(event);
        if (Intrinsics.areEqual(InteractiveEvent.ACTION_INTERACTIVE_ERROR, event.getAction())) {
            this.videoKernel.onError();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(VideoEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.acceptVolumeChange && Intrinsics.areEqual(SystemEvent.ACTION_VOLUME_CHANGED, event.getAction())) {
            int intExtra = event.getIntExtra(4);
            BDVideoPlayer bindPlayer = getBindPlayer();
            if (bindPlayer != null) {
                if (intExtra <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                bindPlayer.setMuteMode(z);
            }
        }
    }

    public final void play(String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.videoKernel.play(videoUrl);
    }

    @CallSuper
    public void processOption(BasicVideoSeries series) {
        boolean z;
        Intrinsics.checkNotNullParameter(series, "series");
        if (series.getPreRenderOptionState() == OptionState.ENABLE) {
            z = true;
        } else {
            z = false;
        }
        setOption("opt-pre-render-on-prepared", BaseKernelLayerKt.toOption(z));
        setOption("video_bind_4g", BaseKernelLayerKt.toOption(BasicVideoSeriesExt.isWifi4GDualEnable(series)));
    }

    public final void setAcceptVolumeChange(boolean z) {
        this.acceptVolumeChange = z;
    }

    public final void setClarityInfo(String str) {
        this.videoKernel.setClarityInfo(str);
    }

    public final void setDecodeMode(int i) {
        this.videoKernel.setDecodeMode(i);
    }

    public void setGestureDetector(IKernelGestureDetector iKernelGestureDetector) {
        this.gestureDetector = iKernelGestureDetector;
    }

    public final void setHttpHeader(HashMap<String, String> hashMap) {
        this.videoKernel.setHttpHeader(hashMap);
    }

    public final void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.videoKernel.setKernelCallBack(iKernelPlayer);
    }

    public final void setLooping(boolean z) {
        this.videoKernel.setLooping(z);
    }

    public final void setProxy(String str) {
        this.videoKernel.setProxy(str);
    }

    public final void setRadius(float f) {
        this.videoKernel.setRadius(f);
    }

    public final void setRemote(boolean z) {
        this.videoKernel.setRemote(z);
    }

    public final void setSpeed(float f) {
        this.videoKernel.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        this.videoKernel.setSurface(surface);
    }

    public final void setUserAgent(String str) {
        this.videoKernel.setUserAgent(str);
    }

    public final void setVideoRotation(int i) {
        this.videoKernel.setVideoRotation(i);
    }

    public final void setVideoScalingMode(int i) {
        this.videoKernel.setVideoScalingMode(i);
    }

    public void setVideoSeries(BasicVideoSeries series) {
        Intrinsics.checkNotNullParameter(series, "series");
        processOption(series);
        this.videoKernel.setVideoSeries(series, getOptionList());
        getOptionList().clear();
    }

    public final void setZOrderMediaOverlay(boolean z) {
        this.videoKernel.setZOrderMediaOverlay(z);
    }

    @Deprecated(message = "使用带切换模式的替换", replaceWith = @ReplaceWith(expression = "switchMediaSource(rank: Int, @ClaritySwitchMode mode: Int)", imports = {}))
    public final void switchMediaSource(int i) {
        this.videoKernel.switchMediaSource(i);
    }

    public final void syncStatus(PlayerStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.videoKernel.getVideoSession().statusChangeNotify(status);
    }

    public final void updateFreeProxy(String str) {
        this.videoKernel.updateFreeProxy(str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseKernelLayer(String kernelType) {
        this(r2);
        Intrinsics.checkNotNullParameter(kernelType, "kernelType");
        AbsVideoKernel obtain = VideoKernelPool.getInstance().obtain(kernelType);
        Intrinsics.checkNotNullExpressionValue(obtain, "getInstance().obtain(kernelType)");
    }

    private final Dispatcher getInternalEventDispatcher() {
        return (Dispatcher) this.internalEventDispatcher$delegate.getValue();
    }

    private final HashMap<String, String> getOptionList() {
        return (HashMap) this.optionList$delegate.getValue();
    }

    private final void requestAudioFocus() {
        BDVideoPlayer bindPlayer;
        BDVideoPlayer bindPlayer2 = getBindPlayer();
        boolean z = true;
        if (((bindPlayer2 == null || !bindPlayer2.isPlayerMute()) ? false : false) && (bindPlayer = getBindPlayer()) != null) {
            bindPlayer.requestAudioFocus();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void detachMessenger() {
        IMessenger messenger = getMessenger();
        if (messenger != null) {
            messenger.removeInternalDispatcher(getInternalEventDispatcher());
        }
        super.detachMessenger();
        this.videoKernel.unbindMessenger();
    }

    public final boolean getAcceptVolumeChange() {
        return this.acceptVolumeChange;
    }

    public final int getBufferingPosition() {
        return this.videoKernel.getBufferingPosition();
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public View getContentView() {
        return this.videoKernel.getBVideoView();
    }

    public final int getDecodeMode() {
        return this.videoKernel.getDecodeMode();
    }

    public final int getDuration() {
        return this.videoKernel.getDuration();
    }

    public final int getDurationMs() {
        return this.videoKernel.getDurationMs();
    }

    public final StringArrayBundle getExtraBundle() {
        return (StringArrayBundle) this.extraBundle$delegate.getValue();
    }

    public IKernelGestureDetector getGestureDetector() {
        return this.gestureDetector;
    }

    public final Map<String, String> getKernelInfo() {
        return this.videoKernel.getKernelInfo();
    }

    public final KernelMediaInfo getKernelMediaInfo() {
        return this.videoKernel.getKernelMediaInfo();
    }

    public final int getPosition() {
        return this.videoKernel.getPosition();
    }

    public final int getPositionMs() {
        return this.videoKernel.getPositionMs();
    }

    public final String getServerIpInfo() {
        return this.videoKernel.getServerIpInfo();
    }

    public final PlayerStatus getStatus() {
        PlayerStatus status = this.videoKernel.getStatus();
        Intrinsics.checkNotNullExpressionValue(status, "videoKernel.status");
        return status;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{4, 3, 1, 2, 5};
    }

    public final int getSyncPositionMs() {
        return this.videoKernel.getSyncPositionMs();
    }

    public final String getVid() {
        String vid = this.videoKernel.getVideoUrlModel().getVid();
        if (vid == null) {
            return "";
        }
        return vid;
    }

    public final int getVideoHeight() {
        return this.videoKernel.getVideoHeight();
    }

    public final AbsVideoKernel getVideoKernel() {
        return this.videoKernel;
    }

    public final VideoSession getVideoSession() {
        VideoSession videoSession = this.videoKernel.getVideoSession();
        Intrinsics.checkNotNullExpressionValue(videoSession, "videoKernel.videoSession");
        return videoSession;
    }

    public final String getVideoUrl() {
        String videoUrl = this.videoKernel.getVideoUrl();
        if (videoUrl == null) {
            return "";
        }
        return videoUrl;
    }

    public final VideoUrlModel getVideoUrlModel() {
        VideoUrlModel videoUrlModel = this.videoKernel.getVideoUrlModel();
        Intrinsics.checkNotNullExpressionValue(videoUrlModel, "videoKernel.getVideoUrlModel<VideoUrlModel>()");
        return videoUrlModel;
    }

    public final int getVideoWidth() {
        return this.videoKernel.getVideoWidth();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        super.onLayerDetach();
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_KERNEL_LAYER_DETACH);
        obtainEvent.setPriority(1);
        obtainEvent.putExtra(9, this.videoKernel.getKernelType());
        sendEvent(obtainEvent);
        setGestureDetector(null);
        setLayerContainer(null);
    }

    public final void pause() {
        this.videoKernel.pause();
    }

    public final void prepare() {
        this.videoKernel.prepare();
    }

    public final void release() {
        if (this.videoKernel instanceof EmptyKernel) {
            return;
        }
        setKernelCallBack(null);
        AbsVideoKernel absVideoKernel = this.videoKernel;
        this.videoKernel = new EmptyKernel();
        VideoKernelPool.getInstance().recycle(absVideoKernel);
    }

    public final void resume() {
        this.videoKernel.resume();
    }

    public final void start() {
        this.videoKernel.start();
    }

    public void stop() {
        this.videoKernel.stop();
    }

    public final void stopPlayback() {
        this.videoKernel.stopPlayback();
    }

    public static /* synthetic */ void seekTo$default(BaseKernelLayer baseKernelLayer, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 1;
            }
            if ((i4 & 4) != 0) {
                i3 = 3;
            }
            baseKernelLayer.seekTo(i, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seekTo");
    }

    public static /* synthetic */ void seekToMs$default(BaseKernelLayer baseKernelLayer, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 1;
            }
            if ((i4 & 4) != 0) {
                i3 = 3;
            }
            baseKernelLayer.seekToMs(i, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seekToMs");
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -1929694922:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_RESUME)) {
                    resume();
                    return;
                }
                return;
            case -1106918114:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE)) {
                    prepare();
                    return;
                }
                return;
            case -1076076346:
                if (action.equals(ControlEvent.ACTION_SEEK_MS)) {
                    seekToMs$default(this, event.getIntExtra(5), event.getIntExtra(12, 3), 0, 4, null);
                    return;
                }
                return;
            case -502522037:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_STOP)) {
                    stop();
                    return;
                }
                return;
            case 745698331:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_START)) {
                    if (getContentView() != null) {
                        View contentView = getContentView();
                        Intrinsics.checkNotNull(contentView);
                        contentView.setVisibility(0);
                    }
                    start();
                    return;
                }
                return;
            case 1547340063:
                if (action.equals(ControlEvent.ACTION_SEEK)) {
                    seekToMs$default(this, event.getIntExtra(5) * 1000, event.getIntExtra(12, 3), 0, 4, null);
                    return;
                }
                return;
            case 1598355405:
                if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE)) {
                    pause();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent event) {
        BDVideoPlayer bindPlayer;
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -150198673) {
            boolean z = true;
            if (hashCode != -103262037) {
                if (hashCode == 1939755256 && action.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                    int intExtra = event.getIntExtra(19);
                    Object extra = event.getExtra(31);
                    if (!(extra instanceof BasicVideoSeries)) {
                        extra = null;
                    }
                    BasicVideoSeries basicVideoSeries = (BasicVideoSeries) extra;
                    if (basicVideoSeries != null) {
                        if (basicVideoSeries.getPlayUrl().length() <= 0) {
                            z = false;
                        }
                        if (z) {
                            changePlayUrl(basicVideoSeries);
                            seekTo$default(this, intExtra, 0, 0, 6, null);
                        }
                    }
                }
            } else if (action.equals(LayerEvent.ACTION_SEEK)) {
                seekTo$default(this, event.getIntExtra(1), event.getIntExtra(37, 1), 0, 4, null);
                requestAudioFocus();
                resume();
            }
        } else if (action.equals(LayerEvent.ACTION_CLICK_NET_TIP) && (bindPlayer = getBindPlayer()) != null) {
            bindPlayer.doPlay();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        switch (action.hashCode()) {
            case -882902390:
                if (action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    Object extra = event.getExtra(3);
                    if (!(extra instanceof BasicVideoSeries)) {
                        extra = null;
                    }
                    BasicVideoSeries basicVideoSeries = (BasicVideoSeries) extra;
                    if (basicVideoSeries != null) {
                        setVideoSeries(basicVideoSeries);
                        return;
                    }
                    return;
                }
                return;
            case -525235558:
                if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                    this.videoKernel.onPrepared();
                    return;
                }
                return;
            case -461848373:
                if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                    this.videoKernel.onError();
                    return;
                }
                return;
            case 154871702:
                if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    this.videoKernel.onComplete();
                    return;
                }
                return;
            case 1370689931:
                if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                    this.videoKernel.onInfo(event.getIntExtra(1), event.getIntExtra(2), event.getExtra(3));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        super.onPlayerStatusChanged(playerStatus, playerStatus2);
        if (playerStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()];
        }
        if (i == 1 || i == 2 || i == 3) {
            getOptionList().clear();
        }
    }

    public final void setDynamicOption(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str != null) {
            this.videoKernel.setDynamicOption(key, str);
        }
    }

    public final void setExternalInfo(String str, Object obj) {
        this.videoKernel.setExternalInfo(str, obj);
    }

    public void setOption(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str != null) {
            if (!usePackageOptionMode()) {
                this.videoKernel.setOption(key, str);
            } else {
                getOptionList().put(key, str);
            }
        }
    }

    public final void setVideoFormatOptions(String str, HashMap<String, String> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.videoKernel.setVideoFormatOptions(str, options);
    }

    public final void switchMediaSource(int i, int i2) {
        this.videoKernel.switchMediaSource(i, i2);
    }

    public final boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        return this.videoKernel.takeSnapshotAsync(onSnapShotFrameListener, f);
    }

    @JvmOverloads
    public void seekTo(int i, int i2, int i3) {
        seekToMs(i * 1000, i2, i3);
    }

    @JvmOverloads
    public void seekToMs(int i, int i2, int i3) {
        int i4;
        int durationMs = this.videoKernel.getDurationMs();
        if (durationMs > i2 && i > (i4 = durationMs - i2)) {
            i = i4;
        }
        this.videoKernel.seekToMs(i, i3);
    }
}
