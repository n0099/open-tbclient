package com.baidu.live.tbadk.ubc;
/* loaded from: classes11.dex */
public class UbcStatConstant {
    public static final String DEBUG_EVENT_ID = "1435";
    public static final String DEBUG_VALUE_CONTENT_FROM = "live_perform";
    public static final String KEY_CONTENT_COMMON = "common";
    public static final String KEY_CONTENT_EXT = "ext";
    public static final String KEY_CONTENT_EXT_ACTIVITY_NAME = "activity_name";
    public static final String KEY_CONTENT_EXT_ENTRY = "entry";
    public static final String KEY_CONTENT_EXT_IS_MIX = "isMix";
    public static final String KEY_CONTENT_EXT_LIVESDK = "livesdk";
    public static final String KEY_CONTENT_EXT_LIVE_ID = "live_id";
    public static final String KEY_CONTENT_EXT_LM_NETWORK = "net_status";
    public static final String KEY_CONTENT_EXT_LOC = "loc";
    public static final String KEY_CONTENT_EXT_MODE = "mode";
    public static final String KEY_CONTENT_EXT_ROOM_ID = "room_id";
    public static final String KEY_CONTENT_EXT_SID = "sid";
    public static final String KEY_CONTENT_EXT_STATUS = "status";
    public static final String KEY_CONTENT_EXT_SUBPAGE = "subpage";
    public static final String KEY_CONTENT_EXT_VID = "vid";
    public static final String KEY_CONTENT_FROM = "from";
    public static final String KEY_CONTENT_NET = "request";
    public static final String KEY_CONTENT_PAGE = "page";
    public static final String KEY_CONTENT_ROOM = "room";
    public static final String KEY_CONTENT_SOURCE = "source";
    public static final String KEY_CONTENT_TYPE = "type";
    public static final String KEY_CONTENT_VALUE = "value";
    public static final String KEY_CUSTOM_ROOM_ID = "custom_room_id";
    public static final String KEY_IS_INIT = "is_init";
    public static final String KEY_LIVE_TYPE = "live_type";
    public static final String KEY_STATISTIC_FROM = "live_indicators";
    public static final String VALUE_CONTENT_FROM = "live";
    public static final String VALUE_LIVE_TYPE_AUDIO = "voice_live";

    /* loaded from: classes11.dex */
    public static class ContentSource {
        public static final String HAOKAN = "haokan";
        public static final String QUANMIN = "mvapp";
        public static final String SHOUBAI = "shoubai";
        public static final String TIEBA = "tieba";
    }

