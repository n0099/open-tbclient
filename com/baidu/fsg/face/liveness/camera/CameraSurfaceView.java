package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes6.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder a;
    private b b;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getHolder();
        this.a.setFormat(-2);
        this.a.setType(3);
        this.a.addCallback(this);
    }

    public void setCameraInterface(b bVar) {
        this.b = bVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.b.a((Activity) getContext(), this.a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.d();
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.b.a((Activity) getContext(), this.a);
        }
    }
}
