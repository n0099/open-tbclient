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
/* loaded from: classes3.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bVN;
    private C0453b dgB;
    private long dgC;
    private String dgx;
    private String dgy;
    private boolean dgz = false;
    private int[] dgA = new int[2];
    private a dgD = new a();

    public b(String str, String str2, String str3) {
        this.bVN = str;
        this.dgx = str2;
        this.dgy = str3;
        aGU();
        aGV();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aGT() {
        SwanCoreVersion akX = d.akC().akX();
        long j = akX != null ? akX.swanCoreVersion : 0L;
        long sw = com.baidu.swan.apps.swancore.b.sw("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + sw + ";curSwanVersion: " + j);
        }
        return j >= sw;
    }

    private void aGU() {
        this.dgz = !aGT() && TextUtils.equals("canvas", this.dgy);
    }

    private void aGV() {
        AbsoluteLayout ou = ak.ou(this.bVN);
        if (ou != null) {
            ou.getLocationOnScreen(this.dgA);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bVN) || TextUtils.isEmpty(this.dgx)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bVN + " ; viewId = " + this.dgx);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dgB = new C0453b(motionEvent.getX(), motionEvent.getY());
            this.dgC = motionEvent.getEventTime();
            this.dgD.C(motionEvent);
            view.postDelayed(this.dgD, 350L);
            aGV();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0453b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dgD);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0453b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dgC < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dgz) {
            f.asJ().a(this.bVN, gVar);
        } else {
            f.asJ().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dgA);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bVN, this.dgx, this.dgy, aVar.aGQ(), aVar.aGR());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dgA);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bVN, this.dgx, this.dgy, aVar.aGQ(), aVar.aGR());
        return gVar;
    }

    private boolean a(C0453b c0453b) {
        return this.dgB != null && this.dgB.b(c0453b) <= ((double) ah.H(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private MotionEvent dgE;
        private g dgF;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dgE = motionEvent;
            this.dgF = b.this.b(this.dgE, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dgF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0453b {
        private double x;
        private double y;

        public C0453b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0453b c0453b) {
            if (c0453b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0453b.x - this.x, 2.0d) + Math.pow(c0453b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
