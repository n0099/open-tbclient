package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.silentupdate.a;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class PushConstants {
    public static final String ACTION_MESSAGE = "com.baidu.android.pushservice.action.MESSAGE";
    public static final String ACTION_METHOD = "com.baidu.android.pushservice.action.METHOD";
    public static final String ACTION_RECEIVE = "com.baidu.android.pushservice.action.RECEIVE";
    public static final String ACTION_RECEIVER_NOTIFICATION_CLICK = "com.baidu.android.pushservice.action.notification.CLICK";
    public static final String ACTION_SDK_MESSAGE = "com.baidu.android.pushservice.action.SDK_MESSAGE";
    public static final String ACTION_SDK_RECEIVE = "com.baidu.android.pushservice.action.sdk.RECEIVE";
    public static final String ACTION_WEB_RECEIVE = "com.baidu.android.pushservice.action.web.RECEIVE";
    public static final int BIND_STATUS_OFFLINE = 1;
    public static final int BIND_STATUS_ONLINE = 0;
    public static final int ERROR_AUTHENTICATION_FAILED = 30603;
    public static final int ERROR_BIND_NOT_EXIST = 30608;
    public static final int ERROR_BIND_OVERLOAD = 30609;
    public static final int ERROR_CHANNEL_TOKEN_TIMEOUT = 30607;
    public static final int ERROR_DATA_NOT_FOUND = 30605;
    public static final int ERROR_METHOD_ERROR = 30601;
    public static final int ERROR_NETWORK_ERROR = 10001;
    public static final int ERROR_PARAMS_ERROR = 30602;
    public static final int ERROR_QUOTA_USE_UP = 30604;
    public static final int ERROR_SERVER_INTERNAL_ERROR = 30600;
    public static final int ERROR_SERVICE_NOT_AVAILABLE = 10002;
    public static final int ERROR_SERVICE_NOT_AVAILABLE_TEMP = 10003;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_TIME_EXPIRES = 30606;
    public static final int ERROR_UNKNOWN = 20001;
    public static final String EXTRA_ACCESS_TOKEN = "access_token";
    public static final String EXTRA_API_KEY = "secret_key";
    public static final String EXTRA_APP = "app";
    public static final String EXTRA_APP_ID = "app_id";
    public static final String EXTRA_BIND_NAME = "bind_name";
    public static final String EXTRA_BIND_STATUS = "bind_status";
    public static final String EXTRA_CB_URL = "cb_url";
    public static final String EXTRA_CONTENT = "content";
    public static final String EXTRA_ERROR_CODE = "error_msg";
    public static final String EXTRA_EXTRA = "extra_extra_custom_content";
    public static final String EXTRA_FETCH_NUM = "fetch_num";
    public static final String EXTRA_FETCH_TYPE = "fetch_type";
    public static final String EXTRA_GID = "gid";
    public static final String EXTRA_GROUP_FETCH_NUM = "group_fetch_num";
    public static final String EXTRA_GROUP_FETCH_TYPE = "group_fetch_type";
    public static final String EXTRA_HASHCODE = "hash_code";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_MSG = "push_ msg";
    public static final String EXTRA_MSGID = "msgid";
    public static final String EXTRA_MSG_IDS = "msg_ids";
    public static final String EXTRA_MSG_KEY = "push_ msg_key";
    public static final String EXTRA_NOTIFICATION_CONTENT = "notification_content";
    public static final String EXTRA_NOTIFICATION_TITLE = "notification_title";
    public static final String EXTRA_OPENTYPE = "open_type";
    public static final String EXTRA_PUSH_MESSAGE = "message";
    public static final String EXTRA_PUSH_MESSAGE_STRING = "message_string";
    public static final String EXTRA_PUSH_SDK_VERSION = "push_sdk_version";
    public static final String EXTRA_TAGS = "tags";
    public static final String EXTRA_TAGS_LIST = "tags_list";
    public static final String EXTRA_TIMESTAMP = "time_stamp";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String EXTRA_WEB_BIND_API_KEY = "com.baidu.pushservice.webapp.apikey";
    public static final int LOGIN_TYPE_ACCESS_TOKEN = 1;
    public static final int LOGIN_TYPE_API_KEY = 0;
    public static final int LOGIN_TYPE_BDUSS = 2;
    public static final int LOGIN_TYPE_UNKNOWN = 9;
    public static final String METHOD_APPSTART = "method_appstart";
    public static final String METHOD_APPSTOP = "method_appstop";
    public static final String METHOD_BIND = "method_bind";
    public static final String METHOD_COUNT = "method_count";
    public static final String METHOD_COUNTGMSG = "method_countgmsg";
    public static final String METHOD_DELETE = "method_delete";
    public static final String METHOD_DEL_TAGS = "method_del_tags";
    public static final String METHOD_FETCH = "method_fetch";
    public static final String METHOD_FETCHGMSG = "method_fetchgmsg";
    public static final String METHOD_GBIND = "method_gbind";
    public static final String METHOD_GINFO = "method_ginfo";
    public static final String METHOD_GLIST = "method_glist";
    public static final String METHOD_GUNBIND = "method_gunbind";
    public static final String METHOD_LISTTAGS = "method_listtags";
    public static final String METHOD_ONLINE = "method_online";
    public static final String METHOD_SEND = "method_send";
    public static final String METHOD_SEND_MSG_TO_SERVER = "method_send_msg_to_server";
    public static final String METHOD_SEND_MSG_TO_USER = "method_send_msg_to_user";
    public static final String METHOD_SET_TAGS = "method_set_tags";
    public static final String METHOD_UNBIND = "method_unbind";
    public static final int OPEN_BY_NOTIFICATION = 1;
    public static final int OPEN_BY_USER = 0;
    public static final String PACKAGE_NAME = "pkg_name";
    private static final int a = 1024;
    private static final String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n";

    public static String rsaEncrypt(String str) {
        try {
            return a.a(a(str.getBytes(), b, 1024), "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static Intent createMethodIntent(Context context) {
        return !LoadExecutor.loadPush(context) ? new Intent() : com.baidu.android.pushservice.apiproxy.PushConstants.createMethodIntent(context);
    }

    public static void restartPushService(Context context) {
        if (LoadExecutor.loadPush(context)) {
            com.baidu.android.pushservice.apiproxy.PushConstants.restartPushService(context);
        }
    }

    public static void startPushService(Context context) {
        if (LoadExecutor.loadPush(context)) {
            com.baidu.android.pushservice.apiproxy.PushConstants.startPushService(context);
        }
    }

    public static String getErrorMsg(int i) {
        switch (i) {
            case 0:
                return "Success";
            case 10001:
                return "Network Problem";
            case 10002:
                return "Service not available";
            case 10003:
                return "Service not available temporary";
            case 30600:
                return "Internal Server Error";
            case 30601:
                return "Method Not Allowed";
            case 30602:
                return "Request Params Not Valid";
            case 30603:
                return "Authentication Failed";
            case 30604:
                return "Quota Use Up Payment Required";
            case 30605:
                return "Data Required Not Found";
            case 30606:
                return "Request Time Expires Timeout";
            case 30607:
                return "Channel Token Timeout";
            case 30608:
                return "Bind Relation Not Found";
            case 30609:
                return "Bind Number Too Many";
            default:
                return "Unknown";
        }
    }

    private static byte[] a(byte[] bArr, String str, int i) {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(a.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int i2 = i / 8;
        int i3 = i2 - 11;
        int length = bArr.length;
        byte[] bArr2 = new byte[(((length + i3) - 1) / i3) * i2];
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            int i6 = length - i5;
            if (i3 < i6) {
                i6 = i3;
            }
            byte[] bArr3 = new byte[i6];
            System.arraycopy(bArr, i5, bArr3, 0, i6);
            i5 += i6;
            System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, i4, i2);
            i4 += i2;
        }
        return bArr2;
    }
}
