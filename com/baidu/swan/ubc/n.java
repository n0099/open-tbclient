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
/* loaded from: classes6.dex */
public class n {
    private static volatile n ewC;
    private com.baidu.swan.ubc.d evU;
    private ExecutorService ewD;
    private com.baidu.swan.ubc.c ewE;
    private int ewF;
    private boolean ewG = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.ewF;
        nVar.ewF = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n beQ() {
        if (ewC == null) {
            synchronized (n.class) {
                if (ewC == null) {
                    ewC = new n();
                }
            }
        }
        return ewC;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.ewF = com.baidu.swan.config.b.aPL().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.ewF > 1073741823) {
                this.ewF -= 1073741823;
            } else {
                this.ewF = 1073741823 + this.ewF;
            }
            if (com.baidu.swan.ubc.e.beu() == null || com.baidu.swan.ubc.e.beu().ahG() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.beu().ahG();
            }
            this.mExecutorService.execute(new g());
            this.ewD = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ak(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.evU != null && this.evU.yi(str)) {
                bVar.iH(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        if (!ak(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.evU != null && this.evU.yi(str)) {
                bVar.iH(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ak(String str, int i) {
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
    public synchronized Flow n(String str, String str2, int i) {
        Flow al;
        al = al(str, i);
        if (al != null && al.getValid()) {
            d dVar = new d(al, str2);
            if (this.evU != null && this.evU.yi(str)) {
                dVar.iH(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return al;
    }

    Flow al(String str, int i) {
        Flow flow = new Flow(str, this.ewF, i);
        if (this.evU != null && !this.evU.aj(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.beu().pM(str)) {
            flow.setValid(false);
        } else {
            if (this.evU != null && this.evU.yg(str) > 0) {
                if (new Random().nextInt(100) >= this.evU.yg(str)) {
                    flow.iI(true);
                }
            }
            if (this.evU != null && this.evU.yh(str)) {
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
    public void M(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.ewG) {
            this.ewG = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.ewE != null) {
                        n.this.ewE.bel();
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
        s.M(jSONArray);
        this.ewD.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ewE != null) {
                    n.this.ewE.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(final JSONArray jSONArray) {
        s.M(jSONArray);
        this.ewD.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ewE != null) {
                    n.this.ewE.L(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beo() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ewE != null) {
                    n.this.ewE.beo();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.ewE != null) {
                    if (z) {
                        n.this.ewE.ya(str);
                    } else {
                        n.this.ewE.yb(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.evU = com.baidu.swan.ubc.d.beq();
            n.this.ewE = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.ewE.bep();
        }
    }

    /* loaded from: classes6.dex */
    private class b implements Runnable {
        private i ewL;

        b(String str, String str2, int i) {
            this.ewL = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.ewL = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.ewL = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.ewL = new i(str, str2, i, str3, j, i2);
        }

        public void iH(boolean z) {
            if (this.ewL != null) {
                this.ewL.iH(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                this.ewL.beK();
                if (!TextUtils.isEmpty(n.this.evU.yf(this.ewL.getId()))) {
                    this.ewL.setCategory(n.this.evU.yf(this.ewL.getId()));
                }
                if ((this.ewL.getOption() & 8) != 0) {
                    n.this.ewE.b(this.ewL);
                } else {
                    n.this.ewE.a(this.ewL);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class d implements Runnable {
        private k ewM;

        d(Flow flow, String str) {
            this.ewM = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.beM());
            this.ewM.dw(flow.getStartTime());
            this.ewM.yo("1");
            n.d(n.this);
        }

        public void iH(boolean z) {
            if (this.ewM != null) {
                this.ewM.iH(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                this.ewM.beK();
                if (!TextUtils.isEmpty(n.this.evU.yf(this.ewM.getId()))) {
                    this.ewM.setCategory(n.this.evU.yf(this.ewM.getId()));
                }
                n.this.ewE.b(this.ewM);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class f implements Runnable {
        private String ewv;
        private int eww;
        private String mValue;

        f(String str, int i, String str2) {
            this.ewv = str;
            this.eww = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                n.this.ewE.i(this.ewv, this.eww, this.mValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class e implements Runnable {
        private JSONArray ewB;
        private String ewv;
        private int eww;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.ewv = str;
            this.eww = i;
            this.ewB = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                n.this.ewE.a(this.ewv, this.eww, this.mEndTime, this.ewB);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c implements Runnable {
        private String ewv;
        private int eww;

        c(String str, int i) {
            this.ewv = str;
            this.eww = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                n.this.ewE.M(this.ewv, this.eww);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private q ewK;

        a(q qVar) {
            this.ewK = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.ewE != null) {
                n.this.ewE.a(this.ewK);
            }
        }
    }
}
