package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private static final boolean DEBUG = g.DEBUG;
    private static volatile m bps;
    private com.baidu.swan.ubc.d boY;
    private ExecutorService bpt;
    private ExecutorService bpu;
    private com.baidu.swan.ubc.c bpv;
    private int bpw;
    private boolean bpx = false;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bpw;
        mVar.bpw = i + 1;
        return i;
    }

    private m() {
        init(r.getContext());
    }

    public static m Tk() {
        if (bps == null) {
            synchronized (m.class) {
                if (bps == null) {
                    bps = new m();
                }
            }
        }
        return bps;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpw = com.baidu.swan.a.a.Ne().getInt("ubc_key_flow_handle", 0);
            if (this.bpw > 1073741823) {
                this.bpw -= 1073741823;
            } else {
                this.bpw = 1073741823 + this.bpw;
            }
            this.bpt = Executors.newSingleThreadExecutor();
            this.bpt.execute(new f(this, null));
            this.bpu = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, jSONObject, i);
            if (this.boY != null && this.boY.jM(str)) {
                aVar.cV(true);
            }
            this.bpt.execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, str2, i);
            if (this.boY != null && this.boY.jM(str)) {
                aVar.cV(true);
            }
            this.bpt.execute(aVar);
        }
    }

    boolean P(String str, int i) {
        if (this.boY == null || this.boY.O(str, i)) {
            if ((i & 16) == 0 || r.Ts().fu(str)) {
                if (this.boY != null && this.boY.jK(str) > 0) {
                    if (new Random().nextInt(100) >= this.boY.jK(str)) {
                        return true;
                    }
                }
                return this.boY != null && this.boY.jL(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpt.execute(new a(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpt.execute(new a(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow i(String str, String str2, int i) {
        Flow Q;
        Q = Q(str, i);
        if (Q != null && Q.getValid()) {
            c cVar = new c(Q, str2);
            if (this.boY != null && this.boY.jM(str)) {
                cVar.cV(true);
            }
            this.bpt.execute(cVar);
        }
        return Q;
    }

    Flow Q(String str, int i) {
        Flow flow = new Flow(str, this.bpw, i);
        if (this.boY != null && !this.boY.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !r.Ts().fu(str)) {
            flow.setValid(false);
        } else {
            if (this.boY != null && this.boY.jK(str) > 0) {
                int jK = this.boY.jK(str);
                int nextInt = new Random().nextInt(100);
                if (DEBUG) {
                    Log.d("UBCBehaviorProcessor", "ubc id " + str + " random value " + nextInt + " rate = " + jK);
                }
                if (nextInt >= jK) {
                    flow.setValid(false);
                }
            }
            if (this.boY != null && this.boY.jL(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bpt.execute(new e(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.bpt.execute(new d(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        this.bpt.execute(new b(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.ubc.m$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ m bpy;

        @Override // java.lang.Runnable
        public void run() {
            if (this.bpy.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            this.bpy.bpv.SS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        q.u(jSONArray);
        if (DEBUG) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("OPEN_STAT", jSONArray.toString());
        }
        this.bpu.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bpv == null) {
                    if (m.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                m.this.bpv.b(jSONArray, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final JSONArray jSONArray) {
        q.u(jSONArray);
        if (DEBUG) {
            Log.d("UBCBehaviorProcessor", "uploadFileData");
        }
        this.bpu.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bpv == null) {
                    if (m.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFileData#ubc init not finish");
                        return;
                    }
                    return;
                }
                m.this.bpv.t(jSONArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpt.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bpv == null) {
                    if (m.DEBUG) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (z) {
                    m.this.bpv.jF(str);
                } else {
                    m.this.bpv.jG(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(m mVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.boY = com.baidu.swan.ubc.d.SW();
            m.this.bpv = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bpv.SV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private i bpB;

        a(String str, String str2, int i) {
            this.bpB = new i(str, str2, i);
        }

        a(String str, JSONObject jSONObject, int i) {
            this.bpB = new i(str, jSONObject, i);
        }

        a(String str, String str2, int i, String str3, int i2) {
            this.bpB = new i(str, str2, i, str3, i2);
        }

        a(String str, String str2, int i, String str3, long j, int i2) {
            this.bpB = new i(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.bpB != null) {
                this.bpB.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.bpB.Th();
            if (!TextUtils.isEmpty(m.this.boY.jJ(this.bpB.getId()))) {
                this.bpB.setCategory(m.this.boY.jJ(this.bpB.getId()));
            }
            if ((this.bpB.getOption() & 8) != 0) {
                m.this.bpv.b(this.bpB);
            } else {
                m.this.bpv.a(this.bpB);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private j bpC;

        c(Flow flow, String str) {
            this.bpC = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bpC.X(flow.getStartTime());
            this.bpC.jO("1");
            m.d(m.this);
        }

        public void cV(boolean z) {
            if (this.bpC != null) {
                this.bpC.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.bpC.Th();
            if (!TextUtils.isEmpty(m.this.boY.jJ(this.bpC.getId()))) {
                this.bpC.setCategory(m.this.boY.jJ(this.bpC.getId()));
            }
            m.this.bpv.b(this.bpC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aDt;
        private int bpm;
        private String mValue;

        e(String str, int i, String str2) {
            this.aDt = str;
            this.bpm = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            m.this.bpv.c(this.aDt, this.bpm, this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private String aDt;
        private long aEo = System.currentTimeMillis();
        private int bpm;
        private JSONArray bpr;

        d(String str, int i, JSONArray jSONArray) {
            this.aDt = str;
            this.bpm = i;
            this.bpr = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            m.this.bpv.a(this.aDt, this.bpm, this.aEo, this.bpr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private String aDt;
        private int bpm;

        b(String str, int i) {
            this.aDt = str;
            this.bpm = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bpv == null) {
                if (m.DEBUG) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            m.this.bpv.y(this.aDt, this.bpm);
        }
    }
}
