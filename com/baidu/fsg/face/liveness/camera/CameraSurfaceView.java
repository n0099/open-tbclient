package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes5.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    SurfaceHolder f2290a;

    /* renamed from: b  reason: collision with root package name */
    private b f2291b;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2290a = getHolder();
        this.f2290a.setFormat(-2);
        this.f2290a.setSizeFromLayout();
        this.f2290a.setType(3);
        this.f2290a.addCallback(this);
    }

    public void setCameraInterface(b bVar) {
        this.f2291b = bVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtil.d("surfaceChanged被调用了");
        if (getContext() instanceof Activity) {
            this.f2291b.a((Activity) getContext(), this.f2290a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.d("surfaceDestroyed被调用了");
        this.f2291b.d();
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.f2291b.a((Activity) getContext(), this.f2290a);
        }
    }
}
