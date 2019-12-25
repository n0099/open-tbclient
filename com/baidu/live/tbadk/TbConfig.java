package com.baidu.live.tbadk;

import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class TbConfig {
    public static final int ABSTRACT_AUTO = 0;
    public static final int ABSTRACT_CLOSE = 2;
    public static final int ABSTRACT_OPEN = 1;
    public static final int ADD_IAMGE_WATER_NONE = 0;
    public static final int ADD_IMAGE_WATER_FORUM_NAME = 2;
    public static final int ADD_IMAGE_WATER_USER_NAME = 1;
    public static final String ALA_VERIFY_STRATEGY = "ala/sys/strategy";
    public static final long APP_ENTER_BACKGROUND_INTERVAL = 1000;
    private static String CFROM_HOST = null;
    public static final boolean DEBUG = true;
    public static final int DEFAULT_SDRAM_PHOTO_NUM = 30;
    public static final String DIALOG_FROM = "dianzishichang";
    public static final String FOLLOW_ADDRESS = "c/c/user/follow";
    public static final int FONT_SIZE_BIG = 1;
    public static final int FONT_SIZE_MID = 2;
    public static final int FONT_SIZE_SMALL = 3;
    public static final int FONT_SIZE_XLAGER = 0;
    public static final String FROM_FILE = "from.dat";
    private static String FROM_HOST = null;
    public static final String GET_NUOMI_ORDER = "tbmall/mema/getNuomiOrder";
    public static final String GET_NUOMI_PAY_INFO = "tbmall/nuomi/getOrderStatusByClient";
    public static final String GET_ORDER = "tbmall/mema/getOrder";
    public static final String GET_PAY_CONFIG = "c/s/getClientConfig";
    public static final String HTTP_PREFIX = "http://tieba.baidu.com/f?";
    public static final String LOCAL_CAMERA_DIR = "cameras";
    public static final int MAX_USER_NAME_BYTE_LENGTH = 14;
    public static final int NET_MSG_GETLENTH = 900002;
    public static final int NET_MSG_TOTALLENTH = 900001;
    public static final long ONE_DAY_TIME = 86400000;
    public static final String PHONE_DATEBASE_NAME = "baidu_tieba.db";
    public static final int POST_IMAGE_BIG = 2000;
    public static final int POST_IMAGE_HIGHT_LIMIT = 18000;
    public static final int POST_IMAGE_MIDDLE = 1800;
    public static final int POST_IMAGE_QUALITY = 85;
    public static final int POST_IMAGE_SMALL = 1500;
    public static final boolean PROMOTED_DEFAULT = true;
    public static final String SDK_VERSION = "3.3.0";
    public static final String ST_TYPE_USE = "use";
    private static int SUBAPP_VERSION = 0;
    private static String SUBAPP_VERSION_NAME = null;
    public static final String TMP_ALA_IM_RECORD_DIR_NAME = "imRecord";
    public static final String TMP_DATABASE_NAME = "tieba_database.db";
    public static final String UNFOLLOW_ADDRESS = "c/c/user/unfollow";
    public static final int UPLOAD_IMAGE_QUALITY_AUTO = 0;
    public static final int UPLOAD_IMAGE_QUALITY_HIGH = 1;
    public static final int UPLOAD_IMAGE_QUALITY_LOW = 3;
    public static final int UPLOAD_IMAGE_QUALITY_MID = 2;
    public static final String URL_CHECK_REAL_NAME = "ala/sys/checkRealName";
    public static final String URL_GETPAYINFO = "tbmall/mema/getpayinfo";
    public static final int USER_PHOTO_AUTO = 0;
    public static final int USER_PHOTO_CLOSE = 2;
    public static final int USER_PHOTO_OPEN = 1;
    public static final int VIEW_IMAGE_QUALITY_AUTO = 0;
    public static final int VIEW_IMAGE_QUALITY_HIGH = 1;
    public static final int VIEW_IMAGE_QUALITY_HIGH_VALUE = 80;
    public static final int VIEW_IMAGE_QUALITY_LOW = 2;
    public static final int VIEW_IMAGE_QUALITY_LOW_VALUE = 45;
    public static final int WEBP_FAILURE_MAX = 5;
    public static final String WEB_VIEW_JUMP2NATIVE = "jump_tieba_native=1";
    private static boolean isInitAppServerMap;
    public static String SERVER_ADDRESS = "https://tiebac.baidu.com/";
    public static String SERVER_HOST = TbDomainConfig.DOMAIN_HTTPS_SERVER_HOST;
    public static String LOGIN_FULL_ADDRESS = SERVER_ADDRESS + "c/s/login";
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    private static String POSITION_PAGER_NAME = "贴吧客户端反馈";
    private static String POSITION_PAGER_ID = "2631903";
    private static String VERSION = "";
    private static String SUBAPP_TYPE = "";
    private static String LIVE_ENTER_FROM = "";
    private static String FROM = null;
    public static boolean IM_ENV_DEBUG = false;
    public static boolean IM_LOG = true;
    public static final Bitmap.Config BitmapConfig = Bitmap.Config.RGB_565;
    private static String TMPDIRNAME = "tieba";
    private static String CURRENT_FROM = null;
    private static int BIG_IMAGE_SIZE = 10240;
    public static String PHOTO_SMALL_ADDRESS = "https://himg.baidu.com/sys/portraitn/item/";
    public static String PHOTO_BIG_ADDRESS = "https://himg.baidu.com/sys/portrait/item/";
    public static final String IMAGE_ADDRESS = SERVER_ADDRESS + "c/p/img?";
    public static int FLOWER_GUIDE_STATUS = 0;
    private static int MAX_PHOTO_MEMORY_CACHE = 30;
    public static String UPLOAD_IMG_URL = SERVER_ADDRESS + "c/s/uploadPicture";
    public static String PACKAGE_NAME = "";
    private static Map<Integer, String> mapAppServer = new HashMap();
    public static boolean IS_START_BAIDU_KUANG_CLOSE_SELF = false;

    /* loaded from: classes2.dex */
    public static final class PassConfig {
        public static final String APP_ID = "1";
        public static final String CRIPT_TYPE = "1";
        public static final String ENC_KEY = "6e93e7659ae637845c7f83abee68a740";
        public static final String GET_CERT_URL = "http://passport.baidu.com/sslcrypt/get_last_cert";
        public static final String LOGIN_BDUSS_URL = "http://passport.baidu.com/v2/sapi/bdusslogin";
        public static final String TPL = "tb";
    }

    public static boolean getDebugSwitch() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public static void setAppServer(String str) {
        SERVER_ADDRESS = str;
    }

    public static void setAppServer(int i) {
        if (!isInitAppServerMap) {
            initAppServerMap();
            isInitAppServerMap = true;
        }
        if (i >= 0 && i < mapAppServer.size()) {
            setAppServer(mapAppServer.get(Integer.valueOf(i)));
            Log.i("TbConfig", "setAppServer domainId:" + i + ", address:" + SERVER_ADDRESS);
        }
    }

    private static void initAppServerMap() {
        mapAppServer.put(0, "https://tiebac.baidu.com/");
        mapAppServer.put(1, "http://zhxfoffline.tieba.otp.baidu.com/");
    }

    public static String getVersion() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            return VERSION;
        }
        if (TbadkCoreApplication.getInst().isTieba()) {
            return SUBAPP_VERSION_NAME;
        }
        return VERSION;
    }

    public static void setVersion(String str) {
        VERSION = str;
    }

    public static void setSubappType(String str) {
        SUBAPP_TYPE = str;
    }

    public static String getSubappType() {
        return SUBAPP_TYPE;
    }

    public static int getSubappVersionCode() {
        return SUBAPP_VERSION;
    }

    public static void setSubappVersionCode(int i) {
        SUBAPP_VERSION = i;
    }

    public static String getSubappVersionName() {
        return SUBAPP_VERSION_NAME;
    }

    public static void setSubappVersionName(String str) {
        SUBAPP_VERSION_NAME = str;
    }

    public static void setLiveEnterFrom(String str) {
        LIVE_ENTER_FROM = str;
    }

    public static String getLiveEnterFrom() {
        return LIVE_ENTER_FROM;
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

    public static String getFromHost() {
        Log.i("TbConfig", "getFromHost:" + FROM_HOST);
        return FROM_HOST;
    }

    public static void setFromHost(String str) {
        Log.i("TbConfig", "setFromHost:" + str);
        FROM_HOST = str;
    }

    public static String getCurrentFromHost() {
        Log.i("TbConfig", "getCurrentFromHost:" + CFROM_HOST);
        return CFROM_HOST;
    }

    public static void setCurrentFromHost(String str) {
        Log.i("TbConfig", "setCurrentFromHost:" + str);
        CFROM_HOST = str;
    }
}
