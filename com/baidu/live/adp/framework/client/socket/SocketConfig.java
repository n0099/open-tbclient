package com.baidu.live.adp.framework.client.socket;

import android.app.Application;
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class SocketConfig {
    public static final int ERR_UN_ONLINE = 110004;
    public static final int LCS_SWITCH_HTTP_ERR_NO = 110005;
    private static int BASE_ERROR_NO = -100000000;
    public static final int CODEC_INVALID_MSG = BASE_ERROR_NO - 200;
    public static final int CODEC_UNKNOWN_COMMAND = BASE_ERROR_NO - 201;
    public static final int CODEC_PACK_FAILED = BASE_ERROR_NO - 210;
    public static final int CODEC_UNPACK_FAILED = BASE_ERROR_NO - 211;
    public static final int CODEC_UNPACK_MISS_TRANSFORMER = BASE_ERROR_NO - 212;
    public static final int CODEC_UNPACK_EXTRA_DATA_FAILED = BASE_ERROR_NO - 213;
    public static final int CODEC_PACK_EXTRA_DATA_FAILED = BASE_ERROR_NO - 214;
    public static final int CODEC_ZIP_FAILED = BASE_ERROR_NO - 220;
    public static final int CODEC_UNZIP_FAILED = BASE_ERROR_NO - 221;
    public static final int CODEC_SECURE_KEY_NOT_READY = BASE_ERROR_NO - 230;
    public static final int CODEC_SECURE_ENCRYPT_FAILED = BASE_ERROR_NO - 231;
    public static final int CODEC_SECURE_DECRYPT_FAILED = BASE_ERROR_NO - 232;
    public static final int CODEC_UNKOWN_ERROR = BASE_ERROR_NO - 233;
    public static final int CODEC_UNPACK_HEAD_FAILED = BASE_ERROR_NO - 234;
    public static final int CODEC_UNPACK_BODY_FAILED = BASE_ERROR_NO - 235;
    public static final int CODEC_UNPACK_EMPTY = BASE_ERROR_NO - 236;
    public static final int QUEUE_TIME_OUT = BASE_ERROR_NO - 301;
    public static final int QUEUE_SEND_ERROR = BASE_ERROR_NO - 302;
    public static final int QUEUE_SEND_ERROR_CLEAR = BASE_ERROR_NO + PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int QUEUE_SEND_ERROR_SERVER = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL;
    public static final int QUEUE_SEND_ERROR_SEQUENCE_CMD = BASE_ERROR_NO - 305;
    public static final int QUEUE_SEND_ERROR_MANUAL_BLOCK = BASE_ERROR_NO - 306;
    public static final int QUEUE_SEND_ERROR_DUPLICATE = BASE_ERROR_NO + PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int QUEUE_SEND_CURRENTSOCKETCLOSE = BASE_ERROR_NO - 308;
    public static final int QUEUE_SEND_REALEASE_BLOCK = BASE_ERROR_NO - 309;
    public static final int QUEUE_SEND_TIME_OUT = BASE_ERROR_NO - 310;
    public static final int QUEUE_SEND_HAVE_RETRY_MESSAGE = BASE_ERROR_NO - 311;
    public static final int QUEUE_SEND_FIND_ORIGINAL_DATA = BASE_ERROR_NO - 312;
    public static final int QUEUE_SEND_NOT_FIND_ORIGINAL_DATA = BASE_ERROR_NO - 313;
    public static final int QUEUE_SERVER_INIT_SEQID_ERROR = BASE_ERROR_NO - 314;
    public static final int QUEUE_SEND_SET_BLOCK = BASE_ERROR_NO - 310;
    public static final int QUEUE_SEND_ERROR_MANUAL_CLOSE = BASE_ERROR_NO - 311;
    public static final int QUEUE_RECE_CMD_NOT_MATCH = BASE_ERROR_NO - 400;
    public static final int LOCATION_PROCESS_ERROR = BASE_ERROR_NO - 501;
    private static String sUrl = null;
    private static String sExtensions = null;
    private static String[] sSubprotocols = null;
    private static int[] sReconnectInterval = MessageConfig.reconStrategy;
    private static ArrayList<BasicNameValuePair> sHeader = null;

    public static String toErrorMsg(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.sdk_im_error_default) : app.getString(R.string.sdk_im_error_codec);
    }

    public static int[] getReConnectInterval() {
        return sReconnectInterval;
    }

    public static void setReConnectInterval(int[] iArr) {
        if (iArr != null) {
            sReconnectInterval = iArr;
        }
    }

    public static String getUrl() {
        return sUrl;
    }

    public static void setUrl(String str) {
        sUrl = str;
    }

    public static String getExtensions() {
        return sExtensions;
    }

    public static void setExtensions(String str) {
        sExtensions = str;
    }

    public static String[] getSubprotocols() {
        return sSubprotocols;
    }

    public static void setSubprotocols(String[] strArr) {
        sSubprotocols = strArr;
    }

    public static ArrayList<BasicNameValuePair> getHeader() {
        return sHeader;
    }

    public static void setHeader(ArrayList<BasicNameValuePair> arrayList) {
        sHeader = arrayList;
    }
}