    /* loaded from: classes11.dex */
    public static class ContentType {
        public static final String ACCESS = "access";
        public static final String CLICK = "click";
        public static final String COVER_CLICK = "cover_clk";
        public static final String DISPLAY = "display";
        public static final String READ = "read";
        public static final String SHOW = "show";
        public static final String UBC_FILTER_IM = "filter_im";
        public static final String UBC_TYPE_AIR_DROP = "air_drop";
        public static final String UBC_TYPE_AUDIO_LIVE_CHAT = "audiolivechat";
        public static final String UBC_TYPE_AUDIO_LIVE_IMRTC = "audioliveimrtc";
        public static final String UBC_TYPE_AUDIO_LIVE_RTC = "audiolivertc";
        public static final String UBC_TYPE_CHALLENGE_CLOSE = "challenge_close";
        public static final String UBC_TYPE_CHALLENGE_CLOSE_RESULT = "challenge_close_result";
        public static final String UBC_TYPE_CHALLENGE_GETMVPTOASTINFO = "challenge_getmvptoastinfo";
        public static final String UBC_TYPE_CHALLENGE_IM = "challenge_im";
        public static final String UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE = "challenge_mvppunishchoose";
        public static final String UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT = "challenge_mvppunishchoose_result";
        public static final String UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT = "challenge_mvptoastinfo_result";
        public static final String UBC_TYPE_CHALLENGE_SCREEN_CHANGE = "challenge_screen_change";
        public static final String UBC_TYPE_CHALLENGE_SUGARDADDYRANKINFO = "challenge_sugardaddyrankinfo";
        public static final String UBC_TYPE_CHALLENGE_SUGARDADDYRANKINFO_RESULT = "challenge_sugardaddyrankinfo_r";
        public static final String UBC_TYPE_CREATE_LIVE = "create_live";
        public static final String UBC_TYPE_CREATE_LIVE_SUCC = "create_live_succ";
        public static final String UBC_TYPE_CREATE_STRATEGY_SUCC = "strategy_succ";
        public static final String UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST = "enter_effect";
        public static final String UBC_TYPE_ENTER_EFFECT = "effect";
        public static final String UBC_TYPE_ENTER_LIVE = "enter_live";
        public static final String UBC_TYPE_ENTER_LIVE_SUCC = "enter_live_succ";
        public static final String UBC_TYPE_GET_LIVE_STATUS = "mget_live_status";
        public static final String UBC_TYPE_GIFT_DYNAMIC_LIST = "dynamic_list";
        public static final String UBC_TYPE_GIFT_NORMAL_LIST = "normal_list";
        public static final String UBC_TYPE_GIFT_PACKAGE_LIST = "package_list";
        public static final String UBC_TYPE_GIFT_SEND_FREE = "send_free";
        public static final String UBC_TYPE_GIFT_SEND_FREE_SUCC = "send_free_succ";
        public static final String UBC_TYPE_GIFT_SEND_PACKAGE = "send_package";
        public static final String UBC_TYPE_GIFT_SEND_PACKAGE_SUCC = "send_package_succ";
        public static final String UBC_TYPE_GIFT_SEND_TDOU = "send_tdou";
        public static final String UBC_TYPE_GIFT_SEND_TDOU_SUCC = "send_tdou_succ";
        public static final String UBC_TYPE_GIFT_SHOW = "gift_show";
        public static final String UBC_TYPE_GOODS_AUTH = "goods_auth";
        public static final String UBC_TYPE_GOODS_AUTH_SUCC = "goods_auth_succ";
        public static final String UBC_TYPE_GOODS_LIST = "goods_list";
        public static final String UBC_TYPE_GOODS_LIST_SUCC = "goods_list_succ";
        public static final String UBC_TYPE_HEADLINE_UPDATE = "headline_update";
        public static final String UBC_TYPE_IM_EXCEPTION = "exc";
        public static final String UBC_TYPE_IM_JOIN = "join";
        public static final String UBC_TYPE_IM_LEAVE = "leave";
        public static final String UBC_TYPE_IM_SEND = "send";
        public static final String UBC_TYPE_IM_WRONG_ID = "wrong_mcastid";
        public static final String UBC_TYPE_LUCKY_BAG = "send_baggift";
        public static final String UBC_TYPE_MEMORY = "memory";
        public static final String UBC_TYPE_NET_WORK = "net_work";
        public static final String UBC_TYPE_PAY_SDK = "pay_sdk";
        public static final String UBC_TYPE_PAY_SDK_SUCC = "pay_sdk_succ";
        public static final String UBC_TYPE_PAY_STATUS = "pay_status";
        public static final String UBC_TYPE_PAY_STATUS_SUCC = "pay_status_succ";
        public static final String UBC_TYPE_PK_ACCPET = "accept";
        public static final String UBC_TYPE_PK_ACCPET_SUCC = "accpet_succ";
        public static final String UBC_TYPE_PK_CANCEL_DIRECT = "canceldirect";
        public static final String UBC_TYPE_PK_CANCEL_DIRECT_SUCC = "canceldirect_succ";
        public static final String UBC_TYPE_PK_CANCEL_RANDOM = "cancelrandom";
        public static final String UBC_TYPE_PK_CANCLE_RANDOM_SUCC = "cancelrandom_succ";
        public static final String UBC_TYPE_PK_CHALLENGE_INFO = "challengeInfo";
        public static final String UBC_TYPE_PK_CHALLENGE_INFO_SUCC = "challengeInfo_succ";
        public static final String UBC_TYPE_PK_DIRECT = "direct";
        public static final String UBC_TYPE_PK_DIRECT_SUCC = "direct_succ";
        public static final String UBC_TYPE_PK_DIRECT_TIMEOUT = "direct_timeout";
        public static final String UBC_TYPE_PK_RANDOM = "random";
        public static final String UBC_TYPE_PK_RANDOM_SUCC = "random_succ";
        public static final String UBC_TYPE_PK_RANDOW_TIMEOUT = "random_timeout";
        public static final String UBC_TYPE_QM_STRATEGY = "qm_strategy";
        public static final String UBC_TYPE_QM_STRATEGY_SUCC = "qm_strategy_succ";
        public static final String UBC_TYPE_RES_DOWN = "res_down";
        public static final String UBC_TYPE_SCROLL_PAGE = "scroll_switch";
        public static final String UBC_TYPE_STRATEGY = "strategy";
        public static final String UBC_TYPE_TYING_GIFT = "tying_gift";
    }

