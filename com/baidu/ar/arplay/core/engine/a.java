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
/* loaded from: classes11.dex */
public class a {
    private static final double[] ff = {1.5707963267948966d, 3.141592653589793d};
    private c fc;
    private e eL = e.EStatSingleFingerCandidate;
    private boolean eM = true;
    private int eN = -1;
    private float eO = -1.0f;
    private float eP = -1.0f;
    private float eQ = -1.0f;
    private float eR = -1.0f;
    private long eS = -1;
    private int eT = -1;
    private float eU = -1.0f;
    private float eV = -1.0f;
    private float eW = -1.0f;
    private float eX = -1.0f;
    private long eY = -1;
    private double eZ = -1.0d;
    private double fa = -1.0d;
    private double fb = -1.0d;
    private boolean fd = true;
    private boolean fe = false;
    private d fg = d.ESWIPE_RIGHT;
    private boolean fh = false;
    private boolean fi = false;
    private boolean fj = false;
    private boolean fk = false;
    private boolean fl = false;
    private boolean fm = false;
    private boolean fn = false;
    private boolean fo = false;
    private boolean fp = false;
    private boolean fq = true;
    private boolean isScreenOrientationLandscape = false;
    private int fr = 0;
    private int fs = 0;
    private C0077a ft = null;
    private Map<Integer, Vector<Float>> fu = new HashMap();
    private boolean fv = false;
    ARPMessage.MessageHandler fw = new ARPMessage.MessageHandler() { // from class: com.baidu.ar.arplay.core.engine.a.1
        @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
        public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get("disable_all") != null) {
                    if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                        a.this.fh = true;
                    } else {
                        a.this.fh = false;
                    }
                }
                if (hashMap.get("disable_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                        a.this.fi = true;
                    } else {
                        a.this.fi = false;
                    }
                }
                if (hashMap.get("disable_double_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                        a.this.fj = true;
                    } else {
                        a.this.fj = false;
                    }
                }
                if (hashMap.get("disable_long_press") != null) {
                    if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                        a.this.fk = true;
                    } else {
                        a.this.fk = false;
                    }
                }
                if (hashMap.get("disable_swipe") != null) {
                    if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                        a.this.fl = true;
                    } else {
                        a.this.fl = false;
                    }
                }
                if (hashMap.get("disable_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                        a.this.fm = true;
                    } else {
                        a.this.fm = false;
                    }
                }
                if (hashMap.get("disable_two_finger_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                        a.this.fn = true;
                    } else {
                        a.this.fn = false;
                    }
                }
                if (hashMap.get("disable_pinch") != null) {
                    if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                        a.this.fo = true;
                    } else {
                        a.this.fo = false;
                    }
                }
                if (hashMap.get("disable_two_finger_rotate") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                        a.this.fp = true;
                    } else {
                        a.this.fp = false;
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.arplay.core.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0077a {
        public int fz;
        public long time;
        public float x;
        public float y;

        private C0077a() {
        }
    }

    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
    public static class c extends Handler {
        WeakReference<a> fL;

        public c(Looper looper, a aVar) {
            super(looper);
            this.fL = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (this.fL.get() != null && this.fL.get().eL == e.EStatSingleFingerCandidate && this.fL.get().eM) {
                        this.fL.get().eL = e.EStatLongPresss;
                        if (this.fL.get().fh || this.fL.get().fk) {
                            return;
                        }
                        this.fL.get().a(b.EGESTURE_LONG_PRESS.ordinal(), Calendar.getInstance().getTimeInMillis(), this.fL.get().eN, this.fL.get().eQ, this.fL.get().eR, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        return;
                    }
                    return;
                case 2:
                    a aVar = this.fL.get();
                    if (aVar == null || message.obj == null) {
                        return;
                    }
                    C0077a c0077a = (C0077a) message.obj;
                    if (!aVar.fi) {
                        this.fL.get().a(b.EGESTURE_CLICK.ordinal(), c0077a.time, c0077a.fz, c0077a.x, c0077a.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    }
                    this.fL.get().a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public enum f {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    public a(Looper looper) {
        this.fc = new c(looper, this);
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
            return (motionEvent.getX(motionEvent.findPointerIndex(this.eN)) - this.eQ) / ((float) (motionEvent.getEventTime() - this.eS));
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
            f8 = this.fs - f3;
            f7 = -f5;
        } else {
            f7 = f4;
            f8 = f2;
            f2 = f3;
            f4 = f5;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.fr <= 0 || this.fs <= 0) {
            f9 = f4;
            f10 = f7;
            f11 = f2;
            f12 = f8;
        } else {
            float f13 = windowSize[0] / this.fr;
            float f14 = windowSize[1] / this.fs;
            float f15 = f8 * f13;
            f9 = f4 * f14;
            f10 = f7 * f13;
            f11 = f2 * f14;
            f12 = f15;
        }
        ARPEngine.getInstance().onTouchUpdate(i, f12, f11, f10, f9, j, i2, f6);
    }

    private float b(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.eN)) - this.eR) / ((float) (motionEvent.getEventTime() - this.eS));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void bb() {
        if (this.fc.hasMessages(2)) {
            this.fc.removeMessages(2);
            if (this.ft != null) {
                if (!this.fi) {
                    a(b.EGESTURE_CLICK.ordinal(), this.ft.time, this.ft.fz, this.ft.x, this.ft.y, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                }
                a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                this.ft = null;
            }
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.eT)) - this.eW) / ((float) (motionEvent.getEventTime() - this.eY));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void clearStatus() {
        this.eL = e.EStatSingleFingerCandidate;
        this.eM = true;
        this.eZ = -1.0d;
        this.fc.removeMessages(1);
        if (this.fc.hasMessages(2)) {
            return;
        }
        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private float d(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.eT)) - this.eX) / ((float) (motionEvent.getEventTime() - this.eY));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.eN));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.eN));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float g(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.eT));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float h(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.eT));
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
                this.fu.put(Integer.valueOf(pointerId), vector);
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
                if (this.fu.containsKey(Integer.valueOf(pointerId2))) {
                    Vector<Float> vector2 = this.fu.get(Integer.valueOf(pointerId2));
                    f2 = x2 - vector2.elementAt(0).floatValue();
                    f3 = y2 - vector2.elementAt(1).floatValue();
                    this.fu.remove(Integer.valueOf(pointerId2));
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
                    if (this.fu.containsKey(Integer.valueOf(pointerId3))) {
                        Vector<Float> vector3 = this.fu.get(Integer.valueOf(pointerId3));
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
                if (this.fu.containsKey(Integer.valueOf(pointerId4))) {
                    Vector<Float> vector4 = this.fu.get(Integer.valueOf(pointerId4));
                    f6 = x4 - vector4.elementAt(0).floatValue();
                    f7 = y4 - vector4.elementAt(1).floatValue();
                    this.fu.remove(Integer.valueOf(pointerId4));
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
            f12 = this.fs - f3;
            f11 = this.fs - f7;
        } else {
            f11 = f6;
            f12 = f2;
            f2 = f3;
            f6 = f7;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length != 2 || windowSize[0] <= 0.0f || windowSize[1] <= 0.0f || this.fr <= 0 || this.fs <= 0) {
            f13 = f9;
            f14 = f8;
            f15 = f6;
            f16 = f11;
            f17 = f5;
            f18 = f4;
            f19 = f2;
            f20 = f12;
        } else {
            float f21 = windowSize[0] / this.fr;
            float f22 = windowSize[1] / this.fs;
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
        this.fs = i2;
        this.fr = i;
    }

    public void i(boolean z) {
        this.fv = z;
    }

    public void j(boolean z) {
        this.fq = z;
    }

    public void onPause() {
        ARPMessage.getInstance().removeMessageHandeler(this.fw);
    }

    public void onResume() {
        ARPMessage.getInstance().registerMessageHandler(11, this.fw);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fv && this.fq) {
            i(motionEvent);
            switch (this.eL) {
                case EStatSingleFingerCandidate:
                    if (motionEvent.getActionMasked() == 0) {
                        Log.d("touchopt", "touchinv Action Down when EStatSingleFingerCandidate");
                        this.eN = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.eO = motionEvent.getX();
                        this.eP = motionEvent.getY();
                        this.eQ = this.eO;
                        this.eR = this.eP;
                        this.eS = motionEvent.getEventTime();
                        if (this.fc.hasMessages(2) && this.ft != null && a(this.ft.x, this.ft.y, motionEvent.getX(), motionEvent.getY()) > 100.0d) {
                            bb();
                        }
                        this.fc.sendEmptyMessageDelayed(1, 600L);
                        Log.d("touchopt", String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.eO), Float.valueOf(this.eP), Long.valueOf(this.eS), Integer.valueOf(this.eN)));
                        return;
                    } else if (2 == motionEvent.getActionMasked()) {
                        double a = a(this.eO, this.eP, motionEvent.getX(), motionEvent.getY());
                        Log.d("touchopt", String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(a)));
                        if (a < 20.0d) {
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                this.eL = e.EStatLongPresss;
                                if (!this.fh && !this.fk) {
                                    a(b.EGESTURE_LONG_PRESS.ordinal(), motionEvent.getDownTime(), this.eN, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                                this.fc.removeMessages(1);
                            }
                        } else if (a < 50.0d) {
                            this.eM = false;
                        } else {
                            bb();
                            this.eL = e.EStatScroll;
                            if (!this.fh && !this.fm) {
                                a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eN, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            }
                            this.fc.removeMessages(1);
                        }
                        this.eQ = motionEvent.getX();
                        this.eR = motionEvent.getY();
                        this.eS = motionEvent.getEventTime();
                        return;
                    } else if (1 != motionEvent.getActionMasked()) {
                        if (5 == motionEvent.getActionMasked()) {
                            if (this.eM) {
                                this.eT = motionEvent.getPointerId(motionEvent.getActionIndex());
                                this.eU = motionEvent.getX(motionEvent.findPointerIndex(this.eT));
                                this.eV = motionEvent.getY(motionEvent.findPointerIndex(this.eT));
                                this.eY = motionEvent.getEventTime();
                                this.eW = this.eU;
                                this.eX = this.eV;
                                this.fa = a(motionEvent.getX(), motionEvent.getY(), this.eU, this.eV);
                                this.eL = e.EStatTwoFingersCandidate;
                            } else {
                                this.eL = e.EStatUnknown;
                            }
                            bb();
                            return;
                        }
                        return;
                    } else {
                        if (a(this.eO, this.eP, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.fh) {
                            if (this.fj) {
                                if (!this.fi) {
                                    a(b.EGESTURE_CLICK.ordinal(), motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                    a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                            } else if (this.fc.hasMessages(2)) {
                                this.fc.removeMessages(2);
                                a(b.EGESTURE_DOUBLE_CLICK.ordinal(), motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                C0077a c0077a = new C0077a();
                                c0077a.fz = motionEvent.getPointerId(0);
                                c0077a.x = motionEvent.getX();
                                c0077a.y = motionEvent.getY();
                                c0077a.time = motionEvent.getDownTime();
                                obtain.obj = c0077a;
                                this.ft = c0077a;
                                this.fc.sendMessageDelayed(obtain, 400L);
                            }
                        }
                        clearStatus();
                        return;
                    }
                case EStatTwoFingersCandidate:
                    if (5 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else {
                        float e2 = e(motionEvent);
                        float f2 = f(motionEvent);
                        float g = g(motionEvent);
                        float h = h(motionEvent);
                        double a2 = a(this.eO, this.eP, e2, f2);
                        double a3 = a(this.eU, this.eV, g, h);
                        if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
                            double a4 = a(this.eO, this.eP, e2, f2, this.eU, this.eV, g, h);
                            if (a4 < 0.7853981633974483d) {
                                this.eL = e.EStatTwoFingersScroll;
                                if (!this.fh && !this.fn) {
                                    a(b.EGESTURE_TWO_FINGER_SCROLL.ordinal(), motionEvent.getDownTime(), this.eN, e2, f2, a(motionEvent), b(motionEvent), this.eT, g, h, c(motionEvent), d(motionEvent), -1, 0.0f);
                                    Log.d("touchopt", "EStatTwoFingersScroll");
                                }
                            } else if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                                this.eL = e.EStatPinchAndUnpinch;
                                this.eZ = a(e2, f2, g, h);
                            } else {
                                float f3 = (this.eO + this.eU) / 2.0f;
                                float f4 = (this.eP + this.eV) / 2.0f;
                                double a5 = a(f3, f4, this.eO, this.eP, this.eO, this.eP, e2, f2);
                                double a6 = a(f3, f4, this.eU, this.eV, this.eU, this.eV, g, h);
                                if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                                    this.eL = e.EStatTwoFingerRotate;
                                    this.fb = a4;
                                } else {
                                    this.eL = e.EStatPinchAndUnpinch;
                                    this.eZ = a(e2, f2, g, h);
                                }
                            }
                        }
                        this.eQ = e2;
                        this.eR = f2;
                        this.eS = motionEvent.getEventTime();
                        this.eW = g;
                        this.eX = h;
                        this.eY = motionEvent.getEventTime();
                        return;
                    }
                case EStatScroll:
                    try {
                        if (5 == motionEvent.getActionMasked()) {
                            this.eO = motionEvent.getX(motionEvent.findPointerIndex(this.eN));
                            this.eP = motionEvent.getY(motionEvent.findPointerIndex(this.eN));
                            this.eQ = this.eO;
                            this.eR = this.eP;
                            this.eS = motionEvent.getEventTime();
                            this.eT = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.eU = motionEvent.getX(motionEvent.findPointerIndex(this.eT));
                            this.eV = motionEvent.getY(motionEvent.findPointerIndex(this.eT));
                            this.eY = motionEvent.getEventTime();
                            this.eW = this.eU;
                            this.eX = this.eV;
                            this.eL = e.EStatTwoFingersCandidate;
                            if (this.fh || this.fm) {
                                return;
                            }
                            a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            return;
                        } else if (6 == motionEvent.getActionMasked()) {
                            this.eL = e.EStatUnknown;
                            return;
                        } else if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else if (2 != motionEvent.getActionMasked()) {
                            this.eL = e.EStatUnknown;
                            return;
                        } else if (motionEvent.getEventTime() - this.eS >= 1) {
                            float e3 = e(motionEvent);
                            float f5 = f(motionEvent);
                            if (!this.fh && !this.fm) {
                                a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eN, e3, f5, a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                            }
                            float f6 = e3 - this.eQ;
                            float f7 = f5 - this.eR;
                            float eventTime = f6 / ((float) (motionEvent.getEventTime() - this.eS));
                            float eventTime2 = f7 / ((float) (motionEvent.getEventTime() - this.eS));
                            if (Math.abs(f6) > Math.abs(f7) && Math.abs(f6) > 100.0d && Math.abs(eventTime) > 20.0d) {
                                if (f6 > 0.0f) {
                                    this.fg = d.ESWIPE_RIGHT;
                                } else {
                                    this.fg = d.ESWIPE_LEFT;
                                }
                                this.eL = e.EStatSwipe;
                            } else if (Math.abs(f7) > Math.abs(f6) && Math.abs(f7) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                                if (f7 > 0.0f) {
                                    this.fg = d.ESWIPE_DOWN;
                                } else {
                                    this.fg = d.ESWIPE_UP;
                                }
                                this.eL = e.EStatSwipe;
                            }
                            this.eQ = e3;
                            this.eR = f5;
                            this.eS = motionEvent.getEventTime();
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e4) {
                        Log.e(" BaiduArView", "Monkey event.getX Exception");
                        return;
                    }
                case EStatSwipe:
                    if (1 != motionEvent.getActionMasked() || this.fh || this.fl) {
                        return;
                    }
                    a(b.EGESTURE_SWIPE.ordinal(), motionEvent.getEventTime(), this.eN, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.fg.ordinal(), 0.0f);
                    clearStatus();
                    return;
                case EStatTwoFingersScroll:
                    if (5 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eN) {
                            this.eN = this.eT;
                            this.eO = this.eU;
                            this.eP = this.eV;
                            this.eQ = this.eW;
                            this.eR = this.eX;
                            this.eS = this.eY;
                        }
                        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.eS < 1 || motionEvent.getEventTime() - this.eY < 1) {
                        return;
                    } else {
                        float e5 = e(motionEvent);
                        float f8 = f(motionEvent);
                        float g2 = g(motionEvent);
                        float h2 = h(motionEvent);
                        if (!this.fh && !this.fn) {
                            a(b.EGESTURE_TWO_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eN, e5, f8, a(motionEvent), b(motionEvent), this.eT, g2, h2, c(motionEvent), d(motionEvent), -1, 0.0f);
                        }
                        this.eQ = e5;
                        this.eR = f8;
                        this.eS = motionEvent.getEventTime();
                        this.eW = g2;
                        this.eX = h2;
                        this.eY = motionEvent.getEventTime();
                        return;
                    }
                case EStatPinchAndUnpinch:
                    if (5 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        this.fd = true;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.eL = e.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.eN) {
                            this.eN = this.eT;
                        }
                        this.fd = true;
                        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.eL = e.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.eS < 1 || motionEvent.getEventTime() - this.eY < 1) {
                        return;
                    } else {
                        float e6 = e(motionEvent);
                        float f9 = f(motionEvent);
                        float g3 = g(motionEvent);
                        float h3 = h(motionEvent);
                        double a7 = a(e6, f9, g3, h3);
                        if (a7 > this.eZ) {
                            if (!this.fh && !this.fo) {
                                if (!this.fd) {
                                    if (this.fe) {
                                        a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                    }
                                    this.fe = false;
                                }
                                a(b.EGESTURE_TWO_FINGER_UNPINCH.ordinal(), motionEvent.getEventTime(), this.eN, e6, f9, a(motionEvent), b(motionEvent), this.eT, g3, h3, c(motionEvent), d(motionEvent), -1, 0.0f);
                                if (this.fd) {
                                    this.fe = false;
                                }
                            }
                        } else if (!this.fh && !this.fo) {
                            if (!this.fd) {
                                if (!this.fe) {
                                    a(b.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                                }
                                this.fe = true;
                            }
                            a(b.EGESTURE_TWO_FINGER_PINCH.ordinal(), motionEvent.getEventTime(), this.eN, e6, f9, a(motionEvent), b(motionEvent), this.eT, g3, h3, c(motionEvent), d(motionEvent), -1, 0.0f);
                            if (this.fd) {
                                this.fe = true;
                            }
                        }
                        this.eZ = a7;
                        this.eQ = e6;
                        this.eR = f9;
                        this.eS = motionEvent.getEventTime();
                        this.eW = g3;
                        this.eX = h3;
                        this.eY = motionEvent.getEventTime();
                        return;
                    }
                case EStatTwoFingerRotate:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else {
                            this.eL = e.EStatUnknown;
                            return;
                        }
                    }
                    float e7 = e(motionEvent);
                    float f10 = f(motionEvent);
                    float g4 = g(motionEvent);
                    float h4 = h(motionEvent);
                    double a8 = a(this.eW - this.eQ, this.eX - this.eR, g4 - e7, h4 - f10);
                    if (!this.fh && !this.fp) {
                        a(b.EGESTURE_TWO_FINGER_ROTATE.ordinal(), motionEvent.getEventTime(), this.eN, e7, f10, -1.0f, -1.0f, this.eT, g4, h4, -1.0f, -1.0f, -1, (float) a8);
                    }
                    this.eQ = e7;
                    this.eR = f10;
                    this.eS = motionEvent.getEventTime();
                    this.eW = g4;
                    this.eX = h4;
                    this.eY = motionEvent.getEventTime();
                    return;
                case EStatLongPresss:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 == motionEvent.getActionMasked()) {
                            clearStatus();
                            return;
                        } else {
                            this.eL = e.EStatUnknown;
                            return;
                        }
                    } else if (a(this.eO, this.eP, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
                        this.eL = e.EScrollAfterLongPress;
                        if (!this.fh && !this.fm) {
                            a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eN, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                        }
                        this.eQ = e(motionEvent);
                        this.eR = f(motionEvent);
                        this.eS = motionEvent.getEventTime();
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
                            this.eL = e.EStatUnknown;
                            return;
                        }
                    }
                    if (!this.fh && !this.fm) {
                        a(b.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), motionEvent.getEventTime(), this.eN, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
                    }
                    this.eQ = e(motionEvent);
                    this.eR = f(motionEvent);
                    this.eS = motionEvent.getEventTime();
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
