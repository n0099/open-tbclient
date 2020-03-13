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
    private String bcj;
    private String caE;
    private String caF;
    private C0306b caI;
    private long caJ;
    private boolean caG = false;
    private int[] caH = new int[2];
    private a caK = new a();

    public b(String str, String str2, String str3) {
        this.bcj = str;
        this.caE = str2;
        this.caF = str3;
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
        this.caG = !ahK() && TextUtils.equals("canvas", this.caF);
    }

    private void ahM() {
        AbsoluteLayout iT = ai.iT(this.bcj);
        if (iT != null) {
            iT.getLocationOnScreen(this.caH);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bcj) || TextUtils.isEmpty(this.caE)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bcj + " ; viewId = " + this.caE);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.caI = new C0306b(motionEvent.getX(), motionEvent.getY());
            this.caJ = motionEvent.getEventTime();
            this.caK.o(motionEvent);
            view.postDelayed(this.caK, 350L);
            ahM();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0306b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.caK);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0306b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.caJ < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.caG) {
            com.baidu.swan.apps.y.f.WS().a(this.bcj, fVar);
        } else {
            com.baidu.swan.apps.y.f.WS().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.caH);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bcj, this.caE, this.caF, aVar.ahH(), aVar.ahI());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.caH);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bcj, this.caE, this.caF, aVar.ahH(), aVar.ahI());
        return fVar;
    }

    private boolean a(C0306b c0306b) {
        return this.caI != null && this.caI.b(c0306b) <= ((double) af.S(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent caL;
        private f caM;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.caL = motionEvent;
            this.caM = b.this.b(this.caL, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.caM);
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
