package com.baidu.baiduarsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ArTouchEvent {
    private static final double[] r = {1.5707963267948966d, 3.141592653589793d};
    private b q;
    private TouchEventStatus b = TouchEventStatus.EStatSingleFingerCandidate;
    private boolean c = true;
    private int d = -1;
    private float e = -1.0f;
    private float f = -1.0f;
    private float g = -1.0f;
    private float h = -1.0f;
    private long i = -1;
    private int j = -1;
    private float k = -1.0f;
    private float l = -1.0f;
    private float m = -1.0f;
    private float n = -1.0f;
    private long o = -1;
    private double p = -1.0d;
    private boolean s = false;
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private boolean w = true;
    private boolean x = true;
    private boolean y = true;
    private boolean z = true;
    private a A = null;
    private boolean B = false;
    ArBridge.d a = new ArBridge.d() { // from class: com.baidu.baiduarsdk.ArTouchEvent.1
        @Override // com.baidu.baiduarsdk.ArBridge.d
        public void a(int i, int i2, HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get("disable_all") != null) {
                    if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                        ArTouchEvent.this.s = true;
                    } else {
                        ArTouchEvent.this.s = false;
                    }
                }
                if (hashMap.get("disable_pinch") != null) {
                    if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                        ArTouchEvent.this.t = true;
                    } else {
                        ArTouchEvent.this.t = false;
                    }
                }
                if (hashMap.get("disable_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                        ArTouchEvent.this.u = true;
                    } else {
                        ArTouchEvent.this.u = false;
                    }
                }
                if (hashMap.get("disable_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                        ArTouchEvent.this.w = true;
                    } else {
                        ArTouchEvent.this.w = false;
                    }
                }
                if (hashMap.get("disable_long_press") != null) {
                    if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                        ArTouchEvent.this.y = true;
                    } else {
                        ArTouchEvent.this.y = false;
                    }
                }
                if (hashMap.get("disable_double_click") != null) {
                    if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                        ArTouchEvent.this.v = true;
                    } else {
                        ArTouchEvent.this.v = false;
                    }
                }
                if (hashMap.get("disable_two_finger_scroll") != null) {
                    if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                        ArTouchEvent.this.x = true;
                    } else {
                        ArTouchEvent.this.x = false;
                    }
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public enum TouchEventStatus {
        EStatSingleFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPresss,
        EStatScroll,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatUnknown
    }

    /* loaded from: classes3.dex */
    public enum TouchEventType {
        EClick,
        ELongPress,
        EScroll,
        ETwoFingerScroll,
        EPinch,
        EUnPinch,
        EScrollAfterLongPress,
        EDoubleClick,
        EClear,
        ESCROLL_DOWN,
        ESHAKE,
        ESCROLL_UP
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public int a;
        public float b;
        public float c;
        public long d;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        WeakReference<ArTouchEvent> a;

        public b(Looper looper, ArTouchEvent arTouchEvent) {
            super(looper);
            this.a = new WeakReference<>(arTouchEvent);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (this.a.get() != null && this.a.get().b == TouchEventStatus.EStatSingleFingerCandidate && this.a.get().c) {
                        this.a.get().b = TouchEventStatus.EStatLongPresss;
                        if (this.a.get().s || this.a.get().y) {
                            return;
                        }
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.a.get().d, this.a.get().g, this.a.get().h, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, Calendar.getInstance().getTimeInMillis());
                        return;
                    }
                    return;
                case 2:
                    ArTouchEvent arTouchEvent = this.a.get();
                    if (arTouchEvent == null || message.obj == null) {
                        return;
                    }
                    a aVar = (a) message.obj;
                    if (!arTouchEvent.u) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), aVar.a, aVar.b, aVar.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, aVar.d);
                    }
                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                    return;
                default:
                    return;
            }
        }
    }

    public ArTouchEvent(Looper looper) {
        this.q = new b(looper, this);
    }

    private double a(float f, float f2, float f3, float f4) {
        return Math.sqrt(((f3 - f) * (f3 - f)) + ((f4 - f2) * (f4 - f2)));
    }

    private double a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (Math.abs(((f4 - f2) / (f3 - f)) - ((f8 - f6) / (f7 - f5))) < 1.0E-7d) {
            return -1.0d;
        }
        float f9 = f3 - f;
        float f10 = f4 - f2;
        float f11 = f7 - f5;
        float f12 = f8 - f6;
        a(String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f9), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)));
        double sqrt = ((f9 * f11) + (f10 * f12)) / (Math.sqrt((f9 * f9) + (f10 * f10)) * Math.sqrt((f11 * f11) + (f12 * f12)));
        a("touchopt" + String.format("cosAngle is %1.3f", Double.valueOf(sqrt)));
        return Math.acos(sqrt);
    }

    private float b(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.d)) - this.g) / ((float) (motionEvent.getEventTime() - this.i));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.d)) - this.h) / ((float) (motionEvent.getEventTime() - this.i));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private void c() {
        this.b = TouchEventStatus.EStatSingleFingerCandidate;
        this.c = true;
        this.p = -1.0d;
        this.q.removeMessages(1);
        if (this.q.hasMessages(2)) {
            return;
        }
        ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
    }

    private float d(MotionEvent motionEvent) {
        try {
            return (motionEvent.getX(motionEvent.findPointerIndex(this.j)) - this.m) / ((float) (motionEvent.getEventTime() - this.o));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private void d() {
        if (this.q.hasMessages(2)) {
            this.q.removeMessages(2);
            if (this.A != null) {
                if (!this.u) {
                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), this.A.a, this.A.b, this.A.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.A.d);
                }
                ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                this.A = null;
            }
        }
    }

    private float e(MotionEvent motionEvent) {
        try {
            return (motionEvent.getY(motionEvent.findPointerIndex(this.j)) - this.n) / ((float) (motionEvent.getEventTime() - this.o));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.d));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private float g(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.d));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private float h(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.j));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    private float i(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.j));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public void a() {
        ArBridge.getInstance().registerMessageHandler(11, this.a);
    }

    public void a(MotionEvent motionEvent) {
        if (this.B && this.z) {
            switch (this.b) {
                case EStatSingleFingerCandidate:
                    if (motionEvent.getActionMasked() == 0) {
                        Log.d("touchopt", "touchinv Action Down when EStatSingleFingerCandidate");
                        this.d = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.e = motionEvent.getX();
                        this.f = motionEvent.getY();
                        this.g = this.e;
                        this.h = this.f;
                        this.i = motionEvent.getEventTime();
                        if (this.q.hasMessages(2) && this.A != null && a(this.A.b, this.A.c, motionEvent.getX(), motionEvent.getY()) > 100.0d) {
                            d();
                        }
                        this.q.sendEmptyMessageDelayed(1, 600L);
                        Log.d("touchopt", String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.e), Float.valueOf(this.f), Long.valueOf(this.i), Integer.valueOf(this.d)));
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_DOWN.ordinal(), this.d, this.e, this.f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.i);
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        return;
                    } else if (2 == motionEvent.getActionMasked()) {
                        double a2 = a(this.e, this.f, motionEvent.getX(), motionEvent.getY());
                        Log.d("touchopt", String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(a2)));
                        if (a2 < 20.0d) {
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                this.b = TouchEventStatus.EStatLongPresss;
                                if (!this.s && !this.y) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.d, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                                this.q.removeMessages(1);
                            }
                        } else if (a2 < 80.0d) {
                            this.c = false;
                        } else {
                            d();
                            this.b = TouchEventStatus.EStatScroll;
                            if (!this.s && !this.w) {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.d, motionEvent.getX(), motionEvent.getY(), b(motionEvent), c(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.q.removeMessages(1);
                        }
                        this.g = motionEvent.getX();
                        this.h = motionEvent.getY();
                        this.i = motionEvent.getEventTime();
                        return;
                    } else if (1 != motionEvent.getActionMasked()) {
                        if (5 == motionEvent.getActionMasked()) {
                            if (this.c) {
                                this.j = motionEvent.getPointerId(motionEvent.getActionIndex());
                                this.k = motionEvent.getX(motionEvent.findPointerIndex(this.j));
                                this.l = motionEvent.getY(motionEvent.findPointerIndex(this.j));
                                this.o = motionEvent.getEventTime();
                                this.m = this.k;
                                this.n = this.l;
                                this.b = TouchEventStatus.EStatTwoFingersCandidate;
                            } else {
                                this.b = TouchEventStatus.EStatUnknown;
                            }
                            d();
                            return;
                        }
                        return;
                    } else {
                        if (a(this.e, this.f, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.s) {
                            if (this.v) {
                                if (!this.u) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                            } else if (this.q.hasMessages(2)) {
                                this.q.removeMessages(2);
                                ArBridge.getInstance().onTouchEvent(TouchEventType.EDoubleClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                a aVar = new a();
                                aVar.a = motionEvent.getPointerId(0);
                                aVar.b = motionEvent.getX();
                                aVar.c = motionEvent.getY();
                                aVar.d = motionEvent.getDownTime();
                                obtain.obj = aVar;
                                this.A = aVar;
                                this.q.sendMessageDelayed(obtain, 400L);
                            }
                        }
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        c();
                        return;
                    }
                case EStatTwoFingersCandidate:
                    if (5 == motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else {
                        float f = f(motionEvent);
                        float g = g(motionEvent);
                        float h = h(motionEvent);
                        float i = i(motionEvent);
                        double a3 = a(this.e, this.f, f, g);
                        double a4 = a(this.k, this.l, h, i);
                        if ((a3 > 80.0d || a4 > 80.0d) && a3 > 20.0d && a4 > 20.0d) {
                            double a5 = a(this.e, this.f, f, g, this.k, this.l, h, i);
                            Log.d("touchopt", String.format("the angle is %1.3f", Double.valueOf(a5)));
                            a(this.e, this.f, motionEvent.getX(), motionEvent.getY());
                            if (a5 < 0.7853981633974483d) {
                                this.b = TouchEventStatus.EStatTwoFingersScroll;
                                if (!this.s && !this.x) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.d, f, g, b(motionEvent), c(motionEvent), this.j, h, i, d(motionEvent), e(motionEvent), motionEvent.getEventTime());
                                    Log.d("touchopt", "EStatTwoFingersScroll");
                                }
                            } else {
                                this.b = TouchEventStatus.EStatPinchAndUnpinch;
                                this.p = a(f, g, h, i);
                            }
                        }
                        this.g = f;
                        this.h = g;
                        this.i = motionEvent.getEventTime();
                        this.m = h;
                        this.n = i;
                        this.o = motionEvent.getEventTime();
                        return;
                    }
                case EStatScroll:
                    try {
                        if (5 == motionEvent.getActionMasked()) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                            this.e = motionEvent.getX(motionEvent.findPointerIndex(this.d));
                            this.f = motionEvent.getY(motionEvent.findPointerIndex(this.d));
                            this.g = this.e;
                            this.h = this.f;
                            this.i = motionEvent.getEventTime();
                            this.j = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.k = motionEvent.getX(motionEvent.findPointerIndex(this.j));
                            this.l = motionEvent.getY(motionEvent.findPointerIndex(this.j));
                            this.o = motionEvent.getEventTime();
                            this.m = this.k;
                            this.n = this.l;
                            this.b = TouchEventStatus.EStatTwoFingersCandidate;
                            return;
                        } else if (6 == motionEvent.getActionMasked()) {
                            this.b = TouchEventStatus.EStatUnknown;
                            return;
                        } else if (1 == motionEvent.getActionMasked()) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                            c();
                            return;
                        } else if (2 != motionEvent.getActionMasked()) {
                            this.b = TouchEventStatus.EStatUnknown;
                            return;
                        } else if (motionEvent.getEventTime() - this.i >= 1) {
                            float f2 = f(motionEvent);
                            float g2 = g(motionEvent);
                            if (!this.s && !this.w) {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.d, f2, g2, b(motionEvent), c(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.g = f2;
                            this.h = g2;
                            this.i = motionEvent.getEventTime();
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        Log.e(" BaiduArView", "Monkey event.getX Exception");
                        return;
                    }
                case EStatTwoFingersScroll:
                    if (5 == motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        this.b = TouchEventStatus.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.d) {
                            this.d = this.j;
                            return;
                        }
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.i < 1 || motionEvent.getEventTime() - this.o < 1) {
                        return;
                    } else {
                        float f3 = f(motionEvent);
                        float g3 = g(motionEvent);
                        float h2 = h(motionEvent);
                        float i2 = i(motionEvent);
                        if (!this.s && !this.x) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.d, f3, g3, b(motionEvent), c(motionEvent), this.j, h2, i2, d(motionEvent), e(motionEvent), motionEvent.getEventTime());
                        }
                        this.g = f3;
                        this.h = g3;
                        this.i = motionEvent.getEventTime();
                        this.m = h2;
                        this.n = i2;
                        this.o = motionEvent.getEventTime();
                        return;
                    }
                case EStatPinchAndUnpinch:
                    if (5 == motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (6 == motionEvent.getActionMasked()) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        this.b = TouchEventStatus.EStatScroll;
                        if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.d) {
                            this.d = this.j;
                            return;
                        }
                        return;
                    } else if (2 != motionEvent.getActionMasked()) {
                        this.b = TouchEventStatus.EStatUnknown;
                        return;
                    } else if (motionEvent.getEventTime() - this.i < 1 || motionEvent.getEventTime() - this.o < 1) {
                        return;
                    } else {
                        float f4 = f(motionEvent);
                        float g4 = g(motionEvent);
                        float h3 = h(motionEvent);
                        float i3 = i(motionEvent);
                        double a6 = a(f4, g4, h3, i3);
                        if (a6 > this.p) {
                            if (!this.s && !this.t) {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.EUnPinch.ordinal(), this.d, f4, g4, b(motionEvent), c(motionEvent), this.j, h3, i3, d(motionEvent), e(motionEvent), motionEvent.getEventTime());
                            }
                        } else if (!this.s && !this.t) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EPinch.ordinal(), this.d, f4, g4, b(motionEvent), c(motionEvent), this.j, h3, i3, d(motionEvent), e(motionEvent), motionEvent.getEventTime());
                        }
                        this.p = a6;
                        this.g = f4;
                        this.h = g4;
                        this.i = motionEvent.getEventTime();
                        this.m = h3;
                        this.n = i3;
                        this.o = motionEvent.getEventTime();
                        return;
                    }
                case EStatLongPresss:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 != motionEvent.getActionMasked()) {
                            this.b = TouchEventStatus.EStatUnknown;
                            return;
                        }
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        c();
                        return;
                    } else if (a(this.e, this.f, motionEvent.getX(), motionEvent.getY()) > 80.0d) {
                        this.b = TouchEventStatus.EScrollAfterLongPress;
                        if (!this.s && !this.w) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.d, motionEvent.getX(), motionEvent.getY(), b(motionEvent), c(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.g = f(motionEvent);
                        this.h = g(motionEvent);
                        this.i = motionEvent.getEventTime();
                        return;
                    } else {
                        return;
                    }
                case EScrollAfterLongPress:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 != motionEvent.getActionMasked()) {
                            this.b = TouchEventStatus.EStatUnknown;
                            return;
                        }
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        c();
                        return;
                    }
                    if (!this.s && !this.w) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.d, motionEvent.getX(), motionEvent.getY(), b(motionEvent), c(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                    }
                    this.g = f(motionEvent);
                    this.h = g(motionEvent);
                    this.i = motionEvent.getEventTime();
                    return;
                case EStatPinch:
                case EStatUnPinch:
                case EStatUnknown:
                    if (1 == motionEvent.getActionMasked()) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        c();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void a(String str) {
        Log.d("ar TouchEventLog ", str);
    }

    public void a(boolean z) {
        this.B = z;
    }

    public void b() {
        ArBridge.getInstance().removeMessageHandeler(this.a);
    }

    public void b(boolean z) {
        this.z = z;
    }
}
