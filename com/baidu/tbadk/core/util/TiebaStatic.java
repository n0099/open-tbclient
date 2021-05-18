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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.c.e.j.a.d;
import d.a.c.e.n.c;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.e.p.q;
import d.a.j0.i0.e;
import d.a.j0.m0.i;
import d.a.j0.r.d0.b;
import d.a.j0.z0.a;
import d.a.j0.z0.g;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class TiebaStatic {
    public static final String ALL_COST = "all_cost";
    public static final String CON_COST = "con_cost";
    public static final String INTENT_KEY_START_TIME = "TibaStatic.StartTime";
    public static final int MAX_COST_VALUE = 180000;
    public static final String PRE_COST = "pre_cost";
    public static final String PRODUCTNAME = "tieba";
    public static final String SHOW_COST = "show_cost";
    public static final String SUB_PRODUCT = "tieba_android";
    public static long lastLogOperateMsgTime = 0;
    public static Object lock = null;
    public static int operateMsgUploadCount = 0;
    public static final long operateMsgUploadInterval = 86400000;
    public static Set<TiebaStatisticCallback> statisticCallbacks;

    /* loaded from: classes3.dex */
    public static class DQPay extends LogFields {
        public static final String TYPE_VALUE = "pay";
    }

    /* loaded from: classes3.dex */
    public static class ErrorKey {
        public static final String OP_ALADIN_PORT_ERROR = "op_aladin_port_error";
    }

    /* loaded from: classes3.dex */
    public static class FileKey {
        public static final String FILE_SD_SIZE = "sd_size";
        public static final String FILE_SD_STATE = "sd_state";
    }

    /* loaded from: classes3.dex */
    public static class IM extends LogFields {
        public static final String TYPE_VALUE = "im";
    }

    /* loaded from: classes3.dex */
    public static class LogFields {
        public static final String ACTION = "action";
        public static final String CMD = "cmd";
        public static final String CMD_REMARK = "cmdRemark";
        public static final String COMMENT = "comment";
        public static final String COST_TIME = "costTime";
        public static final String CUID = "cuid";
        public static final String ERROR_CODE = "errorCode";
        public static final String ERROR_MESSAGE = "errorMsg";
        public static final String IM_UID = "uid";
        public static final String LOG_TYPE = "logtype";
        public static final String MODEL = "model";
        public static final String NETWORK = "network";
        public static final String REASON = "reason";
        public static final String RESULT = "result";
        public static final String SIZE = "size";
        public static final String SQUENCE_ID = "seqID";
        public static final String TIME = "time";
        public static final String TYPE_VALUE = "";
        public static final String URL = "url";
        public static final String VERSON = "version";
    }

    /* loaded from: classes3.dex */
    public static class NetApiName {
    }

    /* loaded from: classes3.dex */
    public static class NetKey {
        public static final String NET_IMG = "img";
    }

    /* loaded from: classes3.dex */
    public static class OpKey {
        public static final String OP_FORUM_ENTER = "op_forum_enter";
        public static final String OP_FRS_ENTER = "op_frs_enter";
        public static final String OP_IMG = "op_img";
        public static final String OP_LIVE = "op_live";
        public static final String OP_NEWS_ENTER = "op_news_enter";
        public static final String OP_PB_ENTER = "op_pb_enter";
        public static final String OP_SQUARE_ENTER = "op_square_enter";
        public static final String OP_VOICE = "op_voice";
    }

    /* loaded from: classes3.dex */
    public static class Params {
        public static final String ABTEST = "abtest";
        public static final String ABTEST_RESULT = "newabtest_result";
        public static final String AB_ACTION = "ab_action";
        public static final String AB_TAG = "ab_tag";
        public static final String AB_TYPE = "ab_type";
        public static final String AD_DESC = "ad_desc";
        public static final String AD_PIC = "ad_pic";
        public static final String AD_SOURCE = "ad_bear_source";
        public static final String AD_TITLE = "ad_title";
        public static final String AD_TYPE = "ad_type";
        public static final String AID = "aid";
        public static final String CARD_TYPE = "card_type";
        public static final String CLICK_LOCATE = "click_locate";
        public static final String CUID = "cuid";
        public static final String CUID_GALAXY2 = "cuid_galaxy2";
        public static final String CUID_GALAXY3 = "c3_aid";
        public static final String CUID_GID = "cuid_gid";
        public static final String ENTRY_NAME = "entryname";
        public static final String EXPOSURE_TIME = "exposure_time";
        public static final String FIRST_DIR = "first_dir";
        public static final String FORUM_ID = "fid";
        public static final String FORUM_ID_MERGE = "fids";
        public static final String FORUM_NAME = "fname";
        public static final String FRIEND_UID = "friend_uid";
        public static final String GUA_TYPE = "gua_type";
        public static final String H5_FORUM_NAME = "kw";
        public static final String IS_FOLLOW = "is_follow";
        public static final String IS_FULL = "is_full";
        public static final String IS_OFFICIAL = "obj_isofficial";
        public static final String IS_OFFICIAL_MERGE = "obj_isofficials";
        public static final String IS_VERTICAL = "is_vertical";
        public static final String IS_ZP = "is_zp";
        public static final String LIST_ORDER = "list_order";
        public static final String MID_PAGE_FLAG = "midpageflag";
        public static final String NID = "nid";
        public static final String OBJ_AD_LOCATE = "obj_adlocate";
        public static final String OBJ_AD_LOCATE_MERGE = "obj_adlocates";
        public static final String OBJ_CUR_PAGE = "obj_cur_page";
        public static final String OBJ_DURATION = "obj_duration";
        public static final String OBJ_EXTRA = "extra";
        public static final String OBJ_FLOOR = "obj_floor";
        public static final String OBJ_FLOOR_MERGE = "obj_floors";
        public static final String OBJ_ID = "obj_id";
        public static final String OBJ_ID_MERGE = "obj_ids";
        public static final String OBJ_ISAD = "obj_isad";
        public static final String OBJ_ISAD_MERGE = "obj_isads";
        public static final String OBJ_ISHOST = "obj_ishost";
        public static final String OBJ_LOCATE = "obj_locate";
        public static final String OBJ_NAME = "obj_name";
        public static final String OBJ_PAGE = "obj_page";
        public static final String OBJ_PARAM1 = "obj_param1";
        public static final String OBJ_PARAM2 = "obj_param2";
        public static final String OBJ_PARAM3 = "obj_param3";
        public static final String OBJ_PARAM4 = "obj_param4";
        public static final String OBJ_PARAM5 = "obj_param5";
        public static final String OBJ_PARAM6 = "obj_param6";
        public static final String OBJ_PARAM7 = "obj_param7";
        public static final String OBJ_PARAM8 = "obj_param8";
        public static final String OBJ_PRE_PAGE = "obj_pre_page";
        public static final String OBJ_SOURCE = "obj_source";
        public static final String OBJ_TAB = "obj_tab";
        public static final String OBJ_TO = "obj_to";
        public static final String OBJ_TYPE = "obj_type";
        public static final String OBJ_URL = "obj_url";
        public static final String PID = "pid";
        public static final String PID_MERGE = "pids";
        public static final String POST_ID = "post_id";
        public static final String POST_TYPE = "post_type";
        public static final String POST_TYPE_MERGE = "post_types";
        public static final String QUERY = "query";
        public static final String RECOM_AB_TAG = "recom_ab_tag";
        public static final String RECOM_EXTRA = "recom_extra";
        public static final String RECOM_SOURCE = "recom_source";
        public static final String RECOM_TYPE = "recom_type";
        public static final String RECOM_WEIGHT = "recom_weight";
        public static final String REC_SOURCE = "source";
        public static final String REFER = "refer";
        public static final String REPLY_TYPE = "reply_type";
        public static final String RESOURCE_ID = "resource_id";
        public static final String SAMPLE_ID = "sample_id";
        public static final String SECOND_DIR = "second_dir";
        public static final String SERVICE_ID = "service_id";
        public static final String SORT_TYPE = "sort_type";
        public static final String SOURCE_FROM = "source_from";
        public static final String STAR_ID = "star_id";
        public static final String TAB_ID = "tab_id";
        public static final String TAG_ID = "tag_id";
        public static final String TASK_ID = "task_id";
        public static final String THREAD_TYPE = "thread_type";
        public static final String THREAD_TYPE_MERGE = "thread_types";
        public static final String TID = "tid";
        public static final String TID_MERGE = "tids";
        public static final String TID_TYPE = "tid_type";
        public static final String TOPIC_ID = "topic_id";
        public static final String UGC_NID = "ugc_nid";
        public static final String UGC_TYPE = "ori_ugc_type";
        public static final String UGC_VID = "ugc_vid";
        public static final String UID = "uid";
        public static final String VID = "vid";
        public static final String WEIGHT = "weight";
    }

    /* loaded from: classes3.dex */
    public interface TiebaStatisticCallback {
        void onLog(StatisticItem statisticItem);

        void onLog(String str);
    }

    /* loaded from: classes3.dex */
    public static class YYParams {
        public static final String HDID = "hdid";
        public static final String YYLIVEID = "yyliveid";
        public static final String YYSID = "yysid";
        public static final String YYSSID = "yyssid";
        public static final String YYUID = "yyuid";
    }

    /* loaded from: classes3.dex */
    public static class YYValues {
        public static final String YY_LIVE = "yylive";
    }

    static {
        BdLog.addLogPackage("com.baidu.adp.plugin");
        lastLogOperateMsgTime = 0L;
        operateMsgUploadCount = 0;
        lock = new Object();
        statisticCallbacks = new LinkedHashSet();
    }

    public static void addStatExtra(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        String sampleId = TbSingleton.getInstance().getSampleId();
        if (!StringUtils.isNull(sampleId)) {
            statisticItem.param(Params.SAMPLE_ID, sampleId);
        }
        String c2 = a.d().c();
        if (!StringUtils.isNull(c2)) {
            statisticItem.param(Params.ABTEST_RESULT, c2);
        }
        e.f().e(statisticItem);
    }

    public static void addStatisticCallback(TiebaStatisticCallback tiebaStatisticCallback) {
        if (tiebaStatisticCallback != null) {
            statisticCallbacks.add(tiebaStatisticCallback);
        }
    }

    public static void aladinPortError(int i2, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().aladinPortErr(ErrorKey.OP_ALADIN_PORT_ERROR, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static String codecSeqId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String d2 = q.d((TbadkCoreApplication.getUniqueIdentifier() + str).getBytes());
            return d2.substring(d2.length() - 16, d2.length());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static void crash(String str) {
        try {
            BdStatisticsManager.getInstance().crash(str, null, null, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void deleteParamByKey(StatisticItem statisticItem, String str) {
        int indexOf = statisticItem.getParams().indexOf(str);
        if (indexOf != -1) {
            statisticItem.getParams().remove(indexOf);
            statisticItem.getParams().remove(indexOf);
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().eventStat(context, str, str2, 1, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void file(Exception exc) {
        String str;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 5) {
            StackTraceElement stackTraceElement = stackTrace[4];
            str = k.join(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
        } else {
            str = null;
        }
        file(exc, str);
    }

    public static String getApiName(String str) {
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

    public static String getCua(Context context) {
        return l.k(context) + "_" + l.i(context) + "_android_" + TbConfig.getVersion() + "_" + l.h(context);
    }

    public static String getSdState() {
        return Environment.getExternalStorageState();
    }

    public static String getStatLog(StatisticItem statisticItem) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        if (statisticItem == null) {
            return "";
        }
        stringBuffer.append("RD_STAT_LOG: ");
        stringBuffer.append("key=");
        stringBuffer.append(statisticItem.getKey());
        stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        List<Object> params = statisticItem.getParams();
        if (params != null && (size = params.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                stringBuffer.append(params.get(i2));
                if (i2 % 2 == 0) {
                    stringBuffer.append("=");
                } else if (i2 != size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void imgError(int i2, String str, String str2) {
    }

    public static void init(Context context, boolean z) {
        try {
            c cVar = new c();
            cVar.f39071a = "tieba";
            cVar.f39072b = SUB_PRODUCT;
            cVar.f39073c = TbConfig.getVersion();
            cVar.f39074d = TbConfig.getFrom();
            cVar.f39075e = TbConfig.getCurrentFrom();
            cVar.f39076f = TbadkCoreApplication.getClientId();
            cVar.f39077g = TbadkCoreApplication.getInst().getCuid();
            cVar.f39078h = TbadkCoreApplication.getInst().getCuidGalaxy2();
            TbadkCoreApplication.getInst().getCuidGid();
            cVar.f39079i = TbadkCoreApplication.getInst().getImei();
            cVar.j = TbConfig.getSubappType();
            cVar.r = g.c().f(context) + "_" + g.c().e(context);
            cVar.v = TbadkCoreApplication.getInst().getAndroidId();
            cVar.s = getCua(context);
            cVar.t = PermissionUtil.getLastCachedOid(context);
            cVar.u = PermissionUtil.getLocalMacAddress(context);
            cVar.w = g.c().a();
            cVar.x = g.c().g() + "_" + g.c().h();
            cVar.z = TbSingleton.getInstance().getBaiduIdForAnti();
            cVar.A = String.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
            cVar.B = String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
            cVar.C = String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
            cVar.D = TbSingleton.getInstance().getData();
            boolean z2 = true;
            if (b.j().k("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", 1) != 1) {
                z2 = false;
            }
            long l = z2 ? b.j().l("KEY_UPLOAD_LOG_INTERVAL", AppConfig.TIMESTAMP_AVAILABLE_DURATION) : VideoCloudSetting.HOUR_MILLISECOND;
            BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, cVar, BdLogSetting.getInstance(), l, TbConfig.SERVER_ADDRESS + TbConfig.TRACK_LOG_UPLOAD_URL);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static boolean isDebugMode() {
        if (BdBaseApplication.getInst() == null) {
            return false;
        }
        return BdBaseApplication.getInst().isDebugMode();
    }

    public static void liveError(int i2, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr(OpKey.OP_LIVE, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(b.j().g(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", b.j().p("live_stream_id", ""));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void liveStreamError(int i2, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().liveErr(OpKey.OP_LIVE, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(b.j().g(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", b.j().p("live_stream_id", ""), "err_int", Integer.valueOf(b.j().k("live_no_error_time", 0)));
            b.j().v("live_no_error_time", 0);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void log(String str) {
        try {
            StatisticItem statisticItem = new StatisticItem(str);
            addStatExtra(statisticItem);
            BdStatisticsManager.getInstance().eventStat(null, str, "", 1, statisticItem.getParams().toArray());
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
            noticeStatisticCallback(str);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void logPagePV(String str) {
        try {
            BdStatisticsManager.getInstance().eventStat(null, str, "", 1, "ispv", "1");
            if (isDebugMode()) {
                BdLog.d("RD_STAT_LOG: key=" + str);
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void net(HttpNetContext httpNetContext) {
        if (httpNetContext == null || httpNetContext.getStat().stat.f38962f > 180000) {
            return;
        }
        try {
            if (httpNetContext.getStat().stat.f38962f < 0 || httpNetContext.getStat().stat.f38959c < 0 || httpNetContext.getStat().stat.f38960d < 0) {
                return;
            }
            int i2 = httpNetContext.getResponse().mServerErrorCode;
            if (!httpNetContext.getResponse().isNetSuccess()) {
                i2 = httpNetContext.getResponse().mNetErrorCode;
            }
            int i3 = i2;
            String currentActivity = TiebaStaticHelper.getCurrentActivity();
            String str = null;
            String str2 = i3 != 0 ? httpNetContext.getResponse().mErrorString : null;
            if (httpNetContext.getRequest().mIsRequestImage) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                if (i3 != 0) {
                    str = httpNetContext.getRequest().getApiName();
                }
                bdStatisticsManager.imgNet(str, currentActivity, httpNetContext.getStat().stat.f38958b, httpNetContext.getStat().stat.f38957a, httpNetContext.getStat().stat.f38962f, httpNetContext.getStat().stat.f38959c, httpNetContext.getStat().stat.f38960d, httpNetContext.getStat().stat.f38961e, i3, str2, new Object[0]);
                return;
            }
            BdStatisticsManager.getInstance().net(httpNetContext.getRequest().getApiName(), currentActivity, httpNetContext.getStat().stat.f38958b, httpNetContext.getStat().stat.f38957a, httpNetContext.getStat().stat.f38962f, httpNetContext.getStat().stat.f38959c, httpNetContext.getStat().stat.f38960d, httpNetContext.getStat().stat.f38961e, i3, str2, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static synchronized void netImg(d.a.c.e.j.a.e eVar) {
        synchronized (TiebaStatic.class) {
            if (eVar.d() != null && eVar.d().size() > 0) {
                netImg(eVar.b().i(), eVar.d().get(0));
                if (eVar.d().size() > 1) {
                    netImg(eVar.b().i(), eVar.d().get(eVar.d().size() - 1));
                }
            }
        }
    }

    public static synchronized void netJson(d.a.c.e.j.a.e eVar, int i2, String str) {
        synchronized (TiebaStatic.class) {
            if (eVar.d() != null && eVar.d().size() > 0) {
                String g2 = eVar.b().g("sid");
                netJson(g2, eVar.b().i(), eVar.d().get(0), i2, str);
                if (eVar.d().size() > 1) {
                    netJson(g2, eVar.b().i(), eVar.d().get(eVar.d().size() - 1), i2, str);
                }
            }
        }
    }

    public static void noticeStatisticCallback(String str) {
        if (statisticCallbacks.isEmpty()) {
            return;
        }
        for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
            if (tiebaStatisticCallback != null) {
                tiebaStatisticCallback.onLog(str);
            }
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        if (j <= 0 || j3 <= 0 || j2 < 0 || j4 < 0 || j5 < 0) {
            return;
        }
        try {
            BdStatisticsManager.getInstance().op(str, null, j3, 0, null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static synchronized void payLog(String str, int i2, String str2, String str3) {
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
                objArr[3] = String.valueOf(i2);
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
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void printDBExceptionLog(Throwable th, String str, Object... objArr) {
        if (th == null) {
            return;
        }
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

    public static void pushMsg(long j, int i2, String str, String str2) {
        BdStatisticsManager.getInstance().log("msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i2), "stat", str2, "link", str);
    }

    public static void removeStatisticCallback(TiebaStatisticCallback tiebaStatisticCallback) {
        if (tiebaStatisticCallback != null) {
            statisticCallbacks.remove(tiebaStatisticCallback);
        }
    }

    public static void save() {
        try {
            d.a.c.h.h.a.b().v();
            d.a.c.e.l.a.g();
            i.d();
            BdStatisticsManager.getInstance().save();
            sendMultiProcessBroadcast();
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void saveAndUploadMsg() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == lastLogOperateMsgTime) {
                lastLogOperateMsgTime = b.j().l("operate_msg_arrive_click_date", 0L);
                operateMsgUploadCount = b.j().k("operate_msg_arrive_click_count", 0);
            }
            if (lastLogOperateMsgTime > 0) {
                if (currentTimeMillis - lastLogOperateMsgTime < 86400000 && operateMsgUploadCount > 3) {
                    return;
                }
                b.j().w("operate_msg_arrive_click_date", currentTimeMillis);
                if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                    operateMsgUploadCount = 0;
                }
            }
            lastLogOperateMsgTime = currentTimeMillis;
            operateMsgUploadCount++;
            b.j().v("operate_msg_arrive_click_count", operateMsgUploadCount);
            BdStatisticsManager.getInstance().saveAndUploadlog("msg");
        }
    }

    public static void sendMultiProcessBroadcast() {
        Intent intent = new Intent("com.baidu.adp.stats.background");
        intent.setPackage(BdBaseApplication.getInst().getPackageName());
        TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
    }

    public static void setUserInfo(String str, String str2, String str3) {
        try {
            BdStatisticsManager.getInstance().setUser(str2, str, str3);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void voiceError(int i2, String str, String str2) {
        try {
            BdStatisticsManager.getInstance().voiceErr(OpKey.OP_VOICE, TiebaStaticHelper.getCurrentActivity(), i2, str, "voice_inf", str2);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void eventStat(Context context, String str, String str2, int i2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().eventStat(context, str, str2, i2, objArr);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void noticeStatisticCallback(StatisticItem statisticItem) {
        if (statisticCallbacks.isEmpty()) {
            return;
        }
        for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
            if (tiebaStatisticCallback != null) {
                tiebaStatisticCallback.onLog(statisticItem);
            }
        }
    }

    public static void logPagePV(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        try {
            statisticItem.param("ispv", "1");
            BdStatisticsManager.getInstance().eventStat(null, statisticItem.getKey(), "", 1, statisticItem.getParams().toArray());
            if (isDebugMode()) {
                BdLog.d(getStatLog(statisticItem));
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static synchronized void netImg(String str, d dVar) {
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.f38962f <= 180000) {
                    try {
                        if (dVar.f38962f >= 0 && dVar.f38959c >= 0 && dVar.f38960d >= 0) {
                            int i2 = dVar.f38965i;
                            String str2 = null;
                            String currentActivity = TiebaStaticHelper.getCurrentActivity();
                            if (i2 != 0 && i2 != 200) {
                                str2 = dVar.f38964h;
                            }
                            BdStatisticsManager.getInstance().imgNet(str, currentActivity, dVar.f38958b, dVar.f38957a, dVar.f38962f, dVar.f38959c, dVar.f38960d, dVar.f38961e, i2, str2, new Object[0]);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        }
    }

    public static void file(Exception exc, String str) {
        if (exc != null) {
            file(exc.getMessage(), str);
        } else {
            file("", str);
        }
    }

    public static void log(StatisticItem statisticItem) {
        if (statisticItem == null) {
            return;
        }
        try {
            addStatExtra(statisticItem);
            BdStatisticsManager.getInstance().eventStat(null, statisticItem.getKey(), "", 1, statisticItem.getParams().toArray());
            if (isDebugMode()) {
                BdLog.d(getStatLog(statisticItem));
            }
            noticeStatisticCallback(statisticItem);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        r20 = r26;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047 A[Catch: Exception -> 0x009a, all -> 0x00a4, TryCatch #1 {Exception -> 0x009a, blocks: (B:9:0x0012, B:11:0x001a, B:13:0x0020, B:15:0x0026, B:17:0x002c, B:24:0x003c, B:26:0x0047, B:28:0x005e, B:29:0x006f), top: B:41:0x0012, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void netJson(String str, String str2, d dVar, int i2, String str3) {
        int i3;
        synchronized (TiebaStatic.class) {
            if (dVar != null) {
                if (dVar.f38962f <= 180000) {
                    try {
                        if (dVar.f38962f >= 0 && dVar.f38959c >= 0 && dVar.f38960d >= 0) {
                            int i4 = dVar.f38965i;
                            if (i4 != 200 && i4 / 100 != 3) {
                                i3 = i4;
                                String str4 = new String();
                                String currentActivity = TiebaStaticHelper.getCurrentActivity();
                                if (i3 != 0) {
                                    str4 = str4 + dVar.f38964h;
                                    if (!TextUtils.isEmpty(str3)) {
                                        str4 = str4 + str3;
                                    }
                                }
                                BdStatisticsManager.getInstance().net(getApiName(str2), str, currentActivity, dVar.f38958b, dVar.f38957a, dVar.f38962f, dVar.f38959c, dVar.f38960d, dVar.f38961e, i3, str4, new Object[0]);
                            }
                            i3 = 0;
                            String str42 = new String();
                            String currentActivity2 = TiebaStaticHelper.getCurrentActivity();
                            if (i3 != 0) {
                            }
                            BdStatisticsManager.getInstance().net(getApiName(str2), str, currentActivity2, dVar.f38958b, dVar.f38957a, dVar.f38962f, dVar.f38959c, dVar.f38960d, dVar.f38961e, i3, str42, new Object[0]);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        }
    }

    public static void file(String str, String str2) {
        String currentActivity = TiebaStaticHelper.getCurrentActivity();
        try {
            if (FileHelper.checkSD()) {
                BdStatisticsManager.getInstance().file(str2, currentActivity, -27, str, FileKey.FILE_SD_STATE, getSdState(), FileKey.FILE_SD_SIZE, Long.valueOf(FileHelper.getAvailableSize()));
            } else {
                BdStatisticsManager.getInstance().file(str2, currentActivity, -23, str, FileKey.FILE_SD_STATE, getSdState());
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static void printDBExceptionLog(String str, int i2, String str2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().db(str, TiebaStaticHelper.getCurrentActivity(), i2, str2, objArr);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
