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
    private String aYO;
    private String aYP;
    private C0184b aYS;
    private long aYT;
    private String azt;
    private boolean aYQ = false;
    private int[] aYR = new int[2];
    private a aYU = new a();

    public b(String str, String str2, String str3) {
        this.azt = str;
        this.aYO = str2;
        this.aYP = str3;
        MR();
        MS();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean MQ() {
        SwanCoreVersion As = c.Ab().As();
        long j = As != null ? As.aTd : 0L;
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
        this.aYQ = !MQ() && TextUtils.equals("canvas", this.aYP);
    }

    private void MS() {
        AbsoluteLayout eO = aa.eO(this.azt);
        if (eO != null) {
            eO.getLocationOnScreen(this.aYR);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.azt) || TextUtils.isEmpty(this.aYO)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.azt + " ; viewId = " + this.aYO);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.aYS = new C0184b(motionEvent.getX(), motionEvent.getY());
            this.aYT = motionEvent.getEventTime();
            this.aYU.s(motionEvent);
            view.postDelayed(this.aYU, 350L);
            MS();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0184b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.aYU);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0184b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.aYT < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.aYQ) {
            e.Ec().a(this.azt, fVar);
        } else {
            e.Ec().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.aYR);
        f fVar = new f();
        fVar.mData = d.c(this.azt, this.aYO, this.aYP, aVar.MN(), aVar.MO());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.aYR);
        f fVar = new f();
        fVar.mData = d.c(this.azt, this.aYO, this.aYP, aVar.MN(), aVar.MO());
        return fVar;
    }

    private boolean a(C0184b c0184b) {
        return this.aYS != null && this.aYS.b(c0184b) <= ((double) x.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent aYV;
        private f aYW;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.aYV = motionEvent;
            this.aYW = b.this.b(this.aYV, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.aYW);
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
