package com.baidu.searchbox.afx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.gl.AlphaVideoRenderer;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.afx.proxy.IPlayer;
import com.baidu.searchbox.afx.proxy.VideoPlayerProxy;
import java.io.File;
/* loaded from: classes13.dex */
public class AlphaVideo extends GLTextureView {
    private static final int GL_CONTEXT_VERSION = 2;
    private AlphaVideoRenderer mAlphaVideoRenderer;
    private volatile boolean mIsPlayRequested;
    private volatile boolean mIsSurfacePrepared;
    private IPlayer mPlayer;

    public AlphaVideo(Context context) {
        super(context);
        this.mPlayer = new VideoPlayerProxy();
        this.mPlayer.setGLTextureView(this);
        init();
    }

    public AlphaVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayer = new VideoPlayerProxy();
        this.mPlayer.setGLTextureView(this);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        initRenderer();
        bringToFront();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    private void initRenderer() {
        this.mAlphaVideoRenderer = new AlphaVideoRenderer();
        this.mAlphaVideoRenderer.setOnSurfacePrepareListener(new AlphaVideoRenderer.OnSurfacePrepareListener() { // from class: com.baidu.searchbox.afx.AlphaVideo.1
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
                    }
                }
            }
        });
        setRenderer(this.mAlphaVideoRenderer);
        setRenderMode(0);
    }

    public void setPlayer(IPlayer iPlayer) {
        this.mPlayer = iPlayer;
        if (this.mPlayer != null) {
            this.mPlayer.setGLTextureView(this);
        }
    }

    public void setSourcePath(String str) {
        if (this.mPlayer != null) {
            this.mPlayer.setSourcePath(str);
        }
    }

    public void setSourceFile(File file) {
        if (this.mPlayer != null) {
            this.mPlayer.setSourceFile(file);
        }
    }

    public void setSourceAssets(String str) {
        if (this.mPlayer != null) {
            this.mPlayer.setSourceAssets(getContext(), str);
        }
    }

    public void setLoopSection(long j, long j2) {
        if (this.mPlayer != null) {
            this.mPlayer.setLoopSection(j, j2);
        }
    }

    public void setLoopSection(long j) {
        if (this.mPlayer != null) {
            this.mPlayer.setLoopSection(j);
        }
    }

    public void setLoopSection(int i, int i2) {
        if (this.mPlayer != null) {
            this.mPlayer.setLoopSection(i, i2);
        }
    }

    public void setLoopSection(int i) {
        if (this.mPlayer != null) {
            this.mPlayer.setLoopSection(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.mPlayer != null) {
            this.mPlayer.setLooping(z);
        }
    }

    public void setDarkFilter(float f) {
        if (this.mAlphaVideoRenderer != null) {
            this.mAlphaVideoRenderer.setDarkFilter(f);
        }
    }

    public void play() {
        if (this.mIsSurfacePrepared) {
            if (this.mPlayer != null) {
                this.mPlayer.play();
                return;
            }
            return;
        }
        this.mIsPlayRequested = true;
    }

    public void pause() {
        if (this.mPlayer != null) {
            this.mPlayer.pause();
        }
    }

    public void stop() {
        if (this.mPlayer != null) {
            this.mPlayer.stop();
        }
    }

    public void destroy() {
        if (this.mPlayer != null) {
            this.mPlayer.destroy();
        }
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        if (this.mPlayer != null) {
            this.mPlayer.setOnVideoStartedListener(onVideoStartedListener);
        }
    }

    public void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        if (this.mPlayer != null) {
            this.mPlayer.setOnVideoEndedListener(onVideoEndedListener);
        }
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        if (this.mPlayer != null) {
            this.mPlayer.setOnVideoErrorListener(onVideoErrorListener);
        }
    }

    public boolean isPlaying() {
        return this.mPlayer != null && this.mPlayer.isPlaying();
    }

    public boolean isPaused() {
        return this.mPlayer != null && this.mPlayer.isPaused();
    }

    public boolean isStopped() {
        return this.mPlayer != null && this.mPlayer.isStopped();
    }

    public boolean isDestroyed() {
        return this.mPlayer != null && this.mPlayer.isDestroyed();
    }

    public long getDuration() {
        if (this.mPlayer != null) {
            return this.mPlayer.getDuration();
        }
        return 0L;
    }

    public int getFps() {
        if (this.mPlayer != null) {
            return this.mPlayer.getFps();
        }
        return 0;
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.afx.gl.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
