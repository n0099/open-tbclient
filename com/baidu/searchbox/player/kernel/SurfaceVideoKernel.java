package com.baidu.searchbox.player.kernel;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes4.dex */
public class SurfaceVideoKernel extends AbsVideoCyber {
    private static final String TAG = "SurfaceVideoKernel";
    private Surface mCurSurface;
    private SurfaceView mFullVideoView = new SurfaceView(BDPlayerConfig.getAppContext());
    private Surface mHalfVideoView;
    private boolean mIsFullViewCreated;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceVideoKernel() {
        this.mFullVideoView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.baidu.searchbox.player.kernel.SurfaceVideoKernel.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceVideoKernel.this.mIsFullViewCreated = true;
                BdVideoLog.d("SurfaceVideoKernel", "surfaceView created");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                BdVideoLog.d("SurfaceVideoKernel", "surfaceView changed");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                BdVideoLog.d("SurfaceVideoKernel", "surfaceView destroyed");
                SurfaceVideoKernel.this.mIsFullViewCreated = false;
            }
        });
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull String str) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        return this.mFullVideoView;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        return this.mPlayer.getVideoHeight();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        return this.mPlayer.getVideoWidth();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        this.mPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSurface(Surface surface) {
        this.mHalfVideoView = surface;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return "SurfaceVideoKernel".equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        super.onPrepared();
        if (this.mKernelStatus.isPlaying()) {
            resume();
        }
        if (this.mStorePosition > 2) {
            this.mPlayer.seekTo(this.mStorePosition - 2);
            this.mStorePosition = -1;
        }
        this.mPlayer.setSurface(this.mCurSurface);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        super.play(str);
        if (!"videoplayer:preload".equals(this.mVideoUrl)) {
            start();
        }
    }
}
