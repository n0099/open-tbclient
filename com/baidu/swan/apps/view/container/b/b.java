package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.m.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = c.DEBUG;
    private String aYN;
    private String aYO;
    private C0155b aYR;
    private long aYS;
    private String azs;
    private boolean aYP = false;
    private int[] aYQ = new int[2];
    private a aYT = new a();

    public b(String str, String str2, String str3) {
        this.azs = str;
        this.aYN = str2;
        this.aYO = str3;
        MR();
        MS();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean MQ() {
        SwanCoreVersion As = com.baidu.swan.apps.core.i.c.Ab().As();
        long j = As != null ? As.aTc : 0L;
        long hg = com.baidu.swan.apps.swancore.b.hg("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + hg + ";curSwanVersion: " + j);
        }
        if (j < hg) {
            return false;
        }
        return true;
    }

    private void MR() {
        this.aYP = !MQ() && TextUtils.equals("canvas", this.aYO);
    }

    private void MS() {
        AbsoluteLayout eO = aa.eO(this.azs);
        if (eO != null) {
            eO.getLocationOnScreen(this.aYQ);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.azs) || TextUtils.isEmpty(this.aYN)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.azs + " ; viewId = " + this.aYN);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.aYR = new C0155b(motionEvent.getX(), motionEvent.getY());
            this.aYS = motionEvent.getEventTime();
            this.aYT.s(motionEvent);
            view.postDelayed(this.aYT, 350L);
            MS();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0155b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.aYT);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0155b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.aYS < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.aYP) {
            e.Ec().a(this.azs, fVar);
        } else {
            e.Ec().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.aYQ);
        f fVar = new f();
        fVar.mData = d.c(this.azs, this.aYN, this.aYO, aVar.MN(), aVar.MO());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.aYQ);
        f fVar = new f();
        fVar.mData = d.c(this.azs, this.aYN, this.aYO, aVar.MN(), aVar.MO());
        return fVar;
    }

    private boolean a(C0155b c0155b) {
        return this.aYR != null && this.aYR.b(c0155b) <= ((double) x.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent aYU;
        private f aYV;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.aYU = motionEvent;
            this.aYV = b.this.b(this.aYU, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.aYV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0155b {
        private double x;
        private double y;

        public C0155b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0155b c0155b) {
            if (c0155b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0155b.x - this.x, 2.0d) + Math.pow(c0155b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
