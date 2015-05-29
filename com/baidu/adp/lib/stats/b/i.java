package com.baidu.adp.lib.stats.b;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.stats.r;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class i {
    private static volatile i xw;
    private String uid;
    private r wt;
    private l xy;
    private k xz;
    private final SimpleDateFormat wE = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xx = new ConcurrentHashMap<>();
    private n xc = new j(this);

    public static i iw() {
        if (xw == null) {
            synchronized (i.class) {
                if (xw == null) {
                    xw = new i();
                }
            }
        }
        return xw;
    }

    public void init() {
        if (this.xz == null) {
            this.xz = new k(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xz, intentFilter);
        }
        this.wt = com.baidu.adp.lib.h.a.iB().hx();
    }

    public synchronized com.baidu.adp.lib.stats.base.a s(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String aD = com.baidu.adp.lib.stats.base.a.aD(str);
            aVar = this.xx.get(aD);
            if (aVar == null) {
                if ("error".equals(aD)) {
                    aVar = new b(this.xc);
                } else if ("dbg".equals(aD)) {
                    aVar = new a(this.xc);
                } else if ("stat".equals(aD)) {
                    aVar = new h(this.xc);
                } else if ("pfmonitor".equals(aD)) {
                    aVar = new g(this.xc);
                } else {
                    aVar = new b(this.xc);
                }
                if (aVar != null) {
                    aVar.aB(aD);
                    this.xx.put(aD, aVar);
                }
            }
            if (aVar != null) {
                aVar.aC(str2);
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, q qVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s;
        if (str != null && str2 != null) {
            if ((qVar != null || (objArr != null && objArr.length != 0)) && (s = s(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ip().isWrite(str, str2)) {
                if (qVar == null) {
                    qVar = new q(str);
                }
                if (str.equals("net") || str.equals("op")) {
                    qVar.f("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                } else if (!str.equals("stat") && !str.equals("crash")) {
                    qVar.f("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    qVar.f(objArr);
                }
                if (this.uid != null) {
                    qVar.r("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat") && !str.equals("pfmonitor")) {
                    qVar.r("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat") && !str.equals("pfmonitor")) {
                    qVar.r("seq_id", str4);
                }
                s.add(qVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.ic() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ip().isExactWriteFile(aVar.ig())) {
            z = true;
        }
        return aVar.ib() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void ix() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            g(entry.getValue());
        }
    }

    public void iy() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            e(entry.getValue());
        }
    }

    public void iz() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (value.ie() > 0) {
                c.d(value, true);
            }
        }
    }

    public void e(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.ib() > 0) {
                e(aVar, true);
            } else if (aVar.ie() > 0) {
                c.d(aVar, false);
            }
        }
    }

    public void iA() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wt != null) {
                long aA = this.wt.aA(value.ig());
                if (aA <= 0) {
                    aA = System.currentTimeMillis();
                    this.wt.d(value.ig(), aA);
                }
                value.setmLastUploadTime(aA);
            }
            f(value);
        }
    }

    private void f(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.ib() > 0) {
                e(aVar, false);
            }
            if (aVar.ie() > 102400) {
                c.d(aVar, false);
            } else if (System.currentTimeMillis() - aVar.getmLastUploadTime() >= 3600000) {
                c.d(aVar, false);
            }
        }
    }

    public void g(com.baidu.adp.lib.stats.base.a aVar) {
        e(aVar, false);
    }

    private void e(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            if (c.c(aVar) > 102400) {
                c.d(aVar, false);
            }
            c.c(aVar, z);
        }
    }

    public void clearLogResource() {
        if (this.xy == null) {
            this.xy = new l();
        }
        this.xy.clearLogResource();
    }
}
