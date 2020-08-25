package com.baidu.live.tbadk.core.data;
/* loaded from: classes7.dex */
public final class ConstantData {

    /* loaded from: classes7.dex */
    public static class BookType {
        public static final int TYPE_MANGA = 3;
        public static final int TYPE_NOVEL = 2;
        public static final int TYPE_PUBLICATION = 1;
    }

    /* loaded from: classes7.dex */
    public static class Mute {
        public static final int MUTE = 1;
        public static final int UN_MUTE = 0;
    }

    /* loaded from: classes7.dex */
    public static class MuteFrom {
        public static final int MANAGER = 1;
        public static final int OPERATE = 0;
        public static final int SUBPB = 2;
    }

    /* loaded from: classes7.dex */
    public class Number {
        public static final int ONE = 1;
        public static final int ZERO = 0;

        public Number() {
        }
    }

    /* loaded from: classes7.dex */
    public class Account {
        public static final int ACCOUNT_IM_NORMAL = 0;
        public static final int ACCOUNT_IM_OFFICIAL = 1;
        public static final int ACCOUT_ACTIVE = 1;
        public static final int ACCOUT_INACTIVE = 0;
        public static final int LOGIN_NO = 0;
        public static final int LOGIN_YES = 1;

        public Account() {
        }
    }

    /* loaded from: classes7.dex */
    public class Logo {
        public static final String LOGO_AD_APK_PACKAGE_NAME = "apk_name";
        public static final String LOGO_AD_APK_SIZE = "apk_size";
        public static final String LOGO_AD_APK_URL = "apk_url";
        public static final String LOGO_AD_APP_NAME = "app_name";
        public static final String LOGO_JUMP_URL = "url";
        public static final String LOGO_JUMP_URL_TPYE = "url_type";
        public static final int URL_TYPE_ANDROID_DOWN = 3;
        public static final int URL_TYPE_NORMAL = 1;
        public static final int URL_TYPE_READ_ONLY = 4;

        public Logo() {
        }
    }

    /* loaded from: classes7.dex */
    public class User {
        public static final int FORBID_ADMIN = 1;
        public static final int FORBID_BAWU = 3;
        public static final int FORBID_NONE = 0;
        public static final int FORBID_SYSTEM = 2;
        public static final int FORUM_MANAGER_BIG = 1;
        public static final int FORUM_MANAGER_NON = 0;
        public static final int FORUM_MANAGER_SMALL = 2;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_UNKNOWN = 0;
        public static final int HAS_NICKNAME = 0;
        public static final int HAS_TAIL_NO = 0;
        public static final int HAS_TAIL_YES = 1;
        public static final int IM_OFFICIAL_ACCOUNT = 4;
        public static final int IM_OFFICIAL_BAR = 1;
        public static final int IM_PERSONAL = 0;
        public static final int IM_SUBSCRIBE_BAR = 3;
        public static final int IS_FRIEND = 1;
        public static final int IS_LIKE = 1;
        public static final int LEFT_CALLED = 1;
        public static final int MEMBER_ADVANCED = 2;
        public static final int MEMBER_ANNUAL = 3;
        public static final int MEMBER_NON = 0;
        public static final int MEMBER_NORMAL = 1;
        public static final int NOT_CORE_USER = 0;
        public static final int NOT_FRIEND = 0;
        public static final int NOT_INTERESTMAN = 0;
        public static final int NOT_LIKE = 0;
        public static final int NO_NICKNAME = 1;
        public static final int PRIVACY_HIDE_TOTAL_ = 3;
        public static final int PRIVACY_OPEN_FRIEND = 2;
        public static final int PRIVACY_OPEN_TOTAL = 1;
        public static final int TYPE_GOD_USER_MULTI = 1;
        public static final int TYPE_GOD_USER_SINGLE = 2;
        public static final int TYPE_PGC = 3;
        public static final int USER_APPROVE_NOT = 0;
        public static final int USER_APPROVE_YES = 1;
        public static final int USER_HIDDEN_NO = 0;
        public static final int USER_HIDDEN_YES = 1;
        public static final int USER_TYPE_ANONYMITY = 0;
        public static final int USER_TYPE_CERTIFICATION = 2;
        public static final int USER_TYPE_LOGIN = 1;

