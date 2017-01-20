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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class j {
    private static volatile j qW;
    private com.baidu.adp.lib.stats.e pD;
    private p qZ;
    private a ra;
    private String uid;
    private final SimpleDateFormat qX = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> qY = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q qt = new l(this);

    public static j fJ() {
        if (qW == null) {
            synchronized (j.class) {
                if (qW == null) {
                    qW = new j();
                }
            }
        }
        return qW;
    }

    public void init() {
        if (this.ra == null) {
            this.ra = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.ra, intentFilter);
        }
        this.pD = com.baidu.adp.lib.stats.a.eG().eH();
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
                j.this.fK();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String as;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.qY.get((as = com.baidu.adp.lib.stats.base.a.as(str)))) == null) {
                if ("alert".equals(as)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(as)) {
                    aVar = new c(this.qt);
                } else if ("dbg".equals(as)) {
                    aVar = new b(this.qt);
                } else if ("stat".equals(as)) {
                    aVar = new i(this.qt);
                } else if ("pfmonitor".equals(as)) {
                    aVar = new h(this.qt);
                } else {
                    aVar = new c(this.qt);
                }
                if (aVar != null) {
                    aVar.ar(as);
                    this.qY.put(as, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.fB().isWrite(str, str2)) {
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
                    dVar.q(SapiAccountManager.SESSION_UID, this.uid);
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
                    if (com.baidu.adp.lib.stats.a.eG().eN()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.fB().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.fk() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.fB().isExactWriteFile(aVar.fs())) {
            z = true;
        }
        return aVar.fh() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.fl() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.fB().isExactWriteFile(aVar.fs())) {
            z = true;
        }
        return aVar.fi() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void fK() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.qY.entrySet()) {
            e(entry.getValue());
        }
    }

    public void fL() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.qY.entrySet()) {
            d(entry.getValue());
        }
    }

    public void fM() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.qY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void ax(String str) {
        com.baidu.adp.lib.stats.base.a r = fJ().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void fN() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.qY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        fO();
    }

    private void fO() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.fh() > 0) {
                d(aVar, true);
            } else if (aVar.fo() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.fp() > 0) {
            m mVar = new m(this, com.baidu.adp.lib.stats.a.eG().eL(), aVar.fm(), com.baidu.adp.lib.stats.a.eG().eL(), aVar.fn(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.t(aVar.fx());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.cz().c(mVar);
        }
    }

    public void fP() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.qY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.pD != null) {
                long ap = this.pD.ap(value.fs());
                if (ap <= 0) {
                    ap = System.currentTimeMillis();
                    this.pD.d(value.fs(), ap);
                }
                value.g(ap);
            }
            if (value != null) {
                if (value.fh() > 0) {
                    d(value, false);
                }
                if (value.fo() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.fj() >= 3600000) {
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
        if (aVar != null && aVar.fi() != 0) {
            if (aVar.fp() > 102400) {
                n nVar = new n(this, com.baidu.adp.lib.stats.a.eG().eL(), aVar.fm(), com.baidu.adp.lib.stats.a.eG().eL(), aVar.fn(), DiskFileOperate.Action.RENAME, aVar);
                nVar.t(aVar.fx());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.cz().c(nVar);
            }
            o oVar = new o(this, com.baidu.adp.lib.stats.a.eG().eL(), aVar.fm(), DiskFileOperate.Action.APPEND, aVar);
            oVar.t(aVar.fx());
            oVar.setContent(aVar.fw().toString());
            aVar.fr();
            if (!aVar.fy()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.Y(3);
            }
            com.baidu.adp.lib.Disk.d.cz().c(oVar);
        }
    }

    public void fQ() {
        if (this.qZ == null) {
            this.qZ = new p();
        }
        this.qZ.fQ();
    }
}
