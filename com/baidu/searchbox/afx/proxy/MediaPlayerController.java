package com.baidu.searchbox.afx.proxy;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.WorkerThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.afx.LogUtilKt;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.MediaPlayerController;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0005MNOPQB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u0016H\u0003J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u0016H\u0003J\b\u0010'\u001a\u00020\u0016H\u0003J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0003J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\b\u0010,\u001a\u00020\u0016H\u0003J\b\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0012\u0010/\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0007H\u0016J\u0012\u00103\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u001c\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\"\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0014J\u0012\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u000205H\u0003J\u0010\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020<H\u0003J\u0010\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020AH\u0003J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u001dH\u0003J\b\u0010K\u001a\u00020\u0016H\u0003J\b\u0010L\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "Lcom/baidu/searchbox/afx/proxy/PlayerProxy;", "Landroid/os/Handler$Callback;", "()V", "duration", "", "isLooping", "", "isSurfaceCreated", "mCompletion", "mGLTextureView", "Lcom/baidu/searchbox/afx/gl/GLTextureView;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mPrepareTime", "mStartTimeMs", "mainHandler", "Landroid/os/Handler;", "playThread", "Landroid/os/HandlerThread;", "workHandler", "checkLooping", "", "destroy", "getCurrentPosition", "", "getDuration", "getFps", "getGlVersion", "", "getMessage", "Landroid/os/Message;", "what", "obj", "", "handleDestroy", "handleMessage", "msg", "handlePause", "handleStop", "initMediaPlayer", "initPlayer", DownloadStatisticConstants.UBC_TYPE_PAUSE, "play", "prepareAsync", "reset", "sendMessage", "setGLTextureView", "glTextureView", "setLooping", "looping", "setSourceAfd", "afd", "Landroid/content/res/AssetFileDescriptor;", "setSourceAssets", "context", "Landroid/content/Context;", "assetsFileName", "setSourceFD", "fd", "Ljava/io/FileDescriptor;", "offset", "length", "setSourceFile", "srcFile", "Ljava/io/File;", "setSurface", "surface", "Landroid/view/Surface;", "setVideoFD", "fileDescriptor", "setVideoFile", "file", "setVideoPath", "path", "startPlay", "stop", "Companion", "OnCompletionListener", "OnErrorListener", "OnInfoListener", "OnPrepareListener", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MediaPlayerController extends PlayerProxy implements Handler.Callback {
    public static final Companion Companion = new Companion(null);
    public static final int DESTROY = 7;
    public static final int INIT_MEDIA_PLAYER = 1;
    public static final int PAUSE = 4;
    public static final int RESET = 9;
    public static final int RESUME = 5;
    public static final int SET_DATA_SOURCE = 2;
    public static final int SET_LOOPING = 10;
    public static final int START = 3;
    public static final int STOP = 6;
    public static final int SURFACE_PREPARED = 8;
    public static final String TAG = "MediaPlayerController";
    public volatile long duration;
    public volatile boolean isLooping;
    public boolean isSurfaceCreated;
    public boolean mCompletion;
    public GLTextureView mGLTextureView;
    public MediaPlayer mMediaPlayer;
    public long mStartTimeMs;
    public HandlerThread playThread;
    public Handler workHandler;
    public long mPrepareTime = -1;
    public final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerProxy.PlayerState.values().length];
            iArr[PlayerProxy.PlayerState.PREPARED.ordinal()] = 1;
            iArr[PlayerProxy.PlayerState.PAUSED.ordinal()] = 2;
            iArr[PlayerProxy.PlayerState.NOT_PREPARED.ordinal()] = 3;
            iArr[PlayerProxy.PlayerState.STOPPED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        return 0;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController$Companion;", "", "()V", "DESTROY", "", "INIT_MEDIA_PLAYER", "PAUSE", "RESET", "RESUME", "SET_DATA_SOURCE", "SET_LOOPING", "START", "STOP", "SURFACE_PREPARED", "TAG", "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final MediaPlayerController get() {
            return new MediaPlayerController();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController$OnCompletionListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "controller", "Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "(Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;)V", "controllerRef", "Ljava/lang/ref/WeakReference;", "onCompletion", "", "mp", "Landroid/media/MediaPlayer;", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OnCompletionListener implements MediaPlayer.OnCompletionListener {
        public WeakReference<MediaPlayerController> controllerRef;

        public OnCompletionListener(MediaPlayerController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controllerRef = new WeakReference<>(controller);
        }

        /* renamed from: onCompletion$lambda-0  reason: not valid java name */
        public static final void m56onCompletion$lambda0(MediaPlayerController playerController, String timeStamp, String prepareTime) {
            Intrinsics.checkNotNullParameter(playerController, "$playerController");
            Intrinsics.checkNotNullParameter(timeStamp, "$timeStamp");
            Intrinsics.checkNotNullParameter(prepareTime, "$prepareTime");
            OnReportListener onReportListener = playerController.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onSuccess(new PlaySuccessInfo(playerController.mSourcePath, timeStamp, prepareTime));
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            LogUtilKt.logD(MediaPlayerController.TAG, "onCompletion;" + Thread.currentThread());
            final MediaPlayerController mediaPlayerController = this.controllerRef.get();
            if (mediaPlayerController != null && mediaPlayerController.mMediaPlayer != null) {
                mediaPlayerController.mCompletion = true;
                try {
                    mediaPlayerController.stop();
                } catch (Exception e) {
                    LogUtilKt.printException(e);
                }
                GLTextureView gLTextureView = mediaPlayerController.mGLTextureView;
                if (gLTextureView != null) {
                    gLTextureView.setRenderMode(0);
                }
                if (mediaPlayerController.mOnReportListener != null) {
                    long j = 1000;
                    final String valueOf = String.valueOf(System.currentTimeMillis() / j);
                    final String valueOf2 = String.valueOf(mediaPlayerController.mPrepareTime / j);
                    mediaPlayerController.mainHandler.post(new Runnable() { // from class: com.baidu.tieba.xg1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                MediaPlayerController.OnCompletionListener.m56onCompletion$lambda0(MediaPlayerController.this, valueOf, valueOf2);
                            }
                        }
                    });
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController$OnErrorListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "controller", "Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "(Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;)V", "controllerRef", "Ljava/lang/ref/WeakReference;", GameAssistConstKt.TYPE_CALLBACK_ERROR, "", "mp", "Landroid/media/MediaPlayer;", "what", "", "extra", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OnErrorListener implements MediaPlayer.OnErrorListener {
        public WeakReference<MediaPlayerController> controllerRef;

        public OnErrorListener(MediaPlayerController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controllerRef = new WeakReference<>(controller);
        }

        /* renamed from: onError$lambda-0  reason: not valid java name */
        public static final void m57onError$lambda0(MediaPlayerController playerController, RuntimeException exception, String endTime, String glVersion, String filePath, String timeStamp) {
            Intrinsics.checkNotNullParameter(playerController, "$playerController");
            Intrinsics.checkNotNullParameter(exception, "$exception");
            Intrinsics.checkNotNullParameter(endTime, "$endTime");
            Intrinsics.checkNotNullParameter(glVersion, "$glVersion");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            Intrinsics.checkNotNullParameter(timeStamp, "$timeStamp");
            OnReportListener onReportListener = playerController.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, exception, endTime, glVersion, filePath, timeStamp));
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            String str2;
            LogUtilKt.logE(MediaPlayerController.TAG, "onError:" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + WebvttCueParser.CHAR_SEMI_COLON + Thread.currentThread());
            final MediaPlayerController mediaPlayerController = this.controllerRef.get();
            if (mediaPlayerController == null) {
                return true;
            }
            String str3 = (mediaPlayer == null || (str3 = Integer.valueOf(mediaPlayer.getCurrentPosition()).toString()) == null) ? "-1" : "-1";
            String glVersion = mediaPlayerController.getGlVersion();
            if (glVersion == null) {
                str = "";
            } else {
                str = glVersion;
            }
            String sourcePath = mediaPlayerController.getSourcePath();
            if (sourcePath == null) {
                str2 = "";
            } else {
                str2 = sourcePath;
            }
            final String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            final RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i + ',' + i2 + ')');
            final String str4 = str3;
            final String str5 = str;
            final String str6 = str2;
            mediaPlayerController.mainHandler.post(new Runnable() { // from class: com.baidu.tieba.yg1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        MediaPlayerController.OnErrorListener.m57onError$lambda0(MediaPlayerController.this, runtimeException, str4, str5, str6, valueOf);
                    }
                }
            });
            OnVideoErrorListener onVideoErrorListener = mediaPlayerController.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                return onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, str3, str, str2, valueOf));
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController$OnInfoListener;", "Landroid/media/MediaPlayer$OnInfoListener;", "controller", "Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "(Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;)V", "controllerRef", "Ljava/lang/ref/WeakReference;", "onInfo", "", "mp", "Landroid/media/MediaPlayer;", "what", "", "extra", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OnInfoListener implements MediaPlayer.OnInfoListener {
        public WeakReference<MediaPlayerController> controllerRef;

        public OnInfoListener(MediaPlayerController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controllerRef = new WeakReference<>(controller);
        }

        /* renamed from: onInfo$lambda-0  reason: not valid java name */
        public static final void m58onInfo$lambda0(MediaPlayerController playerController) {
            Intrinsics.checkNotNullParameter(playerController, "$playerController");
            OnVideoStartedListener onVideoStartedListener = playerController.mOnVideoStartedListener;
            if (onVideoStartedListener != null) {
                onVideoStartedListener.onVideoStarted();
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtilKt.logD(MediaPlayerController.TAG, "onInfo:" + i + ',' + i2 + WebvttCueParser.CHAR_SEMI_COLON + Thread.currentThread());
            final MediaPlayerController mediaPlayerController = this.controllerRef.get();
            if (mediaPlayerController == null) {
                return true;
            }
            if (i == 3) {
                mediaPlayerController.mainHandler.post(new Runnable() { // from class: com.baidu.tieba.wg1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            MediaPlayerController.OnInfoListener.m58onInfo$lambda0(MediaPlayerController.this);
                        }
                    }
                });
                return false;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/afx/proxy/MediaPlayerController$OnPrepareListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "controller", "Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;", "(Lcom/baidu/searchbox/afx/proxy/MediaPlayerController;)V", "controllerRef", "Ljava/lang/ref/WeakReference;", "onPrepared", "", "mp", "Landroid/media/MediaPlayer;", "library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OnPrepareListener implements MediaPlayer.OnPreparedListener {
        public WeakReference<MediaPlayerController> controllerRef;

        public OnPrepareListener(MediaPlayerController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controllerRef = new WeakReference<>(controller);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mp) {
            Intrinsics.checkNotNullParameter(mp, "mp");
            MediaPlayerController mediaPlayerController = this.controllerRef.get();
            if (mediaPlayerController == null || mediaPlayerController.mMediaPlayer == null) {
                return;
            }
            mediaPlayerController.mPlayerState = PlayerProxy.PlayerState.PREPARED;
            mediaPlayerController.duration = mp.getDuration();
            LogUtilKt.logD(MediaPlayerController.TAG, "setOnPreparedListener-onPrepared:" + mp + ',' + mp.getDuration() + WebvttCueParser.CHAR_SEMI_COLON + Thread.currentThread());
            GLTextureView gLTextureView = mediaPlayerController.mGLTextureView;
            if (gLTextureView != null) {
                gLTextureView.setRenderMode(1);
            }
            mediaPlayerController.mPrepareTime = System.currentTimeMillis();
            mediaPlayerController.startPlay();
        }
    }

    public MediaPlayerController() {
        HandlerThread handlerThread = new HandlerThread("afx-play-thread");
        this.playThread = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.workHandler = new Handler(handlerThread.getLooper(), this);
        }
        initMediaPlayer();
    }

    @WorkerThread
    private final void checkLooping() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isLooping() != this.isLooping) {
            mediaPlayer.setLooping(this.isLooping);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGlVersion() {
        Object obj;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Context context;
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null && (context = gLTextureView.getContext()) != null) {
            obj = context.getSystemService("activity");
        } else {
            obj = null;
        }
        if (obj instanceof ActivityManager) {
            activityManager = (ActivityManager) obj;
        } else {
            activityManager = null;
        }
        if (activityManager == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    @WorkerThread
    private final void handleDestroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.mMediaPlayer = null;
        this.mGLTextureView = null;
        super.destroy();
        HandlerThread handlerThread = this.playThread;
        if (handlerThread != null) {
            handlerThread.quit();
            handlerThread.interrupt();
        }
    }

    @WorkerThread
    private final void handlePause() {
        if (!isPlaying()) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null) {
            gLTextureView.setRenderMode(0);
        }
        super.pause();
    }

    private final void initMediaPlayer() {
        sendMessage(getMessage(1, null));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        sendMessage(getMessage(7, null));
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || getState() == PlayerProxy.PlayerState.NOT_PREPARED) {
            return 0;
        }
        if (this.mCompletion) {
            return mediaPlayer.getDuration();
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        if (this.mMediaPlayer == null) {
            return 0L;
        }
        return this.duration;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        sendMessage(getMessage(4, null));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        sendMessage(getMessage(3, null));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void reset() {
        sendMessage(getMessage(9, null));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        sendMessage(getMessage(6, null));
    }

    private final void sendMessage(Message message) {
        HandlerThread handlerThread = this.playThread;
        if (handlerThread != null && handlerThread.isAlive() && !handlerThread.isInterrupted()) {
            if (this.workHandler == null) {
                this.workHandler = new Handler(handlerThread.getLooper(), this);
            }
            Handler handler = this.workHandler;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    @WorkerThread
    private final void setVideoFD(FileDescriptor fileDescriptor) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(fileDescriptor);
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
        LogUtilKt.logI(TAG, "setVideoFile FD, is surface created:" + this.isSurfaceCreated);
    }

    @WorkerThread
    private final void setVideoFile(File file) {
        try {
            FileDescriptor fd = new FileInputStream(file).getFD();
            Intrinsics.checkNotNullExpressionValue(fd, "fd");
            setVideoFD(fd);
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
    }

    @WorkerThread
    private final void setVideoPath(String str) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        sendMessage(getMessage(10, Boolean.valueOf(z)));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceAfd(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            return;
        }
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            setSourceFD(assetFileDescriptor.getFileDescriptor());
            return;
        }
        reset();
        sendMessage(getMessage(2, assetFileDescriptor));
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        reset();
        sendMessage(getMessage(2, fileDescriptor));
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        sendMessage(getMessage(8, surface));
    }

    private final Message getMessage(int i, Object obj) {
        Message message = Message.obtain();
        message.what = i;
        message.obj = obj;
        Intrinsics.checkNotNullExpressionValue(message, "message");
        return message;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceAssets(Context context, String str) {
        super.setSourceAssets(context, str);
    }

    @WorkerThread
    private final void handleStop() {
        MediaPlayer mediaPlayer;
        if (!isPlaying() && !isPaused()) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT <= 19 && (mediaPlayer = this.mMediaPlayer) != null) {
                mediaPlayer.seekTo(0);
            }
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.stop();
            }
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
        super.stop();
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null) {
            gLTextureView.setRenderMode(0);
        }
    }

    @WorkerThread
    private final void initPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(false);
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnErrorListener(new OnErrorListener(this));
        }
        MediaPlayer mediaPlayer3 = this.mMediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(new OnCompletionListener(this));
        }
        MediaPlayer mediaPlayer4 = this.mMediaPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnInfoListener(new OnInfoListener(this));
        }
        MediaPlayer mediaPlayer5 = this.mMediaPlayer;
        if (mediaPlayer5 != null) {
            mediaPlayer5.setOnPreparedListener(new OnPrepareListener(this));
        }
    }

    @WorkerThread
    private final void prepareAsync() {
        LogUtilKt.logD(TAG, "prepareAsync..:" + isNotPrepared() + StringUtil.ARRAY_ELEMENT_SEPARATOR + isStopped());
        if (this.mMediaPlayer != null) {
            if (isNotPrepared() || isStopped()) {
                try {
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.prepareAsync();
                    }
                    this.mPlayerState = PlayerProxy.PlayerState.PREPARING;
                    LogUtilKt.logD(TAG, "prepareAsync end..");
                } catch (IllegalStateException e) {
                    LogUtilKt.logD(TAG, "prepareAsync-IllegalStateException:" + e.getLocalizedMessage());
                    LogUtilKt.printException(e);
                    final String valueOf = String.valueOf(System.currentTimeMillis() / ((long) 1000));
                    this.mainHandler.post(new Runnable() { // from class: com.baidu.tieba.zg1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                MediaPlayerController.m55prepareAsync$lambda2(MediaPlayerController.this, e, valueOf);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: prepareAsync$lambda-2  reason: not valid java name */
    public static final void m55prepareAsync$lambda2(MediaPlayerController this$0, IllegalStateException e, String timeStamp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "$e");
        Intrinsics.checkNotNullParameter(timeStamp, "$timeStamp");
        OnReportListener onReportListener = this$0.mOnReportListener;
        if (onReportListener != null) {
            onReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, this$0.getSourcePath(), timeStamp));
        }
        OnVideoErrorListener onVideoErrorListener = this$0.mOnVideoErrorListener;
        if (onVideoErrorListener != null) {
            onVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, this$0.getSourcePath(), timeStamp));
        }
    }

    @WorkerThread
    private final void setVideoFD(AssetFileDescriptor assetFileDescriptor) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } catch (Exception e) {
            LogUtilKt.printException(e);
        }
        LogUtilKt.logI(TAG, "setVideoFile AFD, is surface created:" + this.isSurfaceCreated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void startPlay() {
        int i;
        LogUtilKt.logD(TAG, "startPlay: " + this.mPlayerState);
        checkLooping();
        PlayerProxy.PlayerState playerState = this.mPlayerState;
        if (playerState == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[playerState.ordinal()];
        }
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4) {
                try {
                    prepareAsync();
                    return;
                } catch (Exception e) {
                    LogUtilKt.printException(e);
                    return;
                }
            }
            return;
        }
        try {
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView != null) {
                gLTextureView.setRenderMode(1);
            }
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            this.mPlayerState = PlayerProxy.PlayerState.PLAYING;
        } catch (Exception e2) {
            LogUtilKt.printException(e2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(msg, "msg");
        LogUtilKt.logD(TAG, "handleMessage:" + msg.what);
        switch (msg.what) {
            case 1:
                initPlayer();
                break;
            case 2:
                Object obj = msg.obj;
                if (obj instanceof File) {
                    setVideoFile((File) obj);
                    break;
                } else if (obj instanceof String) {
                    setVideoPath((String) obj);
                    break;
                } else if (obj instanceof FileDescriptor) {
                    setVideoFD((FileDescriptor) obj);
                    break;
                } else if (obj instanceof AssetFileDescriptor) {
                    setVideoFD((AssetFileDescriptor) obj);
                    break;
                }
                break;
            case 3:
                startPlay();
                break;
            case 4:
                handlePause();
                break;
            case 5:
                startPlay();
                break;
            case 6:
                handleStop();
                break;
            case 7:
                handleDestroy();
                break;
            case 8:
                this.isSurfaceCreated = true;
                Object obj2 = msg.obj;
                if (obj2 != null) {
                    Surface surface = (Surface) obj2;
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.setSurface(surface);
                        break;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
                }
                break;
            case 9:
                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.reset();
                    super.reset();
                    break;
                }
                break;
            case 10:
                Object obj3 = msg.obj;
                if (obj3 instanceof Boolean) {
                    bool = (Boolean) obj3;
                } else {
                    bool = null;
                }
                if (bool == null) {
                    return true;
                }
                boolean booleanValue = bool.booleanValue();
                MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                if (mediaPlayer3 != null) {
                    this.isLooping = booleanValue;
                    mediaPlayer3.setLooping(booleanValue);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceFile(File file) {
        if (file != null) {
            this.mSourcePath = file.getPath();
            reset();
            sendMessage(getMessage(2, file));
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        OnReportListener onReportListener = this.mOnReportListener;
        if (onReportListener != null) {
            onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
        }
        OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
        if (onVideoErrorListener != null) {
            onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
        }
    }
}
