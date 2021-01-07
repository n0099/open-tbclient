package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public class ah extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private MapController f4299a;

    /* renamed from: b  reason: collision with root package name */
    private OnLongPressListener f4300b;
    private volatile Set<GestureDetector.SimpleOnGestureListener> c = new CopyOnWriteArraySet();
    private Object d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnLongPressListener a() {
        return this.f4300b;
    }

    public void a(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.add(simpleOnGestureListener);
        }
    }

    public void a(MapController mapController) {
        this.f4299a = mapController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OnLongPressListener onLongPressListener) {
        this.f4300b = onLongPressListener;
    }

    public void b(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.remove(simpleOnGestureListener);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onDoubleTap(motionEvent);
                }
            }
        }
        if (this.f4299a != null) {
            this.f4299a.handleDoubleDownClick(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onDoubleTapEvent(motionEvent);
                }
            }
        }
        if (motionEvent.getAction() == 1 && this.f4299a != null) {
            this.f4299a.handleDoubleTouch(motionEvent);
        }
        return super.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onDown(motionEvent);
                }
            }
        }
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onFling(motionEvent, motionEvent2, f, f2);
                }
            }
        }
        if (this.f4299a == null) {
            return false;
        }
        if (this.f4299a.getMapControlMode() == MapController.MapControlMode.STREET) {
            this.f4299a.handleTouchUp(motionEvent2);
        }
        return this.f4299a.handleFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onLongPress(motionEvent);
                    }
                }
            }
        }
        if (this.f4299a == null || this.f4299a.isEnableDMoveZoom() || this.f4299a.isNaviMode() || this.f4300b == null) {
            return;
        }
        this.f4300b.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onScroll(motionEvent, motionEvent2, f, f2);
                }
            }
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onShowPress(motionEvent);
                    }
                }
            }
        }
        super.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onSingleTapConfirmed(motionEvent);
                    }
                }
            }
        }
        return this.f4299a != null && this.f4299a.handleTouchSingleClick(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    simpleOnGestureListener.onSingleTapUp(motionEvent);
                }
            }
        }
        return super.onSingleTapUp(motionEvent);
    }
}
