package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class BaseGLMapView extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    protected static Context b;
    private static final String d = BaseGLMapView.class.getSimpleName();
    protected e a;
    public GLSurfaceView.Renderer c;
    private GestureDetector e;
    private boolean f;

    public BaseGLMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.c = new a(this);
        b = context;
        a();
        b();
        setZOrderMediaOverlay(true);
        setRenderer(this.c);
    }

    private void a() {
        if (this.a == null) {
            this.a = new e(b);
        }
    }

    private void b() {
        this.e = new GestureDetector(b, this);
        this.e.setOnDoubleTapListener(this);
        setLongClickable(true);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        this.a.d();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.a.e();
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
        this.a.a(surfaceHolder.getSurface(), i2, i3, com.baidu.pano.platform.c.h.b(b));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if ((motionEvent.getAction() & 255) == 5) {
            z = this.a.c(motionEvent);
            z2 = false;
        } else if (this.e != null) {
            z2 = this.e.onTouchEvent(motionEvent);
            z = this.a.c(motionEvent);
        } else {
            z = false;
            z2 = false;
        }
        return z2 || z;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.a != null) {
            return this.a.a(motionEvent);
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
        if (this.a != null) {
            return this.a.a(motionEvent, motionEvent2, f, f2);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a != null) {
            return this.a.b(motionEvent, motionEvent2, f, f2);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.a.c(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a != null) {
            return this.a.b(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
