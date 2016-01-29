package com.baidu.adp.lib.stats.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
    private static volatile i xN;
    private String uid;
    private com.baidu.adp.lib.stats.e wt;
    private o xQ;
    private a xR;
    private final SimpleDateFormat xO = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xP = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p xl = new k(this);

    public static i iz() {
        if (xN == null) {
            synchronized (i.class) {
                if (xN == null) {
                    xN = new i();
                }
            }
        }
        return xN;
    }

    public void init() {
        if (this.xR == null) {
            this.xR = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xR, intentFilter);
        }
        this.wt = com.baidu.adp.lib.stats.a.ht().hu();
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
                i.this.iA();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a s(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String av = com.baidu.adp.lib.stats.base.a.av(str);
            aVar = this.xP.get(av);
            if (aVar == null) {
                if ("error".equals(av)) {
                    aVar = new b(this.xl);
                } else if ("dbg".equals(av)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.xl);
                } else if ("stat".equals(av)) {
                    aVar = new h(this.xl);
                } else if ("pfmonitor".equals(av)) {
                    aVar = new g(this.xl);
                } else {
                    aVar = new b(this.xl);
                }
                if (aVar != null) {
                    aVar.au(av);
                    this.xP.put(av, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (s = s(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ir().isWrite(str, str2)) {
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
                if (str3 != null && !str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.r("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.r("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    dVar.r("net", com.baidu.adp.lib.stats.g.F(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    if (com.baidu.adp.lib.stats.a.ht().hA()) {
                        dVar.r("ismainproc", "1");
                    } else {
                        dVar.r("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ir().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.hX() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ir().isExactWriteFile(aVar.ih())) {
            z = true;
        }
        return aVar.hU() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hY() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ir().isExactWriteFile(aVar.ih())) {
            z = true;
        }
        return aVar.hV() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void iA() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xP.entrySet()) {
            e(entry.getValue());
        }
    }

    public void iB() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xP.entrySet()) {
            d(entry.getValue());
        }
    }

    public void iC() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xP.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aA(String str) {
        com.baidu.adp.lib.stats.base.a s = iz().s(str, null);
        a(s, false, true);
        d(s);
    }

    public void iD() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xP.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        iE();
    }

    private void iE() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hU() > 0) {
                d(aVar, true);
            } else if (aVar.ib() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.ic() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.ht().hy(), aVar.hZ(), com.baidu.adp.lib.stats.a.ht().hy(), aVar.ia(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.in());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fr().c(lVar);
        }
    }

    public void iF() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xP.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wt != null) {
                long as = this.wt.as(value.ih());
                if (as <= 0) {
                    as = System.currentTimeMillis();
                    this.wt.d(value.ih(), as);
                }
                value.f(as);
            }
            if (value != null) {
                if (value.hU() > 0) {
                    d(value, false);
                }
                if (value.ib() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hW() >= 3600000) {
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
        if (aVar != null && aVar.hV() != 0) {
            if (aVar.ic() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.ht().hy(), aVar.hZ(), com.baidu.adp.lib.stats.a.ht().hy(), aVar.ia(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.in());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fr().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.ht().hy(), aVar.hZ(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.in());
            nVar.setContent(aVar.il().toString());
            aVar.ig();
            if (!aVar.io()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.U(3);
            }
            com.baidu.adp.lib.Disk.d.fr().c(nVar);
        }
    }

    public void iG() {
        if (this.xQ == null) {
            this.xQ = new o();
        }
        this.xQ.iG();
    }
}
