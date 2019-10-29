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
    private static volatile m bPE;
    private ExecutorService bPF;
    private com.baidu.swan.ubc.c bPG;
    private int bPH;
    private boolean bPI = false;
    private com.baidu.swan.ubc.d bPc;
    private ExecutorService btS;
    private Context mContext;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.bPH;
        mVar.bPH = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m acS() {
        if (bPE == null) {
            synchronized (m.class) {
                if (bPE == null) {
                    bPE = new m();
                }
            }
        }
        return bPE;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.bPH = com.baidu.swan.a.a.Vx().getInt("ubc_key_flow_handle", 0);
            if (this.bPH > 1073741823) {
                this.bPH -= 1073741823;
            } else {
                this.bPH = 1073741823 + this.bPH;
            }
            if (s.adh() == null || s.adh().BE() == null) {
                this.btS = Executors.newSingleThreadExecutor();
            } else {
                this.btS = s.adh().BE();
            }
            this.btS.execute(new g());
            this.bPF = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.bPc != null && this.bPc.lw(str)) {
                bVar.dI(true);
            }
            this.btS.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, int i) {
        if (!K(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.bPc != null && this.bPc.lw(str)) {
                bVar.dI(true);
            }
            this.btS.execute(bVar);
        }
    }

    boolean K(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.btS.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.btS.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow g(String str, String str2, int i) {
        Flow L;
        L = L(str, i);
        if (L != null && L.getValid()) {
            d dVar = new d(L, str2);
            if (this.bPc != null && this.bPc.lw(str)) {
                dVar.dI(true);
            }
            this.btS.execute(dVar);
        }
        return L;
    }

    Flow L(String str, int i) {
        Flow flow = new Flow(str, this.bPH, i);
        if (this.bPc != null && !this.bPc.J(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.adh().gv(str)) {
            flow.setValid(false);
        } else {
            if (this.bPc != null && this.bPc.lu(str) > 0) {
                if (new Random().nextInt(100) >= this.bPc.lu(str)) {
                    flow.setValid(false);
                }
            }
            if (this.bPc != null && this.bPc.lv(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.btS.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.btS.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        this.btS.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acT() {
        if (!this.bPI) {
            this.bPI = true;
            this.btS.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.bPG != null) {
                        m.this.bPG.acq();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.btS.execute(new a(pVar));
    }

    public void initConfig() {
        acU();
        if (!com.baidu.swan.a.a.Vx().getBoolean("init_done", false)) {
            String ac = com.baidu.swan.c.a.ac(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(ac)) {
                try {
                    p pVar = new p("0", new JSONObject(ac));
                    pVar.adc();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void acU() {
        o acV = o.acV();
        acV.acT();
        acV.acW();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final JSONArray jSONArray, final String str) {
        r.B(jSONArray);
        this.bPF.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bPG != null) {
                    m.this.bPG.b(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(final JSONArray jSONArray) {
        r.B(jSONArray);
        this.bPF.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bPG != null) {
                    m.this.bPG.z(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void act() {
        this.btS.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bPG != null) {
                    m.this.bPG.act();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(final String str, final boolean z) {
        this.btS.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.bPG != null) {
                    if (z) {
                        m.this.bPG.lo(str);
                    } else {
                        m.this.bPG.lp(str);
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
            m.this.bPc = com.baidu.swan.ubc.d.acv();
            m.this.bPG = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.bPG.acu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private h bPN;

        b(String str, String str2, int i) {
            this.bPN = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.bPN = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.bPN = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.bPN = new h(str, str2, i, str3, j, i2);
        }

        public void dI(boolean z) {
            if (this.bPN != null) {
                this.bPN.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                this.bPN.acN();
                if (!TextUtils.isEmpty(m.this.bPc.lt(this.bPN.getId()))) {
                    this.bPN.setCategory(m.this.bPc.lt(this.bPN.getId()));
                }
                if ((this.bPN.getOption() & 8) != 0) {
                    m.this.bPG.b(this.bPN);
                } else {
                    m.this.bPG.a(this.bPN);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class d implements Runnable {
        private j bPO;

        d(Flow flow, String str) {
            this.bPO = new j(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.bPO.aB(flow.getStartTime());
            this.bPO.lz("1");
            m.d(m.this);
        }

        public void dI(boolean z) {
            if (this.bPO != null) {
                this.bPO.dI(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                this.bPO.acN();
                if (!TextUtils.isEmpty(m.this.bPc.lt(this.bPO.getId()))) {
                    this.bPO.setCategory(m.this.bPc.lt(this.bPO.getId()));
                }
                m.this.bPG.b(this.bPO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private String aZL;
        private int bPx;
        private String mValue;

        f(String str, int i, String str2) {
            this.aZL = str;
            this.bPx = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                m.this.bPG.e(this.aZL, this.bPx, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private String aZL;
        private JSONArray bPD;
        private int bPx;
        private long baF = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.aZL = str;
            this.bPx = i;
            this.bPD = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                m.this.bPG.a(this.aZL, this.bPx, this.baF, this.bPD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private String aZL;
        private int bPx;

        c(String str, int i) {
            this.aZL = str;
            this.bPx = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                m.this.bPG.t(this.aZL, this.bPx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private p bPM;

        a(p pVar) {
            this.bPM = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.bPG != null) {
                m.this.bPG.a(this.bPM);
                com.baidu.swan.a.a.Vx().putBoolean("init_done", true);
            }
        }
    }
}
