package com.baidu.searchbox.afx.proxy;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class MediaPlayerProxy extends PlayerProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaPlayerProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCompletion;
    public GLTextureView mGLTextureView;
    public boolean mIsLooping;
    public MediaPlayer mMediaPlayer;
    public long mPrepareTime;
    public long mStartTimeMs;

    /* renamed from: com.baidu.searchbox.afx.proxy.MediaPlayerProxy$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1435795245, "Lcom/baidu/searchbox/afx/proxy/MediaPlayerProxy$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1435795245, "Lcom/baidu/searchbox/afx/proxy/MediaPlayerProxy$2;");
                    return;
                }
            }
            int[] iArr = new int[PlayerProxy.PlayerState.values().length];
            $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState = iArr;
            try {
                iArr[PlayerProxy.PlayerState.NOT_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.STOPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PREPARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class OnCompletionListener implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnCompletionListener(MediaPlayerProxy mediaPlayerProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaPlayerProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayerProxy mediaPlayerProxy;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || (mediaPlayerProxy = this.mPlayerProxyRef.get()) == null || mediaPlayerProxy.mMediaPlayer == null) {
                return;
            }
            mediaPlayerProxy.mCompletion = true;
            mediaPlayerProxy.mMediaPlayer.stop();
            mediaPlayerProxy.callSuperStop();
            if (mediaPlayerProxy.mGLTextureView != null) {
                mediaPlayerProxy.mGLTextureView.post(new Runnable(this, mediaPlayerProxy) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.OnCompletionListener.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OnCompletionListener this$0;
                    public final /* synthetic */ MediaPlayerProxy val$playerProxy;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mediaPlayerProxy};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$playerProxy = mediaPlayerProxy;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.val$playerProxy.mGLTextureView == null) {
                            return;
                        }
                        this.val$playerProxy.mGLTextureView.setRenderMode(0);
                    }
                });
            }
            if (mediaPlayerProxy.mOnReportListener != null) {
                mediaPlayerProxy.mOnReportListener.onSuccess(new PlaySuccessInfo(mediaPlayerProxy.mSourcePath, String.valueOf(System.currentTimeMillis() / 1000), String.valueOf(mediaPlayerProxy.mPrepareTime / 1000)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class OnErrorListener implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnErrorListener(MediaPlayerProxy mediaPlayerProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaPlayerProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
                if (mediaPlayerProxy == null) {
                    return true;
                }
                String valueOf = mediaPlayer != null ? String.valueOf(mediaPlayer.getCurrentPosition()) : "-1";
                String glVersion = mediaPlayerProxy.getGlVersion();
                String sourcePath = mediaPlayerProxy.getSourcePath();
                String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
                RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i + "," + i2 + SmallTailInfo.EMOTION_SUFFIX);
                OnReportListener onReportListener = mediaPlayerProxy.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
                }
                OnVideoErrorListener onVideoErrorListener = mediaPlayerProxy.mOnVideoErrorListener;
                return onVideoErrorListener != null && onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class OnInfoListener implements MediaPlayer.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnInfoListener(MediaPlayerProxy mediaPlayerProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaPlayerProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            OnVideoStartedListener onVideoStartedListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                MediaPlayerProxy mediaPlayerProxy = this.mPlayerProxyRef.get();
                if (mediaPlayerProxy == null) {
                    return true;
                }
                if (i == 3 && (onVideoStartedListener = mediaPlayerProxy.mOnVideoStartedListener) != null) {
                    onVideoStartedListener.onVideoStarted();
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class OnPrepareListener implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<MediaPlayerProxy> mPlayerProxyRef;

        public OnPrepareListener(MediaPlayerProxy mediaPlayerProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaPlayerProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPlayerProxyRef = new WeakReference<>(mediaPlayerProxy);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayerProxy mediaPlayerProxy;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || (mediaPlayerProxy = this.mPlayerProxyRef.get()) == null || mediaPlayerProxy.mMediaPlayer == null) {
                return;
            }
            mediaPlayerProxy.mPlayerState = PlayerProxy.PlayerState.PREPARED;
            if (mediaPlayerProxy.mGLTextureView != null) {
                mediaPlayerProxy.mGLTextureView.setRenderMode(1);
            }
            mediaPlayerProxy.mPrepareTime = System.currentTimeMillis();
            try {
                mediaPlayerProxy.mMediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayerProxy.checkLooping();
            mediaPlayerProxy.callSuperPlay();
        }
    }

    public MediaPlayerProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPrepareTime = -1L;
        this.mCompletion = false;
        this.mIsLooping = false;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new OnCompletionListener(this));
        this.mMediaPlayer.setOnErrorListener(new OnErrorListener(this));
        this.mMediaPlayer.setOnInfoListener(new OnInfoListener(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSuperPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            super.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSuperStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            super.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLooping() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        boolean isLooping = mediaPlayer.isLooping();
        boolean z = this.mIsLooping;
        if (isLooping != z) {
            this.mMediaPlayer.setLooping(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGlVersion() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView == null || (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
                return null;
            }
            return deviceConfigurationInfo.getGlEsVersion();
        }
        return (String) invokeV.objValue;
    }

    private void prepareAsync(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, onPreparedListener) == null) || this.mMediaPlayer == null) {
            return;
        }
        if (isNotPrepared() || isStopped()) {
            this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
            try {
                this.mMediaPlayer.prepareAsync();
                this.mPlayerState = PlayerProxy.PlayerState.PREPARING;
            } catch (IllegalStateException e) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e, "-1", null, getSourcePath(), valueOf));
                }
                throw e;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.reset();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        this.mGLTextureView = null;
        super.destroy();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mMediaPlayer == null || getState() == PlayerProxy.PlayerState.NOT_PREPARED) {
                return 0;
            }
            return this.mCompletion ? this.mMediaPlayer.getDuration() : this.mMediaPlayer.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                return 0L;
            }
            return mediaPlayer.getDuration();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public MediaPlayer getMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMediaPlayer : (MediaPlayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mMediaPlayer != null && isPlaying()) {
            this.mMediaPlayer.pause();
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView != null) {
                gLTextureView.setRenderMode(0);
            }
            super.pause();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mMediaPlayer == null) {
            return;
        }
        try {
            int i = AnonymousClass2.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
            if (i == 1 || i == 2) {
                prepareAsync(new OnPrepareListener(this));
            } else if (i == 3 || i == 4) {
                if (this.mGLTextureView != null) {
                    this.mGLTextureView.setRenderMode(1);
                }
                this.mMediaPlayer.start();
                super.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
            String glVersion = getGlVersion();
            String sourcePath = getSourcePath();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            OnReportListener onReportListener = this.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
            }
            OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                onVideoErrorListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e, "-1", glVersion, sourcePath, valueOf));
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.mMediaPlayer == null || isDestroyed()) {
            return;
        }
        this.mMediaPlayer.reset();
        super.reset();
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gLTextureView) == null) {
            this.mGLTextureView = gLTextureView;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        this.mIsLooping = z;
        mediaPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fileDescriptor) == null) {
            try {
                reset();
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setDataSource(fileDescriptor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, surface) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setSurface(surface);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.mMediaPlayer == null) {
            return;
        }
        if (isPlaying() || isPaused()) {
            if (Build.VERSION.SDK_INT <= 19) {
                seekTo(0);
            }
            this.mMediaPlayer.stop();
            super.stop();
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView != null) {
                gLTextureView.post(new Runnable(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mGLTextureView == null) {
                            return;
                        }
                        this.this$0.mGLTextureView.setRenderMode(0);
                    }
                });
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{fileDescriptor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                reset();
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setDataSource(fileDescriptor, j, j2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
