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

    public static i im() {
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
        this.wc = com.baidu.adp.lib.stats.a.hi().hj();
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
                i.this.in();
            }
        }
    }

    public synchronized com.baidu.adp.lib.stats.base.a r(String str, String str2) {
        com.baidu.adp.lib.stats.base.a aVar;
        if (TextUtils.isEmpty(str)) {
            aVar = null;
        } else {
            String au = com.baidu.adp.lib.stats.base.a.au(str);
            aVar = this.xy.get(au);
            if (aVar == null) {
                if ("error".equals(au)) {
                    aVar = new b(this.wU);
                } else if ("dbg".equals(au)) {
                    aVar = new com.baidu.adp.lib.stats.b.a(this.wU);
                } else if ("stat".equals(au)) {
                    aVar = new h(this.wU);
                } else if ("pfmonitor".equals(au)) {
                    aVar = new g(this.wU);
                } else {
                    aVar = new b(this.wU);
                }
                if (aVar != null) {
                    aVar.at(au);
                    this.xy.put(au, aVar);
                }
            }
        }
        return aVar;
    }

    public void a(String str, String str2, String str3, String str4, com.baidu.adp.lib.stats.d dVar, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r;
        if (str != null || str2 != null) {
            if ((dVar != null || (objArr != null && objArr.length != 0)) && (r = r(str, str2)) != null && com.baidu.adp.lib.stats.switchs.a.id().isWrite(str, str2)) {
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
                    if (com.baidu.adp.lib.stats.a.hi().hp()) {
                        dVar.q("ismainproc", "1");
                    } else {
                        dVar.q("ismainproc", "0");
                    }
                }
                if (com.baidu.adp.lib.stats.switchs.a.id().isUpload(str, str2)) {
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
        boolean z = System.currentTimeMillis() - aVar.hM() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.id().isExactWriteFile(aVar.hU())) {
            z = true;
        }
        return aVar.hJ() < 10 ? z : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean z = System.currentTimeMillis() - aVar.hN() >= TbConfig.USE_TIME_INTERVAL;
        if (com.baidu.adp.lib.stats.switchs.a.id().isExactWriteFile(aVar.hU())) {
            z = true;
        }
        return aVar.hK() < 10 ? z : true;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void in() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            e(entry.getValue());
        }
    }

    public void io() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            d(entry.getValue());
        }
    }

    public void ip() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            a(value, false, false);
            d(value);
        }
    }

    public void az(String str) {
        com.baidu.adp.lib.stats.base.a r = im().r(str, null);
        a(r, false, true);
        d(r);
    }

    public void iq() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            e(value);
            f(value);
        }
        ir();
    }

    private void ir() {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        this.mHandler.removeMessages(6);
        this.mHandler.sendMessageDelayed(obtainMessage, 3000L);
    }

    public void d(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            if (aVar.hJ() > 0) {
                d(aVar, true);
            } else if (aVar.hQ() > 0) {
                c.c(aVar, false, false, false);
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        if (aVar != null && aVar.hR() > 0) {
            l lVar = new l(this, com.baidu.adp.lib.stats.a.hi().hn(), aVar.hO(), com.baidu.adp.lib.stats.a.hi().hn(), aVar.hP(), DiskFileOperate.Action.RENAME, aVar, z, z2);
            lVar.q(aVar.hZ());
            lVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(lVar);
        }
    }

    public void is() {
        for (Map.Entry<String, com.baidu.adp.lib.stats.base.a> entry : this.xy.entrySet()) {
            com.baidu.adp.lib.stats.base.a value = entry.getValue();
            if (this.wc != null) {
                long ar = this.wc.ar(value.hU());
                if (ar <= 0) {
                    ar = System.currentTimeMillis();
                    this.wc.d(value.hU(), ar);
                }
                value.h(ar);
            }
            if (value != null) {
                if (value.hJ() > 0) {
                    d(value, false);
                }
                if (value.hQ() > 102400) {
                    c.c(value, false, false, false);
                } else if (System.currentTimeMillis() - value.hL() >= 3600000) {
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
        if (aVar != null && aVar.hK() != 0) {
            if (aVar.hR() > 102400) {
                m mVar = new m(this, com.baidu.adp.lib.stats.a.hi().hn(), aVar.hO(), com.baidu.adp.lib.stats.a.hi().hn(), aVar.hP(), DiskFileOperate.Action.RENAME, aVar);
                mVar.q(aVar.hZ());
                mVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                com.baidu.adp.lib.Disk.d.fj().c(mVar);
            }
            n nVar = new n(this, com.baidu.adp.lib.stats.a.hi().hn(), aVar.hO(), DiskFileOperate.Action.APPEND, aVar);
            nVar.q(aVar.hZ());
            nVar.setContent(aVar.hY().toString());
            aVar.hT();
            if (!aVar.ia()) {
                nVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                nVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(nVar);
        }
    }

    public void it() {
        if (this.xz == null) {
            this.xz = new o();
        }
        this.xz.it();
    }
}
