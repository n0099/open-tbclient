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
/* loaded from: classes10.dex */
public class n {
    private static volatile n dJS;
    private ExecutorService dJT;
    private com.baidu.swan.ubc.c dJU;
    private int dJV;
    private boolean dJW = false;
    private com.baidu.swan.ubc.d dJk;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dJV;
        nVar.dJV = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aWb() {
        if (dJS == null) {
            synchronized (n.class) {
                if (dJS == null) {
                    dJS = new n();
                }
            }
        }
        return dJS;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dJV = com.baidu.swan.config.b.aGZ().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dJV > 1073741823) {
                this.dJV -= 1073741823;
            } else {
                this.dJV = 1073741823 + this.dJV;
            }
            if (com.baidu.swan.ubc.e.aVF() == null || com.baidu.swan.ubc.e.aVF().aac() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aVF().aac();
            }
            this.mExecutorService.execute(new g());
            this.dJT = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dJk != null && this.dJk.xg(str)) {
                bVar.hi(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dJk != null && this.dJk.xg(str)) {
                bVar.hi(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    boolean ae(String str, int i) {
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
        Flow af;
        af = af(str, i);
        if (af != null && af.getValid()) {
            d dVar = new d(af, str2);
            if (this.dJk != null && this.dJk.xg(str)) {
                dVar.hi(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return af;
    }

    Flow af(String str, int i) {
        Flow flow = new Flow(str, this.dJV, i);
        if (this.dJk != null && !this.dJk.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aVF().oR(str)) {
            flow.setValid(false);
        } else {
            if (this.dJk != null && this.dJk.xe(str) > 0) {
                if (new Random().nextInt(100) >= this.dJk.xe(str)) {
                    flow.hj(true);
                }
            }
            if (this.dJk != null && this.dJk.xf(str)) {
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
    public void H(String str, int i) {
        this.mExecutorService.execute(new c(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void upload() {
        if (!this.dJW) {
            this.dJW = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dJU != null) {
                        n.this.dJU.aVw();
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
        this.dJT.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJU != null) {
                    n.this.dJU.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.dJT.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJU != null) {
                    n.this.dJU.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJU != null) {
                    n.this.dJU.aVz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJU != null) {
                    if (z) {
                        n.this.dJU.wY(str);
                    } else {
                        n.this.dJU.wZ(str);
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
            n.this.dJk = com.baidu.swan.ubc.d.aVB();
            n.this.dJU = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dJU.aVA();
        }
    }

    /* loaded from: classes10.dex */
    private class b implements Runnable {
        private i dKb;

        b(String str, String str2, int i) {
            this.dKb = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dKb = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dKb = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dKb = new i(str, str2, i, str3, j, i2);
        }

        public void hi(boolean z) {
            if (this.dKb != null) {
                this.dKb.hi(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                this.dKb.aVV();
                if (!TextUtils.isEmpty(n.this.dJk.xd(this.dKb.getId()))) {
                    this.dKb.setCategory(n.this.dJk.xd(this.dKb.getId()));
                }
                if ((this.dKb.getOption() & 8) != 0) {
                    n.this.dJU.b(this.dKb);
                } else {
                    n.this.dJU.a(this.dKb);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private class d implements Runnable {
        private k dKc;

        d(Flow flow, String str) {
            this.dKc = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aVX());
            this.dKc.cq(flow.getStartTime());
            this.dKc.xm("1");
            n.d(n.this);
        }

        public void hi(boolean z) {
            if (this.dKc != null) {
                this.dKc.hi(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                this.dKc.aVV();
                if (!TextUtils.isEmpty(n.this.dJk.xd(this.dKc.getId()))) {
                    this.dKc.setCategory(n.this.dJk.xd(this.dKc.getId()));
                }
                n.this.dJU.b(this.dKc);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class f implements Runnable {
        private String dJL;
        private int dJM;
        private String mValue;

        f(String str, int i, String str2) {
            this.dJL = str;
            this.dJM = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                n.this.dJU.f(this.dJL, this.dJM, this.mValue);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class e implements Runnable {
        private String dJL;
        private int dJM;
        private JSONArray dJR;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dJL = str;
            this.dJM = i;
            this.dJR = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                n.this.dJU.a(this.dJL, this.dJM, this.mEndTime, this.dJR);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class c implements Runnable {
        private String dJL;
        private int dJM;

        c(String str, int i) {
            this.dJL = str;
            this.dJM = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                n.this.dJU.H(this.dJL, this.dJM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private q dKa;

        a(q qVar) {
            this.dKa = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJU != null) {
                n.this.dJU.a(this.dKa);
            }
        }
    }
}
