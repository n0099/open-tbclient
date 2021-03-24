package com.baidu.searchbox.player.kernel;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class TextureVideoKernel extends AbsVideoCyber {
    public static final String TAG = "TextureVideoKernel";
    public Surface mSurface;
    public TextureView mTextureView;
    public HashMap<String, String> options;
    public int mCurrentVideoWidth = 0;
    public int mCurrentVideoHeight = 0;

    public TextureVideoKernel(@NonNull TextureView textureView) {
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.baidu.searchbox.player.kernel.TextureVideoKernel.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (surfaceTexture != null) {
                    TextureVideoKernel.this.mSurface = new Surface(surfaceTexture);
                    TextureVideoKernel textureVideoKernel = TextureVideoKernel.this;
                    textureVideoKernel.mPlayer.setSurface(textureVideoKernel.mSurface);
                    BdVideoLog.d("TextureVideoKernel", "surfaceView created");
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                BdVideoLog.d("TextureVideoKernel", "surfaceView destroyed");
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    private void prepareInternal() {
        if (this.mHeader.size() > 0) {
            setVideoURI(Uri.parse(this.mVideoUrl), this.mHeader);
        } else {
            setVideoURI(Uri.parse(this.mVideoUrl), null);
        }
    }

    private void reset() {
        BdVideoLog.d("TextureVideoKernel", "reset");
        this.mPlayer.reset();
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
                    Surface surface = new Surface(surfaceTexture);
                    this.mSurface = surface;
                    this.mPlayer.setSurface(surface);
                }
            }
            this.mPlayer.setDataSource(BDPlayerConfig.getAppContext(), uri, hashMap);
            this.mPlayer.setScreenOnWhilePlaying(true);
            this.mPlayer.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
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

    public void onError(int i, int i2, Object obj) {
        BdVideoLog.d("TextureVideoKernel", "onError what " + i + " extra " + i2 + " obj " + obj);
        stop();
        this.mKernelStatus.stateChangeNotify(PlayerStatus.ERROR);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        super.onPrepared();
        int i = this.mStorePosition;
        if (i > 2) {
            this.mPlayer.seekTo(i - 2);
            this.mStorePosition = -1;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        super.play(str);
        if (!TextUtils.equals(this.mPreparingUrl, str)) {
            this.mPlayer.stop();
            prepareInternal();
        }
        if (!AbsVideoKernel.PRELOAD_PREFIX.equals(this.mVideoUrl)) {
            this.mPlayer.start();
        }
        this.mStorePosition = -1;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        this.mPlayer.setLooping(z);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return "TextureVideoKernel".equals(str);
    }
}
