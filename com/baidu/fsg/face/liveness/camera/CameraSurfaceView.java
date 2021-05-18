package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f6004a;

    /* renamed from: b  reason: collision with root package name */
    public b f6005b;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceHolder holder = getHolder();
        this.f6004a = holder;
        holder.setFormat(-2);
        this.f6004a.setSizeFromLayout();
        this.f6004a.setType(3);
        this.f6004a.addCallback(this);
    }

    public void setCameraInterface(b bVar) {
        this.f6005b = bVar;
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.f6005b.a((Activity) getContext(), this.f6004a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        LogUtil.d("surfaceChanged被调用了");
        if (getContext() instanceof Activity) {
            this.f6005b.a((Activity) getContext(), this.f6004a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.d("surfaceDestroyed被调用了");
        this.f6005b.d();
    }
}
