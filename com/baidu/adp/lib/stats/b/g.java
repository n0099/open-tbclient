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
public class g {
    private static volatile g zz;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private h zC;
    private a zD;
    private final SimpleDateFormat zA = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> zB = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.zB.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.gx() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.gw() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i yX = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g gR() {
        if (zz == null) {
            synchronized (g.class) {
                if (zz == null) {
                    zz = new g();
                }
            }
        }
        return zz;
    }

    public void init() {
        if (this.zD == null) {
            this.zD = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.zD, intentFilter);
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
                g.this.gS();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String aw;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.zB.get((aw = com.baidu.adp.lib.stats.base.a.aw(str)))) == null) {
                if ("alert".equals(aw)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aw)) {
                    aVar = new c(this.yX);
                } else if ("dbg".equals(aw)) {
                    aVar = new b(this.yX);
                } else if ("stat".equals(aw)) {
                    aVar = new f(this.yX);
                } else if ("pfmonitor".equals(aw)) {
                    aVar = new e(this.yX);
                } else {
                    aVar = new c(this.yX);
                }
                if (aVar != null) {
                    aVar.av(aw);
                    this.zB.put(aw, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gJ().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.d("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.d(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    aVar.p(SapiAccountManager.SESSION_UID, this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    aVar.p("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    aVar.p("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    aVar.p("net", com.baidu.adp.lib.stats.d.ad(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    aVar.d(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.p("ismainproc", "1");
                    } else {
                        aVar.p("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.gJ().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.gs() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gJ().isExactWriteFile(aVar.gA())) {
            z = true;
        }
        return aVar.gp() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gt() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gJ().isExactWriteFile(aVar.gA())) {
            z = true;
        }
        return aVar.gq() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gS() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.zB.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gT() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.zB.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gU() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.zB.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aB(String str) {
        com.baidu.adp.lib.stats.base.a q = gR().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void gV() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.zB.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gW();
    }

    private void gW() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.gp() > 0) {
                d(aVar, true);
            } else if (aVar.gw() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.gx() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gu(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gv(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z3) {
                    super.p(z3);
                    if (z3) {
                        aVar.i(0L);
                        com.baidu.adp.lib.stats.upload.b.gP().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.u(aVar.gF());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dS().c(diskFileOperate);
        }
    }

    public void gX() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.zB.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long at = this.mBdLogSetting.at(value.gA());
                if (at <= 0) {
                    at = System.currentTimeMillis();
                    this.mBdLogSetting.e(value.gA(), at);
                }
                value.g(at);
            }
            if (value != null) {
                if (value.gp() > 0) {
                    d(value, false);
                }
                if (value.gw() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.gr() >= 3600000) {
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
        if (aVar != null && aVar.gq() != 0) {
            if (aVar.gx() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gu(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gv(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void p(boolean z) {
                        super.p(z);
                        if (z) {
                            aVar.i(0L);
                        }
                    }
                };
                diskFileOperate.u(aVar.gF());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dS().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gu(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z) {
                    super.p(z);
                    if (z) {
                        aVar.i(eg().length());
                    }
                }
            };
            dVar.u(aVar.gF());
            dVar.setContent(aVar.gE().toString());
            aVar.gz();
            if (!aVar.gG()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Z(3);
            }
            if (!com.baidu.adp.lib.Disk.d.dS().c(dVar)) {
            }
        }
    }

    public void gY() {
        if (this.zC == null) {
            this.zC = new h();
        }
        this.zC.gY();
    }
}
