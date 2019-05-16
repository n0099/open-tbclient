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
    private String aAv;
    private String bbG;
    private String bbH;
    private C0192b bbK;
    private long bbL;
    private boolean bbI = false;
    private int[] bbJ = new int[2];
    private a bbM = new a();

    public b(String str, String str2, String str3) {
        this.aAv = str;
        this.bbG = str2;
        this.bbH = str3;
        Py();
        Pz();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean Px() {
        SwanCoreVersion BA = c.Bi().BA();
        long j = BA != null ? BA.aVW : 0L;
        long hI = com.baidu.swan.apps.swancore.b.hI("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + hI + ";curSwanVersion: " + j);
        }
        if (j < hI) {
            return false;
        }
        return true;
    }

    private void Py() {
        this.bbI = !Px() && TextUtils.equals("canvas", this.bbH);
    }

    private void Pz() {
        AbsoluteLayout fa = ac.fa(this.aAv);
        if (fa != null) {
            fa.getLocationOnScreen(this.bbJ);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aAv) || TextUtils.isEmpty(this.bbG)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aAv + " ; viewId = " + this.bbG);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bbK = new C0192b(motionEvent.getX(), motionEvent.getY());
            this.bbL = motionEvent.getEventTime();
            this.bbM.s(motionEvent);
            view.postDelayed(this.bbM, 350L);
            Pz();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0192b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bbM);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0192b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bbL < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bbI) {
            e.FV().a(this.aAv, fVar);
        } else {
            e.FV().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.bbJ);
        f fVar = new f();
        fVar.mData = d.c(this.aAv, this.bbG, this.bbH, aVar.Pu(), aVar.Pv());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.bbJ);
        f fVar = new f();
        fVar.mData = d.c(this.aAv, this.bbG, this.bbH, aVar.Pu(), aVar.Pv());
        return fVar;
    }

    private boolean a(C0192b c0192b) {
        return this.bbK != null && this.bbK.b(c0192b) <= ((double) z.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent bbN;
        private f bbO;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.bbN = motionEvent;
            this.bbO = b.this.b(this.bbN, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bbO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0192b {
        private double x;
        private double y;

        public C0192b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0192b c0192b) {
            if (c0192b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0192b.x - this.x, 2.0d) + Math.pow(c0192b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
