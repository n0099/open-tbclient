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
    private static volatile i xv;
    private String uid;
    private com.baidu.adp.lib.stats.e wb;
    private o xy;
    private a xz;
    private final SimpleDateFormat xw = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xx = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p wT = new k(this);

    public static i il() {
        if (xv == null) {
            synchronized (i.class) {
                if (xv == null) {
                    xv = new i();
                }
            }
        }
        return xv;
    }

    public void init() {
        if (this.xz == null) {
            this.xz = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xz, intentFilter);
        }
        this.wb = com.baidu.adp.lib.stats.a.hh().hi();
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
                i.this.im();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String au = com.baidu.adp.lib.stats.base.a.au(str);
            aVar = this.xx.get(au);
            if (aVar == null) {
                if ("error".equals(au)) {
                    aVar = new b(this.wT);
                } else if ("dbg".equals(au)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.wT);
                } else if ("stat".equals(au)) {
                    aVar = new h(this.wT);
                } else if ("pfmonitor".equals(au)) {
                    aVar = new g(this.wT);
                } else {
                    aVar = new b(this.wT);
                }
                if (aVar != null) {
                    aVar.at(au);
                    this.xx.put(au, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ic().isWrite(str, str2)) {
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
                    if (com.baidu.adp.lib.stats.a.hh().ho()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ic().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.hL() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ic().isExactWriteFile(aVar.hT())) {
            z = true;
        }
        return aVar.hI() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hM() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ic().isExactWriteFile(aVar.hT())) {
            z = true;
        }
        return aVar.hJ() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void im() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            e(entry.getValue());
        }
    }

    public void in() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            d(entry.getValue());
        }
    }

    public void io() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void az(String str) {
        com.baidu.adp.lib.stats.base.a r = il().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void ip() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        iq();
    }

    private void iq() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hI() > 0) {
                d(aVar, true);
            } else if (aVar.hP() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.hQ() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hh().hm(), aVar.hN(), com.baidu.adp.lib.stats.a.hh().hm(), aVar.hO(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.hY());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(lVar);
        }
    }

    public void ir() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xx.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wb != null) {
                long ar = this.wb.ar(value.hT());
                if (ar <= 0) {
                    ar = System.currentTimeMillis();
                    this.wb.d(value.hT(), ar);
                }
                value.f(ar);
            }
            if (value != null) {
                if (value.hI() > 0) {
                    d(value, false);
                }
                if (value.hP() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hK() >= 3600000) {
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
        if (aVar != null && aVar.hJ() != 0) {
            if (aVar.hQ() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hh().hm(), aVar.hN(), com.baidu.adp.lib.stats.a.hh().hm(), aVar.hO(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.hY());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fj().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hh().hm(), aVar.hN(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.hY());
            nVar.setContent(aVar.hX().toString());
            aVar.hS();
            if (!aVar.hZ()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(nVar);
        }
    }

    public void is() {
        if (this.xy == null) {
            this.xy = new o();
        }
        this.xy.is();
    }
}
