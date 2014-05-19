package com.baidu.tbadk;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class TbConfig {
    public static final int ABSTRACT_AUTO = 0;
    public static final int ABSTRACT_CLOSE = 2;
    public static final int ABSTRACT_OPEN = 1;
    public static final long APP_ENTER_BACKGROUND_INTERVAL = 1000;
    public static final String APP_UPDATE_ACTION = "com.baidu.tieba.NewsVersion";
    public static final int BIG_IMAGE_MIN_CAPACITY = 10000;
    public static final int BIG_IMAGE_MIN_SIZE = 80;
    public static final int BIG_PHOTO_MAX_SIZE = 110;
    private static final String BROADCAST_CHANGE_SHARED_PREF = "com.baidu.tieba.broadcast.changeSharedPref";
    private static final String BROADCAST_CHANGE_SHARED_PREF_SDK = "com.baidu.tiebasdk.broadcast.changeSharedPref";
    private static final String BROADCAST_IMAGE_RESIZED = "com.baidu.tieba.broadcast.image.resized";
    private static final String BROADCAST_IMAGE_RESIZED_SDK = "com.baidu.tiebasdk.broadcast.image.resized";
    private static final String BROADCAST_NEWVERSION = "com.baidu.tieba.broadcast.newversion";
    private static final String BROADCAST_PAGE_CHANGED = "com.baidu.tieba.broadcast.imagepb.pagechanged";
    private static final String BROADCAST_PAGE_CHANGED_SDK = "com.baidu.tiebasdk.broadcast.imagepb.pagechanged";
    public static final String CDN_LOG_ADDRESS = "c/p/updata";
    public static final String CHANNEL_FILE = "channel.dat";
    public static final boolean COULD_UPDATE = true;
    public static final int DATABASE_SD_VERSION = 9;
    public static final String DETECT_USERNAME_ADDRESS = "c/s/detectuname";
    public static final String DIALOG_FROM = "dianzishichang";
    public static final int EMOTION_HEIGHT = 240;
    public static final int EMOTION_HEIGHT_LOW = 160;
    public static final int EMOTION_WIDTH = 240;
    public static final int EMOTION_WIDTH_LOW = 160;
    public static final String ERROR_UPLOAD_SERVER = "c/s/logupload";
    public static final String FATAL_ERROR_DEBUG_FILE = "fatal_error_debug.log";
    public static final String FATAL_ERROR_FILE = "fatal_error.log";
    public static final String FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/voice_fin_chunk_upload";
    public static final String FOLLOW_ADDRESS = "c/c/user/follow";
    public static final int FONT_SIZE_BIG = 1;
    public static final int FONT_SIZE_MID = 2;
    public static final int FONT_SIZE_SMALL = 3;
    public static final String FROM_FILE = "from.dat";
    public static final String GET_IP_LIST = "c/s/getipinfo";
    public static final String GROUP_HEAD_FILE = "tieba_group_image";
    public static final int HEAD_IMG_SIZE = 960;
    public static final String IMAGE_CACHE_DIR_NAME = "images";
    public static final String IMAGE_RESIZED_FILE = "tieba_resized_image";
    public static final String IMAGE_RESIZED_FILE_DISPLAY = "tieba_resized_image_display";
    public static final float IMAGE_ROUND = 10.0f;
    public static final String INPUT_USERNAME_ADDRESS = "c/s/filluname";
    public static final String IN_PV_ADDRESS = "c/s/inpv";
    public static final String JUMP_TO_NEW_USER_CHOOSE_BAR = "c/u/user/getuserlike";
    public static final boolean LBSSWITCH = true;
    public static final String LOAD_REG_PV_ADDRESS = "c/s/pv";
    public static final String LOCAL_CAMERA_DIR = "cameras";
    public static final String LOCAL_PIC_DIR = "photos";
    public static final String LOGIN_ADDRESS = "c/s/login";
    public static final String LOG_ERROR_FILE = "log_error.log";
    public static final String LOG_SYNC_SWITCH = "http://tb1.bdstatic.com/tb/client/logsync2.js";
    public static final String LOG_UPLOAD_URL = "c/s/newlog";
    public static final int MAX_ASYNC_IMAGE_LOADER_NUM = 5;
    public static final int MAX_CASH_FRIEND_PHOTO_NUM = 500;
    public static final int MAX_CASH_PB_PHOTO_NUM = 500;
    public static final int MAX_CASH_USER_ICON_NUM = 100;
    public static final int MAX_FRS_ICON_NUM = 3;
    public static final int MAX_HOME_ICON_NUM = 3;
    public static final int MAX_PB_ICON_NUM = 3;
    public static final int MAX_PERSON_INFO_ICON_NUM = 4;
    public static final int MAX_PRELOAD_PHOTO_NUM = 30;
    public static final int MAX_PRELOAD_PIC_NUM = 13;
    public static final int MAX_SDRAM_PIC_NUM = 13;
    public static final int MAX_TSHOW_ICON_NUM = 2;
    public static final String MSG_DEFAULT_NODISTURB_END_TIME = "09:00";
    public static final String MSG_DEFAULT_NODISTURB_START_TIME = "23:00";
    public static final boolean MSG_DEFAULT_NODISTURB_SWITCH = false;
    public static final int NET_MSG_GETLENTH = 900002;
    public static final int NET_MSG_TOTALLENTH = 900001;
    public static final int NOTIFY_CHAT_ID = 16;
    public static final int NOTIFY_GROUP_EVENT = 18;
    public static final int NOTIFY_GROUP_ID = 17;
    public static final int NOTIFY_LIVE_GROUP_EVENT = 20;
    public static final int NOTIFY_LIVE_NOTIFY = 21;
    public static final int NOTIFY_MESSAGE_ID = 11;
    public static final int NOTIFY_OFFICIAL_MESSAGE = 19;
    public static final int NOTIFY_PUSH_ID = 15;
    public static final int NOTIFY_RECOMMEND_MESSAGE_ID = 13;
    public static final int NOTIFY_SIGN_ID = 12;
    public static final long NOTIFY_SOUND_INTERVAL = 5000;
    public static final long ONE_DAY_TIME = 86400000;
    public static final int PB_DEFAULT_CONTENT_TEXT_SIZE = 16;
    public static final int PB_DEFAULT_NAME_TEXT_SIZE = 11;
    public static final int PB_IMAGE_DIP_MAX_WIDTH = 427;
    public static final int PB_IMAGE_MAX_HEIGHT = 105;
    public static final int PB_IMAGE_MAX_WIDTH = 105;
    public static final float PB_IMAGE_NEW_SCALE = 1.6f;
    public static final int PB_PHOTO_MAX_SIZE = 80;
    public static final int PB_PHOTO_QUALITY = 80;
    public static final String PERSON_HEAD_FILE = "tieba_head_image";
    public static final String PHONE_DATEBASE_NAME = "baidu_tieba.db";
    public static final int PHOTO_DELAY_TIME = 90;
    public static final String PLUGIN_SYNC = "c/s/pluginsconfig";
    public static final int POST_IMAGE_BIG = 900;
    public static final int POST_IMAGE_DISPLAY = 100;
    public static final int POST_IMAGE_MIDDLE = 750;
    public static final int POST_IMAGE_QUALITY = 80;
    public static final int POST_IMAGE_SMALL = 600;
    public static final String PROFILE_HEAD_MODIFY = "c/c/img/portrait";
    public static final boolean PROMOTED_DEFAULT = true;
    public static final int READ_GIF_CACHE_TIMEOUT_WIFI = 500;
    public static final int READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI = 2000;
    public static final int READ_IMAGE_CACHE_TIMEOUT_WIFI = 300;
    public static final String REGISTER_ADDRESS = "c/m/register";
    public static final String SETTINGFILE = "settings";
    public static final String ST_PARAM_PERSON_INFO_SEND_MESSAGE = "3";
    public static final String ST_PARAM_TAB_MSG_CREATE_CHAT = "2";
    public static final String ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK = "1";
    public static final String ST_TYPE_ADD_TO_LAUNCHER = "add_to_launcher";
    public static final String ST_TYPE_CLIENT_SHARE = "client_share";
    public static final String ST_TYPE_ENTER_FORE = "enter_fore";
    public static final String ST_TYPE_EYESHIELD_MODE = "eyeshield";
    public static final String ST_TYPE_LOGIN = "login";
    public static final String ST_TYPE_OPEN = "open";
    public static final String ST_TYPE_PCHAT = "pchat";
    public static final String ST_TYPE_REG = "reg";
    public static final String ST_TYPE_USE = "use";
    public static final String SW_APID = "sw";
    public static final int THREAD_GIF_MIN_USE_MEMORY = 6291456;
    private static final String TMPDIRNAME = "tieba";
    private static final String TMPDIRNAME_SDK = "tieba_sdk";
    public static final String TMP_DATABASE_NAME = "tieba_database.db";
    public static final String TMP_LOGBAK_DIR_NAME = "logbak";
    public static final String TMP_LOG_DIR_NAME = "log";
    public static final String TMP_PIC_DIR_NAME = "image";
    public static final String TMP_SHARE_DIR_NAME = "share";
    public static final String TMP_VOI_DIR_NAME = "voice";
    public static final int TYPE_DAILY_BUILD = 1;
    public static final int TYPE_GRAY_BUILD = 2;
    public static final int TYPE_RELEASE_BUILD = 3;
    public static final String UNFOLLOW_ADDRESS = "c/c/user/unfollow";
    public static final long UPDATE_NOTIFY_INTERVAL = 86400000;
    public static final String UPLOAD_CHUNK_AUDIO_ADDRESS = "c/c/voice/chunkupload";
    public static final int UPLOAD_IMAGE_QUALITY_AUTO = 0;
    public static final int UPLOAD_IMAGE_QUALITY_HIGH = 1;
    public static final int UPLOAD_IMAGE_QUALITY_LOW = 3;
    public static final int UPLOAD_IMAGE_QUALITY_MID = 2;
    public static final String URL_BUYPROPS = "c/e/mema/buyprops";
    public static final String URL_GETPAYINFO = "c/e/mema/getpayinfo";
    public static final int USER_PHOTO_AUTO = 0;
    public static final int USER_PHOTO_CLOSE = 2;
    public static final int USER_PHOTO_OPEN = 1;
    public static final long USE_TIME_INTERVAL = 60000;
    public static final int VIEW_IMAGE_QUALITY_AUTO = 0;
    public static final int VIEW_IMAGE_QUALITY_HIGH = 1;
    public static final int VIEW_IMAGE_QUALITY_HIGH_VALUE = 80;
    public static final int VIEW_IMAGE_QUALITY_LOW = 2;
    public static final int VIEW_IMAGE_QUALITY_LOW_VALUE = 45;
    public static final int VOICE_CHUNK_UPLOAD_SIZE = 30720;
    public static final String VOICE_DATA = "c/p/voice";
    public static final int WEBP_FAILURE_MAX = 5;
    public static final String WEB_VIEW_JUMP2NATIVE = "jump_tieba_native=1";
    public static final String api_key = "GXGROE8KmWiRmcWFpiWTmUbE";
    public static final String app_id = "1095821";
    public static String SERVER_ADDRESS = "http://c.tieba.baidu.com/";
    public static Domain PASS_LOGIN_ADDRESS = Domain.DOMAIN_ONLINE;
    public static boolean USE_OLD_LOGIN = false;
    private static boolean DebugSwitch = false;
    private static String POSITION_PAGER_NAME = "贴吧客户端反馈";
    private static String POSITION_PAGER_ID = "2631903";
    private static String VERSION = "";
    private static String SUB_VERSION = "";
    private static String FROM = null;
    public static final int PB_IMAGE_NEW_MAX_WIDTH = 640;
    private static int THREAD_IMAGE_MAX_WIDTH = PB_IMAGE_NEW_MAX_WIDTH;
    private static int FRIEND_PHOTO_MAX_SIZE = 80;
    private static int VERSION_TYPE = 3;
    public static final Bitmap.Config BitmapConfig = Bitmap.Config.RGB_565;
    private static String CURRENT_FROM = null;
    private static int BIG_IMAGE_SIZE = 1024;
    private static int BIG_IMAGE_MAX_USED_MEMORY = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
    private static String PHOTO_SMALL_ADDRESS = "http://tb.himg.baidu.com/sys/portraitn/item/";
    private static String FRIEND_PHOTO_ADDRESS = PHOTO_SMALL_ADDRESS;
    public static String PHOTO_BIG_ADDRESS = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String IMAGE_ADDRESS = String.valueOf(SERVER_ADDRESS) + "c/p/img?";
    public static String UPLOAD_IMG_URL = String.valueOf(SERVER_ADDRESS) + "c/s/uploadPicture";

    public static boolean getDebugSwitch() {
        return com.baidu.adp.base.a.getInst().isDebugMode();
    }

    public static void degbugInit(Application application) {
        if ((application.getApplicationInfo().flags & 2) == 0) {
            DebugSwitch = false;
        } else {
            DebugSwitch = true;
        }
    }

    public static void setDebugSwitch(boolean z) {
        DebugSwitch = z;
    }

    public static void setAppServer(String str) {
        SERVER_ADDRESS = str;
    }

    public static final String getBroadcastActionChangeSharedPref() {
        return BROADCAST_CHANGE_SHARED_PREF;
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

    public static final String getTempDirName() {
        return TMPDIRNAME;
    }

    public static int getBigImageSize() {
        return BIG_IMAGE_SIZE;
    }

    public static void setBigImageSize(int i) {
        BIG_IMAGE_SIZE = i;
    }

    public static int initPbImageSize(Context context) {
        int i = PB_IMAGE_NEW_MAX_WIDTH;
        int a = com.baidu.adp.lib.util.h.a(context, 427.0f);
        if (a <= 640) {
            i = a;
        }
        BIG_IMAGE_SIZE = (int) (i * i * 1.6f * 2.0f);
        BdLog.d("BIG_IMAGE_SIZE = " + BIG_IMAGE_SIZE);
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
        BdLog.d("BIG_IMAGE_MAX_USED_MEMORY = " + BIG_IMAGE_MAX_USED_MEMORY);
    }

    public static int getBigImageMaxUsedMemory() {
        return BIG_IMAGE_MAX_USED_MEMORY;
    }

    public static void setBigImageMaxUsedMemory(int i) {
        BIG_IMAGE_MAX_USED_MEMORY = i;
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
        switch (TbadkApplication.m252getInst().getFontSize()) {
            case 1:
                return 13;
            case 2:
                return 12;
            default:
                return 11;
        }
    }

    public static int getContentSize() {
        switch (TbadkApplication.m252getInst().getFontSize()) {
            case 1:
                return 18;
            case 2:
                return 17;
            default:
                return 16;
        }
    }

    public static int getContentSizeOfPostTitle() {
        return getContentSize() + 1;
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
        int sqrt = (int) Math.sqrt(com.baidu.adp.lib.util.h.b(context) * com.baidu.adp.lib.util.h.c(context));
        if (sqrt > THREAD_IMAGE_MAX_WIDTH) {
            THREAD_IMAGE_MAX_WIDTH = sqrt;
        }
        if (Runtime.getRuntime().maxMemory() <= 16777216) {
            THREAD_IMAGE_MAX_WIDTH = (int) (THREAD_IMAGE_MAX_WIDTH * 0.8d);
        }
    }

    public static final int getBigEmotionsSize() {
        return 230400;
    }

    public static int getBubbleImageSize() {
        return LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05;
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
}
