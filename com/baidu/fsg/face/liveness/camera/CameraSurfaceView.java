package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes17.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    SurfaceHolder f1722a;
    private b b;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1722a = getHolder();
        this.f1722a.setFormat(-2);
        this.f1722a.setSizeFromLayout();
        this.f1722a.setType(3);
        this.f1722a.addCallback(this);
    }

    public void setCameraInterface(b bVar) {
        this.b = bVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtil.d("surfaceChanged被调用了");
        if (getContext() instanceof Activity) {
            this.b.a((Activity) getContext(), this.f1722a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.d("surfaceDestroyed被调用了");
        this.b.d();
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.b.a((Activity) getContext(), this.f1722a);
        }
    }
}
