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
    private static volatile i xC;
    private String uid;
    private com.baidu.adp.lib.stats.e wi;
    private o xF;
    private a xG;
    private final SimpleDateFormat xD = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xE = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p xa = new k(this);

    public static i ip() {
        if (xC == null) {
            synchronized (i.class) {
                if (xC == null) {
                    xC = new i();
                }
            }
        }
        return xC;
    }

    public void init() {
        if (this.xG == null) {
            this.xG = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xG, intentFilter);
        }
        this.wi = com.baidu.adp.lib.stats.a.hl().hm();
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
                i.this.iq();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String aw = com.baidu.adp.lib.stats.base.a.aw(str);
            aVar = this.xE.get(aw);
            if (aVar == null) {
                if ("error".equals(aw)) {
                    aVar = new b(this.xa);
                } else if ("dbg".equals(aw)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.xa);
                } else if ("stat".equals(aw)) {
                    aVar = new h(this.xa);
                } else if ("pfmonitor".equals(aw)) {
                    aVar = new g(this.xa);
                } else {
                    aVar = new b(this.xa);
                }
                if (aVar != null) {
                    aVar.av(aw);
                    this.xE.put(aw, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ih().isWrite(str, str2)) {
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
                    if (com.baidu.adp.lib.stats.a.hl().hs()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ih().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.hP() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ih().isExactWriteFile(aVar.hX())) {
            z = true;
        }
        return aVar.hM() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hQ() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ih().isExactWriteFile(aVar.hX())) {
            z = true;
        }
        return aVar.hN() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void iq() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xE.entrySet()) {
            e(entry.getValue());
        }
    }

    public void ir() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xE.entrySet()) {
            d(entry.getValue());
        }
    }

    public void is() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xE.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void aB(String str) {
        com.baidu.adp.lib.stats.base.a r = ip().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void it() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xE.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        iu();
    }

    private void iu() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hM() > 0) {
                d(aVar, true);
            } else if (aVar.hT() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.hU() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hl().hq(), aVar.hR(), com.baidu.adp.lib.stats.a.hl().hq(), aVar.hS(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.ic());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(lVar);
        }
    }

    public void iv() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xE.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wi != null) {
                long at = this.wi.at(value.hX());
                if (at <= 0) {
                    at = System.currentTimeMillis();
                    this.wi.d(value.hX(), at);
                }
                value.f(at);
            }
            if (value != null) {
                if (value.hM() > 0) {
                    d(value, false);
                }
                if (value.hT() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hO() >= 3600000) {
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
        if (aVar != null && aVar.hN() != 0) {
            if (aVar.hU() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hl().hq(), aVar.hR(), com.baidu.adp.lib.stats.a.hl().hq(), aVar.hS(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.ic());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fj().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hl().hq(), aVar.hR(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.ic());
            nVar.setContent(aVar.ib().toString());
            aVar.hW();
            if (!aVar.id()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.J(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(nVar);
        }
    }

    public void iw() {
        if (this.xF == null) {
            this.xF = new o();
        }
        this.xF.iw();
    }
}
