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
    private String cBM;
    private String dQt;
    private String dQu;
    private C0482b dQx;
    private long dQy;
    private boolean dQv = false;
    private int[] dQw = new int[2];
    private a dQz = new a();

    public b(String str, String str2, String str3) {
        this.cBM = str;
        this.dQt = str2;
        this.dQu = str3;
        aOX();
        aOY();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        h(view, motionEvent);
        return true;
    }

    public static boolean aOW() {
        SwanCoreVersion asb = d.arG().asb();
        long j = asb != null ? asb.swanCoreVersion : 0L;
        long td = com.baidu.swan.apps.swancore.b.td("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + td + ";curSwanVersion: " + j);
        }
        return j >= td;
    }

    private void aOX() {
        this.dQv = !aOW() && TextUtils.equals("canvas", this.dQu);
    }

    private void aOY() {
        AbsoluteLayout oW = ak.oW(this.cBM);
        if (oW != null) {
            oW.getLocationOnScreen(this.dQw);
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cBM) || TextUtils.isEmpty(this.dQt)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cBM + " ; viewId = " + this.dQt);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dQx = new C0482b(motionEvent.getX(), motionEvent.getY());
            this.dQy = motionEvent.getEventTime();
            this.dQz.C(motionEvent);
            view.postDelayed(this.dQz, 350L);
            aOY();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0482b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dQz);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0482b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dQy < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dQv) {
            f.azN().a(this.cBM, gVar);
        } else {
            f.azN().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.i(this.dQw);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cBM, this.dQt, this.dQu, aVar.aOT(), aVar.aOU());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.i(this.dQw);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.e(this.cBM, this.dQt, this.dQu, aVar.aOT(), aVar.aOU());
        return gVar;
    }

    private boolean a(C0482b c0482b) {
        return this.dQx != null && this.dQx.b(c0482b) <= ((double) ah.O(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private MotionEvent dQA;
        private g dQB;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dQA = motionEvent;
            this.dQB = b.this.b(this.dQA, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dQB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0482b {
        private double x;
        private double y;

        public C0482b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0482b c0482b) {
            if (c0482b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0482b.x - this.x, 2.0d) + Math.pow(c0482b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
