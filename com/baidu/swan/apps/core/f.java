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
/* loaded from: classes3.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b chg;

    /* loaded from: classes3.dex */
    public static final class a {
        static final int chi = com.baidu.swan.apps.t.a.apx().ZH();
        static final int chj = com.baidu.swan.apps.t.a.apx().ZI();
        static final double chk = com.baidu.swan.apps.t.a.apx().ZJ();
        static final boolean chl = com.baidu.swan.apps.t.a.apx().ZK();
        public static final double chm = com.baidu.swan.apps.t.a.apx().ZM();
        public static final double chn = com.baidu.swan.apps.t.a.apx().ZL();
        static final int cho = com.baidu.swan.apps.t.a.apx().ZN();
    }

    private f() {
    }

    public static synchronized void dK(boolean z) {
        synchronized (f.class) {
            if (a.chl && com.baidu.swan.apps.runtime.d.aAn().Yy() != 1) {
                if (z || chg == null) {
                    afO();
                }
                chg.afQ();
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
        if (a.chl) {
            synchronized (f.class) {
                if (chg == null) {
                    afO();
                }
            }
            chg.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.chl) {
            synchronized (f.class) {
                if (chg == null) {
                    afO();
                }
            }
            chg.log(str);
        }
    }

    private static synchronized void afO() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (chg != null) {
                chg.cancel();
            }
            chg = new b();
        }
    }

    public static void afP() {
        if (a.chl && chg != null) {
            chg.afP();
        }
    }

    public static void aT(long j) {
        if (a.chl && chg != null) {
            chg.aT(j);
        }
    }

    public static void aU(long j) {
        if (a.chl && chg != null) {
            chg.aU(j);
        }
    }

    public static void lm(String str) {
        if (a.chl && chg != null) {
            chg.lm(str);
        }
    }

    public static void L(String str, int i) {
        if (a.chl && chg != null) {
            chg.L(str, i);
        }
    }

    public static void h(String str, long j) {
        if (a.chl && chg != null) {
            chg.h(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {
        private long chp;
        private long chq;
        private boolean chr;
        private List<c> chs;
        private List<c> cht;
        private List<c> chu;
        private volatile boolean chv;
        private String chw;
        private boolean chx;
        private Timer mTimer;

        private b() {
            this.chp = 0L;
            this.chq = 0L;
            this.chr = false;
            this.chs = new ArrayList();
            this.cht = new ArrayList();
            this.chu = new ArrayList();
            this.chv = a.chl;
            this.chw = "";
            this.chx = false;
        }

        void afQ() {
            if (this.chv && a.chi > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.afU();
                        b.this.afS();
                        final SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
                        if (ast != null && !ast.isFinishing()) {
                            ast.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void afV() {
                                    if (b.this.afR()) {
                                        ast.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.chi);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean afR() {
            if (!this.chx || TextUtils.isEmpty(this.chw)) {
                return false;
            }
            com.baidu.swan.apps.core.b.e(afT(), this.chw);
            this.chx = false;
            return true;
        }

        void afP() {
            SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
            if (ast != null && !ast.isFinishing()) {
                StringBuilder append = new StringBuilder(ast.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.chw) ? "未检测到异常\n" : this.chw);
                String afK = com.baidu.swan.apps.core.b.afK();
                if (!TextUtils.isEmpty(afK)) {
                    append.append(afK);
                }
                g.a aVar = new g.a(ast);
                aVar.hn(a.h.swanapp_tip_title).qy(append.toString()).azV().a(new com.baidu.swan.apps.view.c.a()).fz(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.azY();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void afS() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void aT(long j) {
            if (this.chp == 0) {
                this.chp = j;
                aV(this.chp);
            }
        }

        void aU(long j) {
            if (this.chq == 0) {
                this.chq = j;
                aV(this.chq);
            }
        }

        private void aV(long j) {
            if (!this.chr) {
                this.chr = true;
                long afT = afT();
                if (afT != 0 && j - afT > a.cho) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aFQ()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cgX + "; 网络：正常");
                                        d.bc("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cgX + "; 网络：较差");
                                        d.bc("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cgX + "; 网络：离线");
                                        d.bc("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cgX + "; 网络：未知");
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

        private long afT() {
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            if (aAs != null) {
                return aAs.aAv().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void afU() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.chv = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.chs) {
                    cVar2.chA = currentTimeMillis - cVar2.mStartTime;
                    this.cht.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.chu.size()) {
                    c cVar3 = this.chu.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cht.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.chk) {
                    log(com.baidu.swan.apps.core.a.cha);
                    this.chx = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.iK("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cht.size()) {
                        if (this.cht.get(i2).chA > a.chj) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.chA + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.chj));
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
                    this.chs.clear();
                    this.cht.clear();
                    this.chu.clear();
                }
            }
        }

        synchronized void lm(String str) {
            if (this.chv) {
                this.chs.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void L(String str, int i) {
            if (this.chv) {
                this.chu.add(new c(str, 0L, 0L, i));
                ln(str);
            }
        }

        synchronized void h(String str, long j) {
            if (this.chv) {
                this.cht.add(new c(str, 0L, j));
                ln(str);
            }
        }

        private void ln(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.chs.size()) {
                    if (TextUtils.equals(this.chs.get(i2).mUrl, str)) {
                        this.chs.remove(this.chs.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.chx = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.chw += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            afS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {
        long chA;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.chA = j2;
            this.mErrCode = i;
        }
    }
}