    /* loaded from: classes11.dex */
    public static class DebugContentType {
        public static final String EXCEPTION = "exception";
        public static final String REQUEST = "request";
        public static final String STAT = "stat";
    }

    /* loaded from: classes11.dex */
    public static class DebugContentValue {
        public static final String CREATE_LIVE = "create_live";
        public static final String ENTER_LIVE = "enter_live";
        public static final String GIFT = "gift";
        public static final String IM = "im";
        public static final String PAY = "pay";
        public static final String PK = "pk";
    }

    /* loaded from: classes11.dex */
    public static class Page {
        public static final String AUDIO_LIVE_ROOM = "audio_live_room";
        public static final String AUTHOR_LIVE_ROOM = "author_liveroom";
        public static final String LIVE_ACTION = "liveaction";
        public static final String LIVE_END = "live_end";
        public static final String LIVE_RECOMMEND = "your_recommend";
        public static final String LIVE_ROOM = "liveroom";
        public static final String VOICE_CREATE_ROOM = "create_room";
        public static final String VOICE_ROOM = "voiceroom";
        public static final String VOICE_ROOM_END = "voiceroom_end";
    }

    /* loaded from: classes11.dex */
    public static class SubPage {
        public static final String GUESS_POPUP = "guesspop";
        public static final String POPUP = "popup";
    }

