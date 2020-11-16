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
/* loaded from: classes7.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b cGf;

    /* loaded from: classes7.dex */
    public static final class a {
        static final int cGh = com.baidu.swan.apps.t.a.avV().agf();
        static final int cGi = com.baidu.swan.apps.t.a.avV().agg();
        static final double cGj = com.baidu.swan.apps.t.a.avV().agh();
        static final boolean cGk = com.baidu.swan.apps.t.a.avV().agi();
        public static final double cGl = com.baidu.swan.apps.t.a.avV().agk();
        public static final double cGm = com.baidu.swan.apps.t.a.avV().agj();
        static final int cGn = com.baidu.swan.apps.t.a.avV().agl();
    }

    private f() {
    }

    public static synchronized void eF(boolean z) {
        synchronized (f.class) {
            if (a.cGk && com.baidu.swan.apps.runtime.d.aGI().aeW() != 1) {
                if (z || cGf == null) {
                    aml();
                }
                cGf.amn();
            }
        }
    }

    public static void bo(final String str, final String str2) {
        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        f.log(str2 + "; 网络：正常");
                        d.bn(str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                    case 2:
                        f.log(str2 + "; 网络：较差");
                        d.bn(str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        f.log(str2 + "; 网络：离线");
                        d.bn(str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        f.log(str2 + "; 网络：未知");
                        d.bn(str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                        return;
                }
            }
        });
    }

    public static void a(SwanAppNetworkUtils.a aVar) {
        if (a.cGk) {
            synchronized (f.class) {
                if (cGf == null) {
                    aml();
                }
            }
            cGf.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cGk) {
            synchronized (f.class) {
                if (cGf == null) {
                    aml();
                }
            }
            cGf.log(str);
        }
    }

    private static synchronized void aml() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cGf != null) {
                cGf.cancel();
            }
            cGf = new b();
        }
    }

    public static void amm() {
        if (a.cGk && cGf != null) {
            cGf.amm();
        }
    }

    public static void bz(long j) {
        if (a.cGk && cGf != null) {
            cGf.bz(j);
        }
    }

    public static void bA(long j) {
        if (a.cGk && cGf != null) {
            cGf.bA(j);
        }
    }

    public static void mA(String str) {
        if (a.cGk && cGf != null) {
            cGf.mA(str);
        }
    }

    public static void O(String str, int i) {
        if (a.cGk && cGf != null) {
            cGf.O(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cGk && cGf != null) {
            cGf.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b {
        private long cGo;
        private long cGp;
        private boolean cGq;
        private List<c> cGr;
        private List<c> cGs;
        private List<c> cGt;
        private volatile boolean cGu;
        private String cGv;
        private boolean cGw;
        private Timer mTimer;

        private b() {
            this.cGo = 0L;
            this.cGp = 0L;
            this.cGq = false;
            this.cGr = new ArrayList();
            this.cGs = new ArrayList();
            this.cGt = new ArrayList();
            this.cGu = a.cGk;
            this.cGv = "";
            this.cGw = false;
        }

        void amn() {
            if (this.cGu && a.cGh > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.amr();
                        b.this.amp();
                        final SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
                        if (ayQ != null && !ayQ.isFinishing()) {
                            ayQ.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void ams() {
                                    if (b.this.amo()) {
                                        ayQ.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cGh);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean amo() {
            if (!this.cGw || TextUtils.isEmpty(this.cGv)) {
                return false;
            }
            com.baidu.swan.apps.core.b.g(amq(), this.cGv);
            this.cGw = false;
            return true;
        }

        void amm() {
            SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
            if (ayQ != null && !ayQ.isFinishing()) {
                StringBuilder append = new StringBuilder(ayQ.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cGv) ? "未检测到异常\n" : this.cGv);
                String amh = com.baidu.swan.apps.core.b.amh();
                if (!TextUtils.isEmpty(amh)) {
                    append.append(amh);
                }
                g.a aVar = new g.a(ayQ);
                aVar.ib(a.h.swanapp_tip_title).rL(append.toString()).aGq().a(new com.baidu.swan.apps.view.c.a()).gu(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aGt();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void amp() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bz(long j) {
            if (this.cGo == 0) {
                this.cGo = j;
                bB(this.cGo);
            }
        }

        void bA(long j) {
            if (this.cGp == 0) {
                this.cGp = j;
                bB(this.cGp);
            }
        }

        private void bB(long j) {
            if (!this.cGq) {
                this.cGq = true;
                long amq = amq();
                if (amq != 0 && j - amq > a.cGn) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aMl()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cFX + "; 网络：正常");
                                        d.bn("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cFX + "; 网络：较差");
                                        d.bn("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cFX + "; 网络：离线");
                                        d.bn("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cFX + "; 网络：未知");
                                        d.bn("fmp_timeout", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        }
                    });
                }
            }
        }

        private long amq() {
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            if (aGN != null) {
                return aGN.aGQ().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void amr() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.cGu = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cGr) {
                    cVar2.cGz = currentTimeMillis - cVar2.mStartTime;
                    this.cGs.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cGt.size()) {
                    c cVar3 = this.cGt.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cGs.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cGj) {
                    log(com.baidu.swan.apps.core.a.cGa);
                    this.cGw = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.jM("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cGs.size()) {
                        if (this.cGs.get(i2).cGz > a.cGi) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cGz + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cGi));
                        a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.4
                            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                            public void onResult(int i6) {
                                switch (i6) {
                                    case 1:
                                        b.this.log(format + "; 网络：正常");
                                        d.bn("request_slow", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_slow);
                                        return;
                                    case 2:
                                        b.this.log(format + "; 网络：较差");
                                        d.bn("request_slow", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(format + "; 网络：离线");
                                        d.bn("request_slow", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(format + "; 网络：未知");
                                        d.bn("request_slow", "unknown");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                }
                            }
                        });
                    }
                    this.cGr.clear();
                    this.cGs.clear();
                    this.cGt.clear();
                }
            }
        }

        synchronized void mA(String str) {
            if (this.cGu) {
                this.cGr.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void O(String str, int i) {
            if (this.cGu) {
                this.cGt.add(new c(str, 0L, 0L, i));
                mB(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cGu) {
                this.cGs.add(new c(str, 0L, j));
                mB(str);
            }
        }

        private void mB(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cGr.size()) {
                    if (TextUtils.equals(this.cGr.get(i2).mUrl, str)) {
                        this.cGr.remove(this.cGr.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cGw = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cGv += j.h(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            amp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class c {
        long cGz;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cGz = j2;
            this.mErrCode = i;
        }
    }
}
