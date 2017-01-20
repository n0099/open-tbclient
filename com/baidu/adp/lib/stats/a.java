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
    private String pA;
    private boolean pB;
    private e pD;
    private C0006a pE;
    private String py;
    private String pz;
    private static a px = null;
    private static final Handler mHandler = new b();
    private boolean pC = false;
    private a.InterfaceC0007a pF = new c(this);

    public static a eG() {
        if (px == null) {
            synchronized (a.class) {
                if (px == null) {
                    px = new a();
                }
            }
        }
        return px;
    }

    public e eH() {
        return this.pD;
    }

    public void a(Context context, boolean z, String str, String str2, String str3, String str4, f fVar, e eVar) {
        this.mContext = context;
        this.pz = str3;
        this.pA = String.valueOf(this.pz) + "/notUpload";
        this.pB = z;
        this.pD = eVar;
        com.baidu.adp.lib.Disk.d.cz().F(str2);
        com.baidu.adp.lib.stats.switchs.a.fB().a(z, str, this.mContext, this.pF);
        com.baidu.adp.lib.stats.upload.b.fH().a(fVar, str4);
        j.fJ().init();
        if (fVar != null) {
            this.mAppVersion = fVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.py)) {
            this.py = eJ();
            if (z && this.py == null) {
                this.py = "44f94582";
            }
        }
        try {
            if (this.pE == null && this.mContext != null) {
                this.pE = new C0006a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                this.mContext.registerReceiver(this.pE, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        eR();
    }

    public long eI() {
        return com.baidu.adp.lib.stats.a.a.fA().eI();
    }

    private String eJ() {
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

    public String eK() {
        return this.pz;
    }

    public String eL() {
        return this.pA;
    }

    public String eM() {
        return this.py;
    }

    public void k(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.fH().k(str, str2, str3);
    }

    public void save() {
        j.fJ().fK();
    }

    public boolean eN() {
        return this.pB;
    }

    public void a(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            eP();
            com.baidu.adp.lib.stats.switchs.a.fB().b(str, str2, bdUploadStatMsgData);
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
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.uploadallfile".equals(action) && !a.this.pB) {
                    j.fJ().fN();
                }
                if ("com.baidu.adp.stats.upload.alertlog".equals(action) && a.this.pB) {
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

    public void aj(String str) {
        j.fJ().d(j.fJ().r(str, null));
    }

    public void eO() {
        j.fJ().fL();
    }

    public void eP() {
        j.fJ().fN();
        if (this.pB) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        j.fJ().fP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void ak(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void a(String str, d dVar) {
        if (dVar != null) {
            Address b = com.baidu.adp.lib.d.a.dS().b(false, false);
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
            if (eN()) {
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
        if (com.baidu.adp.lib.stats.switchs.a.fB().isUpload("alert", str) && !al(str)) {
            am(str);
            com.baidu.adp.lib.stats.base.a r = j.fJ().r("alert", null);
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
            com.baidu.adp.lib.stats.upload.b.fH().a(r, dVar.toString());
        }
    }

    private boolean al(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - dH().getLong(str, 0L) < ((long) (((com.baidu.adp.lib.stats.switchs.a.fB().geUploadCycle(str, 24) * 60) * 60) * 1000));
    }

    private void am(String str) {
        if (!TextUtils.isEmpty(str)) {
            EditorHelper.putLong(dH(), str, System.currentTimeMillis());
        }
    }

    private SharedPreferences dH() {
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
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !h.eY().aq(str)) {
            if (j == -1) {
                j.fJ().a(str, str2, null, str3, dVar, objArr);
            } else {
                j.fJ().a(str, str2, String.valueOf(j), str3, dVar, objArr);
            }
        }
    }

    public void j(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a r = j.fJ().r(str, null);
        if (r != null && com.baidu.adp.lib.stats.switchs.a.fB().isWrite(str, null)) {
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
        if (!h.eY().aq("file")) {
            a(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void b(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eY().aq("db")) {
            a(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void c(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eY().aq("voice")) {
            a(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void d(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eY().aq("live")) {
            a(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void e(String str, String str2, int i, String str3, Object... objArr) {
        if (!h.eY().aq("aladin_port_error")) {
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

    public d an(String str) {
        return new d(str);
    }

    public String eS() {
        return g.F(BdBaseApplication.getInst());
    }
}
