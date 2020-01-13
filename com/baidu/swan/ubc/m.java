package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m {
    private static volatile m cAT;
    private ExecutorService cAU;
    private com.baidu.swan.ubc.c cAV;
    private int cAW;
    private boolean cAX = false;
    private com.baidu.swan.ubc.d cAs;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.cAW;
        mVar.cAW = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m atp() {
        if (cAT == null) {
            synchronized (m.class) {
                if (cAT == null) {
                    cAT = new m();
                }
            }
        }
        return cAT;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.cAW = com.baidu.swan.config.b.agF().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.cAW > 1073741823) {
                this.cAW -= 1073741823;
            } else {
                this.cAW = 1073741823 + this.cAW;
            }
            if (s.atD() == null || s.atD().Fx() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.atD().Fx();
            }
            this.mExecutorService.execute(new g());
            this.cAU = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!U(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.cAs != null && this.cAs.qF(str)) {
                bVar.eX(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!U(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.cAs != null && this.cAs.qF(str)) {
                bVar.eX(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean U(String str, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, String str3, long j, int i2) {
        this.mExecutorService.execute(new b(str, str2, i, str3, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Flow k(String str, String str2, int i) {
        Flow V;
        V = V(str, i);
        if (V != null && V.getValid()) {
            d dVar = new d(V, str2);
            if (this.cAs != null && this.cAs.qF(str)) {
                dVar.eX(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return V;
    }

    Flow V(String str, int i) {
        Flow flow = new Flow(str, this.cAW, i);
        if (this.cAs != null && !this.cAs.T(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.atD().ju(str)) {
            flow.setValid(false);
        } else {
            if (this.cAs != null && this.cAs.qD(str) > 0) {
                if (new Random().nextInt(100) >= this.cAs.qD(str)) {
                    flow.eY(true);
                }
            }
            if (this.cAs != null && this.cAs.qE(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.cAX) {
            this.cAX = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cAV != null) {
                        m.this.cAV.asN();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        atq();
        if (!com.baidu.swan.config.b.agF().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.aty();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void atq() {
        o atr = o.atr();
        atr.upload();
        atr.ats();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.I(jSONArray);
        this.cAU.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAV != null) {
                    m.this.cAV.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        r.I(jSONArray);
        this.cAU.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAV != null) {
                    m.this.cAV.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asQ() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAV != null) {
                    m.this.cAV.asQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAV != null) {
                    if (z) {
                        m.this.cAV.qx(str);
                    } else {
                        m.this.cAV.qy(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.cAs = com.baidu.swan.ubc.d.asS();
            m.this.cAV = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.cAV.asR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        private h cBb;

        b(String str, String str2, int i) {
            this.cBb = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.cBb = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.cBb = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.cBb = new h(str, str2, i, str3, j, i2);
        }

        public void eX(boolean z) {
            if (this.cBb != null) {
                this.cBb.eX(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                this.cBb.atj();
                if (!TextUtils.isEmpty(m.this.cAs.qC(this.cBb.getId()))) {
                    this.cBb.setCategory(m.this.cAs.qC(this.cBb.getId()));
                }
                if ((this.cBb.getOption() & 8) != 0) {
                    m.this.cAV.b(this.cBb);
                } else {
                    m.this.cAV.a(this.cBb);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private class d implements Runnable {
        private j cBc;

        d(Flow flow, String str) {
            this.cBc = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.atl());
            this.cBc.bi(flow.getStartTime());
            this.cBc.qI("1");
            m.d(m.this);
        }

        public void eX(boolean z) {
            if (this.cBc != null) {
                this.cBc.eX(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                this.cBc.atj();
                if (!TextUtils.isEmpty(m.this.cAs.qC(this.cBc.getId()))) {
                    this.cBc.setCategory(m.this.cAs.qC(this.cBc.getId()));
                }
                m.this.cAV.b(this.cBc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class f implements Runnable {
        private String bDj;
        private int cAN;
        private String mValue;

        f(String str, int i, String str2) {
            this.bDj = str;
            this.cAN = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                m.this.cAV.e(this.bDj, this.cAN, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class e implements Runnable {
        private long bDL = System.currentTimeMillis();
        private String bDj;
        private int cAN;
        private JSONArray cAS;

        e(String str, int i, JSONArray jSONArray) {
            this.bDj = str;
            this.cAN = i;
            this.cAS = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                m.this.cAV.a(this.bDj, this.cAN, this.bDL, this.cAS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c implements Runnable {
        private String bDj;
        private int cAN;

        c(String str, int i) {
            this.bDj = str;
            this.cAN = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                m.this.cAV.w(this.bDj, this.cAN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private p cBa;

        a(p pVar) {
            this.cBa = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAV != null) {
                m.this.cAV.a(this.cBa);
                com.baidu.swan.config.b.agF().putBoolean("init_done", true);
            }
        }
    }
}
