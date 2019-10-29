package com.baidu.sapi2.bio;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BiometricsManager {
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    private static final String SCENE_CERT_LOGIN = "scene:certlogin";
    private static final String SCENE_UN_CERT_LOGIN = "scene:uncertlogin";
    public static final String TAG = BiometricsManager.class.getSimpleName();
    private static BiometricsManager instance;

    public static BiometricsManager getInstance() {
        if (instance == null) {
            instance = new BiometricsManager();
        }
        return instance;
    }

    public void recogWithBduss(Context context, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithCertInfo(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_CERTINFO, str, map, str2, "", "", "", "", str3, str4, str5, passFaceRecogCallback);
    }

    public void recogWithAuthToken(Context context, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithFaceDetect(Context context, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Map<String, String> hashMap = map == null ? new HashMap<>() : map;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("authsid", str4);
        }
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Context context, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    public void livenessRecognize(Context context, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, final PassFaceRecogCallback passFaceRecogCallback) {
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
        PassFaceOperation passFaceOperation = new PassFaceOperation();
        passFaceOperation.operationType = PassFaceOperation.OperationType.RECOGNIZE;
        passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str);
        passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(context));
        passFaceRecogDTO.imageFlag = str2;
        if (map != null) {
            passFaceRecogDTO.extraParamsMap.putAll(map);
        }
        passFaceRecogDTO.livenessType = passFaceRecogType;
        if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            passFaceRecogDTO.realName = str7;
            passFaceRecogDTO.idCardNum = str8;
            passFaceRecogDTO.phoneNum = str9;
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            SapiAccount accountFromBduss = SapiContext.getInstance(context).getAccountFromBduss(str3);
            if (accountFromBduss != null) {
                passFaceRecogDTO.bduss = accountFromBduss.bduss;
                passFaceRecogDTO.uid = accountFromBduss.uid;
                passFaceRecogDTO.stoken = str4;
            }
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            passFaceRecogDTO.authToken = str5;
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            passFaceRecogDTO.exUid = str6;
        } else if (passFaceRecogType == PassFaceRecogType.RECOG_TYPE_OUTER) {
            passFaceRecogDTO.exUid = str6;
        }
        passFaceRecogDTO.passProductId = str;
        if (!TextUtils.isEmpty(str) && (str.contains(SCENE_CERT_LOGIN) || str.contains(SCENE_UN_CERT_LOGIN))) {
            try {
                passFaceRecogDTO.guideLiveness = false;
            } catch (Throwable th) {
            }
        }
        biometric.execute(passFaceOperation, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.bio.BiometricsManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                passFaceRecogCallback.onSuccess(passFaceRecogResult);
                Log.e(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject(), "callbackkey", passFaceRecogResult.callbackkey);
                Log.d(BiometricsManager.TAG, "faceimage", passFaceRecogResult.faceimage, "imgdigests", passFaceRecogResult.imgdigests, "originalImage", passFaceRecogResult.originalImage);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                passFaceRecogCallback.onFailure(passFaceRecogResult);
                Log.d(BiometricsManager.TAG, "result", passFaceRecogResult.toJSONObject());
            }
        }, passFaceRecogDTO, context);
    }

    public static String buildSubPro(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        }
        return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
    }

    /* loaded from: classes2.dex */
    public class LivenessDTO {
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
        public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
        public String authToken;
        public String bduss;
        public String idCardNum;
        public int imageFlag;
        public String livenessRecogType;
        public String livingUname;
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String stoken;
        public String subPro;
        public List<PassNameValuePair> transParamsList = new ArrayList();
        public String uid;

        public LivenessDTO() {
        }
    }
}
