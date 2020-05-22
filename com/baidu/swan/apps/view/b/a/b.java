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
    private String bIH;
    private String cMZ;
    private String cNa;
    private C0400b cNd;
    private long cNe;
    private boolean cNb = false;
    private int[] cNc = new int[2];
    private a cNf = new a();

    public b(String str, String str2, String str3) {
        this.bIH = str;
        this.cMZ = str2;
        this.cNa = str3;
        auD();
        auE();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean auC() {
        SwanCoreVersion abG = d.abl().abG();
        long j = abG != null ? abG.swanCoreVersion : 0L;
        long pi = com.baidu.swan.apps.swancore.b.pi("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + pi + ";curSwanVersion: " + j);
        }
        if (j < pi) {
            return false;
        }
        return true;
    }

    private void auD() {
        this.cNb = !auC() && TextUtils.equals("canvas", this.cNa);
    }

    private void auE() {
        AbsoluteLayout ls = aj.ls(this.bIH);
        if (ls != null) {
            ls.getLocationOnScreen(this.cNc);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bIH) || TextUtils.isEmpty(this.cMZ)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bIH + " ; viewId = " + this.cMZ);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.cNd = new C0400b(motionEvent.getX(), motionEvent.getY());
            this.cNe = motionEvent.getEventTime();
            this.cNf.n(motionEvent);
            view.postDelayed(this.cNf, 350L);
            auE();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0400b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.cNf);
        }
        a(m(motionEvent));
        if (actionMasked == 1 && a(new C0400b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.cNe < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.cNb) {
            f.ahV().a(this.bIH, gVar);
        } else {
            f.ahV().a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.cNc);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bIH, this.cMZ, this.cNa, aVar.auz(), aVar.auA());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g m(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.cNc);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bIH, this.cMZ, this.cNa, aVar.auz(), aVar.auA());
        return gVar;
    }

    private boolean a(C0400b c0400b) {
        return this.cNd != null && this.cNd.b(c0400b) <= ((double) ag.B(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent cNg;
        private g cNh;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(MotionEvent motionEvent) {
            this.cNg = motionEvent;
            this.cNh = b.this.b(this.cNg, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.cNh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0400b {
        private double x;
        private double y;

        public C0400b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0400b c0400b) {
            if (c0400b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0400b.x - this.x, 2.0d) + Math.pow(c0400b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
