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
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Cg;
    private h Cj;
    private a Ck;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat Ch = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Ci = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Ci.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.iK() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.iJ() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i BE = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g je() {
        if (Cg == null) {
            synchronized (g.class) {
                if (Cg == null) {
                    Cg = new g();
                }
            }
        }
        return Cg;
    }

    public void init() {
        if (this.Ck == null) {
            this.Ck = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.Ck, intentFilter);
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
                g.this.jf();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String aK;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Ci.get((aK = com.baidu.adp.lib.stats.base.a.aK(str)))) == null) {
                if ("alert".equals(aK)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aK)) {
                    aVar = new c(this.BE);
                } else if ("dbg".equals(aK)) {
                    aVar = new b(this.BE);
                } else if ("stat".equals(aK)) {
                    aVar = new f(this.BE);
                } else if ("pfmonitor".equals(aK)) {
                    aVar = new e(this.BE);
                } else {
                    aVar = new c(this.BE);
                }
                if (aVar != null) {
                    aVar.aJ(aK);
                    this.Ci.put(aK, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.iW().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.f("module", str, TimeDisplaySetting.START_SHOW_TIME, str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.f(objArr);
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
                    aVar.f(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.append("ismainproc", "1");
                    } else {
                        aVar.append("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.iW().isUpload(str, str2)) {
                    q.a(aVar);
                } else {
                    q.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.iF() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.iW().isExactWriteFile(aVar.iN())) {
            z = true;
        }
        return aVar.iC() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.iG() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.iW().isExactWriteFile(aVar.iN())) {
            z = true;
        }
        return aVar.iD() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void jf() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ci.entrySet()) {
            e(entry.getValue());
        }
    }

    public void jg() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ci.entrySet()) {
            d(entry.getValue());
        }
    }

    public void jh() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ci.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aP(String str) {
        com.baidu.adp.lib.stats.base.a q = je().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void ji() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ci.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        jj();
    }

    private void jj() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.iC() > 0) {
                d(aVar, true);
            } else if (aVar.iJ() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.iK() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iH(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iI(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z3) {
                    super.q(z3);
                    if (z3) {
                        aVar.m(0L);
                        com.baidu.adp.lib.stats.upload.b.jc().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.w(aVar.iS());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ge().c(diskFileOperate);
        }
    }

    public void jk() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Ci.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aH = this.mBdLogSetting.aH(value.iN());
                if (aH <= 0) {
                    aH = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.iN(), aH);
                }
                value.k(aH);
            }
            if (value != null) {
                if (value.iC() > 0) {
                    d(value, false);
                }
                if (value.iJ() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.iE() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.iD() != 0) {
            if (aVar.iK() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iH(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iI(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void q(boolean z) {
                        super.q(z);
                        if (z) {
                            aVar.m(0L);
                        }
                    }
                };
                diskFileOperate.w(aVar.iS());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.ge().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iH(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z) {
                    super.q(z);
                    if (z) {
                        aVar.m(gs().length());
                    }
                }
            };
            dVar.w(aVar.iS());
            dVar.setContent(aVar.iR().toString());
            aVar.iM();
            if (!aVar.iT()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.ge().c(dVar)) {
            }
        }
    }

    public void jl() {
        if (this.Cj == null) {
            this.Cj = new h();
        }
        this.Cj.jl();
    }
}
