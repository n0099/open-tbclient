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
    private static volatile n dJO;
    private ExecutorService dJP;
    private com.baidu.swan.ubc.c dJQ;
    private int dJR;
    private boolean dJS = false;
    private com.baidu.swan.ubc.d dJg;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dJR;
        nVar.dJR = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aWb() {
        if (dJO == null) {
            synchronized (n.class) {
                if (dJO == null) {
                    dJO = new n();
                }
            }
        }
        return dJO;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dJR = com.baidu.swan.config.b.aGZ().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dJR > 1073741823) {
                this.dJR -= 1073741823;
            } else {
                this.dJR = 1073741823 + this.dJR;
            }
            if (com.baidu.swan.ubc.e.aVF() == null || com.baidu.swan.ubc.e.aVF().aac() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aVF().aac();
            }
            this.mExecutorService.execute(new g());
            this.dJP = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dJg != null && this.dJg.xf(str)) {
                bVar.hh(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dJg != null && this.dJg.xf(str)) {
                bVar.hh(true);
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
            if (this.dJg != null && this.dJg.xf(str)) {
                dVar.hh(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return af;
    }

    Flow af(String str, int i) {
        Flow flow = new Flow(str, this.dJR, i);
        if (this.dJg != null && !this.dJg.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aVF().oQ(str)) {
            flow.setValid(false);
        } else {
            if (this.dJg != null && this.dJg.xd(str) > 0) {
                if (new Random().nextInt(100) >= this.dJg.xd(str)) {
                    flow.hi(true);
                }
            }
            if (this.dJg != null && this.dJg.xe(str)) {
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
        if (!this.dJS) {
            this.dJS = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dJQ != null) {
                        n.this.dJQ.aVw();
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
        this.dJP.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJQ != null) {
                    n.this.dJQ.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.dJP.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJQ != null) {
                    n.this.dJQ.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJQ != null) {
                    n.this.dJQ.aVz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dJQ != null) {
                    if (z) {
                        n.this.dJQ.wX(str);
                    } else {
                        n.this.dJQ.wY(str);
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
            n.this.dJg = com.baidu.swan.ubc.d.aVB();
            n.this.dJQ = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dJQ.aVA();
        }
    }

    /* loaded from: classes10.dex */
    private class b implements Runnable {
        private i dJX;

        b(String str, String str2, int i) {
            this.dJX = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dJX = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dJX = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dJX = new i(str, str2, i, str3, j, i2);
        }

        public void hh(boolean z) {
            if (this.dJX != null) {
                this.dJX.hh(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                this.dJX.aVV();
                if (!TextUtils.isEmpty(n.this.dJg.xc(this.dJX.getId()))) {
                    this.dJX.setCategory(n.this.dJg.xc(this.dJX.getId()));
                }
                if ((this.dJX.getOption() & 8) != 0) {
                    n.this.dJQ.b(this.dJX);
                } else {
                    n.this.dJQ.a(this.dJX);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private class d implements Runnable {
        private k dJY;

        d(Flow flow, String str) {
            this.dJY = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aVX());
            this.dJY.cq(flow.getStartTime());
            this.dJY.xl("1");
            n.d(n.this);
        }

        public void hh(boolean z) {
            if (this.dJY != null) {
                this.dJY.hh(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                this.dJY.aVV();
                if (!TextUtils.isEmpty(n.this.dJg.xc(this.dJY.getId()))) {
                    this.dJY.setCategory(n.this.dJg.xc(this.dJY.getId()));
                }
                n.this.dJQ.b(this.dJY);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class f implements Runnable {
        private String dJH;
        private int dJI;
        private String mValue;

        f(String str, int i, String str2) {
            this.dJH = str;
            this.dJI = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                n.this.dJQ.f(this.dJH, this.dJI, this.mValue);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class e implements Runnable {
        private String dJH;
        private int dJI;
        private JSONArray dJN;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dJH = str;
            this.dJI = i;
            this.dJN = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                n.this.dJQ.a(this.dJH, this.dJI, this.mEndTime, this.dJN);
            }
        }
    }

    /* loaded from: classes10.dex */
    private class c implements Runnable {
        private String dJH;
        private int dJI;

        c(String str, int i) {
            this.dJH = str;
            this.dJI = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                n.this.dJQ.H(this.dJH, this.dJI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private q dJW;

        a(q qVar) {
            this.dJW = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dJQ != null) {
                n.this.dJQ.a(this.dJW);
            }
        }
    }
}