        public User() {
        }
    }

    /* loaded from: classes7.dex */
    public class Forum {
        public static final int FOLLOWED = 1;
        public static final int FORUM_TYPE_NORMAL = 0;
        public static final int FORUM_TYPE_OFFICIACL = 1;
        public static final int FORUM_TYPE_SUBSCRIBE = 2;
        public static final int HAS_SIGNIN_NO = 0;
        public static final int HAS_SIGNIN_YES = 1;
        public static final int NOT_FOLLOWED = 0;
        public static final String SPECAIL_FORUM_TYPE_GAME = "game";
        public static final String SPECAIL_FORUM_TYPE_LIVE = "showlive";

        public Forum() {
        }
    }

    /* loaded from: classes7.dex */
    public class ThreadPost {
        public static final int FANS_IS_CALLED = 0;
        public static final int MARKED_NOMAL = 1;
        public static final int MARKED_ONLY_HOST = 2;
        public static final int MARKED_REVERSE = 4;
        public static final int POST_CONTENT_AT = 4;
        public static final int POST_CONTENT_BASE_EMOTION = 2;
        public static final int POST_CONTENT_BIGEMOTION = 11;
        public static final int POST_CONTENT_COLOR_TEXT = 7;
        public static final int POST_CONTENT_LINK = 1;
        public static final int POST_CONTENT_PICTURE = 3;
        public static final int POST_CONTENT_TELEPHONE = 9;
        public static final int POST_CONTENT_TEXT = 0;
        public static final int POST_CONTENT_VIDEO = 5;
        public static final int POST_CONTENT_VOICE = 10;
        public static final int THREADACTIVE_STATUS_CLOSE = 3;
        public static final int THREADACTIVE_STATUS_EXPIRE = 2;
        public static final int THREADACTIVE_STATUS_NORMAL = 1;
        public static final int THREAD_ACTIVITY_NO = 0;
        public static final int THREAD_ACTIVITY_NON = 0;
        public static final int THREAD_ACTIVITY_NORMAL = 1;
        public static final int THREAD_ACTIVITY_PRIZE = 1;
        public static final int THREAD_ACTIVITY_REPOST = 2;
        public static final int THREAD_ACTIVITY_YES = 1;
        public static final int THREAD_GOOD_NO = 0;
        public static final int THREAD_GOOD_YES = 1;
        public static final int THREAD_HAS_TITLE = 0;
        public static final int THREAD_INTERVIEW_INVALID = -1;
        public static final int THREAD_INTERVIEW_NORMAL = 2;
        public static final int THREAD_INTERVIEW_NOT_START = 1;
        public static final int THREAD_INTERVIEW_TIMEOUT = 3;
        public static final int THREAD_LIKE = 1;
        public static final int THREAD_LIVE_INTERVIEW = 0;
        public static final int THREAD_LIVE_NO = 0;
        public static final int THREAD_LIVE_PICTURE = 2;
        public static final int THREAD_LIVE_TEXT = 1;
        public static final int THREAD_LIVE_YES = 1;
        public static final int THREAD_NOT_LIKE = 0;
        public static final int THREAD_NO_TITLE = 1;
        public static final int THREAD_TOP_NO = 0;
        public static final int THREAD_TOP_YES = 1;
        public static final int THREAD_TYPE_ACTIVITY = 12;
        public static final int THREAD_TYPE_ALA_LIVE_EMPTY = 51;
        public static final int THREAD_TYPE_ALA_SHARE_THREAD = 60;
        public static final int THREAD_TYPE_ALA_VIDEO_LIVE = 49;
        public static final int THREAD_TYPE_ALA_VIDEO_RECORD = 50;
        public static final int THREAD_TYPE_ANNOUNCEMENT = 2;
        public static final int THREAD_TYPE_CONVENE = 42;
        public static final int THREAD_TYPE_EXPAND_REPLY = 52;
        public static final int THREAD_TYPE_INTERVIEW_LIVE = 41;
        public static final int THREAD_TYPE_LINK = 54;
        public static final int THREAD_TYPE_NORMAL = 0;
        public static final int THREAD_TYPE_NOTITLE = 19;
        public static final int THREAD_TYPE_OFFICAL = 1003;
        public static final int THREAD_TYPE_PHOTO_LIVE = 33;
        public static final int THREAD_TYPE_REPLY_MORE = 53;
        public static final int THREAD_TYPE_REPSOT = 8;
        public static final int THREAD_TYPE_TOP = 1;
        public static final int THREAD_TYPE_U9 = 3;
        public static final int THREAD_TYPE_VIDEO = 40;
        public static final int THREAD_TYPE_VOICE = 11;
        public static final int THREAD_TYPE_VOTE = 36;
        public static final int THREAD_VOICE_NO = 0;
        public static final int THREAD_VOICE_YES = 1;
        public static final int THREAD_VOTE_NO = 0;
        public static final int THREAD_VOTE_PIC = 2;
        public static final int THREAD_VOTE_TEXT = 1;
        public static final int THREAD_VOTE_YES = 1;

