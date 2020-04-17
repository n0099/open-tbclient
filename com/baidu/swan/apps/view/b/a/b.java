package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.n.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bAK;
    private String czR;
    private String czS;
    private C0336b czV;
    private long czW;
    private boolean czT = false;
    private int[] czU = new int[2];
    private a czX = new a();

    public b(String str, String str2, String str3) {
        this.bAK = str;
        this.czR = str2;
        this.czS = str3;
        apW();
        apX();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean apV() {
        SwanCoreVersion YI = d.Yo().YI();
        long j = YI != null ? YI.swanCoreVersion : 0L;
        long nB = com.baidu.swan.apps.swancore.b.nB("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + nB + ";curSwanVersion: " + j);
        }
        if (j < nB) {
            return false;
        }
        return true;
    }

    private void apW() {
        this.czT = !apV() && TextUtils.equals("canvas", this.czS);
    }

    private void apX() {
        AbsoluteLayout kf = ai.kf(this.bAK);
        if (kf != null) {
            kf.getLocationOnScreen(this.czU);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bAK) || TextUtils.isEmpty(this.czR)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bAK + " ; viewId = " + this.czR);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.czV = new C0336b(motionEvent.getX(), motionEvent.getY());
            this.czW = motionEvent.getEventTime();
            this.czX.n(motionEvent);
            view.postDelayed(this.czX, 350L);
            apX();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0336b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.czX);
        }
        a(m(motionEvent));
        if (actionMasked == 1 && a(new C0336b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.czW < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.czT) {
            com.baidu.swan.apps.y.f.aeK().a(this.bAK, fVar);
        } else {
            com.baidu.swan.apps.y.f.aeK().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.czU);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bAK, this.czR, this.czS, aVar.apS(), aVar.apT());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f m(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.czU);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bAK, this.czR, this.czS, aVar.apS(), aVar.apT());
        return fVar;
    }

    private boolean a(C0336b c0336b) {
        return this.czV != null && this.czV.b(c0336b) <= ((double) af.C(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent czY;
        private f czZ;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(MotionEvent motionEvent) {
            this.czY = motionEvent;
            this.czZ = b.this.b(this.czY, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.czZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0336b {
        private double x;
        private double y;

        public C0336b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0336b c0336b) {
            if (c0336b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0336b.x - this.x, 2.0d) + Math.pow(c0336b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
