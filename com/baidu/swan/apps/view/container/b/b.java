package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.core.i.c;
import com.baidu.swan.apps.m.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aYR;
    private String aYS;
    private C0184b aYV;
    private long aYW;
    private String azw;
    private boolean aYT = false;
    private int[] aYU = new int[2];
    private a aYX = new a();

    public b(String str, String str2, String str3) {
        this.azw = str;
        this.aYR = str2;
        this.aYS = str3;
        MP();
        MQ();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean MO() {
        SwanCoreVersion Ar = c.Aa().Ar();
        long j = Ar != null ? Ar.aTg : 0L;
        long hh = com.baidu.swan.apps.swancore.b.hh("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + hh + ";curSwanVersion: " + j);
        }
        if (j < hh) {
            return false;
        }
        return true;
    }

    private void MP() {
        this.aYT = !MO() && TextUtils.equals("canvas", this.aYS);
    }

    private void MQ() {
        AbsoluteLayout eP = aa.eP(this.azw);
        if (eP != null) {
            eP.getLocationOnScreen(this.aYU);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.azw) || TextUtils.isEmpty(this.aYR)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.azw + " ; viewId = " + this.aYR);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.aYV = new C0184b(motionEvent.getX(), motionEvent.getY());
            this.aYW = motionEvent.getEventTime();
            this.aYX.s(motionEvent);
            view.postDelayed(this.aYX, 350L);
            MQ();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0184b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.aYX);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0184b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.aYW < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.aYT) {
            e.Ea().a(this.azw, fVar);
        } else {
            e.Ea().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.aYU);
        f fVar = new f();
        fVar.mData = d.c(this.azw, this.aYR, this.aYS, aVar.ML(), aVar.MM());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.aYU);
        f fVar = new f();
        fVar.mData = d.c(this.azw, this.aYR, this.aYS, aVar.ML(), aVar.MM());
        return fVar;
    }

    private boolean a(C0184b c0184b) {
        return this.aYV != null && this.aYV.b(c0184b) <= ((double) x.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent aYY;
        private f aYZ;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.aYY = motionEvent;
            this.aYZ = b.this.b(this.aYY, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.aYZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0184b {
        private double x;
        private double y;

        public C0184b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0184b c0184b) {
            if (c0184b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0184b.x - this.x, 2.0d) + Math.pow(c0184b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
