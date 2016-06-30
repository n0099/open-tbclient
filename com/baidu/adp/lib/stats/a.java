package com.baidu.adp.lib.stats;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.stats.switchs.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String mA;
    private String mAppVersion;
    private String mB;
    private Context mContext;
    private String mD;
    private boolean mE;
    private e mG;
    private C0007a mH;
    private static a mz = null;
    private static final Handler mHandler = new b();
    private boolean mF = false;
    private a.InterfaceC0008a mI = new c(this);

    public static a dO() {
        if (mz == null) {
            synchronized (a.class) {
                if (mz == null) {
                    mz = new a();
                }
            }
        }
        return mz;
    }

    public e dP() {
        return this.mG;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.mB = str3;
        this.mD = String.valueOf(this.mB) + "/notUpload";
        this.mE = z;
        this.mG = eVar;
        com.baidu.adp.lib.Disk.d.bH().C(str2);
        com.baidu.adp.lib.stats.switchs.a.eJ().a(z, str, this.mContext, this.mI);
        com.baidu.adp.lib.stats.upload.b.eP().a(fVar, str4);
        j.eR().init();
        if (fVar != null) {
            this.mAppVersion = fVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.mA)) {
            this.mA = dR();
            if (z && this.mA == null) {
                this.mA = "44f94582";
            }
        }
        try {
            if (this.mH == null && this.mContext != null) {
                this.mH = new C0007a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                this.mContext.registerReceiver(this.mH, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        dZ();
    }

    public long dQ() {
        return com.baidu.adp.lib.stats.a.a.eI().dQ();
    }

    private String dR() {
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
                            String md5 = t.toMd5(str.getBytes("UTF-8"));
                            if (!TextUtils.isEmpty(md5) && md5.length() > 8) {
                                return md5.substring(md5.length() - 8);
                            }
                            return md5;
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

    public String dS() {
        return this.mB;
    }

    public String dT() {
        return this.mD;
    }

    public String dU() {
        return this.mA;
    }

    public void k(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.eP().k(str, str2, str3);
    }

    public void save() {
        j.eR().eS();
    }

    public boolean dV() {
        return this.mE;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            dX();
            com.baidu.adp.lib.stats.switchs.a.eJ().b(str, str2, bdUploadStatMsgData);
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
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.uploadallfile".equals(action) && !a.this.mE) {
                    j.eR().eV();
                }
                if ("com.baidu.adp.stats.upload.alertlog".equals(action) && a.this.mE) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("alert_type");
                    String string2 = extras.getString("alert_log");
                    if (!TextUtils.isEmpty(string)) {
                        a.this.p(string, string2);
                    }
                }
            }
        }
    }

    public void ah(String str) {
        j.eR().d(j.eR().r(str, null));
    }

    public void dW() {
        j.eR().eT();
    }

    public void dX() {
        j.eR().eV();
        if (this.mE) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dY() {
        j.eR().eX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void ai(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            Address b = com.baidu.adp.lib.e.a.da().b(false, false);
            if (b != null) {
                dVar.q(ThActivityDetailActivityConfig.LOCATION, b.getLocality());
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

    public void p(String str, String str2) {
        BdLog.i("type = " + str + "; log = " + str2);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2) && str2.getBytes().length > 524288) {
                str2 = str2.substring(0, 1024);
            }
            if (dV()) {
                c(str, str2, null);
                return;
            }
            Intent intent = new Intent("com.baidu.adp.stats.upload.alertlog");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            intent.putExtra("alert_type", str);
            intent.putExtra("alert_log", str2);
            if (this.mContext != null) {
                this.mContext.sendBroadcast(intent);
                BdLog.i("not MainProcess");
                return;
            }
            BdLog.e("mContext == null");
        }
    }

    private void c(String str, String str2, Object[] objArr) {
        if (com.baidu.adp.lib.stats.switchs.a.eJ().isUpload("alert", str) && !aj(str)) {
            ak(str);
            com.baidu.adp.lib.stats.base.a r = j.eR().r("alert", null);
            d dVar = new d("alert");
            dVar.q("module", "alert");
            if (!TextUtils.isEmpty(str)) {
                dVar.q("st", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                dVar.q("alert_log", str2);
            }
            dVar.q(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                dVar.b(objArr);
            }
            r.a(dVar);
            BdLog.i("alert item = " + dVar.toString());
            com.baidu.adp.lib.stats.upload.b.eP().a(r, dVar.toString());
        }
    }

    private boolean aj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - cP().getLong(str, 0L) < ((long) (((com.baidu.adp.lib.stats.switchs.a.eJ().geUploadCycle(str, 24) * 60) * 60) * 1000));
    }

    private void ak(String str) {
        if (!TextUtils.isEmpty(str)) {
            EditorHelper.putLong(cP(), str, System.currentTimeMillis());
        }
    }

    private SharedPreferences cP() {
        return BdBaseApplication.getInst().getSharedPreferences("alert", 0);
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
            dVar.b(objArr);
            dVar.a("mi", 0);
        }
        a("stat", (String) null, -1L, (String) null, dVar, new Object[0]);
    }

    private void a(String str, String str2, long j, String str3, d dVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.eg().ao(str)) {
            if (j == -1) {
                j.eR().a(str, str2, null, str3, dVar, objArr);
            } else {
                j.eR().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void f(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r = j.eR().r(str, null);
        if (r != null && com.baidu.adp.lib.stats.switchs.a.eJ().isWrite(str, null)) {
            d dVar = new d(str);
            if (objArr != null && objArr.length > 0) {
                dVar.b(objArr);
            }
            r.a(dVar);
        }
    }

    public void a(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(g.v(this.mContext)))) {
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
        if (!h.eg().ao("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eg().ao("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eg().ao("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eg().ao("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eg().ao("aladin_port_error")) {
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
            dVar.b(objArr);
        }
        a("crash", "crash", -1L, (String) null, dVar, new Object[0]);
    }

    public d al(String str) {
        return new d(str);
    }

    public String ea() {
        return g.v(BdBaseApplication.getInst());
    }
}
