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
public class BdStatisticsManager {
    private static final int IMG_OVER_TIME = 2000;
    public static final int INIT_UPLOAD_TIME_INTERVAL = 15000;
    private static final String MAIN_PROCESS_MD5 = "44f94582";
    public static final byte UPLOAD_INIT = 2;
    public static final byte UPLOAD_TIMER = 1;
    public static final int UPLOAD_TIMER_INTERVAL = 3600000;
    private String mAppVersion;
    private d mBdLogSetting;
    private Context mContext;
    private boolean mIsMainProcess;
    private a mMultiProcessReceiver;
    private String mNotUploadWriteFileDir;
    private String mProcessNameMd5;
    private String mWriteFileDir;
    private static BdStatisticsManager statisticsManager = null;
    private static final Handler mHandler = new com.baidu.adp.lib.stats.a();
    private boolean isSwitchReady = false;
    private a.InterfaceC0006a mLogSwitchInitCallback = new b(this);

    public static BdStatisticsManager getInstance() {
        if (statisticsManager == null) {
            synchronized (BdStatisticsManager.class) {
                if (statisticsManager == null) {
                    statisticsManager = new BdStatisticsManager();
                }
            }
        }
        return statisticsManager;
    }

    public d getBdLogSetting() {
        return this.mBdLogSetting;
    }

    public void init(Context context, boolean z, String str, String str2, String str3, String str4, e eVar, d dVar) {
        this.mContext = context;
        this.mWriteFileDir = str3;
        this.mNotUploadWriteFileDir = String.valueOf(this.mWriteFileDir) + "/notUpload";
        this.mIsMainProcess = z;
        this.mBdLogSetting = dVar;
        com.baidu.adp.lib.Disk.d.dI().B(str2);
        com.baidu.adp.lib.stats.switchs.a.gC().a(z, str, this.mContext, this.mLogSwitchInitCallback);
        com.baidu.adp.lib.stats.upload.b.gI().a(eVar, str4);
        j.gK().init();
        if (eVar != null) {
            this.mAppVersion = eVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.mProcessNameMd5)) {
            this.mProcessNameMd5 = getProcessNameMd5();
            if (z && this.mProcessNameMd5 == null) {
                this.mProcessNameMd5 = MAIN_PROCESS_MD5;
            }
        }
        try {
            if (this.mMultiProcessReceiver == null && this.mContext != null) {
                this.mMultiProcessReceiver = new a(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                this.mContext.registerReceiver(this.mMultiProcessReceiver, intentFilter);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        startOrNextUploadTimer();
    }

    public long getClientLogId() {
        return com.baidu.adp.lib.stats.a.a.gB().getClientLogId();
    }

    private String getProcessNameMd5() {
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

    public String getWriteDir() {
        return this.mWriteFileDir;
    }

    public String getNotUploadWriteDir() {
        return this.mNotUploadWriteFileDir;
    }

    public String getProcessName() {
        return this.mProcessNameMd5;
    }

    public String getUid() {
        return j.gK().getUid();
    }

    public void setUid(String str) {
        if (!TextUtils.isEmpty(str)) {
            j.gK().setUid(str);
        }
    }

    public void setUser(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.gI().setUser(str, str2, str3);
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public void save() {
        j.gK().gL();
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public void addEntryToTmpSwitchConfDic(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            forceUploadAllLogIgnoreSwitch();
            com.baidu.adp.lib.stats.switchs.a.gC().a(str, str2, bdUploadStatMsgData);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(BdStatisticsManager bdStatisticsManager, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.uploadallfile".equals(action) && !BdStatisticsManager.this.mIsMainProcess) {
                    j.gK().gO();
                }
                if ("com.baidu.adp.stats.upload.alertlog".equals(action) && BdStatisticsManager.this.mIsMainProcess) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("alert_type");
                    String string2 = extras.getString("alert_log");
                    if (!TextUtils.isEmpty(string)) {
                        BdStatisticsManager.this.alert(string, string2);
                    }
                }
            }
        }
    }

    public void saveAndUploadlog(String str) {
        j.gK().d(j.gK().q(str, null));
    }

    public void forceUploadAllLog() {
        j.gK().gM();
    }

    public void forceUploadAllLogIgnoreSwitch() {
        j.gK().gO();
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogToUpload() {
        j.gK().gQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOrNextUploadTimer() {
        mHandler.removeMessages(1);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 3600000L);
    }

    public void resetSwitch(String str) {
        if (!TextUtils.isEmpty(str)) {
            new BdStatSwitchData().parserJson(str);
        }
    }

    public void performance(String str, Object... objArr) {
        addLog("pfmonitor", str, -1L, null, null, objArr);
    }

    public void performance(String str, c cVar) {
        if (cVar != null) {
            Address b = com.baidu.adp.lib.d.a.fg().b(false, false);
            if (b != null) {
                cVar.p("location", b.getLocality());
            }
            addLog("pfmonitor", str, -1L, null, cVar, new Object[0]);
        }
    }

    public void debug(String str, Object... objArr) {
        addLog("dbg", str, -1L, null, null, objArr);
    }

    public void debug(String str, c cVar) {
        if (cVar != null) {
            debug(str, -1L, null, cVar);
        }
    }

    public void debug(String str, long j, String str2, c cVar) {
        addLog("dbg", str, j, str2, cVar, new Object[0]);
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        addLog("dbg", str, j, str2, null, objArr);
    }

    public void error(String str, long j, String str2, c cVar) {
        addLog("error", str, j, str2, cVar, new Object[0]);
    }

    public void error(String str, long j, String str2, Object... objArr) {
        addLog("error", str, j, str2, null, objArr);
    }

    public void alert(String str, String str2) {
        BdLog.i("type = " + str + "; log = " + str2);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2) && str2.getBytes().length > 524288) {
                str2 = str2.substring(0, 1024);
            }
            if (isMainProcess()) {
                alert(str, str2, null);
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

    private void alert(String str, String str2, Object[] objArr) {
        if (com.baidu.adp.lib.stats.switchs.a.gC().isUpload("alert", str) && !checkUploadRecently(str)) {
            setUploadTime(str);
            com.baidu.adp.lib.stats.base.a q = j.gK().q("alert", null);
            c cVar = new c("alert");
            cVar.p("module", "alert");
            if (!TextUtils.isEmpty(str)) {
                cVar.p("st", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                cVar.p("alert_log", str2);
            }
            cVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                cVar.d(objArr);
            }
            q.a(cVar);
            BdLog.i("alert item = " + cVar.toString());
            com.baidu.adp.lib.stats.upload.b.gI().a(q, cVar.toString());
        }
    }

    private boolean checkUploadRecently(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - getConfig().getLong(str, 0L) < ((long) (((com.baidu.adp.lib.stats.switchs.a.gC().geUploadCycle(str, 24) * 60) * 60) * 1000));
    }

    private void setUploadTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            EditorHelper.putLong(getConfig(), str, System.currentTimeMillis());
        }
    }

    private SharedPreferences getConfig() {
        return BdBaseApplication.getInst().getSharedPreferences("alert", 0);
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        c cVar = new c("stat");
        cVar.p("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            cVar.p("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVar.p("pt", str2);
        }
        cVar.p("co", String.valueOf(i));
        cVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            cVar.d(objArr);
            cVar.c("mi", 0);
        }
        addLog("stat", null, -1L, null, cVar, new Object[0]);
    }

