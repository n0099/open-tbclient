package com.baidu.ar.arplay.core.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes14.dex */
public class a {
    private b el;
    private boolean em = true;
    private boolean en = false;
    private boolean eo = false;
    private boolean isScreenOrientationLandscape = false;
    private int ep = 0;
    private int eq = 0;
    private c er = c.EStatSingFingerCandidate;
    private e es = null;
    private Map<Integer, Vector<Float>> et = new HashMap();
    private boolean eu = true;
    private e ev = new e();
    private e ew = new e();
    private e ex = new e();
    private e ey = new e();
    private double ez = -1.0d;
    private boolean eA = true;
    private boolean eB = false;
    private d eC = d.ESWIPE_RIGHT;
    private com.baidu.ar.arplay.core.engine.b ek = new com.baidu.ar.arplay.core.engine.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public enum EnumC0075a {
        EGESTURE_CLICK,
        EGESTURE_DOUBLE_CLICK,
        EGESTURE_LONG_PRESS,
        EGESTURE_SWIPE,
        EGESTURE_SINGLE_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_PINCH,
        EGESTURE_TWO_FINGER_UNPINCH,
        EGESTURE_TWO_FINGER_ROTATE,
        EGESTURE_CLEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (a.this.eo) {
                return;
            }
            switch (message.what) {
                case 1:
                    if (a.this.er == c.EStatSingFingerCandidate && a.this.eu) {
                        a.this.er = c.EStatLongPress;
                        a.this.b(System.currentTimeMillis(), a.this.ev.id, a.this.ev.x, a.this.ev.y);
                        return;
                    }
                    return;
                case 2:
                    if (message.obj != null) {
                        e eVar = (e) message.obj;
                        a.this.a(eVar.time, eVar.id, eVar.x, eVar.y);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum c {
        EStatSingFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPress,
        EStatScroll,
        EStatSwipe,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatTwoFingersRotate,
        EStatUnknown
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class e {
        int id;
        long time;
        float x;
        float y;

        private e() {
            this.id = -1;
            this.x = -1.0f;
            this.y = -1.0f;
            this.time = -1L;
        }

        public void a(MotionEvent motionEvent, int i) {
            this.id = motionEvent.getPointerId(i);
            this.x = motionEvent.getX(i);
            this.y = motionEvent.getY(i);
            this.time = motionEvent.getEventTime();
        }

        public String toString() {
            return "fingerId: " + this.id + " && x,y: " + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + " && time: " + this.time;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum f {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    public a(Looper looper) {
        this.el = new b(looper);
        onResume();
    }

    private double a(double d2, double d3, double d4, double d5) {
        double atan2 = Math.atan2(d5, d4) - Math.atan2(d3, d2);
        return atan2 > 3.141592653589793d ? atan2 - 6.283185307179586d : atan2 < -3.141592653589793d ? atan2 + 6.283185307179586d : atan2;
    }

    private double a(float f2, float f3, float f4, float f5) {
        return Math.sqrt(((f4 - f2) * (f4 - f2)) + ((f5 - f3) * (f5 - f3)));
    }

    private double a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f4 - f2;
        float f11 = f5 - f3;
        float f12 = f8 - f6;
        float f13 = f9 - f7;
        Log.d("ARPTouchInput", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)));
        double sqrt = ((f10 * f12) + (f11 * f13)) / (Math.sqrt((f10 * f10) + (f11 * f11)) * Math.sqrt((f12 * f12) + (f13 * f13)));
        try {
            sqrt = Double.parseDouble(new DecimalFormat("#.00").format(sqrt));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        double acos = Math.acos(sqrt);
        Log.d("ARPTouchInput", String.format("angle is %1.3f", Double.valueOf(Math.toDegrees(acos))));
        return acos;
    }

    private void a(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        if (this.isScreenOrientationLandscape) {
            f8 = this.ep - f3;
            f7 = -f5;
        } else {
            f7 = f4;
            f8 = f2;
            f2 = f3;
            f4 = f5;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ep <= 0 || this.eq <= 0) {
            f9 = f4;
            f10 = f7;
            f11 = f2;
            f12 = f8;
        } else {
            float f13 = windowSize[0] / this.ep;
            float f14 = windowSize[1] / this.eq;
            float f15 = f8 * f13;
            f9 = f4 * f14;
            f10 = f7 * f13;
            f11 = f2 * f14;
            f12 = f15;
        }
        ARPEngine.getInstance().onTouchUpdate(i, f12, f11, f10, f9, j, i2, f6);
    }

    private void a(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        if (this.isScreenOrientationLandscape) {
            f12 = this.ep - f3;
            f11 = this.ep - f7;
        } else {
            f11 = f6;
            f12 = f2;
            f2 = f3;
            f6 = f7;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ep <= 0 || this.eq <= 0) {
            f13 = f9;
            f14 = f8;
            f15 = f6;
            f16 = f11;
            f17 = f5;
            f18 = f4;
            f19 = f2;
            f20 = f12;
        } else {
            float f21 = windowSize[0] / this.ep;
            float f22 = windowSize[1] / this.eq;
            f13 = f9 * f22;
            f14 = f8 * f21;
            f15 = f6 * f22;
            f16 = f11 * f21;
            f17 = f5 * f22;
            f18 = f4 * f21;
            f19 = f2 * f22;
            f20 = f12 * f21;
        }
        ARPEngine.getInstance().onGestureUpdate(i, j, i2, f20, f19, f18, f17, i3, f16, f15, f14, f13, i4, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, float f2, float f3) {
        if (this.ek == null || !this.ek.bc()) {
            return;
        }
        a(EnumC0075a.EGESTURE_CLICK.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        aY();
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5) {
        if (this.ek == null || !this.ek.bf()) {
            return;
        }
        a(EnumC0075a.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9) {
        if (this.ek == null || !this.ek.bg()) {
            return;
        }
        a(EnumC0075a.EGESTURE_TWO_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9, boolean z) {
        if (this.ek == null || !this.ek.bi()) {
            return;
        }
        if (!this.eA) {
            if ((z && !this.eB) || (!z && this.eB)) {
                aY();
            }
            this.eB = z;
        }
        int ordinal = EnumC0075a.EGESTURE_TWO_FINGER_UNPINCH.ordinal();
        if (z) {
            ordinal = EnumC0075a.EGESTURE_TWO_FINGER_PINCH.ordinal();
        }
        a(ordinal, j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
        if (this.eA) {
            this.eB = z;
        }
    }

    private void a(long j, int i, float f2, float f3, int i2, float f4, float f5, float f6) {
        if (this.ek == null || !this.ek.bj()) {
            return;
        }
        a(EnumC0075a.EGESTURE_TWO_FINGER_ROTATE.ordinal(), j, i, f2, f3, -1.0f, -1.0f, i2, f4, f5, -1.0f, -1.0f, -1, f6);
    }

    private void a(long j, int i, int i2) {
        if (this.ek == null || !this.ek.bh()) {
            return;
        }
        a(EnumC0075a.EGESTURE_SWIPE.ordinal(), j, i, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, i2, 0.0f);
        clearStatus();
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 0) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        long eventTime = motionEvent.getEventTime();
        float pressure = motionEvent.getPressure(actionIndex);
        float f2 = 0.0f;
        float f3 = 0.0f;
        switch (actionMasked) {
            case 0:
            case 5:
                Vector<Float> vector = new Vector<>(2);
                vector.add(Float.valueOf(x));
                vector.add(Float.valueOf(y));
                this.et.put(Integer.valueOf(pointerId), vector);
                a(pointerId, x, y, 0.0f, 0.0f, eventTime, f.ETOUCH_BEGIN.ordinal(), pressure);
                return;
            case 1:
            case 6:
                if (this.et.containsKey(Integer.valueOf(pointerId))) {
                    Vector<Float> vector2 = this.et.get(Integer.valueOf(pointerId));
                    f2 = x - vector2.elementAt(0).floatValue();
                    f3 = y - vector2.elementAt(1).floatValue();
                    this.et.remove(Integer.valueOf(pointerId));
                }
                a(pointerId, x, y, f2, f3, eventTime, f.ETOUCH_END.ordinal(), pressure);
                return;
            case 2:
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    float x2 = motionEvent.getX(i);
                    float y2 = motionEvent.getY(i);
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    if (this.et.containsKey(Integer.valueOf(pointerId2))) {
                        Vector<Float> vector3 = this.et.get(Integer.valueOf(pointerId2));
                        float floatValue = x2 - vector3.firstElement().floatValue();
                        f5 = y2 - vector3.lastElement().floatValue();
                        vector3.setElementAt(Float.valueOf(x2), 0);
                        vector3.setElementAt(Float.valueOf(y2), 1);
                        f4 = floatValue;
                    }
                    if (Math.abs(f4) > 0.1f || Math.abs(f5) > 0.1f) {
                        a(pointerId2, x2, y2, f4, f5, eventTime, f.ETOUCH_MOVE.ordinal(), motionEvent.getPressure(i));
                    }
                }
                return;
            case 3:
                if (this.et.containsKey(Integer.valueOf(pointerId))) {
                    Vector<Float> vector4 = this.et.get(Integer.valueOf(pointerId));
                    f2 = x - vector4.elementAt(0).floatValue();
                    f3 = y - vector4.elementAt(1).floatValue();
                    this.et.remove(Integer.valueOf(pointerId));
                }
                a(pointerId, x, y, f2, f3, eventTime, f.ETOUCH_CANCEL.ordinal(), pressure);
                return;
            case 4:
            default:
                return;
        }
    }

    private void a(e eVar, e eVar2) {
        eVar2.id = eVar.id;
        eVar2.x = eVar.x;
        eVar2.y = eVar.y;
        eVar2.time = eVar.time;
    }

    private void aY() {
        a(EnumC0075a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void aZ() {
        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(EnumC0075a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i, float f2, float f3) {
        if (this.ek == null || !this.ek.be()) {
            return;
        }
        a(EnumC0075a.EGESTURE_LONG_PRESS.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void b(MotionEvent motionEvent) {
        switch (this.er) {
            case EStatSingFingerCandidate:
                c(motionEvent);
                return;
            case EStatTwoFingersCandidate:
                h(motionEvent);
                return;
            case EStatScroll:
                i(motionEvent);
                return;
            case EStatSwipe:
                j(motionEvent);
                return;
            case EStatTwoFingersScroll:
                k(motionEvent);
                return;
            case EStatPinchAndUnpinch:
                l(motionEvent);
                return;
            case EStatTwoFingersRotate:
                m(motionEvent);
                return;
            case EStatLongPress:
                n(motionEvent);
                return;
            case EScrollAfterLongPress:
                o(motionEvent);
                return;
            case EStatPinch:
            case EStatUnPinch:
            case EStatUnknown:
                p(motionEvent);
                return;
            default:
                return;
        }
    }

    private void ba() {
        if (this.el.hasMessages(2)) {
            this.el.removeMessages(2);
            if (this.es != null) {
                a(this.es.time, this.es.id, this.es.x, this.es.y);
                this.es = null;
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                d(motionEvent);
                return;
            case 1:
                f(motionEvent);
                return;
            case 2:
                e(motionEvent);
                return;
            case 3:
            case 4:
            default:
                return;
            case 5:
                g(motionEvent);
                return;
        }
    }

    private void clearStatus() {
        this.er = c.EStatSingFingerCandidate;
        this.eu = true;
        this.ez = -1.0d;
        this.el.removeMessages(1);
        if (this.el.hasMessages(2)) {
            return;
        }
        aY();
    }

    private void d(MotionEvent motionEvent) {
        this.ev.a(motionEvent, motionEvent.getActionIndex());
        a(this.ev, this.ew);
        Log.d("ARPTouchInput", "touchDownInSingleFingerCandidate() mFirstFingerTouch = " + this.ev.toString());
        if (this.el.hasMessages(2) && this.es != null && a(this.es.x, this.es.y, this.ev.x, this.ev.y) > 100.0d) {
            ba();
        }
        this.el.sendEmptyMessageDelayed(1, 600L);
    }

    private void e(MotionEvent motionEvent) {
        double a2 = a(this.ev.x, this.ev.y, motionEvent.getX(), motionEvent.getY());
        Log.d("ARPTouchInput", "touchMoveInSingleFingerCandidate() distance = " + a2);
        if (a2 < 20.0d) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                this.er = c.EStatLongPress;
                b(motionEvent.getDownTime(), this.ev.id, motionEvent.getX(), motionEvent.getY());
                this.el.removeMessages(1);
            }
        } else if (a2 < 50.0d) {
            this.eu = false;
        } else {
            ba();
            this.er = c.EStatScroll;
            a(motionEvent.getEventTime(), this.ev.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.el.removeMessages(1);
        }
        this.ew.a(motionEvent, 0);
    }

    private void f(MotionEvent motionEvent) {
        if (a(this.ev.x, this.ev.y, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300) {
            if (this.ek == null || !this.ek.bd()) {
                a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
            } else if (this.el.hasMessages(2)) {
                this.el.removeMessages(2);
                a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
            } else {
                Message obtain = Message.obtain();
                obtain.what = 2;
                e eVar = new e();
                eVar.a(motionEvent, 0);
                obtain.obj = eVar;
                this.es = eVar;
                this.el.sendMessageDelayed(obtain, 400L);
            }
        }
        clearStatus();
    }

    private void g(MotionEvent motionEvent) {
        Log.d("ARPTouchInput", "touchPointerDownInSingleFingerCandidate() mFirstFingnerInClickArea = " + this.eu);
        if (this.eu) {
            this.ex.a(motionEvent, motionEvent.getActionIndex());
            a(this.ex, this.ey);
            this.er = c.EStatTwoFingersCandidate;
        } else {
            this.er = c.EStatUnknown;
        }
        ba();
    }

    private void h(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            this.er = c.EStatUnknown;
            return;
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        double a2 = a(this.ev.x, this.ev.y, u, v);
        double a3 = a(this.ex.x, this.ex.y, w, x);
        if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
            double a4 = a(this.ev.x, this.ev.y, u, v, this.ex.x, this.ex.y, w, x);
            if (a4 < 0.7853981633974483d) {
                this.er = c.EStatTwoFingersScroll;
                a(motionEvent.getDownTime(), this.ev.id, u, v, q(motionEvent), r(motionEvent), this.ex.id, w, x, s(motionEvent), t(motionEvent));
                Log.d("ARPTouchInput", "EStatTwoFingersScroll");
            } else if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                this.er = c.EStatPinchAndUnpinch;
                this.ez = a(u, v, w, x);
            } else {
                float f2 = (this.ev.x + this.ex.x) / 2.0f;
                float f3 = (this.ev.y + this.ex.y) / 2.0f;
                double a5 = a(f2, f3, this.ev.x, this.ev.y, this.ev.x, this.ev.y, u, v);
                double a6 = a(f2, f3, this.ex.x, this.ex.y, this.ex.x, this.ex.y, w, x);
                if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                    this.er = c.EStatTwoFingersRotate;
                } else {
                    this.er = c.EStatPinchAndUnpinch;
                    this.ez = a(u, v, w, x);
                }
            }
        }
        this.ew.x = u;
        this.ew.y = v;
        this.ew.time = motionEvent.getEventTime();
        this.ey.x = w;
        this.ey.y = x;
        this.ey.time = motionEvent.getEventTime();
    }

    private void i(MotionEvent motionEvent) {
        try {
            if (5 == motionEvent.getActionMasked()) {
                this.ev.a(motionEvent, this.ev.id);
                a(this.ev, this.ew);
                this.ex.a(motionEvent, motionEvent.getActionIndex());
                a(this.ex, this.ey);
                this.er = c.EStatTwoFingersCandidate;
                if (this.ek == null || !this.ek.bf()) {
                    return;
                }
                aY();
            } else if (6 == motionEvent.getActionMasked()) {
                this.er = c.EStatUnknown;
            } else if (1 == motionEvent.getActionMasked()) {
                clearStatus();
            } else if (2 != motionEvent.getActionMasked()) {
                this.er = c.EStatUnknown;
            } else if (motionEvent.getEventTime() - this.ew.time >= 1) {
                float u = u(motionEvent);
                float v = v(motionEvent);
                a(motionEvent.getEventTime(), this.ev.id, u, v, q(motionEvent), r(motionEvent));
                float f2 = u - this.ew.x;
                float f3 = v - this.ew.y;
                float eventTime = f2 / ((float) (motionEvent.getEventTime() - this.ew.time));
                float eventTime2 = f3 / ((float) (motionEvent.getEventTime() - this.ew.time));
                if (Math.abs(f2) > Math.abs(f3) && Math.abs(f2) > 100.0d && Math.abs(eventTime) > 20.0d) {
                    if (f2 > 0.0f) {
                        this.eC = d.ESWIPE_RIGHT;
                    } else {
                        this.eC = d.ESWIPE_LEFT;
                    }
                    this.er = c.EStatSwipe;
                } else if (Math.abs(f3) > Math.abs(f2) && Math.abs(f3) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                    if (f3 > 0.0f) {
                        this.eC = d.ESWIPE_DOWN;
                    } else {
                        this.eC = d.ESWIPE_UP;
                    }
                    this.er = c.EStatSwipe;
                }
                this.ew.x = u;
                this.ew.y = v;
                this.ew.time = motionEvent.getEventTime();
            }
        } catch (Exception e2) {
            Log.e("ARPTouchInput", "Monkey event.getX Exception");
        }
    }

    private void j(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            a(motionEvent.getEventTime(), this.ev.id, this.eC.ordinal());
        }
    }

    private void k(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.er = c.EStatUnknown;
        } else if (6 == motionEvent.getActionMasked()) {
            this.er = c.EStatScroll;
            if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.ev.id) {
                a(this.ex, this.ev);
                a(this.ey, this.ew);
            }
            aY();
        } else if (2 != motionEvent.getActionMasked()) {
            this.er = c.EStatUnknown;
        } else if (motionEvent.getEventTime() - this.ew.time < 1 || motionEvent.getEventTime() - this.ey.time < 1) {
        } else {
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            a(motionEvent.getEventTime(), this.ev.id, u, v, q(motionEvent), r(motionEvent), this.ex.id, w, x, s(motionEvent), t(motionEvent));
            this.ev.x = u;
            this.ev.y = v;
            this.ew.time = motionEvent.getEventTime();
            this.ey.x = w;
            this.ey.y = x;
            this.ey.time = motionEvent.getEventTime();
        }
    }

    private void l(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.er = c.EStatUnknown;
            this.eA = true;
        } else if (6 == motionEvent.getActionMasked()) {
            this.er = c.EStatScroll;
            if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.ev.id) {
                this.ev.id = this.ex.id;
            }
            this.eA = true;
            aZ();
        } else if (2 != motionEvent.getActionMasked()) {
            this.er = c.EStatUnknown;
        } else if (motionEvent.getEventTime() - this.ew.time < 1 || motionEvent.getEventTime() - this.ey.time < 1) {
        } else {
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            double a2 = a(u, v, w, x);
            a(motionEvent.getEventTime(), this.ev.id, u, v, q(motionEvent), r(motionEvent), this.ex.id, w, x, s(motionEvent), t(motionEvent), a2 < this.ez);
            this.ez = a2;
            this.ev.x = u;
            this.ev.y = v;
            this.ew.time = motionEvent.getEventTime();
            this.ey.x = w;
            this.ey.y = x;
            this.ey.time = motionEvent.getEventTime();
        }
    }

    private void m(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.er = c.EStatUnknown;
                return;
            }
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        a(motionEvent.getEventTime(), this.ev.id, u, v, this.ex.id, w, x, (float) a(this.ey.x - this.ev.x, this.ey.y - this.ev.y, w - u, x - v));
        this.ev.x = u;
        this.ev.y = v;
        this.ew.time = motionEvent.getEventTime();
        this.ey.x = w;
        this.ey.y = x;
        this.ey.time = motionEvent.getEventTime();
    }

    private void n(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
            } else {
                this.er = c.EStatUnknown;
            }
        } else if (a(this.ev.x, this.ev.y, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
            this.er = c.EScrollAfterLongPress;
            a(motionEvent.getEventTime(), this.ev.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.ev.x = u(motionEvent);
            this.ev.y = v(motionEvent);
            this.ew.time = motionEvent.getEventTime();
        }
    }

    private void o(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.er = c.EStatUnknown;
                return;
            }
        }
        a(motionEvent.getEventTime(), this.ev.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
        this.ev.x = u(motionEvent);
        this.ev.y = v(motionEvent);
        this.ew.time = motionEvent.getEventTime();
    }

    private void p(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            clearStatus();
        }
    }

    private float q(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.ev.id)) - this.ev.x) / ((float) (motionEvent.getEventTime() - this.ew.time));
    }

