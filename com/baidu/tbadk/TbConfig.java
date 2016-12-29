package com.baidu.tbadk;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.webkit.URLUtil;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class TbConfig {
    public static final int ABSTRACT_AUTO = 0;
    public static final int ABSTRACT_CLOSE = 2;
    public static final int ABSTRACT_OPEN = 1;
    public static final String ACROSS_AWARD = "c/f/recommend/acrossaward";
    public static final String ACROSS_FORUM = "c/f/recommend/acrossforum";
    public static final String ADD_FAN_ADDRESS = "c/c/user/fansno";
    public static final int ADD_IAMGE_WATER_NONE = 0;
    public static final int ADD_IMAGE_WATER_FORUM_NAME = 2;
    public static final int ADD_IMAGE_WATER_USER_NAME = 1;
    public static final String ADD_MY_GAME = "c/c/game/addmygamebatch";
    public static final String ADD_USER_BOOKMARK = "c/c/encourage/tbread/addUserBookMark";
    public static final String ALL_THEME_LIST_PAGE = "c/e/theme/getSkinList";
    public static final String APPLY_GAME_CARD = "c/u/game/applygamecard";
    public static final long APP_ENTER_BACKGROUND_INTERVAL = 1000;
    public static final String APP_UPDATE_ACTION = "com.baidu.tieba.NewsVersion";
    public static final int AUTO_PLAY_ALWAYS = 2;
    public static final int AUTO_PLAY_CLOSED = 1;
    public static final int AUTO_PLAY_IN_WIFI = 0;
    public static final String AVATAR_PENDANT = "c/e/theme/getPendantByCategory";
    public static final int BIG_IMAGE_MIN_CAPACITY = 10000;
    public static final int BIG_IMAGE_MIN_SIZE = 80;
    public static final String BIG_IMG_SPEC = "big_img";
    public static final int BIG_PHOTO_MAX_SIZE = 110;
    private static final String BROADCAST_CHANGESKIN = "com.baidu.tieba.broadcast.changeskin";
    private static final String BROADCAST_CHANGE_SHARED_PREF = "com.baidu.tieba.broadcast.changeSharedPref";
    public static final String BROADCAST_FIELD_SKIN_TYPE = "skin_type";
    private static final String BROADCAST_IMAGE_RESIZED = "com.baidu.tieba.broadcast.image.resized";
    private static final String BROADCAST_NEWVERSION = "com.baidu.tieba.broadcast.newversion";
    private static final String BROADCAST_OTHERPROCESSFRONTBACKGROUNDSWITCH = "com.baidu.tieba.broadcast.otherprocessfrontbackground";
    private static final String BROADCAST_PAGE_ADDED = "com.baidu.tieba.broadcast.imagepb.pageadded";
    private static final String BROADCAST_PAGE_CHANGED = "com.baidu.tieba.broadcast.imagepb.pagechanged";
    private static final String BROADCAST_SIGN_ALERT = "com.baidu.tieba.broadcast.signalert";
    public static final String BUBBLE_GROUP_PAGE = "c/e/theme/getBubbleByCategory";
    public static final String BUBBLE_LIST_PAGE = "c/e/theme/getBubbleList";
    public static final String BUBBLE_SET = "c/e/bu/setbubble";
    public static final String BUY_FACE_PACKAGE_URL = "c/e/faces/buyfacepack";
    public static final String CDN_LOG_ADDRESS = "c/p/updata";
    public static final String CHANNEL_FILE = "channel.dat";
    public static final String CHECK_USER_BOOKMARK = "c/e/tbread/checkUserBookMark";
    public static final String CLEAR_LOCATION_INFO = "c/u/recent/hide_position";
    public static final String CMD_GET_BOOKRACK = "c/e/tbread/getBookrack";
    public static final String CMD_GET_BOOKS_BY_IDS = "c/e/tbread/getBooksByIds";
    public static final String CMD_GET_BOOK_COMMENT = "c/e/tbread/getBookComment";
    public static final String CMD_GET_BOOK_ONLINE_CONTENT = "c/e/tbread/getBookContent";
    public static final String CMD_GET_BOOK_SUMMARY = "c/e/tbread/getBookSummary";
    public static final String CMD_GET_CATEGORY_CARTOON = "c/e/cartoon/getCartoonCategoryList";
    public static final String CMD_SCREEN_LOCK_MESSAGE_MORE = "c/f/msg/getMoreMsg";
    public static final String COMMIT_GOOD_ADDRESS = "c/c/bawu/commitgood";
    public static final String COMMIT_TOP_ADDRESS = "c/c/bawu/committop";
    public static final String COMMON_PRAISE_URL = "c/c/zan/like";
    public static final String COOKER_BET = "c/u/game/submit/mbet";
    public static final String COOKER_GAME_RESULT = "c/u/game/submit/getgambleresult";
    public static final String COOKER_RANK_LIST = "c/u/game/smRank";
    public static final String COOKER_RESULT_RECORD = "c/u/game/resultrecord";
    public static final String CREATE_BOOK_PAY_ORDER = "c/c/encourage/tbread/createPayOrder";
    public static final String DAILYRECOMMEND_ADDRESS = "c/f/forum/threadrecommend";
    public static final int DATABASE_SD_VERSION = 9;
    public static final String DELETE_MY_GAME = "c/c/game/delmygame";
    public static final String DEL_POST_ADDRESS = "c/c/bawu/delpost";
    public static final String DEL_THREAD_ADDRESS = "c/c/bawu/delthread";
    public static final String DEL_USER_BOOKMARK = "c/c/encourage/tbread/delUserBookMark";
    public static final String DETECT_USERNAME_ADDRESS = "c/s/detectuname";
    public static final String DIALOG_FROM = "dianzishichang";
    public static final String DO_DAILY_TASK = "c/c/encourage/member/doDailyTask";
    public static final String DRESSUP_CENTER_PAGE = "c/e/theme/getThemeList";
    public static final String ECOMM_REFUND_AGREE_REUNFD = "c/c/encourage/ecomm/order/refund";
    public static final String ECOMM_REFUND_COMFIRM_TRANS = "c/c/encourage/ecomm/order/refund/confirmTrans";
    public static final String ECOMM_REFUND_DETAIL = "c/c/encourage/ecomm/order/refund/refuse";
    public static final String ECOMM_REFUND_DETAIL_PAGE = "c/e/ecomm/order/refund/detail";
    public static final String ECOMM_REFUND_PREPARE = "c/e/ecomm/order/refund/prepare";
    public static final int EMOTION_HEIGHT = 240;
    public static final int EMOTION_HEIGHT_LOW = 160;
    public static final int EMOTION_WIDTH = 240;
    public static final int EMOTION_WIDTH_LOW = 160;
    public static final String ENTERTAINMENT_ADDRESS = "lego/lego";
    public static final String ERROR_UPLOAD_SERVER = "c/s/logupload";
    public static final String FATAL_ERROR_ALERT_FILE = "fatal_error_alert.log";
    public static final String FATAL_ERROR_DEBUG_FILE = "fatal_error_debug.log";
    public static final String FATAL_ERROR_FILE = "fatal_error.log";
    public static final long FATAL_ERROR_FILE_MAX_SIZE = 204800;
    public static final String FATAL_ERROR_NATIVE_DIR = "native_crash";
    public static final String FEED_BACK_WEB_VIEW_URL = "http://tieba.baidu.com/mo/q/feedback";
    public static final String FINE_PB_PAGE = "c/f/excellent/excpbpage";
    public static final String FINE_PB_PRAISE = "c/f/excellent/exczan";
    public static final String FINISH_MEMBER_TASK = "c/c/encourage/point/finishmembertask";
    public static final String FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/voice_fin_chunk_upload";
    public static final String FOLLOW_ADDRESS = "c/c/user/follow";
    public static final int FONT_SIZE_BIG = 1;
    public static final int FONT_SIZE_MID = 2;
    public static final int FONT_SIZE_SMALL = 3;
    public static final int FONT_SIZE_XLAGER = 0;
    public static final String FORBID_USER_ADDRESS = "c/c/bawu/commitprison";
    public static final String FORTUNE_ADDRESS = "mo/q/fudaiindex";
    public static final String FORUM_CLASS_LIST = "c/f/forumsquare/getForumClassList";
    public static final String FORUM_SQUARE = "c/f/forum/forumsquare";
    public static final String FOUND_NEW_ADDRESS = "c/s/foundnew";
    public static final String FROM_FILE = "from.dat";
    public static final int FRS_ABSTRACT_ITEM_NUMBER = 50;
    public static final String FRS_ADDRESS = "c/f/frs/page";
    public static final int FRS_CACHE_NUM = 20;
    public static final String FRS_HEAD_VIDEO_LIST = "c/f/video/forumHeadVideo";
    public static final int FRS_NOABSTRACT_ITEM_NUMBER = 35;
    public static final int FRS_WATER_FALL_PAGE_NUM = 240;
    public static final int FRS_WATER_FALL_PHOTO_NUM = 30;
    public static final String FUNCTION_INTRO_WEBVIEW = "mo/q/topic_page/110_1";
    public static final String GAME_SEARCH_RESULT = "c/u/game/searchGame";
    public static final String GET_BANNER_GAME = "c/u/game/getgameadvertise";
    public static final String GET_BARRAGE_LIST = "c/f/video/getBarrageList";
    public static final String GET_BAWU_INFO = "c/f/forum/getBawuInfo";
    public static final String GET_BOOK_DETAIL_INFO = "c/e/tbread/getBookDetailInfo";
    public static final String GET_BOOK_DIRECTORY_INFO = "c/e/tbread/getBookDirectory";
    public static final String GET_BOOK_DOWNLOAD_INFO = "c/e/tbread/getBookDownloadInfo";
    public static final String GET_BOOK_PAY_PANEL = "c/e/tbread/getPayPanel";
    public static final String GET_CARD_DETAIL = "c/e/theme/getCard";
    public static final String GET_DEFAULT_GIFT_LIST = "c/e/present/getGiftList";
    public static final String GET_FORUM_DETAIL = "c/f/forum/getforumdetail";
    public static final String GET_FRS_HOT = "c/f/frs/getHotThread";
    public static final String GET_FRS_LIVE = "c/f/frs/getFrsTWLiveList";
    public static final String GET_FRS_TAB_FOLLOW_POST_NUM = "c/f/frs/getFrsTabFollowPostNum";
    public static final String GET_GAME_CATEGORY = "c/u/game/getgamecategory";
    public static final String GET_GAME_GATEGORY_DETAIL = "c/u/game/getgamecategorydetail";
    public static final String GET_GIFT_LIST_BY_CATEGORY = "c/e/present/getGiftListByCategoryId";
    public static final String GET_HOT_FORUM_URL = "c/f/forum/hotforum";
    public static final String GET_HOT_GAME = "c/u/game/getHotGameList";
    public static final String GET_IP_LIST = "c/s/getipinfo";
    public static final String GET_LEVEL_INFO_URL = "c/f/forum/getLevelInfo";
    public static final String GET_MANGA_COVER = "c/e/cartoon/getBookCover";
    public static final String GET_MANGA_STORE_INFO = "c/e/cartoon/getBookStore";
    public static final String GET_MEMBER_INFO = "c/f/forum/getMemberInfo";
    public static final String GET_MEMBER_TASK = "c/e/point/getmembertasklist";
    public static final String GET_MY_GAMELIST = "c/u/game/getmygamelist";
    public static final String GET_MY_POST = "c/f/frs/getmypost";
    public static final String GET_MY_SHELF = "c/e/cartoon/getMyShelf";
    public static final String GET_NEW_GAME = "c/u/game/getNewGameList";
    public static final String GET_OPEN_USER_INFO = "c/e/xiuba/getopenid";
    public static final String GET_ORDER = "c/e/mema/getOrder";
    public static final String GET_PACKAGE_DETAIL = "c/e/faces/getfacelist";
    public static final String GET_PACKAGE_DOWNLOAD_URL = "c/e/faces/dpack";
    public static final String GET_PACKAGE_LIST = "c/e/faces/getpacklist";
    public static final String GET_PACKAGE_PURCHASE_RECORDS = "c/e/faces/getpackhis";
    public static final String GET_PAY_CONFIG = "c/s/getClientConfig";
    public static final String GET_PERSONAL_CARD_BY_CATEGORY = "c/e/theme/getCardByCategory";
    public static final String GET_PERSONAL_GIFT_LIST = "c/e/present/getMyGift";
    public static final String GET_PRIVATE_INFO = "c/u/user/getPrivateInfo";
    public static final String GET_SINGLE_GAME = "c/u/game/getsinglegamelist";
    public static final String GET_SUGGEST_LOCATION_BY_NAME = "c/s/getSuggestionByAddrName";
    public static final String GET_SYNC_ADDRESS = "c/s/sync";
    public static final String GET_TASK_SCORE = "c/c/encourage/member/addTaskScores";
    public static final String GET_USER_BOOKMARK_LIST = "c/e/tbread/getUserBookMarkList";
    public static final String GET_USER_BOOK_HISTORY = "c/e/tbread/getUserBookHistory";
    public static final String GET_USER_FREE_CHANCE = "c/e/present/getUserFreeChance";
    public static final String GET_USER_INFO = "c/u/user/getuserinfo";
    public static final String GET_USER_LOCATION = "c/u/user/getuserlocation";
    public static final String GET_USER_ORDER = "c/e/consume/getUserOrder";
    public static final String GIFT_COMMONLIST = "c/e/gift/commonlist";
    public static final String GIFT_PLACE_ORDER = "c/c/encourage/present/placeOrder";
    public static final String GOD_RECOMMEND = "c/r/god/followRecommend";
    public static final String GOD_THREAD_LIST = "c/u/user/godThreadList";
    public static final String GOOD_LIST_ADDRESS = "c/c/bawu/goodlist";
    public static final String GROUP_HEAD_FILE = "tieba_group_image";
    public static final boolean GROUP_MSG_DEFAULT_SWITCH = true;
    public static final int HEAD_IMG_SIZE = 960;
    public static final String HOME_FORUM_FEED_LIST = "c/u/feed/forum";
    public static final String HOME_REALTIME_ADDRESS = "c/f/excellent/realtime";
    public static final String HOT_THREAD_UNLIKE = "c/f/choiceness/unlike";
    public static final String HTTPS_FRS_PREFIX = "http://tieba.baidu.com/f?kw=";
    public static final String HTTPS_PB_PREFIX = "http://tieba.baidu.com/p/";
    public static final String HTTPS_PREFIX = "http://tieba.baidu.com/f?";
    public static final String HTTP_PB_PREFIX = "http://tieba.baidu.com/p/";
    public static final String HTTP_PREFIX = "http://tieba.baidu.com/f?";
    public static final String IMAGE_CACHE_DIR_NAME = "images";
    public static final String IMAGE_PB_ADDRESS = "c/f/pb/picpage";
    public static final int IMAGE_PV_COUNT = 100;
    public static final String IMAGE_RESIZED_FILE = "tieba_resized_image";
    public static final String IMAGE_RESIZED_FILE_DISPLAY = "tieba_resized_image_display";
    public static final float IMAGE_ROUND = 10.0f;
    public static final String INCR_FORUM_ACCESS_ACOUNT = "c/c/forum/incrForumAccessCount";
    public static final String INPUT_USERNAME_ADDRESS = "c/s/filluname";
    public static final String IN_PV_ADDRESS = "c/s/inpv";
    public static final String JUMP_TO_NEW_USER_CHOOSE_BAR = "c/u/user/getuserlike";
    public static final boolean LBSSWITCH = true;
    public static final String LIKE_ADDRESS = "c/c/forum/like";
    public static final int LIVE_IMAGE_MAX_COUNT = 6;
    public static final String LOAD_REG_PV_ADDRESS = "c/s/pv";
    public static final String LOCAL_CAMERA_DIR = "cameras";
    public static final String LOCAL_PIC_DIR = "photos";
    public static final String LOG_ERROR_FILE = "log_error.log";
    public static final String LOG_SYNC_SWITCH = "http://tb1.bdstatic.com/tb/client/logsync3.js";
    public static final String LOG_TOGETHER = "c/s/logtogether";
    public static final String LOG_UPLOAD_URL = "c/s/newlog";
    public static final String MAIN_PACKAGE_NAME = "com.baidu.tieba";
    public static final String MANAGE_ADDRESS = "http://tieba.baidu.com/mo/q/bawuindex";
    public static final String MARK_ADDSTORE = "c/c/post/addstore";
    public static final String MARK_DELSTORE = "c/c/post/rmstore";
    public static final String MARK_GETSTORE = "c/f/post/threadstore";
    public static final int MAX_ACTIVITY_STACK_SIZE = 20;
    public static final int MAX_ASYNC_IMAGE_LOADER_NUM = 5;
    public static final int MAX_CASH_FRIEND_PHOTO_NUM = 500;
    public static final int MAX_CASH_PB_PHOTO_NUM = 500;
    public static final int MAX_CASH_USER_ICON_NUM = 100;
    public static final int MAX_FRS_ICON_NUM = 3;
    public static final int MAX_HOME_ICON_NUM = 3;
    public static final int MAX_PB_ICON_NUM = 3;
    public static final int MAX_PB_PIC_ONEPOST = 10;
    public static final int MAX_PERSON_INFO_ICON_NUM = 9;
    public static final int MAX_PRELOAD_PHOTO_NUM = 30;
    public static final int MAX_PRELOAD_PIC_NUM = 13;
    public static final int MAX_SDRAM_PHOTO_NUM = 50;
    public static final int MAX_SDRAM_PIC_NUM = 13;
    public static final int MAX_TSHOW_ICON_NUM = 2;
    public static final int MAX_USER_NAME_BYTE_LENGTH = 14;
    public static final int MAX_WEBVIEW_CRASH_COUNT_NEWVCODE_VIEW = 3;
    public static final String MEMBERCENTERE_INDEX_PAGE = "c/e/member/getVipInfo";
    public static final String MEMBER_PAY = "c/e/pay/andmember";
    public static final String MEMBER_PRIVILEGE = "c/e/pay/tmall";
    public static final boolean MSG_DEFAULT_ATME_SWITCH = true;
    public static final boolean MSG_DEFAULT_CHAT_SWITCH = true;
    public static final boolean MSG_DEFAULT_FANS_SWITCH = true;
    public static final int MSG_DEFAULT_FREQUENCY = 300;
    public static final String MSG_DEFAULT_NODISTURB_END_TIME = "09:00";
    public static final String MSG_DEFAULT_NODISTURB_START_TIME = "23:00";
    public static final boolean MSG_DEFAULT_NODISTURB_SWITCH = false;
    public static final boolean MSG_DEFAULT_REMIND_LIGHT = true;
    public static final boolean MSG_DEFAULT_REMIND_TONE = true;
    public static final boolean MSG_DEFAULT_REMIND_VIBRATE = false;
    public static final boolean MSG_DEFAULT_REPLYME_SWITCH = true;
    public static final String MULTI_FOLLOW = "c/c/user/mfollow";
    public static final int MUTI_IMAGE_MAX_COUNT = 10;
    public static final int NAVI_STATE_EDIT = 2;
    public static final int NAVI_STATE_SEARCH = 0;
    public static final int NAVI_STATE_SIGN = 1;
    public static final String NEG_FEED_BACK = "c/c/excellent/submitDislike";
    public static final int NET_MSG_GETLENTH = 900002;
    public static final int NET_MSG_TOTALLENTH = 900001;
    public static final int NOTIFY_AT_ME_ID = 25;
    public static final int NOTIFY_CHAT_ID = 16;
    public static final int NOTIFY_FANS_NEW_ID = 26;
    public static final int NOTIFY_GIFT_ID = 23;
    public static final int NOTIFY_GROUP_EVENT = 18;
    public static final int NOTIFY_GROUP_ID = 17;
    public static final int NOTIFY_LIVE_GROUP_END_EVENT = 22;
    public static final int NOTIFY_LIVE_GROUP_EVENT = 20;
    public static final int NOTIFY_LIVE_NOTIFY = 21;
    public static final int NOTIFY_LIVING_VIP = 27;
    public static final int NOTIFY_MY_COLLECT_UPDATE = 28;
    public static final int NOTIFY_OFFICIAL_MESSAGE = 19;
    public static final int NOTIFY_PLUGIN_INSTALLING = 1000;
    public static final int NOTIFY_PUSH_ID = 15;
    public static final int NOTIFY_RECOMMEND_MESSAGE_ID = 13;
    public static final int NOTIFY_REMIND_RECOMMEND = 2000;
    public static final int NOTIFY_REPLY_ME_ID = 24;
    public static final int NOTIFY_SIGN_ID = 12;
    public static final long NOTIFY_SOUND_INTERVAL = 5000;
    public static final long ONE_DAY_TIME = 86400000;
    public static final String OP_BOOKRACK = "c/c/encourage/tbread/opBookrack";
    public static final int PB_DEFAULT_CONTENT_TEXT_SIZE = 16;
    public static final int PB_DEFAULT_NAME_TEXT_SIZE = 11;
    public static final int PB_IMAGE_DIP_MAX_WIDTH = 427;
    public static final int PB_IMAGE_MAX_HEIGHT = 105;
    public static final int PB_IMAGE_MAX_WIDTH = 105;
    public static final float PB_IMAGE_NEW_SCALE = 1.6f;
    public static final int PB_PHOTO_MAX_SIZE = 80;
    public static final int PB_PHOTO_QUALITY = 80;
    public static final String PERSONAL_BACKGROUND_GET = "c/e/theme/getBackground";
    public static final String PERSONAL_BACKGROUND_GROUP_PAGE = "c/e/theme/getBgByCategory";
    public static final String PERSONAL_BACKGROUND_LIST_PAGE = "c/e/theme/getBgList";
    public static final String PERSONAL_BACKGROUND_SET = "c/e/theme/setBackground";
    public static final String PERSON_HEAD_FILE = "tieba_head_image";
    public static final String PERSON_USER_PIC_TEMP_FILE = "tieba_user_pic_temp_image";
    public static final String PHONE_DATEBASE_NAME = "baidu_tieba.db";
    public static final String PHOTOLIVE_HOST_GUIDE = "c/f/livegroup/getTWGuideDesc";
    public static final String PHOTOLIVE_HOST_LEVEL = "c/f/livegroup/getTWAnchorInfo";
    public static final String PHOTOLIVE_HOST_UPGRADE = "c/c/livegroup/upgradeTWAnchor";
    public static final int PHOTO_DELAY_TIME = 90;
    public static final String PHOTO_LIVE_COVER_FILE = "tieba_photo_live_cover_image";
    public static final String PHOTO_LIVE_MISSON_DETAILS = "c/f/livegroup/getTWAnchorTask";
    public static final String PHOTO_LIVE_MISSON_DETAILS_ATTENTION = "c/c/livegroup/setFollowStatus";
    public static final String PHOTO_LIVE_SET_COVER = "c/c/thread/setLiveCover";
    public static final String PHOTO_LIVE_SET_TWGUIDE_DESC = "c/c/livegroup/setTWGuideDesc";
    public static final String PLUGIN_NET_CONFIGS_MIS = "c/s/pluginsmisconf";
    public static final int POST_IMAGE_BIG = 900;
    public static final int POST_IMAGE_DISPLAY = 100;
    public static final int POST_IMAGE_MIDDLE = 750;
    public static final int POST_IMAGE_QUALITY = 80;
    public static final int POST_IMAGE_SMALL = 600;
    public static final String POST_SEARCH_URL = "c/s/searchpost";
    public static final String POST_THREAD_ADDRESS = "c/c/thread/add";
    public static final String POST_THREAD_FOR_SHARE_ADDRESS = "c/c/thread/sdkshare";
    public static final String PRODUCT_NO = "1000002";
    public static final String PROFILE_HEAD_MODIFY = "c/c/img/portrait";
    public static final String PROFILE_MODIFY = "c/c/profile/modify";
    public static final boolean PROMOTED_DEFAULT = true;
    public static final String QUERY_BUY_RESULT_URL = "c/e/faces/querybuyresult";
    public static final int READ_GIF_CACHE_TIMEOUT_WIFI = 500;
    public static final int READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI = 2000;
    public static final int READ_IMAGE_CACHE_TIMEOUT_WIFI = 300;
    public static final String RECOMMEND_FRS = "c/f/excellent/excfrspage";
    public static final String RECOMMEND_FRS_GOD = "c/r/god/feed";
    public static final String RECOMMEND_HOME_PAGE_ADDRESS = "c/f/excellent/personalized";
    public static final String REGISTER_ADDRESS = "c/m/register";
    public static final String REPLY_THREAD_ADDRESS = "c/c/post/add";
    public static final String REPORT_APPLIST = "https://als.baidu.com/device/logForC";
    public static final String SAVE_GAME_STATUS = "c/c/game/saveGameStatus";
    public static final String SEARCH_FRIEND = "c/r/friend/searchFriend";
    public static final String SEND_BLESS = "c/b/commit/sendBless";
    public static final String SEND_FREE_GIFT = "c/c/encourage/present/sendFreeGift";
    public static final String SEND_GIFT = "c/c/gift/send";
    public static final String SETTINGFILE = "settings";
    public static final String SET_COMMON_FORUM_STATE = "c/c/forum/setCommonForumState";
    public static final String SET_HOTSELECT = "c/f/recommend/getSugTopic";
    public static final String SET_MEMBER_CLOSE_AD = "c/c/encourage/member/closeAd";
    public static final String SET_PENDANT = "c/c/encourage/theme/setPendant";
    public static final String SET_PERSONAL_CARD = "c/c/encourage/theme/setCard";
    public static final String SET_PRIVATE = "c/c/friend/setprivate";
    public static final String SET_USER_BOOK_HISTORY = "c/c/encourage/tbread/setUserBookHistory";
    public static final String SIGN_ADDRESS = "c/c/forum/sign";
    public static final String SKIN_DETAIL_PAGE = "c/e/theme/getSkin";
    public static final String STAT_CLIENT_START = "c/c/forum/statClientStartTimes";
    public static final String ST_PARAM_PERSON_INFO_SEND_MESSAGE = "3";
    public static final String ST_PARAM_TAB_MSG_CREATE_CHAT = "2";
    public static final String ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK = "1";
    public static final String ST_TYPE_ADD_TO_LAUNCHER = "add_to_launcher";
    public static final String ST_TYPE_CLIENT_SHARE = "client_share";
    public static final String ST_TYPE_ENTER_FORE = "enter_fore";
    public static final String ST_TYPE_EYESHIELD_MODE = "eyeshield";
    public static final String ST_TYPE_IM = "chat_pg";
    public static final String ST_TYPE_LOGIN = "old_login";
    public static final String ST_TYPE_OPEN = "open";
    public static final String ST_TYPE_PCHAT = "pchat";
    public static final String ST_TYPE_REG = "reg";
    public static final String ST_TYPE_USE = "use";
    public static final String SUBMIT_CLOSE_ADKILLER = "c/c/game/killAd";
    public static final String SW_APID = "sw";
    public static final String SYNC_ACTIVE = "sync_active";
    public static final String TAIL_ADD = "c/u/tail/addTail";
    public static final String TAIL_DELETE = "c/u/tail/deleteTail";
    public static final String TAIL_GET = "c/u/tail/getTails";
    public static final String TAIL_SET = "c/u/tail/setTail";
    public static final String TAIL_UPDATE = "c/u/tail/updateTail";
    public static final String THEME_LIST_UPDATE = "c/e/theme/getUpdateInfo";
    public static final int THREAD_GIF_MIN_USE_MEMORY = 6291456;
    public static final String TMP_DATABASE_NAME = "tieba_database.db";
    public static final String TMP_LOGBAK_DIR_NAME = "logbak";
    public static final String TMP_LOG_DIR_NAME = "log";
    public static final String TMP_PIC_DIR_NAME = "image";
    public static final String TMP_SHARE_DIR_NAME = "share";
    public static final String TMP_VOI_DIR_NAME = "voice";
    public static final String TOP_THEME_LIST_PAGE = "c/e/theme/getSkinByCategory";
    public static final String TRAFFIC_MAIN_PROCESS = "traffic_main_process";
    public static final String TRAFFIC_NATIVE_MEMORY = "traffic_native_memory";
    public static final int TYPE_DAILY_BUILD = 1;
    public static final int TYPE_GRAY_BUILD = 2;
    public static final int TYPE_RELEASE_BUILD = 3;
    public static final String UNFAVOLIKE_ADDRESS = "c/c/forum/unfavolike";
    public static final String UNFOLLOW_ADDRESS = "c/c/user/unfollow";
    public static final long UPDATE_NOTIFY_INTERVAL = 86400000;
    public static final String UPDATE_PLAYER_NUM = "c/c/game/updatetimes";
    public static final String UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/chunkupload";
    public static final int UPLOAD_IMAGE_QUALITY_AUTO = 0;
    public static final int UPLOAD_IMAGE_QUALITY_HIGH = 1;
    public static final int UPLOAD_IMAGE_QUALITY_LOW = 3;
    public static final int UPLOAD_IMAGE_QUALITY_MID = 2;
    public static final String URL_APPLY_COPY_THREAD = "c/c/livegroup/applycopythread";
    public static final String URL_BUYPROPS = "c/e/mema/buyprops";
    public static final String URL_CHECK_VIDEO_STATUS = "c/c/video/uploadVideoStatus";
    public static final String URL_DELETE_GRAFFITTI = "c/c/graffiti/remove";
    public static final String URL_GETPAYINFO = "c/e/mema/getpayinfo";
    public static final String URL_GET_CONSENTLIST = "c/u/feed/getConsentList";
    public static final String URL_GET_GRAFFITI_LIST = "c/f/pb/graffiti";
    public static final String URL_GET_HOME_PAGE_DATA = "c/f/index/homePage";
    public static final String URL_GET_HOT_RANKLIST_DATA = "c/f/recommend/topicList";
    public static final String URL_GET_HOT_TOPIC_DATA = "c/f/recommend/hottopic";
    public static final String URL_GET_TOPIC_RELATE_THREAD = "c/f/recommend/getTopicRelateThread";
    public static final String URL_JUMP_TAG_WALLET = "http://www.bdwallet.activity";
    public static final String URL_MANGA_CHAPTER_ALL = "c/e/cartoon/getAllChapters";
    public static final String URL_MANGA_CHAPTER_DETAIL = "c/e/cartoon/cartoonReader";
    public static final String URL_MANGA_OFFLINE_RESOURCE = "c/e/cartoon/getOfflineResource";
    public static final String URL_MANGA_REPORT = "c/e/cartoon/getReportType";
    public static final String URL_MANGA_REPORT_TYPE = "c/e/cartoon/getReportType";
    public static final String URL_PLAY_STATISTICS = "c/c/video/playStat";
    public static final String URL_TOPIC_USER_PK = "c/f/recommend/userPk";
    public static final String URL_UPLOAD_VIDEO = "c/c/video/uploadVideoData";
    public static final String USER_MUTE_ADD = "c/c/user/userMuteAdd";
    public static final String USER_MUTE_CHECK = "c/u/user/userMuteCheck";
    public static final String USER_MUTE_DEL = "c/c/user/userMuteDel";
    public static final String USER_MUTE_QUERY = "c/u/user/userMuteQuery";
    public static final int USER_PHOTO_AUTO = 0;
    public static final int USER_PHOTO_CLOSE = 2;
    public static final int USER_PHOTO_OPEN = 1;
    public static final long USE_TIME_INTERVAL = 60000;
    public static final String VIDEO_FINISH_ADDRESS = "c/c/video/uploadVideoChunkFinish";
    public static final String VIDEO_SINGLE_UPLOAD_ADDRESS = "c/c/video/uploadVideo";
    public static final String VIDEO_UPLOAD_ADDRESS = "c/c/video/uploadVideoChunk";
    public static final String VIDEO_UPLOAD_BLOCK = "c/c/video/uploadBlock";
    public static final String VIDEO_UPLOAD_CHUNK = "c/c/video/uploadChunk";
    public static final String VIDEO_UPLOAD_FILE = "c/c/video/uploadFile";
    public static final int VIEW_IMAGE_QUALITY_AUTO = 0;
    public static final int VIEW_IMAGE_QUALITY_HIGH = 1;
    public static final int VIEW_IMAGE_QUALITY_HIGH_VALUE = 80;
    public static final int VIEW_IMAGE_QUALITY_LOW = 2;
    public static final int VIEW_IMAGE_QUALITY_LOW_VALUE = 45;
    public static final String VOICE_CACHE_DIR_NAME = "voice";
    public static final int VOICE_CHUNK_UPLOAD_SIZE = 30720;
    public static final String VOICE_DATA = "c/p/voice";
    public static final String VOTE_GRAFFITI = "c/c/graffiti/vote";
    public static final int WEBP_FAILURE_MAX = 5;
    public static final String WEB_URL_FANS = "http://tieba.baidu.com/n/fans-party/prizeshow?nonavigationbar=1&from=native";
    public static final String WEB_URL_TDOU_UEG = "http://tieba.baidu.com/mo/q/nativePayUeg?errorno=";
    public static final String WEB_VIEW_JUMP2NATIVE = "jump_tieba_native=1";
    public static final String WEIXIN_APP_ID = "wxdd0912f3a78239c8";
    public static final String WEIXIN_PARTNER_ID = "1219850201";
    public static final String WEIXIN_SHARE_APP_ID = "wx289a8c58bca4c71e";
    public static final String api_key = "GXGROE8KmWiRmcWFpiWTmUbE";
    public static final String app_id = "1095821";
    public static String SERVER_ADDRESS = TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS;
    public static final long APP_OVERDUR_DRAFT_BOX = 604800000;
    public static long MILLS_7DAYS = APP_OVERDUR_DRAFT_BOX;
    public static int BUILD_NUMBER = 0;
    public static boolean USE_OLD_LOGIN = false;
    public static String LOGIN_FULL_ADDRESS = String.valueOf(SERVER_ADDRESS) + "c/s/login";
    public static String SERVER_ADDRESS_WEB_VIEW = TbDomainConfig.DOMAIN_HTTPS_TIEBA;
    public static int ALPHA_80 = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static boolean KUANG_TEST_MODE = false;
    private static String POSITION_PAGER_NAME = "贴吧客户端反馈";
    private static String POSITION_PAGER_ID = "2631903";
    private static String VERSION = "";
    private static String SUB_VERSION = "";
    private static String LEGO_LIB_VERSION = "1.0.0";
    private static String SUBAPP_TYPE = "";
    private static String FROM = null;
    public static final int PB_IMAGE_NEW_MAX_WIDTH = 640;
    private static int THREAD_IMAGE_MAX_WIDTH = PB_IMAGE_NEW_MAX_WIDTH;
    private static boolean sThreadImageMaxInited = false;
    public static final String TRANSFER_PICTURE_ID = String.valueOf(SERVER_ADDRESS) + "c/c/img/transferUrl2Pid";
    public static final String GET_AUTHORIZE_ID = String.valueOf(SERVER_ADDRESS) + "c/s/uidTransform";
    private static int FRIEND_PHOTO_MAX_SIZE = 80;
    private static int VERSION_TYPE = 3;
    public static final Bitmap.Config BitmapConfig = Bitmap.Config.RGB_565;
    private static String TMPDIRNAME = "tieba";
    private static String CURRENT_FROM = null;
    private static int BIG_IMAGE_SIZE = 10240;
    private static int BIG_IMAGE_MAX_USED_MEMORY = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
    public static String PHOTO_SMALL_ADDRESS = "http://tb.himg.baidu.com/sys/portraitn/item/";
    public static String PHOTO_BIG_ADDRESS = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static String FRIEND_PHOTO_ADDRESS = PHOTO_SMALL_ADDRESS;
    public static final String IMAGE_ADDRESS = String.valueOf(SERVER_ADDRESS) + "c/p/img?";
    public static String UPLOAD_IMG_URL = String.valueOf(SERVER_ADDRESS) + "c/s/uploadPicture";
    public static String CHANGE_USER_PORTRAIT = String.valueOf(SERVER_ADDRESS) + "c/c/img/changeportrait";
    public static String SET_USER_PICS = String.valueOf(SERVER_ADDRESS) + "c/c/img/setuserpic";
    public static String ADD_USER_ATTR_URL = "c/c/user/addUserAttr";
    public static String VOTE_ADD = "c/c/post/addPollPost";
    public static String ADD_MSG_RECORD = "c/b/commit/addMsgRecord";
    public static String COMMIT_GRAFFITI = "c/c/graffiti/commit";
    public static boolean COULD_UPDATE = true;
    public static boolean IS_START_BAIDU_KUANG_CLOSE_SELF = false;
    public static boolean IS_CHECK_OFFICAL_APPLICATION = true;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static String GET_HOT_GOD = "c/u/user/getHotGod";
    public static String GET_BFB_INFO = "c/f/forum/getUserBfbInfo";

    /* loaded from: classes.dex */
    public static final class PassConfig {
        public static final String APP_ID = "1";
        public static final String CRIPT_TYPE = "1";
        public static final String ENC_KEY = "6e93e7659ae637845c7f83abee68a740";
        public static final String GET_CERT_URL = "http://passport.baidu.com/sslcrypt/get_last_cert";
        public static final String LOGIN_BDUSS_URL = "http://passport.baidu.com/v2/sapi/bdusslogin";
        public static final String TPL = "tb";
    }

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }

    public static void setPbListItemMaxNum(int i) {
        PB_LIST_ITEM_MAX_NUM = i;
    }

    public static void setPbListNum(int i) {
        if (i >= 60 && i <= 1000) {
            PB_LIST_ITEM_MAX_NUM = i;
        }
    }

    public static void setFeedBack(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            setPositionPagerName(str);
            setPositionPagerId(str2);
        }
    }

    public static void setImgChunkUploadEnable(int i) {
        IMG_CHUNK_UPLOAD_ENABLE = i;
    }

    public static int getImgChunkUploadEnable() {
        return IMG_CHUNK_UPLOAD_ENABLE;
    }

    public static final String getBroadcastActionPageAdded() {
        return BROADCAST_PAGE_ADDED;
    }

    public static final String getBroadcastActionSignAlert() {
        return BROADCAST_SIGN_ALERT;
    }

    public static boolean getDebugSwitch() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public static void setAppServer(String str) {
        SERVER_ADDRESS = str;
    }

    public static final String getBroadcastActionChangeSharedPref() {
        return BROADCAST_CHANGE_SHARED_PREF;
    }

    public static String getFullVersion() {
        String version = getVersion();
        return String.valueOf(version) + "." + getSubVersion();
    }

    public static String getLegoLibVersion() {
        return LEGO_LIB_VERSION;
    }

    public static void setLegoLibVersion(String str) {
        LEGO_LIB_VERSION = str;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static void setVersion(String str) {
        VERSION = str;
    }

    public static String getSubVersion() {
        return SUB_VERSION;
    }

    public static void setSubVersion(String str) {
        SUB_VERSION = str;
    }

    public static int getVersionType() {
        return VERSION_TYPE;
    }

    public static void setVersionType(int i) {
        VERSION_TYPE = i;
    }

    public static void setSubappType(String str) {
        SUBAPP_TYPE = str;
    }

    public static String getSubappType() {
        return SUBAPP_TYPE;
    }

    public static void setTempDirName(String str) {
        TMPDIRNAME = str;
    }

    public static String getTempDirName() {
        return TMPDIRNAME;
    }

    public static int getBigImageSize() {
        return BIG_IMAGE_SIZE;
    }

    public static int initPbImageSize(Context context) {
        int i = PB_IMAGE_NEW_MAX_WIDTH;
        int dip2px = k.dip2px(context, 427.0f);
        if (dip2px <= 640) {
            i = dip2px;
        }
        BIG_IMAGE_SIZE = (int) (i * i * 1.6f * 2.0f);
        return BIG_IMAGE_SIZE;
    }

    public static int getPbImageSize() {
        return BIG_IMAGE_SIZE;
    }

    public static void initBigImageMaxUsedMemory(Context context) {
        BIG_IMAGE_MAX_USED_MEMORY = initPbImageSize(context) * 13;
        if (BIG_IMAGE_MAX_USED_MEMORY < UtilHelper.getBitmapMaxMemory(context) * 0.28d) {
            BIG_IMAGE_MAX_USED_MEMORY = (int) (UtilHelper.getBitmapMaxMemory(context) * 0.28d);
        }
    }

    public static int getBigImageMaxUsedMemory() {
        return BIG_IMAGE_MAX_USED_MEMORY;
    }

    public static void setBigImageMaxUsedMemory(int i) {
        BIG_IMAGE_MAX_USED_MEMORY = i;
    }

    public static int getBigImageMaxUsedMemoryForRemoteProcess() {
        return (int) (UtilHelper.getBitmapMaxMemory(TbadkCoreApplication.m9getInst().getContext()) * 0.28d);
    }

    public static String getFrom() {
        return FROM;
    }

    public static void setFrom(String str) {
        FROM = str;
    }

    public static String getCurrentFrom() {
        return CURRENT_FROM;
    }

    public static void setCurrentFrom(String str) {
        CURRENT_FROM = str;
    }

    public static void initFriendPhotoConfig(Context context) {
        if (context != null && context.getResources() != null) {
            if (context.getResources().getDisplayMetrics().density < 1.0f) {
                FRIEND_PHOTO_ADDRESS = PHOTO_SMALL_ADDRESS;
                FRIEND_PHOTO_MAX_SIZE = 80;
                return;
            }
            FRIEND_PHOTO_ADDRESS = PHOTO_BIG_ADDRESS;
            FRIEND_PHOTO_MAX_SIZE = 110;
        }
    }

    public static String getFriendPhotoAddress() {
        return FRIEND_PHOTO_ADDRESS;
    }

    public static int getFriendPhotoMaxSize() {
        return FRIEND_PHOTO_MAX_SIZE;
    }

    public static String getPhotoSmallAddress() {
        return PHOTO_SMALL_ADDRESS;
    }

    public static void setPhotoSmallAddress(String str) {
        PHOTO_SMALL_ADDRESS = str;
    }

    public static void setSmallPhotoAdress(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            PHOTO_SMALL_ADDRESS = str;
        }
    }

    public static void setBigPhotoAdress(String str) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            PHOTO_BIG_ADDRESS = str;
        }
    }

    public static int getNameSize() {
        switch (TbadkCoreApplication.m9getInst().getFontSize()) {
            case 0:
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static int getContentSize() {
        switch (TbadkCoreApplication.m9getInst().getFontSize()) {
            case 0:
                return 20;
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int getContentSizeOfPostTitle() {
        return getContentSize() + 3;
    }

    public static int getContentSizeOfLzl(Context context) {
        return context.getResources().getDisplayMetrics().density >= 2.0f ? 14 : 12;
    }

    public static final String getBroadcastActionPageChanged() {
        return BROADCAST_PAGE_CHANGED;
    }

    public static final String getBroadcastActionImageResized() {
        return BROADCAST_IMAGE_RESIZED;
    }

    public static int getThreadImageMaxWidth() {
        return THREAD_IMAGE_MAX_WIDTH;
    }

    public static void initBigImageWidth(Context context) {
        if (!sThreadImageMaxInited) {
            sThreadImageMaxInited = true;
            int sqrt = (int) Math.sqrt(k.I(context) * k.J(context));
            if (sqrt > THREAD_IMAGE_MAX_WIDTH) {
                THREAD_IMAGE_MAX_WIDTH = sqrt;
            }
            if (Runtime.getRuntime().maxMemory() <= 16777216) {
                THREAD_IMAGE_MAX_WIDTH = (int) (THREAD_IMAGE_MAX_WIDTH * 0.8d);
            }
        }
    }

    public static final int getBigEmotionsSize() {
        return 230400;
    }

    public static int getBubbleImageSize() {
        return 22050;
    }

    public static String getPositionPagerName() {
        return POSITION_PAGER_NAME;
    }

    public static void setPositionPagerName(String str) {
        POSITION_PAGER_NAME = str;
    }

    public static String getPositionPagerId() {
        return POSITION_PAGER_ID;
    }

    public static void setPositionPagerId(String str) {
        POSITION_PAGER_ID = str;
    }

    public static final String getBroadcastActionNewVersion() {
        return BROADCAST_NEWVERSION;
    }

    public static String getBigPhotoAdress() {
        return PHOTO_BIG_ADDRESS;
    }

    public static final String getBroadcastActionOtherProcessSwitchFrontBackground() {
        return BROADCAST_OTHERPROCESSFRONTBACKGROUNDSWITCH;
    }

    public static final String getBroadcastActionChangeSkin() {
        return BROADCAST_CHANGESKIN;
    }
}
