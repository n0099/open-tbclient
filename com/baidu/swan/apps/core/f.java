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
/* loaded from: classes25.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b cMZ;

    /* loaded from: classes25.dex */
    public static final class a {
        static final int cNb = com.baidu.swan.apps.t.a.azd().ajn();
        static final int cNc = com.baidu.swan.apps.t.a.azd().ajo();
        static final double cNd = com.baidu.swan.apps.t.a.azd().ajp();
        static final boolean cNe = com.baidu.swan.apps.t.a.azd().ajq();
        public static final double cNf = com.baidu.swan.apps.t.a.azd().ajs();
        public static final double cNg = com.baidu.swan.apps.t.a.azd().ajr();
        static final int cNh = com.baidu.swan.apps.t.a.azd().ajt();
    }

    private f() {
    }

    public static synchronized void eU(boolean z) {
        synchronized (f.class) {
            if (a.cNe && com.baidu.swan.apps.runtime.d.aJQ().aie() != 1) {
                if (z || cMZ == null) {
                    apu();
                }
                cMZ.apw();
            }
        }
    }

    public static void bv(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bu(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bu(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bu(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bu(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cNe) {
            synchronized (f.class) {
                if (cMZ == null) {
                    apu();
                }
            }
            cMZ.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cNe) {
            synchronized (f.class) {
                if (cMZ == null) {
                    apu();
                }
            }
            cMZ.log(str);
        }
    }

    private static synchronized void apu() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cMZ != null) {
                cMZ.cancel();
            }
            cMZ = new b();
        }
    }

    public static void apv() {
        if (a.cNe && cMZ != null) {
            cMZ.apv();
        }
    }

    public static void bY(long j) {
        if (a.cNe && cMZ != null) {
            cMZ.bY(j);
        }
    }

    public static void bZ(long j) {
        if (a.cNe && cMZ != null) {
            cMZ.bZ(j);
        }
    }

    public static void nh(String str) {
        if (a.cNe && cMZ != null) {
            cMZ.nh(str);
        }
    }

    public static void P(String str, int i) {
        if (a.cNe && cMZ != null) {
            cMZ.P(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cNe && cMZ != null) {
            cMZ.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static final class b {
        private long cNi;
        private long cNj;
        private boolean cNk;
        private List<c> cNl;
        private List<c> cNm;
        private List<c> cNn;
        private volatile boolean cNo;
        private String cNp;
        private boolean cNq;
        private Timer mTimer;

        private b() {
            this.cNi = 0L;
            this.cNj = 0L;
            this.cNk = false;
            this.cNl = new ArrayList();
            this.cNm = new ArrayList();
            this.cNn = new ArrayList();
            this.cNo = a.cNe;
            this.cNp = "";
            this.cNq = false;
        }

        void apw() {
            if (this.cNo && a.cNb > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.apz();
                        b.this.apy();
                        final SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
                        if (aBZ != null && !aBZ.isFinishing()) {
                            aBZ.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void apA() {
                                    if (b.this.apx()) {
                                        aBZ.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cNb);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean apx() {
            if (!this.cNq || TextUtils.isEmpty(this.cNp)) {
                return false;
            }
            com.baidu.swan.apps.core.b.i(getLaunchTime(), this.cNp);
            this.cNq = false;
            return true;
        }

        void apv() {
            SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
            if (aBZ != null && !aBZ.isFinishing()) {
                StringBuilder append = new StringBuilder(aBZ.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cNp) ? "未检测到异常\n" : this.cNp);
                String apq = com.baidu.swan.apps.core.b.apq();
                if (!TextUtils.isEmpty(apq)) {
                    append.append(apq);
                }
                g.a aVar = new g.a(aBZ);
                aVar.iz(a.h.swanapp_tip_title).st(append.toString()).aJy().a(new com.baidu.swan.apps.view.c.a()).gJ(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aJB();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void apy() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bY(long j) {
            if (this.cNi == 0) {
                this.cNi = j;
                ca(this.cNi);
            }
        }

        void bZ(long j) {
            if (this.cNj == 0) {
                this.cNj = j;
                ca(this.cNj);
            }
        }

        private void ca(long j) {
            if (!this.cNk) {
                this.cNk = true;
                long launchTime = getLaunchTime();
                if (launchTime != 0 && j - launchTime > a.cNh) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aPs()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cMR + "; 网络：正常");
                                        d.bu("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cMR + "; 网络：较差");
                                        d.bu("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cMR + "; 网络：离线");
                                        d.bu("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cMR + "; 网络：未知");
                                        d.bu("fmp_timeout", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        }
                    });
                }
            }
        }

        private long getLaunchTime() {
            com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
            if (aJV != null) {
                return aJV.aJY().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void apz() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.cNo = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cNl) {
                    cVar2.cNt = currentTimeMillis - cVar2.mStartTime;
                    this.cNm.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cNn.size()) {
                    c cVar3 = this.cNn.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cNm.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cNd) {
                    log(com.baidu.swan.apps.core.a.cMU);
                    this.cNq = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.kt("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cNm.size()) {
                        if (this.cNm.get(i2).cNt > a.cNc) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cNt + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cNc));
                        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                            public void onResult(int i6) {
                                switch (i6) {
                                    case 1:
                                        b.this.log(format + "; 网络：正常");
                                        d.bu("request_slow", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                        return;
                                    case 2:
                                        b.this.log(format + "; 网络：较差");
                                        d.bu("request_slow", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(format + "; 网络：离线");
                                        d.bu("request_slow", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(format + "; 网络：未知");
                                        d.bu("request_slow", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        });
                    }
                    this.cNl.clear();
                    this.cNm.clear();
                    this.cNn.clear();
                }
            }
        }

        synchronized void nh(String str) {
            if (this.cNo) {
                this.cNl.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void P(String str, int i) {
            if (this.cNo) {
                this.cNn.add(new c(str, 0L, 0L, i));
                ni(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cNo) {
                this.cNm.add(new c(str, 0L, j));
                ni(str);
            }
        }

        private void ni(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cNl.size()) {
                    if (TextUtils.equals(this.cNl.get(i2).mUrl, str)) {
                        this.cNl.remove(this.cNl.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cNq = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cNp += j.j(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            apy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static final class c {
        long cNt;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cNt = j2;
            this.mErrCode = i;
        }
    }
}
