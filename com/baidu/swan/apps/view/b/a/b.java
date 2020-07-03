package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bNv;
    private String cRJ;
    private String cRK;
    private C0406b cRN;
    private long cRO;
    private boolean cRL = false;
    private int[] cRM = new int[2];
    private a cRP = new a();

    public b(String str, String str2, String str3) {
        this.bNv = str;
        this.cRJ = str2;
        this.cRK = str3;
        avJ();
        avK();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean avI() {
        SwanCoreVersion acM = d.acr().acM();
        long j = acM != null ? acM.swanCoreVersion : 0L;
        long pq = com.baidu.swan.apps.swancore.b.pq("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + pq + ";curSwanVersion: " + j);
        }
        if (j < pq) {
            return false;
        }
        return true;
    }

    private void avJ() {
        this.cRL = !avI() && TextUtils.equals("canvas", this.cRK);
    }

    private void avK() {
        AbsoluteLayout lA = aj.lA(this.bNv);
        if (lA != null) {
            lA.getLocationOnScreen(this.cRM);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bNv) || TextUtils.isEmpty(this.cRJ)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bNv + " ; viewId = " + this.cRJ);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.cRN = new C0406b(motionEvent.getX(), motionEvent.getY());
            this.cRO = motionEvent.getEventTime();
            this.cRP.n(motionEvent);
            view.postDelayed(this.cRP, 350L);
            avK();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0406b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.cRP);
        }
        a(m(motionEvent));
        if (actionMasked == 1 && a(new C0406b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.cRO < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.cRL) {
            f.ajb().a(this.bNv, gVar);
        } else {
            f.ajb().a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.cRM);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bNv, this.cRJ, this.cRK, aVar.avF(), aVar.avG());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g m(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.cRM);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bNv, this.cRJ, this.cRK, aVar.avF(), aVar.avG());
        return gVar;
    }

    private boolean a(C0406b c0406b) {
        return this.cRN != null && this.cRN.b(c0406b) <= ((double) ag.D(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent cRQ;
        private g cRR;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(MotionEvent motionEvent) {
            this.cRQ = motionEvent;
            this.cRR = b.this.b(this.cRQ, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.cRR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0406b {
        private double x;
        private double y;

        public C0406b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0406b c0406b) {
            if (c0406b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0406b.x - this.x, 2.0d) + Math.pow(c0406b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
