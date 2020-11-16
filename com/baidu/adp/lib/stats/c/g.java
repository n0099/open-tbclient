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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Pf;
    private i Ph;
    private a Pi;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private com.baidu.adp.lib.stats.c mCommonData;
    private String uid;
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Pg = new ConcurrentHashMap<>();
    private final int Pj = 6;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.c.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Pg.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.nA() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.nz() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private j Ox = new j() { // from class: com.baidu.adp.lib.stats.c.g.5
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

    public static g nZ() {
        if (Pf == null) {
            synchronized (g.class) {
                if (Pf == null) {
                    Pf = new g();
                }
            }
        }
        return Pf;
    }

    public void d(com.baidu.adp.lib.stats.c cVar) {
        if (this.Pi == null) {
            this.Pi = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.Pi, intentFilter);
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
                g.this.oa();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a ch(String str) {
        String cc;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Pg.get((cc = com.baidu.adp.lib.stats.base.a.cc(str)))) == null) {
                if ("alert".equals(cc)) {
                    aVar = new com.baidu.adp.lib.stats.c.a(null);
                } else if (BdStatsConstant.StatsType.ERROR.equals(cc)) {
                    aVar = new c(this.Ox);
                } else if ("dbg".equals(cc)) {
                    aVar = new b(this.Ox);
                } else if ("stat".equals(cc)) {
                    aVar = new f(this.Ox);
                } else if (BdStatsConstant.StatsType.PERFORMANCE.equals(cc)) {
                    aVar = new e(this.Ox);
                } else {
                    aVar = new c(this.Ox);
                }
                aVar.cb(cc);
                this.Pg.put(cc, aVar);
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a ch;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (ch = ch(str)) != null && com.baidu.adp.lib.stats.switchs.a.nS().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.f.nl() && com.baidu.adp.lib.stats.f.a(ch)) {
                    aVar.a(this.mCommonData);
                    ch.c(aVar);
                }
                if (com.baidu.adp.lib.stats.switchs.a.nS().isUpload(str, str2)) {
                    ch.a(aVar);
                } else {
                    ch.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.nu() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.nS().isExactWriteFile(aVar.nF())) {
            z = true;
        }
        return aVar.nq() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.nv() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.nS().isExactWriteFile(aVar.nF())) {
            z = true;
        }
        return aVar.nr() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && com.baidu.adp.lib.stats.f.nl() && com.baidu.adp.lib.stats.f.a(aVar)) {
            boolean z = System.currentTimeMillis() - aVar.nw() >= 60000;
            if (com.baidu.adp.lib.stats.switchs.a.nS().isExactWriteFile(aVar.nF())) {
                z = true;
            }
            return aVar.ns() < 10 ? z : true;
        }
        return false;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void oa() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Pg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
        }
    }

    public void ob() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Pg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            j(value);
        }
    }

    public void oc() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Pg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            a(value, false, false);
            j(value);
        }
    }

    public void ci(String str) {
        com.baidu.adp.lib.stats.base.a ch = nZ().ch(str);
        k(ch);
        a(ch, false, true);
        j(ch);
    }

    public void od() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Pg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
            m(value);
        }
        oe();
    }

    private void oe() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, IMConnection.RETRY_DELAY_TIMES);
    }

    public void j(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.nq() > 0) {
                d(aVar, true);
            } else if (aVar.nz() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void k(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.ns() > 0) {
                e(aVar, true);
            } else if (aVar.nB() > 0) {
                h.p(aVar);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.nA() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nx(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ny(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.c.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z3) {
                    super.callback(z3);
                    if (z3) {
                        aVar.L(0L);
                        com.baidu.adp.lib.stats.upload.b.nX().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.nN());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.lL().c(diskFileOperate);
        }
    }

    public void og() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Pg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long bV = this.mBdLogSetting.bV(value.nF());
                if (bV <= 0) {
                    bV = System.currentTimeMillis();
                    this.mBdLogSetting.c(value.nF(), bV);
                }
                value.J(bV);
            }
            if (value != null) {
                if (value.ns() > 0) {
                    e(value, false);
                }
                if (value.nB() > 20480) {
                    h.p(value);
                } else if (System.currentTimeMillis() - value.nt() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    h.p(value);
                }
                if (value.nq() > 0) {
                    d(value, false);
                }
                if (value.nz() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.nt() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.nr() != 0) {
            if (aVar.nA() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nx(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ny(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.c.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void callback(boolean z) {
                        super.callback(z);
                        if (z) {
                            aVar.L(0L);
                        }
                    }
                };
                diskFileOperate.setSdCard(aVar.nN());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.lL().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nx(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.c.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.L(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.nN());
            dVar.setContent(aVar.nL().toString());
            aVar.nD();
            if (!aVar.nP()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.lL().c(dVar)) {
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

    public void oh() {
        if (this.Ph == null) {
            this.Ph = new i();
        }
        this.Ph.oh();
    }
}
