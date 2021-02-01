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
    private String cEi;
    private String dSA;
    private C0479b dSD;
    private long dSE;
    private String dSz;
    private boolean dSB = false;
    private int[] dSC = new int[2];
    private a dSF = new a();

    public b(String str, String str2, String str3) {
        this.cEi = str;
        this.dSz = str2;
        this.dSA = str3;
        aPq();
        aPr();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        h(view, motionEvent);
        return true;
    }

    public static boolean aPp() {
        SwanCoreVersion asA = d.ase().asA();
        long j = asA != null ? asA.swanCoreVersion : 0L;
        long tw = com.baidu.swan.apps.swancore.b.tw("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + tw + ";curSwanVersion: " + j);
        }
        return j >= tw;
    }

    private void aPq() {
        this.dSB = !aPp() && TextUtils.equals("canvas", this.dSA);
    }

    private void aPr() {
        AbsoluteLayout po = ak.po(this.cEi);
        if (po != null) {
            po.getLocationOnScreen(this.dSC);
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cEi) || TextUtils.isEmpty(this.dSz)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cEi + " ; viewId = " + this.dSz);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dSD = new C0479b(motionEvent.getX(), motionEvent.getY());
            this.dSE = motionEvent.getEventTime();
            this.dSF.C(motionEvent);
            view.postDelayed(this.dSF, 350L);
            aPr();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0479b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dSF);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0479b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dSE < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dSB) {
            f.aAl().a(this.cEi, gVar);
        } else {
            f.aAl().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.i(this.dSC);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cEi, this.dSz, this.dSA, aVar.aPm(), aVar.aPn());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.i(this.dSC);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cEi, this.dSz, this.dSA, aVar.aPm(), aVar.aPn());
        return gVar;
    }

    private boolean a(C0479b c0479b) {
        return this.dSD != null && this.dSD.b(c0479b) <= ((double) ah.P(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private MotionEvent dSG;
        private g dSH;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dSG = motionEvent;
            this.dSH = b.this.b(this.dSG, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dSH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0479b {
        private double x;
        private double y;

        public C0479b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0479b c0479b) {
            if (c0479b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0479b.x - this.x, 2.0d) + Math.pow(c0479b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
