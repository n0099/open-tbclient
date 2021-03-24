package com.baidu.pano.platform.comapi.map;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
/* loaded from: classes2.dex */
public abstract class BaseGLMapView extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    /* renamed from: b  reason: collision with root package name */
    public static Context f9471b;

    /* renamed from: d  reason: collision with root package name */
    public static final String f9472d = BaseGLMapView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public e f9473a;

    /* renamed from: c  reason: collision with root package name */
    public GLSurfaceView.Renderer f9474c;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f9475e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9476f;

    public BaseGLMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9476f = false;
        this.f9474c = new a(this);
        f9471b = context;
        a();
        b();
        setZOrderMediaOverlay(true);
        setRenderer(this.f9474c);
    }

    private void a() {
        if (this.f9473a == null) {
            this.f9473a = new e(f9471b);
        }
    }

    private void b() {
        GestureDetector gestureDetector = new GestureDetector(f9471b, this);
        this.f9475e = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        setLongClickable(true);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.b(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.a(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.b(motionEvent, motionEvent2, f2, f3);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f9473a.e();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        this.f9473a.d();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f9473a;
        if (eVar != null) {
            return eVar.a(motionEvent, motionEvent2, f2, f3);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f9473a.c(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean onTouchEvent;
        if ((motionEvent.getAction() & 255) == 5) {
            z = this.f9473a.c(motionEvent);
        } else {
            GestureDetector gestureDetector = this.f9475e;
            if (gestureDetector != null) {
                onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                z = this.f9473a.c(motionEvent);
                return !onTouchEvent || z;
            }
            z = false;
        }
        onTouchEvent = false;
        if (onTouchEvent) {
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f9473a.a(surfaceHolder.getSurface(), i2, i3, com.baidu.pano.platform.c.h.b(f9471b));
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
    }
}
