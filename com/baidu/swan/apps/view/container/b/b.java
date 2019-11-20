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
    private String aUx;
    private String buX;
    private String buY;
    private C0235b bvb;
    private long bvc;
    private boolean buZ = false;
    private int[] bva = new int[2];
    private a bvd = new a();

    public b(String str, String str2, String str3) {
        this.aUx = str;
        this.buX = str2;
        this.buY = str3;
        Vh();
        Vi();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean Vg() {
        SwanCoreVersion Hh = c.GP().Hh();
        long j = Hh != null ? Hh.bpQ : 0L;
        long iu = com.baidu.swan.apps.swancore.b.iu("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + iu + ";curSwanVersion: " + j);
        }
        if (j < iu) {
            return false;
        }
        return true;
    }

    private void Vh() {
        this.buZ = !Vg() && TextUtils.equals("canvas", this.buY);
    }

    private void Vi() {
        AbsoluteLayout fN = ac.fN(this.aUx);
        if (fN != null) {
            fN.getLocationOnScreen(this.bva);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aUx) || TextUtils.isEmpty(this.buX)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aUx + " ; viewId = " + this.buX);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bvb = new C0235b(motionEvent.getX(), motionEvent.getY());
            this.bvc = motionEvent.getEventTime();
            this.bvd.o(motionEvent);
            view.postDelayed(this.bvd, 350L);
            Vi();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0235b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bvd);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0235b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bvc < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.buZ) {
            e.LE().a(this.aUx, fVar);
        } else {
            e.LE().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.f(this.bva);
        f fVar = new f();
        fVar.mData = d.c(this.aUx, this.buX, this.buY, aVar.Vd(), aVar.Ve());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.f(this.bva);
        f fVar = new f();
        fVar.mData = d.c(this.aUx, this.buX, this.buY, aVar.Vd(), aVar.Ve());
        return fVar;
    }

    private boolean a(C0235b c0235b) {
        return this.bvb != null && this.bvb.b(c0235b) <= ((double) z.S(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent bve;
        private f bvf;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.bve = motionEvent;
            this.bvf = b.this.b(this.bve, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bvf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0235b {
        private double x;
        private double y;

        public C0235b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0235b c0235b) {
            if (c0235b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0235b.x - this.x, 2.0d) + Math.pow(c0235b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
