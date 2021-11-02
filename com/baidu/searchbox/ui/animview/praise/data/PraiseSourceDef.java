package com.baidu.searchbox.ui.animview.praise.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PraiseSourceDef {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String H5_PRAISE_SRC_COMMUNITY = "h5_community";
    public static final String H5_PRAISE_SRC_DYNAMIC_NACMT = "h5_dynamic_nacmt";
    public static final String H5_PRAISE_SRC_DYNAMIC_SEARCHBAR = "h5_dynamic_searchbar";
    public static final String H5_PRAISE_SRC_FEEDNEWS = "h5_feednews";
    public static final String H5_PRAISE_SRC_PROFILE_LIGHT = "h5_profile_light";
    public static final String H5_PRAISE_SRC_PROFILE_SEARCHBAR = "h5_profile_searchbar";
    public static final String H5_PRAISE_SRC_SUPERSTAR = "h5_superstar";
    public static final String H5_PRAISE_SRC_WENDA = "h5_wenda";
    public static final String H5_PRAISE_SRC_WENDA_SEARCH = "h5_wenda_search";
    public static final String HN_PRAISE_SRC_DYNAMIC_LIST = "hn_dynamic_list";
    public static final String HN_PRAISE_SRC_SN_PREFIX = "sn_";
    public static final String NA_PRAISE_SRC_COMMENT_DETAIL_HEADER = "na_comment_detail_header";
    public static final String NA_PRAISE_SRC_COMMENT_DETAIL_HOT = "na_comment_detail_hot";
    public static final String NA_PRAISE_SRC_COMMENT_DETAIL_LIST = "na_comment_detail_list";
    public static final String NA_PRAISE_SRC_COMMENT_LIST = "na_comment_list";
    public static final String NA_PRAISE_SRC_COMMUNITY_LIST = "na_interest_square";
    public static final String NA_PRAISE_SRC_DYNAMIC_DETAIL = "dt_landing";
    public static final String NA_PRAISE_SRC_DYNAMIC_DETAIL_CONTENT = "dt_landing_double_click";
    public static final String NA_PRAISE_SRC_DYNAMIC_IMGTXT_DETAIL_BAR = "na_dynamic_imgtxt_detail_bar";
    public static final String NA_PRAISE_SRC_DYNAMIC_IMMERSIVE = "na_dt_immersive";
    public static final String NA_PRAISE_SRC_FANCY_COMMENT_LIST = "na_fancy_comment_list_text_image_video";
    public static final String NA_PRAISE_SRC_FEED = "na_feed";
    public static final String NA_PRAISE_SRC_FEED_TAB_MOMENT = "na_feed_tab_moment";
    public static final String NA_PRAISE_SRC_FEED_VIDEO = "na_feed_video";
    public static final String NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST = "na_feed_video_comment_list";
    public static final String NA_PRAISE_SRC_FEED_VIDEO_LIST = "na_feed_video_list";
    public static final String NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT = "na_feed_video_list_out";
    public static final String NA_PRAISE_SRC_HOT_DISCUSSION = "na_hot_discussion";
    public static final String NA_PRAISE_SRC_IMMERSIVE_VIDEO_LIST = "na_immersive_video_list";
    public static final String NA_PRAISE_SRC_LIVE_ASK_ANSWER = "na_live_ask_answer";
    public static final String NA_PRAISE_SRC_MERGE_VIDEO_LANDING = "merge_video_landing";
    public static final String NA_PRAISE_SRC_MINI_VIDEO_DETAIL_BAR = "na_mini_detail_bar";
    public static final String NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN = "na_mini_detail_screen";
    public static final String NA_PRAISE_SRC_YOULIAO = "na_youliao";
    public transient /* synthetic */ FieldHolder $fh;

    public PraiseSourceDef() {
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
