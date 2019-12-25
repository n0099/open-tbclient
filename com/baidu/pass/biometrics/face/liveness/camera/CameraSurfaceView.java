package com.baidu.pass.biometrics.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes4.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private CameraInterface cameraInterface;
    SurfaceHolder mSurfaceHolder;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this);
    }

    public void setCameraInterface(CameraInterface cameraInterface) {
        this.cameraInterface = cameraInterface;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.cameraInterface.doStartPreview((Activity) getContext(), this.mSurfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cameraInterface.doStopCamera();
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.cameraInterface.doStartPreview((Activity) getContext(), this.mSurfaceHolder);
        }
    }
}
