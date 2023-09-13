package com.baidu.tbadk;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.BigImageCacheOptimizeSwitch;
import com.baidu.tbadk.switchs.ImageCacheOptimizeSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.vh;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class TbConfig {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ABSTRACT_AUTO = 0;
    public static final int ABSTRACT_OPEN = 1;
    public static final int ADD_IAMGE_WATER_NONE = 0;
    public static final int ADD_IMAGE_WATER_FORUM_NAME = 2;
    public static final int ADD_IMAGE_WATER_NO = 3;
    public static final int ADD_IMAGE_WATER_USER_NAME = 1;
    public static String ADD_MSG_RECORD = null;
    public static int ALPHA_80 = 0;
    public static final String API_CAN_SEND_CARD = "/peiwan/api/god/can_send_card";
    public static final String API_CLICK_FRS_GAMEPLAY_CARD = "/peiwan/api/index/audio";
    public static final String API_CLICK_TO_CHAT = "/peiwan/api/team/click";
    public static final String API_GOD_CARD = "/peiwan/api/god/card";
    public static final String API_GOD_IDENTITY = "/peiwan/api/god/identity";
    public static final long APP_ENTER_BACKGROUND_INTERVAL = 1000;
    public static final long APP_ID = 10773430;
    public static final long APP_OVERDUR_DRAFT_BOX = 604800000;
    public static final String APP_UPDATE_ACTION = "com.baidu.tieba.NewsVersion";
    public static final int AUTO_PLAY_ALWAYS = 2;
    public static final int AUTO_PLAY_CLOSED = 3;
    public static final int AUTO_PLAY_IN_WIFI = 1;
    public static final int AUTO_PLAY_UNSET = -1;
    public static final String AVATAR_PENDANT = "c/e/theme/getPendantByCategory";
    public static final String BAWUTEAME_ADDRESS;
    public static final String BIGDAY_IMAGE_CACHE_DIR_NAME = "bigday_images";
    public static int BIG_IMAGE_MAX_USED_MEMORY = 0;
    public static final int BIG_IMAGE_MIN_CAPACITY = 10000;
    public static final int BIG_IMAGE_MIN_SIZE = 80;
    public static int BIG_IMAGE_SIZE = 0;
    public static final int BIG_PHOTO_MAX_SIZE = 110;
    public static final String BROADCAST_CHANGESKIN = "com.baidu.tieba.broadcast.changeskin";
    public static final String BROADCAST_CHANGE_SHARED_PREF = "com.baidu.tieba.broadcast.changeSharedPref";
    public static final String BROADCAST_FIELD_SKIN_TYPE = "skin_type";
    public static final String BROADCAST_IMAGE_RESIZED = "com.baidu.tieba.broadcast.image.resized";
    public static final String BROADCAST_NEWVERSION = "com.baidu.tieba.broadcast.newversion";
    public static final String BROADCAST_SIGN_ALERT = "com.baidu.tieba.broadcast.signalert";
    public static final String BUBBLE_GROUP_PAGE = "c/e/theme/getBubbleByCategory";
    public static final String BUBBLE_LIST_PAGE = "c/e/theme/getBubbleList";
    public static final String BUBBLE_SET = "c/e/bu/setbubble";
    public static final String BUY_FACE_PACKAGE_URL = "c/e/faces/buyfacepack";
    public static final Bitmap.Config BitmapConfig;
    public static String CHANGE_USER_PORTRAIT = null;
    public static final String CHANNEL_FILE = "channel.dat";
    public static final String CHANNEL_ID_BJH_ARTICLE = "33833";
    public static final String CHANNEL_ID_BJH_DYNAMIC = "33842";
    public static final String CHANNEL_ID_BJH_VIDEO = "33840";
    public static final String CHANNEL_ID_PREFIX = "&channelid=";
    public static final String CHECK_OFFICIAL_SWITCH_URL = "c/u/user/getOfficialSwitch";
    public static final String CHECK_SHARE_SDK_URL;
    public static final String CMD_GET_REPOST_FORUM_LIST = "c/f/recommend/getRepostRecommendForum";
    public static final String CMD_HMEPAGE_CHANNEL_LIST = "c/f/forum/channel";
    public static final String CMD_SCREEN_LOCK_MESSAGE_MORE = "c/f/msg/getMoreMsg";
    public static final String COMMIT_GOOD_ADDRESS = "c/c/bawu/commitgood";
    public static final String COMMIT_TOP_ADDRESS = "c/c/bawu/committop";
    public static final String COMMON_PRAISE_URL = "c/c/zan/like";
    public static final String COMMUNITY_CONVENTION = "https://tieba.baidu.com/tb/pc/common-pc.html?key=b337c655543620a37c372836f277b76115";
    public static final String COMPLETE_TASK_URL = "c/s/completeTask";
    public static final String CONCERN_RECOMMEND_FEEDBACK = "c/c/excellent/submitConcernDislike";
    public static boolean COULD_UPDATE = false;
    public static final String CREATE_BA = "https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1";
    public static String CURRENT_FROM = null;
    public static final String DEBUG_UPLOAD = "c/s/debugupload";
    public static final String DECRYPT_CODE_URL = "c/s/decryptCode";
    public static long DEFALT_USE_TIME_INTERVAL = 0;
    public static final float DEFAULT_PIC_USED_MEMORY_PERCENTAGE_MIAN = 0.35f;
    public static final float DEFAULT_PIC_USED_MEMORY_PERCENTAGE_REMOTE = 0.28f;
    public static final int DEFAULT_SDRAM_PHOTO_NUM = 60;
    public static final String DELETE_EMOTION_PACKAGE = "c/e/meme/delPackage";
    public static final String DEL_POST_ADDRESS = "c/c/bawu/delpost";
    public static final String DEL_THREAD_ADDRESS = "c/c/bawu/delthread";
    public static final String DEL_TOKEN_INFO = "c/s/delTokenInfo";
    public static final String DETECT_USERNAME_ADDRESS = "c/s/detectuname";
    public static final String DO_DAILY_TASK = "c/c/encourage/member/doDailyTask";
    public static final String DRESSUP_CENTER_PAGE = "c/e/theme/getThemeList";
    public static final String EARN_MONEY = "https://gamecenter.baidu.com/single/beeplaying?productid=7&gtype=1&channel=100073&actionmode=&idfrom=tieba-gamecenter-top";
    public static final String EMOTION_DETAIL = "/c/e/meme/detail";
    public static final int EMOTION_HEIGHT = 240;
    public static final int EMOTION_HEIGHT_LOW = 160;
    public static final int EMOTION_WIDTH = 240;
    public static final int EMOTION_WIDTH_LOW = 160;
    public static boolean ENABLE_VISIT_PREVIEW_SERVER_DIALOG = false;
    public static final String ENTERTAINMENT_ADDRESS = "lego/lego";
    public static final String ERROR_UPLOAD_SERVER = "c/s/logupload";
    public static final String EXCHANGE_MALL = "https://tieba.baidu.com/mo/q/hybrid-main-user/exchangeShop?customfullscreen=1&nonavigationbar=1";
    public static final String FATAL_ERROR_ALERT_FILE = "fatal_error_alert.log";
    public static final String FATAL_ERROR_DEBUG_FILE = "fatal_error_debug.log";
    public static final String FATAL_ERROR_FILE = "fatal_error.log";
    public static final long FATAL_ERROR_FILE_MAX_SIZE = 204800;
    public static final String FATAL_ERROR_NATIVE_DIR = "native_crash";
    public static final String FINE_PB_PAGE = "c/f/excellent/excpbpage";
    public static final String FINE_PB_PRAISE = "c/f/excellent/exczan";
    public static final String FINISH_MEMBER_TASK = "c/c/encourage/point/finishmembertask";
    public static final String FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/voice_fin_chunk_upload";
    public static final String FOLLOW_ADDRESS = "c/c/user/follow";
    public static final String FOLLOW_ERR_URL = "c/c/user/correctFollowError";
    public static final int FONT_SIZE_BIG = 1;
    public static final int FONT_SIZE_MID = 2;
    public static final int FONT_SIZE_SMALL = 3;
    public static final int FONT_SIZE_XLAGER = 0;
    public static final String FORBID_USER_ADDRESS = "c/c/bawu/commitprison";
    public static final String FORTUNE_ADDRESS = "mo/q/fudaiindex";
    public static final String FORUM_RULES_SHOW = "c/f/forum/forumRuleDetail";
    public static final String FORUM_SQUARE = "c/f/forum/forumsquare";
    public static final String FRIEND_AND_STRANGER_MSG_SWITCH = "c/c/friend/setMsgMask";
    public static String FRIEND_PHOTO_ADDRESS = null;
    public static String FROM = null;
    public static final String FROM_FILE = "from.dat";
    public static final String FRS_ADDRESS = "c/f/frs/page";
    public static final String FRS_COMMON_TAB = "c/f/frs/generalTabList";
    public static final String FRS_DYNAMIC_ADDRESS = "c/f/frs/starTrends";
    public static final String FRS_LIVE_TIP_ADDRESS;
    public static final String GET_AIBOT_APPLY_INTERNAL = "c/c/aigc/applyWhitelist";
    public static final String GET_AIBOT_CHAT_DETAIL = "c/f/aichat/getChatDetail";
    public static final String GET_BAWU_INFO = "c/f/forum/getBawuInfo";
    public static final String GET_BAZHU_NOTICE_REDPOT = "c/c/bawu/setBawuNoticeRead";
    public static String GET_BFB_INFO = null;
    public static final String GET_CARD_DETAIL = "c/e/theme/getCard";
    public static final String GET_CHANNEL_ADDRESS = "c/s/channelIconConfig";
    public static final String GET_CHAT_GROUP_ROOM_LIST = "c/f/chat/getRoomListByFid";
    public static final String GET_CHAT_ROOM_DETAIL = "c/f/chat/getChatRoomDetail";
    public static final String GET_CHAT_ROOM_INIT_INFO = "c/f/chat/getChatRoomInitInfo";
    public static final String GET_DEFAULT_GIFT_LIST = "c/e/present/getGiftList";
    public static final String GET_FEEDBACK_TIP = "mo/q/msg/remindnumber";
    public static final String GET_FESTIVAL_TASK_REPORT = "c/s/commitFestivalTask";
    public static final String GET_FORBIDDEN_FANS = "c/u/fans/blockPage";
    public static final String GET_FORUM_DETAIL = "c/f/forum/getforumdetail";
    public static final String GET_FRIEND_AND_STRANGER_MSG_SWITCH = "c/u/user/getMsgMask";
    public static final String GET_GIFT_LIST_BY_CATEGORY = "c/e/present/getGiftListByCategoryId";
    public static final String GET_HOMEPAGE_REC_FORUM_INFO = "c/f/excellent/getBackRecommendForum";
    public static final String GET_HOT_FORUM_URL = "c/f/forum/hotforum";
    public static final String GET_IMAGE_WATERMARK_TYPE = "c/u/user/getWatermark";
    public static final String GET_IP_LIST = "c/s/getipinfo";
    public static final String GET_LEVEL_INFO_URL = "c/f/forum/getLevelInfo";
    public static final String GET_MEMBER_INFO = "c/f/forum/getMemberInfo";
    public static final String GET_MEMBER_TASK = "c/e/point/getmembertasklist";
    public static final String GET_MY_POST = "c/f/frs/getmypost";
    public static final String GET_NEW_PACKAGE_DETAIL = "c/e/meme/meme";
    public static final String GET_ORDER = "c/e/mema/getOrder";
    public static final String GET_PACKAGE_DETAIL = "c/e/faces/getfacelist";
    public static final String GET_PACKAGE_DOWNLOAD_URL = "c/e/faces/dpack";
    public static final String GET_PAY_CONFIG = "c/s/getClientConfig";
    public static final String GET_PERSONAL_CARD_BY_CATEGORY = "c/e/theme/getCardByCategory";
    public static final String GET_PERSONAL_GIFT_LIST = "c/e/present/getMyGift";
    public static final String GET_POLLING_DATA = "c/s/loop";
    public static final String GET_PRIVATE_INFO = "c/u/user/getPrivateInfo";
    public static final String GET_PUSH_DIALOG_DETAIL = "c/s/getLockWindowMsg";
    public static final String GET_PUSH_DIALOG_TID = "c/s/getLockWindowTid";
    public static final String GET_QM_FILTERS = "c/f/video/qmFilters";
    public static final String GET_QM_STICKERS = "c/f/video/qmStickers";
    public static final String GET_RELATIVE_MEME_LIST = "c/f/chat/getRelativeMemeList";
    public static final String GET_STICKERS = "c/f/video/sticker";
    public static final String GET_SUBSCRIBE_GROUP_CHAT_LIST = "c/u/chat/getChatSubscriptionList";
    public static final String GET_SUGGEST_LOCATION_BY_NAME = "c/s/getSuggestionByAddrName";
    public static final String GET_TRACK_CONFIG = "c/s/trackConfig";
    public static final String GET_USER_FREE_CHANCE = "c/e/present/getUserFreeChance";
    public static final String GET_USER_INFO = "c/u/user/getuserinfo";
    public static final String GET_USER_ORDER = "c/e/consume/getUserOrder";
    public static final String GET_VIDEO_ACTIVITY = "c/f/video/getActList";
    public static final String GET_YINJI_TASK_REPORT = "c/c/user/commitUGTaskInfo";
    public static final String GIFT_PLACE_ORDER = "c/c/encourage/present/placeOrder";
    public static final String GOOD_LIST_ADDRESS = "c/c/bawu/goodlist";
    public static final String GROUP_HEAD_FILE = "tieba_group_image";
    public static final String GUIDE_INTERESTED_FORUM_URL = "c/f/forum/getVerticalForumList";
    public static final String GUIDE_INTEREST_COMMIT_URL = "c/s/newUserInterestSave";
    public static final int HEAD_IMG_SIZE = 960;
    public static final String HOME_FORUM_FEED_LIST = "c/u/feed/forum";
    public static final String HOME_REALTIME_ADDRESS = "c/f/excellent/realtime";
    public static final String HOT_USER_RANK_URL = "c/f/forum/getInfluenceRank";
    public static final String HTTPS_FRS_PREFIX;
    public static final String HTTPS_LIVE_SHARE_PREFIX = "https://tieba.baidu.com/ala/share";
    public static final String HTTPS_PB_PREFIX;
    public static final String HTTPS_PREFIX;
    public static String HTTPS_QUICK_WEBVIEW_PREFIX = null;
    public static final String HTTPS_YY_LIVE_SHARE_PREFIX = "https://web.yy.com/bd_liveroom_share/invoke.html?hostid=5&livesid=";
    public static final String HTTP_PB_PREFIX;
    public static final String HTTP_PREFIX;
    public static final String IMAGE_ADDRESS;
    public static final String IMAGE_CACHE_DIR_NAME = "images";
    public static final String IMAGE_PB_ADDRESS = "c/f/pb/picpage";
    public static final int IMAGE_PV_COUNT = 100;
    public static final String IMAGE_RESIZED_FILE = "tieba_resized_image";
    public static final String IMAGE_RESIZED_FILE_DISPLAY = "tieba_resized_image_display";
    public static final float IMAGE_ROUND = 10.0f;
    public static final String INCR_FORUM_ACCESS_ACOUNT = "c/c/forum/incrForumAccessCount";
    public static final String IN_PV_ADDRESS = "c/s/inpv";
    public static boolean IS_CHECK_OFFICAL_APPLICATION = false;
    public static boolean IS_START_BAIDU_KUANG_CLOSE_SELF = false;
    public static final String ITEM_MANAGE = "c/f/forum/itemManage";
    public static final String ITEM_PAGE = "c/f/forum/itemPage";
    public static final String JUMP_TO_NEW_USER_CHOOSE_BAR = "c/u/user/getuserlike";
    public static final boolean LBSSWITCH = true;
    public static final String LCS_STATISTICS_URL = "c/s/lcslog";
    public static String LEGO_LIB_VERSION = null;
    public static final String LIKE_ADDRESS = "c/c/forum/like";
    public static final String LOAD_REG_PV_ADDRESS = "c/s/pv";
    public static final String LOCAL_CAMERA_DIR = "cameras";
    public static final String LOCAL_PIC_DIR = "photos";
    public static String LOGIN_FULL_ADDRESS = null;
    public static final String LOG_ERROR_FILE = "log_error.log";
    public static final String LOG_SYNC_SWITCH = "http://tb1.bdstatic.com/tb/client/logsync3.js";
    public static final String LOG_TOGETHER = "c/s/logtogether";
    public static final String LOG_UPLOAD_URL = "c/s/newlog";
    public static final int MAINTAB_NO_INTEREST = 1;
    public static final String MANAGE_ADDRESS;
    public static final String MARK_ADDSTORE = "c/c/post/addstore";
    public static final String MARK_DELSTORE = "c/c/post/rmstore";
    public static final String MARK_GETSTORE = "c/f/post/threadstore";
    public static final int MAX_ACTIVITY_STACK_SIZE = 20;
    public static final int MAX_EMOTION_COUNT = 10;
    public static final int MAX_FRS_ICON_NUM = 3;
    public static final int MAX_PB_ICON_NUM = 4;
    public static final int MAX_PERSON_INFO_ICON_NUM = 9;
    public static int MAX_PHOTO_MEMORY_CACHE = 0;
    public static int MAX_PHOTO_MEMORY_CACHE_REMOTE_PROCESS = 0;
    public static final float MAX_PIC_USED_MEMORY_PERCENTAGE = 1.0f;
    public static final int MAX_PRELOAD_PHOTO_NUM = 30;
    public static final int MAX_PRELOAD_PIC_NUM = 13;
    public static final int MAX_QUESTION_PB_USER_NAME_BYTE_LENGTH = 20;
    public static final int MAX_SDRAM_PIC_NUM = 13;
    public static final int MAX_TSHOW_ICON_NUM = 2;
    public static final int MAX_USER_NAME_BYTE_LENGTH = 14;
    public static final int MAX_WEBVIEW_CRASH_COUNT_NEWVCODE_VIEW = 3;
    public static final String MEMBERCENTERE_INDEX_PAGE = "c/e/member/getVipInfo";
    public static final String MEMBER_AUTO_RENEWAL_URL = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html?_client_version=12.17.2&source=12_16_sharecard_a";
    public static final String MEMBER_PAY = "c/e/pay/andmember";
    public static final String MERCATOR_LOCATION_URL = "c/s/getMercatorByLocation";
    public static long MILLS_7DAYS = 0;
    public static final String MORE_TREASURE_TROVE = "c/f/forum/moreTreasureTrove";
    public static final int MSG_DEFAULT_FREQUENCY = 300;
    public static final String MSG_DEFAULT_NODISTURB_END_TIME = "07:00";
    public static final String MSG_DEFAULT_NODISTURB_START_TIME = "23:00";
    public static final boolean MSG_DEFAULT_NODISTURB_SWITCH = false;
    public static final String MULTI_DEL_POST_ADDRESS = "c/c/bawu/multiDelPost";
    public static final int MUTI_IMAGE_MAX_COUNT = 9;
    public static final String NANI_DEFAULT_H5_PREFIX = "https://nani.baidu.com/n/nani/share/tieba";
    public static final int NAVI_STATE_EDIT = 2;
    public static final int NAVI_STATE_SEARCH = 0;
    public static final int NAVI_STATE_SIGN = 1;
    public static final String NEG_DELETE_THREAD = "c/c/bawu/multiDelThread";
    public static final String NEG_FEED_BACK = "c/c/excellent/submitDislike";
    public static final int NET_MSG_GETLENTH = 900002;
    public static final int NEW_FRAME_MUTI_IMAGE_MAX_COUNT = 9;
    public static final String NEW_USER_GET_MONEY_URL;
    public static final int NOTIFY_AGREE_ME_ID = 29;
    public static final int NOTIFY_AT_ME_ID = 25;
    public static final int NOTIFY_CHAT_ID = 16;
    public static final int NOTIFY_FANS_NEW_ID = 26;
    public static final int NOTIFY_GIFT_ID = 23;
    public static final int NOTIFY_GROUP_EVENT = 18;
    public static final int NOTIFY_GROUP_ID = 17;
    public static final int NOTIFY_MY_COLLECT_UPDATE = 28;
    public static final int NOTIFY_OFFICIAL_MESSAGE = 19;
    public static final int NOTIFY_OFFICIAL_NOTIFICATION_TAB = 30;
    public static final int NOTIFY_PUSH_ID = 15;
    public static final int NOTIFY_RECOMMEND_MESSAGE_ID = 13;
    public static final int NOTIFY_REMIND_RECOMMEND = 2000;
    public static final int NOTIFY_REPLY_ME_ID = 24;
    public static final int NOTIFY_SIGN_ID = 12;
    public static final long NOTIFY_SOUND_INTERVAL = 5000;
    public static final int NOTIFY_SPORT_MATCH = 2001;
    public static final int NOTIFY_YUN_PUSH = 2500;
    public static String NOVEL_PAY = null;
    public static final long ONE_DAY_TIME = 86400000;
    public static final int PB_BJH_REPLY_MUTI_IMAGE_MAX_COUNT = 1;
    public static final String PB_CARD_GIFT_GET_URL = "tbmall/businessCard/getCardForGame";
    public static final String PB_FLOOR_AGREE_URL = "c/c/agree/opAgree";
    public static final int PB_IMAGE_DIP_MAX_WIDTH = 427;
    public static final int PB_IMAGE_MAX_HEIGHT = 105;
    public static final int PB_IMAGE_MAX_WIDTH = 105;
    public static final int PB_IMAGE_NEW_MAX_WIDTH = 640;
    public static final float PB_IMAGE_NEW_SCALE = 1.6f;
    public static final int PB_MAX_PRELOAD_PIC_NUM = 3;
    public static final String PB_MORE_GOD_REPLY_URL = "/c/f/pb/getPostList";
    public static final int PB_PHOTO_MAX_SIZE = 80;
    public static final int PB_REPLY_MUTI_IMAGE_MAX_COUNT = 9;
    public static final String PEIWAN_SES = "/peiwan/api/user/letter/ses";
    public static final String PERSONAL_BACKGROUND_GET = "c/e/theme/getBackground";
    public static final String PERSONAL_BACKGROUND_GROUP_PAGE = "c/e/theme/getBgByCategory";
    public static final String PERSONAL_BACKGROUND_LIST_PAGE = "c/e/theme/getBgList";
    public static final String PERSONAL_BACKGROUND_SET = "c/e/theme/setBackground";
    public static final String PERSON_CENTER_DYNAMIC_TAB_URL = "c/u/user/getShoubaiThreadList";
    public static final String PERSON_HEAD_FILE = "tieba_head_image";
    public static final String PERSON_USER_PIC_TEMP_FILE = "tieba_user_pic_temp_image";
    public static final String PHONE_DATEBASE_NAME = "baidu_tieba.db";
    public static String PHOTO_BIG_ADDRESS = null;
    public static final int PHOTO_DELAY_TIME = 90;
    public static String PHOTO_SMALL_ADDRESS = null;
    public static final int POST_IMAGE_BIG = 2000;
    public static final int POST_IMAGE_DISPLAY = 100;
    public static final int POST_IMAGE_HIGHT_LIMIT = 18000;
    public static final int POST_IMAGE_MIDDLE = 1800;
    public static final int POST_IMAGE_QUALITY = 85;
    public static final int POST_IMAGE_SMALL = 1300;
    public static final String POST_SEARCH_URL = "c/s/searchpost";
    public static final String POST_THREAD_ADDRESS = "c/c/thread/add";
    public static final String POST_THREAD_FOR_SHARE_ADDRESS = "c/c/thread/sdkshare";
    public static int PREFETCH_NEXT_VIDEO_NUM = 0;
    public static int PREFETCH_NEXT_VIDEO_SIZE = 0;
    public static final String PRIVACY_DETAIL_URL = "https://tieba.baidu.com/tb/mobile/wisemainstatic/privacy.html";
    public static final String PRODUCT_NO = "1000002";
    public static final String PROFILE_HEAD_MODIFY = "c/c/img/portrait";
    public static final boolean PROMOTED_DEFAULT = true;
    public static final String QUERY_BUY_RESULT_URL = "c/e/faces/querybuyresult";
    public static final String QUESTION_THREAD_CREATE_TAG = "c/c/tag/addContentTag";
    public static final String QUESTION_THREAD_LIST;
    public static final String QUESTION_THREAD_RULE;
    public static final String QUESTION_THREAD_TAG_LIST = "c/f/forum/getForumRecomTagList";
    public static final int READ_GIF_CACHE_TIMEOUT_WIFI = 500;
    public static final int READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI = 2000;
    public static final int READ_IMAGE_CACHE_TIMEOUT_WIFI = 300;
    public static final String RECOMMEND_HOME_PAGE_ADDRESS = "c/f/excellent/personalized";
    public static final String RELEVANCE_ITEM_SEARCH_URL = "c/f/forum/itemSearchList";
    public static final String REMOVE_MULTI_FANS = "c/c/user/multiRemoveFans";
    public static final String REPLY_THREAD_ADDRESS = "c/c/post/add";
    public static final String REQUEST_FOLLOWED_FRS_LIST = "c/f/chat/commonChannel";
    public static final String REQUEST_SPRITE_CREATE_MEME = "c/c/chatroom/createMeme";
    public static final String REQUEST_SPRITE_LOOP = "c/f/sprite/getSpriteSpeech";
    public static final String REQUEST_SPRITE_QUERY_MEME = "c/f/chat/queryMeme";
    public static final String REQUEST_SPRITE_QUESTION_REPLY = "c/f/sprite/getSpriteBottomChat";
    public static final String SEARCH_FRIEND = "c/r/friend/searchFriend";
    public static final String SEARCH_POST_FORUM = "c/f/forum/searchPostForum";
    public static final String SEND_FREE_GIFT = "c/c/encourage/present/sendFreeGift";
    public static String SERVER_ADDRESS = null;
    public static String SERVER_ADDRESS_WEB_VIEW = null;
    public static final String SERVER_GAME_PLAY_ADRESS = "https://peiwan.baidu.com";
    public static final String SET_COMMON_FORUM_STATE = "c/c/forum/setCommonForumState";
    public static final String SET_HOTSELECT = "c/f/recommend/getSugTopic";
    public static final String SET_IMAGE_WATERMARK_TYPE = "c/c/user/setWatermark";
    public static final String SET_MEMBER_CLOSE_AD = "c/c/encourage/member/closeAd";
    public static final String SET_PENDANT = "c/c/encourage/theme/setPendant";
    public static final String SET_PERSONAL_CARD = "c/c/encourage/theme/setCard";
    public static final String SET_PRIVATE = "c/c/friend/setprivate";
    public static String SET_USER_PICS = null;
    public static final String SHARE_CONTENT_TO_CHAT_GROUP_ROOM = "c/c/chatroom/shareCard";
    public static final String SHARE_HUB_DIR_NAME = "share_hub";
    public static final String SIGN_ADDRESS = "c/c/forum/sign";
    public static final String SQUARE_SEARCH_PAGE = "mo/q/hybrid/search?keyword=";
    public static final String STAT_CLIENT_START = "c/c/forum/statClientStartTimes";
    public static final String ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK = "1";
    public static final String ST_TYPE_ENTER_FORE = "enter_fore";
    public static final String ST_TYPE_PCHAT = "pchat";
    public static final String ST_TYPE_USE = "use";
    public static String SUBAPP_TYPE = null;
    public static final int SUBPB_FONT_SIZE_BIG;
    public static final int SUBPB_FONT_SIZE_MID;
    public static final int SUBPB_FONT_SIZE_SMALL;
    public static final int SUBPB_FONT_SIZE_XLAGER;
    public static String SUB_VERSION = null;
    public static final String SW_APID = "sw";
    public static final String SYNC_ACTIVE = "sync_active";
    public static final String TAIL_ADD = "c/u/tail/addTail";
    public static final String TAIL_DELETE = "c/u/tail/deleteTail";
    public static final String TAIL_GET = "c/u/tail/getTails";
    public static final String TAIL_SET = "c/u/tail/setTail";
    public static final String TAIL_UPDATE = "c/u/tail/updateTail";
    public static final int THREAD_GIF_MIN_USE_MEMORY = 6291456;
    public static int THREAD_IMAGE_MAX_WIDTH = 0;
    public static String TIEBA_ADDRESS = null;
    public static String TMPDIRNAME = null;
    public static final String TMP_ALA_IM_RECORD_DIR_NAME = "imRecord";
    public static final String TMP_DATABASE_NAME = "tieba_database.db";
    public static final String TMP_PIC_DIR_NAME = "image";
    public static final String TMP_SHARE_DIR_NAME = "share";
    public static final String TMP_VOI_DIR_NAME = "voice";
    public static final String TRACK_LOG_UPLOAD_URL = "c/s/trackLog";
    public static final int TYPE_DAILY_BUILD = 1;
    public static final int TYPE_GRAY_BUILD = 2;
    public static final int TYPE_RELEASE_BUILD = 3;
    public static final int TYPE_UNKNOWN_BUILD = -1;
    public static final String UNFAVOLIKE_ADDRESS = "c/c/forum/unfavolike";
    public static final String UNFOLLOW_ADDRESS = "c/c/user/unfollow";
    public static final String UPDATE_CHAT_ROOM_DETAIL = "c/f/chat/getChatroomResource";
    public static final long UPDATE_NOTIFY_INTERVAL = 86400000;
    public static final String UPDATE_SIGN_DATA = "c/c/user/setSignMask";
    public static final String UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/chunkupload";
    public static final int UPLOAD_IMAGE_QUALITY_AUTO = 0;
    public static final int UPLOAD_IMAGE_QUALITY_HIGH = 1;
    public static final int UPLOAD_IMAGE_QUALITY_LOW = 3;
    public static final int UPLOAD_IMAGE_QUALITY_MID = 2;
    public static String UPLOAD_IMG_URL = null;
    public static final String URL_ACTIVE_CONFIG = "c/s/activeConfig";
    public static final String URL_ADD_EXPERIENCED = "c/c/forum/share";
    public static final String URL_AD_BILLING_LOG = "c/s/adNewLog";
    public static final String URL_ALA_LIVE_ROOM_CLOSED = "ala/live/mgetLiveStatus";
    public static final String URL_APPLY_COPY_THREAD = "c/c/livegroup/applycopythread";
    public static final String URL_BACK_USER = "c/c/user/backUser";
    public static final String URL_BAIDU_SINGKIL = "https://eopa.baidu.com/page/HomePage-YW54iXYf?channel=7";
    public static final String URL_BJH_REPORT = "https://ufosdk.baidu.com/?m=Client&a=commonreport&appid=234410&nid=%1$s&platid=%2$s&remark=bjh";
    public static final String URL_CALL_FANS = "god/rights/callFans";
    public static final String URL_CALL_ROBOT_ROUTER = "c/c/chatroom/callRobotRouter";
    public static final String URL_CANCEL_FORBIDDEN_FORUM = "c/c/excellent/submitCancelDislike";
    public static final String URL_CANDIDATE_SEARCH = "c/f/bawu/search";
    public static final String URL_CHAT_ROOM = "https://tieba.baidu.com/mo/q/wise-bawu-core/group-chat-manage?fr=room&customfullscreen=1&nonavigationbar=1";
    public static final String URL_CHECK_REAL_NAME = "c/s/checkRealName";
    public static final String URL_CHECK_SHOW_INIT_NAME_DIALOG = "c/s/initNickname";
    public static final String URL_CHECK_VIDEO_STATUS = "c/c/video/uploadVideoStatus";
    public static final String URL_COMMIT_CARD_INFO = "c/c/bawu/commitCardInfo";
    public static final String URL_CONCERN_PAGE = "c/f/concern/userlike";
    public static final String URL_CREATE_CENTER = "https://tieba.baidu.com/mo/q/creativeCenter";
    public static final String URL_CREATE_COLLEGE = "https://tieba.baidu.com/mo/q/creativeCenter?local=college";
    public static final String URL_DELETE_REPLY_AT_MSG = "c/c/post/delmsg";
    public static final String URL_DELETE_USER_DATA = "c/c/user/delAllUserData";
    public static final String URL_ENTER_FORUM_AD = "c/f/forum/getAdInfo";
    public static final String URL_EXCELLENT_ROOM = "https://tieba.baidu.com/mo/q/wise-bawu-core/group-chat-manage?customfullscreen=1&nonavigationbar=1#/essence";
    public static final String URL_EXCEPTION_REPORT;
    public static final String URL_FEED_BACK = "https://ufosdk.baidu.com/ufosdk/postview/tSi1tVlylkKfcPzxh%2FBspQ%3D%3D/222251";
    public static final String URL_FORUM_BROADCAST_HISTORY = "c/f/forum/getForumBroadcastList";
    public static final String URL_FORUM_BROADCAST_RESIDUE = "c/f/forum/getForumMangerRights";
    public static final String URL_FORUM_LEVEL_H5_PAGE = "https://tieba.baidu.com/mo/q/wise-bawu-core/forum-level?customfullscreen=1&nonavigationbar=1";
    public static final String URL_FORUM_MANAGER_APPLY = "https://tieba.baidu.com/mo/q/managerapply/newapplyelection?nomenu=1&fid=";
    public static final String URL_FORUM_RULES_COMMIT = "c/c/bawu/editForumRule";
    public static final String URL_FORUM_RULES_DRAFT = "c/f/forum/forumRuleDraft";
    public static final String URL_FORUM_SQUARE = "c/f/forum/getForumSquare";
    public static final String URL_FRS_BUSINESS_PROMOT_CLICK = "c/e/businessPromot/counter";
    public static final String URL_FRS_LIVE_HORSERACE_LIST = "c/f/forum/getHorseRaceLampList";
    public static final String URL_FRS_MOVE_AREA = "c/c/bawu/moveTabThread";
    public static final String URL_FRS_RECOMMEND = "c/c/bawu/pushRecomToPersonalized";
    public static final String URL_FUN_AD_RECORD = "c/s/adLog";
    public static final String URL_GAME_RANK_STATEMENT = "https://gamecenter.baidu.com/static/game/tb-list-activity.html";
    public static final String URL_GAME_VIDEO = "c/f/excellent/recomVertical";
    public static final String URL_GETPAYINFO = "c/e/mema/getpayinfo";
    public static final String URL_GET_DEEPLINK_SCHEME = "c/s/getDeeplinkScheme";
    public static final String URL_GET_FORBIDDEN_FORUM = "c/u/user/getDislikeList";
    public static final String URL_GET_FORUM_MANAGER_RIGHTS = "c/f/forum/getForumMangerRights";
    public static final String URL_GET_GAME_CODE = "c/c/item/giveOutGameCode";
    public static final String URL_GET_HOT_RANKLIST_DATA = "c/f/recommend/topicList";
    public static final String URL_GET_HOT_TOPIC_DATA = "c/f/recommend/hottopic";
    public static final String URL_GET_HOT_TOPIC_TAB = "c/f/forum/hotThreadList";
    public static final String URL_GET_INTEREST_LABEL_LIST = "c/f/recommtag/getTagList";
    public static final String URL_GET_RECOMMEND_TOPIC = "c/f/recommend/getRecommendTopic";
    public static final String URL_GET_SKILL_SUG_LIST = "c/f/chat/getSkillSugList";
    public static final String URL_GET_STICKER_LIST = "c/f/story/getSticker";
    public static final String URL_GET_TAB_TOPIC_LIST = "c/f/recommend/newtopiclist";
    public static final String URL_GET_TOKEN = "c/s/getToken";
    public static final String URL_GET_TOPIC_DETAIL = "c/f/recommend/newhottopic";
    public static final String URL_GET_TOPIC_RELATE_THREAD = "c/f/recommend/getTopicRelateThread";
    public static final String URL_GET_TOPIC_THREAD = "c/f/recommend/newtopicthread";
    public static final String URL_GET_USER_BLOCK_INFO = "c/u/user/getUserBlackInfo";
    public static final String URL_GET_USER_BY_TIEBA_UID = "c/u/user/getUserByTiebaUid";
    public static final String URL_GET_USER_LIST = "c/u/follow/getFoldedMessageUserInfo";
    public static final String URL_GET_VIDEO_INFO_BY_VLOGID = "/c/f/video/getVideoInfoByVLogId";
    public static final String URL_GET_WORKS_TAGS = "c/f/video/getWorksTags";
    public static final String URL_GOD_AUTH = "https://tieba.baidu.com/mo/q/hybrid/godGuide?customfullscreen=1&nonavigationbar=1&skin=";
    public static final String URL_GOD_EXAMINE = "https://tieba.baidu.com/mo/q/hybrid/godCheck?customfullscreen=1&nonavigationbar=1&skin=";
    public static final String URL_HISTORY_SWAN = "c/s/historySwan";
    public static final String URL_HOT_ACTIVITIES = "https://tieba.baidu.com/mo/q/creativeCenter?local=hots";
    public static final String URL_IMAGE_PREFIX = "https://tiebac.baidu.com/c/p/img?src=";
    public static final String URL_JUMP_TAG_CARDBOX = "https://tieba.baidu.com/mo/q/packetpage/myPacket?tieba_hybrid_enabled=1";
    public static final String URL_JUMP_TAG_WALLET = "http://www.bdwallet.activity";
    public static final String URL_JUMP_YY_LIVE_IN_VIDEO_LIST = "c/f/video/gotoLive";
    public static final String URL_MEMBER_BUY;
    public static final String URL_MOOV_REPORT = "c/c/video/reportSlowStart";
    public static final String URL_PLAY_DURATION_STATISTICS = "c/c/video/playDura";
    public static final String URL_PLAY_STATISTICS = "c/c/video/playStat";
    public static final String URL_POST_VIDEO_MONITOR_REPORT = "ala/sys/vtlog";
    public static final String URL_RECOMMEND_SETTING = "https://tieba.baidu.com/mo/q/hybrid-main-service/pushSettings";
    public static final String URL_RELATE_REC_THREAD = "c/f/forum/relateRecThread";
    public static final String URL_REMOVE_FANS = "c/c/user/removeFans";
    public static String URL_REQUEST_PID = null;
    public static final String URL_SET_PRIVACY = "c/c/thread/setPrivacy";
    public static final String URL_SHARE_COMMAND_GENERATE = "mo/q/schemeToken";
    public static final String URL_SHARE_REPORT = "c/c/thread/share";
    public static final String URL_SHARE_SUCCESS_TO_REPLY_SERVER = "/c/c/video/share";
    public static final String URL_SMART_APP_BROWSE_HISTORY = "c/c/smartapp/view";
    public static final String URL_SMART_APP_DEL_BROWSE_HISTORY = "c/c/smartapp/delView";
    public static final String URL_SMART_APP_SHARE_IMAGE = "c/c/img/getShareImg";
    public static final String URL_STATISTICS_REPORT;
    public static final String URL_SUB_INTEREST_LABEL_LIST = "c/f/recommtag/subTagList";
    public static final String URL_SWITCH_YY_CURRENCY = "c/s/yyConvert";
    public static final String URL_TAB_ACTIVITY_TAB = "c/f/forum/activityPage";
    public static final String URL_TAB_FEED_LIST = "c/f/forum/tabfeedlist";
    public static final String URL_THEME_CENTER;
    public static final String URL_THREAD_PUBLISH = "c/c/bawu/threadPublish";
    public static final String URL_TOPIC_USER_PK = "c/f/recommend/userPk";
    public static final String URL_UEG_REPORT = "c/f/ueg/checkjubao";
    public static final String URL_UEG_SERVICE_CENTER;
    public static final String URL_UPLOAD_DOWNLOAD_INFO = "c/s/appDownloadLog";
    public static final String URL_UPLOAD_OFFLINE_PACK = "c/c/user/uploadOfflinePack";
    public static final String URL_UPLOAD_OFFLINE_PACK_STATUS = "c/c/user/updateOfflinePackTask";
    public static final String URL_UPLOAD_VIDEO = "c/c/video/uploadVideoData";
    public static final String URL_URL_PARSER = "c/s/urlParser";
    public static final String URL_USER_BLOCK_SET = "c/c/user/setUserBlack";
    public static final String URL_USER_REPORT = "c/c/user/complaint";
    public static final String URL_VIDEO_HOLY_CARD = "c/s/dashengVideo";
    public static final String URL_VIDEO_MONITOR_REPORT = "c/c/video/vlog";
    public static final String URL_VIDEO_TAB = "c/f/excellent/recomVideo";
    public static final String URL_WELFARE = "https://gamecenter.baidu.com/static/game/tb-welfare.html";
    public static final String URL_WORKS_INFO = "https://tieba.baidu.com/mo/q/wise-creative-core/guide";
    public static final String URL_WORK_VIDEO_GUIDE = "c/c/video/upGradeVideoUp";
    public static final String URL_YOUNGSTER_VERIFY_AUTHID = "c/c/user/passAuthidVerify";
    public static final String USER_GROWTH_APPLY_ALI_AUTH_INFO_URL;
    public static final String USER_GROWTH_GET_ALI_AUTH_INFO_URL;
    public static final String USER_GROWTH_GUIDE_MAIN_URL;
    public static final String USER_GROWTH_TASK_CENTER_MAIN_URL;
    public static final String USER_MUTE_ADD = "c/c/user/userMuteAdd";
    public static final String USER_MUTE_CHECK = "c/u/user/userMuteCheck";
    public static final String USER_MUTE_DEL = "c/c/user/userMuteDel";
    public static final String USER_MUTE_QUERY = "c/u/user/userMuteQuery";
    public static boolean USE_OLD_LOGIN = false;
    public static final int VALUE_COMMON_EMOTION_SIZE_BIG;
    public static final int VALUE_COMMON_EMOTION_SIZE_MID;
    public static final int VALUE_COMMON_EMOTION_SIZE_SMALL;
    public static final int VALUE_COMMON_EMOTION_SIZE_XLAGER;
    public static final int VALUE_COMMON_FONT_LINE_SPACE_BIG;
    public static final int VALUE_COMMON_FONT_LINE_SPACE_MID;
    public static final int VALUE_COMMON_FONT_LINE_SPACE_SMALL;
    public static final int VALUE_COMMON_FONT_LINE_SPACE_XLAGRE;
    public static final int VALUE_COMMON_FONT_LINE_SPACE_XLONG;
    public static final int VALUE_COMMON_FONT_SIZE_BIG;
    public static final int VALUE_COMMON_FONT_SIZE_MID;
    public static final int VALUE_COMMON_FONT_SIZE_SMALL;
    public static final int VALUE_COMMON_FONT_SIZE_XLAGER;
    public static final int VALUE_OUTTER_SUBPB_FONT_SIZE_BIG;
    public static final int VALUE_OUTTER_SUBPB_FONT_SIZE_MID;
    public static final int VALUE_OUTTER_SUBPB_FONT_SIZE_SMALL;
    public static final int VALUE_OUTTER_SUBPB_FONT_SIZE_XLAGER;
    public static final int VALUE_POST_FONT_LINE_SPACE_BIG;
    public static final int VALUE_POST_FONT_LINE_SPACE_MID;
    public static final int VALUE_POST_FONT_LINE_SPACE_SMALL;
    public static final int VALUE_POST_FONT_LINE_SPACE_XLAGRE;
    public static final int VALUE_SUBPB_EMOTION_SIZE_BIG;
    public static final int VALUE_SUBPB_EMOTION_SIZE_MID;
    public static final int VALUE_SUBPB_EMOTION_SIZE_SMALL;
    public static final int VALUE_SUBPB_EMOTION_SIZE_XLAGER;
    public static final int VALUE_SUBPB_FONT_LINE_SPACE_BIG;
    public static final int VALUE_SUBPB_FONT_LINE_SPACE_MID;
    public static final int VALUE_SUBPB_FONT_LINE_SPACE_SMALL;
    public static final int VALUE_SUBPB_FONT_LINE_SPACE_XLAGRE;
    public static final int VALUE_SUBPB_FONT_SIZE_BIG;
    public static final int VALUE_SUBPB_FONT_SIZE_MID;
    public static final int VALUE_SUBPB_FONT_SIZE_SMALL;
    public static final int VALUE_SUBPB_FONT_SIZE_XLAGER;
    public static String VERSION = null;
    public static int VERSION_TYPE = 0;
    public static final String VIDEO_UPLOAD_BLOCK = "c/c/video/uploadBlock";
    public static final String VIDEO_UPLOAD_CHUNK = "c/c/video/uploadChunk";
    public static final String VIDEO_UPLOAD_FILE = "c/c/video/uploadFile";
    public static final int VIEW_IMAGE_QUALITY_AUTO = 0;
    public static final int VIEW_IMAGE_QUALITY_HIGH = 1;
    public static final int VIEW_IMAGE_QUALITY_HIGH_VALUE = 80;
    public static final int VIEW_IMAGE_QUALITY_LOW = 2;
    public static final int VIEW_IMAGE_QUALITY_LOW_VALUE = 45;
    public static final String VIRTUAL_IMAGE_MAIN_URL;
    public static final String VOICE_CACHE_DIR_NAME = "voice";
    public static final int VOICE_CHUNK_UPLOAD_SIZE = 30720;
    public static final String VOICE_DATA = "c/p/voice";
    public static String VOTE_ADD = null;
    public static final String VOTE_EMOTION_PACKAGE = "c/e/meme/commitVote";
    public static final int WEBP_FAILURE_MAX = 5;
    public static final String WEBVIEW_CACHE_URL = "c/s/getWebviewCacheInfo";
    public static final String WEB_URL_FANS;
    public static final String WEB_URL_TDOU_UEG;
    public static final String WEB_VIEW_JUMP2NATIVE = "jump_tieba_native=1";
    public static final String WEB_VIEW_NEED_FRESH = "need_fresh=1";
    public static final String WEIXIN_APP_ID = "wxdd0912f3a78239c8";
    public static final String WEIXIN_PARTNER_ID = "1219850201";
    public static final String WEIXIN_SHARE_APP_ID = "wx289a8c58bca4c71e";
    public static final String api_key = "GXGROE8KmWiRmcWFpiWTmUbE";
    @Nullable
    public static String cachedFeedBackUrl = null;
    public static final String gamePlayIndexBanner = "/peiwan/api/index/service";
    public static final String push_app_id = "1095821";
    public static boolean sThreadImageMaxInited;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int getBigEmotionsSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return 230400;
        }
        return invokeV.intValue;
    }

    public static final String getBroadcastActionChangeSharedPref() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? BROADCAST_CHANGE_SHARED_PREF : (String) invokeV.objValue;
    }

    public static final String getBroadcastActionChangeSkin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? BROADCAST_CHANGESKIN : (String) invokeV.objValue;
    }

    public static final String getBroadcastActionImageResized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? BROADCAST_IMAGE_RESIZED : (String) invokeV.objValue;
    }

    public static final String getBroadcastActionNewVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? BROADCAST_NEWVERSION : (String) invokeV.objValue;
    }

    public static final String getBroadcastActionSignAlert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? BROADCAST_SIGN_ALERT : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static class DownFlowCmd {
        public static /* synthetic */ Interceptable $ic;
        public static HashSet<Integer> sInterruptCMDs;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1892494462, "Lcom/baidu/tbadk/TbConfig$DownFlowCmd;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1892494462, "Lcom/baidu/tbadk/TbConfig$DownFlowCmd;");
                    return;
                }
            }
            sInterruptCMDs = new HashSet<>();
            collectHttpCmd();
            collectSocketCmd();
        }

        public DownFlowCmd() {
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

        public static void collectHttpCmd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.PB_PLAY_STATISTICS_CMD));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.WEBVIEW_CACHE_INFO));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_UEG_CANCEL));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_GET_BIGDAY_INFO));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_GET_RN_SYNC));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CDN_IPLIST_CMD));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_GET_STORE_REMIND_TIME));
                sInterruptCMDs.add(Integer.valueOf((int) CmdConfigHttp.CMD_GET_USER_INFO));
            }
        }

        public static void collectSocketCmd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                sInterruptCMDs.add(303024);
                sInterruptCMDs.add(309609);
                sInterruptCMDs.add(309618);
                sInterruptCMDs.add(303005);
                sInterruptCMDs.add(309615);
                sInterruptCMDs.add(309485);
                sInterruptCMDs.add(309117);
                sInterruptCMDs.add(202101);
                sInterruptCMDs.add(303017);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class PassConfig {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String APP_ID = "1";
        public static final String CRIPT_TYPE = "1";
        public static final String ENC_KEY = "6e93e7659ae637845c7f83abee68a740";
        public static final String GET_CERT_URL = "http://passport.baidu.com/sslcrypt/get_last_cert";
        public static final String LOGIN_BDUSS_URL = "http://passport.baidu.com/v2/sapi/bdusslogin";
        public static final String OAUTH_OPEN_PLATFORM_ID = "Bxr73Efet8HjR5Tr0HqcgDKr";
        public static final String TPL = "tb";
        public transient /* synthetic */ FieldHolder $fh;

        public PassConfig() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-424364632, "Lcom/baidu/tbadk/TbConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-424364632, "Lcom/baidu/tbadk/TbConfig;");
                return;
            }
        }
        SERVER_ADDRESS = TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS;
        TIEBA_ADDRESS = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        MILLS_7DAYS = 604800000L;
        USE_OLD_LOGIN = false;
        ENABLE_VISIT_PREVIEW_SERVER_DIALOG = false;
        LOGIN_FULL_ADDRESS = SERVER_ADDRESS + "c/s/login";
        SERVER_ADDRESS_WEB_VIEW = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        WEB_URL_TDOU_UEG = TIEBA_ADDRESS + "mo/q/nativePayUeg?errorno=";
        WEB_URL_FANS = TIEBA_ADDRESS + "n/fans-party/prizeshow?nonavigationbar=1&from=native";
        ALPHA_80 = 80;
        cachedFeedBackUrl = null;
        DEFALT_USE_TIME_INTERVAL = 1L;
        MANAGE_ADDRESS = TIEBA_ADDRESS + "mo/q/bawuindex";
        BAWUTEAME_ADDRESS = TIEBA_ADDRESS + "mo/q/bawuteam";
        FRS_LIVE_TIP_ADDRESS = SERVER_ADDRESS + "ala/live/getLiveRemindInFrs";
        VERSION = "";
        SUB_VERSION = "";
        LEGO_LIB_VERSION = "1.0.0";
        SUBAPP_TYPE = "";
        FROM = null;
        THREAD_IMAGE_MAX_WIDTH = 640;
        sThreadImageMaxInited = false;
        VERSION_TYPE = -1;
        BitmapConfig = Bitmap.Config.RGB_565;
        TMPDIRNAME = "tieba";
        CURRENT_FROM = null;
        BIG_IMAGE_SIZE = 10240;
        BIG_IMAGE_MAX_USED_MEMORY = 1048576;
        PHOTO_SMALL_ADDRESS = "http://tb.himg.baidu.com/sys/portraitn/item/";
        PHOTO_BIG_ADDRESS = "http://tb.himg.baidu.com/sys/portrait/item/";
        FRIEND_PHOTO_ADDRESS = "http://tb.himg.baidu.com/sys/portraitn/item/";
        IMAGE_ADDRESS = SERVER_ADDRESS + "c/p/img?";
        UPLOAD_IMG_URL = SERVER_ADDRESS + "c/s/uploadPicture";
        URL_REQUEST_PID = SERVER_ADDRESS + "c/s/getPidByPicUrl";
        CHANGE_USER_PORTRAIT = SERVER_ADDRESS + "c/c/img/changeportrait";
        SET_USER_PICS = SERVER_ADDRESS + "c/c/img/setuserpic";
        VOTE_ADD = "c/c/post/addPollPost";
        ADD_MSG_RECORD = "c/b/commit/addMsgRecord";
        NOVEL_PAY = "c/s/adNovelPay";
        COULD_UPDATE = true;
        VALUE_COMMON_FONT_SIZE_XLAGER = getDimens(R.dimen.T_X04);
        VALUE_COMMON_FONT_SIZE_BIG = getDimens(R.dimen.T_X13);
        VALUE_COMMON_FONT_SIZE_MID = getDimens(R.dimen.T_X05);
        VALUE_COMMON_FONT_SIZE_SMALL = getDimens(R.dimen.T_X06);
        VALUE_OUTTER_SUBPB_FONT_SIZE_XLAGER = getDimens(R.dimen.T_X13);
        VALUE_OUTTER_SUBPB_FONT_SIZE_BIG = getDimens(R.dimen.T_X05);
        VALUE_OUTTER_SUBPB_FONT_SIZE_MID = getDimens(R.dimen.T_X06);
        VALUE_OUTTER_SUBPB_FONT_SIZE_SMALL = getDimens(R.dimen.T_X07);
        VALUE_COMMON_EMOTION_SIZE_XLAGER = getDimens(R.dimen.tbds62);
        VALUE_COMMON_EMOTION_SIZE_BIG = getDimens(R.dimen.tbds54);
        VALUE_COMMON_EMOTION_SIZE_MID = getDimens(R.dimen.tbds52);
        VALUE_COMMON_EMOTION_SIZE_SMALL = getDimens(R.dimen.tbds49);
        VALUE_COMMON_FONT_LINE_SPACE_XLAGRE = getDimens(R.dimen.tbds25);
        VALUE_COMMON_FONT_LINE_SPACE_BIG = getDimens(R.dimen.tbds25);
        VALUE_COMMON_FONT_LINE_SPACE_MID = getDimens(R.dimen.tbds25);
        VALUE_COMMON_FONT_LINE_SPACE_SMALL = getDimens(R.dimen.tbds25);
        VALUE_COMMON_FONT_LINE_SPACE_XLONG = getDimens(R.dimen.tbds17);
        VALUE_POST_FONT_LINE_SPACE_XLAGRE = getDimens(R.dimen.tbds21);
        VALUE_POST_FONT_LINE_SPACE_BIG = getDimens(R.dimen.tbds21);
        VALUE_POST_FONT_LINE_SPACE_MID = getDimens(R.dimen.tbds21);
        VALUE_POST_FONT_LINE_SPACE_SMALL = getDimens(R.dimen.tbds21);
        VALUE_SUBPB_FONT_SIZE_XLAGER = getDimens(R.dimen.T_X04);
        VALUE_SUBPB_FONT_SIZE_BIG = getDimens(R.dimen.T_X13);
        VALUE_SUBPB_FONT_SIZE_MID = getDimens(R.dimen.T_X05);
        VALUE_SUBPB_FONT_SIZE_SMALL = getDimens(R.dimen.T_X06);
        VALUE_SUBPB_EMOTION_SIZE_XLAGER = getDimens(R.dimen.tbds54);
        VALUE_SUBPB_EMOTION_SIZE_BIG = getDimens(R.dimen.tbds49);
        VALUE_SUBPB_EMOTION_SIZE_MID = getDimens(R.dimen.tbds49);
        VALUE_SUBPB_EMOTION_SIZE_SMALL = getDimens(R.dimen.tbds44);
        SUBPB_FONT_SIZE_XLAGER = getDimens(R.dimen.T_X04);
        SUBPB_FONT_SIZE_BIG = getDimens(R.dimen.T_X06);
        SUBPB_FONT_SIZE_MID = getDimens(R.dimen.T_X06);
        SUBPB_FONT_SIZE_SMALL = getDimens(R.dimen.T_X07);
        VALUE_SUBPB_FONT_LINE_SPACE_XLAGRE = getDimens(R.dimen.tbds29);
        VALUE_SUBPB_FONT_LINE_SPACE_BIG = getDimens(R.dimen.tbds29);
        VALUE_SUBPB_FONT_LINE_SPACE_MID = getDimens(R.dimen.tbds20);
        VALUE_SUBPB_FONT_LINE_SPACE_SMALL = getDimens(R.dimen.tbds20);
        MAX_PHOTO_MEMORY_CACHE = 60;
        MAX_PHOTO_MEMORY_CACHE_REMOTE_PROCESS = 10;
        PREFETCH_NEXT_VIDEO_SIZE = 512000;
        PREFETCH_NEXT_VIDEO_NUM = 3;
        IS_START_BAIDU_KUANG_CLOSE_SELF = false;
        IS_CHECK_OFFICAL_APPLICATION = true;
        GET_BFB_INFO = "c/f/forum/getUserBfbInfo";
        HTTP_PREFIX = TIEBA_ADDRESS + "f?";
        HTTPS_PREFIX = TIEBA_ADDRESS + "f?";
        HTTPS_FRS_PREFIX = TIEBA_ADDRESS + "f?kw=";
        HTTPS_PB_PREFIX = TIEBA_ADDRESS + "p/";
        HTTP_PB_PREFIX = TIEBA_ADDRESS + "p/";
        HTTPS_QUICK_WEBVIEW_PREFIX = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
        URL_UEG_SERVICE_CENTER = TIEBA_ADDRESS + "mo/q/hybrid-main-service/uegServiceCenter";
        URL_MEMBER_BUY = TIEBA_ADDRESS + "mo/q/member/pk?jumptoforum=memberbuy";
        CHECK_SHARE_SDK_URL = SERVER_ADDRESS + "c/s/checkAppValid";
        NEW_USER_GET_MONEY_URL = TIEBA_ADDRESS + "mo/q/newusermission";
        QUESTION_THREAD_RULE = TIEBA_ADDRESS + "tb/ask-page/index.html";
        QUESTION_THREAD_LIST = TIEBA_ADDRESS + "mo/q/wise-creative-core/ask-details";
        VIRTUAL_IMAGE_MAIN_URL = TIEBA_ADDRESS + "mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1";
        USER_GROWTH_TASK_CENTER_MAIN_URL = TIEBA_ADDRESS + "mo/q/hybrid-main-user/taskCenter?customfullscreen=1&nonavigationbar=1";
        USER_GROWTH_GUIDE_MAIN_URL = TIEBA_ADDRESS + "mo/q/hybrid-main-user/growRules?fr=taskDes";
        URL_THEME_CENTER = TIEBA_ADDRESS + "mo/q/hybrid/pretendCenter?page_from=1&customfullscreen=1&nonavigationbar=1&skin=";
        USER_GROWTH_APPLY_ALI_AUTH_INFO_URL = TIEBA_ADDRESS + "c/e/alipay/alipayApplyUserInfo";
        USER_GROWTH_GET_ALI_AUTH_INFO_URL = TIEBA_ADDRESS + "c/e/alipay/alipayGetUserInfo";
        URL_EXCEPTION_REPORT = TIEBA_ADDRESS + "c/s/upClientErrLog";
        URL_STATISTICS_REPORT = TIEBA_ADDRESS + "c/s/upClientMonitorLog";
    }

    public TbConfig() {
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

    public static int getBigImageMaxUsedMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return BIG_IMAGE_MAX_USED_MEMORY;
        }
        return invokeV.intValue;
    }

    public static int getBigImageMaxUsedMemoryForRemoteProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return (int) (UtilHelper.getBitmapMaxMemory(TbadkCoreApplication.getInst().getContext()) * getVaildUsedMemoryPer(BigImageCacheOptimizeSwitch.cacheSize(), 0.28f, 0.28f, 1.0f));
        }
        return invokeV.intValue;
    }

    public static int getBigImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return BIG_IMAGE_SIZE;
        }
        return invokeV.intValue;
    }

    public static String getBigPhotoAdress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return PHOTO_BIG_ADDRESS;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return CURRENT_FROM;
        }
        return (String) invokeV.objValue;
    }

    public static boolean getDebugSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return FROM;
        }
        return (String) invokeV.objValue;
    }

    public static String getLegoLibVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return LEGO_LIB_VERSION;
        }
        return (String) invokeV.objValue;
    }

    public static int getMaxPhotoMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return MAX_PHOTO_MEMORY_CACHE;
        }
        return invokeV.intValue;
    }

    public static int getMaxPhotoMemoryCacheForRemoteProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return MAX_PHOTO_MEMORY_CACHE_REMOTE_PROCESS;
        }
        return invokeV.intValue;
    }

    public static int getPbImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return BIG_IMAGE_SIZE;
        }
        return invokeV.intValue;
    }

    public static String getPhotoSmallAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return PHOTO_SMALL_ADDRESS;
        }
        return (String) invokeV.objValue;
    }

    public static String getSubVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return SUB_VERSION;
        }
        return (String) invokeV.objValue;
    }

    public static String getSubappType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return SUBAPP_TYPE;
        }
        return (String) invokeV.objValue;
    }

    public static String getTempDirName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return TMPDIRNAME;
        }
        return (String) invokeV.objValue;
    }

    public static int getThreadImageMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return THREAD_IMAGE_MAX_WIDTH;
        }
        return invokeV.intValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return VERSION;
        }
        return (String) invokeV.objValue;
    }

    public static int getVersionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return VERSION_TYPE;
        }
        return invokeV.intValue;
    }

    public static boolean compareVersion(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String version = getVersion();
            if (TextUtils.isEmpty(version)) {
                return false;
            }
            try {
                String[] split = version.split("\\.");
                String[] split2 = str.split("\\.");
                for (int i = 0; i < 3; i++) {
                    int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void initBigImageWidth(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65577, null, context) != null) || sThreadImageMaxInited) {
            return;
        }
        sThreadImageMaxInited = true;
        int sqrt = (int) Math.sqrt(BdUtilHelper.getEquipmentWidth(context) * BdUtilHelper.getEquipmentHeight(context));
        if (sqrt > THREAD_IMAGE_MAX_WIDTH) {
            THREAD_IMAGE_MAX_WIDTH = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            THREAD_IMAGE_MAX_WIDTH = (int) (THREAD_IMAGE_MAX_WIDTH * 0.8d);
        }
    }

    public static String getBigAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String version = getVersion();
            if (!StringUtils.isNull(version)) {
                String[] split = version.split("\\.");
                if (split.length > 1) {
                    return split[0] + "." + split[1];
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static int getContentLineSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (TbDimenManager.getInstance().needAdapt()) {
                return VALUE_COMMON_FONT_LINE_SPACE_XLONG;
            }
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_COMMON_FONT_LINE_SPACE_SMALL;
                        }
                        return VALUE_COMMON_FONT_LINE_SPACE_SMALL;
                    }
                    return VALUE_COMMON_FONT_LINE_SPACE_MID;
                }
                return VALUE_COMMON_FONT_LINE_SPACE_BIG;
            }
            return VALUE_COMMON_FONT_LINE_SPACE_XLAGRE;
        }
        return invokeV.intValue;
    }

    public static int getContentLineSpaceOfLzl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_SUBPB_FONT_LINE_SPACE_SMALL;
                        }
                        return VALUE_SUBPB_FONT_LINE_SPACE_SMALL;
                    }
                    return VALUE_SUBPB_FONT_LINE_SPACE_MID;
                }
                return VALUE_SUBPB_FONT_LINE_SPACE_BIG;
            }
            return VALUE_SUBPB_FONT_LINE_SPACE_XLAGRE;
        }
        return invokeV.intValue;
    }

    public static int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_COMMON_FONT_SIZE_SMALL;
                        }
                        return VALUE_COMMON_FONT_SIZE_SMALL;
                    }
                    return VALUE_COMMON_FONT_SIZE_MID;
                }
                return VALUE_COMMON_FONT_SIZE_BIG;
            }
            return VALUE_COMMON_FONT_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static int getContentSizeOfLzl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_SUBPB_FONT_SIZE_SMALL;
                        }
                        return VALUE_SUBPB_FONT_SIZE_SMALL;
                    }
                    return VALUE_SUBPB_FONT_SIZE_MID;
                }
                return VALUE_SUBPB_FONT_SIZE_BIG;
            }
            return VALUE_SUBPB_FONT_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static int getEmotionContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_COMMON_EMOTION_SIZE_SMALL;
                        }
                        return VALUE_COMMON_EMOTION_SIZE_SMALL;
                    }
                    return VALUE_COMMON_EMOTION_SIZE_MID;
                }
                return VALUE_COMMON_EMOTION_SIZE_BIG;
            }
            return VALUE_COMMON_EMOTION_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static int getEmotionContentSizeOfLzl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_SUBPB_EMOTION_SIZE_SMALL;
                        }
                        return VALUE_SUBPB_EMOTION_SIZE_SMALL;
                    }
                    return VALUE_SUBPB_EMOTION_SIZE_MID;
                }
                return VALUE_SUBPB_EMOTION_SIZE_BIG;
            }
            return VALUE_SUBPB_EMOTION_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static String getFeedBackUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (cachedFeedBackUrl == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pkgname", BdBaseApplication.getInst().getPackageName());
                hashMap.put("appvn", getVersion());
                cachedFeedBackUrl = UrlUtils.appendParams(URL_FEED_BACK, hashMap);
            }
            return cachedFeedBackUrl;
        }
        return (String) invokeV.objValue;
    }

    public static int getOutterSubpbContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_OUTTER_SUBPB_FONT_SIZE_SMALL;
                        }
                        return VALUE_OUTTER_SUBPB_FONT_SIZE_SMALL;
                    }
                    return VALUE_OUTTER_SUBPB_FONT_SIZE_MID;
                }
                return VALUE_OUTTER_SUBPB_FONT_SIZE_BIG;
            }
            return VALUE_OUTTER_SUBPB_FONT_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static int getPostLineSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return VALUE_POST_FONT_LINE_SPACE_SMALL;
                        }
                        return VALUE_POST_FONT_LINE_SPACE_SMALL;
                    }
                    return VALUE_POST_FONT_LINE_SPACE_MID;
                }
                return VALUE_POST_FONT_LINE_SPACE_BIG;
            }
            return VALUE_POST_FONT_LINE_SPACE_XLAGRE;
        }
        return invokeV.intValue;
    }

    public static int getTestContentSizeOfLzl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize != 0) {
                if (fontSize != 1) {
                    if (fontSize != 2) {
                        if (fontSize != 3) {
                            return SUBPB_FONT_SIZE_SMALL;
                        }
                        return SUBPB_FONT_SIZE_SMALL;
                    }
                    return SUBPB_FONT_SIZE_MID;
                }
                return SUBPB_FONT_SIZE_BIG;
            }
            return SUBPB_FONT_SIZE_XLAGER;
        }
        return invokeV.intValue;
    }

    public static final int getDimens(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), i);
        }
        return invokeI.intValue;
    }

    public static int initPbImageSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            int dip2px = BdUtilHelper.dip2px(context, 427.0f);
            if (dip2px > 640) {
                dip2px = 640;
            }
            int i = (int) (dip2px * dip2px * 1.6f * 2.0f);
            BIG_IMAGE_SIZE = i;
            return i;
        }
        return invokeL.intValue;
    }

    public static void setBigPhotoAdress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, null, str) == null) {
            if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                PHOTO_BIG_ADDRESS = str;
            }
        }
    }

    public static void setCurrentFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, str) == null) {
            CURRENT_FROM = str;
        }
    }

    public static void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, str) == null) {
            FROM = str;
        }
    }

    public static void setLegoLibVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, str) == null) {
            LEGO_LIB_VERSION = str;
        }
    }

    public static void setMaxPhotoMemoryCache(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65584, null, i) == null) {
            if (i < 60) {
                i = 60;
            }
            if (MAX_PHOTO_MEMORY_CACHE != i) {
                TbImageMemoryCache.A().L(i);
            }
            MAX_PHOTO_MEMORY_CACHE = i;
        }
    }

    public static void setSmallPhotoAdress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, null, str) == null) {
            if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                PHOTO_SMALL_ADDRESS = str;
            }
        }
    }

    public static void setSubVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, str) == null) {
            SUB_VERSION = str;
        }
    }

    public static void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, str) == null) {
            VERSION = str;
        }
    }

    public static void setVersionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65588, null, i) == null) {
            VERSION_TYPE = i;
        }
    }

    public static float getVaildUsedMemoryPer(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = JavaTypesHelper.toFloat(UtilHelper.formalDecimalForTwo(f / 100.0f), 0.0f);
            if (f5 >= f3 && f5 <= f4) {
                f2 = f5;
            }
            if (!vh.a()) {
                return f2 * 0.5f;
            }
            return f2;
        }
        return invokeCommon.floatValue;
    }

    public static void initBigImageMaxUsedMemory(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, context) == null) {
            BIG_IMAGE_MAX_USED_MEMORY = initPbImageSize(context) * 13;
            float vaildUsedMemoryPer = getVaildUsedMemoryPer(ImageCacheOptimizeSwitch.cacheSize(), 0.35f, 0.35f, 1.0f);
            if (BIG_IMAGE_MAX_USED_MEMORY < UtilHelper.getBitmapMaxMemory(context) * vaildUsedMemoryPer) {
                BIG_IMAGE_MAX_USED_MEMORY = (int) (UtilHelper.getBitmapMaxMemory(context) * vaildUsedMemoryPer);
            }
        }
    }

    public static void initFriendPhotoConfig(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65578, null, context) == null) && context != null && context.getResources() != null) {
            if (context.getResources().getDisplayMetrics().density < 1.0f) {
                FRIEND_PHOTO_ADDRESS = PHOTO_SMALL_ADDRESS;
            } else {
                FRIEND_PHOTO_ADDRESS = PHOTO_BIG_ADDRESS;
            }
        }
    }
}
