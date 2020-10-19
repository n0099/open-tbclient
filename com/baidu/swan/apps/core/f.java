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
/* loaded from: classes10.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b cty;

    /* loaded from: classes10.dex */
    public static final class a {
        static final int ctA = com.baidu.swan.apps.t.a.asi().act();
        static final int ctB = com.baidu.swan.apps.t.a.asi().acu();
        static final double ctC = com.baidu.swan.apps.t.a.asi().acv();
        static final boolean ctD = com.baidu.swan.apps.t.a.asi().acw();
        public static final double ctE = com.baidu.swan.apps.t.a.asi().acy();
        public static final double ctF = com.baidu.swan.apps.t.a.asi().acx();
        static final int ctG = com.baidu.swan.apps.t.a.asi().acz();
    }

    private f() {
    }

    public static synchronized void eg(boolean z) {
        synchronized (f.class) {
            if (a.ctD && com.baidu.swan.apps.runtime.d.aCW().abk() != 1) {
                if (z || cty == null) {
                    aiz();
                }
                cty.aiB();
            }
        }
    }

    public static void bi(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bh(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bh(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bh(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bh(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.ctD) {
            synchronized (f.class) {
                if (cty == null) {
                    aiz();
                }
            }
            cty.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.ctD) {
            synchronized (f.class) {
                if (cty == null) {
                    aiz();
                }
            }
            cty.log(str);
        }
    }

    private static synchronized void aiz() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cty != null) {
                cty.cancel();
            }
            cty = new b();
        }
    }

    public static void aiA() {
        if (a.ctD && cty != null) {
            cty.aiA();
        }
    }

    public static void bb(long j) {
        if (a.ctD && cty != null) {
            cty.bb(j);
        }
    }

    public static void bc(long j) {
        if (a.ctD && cty != null) {
            cty.bc(j);
        }
    }

    public static void lY(String str) {
        if (a.ctD && cty != null) {
            cty.lY(str);
        }
    }

    public static void M(String str, int i) {
        if (a.ctD && cty != null) {
            cty.M(str, i);
        }
    }

    public static void h(String str, long j) {
        if (a.ctD && cty != null) {
            cty.h(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b {
        private long ctH;
        private long ctI;
        private boolean ctJ;
        private List<c> ctK;
        private List<c> ctL;
        private List<c> ctM;
        private volatile boolean ctN;
        private String ctO;
        private boolean ctP;
        private Timer mTimer;

        private b() {
            this.ctH = 0L;
            this.ctI = 0L;
            this.ctJ = false;
            this.ctK = new ArrayList();
            this.ctL = new ArrayList();
            this.ctM = new ArrayList();
            this.ctN = a.ctD;
            this.ctO = "";
            this.ctP = false;
        }

        void aiB() {
            if (this.ctN && a.ctA > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.aiF();
                        b.this.aiD();
                        final SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
                        if (ave != null && !ave.isFinishing()) {
                            ave.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void aiG() {
                                    if (b.this.aiC()) {
                                        ave.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.ctA);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean aiC() {
            if (!this.ctP || TextUtils.isEmpty(this.ctO)) {
                return false;
            }
            com.baidu.swan.apps.core.b.f(aiE(), this.ctO);
            this.ctP = false;
            return true;
        }

        void aiA() {
            SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
            if (ave != null && !ave.isFinishing()) {
                StringBuilder append = new StringBuilder(ave.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.ctO) ? "未检测到异常\n" : this.ctO);
                String aiv = com.baidu.swan.apps.core.b.aiv();
                if (!TextUtils.isEmpty(aiv)) {
                    append.append(aiv);
                }
                g.a aVar = new g.a(ave);
                aVar.hK(a.h.swanapp_tip_title).rk(append.toString()).aCE().a(new com.baidu.swan.apps.view.c.a()).fV(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aCH();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aiD() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bb(long j) {
            if (this.ctH == 0) {
                this.ctH = j;
                bd(this.ctH);
            }
        }

        void bc(long j) {
            if (this.ctI == 0) {
                this.ctI = j;
                bd(this.ctI);
            }
        }

        private void bd(long j) {
            if (!this.ctJ) {
                this.ctJ = true;
                long aiE = aiE();
                if (aiE != 0 && j - aiE > a.ctG) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aIz()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cto + "; 网络：正常");
                                        d.bh("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cto + "; 网络：较差");
                                        d.bh("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cto + "; 网络：离线");
                                        d.bh("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cto + "; 网络：未知");
                                        d.bh("fmp_timeout", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        }
                    });
                }
            }
        }

        private long aiE() {
            com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
            if (aDb != null) {
                return aDb.aDe().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void aiF() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.ctN = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.ctK) {
                    cVar2.ctS = currentTimeMillis - cVar2.mStartTime;
                    this.ctL.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.ctM.size()) {
                    c cVar3 = this.ctM.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.ctL.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.ctC) {
                    log(com.baidu.swan.apps.core.a.cts);
                    this.ctP = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.jm("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.ctL.size()) {
                        if (this.ctL.get(i2).ctS > a.ctB) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.ctS + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.ctB));
                        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                            public void onResult(int i6) {
                                switch (i6) {
                                    case 1:
                                        b.this.log(format + "; 网络：正常");
                                        d.bh("request_slow", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                        return;
                                    case 2:
                                        b.this.log(format + "; 网络：较差");
                                        d.bh("request_slow", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(format + "; 网络：离线");
                                        d.bh("request_slow", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(format + "; 网络：未知");
                                        d.bh("request_slow", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        });
                    }
                    this.ctK.clear();
                    this.ctL.clear();
                    this.ctM.clear();
                }
            }
        }

        synchronized void lY(String str) {
            if (this.ctN) {
                this.ctK.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void M(String str, int i) {
            if (this.ctN) {
                this.ctM.add(new c(str, 0L, 0L, i));
                lZ(str);
            }
        }

        synchronized void h(String str, long j) {
            if (this.ctN) {
                this.ctL.add(new c(str, 0L, j));
                lZ(str);
            }
        }

        private void lZ(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ctK.size()) {
                    if (TextUtils.equals(this.ctK.get(i2).mUrl, str)) {
                        this.ctK.remove(this.ctK.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.ctP = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.ctO += j.g(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            aiD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class c {
        long ctS;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.ctS = j2;
            this.mErrCode = i;
        }
    }
}
