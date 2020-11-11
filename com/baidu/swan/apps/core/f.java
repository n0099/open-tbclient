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
    private static b cHP;

    /* loaded from: classes10.dex */
    public static final class a {
        static final int cHR = com.baidu.swan.apps.t.a.awD().agN();
        static final int cHS = com.baidu.swan.apps.t.a.awD().agO();
        static final double cHT = com.baidu.swan.apps.t.a.awD().agP();
        static final boolean cHU = com.baidu.swan.apps.t.a.awD().agQ();
        public static final double cHV = com.baidu.swan.apps.t.a.awD().agS();
        public static final double cHW = com.baidu.swan.apps.t.a.awD().agR();
        static final int cHX = com.baidu.swan.apps.t.a.awD().agT();
    }

    private f() {
    }

    public static synchronized void eC(boolean z) {
        synchronized (f.class) {
            if (a.cHU && com.baidu.swan.apps.runtime.d.aHq().afE() != 1) {
                if (z || cHP == null) {
                    amT();
                }
                cHP.amV();
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
        if (a.cHU) {
            synchronized (f.class) {
                if (cHP == null) {
                    amT();
                }
            }
            cHP.a(aVar);
        }
    }

    public static void log(String str) {
        if (a.cHU) {
            synchronized (f.class) {
                if (cHP == null) {
                    amT();
                }
            }
            cHP.log(str);
        }
    }

    private static synchronized void amT() {
        synchronized (f.class) {
            com.baidu.swan.apps.core.c.reset();
            if (cHP != null) {
                cHP.cancel();
            }
            cHP = new b();
        }
    }

    public static void amU() {
        if (a.cHU && cHP != null) {
            cHP.amU();
        }
    }

    public static void bz(long j) {
        if (a.cHU && cHP != null) {
            cHP.bz(j);
        }
    }

    public static void bA(long j) {
        if (a.cHU && cHP != null) {
            cHP.bA(j);
        }
    }

    public static void mG(String str) {
        if (a.cHU && cHP != null) {
            cHP.mG(str);
        }
    }

    public static void O(String str, int i) {
        if (a.cHU && cHP != null) {
            cHP.O(str, i);
        }
    }

    public static void j(String str, long j) {
        if (a.cHU && cHP != null) {
            cHP.j(str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b {
        private long cHY;
        private long cHZ;
        private boolean cIa;
        private List<c> cIb;
        private List<c> cIc;
        private List<c> cId;
        private volatile boolean cIe;
        private String cIf;
        private boolean cIg;
        private Timer mTimer;

        private b() {
            this.cHY = 0L;
            this.cHZ = 0L;
            this.cIa = false;
            this.cIb = new ArrayList();
            this.cIc = new ArrayList();
            this.cId = new ArrayList();
            this.cIe = a.cHU;
            this.cIf = "";
            this.cIg = false;
        }

        void amV() {
            if (this.cIe && a.cHR > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.f.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.amZ();
                        b.this.amX();
                        final SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
                        if (azy != null && !azy.isFinishing()) {
                            azy.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.f.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void ana() {
                                    if (b.this.amW()) {
                                        azy.b(this);
                                    }
                                }
                            });
                        }
                    }
                }, a.cHR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean amW() {
            if (!this.cIg || TextUtils.isEmpty(this.cIf)) {
                return false;
            }
            com.baidu.swan.apps.core.b.g(amY(), this.cIf);
            this.cIg = false;
            return true;
        }

        void amU() {
            SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
            if (azy != null && !azy.isFinishing()) {
                StringBuilder append = new StringBuilder(azy.getText(a.h.swanapp_tip_cur_title)).append(TextUtils.isEmpty(this.cIf) ? "未检测到异常\n" : this.cIf);
                String amP = com.baidu.swan.apps.core.b.amP();
                if (!TextUtils.isEmpty(amP)) {
                    append.append(amP);
                }
                g.a aVar = new g.a(azy);
                aVar.mo33if(a.h.swanapp_tip_title).rR(append.toString()).aGY().a(new com.baidu.swan.apps.view.c.a()).gr(false);
                aVar.c(a.h.swanapp_tip_dialog_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.f.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.aHb();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void amX() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void bz(long j) {
            if (this.cHY == 0) {
                this.cHY = j;
                bB(this.cHY);
            }
        }

        void bA(long j) {
            if (this.cHZ == 0) {
                this.cHZ = j;
                bB(this.cHZ);
            }
        }

        private void bB(long j) {
            if (!this.cIa) {
                this.cIa = true;
                long amY = amY();
                if (amY != 0 && j - amY > a.cHX) {
                    a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.core.f.b.3
                        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
                        public void onResult(int i) {
                            if (ak.aMT()) {
                                switch (i) {
                                    case 1:
                                        b.this.log(com.baidu.swan.apps.core.a.cHH + "; 网络：正常");
                                        d.bo("fmp_timeout", FrsActivityConfig.GOOD);
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_loading_slow);
                                        return;
                                    case 2:
                                        b.this.log(com.baidu.swan.apps.core.a.cHH + "; 网络：较差");
                                        d.bo("fmp_timeout", "bad");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    case 3:
                                        b.this.log(com.baidu.swan.apps.core.a.cHH + "; 网络：离线");
                                        d.bo("fmp_timeout", "offline");
                                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                                        return;
                                    default:
                                        b.this.log(com.baidu.swan.apps.core.a.cHH + "; 网络：未知");
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

        private long amY() {
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if (aHv != null) {
                return aHv.aHy().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void amZ() {
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.cIe = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.cIb) {
                    cVar2.cIj = currentTimeMillis - cVar2.mStartTime;
                    this.cIc.add(cVar2);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.cId.size()) {
                    c cVar3 = this.cId.get(i3);
                    i3++;
                    i4 = (cVar3 == null || cVar3.mErrCode < 400 || cVar3.mErrCode >= 600) ? i4 : i4 + 1;
                }
                int size = this.cIc.size();
                if (i4 > 0) {
                    log("检查request状况，总请求次数：" + (i4 + size) + ", 失败次数: " + i4);
                }
                if (i4 / (size + i4) >= a.cHT) {
                    log(com.baidu.swan.apps.core.a.cHK);
                    this.cIg = true;
                    com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_service_unavailable);
                    d.jS("request_fail");
                } else {
                    int i5 = 0;
                    while (i2 < this.cIc.size()) {
                        if (this.cIc.get(i2).cIj > a.cHS) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.cIj + "ms");
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
                        final String format = String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i5), Integer.valueOf(a.cHS));
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
                    this.cIb.clear();
                    this.cIc.clear();
                    this.cId.clear();
                }
            }
        }

        synchronized void mG(String str) {
            if (this.cIe) {
                this.cIb.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void O(String str, int i) {
            if (this.cIe) {
                this.cId.add(new c(str, 0L, 0L, i));
                mH(str);
            }
        }

        synchronized void j(String str, long j) {
            if (this.cIe) {
                this.cIc.add(new c(str, 0L, j));
                mH(str);
            }
        }

        private void mH(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cIb.size()) {
                    if (TextUtils.equals(this.cIb.get(i2).mUrl, str)) {
                        this.cIb.remove(this.cIb.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void a(SwanAppNetworkUtils.a aVar) {
            this.cIg = true;
            SwanAppNetworkUtils.a(aVar);
        }

        void log(String str) {
            this.cIf += j.h(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            amX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class c {
        long cIj;
        int mErrCode;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        c(String str, long j, long j2, int i) {
            this.mUrl = str;
            this.mStartTime = j;
            this.cIj = j2;
            this.mErrCode = i;
        }
    }
}
