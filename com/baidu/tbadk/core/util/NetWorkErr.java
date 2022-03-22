package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NetWorkErr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_ALERT_DELETE_CODE = 1211066;
    public static final int ERROR_BZC_USER_BLOCK = 220012;
    public static final int ERROR_BZC_USER_MANAGER_NUM = 240104;
    public static final int ERROR_CONTENT_WITH_SENSITIVE_WORD = 220015;
    public static final int ERROR_DELETE_MCN_USER_THREAD = 1211067;
    public static final int ERROR_FORBID_POST_LIVE = 220012;
    public static final int ERROR_GET_FLOWER_MORE_LIMIT = 146021;
    public static final int ERROR_IS_REPEAT_FORBIDDEN = 1211068;
    public static final int ERROR_LINK_COUNT_EXCEED_LIMIT = 3300001;
    public static final int ERROR_MUTE_EYONG_LIMIT = 220017;
    public static final int ERROR_NOT_MEMBER = 1990043;
    public static final int ERROR_NOT_VIP = 1990056;
    public static final int ERROR_NO_USER_NAME = 2260104;
    public static final int ERROR_POST_FREQUENTLY = 220034;
    public static final int ERROR_REPLY_PRIVACY_MY_ATTENTION = 238009;
    public static final int ERROR_REPLY_PRIVACY_MY_FANS = 238010;
    public static final int ERROR_SHOW_APPLY_MEMBER_DIALOG = 3300003;
    public static final int ERROR_UEG_BIND_MOBILE = 3250017;
    public static final int ERROR_UEG_DOUBLE_CHECK = 3250024;
    public static final int ERROR_UEG_FACE_VERIFY = 3250023;
    public static final int ERROR_UEG_IDENTITY_VERIFY = 3250020;
    public static final int ERROR_UEG_MODIFY_PWD = 3250022;
    public static final int ERROR_UEG_PHONE_VERIFY = 3250021;
    public static final int ERROR_USER_BLOCK = 1990059;
    public static final int ERR_PHONE_GBLOCK_ERROR = 3250012;
    public static final int ERR_PRIFORUM_NEED_BIND_PHONE = 2121002;
    public static final int ERR_UNREALNAME_AUTH = 1990055;
    public static final int FORBID_APPEALING = 3250013;
    public static final int FORBID_BAWU = 3250004;
    public static final int FORBID_BLOCK = 3250002;
    public static final int FORBID_SYSTEM = 3250001;
    public static final int FORBID_SYSTEM_INNER = 3250003;
    public static final int FORUM_FORBID = 340001;
    public static final int GET_FORUM_LIST_ERROR = 110001;
    public static final int HAVE_SIGNED = 160002;
    public static final int NEED_ACCOUNT_ACEESS = 227001;
    public static final int NEED_UEG_VALIDATE = 220009;
    public static final int NEED_VCODE = 5;
    public static final int NETWORK_CANCEL = -14;
    public static final int NETWORK_DATA_TOO_BIG = -11;
    public static final int NETWORK_ERR = -1;
    public static final int NETWORK_HTTP_EXCEPTION = -18;
    public static final int NETWORK_IGNORE = -2;
    public static final int NETWORK_IO_EXCEPTION = -19;
    public static final int NETWORK_MEMORY_SMALL = -16;
    public static final int NETWORK_NO_DATA_RECEIVED = -17;
    public static final int NETWORK_OK = 0;
    public static final int NETWORK_OUTOFMEMORY = -15;
    public static final int NETWORK_SOCKET_EXCEPTION = -12;
    public static final int NETWORK_SOCKET_TIMEOUT = -13;
    public static final int NETWORK_SSL_EXCEPTION = -20;
    public static final int NETWORK_UNKNOWN = -10;
    public static final int NO_MORE_IMAGE = 40;
    public static final int THREAD_NOT_EXIST = 4;
    public static final int USERNAME_CANT_USE = 36;
    public static final int USERNAME_OR_PASSWD_ERROR = 2;
    public static final int USER_HAS_LIKE_FORUM = 22;
    public static final int USER_NOT_LOGIN = 1;
    public static final int USER_OR_THREAD_BLOCKED = 350008;
    public static final int VCODE_INPUT_ERROR = 6;
    public transient /* synthetic */ FieldHolder $fh;

    public NetWorkErr() {
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
