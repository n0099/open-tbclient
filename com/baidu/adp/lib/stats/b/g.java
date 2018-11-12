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
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    private static volatile g Fp;
    private h Fr;
    private a Fs;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Fq = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Fq.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.kc() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.kb() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i EM = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g kw() {
        if (Fp == null) {
            synchronized (g.class) {
                if (Fp == null) {
                    Fp = new g();
                }
            }
        }
        return Fp;
    }

    public void init() {
        if (this.Fs == null) {
            this.Fs = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.Fs, intentFilter);
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
                g.this.kx();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a z(String str, String str2) {
        String ba;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Fq.get((ba = com.baidu.adp.lib.stats.base.a.ba(str)))) == null) {
                if ("alert".equals(ba)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if (AiAppsTouchHelper.TouchEventName.TOUCH_ERROR.equals(ba)) {
                    aVar = new c(this.EM);
                } else if ("dbg".equals(ba)) {
                    aVar = new b(this.EM);
                } else if ("stat".equals(ba)) {
                    aVar = new f(this.EM);
                } else if ("pfmonitor".equals(ba)) {
                    aVar = new e(this.EM);
                } else {
                    aVar = new c(this.EM);
                }
                if (aVar != null) {
                    aVar.aZ(ba);
                    this.Fq.put(ba, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a z;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (z = z(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ko().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.f("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
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
                if (com.baidu.adp.lib.stats.switchs.a.ko().isUpload(str, str2)) {
                    z.a(aVar);
                } else {
                    z.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.jX() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.ko().isExactWriteFile(aVar.kf())) {
            z = true;
        }
        return aVar.jU() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.jY() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.ko().isExactWriteFile(aVar.kf())) {
            z = true;
        }
        return aVar.jV() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void kx() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fq.entrySet()) {
            e(entry.getValue());
        }
    }

    public void ky() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fq.entrySet()) {
            d(entry.getValue());
        }
    }

    public void kz() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fq.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void bf(String str) {
        com.baidu.adp.lib.stats.base.a z = kw().z(str, null);
        a(z, false, true);
        d(z);
    }

    public void kA() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fq.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        kB();
    }

    private void kB() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.jU() > 0) {
                d(aVar, true);
            } else if (aVar.kb() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.kc() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.jZ(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ka(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z3) {
                    super.O(z3);
                    if (z3) {
                        aVar.r(0L);
                        com.baidu.adp.lib.stats.upload.b.ku().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.T(aVar.kk());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hB().c(diskFileOperate);
        }
    }

    public void kC() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fq.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aX = this.mBdLogSetting.aX(value.kf());
                if (aX <= 0) {
                    aX = System.currentTimeMillis();
                    this.mBdLogSetting.e(value.kf(), aX);
                }
                value.p(aX);
            }
            if (value != null) {
                if (value.jU() > 0) {
                    d(value, false);
                }
                if (value.kb() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.jW() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.jV() != 0) {
            if (aVar.kc() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.jZ(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.ka(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void O(boolean z) {
                        super.O(z);
                        if (z) {
                            aVar.r(0L);
                        }
                    }
                };
                diskFileOperate.T(aVar.kk());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.hB().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.jZ(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z) {
                    super.O(z);
                    if (z) {
                        aVar.r(hO().length());
                    }
                }
            };
            dVar.T(aVar.kk());
            dVar.setContent(aVar.kj().toString());
            aVar.ke();
            if (!aVar.kl()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.ap(3);
            }
            if (!com.baidu.adp.lib.Disk.d.hB().c(dVar)) {
            }
        }
    }

    public void kD() {
        if (this.Fr == null) {
            this.Fr = new h();
        }
        this.Fr.kD();
    }
}
