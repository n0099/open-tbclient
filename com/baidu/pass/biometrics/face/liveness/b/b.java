package com.baidu.pass.biometrics.face.liveness.b;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes7.dex */
public class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private a f4075a;

    /* renamed from: b  reason: collision with root package name */
    SurfaceHolder f4076b;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4076b = getHolder();
        this.f4076b.setFormat(-2);
        this.f4076b.setType(3);
        this.f4076b.addCallback(this);
    }

    public void a() {
        if (getContext() instanceof Activity) {
            this.f4075a.a((Activity) getContext(), this.f4076b);
        }
    }

    public void setCameraInterface(a aVar) {
        this.f4075a = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.f4075a.a((Activity) getContext(), this.f4076b);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4075a.a();
    }
}
