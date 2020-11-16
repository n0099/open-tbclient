package com.baidu.pass.biometrics.face.liveness.b;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes11.dex */
public class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private a f2750a;
    SurfaceHolder b;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = getHolder();
        this.b.setFormat(-2);
        this.b.setType(3);
        this.b.addCallback(this);
    }

    public void a() {
        if (getContext() instanceof Activity) {
            this.f2750a.a((Activity) getContext(), this.b);
        }
    }

    public void setCameraInterface(a aVar) {
        this.f2750a = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.f2750a.a((Activity) getContext(), this.b);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2750a.a();
    }
}