    private void addLog(String str, String str2, long j, String str3, c cVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !g.fY().ag(str)) {
            if (j == -1) {
                j.gK().a(str, str2, null, str3, cVar, objArr);
            } else {
                j.gK().a(str, str2, String.valueOf(j), str3, cVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q = j.gK().q(str, null);
        if (q != null && com.baidu.adp.lib.stats.switchs.a.gC().isWrite(str, null)) {
            c cVar = new c(str);
            if (objArr != null && objArr.length > 0) {
                cVar.d(objArr);
            }
            q.a(cVar);
        }
    }

    public void imgNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(f.ac(this.mContext)))) {
            net("img", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
        }
    }

    public void error(String str, String str2, String str3, int i, String str4, Object... objArr) {
        op(true, str, str2, str3, 0L, i, str4, objArr);
    }

    public void voiceNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        net("voice", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void net(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        net("d", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void net(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
    }

    public void op(String str, String str2, long j, int i, String str3, Object... objArr) {
        op(true, "d", str, str2, j, i, str3, objArr);
    }

    public void op(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
    }

    public void file(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("file")) {
            op(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void db(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("db")) {
            op(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void imgErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("img")) {
            op(true, "img", str, str2, 0L, i, str3, objArr);
        }
    }

    public void voiceErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("voice")) {
            op(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void liveErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("live")) {
            op(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void aladinPortErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!g.fY().ag("aladin_port_error")) {
            op(true, "aladin_port_error", str, str2, 0L, i, str3, objArr);
        }
    }

    public void crash(String str, String str2, String str3, Object... objArr) {
        c cVar = new c("crash");
        cVar.p("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            cVar.p("crash_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVar.p("ci", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.p("f", str3);
        }
        cVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            cVar.d(objArr);
        }
        addLog("crash", "crash", -1L, null, cVar, new Object[0]);
    }

    public boolean isSwitchReady() {
        return this.isSwitchReady;
    }

    public c getStatsItem(String str) {
        return new c(str);
    }

    public String getCurNetworkType() {
        return f.ac(BdBaseApplication.getInst());
    }

    public static void clearInstance() {
        statisticsManager = null;
    }
}
