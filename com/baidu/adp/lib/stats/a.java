package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.stats.switchs.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private Context mContext;
    private String vW;
    private String vX;
    private String vY;
    private boolean vZ;
    private String wa;
    private e wc;
    private C0005a wd;
    private static a vV = null;
    private static final Handler mHandler = new b();
    private boolean wb = false;
    private a.InterfaceC0006a we = new c(this);

    public static synchronized a hj() {
        a aVar;
        synchronized (a.class) {
            if (vV == null) {
                synchronized (a.class) {
                    if (vV == null) {
                        vV = new a();
                    }
                }
            }
            aVar = vV;
        }
        return aVar;
    }

    public e hk() {
        return this.wc;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.vX = str3;
        this.vY = String.valueOf(this.vX) + "/notUpload";
        this.vZ = z;
        this.wc = eVar;
        com.baidu.adp.lib.Disk.d.fj().M(str2);
        com.baidu.adp.lib.stats.switchs.a.ie().a(z, str, this.mContext, this.we);
        com.baidu.adp.lib.stats.upload.b.il().a(fVar, str4);
        com.baidu.adp.lib.stats.b.i.in().init();
        if (fVar != null) {
            this.wa = fVar.wa;
        }
        if (TextUtils.isEmpty(this.vW)) {
            this.vW = hm();
            if (z && this.vW == null) {
                this.vW = "44f94582";
            }
        }
        try {
            if (this.wd == null && this.mContext != null) {
                this.wd = new C0005a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                this.mContext.registerReceiver(this.wd, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        hu();
    }

    public long hl() {
        return com.baidu.adp.lib.stats.a.a.id().hl();
    }

    private String hm() {
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
                            String B = t.B(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(B) && B.length() > 8) {
                                return B.substring(B.length() - 8);
                            }
                            return B;
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

    public String hn() {
        return this.vX;
    }

    public String ho() {
        return this.vY;
    }

    public String hp() {
        return this.vW;
    }

    public void f(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.il().f(str, str2, str3);
    }

    public void save() {
        com.baidu.adp.lib.stats.b.i.in().io();
    }

    public boolean hq() {
        return this.vZ;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            hs();
            com.baidu.adp.lib.stats.switchs.a.ie().b(str, str2, bdUploadStatMsgData);
        }
    }

    /* renamed from: com.baidu.adp.lib.stats.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0005a extends BroadcastReceiver {
        private C0005a() {
        }

        /* synthetic */ C0005a(a aVar, C0005a c0005a) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("intent_data_multiprocess_type", 0) == 4 && !a.this.vZ) {
                com.baidu.adp.lib.stats.b.i.in().ir();
            }
        }
    }

    public void al(String str) {
        com.baidu.adp.lib.stats.b.i.in().d(com.baidu.adp.lib.stats.b.i.in().r(str, null));
    }

    public void hr() {
        com.baidu.adp.lib.stats.b.i.in().ip();
    }

    public void hs() {
        com.baidu.adp.lib.stats.b.i.in().ir();
        if (this.vZ) {
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
            intent.putExtra("intent_data_multiprocess_type", 4);
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht() {
        com.baidu.adp.lib.stats.b.i.in().it();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void am(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            a("pfmonitor", str, -1L, (String) null, dVar, new Object[0]);
        }
    }

    public void b(String str, Object... objArr) {
        a("dbg", str, -1L, (String) null, (d) null, objArr);
    }

    public void b(String str, d dVar) {
        if (dVar != null) {
            a(str, -1L, (String) null, dVar);
        }
    }

    public void a(String str, long j, String str2, d dVar) {
        a("dbg", str, j, str2, dVar, new Object[0]);
    }

    public void a(String str, long j, String str2, Object... objArr) {
        a("dbg", str, j, str2, (d) null, objArr);
    }

    public void b(String str, long j, String str2, d dVar) {
        a("error", str, j, str2, dVar, new Object[0]);
    }

    public void b(String str, long j, String str2, Object... objArr) {
        a("error", str, j, str2, (d) null, objArr);
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        d dVar = new d("stat");
        dVar.q("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            dVar.q("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.q("pt", str2);
        }
        dVar.q("co", String.valueOf(i));
        dVar.q(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            dVar.e(objArr);
            dVar.b("mi", 0);
        }
        a("stat", (String) null, -1L, (String) null, dVar, new Object[0]);
    }

    private void a(String str, String str2, long j, String str3, d dVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.hB().aq(str)) {
            if (j == -1) {
                com.baidu.adp.lib.stats.b.i.in().a(str, str2, null, str3, dVar, objArr);
            } else {
                com.baidu.adp.lib.stats.b.i.in().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r = com.baidu.adp.lib.stats.b.i.in().r(str, null);
        if (r != null && com.baidu.adp.lib.stats.switchs.a.ie().isWrite(str, null)) {
            d dVar = new d(str);
            if (objArr != null && objArr.length > 0) {
                dVar.e(objArr);
            }
            r.a(dVar);
        }
    }

    public void a(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(g.getNetType(this.mContext)))) {
            a("img", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
        }
    }

    public void a(String str, String str2, String str3, int i, String str4, Object... objArr) {
        a(true, str, str2, str3, 0L, i, str4, objArr);
    }

    public void b(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        a("d", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void a(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
        if (!h.hB().aq("net")) {
            d dVar = new d("net");
            dVar.e("net", g.getNetType(this.mContext), "interface", str2, "cost", String.valueOf(j3));
            if (objArr != null && objArr.length > 0) {
                dVar.e(objArr);
            }
            if (i2 != 0) {
                dVar.b("result", Integer.valueOf(i2));
                dVar.b("es", str4);
            }
            if (j4 > 0) {
                dVar.b(TiebaStatic.CON_COST, Long.valueOf(j4));
            }
            if (j2 > 0) {
                dVar.b("size_u", Long.valueOf(j2));
            }
            if (j > 0) {
                dVar.b("size_d", Long.valueOf(j));
            }
            if (j5 > 0) {
                dVar.b("rsp_cost", Long.valueOf(j5));
            }
            if (!TextUtils.isEmpty(str3)) {
                dVar.b("f", str3);
            }
            if (i > 0) {
                dVar.b("retry", Integer.valueOf(i));
            }
            a("net", str, -1L, (String) null, dVar, new Object[0]);
        }
    }

    public void a(String str, String str2, long j, int i, String str3, Object... objArr) {
        a(true, "d", str, str2, j, i, str3, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
        d dVar = new d("op");
        dVar.e("op_key", str2, "f", str3, "cost", String.valueOf(j), "result", String.valueOf(i), "es", str4);
        if (objArr != null && objArr.length > 0) {
            dVar.e(objArr);
        }
        a("op", str, -1L, (String) null, dVar, new Object[0]);
    }

    public void a(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hB().aq("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hB().aq("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hB().aq("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hB().aq("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hB().aq("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, 0L, i, str3, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        d dVar = new d("crash");
        dVar.q("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            dVar.q("crash_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.q("ci", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            dVar.q("f", str3);
        }
        dVar.q(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            dVar.e(objArr);
        }
        a("crash", "crash", -1L, (String) null, dVar, new Object[0]);
    }

    public d an(String str) {
        return new d(str);
    }

    public String hv() {
        return g.getNetType(BdBaseApplication.getInst());
    }
}
