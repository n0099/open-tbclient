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
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String mAppVersion;
    private Context mContext;
    private String wo;
    private String wp;
    private String wq;
    private boolean wr;
    private e wt;
    private C0006a wu;
    private static a wn = null;
    private static final Handler mHandler = new b();
    private boolean ws = false;
    private a.InterfaceC0007a wv = new c(this);

    public static a ht() {
        if (wn == null) {
            synchronized (a.class) {
                if (wn == null) {
                    wn = new a();
                }
            }
        }
        return wn;
    }

    public e hu() {
        return this.wt;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.wp = str3;
        this.wq = String.valueOf(this.wp) + "/notUpload";
        this.wr = z;
        this.wt = eVar;
        com.baidu.adp.lib.Disk.d.fr().L(str2);
        com.baidu.adp.lib.stats.switchs.a.ir().a(z, str, this.mContext, this.wv);
        com.baidu.adp.lib.stats.upload.b.ix().a(fVar, str4);
        com.baidu.adp.lib.stats.b.i.iz().init();
        if (fVar != null) {
            this.mAppVersion = fVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.wo)) {
            this.wo = hw();
            if (z && this.wo == null) {
                this.wo = "44f94582";
            }
        }
        try {
            if (this.wu == null && this.mContext != null) {
                this.wu = new C0006a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                this.mContext.registerReceiver(this.wu, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        hE();
    }

    public long hv() {
        return com.baidu.adp.lib.stats.a.a.iq().hv();
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

    public String hx() {
        return this.wp;
    }

    public String hy() {
        return this.wq;
    }

    public String hz() {
        return this.wo;
    }

    public void f(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.ix().f(str, str2, str3);
    }

    public void save() {
        com.baidu.adp.lib.stats.b.i.iz().iA();
    }

    public boolean hA() {
        return this.wr;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            hC();
            com.baidu.adp.lib.stats.switchs.a.ir().b(str, str2, bdUploadStatMsgData);
        }
    }

    /* renamed from: com.baidu.adp.lib.stats.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0006a extends BroadcastReceiver {
        private C0006a() {
        }

        /* synthetic */ C0006a(a aVar, C0006a c0006a) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.baidu.adp.stats.uploadallfile".equals(intent.getAction()) && !a.this.wr) {
                com.baidu.adp.lib.stats.b.i.iz().iD();
            }
        }
    }

    public void ao(String str) {
        com.baidu.adp.lib.stats.b.i.iz().d(com.baidu.adp.lib.stats.b.i.iz().s(str, null));
    }

    public void hB() {
        com.baidu.adp.lib.stats.b.i.iz().iB();
    }

    public void hC() {
        com.baidu.adp.lib.stats.b.i.iz().iD();
        if (this.wr) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD() {
        com.baidu.adp.lib.stats.b.i.iz().iF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void ap(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
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
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.hL().at(str)) {
            if (j == -1) {
                com.baidu.adp.lib.stats.b.i.iz().a(str, str2, null, str3, dVar, objArr);
            } else {
                com.baidu.adp.lib.stats.b.i.iz().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a s = com.baidu.adp.lib.stats.b.i.iz().s(str, null);
        if (s != null && com.baidu.adp.lib.stats.switchs.a.ir().isWrite(str, null)) {
            d dVar = new d(str);
            if (objArr != null && objArr.length > 0) {
                dVar.b(objArr);
            }
            s.a(dVar);
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
    }

    public void a(String str, String str2, long j, int i, String str3, Object... objArr) {
        a(true, "d", str, str2, j, i, str3, objArr);
    }

    public void a(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
    }

    public void a(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hL().at("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hL().at("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hL().at("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hL().at("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.hL().at("aladin_port_error")) {
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

    public d aq(String str) {
        return new d(str);
    }

    public String hF() {
        return g.getNetType(BdBaseApplication.getInst());
    }
}
