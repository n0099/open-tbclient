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
    private static volatile j re;
    private com.baidu.adp.lib.stats.e pJ;
    private p rh;
    private a ri;
    private String uid;
    private final SimpleDateFormat rf = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> rg = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q qA = new l(this);

    public static j fL() {
        if (re == null) {
            synchronized (j.class) {
                if (re == null) {
                    re = new j();
                }
            }
        }
        return re;
    }

    public void init() {
        if (this.ri == null) {
            this.ri = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.ri, intentFilter);
        }
        this.pJ = com.baidu.adp.lib.stats.a.eI().eJ();
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
                j.this.fM();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String at;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.rg.get((at = com.baidu.adp.lib.stats.base.a.at(str)))) == null) {
                if ("alert".equals(at)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(at)) {
                    aVar = new c(this.qA);
                } else if ("dbg".equals(at)) {
                    aVar = new b(this.qA);
                } else if ("stat".equals(at)) {
                    aVar = new i(this.qA);
                } else if ("pfmonitor".equals(at)) {
                    aVar = new h(this.qA);
                } else {
                    aVar = new c(this.qA);
                }
                if (aVar != null) {
                    aVar.as(at);
                    this.rg.put(at, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.fD().isWrite(str, str2)) {
                if (dVar == null) {
                    dVar = new com.baidu.adp.lib.stats.d(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    dVar.d("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    dVar.d(objArr);
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
                    dVar.q("net", com.baidu.adp.lib.stats.g.F(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (com.baidu.adp.lib.stats.a.eI().eP()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.fD().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.fm() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.fD().isExactWriteFile(aVar.fu())) {
            z = true;
        }
        return aVar.fj() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.fn() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.fD().isExactWriteFile(aVar.fu())) {
            z = true;
        }
        return aVar.fk() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void fM() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.rg.entrySet()) {
            e(entry.getValue());
        }
    }

    public void fN() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.rg.entrySet()) {
            d(entry.getValue());
        }
    }

    public void fO() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.rg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void ay(String str) {
        com.baidu.adp.lib.stats.base.a r = fL().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void fP() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.rg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        fQ();
    }

    private void fQ() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.fj() > 0) {
                d(aVar, true);
            } else if (aVar.fq() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.fr() > 0) {
            m mVar = new m(this, com.baidu.adp.lib.stats.a.eI().eN(), aVar.fo(), com.baidu.adp.lib.stats.a.eI().eN(), aVar.fp(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.t(aVar.fz());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.cB().c(mVar);
        }
    }

    public void fR() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.rg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.pJ != null) {
                long aq = this.pJ.aq(value.fu());
                if (aq <= 0) {
                    aq = System.currentTimeMillis();
                    this.pJ.d(value.fu(), aq);
                }
                value.g(aq);
            }
            if (value != null) {
                if (value.fj() > 0) {
                    d(value, false);
                }
                if (value.fq() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.fl() >= 3600000) {
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
        if (aVar != null && aVar.fk() != 0) {
            if (aVar.fr() > 102400) {
                n nVar = new n(this, com.baidu.adp.lib.stats.a.eI().eN(), aVar.fo(), com.baidu.adp.lib.stats.a.eI().eN(), aVar.fp(), DiskFileOperate.Action.RENAME, aVar);
                nVar.t(aVar.fz());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.cB().c(nVar);
            }
            o oVar = new o(this, com.baidu.adp.lib.stats.a.eI().eN(), aVar.fo(), DiskFileOperate.Action.APPEND, aVar);
            oVar.t(aVar.fz());
            oVar.setContent(aVar.fy().toString());
            aVar.ft();
            if (!aVar.fA()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.X(3);
            }
            com.baidu.adp.lib.Disk.d.cB().c(oVar);
        }
    }

    public void fS() {
        if (this.rh == null) {
            this.rh = new p();
        }
        this.rh.fS();
    }
}
