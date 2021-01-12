package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class BaseGLMapView extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    /* renamed from: b  reason: collision with root package name */
    protected static Context f3921b;
    private static final String d = BaseGLMapView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected e f3922a;
    public GLSurfaceView.Renderer c;
    private GestureDetector e;
    private boolean f;

    public BaseGLMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.c = new a(this);
        f3921b = context;
        a();
        b();
        setZOrderMediaOverlay(true);
        setRenderer(this.c);
    }

    private void a() {
        if (this.f3922a == null) {
            this.f3922a = new e(f3921b);
        }
    }

    private void b() {
        this.e = new GestureDetector(f3921b, this);
        this.e.setOnDoubleTapListener(this);
        setLongClickable(true);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        this.f3922a.d();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f3922a.e();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f3922a.a(surfaceHolder.getSurface(), i2, i3, com.baidu.pano.platform.c.h.b(f3921b));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if ((motionEvent.getAction() & 255) == 5) {
            z = this.f3922a.c(motionEvent);
            z2 = false;
        } else if (this.e != null) {
            z2 = this.e.onTouchEvent(motionEvent);
            z = this.f3922a.c(motionEvent);
        } else {
            z = false;
            z2 = false;
        }
        return z2 || z;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.f3922a != null) {
            return this.f3922a.a(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f3922a != null) {
            return this.f3922a.a(motionEvent, motionEvent2, f, f2);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f3922a != null) {
            return this.f3922a.b(motionEvent, motionEvent2, f, f2);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f3922a.c(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f3922a != null) {
            return this.f3922a.b(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
