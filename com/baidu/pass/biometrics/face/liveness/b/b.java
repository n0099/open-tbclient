package com.baidu.pass.biometrics.face.liveness.b;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes2.dex */
public class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public a f9211a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9212b;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceHolder holder = getHolder();
        this.f9212b = holder;
        holder.setFormat(-2);
        this.f9212b.setType(3);
        this.f9212b.addCallback(this);
    }

    public void a() {
        if (getContext() instanceof Activity) {
            this.f9211a.a((Activity) getContext(), this.f9212b);
        }
    }

    public void setCameraInterface(a aVar) {
        this.f9211a = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.f9211a.a((Activity) getContext(), this.f9212b);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f9211a.a();
    }
}
