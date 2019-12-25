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
/* loaded from: classes9.dex */
public class b implements View.OnTouchListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aXf;
    private String bWm;
    private String bWn;
    private C0294b bWq;
    private long bWr;
    private boolean bWo = false;
    private int[] bWp = new int[2];
    private a bWs = new a();

    public b(String str, String str2, String str3) {
        this.aXf = str;
        this.bWm = str2;
        this.bWn = str3;
        afc();
        afd();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(view, motionEvent);
        return true;
    }

    public static boolean afb() {
        SwanCoreVersion Oe = d.NK().Oe();
        long j = Oe != null ? Oe.swanCoreVersion : 0L;
        long lX = com.baidu.swan.apps.swancore.b.lX("1.12.0");
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + lX + ";curSwanVersion: " + j);
        }
        if (j < lX) {
            return false;
        }
        return true;
    }

    private void afc() {
        this.bWo = !afb() && TextUtils.equals("canvas", this.bWn);
    }

    private void afd() {
        AbsoluteLayout iB = ai.iB(this.aXf);
        if (iB != null) {
            iB.getLocationOnScreen(this.bWp);
        }
    }

    private void a(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || TextUtils.isEmpty(this.aXf) || TextUtils.isEmpty(this.bWm)) {
            c.e("SwanAppTouchListener", "params is null, slaveId = " + this.aXf + " ; viewId = " + this.bWm);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
            this.bWq = new C0294b(motionEvent.getX(), motionEvent.getY());
            this.bWr = motionEvent.getEventTime();
            this.bWs.o(motionEvent);
            view.postDelayed(this.bWs, 350L);
            afd();
        } else if (actionMasked == 1 || actionMasked == 3 || !a(new C0294b(motionEvent.getX(), motionEvent.getY()))) {
            view.removeCallbacks(this.bWs);
        }
        a(n(motionEvent));
        if (actionMasked == 1 && a(new C0294b(motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.bWr < 350) {
            a(b(motionEvent, "tap"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        if (DEBUG) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + fVar.mData);
        }
        if (!this.bWo) {
            com.baidu.swan.apps.y.f.Uf().a(this.aXf, fVar);
        } else {
            com.baidu.swan.apps.y.f.Uf().a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public f b(MotionEvent motionEvent, String str) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent, str);
        aVar.g(this.bWp);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.aXf, this.bWm, this.bWn, aVar.aeY(), aVar.aeZ());
        return fVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    private f n(MotionEvent motionEvent) {
        com.baidu.swan.apps.view.b.a.a aVar = new com.baidu.swan.apps.view.b.a.a(motionEvent);
        aVar.g(this.bWp);
        f fVar = new f();
        fVar.mData = com.baidu.swan.apps.view.b.b.a.c(this.aXf, this.bWm, this.bWn, aVar.aeY(), aVar.aeZ());
        return fVar;
    }

    private boolean a(C0294b c0294b) {
        return this.bWq != null && this.bWq.b(c0294b) <= ((double) af.T(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private MotionEvent bWt;
        private f bWu;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(MotionEvent motionEvent) {
            this.bWt = motionEvent;
            this.bWu = b.this.b(this.bWt, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.bWu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0294b {
        private double x;
        private double y;

        public C0294b(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public double b(C0294b c0294b) {
            if (c0294b == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(c0294b.x - this.x, 2.0d) + Math.pow(c0294b.y - this.y, 2.0d);
            if (pow > 0.0d) {
                return Math.sqrt(pow);
            }
            return 0.0d;
        }
    }
}
