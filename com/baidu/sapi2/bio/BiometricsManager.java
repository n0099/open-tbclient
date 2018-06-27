package com.baidu.sapi2.bio;

import android.content.Context;
import com.baidu.fsg.api.BaiduRIM;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
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

    public void livenessRecognize(Context context, String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult, RimServiceCallback rimServiceCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        hashMap.put("recogType", biometricsIdentifyResult.livenessRecogType);
        if (SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_CERTINFO.equals(biometricsIdentifyResult.livenessRecogType)) {
            hashMap.put("realName", biometricsIdentifyResult.realName);
            hashMap.put("idCardNo", biometricsIdentifyResult.idCardNum);
            hashMap.put("phoneNo", biometricsIdentifyResult.phoneNum);
        } else if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                hashMap.put("bduss", session.bduss);
                hashMap.put("uid", session.uid);
                hashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, str);
            }
        } else if (SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN.equals(biometricsIdentifyResult.livenessRecogType)) {
            hashMap.put("authToken", biometricsIdentifyResult.authToken);
        }
        hashMap.put("showGuidePage", Integer.valueOf(biometricsIdentifyResult.showGuidePage));
        hashMap.put("supPro", biometricsIdentifyResult.subPro);
        BaiduRIM.getInstance().accessRimService(context, hashMap, rimServiceCallback);
    }

    public void bioScanFace(Context context, SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult, RimServiceCallback rimServiceCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "startLivenessRecognize");
        if (bioScanFaceResult.type == 1) {
            hashMap.put("recogType", "faceDetect");
        } else if (bioScanFaceResult.type == 2) {
            hashMap.put("recogType", "outer");
        }
        hashMap.put("showGuidePage", Integer.valueOf(bioScanFaceResult.showGuidePage));
        hashMap.put("exuid", bioScanFaceResult.uid);
        bioScanFaceResult.transParamsList.add(new BasicNameValuePair("sp_no", bioScanFaceResult.subpro));
        bioScanFaceResult.transParamsList.add(new BasicNameValuePair("cuid", SapiUtils.getClientId(context)));
        hashMap.put("spParams", SapiUtils.createRequestParams(bioScanFaceResult.transParamsList));
        BaiduRIM.getInstance().accessRimService(context, hashMap, rimServiceCallback);
    }
}
