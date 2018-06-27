package com.baidu.sapi2.biometrics.liveness;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.biometrics.liveness.SapiLivenessOperation;
import com.baidu.sapi2.biometrics.liveness.callback.LivenessRecogCallback;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final int a = -1;
    public static final String b = "未知错误";
    public static final int c = 0;

    private a() {
    }

    public static a a() {
        return C0083a.a;
    }

    /* renamed from: com.baidu.sapi2.biometrics.liveness.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0083a {
        private static a a = new a();

        private C0083a() {
        }
    }

    public void a(Context context, HashMap hashMap, final RouterCallback routerCallback) {
        if (routerCallback != null && context != null && hashMap != null) {
            SapiLivenessOperation sapiLivenessOperation = new SapiLivenessOperation();
            sapiLivenessOperation.operationType = SapiLivenessOperation.OperationType.RECOGNIZE;
            LivenessRecogDTO a2 = a(hashMap);
            RimStatisticsUtil.onEventWithValue(f.a, a2 != null ? a2.getSpno() : "");
            SapiLivenessRecogManager.getInstance().execute(sapiLivenessOperation, new LivenessRecogCallback() { // from class: com.baidu.sapi2.biometrics.liveness.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.biometrics.base.a.a
                public void a(LivenessRecogResult livenessRecogResult) {
                    JSONObject jSONObject;
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (livenessRecogResult != null) {
                        HashMap hashMap2 = new HashMap();
                        try {
                            hashMap2.put(BaiduRimConstants.RETCODE_KEY, 0);
                            hashMap2.put("retMsg", livenessRecogResult.getResultMsg());
                            if (livenessRecogResult.extraJson != null) {
                                jSONObject = new JSONObject(livenessRecogResult.extraJson.toString());
                            } else {
                                jSONObject = new JSONObject();
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.authSid)) {
                                jSONObject.put("authsid", livenessRecogResult.authSid);
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.video)) {
                                jSONObject.put("video", livenessRecogResult.video);
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.callbackkey)) {
                                jSONObject.put("callbackkey", livenessRecogResult.callbackkey);
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.faceimage)) {
                                jSONObject.put("faceimage", livenessRecogResult.faceimage);
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.imgdigests)) {
                                jSONObject.put("imgdigests", livenessRecogResult.imgdigests);
                            }
                            if (!TextUtils.isEmpty(livenessRecogResult.originalImage)) {
                                jSONObject.put("originimage", livenessRecogResult.originalImage);
                            }
                            hashMap2.put("result", jSONObject.toString());
                            routerCallback.onResult(0, hashMap2);
                            com.baidu.sapi2.biometrics.liveness.beans.b.a().c();
                            com.baidu.sapi2.biometrics.liveness.beans.b.a().b();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.biometrics.base.a.a
                public void b(LivenessRecogResult livenessRecogResult) {
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (livenessRecogResult != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(livenessRecogResult.getResultCode()));
                        hashMap2.put("retMsg", livenessRecogResult.getResultMsg());
                        routerCallback.onResult(livenessRecogResult.getResultCode(), hashMap2);
                        com.baidu.sapi2.biometrics.liveness.beans.b.a().c();
                        com.baidu.sapi2.biometrics.liveness.beans.b.a().b();
                    }
                }
            }, a2, context);
        }
    }

    private LivenessRecogDTO a(HashMap<String, Object> hashMap) {
        LivenessRecogDTO livenessRecogDTO = new LivenessRecogDTO();
        if (hashMap == null) {
            return livenessRecogDTO;
        }
        livenessRecogDTO.showGuidePage = "1".equals(hashMap.get("showGuidePage") + "");
        livenessRecogDTO.serviceType = hashMap.get("serviceType") != null ? hashMap.get("serviceType") + "" : "1008";
        String str = hashMap.get("recogType") != null ? hashMap.get("recogType") + "" : "";
        if ("bduss".equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;
            livenessRecogDTO.bduss = hashMap.get("bduss") != null ? hashMap.get("bduss") + "" : "";
            livenessRecogDTO.stoken = hashMap.get(ISapiAccount.SAPI_ACCOUNT_STOKEN) != null ? hashMap.get(ISapiAccount.SAPI_ACCOUNT_STOKEN) + "" : "";
            livenessRecogDTO.uid = hashMap.get("uid") != null ? hashMap.get("uid") + "" : "";
        } else if (SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_CERTINFO.equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_CERTINFO;
            livenessRecogDTO.realName = hashMap.get("realName") != null ? hashMap.get("realName") + "" : "";
            livenessRecogDTO.idCardNum = hashMap.get("idCardNo") != null ? hashMap.get("idCardNo") + "" : "";
            livenessRecogDTO.phoneNum = hashMap.get("phoneNo") != null ? hashMap.get("phoneNo") + "" : "";
            livenessRecogDTO.exUid = hashMap.get("exuid") != null ? hashMap.get("exuid") + "" : "";
        } else if (SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN.equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_AUTHTOKEN;
            livenessRecogDTO.authToken = hashMap.get("authToken") != null ? hashMap.get("authToken") + "" : "";
        } else if ("faceDetect".equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_FACEDETECT;
            livenessRecogDTO.exUid = hashMap.get("exuid") != null ? hashMap.get("exuid") + "" : "";
        } else if ("outer".equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_OUTER;
            livenessRecogDTO.exUid = hashMap.get("exuid") != null ? hashMap.get("exuid") + "" : "";
        }
        if (hashMap.get("spParams") != null) {
            livenessRecogDTO.spParams = hashMap.get("spParams") + "";
        } else {
            livenessRecogDTO.spParams = "sp_no=" + hashMap.get("supPro");
        }
        livenessRecogDTO.processid = b();
        com.baidu.sapi2.biometrics.liveness.beans.b.a().a(com.baidu.sapi2.biometrics.liveness.beans.b.a, livenessRecogDTO);
        return livenessRecogDTO;
    }

    public static String b() {
        String uuid = UUID.randomUUID().toString();
        if (!TextUtils.isEmpty(uuid)) {
            return uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        }
        return uuid;
    }
}
