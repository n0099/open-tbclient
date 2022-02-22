package com.baidu.searchbox.afx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.gl.AlphaVideoRenderer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.IPlayer;
import com.baidu.searchbox.afx.proxy.VideoPlayerProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes11.dex */
public class AlphaVideo extends GLTextureView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GL_CONTEXT_VERSION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public AlphaVideoRenderer mAlphaVideoRenderer;
    public boolean mIsKeepLastFrame;
    public volatile boolean mIsPlayRequested;
    public volatile boolean mIsSurfacePrepared;
    public IPlayer mPlayer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaVideo(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
        this.mPlayer = videoPlayerProxy;
        videoPlayerProxy.setGLTextureView(this);
        this.mIsKeepLastFrame = false;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            setEGLContextClientVersion(2);
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            initRenderer();
            bringToFront();
            setPreserveEGLContextOnPause(true);
            setOpaque(false);
            initReport();
        }
    }

    private void initRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            AlphaVideoRenderer alphaVideoRenderer = new AlphaVideoRenderer();
            this.mAlphaVideoRenderer = alphaVideoRenderer;
            alphaVideoRenderer.setOnSurfacePrepareListener(new AlphaVideoRenderer.OnSurfacePrepareListener(this) { // from class: com.baidu.searchbox.afx.AlphaVideo.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlphaVideo this$0;

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

                @Override // com.baidu.searchbox.afx.gl.AlphaVideoRenderer.OnSurfacePrepareListener
                public void onSurfacePrepared(Surface surface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                        if (this.this$0.mPlayer != null) {
                            this.this$0.mPlayer.setSurface(surface);
                        }
                        this.this$0.mIsSurfacePrepared = true;
                        if (this.this$0.mIsPlayRequested) {
                            this.this$0.mIsPlayRequested = false;
                            if (this.this$0.mPlayer != null) {
                                this.this$0.mPlayer.play();
                                if (this.this$0.mAlphaVideoRenderer != null) {
                                    this.this$0.mAlphaVideoRenderer.onPlay();
                                }
                            }
                        }
                    }
                }
            });
            setRenderer(this.mAlphaVideoRenderer);
            setRenderMode(0);
        }
    }

    private void initReport() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setOnReportListener(AlphaVideoManager.getOnReportListener());
        }
    }

    public void destroy() {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.destroy();
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            if (iPlayer != null) {
                return iPlayer.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            if (iPlayer != null) {
                return iPlayer.getFps();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            return iPlayer != null && iPlayer.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            return iPlayer != null && iPlayer.isPaused();
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            return iPlayer != null && iPlayer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public boolean isStopped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            IPlayer iPlayer = this.mPlayer;
            return iPlayer != null && iPlayer.isStopped();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }

    public void pause() {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.pause();
    }

    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.mIsSurfacePrepared) {
                IPlayer iPlayer = this.mPlayer;
                if (iPlayer != null) {
                    iPlayer.play();
                    AlphaVideoRenderer alphaVideoRenderer = this.mAlphaVideoRenderer;
                    if (alphaVideoRenderer != null) {
                        alphaVideoRenderer.onPlay();
                        return;
                    }
                    return;
                }
                return;
            }
            this.mIsPlayRequested = true;
        }
    }

    public void setDarkFilter(float f2) {
        AlphaVideoRenderer alphaVideoRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f2) == null) || (alphaVideoRenderer = this.mAlphaVideoRenderer) == null) {
            return;
        }
        alphaVideoRenderer.setDarkFilter(f2);
    }

    public void setKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsKeepLastFrame = z;
        }
    }

    public void setLoopSection(long j2, long j3) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setLoopSection(j2, j3);
    }

    public void setLooping(boolean z) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setLooping(z);
    }

    public void setOnReportListener(OnReportListener onReportListener) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onReportListener) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setOnReportListener(onReportListener);
    }

    public void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, onVideoEndedListener) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setOnVideoEndedListener(new OnVideoEndedListener(this, onVideoEndedListener) { // from class: com.baidu.searchbox.afx.AlphaVideo.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlphaVideo this$0;
            public final /* synthetic */ OnVideoEndedListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, onVideoEndedListener};
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
                this.val$listener = onVideoEndedListener;
            }

            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public void onVideoEnded() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mAlphaVideoRenderer != null && !this.this$0.mIsKeepLastFrame) {
                        this.this$0.mAlphaVideoRenderer.clearLastFrame();
                    }
                    OnVideoEndedListener onVideoEndedListener2 = this.val$listener;
                    if (onVideoEndedListener2 != null) {
                        onVideoEndedListener2.onVideoEnded();
                    }
                }
            }
        });
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onVideoErrorListener) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setOnVideoErrorListener(onVideoErrorListener);
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onVideoStartedListener) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setOnVideoStartedListener(onVideoStartedListener);
    }

    public void setPlayer(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iPlayer) == null) {
            this.mPlayer = iPlayer;
            if (iPlayer != null) {
                iPlayer.setGLTextureView(this);
            }
            initReport();
        }
    }

    public void setSourceAssets(String str) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setSourceAssets(getContext(), str);
    }

    public void setSourceFile(File file) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, file) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setSourceFile(file);
    }

    public void setSourcePath(String str) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setSourcePath(str);
    }

    public void stop() {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.stop();
    }

    public void setLoopSection(long j2) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setLoopSection(j2);
    }

    public void setLoopSection(int i2, int i3) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setLoopSection(i2, i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
        this.mPlayer = videoPlayerProxy;
        videoPlayerProxy.setGLTextureView(this);
        this.mIsKeepLastFrame = false;
        init();
    }

    public void setLoopSection(int i2) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (iPlayer = this.mPlayer) == null) {
            return;
        }
        iPlayer.setLoopSection(i2);
    }
}
