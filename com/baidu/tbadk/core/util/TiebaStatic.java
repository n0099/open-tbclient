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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
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

    /* loaded from: classes.dex */
    public static class a {
    }

    static {
        BdLog.addLogPackage("com.baidu.adp.plugin");
        lastLogOperateMsgTime = 0L;
        operateMsgUploadCount = 0;
        lock = new Object();
    }

    public static void init(Context context, boolean z) {
        try {
            com.baidu.adp.lib.stats.e eVar = new com.baidu.adp.lib.stats.e();
            eVar.xg = PRODUCTNAME;
            eVar.xh = SUB_PRODUCT;
            eVar.mAppVersion = TbConfig.getVersion();
            eVar.xi = TbConfig.getFrom();
            eVar.xj = TbConfig.getCurrentFrom();
            eVar.mClientId = TbadkCoreApplication.getClientId();
            eVar.mCuid = TbadkCoreApplication.m9getInst().getCuid();
            eVar.xk = TbadkCoreApplication.m9getInst().getImei();
            eVar.xl = TbConfig.getSubappType();
            BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_UPLOAD_URL, eVar, com.baidu.tbadk.core.util.a.us());
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
        if (aVar != null && aVar.vU().agY.vQ <= 180000) {
            try {
                if (aVar.vU().agY.vQ >= 0 && aVar.vU().agY.vN >= 0 && aVar.vU().agY.vO >= 0) {
                    int i = aVar.vT().agW;
                    if (!aVar.vT().vc()) {
                        i = aVar.vT().wj;
                    }
                    String str = null;
                    String vO = ba.vO();
                    if (i != 0) {
                        str = aVar.vT().mErrorString;
                    }
                    if (aVar.vS().agU) {
                        BdStatisticsManager.getInstance().imgNet(i == 0 ? null : aVar.vS().vW(), vO, aVar.vU().agY.vM, aVar.vU().agY.vL, aVar.vU().agY.vQ, aVar.vU().agY.vN, aVar.vU().agY.vO, aVar.vU().agY.vP, i, str, new Object[0]);
                    } else {
                        BdStatisticsManager.getInstance().net(aVar.vS().vW(), vO, aVar.vU().agY.vM, aVar.vU().agY.vL, aVar.vU().agY.vQ, aVar.vU().agY.vN, aVar.vU().agY.vO, aVar.vU().agY.vP, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        BdStatisticsManager.getInstance().log(AddFriendActivityConfig.MSG, "message_id", Long.valueOf(j), PbActivityConfig.KEY_MSG_OP_TYPE, Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.uo().getLong("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.uo().getInt("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.uo().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
            BdStatisticsManager.getInstance().saveAndUploadlog(AddFriendActivityConfig.MSG);
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
            BdStatisticsManager.getInstance().db(str, ba.vO(), i, str2, objArr);
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
            BdStatisticsManager.getInstance().liveErr("op_live", ba.vO(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uo().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.uo().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uo().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr("op_live", ba.vO(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uo().getBoolean(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.uo().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().aladinPortErr("op_aladin_port_error", ba.vO(), i, str, "live_inf", str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String md5 = com.baidu.adp.lib.util.t.toMd5((String.valueOf(TbadkCoreApplication.getUniqueIdentifier()) + str).getBytes());
                return md5.substring(md5.length() - 16, md5.length());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return null;
    }

    public static void voiceError(int i, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().voiceErr("op_voice", ba.vO(), i, str, "voice_inf", str2);
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
            str = com.baidu.adp.lib.util.j.j(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
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
        String vO = ba.vO();
        try {
            if (l.dH()) {
                BdStatisticsManager.getInstance().file(str2, vO, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(l.uz()));
            } else {
                BdStatisticsManager.getInstance().file(str2, vO, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.jg().jh();
            u.uF();
            u.uG();
            u.uH();
            com.baidu.tbadk.performanceLog.w.Gg();
            com.baidu.adp.lib.f.d.fI();
            BdStatisticsManager.getInstance().save();
            sendMultiProcessBroadcast();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent("com.baidu.adp.stats.background");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        TbadkCoreApplication.m9getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.f fVar) {
        synchronized (TiebaStatic.class) {
            if (fVar.fx() != null && fVar.fx().size() > 0) {
                netImg(fVar.fv().getUrl(), fVar.fx().get(0));
                if (fVar.fx().size() > 1) {
                    netImg(fVar.fv().getUrl(), fVar.fx().get(fVar.fx().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar != null) {
                if (eVar.vQ <= 180000) {
                    try {
                        if (eVar.vQ >= 0 && eVar.vN >= 0 && eVar.vO >= 0) {
                            int i = eVar.vT;
                            String str2 = null;
                            String vO = ba.vO();
                            if (i != 0 && i != 200) {
                                str2 = eVar.vS;
                            }
                            BdStatisticsManager.getInstance().imgNet(str, vO, eVar.vM, eVar.vL, eVar.vQ, eVar.vN, eVar.vO, eVar.vP, i, str2, new Object[0]);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        }
    }

    public static synchronized void netJson(com.baidu.adp.lib.network.http.f fVar, int i, String str) {
        synchronized (TiebaStatic.class) {
            if (fVar.fx() != null && fVar.fx().size() > 0) {
                String ad = fVar.fv().ad("sid");
                netJson(ad, fVar.fv().getUrl(), fVar.fx().get(0), i, str);
                if (fVar.fx().size() > 1) {
                    netJson(ad, fVar.fv().getUrl(), fVar.fx().get(fVar.fx().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.e eVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (eVar != null) {
                if (eVar.vQ <= 180000) {
                    try {
                        if (eVar.vQ >= 0 && eVar.vN >= 0 && eVar.vO >= 0) {
                            int i2 = eVar.vT;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String vO = ba.vO();
                            if (i2 != 0) {
                                str4 = String.valueOf(str4) + eVar.vS;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = String.valueOf(str4) + str3;
                                }
                            }
                            BdStatisticsManager.getInstance().net(getApiName(str2), str, vO, eVar.vM, eVar.vL, eVar.vQ, eVar.vN, eVar.vO, eVar.vP, i2, str4, new Object[0]);
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

    public static void log(as asVar) {
        if (asVar != null) {
            try {
                BdStatisticsManager.getInstance().eventStat(null, asVar.getKey(), "", 1, asVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(asVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void logPagePV(as asVar) {
        if (asVar != null) {
            try {
                asVar.Z("ispv", "1");
                BdStatisticsManager.getInstance().eventStat(null, asVar.getKey(), "", 1, asVar.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(asVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static String getStatLog(as asVar) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (asVar == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(asVar.getKey());
        stringBuffer.append(", ");
        List<Object> params = asVar.getParams();
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
