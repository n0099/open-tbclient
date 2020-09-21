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
/* loaded from: classes14.dex */
public class n {
    private static volatile n dLW;
    private ExecutorService dLX;
    private com.baidu.swan.ubc.c dLY;
    private int dLZ;
    private com.baidu.swan.ubc.d dLo;
    private boolean dMa = false;
    private Context mContext;
    private ExecutorService mExecutorService;

    static /* synthetic */ int d(n nVar) {
        int i = nVar.dLZ;
        nVar.dLZ = i + 1;
        return i;
    }

    private n() {
        init(com.baidu.swan.ubc.e.getContext());
    }

    public static n aWN() {
        if (dLW == null) {
            synchronized (n.class) {
                if (dLW == null) {
                    dLW = new n();
                }
            }
        }
        return dLW;
    }

    private void init(Context context) {
        if (this.mContext == null && context != null) {
            if (context instanceof Application) {
                this.mContext = context;
            } else {
                this.mContext = context.getApplicationContext();
            }
            this.dLZ = com.baidu.swan.config.b.aHJ().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            if (this.dLZ > 1073741823) {
                this.dLZ -= 1073741823;
            } else {
                this.dLZ = 1073741823 + this.dLZ;
            }
            if (com.baidu.swan.ubc.e.aWr() == null || com.baidu.swan.ubc.e.aWr().aaL() == null) {
                this.mExecutorService = Executors.newSingleThreadExecutor();
            } else {
                this.mExecutorService = com.baidu.swan.ubc.e.aWr().aaL();
            }
            this.mExecutorService.execute(new g());
            this.dLX = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, jSONObject, i);
            if (this.dLo != null && this.dLo.xz(str)) {
                bVar.hg(true);
            }
            this.mExecutorService.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str, String str2, int i) {
        if (!ae(str, i)) {
            b bVar = new b(str, str2, i);
            if (this.dLo != null && this.dLo.xz(str)) {
                bVar.hg(true);
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
            if (this.dLo != null && this.dLo.xz(str)) {
                dVar.hg(true);
            }
            this.mExecutorService.execute(dVar);
        }
        return af;
    }

    Flow af(String str, int i) {
        Flow flow = new Flow(str, this.dLZ, i);
        if (this.dLo != null && !this.dLo.ad(str, i)) {
            flow.setValid(false);
        } else if ((i & 16) != 0 && !com.baidu.swan.ubc.e.aWr().pk(str)) {
            flow.setValid(false);
        } else {
            if (this.dLo != null && this.dLo.xx(str) > 0) {
                if (new Random().nextInt(100) >= this.dLo.xx(str)) {
                    flow.hh(true);
                }
            }
            if (this.dLo != null && this.dLo.xy(str)) {
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
        if (!this.dMa) {
            this.dMa = true;
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.dLY != null) {
                        n.this.dLY.aWi();
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
        this.dLX.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dLY != null) {
                    n.this.dLY.d(jSONArray, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(final JSONArray jSONArray) {
        s.L(jSONArray);
        this.dLX.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dLY != null) {
                    n.this.dLY.K(jSONArray);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWl() {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dLY != null) {
                    n.this.dLY.aWl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ao(final String str, final boolean z) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.swan.ubc.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.dLY != null) {
                    if (z) {
                        n.this.dLY.xr(str);
                    } else {
                        n.this.dLY.xs(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.dLo = com.baidu.swan.ubc.d.aWn();
            n.this.dLY = new com.baidu.swan.ubc.c(n.this.mContext);
            n.this.dLY.aWm();
        }
    }

    /* loaded from: classes14.dex */
    private class b implements Runnable {
        private i dMf;

        b(String str, String str2, int i) {
            this.dMf = new i(str, str2, i);
        }

        b(String str, JSONObject jSONObject, int i) {
            this.dMf = new i(str, jSONObject, i);
        }

        b(String str, String str2, int i, String str3, int i2) {
            this.dMf = new i(str, str2, i, str3, i2);
        }

        b(String str, String str2, int i, String str3, long j, int i2) {
            this.dMf = new i(str, str2, i, str3, j, i2);
        }

        public void hg(boolean z) {
            if (this.dMf != null) {
                this.dMf.hg(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                this.dMf.aWH();
                if (!TextUtils.isEmpty(n.this.dLo.xw(this.dMf.getId()))) {
                    this.dMf.setCategory(n.this.dLo.xw(this.dMf.getId()));
                }
                if ((this.dMf.getOption() & 8) != 0) {
                    n.this.dLY.b(this.dMf);
                } else {
                    n.this.dLY.a(this.dMf);
                }
            }
        }
    }

    /* loaded from: classes14.dex */
    private class d implements Runnable {
        private k dMg;

        d(Flow flow, String str) {
            this.dMg = new k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.aWJ());
            this.dMg.cr(flow.getStartTime());
            this.dMg.xF("1");
            n.d(n.this);
        }

        public void hg(boolean z) {
            if (this.dMg != null) {
                this.dMg.hg(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                this.dMg.aWH();
                if (!TextUtils.isEmpty(n.this.dLo.xw(this.dMg.getId()))) {
                    this.dMg.setCategory(n.this.dLo.xw(this.dMg.getId()));
                }
                n.this.dLY.b(this.dMg);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class f implements Runnable {
        private String dLP;
        private int dLQ;
        private String mValue;

        f(String str, int i, String str2) {
            this.dLP = str;
            this.dLQ = i;
            this.mValue = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                n.this.dLY.f(this.dLP, this.dLQ, this.mValue);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class e implements Runnable {
        private String dLP;
        private int dLQ;
        private JSONArray dLV;
        private long mEndTime = System.currentTimeMillis();

        e(String str, int i, JSONArray jSONArray) {
            this.dLP = str;
            this.dLQ = i;
            this.dLV = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                n.this.dLY.a(this.dLP, this.dLQ, this.mEndTime, this.dLV);
            }
        }
    }

    /* loaded from: classes14.dex */
    private class c implements Runnable {
        private String dLP;
        private int dLQ;

        c(String str, int i) {
            this.dLP = str;
            this.dLQ = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                n.this.dLY.H(this.dLP, this.dLQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a implements Runnable {
        private q dMe;

        a(q qVar) {
            this.dMe = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.dLY != null) {
                n.this.dLY.a(this.dMe);
            }
        }
    }
}
