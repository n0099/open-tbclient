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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
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
            com.baidu.adp.lib.stats.f fVar = new com.baidu.adp.lib.stats.f();
            fVar.wB = PRODUCTNAME;
            fVar.wC = SUB_PRODUCT;
            fVar.mAppVersion = TbConfig.getVersion();
            fVar.wD = TbConfig.getFrom();
            fVar.mClientId = TbadkCoreApplication.getClientId();
            fVar.mCuid = TbadkCoreApplication.m411getInst().getCuid();
            fVar.wE = TbadkCoreApplication.m411getInst().getImei();
            fVar.wF = TbConfig.getSubappType();
            com.baidu.adp.lib.stats.a.ht().a(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_UPLOAD_URL, fVar, b.uR());
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.a.ht().f(str2, str, str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void net(com.baidu.tbadk.core.util.a.a aVar) {
        if (aVar != null && aVar.wx().adR.vg <= 180000) {
            try {
                if (aVar.wx().adR.vg >= 0 && aVar.wx().adR.vd >= 0 && aVar.wx().adR.ve >= 0) {
                    int i = aVar.ww().adP;
                    if (!aVar.ww().vE()) {
                        i = aVar.ww().vv;
                    }
                    String str = null;
                    String wr = bc.wr();
                    if (i != 0) {
                        str = aVar.ww().mErrorString;
                    }
                    if (aVar.wv().adN) {
                        com.baidu.adp.lib.stats.a.ht().a(i == 0 ? null : aVar.wv().wz(), wr, aVar.wx().adR.vc, aVar.wx().adR.vb, aVar.wx().adR.vg, aVar.wx().adR.vd, aVar.wx().adR.ve, aVar.wx().adR.vf, i, str, new Object[0]);
                    } else {
                        com.baidu.adp.lib.stats.a.ht().b(aVar.wv().wz(), wr, aVar.wx().adR.vc, aVar.wx().adR.vb, aVar.wx().adR.vg, aVar.wx().adR.vd, aVar.wx().adR.ve, aVar.wx().adR.vf, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        com.baidu.adp.lib.stats.a.ht().log(AddFriendActivityConfig.MSG, "message_id", Long.valueOf(j), PbActivityConfig.KEY_MSG_OP_TYPE, Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.uO().getLong("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.uO().getInt("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.uO().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
            com.baidu.adp.lib.stats.a.ht().ao(AddFriendActivityConfig.MSG);
        }
    }

    public static void crash(String str) {
        try {
            com.baidu.adp.lib.stats.a.ht().a(str, (String) null, (String) null, new Object[0]);
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
            com.baidu.adp.lib.stats.a.ht().b(str, bc.wr(), i, str2, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.a.ht().eventStat(context, str, str2, 1, new Object[0]);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.a.ht().eventStat(context, str, str2, i, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void imgError(int i, String str, String str2) {
    }

    public static void liveStreamError(int i, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.a.ht().d("op_live", bc.wr(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.uO().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uO().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(int i, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.a.ht().d("op_live", bc.wr(), i, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.uO().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(int i, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.a.ht().e("op_aladin_port_error", bc.wr(), i, str, "live_inf", str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String B = com.baidu.adp.lib.util.t.B((String.valueOf(TbadkCoreApplication.getUniqueIdentifier()) + str).getBytes());
                return B.substring(B.length() - 16, B.length());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return null;
    }

    public static void voiceError(int i, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.a.ht().c("op_voice", bc.wr(), i, str, "voice_inf", str2);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                com.baidu.adp.lib.stats.a.ht().a(str, (String) null, j3, 0, (String) null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
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
            str = com.baidu.adp.lib.util.j.i(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
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
        String wr = bc.wr();
        try {
            if (m.fq()) {
                com.baidu.adp.lib.stats.a.ht().a(str2, wr, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(m.uX()));
            } else {
                com.baidu.adp.lib.stats.a.ht().a(str2, wr, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.lq().lr();
            u.vd();
            u.ve();
            u.vf();
            com.baidu.tbadk.performanceLog.w.FW();
            com.baidu.adp.lib.g.d.hn();
            com.baidu.adp.lib.stats.a.ht().save();
            sendMultiProcessBroadcast();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent("com.baidu.adp.stats.background");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        TbadkCoreApplication.m411getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.hc() != null && eVar.hc().size() > 0) {
                netImg(eVar.ha().getUrl(), eVar.hc().get(0));
                if (eVar.hc().size() > 1) {
                    netImg(eVar.ha().getUrl(), eVar.hc().get(eVar.hc().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.vg <= 180000) {
                    try {
                        if (dVar.vg >= 0 && dVar.vd >= 0 && dVar.ve >= 0) {
                            int i = dVar.vj;
                            String str2 = null;
                            String wr = bc.wr();
                            if (i != 0 && i != 200) {
                                str2 = dVar.vi;
                            }
                            com.baidu.adp.lib.stats.a.ht().a(str, wr, dVar.vc, dVar.vb, dVar.vg, dVar.vd, dVar.ve, dVar.vf, i, str2, new Object[0]);
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
            if (eVar.hc() != null && eVar.hc().size() > 0) {
                String aj = eVar.ha().aj("sid");
                netJson(aj, eVar.ha().getUrl(), eVar.hc().get(0), i, str);
                if (eVar.hc().size() > 1) {
                    netJson(aj, eVar.ha().getUrl(), eVar.hc().get(eVar.hc().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.vg <= 180000) {
                    try {
                        if (dVar.vg >= 0 && dVar.vd >= 0 && dVar.ve >= 0) {
                            int i2 = dVar.vj;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String wr = bc.wr();
                            if (i2 != 0) {
                                str4 = String.valueOf(str4) + dVar.vi;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = String.valueOf(str4) + str3;
                                }
                            }
                            com.baidu.adp.lib.stats.a.ht().a(getApiName(str2), str, wr, dVar.vc, dVar.vb, dVar.vg, dVar.vd, dVar.ve, dVar.vf, i2, str4, new Object[0]);
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
                com.baidu.adp.lib.stats.a ht = com.baidu.adp.lib.stats.a.ht();
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
                ht.c("pay", objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void log(String str) {
        try {
            com.baidu.adp.lib.stats.a.ht().eventStat(null, str, "", 1, new Object[0]);
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void log(au auVar) {
        if (auVar != null) {
            try {
                com.baidu.adp.lib.stats.a.ht().eventStat(null, auVar.getKey(), "", 1, auVar.vY().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(auVar));
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    private static String getStatLog(au auVar) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (auVar == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(auVar.getKey());
        stringBuffer.append(", ");
        List<Object> vY = auVar.vY();
        if (vY != null && (size = vY.size()) > 0) {
            for (int i = 0; i < size; i++) {
                stringBuffer.append(vY.get(i));
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
