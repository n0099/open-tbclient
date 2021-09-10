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
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.n.d;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.e.e.p.q;
import c.a.q0.d1.a;
import c.a.q0.d1.g;
import c.a.q0.m0.e;
import c.a.q0.q0.i;
import c.a.q0.s.d0.b;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class TiebaStatic {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class DQPay extends LogFields {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TYPE_VALUE = "pay";
        public transient /* synthetic */ FieldHolder $fh;

        public DQPay() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class ErrorKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String OP_ALADIN_PORT_ERROR = "op_aladin_port_error";
        public transient /* synthetic */ FieldHolder $fh;

        public ErrorKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class FileKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_SD_SIZE = "sd_size";
        public static final String FILE_SD_STATE = "sd_state";
        public transient /* synthetic */ FieldHolder $fh;

        public FileKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class IM extends LogFields {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TYPE_VALUE = "im";
        public transient /* synthetic */ FieldHolder $fh;

        public IM() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LogFields {
        public static /* synthetic */ Interceptable $ic = null;
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
        public transient /* synthetic */ FieldHolder $fh;

        public LogFields() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class NetApiName {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NetApiName() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class NetKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String NET_IMG = "img";
        public transient /* synthetic */ FieldHolder $fh;

        public NetKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class OpKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String OP_FORUM_ENTER = "op_forum_enter";
        public static final String OP_FRS_ENTER = "op_frs_enter";
        public static final String OP_IMG = "op_img";
        public static final String OP_LIVE = "op_live";
        public static final String OP_NEWS_ENTER = "op_news_enter";
        public static final String OP_PB_ENTER = "op_pb_enter";
        public static final String OP_SQUARE_ENTER = "op_square_enter";
        public static final String OP_VOICE = "op_voice";
        public transient /* synthetic */ FieldHolder $fh;

        public OpKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class Params {
        public static /* synthetic */ Interceptable $ic = null;
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
        public static final String BDID = "bdid";
        public static final String CARD_TYPE = "card_type";
        public static final String CLICK_LOCATE = "click_locate";
        public static final String CUID = "cuid";
        public static final String CUID_GALAXY2 = "cuid_galaxy2";
        public static final String CUID_GALAXY3 = "c3_aid";
        public static final String CUID_GID = "cuid_gid";
        public static final String ENTRY_NAME = "entryname";
        public static final String EXPOSURE_TIME = "exposure_time";
        public static final String FID_1 = "fid_1";
        public static final String FID_2 = "fid_2";
        public static final String FIRST_DIR = "first_dir";
        public static final String FORUM_ID = "fid";
        public static final String FORUM_ID_MERGE = "fids";
        public static final String FORUM_NAME = "fname";
        public static final String FRIEND_UID = "friend_uid";
        public static final String FROM_SOURCE = "from_source";
        public static final String GUA_TYPE = "gua_type";
        public static final String H5_FORUM_NAME = "kw";
        public static final String IS_FOLLOW = "is_follow";
        public static final String IS_FULL = "is_full";
        public static final String IS_OFFICIAL = "obj_isofficial";
        public static final String IS_OFFICIAL_MERGE = "obj_isofficials";
        public static final String IS_REC = "is_rec";
        public static final String IS_VERTICAL = "is_vertical";
        public static final String IS_ZP = "is_zp";
        public static final String ITEM_ID = "item_id";
        public static final String LIKE_TYPE = "like_type";
        public static final String LIST_ORDER = "list_order";
        public static final String LOGID = "log_id";
        public static final String MID_PAGE_FLAG = "midpageflag";
        public static final String NID = "nid";
        public static final String OBJ_AD_LOCATE = "obj_adlocate";
        public static final String OBJ_AD_LOCATE_MERGE = "obj_adlocates";
        public static final String OBJ_CUR_PAGE = "obj_cur_page";
        public static final String OBJ_DURATION = "obj_duration";
        public static final String OBJ_EXTRA = "extra";
        public static final String OBJ_FEED_TYPE = "obj_feed_type";
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
        public static final String QD = "qd";
        public static final String QUERY = "query";
        public static final String RECOM_AB_TAG = "recom_ab_tag";
        public static final String RECOM_EXTRA = "recom_extra";
        public static final String RECOM_SOURCE = "recom_source";
        public static final String RECOM_TYPE = "recom_type";
        public static final String RECOM_WEIGHT = "recom_weight";
        public static final String REC_SOURCE = "source";
        public static final String REC_TYPE = "rec_type";
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
        public static final String TEMPLATE_ID = "template_id";
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
        public static final String WISE_SAMPLE_ID = "wise_sample_id";
        public static final String ZHIBO_TYPE = "zhibo_type";
        public transient /* synthetic */ FieldHolder $fh;

        public Params() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface TiebaStatisticCallback {
        void onLog(StatisticItem statisticItem);

        void onLog(String str);
    }

    /* loaded from: classes6.dex */
    public static class YYParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String HDID = "hdid";
        public static final String LIVEID = "liveid";
        public static final String YYLIVEID = "yyliveid";
        public static final String YYSID = "yysid";
        public static final String YYSSID = "yyssid";
        public static final String YYTEMPLATEID = "template_id";
        public static final String YYUID = "yyuid";
        public transient /* synthetic */ FieldHolder $fh;

        public YYParams() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class YYValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String YY_LIVE = "yylive";
        public transient /* synthetic */ FieldHolder $fh;

        public YYValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2027125406, "Lcom/baidu/tbadk/core/util/TiebaStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2027125406, "Lcom/baidu/tbadk/core/util/TiebaStatic;");
                return;
            }
        }
        BdLog.addLogPackage("com.baidu.adp.plugin");
        lastLogOperateMsgTime = 0L;
        operateMsgUploadCount = 0;
        lock = new Object();
        statisticCallbacks = new LinkedHashSet();
    }

    public TiebaStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addStatExtra(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, statisticItem) == null) || statisticItem == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, tiebaStatisticCallback) == null) || tiebaStatisticCallback == null) {
            return;
        }
        statisticCallbacks.add(tiebaStatisticCallback);
    }

    public static void aladinPortError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().aladinPortErr(ErrorKey.OP_ALADIN_PORT_ERROR, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static String codecSeqId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void crash(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            try {
                BdStatisticsManager.getInstance().crash(str, null, null, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void deleteParamByKey(StatisticItem statisticItem, String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, statisticItem, str) == null) || (indexOf = statisticItem.getParams().indexOf(str)) == -1) {
            return;
        }
        statisticItem.getParams().remove(indexOf);
        statisticItem.getParams().remove(indexOf);
    }

    public static void eventStat(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().eventStat(context, str, str2, 1, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void file(Exception exc) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, exc) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length >= 5) {
                StackTraceElement stackTraceElement = stackTrace[4];
                str = k.join(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
            } else {
                str = null;
            }
            file(exc, str);
        }
    }

    public static String getApiName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String getCua(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            return l.k(context) + "_" + l.i(context) + "_android_" + TbConfig.getVersion() + "_" + l.h(context);
        }
        return (String) invokeL.objValue;
    }

    public static String getSdState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Environment.getExternalStorageState() : (String) invokeV.objValue;
    }

    public static String getStatLog(StatisticItem statisticItem) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, statisticItem)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void imgError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65553, null, i2, str, str2) == null) {
        }
    }

    public static void init(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, context, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    d dVar = new d();
                    dVar.f2424a = "tieba";
                    dVar.f2425b = SUB_PRODUCT;
                    dVar.f2426c = TbConfig.getVersion();
                    dVar.f2427d = TbConfig.getFrom();
                    dVar.f2428e = TbConfig.getCurrentFrom();
                    dVar.f2429f = TbadkCoreApplication.getClientId();
                    dVar.f2430g = TbadkCoreApplication.getInst().getCuid();
                    dVar.f2431h = TbadkCoreApplication.getInst().getCuidGalaxy2();
                    TbadkCoreApplication.getInst().getCuidGid();
                    dVar.f2432i = TbadkCoreApplication.getInst().getImei();
                    dVar.f2433j = TbConfig.getSubappType();
                    dVar.r = g.d().g(context) + "_" + g.d().f(context);
                    dVar.v = TbadkCoreApplication.getInst().getAndroidId();
                    dVar.s = getCua(context);
                    dVar.t = PermissionUtil.getLastCachedOid(context);
                    dVar.u = PermissionUtil.getLocalMacAddress(context);
                    dVar.w = g.d().b();
                    dVar.x = g.d().h() + "_" + g.d().i();
                    dVar.z = TbSingleton.getInstance().getBaiduIdForAnti();
                    dVar.A = String.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
                    dVar.B = String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
                    dVar.C = String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
                    dVar.D = TbSingleton.getInstance().getData();
                    boolean z2 = true;
                    if (b.j().k("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", 1) != 1) {
                        z2 = false;
                    }
                    long l = z2 ? b.j().l("KEY_UPLOAD_LOG_INTERVAL", AppConfig.TIMESTAMP_AVAILABLE_DURATION) : 3600000L;
                    BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, dVar, BdLogSetting.getInstance(), l, TbConfig.SERVER_ADDRESS + TbConfig.TRACK_LOG_UPLOAD_URL);
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                }
            } finally {
                TTIStats.record("TiebaStatic.init", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static void liveError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65556, null, i2, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().liveErr(OpKey.OP_LIVE, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(b.j().g(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", b.j().p("live_stream_id", ""));
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void liveStreamError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65557, null, i2, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().liveErr(OpKey.OP_LIVE, TiebaStaticHelper.getCurrentActivity(), i2, str, "live_inf", str2, ThreadExpressionActivityConfig.IS_HOST, Integer.valueOf(b.j().g(AlaLiveRoomActivityConfig.LIVE_IS_HOST, false) ? 1 : 0), "stream_id", b.j().p("live_stream_id", ""), "err_int", Integer.valueOf(b.j().k("live_no_error_time", 0)));
                b.j().v("live_no_error_time", 0);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
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
    }

    public static void logPagePV(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, str) == null) {
            try {
                BdStatisticsManager.getInstance().eventStat(null, str, "", 1, "ispv", "1");
                if (isDebugMode()) {
                    BdLog.d("RD_STAT_LOG: key=" + str);
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void net(HttpNetContext httpNetContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, httpNetContext) == null) || httpNetContext == null || httpNetContext.getStat().stat.f2311f > 180000) {
            return;
        }
        try {
            if (httpNetContext.getStat().stat.f2311f < 0 || httpNetContext.getStat().stat.f2308c < 0 || httpNetContext.getStat().stat.f2309d < 0) {
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
                bdStatisticsManager.imgNet(str, currentActivity, httpNetContext.getStat().stat.f2307b, httpNetContext.getStat().stat.f2306a, httpNetContext.getStat().stat.f2311f, httpNetContext.getStat().stat.f2308c, httpNetContext.getStat().stat.f2309d, httpNetContext.getStat().stat.f2310e, i3, str2, new Object[0]);
                return;
            }
            BdStatisticsManager.getInstance().net(httpNetContext.getRequest().getApiName(), currentActivity, httpNetContext.getStat().stat.f2307b, httpNetContext.getStat().stat.f2306a, httpNetContext.getStat().stat.f2311f, httpNetContext.getStat().stat.f2308c, httpNetContext.getStat().stat.f2309d, httpNetContext.getStat().stat.f2310e, i3, str2, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static synchronized void netImg(c.a.e.e.j.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, eVar) == null) {
            synchronized (TiebaStatic.class) {
                if (eVar.d() != null && eVar.d().size() > 0) {
                    netImg(eVar.b().i(), eVar.d().get(0));
                    if (eVar.d().size() > 1) {
                        netImg(eVar.b().i(), eVar.d().get(eVar.d().size() - 1));
                    }
                }
            }
        }
    }

    public static synchronized void netJson(c.a.e.e.j.a.e eVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65565, null, eVar, i2, str) == null) {
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
    }

    public static void noticeStatisticCallback(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, str) == null) || statisticCallbacks.isEmpty()) {
            return;
        }
        for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
            if (tiebaStatisticCallback != null) {
                tiebaStatisticCallback.onLog(str);
            }
        }
    }

    public static void page(String str, long j2, long j3, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || j2 <= 0 || j4 <= 0 || j3 < 0 || j5 < 0 || j6 < 0) {
            return;
        }
        try {
            BdStatisticsManager.getInstance().op(str, null, j4, 0, null, ALL_COST, Long.valueOf(j2), PRE_COST, Long.valueOf(j3), CON_COST, Long.valueOf(j5), SHOW_COST, Long.valueOf(j6));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public static synchronized void payLog(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65570, null, str, i2, str2, str3) == null) {
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
    }

    public static void printDBExceptionLog(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65572, null, th, str, objArr) == null) || th == null) {
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

    public static void pushMsg(long j2, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str, str2}) == null) {
            BdStatisticsManager.getInstance().log("msg", "message_id", Long.valueOf(j2), "op_type", Integer.valueOf(i2), "stat", str2, "link", str);
        }
    }

    public static void removeStatisticCallback(TiebaStatisticCallback tiebaStatisticCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65574, null, tiebaStatisticCallback) == null) || tiebaStatisticCallback == null) {
            return;
        }
        statisticCallbacks.remove(tiebaStatisticCallback);
    }

    public static void save() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, null) == null) {
            try {
                c.a.e.h.h.a.b().v();
                c.a.e.e.l.a.g();
                i.d();
                BdStatisticsManager.getInstance().save();
                sendMultiProcessBroadcast();
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void saveAndUploadMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, null) == null) {
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
    }

    public static void sendMultiProcessBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, null) == null) {
            Intent intent = new Intent("com.baidu.adp.stats.background");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65578, null, str, str2, str3) == null) {
            try {
                BdStatisticsManager.getInstance().setUser(str2, str, str3);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void voiceError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65579, null, i2, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().voiceErr(OpKey.OP_VOICE, TiebaStaticHelper.getCurrentActivity(), i2, str, "voice_inf", str2);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void eventStat(Context context, String str, String str2, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Integer.valueOf(i2), objArr}) == null) {
            try {
                BdStatisticsManager.getInstance().eventStat(context, str, str2, i2, objArr);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public static void noticeStatisticCallback(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, statisticItem) == null) || statisticCallbacks.isEmpty()) {
            return;
        }
        for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
            if (tiebaStatisticCallback != null) {
                tiebaStatisticCallback.onLog(statisticItem);
            }
        }
    }

    public static void logPagePV(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, statisticItem) == null) || statisticItem == null) {
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

    public static synchronized void netImg(String str, c.a.e.e.j.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, str, dVar) == null) {
            synchronized (TiebaStatic.class) {
                if (dVar != null) {
                    if (dVar.f2311f <= 180000) {
                        try {
                            if (dVar.f2311f >= 0 && dVar.f2308c >= 0 && dVar.f2309d >= 0) {
                                int i2 = dVar.f2314i;
                                String str2 = null;
                                String currentActivity = TiebaStaticHelper.getCurrentActivity();
                                if (i2 != 0 && i2 != 200) {
                                    str2 = dVar.f2313h;
                                }
                                BdStatisticsManager.getInstance().imgNet(str, currentActivity, dVar.f2307b, dVar.f2306a, dVar.f2311f, dVar.f2308c, dVar.f2309d, dVar.f2310e, i2, str2, new Object[0]);
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.toString());
                        }
                    }
                }
            }
        }
    }

    public static void file(Exception exc, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, exc, str) == null) {
            if (exc != null) {
                file(exc.getMessage(), str);
            } else {
                file("", str);
            }
        }
    }

    public static void log(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, statisticItem) == null) || statisticItem == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
        r20 = r26;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[Catch: Exception -> 0x009e, all -> 0x00a8, TryCatch #0 {Exception -> 0x009e, blocks: (B:11:0x0016, B:13:0x001e, B:15:0x0024, B:17:0x002a, B:19:0x0030, B:26:0x0040, B:28:0x004b, B:30:0x0062, B:31:0x0073), top: B:45:0x0016, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void netJson(String str, String str2, c.a.e.e.j.a.d dVar, int i2, String str3) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{str, str2, dVar, Integer.valueOf(i2), str3}) == null) {
            synchronized (TiebaStatic.class) {
                if (dVar != null) {
                    if (dVar.f2311f <= 180000) {
                        try {
                            if (dVar.f2311f >= 0 && dVar.f2308c >= 0 && dVar.f2309d >= 0) {
                                int i4 = dVar.f2314i;
                                if (i4 != 200 && i4 / 100 != 3) {
                                    i3 = i4;
                                    String str4 = new String();
                                    String currentActivity = TiebaStaticHelper.getCurrentActivity();
                                    if (i3 != 0) {
                                        str4 = str4 + dVar.f2313h;
                                        if (!TextUtils.isEmpty(str3)) {
                                            str4 = str4 + str3;
                                        }
                                    }
                                    BdStatisticsManager.getInstance().net(getApiName(str2), str, currentActivity, dVar.f2307b, dVar.f2306a, dVar.f2311f, dVar.f2308c, dVar.f2309d, dVar.f2310e, i3, str4, new Object[0]);
                                }
                                i3 = 0;
                                String str42 = new String();
                                String currentActivity2 = TiebaStaticHelper.getCurrentActivity();
                                if (i3 != 0) {
                                }
                                BdStatisticsManager.getInstance().net(getApiName(str2), str, currentActivity2, dVar.f2307b, dVar.f2306a, dVar.f2311f, dVar.f2308c, dVar.f2309d, dVar.f2310e, i3, str42, new Object[0]);
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.toString());
                        }
                    }
                }
            }
        }
    }

    public static void file(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
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
    }

    public static void printDBExceptionLog(String str, int i2, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65571, null, str, i2, str2, objArr) == null) {
            try {
                BdStatisticsManager.getInstance().db(str, TiebaStaticHelper.getCurrentActivity(), i2, str2, objArr);
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }
}
