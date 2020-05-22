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
/* loaded from: classes11.dex */
public class n {
    private static volatile n dqe;
    private com.baidu.swan.ubc.d dpw;
    private ExecutorService dqf;
    private com.baidu.swan.ubc.c dqg;
    private int dqh;
    private boolean dqi = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dqh;
        nVar.dqh = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aID() {
        if (dqe == null) {
            synchronized (n.class) {
                if (dqe == null) {
                    dqe = new n();
                }
            }
        }
        return dqe;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = (Application) context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dqh = com.baidu.swan.config.b.auW().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dqh > 1073741823) {
                this.dqh -= 1073741823;
            } else {
                this.dqh = 1073741823 + this.dqh;
            }
            if (com.baidu.swan.ubc.e.aIh() == null || com.baidu.swan.ubc.e.aIh().St() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aIh().St();
            }
            this.mExecutorService.execute(new g());
            this.dqf = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dpw != null && this.dpw.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, String str2, int i) {
        if (!ab(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dpw != null && this.dpw.tJ(str)) {
                bVar.gn(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ab(String str, int i) {
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
    public synchronized Flow i(String str, String str2, int i) {
        Flow ac;
        ac = ac(str, i);
        if (ac != null && ac.getValid()) {
            d dVar = new d(ac, str2);
            if (this.dpw != null && this.dpw.tJ(str)) {
                dVar.gn(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return ac;
    }

    Flow ac(String str, int i) {
        Flow flow = new Flow(str, this.dqh, i);
        if (this.dpw != null && !this.dpw.aa(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aIh().mj(str)) {
            flow.setValid(false);
        } else {
            if (this.dpw != null && this.dpw.tH(str) > 0) {
                if (new Random().nextInt(100) >= this.dpw.tH(str)) {
                    flow.go(true);
                }
            }
            if (this.dpw != null && this.dpw.tI(str)) {
                flow.setValid(false);
            }
        }
        return flow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.mExecutorService.execute(new f(str, i, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, JSONArray jSONArray) {
        this.mExecutorService.execute(new e(str, i, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.dqi) {
            this.dqi = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dqg != null) {
                        n.this.dqg.aHY();
                    }
                }
            });
        }
    }

    public void b(q qVar) {
        this.mExecutorService.execute(new a(qVar));
    }

    public void initConfig() {
        aIE();
    }

    private void aIE() {
        p aIF = p.aIF();
        aIF.upload();
        aIF.aIG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final JSONArray jSONArray, final String str) {
        s.I(jSONArray);
        this.dqf.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dqg != null) {
                    n.this.dqg.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(final JSONArray jSONArray) {
        s.I(jSONArray);
        this.dqf.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dqg != null) {
                    n.this.dqg.H(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIb() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dqg != null) {
                    n.this.dqg.aIb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aj(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dqg != null) {
                    if (z) {
                        n.this.dqg.tB(str);
                    } else {
                        n.this.dqg.tC(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.dpw = com.baidu.swan.ubc.d.aId();
            n.this.dqg = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dqg.aIc();
        }
    }

    /* loaded from: classes11.dex */
    private class b implements Runnable {
        private i dqm;

        b(String str, String str2, int i) {
            this.dqm = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dqm = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dqm = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dqm = new i(str, str2, i, str3, j, i2);
        }

        public void gn(boolean z) {
            if (this.dqm != null) {
                this.dqm.gn(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                this.dqm.aIx();
                if (!TextUtils.isEmpty(n.this.dpw.tG(this.dqm.getId()))) {
                    this.dqm.setCategory(n.this.dpw.tG(this.dqm.getId()));
                }
                if ((this.dqm.getOption() & 8) != 0) {
                    n.this.dqg.b(this.dqm);
                } else {
                    n.this.dqg.a(this.dqm);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private class d implements Runnable {
        private k dqn;

        d(Flow flow, String str) {
            this.dqn = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aIz());
            this.dqn.bR(flow.getStartTime());
            this.dqn.tP("1");
            n.d(n.this);
        }

        public void gn(boolean z) {
            if (this.dqn != null) {
                this.dqn.gn(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                this.dqn.aIx();
                if (!TextUtils.isEmpty(n.this.dpw.tG(this.dqn.getId()))) {
                    this.dqn.setCategory(n.this.dpw.tG(this.dqn.getId()));
                }
                n.this.dqg.b(this.dqn);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class f implements Runnable {
        private String dpX;
        private int dpY;
        private String mValue;

        f(String str, int i, String str2) {
            this.dpX = str;
            this.dpY = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                n.this.dqg.f(this.dpX, this.dpY, this.mValue);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class e implements Runnable {
        private String dpX;
        private int dpY;
        private JSONArray dqd;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dpX = str;
            this.dpY = i;
            this.dqd = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                n.this.dqg.a(this.dpX, this.dpY, this.mEndTime, this.dqd);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c implements Runnable {
        private String dpX;
        private int dpY;

        c(String str, int i) {
            this.dpX = str;
            this.dpY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                n.this.dqg.G(this.dpX, this.dpY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private q dql;

        a(q qVar) {
            this.dql = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dqg != null) {
                n.this.dqg.a(this.dql);
            }
        }
    }
}
