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
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.c.e.n.d;
import d.a.c.e.n.e;
import d.a.c.e.n.f;
import d.a.c.e.n.k.a;
import d.a.c.e.n.m.g;
import d.a.c.e.p.q;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes.dex */
public class BdStatisticsManager {
    public static final int IMG_OVER_TIME = 2000;
    public static final int INIT_UPLOAD_TIME_INTERVAL = 15000;
    public static final String MAIN_PROCESS_MD5 = "44f94582";
    public static final int MIN_UPLOAD_TIMER_INTERVAL = 60000;
    public static final int OLD_TIMER_INTERVAL = 3600000;
    public static final byte UPLOAD_INIT = 2;
    public static final byte UPLOAD_TIMER = 1;
    public static final int UPLOAD_TIMER_INTERVAL = 120000;
    public static final Handler mHandler = new a();
    public static BdStatisticsManager statisticsManager;
    public String mAppVersion;
    public d.a.c.e.n.b mBdLogSetting;
    public d.a.c.e.n.c mCommonData;
    public Context mContext;
    public boolean mIsMainProcess;
    public c mMultiProcessReceiver;
    public String mNotUploadWriteFileDir;
    public String mProcessNameMd5;
    public String mTrackLogWriteFileDir;
    public String mWriteFileDir;
    public boolean isSwitchReady = false;
    public long mUploadInterval = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    public a.b mLogSwitchInitCallback = new b();