        public ThreadPost() {
        }
    }

    /* loaded from: classes7.dex */
    public class PageState {
        public static final int FIRST_PAGE = 1;
        public static final int HAS_MORE_NO = 0;
        public static final int HAS_MORE_YES = 1;
        public static final int HAS_PRE_NO = 0;
        public static final int HAS_PRE_YES = 1;

        public PageState() {
        }
    }

    /* loaded from: classes7.dex */
    public class PluginType {
        public static final int NORMAL = 0;

        public PluginType() {
        }
    }

    /* loaded from: classes7.dex */
    public class BooleanInt {
        public static final int FALSE = 0;
        public static final int TRUE = 1;

        public BooleanInt() {
        }
    }

    /* loaded from: classes7.dex */
    public class Personalized {
        public static final int TAG_TYPE_ALA_LIVE = 7;
        public static final int TAG_TYPE_ALA_VIDEO = 4;
        public static final int TAG_TYPE_GOD = 3;
        public static final int TAG_TYPE_LEGO = 5;
        public static final int TAG_TYPE_PERSONALIZED = 1;
        public static final int TAG_TYPE_RECOMMEND = 2;

        public Personalized() {
        }
    }

    /* loaded from: classes7.dex */
    public class Lego {
        public static final int LEGO_BUSINESS_CONTAINER = 0;
        public static final int LEGO_BUSINESS_FRS = 1;
        public static final int LEGO_BUSINESS_HOMEPAGE = 2;
        public static final int LEGO_BUSINESS_HOMEPAGE_TAB = 3;
        public static final int LEGO_BUSINESS_PB = 4;
        public static final int LEGO_BUSINESS_UI = 5;

        public Lego() {
        }
    }

    /* loaded from: classes7.dex */
    public class PAGE_NAME {
        public static final int FRS = 1;
        public static final int PB = 2;

        public PAGE_NAME() {
        }
    }

    /* loaded from: classes7.dex */
    public class VideoLocationType {
        public static final String ACTIVE_LIST = "activelist";
        public static final String CONCERN_TAB = "concern_tab";
        public static final String FLOOR_10 = "floor10";
        public static final String FLOOR_15 = "floor15";
        public static final String FRS = "frs";
        public static final String FRS_5FLOOR = "floor5";
        public static final String HEAD_VIDEO = "headvideo";
        public static final String HOME = "index";
        public static final String HOT_TOPIC_JUHE = "hot_juhe";
        public static final String MID = "midpage";
        public static final String PB = "pb";
        public static final String PERSON_PROFILE = "profile";
        public static final String PUSH = "push";
        public static final String VIDEO_AGGREGATION = "frs_bavideotab";
        public static final String VIDEO_MIDDEL_PAGE = "auto_midpage";
        @Deprecated
        public static final String VIDEO_SQUARE_DYNAMIC = "focus_tab";
        public static final String VIDEO_SQUARE_LIVE_BANNER = "square_live_banner";
        public static final String VIDEO_SQUARE_RECOMMEND = "recom_tab";
        public static final String VIDEO_TAB = "tab";
        public static final String VIDEO_TAB2 = "tab2";
        public static final String WSP_BAVIDEOTAB = "wsp_bavideotab";

