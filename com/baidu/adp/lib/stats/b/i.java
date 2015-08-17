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
    private static volatile i xx;
    private String uid;
    private com.baidu.adp.lib.stats.e wd;
    private o xA;
    private a xB;
    private final SimpleDateFormat xy = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xz = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p wV = new k(this);

    public static i io() {
        if (xx == null) {
            synchronized (i.class) {
                if (xx == null) {
                    xx = new i();
                }
            }
        }
        return xx;
    }

    public void init() {
        if (this.xB == null) {
            this.xB = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xB, intentFilter);
        }
        this.wd = com.baidu.adp.lib.stats.a.hk().hl();
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
                i.this.ip();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String au = com.baidu.adp.lib.stats.base.a.au(str);
            aVar = this.xz.get(au);
            if (aVar == null) {
                if ("error".equals(au)) {
                    aVar = new b(this.wV);
                } else if ("dbg".equals(au)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.wV);
                } else if ("stat".equals(au)) {
                    aVar = new h(this.wV);
                } else if ("pfmonitor".equals(au)) {
                    aVar = new g(this.wV);
                } else {
                    aVar = new b(this.wV);
                }
                if (aVar != null) {
                    aVar.at(au);
                    this.xz.put(au, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ig().isWrite(str, str2)) {
                if (dVar == null) {
                    dVar = new com.baidu.adp.lib.stats.d(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    dVar.e("module", str, "st", str2, Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    dVar.e(objArr);
                }
                if (this.uid != null && !str.equals("stat")) {
                    dVar.q("uid", this.uid);
                }
                if (str3 != null && !str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.q("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat") && !str.equals("pfmonitor")) {
                    dVar.q("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    dVar.q("net", com.baidu.adp.lib.stats.g.F(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    if (com.baidu.adp.lib.stats.a.hk().hr()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ig().isUpload(str, str2)) {
                    r.a(dVar);
                } else {
                    r.b(dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hO() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ig().isExactWriteFile(aVar.hW())) {
            z = true;
        }
        return aVar.hL() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hP() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ig().isExactWriteFile(aVar.hW())) {
            z = true;
        }
        return aVar.hM() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void ip() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xz.entrySet()) {
            e(entry.getValue());
        }
    }

    public void iq() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xz.entrySet()) {
            d(entry.getValue());
        }
    }

    public void ir() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xz.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void az(String str) {
        com.baidu.adp.lib.stats.base.a r = io().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void is() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xz.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        it();
    }

    private void it() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hL() > 0) {
                d(aVar, true);
            } else if (aVar.hS() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.hT() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hk().hp(), aVar.hQ(), com.baidu.adp.lib.stats.a.hk().hp(), aVar.hR(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.ib());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fm().c(lVar);
        }
    }

    public void iu() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xz.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wd != null) {
                long ar = this.wd.ar(value.hW());
                if (ar <= 0) {
                    ar = System.currentTimeMillis();
                    this.wd.d(value.hW(), ar);
                }
                value.f(ar);
            }
            if (value != null) {
                if (value.hL() > 0) {
                    d(value, false);
                }
                if (value.hS() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hN() >= 3600000) {
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
        if (aVar != null && aVar.hM() != 0) {
            if (aVar.hT() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hk().hp(), aVar.hQ(), com.baidu.adp.lib.stats.a.hk().hp(), aVar.hR(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.ib());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fm().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hk().hp(), aVar.hQ(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.ib());
            nVar.setContent(aVar.ia().toString());
            aVar.hV();
            if (!aVar.ic()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fm().c(nVar);
        }
    }

    public void iv() {
        if (this.xA == null) {
            this.xA = new o();
        }
        this.xA.iv();
    }
}
