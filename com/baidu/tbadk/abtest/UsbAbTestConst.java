package com.baidu.tbadk.abtest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UsbAbTestConst {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AD_NOT_INSTALL_REMIND_A = "12_46_ad_not_install_remind_a";
    public static final String KEY_AD_NOT_INSTALL_REMIND_B = "12_46_ad_not_install_remind_b";
    public static final String KEY_AGREE_NUMBER_CAN_CLICK = "12_27_agree_number_can_a";
    public static final String KEY_BIG_IMAGE_PRE_PAGE = "12.39_big_image_pre_page";
    public static final String KEY_CONCERN_FEED_TEST = "12.38_concern_feed_test";
    public static final String KEY_ENTER_FRS_NO_ANMI = "12.25_enter_frs_no_anim";
    public static final String KEY_EXTRA_DURATION = "12.41_extra_duration";
    public static final String KEY_FEED_LIVE_CARD_STYLE_A = "12_39_livecard_style_a";
    public static final String KEY_FORUM_REC_REASON_COLOR_TEST_A = "12_19_rec_a";
    public static final String KEY_FUN_AD_SDK_DUPLICATE_REMOVAL = "12_4_bear_duplicate_removal_a";
    public static final String KEY_FUN_AD_SDK_FRS = "12_2_frs_bear_a";
    public static final String KEY_FUN_AD_SDK_PB_BANNER = "11_9_pb_bear_a";
    public static final String KEY_FUN_AD_SDK_PB_COMMENT = "12_8_0_pb_comment_bear_a";
    public static final String KEY_FUN_AD_SDK_PERSONALIZE = "12_5_personalize_bear_a";
    public static final String KEY_FUN_AD_SDK_PICPAGE_BEAR = "12_2_picpage_bear_a";
    public static final String KEY_FUN_AD_SDK_PICPAGE_INSERT_BEAR = "12_11_picpage_ahead_bear_a";
    public static final String KEY_HOME_MAX_THREAD_COUNT_DISABLE = "home_page_max_thread_count_disable";
    public static final String KEY_HOME_WRITE_TEST = "12.46_home_write_test";
    public static final String KEY_HOT_RANK_SHOW = "12_15_live_cell_style_a";
    public static final String KEY_HOT_SPLASH_FIX = "12_25_splash_req_ad_rule";
    public static final String KEY_IJK_IPV6_UPGRADE = "12_47_ijk_ipv6_upgrade_a";
    public static final String KEY_LIVE_CARD_GAME_SHOW = "12_18_live_gameshow_style_a";
    public static final String KEY_MAIN_INDEX_TAB_SHOW_A = "12_26_index_tab_show_a";
    public static final String KEY_MYPAGE_EXPOSED_REMIND_CARD = "12_28_exposed_remind_ad";
    public static final String KEY_NATIVE_AD_AUTO_PLAY = "12_14_ad_video_a";
    public static final String KEY_NATIVE_AD_NO_INTERACTION_STYLE = "12_18_personalize_frs_style_a";
    public static final String KEY_NICK_NAME = "12_11_nick_name_a";
    public static final String KEY_NON_ECOM_AD_DOWNLOADER_A = "12_46_non_ecom_ad_downloader_a";
    public static final String KEY_NON_ECOM_AD_DOWNLOADER_B = "12_46_non_ecom_ad_downloader_b";
    public static final String KEY_PB_NO_CACHE_TEST = "12.45_pb_no_cache_abtest";
    public static final String KEY_PB_REPLY_OPTIMIZE = "12.33_pb_reply_optimize_a";
    public static final String KEY_PERSONAL_VIDEO_TAB_FLOW = "12_10_zhuye_feed_b";
    public static final String KEY_PERSON_CENTER_H5_ABTEST = "12.45_person_center_h5_abtest";
    public static final String KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_A = "12_37_openpush_b";
    public static final String KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_B = "12_37_openpush_c";
    public static final String KEY_RECOMMEND_FEED_TEST = "12.44_recommend_feed_test";
    public static final String KEY_SEARCH_H5_TEST = "12_44_searchbox_a";
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
