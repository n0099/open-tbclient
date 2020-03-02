package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.n.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes11.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bci;
    private String caD;
    private String caE;
    private C0306b caH;
    private long caI;
    private boolean caF = false;
    private int[] caG = new int[2];
    private a caJ = new a();

    public b(String str, String str2, String str3) {
        this.bci = str;
        this.caD = str2;
        this.caE = str3;
        ahL();
        ahM();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean ahK() {
        SwanCoreVersion QQ = d.Qw().QQ();
        long j = QQ != null ? QQ.swanCoreVersion : 0L;
        long mp = com.baidu.swan.apps.swancore.b.mp("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + mp + ";curSwanVersion: " + j);
        }
        if (j < mp) {
            return false;
        }
        return true;
    }

    private void ahL() {
        this.caF = !ahK() && TextUtils.equals("canvas", this.caE);
    }

    private void ahM() {
        AbsoluteLayout iT = ai.iT(this.bci);
        if (iT != null) {
            iT.getLocationOnScreen(this.caG);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bci) || TextUtils.isEmpty(this.caD)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bci + " ; viewId = " + this.caD);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.caH = new C0306b(motionEvent.getX(), motionEvent.getY());
            this.caI = motionEvent.getEventTime();
            this.caJ.o(motionEvent);
            view.postDelayed(this.caJ, 350L);
            ahM();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0306b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.caJ);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0306b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.caI < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.caF) {
            com.baidu.swan.apps.y.f.WS().a(this.bci, fVar);
        } else {
            com.baidu.swan.apps.y.f.WS().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.caG);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bci, this.caD, this.caE, aVar.ahH(), aVar.ahI());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.caG);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bci, this.caD, this.caE, aVar.ahH(), aVar.ahI());
        return fVar;
    }

    private boolean a(C0306b c0306b) {
        return this.caH != null && this.caH.b(c0306b) <= ((double) af.S(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent caK;
        private f caL;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.caK = motionEvent;
            this.caL = b.this.b(this.caK, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.caL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0306b {
        private double x;
        private double y;

        public C0306b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0306b c0306b) {
            if (c0306b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0306b.x - this.x, 2.0d) + Math.pow(c0306b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