    /* loaded from: classes11.dex */
    public static class Value {
        public static final String BIG_GIFT_DATA_ERROR = "big_gift_data_error";
        public static final String BIG_GIFT_DOWNLOADING = "big_gift_down";
        public static final String BIG_GIFT_PLAY_ERROR = "big_gift_play_error";
        public static final String BIG_GIFT_SHOWING = "big_gift_showing";
        public static final String BIG_GIFT_SPIT = "big_gift_spit";
        public static final String BIG_GIFT_TO_SMALL_GIFT = "big_gift_to_samll";
        public static final String EFFECT_ARCHIVE_ERROR = "effect_archive_error";
        public static final String EFFECT_DELETE = "effect_delet";
        public static final String EFFECT_FILE_ERROR = "effect_file_error";
        public static final String EFFECT_GET_LIVES_ERROR = "get_lives_error";
        public static final String EFFECT_GET_LIVE_STATUS_EXCEP = "get_live_status_exception";
        public static final String EFFECT_SWITCH_ROOM = "switch_room";
        public static final String EFFECT_SWITCH_ROOM_EXCEP = "switch_exception";
        public static final String GIFT_DELETE = "gift_delet";
        public static final String NET_ERROR = "net_error";
        public static final String VALUE_AIRDROP_DISMISS = "air_drop_dismiss";
        public static final String VALUE_AIRDROP_REFRESH = "air_drop_refresh";
        public static final String VALUE_AIRDROP_REFUSE = "air_drop_refuse";
        public static final String VALUE_AIRDROP_SHOW = "air_drop_show";
        public static final String VALUE_BARRAGE_CARD_RECEIVE = "bullechat_ give";
        public static final String VALUE_BC_CHAT_APPLY_CFM = "linkapply_cfm";
        public static final String VALUE_BC_CHAT_APPLY_CLICK = "linkapply_clk";
        public static final String VALUE_BC_CHAT_DUO_BEAUTY_SHOW = "chatbeauty_show";
        public static final String VALUE_BC_CHAT_DUO_CHAT_CLICK = "duochat_clk";
        public static final String VALUE_BC_CHAT_DUO_LINK_APPLY_CLICK = "linkapply_clk";
        public static final String VALUE_BC_CHAT_DUO_LINK_APPLY_FAIL = "linkapply_fail";
        public static final String VALUE_BC_CHAT_DUO_LINK_APPLY_SUCCESS = "linkapply_succ";
        public static final String VALUE_BC_CHAT_DUO_LINK_CLOSE_CAN = "linkclose_can";
        public static final String VALUE_BC_CHAT_DUO_LINK_CLOSE_CFM = "linkclose_cfm";
        public static final String VALUE_BC_CHAT_DUO_LINK_CLOSE_SHOW = "linkclose_show";
        public static final String VALUE_BC_CHAT_DUO_LINK_SUCCESS = "duolink_succ";
        public static final String VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK = "chatbeauty_clk";
        public static final String VALUE_BC_CHAT_DUO_PRE_POP_SEC = "duochatpop_esc";
        public static final String VALUE_BC_CHAT_DUO_PRE_POP_SHOW = "duochatpop_show";
        public static final String VALUE_BC_CHAT_LINK_CANCEL_CLICK = "linkcancel_clk";
        public static final String VALUE_BC_CHAT_LINK_CANCEL_SHOW = "linkcancel_show";
        public static final String VALUE_BC_CHAT_LINK_CLOSE_CLICK = "linkclose_clk";
        public static final String VALUE_BC_CHAT_LINK_CONFIRM_CLICK = "linkcfm_clk";
        public static final String VALUE_BC_CHAT_LINK_CONFIRM_SHOW = "linkcfm_show";
        public static final String VALUE_BC_CHAT_SHOW_APPLY_PANEL = "linkapply_show";
        public static final String VALUE_CHAT_INVITE_TAB_SHOW = "invitetab_show";
        public static final String VALUE_CHAT_LINK_CLICK = "chatlink_clk";
        public static final String VALUE_CHAT_LINK_CLOSE_CAN = "linkclose_can";
        public static final String VALUE_CHAT_LINK_CLOSE_CFM = "linkclose_cfm";
        public static final String VALUE_CHAT_LINK_CLOSE_CLICK = "linkclose_clk";
        public static final String VALUE_CHAT_LINK_CLS_TAB_SHOW = "linkclstab_show";
        public static final String VALUE_CHAT_LINK_FAIL = "chatlink_fail";
        public static final String VALUE_CHAT_LINK_INVITE_ACC = "linkinvite_acc";
        public static final String VALUE_CHAT_LINK_INVITE_RFS = "linkinvite_rfs";
        public static final String VALUE_CHAT_LINK_INVITE_SHOW = "linkinvite_show";
        public static final String VALUE_CHAT_LINK_SUCCESS = "chatlink_succ";
        public static final String VALUE_CHAT_LINK_TAB_SHOW = "linktab_show";
        public static final String VALUE_DAILY_TASK_BUTTON_CLICK = "taskbtn_clk";
        public static final String VALUE_DAILY_TASK_BUTTON_SHOW = "taskbtn_show";
        public static final String VALUE_FILTER_IM = "localfilter_msg";
        public static final String VALUE_HEADLINE_FROM_IM = "im";
        public static final String VALUE_HEADLINE_FROM_SERVER = "liveInfo";
        public static final String VALUE_HOST_POKE = "anchorpoke_clk";
        public static final String VALUE_HOST_POKE_SUCCESS = "anchorpoke_succ";
        public static final String VALUE_INVITE_BTN_CLICK = "invitebtn_clk";
        public static final String VALUE_LUCKYBAG_OPEN = "receive_baggiftopen";
        public static final String VALUE_LUCKYBAG_RECEIVE = "receive_baggift";
        public static final String VALUE_LUCKYBAG_RECEIVE_TOTAL = "receive_baggifttotal";
        public static final String VALUE_LUCKYBAG_SEND_FAIL = "send_bag_fail";
        public static final String VALUE_LUCKYBAG_SEND_REQUEST = "send_bagrequest";
        public static final String VALUE_LUCKYBAG_SEND_SUCC = "send_bag_suc";
        public static final String VALUE_QUICK_CLICK = "quickchat_clk";
        public static final String VALUE_QUICK_SHOW = "quickchat_show";
        public static final String VALUE_TYING_GIFT_GATHER = "tying_gift_gather";
        public static final String VALUE_TYING_IM_REC = "tying_im_rec";
        public static final String VALUE_TYING_PENDANT_SHOW = "tying_pendant_show";
        public static final String VALUE_USER_POKE_BACK = "userpoke_clk";
        public static final String VALUE_USER_POKE_BACK_SUCCESS = "userpoke_succ";
    }
}
