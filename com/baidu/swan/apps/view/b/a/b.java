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
    private String cqC;
    private String dBd;
    private String dBe;
    private C0484b dBh;
    private long dBi;
    private boolean dBf = false;
    private int[] dBg = new int[2];
    private a dBj = new a();

    public b(String str, String str2, String str3) {
        this.cqC = str;
        this.dBd = str2;
        this.dBe = str3;
        aLx();
        aLy();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean aLw() {
        SwanCoreVersion apD = d.aph().apD();
        long j = apD != null ? apD.swanCoreVersion : 0L;
        long tB = com.baidu.swan.apps.swancore.b.tB("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + tB + ";curSwanVersion: " + j);
        }
        return j >= tB;
    }

    private void aLx() {
        this.dBf = !aLw() && TextUtils.equals("canvas", this.dBe);
    }

    private void aLy() {
        AbsoluteLayout pz = ak.pz(this.cqC);
        if (pz != null) {
            pz.getLocationOnScreen(this.dBg);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.cqC) || TextUtils.isEmpty(this.dBd)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.cqC + " ; viewId = " + this.dBd);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.dBh = new C0484b(motionEvent.getX(), motionEvent.getY());
            this.dBi = motionEvent.getEventTime();
            this.dBj.C(motionEvent);
            view.postDelayed(this.dBj, 350L);
            aLy();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0484b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.dBj);
        }
        a(B(motionEvent));
        if (actionMasked == 1 && a(new C0484b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.dBi < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.mData);
        }
        if (!this.dBf) {
            f.axo().a(this.cqC, gVar);
        } else {
            f.axo().b(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public g b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.h(this.dBg);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.cqC, this.dBd, this.dBe, aVar.aLt(), aVar.aLu());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private g B(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.h(this.dBg);
        g gVar = new g();
        gVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.cqC, this.dBd, this.dBe, aVar.aLt(), aVar.aLu());
        return gVar;
    }

    private boolean a(C0484b c0484b) {
        return this.dBh != null && this.dBh.b(c0484b) <= ((double) ah.L(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private MotionEvent dBk;
        private g dBl;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(MotionEvent motionEvent) {
            this.dBk = motionEvent;
            this.dBl = b.this.b(this.dBk, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.dBl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0484b {
        private double x;
        private double y;

        public C0484b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0484b c0484b) {
            if (c0484b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0484b.x - this.x, 2.0d) + Math.pow(c0484b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
