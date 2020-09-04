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
/* loaded from: classes8.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTN;
    private C0458b deB;
    private long deC;
    private String dex;
    private String dey;
    private boolean dez = false;
    private int[] deA = new int[2];
    private a deD = new a();

    public b(String str, String str2, String str3) {
        this.bTN = str;
        this.dex = str2;
        this.dey = str3;
        aGk();
        aGl();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aGj() {
        SwanCoreVersion akn = d.ajS().akn();
        long j = akn != null ? akn.swanCoreVersion : 0L;
        long sc = com.baidu.swan.apps.swancore.b.sc("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + sc + ";curSwanVersion: " + j);
        }
        return j >= sc;
    }

    private void aGk() {
        this.dez = !aGj() && TextUtils.equals("canvas", this.dey);
    }

    private void aGl() {
        AbsoluteLayout nZ = ak.nZ(this.bTN);
        if (nZ != null) {
            nZ.getLocationOnScreen(this.deA);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bTN) || TextUtils.isEmpty(this.dex)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bTN + " ; viewId = " + this.dex);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.deB = new C0458b(motionEvent.getX(), motionEvent.getY());
            this.deC = motionEvent.getEventTime();
            this.deD.C(motionEvent);
            view.postDelayed(this.deD, 350L);
            aGl();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0458b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.deD);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0458b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.deC < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dez) {
            f.arY().a(this.bTN, gVar);
        } else {
            f.arY().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.deA);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bTN, this.dex, this.dey, aVar.aGg(), aVar.aGh());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.deA);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bTN, this.dex, this.dey, aVar.aGg(), aVar.aGh());
        return gVar;
    }

    private boolean a(C0458b c0458b) {
        return this.deB != null && this.deB.b(c0458b) <= ((double) ah.H(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private MotionEvent deE;
        private g deF;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.deE = motionEvent;
            this.deF = b.this.b(this.deE, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.deF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0458b {
        private double x;
        private double y;

        public C0458b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0458b c0458b) {
            if (c0458b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0458b.x - this.x, 2.0d) + Math.pow(c0458b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
