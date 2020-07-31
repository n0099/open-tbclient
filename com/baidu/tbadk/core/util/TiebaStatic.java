package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteFullException;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class TiebaStatic {
    public static final String ALL_COST = "all_cost";
    public static final String CON_COST = "con_cost";
    public static final String INTENT_KEY_START_TIME = "TibaStatic.StartTime";
    private static final int MAX_COST_VALUE = 180000;
    public static final String PRE_COST = "pre_cost";
    private static final String PRODUCTNAME = "tieba";
    public static final String SHOW_COST = "show_cost";
    private static final String SUB_PRODUCT = "tieba_android";
    private static long lastLogOperateMsgTime = 0;
    private static Object lock = null;
    private static int operateMsgUploadCount = 0;
    private static final long operateMsgUploadInterval = 86400000;
    private static Set<a> statisticCallbacks;

    /* loaded from: classes.dex */
    public interface a {
        void b(ap apVar);

        void xV(String str);
    }

    static {
        BdLog.addLogPackage("com.baidu.adp.plugin");
        lastLogOperateMsgTime = 0L;
        operateMsgUploadCount = 0;
        lock = new Object();
        statisticCallbacks = new LinkedHashSet();
    }

    public static void init(Context context, boolean z) {
        long j;
        try {
            com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c();
            cVar.Mj = "tieba";
            cVar.Mk = SUB_PRODUCT;
            cVar.mAppVersion = TbConfig.getVersion();
            cVar.mChannel = TbConfig.getFrom();
            cVar.Ml = TbConfig.getCurrentFrom();
            cVar.Mm = TbadkCoreApplication.getClientId();
            cVar.mCuid = TbadkCoreApplication.getInst().getCuid();
            cVar.Mn = TbadkCoreApplication.getInst().getCuidGalaxy2();
            cVar.Mo = TbadkCoreApplication.getInst().getCuidGid();
            cVar.Mp = TbadkCoreApplication.getInst().getImei();
            cVar.Mq = TbConfig.getSubappType();
            if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_LOG_REAL_TIME_UPLOAD_SWITCH, 1) == 1) {
                j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("KEY_UPLOAD_LOG_INTERVAL", 120000L);
            } else {
                j = BdKVCache.MILLS_1Hour;
            }
            BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, cVar, com.baidu.tbadk.core.util.a.aZV(), j, TbConfig.SERVER_ADDRESS + TbConfig.TRACK_LOG_UPLOAD_URL);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        try {
            BdStatisticsManager.getInstance().setUser(str2, str, str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void net(com.baidu.tbadk.core.util.a.a aVar) {
        if (aVar != null && aVar.baY().ebN.KE <= 180000) {
            try {
                if (aVar.baY().ebN.KE >= 0 && aVar.baY().ebN.connectTime >= 0 && aVar.baY().ebN.KD >= 0) {
                    int i = aVar.baX().mServerErrorCode;
                    if (!aVar.baX().isNetSuccess()) {
                        i = aVar.baX().mNetErrorCode;
                    }
                    String str = null;
                    String currentActivity = bb.getCurrentActivity();
                    if (i != 0) {
                        str = aVar.baX().mErrorString;
                    }
                    if (aVar.baW().mIsRequestImage) {
                        BdStatisticsManager.getInstance().imgNet(i == 0 ? null : aVar.baW().getApiName(), currentActivity, aVar.baY().ebN.downloadSize, aVar.baY().ebN.KC, aVar.baY().ebN.KE, aVar.baY().ebN.connectTime, aVar.baY().ebN.KD, aVar.baY().ebN.retry, i, str, new Object[0]);
                    } else {
                        BdStatisticsManager.getInstance().net(aVar.baW().getApiName(), currentActivity, aVar.baY().ebN.downloadSize, aVar.baY().ebN.KC, aVar.baY().ebN.KE, aVar.baY().ebN.connectTime, aVar.baY().ebN.KD, aVar.baY().ebN.retry, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        BdStatisticsManager.getInstance().log("msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.OPERATE_MSG_ARRIVE_CLICK_DATE, 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.OPERATE_MSG_ARRIVE_CLICK_COUNT, 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.OPERATE_MSG_ARRIVE_CLICK_DATE, currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.OPERATE_MSG_ARRIVE_CLICK_COUNT, operateMsgUploadCount);
            BdStatisticsManager.getInstance().saveAndUploadlog("msg");
        }
    }

    public static void crash(String str) {
        try {
            BdStatisticsManager.getInstance().crash(str, null, null, new Object[0]);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void printDBExceptionLog(Throwable th, String str, Object... objArr) {
        if (th != null) {
            if (th instanceof SQLiteDatabaseCorruptException) {
                printDBExceptionLog(str, -14, th.toString(), objArr);
            } else if (th instanceof SQLiteAbortException) {
                printDBExceptionLog(str, -11, th.toString(), objArr);
            } else if (th instanceof SQLiteConstraintException) {
                printDBExceptionLog(str, -12, th.toString(), objArr);
            } else if (th instanceof SQLiteDiskIOException) {
                printDBExceptionLog(str, -15, th.toString(), objArr);
            } else if (th instanceof SQLiteFullException) {
                printDBExceptionLog(str, -16, th.toString(), objArr);
            } else if (th instanceof SQLiteDoneException) {
                printDBExceptionLog(str, -19, th.toString(), objArr);
            } else {
                printDBExceptionLog(str, -17, th.toString(), objArr);
            }
        }
    }

    public static void printDBExceptionLog(String str, int i, String str2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().db(str, bb.getCurrentActivity(), i, str2, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().eventStat(context, str, str2, 1, new Object[0]);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().eventStat(context, str, str2, i, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void imgError(int i, String str, String str2) {
    }

    public static void liveStreamError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr(TiebaInitialize.OpKey.OP_LIVE, bb.getCurrentActivity(), i, str, BdStatsConstant.StatsKey.LIVE_INF, str2, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("live_is_host", false) ? 1 : 0), BdStatsConstant.StatsKey.STREAM_ID, com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.LIVE_STREAM_ID, ""), BdStatsConstant.StatsKey.ERR_INTERVAL, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.LIVE_NO_ERROR_TIME, 0)));
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.LIVE_NO_ERROR_TIME, 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr(TiebaInitialize.OpKey.OP_LIVE, bb.getCurrentActivity(), i, str, BdStatsConstant.StatsKey.LIVE_INF, str2, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("live_is_host", false) ? 1 : 0), BdStatsConstant.StatsKey.STREAM_ID, com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.LIVE_STREAM_ID, ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().aladinPortErr(TiebaInitialize.ErrorKey.OP_ALADIN_PORT_ERROR, bb.getCurrentActivity(), i, str, BdStatsConstant.StatsKey.LIVE_INF, str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String md5 = com.baidu.adp.lib.util.s.toMd5((TbadkCoreApplication.getUniqueIdentifier() + str).getBytes());
                return md5.substring(md5.length() - 16, md5.length());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return null;
    }

    public static void voiceError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().voiceErr(TiebaInitialize.OpKey.OP_VOICE, bb.getCurrentActivity(), i, str, BdStatsConstant.StatsKey.VOICE_INF, str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                BdStatisticsManager.getInstance().op(str, null, j3, 0, null, "all_cost", Long.valueOf(j), "pre_cost", Long.valueOf(j2), "con_cost", Long.valueOf(j4), "show_cost", Long.valueOf(j5));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void file(Exception exc) {
        String str = null;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 5) {
            StackTraceElement stackTraceElement = stackTrace[4];
            str = com.baidu.adp.lib.util.k.join(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
        }
        file(exc, str);
    }

    public static void file(Exception exc, String str) {
        if (exc != null) {
            file(exc.getMessage(), str);
        } else {
            file("", str);
        }
    }

    public static void file(String str, String str2) {
        String currentActivity = bb.getCurrentActivity();
        try {
            if (n.checkSD()) {
                BdStatisticsManager.getInstance().file(str2, currentActivity, -27, str, TiebaInitialize.FileKey.FILE_SD_STATE, getSdState(), TiebaInitialize.FileKey.FILE_SD_SIZE, Long.valueOf(n.getAvailableSize()));
            } else {
                BdStatisticsManager.getInstance().file(str2, currentActivity, -23, str, TiebaInitialize.FileKey.FILE_SD_STATE, getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.nY().nZ();
            u.baf();
            u.bag();
            u.bah();
            com.baidu.tbadk.n.j.bly();
            com.baidu.adp.lib.e.d.lp();
            BdStatisticsManager.getInstance().save();
            sendMultiProcessBroadcast();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent(BdStatsConstant.MULTIPROCESS_TYPE_BACKGROUND);
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.kV() != null && eVar.kV().size() > 0) {
                netImg(eVar.kT().getUrl(), eVar.kV().get(0));
                if (eVar.kV().size() > 1) {
                    netImg(eVar.kT().getUrl(), eVar.kV().get(eVar.kV().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.KE <= 180000) {
                    try {
                        if (dVar.KE >= 0 && dVar.connectTime >= 0 && dVar.KD >= 0) {
                            int i = dVar.KF;
                            String str2 = null;
                            String currentActivity = bb.getCurrentActivity();
                            if (i != 0 && i != 200) {
                                str2 = dVar.exception;
                            }
                            BdStatisticsManager.getInstance().imgNet(str, currentActivity, dVar.downloadSize, dVar.KC, dVar.KE, dVar.connectTime, dVar.KD, dVar.retry, i, str2, new Object[0]);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        }
    }

    public static synchronized void netJson(com.baidu.adp.lib.network.http.e eVar, int i, String str) {
        synchronized (TiebaStatic.class) {
            if (eVar.kV() != null && eVar.kV().size() > 0) {
                String bC = eVar.kT().bC(UbcStatConstant.KEY_CONTENT_EXT_SID);
                netJson(bC, eVar.kT().getUrl(), eVar.kV().get(0), i, str);
                if (eVar.kV().size() > 1) {
                    netJson(bC, eVar.kT().getUrl(), eVar.kV().get(eVar.kV().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.KE <= 180000) {
                    try {
                        if (dVar.KE >= 0 && dVar.connectTime >= 0 && dVar.KD >= 0) {
                            int i2 = dVar.KF;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String currentActivity = bb.getCurrentActivity();
                            if (i2 != 0) {
                                str4 = str4 + dVar.exception;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = str4 + str3;
                                }
                            }
                            BdStatisticsManager.getInstance().net(getApiName(str2), str, currentActivity, dVar.downloadSize, dVar.KC, dVar.KE, dVar.connectTime, dVar.KD, dVar.retry, i2, str4, new Object[0]);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        }
    }

    private static String getApiName(String str) {
        if (str == null) {
            return null;
        }
        String str2 = TbConfig.SERVER_ADDRESS;
        if (str.startsWith(str2)) {
            int indexOf = str.indexOf(63);
            if (indexOf < 0) {
                indexOf = str.length();
            }
            return str.substring(str2.length(), indexOf);
        }
        return str;
    }

    public static synchronized void payLog(String str, int i, String str2, String str3) {
        synchronized (TiebaStatic.class) {
            try {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                Object[] objArr = new Object[8];
                objArr[0] = TiebaInitialize.LogFields.ERROR_MESSAGE;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr[1] = str;
                objArr[2] = TiebaInitialize.LogFields.ERROR_CODE;
                objArr[3] = String.valueOf(i);
                objArr[4] = "action";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                objArr[5] = str2;
                objArr[6] = "result";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                objArr[7] = str3;
                bdStatisticsManager.debug("pay", objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static void addStatExtra(ap apVar) {
        if (apVar != null) {
            String sampleId = TbSingleton.getInstance().getSampleId();
            if (!StringUtils.isNull(sampleId)) {
                apVar.dn("sample_id", sampleId);
            }
            String bmi = com.baidu.tbadk.util.a.bmh().bmi();
            if (!StringUtils.isNull(bmi)) {
                apVar.dn("newabtest_result", bmi);
            }
            com.baidu.tbadk.l.e.bli().c(apVar);
        }
    }

    public static void log(String str) {
        try {
            ap apVar = new ap(str);
            addStatExtra(apVar);
            BdStatisticsManager.getInstance().eventStat(null, str, "", 1, apVar.getParams().toArray());
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
            noticeStatisticCallback(str);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void log(ap apVar) {
        if (apVar != null) {
            try {
                addStatExtra(apVar);
                BdStatisticsManager.getInstance().eventStat(null, apVar.getKey(), "", 1, apVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(apVar));
                }
                noticeStatisticCallback(apVar);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void logPagePV(String str) {
        try {
            BdStatisticsManager.getInstance().eventStat(null, str, "", 1, "ispv", "1");
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void logPagePV(ap apVar) {
        if (apVar != null) {
            try {
                apVar.dn("ispv", "1");
                BdStatisticsManager.getInstance().eventStat(null, apVar.getKey(), "", 1, apVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(apVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static String getStatLog(ap apVar) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (apVar == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(apVar.getKey());
        stringBuffer.append(", ");
        List<Object> params = apVar.getParams();
        if (params != null && (size = params.size()) > 0) {
            for (int i = 0; i < size; i++) {
                stringBuffer.append(params.get(i));
                if (i % 2 == 0) {
                    stringBuffer.append(ETAG.EQUAL);
                } else if (i != size - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return stringBuffer.toString();
    }

    private static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    private static void noticeStatisticCallback(String str) {
        if (!statisticCallbacks.isEmpty()) {
            for (a aVar : statisticCallbacks) {
                if (aVar != null) {
                    aVar.xV(str);
                }
            }
        }
    }

    private static void noticeStatisticCallback(ap apVar) {
        if (!statisticCallbacks.isEmpty()) {
            for (a aVar : statisticCallbacks) {
                if (aVar != null) {
                    aVar.b(apVar);
                }
            }
        }
    }

    public static void addStatisticCallback(a aVar) {
        if (aVar != null) {
            statisticCallbacks.add(aVar);
        }
    }

    public static void removeStatisticCallback(a aVar) {
        if (aVar != null) {
            statisticCallbacks.remove(aVar);
        }
    }
}
