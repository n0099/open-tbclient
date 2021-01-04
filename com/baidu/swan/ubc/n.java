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
    private static volatile n eBr;
    private com.baidu.swan.ubc.d eAJ;
    private ExecutorService eBs;
    private com.baidu.swan.ubc.c eBt;
    private int eBu;
    private boolean eBv = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.eBu;
        nVar.eBu = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n biJ() {
        if (eBr == null) {
            synchronized (n.class) {
                if (eBr == null) {
                    eBr = new n();
                }
            }
        }
        return eBr;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.eBu = com.baidu.swan.config.b.aTE().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.eBu > 1073741823) {
                this.eBu -= 1073741823;
            } else {
                this.eBu = 1073741823 + this.eBu;
            }
            if (com.baidu.swan.ubc.e.bin() == null || com.baidu.swan.ubc.e.bin().alz() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.bin().alz();
            }
            this.mExecutorService.execute(new g());
            this.eBs = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ak(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.eAJ != null && this.eAJ.zt(str)) {
                bVar.iL(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str, String str2, int i) {
        if (!ak(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.eAJ != null && this.eAJ.zt(str)) {
                bVar.iL(true);
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
            if (this.eAJ != null && this.eAJ.zt(str)) {
                dVar.iL(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return al;
    }

    Flow al(String str, int i) {
        Flow flow = new Flow(str, this.eBu, i);
        if (this.eAJ != null && !this.eAJ.aj(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.bin().qX(str)) {
            flow.setValid(false);
        } else {
            if (this.eAJ != null && this.eAJ.zr(str) > 0) {
                if (new Random().nextInt(100) >= this.eAJ.zr(str)) {
                    flow.iM(true);
                }
            }
            if (this.eAJ != null && this.eAJ.zs(str)) {
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
        if (!this.eBv) {
            this.eBv = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.eBt != null) {
                        n.this.eBt.bie();
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
        this.eBs.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eBt != null) {
                    n.this.eBt.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(final JSONArray jSONArray) {
        s.M(jSONArray);
        this.eBs.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eBt != null) {
                    n.this.eBt.L(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bih() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eBt != null) {
                    n.this.eBt.bih();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void av(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.eBt != null) {
                    if (z) {
                        n.this.eBt.zl(str);
                    } else {
                        n.this.eBt.zm(str);
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
            n.this.eAJ = com.baidu.swan.ubc.d.bij();
            n.this.eBt = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.eBt.bii();
        }
    }

    /* loaded from: classes6.dex */
    private class b implements Runnable {
        private i eBA;

        b(String str, String str2, int i) {
            this.eBA = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.eBA = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.eBA = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.eBA = new i(str, str2, i, str3, j, i2);
        }

        public void iL(boolean z) {
            if (this.eBA != null) {
                this.eBA.iL(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                this.eBA.biD();
                if (!TextUtils.isEmpty(n.this.eAJ.zq(this.eBA.getId()))) {
                    this.eBA.setCategory(n.this.eAJ.zq(this.eBA.getId()));
                }
                if ((this.eBA.getOption() & 8) != 0) {
                    n.this.eBt.b(this.eBA);
                } else {
                    n.this.eBt.a(this.eBA);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class d implements Runnable {
        private k eBB;

        d(Flow flow, String str) {
            this.eBB = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.biF());
            this.eBB.dw(flow.getStartTime());
            this.eBB.zz("1");
            n.d(n.this);
        }

        public void iL(boolean z) {
            if (this.eBB != null) {
                this.eBB.iL(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                this.eBB.biD();
                if (!TextUtils.isEmpty(n.this.eAJ.zq(this.eBB.getId()))) {
                    this.eBB.setCategory(n.this.eAJ.zq(this.eBB.getId()));
                }
                n.this.eBt.b(this.eBB);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class f implements Runnable {
        private String eBk;
        private int eBl;
        private String mValue;

        f(String str, int i, String str2) {
            this.eBk = str;
            this.eBl = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                n.this.eBt.i(this.eBk, this.eBl, this.mValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class e implements Runnable {
        private String eBk;
        private int eBl;
        private JSONArray eBq;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.eBk = str;
            this.eBl = i;
            this.eBq = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                n.this.eBt.a(this.eBk, this.eBl, this.mEndTime, this.eBq);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c implements Runnable {
        private String eBk;
        private int eBl;

        c(String str, int i) {
            this.eBk = str;
            this.eBl = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                n.this.eBt.M(this.eBk, this.eBl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private q eBz;

        a(q qVar) {
            this.eBz = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.eBt != null) {
                n.this.eBt.a(this.eBz);
            }
        }
    }
}
