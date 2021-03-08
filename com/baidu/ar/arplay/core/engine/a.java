package com.baidu.ar.arplay.core.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes3.dex */
public class a {
    private b et;
    private boolean eu = true;
    private boolean ev = false;
    private boolean ew = false;
    private boolean isScreenOrientationLandscape = false;
    private int ex = 0;
    private int ey = 0;
    private c ez = c.EStatSingFingerCandidate;
    private e eA = null;
    private Map<Integer, Vector<Float>> eB = new HashMap();
    private boolean eC = true;
    private e eD = new e();
    private e eE = new e();
    private e eF = new e();
    private e eG = new e();
    private double eH = -1.0d;
    private boolean eI = true;
    private boolean eJ = false;
    private d eK = d.ESWIPE_RIGHT;
    private com.baidu.ar.arplay.core.engine.b es = new com.baidu.ar.arplay.core.engine.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0076a {
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
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (a.this.ew) {
                return;
            }
            switch (message.what) {
                case 1:
                    if (a.this.ez == c.EStatSingFingerCandidate && a.this.eC) {
                        a.this.ez = c.EStatLongPress;
                        a.this.b(System.currentTimeMillis(), a.this.eD.id, a.this.eD.x, a.this.eD.y);
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
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            return "fingerId: " + this.id + " && x,y: " + this.x + "," + this.y + " && time: " + this.time;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum f {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    public a(Looper looper) {
        this.et = new b(looper);
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
            f8 = this.ex - f3;
            f7 = -f5;
            f5 = f4;
            f3 = f2;
        } else {
            f7 = f4;
            f8 = f2;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ex <= 0 || this.ey <= 0) {
            f9 = f5;
            f10 = f7;
            f11 = f3;
            f12 = f8;
        } else {
            float f13 = windowSize[0] / this.ex;
            float f14 = windowSize[1] / this.ey;
            float f15 = f8 * f13;
            f9 = f5 * f14;
            f10 = f7 * f13;
            f11 = f3 * f14;
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
            f12 = this.ex - f3;
            f11 = this.ex - f7;
            f7 = f6;
            f3 = f2;
        } else {
            f11 = f6;
            f12 = f2;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ex <= 0 || this.ey <= 0) {
            f13 = f9;
            f14 = f8;
            f15 = f7;
            f16 = f11;
            f17 = f5;
            f18 = f4;
            f19 = f3;
            f20 = f12;
        } else {
            float f21 = windowSize[0] / this.ex;
            float f22 = windowSize[1] / this.ey;
            f13 = f9 * f22;
            f14 = f8 * f21;
            f15 = f7 * f22;
            f16 = f11 * f21;
            f17 = f5 * f22;
            f18 = f4 * f21;
            f19 = f3 * f22;
            f20 = f12 * f21;
        }
        ARPEngine.getInstance().onGestureUpdate(i, j, i2, f20, f19, f18, f17, i3, f16, f15, f14, f13, i4, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, float f2, float f3) {
        if (this.es == null || !this.es.aW()) {
            return;
        }
        a(EnumC0076a.EGESTURE_CLICK.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        aS();
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5) {
        if (this.es == null || !this.es.aZ()) {
            return;
        }
        a(EnumC0076a.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9) {
        if (this.es == null || !this.es.ba()) {
            return;
        }
        a(EnumC0076a.EGESTURE_TWO_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9, boolean z) {
        if (this.es == null || !this.es.bc()) {
            return;
        }
        if (!this.eI) {
            if ((z && !this.eJ) || (!z && this.eJ)) {
                aS();
            }
            this.eJ = z;
        }
        int ordinal = EnumC0076a.EGESTURE_TWO_FINGER_UNPINCH.ordinal();
        if (z) {
            ordinal = EnumC0076a.EGESTURE_TWO_FINGER_PINCH.ordinal();
        }
        a(ordinal, j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
        if (this.eI) {
            this.eJ = z;
        }
    }

    private void a(long j, int i, float f2, float f3, int i2, float f4, float f5, float f6) {
        if (this.es == null || !this.es.bd()) {
            return;
        }
        a(EnumC0076a.EGESTURE_TWO_FINGER_ROTATE.ordinal(), j, i, f2, f3, -1.0f, -1.0f, i2, f4, f5, -1.0f, -1.0f, -1, f6);
    }

    private void a(long j, int i, int i2) {
        if (this.es == null || !this.es.bb()) {
            return;
        }
        a(EnumC0076a.EGESTURE_SWIPE.ordinal(), j, i, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, i2, 0.0f);
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
                this.eB.put(Integer.valueOf(pointerId), vector);
                a(pointerId, x, y, 0.0f, 0.0f, eventTime, f.ETOUCH_BEGIN.ordinal(), pressure);
                return;
            case 1:
            case 6:
                if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                    Vector<Float> vector2 = this.eB.get(Integer.valueOf(pointerId));
                    f2 = x - vector2.elementAt(0).floatValue();
                    f3 = y - vector2.elementAt(1).floatValue();
                    this.eB.remove(Integer.valueOf(pointerId));
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
                    if (this.eB.containsKey(Integer.valueOf(pointerId2))) {
                        Vector<Float> vector3 = this.eB.get(Integer.valueOf(pointerId2));
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
                if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                    Vector<Float> vector4 = this.eB.get(Integer.valueOf(pointerId));
                    f2 = x - vector4.elementAt(0).floatValue();
                    f3 = y - vector4.elementAt(1).floatValue();
                    this.eB.remove(Integer.valueOf(pointerId));
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

    private void aS() {
        a(EnumC0076a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void aT() {
        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(EnumC0076a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
    }

    private void aU() {
        if (this.et.hasMessages(2)) {
            this.et.removeMessages(2);
            if (this.eA != null) {
                a(this.eA.time, this.eA.id, this.eA.x, this.eA.y);
                this.eA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i, float f2, float f3) {
        if (this.es == null || !this.es.aY()) {
            return;
        }
        a(EnumC0076a.EGESTURE_LONG_PRESS.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void b(MotionEvent motionEvent) {
        switch (this.ez) {
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
        this.ez = c.EStatSingFingerCandidate;
        this.eC = true;
        this.eH = -1.0d;
        this.et.removeMessages(1);
        if (this.et.hasMessages(2)) {
            return;
        }
        aS();
    }

    private void d(MotionEvent motionEvent) {
        this.eD.a(motionEvent, motionEvent.getActionIndex());
        a(this.eD, this.eE);
        Log.d("ARPTouchInput", "touchDownInSingleFingerCandidate() mFirstFingerTouch = " + this.eD.toString());
        if (this.et.hasMessages(2) && this.eA != null && a(this.eA.x, this.eA.y, this.eD.x, this.eD.y) > 100.0d) {
            aU();
        }
        this.et.sendEmptyMessageDelayed(1, 600L);
    }

    private void e(MotionEvent motionEvent) {
        double a2 = a(this.eD.x, this.eD.y, motionEvent.getX(), motionEvent.getY());
        Log.d("ARPTouchInput", "touchMoveInSingleFingerCandidate() distance = " + a2);
        if (a2 < 20.0d) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                this.ez = c.EStatLongPress;
                b(motionEvent.getDownTime(), this.eD.id, motionEvent.getX(), motionEvent.getY());
                this.et.removeMessages(1);
            }
        } else if (a2 < 50.0d) {
            this.eC = false;
        } else {
            aU();
            this.ez = c.EStatScroll;
            a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.et.removeMessages(1);
        }
        this.eE.a(motionEvent, 0);
    }

    private void f(MotionEvent motionEvent) {
        if (a(this.eD.x, this.eD.y, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300) {
            if (this.es == null || !this.es.aX()) {
                a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
            } else if (this.et.hasMessages(2)) {
                this.et.removeMessages(2);
                a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
            } else {
                Message obtain = Message.obtain();
                obtain.what = 2;
                e eVar = new e();
                eVar.a(motionEvent, 0);
                obtain.obj = eVar;
                this.eA = eVar;
                this.et.sendMessageDelayed(obtain, 400L);
            }
        }
        clearStatus();
    }

    private void g(MotionEvent motionEvent) {
        Log.d("ARPTouchInput", "touchPointerDownInSingleFingerCandidate() mFirstFingnerInClickArea = " + this.eC);
        if (this.eC) {
            this.eF.a(motionEvent, motionEvent.getActionIndex());
            a(this.eF, this.eG);
            this.ez = c.EStatTwoFingersCandidate;
        } else {
            this.ez = c.EStatUnknown;
        }
        aU();
    }

    private void h(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
            return;
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        double a2 = a(this.eD.x, this.eD.y, u, v);
        double a3 = a(this.eF.x, this.eF.y, w, x);
        if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
            double a4 = a(this.eD.x, this.eD.y, u, v, this.eF.x, this.eF.y, w, x);
            if (a4 < 0.7853981633974483d) {
                this.ez = c.EStatTwoFingersScroll;
                a(motionEvent.getDownTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
                Log.d("ARPTouchInput", "EStatTwoFingersScroll");
            } else if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                this.ez = c.EStatPinchAndUnpinch;
                this.eH = a(u, v, w, x);
            } else {
                float f2 = (this.eD.x + this.eF.x) / 2.0f;
                float f3 = (this.eD.y + this.eF.y) / 2.0f;
                double a5 = a(f2, f3, this.eD.x, this.eD.y, this.eD.x, this.eD.y, u, v);
                double a6 = a(f2, f3, this.eF.x, this.eF.y, this.eF.x, this.eF.y, w, x);
                if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                    this.ez = c.EStatTwoFingersRotate;
                } else {
                    this.ez = c.EStatPinchAndUnpinch;
                    this.eH = a(u, v, w, x);
                }
            }
        }
        this.eE.x = u;
        this.eE.y = v;
        this.eE.time = motionEvent.getEventTime();
        this.eG.x = w;
        this.eG.y = x;
        this.eG.time = motionEvent.getEventTime();
    }

    private void i(MotionEvent motionEvent) {
        try {
            if (5 == motionEvent.getActionMasked()) {
                this.eD.a(motionEvent, this.eD.id);
                a(this.eD, this.eE);
                this.eF.a(motionEvent, motionEvent.getActionIndex());
                a(this.eF, this.eG);
                this.ez = c.EStatTwoFingersCandidate;
                if (this.es == null || !this.es.aZ()) {
                    return;
                }
                aS();
            } else if (6 == motionEvent.getActionMasked()) {
                this.ez = c.EStatUnknown;
            } else if (1 == motionEvent.getActionMasked()) {
                clearStatus();
            } else if (2 != motionEvent.getActionMasked()) {
                this.ez = c.EStatUnknown;
            } else if (motionEvent.getEventTime() - this.eE.time >= 1) {
                float u = u(motionEvent);
                float v = v(motionEvent);
                a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent));
                float f2 = u - this.eE.x;
                float f3 = v - this.eE.y;
                float eventTime = f2 / ((float) (motionEvent.getEventTime() - this.eE.time));
                float eventTime2 = f3 / ((float) (motionEvent.getEventTime() - this.eE.time));
                if (Math.abs(f2) > Math.abs(f3) && Math.abs(f2) > 100.0d && Math.abs(eventTime) > 20.0d) {
                    if (f2 > 0.0f) {
                        this.eK = d.ESWIPE_RIGHT;
                    } else {
                        this.eK = d.ESWIPE_LEFT;
                    }
                    this.ez = c.EStatSwipe;
                } else if (Math.abs(f3) > Math.abs(f2) && Math.abs(f3) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                    if (f3 > 0.0f) {
                        this.eK = d.ESWIPE_DOWN;
                    } else {
                        this.eK = d.ESWIPE_UP;
                    }
                    this.ez = c.EStatSwipe;
                }
                this.eE.x = u;
                this.eE.y = v;
                this.eE.time = motionEvent.getEventTime();
            }
        } catch (Exception e2) {
            Log.e("ARPTouchInput", "Monkey event.getX Exception");
        }
    }

    private void j(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            a(motionEvent.getEventTime(), this.eD.id, this.eK.ordinal());
        }
    }

    private void k(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
        } else if (6 == motionEvent.getActionMasked()) {
            this.ez = c.EStatScroll;
            if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eD.id) {
                a(this.eF, this.eD);
                a(this.eG, this.eE);
            }
            aS();
        } else if (2 != motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
        } else if (motionEvent.getEventTime() - this.eE.time < 1 || motionEvent.getEventTime() - this.eG.time < 1) {
        } else {
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
            this.eD.x = u;
            this.eD.y = v;
            this.eE.time = motionEvent.getEventTime();
            this.eG.x = w;
            this.eG.y = x;
            this.eG.time = motionEvent.getEventTime();
        }
    }

    private void l(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
            this.eI = true;
        } else if (6 == motionEvent.getActionMasked()) {
            this.ez = c.EStatScroll;
            if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eD.id) {
                this.eD.id = this.eF.id;
            }
            this.eI = true;
            aT();
        } else if (2 != motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
        } else if (motionEvent.getEventTime() - this.eE.time < 1 || motionEvent.getEventTime() - this.eG.time < 1) {
        } else {
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            double a2 = a(u, v, w, x);
            a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent), a2 < this.eH);
            this.eH = a2;
            this.eD.x = u;
            this.eD.y = v;
            this.eE.time = motionEvent.getEventTime();
            this.eG.x = w;
            this.eG.y = x;
            this.eG.time = motionEvent.getEventTime();
        }
    }

    private void m(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.ez = c.EStatUnknown;
                return;
            }
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        a(motionEvent.getEventTime(), this.eD.id, u, v, this.eF.id, w, x, (float) a(this.eG.x - this.eD.x, this.eG.y - this.eD.y, w - u, x - v));
        this.eD.x = u;
        this.eD.y = v;
        this.eE.time = motionEvent.getEventTime();
        this.eG.x = w;
        this.eG.y = x;
        this.eG.time = motionEvent.getEventTime();
    }

    private void n(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
            } else {
                this.ez = c.EStatUnknown;
            }
        } else if (a(this.eD.x, this.eD.y, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
            this.ez = c.EScrollAfterLongPress;
            a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.eD.x = u(motionEvent);
            this.eD.y = v(motionEvent);
            this.eE.time = motionEvent.getEventTime();
        }
    }

    private void o(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.ez = c.EStatUnknown;
                return;
            }
        }
        a(motionEvent.getEventTime(), this.eD.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
        this.eD.x = u(motionEvent);
        this.eD.y = v(motionEvent);
        this.eE.time = motionEvent.getEventTime();
    }

    private void p(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            clearStatus();
        }
    }

    private float q(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.eD.id)) - this.eD.x) / ((float) (motionEvent.getEventTime() - this.eE.time));
    }

    private float r(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.eD.id)) - this.eD.y) / ((float) (motionEvent.getEventTime() - this.eE.time));
    }

    private float s(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.eF.id)) - this.eG.x) / ((float) (motionEvent.getEventTime() - this.eG.time));
    }

    private float t(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.eF.id)) - this.eG.y) / ((float) (motionEvent.getEventTime() - this.eG.time));
    }

    private float u(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.eD.id));
    }

    private float v(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.eD.id));
    }

    private float w(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.eF.id));
    }

    private float x(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.eF.id));
    }

    public void d(int i, int i2) {
        Log.d("ARPTouchInput", "setScreenWidthHight width * height = " + i + " * " + i2);
        if (this.isScreenOrientationLandscape) {
            this.ex = i2;
            this.ey = i;
            return;
        }
        this.ex = i;
        this.ey = i2;
    }

    public void h(boolean z) {
        this.ev = z;
    }

    public void i(boolean z) {
        this.eu = z;
    }

    public void onPause() {
        if (this.es != null) {
            this.es.onPause();
        }
    }

    public final void onResume() {
        if (this.es != null) {
            this.es.onResume();
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (!this.ev || !this.eu || this.ew) {
            Log.e("ARPTouchInput", "onTouchEvent mEnginSoLoaded = " + this.ev + " && mUserTouchEnable = " + this.eu + " && mReleased = " + this.ew);
            return;
        }
        a(motionEvent);
        b(motionEvent);
    }

    public void release() {
        this.ew = true;
        if (this.et != null) {
            this.et.removeCallbacksAndMessages(null);
            this.es = null;
        }
        if (this.es != null) {
            this.es.release();
            this.es = null;
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Log.d("ARPTouchInput", "setScreenOrientationLandscape landscape = " + z);
        this.isScreenOrientationLandscape = z;
    }
}
