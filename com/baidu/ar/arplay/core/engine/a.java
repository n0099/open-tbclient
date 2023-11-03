package com.baidu.ar.arplay.core.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes.dex */
public class a {
    public b et;
    public boolean eu = true;
    public boolean ev = false;
    public boolean ew = false;
    public boolean isScreenOrientationLandscape = false;
    public int ex = 0;
    public int ey = 0;
    public c ez = c.EStatSingFingerCandidate;
    public e eA = null;
    public Map<Integer, Vector<Float>> eB = new HashMap();
    public boolean eC = true;
    public e eD = new e(this, null);
    public e eE = new e(this, null);
    public e eF = new e(this, null);
    public e eG = new e(this, null);
    public double eH = -1.0d;
    public boolean eI = true;
    public boolean eJ = false;
    public d eK = d.ESWIPE_RIGHT;
    public com.baidu.ar.arplay.core.engine.b es = new com.baidu.ar.arplay.core.engine.b();

    /* renamed from: com.baidu.ar.arplay.core.engine.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] eL;

        static {
            int[] iArr = new int[c.values().length];
            eL = iArr;
            try {
                iArr[c.EStatSingFingerCandidate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eL[c.EStatTwoFingersCandidate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eL[c.EStatScroll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eL[c.EStatSwipe.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eL[c.EStatTwoFingersScroll.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eL[c.EStatPinchAndUnpinch.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eL[c.EStatTwoFingersRotate.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                eL[c.EStatLongPress.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                eL[c.EScrollAfterLongPress.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                eL[c.EStatPinch.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                eL[c.EStatUnPinch.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                eL[c.EStatUnknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0052a {
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

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            if (a.this.ew) {
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2 && (obj = message.obj) != null) {
                    e eVar = (e) obj;
                    a.this.a(eVar.time, eVar.id, eVar.x, eVar.y);
                }
            } else if (a.this.ez == c.EStatSingFingerCandidate && a.this.eC) {
                a.this.ez = c.EStatLongPress;
                a.this.b(System.currentTimeMillis(), a.this.eD.id, a.this.eD.x, a.this.eD.y);
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* loaded from: classes.dex */
    public class e {
        public int id;
        public long time;
        public float x;
        public float y;

        public e() {
            this.id = -1;
            this.x = -1.0f;
            this.y = -1.0f;
            this.time = -1L;
        }

        public /* synthetic */ e(a aVar, AnonymousClass1 anonymousClass1) {
            this();
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

    /* loaded from: classes.dex */
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
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return Math.sqrt((f6 * f6) + (f7 * f7));
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
        int i3;
        int i4;
        if (this.isScreenOrientationLandscape) {
            f7 = this.ex - f3;
            f9 = f4;
            f8 = -f5;
            f10 = f2;
        } else {
            f7 = f2;
            f8 = f4;
            f9 = f5;
            f10 = f3;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length == 2 && windowSize[0] > 0.0f && windowSize[1] > 0.0f && (i3 = this.ex) > 0 && (i4 = this.ey) > 0) {
            float f11 = windowSize[0] / i3;
            float f12 = windowSize[1] / i4;
            f7 *= f11;
            f8 *= f11;
            f10 *= f12;
            f9 *= f12;
        }
        ARPEngine.getInstance().onTouchUpdate(i, f7, f10, f8, f9, j, i2, f6);
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
        float f21;
        float f22;
        int i5;
        int i6;
        if (this.isScreenOrientationLandscape) {
            int i7 = this.ex;
            f11 = i7 - f3;
            f14 = f6;
            f13 = i7 - f7;
            f12 = f2;
        } else {
            f11 = f2;
            f12 = f3;
            f13 = f6;
            f14 = f7;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || (i5 = this.ex) <= 0 || (i6 = this.ey) <= 0) {
            f15 = f4;
            f16 = f5;
            f17 = f8;
            f18 = f9;
            f19 = f12;
            f20 = f11;
            f21 = f13;
            f22 = f14;
        } else {
            float f23 = windowSize[0] / i5;
            float f24 = windowSize[1] / i6;
            f19 = f12 * f24;
            f20 = f11 * f23;
            f21 = f13 * f23;
            f22 = f14 * f24;
            f18 = f24 * f9;
            f17 = f23 * f8;
            f15 = f4 * f23;
            f16 = f5 * f24;
        }
        ARPEngine.getInstance().onGestureUpdate(i, j, i2, f20, f19, f15, f16, i3, f21, f22, f17, f18, i4, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, float f2, float f3) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.aW()) {
            return;
        }
        a(EnumC0052a.EGESTURE_CLICK.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        aS();
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.aZ()) {
            return;
        }
        a(EnumC0052a.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.ba()) {
            return;
        }
        a(EnumC0052a.EGESTURE_TWO_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9, boolean z) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.bc()) {
            return;
        }
        if (!this.eI) {
            if ((z && !this.eJ) || (!z && this.eJ)) {
                aS();
            }
            this.eJ = z;
        }
        int ordinal = EnumC0052a.EGESTURE_TWO_FINGER_UNPINCH.ordinal();
        if (z) {
            ordinal = EnumC0052a.EGESTURE_TWO_FINGER_PINCH.ordinal();
        }
        a(ordinal, j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
        if (this.eI) {
            this.eJ = z;
        }
    }

