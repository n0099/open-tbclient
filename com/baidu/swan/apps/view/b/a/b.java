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
    private String bAP;
    private C0357b cAb;
    private long cAc;
    private String czX;
    private String czY;
    private boolean czZ = false;
    private int[] cAa = new int[2];
    private a cAd = new a();

    public b(String str, String str2, String str3) {
        this.bAP = str;
        this.czX = str2;
        this.czY = str3;
        apV();
        apW();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean apU() {
        SwanCoreVersion YH = d.Yn().YH();
        long j = YH != null ? YH.swanCoreVersion : 0L;
        long nB = com.baidu.swan.apps.swancore.b.nB("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + nB + ";curSwanVersion: " + j);
        }
        if (j < nB) {
            return false;
        }
        return true;
    }

    private void apV() {
        this.czZ = !apU() && TextUtils.equals("canvas", this.czY);
    }

    private void apW() {
        AbsoluteLayout kf = ai.kf(this.bAP);
        if (kf != null) {
            kf.getLocationOnScreen(this.cAa);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.bAP) || TextUtils.isEmpty(this.czX)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.bAP + " ; viewId = " + this.czX);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.cAb = new C0357b(motionEvent.getX(), motionEvent.getY());
            this.cAc = motionEvent.getEventTime();
            this.cAd.n(motionEvent);
            view.postDelayed(this.cAd, 350L);
            apW();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0357b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.cAd);
        }
        a(m(motionEvent));
        if (actionMasked == 1 && a(new C0357b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.cAc < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.czZ) {
            com.baidu.swan.apps.y.f.aeJ().a(this.bAP, fVar);
        } else {
            com.baidu.swan.apps.y.f.aeJ().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.cAa);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bAP, this.czX, this.czY, aVar.apR(), aVar.apS());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f m(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.cAa);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.bAP, this.czX, this.czY, aVar.apR(), aVar.apS());
        return fVar;
    }

    private boolean a(C0357b c0357b) {
        return this.cAb != null && this.cAb.b(c0357b) <= ((double) af.C(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private MotionEvent cAe;
        private f cAf;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(MotionEvent motionEvent) {
            this.cAe = motionEvent;
            this.cAf = b.this.b(this.cAe, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.cAf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0357b {
        private double x;
        private double y;

        public C0357b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0357b c0357b) {
            if (c0357b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0357b.x - this.x, 2.0d) + Math.pow(c0357b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
