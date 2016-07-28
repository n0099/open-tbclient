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
    private static volatile j oM;
    private com.baidu.adp.lib.stats.e nm;
    private p oP;
    private a oQ;
    private String uid;
    private final SimpleDateFormat oN = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> oO = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q oe = new l(this);

    public static j eQ() {
        if (oM == null) {
            synchronized (j.class) {
                if (oM == null) {
                    oM = new j();
                }
            }
        }
        return oM;
    }

    public void init() {
        if (this.oQ == null) {
            this.oQ = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.oQ, intentFilter);
        }
        this.nm = com.baidu.adp.lib.stats.a.dN().dO();
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
                j.this.eR();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String as;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.oO.get((as = com.baidu.adp.lib.stats.base.a.as(str)))) == null) {
                if ("alert".equals(as)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(as)) {
                    aVar = new c(this.oe);
                } else if ("dbg".equals(as)) {
                    aVar = new b(this.oe);
                } else if ("stat".equals(as)) {
                    aVar = new i(this.oe);
                } else if ("pfmonitor".equals(as)) {
                    aVar = new h(this.oe);
                } else {
                    aVar = new c(this.oe);
                }
                if (aVar != null) {
                    aVar.ar(as);
                    this.oO.put(as, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.eI().isWrite(str, str2)) {
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
                    dVar.q("net", com.baidu.adp.lib.stats.g.v(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (com.baidu.adp.lib.stats.a.dN().dU()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.eI().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.er() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.eI().isExactWriteFile(aVar.ez())) {
            z = true;
        }
        return aVar.eo() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.es() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.eI().isExactWriteFile(aVar.ez())) {
            z = true;
        }
        return aVar.ep() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void eR() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oO.entrySet()) {
            e(entry.getValue());
        }
    }

    public void eS() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oO.entrySet()) {
            d(entry.getValue());
        }
    }

    public void eT() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oO.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void ax(String str) {
        com.baidu.adp.lib.stats.base.a r = eQ().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void eU() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oO.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        eV();
    }

    private void eV() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.eo() > 0) {
                d(aVar, true);
            } else if (aVar.ev() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.ew() > 0) {
            m mVar = new m(this, com.baidu.adp.lib.stats.a.dN().dS(), aVar.et(), com.baidu.adp.lib.stats.a.dN().dS(), aVar.eu(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.r(aVar.eE());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.bG().c(mVar);
        }
    }

    public void eW() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.oO.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.nm != null) {
                long ap = this.nm.ap(value.ez());
                if (ap <= 0) {
                    ap = System.currentTimeMillis();
                    this.nm.d(value.ez(), ap);
                }
                value.g(ap);
            }
            if (value != null) {
                if (value.eo() > 0) {
                    d(value, false);
                }
                if (value.ev() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.eq() >= 3600000) {
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
        if (aVar != null && aVar.ep() != 0) {
            if (aVar.ew() > 102400) {
                n nVar = new n(this, com.baidu.adp.lib.stats.a.dN().dS(), aVar.et(), com.baidu.adp.lib.stats.a.dN().dS(), aVar.eu(), DiskFileOperate.Action.RENAME, aVar);
                nVar.r(aVar.eE());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.bG().c(nVar);
            }
            o oVar = new o(this, com.baidu.adp.lib.stats.a.dN().dS(), aVar.et(), DiskFileOperate.Action.APPEND, aVar);
            oVar.r(aVar.eE());
            oVar.setContent(aVar.eD().toString());
            aVar.ey();
            if (!aVar.eF()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.K(3);
            }
            com.baidu.adp.lib.Disk.d.bG().c(oVar);
        }
    }

    public void eX() {
        if (this.oP == null) {
            this.oP = new p();
        }
        this.oP.eX();
    }
}
