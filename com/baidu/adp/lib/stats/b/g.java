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
    private static volatile g alF;
    private h alI;
    private a alJ;
    private com.baidu.adp.lib.stats.b mBdLogSetting;
    private String uid;
    private final SimpleDateFormat alG = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> alH = new ConcurrentHashMap<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.adp.lib.stats.b.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 6:
                    for (Map.Entry entry : g.this.alH.entrySet()) {
                        com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                        if (aVar.nO() > 0) {
                            g.this.a(aVar, true, true);
                        }
                        if (aVar.nN() > 0) {
                            d.c(aVar, true, true, true);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private i alc = new i() { // from class: com.baidu.adp.lib.stats.b.g.5
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

    public static g oi() {
        if (alF == null) {
            synchronized (g.class) {
                if (alF == null) {
                    alF = new g();
                }
            }
        }
        return alF;
    }

    public void init() {
        if (this.alJ == null) {
            this.alJ = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.alJ, intentFilter);
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
                g.this.oj();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a p(String str, String str2) {
        String ay;
        com.baidu.adp.lib.stats.base.a aVar = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (aVar = this.alH.get((ay = com.baidu.adp.lib.stats.base.a.ay(str)))) == null) {
                if ("alert".equals(ay)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(null);
                } else if ("error".equals(ay)) {
                    aVar = new c(this.alc);
                } else if ("dbg".equals(ay)) {
                    aVar = new b(this.alc);
                } else if ("stat".equals(ay)) {
                    aVar = new f(this.alc);
                } else if ("pfmonitor".equals(ay)) {
                    aVar = new e(this.alc);
                } else {
                    aVar = new c(this.alc);
                }
                if (aVar != null) {
                    aVar.ax(ay);
                    this.alH.put(ay, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a p;
        if (str != null || str2 != null) {
            if ((aVar != null || (objArr != null && objArr.length != 0)) && (p = p(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.oa().isWrite(str, str2)) {
                if (aVar == null) {
                    aVar = new com.baidu.adp.lib.stats.a(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    aVar.h("module", str, TimeDisplaySetting.START_SHOW_TIME, str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    aVar.h(objArr);
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
                    aVar.h(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        aVar.append("ismainproc", "1");
                    } else {
                        aVar.append("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.oa().isUpload(str, str2)) {
                    p.a(aVar);
                } else {
                    p.b(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.nJ() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.oa().isExactWriteFile(aVar.nR())) {
            z = true;
        }
        return aVar.nG() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.nK() >= 60000;
        if (com.baidu.adp.lib.stats.switchs.a.oa().isExactWriteFile(aVar.nR())) {
            z = true;
        }
        return aVar.nH() < 10 ? z : true;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void oj() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.alH.entrySet()) {
            e(entry.getValue());
        }
    }

    public void ok() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.alH.entrySet()) {
            d(entry.getValue());
        }
    }

    public void ol() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.alH.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aD(String str) {
        com.baidu.adp.lib.stats.base.a p = oi().p(str, null);
        a(p, false, true);
        d(p);
    }

    public void om() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.alH.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        on();
    }

    private void on() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.nG() > 0) {
                d(aVar, true);
            } else if (aVar.nN() > 0) {
                d.c(aVar, false, false, false);
            }
        }
    }

    public void a(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2) {
        if (aVar != null && aVar.nO() > 0) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nL(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nM(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void W(boolean z3) {
                    super.W(z3);
                    if (z3) {
                        aVar.s(0L);
                        com.baidu.adp.lib.stats.upload.b.og().a(aVar, z, true, z2);
                    }
                }
            };
            diskFileOperate.ab(aVar.nW());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
        }
    }

    public void oo() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.alH.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.mBdLogSetting != null) {
                long av = this.mBdLogSetting.av(value.nR());
                if (av <= 0) {
                    av = System.currentTimeMillis();
                    this.mBdLogSetting.d(value.nR(), av);
                }
                value.q(av);
            }
            if (value != null) {
                if (value.nG() > 0) {
                    d(value, false);
                }
                if (value.nN() > 102400) {
                    d.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.nI() >= BdStatisticsManager.getInstance().getUploadInterval()) {
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
        if (aVar != null && aVar.nH() != 0) {
            if (aVar.nO() > 102400) {
                DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nL(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nM(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.g.3
                    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                    public void W(boolean z) {
                        super.W(z);
                        if (z) {
                            aVar.s(0L);
                        }
                    }
                };
                diskFileOperate.ab(aVar.nW());
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
            }
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.nL(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.g.4
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void W(boolean z) {
                    super.W(z);
                    if (z) {
                        aVar.s(lz().length());
                    }
                }
            };
            dVar.ab(aVar.nW());
            dVar.setContent(aVar.nV().toString());
            aVar.nQ();
            if (!aVar.nX()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.cP(3);
            }
            if (!com.baidu.adp.lib.Disk.d.ll().c(dVar)) {
            }
        }
    }

    public void op() {
        if (this.alI == null) {
            this.alI = new h();
        }
        this.alI.op();
    }
}
