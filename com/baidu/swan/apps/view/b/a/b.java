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
    private String bTJ;
    private String det;
    private String deu;
    private C0458b dex;
    private long dey;
    private boolean dev = false;
    private int[] dew = new int[2];
    private a dez = new a();

    public b(String str, String str2, String str3) {
        this.bTJ = str;
        this.det = str2;
        this.deu = str3;
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
        long sb = com.baidu.swan.apps.swancore.b.sb("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + sb + ";curSwanVersion: " + j);
        }
        return j >= sb;
    }

    private void aGk() {
        this.dev = !aGj() && TextUtils.equals("canvas", this.deu);
    }

    private void aGl() {
        AbsoluteLayout nY = ak.nY(this.bTJ);
        if (nY != null) {
            nY.getLocationOnScreen(this.dew);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bTJ) || TextUtils.isEmpty(this.det)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bTJ + " ; viewId = " + this.det);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dex = new C0458b(motionEvent.getX(), motionEvent.getY());
            this.dey = motionEvent.getEventTime();
            this.dez.C(motionEvent);
            view.postDelayed(this.dez, 350L);
            aGl();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0458b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dez);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0458b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dey < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dev) {
            f.arY().a(this.bTJ, gVar);
        } else {
            f.arY().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dew);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bTJ, this.det, this.deu, aVar.aGg(), aVar.aGh());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dew);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bTJ, this.det, this.deu, aVar.aGg(), aVar.aGh());
        return gVar;
    }

    private boolean a(C0458b c0458b) {
        return this.dex != null && this.dex.b(c0458b) <= ((double) ah.H(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        private MotionEvent deA;
        private g deB;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.deA = motionEvent;
            this.deB = b.this.b(this.deA, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.deB);
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
