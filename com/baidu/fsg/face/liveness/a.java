package com.baidu.fsg.face.liveness;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.liveness.SapiLivenessOperation;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class a {
    private a() {
    }

    public static a a() {
        return C0120a.f1601a;
    }

    /* renamed from: com.baidu.fsg.face.liveness.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class C0120a {

        /* renamed from: a  reason: collision with root package name */
        private static a f1601a = new a();

        private C0120a() {
        }
    }

    public void a(Context context, HashMap hashMap, final RouterCallback routerCallback) {
        if (routerCallback != null && context != null && hashMap != null) {
            LivenessRecogDTO a2 = a(hashMap);
            final SapiLivenessOperation sapiLivenessOperation = new SapiLivenessOperation();
            if (a2 != null && a2.isVideoRecog()) {
                sapiLivenessOperation.operationType = SapiLivenessOperation.OperationType.VIDEORECOG;
                ArrayList arrayList = new ArrayList();
                arrayList.add(a2.getSpno() + "");
                arrayList.add(a2.spParams + "");
                RimStatisticsUtil.onEventWithValues(d.I, arrayList);
            } else {
                sapiLivenessOperation.operationType = SapiLivenessOperation.OperationType.RECOGNIZE;
                RimStatisticsUtil.onEventWithValue(d.f1728a, a2 != null ? a2.getSpno() : "");
            }
            SapiLivenessRecogManager.getInstance().execute(sapiLivenessOperation, new LivenessRecogCallback() { // from class: com.baidu.fsg.face.liveness.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.face.base.a.a
                public void a(LivenessRecogResult livenessRecogResult) {
                    JSONObject jSONObject;
                    JSONObject jSONObject2;
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (sapiLivenessOperation.operationType == SapiLivenessOperation.OperationType.VIDEORECOG) {
                        if (livenessRecogResult != null) {
                            HashMap hashMap2 = new HashMap();
                            try {
                                hashMap2.put(BaiduRimConstants.RETCODE_KEY, 0);
                                hashMap2.put("retMsg", livenessRecogResult.getResultMsg());
                                if (livenessRecogResult.extraJson != null) {
                                    jSONObject2 = new JSONObject(livenessRecogResult.extraJson.toString());
                                } else {
                                    jSONObject2 = new JSONObject();
                                }
                                if (!TextUtils.isEmpty(livenessRecogResult.authSid)) {
                                    jSONObject2.put("authsid", livenessRecogResult.authSid);
                                }
                                if (!TextUtils.isEmpty(livenessRecogResult.callbackkey)) {
                                    jSONObject2.put("callbackkey", livenessRecogResult.callbackkey);
                                }
                                jSONObject2.remove("need_confirm");
                                hashMap2.put("result", jSONObject2.toString());
                                routerCallback.onResult(0, hashMap2);
                                com.baidu.fsg.face.liveness.beans.c.a().b();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (livenessRecogResult != null) {
                        HashMap hashMap3 = new HashMap();
                        try {
                            hashMap3.put(BaiduRimConstants.RETCODE_KEY, 0);
                            hashMap3.put("retMsg", livenessRecogResult.getResultMsg());
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
                            jSONObject.remove("need_confirm");
                            hashMap3.put("result", jSONObject.toString());
                            routerCallback.onResult(0, hashMap3);
                            com.baidu.fsg.face.liveness.beans.c.a().b();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.fsg.face.base.a.a
                public void b(LivenessRecogResult livenessRecogResult) {
                    JSONObject jSONObject;
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (sapiLivenessOperation.operationType == SapiLivenessOperation.OperationType.VIDEORECOG) {
                        if (livenessRecogResult != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(livenessRecogResult.getResultCode()));
                            hashMap2.put("retMsg", livenessRecogResult.getResultMsg());
                            routerCallback.onResult(livenessRecogResult.getResultCode(), hashMap2);
                            com.baidu.fsg.face.liveness.beans.c.a().b();
                        }
                    } else if (livenessRecogResult != null) {
                        HashMap hashMap3 = new HashMap();
                        try {
                            hashMap3.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(livenessRecogResult.getResultCode()));
                            hashMap3.put("retMsg", livenessRecogResult.getResultMsg());
                            if (livenessRecogResult.getResultCode() == -302) {
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
                                jSONObject.remove("need_confirm");
                                hashMap3.put("result", jSONObject.toString());
                            }
                            routerCallback.onResult(livenessRecogResult.getResultCode(), hashMap3);
                            com.baidu.fsg.face.liveness.beans.c.a().b();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
        livenessRecogDTO.soundSwitch = "1".equals(hashMap.get("soundSwitch") + "");
        livenessRecogDTO.randomLiveness = "1".equals(hashMap.get("randomAction") + "");
        livenessRecogDTO.recordLiveness = "1".equals(hashMap.get("recordVideo") + "");
        livenessRecogDTO.switchVideo = "1".equals(hashMap.get("switchVideo") + "");
        livenessRecogDTO.recordAudio = "1".equals(hashMap.get("soundFlag") + "");
        livenessRecogDTO.serviceType = hashMap.get("serviceType") != null ? hashMap.get("serviceType") + "" : "1008";
        String str = hashMap.get("recogType") != null ? hashMap.get("recogType") + "" : "";
        livenessRecogDTO.imageFlag = hashMap.get("imageFlag") != null ? hashMap.get("imageFlag") + "" : "0";
        if ("bduss".equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;
            livenessRecogDTO.bduss = hashMap.get("bduss") != null ? hashMap.get("bduss") + "" : "";
            livenessRecogDTO.uid = hashMap.get("uid") != null ? hashMap.get("uid") + "" : "";
        } else if ("certinfo".equals(str)) {
            livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_CERTINFO;
            livenessRecogDTO.realName = hashMap.get("realName") != null ? hashMap.get("realName") + "" : "";
            livenessRecogDTO.idCardNum = hashMap.get("idCardNo") != null ? hashMap.get("idCardNo") + "" : "";
            livenessRecogDTO.phoneNum = hashMap.get("phoneNo") != null ? hashMap.get("phoneNo") + "" : "";
            livenessRecogDTO.exUid = hashMap.get("exuid") != null ? hashMap.get("exuid") + "" : "";
        } else if ("authtoken".equals(str)) {
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
        if (hashMap.get("livenessServiceId") != null) {
            livenessRecogDTO.livenessServiceId = hashMap.get("livenessServiceId") + "";
        }
        com.baidu.fsg.face.liveness.beans.c.a().a("request_data", livenessRecogDTO);
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
