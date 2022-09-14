package com.baidu.tbadk.core.util;

import android.content.res.Resources;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbErrInfo {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final int ERR_SEND_CANCEL = -54;
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
    public transient /* synthetic */ FieldHolder $fh;

    public TbErrInfo() {
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

    public static String getErrMsg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
            if (i != -85) {
                if (i != -84) {
                    if (i != -52) {
                        if (i == -51) {
                            return resources.getString(R.string.obfuscated_res_0x7f0f13ac);
                        }
                        if (i != -7) {
                            if (i == -3) {
                                return resources.getString(R.string.obfuscated_res_0x7f0f139a);
                            }
                            if (i != -2 && i != -1) {
                                if (i != 0) {
                                    switch (i) {
                                        case ERR_LIVE_PLAY_NO_STREAM /* -1129 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a2);
                                        case ERR_LIVE_PLAY_INVALID_CODEC /* -1128 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a0);
                                        case ERR_LIVE_PLAY_NETWORK /* -1127 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a1);
                                        case ERR_LIVE_PLAY_FILE /* -1126 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f139f);
                                        case ERR_LIVE_REMOTE_EXCEPTION /* -1125 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a3);
                                        case ERR_LIVE_TOKEN_EXPIRED /* -1124 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13aa);
                                        case ERR_LIVE_CONNECTION_KICKED /* -1123 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f1398);
                                        case ERR_LIVE_MM_MODULE_FAILED /* -1122 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f139d);
                                        case ERR_LIVE_SDK_PUB_FAILED /* -1121 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a5);
                                        case ERR_LIVE_SDK_INIT_FAILED /* -1120 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a4);
                                        case ERR_LIVE_LIB_LOAD /* -1119 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f139b);
                                        case ERR_LIVE_NOT_SUPPORT /* -1118 */:
                                            return resources.getString(R.string.obfuscated_res_0x7f0f139e);
                                        default:
                                            switch (i) {
                                                case ERR_UOP_CREATE_GROUP_FAIL /* -48 */:
                                                    return resources.getString(R.string.obfuscated_res_0x7f0f1399);
                                                case ERR_UOP_SENDTEXT_INVALID /* -47 */:
                                                    return resources.getString(R.string.obfuscated_res_0x7f0f13a6);
                                                case ERR_UOP_SENDTEXT_TOO_SHORT /* -46 */:
                                                    return resources.getString(R.string.obfuscated_res_0x7f0f13a9);
                                                case ERR_UOP_SENDTEXT_TOO_LONG /* -45 */:
                                                    return resources.getString(R.string.obfuscated_res_0x7f0f13a7);
                                                default:
                                                    switch (i) {
                                                        case ERR_UOP_SENDMSG_TOO_MORE /* -42 */:
                                                            return resources.getString(R.string.obfuscated_res_0x7f0f13a8);
                                                        case ERR_UOP_VOICE_TOO_SHORT /* -41 */:
                                                            return resources.getString(R.string.obfuscated_res_0x7f0f13ae);
                                                        case ERR_USER_OPERATE /* -40 */:
                                                            return resources.getString(R.string.obfuscated_res_0x7f0f13ad);
                                                        default:
                                                            switch (i) {
                                                                case ERR_FILE_SD_FULL /* -26 */:
                                                                    return resources.getString(R.string.obfuscated_res_0x7f0f05bc);
                                                                case ERR_FILE_IO_SD /* -25 */:
                                                                    return resources.getString(R.string.obfuscated_res_0x7f0f05bb);
                                                                case ERR_FILE_SHARED_SD /* -24 */:
                                                                    return resources.getString(R.string.obfuscated_res_0x7f0f05bd);
                                                                case -23:
                                                                    return resources.getString(R.string.obfuscated_res_0x7f0f05b8);
                                                                default:
                                                                    return resources.getString(R.string.obfuscated_res_0x7f0f13ab);
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return null;
                            }
                        }
                    }
                    return resources.getString(R.string.obfuscated_res_0x7f0f0c59);
                }
                return resources.getString(R.string.voice_err_other);
            }
            return resources.getString(R.string.obfuscated_res_0x7f0f139c);
        }
        return (String) invokeI.objValue;
    }

    public static int getFileHelperSDErr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int x = zi.x();
            if (x != 1) {
                if (x != 2) {
                    return x != 3 ? 0 : -25;
                }
                return -24;
            }
            return -23;
        }
        return invokeV.intValue;
    }
}
