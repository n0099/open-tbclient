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
    private String cib;
    private String dsF;
    private String dsG;
    private C0470b dsJ;
    private long dsK;
    private boolean dsH = false;
    private int[] dsI = new int[2];
    private a dsL = new a();

    public b(String str, String str2, String str3) {
        this.cib = str;
        this.dsF = str2;
        this.dsG = str3;
        aJD();
        aJE();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aJC() {
        SwanCoreVersion anI = d.ann().anI();
        long j = anI != null ? anI.swanCoreVersion : 0L;
        long ti = com.baidu.swan.apps.swancore.b.ti("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + ti + ";curSwanVersion: " + j);
        }
        return j >= ti;
    }

    private void aJD() {
        this.dsH = !aJC() && TextUtils.equals("canvas", this.dsG);
    }

    private void aJE() {
        AbsoluteLayout pg = ak.pg(this.cib);
        if (pg != null) {
            pg.getLocationOnScreen(this.dsI);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cib) || TextUtils.isEmpty(this.dsF)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cib + " ; viewId = " + this.dsF);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dsJ = new C0470b(motionEvent.getX(), motionEvent.getY());
            this.dsK = motionEvent.getEventTime();
            this.dsL.C(motionEvent);
            view.postDelayed(this.dsL, 350L);
            aJE();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0470b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dsL);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0470b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dsK < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dsH) {
            f.avu().a(this.cib, gVar);
        } else {
            f.avu().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dsI);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.cib, this.dsF, this.dsG, aVar.aJz(), aVar.aJA());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dsI);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.cib, this.dsF, this.dsG, aVar.aJz(), aVar.aJA());
        return gVar;
    }

    private boolean a(C0470b c0470b) {
        return this.dsJ != null && this.dsJ.b(c0470b) <= ((double) ah.J(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private MotionEvent dsM;
        private g dsN;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dsM = motionEvent;
            this.dsN = b.this.b(this.dsM, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dsN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0470b {
        private double x;
        private double y;

        public C0470b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0470b c0470b) {
            if (c0470b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0470b.x - this.x, 2.0d) + Math.pow(c0470b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
