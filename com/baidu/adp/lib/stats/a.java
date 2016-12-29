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
import com.baidu.tieba.compatible.EditorHelper;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String mAppVersion;
    private Context mContext;
    private String pE;
    private String pF;
    private String pG;
    private boolean pH;
    private e pJ;
    private C0007a pK;
    private static a pD = null;
    private static final Handler mHandler = new b();
    private boolean pI = false;
    private a.InterfaceC0008a pL = new c(this);

    public static a eI() {
        if (pD == null) {
            synchronized (a.class) {
                if (pD == null) {
                    pD = new a();
                }
            }
        }
        return pD;
    }

    public e eJ() {
        return this.pJ;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.pF = str3;
        this.pG = String.valueOf(this.pF) + "/notUpload";
        this.pH = z;
        this.pJ = eVar;
        com.baidu.adp.lib.Disk.d.cB().F(str2);
        com.baidu.adp.lib.stats.switchs.a.fD().a(z, str, this.mContext, this.pL);
        com.baidu.adp.lib.stats.upload.b.fJ().a(fVar, str4);
        j.fL().init();
        if (fVar != null) {
            this.mAppVersion = fVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.pE)) {
            this.pE = eL();
            if (z && this.pE == null) {
                this.pE = "44f94582";
            }
        }
        try {
            if (this.pK == null && this.mContext != null) {
                this.pK = new C0007a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                this.mContext.registerReceiver(this.pK, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        eT();
    }

    public long eK() {
        return com.baidu.adp.lib.stats.a.a.fC().eK();
    }

    private String eL() {
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

    public String eM() {
        return this.pF;
    }

    public String eN() {
        return this.pG;
    }

    public String eO() {
        return this.pE;
    }

    public void k(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.fJ().k(str, str2, str3);
    }

    public void save() {
        j.fL().fM();
    }

    public boolean eP() {
        return this.pH;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            eR();
            com.baidu.adp.lib.stats.switchs.a.fD().b(str, str2, bdUploadStatMsgData);
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
                if ("com.baidu.adp.stats.uploadallfile".equals(action) && !a.this.pH) {
                    j.fL().fP();
                }
                if ("com.baidu.adp.stats.upload.alertlog".equals(action) && a.this.pH) {
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

    public void ak(String str) {
        j.fL().d(j.fL().r(str, null));
    }

    public void eQ() {
        j.fL().fN();
    }

    public void eR() {
        j.fL().fP();
        if (this.pH) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        j.fL().fR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void al(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            Address b = com.baidu.adp.lib.e.a.dU().b(false, false);
            if (b != null) {
                dVar.q("location", b.getLocality());
            }
            a("pfmonitor", str, -1L, (String) null, dVar, new Object[0]);
        }
    }

    public void h(String str, Object... objArr) {
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
            if (eP()) {
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
        if (com.baidu.adp.lib.stats.switchs.a.fD().isUpload("alert", str) && !am(str)) {
            an(str);
            com.baidu.adp.lib.stats.base.a r = j.fL().r("alert", null);
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
                dVar.d(objArr);
            }
            r.a(dVar);
            BdLog.i("alert item = " + dVar.toString());
            com.baidu.adp.lib.stats.upload.b.fJ().a(r, dVar.toString());
        }
    }

    private boolean am(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - dJ().getLong(str, 0L) < ((long) (((com.baidu.adp.lib.stats.switchs.a.fD().geUploadCycle(str, 24) * 60) * 60) * 1000));
    }

    private void an(String str) {
        if (!TextUtils.isEmpty(str)) {
            EditorHelper.putLong(dJ(), str, System.currentTimeMillis());
        }
    }

    private SharedPreferences dJ() {
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
            dVar.d(objArr);
            dVar.c("mi", 0);
        }
        a("stat", (String) null, -1L, (String) null, dVar, new Object[0]);
    }

    private void a(String str, String str2, long j, String str3, d dVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.fa().ar(str)) {
            if (j == -1) {
                j.fL().a(str, str2, null, str3, dVar, objArr);
            } else {
                j.fL().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void j(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r = j.fL().r(str, null);
        if (r != null && com.baidu.adp.lib.stats.switchs.a.fD().isWrite(str, null)) {
            d dVar = new d(str);
            if (objArr != null && objArr.length > 0) {
                dVar.d(objArr);
            }
            r.a(dVar);
        }
    }

    public void a(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(g.F(this.mContext)))) {
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
        if (!h.fa().ar("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.fa().ar("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.fa().ar("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.fa().ar("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.fa().ar("aladin_port_error")) {
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
            dVar.d(objArr);
        }
        a("crash", "crash", -1L, (String) null, dVar, new Object[0]);
    }

    public d ao(String str) {
        return new d(str);
    }

    public String eU() {
        return g.F(BdBaseApplication.getInst());
    }
}
