package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.recorder.video.listener.TextureViewListener;
import java.util.HashSet;
import java.util.Set;
@TargetApi(16)
/* loaded from: classes15.dex */
public class AlaTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final boolean IS_OPEN_TAG = false;
    private static final String TAG = "LIVE_SDK_JNI";
    private Activity mActivity;
    private Set<TextureViewListener> mListeners;
    private Surface mSurface;
    private int mSurfaceHeight;
    private TextureViewListener.SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private int mSurfaceWidth;

    public AlaTextureView(Context context) {
        super(context);
        this.mActivity = null;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mListeners = new HashSet();
        this.mSurfaceHolder = new TextureViewListener.SurfaceHolder() { // from class: com.baidu.ala.recorder.video.camera.AlaTextureView.1
            @Override // com.baidu.ala.recorder.video.listener.TextureViewListener.SurfaceHolder
            public Surface getSurface() {
                return AlaTextureView.this.mSurface;
            }

            @Override // com.baidu.ala.recorder.video.listener.TextureViewListener.SurfaceHolder
            public int getSurfaceWidth() {
                return AlaTextureView.this.mSurfaceWidth;
            }

            @Override // com.baidu.ala.recorder.video.listener.TextureViewListener.SurfaceHolder
            public int getSurfaceHeight() {
                return AlaTextureView.this.mSurfaceHeight;
            }
        };
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
            setSurfaceTextureListener(this);
            return;
        }
        throw new IllegalArgumentException("context must be Activity");
    }

    public void addListener(TextureViewListener textureViewListener) {
        if (!this.mListeners.contains(textureViewListener)) {
            this.mListeners.add(textureViewListener);
        }
    }

    public void removeListener(TextureViewListener textureViewListener) {
        this.mListeners.remove(textureViewListener);
    }

    public void removeAllListener() {
        this.mListeners.clear();
    }

    public void release() {
        try {
            this.mListeners.clear();
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        for (TextureViewListener textureViewListener : this.mListeners) {
            textureViewListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mSurfaceTexture != null) {
            setSurfaceTexture(this.mSurfaceTexture);
            if (this.mSurface == null) {
                this.mSurface = new Surface(this.mSurfaceTexture);
            }
        } else {
            this.mSurfaceTexture = surfaceTexture;
            this.mSurface = new Surface(surfaceTexture);
        }
        if (this.mSurfaceHeight == 0) {
            this.mSurfaceHeight = i2;
        }
        if (this.mSurfaceWidth == 0) {
            this.mSurfaceWidth = i;
        }
        for (TextureViewListener textureViewListener : this.mListeners) {
            textureViewListener.onSurfaceWindow(this.mSurfaceHolder);
        }
        for (TextureViewListener textureViewListener2 : this.mListeners) {
            textureViewListener2.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
        if (this.mSurfaceWidth > 0 && this.mSurfaceHeight > 0 && (i != this.mSurfaceWidth || i2 != this.mSurfaceHeight)) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getLayoutParams() != null) {
            if (this.mSurfaceHeight > 0 && this.mSurfaceWidth > 0) {
                int i = this.mSurfaceWidth;
                int i2 = this.mSurfaceHeight;
                if (configuration.orientation == 2 && this.mSurfaceWidth < this.mSurfaceHeight) {
                    i = this.mSurfaceHeight;
                    i2 = this.mSurfaceWidth;
                }
                if (configuration.orientation == 1 && this.mSurfaceHeight < this.mSurfaceWidth) {
                    i = this.mSurfaceHeight;
                    i2 = this.mSurfaceWidth;
                }
                if (this.mSurfaceTexture != null) {
                    onSurfaceTextureSizeChanged(this.mSurfaceTexture, i, i2);
                }
            }
            for (TextureViewListener textureViewListener : this.mListeners) {
                textureViewListener.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        int i3;
        int i4;
        int realScreenOrientation = AlaLiveUtilHelper.getRealScreenOrientation(this.mActivity);
        if (i != this.mSurfaceWidth || i2 != this.mSurfaceHeight) {
            if (realScreenOrientation != 2 || i >= i2) {
                i3 = i2;
                i4 = i;
            } else {
                i3 = i;
                i4 = i2;
            }
            if (realScreenOrientation != 1 || i3 >= i4) {
                int i5 = i3;
                i3 = i4;
                i4 = i5;
            }
            this.mSurfaceWidth = i3;
            this.mSurfaceHeight = i4;
            for (TextureViewListener textureViewListener : this.mListeners) {
                textureViewListener.onSurfaceWindow(this.mSurfaceHolder);
            }
            for (TextureViewListener textureViewListener2 : this.mListeners) {
                textureViewListener2.onSurfaceTextureSizeChanged(surfaceTexture, this.mSurfaceWidth, this.mSurfaceHeight);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        for (TextureViewListener textureViewListener : this.mListeners) {
            textureViewListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return this.mSurfaceTexture == null;
    }
}
