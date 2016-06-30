package com.baidu.adp.lib.stats.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class j {
    private static volatile j og;
    private com.baidu.adp.lib.stats.e mG;
    private p oj;
    private a ol;
    private String uid;
    private final SimpleDateFormat oh = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> oi = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q nC = new l(this);

    public static j eR() {
        if (og == null) {
            synchronized (j.class) {
                if (og == null) {
                    og = new j();
                }
            }
        }
        return og;
    }

    public void init() {
        if (this.ol == null) {
            this.ol = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.ol, intentFilter);
        }
        this.mG = com.baidu.adp.lib.stats.a.dO().dP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                j.this.setUid(intent.getStringExtra("intent_data_userid"));
                j.this.eS();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String aq;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.oi.get((aq = com.baidu.adp.lib.stats.base.a.aq(str)))) == null) {
                if ("alert".equals(aq)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aq)) {
                    aVar = new c(this.nC);
                } else if ("dbg".equals(aq)) {
                    aVar = new b(this.nC);
                } else if ("stat".equals(aq)) {
                    aVar = new i(this.nC);
                } else if ("pfmonitor".equals(aq)) {
                    aVar = new h(this.nC);
                } else {
                    aVar = new c(this.nC);
                }
                if (aVar != null) {
                    aVar.ap(aq);
                    this.oi.put(aq, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.eJ().isWrite(str, str2)) {
                if (dVar == null) {
                    dVar = new com.baidu.adp.lib.stats.d(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    dVar.b("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    dVar.b(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    dVar.q("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    dVar.q("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    dVar.q("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    dVar.q("net", com.baidu.adp.lib.stats.g.v(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (com.baidu.adp.lib.stats.a.dO().dV()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.eJ().isUpload(str, str2)) {
                    r.a(dVar);
                } else {
                    r.b(dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.es() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.eJ().isExactWriteFile(aVar.eA())) {
            z = true;
        }
        return aVar.ep() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.et() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.eJ().isExactWriteFile(aVar.eA())) {
            z = true;
        }
        return aVar.eq() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void eS() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oi.entrySet()) {
            e(entry.getValue());
        }
    }

    public void eT() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oi.entrySet()) {
            d(entry.getValue());
        }
    }

    public void eU() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oi.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void av(String str) {
        com.baidu.adp.lib.stats.base.a r = eR().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void eV() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oi.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        eW();
    }

    private void eW() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.ep() > 0) {
                d(aVar, true);
            } else if (aVar.ew() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.ex() > 0) {
            m mVar = new m(this, com.baidu.adp.lib.stats.a.dO().dT(), aVar.eu(), com.baidu.adp.lib.stats.a.dO().dT(), aVar.ev(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.p(aVar.eF());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.bH().c(mVar);
        }
    }

    public void eX() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oi.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mG != null) {
                long an = this.mG.an(value.eA());
                if (an <= 0) {
                    an = System.currentTimeMillis();
                    this.mG.d(value.eA(), an);
                }
                value.f(an);
            }
            if (value != null) {
                if (value.ep() > 0) {
                    d(value, false);
                }
                if (value.ew() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.er() >= 3600000) {
                    d.c(value, false, false, false);
                }
            }
        }
    }

    public void e(com.baidu.adp.lib.stats.base.a aVar) {
        d(aVar, false);
    }

    private void d(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            if (d.a(aVar) > 102400) {
                d.c(aVar, false, false, false);
            }
            d.c(aVar, z);
        }
    }

    public void f(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && aVar.eq() != 0) {
            if (aVar.ex() > 102400) {
                n nVar = new n(this, com.baidu.adp.lib.stats.a.dO().dT(), aVar.eu(), com.baidu.adp.lib.stats.a.dO().dT(), aVar.ev(), DiskFileOperate.Action.RENAME, aVar);
                nVar.p(aVar.eF());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.bH().c(nVar);
            }
            o oVar = new o(this, com.baidu.adp.lib.stats.a.dO().dT(), aVar.eu(), DiskFileOperate.Action.APPEND, aVar);
            oVar.p(aVar.eF());
            oVar.setContent(aVar.eE().toString());
            aVar.ez();
            if (!aVar.eG()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.H(3);
            }
            com.baidu.adp.lib.Disk.d.bH().c(oVar);
        }
    }

    public void eY() {
        if (this.oj == null) {
            this.oj = new p();
        }
        this.oj.eY();
    }
}
