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
/* loaded from: classes8.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cFI;
    private String dUa;
    private String dUb;
    private C0485b dUe;
    private long dUf;
    private boolean dUc = false;
    private int[] dUd = new int[2];
    private a dUg = new a();

    public b(String str, String str2, String str3) {
        this.cFI = str;
        this.dUa = str2;
        this.dUb = str3;
        aPt();
        aPu();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        h(view, motionEvent);
        return true;
    }

    public static boolean aPs() {
        SwanCoreVersion asD = d.ash().asD();
        long j = asD != null ? asD.swanCoreVersion : 0L;
        long tD = com.baidu.swan.apps.swancore.b.tD("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + tD + ";curSwanVersion: " + j);
        }
        return j >= tD;
    }

    private void aPt() {
        this.dUc = !aPs() && TextUtils.equals("canvas", this.dUb);
    }

    private void aPu() {
        AbsoluteLayout pv = ak.pv(this.cFI);
        if (pv != null) {
            pv.getLocationOnScreen(this.dUd);
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cFI) || TextUtils.isEmpty(this.dUa)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cFI + " ; viewId = " + this.dUa);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dUe = new C0485b(motionEvent.getX(), motionEvent.getY());
            this.dUf = motionEvent.getEventTime();
            this.dUg.C(motionEvent);
            view.postDelayed(this.dUg, 350L);
            aPu();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0485b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dUg);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0485b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dUf < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dUc) {
            f.aAo().a(this.cFI, gVar);
        } else {
            f.aAo().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.i(this.dUd);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cFI, this.dUa, this.dUb, aVar.aPp(), aVar.aPq());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.i(this.dUd);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cFI, this.dUa, this.dUb, aVar.aPp(), aVar.aPq());
        return gVar;
    }

    private boolean a(C0485b c0485b) {
        return this.dUe != null && this.dUe.b(c0485b) <= ((double) ah.T(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private MotionEvent dUh;
        private g dUi;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dUh = motionEvent;
            this.dUi = b.this.b(this.dUh, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dUi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0485b {
        private double x;
        private double y;

        public C0485b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0485b c0485b) {
            if (c0485b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0485b.x - this.x, 2.0d) + Math.pow(c0485b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
