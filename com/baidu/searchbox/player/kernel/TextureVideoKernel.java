package com.baidu.searchbox.player.kernel;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class TextureVideoKernel extends AbsVideoCyber {
    private static final String TAG = "TextureVideoKernel";
    private Surface mSurface;
    private TextureView mTextureView;
    private HashMap<String, String> options;
    private int mCurrentVideoWidth = 0;
    private int mCurrentVideoHeight = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureVideoKernel(@NonNull TextureView textureView) {
        this.mTextureView = textureView;
        this.mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.baidu.searchbox.player.kernel.TextureVideoKernel.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (surfaceTexture != null) {
                    TextureVideoKernel.this.mSurface = new Surface(surfaceTexture);
                    TextureVideoKernel.this.mPlayer.setSurface(TextureVideoKernel.this.mSurface);
                    BdVideoLog.d("TextureVideoKernel", "surfaceView created");
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                BdVideoLog.d("TextureVideoKernel", "surfaceView destroyed");
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull String str) {
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        return this.mTextureView;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        return this.mCurrentVideoHeight;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        return this.mCurrentVideoWidth;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        this.mPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return "TextureVideoKernel".equals(str);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        super.play(str);
        if (!TextUtils.equals(this.mPreparingUrl, str)) {
            this.mPlayer.stop();
            prepareInternal();
        }
        if (!"videoplayer:preload".equals(this.mVideoUrl)) {
            this.mPlayer.start();
        }
        this.mStorePosition = -1;
    }

    private void prepareInternal() {
        if (this.mHeader.size() > 0) {
            setVideoURI(Uri.parse(this.mVideoUrl), this.mHeader);
        } else {
            setVideoURI(Uri.parse(this.mVideoUrl), null);
        }
    }

    private void setVideoURI(Uri uri, HashMap<String, String> hashMap) {
        BdVideoLog.d("TextureVideoKernel", "setVideoURI");
        try {
            initPlayer();
            if (this.options != null) {
                this.options = null;
                for (Map.Entry<String, String> entry : this.options.entrySet()) {
                    this.mPlayer.setOption(entry.getKey(), entry.getValue());
                }
            }
            if (this.mTextureView != null) {
                this.mCurrentVideoWidth = 0;
                this.mCurrentVideoHeight = 0;
                SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
                if (surfaceTexture != null) {
                    this.mSurface = new Surface(surfaceTexture);
                    this.mPlayer.setSurface(this.mSurface);
                }
            }
            this.mPlayer.setDataSource(BDPlayerConfig.getAppContext(), uri, hashMap);
            this.mPlayer.setScreenOnWhilePlaying(true);
            this.mPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    public void onError(int i, int i2, Object obj) {
        BdVideoLog.d("TextureVideoKernel", "onError what " + i + " extra " + i2 + " obj " + obj);
        stop();
        this.mKernelStatus.stateChangeNotify(PlayerStatus.ERROR);
    }

    private void reset() {
        BdVideoLog.d("TextureVideoKernel", "reset");
        this.mPlayer.reset();
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        super.onPrepared();
        if (this.mStorePosition > 2) {
            this.mPlayer.seekTo(this.mStorePosition - 2);
            this.mStorePosition = -1;
        }
    }
}
