package com.baidu.sapi2.bio;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BiometricsManager {
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    public static final String TAG = BiometricsManager.class.getSimpleName();
    private static BiometricsManager instance;

    /* loaded from: classes2.dex */
    public interface DelegateRimServiceCallback {
        void onResult(int i, Map<String, Object> map);
    }

    public static BiometricsManager getInstance() {
        if (instance == null) {
            instance = new BiometricsManager();
        }
        return instance;
    }

    public boolean usePassBioSDK(Context context) {
        try {
            Class.forName("com.baidu.fsg.api.BaiduRIM");
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration.rimSDKEnable) {
                return false;
            }
            List<String> rimBackList = SapiContext.getInstance(context).getRimBackList();
            if (rimBackList.isEmpty()) {
                return true;
            }
            return (rimBackList.contains("all") || rimBackList.contains(sapiConfiguration.tpl)) ? false : true;
        } catch (Throwable th) {
            Log.e(th);
            return true;
        }
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

    public void rimlivenessRecognize(Context context, String str, LivenessDTO livenessDTO, final DelegateRimServiceCallback delegateRimServiceCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("imageFlag", Integer.valueOf(livenessDTO.imageFlag));
        hashMap.put("recogType", livenessDTO.livenessRecogType);
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        hashMap.put("supPro", livenessDTO.subPro);
        if ("certinfo".equals(livenessDTO.livenessRecogType)) {
            hashMap.put("realName", livenessDTO.realName);
            hashMap.put("idCardNo", livenessDTO.idCardNum);
            hashMap.put("phoneNo", livenessDTO.phoneNum);
        } else if ("bduss".equals(livenessDTO.livenessRecogType)) {
            SapiAccount accountFromBduss = SapiContext.getInstance(context).getAccountFromBduss(livenessDTO.bduss);
            if (accountFromBduss != null) {
                hashMap.put("bduss", accountFromBduss.bduss);
                hashMap.put("uid", accountFromBduss.uid);
                hashMap.put("stoken", str);
            }
        } else if ("authtoken".equals(livenessDTO.livenessRecogType)) {
            hashMap.put("authToken", livenessDTO.authToken);
        }
        livenessDTO.transParamsList.add(new PassNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, livenessDTO.subPro));
        livenessDTO.transParamsList.add(new PassNameValuePair("cuid", SapiUtils.getClientId(context)));
        hashMap.put("spParams", SapiUtils.createRequestParams(livenessDTO.transParamsList));
        BaiduRIM.getInstance().accessRimService(context, hashMap, new RimServiceCallback() { // from class: com.baidu.sapi2.bio.BiometricsManager.2
            public void onResult(int i, Map<String, Object> map) {
                delegateRimServiceCallback.onResult(i, map);
            }
        });
    }

    public void bioScanFace(Context context, LivenessDTO livenessDTO, final DelegateRimServiceCallback delegateRimServiceCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("imageFlag", Integer.valueOf(livenessDTO.imageFlag));
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        hashMap.put("recogType", livenessDTO.livenessRecogType);
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        hashMap.put("exuid", livenessDTO.livingUname);
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        livenessDTO.transParamsList.add(new PassNameValuePair(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, livenessDTO.subPro));
        livenessDTO.transParamsList.add(new PassNameValuePair("cuid", SapiUtils.getClientId(context)));
        hashMap.put("spParams", SapiUtils.createRequestParams(livenessDTO.transParamsList));
        BaiduRIM.getInstance().accessRimService(context, hashMap, new RimServiceCallback() { // from class: com.baidu.sapi2.bio.BiometricsManager.3
            public void onResult(int i, Map<String, Object> map) {
                delegateRimServiceCallback.onResult(i, map);
            }
        });
    }

    public LivenessResult parseMap2LivenessResult(int i, Map<String, Object> map) {
        LivenessResult livenessResult = new LivenessResult();
        livenessResult.errCode = i;
        livenessResult.errMsg = (String) map.get("retMsg");
        String str = (String) map.get("result");
        if (livenessResult.errCode != 0 || TextUtils.isEmpty(str)) {
            return livenessResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            livenessResult.callBackKey = jSONObject.optString("callbackkey");
            livenessResult.authSid = jSONObject.optString("authsid");
        } catch (JSONException e) {
            Log.e(e);
        }
        return livenessResult;
    }

    /* loaded from: classes2.dex */
    public class LivenessResult {
        public String authSid;
        public String callBackKey;
        public int errCode;
        public String errMsg;

        public LivenessResult() {
        }
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
        public int biometricType;
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
