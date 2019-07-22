package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.m.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aBd;
    private String bcs;
    private String bct;
    private C0189b bcw;
    private long bcx;
    private boolean bcu = false;
    private int[] bcv = new int[2];
    private a bcy = new a();

    public b(String str, String str2, String str3) {
        this.aBd = str;
        this.bcs = str2;
        this.bct = str3;
        Qp();
        Qq();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean Qo() {
        SwanCoreVersion Ci = c.BQ().Ci();
        long j = Ci != null ? Ci.aWG : 0L;
        long hO = com.baidu.swan.apps.swancore.b.hO("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + hO + ";curSwanVersion: " + j);
        }
        if (j < hO) {
            return false;
        }
        return true;
    }

    private void Qp() {
        this.bcu = !Qo() && TextUtils.equals("canvas", this.bct);
    }

    private void Qq() {
        AbsoluteLayout fe = ac.fe(this.aBd);
        if (fe != null) {
            fe.getLocationOnScreen(this.bcv);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aBd) || TextUtils.isEmpty(this.bcs)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aBd + " ; viewId = " + this.bcs);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bcw = new C0189b(motionEvent.getX(), motionEvent.getY());
            this.bcx = motionEvent.getEventTime();
            this.bcy.s(motionEvent);
            view.postDelayed(this.bcy, 350L);
            Qq();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0189b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bcy);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0189b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bcx < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bcu) {
            e.GF().a(this.aBd, fVar);
        } else {
            e.GF().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.bcv);
        f fVar = new f();
        fVar.mData = d.c(this.aBd, this.bcs, this.bct, aVar.Ql(), aVar.Qm());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.bcv);
        f fVar = new f();
        fVar.mData = d.c(this.aBd, this.bcs, this.bct, aVar.Ql(), aVar.Qm());
        return fVar;
    }

    private boolean a(C0189b c0189b) {
        return this.bcw != null && this.bcw.b(c0189b) <= ((double) z.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private f bcA;
        private MotionEvent bcz;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.bcz = motionEvent;
            this.bcA = b.this.b(this.bcz, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bcA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0189b {
        private double x;
        private double y;

        public C0189b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0189b c0189b) {
            if (c0189b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0189b.x - this.x, 2.0d) + Math.pow(c0189b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
