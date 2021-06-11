package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
/* loaded from: classes3.dex */
public class YYLiveUtil {
    public static final String SOURCE_BAIDU_LIVE_CARD_ = "baidu_live_zhibo_block_";
    public static final String SOURCE_BAIDU_LIVE_FOLLOW_HEAD = "baidu_live_zhibo_guanzhu_head";
    public static final String SOURCE_BAIDU_LIVE_RECOMMEND_BANNER = "baidu_live_recommend_banner";
    public static final String SOURCE_BAIDU_LIVE_TOP_PLAY = "baidu_live_top_play";
    public static final String SOURCE_FRS_LIVE_CARD_ = "frs_live_";
    public static final String SOURCE_FRS_LIVE_HEAD_ = "frs_feed_head_";
    public static final String SOURCE_HOME_FOLLOW_TAB_CARD = "home_guanzhu_tab";
    public static final String SOURCE_HOME_FOLLOW_TAB_HEAD = "home_guanzhu_head";
    public static final String SOURCE_HOME_LIVE_TAB_CARD_ = "home_live_tab_block_";
    public static final String SOURCE_HOME_LIVE_TAB_FOLLOW_CARD = "my_concern_live_card";
    public static final String SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD = "my_concern_live_head";
    public static final String SOURCE_HOME_LIVE_TAB_RECOMMEND = "home_live_tab_recommend";
    public static final String SOURCE_HOME_LIVE_TAB_STAGE = "home_live_tab_wutai";
    public static final String SOURCE_HOME_RECOMMEND_HEAD = "home_recommend_head";
    public static final String SOURCE_HOME_RECOMMEND_PLAY = "home_recommend_play";
    public static final String SOURCE_HOME_RECOMMEND_TWO_FLOOR = "home_recommend_two_floor";
    public static final String SOURCE_NOT_DEFINE = "not_define";
    public static final String SOURCE_PERSON_AUTHOR_HEAD = "my_author_head";

    public static int calculateLiveType(AlaInfoData alaInfoData) {
        YyExtData yyExtData = alaInfoData.mYyExtData;
        return yyExtData != null ? yyExtData.isYyGame ? 3 : 2 : alaInfoData.live_type == 1 ? 1 : 5;
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        jumpToYYLiveRoom(tbPageContext, str, str2, str3, str4, SOURCE_NOT_DEFINE);
    }

    public static void jumpYYLiveRoom(TbPageContext tbPageContext, AlaInfoData alaInfoData) {
        if (alaInfoData == null || !alaInfoData.isLegalYYLiveData()) {
            return;
        }
        YyExtData yyExtData = alaInfoData.mYyExtData;
        String str = yyExtData.mSid;
        String str2 = yyExtData.mSsid;
        String str3 = yyExtData.mTemplateId;
        jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + alaInfoData.roomId);
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4, String str5) {
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX + "sid=" + str + "&ssid=" + str2 + "&templateId=" + str3 + "&roomId=" + str4 + "&source=" + str5});
    }
}
