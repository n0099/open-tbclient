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
/* loaded from: classes5.dex */
public class MediaPlayerProxy extends PlayerProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaPlayerProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public GLTextureView mGLTextureView;
    public MediaPlayer mMediaPlayer;
    public long mPrepareTime;
    public long mStartTimeMs;

    /* renamed from: com.baidu.searchbox.afx.proxy.MediaPlayerProxy$6  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1435795369, "Lcom/baidu/searchbox/afx/proxy/MediaPlayerProxy$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1435795369, "Lcom/baidu/searchbox/afx/proxy/MediaPlayerProxy$6;");
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

    public MediaPlayerProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPrepareTime = -1L;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaPlayerProxy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                    this.this$0.mMediaPlayer.stop();
                    MediaPlayerProxy.super.stop();
                    if (this.this$0.mGLTextureView != null) {
                        this.this$0.mGLTextureView.post(new Runnable(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mGLTextureView == null) {
                                    return;
                                }
                                this.this$1.this$0.mGLTextureView.setRenderMode(0);
                            }
                        });
                    }
                    if (this.this$0.mOnReportListener != null) {
                        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                        String valueOf2 = String.valueOf(this.this$0.mPrepareTime / 1000);
                        MediaPlayerProxy mediaPlayerProxy = this.this$0;
                        mediaPlayerProxy.mOnReportListener.onSuccess(new PlaySuccessInfo(mediaPlayerProxy.mSourcePath, valueOf, valueOf2));
                    }
                }
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaPlayerProxy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i4, i5)) == null) {
                    String valueOf = mediaPlayer2 != null ? String.valueOf(mediaPlayer2.getCurrentPosition()) : "-1";
                    String glVersion = this.this$0.getGlVersion();
                    String sourcePath = this.this$0.getSourcePath();
                    String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
                    RuntimeException runtimeException = new RuntimeException("MediaPlayer Error (" + i4 + "," + i5 + SmallTailInfo.EMOTION_SUFFIX);
                    OnReportListener onReportListener = this.this$0.mOnReportListener;
                    if (onReportListener != null) {
                        onReportListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
                    }
                    OnVideoErrorListener onVideoErrorListener = this.this$0.mOnVideoErrorListener;
                    return onVideoErrorListener != null && onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.MEDIAPLAYER_DECODING_ERROR_ERRORMSG, runtimeException, valueOf, glVersion, sourcePath, valueOf2));
                }
                return invokeLII.booleanValue;
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaPlayerProxy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i4, int i5) {
                InterceptResult invokeLII;
                OnVideoStartedListener onVideoStartedListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i4, i5)) == null) {
                    if (i4 == 3 && (onVideoStartedListener = this.this$0.mOnVideoStartedListener) != null) {
                        onVideoStartedListener.onVideoStarted();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGlVersion() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65545, this, onPreparedListener) == null) || this.mMediaPlayer == null) {
            return;
        }
        if (isNotPrepared() || isStopped()) {
            this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
            try {
                this.mMediaPlayer.prepareAsync();
                this.mPlayerState = PlayerProxy.PlayerState.PREPARING;
            } catch (IllegalStateException e2) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e2, "-1", null, getSourcePath(), valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(2, ErrorInfo.OPENGL_ENVIRONMENT_ERROR_ERRORMSG, e2, "-1", null, getSourcePath(), valueOf));
                }
                throw e2;
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
        mediaPlayer.release();
        this.mMediaPlayer = null;
        this.mGLTextureView = null;
        super.destroy();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public MediaPlayer getMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMediaPlayer : (MediaPlayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mMediaPlayer != null && isPlaying()) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mMediaPlayer == null) {
            return;
        }
        try {
            int i2 = AnonymousClass6.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                prepareAsync(new MediaPlayer.OnPreparedListener(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.4
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
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer) == null) {
                            MediaPlayerProxy mediaPlayerProxy = this.this$0;
                            mediaPlayerProxy.mPlayerState = PlayerProxy.PlayerState.PREPARED;
                            if (mediaPlayerProxy.mGLTextureView != null) {
                                this.this$0.mGLTextureView.setRenderMode(1);
                            }
                            this.this$0.mPrepareTime = System.currentTimeMillis();
                            this.this$0.mMediaPlayer.start();
                            MediaPlayerProxy.super.play();
                        }
                    }
                });
            } else if (i2 == 3 || i2 == 4) {
                if (this.mGLTextureView != null) {
                    this.mGLTextureView.setRenderMode(1);
                }
                this.mMediaPlayer.start();
                super.play();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            String glVersion = getGlVersion();
            String sourcePath = getSourcePath();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            OnReportListener onReportListener = this.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e2, "-1", glVersion, sourcePath, valueOf));
            }
            OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                onVideoErrorListener.onError(new ErrorInfo(1, ErrorInfo.MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG, e2, "-1", glVersion, sourcePath, valueOf));
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mMediaPlayer == null || isDestroyed()) {
            return;
        }
        this.mMediaPlayer.reset();
        super.reset();
    }

    public void seekTo(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gLTextureView) == null) {
            this.mGLTextureView = gLTextureView;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fileDescriptor) == null) {
            try {
                reset();
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setDataSource(fileDescriptor);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, surface) == null) || (mediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mediaPlayer.setSurface(surface);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.mMediaPlayer == null) {
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
                gLTextureView.post(new Runnable(this) { // from class: com.baidu.searchbox.afx.proxy.MediaPlayerProxy.5
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
    public void setSourceFD(FileDescriptor fileDescriptor, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                reset();
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setDataSource(fileDescriptor, j2, j3);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
