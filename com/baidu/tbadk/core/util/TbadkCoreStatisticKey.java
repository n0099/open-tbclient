package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TbadkCoreStatisticKey {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_FOLLOW_LIVE_LIVE_ITEM_CLICK = "c12677";
    public static final String ALA_FOLLOW_LIVE_LIVE_ITEM_SHOW = "c12676";
    public static final String ALA_FOLLOW_LIVE_SQUARE_ITEM_CLICK = "c12679";
    public static final String ALA_FOLLOW_LIVE_SQUARE_ITEM_SHOW = "c12678";
    public static final String AS_INVOKE_TIEBA = "c10105";
    public static final String BUBBLE_PAY_MEMBER_CLICK = "c10055";
    public static final String BUBBLE_PAY_MEMBER_SUCCESS = "c10383";
    public static final String CHANDE_OLD_SUCCESS = "c10492";
    public static final String CLOSE_AD_TIME = "c14534";
    public static final String CONCERN_TAB_THREAD_CLICK = "c12352";
    public static final String ENTER_FORUM_EDIT_MENTION_CLICK = "c10149";
    public static final String ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK = "c10098";
    public static final String FACESHOP_DELETE = "c12233";
    public static final String FACESHOP_DOWNLOAD = "c12230";
    public static final String FACESHOP_ORDER = "c12234";
    public static final String FACESHOP_SHARE = "c12235";
    public static final String FACESHOP_TOTAL_NUM = "c12232";
    public static final String FACESHOP_UPLOAD_SOURCE = "c12327";
    public static final String FACESHOP_USE_EMOTION = "c12231";
    public static final String FANS_REMIND_CLICK = "c10390";
    public static final String FLOATING_VIEW_CLICK_KEY = "C12265";
    public static final String FLOATING_VIEW_SHOW_KEY = "C12266";
    public static final String FLOOR_VOICE_PLAY = "floor_voice_play";
    public static final String FRS_EXPERIENCE_SPEED = "c10752";
    public static final String FRS_EXPERIENCE_SPEED_BUY_MEMBER = "c10764";
    public static final String FRS_HOT_TOPIC_CARD_SHOW = "c10835";
    public static final String FRS_HOT_TOPIC_ITEM_CLICK = "c10819";
    public static final String FRS_LIVE_TAB = "c10386";
    public static final String FRS_PHOTO_LIVE_VIEW_PAGER_ITEM = "c10242";
    public static final String FUN_AD_AUTHORITY_CLICK = "c14090";
    public static final String FUN_AD_CLICK = "c14053";
    public static final String FUN_AD_DISCARD = "c14088";
    public static final String FUN_AD_FEEDBACK = "c14044";
    public static final String FUN_AD_FRS_FLOOR_SHOW = "c14272";
    public static final String FUN_AD_PRIVACY_CLICK = "c14089";
    public static final String FUN_AD_REQUEST = "c14005";
    public static final String FUN_AD_SHOW = "c14006";
    public static final String FUN_AD_SHOW_ERROR = "c14199";
    public static final String GOD_REPLY_LAYOUT_FULL_TEXT_CLICK = "c13348";
    public static final String GOD_REPLY_LAYOUT_FULL_TEXT_SHOW = "c13347";
    public static final String HOST_START = "c11894";
    public static final String HOT_SPLASH_APP_START = "c14555";
    public static final String HOT_SPLASH_TIMEOUT = "c14535";
    public static final String HOT_TOPIC_CLICK = "c11455";
    public static final String HOT_TOPIC_CLICK_FRS = "frs";
    public static final String HOT_TOPIC_CLICK_HOME = "index";
    public static final String HOT_TOPIC_CLICK_PB = "pb";
    public static final String HOT_TOPIC_CLICK_PB_BOTTOM = "pb_bottom";
    public static final String HOT_TOPIC_CLICK_TOPIC = "1";
    public static final String IM_REC_FORUM_ATTENTION_CLICK = "c14308";
    public static final String IM_REC_FORUM_ITEM_CLICK = "c14307";
    public static final String IM_REC_FORUM_ITEM_SHOW_KEY = "c14306";
    public static final String IM_TAB_SHOW_KEY = "c14305";
    public static final String INVOKE_AS = "c10007";
    public static final String KEY_AD_FLOAT_LAYER_CLICK = "c14428";
    public static final String KEY_AD_FLOAT_LAYER_SHOW = "c14427";
    public static final String KEY_AGREE_SUCCESS_CLICK = "c14179";
    public static final String KEY_AIAPPS_CALL_NATIVE = "c13561";
    public static final String KEY_AIAPPS_START = "c13606";
    public static final String KEY_AIAPPS_START_FAIL = "c13607";
    public static final String KEY_AI_APP_SHARE_CLICK = "c13531";
    public static final String KEY_ANNOUNCE_AREA = "c13447";
    public static final String KEY_ANTI_DIALOG_NEG_CLICK = "c12535";
    public static final String KEY_ANTI_DIALOG_POS_CLICK = "c12536";
    public static final String KEY_ANTI_DIALOG_SHOW = "c12534";
    public static final String KEY_BACK_USER = "c13997";
    public static final String KEY_BAR_DETAIL_CLICK = "c12714";
    public static final String KEY_BAR_ENTRANCE_DETAIL = "c13443";
    public static final String KEY_BAR_MANAGE_CLICK = "c12711";
    public static final String KEY_BIG_EMOTION_NUM = "c13991";
    public static final String KEY_COMMENT_BTN_CLICK = "c13568";
    public static final String KEY_COMMODITY_ENTRANCE_CLICK = "c13897";
    public static final String KEY_COMMODITY_ENTRANCE_SHOW = "c13896";
    public static final String KEY_CONCERN_BTN_CLICK = "c13570";
    public static final String KEY_CONCERN_SWITCH = "c14054";
    public static final String KEY_COPY_CLIENT_NUMBER_CLICK = "c14146";
    public static final String KEY_DARK_MODE_FOLLOW_SYSTEM = "c13577";
    public static final String KEY_DELETE_THREAD_REASON = "c13123";
    public static final String KEY_DRAG_TO_PERSONAL_CENTER = "c14536";
    public static final String KEY_DYNAMIC_CARD_CLICK = "c13564";
    public static final String KEY_DYNAMIC_CARD_SHOW = "c13578";
    public static final String KEY_ENTER_VIDEO_PAGE = "c12664";
    public static final String KEY_FE_FITE_PROGRAM_CLICK = "c13274";
    public static final String KEY_FLOAT_LAYER_CLICK = "c14129";
    public static final String KEY_FLOAT_LAYER_SHOW = "c14128";
    public static final String KEY_FROM_FRS_START_VOICE_ROOM = "c14467";
    public static final String KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_CLICK = "c14461";
    public static final String KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_EXPOSE = "c14460";
    public static final String KEY_FROM_FRS_VOICE_ROOM_LIST_PAGE_ENTER = "c14459";
    public static final String KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY = "c14473";
    public static final String KEY_FROM_VIDEO_MIDDLE_PTS = "c14495";
    public static final String KEY_FROM_VIDEO_ROLLBACK = "c14471";
    public static final String KEY_FRS_AD_LIST_ITEM_CLICK = "c13194";
    public static final String KEY_H5_OFFLINE_PACKAGE_DOWNLOAD = "c13435";
    public static final String KEY_HOME_RECOMMEND_CARD_INTEREST_CLICK = "c14372";
    public static final String KEY_HOME_RECOMMEND_CARD_INTEREST_SHOW = "c14367";
    public static final String KEY_IMAGE_VIEWER_DOWNLOAD_DIALOG_SUCCESS = "c14047";
    public static final String KEY_ITEM_THROUGH_CLICK = "c14073";
    public static final String KEY_ITEM_THROUGH_EXPOSURE = "c14072";
    public static final String KEY_MANAGE_ITEM_CLICK = "c12713";
    public static final String KEY_MESSAGE_AGGREGATION_PV = "view_msg";
    public static final String KEY_MORE_HISTORY_RECORD_CLICK = "c13437";
    public static final String KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK = "c13742";
    public static final String KEY_PAY_PUT_TIE = "c13998";
    public static final String KEY_PB_VOTE_SOURCE = "c13445";
    public static final String KEY_PERSON_CENTER_LITE_GAME_CENTER_CLICK = "c13431";
    public static final String KEY_PERSON_TALK_REPORT_CLICK = "c13063";
    public static final String KEY_QUICK_WEBVIEW_LOCAL_URL = "c13835";
    public static final String KEY_RATE_FEEDBACK_CLICK_CANCEL = "c13078";
    public static final String KEY_RATE_FEEDBACK_CLICK_FEEDBACK = "c13077";
    public static final String KEY_RATE_FEEDBACK_DIALOG_SHOW = "c13076";
    public static final String KEY_RATE_FIRST_CLICK_STAR = "c13072";
    public static final String KEY_RATE_FIRST_DIALOG_SHOW = "c13071";
    public static final String KEY_RATE_SCORE_CLICK_CANCEL = "c13075";
    public static final String KEY_RATE_SCORE_CLICK_SCORE = "c13074";
    public static final String KEY_RATE_SCORE_DIALOG_SHOW = "c13073";
    public static final String KEY_RICH_TEXT_VIDEO_CLICK = "c10643";
    public static final String KEY_SCHEMA_OPEN_WORKPUBLISH = "c14550";
    public static final String KEY_SCHEME_JUMP_CALL_NATIVE = "c10320";
    public static final String KEY_SEARCH_SUG_FORUM_CLICK = "c14288";
    public static final String KEY_SEARCH_SUG_FORUM_SHOW = "c14287";
    public static final String KEY_SEARCH_SUG_ITEM_CLICK = "c14290";
    public static final String KEY_SEARCH_SUG_ITEM_SHOW = "c14289";
    public static final String KEY_SEARCH_SUG_LIVE_CLICK = "c14294";
    public static final String KEY_SEARCH_SUG_LIVE_SHOW = "c14293";
    public static final String KEY_SEARCH_SUG_RANKING_CLICK = "c14292";
    public static final String KEY_SEARCH_SUG_RANKING_SHOW = "c14291";
    public static final String KEY_SHARE_CANCEL = "c12481";
    public static final String KEY_SHARE_CLICK = "c12386";
    public static final String KEY_SHARE_FORUM_OR_THREAD = "c10125";
    public static final String KEY_SHARE_GAME_DETIAL = "c13953";
    public static final String KEY_SHARE_PHOTO_LIVE = "c10427";
    public static final String KEY_SHARE_SUCCESS = "share_success";
    public static final String KEY_SHARE_TOPIC_DETAIL = "c13365";
    public static final String KEY_SIGN_REMIND_CLOSE_CLICK = "c13251";
    public static final String KEY_SIGN_REMIND_OK_CLICK = "c13250";
    public static final String KEY_SIGN_REMIND_PUSH_CLICK = "c13253";
    public static final String KEY_SIGN_REMIND_PUSH_SHOW = "c13252";
    public static final String KEY_SIGN_REMIND_SHOW = "c13249";
    public static final String KEY_SIGN_REMIND_SWITCH = "c13254";
    public static final String KEY_SMALL_EMOTION_NUM = "c13990";
    public static final String KEY_SMART_APP_HISTORY_DELETE_CLICK = "c13436";
    public static final String KEY_SMART_COLOR_FETCH_COLOR = "c14170";
    public static final String KEY_SPLASH_GOTO_MAIN_TAB = "c14375";
    public static final String KEY_START_VOICE_ROOM = "c14464";
    public static final String KEY_TASK_ENTRANCE = "c13422";
    public static final String KEY_THREAD_ACHIEVEMENT_SHARE = "c10898";
    public static final String KEY_THREAD_FIRE_CLICK = "c14266";
    public static final String KEY_TIEBA_UID_SHARE_DIALOG_CLICK = "c14148";
    public static final String KEY_TIEBA_UID_SHARE_DIALOG_SHOW = "c14147";
    public static final String KEY_TOPIC_DETAIL_CARD_AGREE_CLICK = "c13358";
    public static final String KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK = "c14394";
    public static final String KEY_TRANSFER_BTN_CLICK = "c13567";
    public static final String KEY_UPDATE_OFFLINE_PACK = "c14055";
    public static final String KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK = "c14182";
    public static final String KEY_VIDEO_ACCOUNT_ATTENTION_CLICK = "c14185";
    public static final String KEY_VIDEO_ACCOUNT_ATTENTION_LIST_PAGE = "c14262";
    public static final String KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK = "c14263";
    public static final String KEY_VIDEO_ACCOUNT_CLICK = "c14183";
    public static final String KEY_VIDEO_ACCOUNT_EXPOSURE = "c14198";
    public static final String KEY_VIDEO_ACCOUNT_PROGRESS_CLICK = "c14184";
    public static final String KEY_VIDEO_FROM_OUTSIDE = "c14304";
    public static final String KEY_VIDEO_HORIZONTAL_PLAY = "c14499";
    public static final String KEY_VIDEO_SHARE_SUCCESS = "c14181";
    public static final String KEY_VIDEO_SPLASH_SKIP = "c12946";
    public static final String KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK = "c14302";
    public static final String KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM = "c14300";
    public static final String KEY_VIDEO_TIME = "c11244";
    public static final String KEY_VOICE_ROOM_LIST_ITEM_CLICK = "c14456";
    public static final String KEY_VOICE_ROOM_LIST_ITEM_EXPOSE = "c14455";
    public static final String KEY_VOICE_ROOM_LIST_PAGE_ENTER = "c14454";
    public static final String KEY_VOTE_BUTTON = "c13441";
    public static final String KEY_VOTE_PAGE = "c13440";
    public static final String KEY_WRITE_GOODS_NEW_DIALOG_CLICK = "c13959";
    public static final String KEY_WRITE_GOODS_NEW_DIALOG_SHOW = "c13958";
    public static final String MEMBER_PAY_PAGE_SHOW = "c13747";
    public static final String MEMBER_PAY_PAGE_SHOW_PAY_CLICK = "c13748";
    public static final String MODIFY_NICK_ENTER_OPNEN_MEM_CLICK = "c12409";
    public static final String MYLIVE_TO_BE_ANCHOR = "c10491";
    public static final String MY_THREAD_SHARE_LIVE = "c12333";
    public static final String NEGATIVE_FEEDBACK_OPEN_CLICK = "c11989";
    public static final String NEG_FEEDBACK_KEY = "c11693";
    public static final String NOTIFY_GROUP_EVENT_CLICK = "notify_group_event_click";
    public static final String OBJ_PARAM1 = "obj_param1";
    public static final String PARAM_ID = "obj_id";
    public static final String PARAM_LOCATE = "obj_locate";
    public static final String PARAM_NAME = "obj_name";
    public static final String PARAM_SOURCE = "obj_source";
    public static final String PARAM_TYPE = "obj_type";
    public static final String PB_URL_CLICK_KEY = "c11972";
    public static final String PB_VOICE_PLAY = "pb_voice_play";
    public static final String PHOTO_LIVE_GREATCALL_MSG = "c10195";
    public static final String PL_COLLECT_UPDATE_NOTIFICATION = "c10430";
    public static final String PUSH_CCLICK = "c11703";
    public static final String PUSH_ENTRANCE = "c10303";
    public static final String PUSH_MESSAGE_CLICK = "c11963";
    public static final String PUSH_RECOMMEND_PB_RECEIVE = "c10146";
    public static final String REF_TYPE_MAINTAB_AD = "4000401";
    public static final String REMIND_EXPIRED = "remind_expired";
    public static final String REQUEST_AD_TIME = "c14532";
    public static final String SET_NIGHT_MODE = "c10647";
    public static final String SHOW_AD_TIME = "c14533";
    public static final String SUBPB_CLICK_SEND = "c10090";
    public static final String TAIL_PAY_MEMBER_SUCCESS = "c10061";
    public static final String THREAD_ACHIEVEMENT_DETAIL_SHARE = "c13724";
    public static final String UPDATE_IMMEDIATELY_CLICK = "c10003";
    public static final String UPDATE_IMMEDIATELY_SHOW = "c10010";
    public static final String UPDATE_INCREMENTAL_CLICK = "c10001";
    public static final String UPDATE_INCREMENTAL_SHOW = "c10002";
    public static final String UPDATE_SUCCES_IN_MISSON = "c10867";
    public static final String UPDATE_SUPER_SPEED_CLICK = "c10009";
    public static final String UPDATE_SUPER_SPEED_SHOW = "c10008";
    public static final String UPDATE_TIEFA_DOWNLOAD_FAILED = "c10662";
    public static final String UPGRADE_DIALOG_CHOOSE_IMAGE = "c10489";
    public static final String UPGRADE_SUCCESS = "c10500";
    public static final String WEBVIEW_SHARE = "c10898";
    public static final String WRITE_MORE_LINK_DIALOG_SHOW = "c13745";
    public static final String WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK = "c13746";
    public static final String XIAOYING_DURATION = "c10068";
    public static final String YULE_GAME_EAST_EGG_CLICK = "c10853";
    public static final String YULE_GAME_EAST_EGG_PB_CLICK = "c10854";
    public static final String YULE_GAME_EAST_EGG_VIEW = "c10852";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class AntiLocateValue {
        public static /* synthetic */ Interceptable $ic = null;
        public static int LOCATE_CHAT = 6;
        public static int LOCATE_COLD_BOOT = 8;
        public static int LOCATE_HOT_BOOT = 9;
        public static int LOCATE_LIKE_BAR = 7;
        public static int LOCATE_LIKE_PERSON = 4;
        public static int LOCATE_REPLY = 2;
        public static int LOCATE_REPLY_SUB_PB = 3;
        public static int LOCATE_SIGN = 5;
        public static int LOCATE_WRITE = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(709551034, "Lcom/baidu/tbadk/core/util/TbadkCoreStatisticKey$AntiLocateValue;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(709551034, "Lcom/baidu/tbadk/core/util/TbadkCoreStatisticKey$AntiLocateValue;");
            }
        }

        public AntiLocateValue() {
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
    }

    public TbadkCoreStatisticKey() {
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
