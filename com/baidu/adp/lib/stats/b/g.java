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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g rw;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private h ry;
    private a rz;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());

    /* renamed from: rx  reason: collision with root package name */
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> f7rx = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.f7rx.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.gu() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.gt() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i qS = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
        @Override // com.baidu.adp.lib.stats.b.i
        public void g(com.baidu.adp.lib.stats.base.a aVar) {
            if (g.this.b(aVar)) {
                g.this.e(aVar);
            }
            if (g.this.c(aVar)) {
                g.this.f(aVar);
            }
        }
    };

    public static g gO() {
        if (rw == null) {
            synchronized (g.class) {
                if (rw == null) {
                    rw = new g();
                }
            }
        }
        return rw;
    }

    public void init() {
        if (this.rz == null) {
            this.rz = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.rz, intentFilter);
        }
        this.mBdLogSetting = BdStatisticsManager.getInstance().getBdLogSetting();
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
                g.this.gP();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a m(String str, String str2) {
        String aq;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f7rx.get((aq = com.baidu.adp.lib.stats.base.a.aq(str)))) == null) {
                if ("alert".equals(aq)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if (BdStatsConstant.StatsType.ERROR.equals(aq)) {
                    aVar = new c(this.qS);
                } else if ("dbg".equals(aq)) {
                    aVar = new b(this.qS);
                } else if ("stat".equals(aq)) {
                    aVar = new f(this.qS);
                } else if (BdStatsConstant.StatsType.PERFORMANCE.equals(aq)) {
                    aVar = new e(this.qS);
                } else {
                    aVar = new c(this.qS);
                }
                if (aVar != null) {
                    aVar.ap(aq);
                    this.f7rx.put(aq, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a m;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (m = m(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gG().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.switchs.a.gG().isUpload(str, str2)) {
                    m.a(aVar);
                } else {
                    m.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gp() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.gG().isExactWriteFile(aVar.gx())) {
            z = true;
        }
        return aVar.gm() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gq() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.gG().isExactWriteFile(aVar.gx())) {
            z = true;
        }
        return aVar.gn() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gP() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.f7rx.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gQ() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.f7rx.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gR() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.f7rx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void av(String str) {
        com.baidu.adp.lib.stats.base.a m = gO().m(str, null);
        a(m, false, true);
        d(m);
    }

    public void gS() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.f7rx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gT();
    }

    private void gT() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.gm() > 0) {
                d(aVar, true);
            } else if (aVar.gt() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.gu() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gr(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gs(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z3) {
                    super.callback(z3);
                    if (z3) {
                        aVar.m(0L);
                        com.baidu.adp.lib.stats.upload.b.gM().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.gC());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.eP().c(diskFileOperate);
        }
    }

    public void gU() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.f7rx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long an = this.mBdLogSetting.an(value.gx());
                if (an <= 0) {
                    an = System.currentTimeMillis();
                    this.mBdLogSetting.e(value.gx(), an);
                }
                value.k(an);
            }
            if (value != null) {
                if (value.gm() > 0) {
                    d(value, false);
                }
                if (value.gt() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.go() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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

    public void f(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && aVar.gn() != 0) {
            if (aVar.gu() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gr(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gs(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void callback(boolean z) {
                        super.callback(z);
                        if (z) {
                            aVar.m(0L);
                        }
                    }
                };
                diskFileOperate.setSdCard(aVar.gC());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.eP().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gr(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.m(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.gC());
            dVar.setContent(aVar.gB().toString());
            aVar.gw();
            if (!aVar.gD()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.eP().c(dVar)) {
            }
        }
    }

    public void gV() {
        if (this.ry == null) {
            this.ry = new h();
        }
        this.ry.gV();
    }
}
