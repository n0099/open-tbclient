package com.baidu.searchbox.account.result;

import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BoxFaceRecogResult {
    public static final int ERROR_CODE_CONTRAST_FAIL = -302;
    public static final int ERROR_CODE_FACE_SDK_INIT_FAIL = -303;
    public static final int ERROR_CODE_IMAGE_FILE_EMPTY = -306;
    public static final int ERROR_CODE_LIVENESS_RECOGNIZE_TIME_OUT = -301;
    public static final int ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION = -307;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_OPEN_CAMERA_FAILURE = -305;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final int RESULT_CODE_SUCCESS = 0;
    public String authSid;
    public String callbackkey;
    public JSONObject extraJson;
    public String faceimage;
    public ArrayList<byte[]> imageList;
    public String imgdigests;
    public String originalImage;
    public int resultCode = -202;
    public String resultMsg;
    public String video;
}
