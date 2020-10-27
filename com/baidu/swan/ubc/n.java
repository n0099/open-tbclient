package com.baidu.swan.ubc;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class n {
    private static volatile n egu;
    private com.baidu.swan.ubc.d efL;
    private ExecutorService egv;
    private com.baidu.swan.ubc.c egw;
    private int egx;
    private boolean egy = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.egx;
        nVar.egx = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bbo() {
        if (egu == null) {
            synchronized (n.class) {
                if (egu == null) {
                    egu = new n();
                }
            }
        }
        return egu;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.egx = com.baidu.swan.config.b.aMm().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.egx > 1073741823) {
                this.egx -= 1073741823;
            } else {
                this.egx = 1073741823 + this.egx;
            }
            if (com.baidu.swan.ubc.e.baS() == null || com.baidu.swan.ubc.e.baS().afr() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.baS().afr();
            }
            this.mExecutorService.execute(new g());
            this.egv = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.efL != null && this.efL.yE(str)) {
                bVar.hP(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!af(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.efL != null && this.efL.yE(str)) {
                bVar.hP(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean af(String str, int i) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
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
    public synchronized Flow j(String str, String str2, int i) {
        Flow ag;
        ag = ag(str, i);
        if (ag != null && ag.getValid()) {
            d dVar = new d(ag, str2);
            if (this.efL != null && this.efL.yE(str)) {
                dVar.hP(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ag;
    }

    Flow ag(String str, int i) {
        Flow flow = new Flow(str, this.egx, i);
        if (this.efL != null && !this.efL.ae(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.baS().qp(str)) {
            flow.setValid(false);
        } else {
            if (this.efL != null && this.efL.yC(str) > 0) {
                if (new Random().nextInt(100) >= this.efL.yC(str)) {
                    flow.hQ(true);
                }
            }
            if (this.efL != null && this.efL.yD(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.egy) {
            this.egy = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.egw != null) {
                        n.this.egw.baJ();
                    }
                }
            });
        }
    }

    public void b(q qVar) {
        this.mExecutorService.execute(new a(qVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final JSONArray jSONArray, final String str) {
        s.L(jSONArray);
        this.egv.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.egw != null) {
                    n.this.egw.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.egv.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.egw != null) {
                    n.this.egw.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baM() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.egw != null) {
                    n.this.egw.baM();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.egw != null) {
                    if (z) {
                        n.this.egw.yw(str);
                    } else {
                        n.this.egw.yx(str);
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
            n.this.efL = com.baidu.swan.ubc.d.baO();
            n.this.egw = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.egw.baN();
        }
    }

    /* loaded from: classes9.dex */
    private class b implements Runnable {
        private i egD;

        b(String str, String str2, int i) {
            this.egD = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.egD = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.egD = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.egD = new i(str, str2, i, str3, j, i2);
        }

        public void hP(boolean z) {
            if (this.egD != null) {
                this.egD.hP(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                this.egD.bbi();
                if (!TextUtils.isEmpty(n.this.efL.yB(this.egD.getId()))) {
                    this.egD.setCategory(n.this.efL.yB(this.egD.getId()));
                }
                if ((this.egD.getOption() & 8) != 0) {
                    n.this.egw.b(this.egD);
                } else {
                    n.this.egw.a(this.egD);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    private class d implements Runnable {
        private k egE;

        d(Flow flow, String str) {
            this.egE = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.bbk());
            this.egE.cB(flow.getStartTime());
            this.egE.yK("1");
            n.d(n.this);
        }

        public void hP(boolean z) {
            if (this.egE != null) {
                this.egE.hP(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                this.egE.bbi();
                if (!TextUtils.isEmpty(n.this.efL.yB(this.egE.getId()))) {
                    this.egE.setCategory(n.this.efL.yB(this.egE.getId()));
                }
                n.this.egw.b(this.egE);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class f implements Runnable {
        private String egn;
        private int ego;
        private String mValue;

        f(String str, int i, String str2) {
            this.egn = str;
            this.ego = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                n.this.egw.h(this.egn, this.ego, this.mValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class e implements Runnable {
        private String egn;
        private int ego;
        private JSONArray egt;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.egn = str;
            this.ego = i;
            this.egt = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                n.this.egw.a(this.egn, this.ego, this.mEndTime, this.egt);
            }
        }
    }

    /* loaded from: classes9.dex */
    private class c implements Runnable {
        private String egn;
        private int ego;

        c(String str, int i) {
            this.egn = str;
            this.ego = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                n.this.egw.I(this.egn, this.ego);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private q egC;

        a(q qVar) {
            this.egC = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.egw != null) {
                n.this.egw.a(this.egC);
            }
        }
    }
}
