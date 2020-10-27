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
    private static b cBW;

    /* loaded from: classes10.dex */
    public static final class a {
        static final int cBY = com.baidu.swan.apps.t.a.aud().aen();
        static final int cBZ = com.baidu.swan.apps.t.a.aud().aeo();
        static final double cCa = com.baidu.swan.apps.t.a.aud().aep();
        static final boolean cCb = com.baidu.swan.apps.t.a.aud().aeq();
        public static final double cCc = com.baidu.swan.apps.t.a.aud().aes();
        public static final double cCd = com.baidu.swan.apps.t.a.aud().aer();
        static final int cCe = com.baidu.swan.apps.t.a.aud().aet();
    }

    private f() {
    }

    public static synchronized void et(boolean z) {
        synchronized (f.class) {
            if (a.cCb && com.baidu.swan.apps.runtime.d.aEQ().ade() != 1) {
                if (z || cBW == null) {
                    akt();
                }
                cBW.akv();
            }
        }
    }

    public static void bp(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bo(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bo(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bo(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bo(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cCb) {
            synchronized (f.class) {
                if (cBW == null) {
                    akt();
                }
            }
            cBW.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cCb) {
            synchronized (f.class) {
                if (cBW == null) {
                    akt();
                }
            }
            cBW.log(str);
        }
    }

    private static synchronized void akt() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cBW != null) {
                cBW.cancel();
            }
            cBW = new b();
        }
    }

    public static void aku() {
        if (a.cCb && cBW != null) {
            cBW.aku();
        }
    }

    public static void bd(long j) {
        if (a.cCb && cBW != null) {
            cBW.bd(j);
        }
    }

    public static void be(long j) {
        if (a.cCb && cBW != null) {
            cBW.be(j);
        }
    }

    public static void mr(String str) {
        if (a.cCb && cBW != null) {
            cBW.mr(str);
        }
    }

    public static void M(String str, int i) {
        if (a.cCb && cBW != null) {
            cBW.M(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cCb && cBW != null) {
            cBW.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b {
        private long cCf;
        private long cCg;
        private boolean cCh;
        private List<c> cCi;
        private List<c> cCj;
        private List<c> cCk;
        private volatile boolean cCl;
        private String cCm;
        private boolean cCn;
        private Timer mTimer;

        private b() {
            this.cCf = 0L;
            this.cCg = 0L;
            this.cCh = false;
            this.cCi = new ArrayList();
            this.cCj = new ArrayList();
            this.cCk = new ArrayList();
            this.cCl = a.cCb;
            this.cCm = "";
            this.cCn = false;
        }

        void akv() {
            if (this.cCl && a.cBY > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.akz();
                        b.this.akx();
                        final SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
                        if (awY != null && !awY.isFinishing()) {
                            awY.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void akA() {
                                    if (b.this.akw()) {
                                        awY.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cBY);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean akw() {
            if (!this.cCn || TextUtils.isEmpty(this.cCm)) {
                return false;
            }
            com.baidu.swan.apps.core.b.f(aky(), this.cCm);
            this.cCn = false;
            return true;
        }

        void aku() {
            SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
            if (awY != null && !awY.isFinishing()) {
                StringBuilder append = new StringBuilder(awY.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cCm) ? "未检测到异常\n" : this.cCm);
                String akp = com.baidu.swan.apps.core.b.akp();
                if (!TextUtils.isEmpty(akp)) {
                    append.append(akp);
                }
                g.a aVar = new g.a(awY);
                aVar.hV(a.h.swanapp_tip_title).rD(append.toString()).aEy().a(new com.baidu.swan.apps.view.c.a()).gi(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aEB();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void akx() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bd(long j) {
            if (this.cCf == 0) {
                this.cCf = j;
                bf(this.cCf);
            }
        }

        void be(long j) {
            if (this.cCg == 0) {
                this.cCg = j;
                bf(this.cCg);
            }
        }

        private void bf(long j) {
            if (!this.cCh) {
                this.cCh = true;
                long aky = aky();
                if (aky != 0 && j - aky > a.cCe) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aKt()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cBO + "; 网络：正常");
                                        d.bo("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cBO + "; 网络：较差");
                                        d.bo("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cBO + "; 网络：离线");
                                        d.bo("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cBO + "; 网络：未知");
                                        d.bo("fmp_timeout", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        }
                    });
                }
            }
        }

        private long aky() {
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            if (aEV != null) {
                return aEV.aEY().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void akz() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.cCl = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cCi) {
                    cVar2.cCq = currentTimeMillis - cVar2.mStartTime;
                    this.cCj.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cCk.size()) {
                    c cVar3 = this.cCk.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cCj.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cCa) {
                    log(com.baidu.swan.apps.core.a.cBR);
                    this.cCn = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.jF("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cCj.size()) {
                        if (this.cCj.get(i2).cCq > a.cBZ) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cCq + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cBZ));
                        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                            public void onResult(int i6) {
                                switch (i6) {
                                    case 1:
                                        b.this.log(format + "; 网络：正常");
                                        d.bo("request_slow", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                        return;
                                    case 2:
                                        b.this.log(format + "; 网络：较差");
                                        d.bo("request_slow", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(format + "; 网络：离线");
                                        d.bo("request_slow", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(format + "; 网络：未知");
                                        d.bo("request_slow", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        });
                    }
                    this.cCi.clear();
                    this.cCj.clear();
                    this.cCk.clear();
                }
            }
        }

        synchronized void mr(String str) {
            if (this.cCl) {
                this.cCi.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void M(String str, int i) {
            if (this.cCl) {
                this.cCk.add(new c(str, 0L, 0L, i));
                ms(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cCl) {
                this.cCj.add(new c(str, 0L, j));
                ms(str);
            }
        }

        private void ms(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cCi.size()) {
                    if (TextUtils.equals(this.cCi.get(i2).mUrl, str)) {
                        this.cCi.remove(this.cCi.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cCn = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cCm += j.g(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            akx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class c {
        long cCq;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cCq = j2;
            this.mErrCode = i;
        }
    }
}