    private void a(long j, int i, float f2, float f3, int i2, float f4, float f5, float f6) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.bd()) {
            return;
        }
        a(EnumC0052a.EGESTURE_TWO_FINGER_ROTATE.ordinal(), j, i, f2, f3, -1.0f, -1.0f, i2, f4, f5, -1.0f, -1.0f, -1, f6);
    }

    private void a(long j, int i, int i2) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.bb()) {
            return;
        }
        a(EnumC0052a.EGESTURE_SWIPE.ordinal(), j, i, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, i2, 0.0f);
        clearStatus();
    }

    private void a(MotionEvent motionEvent) {
        f fVar;
        float f2;
        int i;
        int i2;
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
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = motionEvent.getPointerCount();
                    int i3 = 0;
                    while (i3 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        float x2 = motionEvent.getX(i3);
                        float y2 = motionEvent.getY(i3);
                        float f5 = 0.0f;
                        if (this.eB.containsKey(Integer.valueOf(pointerId2))) {
                            Vector<Float> vector = this.eB.get(Integer.valueOf(pointerId2));
                            f5 = x2 - vector.firstElement().floatValue();
                            f2 = y2 - vector.lastElement().floatValue();
                            vector.setElementAt(Float.valueOf(x2), 0);
                            vector.setElementAt(Float.valueOf(y2), 1);
                        } else {
                            f2 = 0.0f;
                        }
                        if (Math.abs(f5) > 0.1f || Math.abs(f2) > 0.1f) {
                            i = i3;
                            i2 = pointerCount;
                            a(pointerId2, x2, y2, f5, f2, eventTime, f.ETOUCH_MOVE.ordinal(), motionEvent.getPressure(i3));
                        } else {
                            i = i3;
                            i2 = pointerCount;
                        }
                        i3 = i + 1;
                        pointerCount = i2;
                    }
                    return;
                } else if (actionMasked == 3) {
                    if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                        Vector<Float> vector2 = this.eB.get(Integer.valueOf(pointerId));
                        this.eB.remove(Integer.valueOf(pointerId));
                        f4 = y - vector2.elementAt(1).floatValue();
                        f3 = x - vector2.elementAt(0).floatValue();
                    }
                    fVar = f.ETOUCH_CANCEL;
                    a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
                } else if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                }
            }
            if (this.eB.containsKey(Integer.valueOf(pointerId))) {
                Vector<Float> vector3 = this.eB.get(Integer.valueOf(pointerId));
                this.eB.remove(Integer.valueOf(pointerId));
                f4 = y - vector3.elementAt(1).floatValue();
                f3 = x - vector3.elementAt(0).floatValue();
            }
            fVar = f.ETOUCH_END;
            a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
        }
        Vector<Float> vector4 = new Vector<>(2);
        vector4.add(Float.valueOf(x));
        vector4.add(Float.valueOf(y));
        this.eB.put(Integer.valueOf(pointerId), vector4);
        fVar = f.ETOUCH_BEGIN;
        a(pointerId, x, y, f3, f4, eventTime, fVar.ordinal(), pressure);
    }

    private void a(e eVar, e eVar2) {
        eVar2.id = eVar.id;
        eVar2.x = eVar.x;
        eVar2.y = eVar.y;
        eVar2.time = eVar.time;
    }

    private void aS() {
        a(EnumC0052a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void aT() {
        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(EnumC0052a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
    }

    private void aU() {
        if (this.et.hasMessages(2)) {
            this.et.removeMessages(2);
            e eVar = this.eA;
            if (eVar != null) {
                a(eVar.time, eVar.id, eVar.x, eVar.y);
                this.eA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i, float f2, float f3) {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar == null || !bVar.aY()) {
            return;
        }
        a(EnumC0052a.EGESTURE_LONG_PRESS.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void b(MotionEvent motionEvent) {
        switch (AnonymousClass1.eL[this.ez.ordinal()]) {
            case 1:
                c(motionEvent);
                return;
            case 2:
                h(motionEvent);
                return;
            case 3:
                i(motionEvent);
                return;
            case 4:
                j(motionEvent);
                return;
            case 5:
                k(motionEvent);
                return;
            case 6:
                l(motionEvent);
                return;
            case 7:
                m(motionEvent);
                return;
            case 8:
                n(motionEvent);
                return;
            case 9:
                o(motionEvent);
                return;
            case 10:
            case 11:
            case 12:
                p(motionEvent);
                return;
            default:
                return;
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            d(motionEvent);
        } else if (actionMasked == 1) {
            f(motionEvent);
        } else if (actionMasked == 2) {
            e(motionEvent);
        } else if (actionMasked != 5) {
        } else {
            g(motionEvent);
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
        e eVar;
        this.eD.a(motionEvent, motionEvent.getActionIndex());
        a(this.eD, this.eE);
        Log.d("ARPTouchInput", "touchDownInSingleFingerCandidate() mFirstFingerTouch = " + this.eD.toString());
        if (this.et.hasMessages(2) && (eVar = this.eA) != null) {
            float f2 = eVar.x;
            float f3 = eVar.y;
            e eVar2 = this.eD;
            if (a(f2, f3, eVar2.x, eVar2.y) > 100.0d) {
                aU();
            }
        }
        this.et.sendEmptyMessageDelayed(1, 600L);
    }

    private void e(MotionEvent motionEvent) {
        e eVar = this.eD;
        double a = a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY());
        Log.d("ARPTouchInput", "touchMoveInSingleFingerCandidate() distance = " + a);
        if (a < 20.0d) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                this.ez = c.EStatLongPress;
                b(motionEvent.getDownTime(), this.eD.id, motionEvent.getX(), motionEvent.getY());
                this.et.removeMessages(1);
            }
        } else if (a < 50.0d) {
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
        e eVar = this.eD;
        if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300) {
            com.baidu.ar.arplay.core.engine.b bVar = this.es;
            if (bVar != null && bVar.aX()) {
                if (this.et.hasMessages(2)) {
                    this.et.removeMessages(2);
                } else {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    e eVar2 = new e(this, null);
                    eVar2.a(motionEvent, 0);
                    obtain.obj = eVar2;
                    this.eA = eVar2;
                    this.et.sendMessageDelayed(obtain, 400L);
                }
            }
            a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
        }
        clearStatus();
    }

    private void g(MotionEvent motionEvent) {
        c cVar;
        Log.d("ARPTouchInput", "touchPointerDownInSingleFingerCandidate() mFirstFingnerInClickArea = " + this.eC);
        if (this.eC) {
            this.eF.a(motionEvent, motionEvent.getActionIndex());
            a(this.eF, this.eG);
            cVar = c.EStatTwoFingersCandidate;
        } else {
            cVar = c.EStatUnknown;
        }
        this.ez = cVar;
        aU();
    }

    private void h(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (2 != motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
            return;
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        e eVar = this.eD;
        double a = a(eVar.x, eVar.y, u, v);
        e eVar2 = this.eF;
        double a2 = a(eVar2.x, eVar2.y, w, x);
        if ((a > 50.0d || a2 > 50.0d) && a > 20.0d && a2 > 20.0d) {
            e eVar3 = this.eD;
            float f4 = eVar3.x;
            float f5 = eVar3.y;
            e eVar4 = this.eF;
            double a3 = a(f4, f5, u, v, eVar4.x, eVar4.y, w, x);
            if (a3 < 0.7853981633974483d) {
                this.ez = c.EStatTwoFingersScroll;
                a(motionEvent.getDownTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
                Log.d("ARPTouchInput", "EStatTwoFingersScroll");
                f2 = w;
                f3 = x;
            } else {
                if (a3 > 3.141592653589793d || a3 <= 1.5707963267948966d) {
                    f2 = w;
                    f3 = x;
                    this.ez = c.EStatPinchAndUnpinch;
                } else {
                    e eVar5 = this.eD;
                    float f6 = eVar5.x;
                    e eVar6 = this.eF;
                    float f7 = (eVar6.x + f6) / 2.0f;
                    float f8 = eVar5.y;
                    float f9 = (eVar6.y + f8) / 2.0f;
                    double a4 = a(f7, f9, f6, f8, f6, f8, u, v);
                    e eVar7 = this.eF;
                    float f10 = eVar7.x;
                    float f11 = eVar7.y;
                    double a5 = a(f7, f9, f10, f11, f10, f11, w, x);
                    if (Math.abs(a4 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d) {
                        f2 = w;
                        f3 = x;
                        this.ez = c.EStatTwoFingersRotate;
                    } else {
                        this.ez = c.EStatPinchAndUnpinch;
                        f2 = w;
                        f3 = x;
                    }
                }
                this.eH = a(u, v, f2, f3);
            }
        } else {
            f3 = x;
            f2 = w;
        }
        e eVar8 = this.eE;
        eVar8.x = u;
        eVar8.y = v;
        eVar8.time = motionEvent.getEventTime();
        e eVar9 = this.eG;
        eVar9.x = f2;
        eVar9.y = f3;
        eVar9.time = motionEvent.getEventTime();
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
                return;
            }
            if (6 != motionEvent.getActionMasked()) {
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    return;
                } else if (2 == motionEvent.getActionMasked()) {
                    if (motionEvent.getEventTime() - this.eE.time >= 1) {
                        float u = u(motionEvent);
                        float v = v(motionEvent);
                        a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent));
                        float f2 = u - this.eE.x;
                        float f3 = v - this.eE.y;
                        float eventTime = f2 / ((float) (motionEvent.getEventTime() - this.eE.time));
                        float eventTime2 = f3 / ((float) (motionEvent.getEventTime() - this.eE.time));
                        if (Math.abs(f2) <= Math.abs(f3) || Math.abs(f2) <= 100.0d || Math.abs(eventTime) <= 20.0d) {
                            if (Math.abs(f3) > Math.abs(f2) && Math.abs(f3) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                                this.eK = f3 > 0.0f ? d.ESWIPE_DOWN : d.ESWIPE_UP;
                            }
                            this.eE.x = u;
                            this.eE.y = v;
                            this.eE.time = motionEvent.getEventTime();
                            return;
                        }
                        this.eK = f2 > 0.0f ? d.ESWIPE_RIGHT : d.ESWIPE_LEFT;
                        this.ez = c.EStatSwipe;
                        this.eE.x = u;
                        this.eE.y = v;
                        this.eE.time = motionEvent.getEventTime();
                        return;
                    }
                    return;
                }
            }
            this.ez = c.EStatUnknown;
        } catch (Exception unused) {
            Log.e("ARPTouchInput", "Monkey event.getX Exception");
        }
    }

    private void j(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            a(motionEvent.getEventTime(), this.eD.id, this.eK.ordinal());
        }
    }

    private void k(MotionEvent motionEvent) {
        if (5 != motionEvent.getActionMasked()) {
            if (6 == motionEvent.getActionMasked()) {
                this.ez = c.EStatScroll;
                int action = (motionEvent.getAction() & 65280) >>> 8;
                e eVar = this.eD;
                if (action == eVar.id) {
                    a(this.eF, eVar);
                    a(this.eG, this.eE);
                }
                aS();
                return;
            } else if (2 == motionEvent.getActionMasked()) {
                if (motionEvent.getEventTime() - this.eE.time < 1 || motionEvent.getEventTime() - this.eG.time < 1) {
                    return;
                }
                float u = u(motionEvent);
                float v = v(motionEvent);
                float w = w(motionEvent);
                float x = x(motionEvent);
                a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent));
                e eVar2 = this.eD;
                eVar2.x = u;
                eVar2.y = v;
                this.eE.time = motionEvent.getEventTime();
                e eVar3 = this.eG;
                eVar3.x = w;
                eVar3.y = x;
                eVar3.time = motionEvent.getEventTime();
                return;
            }
        }
        this.ez = c.EStatUnknown;
    }

    private void l(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
            this.eI = true;
        } else if (6 == motionEvent.getActionMasked()) {
            this.ez = c.EStatScroll;
            int action = (motionEvent.getAction() & 65280) >>> 8;
            e eVar = this.eD;
            if (action == eVar.id) {
                eVar.id = this.eF.id;
            }
            this.eI = true;
            aT();
        } else if (2 != motionEvent.getActionMasked()) {
            this.ez = c.EStatUnknown;
        } else if (motionEvent.getEventTime() - this.eE.time >= 1 && motionEvent.getEventTime() - this.eG.time >= 1) {
            float u = u(motionEvent);
            float v = v(motionEvent);
            float w = w(motionEvent);
            float x = x(motionEvent);
            double a = a(u, v, w, x);
            a(motionEvent.getEventTime(), this.eD.id, u, v, q(motionEvent), r(motionEvent), this.eF.id, w, x, s(motionEvent), t(motionEvent), a < this.eH);
            this.eH = a;
            e eVar2 = this.eD;
            eVar2.x = u;
            eVar2.y = v;
            this.eE.time = motionEvent.getEventTime();
            e eVar3 = this.eG;
            eVar3.x = w;
            eVar3.y = x;
            eVar3.time = motionEvent.getEventTime();
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
        e eVar = this.eG;
        float f2 = eVar.x;
        e eVar2 = this.eD;
        a(motionEvent.getEventTime(), this.eD.id, u, v, this.eF.id, w, x, (float) a(f2 - eVar2.x, eVar.y - eVar2.y, w - u, x - v));
        e eVar3 = this.eD;
        eVar3.x = u;
        eVar3.y = v;
        this.eE.time = motionEvent.getEventTime();
        e eVar4 = this.eG;
        eVar4.x = w;
        eVar4.y = x;
        eVar4.time = motionEvent.getEventTime();
    }

    private void n(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.ez = c.EStatUnknown;
                return;
            }
        }
        e eVar = this.eD;
        if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
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
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public final void onResume() {
        com.baidu.ar.arplay.core.engine.b bVar = this.es;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.ev && this.eu && !this.ew) {
            a(motionEvent);
            b(motionEvent);
            return;
        }
        Log.e("ARPTouchInput", "onTouchEvent mEnginSoLoaded = " + this.ev + " && mUserTouchEnable = " + this.eu + " && mReleased = " + this.ew);
    }

    public void release() {
        this.ew = true;
        b bVar = this.et;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.es = null;
        }
        com.baidu.ar.arplay.core.engine.b bVar2 = this.es;
        if (bVar2 != null) {
            bVar2.release();
            this.es = null;
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Log.d("ARPTouchInput", "setScreenOrientationLandscape landscape = " + z);
        this.isScreenOrientationLandscape = z;
    }
}
