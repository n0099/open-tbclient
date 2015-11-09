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
    private static volatile i xw;
    private String uid;
    private com.baidu.adp.lib.stats.e wc;
    private a xA;
    private o xz;
    private final SimpleDateFormat xx = new SimpleDateFormat("yy-MM-dd_HH-mm-ss_SSS", Locale.getDefault());
    private final ConcurrentHashMap<String, com.baidu.adp.lib.stats.base.a> xy = new ConcurrentHashMap<>();
    private Handler mHandler = new j(this, Looper.getMainLooper());
    private p wU = new k(this);

    public static i in() {
        if (xw == null) {
            synchronized (i.class) {
                if (xw == null) {
                    xw = new i();
                }
            }
        }
        return xw;
    }

    public void init() {
        if (this.xA == null) {
            this.xA = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xA, intentFilter);
        }
        this.wc = com.baidu.adp.lib.stats.a.hj().hk();
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
                i.this.io();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String as = com.baidu.adp.lib.stats.base.a.as(str);
            aVar = this.xy.get(as);
            if (aVar == null) {
                if ("error".equals(as)) {
                    aVar = new b(this.wU);
                } else if ("dbg".equals(as)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.wU);
                } else if ("stat".equals(as)) {
                    aVar = new h(this.wU);
                } else if ("pfmonitor".equals(as)) {
                    aVar = new g(this.wU);
                } else {
                    aVar = new b(this.wU);
                }
                if (aVar != null) {
                    aVar.ar(as);
                    this.xy.put(as, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.ie().isWrite(str, str2)) {
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
                    if (com.baidu.adp.lib.stats.a.hj().hq()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.ie().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.hN() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ie().isExactWriteFile(aVar.hV())) {
            z = true;
        }
        return aVar.hK() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hO() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.ie().isExactWriteFile(aVar.hV())) {
            z = true;
        }
        return aVar.hL() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void io() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            e(entry.getValue());
        }
    }

    public void ip() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            d(entry.getValue());
        }
    }

    public void iq() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void ax(String str) {
        com.baidu.adp.lib.stats.base.a r = in().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void ir() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        is();
    }

    private void is() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hK() > 0) {
                d(aVar, true);
            } else if (aVar.hR() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.hS() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hj().ho(), aVar.hP(), com.baidu.adp.lib.stats.a.hj().ho(), aVar.hQ(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.ia());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(lVar);
        }
    }

    public void it() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wc != null) {
                long ap = this.wc.ap(value.hV());
                if (ap <= 0) {
                    ap = System.currentTimeMillis();
                    this.wc.d(value.hV(), ap);
                }
                value.f(ap);
            }
            if (value != null) {
                if (value.hK() > 0) {
                    d(value, false);
                }
                if (value.hR() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hM() >= 3600000) {
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
        if (aVar != null && aVar.hL() != 0) {
            if (aVar.hS() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hj().ho(), aVar.hP(), com.baidu.adp.lib.stats.a.hj().ho(), aVar.hQ(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.ia());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fj().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hj().ho(), aVar.hP(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.ia());
            nVar.setContent(aVar.hZ().toString());
            aVar.hU();
            if (!aVar.ib()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(nVar);
        }
    }

    public void iu() {
        if (this.xz == null) {
            this.xz = new o();
        }
        this.xz.iu();
    }
}
