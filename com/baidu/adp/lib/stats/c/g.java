package com.baidu.adp.lib.stats.c;

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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Qe;
    private i Qg;
    private a Qh;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private com.baidu.adp.lib.stats.c mCommonData;
    private String uid;
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Qf = new ConcurrentHashMap<>();
    private final int Qi = 6;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.c.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Qf.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.nb() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.na() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private j Ps = new j() { // from class: com.baidu.adp.lib.stats.c.g.5
        @Override // com.baidu.adp.lib.stats.c.j
        public void o(com.baidu.adp.lib.stats.base.a aVar) {
            if (g.this.i(aVar)) {
                g.this.n(aVar);
            }
            if (g.this.g(aVar)) {
                g.this.l(aVar);
            }
            if (g.this.h(aVar)) {
                g.this.m(aVar);
            }
        }
    };

    public static g nA() {
        if (Qe == null) {
            synchronized (g.class) {
                if (Qe == null) {
                    Qe = new g();
                }
            }
        }
        return Qe;
    }

    public void d(com.baidu.adp.lib.stats.c cVar) {
        if (this.Qh == null) {
            this.Qh = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.Qh, intentFilter);
        }
        this.mBdLogSetting = BdStatisticsManager.getInstance().getBdLogSetting();
        this.mCommonData = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                g.this.setUid(intent.getStringExtra(BdStatsConstant.INTENT_DATA_USERID));
                g.this.nB();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a cd(String str) {
        String bY;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Qf.get((bY = com.baidu.adp.lib.stats.base.a.bY(str)))) == null) {
                if ("alert".equals(bY)) {
                    aVar = new com.baidu.adp.lib.stats.c.a(null);
                } else if (BdStatsConstant.StatsType.ERROR.equals(bY)) {
                    aVar = new c(this.Ps);
                } else if ("dbg".equals(bY)) {
                    aVar = new b(this.Ps);
                } else if ("stat".equals(bY)) {
                    aVar = new f(this.Ps);
                } else if (BdStatsConstant.StatsType.PERFORMANCE.equals(bY)) {
                    aVar = new e(this.Ps);
                } else {
                    aVar = new c(this.Ps);
                }
                aVar.bX(bY);
                this.Qf.put(bY, aVar);
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a cd;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (cd = cd(str)) != null && com.baidu.adp.lib.stats.switchs.a.nt().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.append(BdStatsConstant.StatsKey.TYPE, str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.append(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    aVar.append("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    aVar.append(BdStatsConstant.StatsKey.LOGID, str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    aVar.append(BdStatsConstant.StatsKey.SEQUENCEID, str4);
                }
                if (!str.equals("stat")) {
                    aVar.append("net", com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals(BdStatsConstant.StatsType.PERFORMANCE)) {
                    aVar.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.append(BdStatsConstant.StatsKey.IS_MAIN_PROC, "1");
                    } else {
                        aVar.append(BdStatsConstant.StatsKey.IS_MAIN_PROC, "0");
                    }
                }
                if (com.baidu.adp.lib.stats.f.mO() && com.baidu.adp.lib.stats.f.a(cd)) {
                    aVar.a(this.mCommonData);
                    cd.c(aVar);
                }
                if (com.baidu.adp.lib.stats.switchs.a.nt().isUpload(str, str2)) {
                    cd.a(aVar);
                } else {
                    cd.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.mV() >= AppStatusRules.DEFAULT_GRANULARITY;
        if (com.baidu.adp.lib.stats.switchs.a.nt().isExactWriteFile(aVar.ng())) {
            z = true;
        }
        return aVar.mR() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.mW() >= AppStatusRules.DEFAULT_GRANULARITY;
        if (com.baidu.adp.lib.stats.switchs.a.nt().isExactWriteFile(aVar.ng())) {
            z = true;
        }
        return aVar.mS() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && com.baidu.adp.lib.stats.f.mO() && com.baidu.adp.lib.stats.f.a(aVar)) {
            boolean z = System.currentTimeMillis() - aVar.mX() >= AppStatusRules.DEFAULT_GRANULARITY;
            if (com.baidu.adp.lib.stats.switchs.a.nt().isExactWriteFile(aVar.ng())) {
                z = true;
            }
            return aVar.mT() < 10 ? z : true;
        }
        return false;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void nB() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Qf.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
        }
    }

    public void nC() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Qf.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            j(value);
        }
    }

    public void nD() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Qf.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            a(value, false, false);
            j(value);
        }
    }

    public void ce(String str) {
        com.baidu.adp.lib.stats.base.a cd = nA().cd(str);
        k(cd);
        a(cd, false, true);
        j(cd);
    }

    public void nE() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Qf.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
            m(value);
        }
        nF();
    }

    private void nF() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, IMConnection.RETRY_DELAY_TIMES);
    }

    public void j(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.mR() > 0) {
                d(aVar, true);
            } else if (aVar.na() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void k(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.mT() > 0) {
                e(aVar, true);
            } else if (aVar.nc() > 0) {
                h.p(aVar);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.nb() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.mY(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.mZ(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.c.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z3) {
                    super.callback(z3);
                    if (z3) {
                        aVar.J(0L);
                        com.baidu.adp.lib.stats.upload.b.ny().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.no());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.lh().c(diskFileOperate);
        }
    }

    public void nG() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Qf.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long bS = this.mBdLogSetting.bS(value.ng());
                if (bS <= 0) {
                    bS = System.currentTimeMillis();
                    this.mBdLogSetting.c(value.ng(), bS);
                }
                value.H(bS);
            }
            if (value != null) {
                if (value.mT() > 0) {
                    e(value, false);
                }
                if (value.nc() > 20480) {
                    h.p(value);
                } else if (System.currentTimeMillis() - value.mU() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    h.p(value);
                }
                if (value.mR() > 0) {
                    d(value, false);
                }
                if (value.na() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.mU() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    d.c(value, false, false, false);
                }
            }
        }
    }

    public void l(com.baidu.adp.lib.stats.base.a aVar) {
        d(aVar, false);
    }

    private void d(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            if (d.f(aVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                d.c(aVar, false, false, false);
            }
            d.c(aVar, z);
        }
    }

    public void m(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && aVar.mS() != 0) {
            if (aVar.nb() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.mY(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.mZ(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.c.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void callback(boolean z) {
                        super.callback(z);
                        if (z) {
                            aVar.J(0L);
                        }
                    }
                };
                diskFileOperate.setSdCard(aVar.no());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.lh().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.mY(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.c.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.J(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.no());
            dVar.setContent(aVar.nm().toString());
            aVar.ne();
            if (!aVar.nq()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.lh().c(dVar)) {
            }
        }
    }

    public void n(com.baidu.adp.lib.stats.base.a aVar) {
        e(aVar, false);
    }

    private void e(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            if (h.f(aVar) > 20480) {
                h.p(aVar);
            }
            h.c(aVar, z);
        }
    }

    public void nH() {
        if (this.Qg == null) {
            this.Qg = new i();
        }
        this.Qg.nH();
    }
}
