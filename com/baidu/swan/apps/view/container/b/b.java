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
    private String aUP;
    private String bvO;
    private String bvP;
    private C0235b bvS;
    private long bvT;
    private boolean bvQ = false;
    private int[] bvR = new int[2];
    private a bvU = new a();

    public b(String str, String str2, String str3) {
        this.aUP = str;
        this.bvO = str2;
        this.bvP = str3;
        Vj();
        Vk();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean Vi() {
        SwanCoreVersion Hg = c.GO().Hg();
        long j = Hg != null ? Hg.bqi : 0L;
        long iu = com.baidu.swan.apps.swancore.b.iu("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + iu + ";curSwanVersion: " + j);
        }
        if (j < iu) {
            return false;
        }
        return true;
    }

    private void Vj() {
        this.bvQ = !Vi() && TextUtils.equals("canvas", this.bvP);
    }

    private void Vk() {
        AbsoluteLayout fN = ac.fN(this.aUP);
        if (fN != null) {
            fN.getLocationOnScreen(this.bvR);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aUP) || TextUtils.isEmpty(this.bvO)) {
            com.baidu.swan.apps.console.c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aUP + " ; viewId = " + this.bvO);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bvS = new C0235b(motionEvent.getX(), motionEvent.getY());
            this.bvT = motionEvent.getEventTime();
            this.bvU.o(motionEvent);
            view.postDelayed(this.bvU, 350L);
            Vk();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0235b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bvU);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0235b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bvT < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bvQ) {
            e.LD().a(this.aUP, fVar);
        } else {
            e.LD().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent, str);
        aVar.f(this.bvR);
        f fVar = new f();
        fVar.mData = d.c(this.aUP, this.bvO, this.bvP, aVar.Vf(), aVar.Vg());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.container.b.a aVar = new com.baidu.swan.apps.view.container.b.a(motionEvent);
        aVar.f(this.bvR);
        f fVar = new f();
        fVar.mData = d.c(this.aUP, this.bvO, this.bvP, aVar.Vf(), aVar.Vg());
        return fVar;
    }

    private boolean a(C0235b c0235b) {
        return this.bvS != null && this.bvS.b(c0235b) <= ((double) z.S(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private MotionEvent bvV;
        private f bvW;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.bvV = motionEvent;
            this.bvW = b.this.b(this.bvV, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bvW);
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
