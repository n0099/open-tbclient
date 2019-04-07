package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    private static volatile l bpw;
    private int bpA;
    private boolean bpB = false;
    private com.baidu.swan.ubc.d bpc;
    private ExecutorService bpx;
    private ExecutorService bpy;
    private com.baidu.swan.ubc.c bpz;
    private Context mContext;

    static /* synthetic */ int d(l lVar) {
        int i = lVar.bpA;
        lVar.bpA = i + 1;
        return i;
    }

    private l() {
        init(q.getContext());
    }

    public static l Ti() {
        if (bpw == null) {
            synchronized (l.class) {
                if (bpw == null) {
                    bpw = new l();
                }
            }
        }
        return bpw;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bpA = com.baidu.swan.a.a.Nc().getInt("ubc_key_flow_handle", 0);
            if (this.bpA > 1073741823) {
                this.bpA -= 1073741823;
            } else {
                this.bpA = 1073741823 + this.bpA;
            }
            this.bpx = Executors.newSingleThreadExecutor();
            this.bpx.execute(new f(this, null));
            this.bpy = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, jSONObject, i);
            if (this.bpc != null && this.bpc.jN(str)) {
                aVar.cV(true);
            }
            this.bpx.execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, String str2, int i) {
        if (!P(str, i)) {
            a aVar = new a(str, str2, i);
            if (this.bpc != null && this.bpc.jN(str)) {
                aVar.cV(true);
            }
            this.bpx.execute(aVar);
        }
    }

    boolean P(String str, int i) {
        if (this.bpc == null || this.bpc.O(str, i)) {
            if ((i & 16) == 0 || q.Tq().fv(str)) {
                if (this.bpc != null && this.bpc.jL(str) > 0) {
                    if (new Random().nextInt(100) >= this.bpc.jL(str)) {
                        return true;
                    }
                }
                return this.bpc != null && this.bpc.jM(str);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.bpx.execute(new a(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.bpx.execute(new a(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow i(String str, String str2, int i) {
        Flow Q;
        Q = Q(str, i);
        if (Q != null && Q.getValid()) {
            c cVar = new c(Q, str2);
            if (this.bpc != null && this.bpc.jN(str)) {
                cVar.cV(true);
            }
            this.bpx.execute(cVar);
        }
        return Q;
    }

    Flow Q(String str, int i) {
        Flow flow = new Flow(str, this.bpA, i);
        if (this.bpc != null && !this.bpc.O(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !q.Tq().fv(str)) {
            flow.setValid(false);
        } else {
            if (this.bpc != null && this.bpc.jL(str) > 0) {
                if (new Random().nextInt(100) >= this.bpc.jL(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bpc != null && this.bpc.jM(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bpx.execute(new e(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.bpx.execute(new d(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        this.bpx.execute(new b(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.ubc.l$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ l bpC;

        @Override // java.lang.Runnable
        public void run() {
            if (this.bpC.bpz != null) {
                this.bpC.bpz.SQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        p.u(jSONArray);
        this.bpy.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpz != null) {
                    l.this.bpz.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final JSONArray jSONArray) {
        p.u(jSONArray);
        this.bpy.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpz != null) {
                    l.this.bpz.t(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final String str, final boolean z) {
        this.bpx.execute(new Runnable() { // from class: com.baidu.swan.ubc.l.4
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.bpz != null) {
                    if (z) {
                        l.this.bpz.jG(str);
                    } else {
                        l.this.bpz.jH(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(l lVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            l.this.bpc = com.baidu.swan.ubc.d.SU();
            l.this.bpz = new com.baidu.swan.ubc.c(l.this.mContext);
            l.this.bpz.ST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private h bpF;

        a(String str, String str2, int i) {
            this.bpF = new h(str, str2, i);
        }

        a(String str, JSONObject jSONObject, int i) {
            this.bpF = new h(str, jSONObject, i);
        }

        a(String str, String str2, int i, String str3, int i2) {
            this.bpF = new h(str, str2, i, str3, i2);
        }

        a(String str, String str2, int i, String str3, long j, int i2) {
            this.bpF = new h(str, str2, i, str3, j, i2);
        }

        public void cV(boolean z) {
            if (this.bpF != null) {
                this.bpF.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpz != null) {
                this.bpF.Tf();
                if (!TextUtils.isEmpty(l.this.bpc.jK(this.bpF.getId()))) {
                    this.bpF.setCategory(l.this.bpc.jK(this.bpF.getId()));
                }
                if ((this.bpF.getOption() & 8) != 0) {
                    l.this.bpz.b(this.bpF);
                } else {
                    l.this.bpz.a(this.bpF);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private i bpG;

        c(Flow flow, String str) {
            this.bpG = new i(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bpG.X(flow.getStartTime());
            this.bpG.jP("1");
            l.d(l.this);
        }

        public void cV(boolean z) {
            if (this.bpG != null) {
                this.bpG.cV(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpz != null) {
                this.bpG.Tf();
                if (!TextUtils.isEmpty(l.this.bpc.jK(this.bpG.getId()))) {
                    this.bpG.setCategory(l.this.bpc.jK(this.bpG.getId()));
                }
                l.this.bpz.b(this.bpG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aDx;
        private int bpq;
        private String mValue;

        e(String str, int i, String str2) {
            this.aDx = str;
            this.bpq = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpz != null) {
                l.this.bpz.c(this.aDx, this.bpq, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private String aDx;
        private long aEs = System.currentTimeMillis();
        private int bpq;
        private JSONArray bpv;

        d(String str, int i, JSONArray jSONArray) {
            this.aDx = str;
            this.bpq = i;
            this.bpv = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpz != null) {
                l.this.bpz.a(this.aDx, this.bpq, this.aEs, this.bpv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private String aDx;
        private int bpq;

        b(String str, int i) {
            this.aDx = str;
            this.bpq = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.bpz != null) {
                l.this.bpz.y(this.aDx, this.bpq);
            }
        }
    }
}
