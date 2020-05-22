package com.baidu.ar.arplay.core.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.arplay.core.message.ARPMessage;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes3.dex */
public class a {
    private static final double[] eT = {1.5707963267948966d, 3.141592653589793d};
    private c eQ;
    private e ez = e.EStatSingleFingerCandidate;
    private boolean eA = true;
    private int eB = -1;
    private float eC = -1.0f;
    private float eD = -1.0f;
    private float eE = -1.0f;
    private float eF = -1.0f;
    private long eG = -1;
    private int eH = -1;
    private float eI = -1.0f;
    private float eJ = -1.0f;
    private float eK = -1.0f;
    private float eL = -1.0f;
    private long eM = -1;
    private double eN = -1.0d;
    private double eO = -1.0d;
    private double eP = -1.0d;
    private boolean eR = true;
    private boolean eS = false;
    private d eU = d.ESWIPE_RIGHT;
    private boolean eV = false;
    private boolean eW = false;
    private boolean eX = false;
    private boolean eY = false;
    private boolean eZ = false;
    private boolean fa = false;
    private boolean fb = false;
    private boolean fc = false;
    private boolean fd = false;
    private boolean fe = true;
    private boolean isScreenOrientationLandscape = false;
    private int ff = 0;
    private int fg = 0;
    private C0075a fh = null;
    private Map<Integer, Vector<Float>> fi = new HashMap();
    private boolean fj = false;
    ARPMessage.MessageHandler fk = new ARPMessage.MessageHandler() { // from class: com.baidu.ar.arplay.core.engine.a.1
        @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
        public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get("disable_all") != null) {
                    if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                        a.this.eV = true;
                    } else {
                        a.this.eV = false;
                    }
                }
                if (hashMap.get("disable_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                        a.this.eW = true;
                    } else {
                        a.this.eW = false;
                    }
                }
                if (hashMap.get("disable_double_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                        a.this.eX = true;
                    } else {
                        a.this.eX = false;
                    }
                }
                if (hashMap.get("disable_long_press") != null) {
                    if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                        a.this.eY = true;
                    } else {
                        a.this.eY = false;
                    }
                }
                if (hashMap.get("disable_swipe") != null) {
                    if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                        a.this.eZ = true;
                    } else {
                        a.this.eZ = false;
                    }
                }
                if (hashMap.get("disable_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                        a.this.fa = true;
                    } else {
                        a.this.fa = false;
                    }
                }
                if (hashMap.get("disable_two_finger_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                        a.this.fb = true;
                    } else {
                        a.this.fb = false;
                    }
                }
                if (hashMap.get("disable_pinch") != null) {
                    if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                        a.this.fc = true;
                    } else {
                        a.this.fc = false;
                    }
                }
                if (hashMap.get("disable_two_finger_rotate") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                        a.this.fd = true;
                    } else {
                        a.this.fd = false;
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0075a {
        public int fn;
        public long time;
        public float x;
        public float y;

        private C0075a() {
        }
    }

    /* loaded from: classes3.dex */
    public enum b {
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
    public static class c extends Handler {
        WeakReference<a> fz;

        public c(Looper looper, a aVar) {
            super(looper);
            this.fz = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (this.fz.get() != null && this.fz.get().ez == e.EStatSingleFingerCandidate && this.fz.get().eA) {
                        this.fz.get().ez = e.EStatLongPresss;
                        if (this.fz.get().eV || this.fz.get().eY) {
                            return;
                        }
                        this.fz.get().a(b.EGESTURE_LONG_PRESS.ordinal(), Calendar.getInstance().getTimeInMillis(), this.fz.get().eB, this.fz.get().eE, this.fz.get().eF, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        return;
                    }
                    return;
                case 2:
                    a aVar = this.fz.get();
                    if (aVar == null || message.obj == null) {
                        return;
                    }
                    C0075a c0075a = (C0075a) message.obj;
                    if (!aVar.eW) {
                        this.fz.get().a(b.EGESTURE_CLICK.ordinal(), c0075a.time, c0075a.fn, c0075a.x, c0075a.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    }
                    this.fz.get().a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* loaded from: classes3.dex */
    public enum e {
        EStatSingleFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPresss,
        EStatScroll,
        EStatSwipe,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatTwoFingerRotate,
        EStatUnknown
    }

    /* loaded from: classes3.dex */
    public enum f {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    public a(Looper looper) {
        this.eQ = new c(looper, this);
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
        E(String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)));
        double sqrt = ((f10 * f12) + (f11 * f13)) / (Math.sqrt((f10 * f10) + (f11 * f11)) * Math.sqrt((f12 * f12) + (f13 * f13)));
        try {
            sqrt = Double.parseDouble(new DecimalFormat("#.00").format(sqrt));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        double acos = Math.acos(sqrt);
        E("touchopt" + String.format("angle is %1.3f", Double.valueOf(Math.toDegrees(acos))));
        return acos;
    }

    private float a(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.eB)) - this.eE) / ((float) (motionEvent.getEventTime() - this.eG));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void a(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        if (this.isScreenOrientationLandscape) {
            f8 = this.fg - f3;
            f7 = -f5;
        } else {
            f7 = f4;
            f8 = f2;
            f2 = f3;
            f4 = f5;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ff <= 0 || this.fg <= 0) {
            f9 = f4;
            f10 = f7;
            f11 = f2;
            f12 = f8;
        } else {
            float f13 = windowSize[0] / this.ff;
            float f14 = windowSize[1] / this.fg;
            float f15 = f8 * f13;
            f9 = f4 * f14;
            f10 = f7 * f13;
            f11 = f2 * f14;
            f12 = f15;
        }
        ARPEngine.getInstance().onTouchUpdate(i, f12, f11, f10, f9, j, i2, f6);
    }

    private void aN() {
        if (this.eQ.hasMessages(2)) {
            this.eQ.removeMessages(2);
            if (this.fh != null) {
                if (!this.eW) {
                    a(b.EGESTURE_CLICK.ordinal(), this.fh.time, this.fh.fn, this.fh.x, this.fh.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                }
                a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                this.fh = null;
            }
        }
    }

    private float b(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.eB)) - this.eF) / ((float) (motionEvent.getEventTime() - this.eG));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.eH)) - this.eK) / ((float) (motionEvent.getEventTime() - this.eM));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void clearStatus() {
        this.ez = e.EStatSingleFingerCandidate;
        this.eA = true;
        this.eN = -1.0d;
        this.eQ.removeMessages(1);
        if (this.eQ.hasMessages(2)) {
            return;
        }
        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private float d(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.eH)) - this.eL) / ((float) (motionEvent.getEventTime() - this.eM));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.eB));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.eB));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float g(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.eH));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float h(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.eH));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void i(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 0) {
            return;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                float x = motionEvent.getX(actionIndex);
                float y = motionEvent.getY(actionIndex);
                Vector<Float> vector = new Vector<>(2);
                vector.add(Float.valueOf(x));
                vector.add(Float.valueOf(y));
                this.fi.put(Integer.valueOf(pointerId), vector);
                a(pointerId, x, y, 0.0f, 0.0f, motionEvent.getEventTime(), f.ETOUCH_BEGIN.ordinal(), motionEvent.getPressure(actionIndex));
                return;
            case 1:
            case 6:
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float x2 = motionEvent.getX(actionIndex2);
                float y2 = motionEvent.getY(actionIndex2);
                float f2 = 0.0f;
                float f3 = 0.0f;
                if (this.fi.containsKey(Integer.valueOf(pointerId2))) {
                    Vector<Float> vector2 = this.fi.get(Integer.valueOf(pointerId2));
                    f2 = x2 - vector2.elementAt(0).floatValue();
                    f3 = y2 - vector2.elementAt(1).floatValue();
                    this.fi.remove(Integer.valueOf(pointerId2));
                }
                a(pointerId2, x2, y2, f2, f3, motionEvent.getEventTime(), f.ETOUCH_END.ordinal(), motionEvent.getPressure(actionIndex2));
                return;
            case 2:
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    int pointerId3 = motionEvent.getPointerId(i);
                    float x3 = motionEvent.getX(i);
                    float y3 = motionEvent.getY(i);
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    if (this.fi.containsKey(Integer.valueOf(pointerId3))) {
                        Vector<Float> vector3 = this.fi.get(Integer.valueOf(pointerId3));
                        float floatValue = x3 - vector3.firstElement().floatValue();
                        f5 = y3 - vector3.lastElement().floatValue();
                        vector3.setElementAt(Float.valueOf(x3), 0);
                        vector3.setElementAt(Float.valueOf(y3), 1);
                        f4 = floatValue;
                    }
                    if (Math.abs(f4) > 0.1f || Math.abs(f5) > 0.1f) {
                        a(pointerId3, x3, y3, f4, f5, motionEvent.getEventTime(), f.ETOUCH_MOVE.ordinal(), motionEvent.getPressure(i));
                    }
                }
                return;
            case 3:
                int actionIndex3 = motionEvent.getActionIndex();
                int pointerId4 = motionEvent.getPointerId(actionIndex3);
                float x4 = motionEvent.getX(actionIndex3);
                float y4 = motionEvent.getY(actionIndex3);
                float f6 = 0.0f;
                float f7 = 0.0f;
                if (this.fi.containsKey(Integer.valueOf(pointerId4))) {
                    Vector<Float> vector4 = this.fi.get(Integer.valueOf(pointerId4));
                    f6 = x4 - vector4.elementAt(0).floatValue();
                    f7 = y4 - vector4.elementAt(1).floatValue();
                    this.fi.remove(Integer.valueOf(pointerId4));
                }
                a(pointerId4, x4, y4, f6, f7, motionEvent.getEventTime(), f.ETOUCH_CANCEL.ordinal(), motionEvent.getPressure(actionIndex3));
                return;
            case 4:
            default:
                return;
        }
    }

    public void E(String str) {
        Log.d("ar TouchEventLog ", str);
    }

    public void a(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10) {
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
            f12 = this.fg - f3;
            f11 = this.fg - f7;
        } else {
            f11 = f6;
            f12 = f2;
            f2 = f3;
            f6 = f7;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.ff <= 0 || this.fg <= 0) {
            f13 = f9;
            f14 = f8;
            f15 = f6;
            f16 = f11;
            f17 = f5;
            f18 = f4;
            f19 = f2;
            f20 = f12;
        } else {
            float f21 = windowSize[0] / this.ff;
            float f22 = windowSize[1] / this.fg;
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

    public void d(int i, int i2) {
        this.fg = i2;
        this.ff = i;
    }

    public void j(boolean z) {
        this.fj = z;
    }

    public void k(boolean z) {
        this.fe = z;
    }

    public void onPause() {
        ARPMessage.getInstance().removeMessageHandeler(this.fk);
    }

    public void onResume() {
        ARPMessage.getInstance().registerMessageHandler(11, this.fk);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fj && this.fe) {
            i(motionEvent);
            switch (this.ez) {
                case EStatSingleFingerCandidate:
                    if (motionEvent.getActionMasked() == 0) {
                        Log.d("touchopt", "touchinv Action Down when EStatSingleFingerCandidate");
                        this.eB = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.eC = motionEvent.getX();
                        this.eD = motionEvent.getY();
                        this.eE = this.eC;
                        this.eF = this.eD;
                        this.eG = motionEvent.getEventTime();
                        if (this.eQ.hasMessages(2) && this.fh != null && a(this.fh.x, this.fh.y, motionEvent.getX(), motionEvent.getY()) > 100.0d) {
                            aN();
                        }
                        this.eQ.sendEmptyMessageDelayed(1, 600L);
                        Log.d("touchopt", String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.eC), Float.valueOf(this.eD), Long.valueOf(this.eG), Integer.valueOf(this.eB)));
                        return;
                    } else if (2 == motionEvent.getActionMasked()) {
                        double a = a(this.eC, this.eD, motionEvent.getX(), motionEvent.getY());
                        Log.d("touchopt", String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(a)));
                        if (a < 20.0d) {
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                this.ez = e.EStatLongPresss;
                                if (!this.eV && !this.eY) {
                                    a(b.EGESTURE_LONG_PRESS.ordinal(), motionEvent.getDownTime(), this.eB, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                                this.eQ.removeMessages(1);
                            }
                        } else if (a < 50.0d) {
                            this.eA = false;
                        } else {
                            aN();
                            this.ez = e.EStatScroll;
                            if (!this.eV && !this.fa) {
                                a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eB, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            }
                            this.eQ.removeMessages(1);
                        }
                        this.eE = motionEvent.getX();
                        this.eF = motionEvent.getY();
                        this.eG = motionEvent.getEventTime();
                        return;
                    } else if (1 != motionEvent.getActionMasked()) {
                        if (5 == motionEvent.getActionMasked()) {
                            if (this.eA) {
                                this.eH = motionEvent.getPointerId(motionEvent.getActionIndex());
                                this.eI = motionEvent.getX(motionEvent.findPointerIndex(this.eH));
                                this.eJ = motionEvent.getY(motionEvent.findPointerIndex(this.eH));
                                this.eM = motionEvent.getEventTime();
                                this.eK = this.eI;
                                this.eL = this.eJ;
                                this.eO = a(motionEvent.getX(), motionEvent.getY(), this.eI, this.eJ);
                                this.ez = e.EStatTwoFingersCandidate;
                            } else {
                                this.ez = e.EStatUnknown;
                            }
                            aN();
                            return;
                        }
                        return;
                    } else {
                        if (a(this.eC, this.eD, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.eV) {
                            if (this.eX) {
                                if (!this.eW) {
                                    a(b.EGESTURE_CLICK.ordinal(), motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                    a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                            } else if (this.eQ.hasMessages(2)) {
                                this.eQ.removeMessages(2);
                                a(b.EGESTURE_DOUBLE_CLICK.ordinal(), motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                C0075a c0075a = new C0075a();
                                c0075a.fn = motionEvent.getPointerId(0);
                                c0075a.x = motionEvent.getX();
                                c0075a.y = motionEvent.getY();
                                c0075a.time = motionEvent.getDownTime();
                                obtain.obj = c0075a;
                                this.fh = c0075a;
                                this.eQ.sendMessageDelayed(obtain, 400L);
                            }
                        }
                        clearStatus();
                        return;
                    }
                case EStatTwoFingersCandidate:
                    if (5 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else {
                        float e2 = e(motionEvent);
                        float f2 = f(motionEvent);
                        float g = g(motionEvent);
                        float h = h(motionEvent);
                        double a2 = a(this.eC, this.eD, e2, f2);
                        double a3 = a(this.eI, this.eJ, g, h);
                        if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
                            double a4 = a(this.eC, this.eD, e2, f2, this.eI, this.eJ, g, h);
                            if (a4 < 0.7853981633974483d) {
                                this.ez = e.EStatTwoFingersScroll;
                                if (!this.eV && !this.fb) {
                                    a(b.EGESTURE_TWO_FINGER_SCROLL.ordinal(), motionEvent.getDownTime(), this.eB, e2, f2, a(motionEvent), b(motionEvent), this.eH, g, h, c(motionEvent), d(motionEvent), -1, 0.0f);
                                    Log.d("touchopt", "EStatTwoFingersScroll");
                                }
                            } else if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                                this.ez = e.EStatPinchAndUnpinch;
                                this.eN = a(e2, f2, g, h);
                            } else {
                                float f3 = (this.eC + this.eI) / 2.0f;
                                float f4 = (this.eD + this.eJ) / 2.0f;
                                double a5 = a(f3, f4, this.eC, this.eD, this.eC, this.eD, e2, f2);
                                double a6 = a(f3, f4, this.eI, this.eJ, this.eI, this.eJ, g, h);
                                if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                                    this.ez = e.EStatTwoFingerRotate;
                                    this.eP = a4;
                                } else {
                                    this.ez = e.EStatPinchAndUnpinch;
                                    this.eN = a(e2, f2, g, h);
                                }
                            }
                        }
                        this.eE = e2;
                        this.eF = f2;
                        this.eG = motionEvent.getEventTime();
                        this.eK = g;
                        this.eL = h;
                        this.eM = motionEvent.getEventTime();
                        return;
                    }
                case EStatScroll:
                    try {
                        if (5 == motionEvent.getActionMasked()) {
                            this.eC = motionEvent.getX(motionEvent.findPointerIndex(this.eB));
                            this.eD = motionEvent.getY(motionEvent.findPointerIndex(this.eB));
                            this.eE = this.eC;
                            this.eF = this.eD;
                            this.eG = motionEvent.getEventTime();
                            this.eH = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.eI = motionEvent.getX(motionEvent.findPointerIndex(this.eH));
                            this.eJ = motionEvent.getY(motionEvent.findPointerIndex(this.eH));
                            this.eM = motionEvent.getEventTime();
                            this.eK = this.eI;
                            this.eL = this.eJ;
                            this.ez = e.EStatTwoFingersCandidate;
                            if (this.eV || this.fa) {
                                return;
                            }
                            a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            return;
                        } else if (6 == motionEvent.getActionMasked()) {
                            this.ez = e.EStatUnknown;
                            return;
                        } else if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else if (2 != motionEvent.getActionMasked()) {
                            this.ez = e.EStatUnknown;
                            return;
                        } else if (motionEvent.getEventTime() - this.eG >= 1) {
                            float e3 = e(motionEvent);
                            float f5 = f(motionEvent);
                            if (!this.eV && !this.fa) {
                                a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eB, e3, f5, a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            }
                            float f6 = e3 - this.eE;
                            float f7 = f5 - this.eF;
                            float eventTime = f6 / ((float) (motionEvent.getEventTime() - this.eG));
                            float eventTime2 = f7 / ((float) (motionEvent.getEventTime() - this.eG));
                            if (Math.abs(f6) > Math.abs(f7) && Math.abs(f6) > 100.0d && Math.abs(eventTime) > 20.0d) {
                                if (f6 > 0.0f) {
                                    this.eU = d.ESWIPE_RIGHT;
                                } else {
                                    this.eU = d.ESWIPE_LEFT;
                                }
                                this.ez = e.EStatSwipe;
                            } else if (Math.abs(f7) > Math.abs(f6) && Math.abs(f7) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                                if (f7 > 0.0f) {
                                    this.eU = d.ESWIPE_DOWN;
                                } else {
                                    this.eU = d.ESWIPE_UP;
                                }
                                this.ez = e.EStatSwipe;
                            }
                            this.eE = e3;
                            this.eF = f5;
                            this.eG = motionEvent.getEventTime();
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e4) {
                        Log.e(" BaiduArView", "Monkey event.getX Exception");
                        return;
                    }
                case EStatSwipe:
                    if (1 != motionEvent.getActionMasked() || this.eV || this.eZ) {
                        return;
                    }
                    a(b.EGESTURE_SWIPE.ordinal(), motionEvent.getEventTime(), this.eB, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.eU.ordinal(), 0.0f);
                    clearStatus();
                    return;
                case EStatTwoFingersScroll:
                    if (5 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eB) {
                            this.eB = this.eH;
                            this.eC = this.eI;
                            this.eD = this.eJ;
                            this.eE = this.eK;
                            this.eF = this.eL;
                            this.eG = this.eM;
                        }
                        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.eG < 1 || motionEvent.getEventTime() - this.eM < 1) {
                        return;
                    } else {
                        float e5 = e(motionEvent);
                        float f8 = f(motionEvent);
                        float g2 = g(motionEvent);
                        float h2 = h(motionEvent);
                        if (!this.eV && !this.fb) {
                            a(b.EGESTURE_TWO_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eB, e5, f8, a(motionEvent), b(motionEvent), this.eH, g2, h2, c(motionEvent), d(motionEvent), -1, 0.0f);
                        }
                        this.eE = e5;
                        this.eF = f8;
                        this.eG = motionEvent.getEventTime();
                        this.eK = g2;
                        this.eL = h2;
                        this.eM = motionEvent.getEventTime();
                        return;
                    }
                case EStatPinchAndUnpinch:
                    if (5 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        this.eR = true;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.ez = e.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eB) {
                            this.eB = this.eH;
                        }
                        this.eR = true;
                        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.ez = e.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.eG < 1 || motionEvent.getEventTime() - this.eM < 1) {
                        return;
                    } else {
                        float e6 = e(motionEvent);
                        float f9 = f(motionEvent);
                        float g3 = g(motionEvent);
                        float h3 = h(motionEvent);
                        double a7 = a(e6, f9, g3, h3);
                        if (a7 > this.eN) {
                            if (!this.eV && !this.fc) {
                                if (!this.eR) {
                                    if (this.eS) {
                                        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                    }
                                    this.eS = false;
                                }
                                a(b.EGESTURE_TWO_FINGER_UNPINCH.ordinal(), motionEvent.getEventTime(), this.eB, e6, f9, a(motionEvent), b(motionEvent), this.eH, g3, h3, c(motionEvent), d(motionEvent), -1, 0.0f);
                                if (this.eR) {
                                    this.eS = false;
                                }
                            }
                        } else if (!this.eV && !this.fc) {
                            if (!this.eR) {
                                if (!this.eS) {
                                    a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                                this.eS = true;
                            }
                            a(b.EGESTURE_TWO_FINGER_PINCH.ordinal(), motionEvent.getEventTime(), this.eB, e6, f9, a(motionEvent), b(motionEvent), this.eH, g3, h3, c(motionEvent), d(motionEvent), -1, 0.0f);
                            if (this.eR) {
                                this.eS = true;
                            }
                        }
                        this.eN = a7;
                        this.eE = e6;
                        this.eF = f9;
                        this.eG = motionEvent.getEventTime();
                        this.eK = g3;
                        this.eL = h3;
                        this.eM = motionEvent.getEventTime();
                        return;
                    }
                case EStatTwoFingerRotate:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else {
                            this.ez = e.EStatUnknown;
                            return;
                        }
                    }
                    float e7 = e(motionEvent);
                    float f10 = f(motionEvent);
                    float g4 = g(motionEvent);
                    float h4 = h(motionEvent);
                    double a8 = a(this.eK - this.eE, this.eL - this.eF, g4 - e7, h4 - f10);
                    if (!this.eV && !this.fd) {
                        a(b.EGESTURE_TWO_FINGER_ROTATE.ordinal(), motionEvent.getEventTime(), this.eB, e7, f10, -1.0f, -1.0f, this.eH, g4, h4, -1.0f, -1.0f, -1, (float) a8);
                    }
                    this.eE = e7;
                    this.eF = f10;
                    this.eG = motionEvent.getEventTime();
                    this.eK = g4;
                    this.eL = h4;
                    this.eM = motionEvent.getEventTime();
                    return;
                case EStatLongPresss:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else {
                            this.ez = e.EStatUnknown;
                            return;
                        }
                    } else if (a(this.eC, this.eD, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
                        this.ez = e.EScrollAfterLongPress;
                        if (!this.eV && !this.fa) {
                            a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eB, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        }
                        this.eE = e(motionEvent);
                        this.eF = f(motionEvent);
                        this.eG = motionEvent.getEventTime();
                        return;
                    } else {
                        return;
                    }
                case EScrollAfterLongPress:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else {
                            this.ez = e.EStatUnknown;
                            return;
                        }
                    }
                    if (!this.eV && !this.fa) {
                        a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eB, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    }
                    this.eE = e(motionEvent);
                    this.eF = f(motionEvent);
                    this.eG = motionEvent.getEventTime();
                    return;
                case EStatPinch:
                case EStatUnPinch:
                case EStatUnknown:
                    if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        this.isScreenOrientationLandscape = z;
    }
}
