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
    private static volatile g wd;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private h wf;
    private a wg;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> we = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.we.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.fT() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.fS() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i vB = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g go() {
        if (wd == null) {
            synchronized (g.class) {
                if (wd == null) {
                    wd = new g();
                }
            }
        }
        return wd;
    }

    public void init() {
        if (this.wg == null) {
            this.wg = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.wg, intentFilter);
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
                g.this.gp();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String av;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.we.get((av = com.baidu.adp.lib.stats.base.a.av(str)))) == null) {
                if ("alert".equals(av)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(av)) {
                    aVar = new c(this.vB);
                } else if ("dbg".equals(av)) {
                    aVar = new b(this.vB);
                } else if ("stat".equals(av)) {
                    aVar = new f(this.vB);
                } else if ("pfmonitor".equals(av)) {
                    aVar = new e(this.vB);
                } else {
                    aVar = new c(this.vB);
                }
                if (aVar != null) {
                    aVar.au(av);
                    this.we.put(av, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gg().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.switchs.a.gg().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.fO() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.gg().isExactWriteFile(aVar.fW())) {
            z = true;
        }
        return aVar.fL() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.fP() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.gg().isExactWriteFile(aVar.fW())) {
            z = true;
        }
        return aVar.fM() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gp() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.we.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gq() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.we.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gr() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.we.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aA(String str) {
        com.baidu.adp.lib.stats.base.a q = go().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void gs() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.we.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gt();
    }

    private void gt() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.fL() > 0) {
                d(aVar, true);
            } else if (aVar.fS() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.fT() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.fQ(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.fR(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z3) {
                    super.q(z3);
                    if (z3) {
                        aVar.k(0L);
                        com.baidu.adp.lib.stats.upload.b.gm().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.w(aVar.gb());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dp().c(diskFileOperate);
        }
    }

    public void gu() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.we.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long as = this.mBdLogSetting.as(value.fW());
                if (as <= 0) {
                    as = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.fW(), as);
                }
                value.i(as);
            }
            if (value != null) {
                if (value.fL() > 0) {
                    d(value, false);
                }
                if (value.fS() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.fN() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.fM() != 0) {
            if (aVar.fT() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.fQ(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.fR(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void q(boolean z) {
                        super.q(z);
                        if (z) {
                            aVar.k(0L);
                        }
                    }
                };
                diskFileOperate.w(aVar.gb());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dp().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.fQ(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z) {
                    super.q(z);
                    if (z) {
                        aVar.k(dD().length());
                    }
                }
            };
            dVar.w(aVar.gb());
            dVar.setContent(aVar.ga().toString());
            aVar.fV();
            if (!aVar.gd()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.P(3);
            }
            if (!com.baidu.adp.lib.Disk.d.dp().c(dVar)) {
            }
        }
    }

    public void gv() {
        if (this.wf == null) {
            this.wf = new h();
        }
        this.wf.gv();
    }
}
