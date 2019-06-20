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
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g CX;
    private h CZ;
    private a Da;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> CY = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.CY.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.iY() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.iX() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i Ct = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g js() {
        if (CX == null) {
            synchronized (g.class) {
                if (CX == null) {
                    CX = new g();
                }
            }
        }
        return CX;
    }

    public void init() {
        if (this.Da == null) {
            this.Da = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.Da, intentFilter);
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
                g.this.setUid(intent.getStringExtra("intent_data_userid"));
                g.this.jt();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String aL;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.CY.get((aL = com.baidu.adp.lib.stats.base.a.aL(str)))) == null) {
                if ("alert".equals(aL)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aL)) {
                    aVar = new c(this.Ct);
                } else if ("dbg".equals(aL)) {
                    aVar = new b(this.Ct);
                } else if ("stat".equals(aL)) {
                    aVar = new f(this.Ct);
                } else if ("pfmonitor".equals(aL)) {
                    aVar = new e(this.Ct);
                } else {
                    aVar = new c(this.Ct);
                }
                if (aVar != null) {
                    aVar.aK(aL);
                    this.CY.put(aL, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.jk().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.c(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    aVar.append("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    aVar.append("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    aVar.append("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    aVar.append("net", com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    aVar.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.append("ismainproc", "1");
                    } else {
                        aVar.append("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.jk().isUpload(str, str2)) {
                    r.a(aVar);
                } else {
                    r.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.iT() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.jk().isExactWriteFile(aVar.jb())) {
            z = true;
        }
        return aVar.iQ() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.iU() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.jk().isExactWriteFile(aVar.jb())) {
            z = true;
        }
        return aVar.iR() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void jt() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.CY.entrySet()) {
            e(entry.getValue());
        }
    }

    public void ju() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.CY.entrySet()) {
            d(entry.getValue());
        }
    }

    public void jv() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.CY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aQ(String str) {
        com.baidu.adp.lib.stats.base.a r = js().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void jw() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.CY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        jx();
    }

    private void jx() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.iQ() > 0) {
                d(aVar, true);
            } else if (aVar.iX() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.iY() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iV(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iW(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void G(boolean z3) {
                    super.G(z3);
                    if (z3) {
                        aVar.m(0L);
                        com.baidu.adp.lib.stats.upload.b.jq().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.L(aVar.jg());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.gt().c(diskFileOperate);
        }
    }

    public void jy() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.CY.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aI = this.mBdLogSetting.aI(value.jb());
                if (aI <= 0) {
                    aI = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.jb(), aI);
                }
                value.k(aI);
            }
            if (value != null) {
                if (value.iQ() > 0) {
                    d(value, false);
                }
                if (value.iX() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.iS() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.iR() != 0) {
            if (aVar.iY() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iV(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iW(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void G(boolean z) {
                        super.G(z);
                        if (z) {
                            aVar.m(0L);
                        }
                    }
                };
                diskFileOperate.L(aVar.jg());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.gt().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iV(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void G(boolean z) {
                    super.G(z);
                    if (z) {
                        aVar.m(gH().length());
                    }
                }
            };
            dVar.L(aVar.jg());
            dVar.setContent(aVar.jf().toString());
            aVar.ja();
            if (!aVar.jh()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.gt().c(dVar)) {
            }
        }
    }

    public void jz() {
        if (this.CZ == null) {
            this.CZ = new h();
        }
        this.CZ.jz();
    }
}
