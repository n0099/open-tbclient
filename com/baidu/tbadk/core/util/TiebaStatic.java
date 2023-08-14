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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.bi;
import com.baidu.tieba.cg;
import com.baidu.tieba.dr5;
import com.baidu.tieba.dv5;
import com.baidu.tieba.fi;
import com.baidu.tieba.mv5;
import com.baidu.tieba.ng;
import com.baidu.tieba.tu5;
import com.baidu.tieba.vr5;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
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
    public static final ArrayList<String> immediatelyUploadKeys;
    public static long lastLogOperateMsgTime = 0;
    public static Object lock = null;
    public static int operateMsgUploadCount = 0;
    public static final long operateMsgUploadInterval = 86400000;
    public static Set<TiebaStatisticCallback> statisticCallbacks;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface TiebaStatisticCallback {
        void onLog(StatisticItem statisticItem);

        void onLog(String str);
    }

    /* loaded from: classes4.dex */
    public static class AgreeFunnerValue {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOC_CANT_CLICK_NUM = 5;
        public static final int LOC_CLICK = 1;
        public static final int LOC_DATA_NULL = 3;
        public static final int LOC_FAKE_VIDEO = 2;
        public static final int LOC_NO_LOGIN = 4;
        public static final int LOC_SENDED = 7;
        public static final int LOC_WILL_SEND = 6;
        public transient /* synthetic */ FieldHolder $fh;

        public AgreeFunnerValue() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class AgreeNotifyValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TYPE_NOT_SHOW_RED_DOT = 2;
        public static final int TYPE_SHOW_RED_DOT = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public AgreeNotifyValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CardImgClickValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int JUMP_TO_IMAGE_VIEWER = 2;
        public static final int JUMP_TO_PB = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public CardImgClickValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class DQPay extends LogFields {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TYPE_VALUE = "pay";
        public transient /* synthetic */ FieldHolder $fh;

        public DQPay() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ErrorKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String OP_ALADIN_PORT_ERROR = "op_aladin_port_error";
        public transient /* synthetic */ FieldHolder $fh;

        public ErrorKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class IM extends LogFields {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TYPE_VALUE = "im";
        public transient /* synthetic */ FieldHolder $fh;

        public IM() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class NetApiName {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NetApiName() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class NetKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String NET_IMG = "img";
        public transient /* synthetic */ FieldHolder $fh;

        public NetKey() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Params {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ABTEST = "abtest";
        public static final String ABTEST_RESULT = "newabtest_result";
        public static final String AB_ACTION = "ab_action";
        public static final String AB_TAG = "ab_tag";
        public static final String AB_TYPE = "ab_type";
        public static final String AD_BEAR_PLACE = "ad_bear_place";
        public static final String AD_DESC = "ad_desc";
        public static final String AD_PIC = "ad_pic";
        public static final String AD_SOURCE = "ad_bear_source";
        public static final String AD_TITLE = "ad_title";
        public static final String AD_TYPE = "ad_type";
        public static final String AID = "aid";
        public static final String BDID = "bdid";
        public static final String BEAR_CONFIG = "bear_config";
        public static final String BHV_ID = "bhv_id";
        public static final String CARD_TYPE = "card_type";
        public static final String CLICK_LOCATE = "click_locate";
        public static final String CONTENT = "content";
        public static final String CUID = "cuid";
        public static final String CUID_GALAXY2 = "cuid_galaxy2";
        public static final String CUID_GALAXY3 = "c3_aid";
        public static final String CUID_GID = "cuid_gid";
        public static final String ENTRY_NAME = "entryname";
        public static final String EQID = "eqid";
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
        public static final String HID = "hid";
        public static final String IS_FOLLOW = "is_follow";
        public static final String IS_FULL = "is_full";
        public static final String IS_OFFICIAL = "obj_isofficial";
        public static final String IS_OFFICIAL_MERGE = "obj_isofficials";
        public static final String IS_REC = "is_rec";
        public static final String IS_SPECIAL_THREAD = "is_special_thread";
        public static final String IS_UP = "is_up";
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
        public static final String OBJ_TO_PB = "obj_topb";
        public static final String OBJ_TYPE = "obj_type";
        public static final String OBJ_URL = "obj_url";
        public static final String PID = "pid";
        public static final String PID_MERGE = "pids";
        public static final String PLG_CONFIG = "plg_config";
        public static final String POST_CONTENT = "post_content";
        public static final String POST_ID = "post_id";
        public static final String POST_TYPE = "post_type";
        public static final String POST_TYPE_MERGE = "post_types";
        public static final String PURE_BROWSING = "pure_browsing";
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
        public static final String ROOM_ID = "room_id";
        public static final String SAMPLE_ID = "sample_id";
        public static final String SECOND_DIR = "second_dir";
        public static final String SERVICE_ID = "service_id";
        public static final String SESSION_ID = "session_id";
        public static final String SORT_TYPE = "sort_type";
        public static final String SOURCE_FROM = "source_from";
        public static final String SPLASH_UNI = "splash_uni";
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
        public static final String TIEBA_PARAMS = "tieba_params";
        public static final String TOPIC_ID = "topic_id";
        public static final String TOPIC_TYPE = "topic_type";
        public static final String T_PLUS_AD_SOURCE = "ad_source";
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class RDValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AGREE_FUNNER = 5;
        public static final int CRASH_ONLINE = 6;
        public static final int FRS_WHITE_TIME = 4;
        public static final int NAS_REDIRECT = 1;
        public static final int REPLY_FUNNER = 3;
        public static final int SCHEME_FIRST_SPLASH_TIMES = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public RDValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ReplyFunnerValue {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOC_BJH_ANTI = 3;
        public static final int LOC_BJH_WILL_SHOW_INPUT = 7;
        public static final int LOC_CLICK_ADD_POST = 11;
        public static final int LOC_CLICK_FOR_REPLY = 1;
        public static final int LOC_CLICK_FULL_ADD_POST = 17;
        public static final int LOC_DATA_NULL = 20;
        public static final int LOC_GOTO_FULL_SCREEN_EDITOR = 10;
        public static final int LOC_HOST_ANTI = 8;
        public static final int LOC_NOT_WIFI_TIP = 15;
        public static final int LOC_NOT_WIFI_TIP_CANCEL = 16;
        public static final int LOC_NO_LOGIN = 2;
        public static final int LOC_POST_FAIL = 19;
        public static final int LOC_POST_SUC = 18;
        public static final int LOC_REQ_PROPER = 4;
        public static final int LOC_REQ_PROPER_FAIL = 6;
        public static final int LOC_REQ_PROPER_SUC = 5;
        public static final int LOC_SENSITIVE_OR_HOST_ANTI = 13;
        public static final int LOC_SHOW_INPUT = 9;
        public static final int LOC_START_SEND = 14;
        public static final int LOC_TOOMUCH_PIC = 12;
        public static final int LOC_VITRUAL_IMG = 21;
        public transient /* synthetic */ FieldHolder $fh;

        public ReplyFunnerValue() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class StampShareValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOCATE_FRS = 1;
        public static final int LOCATE_MINE_PAGE = 3;
        public static final int LOCATE_PB = 2;
        public static final int LOCATE_SHARE_SUCCESS = 20;
        public static final int SOURCE_KEEP_DIALOG = 1;
        public static final int SOURCE_OPERATION_ISSUE_DIALOG = 3;
        public static final int SOURCE_POST_REPLY_DIALOG = 2;
        public static final int TYPE_STAMP_DIALOG_CLICK = 2;
        public static final int TYPE_STAMP_DIALOG_SHOW = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public StampShareValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class YYValues {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String YY_LIVE = "yylive";
        public transient /* synthetic */ FieldHolder $fh;

        public YYValues() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        ArrayList<String> arrayList = new ArrayList<>();
        immediatelyUploadKeys = arrayList;
        arrayList.add(TbadkCoreStatisticKey.PUSH_CCLICK);
        immediatelyUploadKeys.add(TbadkCoreStatisticKey.HOST_START);
        immediatelyUploadKeys.add(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
        immediatelyUploadKeys.add(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP);
        immediatelyUploadKeys.add(TbadkCoreStatisticKey.KEY_AIAPPS_CALL_NATIVE);
        immediatelyUploadKeys.add("c13390");
    }

    public static void saveAndUploadMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            synchronized (lock) {
                long currentTimeMillis = System.currentTimeMillis();
                if (0 == lastLogOperateMsgTime) {
                    lastLogOperateMsgTime = SharedPrefHelper.getInstance().getLong("operate_msg_arrive_click_date", 0L);
                    operateMsgUploadCount = SharedPrefHelper.getInstance().getInt("operate_msg_arrive_click_count", 0);
                }
                if (lastLogOperateMsgTime > 0) {
                    if (currentTimeMillis - lastLogOperateMsgTime < 86400000 && operateMsgUploadCount > 3) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putLong("operate_msg_arrive_click_date", currentTimeMillis);
                    if (currentTimeMillis - lastLogOperateMsgTime >= 86400000) {
                        operateMsgUploadCount = 0;
                    }
                }
                lastLogOperateMsgTime = currentTimeMillis;
                operateMsgUploadCount++;
                SharedPrefHelper.getInstance().putInt("operate_msg_arrive_click_count", operateMsgUploadCount);
                BdStatisticsManager.getInstance().saveAndUploadlog("msg");
            }
        }
    }

    public TiebaStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getSdState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return Environment.getExternalStorageState();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static void save() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            try {
                cg.g();
                vr5.c();
                BdStatisticsManager.getInstance().save();
                sendMultiProcessBroadcast();
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void sendMultiProcessBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            Intent intent = new Intent("com.baidu.adp.stats.background");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
        }
    }

    public static void addStatExtra(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, statisticItem) != null) || statisticItem == null) {
            return;
        }
        String sampleId = TbSingleton.getInstance().getSampleId();
        if (!StringUtils.isNull(sampleId)) {
            statisticItem.param(Params.SAMPLE_ID, sampleId);
        }
        String c = tu5.d().c();
        if (!StringUtils.isNull(c)) {
            statisticItem.param(Params.ABTEST_RESULT, c);
        }
        dr5.f().e(statisticItem);
        statisticItem.addParam("session_id", mv5.g().i());
    }

    public static String getCua(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            return BdUtilHelper.getEquipmentWidth(context) + "_" + BdUtilHelper.getEquipmentHeight(context) + "_android_" + TbConfig.getVersion() + "_" + BdUtilHelper.getEquipmentDensity(context);
        }
        return (String) invokeL.objValue;
    }

    public static void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            try {
                StatisticItem statisticItem = new StatisticItem(str);
                addStatExtra(statisticItem);
                BdStatisticsManager.getInstance().eventStat(null, str, "", 1, statisticItem.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d("RD_STAT_LOG: key=" + str);
                }
                noticeStatisticCallback(str);
                if (isImmediatelyKey(str)) {
                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitchImmediately();
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void logPagePV(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, statisticItem) != null) || statisticItem == null) {
            return;
        }
        try {
            statisticItem.param("ispv", "1");
            BdStatisticsManager.getInstance().eventStat(null, statisticItem.getKey(), "", 1, statisticItem.getParams().toArray());
            if (isDebugMode()) {
                BdLog.d(getStatLog(statisticItem));
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public static long logWithBackTime(StatisticItem statisticItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, statisticItem)) == null) {
            long j = 0;
            if (statisticItem == null) {
                return 0L;
            }
            try {
                addStatExtra(statisticItem);
                j = BdStatisticsManager.getInstance().eventStatLogTime(null, statisticItem.getKey(), "", 1, statisticItem.getParams().toArray());
                if (isDebugMode()) {
                    BdLog.d(getStatLog(statisticItem));
                }
                noticeStatisticCallback(statisticItem);
                if (isImmediatelyKey(statisticItem.getKey())) {
                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitchImmediately();
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static void crash(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            try {
                BdStatisticsManager.getInstance().crash(str, null, null, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static boolean isImmediatelyKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TbSingleton.getInstance().isStartStatUploadImmediately && immediatelyUploadKeys.contains(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void log(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, statisticItem) == null) {
            logWithBackTime(statisticItem);
        }
    }

    public static void noticeStatisticCallback(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, statisticItem) == null) && !statisticCallbacks.isEmpty()) {
            for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
                if (tiebaStatisticCallback != null) {
                    tiebaStatisticCallback.onLog(statisticItem);
                }
            }
        }
    }

    public static void deleteParamByKey(StatisticItem statisticItem, String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, statisticItem, str) == null) && (indexOf = statisticItem.getParams().indexOf(str)) != -1) {
            statisticItem.getParams().remove(indexOf);
            statisticItem.getParams().remove(indexOf);
        }
    }

    public static void file(Exception exc, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, exc, str) == null) {
            if (exc != null) {
                file(exc.getMessage(), str);
            } else {
                file("", str);
            }
        }
    }

    public static void eventStat(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().eventStat(context, str, str2, 1, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void setUserInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, str, str2, str3) == null) {
            try {
                BdStatisticsManager.getInstance().setUser(str2, str, str3);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, str, str2, Integer.valueOf(i), objArr}) == null) {
            try {
                BdStatisticsManager.getInstance().eventStat(context, str, str2, i, objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void file(Exception exc) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, exc) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length >= 5) {
                StackTraceElement stackTraceElement = stackTrace[4];
                str = bi.join(stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName());
            } else {
                str = null;
            }
            file(exc, str);
        }
    }

    public static void file(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            String currentActivity = TiebaStaticHelper.getCurrentActivity();
            try {
                if (FileHelper.checkSD()) {
                    BdStatisticsManager.getInstance().file(str2, currentActivity, -27, str, FileKey.FILE_SD_STATE, getSdState(), FileKey.FILE_SD_SIZE, Long.valueOf(FileHelper.getAvailableSize()));
                } else {
                    BdStatisticsManager.getInstance().file(str2, currentActivity, -23, str, FileKey.FILE_SD_STATE, getSdState());
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static String getStatLog(StatisticItem statisticItem) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, statisticItem)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void init(Context context, boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, context, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ng ngVar = new ng();
                    ngVar.a = "tieba";
                    ngVar.b = SUB_PRODUCT;
                    ngVar.c = TbConfig.getVersion();
                    ngVar.d = TbConfig.getFrom();
                    ngVar.e = TbConfig.getCurrentFrom();
                    ngVar.f = TbadkCoreApplication.getClientId();
                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                        ngVar.g = TbadkCoreApplication.getInst().getCuid();
                        ngVar.h = TbadkCoreApplication.getInst().getCuidGalaxy2();
                    }
                    TbadkCoreApplication.getInst().getCuidGid();
                    ngVar.i = TbadkCoreApplication.getInst().getImei();
                    ngVar.j = TbConfig.getSubappType();
                    ngVar.r = dv5.c().f(context) + "_" + dv5.c().e(context);
                    ngVar.v = TbadkCoreApplication.getInst().getAndroidId();
                    ngVar.s = getCua(context);
                    ngVar.t = PermissionUtil.getLastCachedOid(context);
                    ngVar.u = PermissionUtil.getLocalMacAddress(context);
                    ngVar.w = dv5.c().a();
                    ngVar.x = dv5.c().g() + "_" + dv5.c().h();
                    ngVar.z = TbSingleton.getInstance().getBaiduIdForAnti();
                    ngVar.A = String.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
                    ngVar.B = String.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
                    ngVar.C = String.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
                    ngVar.D = TbSingleton.getInstance().getData();
                    boolean z2 = true;
                    if (SharedPrefHelper.getInstance().getInt("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", 1) != 1) {
                        z2 = false;
                    }
                    if (z2) {
                        j = SharedPrefHelper.getInstance().getLong("KEY_UPLOAD_LOG_INTERVAL", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                    } else {
                        j = 3600000;
                    }
                    long j2 = j;
                    fi fiVar = new fi() { // from class: com.baidu.tbadk.core.util.TiebaStatic.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.baidu.tieba.fi
                        public boolean isAgreePrivacyPolicy() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                return PermissionUtil.isAgreePrivacyPolicy();
                            }
                            return invokeV.booleanValue;
                        }

                        @Override // com.baidu.tieba.fi
                        public boolean isBrowseMode() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return PermissionUtil.isBrowseMode();
                            }
                            return invokeV.booleanValue;
                        }
                    };
                    BdStatisticsManager.getInstance().setPermissionUtil(fiVar);
                    BdStatisticsManager.getInstance().init(context, z, TbConfig.LOG_SYNC_SWITCH, TbConfig.getTempDirName(), "newStat", TbConfig.SERVER_ADDRESS + TbConfig.LOG_UPLOAD_URL, ngVar, BdLogSetting.getInstance(), j2, TbConfig.SERVER_ADDRESS + TbConfig.TRACK_LOG_UPLOAD_URL);
                    BdLog.setPermissionUtil(fiVar);
                    zg.o().A(fiVar);
                    zg.o().p();
                } catch (Exception e) {
                    BdLog.e(e.toString());
                }
            } finally {
                TTIStats.record("TiebaStatic.init", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public static void noticeStatisticCallback(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, null, str) == null) && !statisticCallbacks.isEmpty()) {
            for (TiebaStatisticCallback tiebaStatisticCallback : statisticCallbacks) {
                if (tiebaStatisticCallback != null) {
                    tiebaStatisticCallback.onLog(str);
                }
            }
        }
    }

    public static void page(String str, long j, long j2, long j3, long j4, long j5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) && j > 0 && j3 > 0 && j2 >= 0 && j4 >= 0 && j5 >= 0) {
            try {
                BdStatisticsManager.getInstance().op(str, null, j3, 0, null, ALL_COST, Long.valueOf(j), PRE_COST, Long.valueOf(j2), CON_COST, Long.valueOf(j4), SHOW_COST, Long.valueOf(j5));
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void printDBExceptionLog(String str, int i, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65559, null, str, i, str2, objArr) == null) {
            try {
                BdStatisticsManager.getInstance().db(str, TiebaStaticHelper.getCurrentActivity(), i, str2, objArr);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public static void printDBExceptionLog(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65560, null, th, str, objArr) != null) || th == null) {
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

    public static void pushMsg(long j, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, str2}) == null) {
            BdStatisticsManager.getInstance().log("msg", "message_id", Long.valueOf(j), "op_type", Integer.valueOf(i), "stat", str2, "link", str);
        }
    }

    public static void voiceError(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65566, null, i, str, str2) == null) {
            try {
                BdStatisticsManager.getInstance().voiceErr(OpKey.OP_VOICE, TiebaStaticHelper.getCurrentActivity(), i, str, "voice_inf", str2);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