    private float r(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.ev.id)) - this.ev.y) / ((float) (motionEvent.getEventTime() - this.ew.time));
    }

    private float s(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.ex.id)) - this.ey.x) / ((float) (motionEvent.getEventTime() - this.ey.time));
    }

    private float t(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.ex.id)) - this.ey.y) / ((float) (motionEvent.getEventTime() - this.ey.time));
    }

    private float u(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.ev.id));
    }

    private float v(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.ev.id));
    }

    private float w(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.ex.id));
    }

    private float x(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.ex.id));
    }

    public void d(int i, int i2) {
        Log.d("ARPTouchInput", "setScreenWidthHight width * height = " + i + " * " + i2);
        if (this.isScreenOrientationLandscape) {
            this.ep = i2;
            this.eq = i;
            return;
        }
        this.ep = i;
        this.eq = i2;
    }

    public void j(boolean z) {
        this.en = z;
    }

    public void k(boolean z) {
        this.em = z;
    }

    public void onPause() {
        if (this.ek != null) {
            this.ek.onPause();
        }
    }

    public void onResume() {
        if (this.ek != null) {
            this.ek.onResume();
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.en && this.em && !this.eo) {
            a(motionEvent);
            b(motionEvent);
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Log.d("ARPTouchInput", "setScreenOrientationLandscape landscape = " + z);
        this.isScreenOrientationLandscape = z;
    }
}
