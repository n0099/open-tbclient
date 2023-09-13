package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes3.dex */
public class CyberTextureView extends TextureView implements ICyberRenderView {
    public static final String TAG = "CyberTextureView";
    public CyberRenderSizeHelper mCyberRenderSizeHelper;
    public ICyberRenderView.ICyberSurfaceListener mCyberSurfaceListener;
    public boolean mEnableReleaseSurfaceTexture;
    public boolean mEnableTextureViewTranslate;
    public boolean mFirstDisplay;
    public boolean mHasTranslate;
    public boolean mIsDestoryed;
    public boolean mIsOwnedByPlayer;
    public Surface mSurface;
    public SurfaceCallback mSurfaceCallback;
    public SurfaceTexture mSurfaceTexture;

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean isNeedTakeSnapShotAsync() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean setFilterRegion(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setZOrderMediaOverlay(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class SurfaceCallback implements TextureView.SurfaceTextureListener {
        public SurfaceCallback() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (CyberTextureView.this.mFirstDisplay) {
                return;
            }
            CyberTextureView.this.mFirstDisplay = true;
            if (CyberTextureView.this.mCyberSurfaceListener != null) {
                CyberTextureView.this.mCyberSurfaceListener.onSurfaceFirstFrameDrawed(System.currentTimeMillis());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d(CyberTextureView.TAG, "onSurfaceTextureAvailable surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            CyberTextureView.this.mIsDestoryed = false;
            if (CyberTextureView.this.mEnableReleaseSurfaceTexture && !CyberTextureView.this.mIsOwnedByPlayer) {
                CyberTextureView.this.releaseLastSurfaceTexture(surfaceTexture);
            }
            if (CyberTextureView.this.mSurfaceTexture == null) {
                CyberTextureView.this.mSurfaceTexture = surfaceTexture;
                if (CyberTextureView.this.mCyberSurfaceListener != null) {
                    CyberTextureView.this.mCyberSurfaceListener.onSurfaceReady(1);
                }
            } else if (Build.VERSION.SDK_INT < 21) {
                CyberTextureView.this.mSurfaceTexture = surfaceTexture;
                if (CyberTextureView.this.mCyberSurfaceListener != null) {
                    CyberTextureView.this.mCyberSurfaceListener.onSurfaceReady(1);
                }
            } else {
                CyberTextureView cyberTextureView = CyberTextureView.this;
                cyberTextureView.setSurfaceTexture(cyberTextureView.mSurfaceTexture);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            CyberLog.d(CyberTextureView.TAG, "onSurfaceTextureDestroyed surface:" + surfaceTexture);
            CyberTextureView.this.mIsDestoryed = true;
            if (CyberTextureView.this.mEnableReleaseSurfaceTexture && !CyberTextureView.this.mIsOwnedByPlayer) {
                if (surfaceTexture != CyberTextureView.this.mSurfaceTexture && surfaceTexture != null) {
                    surfaceTexture.release();
                }
                CyberTextureView.this.releaseSurfaceTexture();
                return false;
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            CyberLog.d(CyberTextureView.TAG, "onSurfaceTextureSizeChanged surface:" + surfaceTexture + " width:" + i + " height:" + i2);
            CyberTextureView.this.mIsDestoryed = false;
        }
    }

    public CyberTextureView(Context context) {
        super(context);
        this.mHasTranslate = false;
        SurfaceCallback surfaceCallback = new SurfaceCallback();
        this.mSurfaceCallback = surfaceCallback;
        setSurfaceTextureListener(surfaceCallback);
        this.mCyberRenderSizeHelper = new CyberRenderSizeHelper();
        this.mFirstDisplay = false;
        this.mIsOwnedByPlayer = false;
        this.mIsDestoryed = false;
        this.mEnableReleaseSurfaceTexture = CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_TEXTUREVIEW_TEXTURE_AUTO_RELEASE, true);
        this.mEnableTextureViewTranslate = CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_TEXTUREVIEW_ENABLE_TRANSLATE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
        if (surfaceTexture2 != null && surfaceTexture2 != surfaceTexture) {
            CyberLog.i(TAG, "releaseLastSurfaceTexture mSurfaceTexture:" + this.mSurfaceTexture);
            releaseSurfaceTexture();
        }
    }

    private void updateRotation(int i) {
        int drawFrameRotation = this.mCyberRenderSizeHelper.getDrawFrameRotation();
        if (drawFrameRotation > 0) {
            drawFrameRotation = 360 - drawFrameRotation;
        }
        CyberLog.i(TAG, "updateRotation rotate:" + i + " drawFrameRotation:" + drawFrameRotation);
        setRotation((float) drawFrameRotation);
        requestLayout();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setClientRotation(int i) {
        if (this.mCyberRenderSizeHelper.onClientRotationChanged(i)) {
            updateRotation(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setCyberSurfaceListener(ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener) {
        this.mCyberSurfaceListener = iCyberSurfaceListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setDisplayMode(int i) {
        if (this.mCyberRenderSizeHelper.onDisplayModeChanged(i)) {
            updateDisplaySize();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setRawFrameRotation(int i) {
        if (this.mCyberRenderSizeHelper.onRawFrameRotationChanged(i)) {
            updateRotation(i);
        }
    }

    private void doTranslate(int i, int i2, int i3, int i4) {
        if (!this.mEnableTextureViewTranslate) {
            return;
        }
        if (this.mCyberRenderSizeHelper.isNeedTranslate()) {
            Matrix matrix = new Matrix();
            getTransform(matrix);
            CyberLog.i(TAG, "doTranslate old_width:" + i + " old_height:" + i2 + " width:" + i3 + " height:" + i4);
            float f = ((float) (i3 - i)) / 2.0f;
            float f2 = ((float) (i4 - i2)) / 2.0f;
            StringBuilder sb = new StringBuilder();
            sb.append("doTranslate x:");
            sb.append(f);
            sb.append(" y:");
            sb.append(f2);
            CyberLog.i(TAG, sb.toString());
            int displayMode = this.mCyberRenderSizeHelper.getDisplayMode();
            if (displayMode == 7) {
                matrix.setTranslate(-f, 0.0f);
            } else if (displayMode == 8) {
                matrix.setTranslate(f, 0.0f);
            } else if (displayMode == 9) {
                matrix.setTranslate(0.0f, -f2);
            } else if (displayMode == 10) {
                matrix.setTranslate(0.0f, f2);
            }
            setTransform(matrix);
            this.mHasTranslate = true;
        } else if (this.mHasTranslate) {
            Matrix matrix2 = new Matrix();
            getTransform(matrix2);
            matrix2.setTranslate(0.0f, 0.0f);
            setTransform(matrix2);
            this.mHasTranslate = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            CyberLog.i(TAG, "releaseSurfaceTexture mSurfaceTexture:" + this.mSurfaceTexture);
            this.mSurfaceTexture = null;
        }
    }

    private void updateDisplaySize() {
        requestLayout();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void destory() {
        releaseSurfaceTexture();
        release();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void reset() {
        setRotation(0.0f);
        this.mCyberRenderSizeHelper.reset();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Surface createNewSurface() {
        CyberLog.d(TAG, "createNewSurface mSurface:" + this.mSurface);
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        CyberLog.d(TAG, "createNewSurface getSurfaceTexture:" + getSurfaceTexture());
        if (getSurfaceTexture() != null) {
            this.mIsOwnedByPlayer = true;
            this.mSurface = new Surface(getSurfaceTexture());
            if (this.mEnableReleaseSurfaceTexture) {
                releaseLastSurfaceTexture(getSurfaceTexture());
            }
            this.mSurfaceTexture = getSurfaceTexture();
            this.mFirstDisplay = false;
        }
        CyberLog.d(TAG, "createNewSurface mSurface:" + this.mSurface);
        return this.mSurface;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        float f;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mCyberRenderSizeHelper.onSurfaceSizeChanged(size, size2);
        this.mCyberRenderSizeHelper.updateDisplaySize();
        ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener = this.mCyberSurfaceListener;
        if (iCyberSurfaceListener != null) {
            iCyberSurfaceListener.onSurfaceChanged(size, size2);
        }
        if (this.mCyberRenderSizeHelper.getDrawFrameRotation() != 90 && this.mCyberRenderSizeHelper.getDrawFrameRotation() != 270) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            i2 = i;
            i = i2;
        }
        int defaultSize = View.getDefaultSize(this.mCyberRenderSizeHelper.getVideoWidth(), i);
        int defaultSize2 = View.getDefaultSize(this.mCyberRenderSizeHelper.getVideoHeight(), i2);
        float[] displayScale = this.mCyberRenderSizeHelper.getDisplayScale();
        if (z) {
            i3 = (int) (displayScale[1] * defaultSize);
            f = displayScale[0];
        } else {
            i3 = (int) (displayScale[0] * defaultSize);
            f = displayScale[1];
        }
        int i4 = (int) (f * defaultSize2);
        setMeasuredDimension(i3, i4);
        doTranslate(defaultSize, defaultSize2, i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mCyberRenderSizeHelper.onVideoSizeChanged(i, i2, i3, i4)) {
            updateDisplaySize();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void release() {
        CyberLog.d(TAG, "release called mSurfaceTexture:" + this.mSurfaceTexture);
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        this.mIsOwnedByPlayer = false;
        if (this.mEnableReleaseSurfaceTexture) {
            if (this.mIsDestoryed) {
                CyberLog.d(TAG, "release called mSurfaceTexture:" + this.mSurfaceTexture + " mIsDestoryed:" + this.mIsDestoryed);
                releaseSurfaceTexture();
                return;
            }
            return;
        }
        this.mSurfaceTexture = null;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Bitmap takeSnapshot(float f, int i, int i2) {
        return getBitmap();
    }
}
