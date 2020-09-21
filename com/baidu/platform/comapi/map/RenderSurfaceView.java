package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.ae;
/* loaded from: classes3.dex */
public class RenderSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    protected ad k;

    public RenderSurfaceView(Context context) {
        super(context);
        a(context, ae.a.AUTO);
    }

    public RenderSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, ae.a.AUTO);
    }

    public RenderSurfaceView(Context context, ae.a aVar) {
        super(context);
        a(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad a(ae.a aVar) {
        return ae.a(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, ae.a aVar) {
        if (this.k != null) {
            return;
        }
        this.k = a(aVar);
        getHolder().addCallback(this);
    }

    public Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return this.k.a(i, i2, i3, i4, obj, config);
    }

    public int getDebugFlags() {
        return this.k.d();
    }

    public ad getRenderControl() {
        return this.k;
    }

    public int getRenderMode() {
        return this.k.e();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k.i();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.k.j();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.k.g();
    }

    public void onResume() {
        this.k.h();
    }

    public void queueEvent(Runnable runnable) {
        this.k.a(runnable);
    }

    public void requestRender() {
        this.k.f();
    }

    public void setDebugFlags(int i) {
        this.k.a(i);
    }

    public void setRenderMode(int i) {
        this.k.c(i);
    }

    public void setRenderer(ak akVar) {
        this.k.a(akVar);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.k.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.k.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.k.surfaceDestroyed(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    @TargetApi(26)
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        this.k.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }
}
