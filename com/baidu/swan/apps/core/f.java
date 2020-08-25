package com.baidu.swan.apps.core;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b cfb;

    /* loaded from: classes8.dex */
    public static final class a {
        static final int cfd = com.baidu.swan.apps.t.a.aoM().YY();
        static final int cfe = com.baidu.swan.apps.t.a.aoM().YZ();
        static final double cff = com.baidu.swan.apps.t.a.aoM().Za();
        static final boolean cfg = com.baidu.swan.apps.t.a.aoM().Zb();
        public static final double cfh = com.baidu.swan.apps.t.a.aoM().Zd();
        public static final double cfi = com.baidu.swan.apps.t.a.aoM().Zc();
        static final int cfj = com.baidu.swan.apps.t.a.aoM().Ze();
    }

    private f() {
    }

    public static synchronized void dL(boolean z) {
        synchronized (f.class) {
            if (a.cfg && com.baidu.swan.apps.runtime.d.azE().XP() != 1) {
                if (z || cfb == null) {
                    afe();
                }
                cfb.afg();
            }
        }
    }

    public static void bd(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bc(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bc(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bc(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bc(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cfg) {
            synchronized (f.class) {
                if (cfb == null) {
                    afe();
                }
            }
            cfb.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cfg) {
            synchronized (f.class) {
                if (cfb == null) {
                    afe();
                }
            }
            cfb.log(str);
        }
    }

    private static synchronized void afe() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cfb != null) {
                cfb.cancel();
            }
            cfb = new b();
        }
    }

    public static void aff() {
        if (a.cfg && cfb != null) {
            cfb.aff();
        }
    }

    public static void aS(long j) {
        if (a.cfg && cfb != null) {
            cfb.aS(j);
        }
    }

    public static void aT(long j) {
        if (a.cfg && cfb != null) {
            cfb.aT(j);
        }
    }

    public static void kS(String str) {
        if (a.cfg && cfb != null) {
            cfb.kS(str);
        }
    }

    public static void L(String str, int i) {
        if (a.cfg && cfb != null) {
            cfb.L(str, i);
        }
    }

    public static void h(String str, long j) {
        if (a.cfg && cfb != null) {
            cfb.h(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class b {
        private long cfk;
        private long cfl;
        private boolean cfm;
        private List<c> cfn;
        private List<c> cfo;
        private List<c> cfp;
        private volatile boolean cfq;
        private String cfr;
        private boolean cfs;
        private Timer mTimer;

        private b() {
            this.cfk = 0L;
            this.cfl = 0L;
            this.cfm = false;
            this.cfn = new ArrayList();
            this.cfo = new ArrayList();
            this.cfp = new ArrayList();
            this.cfq = a.cfg;
            this.cfr = "";
            this.cfs = false;
        }

        void afg() {
            if (this.cfq && a.cfd > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.afk();
                        b.this.afi();
                        final SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
                        if (arI != null && !arI.isFinishing()) {
                            arI.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void afl() {
                                    if (b.this.afh()) {
                                        arI.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cfd);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean afh() {
            if (!this.cfs || TextUtils.isEmpty(this.cfr)) {
                return false;
            }
            com.baidu.swan.apps.core.b.e(afj(), this.cfr);
            this.cfs = false;
            return true;
        }

        void aff() {
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (arI != null && !arI.isFinishing()) {
                StringBuilder append = new StringBuilder(arI.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cfr) ? "未检测到异常\n" : this.cfr);
                String afa = com.baidu.swan.apps.core.b.afa();
                if (!TextUtils.isEmpty(afa)) {
                    append.append(afa);
                }
                g.a aVar = new g.a(arI);
                aVar.he(a.h.swanapp_tip_title).qe(append.toString()).azm().a(new com.baidu.swan.apps.view.c.a()).fA(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.azp();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void afi() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void aS(long j) {
            if (this.cfk == 0) {
                this.cfk = j;
                aU(this.cfk);
            }
        }

        void aT(long j) {
            if (this.cfl == 0) {
                this.cfl = j;
                aU(this.cfl);
            }
        }

        private void aU(long j) {
            if (!this.cfm) {
                this.cfm = true;
                long afj = afj();
                if (afj != 0 && j - afj > a.cfj) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aFg()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.ceS + "; 网络：正常");
                                        d.bc("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.ceS + "; 网络：较差");
                                        d.bc("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.ceS + "; 网络：离线");
                                        d.bc("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.ceS + "; 网络：未知");
                                        d.bc("fmp_timeout", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        }
                    });
                }
            }
        }

        private long afj() {
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            if (azJ != null) {
                return azJ.azM().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void afk() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.cfq = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cfn) {
                    cVar2.cfv = currentTimeMillis - cVar2.mStartTime;
                    this.cfo.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cfp.size()) {
                    c cVar3 = this.cfp.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cfo.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cff) {
                    log(com.baidu.swan.apps.core.a.ceV);
                    this.cfs = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.iq("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cfo.size()) {
                        if (this.cfo.get(i2).cfv > a.cfe) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cfv + "ms");
                            } catch (MalformedURLException e) {
                                if (f.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                            i = i5 + 1;
                        } else {
                            i = i5;
                        }
                        i2++;
                        i5 = i;
                    }
                    if (i5 >= 2) {
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cfe));
                        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                            public void onResult(int i6) {
                                switch (i6) {
                                    case 1:
                                        b.this.log(format + "; 网络：正常");
                                        d.bc("request_slow", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                        return;
                                    case 2:
                                        b.this.log(format + "; 网络：较差");
                                        d.bc("request_slow", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(format + "; 网络：离线");
                                        d.bc("request_slow", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(format + "; 网络：未知");
                                        d.bc("request_slow", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        });
                    }
                    this.cfn.clear();
                    this.cfo.clear();
                    this.cfp.clear();
                }
            }
        }

        synchronized void kS(String str) {
            if (this.cfq) {
                this.cfn.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void L(String str, int i) {
            if (this.cfq) {
                this.cfp.add(new c(str, 0L, 0L, i));
                kT(str);
            }
        }

        synchronized void h(String str, long j) {
            if (this.cfq) {
                this.cfo.add(new c(str, 0L, j));
                kT(str);
            }
        }

        private void kT(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cfn.size()) {
                    if (TextUtils.equals(this.cfn.get(i2).mUrl, str)) {
                        this.cfn.remove(this.cfn.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cfs = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cfr += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            afi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class c {
        long cfv;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cfv = j2;
            this.mErrCode = i;
        }
    }
}
