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
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Nc;
    private i Nf;
    private a Ng;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private com.baidu.adp.lib.stats.c mCommonData;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Ne = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Ne.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.lD() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.lC() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private j Mv = new j() { // from class: com.baidu.adp.lib.stats.b.g.5
        @Override // com.baidu.adp.lib.stats.b.j
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

    public static g mc() {
        if (Nc == null) {
            synchronized (g.class) {
                if (Nc == null) {
                    Nc = new g();
                }
            }
        }
        return Nc;
    }

    public void d(com.baidu.adp.lib.stats.c cVar) {
        if (this.Ng == null) {
            this.Ng = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.Ng, intentFilter);
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
                g.this.md();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a y(String str, String str2) {
        String bV;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Ne.get((bV = com.baidu.adp.lib.stats.base.a.bV(str)))) == null) {
                if ("alert".equals(bV)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if (BdStatsConstant.StatsType.ERROR.equals(bV)) {
                    aVar = new c(this.Mv);
                } else if ("dbg".equals(bV)) {
                    aVar = new b(this.Mv);
                } else if ("stat".equals(bV)) {
                    aVar = new f(this.Mv);
                } else if (BdStatsConstant.StatsType.PERFORMANCE.equals(bV)) {
                    aVar = new e(this.Mv);
                } else {
                    aVar = new c(this.Mv);
                }
                if (aVar != null) {
                    aVar.bU(bV);
                    this.Ne.put(bV, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a y;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (y = y(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.lV().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.f.lo() && com.baidu.adp.lib.stats.f.a(y)) {
                    aVar.a(this.mCommonData);
                    y.c(aVar);
                }
                if (com.baidu.adp.lib.stats.switchs.a.lV().isUpload(str, str2)) {
                    y.a(aVar);
                } else {
                    y.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.lx() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.lV().isExactWriteFile(aVar.lI())) {
            z = true;
        }
        return aVar.lt() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.ly() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.lV().isExactWriteFile(aVar.lI())) {
            z = true;
        }
        return aVar.lu() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && com.baidu.adp.lib.stats.f.lo() && com.baidu.adp.lib.stats.f.a(aVar)) {
            boolean z = System.currentTimeMillis() - aVar.lz() >= 60000;
            if (com.baidu.adp.lib.stats.switchs.a.lV().isExactWriteFile(aVar.lI())) {
                z = true;
            }
            return aVar.lv() < 10 ? z : true;
        }
        return false;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void md() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ne.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
        }
    }

    public void me() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ne.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            j(value);
        }
    }

    public void mf() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ne.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            a(value, false, false);
            j(value);
        }
    }

    public void ca(String str) {
        com.baidu.adp.lib.stats.base.a y = mc().y(str, null);
        k(y);
        a(y, false, true);
        j(y);
    }

    public void mg() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ne.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
            m(value);
        }
        mh();
    }

    private void mh() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void j(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.lt() > 0) {
                d(aVar, true);
            } else if (aVar.lC() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void k(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.lv() > 0) {
                e(aVar, true);
            } else if (aVar.lE() > 0) {
                h.p(aVar);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.lD() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.lA(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.lB(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z3) {
                    super.callback(z3);
                    if (z3) {
                        aVar.L(0L);
                        com.baidu.adp.lib.stats.upload.b.ma().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.lQ());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.jP().c(diskFileOperate);
        }
    }

    public void mi() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ne.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long bO = this.mBdLogSetting.bO(value.lI());
                if (bO <= 0) {
                    bO = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.lI(), bO);
                }
                value.J(bO);
            }
            if (value != null) {
                if (value.lv() > 0) {
                    e(value, false);
                }
                if (value.lE() > 20480) {
                    h.p(value);
                } else if (System.currentTimeMillis() - value.lw() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    h.p(value);
                }
                if (value.lt() > 0) {
                    d(value, false);
                }
                if (value.lC() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.lw() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.lu() != 0) {
            if (aVar.lD() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.lA(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.lB(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void callback(boolean z) {
                        super.callback(z);
                        if (z) {
                            aVar.L(0L);
                        }
                    }
                };
                diskFileOperate.setSdCard(aVar.lQ());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.jP().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.lA(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.L(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.lQ());
            dVar.setContent(aVar.lO().toString());
            aVar.lG();
            if (!aVar.lS()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.jP().c(dVar)) {
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

    public void mj() {
        if (this.Nf == null) {
            this.Nf = new i();
        }
        this.Nf.mj();
    }
}