    /* loaded from: classes.dex */
    public static class a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                BdStatisticsManager.getInstance().forceUploadAllLog();
                BdStatisticsManager.getInstance().startOrNextUploadTimer();
            } else if (i2 != 2) {
            } else {
                removeMessages(2);
                BdStatisticsManager.getInstance().checkLogToUpload();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.c.e.n.k.a.b
        public void a() {
            BdStatisticsManager.this.isSwitchReady = true;
            if (BdStatisticsManager.this.mIsMainProcess) {
                g.h().f();
            }
            BdStatisticsManager.mHandler.removeMessages(2);
            if (BdBaseApplication.getInst().checkInterrupt()) {
                return;
            }
            BdStatisticsManager.mHandler.sendMessageDelayed(BdStatisticsManager.mHandler.obtainMessage(2), 15000L);
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.uploadallfile".equals(action) && !BdStatisticsManager.this.mIsMainProcess) {
                g.h().s();
            }
            if ("com.baidu.adp.stats.upload.alertlog".equals(action) && BdStatisticsManager.this.mIsMainProcess) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("alert_type");
                String string2 = extras.getString("alert_log");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                BdStatisticsManager.this.alert(string, string2);
            }
        }

        public /* synthetic */ c(BdStatisticsManager bdStatisticsManager, a aVar) {
            this();
        }
    }

    private void addLog(String str, String str2, long j, String str3, d.a.c.e.n.a aVar, Object... objArr) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || e.c().a(str)) {
            return;
        }
        if (j == -1) {
            g.h().C(str, str2, null, str3, aVar, objArr);
        } else {
            g.h().C(str, str2, String.valueOf(j), str3, aVar, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLogToUpload() {
        g.h().e();
    }

    private boolean checkUploadRecently(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return System.currentTimeMillis() - getConfig().getLong(str, 0L) < ((long) (((d.a.c.e.n.k.a.o().m(str, 24) * 60) * 60) * 1000));
    }

    public static void clearInstance() {
        statisticsManager = null;
    }

    private SharedPreferences getConfig() {
        return BdBaseApplication.getInst().getSharedPreferences("alert", 0);
    }

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

    private String getProcessNameMd5() {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context = this.mContext;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                if (runningAppProcesses.get(i2).pid == myPid) {
                    String str = runningAppProcesses.get(i2).processName;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            String d2 = q.d(str.getBytes("UTF-8"));
                            return (TextUtils.isEmpty(d2) || d2.length() <= 8) ? d2 : d2.substring(d2.length() - 8);
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2.getMessage());
                            return str;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void setUploadTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EditorHelper.putLong(getConfig(), str, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOrNextUploadTimer() {
        mHandler.removeMessages(1);
        Handler handler = mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.mUploadInterval);
    }

    public void addEntryToTmpSwitchConfDic(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null || BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        forceUploadAllLogIgnoreSwitch();
        d.a.c.e.n.k.a.o().k(str, str2, bdUploadStatMsgData);
    }

    public void aladinPortErr(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a("aladin_port_error")) {
            return;
        }
        op(true, "aladin_port_error", str, str2, 0L, i2, str3, objArr);
    }

    public void alert(String str, String str2) {
        BdLog.i("type = " + str + "; log = " + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
        Context context = this.mContext;
        if (context != null) {
            context.sendBroadcast(intent);
            BdLog.i("not MainProcess");
            return;
        }
        BdLog.e("mContext == null");
    }

    public void crash(String str, String str2, String str3, Object... objArr) {
        d.a.c.e.n.a aVar = new d.a.c.e.n.a("crash");
        aVar.b("module", "crash");
        if (!TextUtils.isEmpty(str)) {
            aVar.b("crash_type", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.b("ci", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            aVar.b("f", str3);
        }
        aVar.b("t", String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            aVar.c(objArr);
        }
        addLog("crash", "crash", -1L, null, aVar, new Object[0]);
    }

    public void db(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a(IMTrackDatabase.DbEnum.TABLE_NAME)) {
            return;
        }
        op(true, IMTrackDatabase.DbEnum.TABLE_NAME, str, str2, 0L, i2, str3, objArr);
    }

    public void debug(String str, Object... objArr) {
        addLog("dbg", str, -1L, null, null, objArr);
    }

    public void error(String str, long j, String str2, d.a.c.e.n.a aVar) {
        addLog("error", str, j, str2, aVar, new Object[0]);
    }

    public void eventStat(Context context, String str, String str2, int i2, Object... objArr) {
        d.a.c.e.n.a aVar = new d.a.c.e.n.a("stat");
        aVar.b("module", "stat");
        if (!TextUtils.isEmpty(str)) {
            aVar.b("op_key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.b(Config.PLATFORM_TYPE, str2);
        }
        aVar.b("co", String.valueOf(i2));
        aVar.b("t", String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            aVar.c(objArr);
            aVar.a("mi", 0);
        }
        addLog("stat", null, -1L, null, aVar, new Object[0]);
    }

    public void file(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a("file")) {
            return;
        }
        op(true, "file", str, str2, 0L, i2, str3, objArr);
    }

    public void forceUploadAllLog() {
        g.h().p();
    }

    public void forceUploadAllLogIgnoreSwitch() {
        if (BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        g.h().s();
        if (this.mIsMainProcess) {
            Intent intent = new Intent("com.baidu.adp.stats.uploadallfile");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.mContext.sendBroadcast(intent);
        }
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public d.a.c.e.n.b getBdLogSetting() {
        return this.mBdLogSetting;
    }

    public long getClientLogId() {
        return d.a.c.e.n.i.a.b().a();
    }

    public String getCurNetworkType() {
        return d.a(BdBaseApplication.getInst());
    }

    public String getNotUploadWriteDir() {
        return this.mNotUploadWriteFileDir;
    }

    public String getProcessName() {
        return this.mProcessNameMd5;
    }

    public d.a.c.e.n.a getStatsItem(String str) {
        return new d.a.c.e.n.a(str);
    }

    public String getTrackLogWriteDir() {
        return this.mTrackLogWriteFileDir;
    }

    public String getUid() {
        return g.h().j();
    }

    public long getUploadInterval() {
        return this.mUploadInterval;
    }

    public String getWriteDir() {
        return this.mWriteFileDir;
    }

    public void imgErr(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a("img")) {
            return;
        }
        op(true, "img", str, str2, 0L, i2, str3, objArr);
    }

    public void imgNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i2, int i3, String str3, Object... objArr) {
        if ((i3 == 0 || i3 == 200) && (j3 <= 2000 || !CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(d.a(this.mContext)))) {
            return;
        }
        net("img", str, str2, j, j2, j3, j4, j5, i2, i3, str3, objArr);
    }

    public void init(Context context, boolean z, String str, String str2, String str3, String str4, d.a.c.e.n.c cVar, d.a.c.e.n.b bVar, long j, String str5) {
        this.mContext = context;
        this.mWriteFileDir = str3;
        this.mNotUploadWriteFileDir = this.mWriteFileDir + "/notUpload";
        this.mTrackLogWriteFileDir = "trackLog";
        this.mIsMainProcess = z;
        this.mBdLogSetting = bVar;
        this.mCommonData = cVar;
        d.a.c.e.a.d.g().h(str2);
        d.a.c.e.n.k.a.o().r(z, str, this.mContext, this.mLogSwitchInitCallback);
        d.a.c.e.n.l.b.m().n(cVar, str4, str5);
        g.h().k(cVar);
        if (cVar != null) {
            this.mAppVersion = cVar.f42493c;
        }
        if (TextUtils.isEmpty(this.mProcessNameMd5)) {
            String processNameMd5 = getProcessNameMd5();
            this.mProcessNameMd5 = processNameMd5;
            if (z && processNameMd5 == null) {
                this.mProcessNameMd5 = MAIN_PROCESS_MD5;
            }
        }
        try {
            if (this.mMultiProcessReceiver == null && this.mContext != null && !BdBaseApplication.getInst().checkInterrupt()) {
                this.mMultiProcessReceiver = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.multiproceess.uploadallfile");
                intentFilter.addAction("com.baidu.adp.stats.upload.alertlog");
                this.mContext.registerReceiver(this.mMultiProcessReceiver, intentFilter);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (j >= 60000) {
            this.mUploadInterval = j;
        }
        boolean checkInterrupt = BdBaseApplication.getInst().checkInterrupt();
        if (BdBaseApplication.getInst().checkInLater30Min()) {
            long random = (((int) (Math.random() * 30.0d)) + 1) * 60 * 1000;
            if (random > this.mUploadInterval) {
                this.mUploadInterval = random;
            }
            startOrNextUploadTimer();
        } else if (checkInterrupt) {
            if (BdBaseApplication.getInst().checkNewUser()) {
                return;
            }
            this.mUploadInterval = 3600000L;
            startOrNextUploadTimer();
        } else {
            startOrNextUploadTimer();
        }
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public boolean isSwitchReady() {
        return this.isSwitchReady;
    }

    public void liveErr(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a("live")) {
            return;
        }
        op(true, "live", str, str2, 0L, i2, str3, objArr);
    }

    public void log(String str, Object... objArr) {
        d.a.c.e.n.h.a i2 = g.h().i(str);
        if (i2 == null || !d.a.c.e.n.k.a.o().v(str, null)) {
            return;
        }
        d.a.c.e.n.a aVar = new d.a.c.e.n.a(str);
        if (objArr != null && objArr.length > 0) {
            aVar.c(objArr);
        }
        i2.a(aVar);
    }

    public void net(String str, String str2, long j, long j2, long j3, long j4, long j5, int i2, int i3, String str3, Object... objArr) {
        net("d", str, str2, j, j2, j3, j4, j5, i2, i3, str3, objArr);
    }

    public void net(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i2, int i3, String str4, Object... objArr) {
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        addLog("dbg", str, j, str2, null, objArr);
    }

    public void op(String str, String str2, long j, int i2, String str3, Object... objArr) {
        op(true, "d", str, str2, j, i2, str3, objArr);
    }

    public void op(boolean z, String str, String str2, String str3, long j, int i2, String str4, Object... objArr) {
    }

    public void performance(String str, Object... objArr) {
        addLog("pfmonitor", str, -1L, null, null, objArr);
    }

    public void resetSwitch(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new BdStatSwitchData().parserJson(str);
    }

    public void save() {
        g.h().o();
    }

    public void saveAndUploadlog(String str) {
        if (BdBaseApplication.getInst().checkInterrupt()) {
            return;
        }
        d.a.c.e.n.h.a i2 = g.h().i(str);
        g.h().A(i2);
        g.h().v(i2);
    }

    public void setAndroidId(String str) {
        d.a.c.e.n.c cVar = this.mCommonData;
        if (cVar != null) {
            cVar.v = str;
        }
    }

    public void setCommonDataMac(String str) {
        d.a.c.e.n.c cVar = this.mCommonData;
        if (cVar != null) {
            cVar.u = str;
        }
    }

    public void setOaid(String str) {
        d.a.c.e.n.c cVar = this.mCommonData;
        if (cVar != null) {
            cVar.t = str;
        }
    }

    public void setUid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g.h().B(str);
    }

    public void setUser(String str, String str2, String str3) {
        d.a.c.e.n.l.b.m().o(str, str2, str3);
    }

    public void voiceErr(String str, String str2, int i2, String str3, Object... objArr) {
        if (e.c().a("voice")) {
            return;
        }
        op(true, "voice", str, str2, 0L, i2, str3, objArr);
    }

    public void voiceNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i2, int i3, String str3, Object... objArr) {
        net("voice", str, str2, j, j2, j3, j4, j5, i2, i3, str3, objArr);
    }

    public void debug(String str, d.a.c.e.n.a aVar) {
        if (aVar == null) {
            return;
        }
        debug(str, -1L, null, aVar);
    }

    public void error(String str, long j, String str2, Object... objArr) {
        addLog("error", str, j, str2, null, objArr);
    }

    public void performance(String str, d.a.c.e.n.a aVar) {
        if (aVar == null) {
            return;
        }
        Address i2 = d.a.c.e.i.a.k().i(false, false);
        if (i2 != null) {
            aVar.b("location", i2.getLocality());
        }
        addLog("pfmonitor", str, -1L, null, aVar, new Object[0]);
    }

    public void debug(String str, long j, String str2, d.a.c.e.n.a aVar) {
        addLog("dbg", str, j, str2, aVar, new Object[0]);
    }

    public void error(String str, String str2, String str3, int i2, String str4, Object... objArr) {
        op(true, str, str2, str3, 0L, i2, str4, objArr);
    }

    private void alert(String str, String str2, Object[] objArr) {
        if (d.a.c.e.n.k.a.o().u("alert", str) && !checkUploadRecently(str)) {
            setUploadTime(str);
            d.a.c.e.n.h.a i2 = g.h().i("alert");
            d.a.c.e.n.a aVar = new d.a.c.e.n.a("alert");
            aVar.b("module", "alert");
            if (!TextUtils.isEmpty(str)) {
                aVar.b("st", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aVar.b("alert_log", str2);
            }
            aVar.b("t", String.valueOf(System.currentTimeMillis()));
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            i2.a(aVar);
            if (f.e()) {
                aVar.d(this.mCommonData);
                d.a.c.e.n.l.b.m().q(i2, aVar.f().c().toString());
            }
            BdLog.i("alert item = " + aVar.toString());
            d.a.c.e.n.l.b.m().p(i2, aVar.toString());
        }
    }
}
