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
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
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

    static {
        BdLog.addLogPackage("com.baidu.adp.plugin");
        lastLogOperateMsgTime = 0L;
        operateMsgUploadCount = 0;
        lock = new Object();
    }

    public static void init(Context context, boolean z) {
        long j;
        try {
            com.baidu.adp.lib.stats.c cVar = new com.baidu.adp.lib.stats.c();
            cVar.Eb = "tieba";
            cVar.Ec = SUB_PRODUCT;
            cVar.mAppVersion = TbConfig.getVersion();
            cVar.mChannel = TbConfig.getFrom();
            cVar.Ed = TbConfig.getCurrentFrom();
            cVar.Ee = TbadkCoreApplication.getClientId();
            cVar.mCuid = TbadkCoreApplication.getInst().getCuid();
            cVar.Ef = TbadkCoreApplication.getInst().getCuidGalaxy2();
            cVar.Eg = TbadkCoreApplication.getInst().getCuidGid();
            cVar.Eh = TbadkCoreApplication.getInst().getImei();
            cVar.Ei = TbConfig.getSubappType();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", 1) == 1) {
                j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("KEY_UPLOAD_LOG_INTERVAL", 120000L);
            } else {
                j = 3600000;
            }
            BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, cVar, a.CB(), j);
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
        if (aVar != null && aVar.Ej().aDw.CJ <= 180000) {
            try {
                if (aVar.Ej().aDw.CJ >= 0 && aVar.Ej().aDw.connectTime >= 0 && aVar.Ej().aDw.CH >= 0) {
                    int i = aVar.Ei().aDu;
                    if (!aVar.Ei().Dm()) {
                        i = aVar.Ei().De;
                    }
                    String str = null;
                    String Ed = aw.Ed();
                    if (i != 0) {
                        str = aVar.Ei().mErrorString;
                    }
                    if (aVar.Eh().aDs) {
                        BdStatisticsManager.getInstance().imgNet(i == 0 ? null : aVar.Eh().El(), Ed, aVar.Ej().aDw.CG, aVar.Ej().aDw.CF, aVar.Ej().aDw.CJ, aVar.Ej().aDw.connectTime, aVar.Ej().aDw.CH, aVar.Ej().aDw.CI, i, str, new Object[0]);
                    } else {
                        BdStatisticsManager.getInstance().net(aVar.Eh().El(), Ed, aVar.Ej().aDw.CG, aVar.Ej().aDw.CF, aVar.Ej().aDw.CJ, aVar.Ej().aDw.connectTime, aVar.Ej().aDw.CH, aVar.Ej().aDw.CI, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        BdStatisticsManager.getInstance().log("msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, SelectForumActivityConfig.KEY_SHARE_LINK, str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
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
            BdStatisticsManager.getInstance().db(str, aw.Ed(), i, str2, objArr);
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
            BdStatisticsManager.getInstance().liveErr("op_live", aw.Ed(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr("op_live", aw.Ed(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().aladinPortErr("op_aladin_port_error", aw.Ed(), i, str, "live_inf", str2);
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
            BdStatisticsManager.getInstance().voiceErr("op_voice", aw.Ed(), i, str, "voice_inf", str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                BdStatisticsManager.getInstance().op(str, null, j3, 0, null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
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
            str = com.baidu.adp.lib.util.k.j(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
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
        String Ed = aw.Ed();
        try {
            if (l.hA()) {
                BdStatisticsManager.getInstance().file(str2, Ed, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(l.CJ()));
            } else {
                BdStatisticsManager.getInstance().file(str2, Ed, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.mN().mO();
            s.CP();
            s.CQ();
            s.CR();
            com.baidu.tbadk.l.j.Pj();
            com.baidu.adp.lib.f.d.jC();
            BdStatisticsManager.getInstance().save();
            sendMultiProcessBroadcast();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent("com.baidu.adp.stats.background");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.jr() != null && eVar.jr().size() > 0) {
                netImg(eVar.jp().getUrl(), eVar.jr().get(0));
                if (eVar.jr().size() > 1) {
                    netImg(eVar.jp().getUrl(), eVar.jr().get(eVar.jr().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.CJ <= 180000) {
                    try {
                        if (dVar.CJ >= 0 && dVar.connectTime >= 0 && dVar.CH >= 0) {
                            int i = dVar.CM;
                            String str2 = null;
                            String Ed = aw.Ed();
                            if (i != 0 && i != 200) {
                                str2 = dVar.CL;
                            }
                            BdStatisticsManager.getInstance().imgNet(str, Ed, dVar.CG, dVar.CF, dVar.CJ, dVar.connectTime, dVar.CH, dVar.CI, i, str2, new Object[0]);
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
            if (eVar.jr() != null && eVar.jr().size() > 0) {
                String aQ = eVar.jp().aQ("sid");
                netJson(aQ, eVar.jp().getUrl(), eVar.jr().get(0), i, str);
                if (eVar.jr().size() > 1) {
                    netJson(aQ, eVar.jp().getUrl(), eVar.jr().get(eVar.jr().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.CJ <= 180000) {
                    try {
                        if (dVar.CJ >= 0 && dVar.connectTime >= 0 && dVar.CH >= 0) {
                            int i2 = dVar.CM;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String Ed = aw.Ed();
                            if (i2 != 0) {
                                str4 = str4 + dVar.CL;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = str4 + str3;
                                }
                            }
                            BdStatisticsManager.getInstance().net(getApiName(str2), str, Ed, dVar.CG, dVar.CF, dVar.CJ, dVar.connectTime, dVar.CH, dVar.CI, i2, str4, new Object[0]);
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
                objArr[0] = "errorMsg";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr[1] = str;
                objArr[2] = AudioStatusCallback.KEY_ERROR_CODE;
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

    public static void log(String str) {
        try {
            BdStatisticsManager.getInstance().eventStat(null, str, "", 1, new Object[0]);
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
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

    public static void log(am amVar) {
        if (amVar != null) {
            try {
                BdStatisticsManager.getInstance().eventStat(null, amVar.getKey(), "", 1, amVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(amVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void logPagePV(am amVar) {
        if (amVar != null) {
            try {
                amVar.aA("ispv", "1");
                BdStatisticsManager.getInstance().eventStat(null, amVar.getKey(), "", 1, amVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(amVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static String getStatLog(am amVar) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (amVar == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(amVar.getKey());
        stringBuffer.append(", ");
        List<Object> params = amVar.getParams();
        if (params != null && (size = params.size()) > 0) {
            for (int i = 0; i < size; i++) {
                stringBuffer.append(params.get(i));
                if (i % 2 == 0) {
                    stringBuffer.append(ETAG.EQUAL);
                } else if (i != size - 1) {
                    stringBuffer.append(",");
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
}
