package com.baidu.tbadk.core.util;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UrlSchemaHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTO_PAY_MEMBER_SUCC_PARAM = "from=autopay";
    public static final String AUTO_PAY_MEMBER_SUCC_URL = "tieba.baidu.com/mo/q/tbeanrights?";
    public static final String CHANGE_YINJI_SUCCESS = "/changeyinjisuccess";
    public static final String FINISH_THIS_WEBVIEW = "https://tieba.baidu.com/?jump=finish_this_page";
    public static final String FROM_ENTER_FORUM = "unidispatch/enterforum";
    public static final String FROM_FORUM_SQUARE = "unidispatch/forumsquare";
    public static final String FROM_YUN_PUSH = "&from_yunpush=1";
    public static final String FROM_YUN_PUSH_TWO = "?from_yunpush=1";
    public static final String GOTO_BUBBLE_LIST = "jumptobubble_list";
    public static final String GOTO_ENTERFORUM_TAB = "jump_enter_forum=1";
    public static final String GOTO_LOGIN = "jumptologin=1";
    public static final String GOTO_OFFICIAL_CHAT = "jump_official_chat=1";
    public static final String GOTO_PERSONAL_CHAT = "jump_chat=1";
    public static final String GOTO_PERSON_INFO = "jump_personalCenter=1";
    public static final String GOTO_RECOMMNEDS_FRS_TAB = "jump_chosen_post=1";
    public static final String GOTO_TAIL_MANAGER = "jump_tail_edit=1";
    public static final String GOTO_TDOU_PAY_BUNDING_PHONE = "bunding_phone=1";
    public static final String GO_TO_MIX_LIVE = "unidispatch/mixlive";
    public static final String GO_TO_YY_CUSTOMER_SERVICE = "video/yylive/customerservice";
    public static final String GO_TO_YY_FEEDBACK = "video/yylive/feedback";
    public static final String GO_TO_YY_LIVE = "video/yylive/joinlive";
    public static final String GO_TO_YY_PERSONAL_CENTER_PAGE = "bdtiebalive://video/yylive/router?url=yymobile%3A%2F%2FWeb%2FView%3Furl%3Dhttps%3A%2F%2Fweb.yy.com%2Fbd_anchor_user_center%2Findex.html%26needLogin%3D1";
    public static final String GO_TO_YY_ROUTER = "video/yylive/router";
    public static final String HTTPS_JUMP_TOPIC_DETAIL = "https://tieba.baidu.com/mo/q/newtopic/detail";
    public static final String HTTPS_JUMP_TO_CHAT = "https://tieba.baidu.com/mo/q/chat";
    public static final String HTTPS_JUMP_TO_HOT_TOPIC = "https://tieba.baidu.com/mo/q/hotmessage?topic_id=";
    public static final String HTTPS_JUMP_TO_HOT_TOPIC2 = "https://tieba.baidu.com/mo/q/hotMessage?topic_id=";
    public static final String HTTPS_JUMP_TO_HOT_TOPIC3 = "https://tieba.baidu.com/mo/q/hotMessage?topic_id=";
    public static final String HTTPS_JUMP_TO_HOT_TOPIC_NEW = "https://tieba.baidu.com/mo/q/newhotmessage?";
    public static final String HTTPS_JUMP_TO_USER_GIFT = "https://tieba.baidu.com/user/gift";
    public static final String HTTP_JUMP_TOPIC_DETAIL = "https://tieba.baidu.com/mo/q/newtopic/detail";
    public static final String HTTP_JUMP_TO_USER_GIFT = "https://tieba.baidu.com/user/gift";
    public static final String JUMP_TO_CHAT = "https://tieba.baidu.com/mo/q/chat";
    public static final String JUMP_TO_HOT_TOPIC = "https://tieba.baidu.com/mo/q/hotmessage?topic_id=";
    public static final String JUMP_TO_HOT_TOPIC2 = "https://tieba.baidu.com/mo/q/hotMessage?topic_id=";
    public static final String JUMP_TO_HOT_TOPIC_NEW = "https://tieba.baidu.com/mo/q/newhotmessage?";
    public static final String JUMP_TO_MODIFY_NICKNAME = "/interact/modifyname";
    public static final String JUMP_TO_NEW_PAGE = "jump=open_full_screen_web_page";
    public static final String JUMP_TO_NEW_PAGE_2 = "jump=open_screen_web_page";
    public static final String JUMP_TO_POST_LIST = "https://tieba.baidu.com/mo/q/myPost";
    public static final String JUMP_TO_THIS_PAGE = "jump=open_in_this_page";
    public static final String JUMP_TO_VIDEO_SQUARE = "routertovideosquare:";
    public static final String MEMBER_CENTER_URL = "mo/q/hybrid/tbvip";
    public static final String OPEN_PERSON_INFO = "open_personalCenter=1";
    public static final String PAY_MEMBER_PAGE = "/paywithnative";
    public static final String PAY_TBEAN_PAGE = "/buyTBeans";
    public static final String REAL_NAME_AUTH_URL = "https://wappass.baidu.com/passport/realnamewidget?tpl=tieba&adapter=3&nomenu=1";
    public static final String REDIRECT_JUMP_KEY = "jump_webview_type=2";
    public static final String SCHEMA_AGREE_ME = "com.baidu.tieba://unidispatch/agreemepage";
    public static final String SCHEMA_AT_ME = "com.baidu.tieba://unidispatch/atmepage";
    public static final String SCHEMA_CHUSHOU_LIVE_SDK = "tiebachushou://";
    public static final String SCHEMA_FANS_PAGE = "com.baidu.tieba://unidispatch/fanspage";
    public static final String SCHEMA_FORUM_BROADCAST_REVIEWED = "com.baidu.tieba://unidispatch/forumbroadcast/reviewed";
    public static final String SCHEMA_FORUM_BROADCAST_SINGLE_FEED = "com.baidu.tieba://unidispatch/forumbroadcast/singlefeed";
    public static final String SCHEMA_FORUM_DETAIL_FLUTTER = "com.baidu.tieba://unidispatch/forumDetail?forumId=";
    public static final String SCHEMA_GAME_PLAY_ALBUM = "com.baidu.tieba://unidispatch/GameGodAlbum";
    public static final String SCHEMA_GAME_PLAY_GODS_PAGE = "com.baidu.tieba://unidispatch/GameGodsDetailPage";
    public static final String SCHEMA_GAME_PLAY_MAIN_PAGE = "com.baidu.tieba://unidispatch/GamePlayPage";
    public static final String SCHEMA_GAME_PLAY_ORDERING_PAGE = "com.baidu.tieba://unidispatch/GameGodsDetailPage";
    public static final String SCHEMA_GAME_PLAY_ORDER_PAGE = "com.baidu.tieba://unidispatch/GameOrderDetail";
    public static final String SCHEMA_GAME_PLAY_PERSON_CHAT = "com.baidu.tieba://unidispatch/UserChat";
    public static final String SCHEMA_GAME_PLAY_SKILL_DETAIL = "com.baidu.tieba://unidispatch/GameSkillDetail";
    public static final String SCHEMA_GAME_RECOMMENT_PAGE = "tbmaintab://tieba.baidu.com";
    public static final String SCHEMA_LIVE_MY_CONCERN_LIST = "com.baidu.tieba://unidispatch/liveconcernlist";
    public static final String SCHEMA_LIVE_SDK = "bdtiebalive://";
    public static final String SCHEMA_NAITVE_H5 = "com.baidu.tieba://unidispatch/tbwebview";
    public static final String SCHEMA_PATH_FROM_FORUM_SQUARE = "/forumsquare";
    public static final String SCHEMA_REPLY_ME = "com.baidu.tieba://unidispatch/replyme";
    public static final String SCHEMA_TB_FLUTTER = "flt://";
    public static final String SCHEMA_TO_FORUM_USER_LIVE = "com.baidu.tieba://unidispatch/yylivelist";
    public static final String SCHEMA_TYPE_BAIJIAHAO_PB = "isbaijiahao=1";
    public static final String SCHEMA_TYPE_BAR_VOTE = "tieba://election?";
    public static final String SCHEMA_TYPE_BEAUTY_PIC = "beautypic:";
    public static final String SCHEMA_TYPE_CERCON_FORUM = "emoticonforumattend://";
    public static final String SCHEMA_TYPE_CHECK_EMOTION_UPLOADING = "emoticonuploadingcheck://";
    public static final String SCHEMA_TYPE_CLOSE_WEBVIEW = "closewebview://";
    public static final String SCHEMA_TYPE_COLLECT_EMOTION = "emoticoncoll://";
    public static final String SCHEMA_TYPE_CREATE_EMOTION = "emoticoncreate://";
    public static final String SCHEMA_TYPE_CREATE_SINGLE_EMOTION = "emoticonsinglecreate://";
    public static final String SCHEMA_TYPE_DEEPLINK_FRS = "com.baidu.tieba://unidispatch/frs?kw=";
    public static final String SCHEMA_TYPE_DEEPLINK_TOPIC = "com.baidu.tieba://deeplink?jump=new_hot_topic_list";
    public static final String SCHEMA_TYPE_DELETE_EMOTION = "emoticondel://";
    public static final String SCHEMA_TYPE_DIALOG_EMOTION = "emoticondialog://";
    public static final String SCHEMA_TYPE_DOWNLOAD_EMOTION = "emoticondown://";
    public static final String SCHEMA_TYPE_FEED_BACK = "feedback:";
    public static final String SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB = "financialfrs://";
    public static final String SCHEMA_TYPE_FINISH_THIS_PAGE = "jump=finish_this_page";
    public static final String SCHEMA_TYPE_FRS = "frs:";
    public static final String SCHEMA_TYPE_FRS_DETAIL = "tieba://frsdetail?";
    public static final String SCHEMA_TYPE_FRS_ITEM_TAB = "tieba.baidu.com/f/itemdetail?forumname=";
    public static final String SCHEMA_TYPE_FRS_RULES = "forumruledetail://";
    public static final String SCHEMA_TYPE_GAME_DETAIL = "game:detail:";
    public static final String SCHEMA_TYPE_GAME_SDK = "tieba://gamedemo?";
    public static final String SCHEMA_TYPE_GOTO_BUY_TBEAN = "tdoudiscount:";
    public static final String SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY = "tieba.baidu.com/mo/q/cardBag";
    public static final String SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY_ASSIST = "packet_id=";
    public static final String SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS = "consumptionrecords:";
    public static final String SCHEMA_TYPE_GOTO_DRESSUP_CENTER = "dressupcenter:";
    public static final String SCHEMA_TYPE_GOTO_MEMBER_BUY = "memberbuy:";
    public static final String SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST = "jumptoforum=memberbuy";
    public static final String SCHEMA_TYPE_GOTO_MEMBER_CENTER = "membercenter:";
    public static final String SCHEMA_TYPE_GOTO_MEMBER_EXCHANGE = "memberexchange:";
    public static final String SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER = "membertaskcenter:";
    public static final String SCHEMA_TYPE_GOTO_ONE_KEY_SIGN = "onekeysign:";
    public static final String SCHEMA_TYPE_GOTO_PENDANT_LIST = "avatarpendantlist:";
    public static final String SCHEMA_TYPE_GOTO_PERSONAL_BG = "personalbg:";
    public static final String SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL = "personalcard:";
    public static final String SCHEMA_TYPE_GOTO_POST_BUBBLE = "postbubble:";
    public static final String SCHEMA_TYPE_GOTO_TBEAN_BUY = "tdoudiscount:";
    public static final String SCHEMA_TYPE_GOTO_WALLET_SDK_DUXIAOMAN = "duxiaoman.com/cloan";
    public static final String SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH = "icash.baidu.com/cloan";
    public static final String SCHEMA_TYPE_HAS_EMOTION = "emoticonhas://";
    public static final String SCHEMA_TYPE_HOMEPAGE_LIVETAB = "tieba://homepage_livetab?";
    public static final String SCHEMA_TYPE_HOT_TOPIC_LIST = "hottopiclist:";
    public static final String SCHEMA_TYPE_HOT_TOPIC_LIST_NEW = "https://tieba.baidu.com/mo/q/hotMessage/list";
    public static final String SCHEMA_TYPE_HOT_TOPIC_LIST_NEW_HTTPS = "https://tieba.baidu.com/mo/q/hotMessage/list";
    public static final String SCHEMA_TYPE_HOT_TOPIC_RANK_LIST = "unidispatch/hot_topic_rank_list";
    public static final String SCHEMA_TYPE_HTTP = "http:";
    public static final String SCHEMA_TYPE_HTTPS = "https:";
    public static final String SCHEMA_TYPE_JUMP_LIVE_ROOM = "tieba://jumpliveroom?";
    public static final String SCHEMA_TYPE_JUMP_MEMBER_BUY = "jumpmemberbuy://";
    public static final String SCHEMA_TYPE_JUMP_OUTER = "jump=outer";
    public static final String SCHEMA_TYPE_JUMP_PB = "tieba://pb?";
    public static final String SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL = "emoticonpkgpage://";
    public static final String SCHEMA_TYPE_LEGO = "tieba://lego?";
    public static final String SCHEMA_TYPE_LIST = "list:";
    public static final String SCHEMA_TYPE_MIDDLE_PAGE = "middlepage:";
    public static final String SCHEMA_TYPE_MODIFY_NAME = "modifyname://";
    public static final String SCHEMA_TYPE_OPFEATURE = "opfeature:";
    public static final String SCHEMA_TYPE_ORDER_EMOTION = "emoticonorder://";
    public static final String SCHEMA_TYPE_PB = "pb:";
    public static final String SCHEMA_TYPE_PHOTOLIVE = "twzb:";
    public static final String SCHEMA_TYPE_PONE = "tel:";
    public static final String SCHEMA_TYPE_SAVE_EMOTION = "emoticonsave://";
    public static final String SCHEMA_TYPE_SHARE = "share:";
    public static final String SCHEMA_TYPE_SHARE_EMOTION = "share://";
    public static final String SCHEMA_TYPE_SMS = "sms:";
    public static final String SCHEMA_TYPE_SQUARE = "square:";
    public static final String SCHEMA_TYPE_SQUARE_FORUM_LIST = "forumsquarelist";
    public static final String SCHEMA_TYPE_SQUARE_SEARCH = "squaresearch:";
    public static final String SCHEMA_TYPE_START_GAME = "tieba://gameinvoke?";
    public static final String SCHEMA_TYPE_SUB_PB = "tieba.baidu.com/subp";
    public static final String SCHEMA_TYPE_SWAN = "tiebaclient://swan";
    public static final String SCHEMA_TYPE_SWAN_BAIDUBOXAPP = "baiduboxapp://swan";
    public static final String SCHEMA_TYPE_TBOWNEREMOJI = "/n/interact/tbowneremoji";
    public static final String SCHEMA_TYPE_TB_CLIENT = "tbclient://";
    public static final String SCHEMA_TYPE_TB_CLIENT_GAME_FRS_TAB = "tblaunch://tieba.baidu.com/f?";
    public static final String SCHEMA_TYPE_TB_CLIENT_ZM = "tbclient_zm://";
    public static final String SCHEMA_TYPE_TB_LAUNCH = "tblaunch://";
    public static final String SCHEMA_TYPE_TOAST_EMOTION = "emoticontoast://";
    public static final String SCHEMA_TYPE_TOPIC = "topic:";
    public static final String SCHEMA_TYPE_VIDEO_MIDDLE_PAGE = "tieba.baidu.com/videoMiddlePage";
    public static final String SCHEMA_TYPE_WEB = "web:";
    public static final String SCHEMA_TYPE_ZB = "zb:";
    public static final String SCHEMA_VIDEO_CREATE_CENTER = "com.baidu.tieba://unidispatch/video_create_center";
    public static final String SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX = "bdtiebalive://video/yylive/joinlive?";
    public static final String SCHEME_TYPE_ACCOUNT_SAFE = "tieba://accountsafe";
    public static final String SCHEME_TYPE_ID_CARD = "tieba://idcard?";
    public static final String TBEAN_TOAST = "pay=1";
    public static final String VIRTUAL_IMAGE_MAIN_URL = "https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar";
    public transient /* synthetic */ FieldHolder $fh;

    public UrlSchemaHelper() {
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

    public static boolean checkBaiduboxappSwan(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.startsWith(SCHEMA_TYPE_SWAN_BAIDUBOXAPP) : invokeL.booleanValue;
    }

    public static void goToNewPageByScheme(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith(SCHEMA_TYPE_SWAN)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(805306368);
        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
            TbadkCoreApplication.getInst().startActivity(intent);
        }
    }

    @NonNull
    public static String replaceSwanBaiduboxapp2Tiebaclient(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.replace(SCHEMA_TYPE_SWAN_BAIDUBOXAPP, SCHEMA_TYPE_SWAN) : (String) invokeL.objValue;
    }
}
