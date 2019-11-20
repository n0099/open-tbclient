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
    private static volatile m bON;
    private ExecutorService bOO;
    private com.baidu.swan.ubc.c bOP;
    private int bOQ;
    private boolean bOR = false;
    private com.baidu.swan.ubc.d bOl;
    private ExecutorService btb;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bOQ;
        mVar.bOQ = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m acQ() {
        if (bON == null) {
            synchronized (m.class) {
                if (bON == null) {
                    bON = new m();
                }
            }
        }
        return bON;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bOQ = com.baidu.swan.a.a.Vv().getInt("ubc_key_flow_handle", 0);
            if (this.bOQ > 1073741823) {
                this.bOQ -= 1073741823;
            } else {
                this.bOQ = 1073741823 + this.bOQ;
            }
            if (s.adf() == null || s.adf().BF() == null) {
                this.btb = Executors.newSingleThreadExecutor();
            } else {
                this.btb = s.adf().BF();
            }
            this.btb.execute(new g());
            this.bOO = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.bOl != null && this.bOl.lw(str)) {
                bVar.dI(true);
            }
            this.btb.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.bOl != null && this.bOl.lw(str)) {
                bVar.dI(true);
            }
            this.btb.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.btb.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.btb.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow g(String str, String str2, int i) {
        Flow L;
        L = L(str, i);
        if (L != null && L.getValid()) {
            d dVar = new d(L, str2);
            if (this.bOl != null && this.bOl.lw(str)) {
                dVar.dI(true);
            }
            this.btb.execute(dVar);
        }
        return L;
    }

    Flow L(String str, int i) {
        Flow flow = new Flow(str, this.bOQ, i);
        if (this.bOl != null && !this.bOl.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.adf().gv(str)) {
            flow.setValid(false);
        } else {
            if (this.bOl != null && this.bOl.lu(str) > 0) {
                if (new Random().nextInt(100) >= this.bOl.lu(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bOl != null && this.bOl.lv(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.btb.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.btb.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        this.btb.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acR() {
        if (!this.bOR) {
            this.bOR = true;
            this.btb.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.bOP != null) {
                        m.this.bOP.aco();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.btb.execute(new a(pVar));
    }

    public void initConfig() {
        acS();
        if (!com.baidu.swan.a.a.Vv().getBoolean("init_done", false)) {
            String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(ac)) {
                try {
                    p pVar = new p("0", new JSONObject(ac));
                    pVar.ada();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void acS() {
        o acT = o.acT();
        acT.acR();
        acT.acU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        r.B(jSONArray);
        this.bOO.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bOP != null) {
                    m.this.bOP.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(final JSONArray jSONArray) {
        r.B(jSONArray);
        this.bOO.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bOP != null) {
                    m.this.bOP.z(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acr() {
        this.btb.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bOP != null) {
                    m.this.bOP.acr();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(final String str, final boolean z) {
        this.btb.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bOP != null) {
                    if (z) {
                        m.this.bOP.lo(str);
                    } else {
                        m.this.bOP.lp(str);
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
            m.this.bOl = com.baidu.swan.ubc.d.act();
            m.this.bOP = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bOP.acs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private h bOW;

        b(String str, String str2, int i) {
            this.bOW = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.bOW = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.bOW = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.bOW = new h(str, str2, i, str3, j, i2);
        }

        public void dI(boolean z) {
            if (this.bOW != null) {
                this.bOW.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                this.bOW.acL();
                if (!TextUtils.isEmpty(m.this.bOl.lt(this.bOW.getId()))) {
                    this.bOW.setCategory(m.this.bOl.lt(this.bOW.getId()));
                }
                if ((this.bOW.getOption() & 8) != 0) {
                    m.this.bOP.b(this.bOW);
                } else {
                    m.this.bOP.a(this.bOW);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class d implements Runnable {
        private j bOX;

        d(Flow flow, String str) {
            this.bOX = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bOX.aA(flow.getStartTime());
            this.bOX.lz("1");
            m.d(m.this);
        }

        public void dI(boolean z) {
            if (this.bOX != null) {
                this.bOX.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                this.bOX.acL();
                if (!TextUtils.isEmpty(m.this.bOl.lt(this.bOX.getId()))) {
                    this.bOX.setCategory(m.this.bOl.lt(this.bOX.getId()));
                }
                m.this.bOP.b(this.bOX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private String aZt;
        private int bOG;
        private String mValue;

        f(String str, int i, String str2) {
            this.aZt = str;
            this.bOG = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                m.this.bOP.e(this.aZt, this.bOG, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aZt;
        private int bOG;
        private JSONArray bOM;
        private long ban = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.aZt = str;
            this.bOG = i;
            this.bOM = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                m.this.bOP.a(this.aZt, this.bOG, this.ban, this.bOM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private String aZt;
        private int bOG;

        c(String str, int i) {
            this.aZt = str;
            this.bOG = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                m.this.bOP.t(this.aZt, this.bOG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private p bOV;

        a(p pVar) {
            this.bOV = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bOP != null) {
                m.this.bOP.a(this.bOV);
                com.baidu.swan.a.a.Vv().putBoolean("init_done", true);
            }
        }
    }
}
