package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bOl;
    private String cVp;
    private String cVq;
    private C0412b cVt;
    private long cVu;
    private boolean cVr = false;
    private int[] cVs = new int[2];
    private a cVv = new a();

    public b(String str, String str2, String str3) {
        this.bOl = str;
        this.cVp = str2;
        this.cVq = str3;
        ayc();
        ayd();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean ayb() {
        SwanCoreVersion adQ = d.adw().adQ();
        long j = adQ != null ? adQ.swanCoreVersion : 0L;
        long qb = com.baidu.swan.apps.swancore.b.qb("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + qb + ";curSwanVersion: " + j);
        }
        return j >= qb;
    }

    private void ayc() {
        this.cVr = !ayb() && TextUtils.equals("canvas", this.cVq);
    }

    private void ayd() {
        AbsoluteLayout mb = al.mb(this.bOl);
        if (mb != null) {
            mb.getLocationOnScreen(this.cVs);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bOl) || TextUtils.isEmpty(this.cVp)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bOl + " ; viewId = " + this.cVp);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.cVt = new C0412b(motionEvent.getX(), motionEvent.getY());
            this.cVu = motionEvent.getEventTime();
            this.cVv.n(motionEvent);
            view.postDelayed(this.cVv, 350L);
            ayd();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0412b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.cVv);
        }
        a(m(motionEvent));
        if (actionMasked == 1 && a(new C0412b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.cVu < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.cVr) {
            f.akr().a(this.bOl, gVar);
        } else {
            f.akr().a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.cVs);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bOl, this.cVp, this.cVq, aVar.axY(), aVar.axZ());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g m(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.cVs);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bOl, this.cVp, this.cVq, aVar.axY(), aVar.axZ());
        return gVar;
    }

    private boolean a(C0412b c0412b) {
        return this.cVt != null && this.cVt.b(c0412b) <= ((double) ai.D(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private MotionEvent cVw;
        private g cVx;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(MotionEvent motionEvent) {
            this.cVw = motionEvent;
            this.cVx = b.this.b(this.cVw, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.cVx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0412b {
        private double x;
        private double y;

        public C0412b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0412b c0412b) {
            if (c0412b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0412b.x - this.x, 2.0d) + Math.pow(c0412b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