        public VideoLocationType() {
        }
    }

    /* loaded from: classes7.dex */
    public class VideoProductionType {
        public static final String MIS_CONFIG = "2";
        public static final String RECOMMEND = "1";

        public VideoProductionType() {
        }
    }

    /* loaded from: classes7.dex */
    public class VideoChannelState {
        public static final int HAS_ORDER = 1;
        public static final int NOT_ORDER = 2;

        public VideoChannelState() {
        }
    }

    /* loaded from: classes7.dex */
    public class PbPageFromType {
        public static final int TYPE_FROM_AT_ME = 13;
        public static final int TYPE_FROM_DEFAULT = 0;
        public static final int TYPE_FROM_FRS = 3;
        public static final int TYPE_FROM_GAME_BAR_RECOMMEND_TAB = 14;
        public static final int TYPE_FROM_HOME_AND_SQUARE_VIDEO = 9;
        public static final int TYPE_FROM_HOME_CONCERN = 1;
        public static final int TYPE_FROM_IM_REPLY_ME = 12;
        public static final int TYPE_FROM_KUANG = 6;
        public static final int TYPE_FROM_MY_COLLECTION = 10;
        public static final int TYPE_FROM_MY_HISTORY = 11;
        public static final int TYPE_FROM_PERSONAL_CENTER = 4;
        public static final int TYPE_FROM_PUSH_MESSAGE = 7;
        public static final int TYPE_FROM_RECOMMEND = 2;
        public static final int TYPE_FROM_SEARCH_RESULT = 8;
        public static final int TYPE_FROM_WEB = 5;

        public PbPageFromType() {
        }
    }

    /* loaded from: classes7.dex */
    public class PbForumNameShowSize {
        public static final int MAX_FORUM_LENGTH_FIRST_FLOOR_SOURCES = 7;
        public static final int MAX_FORUM_LENGTH_NAVIGATION_BAR = 7;
        public static final int MAX_FORUM_LENGTH_REPLY_FLOOR_SOURCE = 5;

        public PbForumNameShowSize() {
        }
    }

    /* loaded from: classes7.dex */
    public class PbThreadPraise {
        public static final int AGREE_TYPE_BIG_KENG = 4;
        public static final int AGREE_TYPE_BIG_ZAN = 1;
        public static final int AGREE_TYPE_KENG = 3;
        public static final int AGREE_TYPE_ZAN = 2;
        public static final int CANCEL_PRAISED = 1;
        public static final int COMMIT_PRAISED = 0;
        public static final int MAX_LENGTH_SHOW_USERNAME = 5;
        public static final int OBJ_TYPE_FLOOR_REPLY = 1;
        public static final int OBJ_TYPE_MAIN_THREAD = 3;
        public static final int OBJ_TYPE_SUBPB_REPLY = 2;

        public PbThreadPraise() {
        }
    }

    /* loaded from: classes7.dex */
    public class AlaUser {
        public static final int OFFICIAL_TYPE_PATROLLER = 1;
        public static final int OFFICIAL_TYPE_STAGE = 2;

        public AlaUser() {
        }
    }

    /* loaded from: classes7.dex */
    public class PrivacySetting {
        public static final int DEFAULT = 0;
        public static final int FRIEND = 2;
        public static final int HIDE = 3;
        public static final int MY_ATTENTIONS = 6;
        public static final int MY_FANS = 5;
        public static final int PART = 4;
        public static final int PUBLIC = 1;

        public PrivacySetting() {
        }
    }

    /* loaded from: classes7.dex */
    public class ThreadCardShowType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_ONE = 1;
        public static final int TYPE_TWO = 2;

        public ThreadCardShowType() {
        }
    }

    /* loaded from: classes7.dex */
    public class PhotoLiveCommonData {
        public static final int MAX_CHOOSE_STYLE = 3;
        public static final int MAX_THREAD_EXPRESSION_COUNT = 3;
        public static final int MIN_RANDOM_NUM = 1;

        public PhotoLiveCommonData() {
        }
    }
}
