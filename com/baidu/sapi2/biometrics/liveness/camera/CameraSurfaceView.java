package com.baidu.sapi2.biometrics.liveness.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes2.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder a;
    private a b;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getHolder();
        this.a.setFormat(-2);
        this.a.setType(3);
        this.a.addCallback(this);
    }

    public void setCameraInterface(a aVar) {
        this.b = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.b.a(getContext(), this.a);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.d();
    }

    public void startPreview() {
        this.b.a(getContext(), this.a);
    }
}
