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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class j {
    private static volatile j xX;
    private com.baidu.adp.lib.stats.d mBdLogSetting;
    private String uid;
    private p ya;
    private a yb;
    private final SimpleDateFormat xY = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xZ = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q xu = new l(this);

    public static j gK() {
        if (xX == null) {
            synchronized (j.class) {
                if (xX == null) {
                    xX = new j();
                }
            }
        }
        return xX;
    }

    public void init() {
        if (this.yb == null) {
            this.yb = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.yb, intentFilter);
        }
        this.mBdLogSetting = BdStatisticsManager.getInstance().getBdLogSetting();
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
                j.this.gL();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String ai;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.xZ.get((ai = com.baidu.adp.lib.stats.base.a.ai(str)))) == null) {
                if ("alert".equals(ai)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(ai)) {
                    aVar = new c(this.xu);
                } else if ("dbg".equals(ai)) {
                    aVar = new b(this.xu);
                } else if ("stat".equals(ai)) {
                    aVar = new i(this.xu);
                } else if ("pfmonitor".equals(ai)) {
                    aVar = new h(this.xu);
                } else {
                    aVar = new c(this.xu);
                }
                if (aVar != null) {
                    aVar.ah(ai);
                    this.xZ.put(ai, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.c cVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((cVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gC().isWrite(str, str2)) {
                if (cVar == null) {
                    cVar = new com.baidu.adp.lib.stats.c(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    cVar.d("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    cVar.d(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    cVar.p(SapiAccountManager.SESSION_UID, this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    cVar.p("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    cVar.p("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    cVar.p("net", com.baidu.adp.lib.stats.f.ac(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    cVar.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        cVar.p("ismainproc", "1");
                    } else {
                        cVar.p("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.gC().isUpload(str, str2)) {
                    q.a(cVar);
                } else {
                    q.b(cVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gl() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gC().isExactWriteFile(aVar.gt())) {
            z = true;
        }
        return aVar.gi() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gm() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gC().isExactWriteFile(aVar.gt())) {
            z = true;
        }
        return aVar.gj() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gL() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xZ.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gM() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xZ.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gN() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xZ.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void an(String str) {
        com.baidu.adp.lib.stats.base.a q = gK().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void gO() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xZ.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gP();
    }

    private void gP() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.gi() > 0) {
                d(aVar, true);
            } else if (aVar.gp() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.gq() > 0) {
            m mVar = new m(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gn(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.go(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.u(aVar.gy());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dI().c(mVar);
        }
    }

    public void gQ() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xZ.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long af = this.mBdLogSetting.af(value.gt());
                if (af <= 0) {
                    af = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.gt(), af);
                }
                value.g(af);
            }
            if (value != null) {
                if (value.gi() > 0) {
                    d(value, false);
                }
                if (value.gp() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.gk() >= 3600000) {
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
        if (aVar != null && aVar.gj() != 0) {
            if (aVar.gq() > 102400) {
                n nVar = new n(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gn(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.go(), DiskFileOperate.Action.RENAME, aVar);
                nVar.u(aVar.gy());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dI().c(nVar);
            }
            o oVar = new o(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gn(), DiskFileOperate.Action.APPEND, aVar);
            oVar.u(aVar.gy());
            oVar.setContent(aVar.gx().toString());
            aVar.gs();
            if (!aVar.gz()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.W(3);
            }
            com.baidu.adp.lib.Disk.d.dI().c(oVar);
        }
    }

    public void gR() {
        if (this.ya == null) {
            this.ya = new p();
        }
        this.ya.gR();
    }
}
