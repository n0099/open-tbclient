package com.baidu.sapi2.bio;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BiometricsManager {
    public static final String PASS_PRODUCT_ID = "pp";
    private static BiometricsManager instance;

    public static BiometricsManager getInstance() {
        if (instance == null) {
            instance = new BiometricsManager();
        }
        return instance;
    }

    public void livenessRecognize(Context context, String str, LivenessDTO livenessDTO, RimServiceCallback rimServiceCallback) {
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
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, str);
            }
        } else if ("authtoken".equals(livenessDTO.livenessRecogType)) {
            hashMap.put("authToken", livenessDTO.authToken);
        }
        livenessDTO.transParamsList.add(new BasicNameValuePair("sp_no", livenessDTO.subPro));
        livenessDTO.transParamsList.add(new BasicNameValuePair("cuid", SapiUtils.getClientId(context)));
        hashMap.put("spParams", SapiUtils.createRequestParams(livenessDTO.transParamsList));
        BaiduRIM.getInstance().accessRimService(context, hashMap, rimServiceCallback);
    }

    public void bioScanFace(Context context, LivenessDTO livenessDTO, RimServiceCallback rimServiceCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("imageFlag", Integer.valueOf(livenessDTO.imageFlag));
        hashMap.put("recogType", livenessDTO.livenessRecogType);
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        hashMap.put("exuid", livenessDTO.livingUname);
        hashMap.put("showGuidePage", Integer.valueOf(livenessDTO.showGuidePage));
        livenessDTO.transParamsList.add(new BasicNameValuePair("sp_no", livenessDTO.subPro));
        livenessDTO.transParamsList.add(new BasicNameValuePair("cuid", SapiUtils.getClientId(context)));
        hashMap.put("spParams", SapiUtils.createRequestParams(livenessDTO.transParamsList));
        BaiduRIM.getInstance().accessRimService(context, hashMap, rimServiceCallback);
    }

    public static String buildSubPro(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        }
        return "pp-pp-" + str + "-{tpl:" + SapiAccountManager.getInstance().getConfignation().tpl + ",scene:" + str2 + "}";
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
        public List<NameValuePair> transParamsList = new ArrayList();
        public String uid;

        public LivenessDTO() {
        }
    }
}
