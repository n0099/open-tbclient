package com.baidu.pass.biometrics.face.liveness.b;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes15.dex */
public class b extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private a f4040a;

    /* renamed from: b  reason: collision with root package name */
    SurfaceHolder f4041b;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4041b = getHolder();
        this.f4041b.setFormat(-2);
        this.f4041b.setType(3);
        this.f4041b.addCallback(this);
    }

    public void a() {
        if (getContext() instanceof Activity) {
            this.f4040a.a((Activity) getContext(), this.f4041b);
        }
    }

    public void setCameraInterface(a aVar) {
        this.f4040a = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (getContext() instanceof Activity) {
            this.f4040a.a((Activity) getContext(), this.f4041b);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4040a.a();
    }
}
