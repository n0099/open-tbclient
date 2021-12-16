package com.baidu.searchbox.afx.proxy;

import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoPreparedListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.decode.SpeedControl;
import com.baidu.searchbox.afx.decode.VideoPlayer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.PlayerProxy;
import com.baidu.searchbox.afx.recode.Mp4Composer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes10.dex */
public class VideoPlayerProxy extends PlayerProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VideoPlayerProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public final VideoPlayer.PlayTask mPlayTask;
    public final VideoPlayer mVideoPlayer;

    /* renamed from: com.baidu.searchbox.afx.proxy.VideoPlayerProxy$6  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110219264, "Lcom/baidu/searchbox/afx/proxy/VideoPlayerProxy$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(110219264, "Lcom/baidu/searchbox/afx/proxy/VideoPlayerProxy$6;");
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
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[PlayerProxy.PlayerState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public VideoPlayerProxy() {
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
        VideoPlayer videoPlayer = new VideoPlayer();
        this.mVideoPlayer = videoPlayer;
        videoPlayer.setFrameCallback(new SpeedControl());
        this.mVideoPlayer.setOnInfoListener(new VideoPlayer.OnInfoListener(this) { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoPlayerProxy this$0;

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

            @Override // com.baidu.searchbox.afx.decode.VideoPlayer.OnInfoListener
            public boolean onInfo(VideoPlayer videoPlayer2, int i4, int i5) {
                InterceptResult invokeLII;
                OnVideoStartedListener onVideoStartedListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, videoPlayer2, i4, i5)) == null) {
                    if (i4 == 3 && (onVideoStartedListener = this.this$0.mOnVideoStartedListener) != null) {
                        onVideoStartedListener.onVideoStarted();
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        });
        this.mPlayTask = new VideoPlayer.PlayTask(this.mVideoPlayer, new OnVideoEndedListener(this) { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoPlayerProxy this$0;

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

            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    VideoPlayerProxy videoPlayerProxy = this.this$0;
                    videoPlayerProxy.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                    OnVideoEndedListener onVideoEndedListener = videoPlayerProxy.mOnVideoEndedListener;
                    if (onVideoEndedListener != null) {
                        onVideoEndedListener.onVideoEnded();
                    }
                }
            }
        }, new OnVideoErrorListener(this) { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoPlayerProxy this$0;

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

            @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
            public boolean onError(ErrorInfo errorInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, errorInfo)) == null) {
                    VideoPlayerProxy videoPlayerProxy = this.this$0;
                    videoPlayerProxy.mPlayerState = PlayerProxy.PlayerState.STOPPED;
                    OnVideoErrorListener onVideoErrorListener = videoPlayerProxy.mOnVideoErrorListener;
                    return onVideoErrorListener != null && onVideoErrorListener.onError(errorInfo);
                }
                return invokeL.booleanValue;
            }
        }, new OnReportListener(this) { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoPlayerProxy this$0;

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

            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onError(ErrorInfo errorInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, errorInfo) == null) {
                    VideoPlayerProxy videoPlayerProxy = this.this$0;
                    if (videoPlayerProxy.mOnReportListener == null || errorInfo == null) {
                        return;
                    }
                    errorInfo.mFilePath = videoPlayerProxy.getSourcePath();
                    if (this.this$0.mVideoPlayer != null) {
                        errorInfo.mGlVersion = this.this$0.mVideoPlayer.getGlVersion();
                    }
                    this.this$0.mOnReportListener.onError(errorInfo);
                }
            }

            @Override // com.baidu.searchbox.afx.callback.OnReportListener
            public void onSuccess(PlaySuccessInfo playSuccessInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playSuccessInfo) == null) {
                    VideoPlayerProxy videoPlayerProxy = this.this$0;
                    if (videoPlayerProxy.mOnReportListener != null) {
                        if (playSuccessInfo != null) {
                            playSuccessInfo.mFilePath = videoPlayerProxy.getSourcePath();
                        }
                        this.this$0.mOnReportListener.onSuccess(playSuccessInfo);
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayer = this.mVideoPlayer) == null || this.mPlayTask == null) {
            return;
        }
        videoPlayer.release();
        this.mPlayTask.release();
        super.destroy();
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if (videoPlayer == null) {
                return 0L;
            }
            return videoPlayer.getDuration();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoPlayer videoPlayer = this.mVideoPlayer;
            if (videoPlayer == null) {
                return 0;
            }
            return videoPlayer.getFps();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mVideoPlayer != null && isPlaying()) {
            this.mVideoPlayer.requestPause();
            super.pause();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = AnonymousClass6.$SwitchMap$com$baidu$searchbox$afx$proxy$PlayerProxy$PlayerState[this.mPlayerState.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                VideoPlayer.PlayTask playTask = this.mPlayTask;
                if (playTask != null) {
                    playTask.execute();
                }
            } else if (i2 == 4) {
                resume();
            }
            super.play();
        }
    }

    public void prepareAsync(String str, OnVideoPreparedListener onVideoPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, onVideoPreparedListener) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            File parentFile = file.getParentFile();
            new Mp4Composer().start(str, new File(parentFile, file.getName().replace(".mp4", "") + "_processed.mp4").getPath(), new Mp4Composer.Listener(this, currentTimeMillis, onVideoPreparedListener) { // from class: com.baidu.searchbox.afx.proxy.VideoPlayerProxy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoPlayerProxy this$0;
                public final /* synthetic */ OnVideoPreparedListener val$onPreparedListener;
                public final /* synthetic */ long val$startMs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(currentTimeMillis), onVideoPreparedListener};
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
                    this.val$startMs = currentTimeMillis;
                    this.val$onPreparedListener = onVideoPreparedListener;
                }

                @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
                public void onCompleted() {
                    OnVideoPreparedListener onVideoPreparedListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (onVideoPreparedListener2 = this.val$onPreparedListener) == null) {
                        return;
                    }
                    onVideoPreparedListener2.onPrepared();
                }

                @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
                public void onFailed(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    }
                }

                @Override // com.baidu.searchbox.afx.recode.Mp4Composer.Listener
                public void onProgress(float f2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mVideoPlayer != null && isPaused()) {
            this.mVideoPlayer.requestResume();
            super.resume();
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setGLTextureView(GLTextureView gLTextureView) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gLTextureView) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setGLTextureView(gLTextureView);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j2, long j3) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setLoopSection(j2, j3);
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLooping(boolean z) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fileDescriptor) == null) {
            try {
                if (this.mVideoPlayer != null) {
                    this.mVideoPlayer.setDataSource(fileDescriptor);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSurface(Surface surface) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, surface) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setSurface(surface);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.mVideoPlayer == null) {
            return;
        }
        if (isPlaying() || isPaused()) {
            this.mVideoPlayer.requestStop();
            this.mPlayerState = PlayerProxy.PlayerState.STOPPED;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j2) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setLoopSection(j2);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy
    public void setSourceFD(FileDescriptor fileDescriptor, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                if (this.mVideoPlayer != null) {
                    this.mVideoPlayer.setDataSource(fileDescriptor, j2, j3);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i2, int i3) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setLoopSection(i2, i3);
    }

    @Override // com.baidu.searchbox.afx.proxy.PlayerProxy, com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i2) {
        VideoPlayer videoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (videoPlayer = this.mVideoPlayer) == null) {
            return;
        }
        videoPlayer.setLoopSection(i2);
    }
}
