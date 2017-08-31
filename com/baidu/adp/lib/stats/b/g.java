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
    private static volatile g xt;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private h xw;
    private a xx;
    private final SimpleDateFormat xu = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xv = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.xv.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.go() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.gn() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i wR = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g gI() {
        if (xt == null) {
            synchronized (g.class) {
                if (xt == null) {
                    xt = new g();
                }
            }
        }
        return xt;
    }

    public void init() {
        if (this.xx == null) {
            this.xx = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xx, intentFilter);
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
                g.this.gJ();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a q(String str, String str2) {
        String aq;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.xv.get((aq = com.baidu.adp.lib.stats.base.a.aq(str)))) == null) {
                if ("alert".equals(aq)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(aq)) {
                    aVar = new c(this.wR);
                } else if ("dbg".equals(aq)) {
                    aVar = new b(this.wR);
                } else if ("stat".equals(aq)) {
                    aVar = new f(this.wR);
                } else if ("pfmonitor".equals(aq)) {
                    aVar = new e(this.wR);
                } else {
                    aVar = new c(this.wR);
                }
                if (aVar != null) {
                    aVar.ap(aq);
                    this.xv.put(aq, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (q = q(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.gA().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.c("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.c(objArr);
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
                    aVar.p("net", com.baidu.adp.lib.stats.d.aa(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    aVar.c(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.p("ismainproc", "1");
                    } else {
                        aVar.p("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.gA().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.gj() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gA().isExactWriteFile(aVar.gr())) {
            z = true;
        }
        return aVar.gg() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.gk() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.gA().isExactWriteFile(aVar.gr())) {
            z = true;
        }
        return aVar.gh() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void gJ() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xv.entrySet()) {
            e(entry.getValue());
        }
    }

    public void gK() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xv.entrySet()) {
            d(entry.getValue());
        }
    }

    public void gL() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xv.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void av(String str) {
        com.baidu.adp.lib.stats.base.a q = gI().q(str, null);
        a(q, false, true);
        d(q);
    }

    public void gM() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xv.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        gN();
    }

    private void gN() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.gg() > 0) {
                d(aVar, true);
            } else if (aVar.gn() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.go() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gl(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gm(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z3) {
                    super.p(z3);
                    if (z3) {
                        aVar.i(0L);
                        com.baidu.adp.lib.stats.upload.b.gG().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.v(aVar.gw());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dI().c(diskFileOperate);
        }
    }

    public void gO() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xv.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long an = this.mBdLogSetting.an(value.gr());
                if (an <= 0) {
                    an = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.gr(), an);
                }
                value.g(an);
            }
            if (value != null) {
                if (value.gg() > 0) {
                    d(value, false);
                }
                if (value.gn() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.gi() >= 3600000) {
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
        if (aVar != null && aVar.gh() != 0) {
            if (aVar.go() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gl(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gm(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void p(boolean z) {
                        super.p(z);
                        if (z) {
                            aVar.i(0L);
                        }
                    }
                };
                diskFileOperate.v(aVar.gw());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.dI().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.gl(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z) {
                    super.p(z);
                    if (z) {
                        aVar.i(dW().length());
                    }
                }
            };
            dVar.v(aVar.gw());
            dVar.setContent(aVar.gv().toString());
            aVar.gq();
            if (!aVar.gx()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.W(3);
            }
            if (!com.baidu.adp.lib.Disk.d.dI().c(dVar)) {
            }
        }
    }

    public void gP() {
        if (this.xw == null) {
            this.xw = new h();
        }
        this.xw.gP();
    }
}
