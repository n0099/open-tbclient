package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cGy;
    private String dVf;
    private String dVg;
    private C0499b dVj;
    private long dVk;
    private boolean dVh = false;
    private int[] dVi = new int[2];
    private a dVl = new a();

    public b(String str, String str2, String str3) {
        this.cGy = str;
        this.dVf = str2;
        this.dVg = str3;
        aSR();
        aSS();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        h(view, motionEvent);
        return true;
    }

    public static boolean aSQ() {
        SwanCoreVersion avW = d.avB().avW();
        long j = avW != null ? avW.swanCoreVersion : 0L;
        long uo = com.baidu.swan.apps.swancore.b.uo("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + uo + ";curSwanVersion: " + j);
        }
        return j >= uo;
    }

    private void aSR() {
        this.dVh = !aSQ() && TextUtils.equals("canvas", this.dVg);
    }

    private void aSS() {
        AbsoluteLayout qh = ak.qh(this.cGy);
        if (qh != null) {
            qh.getLocationOnScreen(this.dVi);
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cGy) || TextUtils.isEmpty(this.dVf)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cGy + " ; viewId = " + this.dVf);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dVj = new C0499b(motionEvent.getX(), motionEvent.getY());
            this.dVk = motionEvent.getEventTime();
            this.dVl.C(motionEvent);
            view.postDelayed(this.dVl, 350L);
            aSS();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0499b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dVl);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0499b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dVk < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dVh) {
            f.aDH().a(this.cGy, gVar);
        } else {
            f.aDH().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.i(this.dVi);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cGy, this.dVf, this.dVg, aVar.aSN(), aVar.aSO());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.i(this.dVi);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cGy, this.dVf, this.dVg, aVar.aSN(), aVar.aSO());
        return gVar;
    }

    private boolean a(C0499b c0499b) {
        return this.dVj != null && this.dVj.b(c0499b) <= ((double) ah.O(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private MotionEvent dVm;
        private g dVn;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dVm = motionEvent;
            this.dVn = b.this.b(this.dVm, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dVn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0499b {
        private double x;
        private double y;

        public C0499b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0499b c0499b) {
            if (c0499b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0499b.x - this.x, 2.0d) + Math.pow(c0499b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
