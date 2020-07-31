package com.baidu.swan.apps.core;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.v.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b bZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a {
        static final int bZn = com.baidu.swan.apps.t.a.ahm().Tg();
        static final int bZo = com.baidu.swan.apps.t.a.ahm().Th();
        static final double bZp = com.baidu.swan.apps.t.a.ahm().Ti();
        static final boolean bZq = com.baidu.swan.apps.t.a.ahm().Tj();
    }

    public static synchronized void YV() {
        synchronized (d.class) {
            if (a.bZq) {
                com.baidu.swan.apps.core.b.reset();
                if (bZm != null) {
                    bZm.cancel();
                }
                bZm = new b();
                bZm.YV();
            }
        }
    }

    public static void YW() {
        if (a.bZq && bZm != null) {
            bZm.YW();
        }
    }

    public static void aO(long j) {
        if (a.bZq && bZm != null) {
            bZm.aO(j);
        }
    }

    public static void aP(long j) {
        if (a.bZq && bZm != null) {
            bZm.aP(j);
        }
    }

    public static void js(String str) {
        if (a.bZq && bZm != null) {
            bZm.js(str);
        }
    }

    public static void jt(String str) {
        if (a.bZq && bZm != null) {
            bZm.jt(str);
        }
    }

    public static void i(String str, long j) {
        if (a.bZq && bZm != null) {
            bZm.i(str, j);
        }
    }

    public static void YX() {
        if (a.bZq) {
            SwanAppNetworkUtils.h(new Runnable() { // from class: com.baidu.swan.apps.core.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.core.b.showToast(a.h.swanapp_tip_net_unavailable);
                }
            });
        }
    }

    public static void log(String str) {
        if (a.bZq && bZm != null) {
            bZm.log(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b {
        private long bZr;
        private long bZs;
        private boolean bZt;
        private List<c> bZu;
        private List<c> bZv;
        private List<c> bZw;
        private volatile boolean bZx;
        private String bZy;
        private boolean bZz;
        private Timer mTimer;

        private b() {
            this.bZr = 0L;
            this.bZs = 0L;
            this.bZt = false;
            this.bZu = new ArrayList();
            this.bZv = new ArrayList();
            this.bZw = new ArrayList();
            this.bZx = a.bZq;
            this.bZy = "";
            this.bZz = false;
        }

        void YV() {
            log("是否开启加载异常提示: " + a.bZq);
            if (this.bZx && a.bZn > 0) {
                this.mTimer = new Timer();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.core.d.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.Zb();
                        b.this.YZ();
                        final SwanAppActivity akb = f.akr().akb();
                        if (akb != null && !akb.isFinishing()) {
                            akb.a(new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.core.d.b.1.1
                                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                                public void Zc() {
                                    b.this.YY();
                                    akb.b(this);
                                }
                            });
                        }
                    }
                }, a.bZn);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void YY() {
            if (this.bZz && !TextUtils.isEmpty(this.bZy)) {
                com.baidu.swan.apps.core.a.e(Za(), this.bZy);
            }
        }

        void YW() {
            SwanAppActivity akb = f.akr().akb();
            if (akb != null && !akb.isFinishing()) {
                StringBuilder append = new StringBuilder(akb.getText(a.h.swanapp_tip_cur_title)).append(this.bZy);
                Pair<Long, String> YT = com.baidu.swan.apps.core.a.YT();
                if (YT != null && YT.first != null && !TextUtils.isEmpty((CharSequence) YT.second) && ((Long) YT.first).longValue() > 0 && ((Long) YT.first).longValue() != Za()) {
                    append.append("\n").append(j.f(((Long) YT.first).longValue(), "yyyy-MM-dd HH:mm:ss")).append(akb.getText(a.h.swanapp_tip_last_title)).append((String) YT.second);
                }
                g.a aVar = new g.a(akb);
                aVar.fi(a.h.swanapp_tip_title).og(append.toString()).a(new com.baidu.swan.apps.view.c.a()).fh(false);
                aVar.c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aVar.ard();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void YZ() {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }

        void aO(long j) {
            if (this.bZr == 0) {
                this.bZr = j;
                aQ(this.bZr);
            }
        }

        void aP(long j) {
            if (this.bZs == 0) {
                this.bZs = j;
                aQ(this.bZs);
            }
        }

        private void aQ(long j) {
            if (!this.bZt) {
                this.bZt = true;
                long Za = Za();
                if (Za != 0 && j - Za > 3000) {
                    log("FMP和FTP在框架启动后三秒内未触发，检查弱网");
                    YX();
                }
            }
        }

        private long Za() {
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            if (arw != null) {
                return arw.arz().getLong("launch_time", 0L);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void Zb() {
            int size;
            c cVar;
            int i;
            int i2 = 0;
            synchronized (this) {
                this.bZx = false;
                long currentTimeMillis = System.currentTimeMillis();
                for (c cVar2 : this.bZu) {
                    cVar2.bZC = currentTimeMillis - cVar2.mStartTime;
                    this.bZv.add(cVar2);
                }
                int size2 = this.bZw.size();
                log("检查request状况，失败次数：" + size2 + ", 成功次数: " + this.bZv.size());
                if (size2 / (size2 + size) >= a.bZp) {
                    log("请求失败率超过" + a.bZp + "，服务不稳定");
                    this.bZz = true;
                    com.baidu.swan.apps.core.b.showToast(a.h.swanapp_tip_service_unavailable);
                } else {
                    int i3 = 0;
                    while (i3 < this.bZv.size()) {
                        if (this.bZv.get(i3).bZC > a.bZo) {
                            try {
                                log("请求 " + new URL(cVar.mUrl).getPath() + " 耗时较长 ：" + cVar.bZC + "ms");
                            } catch (MalformedURLException e) {
                                if (d.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                            i = i2 + 1;
                        } else {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                    }
                    if (i2 >= 2) {
                        log(i2 + "个请求耗时大于2秒，网络较慢");
                        this.bZz = true;
                        com.baidu.swan.apps.core.b.showToast(a.h.swanapp_tip_service_slow);
                    }
                    this.bZu.clear();
                    this.bZv.clear();
                    this.bZw.clear();
                }
            }
        }

        synchronized void js(String str) {
            if (this.bZx) {
                this.bZu.add(new c(str, System.currentTimeMillis(), 0L));
            }
        }

        synchronized void jt(String str) {
            if (this.bZx) {
                this.bZw.add(new c(str, 0L, 0L));
                ju(str);
            }
        }

        synchronized void i(String str, long j) {
            if (this.bZx) {
                this.bZv.add(new c(str, 0L, j));
                ju(str);
            }
        }

        private void ju(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bZu.size()) {
                    if (TextUtils.equals(this.bZu.get(i2).mUrl, str)) {
                        this.bZu.remove(this.bZu.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        void YX() {
            this.bZz = true;
            SwanAppNetworkUtils.h(new Runnable() { // from class: com.baidu.swan.apps.core.d.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.log("检测到弱网并提示");
                    com.baidu.swan.apps.core.b.showToast(a.h.swanapp_tip_net_unavailable);
                }
            });
        }

        void log(String str) {
            this.bZy += str + "\n";
            if (d.DEBUG) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void cancel() {
            YZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class c {
        long bZC;
        long mStartTime;
        String mUrl;

        c(String str, long j, long j2) {
            this.mUrl = str;
            this.mStartTime = j;
            this.bZC = j2;
        }
    }
}
