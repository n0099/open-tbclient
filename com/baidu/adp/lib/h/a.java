package com.baidu.adp.lib.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.stats.r;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private Context mContext;
    private String mProcessNameMd5;
    private String wp;
    private r wt;
    private boolean wu;
    private String xB;
    private d xD;
    private static a xA = null;
    private static final Handler mHandler = new b();
    private boolean xC = false;
    private com.baidu.adp.lib.stats.switchs.c xE = new c(this);

    public static synchronized a iB() {
        a aVar;
        synchronized (a.class) {
            if (xA == null) {
                synchronized (a.class) {
                    if (xA == null) {
                        xA = new a();
                    }
                }
            }
            aVar = xA;
        }
        return aVar;
    }

    public r hx() {
        return this.wt;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, e eVar, r rVar) {
        this.mContext = context;
        this.xB = str3;
        this.wu = z;
        this.wt = rVar;
        com.baidu.adp.lib.Disk.d.fp().P(str2);
        com.baidu.adp.lib.stats.switchs.a.ip().a(z, str, this.mContext, this.xE);
        com.baidu.adp.lib.stats.upload.b.iv().a(eVar, str4);
        com.baidu.adp.lib.stats.b.i.iw().init();
        if (eVar != null) {
            this.wp = eVar.wp;
        }
        if (TextUtils.isEmpty(this.mProcessNameMd5)) {
            this.mProcessNameMd5 = hw();
            if (z && this.mProcessNameMd5 == null) {
                this.mProcessNameMd5 = "44f94582";
            }
        }
        try {
            if (this.xD == null && this.mContext != null) {
                this.xD = new d(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                this.mContext.registerReceiver(this.xD, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        hG();
    }

    public long io() {
        return com.baidu.adp.lib.stats.a.a.in().io();
    }

    private String hw() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this.mContext == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= runningAppProcesses.size()) {
                    break;
                }
                if (runningAppProcesses.get(i2).pid == myPid) {
                    String str = runningAppProcesses.get(i2).processName;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            String p = ac.p(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(p) && p.length() > 8) {
                                return p.substring(p.length() - 8);
                            }
                            return p;
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(e.getMessage());
                            return str;
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        return null;
    }

    public String iC() {
        return this.xB;
    }

    public String iD() {
        return this.mProcessNameMd5;
    }

    public void ix() {
        com.baidu.adp.lib.stats.b.i.iw().ix();
    }

    public boolean iE() {
        return this.wu;
    }

    public void b(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            com.baidu.adp.lib.stats.switchs.a.ip().a(str, str2, bdUploadStatMsgData);
        }
    }

    public void aG(String str) {
        com.baidu.adp.lib.stats.b.i.iw().e(com.baidu.adp.lib.stats.b.i.iw().s(str, null));
    }

    public void t(String str, String str2) {
        com.baidu.adp.lib.stats.b.i.iw().e(com.baidu.adp.lib.stats.b.i.iw().s(str, str2));
    }

    public void iF() {
        com.baidu.adp.lib.stats.b.i.iw().iy();
    }

    public void iG() {
        com.baidu.adp.lib.stats.b.i.iw().iz();
        if (this.wu) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
            intent.putExtra("intent_data_multiprocess_type", 4);
            this.mContext.sendBroadcast(intent);
        }
    }

    public void iH() {
        com.baidu.adp.lib.stats.b.i.iw().iA();
    }

    public void hG() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void b(String str, long j, String str2, q qVar) {
        a("dbg", str, j, str2, qVar, new Object[0]);
    }

    public void a(String str, long j, String str2, Object... objArr) {
        a("dbg", str, j, str2, (q) null, objArr);
    }

    public void a(String str, long j, String str2, q qVar) {
        a("pfmonitor", str, j, str2, qVar, new Object[0]);
    }

    public void c(String str, long j, String str2, q qVar) {
        a("error", str, j, str2, qVar, new Object[0]);
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        q qVar = new q("stat");
        qVar.r("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            qVar.r("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            qVar.r("pt", str2);
        }
        qVar.f("co", Integer.valueOf(i));
        qVar.r(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            qVar.f(objArr);
            qVar.b("mi", 0);
        }
        a("stat", "stat", -1L, (String) null, qVar, new Object[0]);
    }

    private void a(String str, String str2, long j, String str3, q qVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !g.iI().aw(str)) {
            if (j == -1) {
                com.baidu.adp.lib.stats.b.i.iw().a(str, str2, null, str3, qVar, objArr);
            } else {
                com.baidu.adp.lib.stats.b.i.iw().a(str, str2, String.valueOf(j), str3, qVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s = com.baidu.adp.lib.stats.b.i.iw().s(str, null);
        if (s != null && com.baidu.adp.lib.stats.switchs.a.ip().isWrite(str, null)) {
            q qVar = new q(str);
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            s.add(qVar);
        }
    }

    public void a(String str, String str2, long j, String str3, String str4, long j2, long j3, long j4, long j5, long j6, int i, int i2, String str5, Object... objArr) {
        if (!g.iI().aw("net")) {
            q qVar = new q("net");
            qVar.f("net", f.getNetType(this.mContext), "interface", str2, "cost", String.valueOf(j4));
            if (objArr != null && objArr.length > 0) {
                qVar.f(objArr);
            }
            if (i2 != 0) {
                qVar.b("result", Integer.valueOf(i2));
                qVar.b("es", str5);
            }
            if (j5 > 0) {
                qVar.b(TiebaStatic.CON_COST, Long.valueOf(j5));
            }
            if (j3 > 0) {
                qVar.b("size_u", Long.valueOf(j3));
            }
            if (j2 > 0) {
                qVar.b("size_d", Long.valueOf(j2));
            }
            if (j6 > 0) {
                qVar.b("rsp_cost", Long.valueOf(j6));
            }
            if (!TextUtils.isEmpty(str4)) {
                qVar.b("f", str4);
            }
            if (i > 0) {
                qVar.b("retry", Integer.valueOf(i));
            }
            a("net", str, j, str3, qVar, new Object[0]);
        }
    }

    public void a(boolean z, String str, String str2, long j, String str3, String str4, long j2, int i, String str5, Object... objArr) {
        q qVar = new q("op");
        qVar.f("op_key", str2, "f", str4, "cost", String.valueOf(j2), "result", String.valueOf(i), "es", str5);
        if (objArr != null && objArr.length > 0) {
            qVar.f(objArr);
        }
        a("op", str, j, str3, qVar, new Object[0]);
    }

    public void a(String str, long j, String str2, String str3, String str4, Object... objArr) {
        q qVar = new q("crash");
        qVar.r("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            qVar.r("crash_type", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            qVar.r("ci", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            qVar.r("f", str4);
        }
        qVar.r(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            qVar.f(objArr);
        }
        a("crash", "crash", j, str2, qVar, new Object[0]);
    }
}
