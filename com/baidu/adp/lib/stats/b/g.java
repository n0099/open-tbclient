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
    private static volatile g Cl;
    private h Cn;
    private a Co;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Cm = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Cm.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.iJ() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.iI() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i BJ = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g jd() {
        if (Cl == null) {
            synchronized (g.class) {
                if (Cl == null) {
                    Cl = new g();
                }
            }
        }
        return Cl;
    }

    public void init() {
        if (this.Co == null) {
            this.Co = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.Co, intentFilter);
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
                g.this.je();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        String aJ;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Cm.get((aJ = com.baidu.adp.lib.stats.base.a.aJ(str)))) == null) {
                if ("alert".equals(aJ)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aJ)) {
                    aVar = new c(this.BJ);
                } else if ("dbg".equals(aJ)) {
                    aVar = new b(this.BJ);
                } else if ("stat".equals(aJ)) {
                    aVar = new f(this.BJ);
                } else if ("pfmonitor".equals(aJ)) {
                    aVar = new e(this.BJ);
                } else {
                    aVar = new c(this.BJ);
                }
                if (aVar != null) {
                    aVar.aI(aJ);
                    this.Cm.put(aJ, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.iV().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.switchs.a.iV().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.iE() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.iV().isExactWriteFile(aVar.iM())) {
            z = true;
        }
        return aVar.iB() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.iF() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.iV().isExactWriteFile(aVar.iM())) {
            z = true;
        }
        return aVar.iC() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void je() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Cm.entrySet()) {
            e(entry.getValue());
        }
    }

    public void jf() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Cm.entrySet()) {
            d(entry.getValue());
        }
    }

    public void jg() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Cm.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aO(String str) {
        com.baidu.adp.lib.stats.base.a r = jd().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void jh() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Cm.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        ji();
    }

    private void ji() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.iB() > 0) {
                d(aVar, true);
            } else if (aVar.iI() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.iJ() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iG(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iH(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void t(boolean z3) {
                    super.t(z3);
                    if (z3) {
                        aVar.m(0L);
                        com.baidu.adp.lib.stats.upload.b.jb().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.y(aVar.iR());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.gf().c(diskFileOperate);
        }
    }

    public void jj() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Cm.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aG = this.mBdLogSetting.aG(value.iM());
                if (aG <= 0) {
                    aG = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.iM(), aG);
                }
                value.k(aG);
            }
            if (value != null) {
                if (value.iB() > 0) {
                    d(value, false);
                }
                if (value.iI() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.iD() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.iC() != 0) {
            if (aVar.iJ() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iG(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iH(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void t(boolean z) {
                        super.t(z);
                        if (z) {
                            aVar.m(0L);
                        }
                    }
                };
                diskFileOperate.y(aVar.iR());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.gf().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.iG(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void t(boolean z) {
                    super.t(z);
                    if (z) {
                        aVar.m(gt().length());
                    }
                }
            };
            dVar.y(aVar.iR());
            dVar.setContent(aVar.iQ().toString());
            aVar.iL();
            if (!aVar.iS()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.gf().c(dVar)) {
            }
        }
    }

    public void jk() {
        if (this.Cn == null) {
            this.Cn = new h();
        }
        this.Cn.jk();
    }
}
