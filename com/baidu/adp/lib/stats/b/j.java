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
    private static volatile j ys;
    private com.baidu.adp.lib.stats.d mBdLogSetting;
    private String uid;
    private p yv;
    private a yw;
    private final SimpleDateFormat yt = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> yu = new ConcurrentHashMap<>();
    private Handler mHandler = new k(this, Looper.getMainLooper());
    private q xP = new l(this);

    public static j gE() {
        if (ys == null) {
            synchronized (j.class) {
                if (ys == null) {
                    ys = new j();
                }
            }
        }
        return ys;
    }

    public void init() {
        if (this.yw == null) {
            this.yw = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.yw, intentFilter);
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
                j.this.gF();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String am;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.yu.get((am = com.baidu.adp.lib.stats.base.a.am(str)))) == null) {
                if ("alert".equals(am)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(am)) {
                    aVar = new c(this.xP);
                } else if ("dbg".equals(am)) {
                    aVar = new b(this.xP);
                } else if ("stat".equals(am)) {
                    aVar = new i(this.xP);
                } else if ("pfmonitor".equals(am)) {
                    aVar = new h(this.xP);
                } else {
                    aVar = new c(this.xP);
                }
                if (aVar != null) {
                    aVar.al(am);
                    this.yu.put(am, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.c cVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((cVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gw().isWrite(str, str2)) {
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
                    cVar.p("net", com.baidu.adp.lib.stats.f.ad(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    cVar.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        cVar.p("ismainproc", "1");
                    } else {
                        cVar.p("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.gw().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.gf() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gw().isExactWriteFile(aVar.gn())) {
            z = true;
        }
        return aVar.gb() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gg() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gw().isExactWriteFile(aVar.gn())) {
            z = true;
        }
        return aVar.gd() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gF() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yu.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gG() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yu.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gH() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yu.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void ar(String str) {
        com.baidu.adp.lib.stats.base.a q = gE().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void gI() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yu.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gJ();
    }

    private void gJ() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.gb() > 0) {
                d(aVar, true);
            } else if (aVar.gj() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.gk() > 0) {
            m mVar = new m(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gh(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gi(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            mVar.u(aVar.gs());
            mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dI().c(mVar);
        }
    }

    public void gK() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yu.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aj = this.mBdLogSetting.aj(value.gn());
                if (aj <= 0) {
                    aj = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.gn(), aj);
                }
                value.g(aj);
            }
            if (value != null) {
                if (value.gb() > 0) {
                    d(value, false);
                }
                if (value.gj() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.ge() >= 3600000) {
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
        if (aVar != null && aVar.gd() != 0) {
            if (aVar.gk() > 102400) {
                n nVar = new n(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gh(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gi(), DiskFileOperate.Action.RENAME, aVar);
                nVar.u(aVar.gs());
                nVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dI().c(nVar);
            }
            o oVar = new o(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gh(), DiskFileOperate.Action.APPEND, aVar);
            oVar.u(aVar.gs());
            oVar.setContent(aVar.gr().toString());
            aVar.gm();
            if (!aVar.gt()) {
                oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                oVar.Y(3);
            }
            com.baidu.adp.lib.Disk.d.dI().c(oVar);
        }
    }

    public void gL() {
        if (this.yv == null) {
            this.yv = new p();
        }
        this.yv.gL();
    }
}
