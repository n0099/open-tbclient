package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cwA;
    private String dGV;
    private String dGW;
    private C0496b dGZ;
    private long dHa;
    private boolean dGX = false;
    private int[] dGY = new int[2];
    private a dHb = new a();

    public b(String str, String str2, String str3) {
        this.cwA = str;
        this.dGV = str2;
        this.dGW = str3;
        aNX();
        aNY();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aNW() {
        SwanCoreVersion asd = d.arI().asd();
        long j = asd != null ? asd.swanCoreVersion : 0L;
        long tP = com.baidu.swan.apps.swancore.b.tP("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + tP + ";curSwanVersion: " + j);
        }
        return j >= tP;
    }

    private void aNX() {
        this.dGX = !aNW() && TextUtils.equals("canvas", this.dGW);
    }

    private void aNY() {
        AbsoluteLayout pN = ak.pN(this.cwA);
        if (pN != null) {
            pN.getLocationOnScreen(this.dGY);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cwA) || TextUtils.isEmpty(this.dGV)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cwA + " ; viewId = " + this.dGV);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dGZ = new C0496b(motionEvent.getX(), motionEvent.getY());
            this.dHa = motionEvent.getEventTime();
            this.dHb.C(motionEvent);
            view.postDelayed(this.dHb, 350L);
            aNY();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0496b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dHb);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0496b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dHa < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dGX) {
            f.azO().a(this.cwA, gVar);
        } else {
            f.azO().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dGY);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.d(this.cwA, this.dGV, this.dGW, aVar.aNT(), aVar.aNU());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dGY);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.d(this.cwA, this.dGV, this.dGW, aVar.aNT(), aVar.aNU());
        return gVar;
    }

    private boolean a(C0496b c0496b) {
        return this.dGZ != null && this.dGZ.b(c0496b) <= ((double) ah.N(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private MotionEvent dHc;
        private g dHd;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dHc = motionEvent;
            this.dHd = b.this.b(this.dHc, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dHd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0496b {
        private double x;
        private double y;

        public C0496b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0496b c0496b) {
            if (c0496b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0496b.x - this.x, 2.0d) + Math.pow(c0496b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
