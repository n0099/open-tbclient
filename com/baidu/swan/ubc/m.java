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
/* loaded from: classes9.dex */
public class m {
    private static volatile m cAI;
    private ExecutorService cAJ;
    private com.baidu.swan.ubc.c cAK;
    private int cAL;
    private boolean cAM = false;
    private com.baidu.swan.ubc.d cAh;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(m mVar) {
        int i = mVar.cAL;
        mVar.cAL = i + 1;
        return i;
    }

    private m() {
        init(s.getContext());
    }

    public static m asW() {
        if (cAI == null) {
            synchronized (m.class) {
                if (cAI == null) {
                    cAI = new m();
                }
            }
        }
        return cAI;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.cAL = com.baidu.swan.config.b.agm().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.cAL > 1073741823) {
                this.cAL -= 1073741823;
            } else {
                this.cAL = 1073741823 + this.cAL;
            }
            if (s.atk() == null || s.atk().Fb() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = s.atk().Fb();
            }
            this.mExecutorService.execute(new g());
            this.cAJ = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!U(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.cAh != null && this.cAh.qC(str)) {
                bVar.eS(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!U(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.cAh != null && this.cAh.qC(str)) {
                bVar.eS(true);
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
            if (this.cAh != null && this.cAh.qC(str)) {
                dVar.eS(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return V;
    }

    Flow V(String str, int i) {
        Flow flow = new Flow(str, this.cAL, i);
        if (this.cAh != null && !this.cAh.T(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !s.atk().jr(str)) {
            flow.setValid(false);
        } else {
            if (this.cAh != null && this.cAh.qA(str) > 0) {
                if (new Random().nextInt(100) >= this.cAh.qA(str)) {
                    flow.eT(true);
                }
            }
            if (this.cAh != null && this.cAh.qB(str)) {
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
        if (!this.cAM) {
            this.cAM = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.1
                @Override // java.lang.Runnable
                public void run() {
                    if (m.this.cAK != null) {
                        m.this.cAK.asu();
                    }
                }
            });
        }
    }

    public void a(p pVar) {
        this.mExecutorService.execute(new a(pVar));
    }

    public void initConfig() {
        asX();
        if (!com.baidu.swan.config.b.agm().getBoolean("init_done", false)) {
            String readAssetData = com.baidu.swan.d.c.readAssetData(AppRuntime.getAppContext(), "ubc_config.json");
            if (!TextUtils.isEmpty(readAssetData)) {
                try {
                    p pVar = new p("0", new JSONObject(readAssetData));
                    pVar.atf();
                    a(pVar);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void asX() {
        o asY = o.asY();
        asY.upload();
        asY.asZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final JSONArray jSONArray, final String str) {
        r.H(jSONArray);
        this.cAJ.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAK != null) {
                    m.this.cAK.c(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final JSONArray jSONArray) {
        r.H(jSONArray);
        this.cAJ.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAK != null) {
                    m.this.cAK.G(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asx() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAK != null) {
                    m.this.cAK.asx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.m.5
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.cAK != null) {
                    if (z) {
                        m.this.cAK.qu(str);
                    } else {
                        m.this.cAK.qv(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            m.this.cAh = com.baidu.swan.ubc.d.asz();
            m.this.cAK = new com.baidu.swan.ubc.c(m.this.mContext);
            m.this.cAK.asy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        private h cAQ;

        b(String str, String str2, int i) {
            this.cAQ = new h(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.cAQ = new h(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.cAQ = new h(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.cAQ = new h(str, str2, i, str3, j, i2);
        }

        public void eS(boolean z) {
            if (this.cAQ != null) {
                this.cAQ.eS(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                this.cAQ.asQ();
                if (!TextUtils.isEmpty(m.this.cAh.qz(this.cAQ.getId()))) {
                    this.cAQ.setCategory(m.this.cAh.qz(this.cAQ.getId()));
                }
                if ((this.cAQ.getOption() & 8) != 0) {
                    m.this.cAK.b(this.cAQ);
                } else {
                    m.this.cAK.a(this.cAQ);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        private j cAR;

        d(Flow flow, String str) {
            this.cAR = new j(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.asS());
            this.cAR.bf(flow.getStartTime());
            this.cAR.qF("1");
            m.d(m.this);
        }

        public void eS(boolean z) {
            if (this.cAR != null) {
                this.cAR.eS(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                this.cAR.asQ();
                if (!TextUtils.isEmpty(m.this.cAh.qz(this.cAR.getId()))) {
                    this.cAR.setCategory(m.this.cAh.qz(this.cAR.getId()));
                }
                m.this.cAK.b(this.cAR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class f implements Runnable {
        private String bCy;
        private int cAC;
        private String mValue;

        f(String str, int i, String str2) {
            this.bCy = str;
            this.cAC = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                m.this.cAK.e(this.bCy, this.cAC, this.mValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        private String bCy;
        private long bDa = System.currentTimeMillis();
        private int cAC;
        private JSONArray cAH;

        e(String str, int i, JSONArray jSONArray) {
            this.bCy = str;
            this.cAC = i;
            this.cAH = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                m.this.cAK.a(this.bCy, this.cAC, this.bDa, this.cAH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        private String bCy;
        private int cAC;

        c(String str, int i) {
            this.bCy = str;
            this.cAC = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                m.this.cAK.w(this.bCy, this.cAC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private p cAP;

        a(p pVar) {
            this.cAP = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.cAK != null) {
                m.this.cAK.a(this.cAP);
                com.baidu.swan.config.b.agm().putBoolean("init_done", true);
            }
        }
    }
}
