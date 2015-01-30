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
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
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
    private static final long operateMsgUploadInterval = 86400000;
    private static long lastLogOperateMsgTime = 0;
    private static int operateMsgUploadCount = 0;
    private static Object lock = new Object();

    public static void init(Context context, boolean z) {
        try {
            com.baidu.adp.lib.stats.f.eq().a(context, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_UPLOAD_URL, TbConfig.LOG_SYNC_SWITCH, PRODUCTNAME, SUB_PRODUCT, TbConfig.getVersion(), TbConfig.getFrom(), TbadkCoreApplication.getClientId(), TbadkCoreApplication.m255getInst().getCuid(), TbadkCoreApplication.m255getInst().getImei(), "stat", c.on(), z);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.eq().f(str2, str, str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void net(com.baidu.tbadk.core.util.httpNet.c cVar) {
        if (cVar != null && cVar.qi().la.kt <= 180000) {
            try {
                if (cVar.qi().la.kt >= 0 && cVar.qi().la.kr >= 0 && cVar.qi().la.ks >= 0) {
                    int i = cVar.qh().KC;
                    if (!cVar.qh().pc()) {
                        i = cVar.qh().KB;
                    }
                    String str = null;
                    String pT = bk.pT();
                    if (i != 0) {
                        str = cVar.qh().mErrorString;
                    }
                    if (cVar.qg().Kz) {
                        com.baidu.adp.lib.stats.f.eq().a(i == 0 ? null : cVar.qg().qk(), cVar.qg().Ky, pT, cVar.qi().la.kq, cVar.qi().la.kp, cVar.qi().la.kt, cVar.qi().la.kr, cVar.qi().la.ks, cVar.qi().la.retry, i, str, new Object[0]);
                    } else {
                        com.baidu.adp.lib.stats.f.eq().b(cVar.qg().qk(), cVar.qg().Ky, pT, cVar.qi().la.kq, cVar.qi().la.kp, cVar.qi().la.kt, cVar.qi().la.kr, cVar.qi().la.ks, cVar.qi().la.retry, i, str, new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void imNet(SocketResponsedMessage socketResponsedMessage) {
        imNet(socketResponsedMessage, null);
    }

    public static void imNet(SocketResponsedMessage socketResponsedMessage, String str) {
        if (socketResponsedMessage != null) {
            String str2 = null;
            try {
                if (socketResponsedMessage.getOrginalMessage() != null && (socketResponsedMessage.getOrginalMessage() instanceof SocketMessage)) {
                    str2 = codecSeqId(String.valueOf(((SocketMessage) socketResponsedMessage.getOrginalMessage()).getSquencedId()));
                }
                if (str == null) {
                    com.baidu.adp.lib.stats.f.eq().a("im", String.valueOf(socketResponsedMessage.getCmd()), str2, (String) null, socketResponsedMessage.getDownSize(), 0L, socketResponsedMessage.getCostTime(), 0L, 0L, socketResponsedMessage.getRetry(), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
                } else {
                    com.baidu.adp.lib.stats.f.eq().a("im", String.valueOf(socketResponsedMessage.getCmd()), str2, (String) null, socketResponsedMessage.getDownSize(), 0L, socketResponsedMessage.getCostTime(), 0L, 0L, socketResponsedMessage.getRetry(), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), "msgtype", str);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void pushMsg(long j, int i, String str, String str2) {
        com.baidu.adp.lib.stats.f.eq().log(AddFriendActivityConfig.MSG, "message_id", Long.valueOf(j), PbActivityConfig.KEY_MSG_OP_TYPE, Integer.valueOf(i), "stat", str2, "link", str);
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = com.baidu.tbadk.core.sharedPref.b.oj().getLong("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = com.baidu.tbadk.core.sharedPref.b.oj().getInt("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000 || operateMsgUploadCount <= 3) {
                    com.baidu.tbadk.core.sharedPref.b.oj().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                } else {
                    return;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
            com.baidu.adp.lib.stats.f.eq().al(AddFriendActivityConfig.MSG);
        }
    }

    public static void crash(String str) {
        try {
            com.baidu.adp.lib.stats.f.eq().a(str, (String) null, (String) null, new Object[0]);
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
            com.baidu.adp.lib.stats.f.eq().b(str, null, bk.pT(), i, str2, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        try {
            com.baidu.adp.lib.stats.f.eq().eventStat(context, str, str2, 1, new Object[0]);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        try {
            com.baidu.adp.lib.stats.f.eq().eventStat(context, str, str2, i, objArr);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void imgError(String str, int i, String str2, String str3) {
    }

    public static void liveStreamError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.eq().d("op_live", str, bk.pT(), i, str2, "live_inf", str3, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.oj().getString("live_stream_id", ""), "err_int", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.oj().getInt("live_no_error_time", 0)));
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("live_no_error_time", 0);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void liveError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.eq().d("op_live", str, bk.pT(), i, str2, "live_inf", str3, "is_host", Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("live_is_host", false) ? 1 : 0), "stream_id", com.baidu.tbadk.core.sharedPref.b.oj().getString("live_stream_id", ""));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void aladinPortError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.eq().e("op_aladin_port_error", str, bk.pT(), i, str2, "live_inf", str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String n = com.baidu.adp.lib.util.z.n((String.valueOf(TbadkCoreApplication.getUniqueIdentifier()) + str).getBytes());
                return n.substring(n.length() - 16, n.length());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        return null;
    }

    public static void voiceError(String str, int i, String str2, String str3) {
        try {
            com.baidu.adp.lib.stats.f.eq().c("op_voice", str, bk.pT(), i, str2, "voice_inf", str3);
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static synchronized void imLog(int i, int i2, String str, String str2, String str3, int i3, String str4, long j, int i4, String str5) {
        synchronized (TiebaStatic.class) {
            try {
                String bK = com.baidu.tbadk.core.log.b.bK(i);
                com.baidu.adp.lib.stats.f eq = com.baidu.adp.lib.stats.f.eq();
                Object[] objArr = new Object[22];
                objArr[0] = com.baidu.tbadk.core.frameworkData.a.CMD;
                objArr[1] = String.valueOf(i);
                objArr[2] = "cmdRemark";
                objArr[3] = bK;
                objArr[4] = "seqID";
                objArr[5] = String.valueOf(i2);
                objArr[6] = "reason";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                objArr[7] = str;
                objArr[8] = "action";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                objArr[9] = str2;
                objArr[10] = "result";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                objArr[11] = str3;
                objArr[12] = "errorCode";
                objArr[13] = String.valueOf(i3);
                objArr[14] = "errorMsg";
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                objArr[15] = str4;
                objArr[16] = "costTime";
                objArr[17] = String.valueOf(j);
                objArr[18] = "size";
                objArr[19] = String.valueOf(i4);
                objArr[20] = "comment";
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                objArr[21] = str5;
                eq.b("im", objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static synchronized void imLog(String str, String str2, String str3) {
        synchronized (TiebaStatic.class) {
            imLog(0, 0, str, str2, str3, 0, null, 0L, 0, null);
        }
    }

    public static synchronized void imLog(String str, String str2, String str3, int i, String str4) {
        synchronized (TiebaStatic.class) {
            imLog(0, 0, str, str2, str3, i, str4, 0L, 0, null);
        }
    }

    public static synchronized void imLog(int i, int i2, String str, String str2, String str3, int i3, String str4) {
        synchronized (TiebaStatic.class) {
            imLog(i, i2, str, str2, str3, i3, str4, 0L, 0, null);
        }
    }

    public static synchronized void imLog(int i, int i2, String str, String str2, String str3, int i3, String str4, long j) {
        synchronized (TiebaStatic.class) {
            imLog(i, i2, str, str2, str3, i3, str4, j, 0, null);
        }
    }

    public static synchronized void imLog(String str, String str2, String str3, int i, String str4, long j, String str5) {
        synchronized (TiebaStatic.class) {
            imLog(0, 0, str, str2, str3, i, str4, j, 0, str5);
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                com.baidu.adp.lib.stats.f.eq().a(str, (String) null, (String) null, j3, 0, (String) null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
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
            str = com.baidu.adp.lib.util.k.e(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
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
        String pT = bk.pT();
        try {
            if (s.bL()) {
                com.baidu.adp.lib.stats.f.eq().a(str2, null, pT, -27, str, "sd_state", getSdState(), "sd_size", Long.valueOf(s.ov()));
            } else {
                com.baidu.adp.lib.stats.f.eq().a(str2, null, pT, -23, str, "sd_state", getSdState());
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static void save() {
        try {
            com.baidu.adp.plugin.b.a.hU().hV();
            w.oC();
            w.oD();
            w.oE();
            com.baidu.tbadk.performanceLog.x.zw();
            com.baidu.adp.lib.f.f.ee();
            com.baidu.adp.lib.stats.f.eq().save();
            sendMultiProcessBroadcast();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    protected static void sendMultiProcessBroadcast() {
        Intent intent = new Intent();
        intent.setAction("adp.bdstatisticsmanager2.multiprocess");
        intent.putExtra("intent_data_multiprocess_type", 1);
        TbadkCoreApplication.m255getInst().getApp().sendBroadcast(intent);
    }

    private static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static synchronized void imError(String str, int i, int i2, String str2, int i3) {
        synchronized (TiebaStatic.class) {
            try {
                com.baidu.adp.lib.stats.f.eq().a("im", str, codecSeqId(String.valueOf(i2)), "cmd:" + i, i3, str2, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static synchronized void netImg(com.baidu.adp.lib.network.http.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.dP() != null && eVar.dP().size() > 0) {
                String ab = eVar.dN().ab("sid");
                netImg(ab, eVar.dN().getUrl(), eVar.dP().get(0));
                if (eVar.dP().size() > 1) {
                    netImg(ab, eVar.dN().getUrl(), eVar.dP().get(eVar.dP().size() - 1));
                }
            }
        }
    }

    public static synchronized void netImg(String str, String str2, com.baidu.adp.lib.network.http.d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.kt <= 180000) {
                    try {
                        if (dVar.kt >= 0 && dVar.kr >= 0 && dVar.ks >= 0) {
                            int i = dVar.kx;
                            String str3 = null;
                            String pT = bk.pT();
                            if (i != 0 && i != 200) {
                                str3 = dVar.kv;
                            }
                            com.baidu.adp.lib.stats.f.eq().a(str2, str, pT, dVar.kq, dVar.kp, dVar.kt, dVar.kr, dVar.ks, dVar.retry, i, str3, new Object[0]);
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
            if (eVar.dP() != null && eVar.dP().size() > 0) {
                String ab = eVar.dN().ab("sid");
                netJson(ab, eVar.dN().getUrl(), eVar.dP().get(0), i, str);
                if (eVar.dP().size() > 1) {
                    netJson(ab, eVar.dN().getUrl(), eVar.dP().get(eVar.dP().size() - 1), i, str);
                }
            }
        }
    }

    public static synchronized void netJson(String str, String str2, com.baidu.adp.lib.network.http.d dVar, int i, String str3) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.kt <= 180000) {
                    try {
                        if (dVar.kt >= 0 && dVar.kr >= 0 && dVar.ks >= 0) {
                            int i2 = dVar.kx;
                            if (i2 == 200 || i2 / 100 == 3) {
                                i2 = 0;
                                if (i != 0) {
                                    i2 = i;
                                }
                            }
                            String str4 = new String();
                            String pT = bk.pT();
                            if (i2 != 0) {
                                str4 = String.valueOf(str4) + dVar.kv;
                                if (!TextUtils.isEmpty(str3)) {
                                    str4 = String.valueOf(str4) + str3;
                                }
                            }
                            com.baidu.adp.lib.stats.f.eq().b(getApiName(str2), str, pT, dVar.kq, dVar.kp, dVar.kt, dVar.kr, dVar.ks, dVar.retry, i2, str4, new Object[0]);
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
                com.baidu.adp.lib.stats.f eq = com.baidu.adp.lib.stats.f.eq();
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
                eq.b("pay", objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
