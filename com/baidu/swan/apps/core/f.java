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
/* loaded from: classes9.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b cPw;

    /* loaded from: classes9.dex */
    public static final class a {
        static final int cPy = com.baidu.swan.apps.t.a.awZ().aha();
        static final int cPz = com.baidu.swan.apps.t.a.awZ().ahb();
        static final double cPA = com.baidu.swan.apps.t.a.awZ().ahc();
        static final boolean cPB = com.baidu.swan.apps.t.a.awZ().ahd();
        public static final double cPC = com.baidu.swan.apps.t.a.awZ().ahf();
        public static final double cPD = com.baidu.swan.apps.t.a.awZ().ahe();
        static final int cPE = com.baidu.swan.apps.t.a.awZ().ahg();
    }

    private f() {
    }

    public static synchronized void fb(boolean z) {
        synchronized (f.class) {
            if (a.cPB && com.baidu.swan.apps.runtime.d.aIG().getFrameType() != 1) {
                if (z || cPw == null) {
                    ank();
                }
                cPw.anm();
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
        if (a.cPB) {
            synchronized (f.class) {
                if (cPw == null) {
                    ank();
                }
            }
            cPw.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cPB) {
            synchronized (f.class) {
                if (cPw == null) {
                    ank();
                }
            }
            cPw.log(str);
        }
    }

    private static synchronized void ank() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cPw != null) {
                cPw.cancel();
            }
            cPw = new b();
        }
    }

    public static void anl() {
        if (a.cPB && cPw != null) {
            cPw.anl();
        }
    }

    public static void cf(long j) {
        if (a.cPB && cPw != null) {
            cPw.cf(j);
        }
    }

    public static void cg(long j) {
        if (a.cPB && cPw != null) {
            cPw.cg(j);
        }
    }

    public static void mh(String str) {
        if (a.cPB && cPw != null) {
            cPw.mh(str);
        }
    }

    public static void S(String str, int i) {
        if (a.cPB && cPw != null) {
            cPw.S(str, i);
        }
    }

    public static void i(String str, long j) {
        if (a.cPB && cPw != null) {
            cPw.i(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class b {
        private long cPF;
        private long cPG;
        private boolean cPH;
        private List<c> cPI;
        private List<c> cPJ;
        private List<c> cPK;
        private volatile boolean cPL;
        private String cPM;
        private boolean cPN;
        private Timer mTimer;

        private b() {
            this.cPF = 0L;
            this.cPG = 0L;
            this.cPH = false;
            this.cPI = new ArrayList();
            this.cPJ = new ArrayList();
            this.cPK = new ArrayList();
            this.cPL = a.cPB;
            this.cPM = "";
            this.cPN = false;
        }

        void anm() {
            if (this.cPL && a.cPy > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.anp();
                        b.this.ano();
                        final SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
                        if (azV != null && !azV.isFinishing()) {
                            azV.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void anq() {
                                    if (b.this.ann()) {
                                        azV.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cPy);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ann() {
            if (!this.cPN || TextUtils.isEmpty(this.cPM)) {
                return false;
            }
            com.baidu.swan.apps.core.b.i(getLaunchTime(), this.cPM);
            this.cPN = false;
            return true;
        }

        void anl() {
            SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
            if (azV != null && !azV.isFinishing()) {
                StringBuilder append = new StringBuilder(azV.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cPM) ? "未检测到异常\n" : this.cPM);
                String ang = com.baidu.swan.apps.core.b.ang();
                if (!TextUtils.isEmpty(ang)) {
                    append.append(ang);
                }
                g.a aVar = new g.a(azV);
                aVar.gR(a.h.swanapp_tip_title).rx(append.toString()).aHT().a(new com.baidu.swan.apps.view.c.a()).gT(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aHX();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ano() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void cf(long j) {
            if (this.cPF == 0) {
                this.cPF = j;
                ch(this.cPF);
            }
        }

        void cg(long j) {
            if (this.cPG == 0) {
                this.cPG = j;
                ch(this.cPG);
            }
        }

        private void ch(long j) {
            if (!this.cPH) {
                this.cPH = true;
                long launchTime = getLaunchTime();
                if (launchTime != 0 && j - launchTime > a.cPE) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aOj()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cPo + "; 网络：正常");
                                        d.bm("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cPo + "; 网络：较差");
                                        d.bm("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cPo + "; 网络：离线");
                                        d.bm("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cPo + "; 网络：未知");
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
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            if (aIL != null) {
                return aIL.aIO().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void anp() {
            c cVar;
            int i;
            this.cPL = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (c cVar2 : this.cPI) {
                cVar2.cPQ = currentTimeMillis - cVar2.mStartTime;
                this.cPJ.add(cVar2);
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.cPK.size()) {
                c cVar3 = this.cPK.get(i2);
                i2++;
                i3 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i3 : i3 + 1;
            }
            int size = this.cPJ.size();
            if (i3 > 0) {
                log("检查request状况，总请求次数：" + (i3 + size) + ", 失败次数: " + i3);
            }
            if (i3 / (size + i3) >= a.cPA) {
                log(com.baidu.swan.apps.core.a.cPr);
                this.cPN = true;
                com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                d.report("request_fail");
            } else {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.cPJ.size()) {
                    if (this.cPJ.get(i4).cPQ > a.cPz) {
                        try {
                            log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cPQ + "ms");
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
                    final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cPz));
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
                this.cPI.clear();
                this.cPJ.clear();
                this.cPK.clear();
            }
        }

        synchronized void mh(String str) {
            if (this.cPL) {
                this.cPI.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void S(String str, int i) {
            if (this.cPL) {
                this.cPK.add(new c(str, 0L, 0L, i));
                mi(str);
            }
        }

        synchronized void i(String str, long j) {
            if (this.cPL) {
                this.cPJ.add(new c(str, 0L, j));
                mi(str);
            }
        }

        private void mi(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cPI.size()) {
                    if (TextUtils.equals(this.cPI.get(i2).mUrl, str)) {
                        this.cPI.remove(this.cPI.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cPN = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cPM += j.j(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            ano();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class c {
        long cPQ;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cPQ = j2;
            this.mErrCode = i;
        }
    }
}
