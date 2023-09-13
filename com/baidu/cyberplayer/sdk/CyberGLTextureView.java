package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberRender;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
/* loaded from: classes3.dex */
public class CyberGLTextureView extends GLTextureView implements ICyberRenderView {
    public static final String TAG = "CyberGLTextureView";
    public CyberRender mRender;

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public View getView() {
        return this;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean isNeedTakeSnapShotAsync() {
        return true;
    }

    public CyberGLTextureView(Context context) {
        this(context, 0);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setClientRotation(int i) {
        this.mRender.setClientRotation(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setCyberSurfaceListener(ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener) {
        this.mRender.setCyberSurfaceListener(iCyberSurfaceListener);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setDisplayMode(int i) {
        this.mRender.setDisplayeMode(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setRawFrameRotation(int i) {
        this.mRender.setRawFrameRotation(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void setZOrderMediaOverlay(boolean z) {
        CyberLog.d(TAG, this + "///setZOrderMediaOverlay : " + z);
    }

    public CyberGLTextureView(Context context, int i) {
        super(context);
        setEGLContextClientVersion(2);
        if (i == 256) {
            this.mRender = new CyberGaussBurRender();
        } else {
            this.mRender = new CyberRender();
        }
        this.mRender.setOnRequestRenderListener(new CyberRender.OnRequestRenderListener() { // from class: com.baidu.cyberplayer.sdk.CyberGLTextureView.1
            @Override // com.baidu.cyberplayer.sdk.CyberRender.OnRequestRenderListener
            public void onRequestRender() {
                CyberGLTextureView.this.requestRender();
            }
        });
        setRenderer(this.mRender);
        setRenderMode(0);
        CyberLog.d(TAG, this + "///mRender : " + this.mRender);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Surface createNewSurface() {
        return this.mRender.createNewSurface();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void destory() {
        release();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void release() {
        this.mRender.release();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void reset() {
        this.mRender.reset();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.mRender.onVideoSizeChanged(i, i2, i3, i4);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public boolean setFilterRegion(int i, float f, float f2, float f3, float f4) {
        return this.mRender.setFilterRegion(i, f, f2, f3, f4);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberRenderView
    public Bitmap takeSnapshot(float f, int i, int i2) {
        this.mRender.takeSnapshot(f, i, i2);
        return null;
    }
}
