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
    private static b cff;

    /* loaded from: classes8.dex */
    public static final class a {
        static final int cfh = com.baidu.swan.apps.t.a.aoM().YY();
        static final int cfi = com.baidu.swan.apps.t.a.aoM().YZ();
        static final double cfj = com.baidu.swan.apps.t.a.aoM().Za();
        static final boolean cfk = com.baidu.swan.apps.t.a.aoM().Zb();
        public static final double cfl = com.baidu.swan.apps.t.a.aoM().Zd();
        public static final double cfm = com.baidu.swan.apps.t.a.aoM().Zc();
        static final int cfn = com.baidu.swan.apps.t.a.aoM().Ze();
    }

    private f() {
    }

    public static synchronized void dM(boolean z) {
        synchronized (f.class) {
            if (a.cfk && com.baidu.swan.apps.runtime.d.azE().XP() != 1) {
                if (z || cff == null) {
                    afe();
                }
                cff.afg();
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
        if (a.cfk) {
            synchronized (f.class) {
                if (cff == null) {
                    afe();
                }
            }
            cff.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cfk) {
            synchronized (f.class) {
                if (cff == null) {
                    afe();
                }
            }
            cff.log(str);
        }
    }

    private static synchronized void afe() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cff != null) {
                cff.cancel();
            }
            cff = new b();
        }
    }

    public static void aff() {
        if (a.cfk && cff != null) {
            cff.aff();
        }
    }

    public static void aS(long j) {
        if (a.cfk && cff != null) {
            cff.aS(j);
        }
    }

    public static void aT(long j) {
        if (a.cfk && cff != null) {
            cff.aT(j);
        }
    }

    public static void kT(String str) {
        if (a.cfk && cff != null) {
            cff.kT(str);
        }
    }

    public static void L(String str, int i) {
        if (a.cfk && cff != null) {
            cff.L(str, i);
        }
    }

    public static void h(String str, long j) {
        if (a.cfk && cff != null) {
            cff.h(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class b {
        private long cfo;
        private long cfp;
        private boolean cfq;
        private List<c> cfr;
        private List<c> cfs;
        private List<c> cft;
        private volatile boolean cfu;
        private String cfv;
        private boolean cfw;
        private Timer mTimer;

        private b() {
            this.cfo = 0L;
            this.cfp = 0L;
            this.cfq = false;
            this.cfr = new ArrayList();
            this.cfs = new ArrayList();
            this.cft = new ArrayList();
            this.cfu = a.cfk;
            this.cfv = "";
            this.cfw = false;
        }

        void afg() {
            if (this.cfu && a.cfh > 0) {
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
                }, a.cfh);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean afh() {
            if (!this.cfw || TextUtils.isEmpty(this.cfv)) {
                return false;
            }
            com.baidu.swan.apps.core.b.e(afj(), this.cfv);
            this.cfw = false;
            return true;
        }

        void aff() {
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (arI != null && !arI.isFinishing()) {
                StringBuilder append = new StringBuilder(arI.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cfv) ? "未检测到异常\n" : this.cfv);
                String afa = com.baidu.swan.apps.core.b.afa();
                if (!TextUtils.isEmpty(afa)) {
                    append.append(afa);
                }
                g.a aVar = new g.a(arI);
                aVar.he(a.h.swanapp_tip_title).qf(append.toString()).azm().a(new com.baidu.swan.apps.view.c.a()).fB(false);
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
            if (this.cfo == 0) {
                this.cfo = j;
                aU(this.cfo);
            }
        }

        void aT(long j) {
            if (this.cfp == 0) {
                this.cfp = j;
                aU(this.cfp);
            }
        }

        private void aU(long j) {
            if (!this.cfq) {
                this.cfq = true;
                long afj = afj();
                if (afj != 0 && j - afj > a.cfn) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aFg()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.ceW + "; 网络：正常");
                                        d.bc("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.ceW + "; 网络：较差");
                                        d.bc("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.ceW + "; 网络：离线");
                                        d.bc("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.ceW + "; 网络：未知");
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
                this.cfu = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cfr) {
                    cVar2.cfz = currentTimeMillis - cVar2.mStartTime;
                    this.cfs.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cft.size()) {
                    c cVar3 = this.cft.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cfs.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cfj) {
                    log(com.baidu.swan.apps.core.a.ceZ);
                    this.cfw = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.ir("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cfs.size()) {
                        if (this.cfs.get(i2).cfz > a.cfi) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cfz + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cfi));
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
                    this.cfr.clear();
                    this.cfs.clear();
                    this.cft.clear();
                }
            }
        }

        synchronized void kT(String str) {
            if (this.cfu) {
                this.cfr.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void L(String str, int i) {
            if (this.cfu) {
                this.cft.add(new c(str, 0L, 0L, i));
                kU(str);
            }
        }

        synchronized void h(String str, long j) {
            if (this.cfu) {
                this.cfs.add(new c(str, 0L, j));
                kU(str);
            }
        }

        private void kU(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cfr.size()) {
                    if (TextUtils.equals(this.cfr.get(i2).mUrl, str)) {
                        this.cfr.remove(this.cfr.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cfw = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cfv += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
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
        long cfz;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cfz = j2;
            this.mErrCode = i;
        }
    }
}
