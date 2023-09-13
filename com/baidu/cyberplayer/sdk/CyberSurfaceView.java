package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class CyberSurfaceView extends SurfaceView implements ICyberRenderView {
    public static final String TAG = "CyberSurfaceView";
    public CyberRenderSizeHelper mCyberRenderSizeHelper;
    public ICyberRenderView.ICyberSurfaceListener mCyberSurfaceListener;
    public boolean mFirstDisplay;
    public boolean mHasSurCreated;
    public boolean mHasTranslate;
    public Surface mSurface;
    public SurfaceCallback mSurfaceCallBack;

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean isNeedTakeSnapShotAsync() {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void release() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setClientRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean setFilterRegion(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setRawFrameRotation(int i) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Bitmap takeSnapshot(float f, int i, int i2) {
        return null;
    }

    /* loaded from: classes3.dex */
    public class SurfaceCallback implements SurfaceHolder.Callback {
        public SurfaceCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            CyberLog.d(CyberSurfaceView.TAG, "surfaceChanged: " + i2 + " x " + i3);
            if (CyberSurfaceView.this.mCyberSurfaceListener != null) {
                CyberSurfaceView.this.mCyberSurfaceListener.onSurfaceChanged(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CyberLog.d(CyberSurfaceView.TAG, "surfaceCreated mCyberSurfaceListener:" + CyberSurfaceView.this.mCyberSurfaceListener);
            CyberSurfaceView.this.mSurface = surfaceHolder.getSurface();
            if (CyberSurfaceView.this.mCyberSurfaceListener != null) {
                CyberSurfaceView.this.mCyberSurfaceListener.onSurfaceReady(2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CyberLog.d(CyberSurfaceView.TAG, "surfaceDestroyed mCyberSurfaceListener:" + CyberSurfaceView.this.mCyberSurfaceListener);
            if (CyberSurfaceView.this.mSurface != null) {
                CyberSurfaceView.this.mSurface.release();
                CyberSurfaceView.this.mSurface = null;
            }
            if (CyberSurfaceView.this.mCyberSurfaceListener != null) {
                CyberSurfaceView.this.mCyberSurfaceListener.onSurfaceDestroyed(2);
            }
        }
    }

    public CyberSurfaceView(Context context) {
        super(context);
        this.mHasTranslate = false;
        this.mFirstDisplay = false;
        this.mHasSurCreated = false;
        CyberLog.d(TAG, "CyberSurfaceView constructor called");
        getHolder().setType(0);
        getHolder().setFixedSize(1920, 1080);
        this.mSurfaceCallBack = new SurfaceCallback();
        getHolder().addCallback(this.mSurfaceCallBack);
        this.mCyberRenderSizeHelper = new CyberRenderSizeHelper();
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mFirstDisplay) {
            CyberLog.d(TAG, "FirstDisplay!!!");
            this.mFirstDisplay = true;
            ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener = this.mCyberSurfaceListener;
            if (iCyberSurfaceListener != null) {
                iCyberSurfaceListener.onSurfaceFirstFrameDrawed(System.currentTimeMillis());
            }
            setWillNotDraw(true);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setCyberSurfaceListener(ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener) {
        this.mCyberSurfaceListener = iCyberSurfaceListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setDisplayMode(int i) {
        if (this.mCyberRenderSizeHelper.onDisplayModeChanged(i)) {
            CyberLog.i(TAG, "setDisplayMode to " + i);
            this.mCyberRenderSizeHelper.updateDisplaySize();
            requestLayout();
        }
    }

    @Override // android.view.SurfaceView, com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setZOrderMediaOverlay(boolean z) {
        super.setZOrderMediaOverlay(z);
    }

    private void doTranslate(int i, int i2, int i3, int i4) {
        if (this.mCyberRenderSizeHelper.isNeedTranslate()) {
            CyberLog.i(TAG, "doTranslate lastWidth:" + i + " lastHeight:" + i2 + " width:" + i3 + " height:" + i4);
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
                setTranslationX(-f);
                setTranslationY(0.0f);
            } else if (displayMode == 8) {
                setTranslationX(f);
                setTranslationY(0.0f);
            } else if (displayMode == 9) {
                setTranslationX(0.0f);
                setTranslationY(-f2);
            } else if (displayMode == 10) {
                setTranslationX(0.0f);
                setTranslationY(f2);
            }
            this.mHasTranslate = true;
        } else if (this.mHasTranslate) {
            setTranslationX(0.0f);
            setTranslationY(0.0f);
            this.mHasTranslate = false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Surface createNewSurface() {
        CyberLog.d(TAG, "mSurface:" + this.mSurface);
        if (this.mSurface == null) {
            this.mSurface = getHolder().getSurface();
        }
        Surface surface = this.mSurface;
        if (surface != null && !surface.isValid()) {
            CyberLog.i(TAG, "createNewSurface isValid:" + this.mSurface.isValid());
            this.mSurface = null;
        }
        if (this.mHasSurCreated) {
            Utils.clearSurface(this.mSurface);
        }
        if (this.mSurface != null) {
            this.mHasSurCreated = true;
        }
        return this.mSurface;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void destory() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        reset();
        if (this.mSurfaceCallBack != null) {
            getHolder().removeCallback(this.mSurfaceCallBack);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void reset() {
        this.mCyberRenderSizeHelper.reset();
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        this.mHasTranslate = false;
        this.mFirstDisplay = false;
        this.mHasSurCreated = false;
        setWillNotDraw(false);
    }

    public void finalize() throws Throwable {
        super.finalize();
        CyberLog.d(TAG, "CyberSurfaceView finalize called mSurface:" + this.mSurface);
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        reset();
        if (this.mSurfaceCallBack != null) {
            getHolder().removeCallback(this.mSurfaceCallBack);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        float f;
        CyberLog.i(TAG, "onMeasure(" + View.MeasureSpec.toString(i) + StringUtil.ARRAY_ELEMENT_SEPARATOR + View.MeasureSpec.toString(i2) + SmallTailInfo.EMOTION_SUFFIX);
        this.mCyberRenderSizeHelper.onSurfaceSizeChanged(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.mCyberRenderSizeHelper.updateDisplaySize();
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
            CyberLog.i(TAG, "onVideoSizeChanged:" + i + "/" + i2 + "/" + i3 + "/" + i4);
            requestLayout();
        }
    }
}
