package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
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
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String mAppVersion;
    private Context mContext;
    private String wF;
    private String wG;
    private String wH;
    private boolean wI;
    private e wK;
    private C0007a wL;
    private static a wE = null;
    private static final Handler mHandler = new b();
    private boolean wJ = false;
    private a.InterfaceC0008a wM = new c(this);

    public static a hz() {
        if (wE == null) {
            synchronized (a.class) {
                if (wE == null) {
                    wE = new a();
                }
            }
        }
        return wE;
    }

    public e hA() {
        return this.wK;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.wG = str3;
        this.wH = String.valueOf(this.wG) + "/notUpload";
        this.wI = z;
        this.wK = eVar;
        com.baidu.adp.lib.Disk.d.fs().L(str2);
        com.baidu.adp.lib.stats.switchs.a.ix().a(z, str, this.mContext, this.wM);
        com.baidu.adp.lib.stats.upload.b.iD().a(fVar, str4);
        com.baidu.adp.lib.stats.b.i.iF().init();
        if (fVar != null) {
            this.mAppVersion = fVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.wF)) {
            this.wF = hC();
            if (z && this.wF == null) {
                this.wF = "44f94582";
            }
        }
        try {
            if (this.wL == null && this.mContext != null) {
                this.wL = new C0007a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                this.mContext.registerReceiver(this.wL, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        hK();
    }

    public long hB() {
        return com.baidu.adp.lib.stats.a.a.iw().hB();
    }

    private String hC() {
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
                            String l = t.l(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(l) && l.length() > 8) {
                                return l.substring(l.length() - 8);
                            }
                            return l;
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

    public String hD() {
        return this.wG;
    }

    public String hE() {
        return this.wH;
    }

    public String hF() {
        return this.wF;
    }

    public void f(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.iD().f(str, str2, str3);
    }

    public void save() {
        com.baidu.adp.lib.stats.b.i.iF().iG();
    }

    public boolean hG() {
        return this.wI;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            hI();
            com.baidu.adp.lib.stats.switchs.a.ix().b(str, str2, bdUploadStatMsgData);
        }
    }

    /* renamed from: com.baidu.adp.lib.stats.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0007a extends BroadcastReceiver {
        private C0007a() {
        }

        /* synthetic */ C0007a(a aVar, C0007a c0007a) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.baidu.adp.stats.uploadallfile".equals(intent.getAction()) && !a.this.wI) {
                com.baidu.adp.lib.stats.b.i.iF().iJ();
            }
        }
    }

    public void aq(String str) {
        com.baidu.adp.lib.stats.b.i.iF().d(com.baidu.adp.lib.stats.b.i.iF().s(str, null));
    }

    public void hH() {
        com.baidu.adp.lib.stats.b.i.iF().iH();
    }

    public void hI() {
        com.baidu.adp.lib.stats.b.i.iF().iJ();
        if (this.wI) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hJ() {
        com.baidu.adp.lib.stats.b.i.iF().iL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void ar(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            Address b = com.baidu.adp.lib.e.a.gL().b(false, false);
            if (b != null) {
                dVar.r("location", b.getLocality());
            }
            a("pfmonitor", str, -1L, (String) null, dVar, new Object[0]);
        }
    }

    public void c(String str, Object... objArr) {
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
        dVar.r("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            dVar.r("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.r("pt", str2);
        }
        dVar.r("co", String.valueOf(i));
        dVar.r(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            dVar.b(objArr);
            dVar.b("mi", 0);
        }
        a("stat", (String) null, -1L, (String) null, dVar, new Object[0]);
    }

    private void a(String str, String str2, long j, String str3, d dVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.hR().av(str)) {
            if (j == -1) {
                com.baidu.adp.lib.stats.b.i.iF().a(str, str2, null, str3, dVar, objArr);
            } else {
                com.baidu.adp.lib.stats.b.i.iF().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s = com.baidu.adp.lib.stats.b.i.iF().s(str, null);
        if (s != null && com.baidu.adp.lib.stats.switchs.a.ix().isWrite(str, null)) {
            d dVar = new d(str);
            if (objArr != null && objArr.length > 0) {
                dVar.b(objArr);
            }
            s.a(dVar);
        }
    }

    public void a(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(g.w(this.mContext)))) {
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
    }

    public void a(String str, String str2, long j, int i, String str3, Object... objArr) {
        a(true, "d", str, str2, j, i, str3, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
    }

    public void a(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hR().av("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hR().av("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hR().av("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hR().av("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hR().av("aladin_port_error")) {
            a(true, "aladin_port_error", str, str2, 0L, i, str3, objArr);
        }
    }

    public void a(String str, String str2, String str3, Object... objArr) {
        d dVar = new d("crash");
        dVar.r("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            dVar.r("crash_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.r("ci", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            dVar.r("f", str3);
        }
        dVar.r(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            dVar.b(objArr);
        }
        a("crash", "crash", -1L, (String) null, dVar, new Object[0]);
    }

    public d as(String str) {
        return new d(str);
    }

    public String hL() {
        return g.w(BdBaseApplication.getInst());
    }
}
