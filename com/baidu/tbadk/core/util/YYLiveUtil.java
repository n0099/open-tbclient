package com.baidu.tbadk.core.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class YYLiveUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SOURCE_BAIDU_LIVE_CARD_ = "baidu_live_zhibo_block_";
    public static final String SOURCE_BAIDU_LIVE_FOLLOW_HEAD = "baidu_live_zhibo_guanzhu_head";
    public static final String SOURCE_BAIDU_LIVE_RECOMMEND_BANNER = "baidu_live_recommend_banner";
    public static final String SOURCE_BAIDU_LIVE_TOP_PLAY = "baidu_live_top_play";
    public static final String SOURCE_CHANNEL_BANNER = "home_page_channel_banner";
    public static final String SOURCE_FRS_LIVE_CARD_ = "frs_live_";
    public static final String SOURCE_FRS_LIVE_CARD_TAB = "frs_tab_live_card";
    public static final String SOURCE_FRS_LIVE_HEAD_ = "frs_feed_head_";
    public static final String SOURCE_FRS_SERVICE_AREA = "frs_service_area";
    public static final String SOURCE_HOMEPAGE_VIDEO_CHANNEL = "video_bar_icon";
    public static final String SOURCE_HOMEPAGE_VIDEO_MIDDLE = "video_immer_icon";
    public static final String SOURCE_HOME_CONCERN_LIVE_HEAD = "home_guanzhu_live_head";
    public static final String SOURCE_HOME_CONCERN_TUWEN_HEAD = "home_guanzhu_tuwen_head";
    public static final String SOURCE_HOME_CONCERN_VIDEO_HEAD = "home_guanzhu_video_head";
    public static final String SOURCE_HOME_FOLLOW_TAB_CARD = "home_guanzhu_tab";
    public static final String SOURCE_HOME_FOLLOW_TAB_HEAD = "home_guanzhu_head";
    public static final String SOURCE_HOME_LIVE_TAB_CARD_ = "home_live_tab_block_";
    public static final String SOURCE_HOME_LIVE_TAB_FOLLOW_CARD = "my_concern_live_card";
    public static final String SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD = "my_concern_live_head";
    public static final String SOURCE_HOME_LIVE_TAB_RECOMMEND = "home_live_tab_recommend";
    public static final String SOURCE_HOME_LIVE_TAB_STAGE = "home_live_tab_wutai";
    public static final String SOURCE_HOME_RECOMMEND_AUTO_PLAY = "home_recommend_auto_play";
    public static final String SOURCE_HOME_RECOMMEND_HEAD = "home_recommend_head";
    public static final String SOURCE_HOME_RECOMMEND_LIVE_HEAD = "home_recommend_live_head";
    public static final String SOURCE_HOME_RECOMMEND_PLAY = "home_recommend_play";
    public static final String SOURCE_HOME_RECOMMEND_SECOND_FLOOR = "home_recommend_twofloor";
    public static final String SOURCE_HOME_RECOMMEND_TUWEN_HEAD = "home_recommend_tuwen_head";
    public static final String SOURCE_HOME_RECOMMEND_TWO_FLOOR = "home_recommend_two_floor";
    public static final String SOURCE_HOME_RECOMMEND_VIDEO_HEAD = "home_recommend_video_head";
    public static final String SOURCE_NOT_DEFINE = "not_define";
    public static final String SOURCE_PB_BIG_IMAGE_HEAD = "pb_datu_head";
    public static final String SOURCE_PB_LIVE_BANNER = "pb_live_banner";
    public static final String SOURCE_PB_LIVE_HEAD = "pb_live_head";
    public static final String SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD = "pb_video_recommend_live_card";
    public static final String SOURCE_PB_WORD_RECOMMEND_LIVE_CARD = "pb_tuwen_recommend_live_card";
    public static final String SOURCE_PERSON_AUTHOR_HEAD = "my_author_head";
    public static final String SOURCE_PERSON_LIST_OTHER = "follow_other_head";
    public static final String SOURCE_PERSON_LIST_OWNER = "follow_owner_head";
    public transient /* synthetic */ FieldHolder $fh;

    public YYLiveUtil() {
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

    public static void addYyExtData(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, statisticItem, str) == null) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("sid");
                String queryParameter2 = parse.getQueryParameter("ssid");
                String queryParameter3 = parse.getQueryParameter(TiebaStatic.YYParams.YYUID);
                String queryParameter4 = parse.getQueryParameter("templateId");
                String queryParameter5 = parse.getQueryParameter("liveId");
                YyExtData yyExtData = new YyExtData();
                yyExtData.mSid = queryParameter;
                yyExtData.mSsid = queryParameter2;
                yyExtData.mYyUid = queryParameter3;
                yyExtData.liveId = queryParameter5;
                yyExtData.mTemplateId = queryParameter4;
                TiebaStaticHelper.addYYParam(statisticItem, yyExtData);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
            } catch (Exception unused) {
            }
        }
    }

    public static int calculateLiveType(AlaInfoData alaInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, alaInfoData)) == null) {
            int i = 5;
            if (alaInfoData == null) {
                return 5;
            }
            YyExtData yyExtData = alaInfoData.mYyExtData;
            if (yyExtData != null) {
                i = yyExtData.isYyGame ? 3 : 2;
            } else if (alaInfoData.live_type == 1) {
                i = 1;
            }
            copyLiveIdToYYExtData(alaInfoData);
            return i;
        }
        return invokeL.intValue;
    }

    public static void copyLiveIdToYYExtData(AlaInfoData alaInfoData) {
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, alaInfoData) == null) || alaInfoData == null || (yyExtData = alaInfoData.mYyExtData) == null || !TextUtils.isEmpty(yyExtData.liveId)) {
            return;
        }
        alaInfoData.mYyExtData.liveId = String.valueOf(alaInfoData.live_id);
    }

    public static boolean isLiveRoom(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0216).equals(str) || TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0217).equals(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isYYLiveLink(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !TextUtils.isEmpty(str) && str.contains("bdtiebalive://video/yylive") : invokeL.booleanValue;
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, YyExtData yyExtData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, tbPageContext, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", str);
    }

    public static void jumpYYLiveRoom(TbPageContext tbPageContext, AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, tbPageContext, alaInfoData) == null) && alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            YyExtData yyExtData = alaInfoData.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + alaInfoData.roomId);
        }
    }

    public static String makeJumpToYYLiveRoomUrl(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            StringBuilder sb = new StringBuilder(UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX);
            sb.append("sid=");
            sb.append(str);
            sb.append("&ssid=");
            sb.append(str2);
            sb.append("&templateId=");
            sb.append(str3);
            sb.append("&roomId=");
            sb.append(str4);
            sb.append("&source=");
            sb.append(str6);
            if (!StringUtils.isNull(str5)) {
                sb.append("&streamInfo=");
                sb.append(urlEncoded(str5));
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String urlEncoded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4) == null) {
            jumpToYYLiveRoom(tbPageContext, str, str2, str3, str4, SOURCE_NOT_DEFINE);
        }
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{tbPageContext, str, str2, str3, str4, str5}) == null) {
            jumpToYYLiveRoom(tbPageContext, str, str2, str3, str4, null, str5);
        }
    }

    public static void jumpYYLiveRoom(TbPageContext tbPageContext, AlaInfoData alaInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65548, null, tbPageContext, alaInfoData, str) == null) && alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            YyExtData yyExtData = alaInfoData.mYyExtData;
            String str2 = yyExtData.mSid;
            String str3 = yyExtData.mSsid;
            String str4 = yyExtData.mTemplateId;
            jumpToYYLiveRoom(tbPageContext, str2, str3, str4, "" + alaInfoData.roomId, str);
        }
    }

    public static void jumpToYYLiveRoom(TbPageContext tbPageContext, String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{tbPageContext, str, str2, str3, str4, str5, str6}) == null) {
            StringBuilder sb = new StringBuilder(UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX);
            sb.append("sid=");
            sb.append(str);
            sb.append("&ssid=");
            sb.append(str2);
            sb.append("&templateId=");
            sb.append(str3);
            sb.append("&roomId=");
            sb.append(str4);
            sb.append("&source=");
            sb.append(str6);
            if (!StringUtils.isNull(str5)) {
                sb.append("&streamInfo=");
                sb.append(urlEncoded(str5));
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{sb.toString()});
        }
    }

    public static int calculateLiveType(YyExtData yyExtData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yyExtData)) == null) {
            if (yyExtData != null) {
                return yyExtData.isYyGame ? 3 : 2;
            }
            return 5;
        }
        return invokeL.intValue;
    }
}
