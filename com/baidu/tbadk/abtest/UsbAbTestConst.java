package com.baidu.tbadk.abtest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UsbAbTestConst {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AD_RETARGET_NOTIFICATION_REMIND = "12_28_notification_remind_ad";
    public static final String KEY_AD_RETARGET_TIPS_REMIND = "12_28_tips_remind_ad";
    public static final String KEY_AGREE_NUMBER_CAN_CLICK = "12_27_agree_number_can_a";
    public static final String KEY_BIG_IMAGE_PRE_PAGE = "12.39_big_image_pre_page";
    public static final String KEY_BIG_PIC_RECOMMEND_LIVE_SECOND_FLOOR_A = "12_30_picture_recommend_live_a";
    public static final String KEY_BIG_PIC_RECOMMEND_LIVE_SECOND_FLOOR_B = "12_30_picture_recommend_live_b";
    public static final String KEY_CONCERN_FEED_TEST = "12.38_concern_feed_test";
    public static final String KEY_ENTER_FRS_NO_ANMI = "12.25_enter_frs_no_anim";
    public static final String KEY_EXIT_REMIND_TIP = "12_28_exit_remind_ad";
    public static final String KEY_FEED_LIVE_CARD_STYLE_A = "12_39_livecard_style_a";
    public static final String KEY_FEED_VIDEO_TRANSITION = "12_19_feed_video_transition_a";
    public static final String KEY_FORUM_REC_REASON_COLOR_TEST_A = "12_19_rec_a";
    public static final String KEY_FRS_FOLLOW_GUIDE_A = "12_22_frs_follow_guide_a";
    public static final String KEY_FUN_AD_SDK_DUPLICATE_REMOVAL = "12_4_bear_duplicate_removal_a";
    public static final String KEY_FUN_AD_SDK_FRS = "12_2_frs_bear_a";
    public static final String KEY_FUN_AD_SDK_PB_BANNER = "11_9_pb_bear_a";
    public static final String KEY_FUN_AD_SDK_PB_COMMENT = "12_8_0_pb_comment_bear_a";
    public static final String KEY_FUN_AD_SDK_PERSONALIZE = "12_5_personalize_bear_a";
    public static final String KEY_FUN_AD_SDK_PICPAGE_BEAR = "12_2_picpage_bear_a";
    public static final String KEY_FUN_AD_SDK_PICPAGE_INSERT_BEAR = "12_11_picpage_ahead_bear_a";
    public static final String KEY_HOMEPAGE_RECOMMEND_LIVE_SECOND_FLOOR = "12_28_homepage_recommend_live_a";
    public static final String KEY_HOME_MAX_THREAD_COUNT_DISABLE = "home_page_max_thread_count_disable";
    public static final String KEY_HOT_RANK_SHOW = "12_15_live_cell_style_a";
    public static final String KEY_HOT_SPLASH_FIX = "12_25_splash_req_ad_rule";
    public static final String KEY_IMAGE_CACHE_OPTIMIZE = "12.36_imagecache_optimize_a";
    public static final String KEY_IMG_CLICK_TO_PB = "12_24_tupiandianji_b";
    public static final String KEY_IMG_NOT_CANCEL = "12_28_img_not_cancel";
    public static final String KEY_LIVE_CARD_GAME_SHOW = "12_18_live_gameshow_style_a";
    public static final String KEY_MAIN_INDEX_TAB_SHOW_A = "12_26_index_tab_show_a";
    public static final String KEY_MAIN_TAB_DATA_CACHE = "12_21_main_tab_data_b";
    public static final String KEY_MAIN_TAB_DATA_OFF = "12_21_main_tab_data_c";
    public static final String KEY_MAIN_TAB_DATA_PREFETCH = "12_21_main_tab_data_a";
    public static final String KEY_MYPAGE_EXPOSED_REMIND_CARD = "12_28_exposed_remind_ad";
    public static final String KEY_NATIVE_AD_AUTO_PLAY = "12_14_ad_video_a";
    public static final String KEY_NATIVE_AD_NO_INTERACTION_STYLE = "12_18_personalize_frs_style_a";
    public static final String KEY_NEW_INTEREST_TEST_A = "12_21_interest_card_log_a";
    public static final String KEY_NICK_NAME = "12_11_nick_name_a";
    public static final String KEY_OFFLINE_SIGN_PUSH = "12_27_signpush_a";
    public static final String KEY_ONLINE_PUSH_SHOW_TEST_A = "12_25_andriodpush_a";
    public static final String KEY_PB_FORUM_GUIDE_TEST_A = "12_22_pb_forum_guide_a";
    public static final String KEY_PB_REPLY_OPTIMIZE = "12.33_pb_reply_optimize_a";
    public static final String KEY_PB_SHARE_PATH_TEST_A = "12_25_zhuanfalujing_a";
    public static final String KEY_PERSONAL_VIDEO_TAB_FLOW = "12_10_zhuye_feed_b";
    public static final String KEY_PUSH_PERMISSION_BTN_BOTTOM = "12_26_push_btn_bottom_a";
    public static final String KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_A = "12_37_openpush_b";
    public static final String KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_B = "12_37_openpush_c";
    public static final String KEY_REQUEST_INSERT_AD = "frontpage_popup_a";
    public static final String KEY_SHARE_BTN_TOP_RIGHT = "12_25_zhuanfaweizhi_a";
    public static final String KEY_SHARE_H5_CARD_OPTIMIZE = "12_16_sharecard_a";
    public static final String KEY_SHOU_BAI_THREAD_TEST = "12.39_shou_bai_thread_test";
    public static final String KEY_VIDEOTAB_AUTO_PLAY = "12_5_zp_1";
    public static final String KEY_VIDEO_AUTO_PLAY_NEXT_VIDEO = "12_15_autoplay_a";
    public static final String KEY_VIDEO_SET_URL_AGAIN = "12_20_repeatset_a";
    public static final String KEY_WRITE_PROTO = "12_26_thread_proto_android_a";
    public static final String VIDEO_PLAY_DANMU_SHOW = "12_14_danmu_1";
    public transient /* synthetic */ FieldHolder $fh;

    public UsbAbTestConst() {
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
