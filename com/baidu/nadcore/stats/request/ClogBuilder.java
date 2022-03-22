package com.baidu.nadcore.stats.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.a0.c.c;
import c.a.a0.a0.c.d;
import c.a.a0.x.b;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ClogBuilder extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final JSONObject f27642c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Area {
        public static final /* synthetic */ Area[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Area AD_CALL;
        public static final Area AD_NOTIFICATION_BTN_CLICK;
        public static final Area AD_NOTIFICATION_ITEM_CLICK;
        public static final Area AD_NOTIFICATION_NOTIFY;
        public static final Area AD_NOTIFICATION_REMOVE;
        public static final Area AD_NOTIFICATION_SHOW;
        public static final Area APP_PERMISSION;
        public static final Area APP_PRIVACY;
        public static final Area AUTO_HIDE;
        public static final Area BUTTON;
        public static final Area CLOSE_BTN;
        public static final Area DIALOG;
        public static final Area DIALOG_KEYBACK;
        public static final Area DIALOG_NEGATIVE;
        public static final Area DIALOG_POSITIVE;
        public static final Area FLOATING;
        public static final Area HOTAREA;
        public static final Area ICON;
        public static final Area IMAGE;
        public static final Area INSTALL_LATER_BUTTON;
        public static final Area INSTALL_NOW_BUTTON;
        public static final Area INVALID;
        public static final Area NAME;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1658808665, "Lcom/baidu/nadcore/stats/request/ClogBuilder$Area;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1658808665, "Lcom/baidu/nadcore/stats/request/ClogBuilder$Area;");
                    return;
                }
            }
            ICON = new Area("ICON", 0, "icon");
            NAME = new Area("NAME", 1, "name");
            BUTTON = new Area("BUTTON", 2, "button");
            INSTALL_NOW_BUTTON = new Area("INSTALL_NOW_BUTTON", 3, "install_now_button");
            INSTALL_LATER_BUTTON = new Area("INSTALL_LATER_BUTTON", 4, "install_later_button");
            HOTAREA = new Area("HOTAREA", 5, "hotarea");
            AD_NOTIFICATION_ITEM_CLICK = new Area("AD_NOTIFICATION_ITEM_CLICK", 6, "ad_notification_item_click");
            AD_NOTIFICATION_BTN_CLICK = new Area("AD_NOTIFICATION_BTN_CLICK", 7, "ad_notification_btn_click");
            AD_NOTIFICATION_SHOW = new Area("AD_NOTIFICATION_SHOW", 8, "ad_notification_show");
            AD_NOTIFICATION_NOTIFY = new Area("AD_NOTIFICATION_NOTIFY", 9, "ad_notification_notify");
            AD_NOTIFICATION_REMOVE = new Area("AD_NOTIFICATION_REMOVE", 10, "ad_notification_remove");
            DIALOG = new Area("DIALOG", 11, "popup");
            DIALOG_POSITIVE = new Area("DIALOG_POSITIVE", 12, "popup_select");
            DIALOG_NEGATIVE = new Area("DIALOG_NEGATIVE", 13, "popup_cancel");
            DIALOG_KEYBACK = new Area("DIALOG_KEYBACK", 14, "popup_back");
            AD_CALL = new Area("AD_CALL", 15, "CALL");
            APP_PRIVACY = new Area("APP_PRIVACY", 16, "app_privacy");
            APP_PERMISSION = new Area("APP_PERMISSION", 17, "app_permission");
            FLOATING = new Area("FLOATING", 18, "floating_btn");
            IMAGE = new Area("IMAGE", 19, "image");
            CLOSE_BTN = new Area("CLOSE_BTN", 20, "close_btn");
            AUTO_HIDE = new Area("AUTO_HIDE", 21, "auto_hide");
            Area area = new Area("INVALID", 22, "INVALID");
            INVALID = area;
            $VALUES = new Area[]{ICON, NAME, BUTTON, INSTALL_NOW_BUTTON, INSTALL_LATER_BUTTON, HOTAREA, AD_NOTIFICATION_ITEM_CLICK, AD_NOTIFICATION_BTN_CLICK, AD_NOTIFICATION_SHOW, AD_NOTIFICATION_NOTIFY, AD_NOTIFICATION_REMOVE, DIALOG, DIALOG_POSITIVE, DIALOG_NEGATIVE, DIALOG_KEYBACK, AD_CALL, APP_PRIVACY, APP_PERMISSION, FLOATING, IMAGE, CLOSE_BTN, AUTO_HIDE, area};
        }

        public Area(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static Area valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Area) Enum.valueOf(Area.class, str) : (Area) invokeL.objValue;
        }

        public static Area[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Area[]) $VALUES.clone() : (Area[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class LogType {
        public static final /* synthetic */ LogType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LogType AD_CALL;
        public static final LogType AD_NOTIFICATION_NOTIFY_FAILED;
        public static final LogType CHAN_MORE;
        public static final LogType CHECK;
        public static final LogType CLICK;
        public static final LogType CLOSE;
        public static final LogType DAZZLE_CARD_SHOW;
        public static final LogType DAZZLE_CLICK;
        public static final LogType DAZZLE_IN;
        public static final LogType DAZZLE_OUT;
        public static final LogType DAZZLE_TRANS_SLIDING_COUNT;
        public static final LogType DEEPLINK_STAY_TIME;
        public static final LogType DEEPLINK_STAY_TRANS;
        public static final LogType DEEP_LINK;
        public static final LogType DISCARD;
        public static final LogType DOWNLOAD_COMPLETE;
        public static final LogType DOWNLOAD_CONTINUE;
        public static final LogType DOWNLOAD_FAILED;
        public static final LogType DOWNLOAD_INSTALL;
        public static final LogType DOWNLOAD_PAUSE;
        public static final LogType DOWNLOAD_RETRY;
        public static final LogType DOWNLOAD_START;
        public static final LogType DURATION;
        public static final LogType EXCEPTION;
        public static final LogType FAIL;
        public static final LogType FREE_CLICK;
        public static final LogType FREE_SHOW;
        public static final LogType GESTURE_MATCH_FAILURE;
        public static final LogType GESTURE_MATCH_SUCCESS;
        public static final LogType HOME_PAGE_FIRST_SCREEN_AD_SHOW;
        public static final LogType HW_API_REQUEST;
        public static final LogType INSTALL_COMPLETE;
        public static final LogType INTERACTION_COLLECT;
        public static final LogType INTERACTION_COMMENT;
        public static final LogType INTERACTION_FOLLOW;
        public static final LogType INTERACTION_PRAISE;
        public static final LogType INTERACTION_SHARE;
        public static final LogType LOTTIE_CLICK;
        public static final LogType LOTTIE_DISMISS;
        public static final LogType LOTTIE_LOAD_FAIL;
        public static final LogType LOTTIE_LONG_PRESS;
        public static final LogType LOTTIE_RES_PREFETCH_FAIL;
        public static final LogType LOTTIE_SHOW;
        public static final LogType NAVIDEO_POP_CLOSE;
        public static final LogType OPEN_APP;
        public static final LogType PHONE_STATE_LISTEN;
        public static final LogType PLACEHOLDER;
        public static final LogType PLAY_ZERO_SEC;
        public static final LogType REWARD_COIN_FAIL;
        public static final LogType REWARD_TOKEN_FAIL;
        public static final LogType SHOW;
        public static final LogType SKIP;
        public static final LogType STOCK;
        public static final LogType TAIL_FRAME_SHOW_TIME;
        public static final LogType TOP_VIEW_SPEED_STATE;
        public static final LogType TRUE_VIEW;
        public static final LogType VIDEO_COMPLETED;
        public static final LogType VIDEO_LP_BT;
        public static final LogType VIDEO_LP_PV;
        public static final LogType VIDEO_LP_TAIL_CLICK;
        public static final LogType VIDEO_LP_VIDEO_HIDE;
        public static final LogType VIDEO_PAUSE;
        public static final LogType VIDEO_RESUME;
        public static final LogType VIDEO_START;
        public static final LogType VISIBLE_SHOW;
        public static final LogType VISIBLE_TWO_SEC;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-299487388, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-299487388, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;");
                    return;
                }
            }
            CLICK = new LogType("CLICK", 0, "2");
            SHOW = new LogType("SHOW", 1, "3");
            DISCARD = new LogType("DISCARD", 2, "5");
            FAIL = new LogType("FAIL", 3, "6");
            CLOSE = new LogType("CLOSE", 4, "7");
            FREE_SHOW = new LogType("FREE_SHOW", 5, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            FREE_CLICK = new LogType("FREE_CLICK", 6, "102");
            VIDEO_LP_BT = new LogType("VIDEO_LP_BT", 7, "12");
            VIDEO_LP_PV = new LogType("VIDEO_LP_PV", 8, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            VIDEO_LP_VIDEO_HIDE = new LogType("VIDEO_LP_VIDEO_HIDE", 9, "131");
            CHAN_MORE = new LogType("CHAN_MORE", 10, "22");
            DEEP_LINK = new LogType("DEEP_LINK", 11, "706");
            VISIBLE_SHOW = new LogType("VISIBLE_SHOW", 12, "203");
            VIDEO_LP_TAIL_CLICK = new LogType("VIDEO_LP_TAIL_CLICK", 13, "102");
            DOWNLOAD_START = new LogType("DOWNLOAD_START", 14, "701");
            DOWNLOAD_PAUSE = new LogType("DOWNLOAD_PAUSE", 15, "702");
            DOWNLOAD_CONTINUE = new LogType("DOWNLOAD_CONTINUE", 16, "703");
            DOWNLOAD_COMPLETE = new LogType("DOWNLOAD_COMPLETE", 17, "704");
            DOWNLOAD_INSTALL = new LogType("DOWNLOAD_INSTALL", 18, "705");
            DOWNLOAD_RETRY = new LogType("DOWNLOAD_RETRY", 19, "708");
            DOWNLOAD_FAILED = new LogType("DOWNLOAD_FAILED", 20, "709");
            INSTALL_COMPLETE = new LogType("INSTALL_COMPLETE", 21, "710");
            OPEN_APP = new LogType("OPEN_APP", 22, "713");
            AD_CALL = new LogType("AD_CALL", 23, "777");
            VISIBLE_TWO_SEC = new LogType("VISIBLE_TWO_SEC", 24, "213");
            TAIL_FRAME_SHOW_TIME = new LogType("TAIL_FRAME_SHOW_TIME", 25, "52");
            DURATION = new LogType("DURATION", 26, "331");
            TRUE_VIEW = new LogType("TRUE_VIEW", 27, "332");
            DAZZLE_IN = new LogType("DAZZLE_IN", 28, "51");
            DAZZLE_OUT = new LogType("DAZZLE_OUT", 29, "52");
            DAZZLE_TRANS_SLIDING_COUNT = new LogType("DAZZLE_TRANS_SLIDING_COUNT", 30, "54");
            DAZZLE_CLICK = new LogType("DAZZLE_CLICK", 31, "102");
            DAZZLE_CARD_SHOW = new LogType("DAZZLE_CARD_SHOW", 32, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            PLAY_ZERO_SEC = new LogType("PLAY_ZERO_SEC", 33, "30");
            VIDEO_START = new LogType("VIDEO_START", 34, "31");
            VIDEO_PAUSE = new LogType("VIDEO_PAUSE", 35, "32");
            VIDEO_RESUME = new LogType("VIDEO_RESUME", 36, "33");
            VIDEO_COMPLETED = new LogType("VIDEO_COMPLETED", 37, "34");
            EXCEPTION = new LogType("EXCEPTION", 38, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT);
            CHECK = new LogType("CHECK", 39, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC);
            TOP_VIEW_SPEED_STATE = new LogType("TOP_VIEW_SPEED_STATE", 40, "801");
            NAVIDEO_POP_CLOSE = new LogType("NAVIDEO_POP_CLOSE", 41, "8");
            INTERACTION_PRAISE = new LogType("INTERACTION_PRAISE", 42, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            INTERACTION_SHARE = new LogType("INTERACTION_SHARE", 43, "108");
            INTERACTION_COMMENT = new LogType("INTERACTION_COMMENT", 44, TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP);
            SKIP = new LogType("SKIP", 45, "11");
            STOCK = new LogType("STOCK", 46, "13");
            GESTURE_MATCH_SUCCESS = new LogType("GESTURE_MATCH_SUCCESS", 47, "9");
            GESTURE_MATCH_FAILURE = new LogType("GESTURE_MATCH_FAILURE", 48, TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE);
            INTERACTION_FOLLOW = new LogType("INTERACTION_FOLLOW", 49, TbEnum.SystemMessage.EVENT_ID_COMMON);
            AD_NOTIFICATION_NOTIFY_FAILED = new LogType("AD_NOTIFICATION_NOTIFY_FAILED", 50, "111");
            LOTTIE_LONG_PRESS = new LogType("LOTTIE_LONG_PRESS", 51, "112");
            LOTTIE_SHOW = new LogType("LOTTIE_SHOW", 52, "113");
            LOTTIE_DISMISS = new LogType("LOTTIE_DISMISS", 53, "114");
            LOTTIE_CLICK = new LogType("LOTTIE_CLICK", 54, "115");
            LOTTIE_RES_PREFETCH_FAIL = new LogType("LOTTIE_RES_PREFETCH_FAIL", 55, ApsConstants.TYPE_ANDROID_PLUGIN);
            LOTTIE_LOAD_FAIL = new LogType("LOTTIE_LOAD_FAIL", 56, "117");
            HOME_PAGE_FIRST_SCREEN_AD_SHOW = new LogType("HOME_PAGE_FIRST_SCREEN_AD_SHOW", 57, "118");
            HW_API_REQUEST = new LogType("HW_API_REQUEST", 58, "119");
            DEEPLINK_STAY_TRANS = new LogType("DEEPLINK_STAY_TRANS", 59, "751");
            DEEPLINK_STAY_TIME = new LogType("DEEPLINK_STAY_TIME", 60, "752");
            INTERACTION_COLLECT = new LogType("INTERACTION_COLLECT", 61, "805");
            PHONE_STATE_LISTEN = new LogType("PHONE_STATE_LISTEN", 62, "807");
            REWARD_TOKEN_FAIL = new LogType("REWARD_TOKEN_FAIL", 63, "781");
            REWARD_COIN_FAIL = new LogType("REWARD_COIN_FAIL", 64, "782");
            LogType logType = new LogType("PLACEHOLDER", 65, "-1");
            PLACEHOLDER = logType;
            $VALUES = new LogType[]{CLICK, SHOW, DISCARD, FAIL, CLOSE, FREE_SHOW, FREE_CLICK, VIDEO_LP_BT, VIDEO_LP_PV, VIDEO_LP_VIDEO_HIDE, CHAN_MORE, DEEP_LINK, VISIBLE_SHOW, VIDEO_LP_TAIL_CLICK, DOWNLOAD_START, DOWNLOAD_PAUSE, DOWNLOAD_CONTINUE, DOWNLOAD_COMPLETE, DOWNLOAD_INSTALL, DOWNLOAD_RETRY, DOWNLOAD_FAILED, INSTALL_COMPLETE, OPEN_APP, AD_CALL, VISIBLE_TWO_SEC, TAIL_FRAME_SHOW_TIME, DURATION, TRUE_VIEW, DAZZLE_IN, DAZZLE_OUT, DAZZLE_TRANS_SLIDING_COUNT, DAZZLE_CLICK, DAZZLE_CARD_SHOW, PLAY_ZERO_SEC, VIDEO_START, VIDEO_PAUSE, VIDEO_RESUME, VIDEO_COMPLETED, EXCEPTION, CHECK, TOP_VIEW_SPEED_STATE, NAVIDEO_POP_CLOSE, INTERACTION_PRAISE, INTERACTION_SHARE, INTERACTION_COMMENT, SKIP, STOCK, GESTURE_MATCH_SUCCESS, GESTURE_MATCH_FAILURE, INTERACTION_FOLLOW, AD_NOTIFICATION_NOTIFY_FAILED, LOTTIE_LONG_PRESS, LOTTIE_SHOW, LOTTIE_DISMISS, LOTTIE_CLICK, LOTTIE_RES_PREFETCH_FAIL, LOTTIE_LOAD_FAIL, HOME_PAGE_FIRST_SCREEN_AD_SHOW, HW_API_REQUEST, DEEPLINK_STAY_TRANS, DEEPLINK_STAY_TIME, INTERACTION_COLLECT, PHONE_STATE_LISTEN, REWARD_TOKEN_FAIL, REWARD_COIN_FAIL, logType};
        }

        public LogType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static LogType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogType) Enum.valueOf(LogType.class, str) : (LogType) invokeL.objValue;
        }

        public static LogType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogType[]) $VALUES.clone() : (LogType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Page {
        public static final /* synthetic */ Page[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Page AD_CALL;
        public static final Page AD_INSTALL_TIPS;
        public static final Page AD_NOTIFICATION;
        public static final Page AD_START_INSTALL_TIPS;
        public static final Page AD_TAIL;
        public static final Page DOWNLOAD_RECTIFY;
        public static final Page INVALID;
        public static final Page NAVIDEO_POP;
        public static final Page NA_SPLASH;
        public static final Page PAGE_NA;
        public static final Page PAGE_SEARCHBOX;
        public static final Page PAGE_VIDEO_IMMERSIVE_LP;
        public static final Page PAGE_VIDEO_LANDING;
        public static final Page PAGE_VIDEO_TAIL;
        public static final Page POPUP;
        public static final Page RETARGET;
        public static final Page REWARD_VIDEO;
        public static final Page VIDEO_LIST;
        public static final Page WELFAREMAXLP;
        public static final Page WELFAREPANEL;
        public static final Page WELFARETAIL;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1645460251, "Lcom/baidu/nadcore/stats/request/ClogBuilder$Page;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1645460251, "Lcom/baidu/nadcore/stats/request/ClogBuilder$Page;");
                    return;
                }
            }
            AD_CALL = new Page("AD_CALL", 0, "AD_CALL");
            AD_NOTIFICATION = new Page("AD_NOTIFICATION", 1, "AD_NOTIFICATION");
            RETARGET = new Page("RETARGET", 2, "RETARGET");
            AD_START_INSTALL_TIPS = new Page("AD_START_INSTALL_TIPS", 3, "AD_START_INSTALL_TIPS");
            AD_INSTALL_TIPS = new Page("AD_INSTALL_TIPS", 4, "AD_INSTALL_TIPS");
            POPUP = new Page("POPUP", 5, "popup");
            PAGE_NA = new Page("PAGE_NA", 6, "page_na");
            PAGE_SEARCHBOX = new Page("PAGE_SEARCHBOX", 7, "HOMEPAGE");
            AD_TAIL = new Page("AD_TAIL", 8, "TAIL");
            PAGE_VIDEO_LANDING = new Page("PAGE_VIDEO_LANDING", 9, "NAVIDEO");
            PAGE_VIDEO_TAIL = new Page("PAGE_VIDEO_TAIL", 10, "NAVIDEO_TAIL");
            REWARD_VIDEO = new Page("REWARD_VIDEO", 11, "REWARD_VIDEO");
            NA_SPLASH = new Page("NA_SPLASH", 12, "NA_SPLASH");
            DOWNLOAD_RECTIFY = new Page("DOWNLOAD_RECTIFY", 13, "DOWNLOAD_RECTIFY");
            VIDEO_LIST = new Page("VIDEO_LIST", 14, "VIDEOLIST");
            WELFAREPANEL = new Page("WELFAREPANEL", 15, "WELFAREPANEL");
            WELFAREMAXLP = new Page("WELFAREMAXLP", 16, "WELFAREMAXLP");
            WELFARETAIL = new Page("WELFARETAIL", 17, "WELFARETAIL");
            PAGE_VIDEO_IMMERSIVE_LP = new Page("PAGE_VIDEO_IMMERSIVE_LP", 18, "IMMERSIVE_VIDEOADDETAIL");
            NAVIDEO_POP = new Page("NAVIDEO_POP", 19, "NAVIDEO_POP");
            Page page = new Page("INVALID", 20, "INVALID");
            INVALID = page;
            $VALUES = new Page[]{AD_CALL, AD_NOTIFICATION, RETARGET, AD_START_INSTALL_TIPS, AD_INSTALL_TIPS, POPUP, PAGE_NA, PAGE_SEARCHBOX, AD_TAIL, PAGE_VIDEO_LANDING, PAGE_VIDEO_TAIL, REWARD_VIDEO, NA_SPLASH, DOWNLOAD_RECTIFY, VIDEO_LIST, WELFAREPANEL, WELFAREMAXLP, WELFARETAIL, PAGE_VIDEO_IMMERSIVE_LP, NAVIDEO_POP, page};
        }

        public Page(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static Page valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Page) Enum.valueOf(Page.class, str) : (Page) invokeL.objValue;
        }

        public static Page[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Page[]) $VALUES.clone() : (Page[]) invokeV.objValue;
        }
    }

    public ClogBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27642c = b.b(null);
        c("origin_time", String.valueOf(System.currentTimeMillis()));
    }

    @Override // c.a.a0.a0.c.a, c.a.a0.a0.c.d
    public <T extends d> T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            c(str, str2);
            return this;
        }
        return (T) invokeLL.objValue;
    }

    @Override // c.a.a0.a0.c.a
    public <T extends d> T c(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            b.e(this.f27642c, str, obj);
            return this;
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27642c : (JSONObject) invokeV.objValue;
    }

    public ClogBuilder g(Area area) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, area)) == null) {
            c("da_area", area.type);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            c("da_area", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            c("da_ext1", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    @Override // c.a.a0.a0.c.c, c.a.a0.a0.c.d
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TextUtils.isEmpty(this.f27642c.optString("da_type"))) {
                return false;
            }
            return super.isValid();
        }
        return invokeV.booleanValue;
    }

    public ClogBuilder j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c("da_ext2", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            c("da_ext3", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            c("da_ext4", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            c("da_ext5", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            c("extra_param", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            c("da_menu1", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            c("da_menu2", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder q(Page page) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, page)) == null) {
            c(BdVideoAd.AD_VIDEO_DAPAGE, page.type);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            c(BdVideoAd.AD_VIDEO_DAPAGE, str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder s(LogType logType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, logType)) == null) {
            c("da_type", logType.type);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    public ClogBuilder t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            c("da_type", str);
            return this;
        }
        return (ClogBuilder) invokeL.objValue;
    }

    @Override // c.a.a0.a0.c.c, c.a.a0.a0.c.a, c.a.a0.a0.c.d
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            super.toString();
            if (this.a.toString().contains("ad")) {
                return this.a.toString();
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f27642c);
                String encode = URLEncoder.encode(jSONArray.toString(), IMAudioTransRequest.CHARSET);
                if (this.a.length() > 0) {
                    this.a.append('&');
                }
                StringBuilder sb = this.a;
                sb.append("ad");
                sb.append('=');
                sb.append(encode);
                return sb.toString();
            } catch (Exception unused) {
                return this.a.toString();
            }
        }
        return (String) invokeV.objValue;
    }
}
