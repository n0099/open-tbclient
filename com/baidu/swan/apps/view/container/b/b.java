package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.m.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aBB;
    private String bcQ;
    private String bcR;
    private C0203b bcU;
    private long bcV;
    private boolean bcS = false;
    private int[] bcT = new int[2];
    private a bcW = new a();

    public b(String str, String str2, String str3) {
        this.aBB = str;
        this.bcQ = str2;
        this.bcR = str3;
        Qt();
        Qu();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean Qs() {
        SwanCoreVersion Cm = c.BU().Cm();
        long j = Cm != null ? Cm.aXe : 0L;
        long hQ = com.baidu.swan.apps.swancore.b.hQ("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + hQ + ";curSwanVersion: " + j);
        }
        if (j < hQ) {
            return false;
        }
        return true;
    }

    private void Qt() {
        this.bcS = !Qs() && TextUtils.equals("canvas", this.bcR);
    }

    private void Qu() {
        AbsoluteLayout fg = ac.fg(this.aBB);
        if (fg != null) {
            fg.getLocationOnScreen(this.bcT);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aBB) || TextUtils.isEmpty(this.bcQ)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aBB + " ; viewId = " + this.bcQ);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bcU = new C0203b(motionEvent.getX(), motionEvent.getY());
            this.bcV = motionEvent.getEventTime();
            this.bcW.s(motionEvent);
            view.postDelayed(this.bcW, 350L);
            Qu();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0203b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bcW);
        }
        a(r(motionEvent));
        if (actionMasked == 1 && a(new C0203b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bcV < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bcS) {
            e.GJ().a(this.aBB, fVar);
        } else {
            e.GJ().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.g(this.bcT);
        f fVar = new f();
        fVar.mData = d.c(this.aBB, this.bcQ, this.bcR, aVar.Qp(), aVar.Qq());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f r(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.g(this.bcT);
        f fVar = new f();
        fVar.mData = d.c(this.aBB, this.bcQ, this.bcR, aVar.Qp(), aVar.Qq());
        return fVar;
    }

    private boolean a(C0203b c0203b) {
        return this.bcU != null && this.bcU.b(c0203b) <= ((double) z.ad(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent bcX;
        private f bcY;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(MotionEvent motionEvent) {
            this.bcX = motionEvent;
            this.bcY = b.this.b(this.bcX, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bcY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0203b {
        private double x;
        private double y;

        public C0203b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0203b c0203b) {
            if (c0203b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0203b.x - this.x, 2.0d) + Math.pow(c0203b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
