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
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.b.g;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.stats.switchs.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.r;
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
    private b mBdLogSetting;
    private Context mContext;
    private boolean mIsMainProcess;
    private a mMultiProcessReceiver;
    private String mNotUploadWriteFileDir;
    private String mProcessNameMd5;
    private String mWriteFileDir;
    private static BdStatisticsManager statisticsManager = null;
    private static final Handler mHandler = new Handler() { // from class: com.baidu.adp.lib.stats.BdStatisticsManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    BdStatisticsManager.getInstance().forceUploadAllLog();
                    BdStatisticsManager.getInstance().startOrNextUploadTimer();
                    return;
                case 2:
                    removeMessages(2);
                    BdStatisticsManager.getInstance().checkLogToUpload();
                    return;
                default:
                    return;
            }
        }
    };
    private boolean isSwitchReady = false;
    private a.InterfaceC0006a mLogSwitchInitCallback = new a.InterfaceC0006a() { // from class: com.baidu.adp.lib.stats.BdStatisticsManager.2
        @Override // com.baidu.adp.lib.stats.switchs.a.InterfaceC0006a
        public void gd() {
            BdStatisticsManager.this.isSwitchReady = true;
            if (BdStatisticsManager.this.mIsMainProcess) {
                g.gR().gY();
            }
            BdStatisticsManager.mHandler.removeMessages(2);
            BdStatisticsManager.mHandler.sendMessageDelayed(BdStatisticsManager.mHandler.obtainMessage(2), 15000L);
        }
    };

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

    public b getBdLogSetting() {
        return this.mBdLogSetting;
    }

    public void init(Context context, boolean z, String str, String str2, String str3, String str4, c cVar, b bVar) {
        this.mContext = context;
        this.mWriteFileDir = str3;
        this.mNotUploadWriteFileDir = this.mWriteFileDir + "/notUpload";
        this.mIsMainProcess = z;
        this.mBdLogSetting = bVar;
        com.baidu.adp.lib.Disk.d.dS().O(str2);
        com.baidu.adp.lib.stats.switchs.a.gJ().a(z, str, this.mContext, this.mLogSwitchInitCallback);
        com.baidu.adp.lib.stats.upload.b.gP().a(cVar, str4);
        g.gR().init();
        if (cVar != null) {
            this.mAppVersion = cVar.mAppVersion;
        }
        if (TextUtils.isEmpty(this.mProcessNameMd5)) {
            this.mProcessNameMd5 = getProcessNameMd5();
            if (z && this.mProcessNameMd5 == null) {
                this.mProcessNameMd5 = MAIN_PROCESS_MD5;
            }
        }
        try {
            if (this.mMultiProcessReceiver == null && this.mContext != null) {
                this.mMultiProcessReceiver = new a();
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
        return com.baidu.adp.lib.stats.a.a.gI().getClientLogId();
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
                            String md5 = r.toMd5(str.getBytes("UTF-8"));
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
        return g.gR().getUid();
    }

    public void setUid(String str) {
        if (!TextUtils.isEmpty(str)) {
            g.gR().setUid(str);
        }
    }

    public void setUser(String str, String str2, String str3) {
        com.baidu.adp.lib.stats.upload.b.gP().setUser(str, str2, str3);
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public void save() {
        g.gR().gS();
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public void addEntryToTmpSwitchConfDic(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && bdUploadStatMsgData != null) {
            forceUploadAllLogIgnoreSwitch();
            com.baidu.adp.lib.stats.switchs.a.gJ().a(str, str2, bdUploadStatMsgData);
        }
    }

    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.baidu.adp.stats.uploadallfile".equals(action) && !BdStatisticsManager.this.mIsMainProcess) {
                    g.gR().gV();
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
        g.gR().d(g.gR().q(str, null));
    }

    public void forceUploadAllLog() {
        g.gR().gT();
    }

    public void forceUploadAllLogIgnoreSwitch() {
        g.gR().gV();
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogToUpload() {
        g.gR().gX();
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

    public void performance(String str, com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            Address b = com.baidu.adp.lib.d.a.fo().b(false, false);
            if (b != null) {
                aVar.p("location", b.getLocality());
            }
            addLog("pfmonitor", str, -1L, null, aVar, new Object[0]);
        }
    }

    public void debug(String str, Object... objArr) {
        addLog("dbg", str, -1L, null, null, objArr);
    }

    public void debug(String str, com.baidu.adp.lib.stats.a aVar) {
        if (aVar != null) {
            debug(str, -1L, null, aVar);
        }
    }

    public void debug(String str, long j, String str2, com.baidu.adp.lib.stats.a aVar) {
        addLog("dbg", str, j, str2, aVar, new Object[0]);
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        addLog("dbg", str, j, str2, null, objArr);
    }

    public void error(String str, long j, String str2, com.baidu.adp.lib.stats.a aVar) {
        addLog("error", str, j, str2, aVar, new Object[0]);
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
        if (com.baidu.adp.lib.stats.switchs.a.gJ().isUpload("alert", str) && !checkUploadRecently(str)) {
            setUploadTime(str);
            com.baidu.adp.lib.stats.base.a q = g.gR().q("alert", null);
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("alert");
            aVar.p("module", "alert");
            if (!TextUtils.isEmpty(str)) {
                aVar.p("st", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.p("alert_log", str2);
            }
            aVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                aVar.d(objArr);
            }
            q.a(aVar);
            BdLog.i("alert item = " + aVar.toString());
            com.baidu.adp.lib.stats.upload.b.gP().a(q, aVar.toString());
        }
    }

    private boolean checkUploadRecently(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - getConfig().getLong(str, 0L) < ((long) (((com.baidu.adp.lib.stats.switchs.a.gJ().geUploadCycle(str, 24) * 60) * 60) * 1000));
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
        com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("stat");
        aVar.p("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            aVar.p("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.p("pt", str2);
        }
        aVar.p("co", String.valueOf(i));
        aVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            aVar.d(objArr);
            aVar.c("mi", 0);
        }
        addLog("stat", null, -1L, null, aVar, new Object[0]);
    }

    private void addLog(String str, String str2, long j, String str3, com.baidu.adp.lib.stats.a aVar, Object... objArr) {
        if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && !e.gg().at(str)) {
            if (j == -1) {
                g.gR().a(str, str2, null, str3, aVar, objArr);
            } else {
                g.gR().a(str, str2, String.valueOf(j), str3, aVar, objArr);
            }
        }
    }

    public void log(String str, Object... objArr) {
        com.baidu.adp.lib.stats.base.a q = g.gR().q(str, null);
        if (q != null && com.baidu.adp.lib.stats.switchs.a.gJ().isWrite(str, null)) {
            com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a(str);
            if (objArr != null && objArr.length > 0) {
                aVar.d(objArr);
            }
            q.a(aVar);
        }
    }

    public void imgNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        if ((i2 != 0 && i2 != 200) || (j3 > 2000 && "WIFI".equals(d.ad(this.mContext)))) {
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
        if (!e.gg().at("file")) {
            op(true, "file", str, str2, 0L, i, str3, objArr);
        }
    }

    public void db(String str, String str2, int i, String str3, Object... objArr) {
        if (!e.gg().at("db")) {
            op(true, "db", str, str2, 0L, i, str3, objArr);
        }
    }

    public void imgErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!e.gg().at("img")) {
            op(true, "img", str, str2, 0L, i, str3, objArr);
        }
    }

    public void voiceErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!e.gg().at("voice")) {
            op(true, "voice", str, str2, 0L, i, str3, objArr);
        }
    }

    public void liveErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!e.gg().at("live")) {
            op(true, "live", str, str2, 0L, i, str3, objArr);
        }
    }

    public void aladinPortErr(String str, String str2, int i, String str3, Object... objArr) {
        if (!e.gg().at("aladin_port_error")) {
            op(true, "aladin_port_error", str, str2, 0L, i, str3, objArr);
        }
    }

    public void crash(String str, String str2, String str3, Object... objArr) {
        com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("crash");
        aVar.p("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            aVar.p("crash_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.p("ci", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            aVar.p("f", str3);
        }
        aVar.p(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            aVar.d(objArr);
        }
        addLog("crash", "crash", -1L, null, aVar, new Object[0]);
    }

    public boolean isSwitchReady() {
        return this.isSwitchReady;
    }

    public com.baidu.adp.lib.stats.a getStatsItem(String str) {
        return new com.baidu.adp.lib.stats.a(str);
    }

    public String getCurNetworkType() {
        return d.ad(BdBaseApplication.getInst());
    }

    public static void clearInstance() {
        statisticsManager = null;
    }
}
