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
    private static b cRU;

    /* loaded from: classes9.dex */
    public static final class a {
        static final int cRW = com.baidu.swan.apps.t.a.aAu().akv();
        static final int cRX = com.baidu.swan.apps.t.a.aAu().akw();
        static final double cRY = com.baidu.swan.apps.t.a.aAu().akx();
        static final boolean cRZ = com.baidu.swan.apps.t.a.aAu().aky();
        public static final double cSa = com.baidu.swan.apps.t.a.aAu().akA();
        public static final double cSb = com.baidu.swan.apps.t.a.aAu().akz();
        static final int cSc = com.baidu.swan.apps.t.a.aAu().akB();
    }

    private f() {
    }

    public static synchronized void fd(boolean z) {
        synchronized (f.class) {
            if (a.cRZ && com.baidu.swan.apps.runtime.d.aMg().ajk() != 1) {
                if (z || cRU == null) {
                    aqG();
                }
                cRU.aqI();
            }
        }
    }

    public static void bu(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bt(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bt(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bt(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bt(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cRZ) {
            synchronized (f.class) {
                if (cRU == null) {
                    aqG();
                }
            }
            cRU.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cRZ) {
            synchronized (f.class) {
                if (cRU == null) {
                    aqG();
                }
            }
            cRU.log(str);
        }
    }

    private static synchronized void aqG() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cRU != null) {
                cRU.cancel();
            }
            cRU = new b();
        }
    }

    public static void aqH() {
        if (a.cRZ && cRU != null) {
            cRU.aqH();
        }
    }

    public static void bZ(long j) {
        if (a.cRZ && cRU != null) {
            cRU.bZ(j);
        }
    }

    public static void ca(long j) {
        if (a.cRZ && cRU != null) {
            cRU.ca(j);
        }
    }

    public static void na(String str) {
        if (a.cRZ && cRU != null) {
            cRU.na(str);
        }
    }

    public static void Q(String str, int i) {
        if (a.cRZ && cRU != null) {
            cRU.Q(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cRZ && cRU != null) {
            cRU.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class b {
        private long cSd;
        private long cSe;
        private boolean cSf;
        private List<c> cSg;
        private List<c> cSh;
        private List<c> cSi;
        private volatile boolean cSj;
        private String cSk;
        private boolean cSl;
        private Timer mTimer;

        private b() {
            this.cSd = 0L;
            this.cSe = 0L;
            this.cSf = false;
            this.cSg = new ArrayList();
            this.cSh = new ArrayList();
            this.cSi = new ArrayList();
            this.cSj = a.cRZ;
            this.cSk = "";
            this.cSl = false;
        }

        void aqI() {
            if (this.cSj && a.cRW > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.aqL();
                        b.this.aqK();
                        final SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
                        if (aDq != null && !aDq.isFinishing()) {
                            aDq.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void aqM() {
                                    if (b.this.aqJ()) {
                                        aDq.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cRW);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean aqJ() {
            if (!this.cSl || TextUtils.isEmpty(this.cSk)) {
                return false;
            }
            com.baidu.swan.apps.core.b.h(getLaunchTime(), this.cSk);
            this.cSl = false;
            return true;
        }

        void aqH() {
            SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
            if (aDq != null && !aDq.isFinishing()) {
                StringBuilder append = new StringBuilder(aDq.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cSk) ? "未检测到异常\n" : this.cSk);
                String aqC = com.baidu.swan.apps.core.b.aqC();
                if (!TextUtils.isEmpty(aqC)) {
                    append.append(aqC);
                }
                g.a aVar = new g.a(aDq);
                aVar.iu(a.h.swanapp_tip_title).sp(append.toString()).aLt().a(new com.baidu.swan.apps.view.c.a()).gV(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aLx();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aqK() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bZ(long j) {
            if (this.cSd == 0) {
                this.cSd = j;
                cb(this.cSd);
            }
        }

        void ca(long j) {
            if (this.cSe == 0) {
                this.cSe = j;
                cb(this.cSe);
            }
        }

        private void cb(long j) {
            if (!this.cSf) {
                this.cSf = true;
                long launchTime = getLaunchTime();
                if (launchTime != 0 && j - launchTime > a.cSc) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aRJ()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cRM + "; 网络：正常");
                                        d.bt("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cRM + "; 网络：较差");
                                        d.bt("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cRM + "; 网络：离线");
                                        d.bt("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cRM + "; 网络：未知");
                                        d.bt("fmp_timeout", "unknown");
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
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            if (aMl != null) {
                return aMl.aMo().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void aqL() {
            c cVar;
            int i;
            this.cSj = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (c cVar2 : this.cSg) {
                cVar2.cSo = currentTimeMillis - cVar2.mStartTime;
                this.cSh.add(cVar2);
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.cSi.size()) {
                c cVar3 = this.cSi.get(i2);
                i2++;
                i3 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i3 : i3 + 1;
            }
            int size = this.cSh.size();
            if (i3 > 0) {
                log("检查request状况，总请求次数：" + (i3 + size) + ", 失败次数: " + i3);
            }
            if (i3 / (size + i3) >= a.cRY) {
                log(com.baidu.swan.apps.core.a.cRP);
                this.cSl = true;
                com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                d.report("request_fail");
            } else {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.cSh.size()) {
                    if (this.cSh.get(i4).cSo > a.cRX) {
                        try {
                            log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cSo + "ms");
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
                    final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cRX));
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i6) {
                            switch (i6) {
                                case 1:
                                    b.this.log(format + "; 网络：正常");
                                    d.bt("request_slow", FrsActivityConfig.GOOD);
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                    return;
                                case 2:
                                    b.this.log(format + "; 网络：较差");
                                    d.bt("request_slow", "bad");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                case 3:
                                    b.this.log(format + "; 网络：离线");
                                    d.bt("request_slow", "offline");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                    return;
                                default:
                                    b.this.log(format + "; 网络：未知");
                                    d.bt("request_slow", "unknown");
                                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                    return;
                            }
                        }
                    });
                }
                this.cSg.clear();
                this.cSh.clear();
                this.cSi.clear();
            }
        }

        synchronized void na(String str) {
            if (this.cSj) {
                this.cSg.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void Q(String str, int i) {
            if (this.cSj) {
                this.cSi.add(new c(str, 0L, 0L, i));
                nb(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cSj) {
                this.cSh.add(new c(str, 0L, j));
                nb(str);
            }
        }

        private void nb(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cSg.size()) {
                    if (TextUtils.equals(this.cSg.get(i2).mUrl, str)) {
                        this.cSg.remove(this.cSg.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cSl = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cSk += j.i(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            aqK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class c {
        long cSo;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cSo = j2;
            this.mErrCode = i;
        }
    }
}
