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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.tencent.tauth.AuthActivity;
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
            cVar.AY = PRODUCTNAME;
            cVar.AZ = SUB_PRODUCT;
            cVar.mAppVersion = TbConfig.getVersion();
            cVar.mChannel = TbConfig.getFrom();
            cVar.Ba = TbConfig.getCurrentFrom();
            cVar.Bb = TbadkCoreApplication.getClientId();
            cVar.mCuid = TbadkCoreApplication.getInst().getCuid();
            cVar.Bc = TbadkCoreApplication.getInst().getCuidGalaxy2();
            cVar.Bd = TbadkCoreApplication.getInst().getCuidGid();
            cVar.Be = TbadkCoreApplication.getInst().getImei();
            cVar.Bf = TbConfig.getSubappType();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", 1) == 1) {
                j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("KEY_UPLOAD_LOG_INTERVAL", 120000L);
            } else {
                j = 3600000;
            }
            BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, cVar, a.yk(), j);
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
        if (aVar != null && aVar.zZ().ast.zG <= 180000) {
            try {
                if (aVar.zZ().ast.zG >= 0 && aVar.zZ().ast.connectTime >= 0 && aVar.zZ().ast.zE >= 0) {
                    int i = aVar.zY().asr;
                    if (!aVar.zY().za()) {
                        i = aVar.zY().zZ;
                    }
                    String str = null;
                    String zR = ax.zR();
                    if (i != 0) {
                        str = aVar.zY().mErrorString;
                    }
                    if (aVar.zX().asp) {
                        BdStatisticsManager.getInstance().imgNet(i == 0 ? null : aVar.zX().Ab(), zR, aVar.zZ().ast.zD, aVar.zZ().ast.zC, aVar.zZ().ast.zG, aVar.zZ().ast.connectTime, aVar.zZ().ast.zE, aVar.zZ().ast.zF, i, str, new Object[0]);
                    } else {
                        BdStatisticsManager.getInstance().net(aVar.zX().Ab(), zR, aVar.zZ().ast.zD, aVar.zZ().ast.zC, aVar.zZ().ast.zG, aVar.zZ().ast.connectTime, aVar.zZ().ast.zE, aVar.zZ().ast.zF, i, str, new Object[0]);
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
            BdStatisticsManager.getInstance().db(str, ax.zR(), i, str2, objArr);
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
            BdStatisticsManager.getInstance().liveErr("op_live", ax.zR(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr("op_live", ax.zR(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().aladinPortErr("op_aladin_port_error", ax.zR(), i, str, "live_inf", str2);
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
            BdStatisticsManager.getInstance().voiceErr("op_voice", ax.zR(), i, str, "voice_inf", str2);
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
        String zR = ax.zR();
        try {
            if (l.ge()) {
                BdStatisticsManager.getInstance().file(str2, zR, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(l.yu()));
            } else {
                BdStatisticsManager.getInstance().file(str2, zR, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.ly().lz();
            t.yD();
            t.yE();
            t.yF();
            com.baidu.tbadk.k.j.KI();
            com.baidu.adp.lib.f.d.ii();
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
            if (eVar.hX() != null && eVar.hX().size() > 0) {
                netImg(eVar.hV().getUrl(), eVar.hX().get(0));
                if (eVar.hX().size() > 1) {
                    netImg(eVar.hV().getUrl(), eVar.hX().get(eVar.hX().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.zG <= 180000) {
                    try {
                        if (dVar.zG >= 0 && dVar.connectTime >= 0 && dVar.zE >= 0) {
                            int i = dVar.zJ;
                            String str2 = null;
                            String zR = ax.zR();
                            if (i != 0 && i != 200) {
                                str2 = dVar.zI;
                            }
                            BdStatisticsManager.getInstance().imgNet(str, zR, dVar.zD, dVar.zC, dVar.zG, dVar.connectTime, dVar.zE, dVar.zF, i, str2, new Object[0]);
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
            if (eVar.hX() != null && eVar.hX().size() > 0) {
                String ay = eVar.hV().ay("sid");
                netJson(ay, eVar.hV().getUrl(), eVar.hX().get(0), i, str);
                if (eVar.hX().size() > 1) {
                    netJson(ay, eVar.hV().getUrl(), eVar.hX().get(eVar.hX().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.zG <= 180000) {
                    try {
                        if (dVar.zG >= 0 && dVar.connectTime >= 0 && dVar.zE >= 0) {
                            int i2 = dVar.zJ;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String zR = ax.zR();
                            if (i2 != 0) {
                                str4 = str4 + dVar.zI;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = str4 + str3;
                                }
                            }
                            BdStatisticsManager.getInstance().net(getApiName(str2), str, zR, dVar.zD, dVar.zC, dVar.zG, dVar.connectTime, dVar.zE, dVar.zF, i2, str4, new Object[0]);
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
                objArr[2] = "errorCode";
                objArr[3] = String.valueOf(i);
                objArr[4] = AuthActivity.ACTION_KEY;
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

    public static void log(an anVar) {
        if (anVar != null) {
            try {
                BdStatisticsManager.getInstance().eventStat(null, anVar.getKey(), "", 1, anVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(anVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void logPagePV(an anVar) {
        if (anVar != null) {
            try {
                anVar.ah("ispv", "1");
                BdStatisticsManager.getInstance().eventStat(null, anVar.getKey(), "", 1, anVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(anVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static String getStatLog(an anVar) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (anVar == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(anVar.getKey());
        stringBuffer.append(", ");
        List<Object> params = anVar.getParams();
        if (params != null && (size = params.size()) > 0) {
            for (int i = 0; i < size; i++) {
                stringBuffer.append(params.get(i));
                if (i % 2 == 0) {
                    stringBuffer.append("=");
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
