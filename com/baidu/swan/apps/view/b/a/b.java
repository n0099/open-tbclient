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
/* loaded from: classes10.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aXX;
    private C0296b bWC;
    private long bWD;
    private String bWy;
    private String bWz;
    private boolean bWA = false;
    private int[] bWB = new int[2];
    private a bWE = new a();

    public b(String str, String str2, String str3) {
        this.aXX = str;
        this.bWy = str2;
        this.bWz = str3;
        afv();
        afw();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean afu() {
        SwanCoreVersion OA = d.Og().OA();
        long j = OA != null ? OA.swanCoreVersion : 0L;
        long ma = com.baidu.swan.apps.swancore.b.ma("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + ma + ";curSwanVersion: " + j);
        }
        if (j < ma) {
            return false;
        }
        return true;
    }

    private void afv() {
        this.bWA = !afu() && TextUtils.equals("canvas", this.bWz);
    }

    private void afw() {
        AbsoluteLayout iE = ai.iE(this.aXX);
        if (iE != null) {
            iE.getLocationOnScreen(this.bWB);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aXX) || TextUtils.isEmpty(this.bWy)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aXX + " ; viewId = " + this.bWy);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bWC = new C0296b(motionEvent.getX(), motionEvent.getY());
            this.bWD = motionEvent.getEventTime();
            this.bWE.o(motionEvent);
            view.postDelayed(this.bWE, 350L);
            afw();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0296b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bWE);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0296b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bWD < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bWA) {
            com.baidu.swan.apps.y.f.UC().a(this.aXX, fVar);
        } else {
            com.baidu.swan.apps.y.f.UC().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.bWB);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.aXX, this.bWy, this.bWz, aVar.afr(), aVar.afs());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.bWB);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.aXX, this.bWy, this.bWz, aVar.afr(), aVar.afs());
        return fVar;
    }

    private boolean a(C0296b c0296b) {
        return this.bWC != null && this.bWC.b(c0296b) <= ((double) af.S(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private MotionEvent bWF;
        private f bWG;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.bWF = motionEvent;
            this.bWG = b.this.b(this.bWF, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bWG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0296b {
        private double x;
        private double y;

        public C0296b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0296b c0296b) {
            if (c0296b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0296b.x - this.x, 2.0d) + Math.pow(c0296b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
