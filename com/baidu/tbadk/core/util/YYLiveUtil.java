package com.baidu.tbadk.core.util;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class YYLiveUtil {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String SOURCE_HOME_RECOMMEND_SECOND_FLOOR = "home_recommend_twofloor";
    public static final String SOURCE_HOME_RECOMMEND_TWO_FLOOR = "home_recommend_two_floor";
    public static final String SOURCE_NOT_DEFINE = "not_define";
    public static final String SOURCE_PB_BIG_IMAGE_HEAD = "pb_datu_head";
    public static final String SOURCE_PB_LIVE_BANNER = "pb_live_banner";
    public static final String SOURCE_PB_LIVE_HEAD = "pb_live_head";
    public static final String SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD = "pb_video_recommend_live_card";
    public static final String SOURCE_PB_WORD_RECOMMEND_LIVE_CARD = "pb_tuwen_recommend_live_card";
    public static final String SOURCE_PERSON_AUTHOR_HEAD = "my_author_head";
    public transient /* synthetic */ FieldHolder $fh;

    public YYLiveUtil() {
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

    public static int calculateLiveType(AlaInfoData alaInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, alaInfoData)) == null) {
            YyExtData yyExtData = alaInfoData.mYyExtData;
            return yyExtData != null ? yyExtData.isYyGame ? 3 : 2 : alaInfoData.live_type == 1 ? 1 : 5;
        }
        return invokeL.intValue;
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, tbPageContext, str, str2, str3, str4) == null) {
            jumpToYYLiveRoom(tbPageContext, str, str2, str3, str4, SOURCE_NOT_DEFINE);
        }
    }

    public static void jumpYYLiveRoom(TbPageContext tbPageContext, AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65540, null, tbPageContext, alaInfoData) == null) && alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            YyExtData yyExtData = alaInfoData.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + alaInfoData.roomId);
        }
    }

    public static String makeJumpToYYLiveRoomUrl(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, str4, str5)) == null) {
            return UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX + "sid=" + str + "&ssid=" + str2 + "&templateId=" + str3 + "&roomId=" + str4 + "&source=" + str5;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, str, str2, str3, str4, str5}) == null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX + "sid=" + str + "&ssid=" + str2 + "&templateId=" + str3 + "&roomId=" + str4 + "&source=" + str5});
        }
    }
}
