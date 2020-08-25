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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Ot;
    private i Ov;
    private a Ow;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private com.baidu.adp.lib.stats.c mCommonData;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Ou = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Ou.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.nu() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.nt() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private j NL = new j() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g nT() {
        if (Ot == null) {
            synchronized (g.class) {
                if (Ot == null) {
                    Ot = new g();
                }
            }
        }
        return Ot;
    }

    public void d(com.baidu.adp.lib.stats.c cVar) {
        if (this.Ow == null) {
            this.Ow = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.Ow, intentFilter);
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
                g.this.nU();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a z(String str, String str2) {
        String ca;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Ou.get((ca = com.baidu.adp.lib.stats.base.a.ca(str)))) == null) {
                if ("alert".equals(ca)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if (BdStatsConstant.StatsType.ERROR.equals(ca)) {
                    aVar = new c(this.NL);
                } else if ("dbg".equals(ca)) {
                    aVar = new b(this.NL);
                } else if ("stat".equals(ca)) {
                    aVar = new f(this.NL);
                } else if (BdStatsConstant.StatsType.PERFORMANCE.equals(ca)) {
                    aVar = new e(this.NL);
                } else {
                    aVar = new c(this.NL);
                }
                if (aVar != null) {
                    aVar.bZ(ca);
                    this.Ou.put(ca, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a z;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (z = z(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.nM().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.f.nf() && com.baidu.adp.lib.stats.f.a(z)) {
                    aVar.a(this.mCommonData);
                    z.c(aVar);
                }
                if (com.baidu.adp.lib.stats.switchs.a.nM().isUpload(str, str2)) {
                    z.a(aVar);
                } else {
                    z.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.no() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.nM().isExactWriteFile(aVar.nz())) {
            z = true;
        }
        return aVar.nk() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.np() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.nM().isExactWriteFile(aVar.nz())) {
            z = true;
        }
        return aVar.nl() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && com.baidu.adp.lib.stats.f.nf() && com.baidu.adp.lib.stats.f.a(aVar)) {
            boolean z = System.currentTimeMillis() - aVar.nq() >= 60000;
            if (com.baidu.adp.lib.stats.switchs.a.nM().isExactWriteFile(aVar.nz())) {
                z = true;
            }
            return aVar.nm() < 10 ? z : true;
        }
        return false;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void nU() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ou.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
        }
    }

    public void nV() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ou.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            j(value);
        }
    }

    public void nW() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ou.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            k(value);
            a(value, false, false);
            j(value);
        }
    }

    public void cf(String str) {
        com.baidu.adp.lib.stats.base.a z = nT().z(str, null);
        k(z);
        a(z, false, true);
        j(z);
    }

    public void nX() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ou.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            n(value);
            l(value);
            m(value);
        }
        nY();
    }

    private void nY() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, IMConnection.RETRY_DELAY_TIMES);
    }

    public void j(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.nk() > 0) {
                d(aVar, true);
            } else if (aVar.nt() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void k(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.nm() > 0) {
                e(aVar, true);
            } else if (aVar.nv() > 0) {
                h.p(aVar);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.nu() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nr(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ns(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z3) {
                    super.callback(z3);
                    if (z3) {
                        aVar.L(0L);
                        com.baidu.adp.lib.stats.upload.b.nR().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.nH());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.lG().c(diskFileOperate);
        }
    }

    public void nZ() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ou.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long bT = this.mBdLogSetting.bT(value.nz());
                if (bT <= 0) {
                    bT = System.currentTimeMillis();
                    this.mBdLogSetting.c(value.nz(), bT);
                }
                value.J(bT);
            }
            if (value != null) {
                if (value.nm() > 0) {
                    e(value, false);
                }
                if (value.nv() > 20480) {
                    h.p(value);
                } else if (System.currentTimeMillis() - value.nn() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                    h.p(value);
                }
                if (value.nk() > 0) {
                    d(value, false);
                }
                if (value.nt() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.nn() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.nl() != 0) {
            if (aVar.nu() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nr(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ns(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void callback(boolean z) {
                        super.callback(z);
                        if (z) {
                            aVar.L(0L);
                        }
                    }
                };
                diskFileOperate.setSdCard(aVar.nH());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.lG().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nr(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.L(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.nH());
            dVar.setContent(aVar.nF().toString());
            aVar.nx();
            if (!aVar.nJ()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.lG().c(dVar)) {
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

    public void oa() {
        if (this.Ov == null) {
            this.Ov = new i();
        }
        this.Ov.oa();
    }
}
