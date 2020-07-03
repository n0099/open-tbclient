package com.baidu.live.tbadk.core.util;

import android.content.res.Resources;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class TbErrInfo {
    public static final int ERR_FILE_IO_SD = -25;
    public static final int ERR_FILE_NO_SD = -23;
    public static final int ERR_FILE_SD_FULL = -26;
    public static final int ERR_FILE_SHARED_SD = -24;
    public static final int ERR_FILE_UNKNOWN = -27;
    public static final int ERR_GROUP_ACTIVITY_NOT_EXIST = 2230504;
    public static final int ERR_GROUP_NOT_EXIST = 2230101;
    public static final int ERR_HTTP_DATA_FORMAT = -3;
    public static final int ERR_HTTP_INVALID = -1;
    public static final int ERR_HTTP_TIMEOUT = -2;
    public static final int ERR_HTTP_UNKNOWN = -7;
    public static final int ERR_IMG_ADD_MEMORY = -1006;
    public static final int ERR_IMG_CACHE = -1004;
    public static final int ERR_IMG_DECODE_WEBP = -1012;
    public static final int ERR_IMG_FILE = -1007;
    public static final int ERR_IMG_LOAD_BITMAP = -1008;
    public static final int ERR_IMG_RESIZE = -1005;
    public static final int ERR_IMG_SEND = -1002;
    public static final int ERR_INVALID_CACHE = -18;
    public static final int ERR_LIVE_CONNECTION_KICKED = -1123;
    public static final int ERR_LIVE_LIB_LOAD = -1119;
    public static final int ERR_LIVE_MM_MODULE_FAILED = -1122;
    public static final int ERR_LIVE_NOT_SUPPORT = -1118;
    public static final int ERR_LIVE_PLAY_FILE = -1126;
    public static final int ERR_LIVE_PLAY_INVALID_CODEC = -1128;
    public static final int ERR_LIVE_PLAY_NETWORK = -1127;
    public static final int ERR_LIVE_PLAY_NO_STREAM = -1129;
    public static final int ERR_LIVE_REMOTE_EXCEPTION = -1125;
    public static final int ERR_LIVE_SDK_INIT_FAILED = -1120;
    public static final int ERR_LIVE_SDK_PUB_FAILED = -1121;
    public static final int ERR_LIVE_TOKEN_EXPIRED = -1124;
    public static final int ERR_LOCATION_FAILED = -85;
    public static final int ERR_LOTTERY_UNLIKE_FORUM = 3110004;
    public static final int ERR_NO_LOTTERY_CHANCE = 2390003;
    public static final int ERR_REUPLOAD_FILE = 320033;
    public static final int ERR_SEND_FAIL = -53;
    public static final int ERR_SERVER_UNKNOW = -51;
    public static final int ERR_SOKCET_SWITCH_HTTP = 110005;
    public static final int ERR_SQLITE_ABORT = -11;
    public static final int ERR_SQLITE_CONSTRAINT = -12;
    public static final int ERR_SQLITE_DATABASE_CORRUPT = -14;
    public static final int ERR_SQLITE_DISK_IO = -15;
    public static final int ERR_SQLITE_DONE = -19;
    public static final int ERR_SQLITE_FULL = -16;
    public static final int ERR_SQLITE_UNKNOWN = -17;
    public static final int ERR_UNKNOW = -52;
    public static final int ERR_UNLOGIN = 110000;
    public static final int ERR_UN_ONLINE = 110004;
    public static final int ERR_UOP_CREATE_GROUP_FAIL = -48;
    public static final int ERR_UOP_SENDMSG_TOO_MORE = -42;
    public static final int ERR_UOP_SENDTEXT_INVALID = -47;
    public static final int ERR_UOP_SENDTEXT_TOO_LONG = -45;
    public static final int ERR_UOP_SENDTEXT_TOO_SHORT = -46;
    public static final int ERR_UOP_VOICE_TOO_SHORT = -41;
    public static final int ERR_USER_OPERATE = -40;
    public static final int ERR_VOICE_RECORD = -84;
    public static final int ERR_VOI_DOWN = -1104;
    public static final int ERR_VOI_FILE = -1103;
    public static final int ERR_VOI_FILENAME = -1106;
    public static final int ERR_VOI_HEADSET = -1111;
    public static final int ERR_VOI_LEN = -1105;
    public static final int ERR_VOI_PAUSE = -1102;
    public static final int ERR_VOI_SEND = -1113;
    public static final int ERR_VOI_SPEAKER = -1107;
    public static final int ERR_VOI_START = -1101;
    public static final int ERR_VOI_UNREGISTPLUGIN = -1110;
    public static final int ERR_VOI_UNREGISTSENSOR = -1109;
    public static final int ERR_VOI_UPDATEVIEW = -1112;
    public static final int ERR_VOI_VOLUME = -1108;
    public static final int STATS_OK = 0;

    public static String getErrMsg(int i) {
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        switch (i) {
            case -1129:
                return resources.getString(a.i.sdk_tb_err_play_no_stream);
            case -1128:
                return resources.getString(a.i.sdk_tb_err_play_invalid_codec);
            case -1127:
                return resources.getString(a.i.sdk_tb_err_play_network);
            case -1126:
                return resources.getString(a.i.sdk_tb_err_play_file);
            case -1125:
                return resources.getString(a.i.sdk_tb_err_remote_exception);
            case -1124:
                return resources.getString(a.i.sdk_tb_err_token_expired);
            case -1123:
                return resources.getString(a.i.sdk_tb_err_connection_kicked);
            case -1122:
                return resources.getString(a.i.sdk_tb_err_mm_module_failed);
            case -1121:
                return resources.getString(a.i.sdk_tb_err_sdk_pub_failed);
            case -1120:
                return resources.getString(a.i.sdk_tb_err_sdk_init_failed);
            case -1119:
                return resources.getString(a.i.sdk_tb_err_load_lib_failed);
            case -1118:
                return resources.getString(a.i.sdk_tb_err_not_support);
            case -85:
                return resources.getString(a.i.sdk_tb_err_location_failed);
            case -84:
                return resources.getString(a.i.sdk_voice_err_other);
            case -52:
            case -7:
            case -2:
            case -1:
                return resources.getString(a.i.sdk_neterror);
            case -51:
                return resources.getString(a.i.sdk_tb_err_unknown);
            case -48:
                return resources.getString(a.i.sdk_tb_err_create_group_failed);
            case -47:
                return resources.getString(a.i.sdk_tb_err_send_invalid);
            case -46:
                return resources.getString(a.i.sdk_tb_err_send_too_short);
            case -45:
                return resources.getString(a.i.sdk_tb_err_send_too_long);
            case -42:
                return resources.getString(a.i.sdk_tb_err_send_too_more);
            case -41:
                return resources.getString(a.i.sdk_tb_err_voice_short);
            case -40:
                return resources.getString(a.i.sdk_tb_err_user_operation);
            case -26:
                return resources.getString(a.i.sdk_error_sd_full);
            case -25:
                return resources.getString(a.i.sdk_error_sd_error);
            case -24:
                return resources.getString(a.i.sdk_error_sd_shared);
            case -23:
                return resources.getString(a.i.sdk_error_no_sdcard);
            case -3:
                return resources.getString(a.i.sdk_tb_err_data_format);
            case 0:
                return null;
            default:
                return resources.getString(a.i.sdk_tb_err_undefine);
        }
    }

    public static int getFileHelperSDErr() {
        switch (BdFileHelper.getSdError()) {
            case 1:
                return -23;
            case 2:
                return -24;
            case 3:
                return -25;
            default:
                return 0;
        }
    }
}
