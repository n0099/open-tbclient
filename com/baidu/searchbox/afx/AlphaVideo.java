package com.baidu.searchbox.afx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.gl.AlphaVideoRenderer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.IPlayer;
import com.baidu.searchbox.afx.proxy.VideoPlayerProxy;
import java.io.File;
/* loaded from: classes2.dex */
public class AlphaVideo extends GLTextureView {
    public static final int GL_CONTEXT_VERSION = 2;
    public AlphaVideoRenderer mAlphaVideoRenderer;
    public boolean mIsKeepLastFrame;
    public volatile boolean mIsPlayRequested;
    public volatile boolean mIsSurfacePrepared;
    public IPlayer mPlayer;

    public AlphaVideo(Context context) {
        super(context);
        VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
        this.mPlayer = videoPlayerProxy;
        videoPlayerProxy.setGLTextureView(this);
        this.mIsKeepLastFrame = false;
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        initRenderer();
        bringToFront();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
        initReport();
    }

    private void initRenderer() {
        AlphaVideoRenderer alphaVideoRenderer = new AlphaVideoRenderer();
        this.mAlphaVideoRenderer = alphaVideoRenderer;
        alphaVideoRenderer.setOnSurfacePrepareListener(new AlphaVideoRenderer.OnSurfacePrepareListener() { // from class: com.baidu.searchbox.afx.AlphaVideo.1
            @Override // com.baidu.searchbox.afx.gl.AlphaVideoRenderer.OnSurfacePrepareListener
            public void onSurfacePrepared(Surface surface) {
                if (AlphaVideo.this.mPlayer != null) {
                    AlphaVideo.this.mPlayer.setSurface(surface);
                }
                AlphaVideo.this.mIsSurfacePrepared = true;
                if (AlphaVideo.this.mIsPlayRequested) {
                    AlphaVideo.this.mIsPlayRequested = false;
                    if (AlphaVideo.this.mPlayer != null) {
                        AlphaVideo.this.mPlayer.play();
                        if (AlphaVideo.this.mAlphaVideoRenderer != null) {
                            AlphaVideo.this.mAlphaVideoRenderer.onPlay();
                        }
                    }
                }
            }
        });
        setRenderer(this.mAlphaVideoRenderer);
        setRenderMode(0);
    }

    private void initReport() {
        setOnReportListener(AlphaVideoManager.getOnReportListener());
    }

    public void destroy() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.destroy();
        }
    }

    public long getDuration() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            return iPlayer.getDuration();
        }
        return 0L;
    }

    public int getFps() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            return iPlayer.getFps();
        }
        return 0;
    }

    public boolean isDestroyed() {
        IPlayer iPlayer = this.mPlayer;
        return iPlayer != null && iPlayer.isDestroyed();
    }

    public boolean isPaused() {
        IPlayer iPlayer = this.mPlayer;
        return iPlayer != null && iPlayer.isPaused();
    }

    public boolean isPlaying() {
        IPlayer iPlayer = this.mPlayer;
        return iPlayer != null && iPlayer.isPlaying();
    }

    public boolean isStopped() {
        IPlayer iPlayer = this.mPlayer;
        return iPlayer != null && iPlayer.isStopped();
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onResume() {
        super.onResume();
    }

    public void pause() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.pause();
        }
    }

    public void play() {
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

    public void setDarkFilter(float f2) {
        AlphaVideoRenderer alphaVideoRenderer = this.mAlphaVideoRenderer;
        if (alphaVideoRenderer != null) {
            alphaVideoRenderer.setDarkFilter(f2);
        }
    }

    public void setKeepLastFrame(boolean z) {
        this.mIsKeepLastFrame = z;
    }

    public void setLoopSection(long j, long j2) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setLoopSection(j, j2);
        }
    }

    public void setLooping(boolean z) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setLooping(z);
        }
    }

    public void setOnReportListener(OnReportListener onReportListener) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setOnReportListener(onReportListener);
        }
    }

    public void setOnVideoEndedListener(final OnVideoEndedListener onVideoEndedListener) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.searchbox.afx.AlphaVideo.2
                @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                public void onVideoEnded() {
                    if (AlphaVideo.this.mAlphaVideoRenderer != null && !AlphaVideo.this.mIsKeepLastFrame) {
                        AlphaVideo.this.mAlphaVideoRenderer.clearLastFrame();
                    }
                    OnVideoEndedListener onVideoEndedListener2 = onVideoEndedListener;
                    if (onVideoEndedListener2 != null) {
                        onVideoEndedListener2.onVideoEnded();
                    }
                }
            });
        }
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setOnVideoErrorListener(onVideoErrorListener);
        }
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setOnVideoStartedListener(onVideoStartedListener);
        }
    }

    public void setPlayer(IPlayer iPlayer) {
        this.mPlayer = iPlayer;
        if (iPlayer != null) {
            iPlayer.setGLTextureView(this);
        }
        initReport();
    }

    public void setSourceAssets(String str) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setSourceAssets(getContext(), str);
        }
    }

    public void setSourceFile(File file) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setSourceFile(file);
        }
    }

    public void setSourcePath(String str) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setSourcePath(str);
        }
    }

    public void stop() {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.stop();
        }
    }

    public void setLoopSection(long j) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setLoopSection(j);
        }
    }

    public void setLoopSection(int i, int i2) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setLoopSection(i, i2);
        }
    }

    public AlphaVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        VideoPlayerProxy videoPlayerProxy = new VideoPlayerProxy();
        this.mPlayer = videoPlayerProxy;
        videoPlayerProxy.setGLTextureView(this);
        this.mIsKeepLastFrame = false;
        init();
    }

    public void setLoopSection(int i) {
        IPlayer iPlayer = this.mPlayer;
        if (iPlayer != null) {
            iPlayer.setLoopSection(i);
        }
    }
}
