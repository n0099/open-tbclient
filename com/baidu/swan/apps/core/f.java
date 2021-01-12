package com.baidu.swan.apps.core;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.j;
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
    private static b cNi;

    /* loaded from: classes8.dex */
    public static final class a {
        static final int cNk = com.baidu.swan.apps.t.a.awB().agC();
        static final int cNl = com.baidu.swan.apps.t.a.awB().agD();
        static final double cNm = com.baidu.swan.apps.t.a.awB().agE();
        static final boolean cNn = com.baidu.swan.apps.t.a.awB().agF();
        public static final double cNo = com.baidu.swan.apps.t.a.awB().agH();
        public static final double cNp = com.baidu.swan.apps.t.a.awB().agG();
        static final int cNq = com.baidu.swan.apps.t.a.awB().agI();
    }

    private f() {
    }

    public static synchronized void eZ(boolean z) {
        synchronized (f.class) {
            if (a.cNn && com.baidu.swan.apps.runtime.d.aIn().afr() != 1) {
                if (z || cNi == null) {
                    amM();
                }
                cNi.amO();
            }
        }
    }

    public static void bt(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bs(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bs(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bs(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bs(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cNn) {
            synchronized (f.class) {
                if (cNi == null) {
                    amM();
                }
            }
            cNi.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cNn) {
            synchronized (f.class) {
                if (cNi == null) {
                    amM();
                }
            }
            cNi.log(str);
        }
    }

    private static synchronized void amM() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cNi != null) {
                cNi.cancel();
            }
            cNi = new b();
        }
    }

    public static void amN() {
        if (a.cNn && cNi != null) {
            cNi.amN();
        }
    }

    public static void bZ(long j) {
        if (a.cNn && cNi != null) {
            cNi.bZ(j);
        }
    }

    public static void ca(long j) {
        if (a.cNn && cNi != null) {
            cNi.ca(j);
        }
    }

    public static void lP(String str) {
        if (a.cNn && cNi != null) {
            cNi.lP(str);
        }
    }

    public static void Q(String str, int i) {
        if (a.cNn && cNi != null) {
            cNi.Q(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cNn && cNi != null) {
            cNi.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class b {
        private long cNr;
        private long cNs;
        private boolean cNt;
        private List<c> cNu;
        private List<c> cNv;
        private List<c> cNw;
        private volatile boolean cNx;
        private String cNy;
        private boolean cNz;
        private Timer mTimer;

        private b() {
            this.cNr = 0L;
            this.cNs = 0L;
            this.cNt = false;
            this.cNu = new ArrayList();
            this.cNv = new ArrayList();
            this.cNw = new ArrayList();
            this.cNx = a.cNn;
            this.cNy = "";
            this.cNz = false;
        }

        void amO() {
            if (this.cNx && a.cNk > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.amR();
                        b.this.amQ();
                        final SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
                        if (azx != null && !azx.isFinishing()) {
                            azx.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void amS() {
                                    if (b.this.amP()) {
                                        azx.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cNk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean amP() {
            if (!this.cNz || TextUtils.isEmpty(this.cNy)) {
                return false;
            }
            com.baidu.swan.apps.core.b.h(getLaunchTime(), this.cNy);
            this.cNz = false;
            return true;
        }

        void amN() {
            SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
            if (azx != null && !azx.isFinishing()) {
                StringBuilder append = new StringBuilder(azx.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cNy) ? "未检测到异常\n" : this.cNy);
                String amI = com.baidu.swan.apps.core.b.amI();
                if (!TextUtils.isEmpty(amI)) {
                    append.append(amI);
                }
                g.a aVar = new g.a(azx);
                aVar.gO(a.h.swanapp_tip_title).re(append.toString()).aHA().a(new com.baidu.swan.apps.view.c.a()).gR(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aHE();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void amQ() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bZ(long j) {
            if (this.cNr == 0) {
                this.cNr = j;
                cb(this.cNr);
            }
        }

        void ca(long j) {
            if (this.cNs == 0) {
                this.cNs = j;
                cb(this.cNs);
            }
        }

        private void cb(long j) {
            if (!this.cNt) {
                this.cNt = true;
                long launchTime = getLaunchTime();
                if (launchTime != 0 && j - launchTime > a.cNq) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aNQ()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cNa + "; 网络：正常");
                                        d.bs("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cNa + "; 网络：较差");
                                        d.bs("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cNa + "; 网络：离线");
                                        d.bs("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cNa + "; 网络：未知");
                                        d.bs("fmp_timeout", "unknown");
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
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            if (aIs != null) {
                return aIs.aIv().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void amR() {
            c cVar;
            int i;
            this.cNx = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (c cVar2 : this.cNu) {
                cVar2.cNC = currentTimeMillis - cVar2.mStartTime;
                this.cNv.add(cVar2);
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.cNw.size()) {
                c cVar3 = this.cNw.get(i2);
                i2++;
                i3 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i3 : i3 + 1;
            }
            int size = this.cNv.size();
            if (i3 > 0) {
                log("检查request状况，总请求次数：" + (i3 + size) + ", 失败次数: " + i3);
            }
            if (i3 / (size + i3) >= a.cNm) {
                log(com.baidu.swan.apps.core.a.cNd);
                this.cNz = true;
                com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                d.report("request_fail");
            } else {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.cNv.size()) {
                    if (this.cNv.get(i4).cNC > a.cNl) {
                        try {
                            log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cNC + "ms");
                        } catch (MalformedURLException e) {
                            if (f.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                        i = i5 + 1;
                    } else {
                        i = i5;
                    }
                    i4++;
                    i5 = i;
                }
                if (i5 >= 2) {
                    final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cNl));
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i6) {
                            switch (i6) {
                                case 1:
                                    b.this.log(format + "; 网络：正常");
                                    d.bs("request_slow", FrsActivityConfig.GOOD);
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                    return;
                                case 2:
                                    b.this.log(format + "; 网络：较差");
                                    d.bs("request_slow", "bad");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                case 3:
                                    b.this.log(format + "; 网络：离线");
                                    d.bs("request_slow", "offline");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                default:
                                    b.this.log(format + "; 网络：未知");
                                    d.bs("request_slow", "unknown");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                    return;
                            }
                        }
                    });
                }
                this.cNu.clear();
                this.cNv.clear();
                this.cNw.clear();
            }
        }

        synchronized void lP(String str) {
            if (this.cNx) {
                this.cNu.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void Q(String str, int i) {
            if (this.cNx) {
                this.cNw.add(new c(str, 0L, 0L, i));
                lQ(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cNx) {
                this.cNv.add(new c(str, 0L, j));
                lQ(str);
            }
        }

        private void lQ(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cNu.size()) {
                    if (TextUtils.equals(this.cNu.get(i2).mUrl, str)) {
                        this.cNu.remove(this.cNu.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cNz = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cNy += j.i(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            amQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class c {
        long cNC;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cNC = j2;
            this.mErrCode = i;
        }
    }
}
