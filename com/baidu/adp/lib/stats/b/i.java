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
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class i {
    private static volatile i ye;
    private String uid;
    private com.baidu.adp.lib.stats.e wK;
    private o yh;
    private a yi;
    private final SimpleDateFormat yf = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> yg = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p xC = new k(this);

    public static i iF() {
        if (ye == null) {
            synchronized (i.class) {
                if (ye == null) {
                    ye = new i();
                }
            }
        }
        return ye;
    }

    public void init() {
        if (this.yi == null) {
            this.yi = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.yi, intentFilter);
        }
        this.wK = com.baidu.adp.lib.stats.a.hz().hA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                i.this.setUid(intent.getStringExtra("intent_data_userid"));
                i.this.iG();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a s(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String ax = com.baidu.adp.lib.stats.base.a.ax(str);
            aVar = this.yg.get(ax);
            if (aVar == null) {
                if ("error".equals(ax)) {
                    aVar = new b(this.xC);
                } else if ("dbg".equals(ax)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.xC);
                } else if ("stat".equals(ax)) {
                    aVar = new h(this.xC);
                } else if ("pfmonitor".equals(ax)) {
                    aVar = new g(this.xC);
                } else {
                    aVar = new b(this.xC);
                }
                if (aVar != null) {
                    aVar.aw(ax);
                    this.yg.put(ax, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (s = s(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ix().isWrite(str, str2)) {
                if (dVar == null) {
                    dVar = new com.baidu.adp.lib.stats.d(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    dVar.b("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    dVar.b(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    dVar.r("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat")) {
                    dVar.r("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    dVar.r("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    dVar.r("net", com.baidu.adp.lib.stats.g.w(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.b(Info.kBaiduPIDKey, Integer.valueOf(Process.myPid()));
                    if (com.baidu.adp.lib.stats.a.hz().hG()) {
                        dVar.r("ismainproc", "1");
                    } else {
                        dVar.r("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ix().isUpload(str, str2)) {
                    s.a(dVar);
                } else {
                    s.b(dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.ie() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ix().isExactWriteFile(aVar.io())) {
            z = true;
        }
        return aVar.ia() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.ig() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ix().isExactWriteFile(aVar.io())) {
            z = true;
        }
        return aVar.ib() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void iG() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yg.entrySet()) {
            e(entry.getValue());
        }
    }

    public void iH() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yg.entrySet()) {
            d(entry.getValue());
        }
    }

    public void iI() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aC(String str) {
        com.baidu.adp.lib.stats.base.a s = iF().s(str, null);
        a(s, false, true);
        d(s);
    }

    public void iJ() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        iK();
    }

    private void iK() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.ia() > 0) {
                d(aVar, true);
            } else if (aVar.ij() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.ik() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hz().hE(), aVar.ih(), com.baidu.adp.lib.stats.a.hz().hE(), aVar.ii(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.p(aVar.it());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fs().c(lVar);
        }
    }

    public void iL() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.yg.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wK != null) {
                long au = this.wK.au(value.io());
                if (au <= 0) {
                    au = System.currentTimeMillis();
                    this.wK.d(value.io(), au);
                }
                value.f(au);
            }
            if (value != null) {
                if (value.ia() > 0) {
                    d(value, false);
                }
                if (value.ij() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.ic() >= 3600000) {
                    c.c(value, false, false, false);
                }
            }
        }
    }

    public void e(com.baidu.adp.lib.stats.base.a aVar) {
        d(aVar, false);
    }

    private void d(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            if (c.a(aVar) > 102400) {
                c.c(aVar, false, false, false);
            }
            c.c(aVar, z);
        }
    }

    public void f(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null && aVar.ib() != 0) {
            if (aVar.ik() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hz().hE(), aVar.ih(), com.baidu.adp.lib.stats.a.hz().hE(), aVar.ii(), DiskFileOperate.Action.RENAME, aVar);
                mVar.p(aVar.it());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fs().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hz().hE(), aVar.ih(), DiskFileOperate.Action.APPEND, aVar);
            nVar.p(aVar.it());
            nVar.setContent(aVar.is().toString());
            aVar.in();
            if (!aVar.iu()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.T(3);
            }
            com.baidu.adp.lib.Disk.d.fs().c(nVar);
        }
    }

    public void iM() {
        if (this.yh == null) {
            this.yh = new o();
        }
        this.yh.iM();
    }
}
