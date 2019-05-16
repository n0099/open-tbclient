package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private static volatile m bvJ;
    private ExecutorService aZL;
    private ExecutorService bvK;
    private com.baidu.swan.ubc.c bvL;
    private int bvM;
    private boolean bvN = false;
    private com.baidu.swan.ubc.d bvh;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bvM;
        mVar.bvM = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m Xd() {
        if (bvJ == null) {
            synchronized (m.class) {
                if (bvJ == null) {
                    bvJ = new m();
                }
            }
        }
        return bvJ;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bvM = com.baidu.swan.a.a.PL().getInt("ubc_key_flow_handle", 0);
            if (this.bvM > 1073741823) {
                this.bvM -= 1073741823;
            } else {
                this.bvM = 1073741823 + this.bvM;
            }
            if (s.Xr() == null || s.Xr().wf() == null) {
                this.aZL = Executors.newSingleThreadExecutor();
            } else {
                this.aZL = s.Xr().wf();
            }
            this.aZL.execute(new g());
            this.bvK = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.bvh != null && this.bvh.kL(str)) {
                bVar.dm(true);
            }
            this.aZL.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.bvh != null && this.bvh.kL(str)) {
                bVar.dm(true);
            }
            this.aZL.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.aZL.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.aZL.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow g(String str, String str2, int i) {
        Flow L;
        L = L(str, i);
        if (L != null && L.getValid()) {
            d dVar = new d(L, str2);
            if (this.bvh != null && this.bvh.kL(str)) {
                dVar.dm(true);
            }
            this.aZL.execute(dVar);
        }
        return L;
    }

    Flow L(String str, int i) {
        Flow flow = new Flow(str, this.bvM, i);
        if (this.bvh != null && !this.bvh.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.Xr().fK(str)) {
            flow.setValid(false);
        } else {
            if (this.bvh != null && this.bvh.kJ(str) > 0) {
                if (new Random().nextInt(100) >= this.bvh.kJ(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bvh != null && this.bvh.kK(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.aZL.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.aZL.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        this.aZL.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Xe() {
        if (!this.bvN) {
            this.bvN = true;
            this.aZL.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.bvL != null) {
                        m.this.bvL.WD();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.aZL.execute(new a(pVar));
    }

    public void initConfig() {
        Xf();
        if (!com.baidu.swan.a.a.PL().getBoolean("init_done", false)) {
            String ae = com.baidu.swan.c.a.ae(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(ae)) {
                try {
                    p pVar = new p("0", new JSONObject(ae));
                    pVar.Xm();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void Xf() {
        o Xg = o.Xg();
        Xg.Xe();
        Xg.Xh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        r.t(jSONArray);
        this.bvK.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bvL != null) {
                    m.this.bvL.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final JSONArray jSONArray) {
        r.t(jSONArray);
        this.bvK.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bvL != null) {
                    m.this.bvL.r(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WG() {
        this.aZL.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bvL != null) {
                    m.this.bvL.WG();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(final String str, final boolean z) {
        this.aZL.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bvL != null) {
                    if (z) {
                        m.this.bvL.kD(str);
                    } else {
                        m.this.bvL.kE(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.bvh = com.baidu.swan.ubc.d.WI();
            m.this.bvL = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bvL.WH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private h bvS;

        b(String str, String str2, int i) {
            this.bvS = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.bvS = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.bvS = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.bvS = new h(str, str2, i, str3, j, i2);
        }

        public void dm(boolean z) {
            if (this.bvS != null) {
                this.bvS.dm(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                this.bvS.WZ();
                if (!TextUtils.isEmpty(m.this.bvh.kI(this.bvS.getId()))) {
                    this.bvS.setCategory(m.this.bvh.kI(this.bvS.getId()));
                }
                if ((this.bvS.getOption() & 8) != 0) {
                    m.this.bvL.b(this.bvS);
                } else {
                    m.this.bvL.a(this.bvS);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class d implements Runnable {
        private j bvT;

        d(Flow flow, String str) {
            this.bvT = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bvT.ah(flow.getStartTime());
            this.bvT.kO("1");
            m.d(m.this);
        }

        public void dm(boolean z) {
            if (this.bvT != null) {
                this.bvT.dm(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                this.bvT.WZ();
                if (!TextUtils.isEmpty(m.this.bvh.kI(this.bvT.getId()))) {
                    this.bvT.setCategory(m.this.bvh.kI(this.bvT.getId()));
                }
                m.this.bvL.b(this.bvT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private String aFq;
        private int bvC;
        private String mValue;

        f(String str, int i, String str2) {
            this.aFq = str;
            this.bvC = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                m.this.bvL.c(this.aFq, this.bvC, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aFq;
        private long aGl = System.currentTimeMillis();
        private int bvC;
        private JSONArray bvI;

        e(String str, int i, JSONArray jSONArray) {
            this.aFq = str;
            this.bvC = i;
            this.bvI = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                m.this.bvL.a(this.aFq, this.bvC, this.aGl, this.bvI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private String aFq;
        private int bvC;

        c(String str, int i) {
            this.aFq = str;
            this.bvC = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                m.this.bvL.t(this.aFq, this.bvC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private p bvR;

        a(p pVar) {
            this.bvR = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bvL != null) {
                m.this.bvL.a(this.bvR);
                com.baidu.swan.a.a.PL().putBoolean("init_done", true);
            }
        }
    }
}
