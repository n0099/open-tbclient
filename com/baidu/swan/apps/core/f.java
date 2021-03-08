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
    private static b cQW;

    /* loaded from: classes8.dex */
    public static final class a {
        static final int cQY = com.baidu.swan.apps.t.a.axc().ahd();
        static final int cQZ = com.baidu.swan.apps.t.a.axc().ahe();
        static final double cRa = com.baidu.swan.apps.t.a.axc().ahf();
        static final boolean cRb = com.baidu.swan.apps.t.a.axc().ahg();
        public static final double cRc = com.baidu.swan.apps.t.a.axc().ahi();
        public static final double cRd = com.baidu.swan.apps.t.a.axc().ahh();
        static final int cRe = com.baidu.swan.apps.t.a.axc().ahj();
    }

    private f() {
    }

    public static synchronized void fb(boolean z) {
        synchronized (f.class) {
            if (a.cRb && com.baidu.swan.apps.runtime.d.aIJ().getFrameType() != 1) {
                if (z || cQW == null) {
                    ann();
                }
                cQW.anp();
            }
        }
    }

    public static void bn(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bm(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bm(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bm(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bm(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cRb) {
            synchronized (f.class) {
                if (cQW == null) {
                    ann();
                }
            }
            cQW.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cRb) {
            synchronized (f.class) {
                if (cQW == null) {
                    ann();
                }
            }
            cQW.log(str);
        }
    }

    private static synchronized void ann() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cQW != null) {
                cQW.cancel();
            }
            cQW = new b();
        }
    }

    public static void ano() {
        if (a.cRb && cQW != null) {
            cQW.ano();
        }
    }

    public static void cf(long j) {
        if (a.cRb && cQW != null) {
            cQW.cf(j);
        }
    }

    public static void cg(long j) {
        if (a.cRb && cQW != null) {
            cQW.cg(j);
        }
    }

    public static void mo(String str) {
        if (a.cRb && cQW != null) {
            cQW.mo(str);
        }
    }

    public static void T(String str, int i) {
        if (a.cRb && cQW != null) {
            cQW.T(str, i);
        }
    }

    public static void i(String str, long j) {
        if (a.cRb && cQW != null) {
            cQW.i(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class b {
        private long cRf;
        private long cRg;
        private boolean cRh;
        private List<c> cRi;
        private List<c> cRj;
        private List<c> cRk;
        private volatile boolean cRl;
        private String cRm;
        private boolean cRn;
        private Timer mTimer;

        private b() {
            this.cRf = 0L;
            this.cRg = 0L;
            this.cRh = false;
            this.cRi = new ArrayList();
            this.cRj = new ArrayList();
            this.cRk = new ArrayList();
            this.cRl = a.cRb;
            this.cRm = "";
            this.cRn = false;
        }

        void anp() {
            if (this.cRl && a.cQY > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.ans();
                        b.this.anr();
                        final SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
                        if (azY != null && !azY.isFinishing()) {
                            azY.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void ant() {
                                    if (b.this.anq()) {
                                        azY.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cQY);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean anq() {
            if (!this.cRn || TextUtils.isEmpty(this.cRm)) {
                return false;
            }
            com.baidu.swan.apps.core.b.i(getLaunchTime(), this.cRm);
            this.cRn = false;
            return true;
        }

        void ano() {
            SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
            if (azY != null && !azY.isFinishing()) {
                StringBuilder append = new StringBuilder(azY.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cRm) ? "未检测到异常\n" : this.cRm);
                String anj = com.baidu.swan.apps.core.b.anj();
                if (!TextUtils.isEmpty(anj)) {
                    append.append(anj);
                }
                g.a aVar = new g.a(azY);
                aVar.gS(a.h.swanapp_tip_title).rE(append.toString()).aHW().a(new com.baidu.swan.apps.view.c.a()).gT(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aIa();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void anr() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void cf(long j) {
            if (this.cRf == 0) {
                this.cRf = j;
                ch(this.cRf);
            }
        }

        void cg(long j) {
            if (this.cRg == 0) {
                this.cRg = j;
                ch(this.cRg);
            }
        }

        private void ch(long j) {
            if (!this.cRh) {
                this.cRh = true;
                long launchTime = getLaunchTime();
                if (launchTime != 0 && j - launchTime > a.cRe) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aOm()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cQO + "; 网络：正常");
                                        d.bm("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cQO + "; 网络：较差");
                                        d.bm("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cQO + "; 网络：离线");
                                        d.bm("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cQO + "; 网络：未知");
                                        d.bm("fmp_timeout", "unknown");
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
            com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
            if (aIO != null) {
                return aIO.aIR().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void ans() {
            c cVar;
            int i;
            this.cRl = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (c cVar2 : this.cRi) {
                cVar2.cRq = currentTimeMillis - cVar2.mStartTime;
                this.cRj.add(cVar2);
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.cRk.size()) {
                c cVar3 = this.cRk.get(i2);
                i2++;
                i3 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i3 : i3 + 1;
            }
            int size = this.cRj.size();
            if (i3 > 0) {
                log("检查request状况，总请求次数：" + (i3 + size) + ", 失败次数: " + i3);
            }
            if (i3 / (size + i3) >= a.cRa) {
                log(com.baidu.swan.apps.core.a.cQR);
                this.cRn = true;
                com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                d.report("request_fail");
            } else {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.cRj.size()) {
                    if (this.cRj.get(i4).cRq > a.cQZ) {
                        try {
                            log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cRq + "ms");
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
                    final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cQZ));
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i6) {
                            switch (i6) {
                                case 1:
                                    b.this.log(format + "; 网络：正常");
                                    d.bm("request_slow", FrsActivityConfig.GOOD);
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                    return;
                                case 2:
                                    b.this.log(format + "; 网络：较差");
                                    d.bm("request_slow", "bad");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                case 3:
                                    b.this.log(format + "; 网络：离线");
                                    d.bm("request_slow", "offline");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                default:
                                    b.this.log(format + "; 网络：未知");
                                    d.bm("request_slow", "unknown");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                    return;
                            }
                        }
                    });
                }
                this.cRi.clear();
                this.cRj.clear();
                this.cRk.clear();
            }
        }

        synchronized void mo(String str) {
            if (this.cRl) {
                this.cRi.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void T(String str, int i) {
            if (this.cRl) {
                this.cRk.add(new c(str, 0L, 0L, i));
                mp(str);
            }
        }

        synchronized void i(String str, long j) {
            if (this.cRl) {
                this.cRj.add(new c(str, 0L, j));
                mp(str);
            }
        }

        private void mp(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cRi.size()) {
                    if (TextUtils.equals(this.cRi.get(i2).mUrl, str)) {
                        this.cRi.remove(this.cRi.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cRn = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cRm += j.j(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            anr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class c {
        long cRq;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cRq = j2;
            this.mErrCode = i;
        }
    }
}
