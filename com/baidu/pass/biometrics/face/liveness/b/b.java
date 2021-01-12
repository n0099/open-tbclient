package com.baidu.pass.biometrics.face.liveness.b;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes6.dex */
public class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private a f4037a;

    /* renamed from: b  reason: collision with root package name */
    SurfaceHolder f4038b;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4038b = getHolder();
        this.f4038b.setFormat(-2);
        this.f4038b.setType(3);
        this.f4038b.addCallback(this);
    }

    public void a() {
        if (getContext() instanceof Activity) {
            this.f4037a.a((Activity) getContext(), this.f4038b);
        }
    }

    public void setCameraInterface(a aVar) {
        this.f4037a = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.f4037a.a((Activity) getContext(), this.f4038b);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4037a.a();
    }
}
