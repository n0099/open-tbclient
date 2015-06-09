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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
        try {
            com.baidu.adp.lib.stats.f.hz().a(context, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_UPLOAD_URL, TbConfig.LOG_SYNC_SWITCH_OLD, PRODUCTNAME, SUB_PRODUCT, TbConfig.getVersion(), TbConfig.getFrom(), TbadkCoreApplication.getClientId(), TbadkCoreApplication.m411getInst().getCuid(), TbadkCoreApplication.m411getInst().getImei(), TbConfig.getSubappType(), "stat", b.so(), z);
            com.baidu.adp.lib.h.e eVar = new com.baidu.adp.lib.h.e();
            eVar.wg = PRODUCTNAME;
            eVar.wh = SUB_PRODUCT;
            eVar.wp = TbConfig.getVersion();
            eVar.wi = TbConfig.getFrom();
            eVar.mClientId = TbadkCoreApplication.getClientId();
            eVar.mCuid = TbadkCoreApplication.m411getInst().getCuid();
            eVar.wq = TbadkCoreApplication.m411getInst().getImei();
            eVar.wr = TbConfig.getSubappType();
            com.baidu.adp.lib.h.a.iB().a(context, z, TbConfig.LOG_SYNC_SWITCH, PRODUCTNAME, "newStat", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_UPLOAD_URL, eVar, b.so());
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.hz().f(str2, str, str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void net(com.baidu.tbadk.core.util.httpNet.a aVar) {
        if (aVar != null && aVar.tU().WK.uV <= 180000) {
            try {
                if (aVar.tU().WK.uV >= 0 && aVar.tU().WK.uS >= 0 && aVar.tU().WK.uT >= 0) {
                    int i = aVar.tT().WI;
                    if (!aVar.tT().ta()) {
                        i = aVar.tT().WH;
                    }
                    String str = null;
                    String tM = bg.tM();
                    if (i != 0) {
                        str = aVar.tT().mErrorString;
                    }
                    if (aVar.tS().WF) {
                        com.baidu.adp.lib.stats.f.hz().a(i == 0 ? null : aVar.tS().tW(), aVar.tS().WE, tM, aVar.tU().WK.uR, aVar.tU().WK.uQ, aVar.tU().WK.uV, aVar.tU().WK.uS, aVar.tU().WK.uT, aVar.tU().WK.uU, i, str, new Object[0]);
                    } else {
                        com.baidu.adp.lib.stats.f.hz().b(aVar.tS().tW(), aVar.tS().WE, tM, aVar.tU().WK.uR, aVar.tU().WK.uQ, aVar.tU().WK.uV, aVar.tU().WK.uS, aVar.tU().WK.uT, aVar.tU().WK.uU, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        com.baidu.adp.lib.stats.f.hz().log(AddFriendActivityConfig.MSG, "message_id", Long.valueOf(j), PbActivityConfig.KEY_MSG_OP_TYPE, Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.sl().getLong("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.sl().getInt("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.sl().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
            com.baidu.adp.lib.stats.f.hz().at(AddFriendActivityConfig.MSG);
        }
    }

    public static void crash(String str) {
        try {
            com.baidu.adp.lib.stats.f.hz().a(str, (String) null, (String) null, new Object[0]);
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
            com.baidu.adp.lib.stats.f.hz().b(str, null, bg.tM(), i, str2, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.f.hz().eventStat(context, str, str2, 1, new Object[0]);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.f.hz().eventStat(context, str, str2, i, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void imgError(String str, int i, String str2, String str3) {
    }

    public static void liveStreamError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.hz().d("op_live", str, bg.tM(), i, str2, "live_inf", str3, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.sl().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.sl().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.hz().d("op_live", str, bg.tM(), i, str2, "live_inf", str3, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.sl().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.hz().e("op_aladin_port_error", str, bg.tM(), i, str2, "live_inf", str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String p = com.baidu.adp.lib.util.ac.p((String.valueOf(TbadkCoreApplication.getUniqueIdentifier()) + str).getBytes());
                return p.substring(p.length() - 16, p.length());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return null;
    }

    public static void voiceError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.hz().c("op_voice", str, bg.tM(), i, str2, "voice_inf", str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                com.baidu.adp.lib.stats.f.hz().a(str, (String) null, (String) null, j3, 0, (String) null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
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
            str = com.baidu.adp.lib.util.m.e(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
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
        String tM = bg.tM();
        try {
            if (o.fo()) {
                com.baidu.adp.lib.stats.f.hz().a(str2, null, tM, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(o.su()));
            } else {
                com.baidu.adp.lib.stats.f.hz().a(str2, null, tM, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.lB().lC();
            t.sA();
            t.sB();
            t.sC();
            com.baidu.tbadk.performanceLog.ab.DA();
            com.baidu.adp.lib.f.f.hn();
            com.baidu.adp.lib.stats.f.hz().save();
            sendMultiProcessBroadcast();
            sendMultiProcessBroadcast2();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager.multiprocess");
        intent.putExtra("intent_data_multiprocess_type", 1);
        TbadkCoreApplication.m411getInst().getApp().sendBroadcast(intent);
    }

    protected static void sendMultiProcessBroadcast2() {
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager.multiprocess2");
        intent.putExtra("intent_data_multiprocess_type", 1);
        TbadkCoreApplication.m411getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.ha() != null && eVar.ha().size() > 0) {
                String aj = eVar.gY().aj("sid");
                netImg(aj, eVar.gY().getUrl(), eVar.ha().get(0));
                if (eVar.ha().size() > 1) {
                    netImg(aj, eVar.gY().getUrl(), eVar.ha().get(eVar.ha().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, String str2, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.uV <= 180000) {
                    try {
                        if (dVar.uV >= 0 && dVar.uS >= 0 && dVar.uT >= 0) {
                            int i = dVar.uY;
                            String str3 = null;
                            String tM = bg.tM();
                            if (i != 0 && i != 200) {
                                str3 = dVar.uX;
                            }
                            com.baidu.adp.lib.stats.f.hz().a(str2, str, tM, dVar.uR, dVar.uQ, dVar.uV, dVar.uS, dVar.uT, dVar.uU, i, str3, new Object[0]);
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
            if (eVar.ha() != null && eVar.ha().size() > 0) {
                String aj = eVar.gY().aj("sid");
                netJson(aj, eVar.gY().getUrl(), eVar.ha().get(0), i, str);
                if (eVar.ha().size() > 1) {
                    netJson(aj, eVar.gY().getUrl(), eVar.ha().get(eVar.ha().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.uV <= 180000) {
                    try {
                        if (dVar.uV >= 0 && dVar.uS >= 0 && dVar.uT >= 0) {
                            int i2 = dVar.uY;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String tM = bg.tM();
                            if (i2 != 0) {
                                str4 = String.valueOf(str4) + dVar.uX;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = String.valueOf(str4) + str3;
                                }
                            }
                            com.baidu.adp.lib.stats.f.hz().b(getApiName(str2), str, tM, dVar.uR, dVar.uQ, dVar.uV, dVar.uS, dVar.uT, dVar.uU, i2, str4, new Object[0]);
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
                com.baidu.adp.lib.stats.f hz = com.baidu.adp.lib.stats.f.hz();
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
                hz.b("pay", objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
