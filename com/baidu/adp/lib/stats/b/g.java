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
    private static volatile g Fo;
    private h Fq;
    private a Fr;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> Fp = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.Fp.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.ke() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.kd() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i EL = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g ky() {
        if (Fo == null) {
            synchronized (g.class) {
                if (Fo == null) {
                    Fo = new g();
                }
            }
        }
        return Fo;
    }

    public void init() {
        if (this.Fr == null) {
            this.Fr = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.Fr, intentFilter);
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
                g.this.kz();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a z(String str, String str2) {
        String bb;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.Fp.get((bb = com.baidu.adp.lib.stats.base.a.bb(str)))) == null) {
                if ("alert".equals(bb)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(bb)) {
                    aVar = new c(this.EL);
                } else if ("dbg".equals(bb)) {
                    aVar = new b(this.EL);
                } else if ("stat".equals(bb)) {
                    aVar = new f(this.EL);
                } else if ("pfmonitor".equals(bb)) {
                    aVar = new e(this.EL);
                } else {
                    aVar = new c(this.EL);
                }
                if (aVar != null) {
                    aVar.ba(bb);
                    this.Fp.put(bb, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a z;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (z = z(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.kq().isWrite(str, str2)) {
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
                if (com.baidu.adp.lib.stats.switchs.a.kq().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.jZ() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.kq().isExactWriteFile(aVar.kh())) {
            z = true;
        }
        return aVar.jW() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.ka() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.kq().isExactWriteFile(aVar.kh())) {
            z = true;
        }
        return aVar.jX() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void kz() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fp.entrySet()) {
            e(entry.getValue());
        }
    }

    public void kA() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fp.entrySet()) {
            d(entry.getValue());
        }
    }

    public void kB() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fp.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void bg(String str) {
        com.baidu.adp.lib.stats.base.a z = ky().z(str, null);
        a(z, false, true);
        d(z);
    }

    public void kC() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fp.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        kD();
    }

    private void kD() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.jW() > 0) {
                d(aVar, true);
            } else if (aVar.kd() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.ke() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.kb(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.kc(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z3) {
                    super.O(z3);
                    if (z3) {
                        aVar.p(0L);
                        com.baidu.adp.lib.stats.upload.b.kw().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.T(aVar.km());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hz().c(diskFileOperate);
        }
    }

    public void kE() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.Fp.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long aY = this.mBdLogSetting.aY(value.kh());
                if (aY <= 0) {
                    aY = System.currentTimeMillis();
                    this.mBdLogSetting.e(value.kh(), aY);
                }
                value.n(aY);
            }
            if (value != null) {
                if (value.jW() > 0) {
                    d(value, false);
                }
                if (value.kd() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.jY() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.jX() != 0) {
            if (aVar.ke() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.kb(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.kc(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void O(boolean z) {
                        super.O(z);
                        if (z) {
                            aVar.p(0L);
                        }
                    }
                };
                diskFileOperate.T(aVar.km());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.hz().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.kb(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z) {
                    super.O(z);
                    if (z) {
                        aVar.p(hN().length());
                    }
                }
            };
            dVar.T(aVar.km());
            dVar.setContent(aVar.kl().toString());
            aVar.kg();
            if (!aVar.kn()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Y(3);
            }
            if (!com.baidu.adp.lib.Disk.d.hz().c(dVar)) {
            }
        }
    }

    public void kF() {
        if (this.Fq == null) {
            this.Fq = new h();
        }
        this.Fq.kF();
    }
}
