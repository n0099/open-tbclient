package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CommonStatisticKey {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_FRIEND_ROOM_CARD_CLICK = "c14008";
    public static final String ALA_FRIEND_ROOM_CARD_SHOW = "c14007";
    public static final String BUBBLE_TOOL_SHOW = "c15103";
    public static final String FRS_PUBLISH_ALA_CLICK = "c14138";
    public static final String FRS_VOICE_PLAY = "frs_voice_play";
    public static final int FUNCTION_STATISTIC_LOCATION_ALA = 6;
    public static final int FUNCTION_STATISTIC_LOCATION_BLUE_DIRLL = 8;
    public static final int FUNCTION_STATISTIC_LOCATION_CARD_BOX = 11;
    public static final int FUNCTION_STATISTIC_LOCATION_CHANNEL = 7;
    public static final int FUNCTION_STATISTIC_LOCATION_COLLECT = 2;
    public static final int FUNCTION_STATISTIC_LOCATION_CONSUME_RECORD = 12;
    public static final int FUNCTION_STATISTIC_LOCATION_DRIFTING_BOTTLE = 10;
    public static final int FUNCTION_STATISTIC_LOCATION_FRIEND = 3;
    public static final int FUNCTION_STATISTIC_LOCATION_GIFT = 4;
    public static final int FUNCTION_STATISTIC_LOCATION_HISTORY = 5;
    public static final int FUNCTION_STATISTIC_LOCATION_MESSAGE = 1;
    public static final int FUNCTION_STATISTIC_LOCATION_SHELF = 9;
    public static final String HOME_PUBLISH_ALA_CLICK = "c13619";
    public static final String KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_CLICK = "c14545";
    public static final String KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_SHOW = "c14544";
    public static final String KEY_ACCELERATOR_PAGE_RETRY_BTN_CLICK = "c14549";
    public static final String KEY_ACCELERATOR_PAGE_RETRY_BTN_SHOW = "c14548";
    public static final String KEY_ACCELERATOR_PAGE_SHOW = "c14543";
    public static final String KEY_ACCELERATOR_PAGE_STOP_BTN_CLICK = "c14547";
    public static final String KEY_ACCELERATOR_PAGE_STOP_BTN_SHOW = "c14546";
    public static final String KEY_AT_PANEL_COMMIT = "c14377";
    public static final String KEY_AT_PANEL_SHOW = "c14376";
    public static final String KEY_BATCH_DELETE_MESSAGE = "c14663";
    public static final String KEY_BATCH_MULTI_DEL_CLICK = "c14858";
    public static final String KEY_BAWU_FRS_MUSK_CLICK = "c14324";
    public static final String KEY_BAWU_MULTI_MUSK_CLICK = "c14325";
    public static final String KEY_BAWU_TIP_DIALOG_CANCEL = "c14323";
    public static final String KEY_BAWU_TIP_DIALOG_SHOW = "c14322";
    public static final String KEY_CARD_ENTER_FORUM_CLICK = "C12888";
    public static final String KEY_CARD_ENTER_FORUM_SHOW = "c12887";
    public static final String KEY_CHANGE_RICH_TEXT_MODE = "c14553";
    public static final String KEY_CHAT_GROUP_BOTTOM_BANNER_CLICKED = "c15096";
    public static final String KEY_CHAT_GROUP_CLICK = "c15076";
    public static final String KEY_CHAT_GROUP_DIALOG_SHOW = "c15074";
    public static final String KEY_CHECK_DIALOG_CLICK = "c15029";
    public static final String KEY_CHECK_DIALOG_SHOW = "c15028";
    public static final String KEY_CLICK_VIDEO_TOPIC = "c14410";
    public static final String KEY_COLLECT_COVER_CLICK = "c15203";
    public static final String KEY_COLLECT_COVER_SHOW = "c15202";
    public static final String KEY_COMMUNITY_CONVENTION_CLICK = "c14687";
    public static final String KEY_CONCERN_YY_LIVE_AVATER_CLICK = "c14279";
    public static final String KEY_CONCERN_YY_LIVE_AVATER_SHOW = "c14280";
    public static final String KEY_CREATE_BA_CLICK = "c14676";
    public static final String KEY_CURRENCY_SWITCH_DIALOG_CLICK = "c14142";
    public static final String KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON = "c14145";
    public static final String KEY_CURRENCY_SWITCH_DIALOG_CLICK_SUCCESS = "c14143";
    public static final String KEY_CURRENCY_SWITCH_DIALOG_SHOW = "c14141";
    public static final String KEY_DOWNLOAD_MANAGER_DOWNLOADING_CLICK = "c14361";
    public static final String KEY_DOWNLOAD_MANAGER_INSTALLED_CLICK = "c14373";
    public static final String KEY_DOWNLOAD_MANAGER_ORDERED_CLICK = "c14360";
    public static final String KEY_DOWNLOAD_MANAGER_SHOW = "c14359";
    public static final String KEY_DRESS_UP_BUNDLE_CLICK = "c15002";
    public static final String KEY_DRESS_UP_BUNDLE_SHOW = "c15001";
    public static final String KEY_DXX_GUIDE_START_DOWNLOAD = "c15197";
    public static final String KEY_ENTRANCE_CLICKED = "c12611";
    public static final String KEY_FESTIVAL_TIP_VIEW_CLICK = "c15170";
    public static final String KEY_FORUM_INSIDE_LIVE_CLICK = "c14137";
    public static final String KEY_FORUM_INSIDE_LIVE_SHOW = "c14136";
    public static final String KEY_FORUM_REC_THREAD_CLICK = "c19001";
    public static final String KEY_FORUM_REC_THREAD_SHOW = "c19000";
    public static final String KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5 = "c14197";
    public static final String KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5 = "c14196";
    public static final String KEY_FRS_ADVANCED_AD_COMPLETE_SHOW = "c14195";
    public static final String KEY_FRS_CONTENT_COLLECTION_TAB_LOG = "c15138";
    public static final String KEY_FRS_FORUM_FLOAT_CLICK = "c13881";
    public static final String KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_CLICK = "c14541";
    public static final String KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_SHOW = "c14540";
    public static final String KEY_FRS_ITEM_ACCELERATOR_START_BTN_IMG_CLICK = "c14542";
    public static final String KEY_FRS_ITEM_GAME_CODE_CLICK = "c14422";
    public static final String KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_CLICK = "c14424";
    public static final String KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_SHOW = "c14423";
    public static final String KEY_FRS_ITEM_GAME_CODE_SHOW = "c14421";
    public static final String KEY_FRS_ITEM_TAB_ALBUM_CLICK = "c14187";
    public static final String KEY_FRS_ITEM_TAB_COMMENT_CLICK = "c14190";
    public static final String KEY_FRS_ITEM_TAB_RANKING = "c14189";
    public static final String KEY_FRS_ITEM_TAB_RECOMMEND_CLICK = "c14191";
    public static final String KEY_FRS_ITEM_TAB_SHOW = "c14186";
    public static final String KEY_FRS_ITEM_TAB_TAG_CLICK = "c14188";
    public static final String KEY_FRS_MULTI_MUSK_VIEW_CANCEL_CLICK = "c14333";
    public static final String KEY_FRS_MULTI_MUSK_VIEW_MUSK_AND_FORBIDDEN_CLICK = "c14332";
    public static final String KEY_FRS_MULTI_MUSK_VIEW_MUSK_CLICK = "c14331";
    public static final String KEY_FRS_MULTI_MUSK_VIEW_SHOW = "c14330";
    public static final String KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK = "c14329";
    public static final String KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK = "c14328";
    public static final String KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK = "c14327";
    public static final String KEY_FRS_MUSK_REASON_DIALOG_SHOW = "c14326";
    public static final String KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK = "c14336";
    public static final String KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK = "c14335";
    public static final String KEY_FRS_MUSK_SELF_DIALOG_SHOW = "c14334";
    public static final String KEY_FRS_ORDER_DOWNLOAD_CLICK = "c14192";
    public static final String KEY_FRS_ORDER_DOWNLOAD_EXPORT = "c14193";
    public static final String KEY_FRS_STAR_PIC_CLICK = "c12883";
    public static final String KEY_FRS_TRANSMIT_THREAD = "c12940";
    public static final String KEY_FUNCTION_PANEL_CLIKED = "c12612";
    public static final String KEY_GET_ALI_PAY_USER_INFO = "c15118";
    public static final String KEY_GROUP_CHAT_ENTRANCE_CLICK = "c15075";
    public static final String KEY_GROUP_CHAT_LINK_SHOW = "c15077";
    public static final String KEY_GROUP_CHAT_ROBOT_CLICK = "c15133";
    public static final String KEY_HEATING_THREAD_AGREE = "c14204";
    public static final String KEY_HEATING_THREAD_CLICK = "c14203";
    public static final String KEY_HEATING_THREAD_COMMENT = "c14205";
    public static final String KEY_HEATING_THREAD_EXPOSE = "c14202";
    public static final String KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW = "c14601";
    public static final String KEY_HOME_PAGE_MESSGAE_AT_CLICK = "c14598";
    public static final String KEY_HOME_PAGE_MESSGAE_AT_SUCESSED = "c14612";
    public static final String KEY_HOME_PAGE_MESSGAE_FANS_CLICK = "c14614";
    public static final String KEY_HOME_PAGE_MESSGAE_ITEM_CLICK = "c14618";
    public static final String KEY_HOME_PAGE_MESSGAE_ITEM_SHOW = "c14617";
    public static final String KEY_HOME_PAGE_MESSGAE_REPLY_CLICK = "c14602";
    public static final String KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_CLICK = "c14620";
    public static final String KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_SHOW = "c14619";
    public static final String KEY_HOME_PAGE_MESSGAE_TAB_CLICK = "c14609";
    public static final String KEY_HOME_PAGE_MESSGAE_TAB_SHOW = "c14611";
    public static final String KEY_HOME_PAGE_YY_LIVE_AVATER_CLICK = "c14281";
    public static final String KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW = "c14282";
    public static final String KEY_HOT_EVENT_CLICK = "c14963";
    public static final String KEY_HOT_EVENT_SHOW = "c14962";
    public static final String KEY_HOT_TOPIC_BANNER_CLICK = "c14902";
    public static final String KEY_HOT_TOPIC_NEXT_ONE = "c14903";
    public static final String KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK = "c14339";
    public static final String KEY_INTEREST_GUIDE_CLICK = "c14096";
    public static final String KEY_INTEREST_GUIDE_SEE_MORE_CLICK = "c14350";
    public static final String KEY_INTEREST_GUIDE_SHOW = "c14095";
    public static final String KEY_ITEM_CARD_BUTTON_CLICK = "c14121";
    public static final String KEY_ITEM_CARD_BUTTON_SHOW = "c14120";
    public static final String KEY_ITEM_HOT_VIDEO_CLICK = "c14352";
    public static final String KEY_ITEM_HOT_VIDEO_SHOW = "c14351";
    public static final String KEY_ITEM_RECENT_UPDATE_CLICK = "c14354";
    public static final String KEY_ITEM_RECENT_UPDATE_SHOW = "c14353";
    public static final String KEY_LIMIT_MODE_CHANGE_TOAST = "c14554";
    public static final String KEY_LIVE_TAB_CLICK = "c14133";
    public static final String KEY_LIVE_TAB_SHOW = "c14131";
    public static final String KEY_LOCAL_INOUT_SEND_BTN_CLICK = "c14527";
    public static final String KEY_LOCAL_INOUT_SHOW = "c14526";
    public static final String KEY_LOGIN_DIALOG_INVOKE = "c14059";
    public static final String KEY_LOGIN_DIALOG_SUCCESS = "c14060";
    public static final String KEY_MINE_PAGE_LOGIN_DIALOG_SUCCESS = "c14468";
    public static final String KEY_MULTI_DEL_BUTTON_CLICK = "c13122";
    public static final String KEY_MY_TAB_GENERAL_DRESS_CLICK = "c15003";
    public static final String KEY_NAMEPLATE_OF_USER_LEVEL_STATIC = "c14927";
    public static final String KEY_NEW_SCHEME_PULL_UP = "c13321";
    public static final String KEY_ONE_KEY_READ = "c14662";
    public static final String KEY_PB_CONTENT_COLLECTION_VIEW_CLICK = "c15141";
    public static final String KEY_PB_CONTENT_COLLECTION_VIEW_SHOW = "c15143";
    public static final String KEY_PB_FOLD_FLOOR_COMPLAINT = "c14439";
    public static final String KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK = "c14438";
    public static final String KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW = "c14437";
    public static final String KEY_PB_FOLD_ICON_CLICK = "c14435";
    public static final String KEY_PB_FOLD_ICON_SHOW = "c14434";
    public static final String KEY_PB_FORUM_GUIDE_VIEW_CLICK = "c14595";
    public static final String KEY_PB_FORUM_GUIDE_VIEW_SHOW = "c14594";
    public static final String KEY_PB_HAS_FOLD_ICON_SHOW = "c14436";
    public static final String KEY_PB_MORE_DIALOG_MUSK_CLICK = "c14338";
    public static final String KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK = "c14517";
    public static final String KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW = "c14516";
    public static final String KEY_PB_NOVEL_INFO_JUMP_H5 = "c14552";
    public static final String KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK = "c14529";
    public static final String KEY_PB_NOVEL_INFO_PAY_DIALOG_SHOW = "c14528";
    public static final String KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK = "c14519";
    public static final String KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW = "c14518";
    public static final String KEY_PB_OPTIMIZE_LOAD_DURATION = "c14610";
    public static final String KEY_PB_PAGE_CONTENT_COLLECTION_SHOW = "c15140";
    public static final String KEY_PB_RECOMMEND_GUIDE_VIEW_JUMP = "c14875";
    public static final String KEY_PB_RECOMMEND_GUIDE_VIEW_SHOW = "c14874";
    public static final String KEY_PERSON_LIVE_TAB_CLICK = "c14123";
    public static final String KEY_POST_THREAD_AT_USE_CONDITION = "c14380";
    public static final String KEY_PUSH_PERMISSIION_DIALOG_SHOW = "c13674";
    public static final String KEY_PUSH_PERMISSION_DIALOG_click = "c13673";
    public static final String KEY_QUESTION_DETAIL_HELP = "c14864";
    public static final String KEY_QUESTION_DETAIL_MORE = "c14865";
    public static final String KEY_QUESTION_ENTRANCE_CLICK = "c14860";
    public static final String KEY_QUESTION_ENTRANCE_SHOW = "c14859";
    public static final String KEY_QUESTION_MSG_NO_SHIELD = "c14861";
    public static final String KEY_QUESTION_TOP_NOTIFY_CLICK = "c14863";
    public static final String KEY_QUESTION_TOP_NOTIFY_SHOW = "c14862";
    public static final String KEY_RD_USE = "c14470";
    public static final String KEY_RECOMMEND_GAMECENTER = "c14119";
    public static final String KEY_RECOMMEND_TIP_ITEM_CLICK = "c12049";
    public static final String KEY_RED_PACKET_POP_WINDOW_SHOW = "c13083";
    public static final String KEY_REPORT_PRIVATE_MSG_CHANGE = "c14577";
    public static final String KEY_SCREEN_SHOT = "c13848";
    public static final String KEY_SEND_EASTER_EGG_EMOJI = "c14659";
    public static final String KEY_SERVICE_CENTER_CLICK = "c14968";
    public static final String KEY_SHARE_FRIEND_BTN = "c14644";
    public static final String KEY_SHARE_NEARLY_PERSON = "c14643";
    public static final String KEY_SHOW_PB_HEAD_NOTICE_BAR = "c14340";
    public static final String KEY_SITE_SERVICE = "c14050";
    public static final String KEY_SITE_SERVICE_ENTRANCE = "c14049";
    public static final String KEY_STAMP_SHARE_DIALOG = "c14503";
    public static final String KEY_STATISTICS_ADVERTSDK_CLICK = "c13320";
    public static final String KEY_STATISTICS_ADVERTSDK_SHOW = "c13319";
    public static final String KEY_STATISTICS_MOBADS_CLICK = "c13043";
    public static final String KEY_STATISTICS_MOBADS_SHOW = "c13042";
    public static final String KEY_SUGGEST_FEEDBACK_CLICK = "c14969";
    public static final String KEY_SYSTEM_SERVICE = "c14052";
    public static final String KEY_THREAD_POST_FAIL_DIALOG_RETRY_CLICK = "c14041";
    public static final String KEY_THREAD_POST_RESULT_DIALOG_SHOW = "c14040";
    public static final String KEY_TIE_PLUS_CPC_REQUEST_COST_URL = "c14567";
    public static final String KEY_TIE_PLUS_CPC_REQUEST_SHOW_URL = "c14568";
    public static final String KEY_TIE_PLUS_DIALOG_EXPOSE = "c14298";
    public static final String KEY_TIE_PLUS_DOWNLOAD_FINISHED = "c14395";
    public static final String KEY_TIE_PLUS_RICH_TEXT_CLICK = "c14297";
    public static final String KEY_TIE_PLUS_RICH_TEXT_EXPOSE = "c14296";
    public static final String KEY_TIE_PLUS_WECHAT_DIALOG_CLICK = "c14481";
    public static final String KEY_TIE_PLUS_WECHAT_DIALOG_EXPOSE = "c14480";
    public static final String KEY_TOAST_DOWNLOAD_MANAGER_CLICK = "c14362";
    public static final String KEY_UEG_POST_CLICKED = "c14048";
    public static final String KEY_URL_NULL_REPORT = "c12619";
    public static final String KEY_USER_GROWTH_TASK_FINISH_TOAST_SHOW = "c15244";
    public static final String KEY_VIDEO_AD_PLAY_SWITCH = "c14625";
    public static final String KEY_VIDEO_EASTER_EGG_REPLAY = "c13044";
    public static final String KEY_VIDEO_EASTER_EGG_SHARE = "c13045";
    public static final String KEY_VIDEO_EASTER_EGG_SHOW = "c13046";
    public static final String KEY_VIDEO_FLOW_PLAY_CLICK = "c13257";
    public static final String KEY_VIDEO_PLAY_BTN_CLICK = "c13255";
    public static final String KEY_VIDEO_SEEK_CLICK = "c13256";
    public static final String KEY_VIP_AD_FREE_GUID_TIP_CLICK = "c14867";
    public static final String KEY_VIP_AD_FREE_GUID_TIP_SHOW = "c14866";
    public static final String KEY_VIP_CARD_BUTTON_CLICK = "c14936";
    public static final String KEY_VIP_CARD_CLICK = "c14935";
    public static final String KEY_VIP_CARD_SHOW = "c14934";
    public static final String KEY_VOICE_ROOM_SHARE = "c14466";
    public static final String KEY_VOICE_ROOM_SHARE_PANEL = "c14465";
    public static final String KEY_WORK_PUBLISH_ENTER_TYPE_CLICK = "c13793";
    public static final String KEY_WORK_VIDEO_HAS_TOPIC = "c14420";
    public static final String KEY_WORK_VIDEO_TOPIC_LAYOUT_SHOW = "c14414";
    public static final String KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK = "c14418";
    public static final String KEY_WORK_VIDEO_TOPIC_TAB_SHOW = "c14416";
    public static final String KEY_WRITE_VOTE_VIEW_SHOW = "c13800";
    public static final String KEY_XIUXIU_THREAD_SHOW = "c15061";
    public static final String KEY_YY_ENTRANCE_BIGPIC_RECOMMON_CLICK = "c14846";
    public static final String KEY_YY_ENTRANCE_BIGPIC_RECOMMON_SHOW = "c14845";
    public static final String KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_CLICK = "c14844";
    public static final String KEY_YY_ENTRANCE_HOMEPAGE_RECOMMON_SHOW = "c14843";
    public static final String KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK = "c14265";
    public static final String KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW = "c14206";
    public static final String KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_CLICK = "c14848";
    public static final String KEY_YY_ENTRANCE_IN_VIDEO_NORMAL_SHOW = "c14847";
    public static final String KEY_YY_FRS_HEAD_SCULPTURE_CLICK = "c14140";
    public static final String KEY_YY_FRS_HEAD_SCULPTURE_SHOW = "c14139";
    public static final String KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK = "c14267";
    public static final String KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW = "c14268";
    public static final String MESSAGE_ENTER_ICON_CLICK = "c12924";
    public static final String MY_SERVICE_CK = "my_service_ck";
    public static final String NOTIFICATION_PERMISSION_DIALOG_CLICK = "c13673";
    public static final String NOTIFICATION_PERMISSION_DIALOG_SHOW = "c13674";
    public static final String PB_SHOW_APP = "pb_show_app";
    public static final String PERSON_CENTER_FUNCTION_CLICK = "c12044";
    public static final String PERSON_INFO_CENTER_LOTTIE_SHOW = "c13248";
    public static final String REF_TYPE_FRS_AD = "4000601";
    public static final String SEARCH_BAR_CLICK = "c10378";
    public static final String TAIL_TOOL_SHOW = "c15165";
    public static final String UBS_TEST_PUBLISH_BUTTON_CLICK = "c13702";
    public static final String USER_ICON_VISIT = "c10134";
    public static final String WINDOW_CLICK = "c14076";
    public static final String WINDOW_EXPOSURE = "c14075";
    public static final String kEY_TIE_PLUS_DIAGLO_CLICK = "c14299";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class Page {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FRS = "frs";
        public static final String INDEX = "index";
        public static final String PB = "pb";
        public transient /* synthetic */ FieldHolder $fh;

        public Page() {
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

    /* loaded from: classes3.dex */
    public static final class TbMemberOfficialStatic {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String MEMBER_MSG_CENTER_NOTIFY_CLICK = "c14939";
        public static final String MEMBER_MSG_CENTER_NOTIFY_SHOW = "c14938";
        public static final String MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_MSG_CLICK = "c14942";
        public static final String MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_MSG_SHOW = "c14941";
        public static final String MEMBER_OFFICIAL_NOTIFY_LIST_PAGE_SHOW = "c14940";
        public static final String TB_MEMBER_OFFICIAL_ID = "1638369935";
        public transient /* synthetic */ FieldHolder $fh;

        public TbMemberOfficialStatic() {
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

    /* loaded from: classes3.dex */
    public static final class Transmitthread {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String OBJ_TYPE_PB = "2";
        public static final String OBJ_TYPE_SOURCE_PB = "3";
        public static final String OBJ_TYPE_USER = "1";
        public transient /* synthetic */ FieldHolder $fh;

        public Transmitthread() {
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

    public CommonStatisticKey() {
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
