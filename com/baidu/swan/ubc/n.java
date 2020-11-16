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
/* loaded from: classes16.dex */
public class n {
    private static volatile n ekE;
    private com.baidu.swan.ubc.d ejW;
    private ExecutorService ekF;
    private com.baidu.swan.ubc.c ekG;
    private int ekH;
    private boolean ekI = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.ekH;
        nVar.ekH = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n bdh() {
        if (ekE == null) {
            synchronized (n.class) {
                if (ekE == null) {
                    ekE = new n();
                }
            }
        }
        return ekE;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ekH = com.baidu.swan.config.b.aOe().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.ekH > 1073741823) {
                this.ekH -= 1073741823;
            } else {
                this.ekH = 1073741823 + this.ekH;
            }
            if (com.baidu.swan.ubc.e.bcL() == null || com.baidu.swan.ubc.e.bcL().ahj() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.bcL().ahj();
            }
            this.mExecutorService.execute(new g());
            this.ekF = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.ejW != null && this.ejW.yN(str)) {
                bVar.ib(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str, String str2, int i) {
        if (!ah(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.ejW != null && this.ejW.yN(str)) {
                bVar.ib(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ah(String str, int i) {
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
    public synchronized Flow k(String str, String str2, int i) {
        Flow ai;
        ai = ai(str, i);
        if (ai != null && ai.getValid()) {
            d dVar = new d(ai, str2);
            if (this.ejW != null && this.ejW.yN(str)) {
                dVar.ib(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ai;
    }

    Flow ai(String str, int i) {
        Flow flow = new Flow(str, this.ekH, i);
        if (this.ejW != null && !this.ejW.ag(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.bcL().qx(str)) {
            flow.setValid(false);
        } else {
            if (this.ejW != null && this.ejW.yL(str) > 0) {
                if (new Random().nextInt(100) >= this.ejW.yL(str)) {
                    flow.ic(true);
                }
            }
            if (this.ejW != null && this.ejW.yM(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.ekI) {
            this.ekI = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.ekG != null) {
                        n.this.ekG.bcC();
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
        this.ekF.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ekG != null) {
                    n.this.ekG.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.ekF.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ekG != null) {
                    n.this.ekG.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcF() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ekG != null) {
                    n.this.ekG.bcF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ekG != null) {
                    if (z) {
                        n.this.ekG.yF(str);
                    } else {
                        n.this.ekG.yG(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.ejW = com.baidu.swan.ubc.d.bcH();
            n.this.ekG = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.ekG.bcG();
        }
    }

    /* loaded from: classes16.dex */
    private class b implements Runnable {
        private i ekN;

        b(String str, String str2, int i) {
            this.ekN = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ekN = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ekN = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ekN = new i(str, str2, i, str3, j, i2);
        }

        public void ib(boolean z) {
            if (this.ekN != null) {
                this.ekN.ib(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                this.ekN.bdb();
                if (!TextUtils.isEmpty(n.this.ejW.yK(this.ekN.getId()))) {
                    this.ekN.setCategory(n.this.ejW.yK(this.ekN.getId()));
                }
                if ((this.ekN.getOption() & 8) != 0) {
                    n.this.ekG.b(this.ekN);
                } else {
                    n.this.ekG.a(this.ekN);
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    private class d implements Runnable {
        private k ekO;

        d(Flow flow, String str) {
            this.ekO = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.bdd());
            this.ekO.cX(flow.getStartTime());
            this.ekO.yT("1");
            n.d(n.this);
        }

        public void ib(boolean z) {
            if (this.ekO != null) {
                this.ekO.ib(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                this.ekO.bdb();
                if (!TextUtils.isEmpty(n.this.ejW.yK(this.ekO.getId()))) {
                    this.ekO.setCategory(n.this.ejW.yK(this.ekO.getId()));
                }
                n.this.ekG.b(this.ekO);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class f implements Runnable {
        private String ekx;
        private int eky;
        private String mValue;

        f(String str, int i, String str2) {
            this.ekx = str;
            this.eky = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                n.this.ekG.i(this.ekx, this.eky, this.mValue);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class e implements Runnable {
        private JSONArray ekD;
        private String ekx;
        private int eky;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.ekx = str;
            this.eky = i;
            this.ekD = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                n.this.ekG.a(this.ekx, this.eky, this.mEndTime, this.ekD);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class c implements Runnable {
        private String ekx;
        private int eky;

        c(String str, int i) {
            this.ekx = str;
            this.eky = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                n.this.ekG.K(this.ekx, this.eky);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a implements Runnable {
        private q ekM;

        a(q qVar) {
            this.ekM = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ekG != null) {
                n.this.ekG.a(this.ekM);
            }
        }
    }
}
