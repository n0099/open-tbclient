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
/* loaded from: classes25.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cBI;
    private String dMm;
    private String dMn;
    private C0506b dMq;
    private long dMr;
    private boolean dMo = false;
    private int[] dMp = new int[2];
    private a dMs = new a();

    public b(String str, String str2, String str3) {
        this.cBI = str;
        this.dMm = str2;
        this.dMn = str3;
        aQv();
        aQw();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aQu() {
        SwanCoreVersion auD = d.aui().auD();
        long j = auD != null ? auD.swanCoreVersion : 0L;
        long ur = com.baidu.swan.apps.swancore.b.ur("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + ur + ";curSwanVersion: " + j);
        }
        return j >= ur;
    }

    private void aQv() {
        this.dMo = !aQu() && TextUtils.equals("canvas", this.dMn);
    }

    private void aQw() {
        AbsoluteLayout qo = ak.qo(this.cBI);
        if (qo != null) {
            qo.getLocationOnScreen(this.dMp);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cBI) || TextUtils.isEmpty(this.dMm)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cBI + " ; viewId = " + this.dMm);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dMq = new C0506b(motionEvent.getX(), motionEvent.getY());
            this.dMr = motionEvent.getEventTime();
            this.dMs.C(motionEvent);
            view.postDelayed(this.dMs, 350L);
            aQw();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0506b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dMs);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0506b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dMr < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dMo) {
            f.aCp().a(this.cBI, gVar);
        } else {
            f.aCp().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dMp);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cBI, this.dMm, this.dMn, aVar.aQr(), aVar.aQs());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dMp);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cBI, this.dMm, this.dMn, aVar.aQr(), aVar.aQs());
        return gVar;
    }

    private boolean a(C0506b c0506b) {
        return this.dMq != null && this.dMq.b(c0506b) <= ((double) ah.M(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a implements Runnable {
        private MotionEvent dMt;
        private g dMu;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dMt = motionEvent;
            this.dMu = b.this.b(this.dMt, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dMu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0506b {
        private double x;
        private double y;

        public C0506b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0506b c0506b) {
            if (c0506b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0506b.x - this.x, 2.0d) + Math.pow(c0506b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
