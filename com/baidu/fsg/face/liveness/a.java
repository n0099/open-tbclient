package com.baidu.fsg.face.liveness;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.liveness.SapiLivenessOperation;
import com.baidu.fsg.face.liveness.callback.LivenessRecogCallback;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.fsg.face.liveness.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1647a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f39686a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411897274, "Lcom/baidu/fsg/face/liveness/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1411897274, "Lcom/baidu/fsg/face/liveness/a$a;");
                    return;
                }
            }
            f39686a = new a();
        }

        public C1647a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1647a.f39686a : (a) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || routerCallback == null || context == null || hashMap == null) {
            return;
        }
        LivenessRecogDTO a2 = a(hashMap);
        SapiLivenessOperation sapiLivenessOperation = new SapiLivenessOperation();
        if (a2 != null && a2.isVideoRecog()) {
            sapiLivenessOperation.operationType = SapiLivenessOperation.OperationType.VIDEORECOG;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.getSpno() + "");
            arrayList.add(a2.spParams + "");
            RimStatisticsUtil.onEventWithValues(d.I, arrayList);
        } else {
            sapiLivenessOperation.operationType = SapiLivenessOperation.OperationType.RECOGNIZE;
            RimStatisticsUtil.onEventWithValue(d.f40016a, a2 != null ? a2.getSpno() : "");
        }
        SapiLivenessRecogManager.getInstance().execute(sapiLivenessOperation, new LivenessRecogCallback(this, sapiLivenessOperation, routerCallback) { // from class: com.baidu.fsg.face.liveness.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SapiLivenessOperation f39683a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RouterCallback f39684b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f39685c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, sapiLivenessOperation, routerCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f39685c = this;
                this.f39683a = sapiLivenessOperation;
                this.f39684b = routerCallback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.fsg.face.base.a.a
            public void a(LivenessRecogResult livenessRecogResult) {
                JSONObject jSONObject;
                JSONObject jSONObject2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessRecogResult) == null) {
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (this.f39683a.operationType == SapiLivenessOperation.OperationType.VIDEORECOG) {
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
                                this.f39684b.onResult(0, hashMap2);
                                com.baidu.fsg.face.liveness.beans.c.a().b();
                            } catch (JSONException e2) {
                                e2.printStackTrace();
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
                            this.f39684b.onResult(0, hashMap3);
                            com.baidu.fsg.face.liveness.beans.c.a().b();
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.fsg.face.base.a.a
            public void b(LivenessRecogResult livenessRecogResult) {
                JSONObject jSONObject;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, livenessRecogResult) == null) {
                    SapiLivenessRecogManager.getInstance().cleanLivenessRecogCallback();
                    if (this.f39683a.operationType == SapiLivenessOperation.OperationType.VIDEORECOG) {
                        if (livenessRecogResult != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(livenessRecogResult.getResultCode()));
                            hashMap2.put("retMsg", livenessRecogResult.getResultMsg());
                            this.f39684b.onResult(livenessRecogResult.getResultCode(), hashMap2);
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
                            this.f39684b.onResult(livenessRecogResult.getResultCode(), hashMap3);
                            com.baidu.fsg.face.liveness.beans.c.a().b();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }, a2, context);
    }

    private LivenessRecogDTO a(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, hashMap)) == null) {
            LivenessRecogDTO livenessRecogDTO = new LivenessRecogDTO();
            if (hashMap == null) {
                return livenessRecogDTO;
            }
            livenessRecogDTO.showGuidePage = "1".equals(hashMap.get(LightInvokerImpl.LIVENESS_SHOW_GUIDE_PAGE) + "");
            livenessRecogDTO.soundSwitch = "1".equals(hashMap.get("soundSwitch") + "");
            livenessRecogDTO.randomLiveness = "1".equals(hashMap.get(LightInvokerImpl.RANDOM_ACTION) + "");
            livenessRecogDTO.recordLiveness = "1".equals(hashMap.get(LightInvokerImpl.RECORD_VIDEO) + "");
            livenessRecogDTO.switchVideo = "1".equals(hashMap.get(LightInvokerImpl.SWITCH_VIDEO) + "");
            livenessRecogDTO.recordAudio = "1".equals(hashMap.get("soundFlag") + "");
            if (hashMap.get(LightInvokerImpl.LIVENESS_SERVIVETYPE) != null) {
                str = hashMap.get(LightInvokerImpl.LIVENESS_SERVIVETYPE) + "";
            } else {
                str = "1008";
            }
            livenessRecogDTO.serviceType = str;
            if (hashMap.get("recogType") != null) {
                str2 = hashMap.get("recogType") + "";
            } else {
                str2 = "";
            }
            if (hashMap.get("imageFlag") != null) {
                str3 = hashMap.get("imageFlag") + "";
            } else {
                str3 = "0";
            }
            livenessRecogDTO.imageFlag = str3;
            if ("bduss".equals(str2)) {
                livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_BDUSS;
                if (hashMap.get("bduss") != null) {
                    str11 = hashMap.get("bduss") + "";
                } else {
                    str11 = "";
                }
                livenessRecogDTO.bduss = str11;
                if (hashMap.get("uid") != null) {
                    str12 = hashMap.get("uid") + "";
                } else {
                    str12 = "";
                }
                livenessRecogDTO.uid = str12;
            } else if ("certinfo".equals(str2)) {
                livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_CERTINFO;
                if (hashMap.get("realName") != null) {
                    str7 = hashMap.get("realName") + "";
                } else {
                    str7 = "";
                }
                livenessRecogDTO.realName = str7;
                if (hashMap.get("idCardNo") != null) {
                    str8 = hashMap.get("idCardNo") + "";
                } else {
                    str8 = "";
                }
                livenessRecogDTO.idCardNum = str8;
                if (hashMap.get("phoneNo") != null) {
                    str9 = hashMap.get("phoneNo") + "";
                } else {
                    str9 = "";
                }
                livenessRecogDTO.phoneNum = str9;
                if (hashMap.get("exuid") != null) {
                    str10 = hashMap.get("exuid") + "";
                } else {
                    str10 = "";
                }
                livenessRecogDTO.exUid = str10;
            } else if ("authtoken".equals(str2)) {
                livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_AUTHTOKEN;
                if (hashMap.get("authToken") != null) {
                    str6 = hashMap.get("authToken") + "";
                } else {
                    str6 = "";
                }
                livenessRecogDTO.authToken = str6;
            } else if ("faceDetect".equals(str2)) {
                livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_FACEDETECT;
                if (hashMap.get("exuid") != null) {
                    str5 = hashMap.get("exuid") + "";
                } else {
                    str5 = "";
                }
                livenessRecogDTO.exUid = str5;
            } else if ("outer".equals(str2)) {
                livenessRecogDTO.livenessType = LivenessRecogType.RECOG_TYPE_OUTER;
                if (hashMap.get("exuid") != null) {
                    str4 = hashMap.get("exuid") + "";
                } else {
                    str4 = "";
                }
                livenessRecogDTO.exUid = str4;
            }
            if (hashMap.get(LightInvokerImpl.SP_PARAMS) != null) {
                livenessRecogDTO.spParams = hashMap.get(LightInvokerImpl.SP_PARAMS) + "";
            } else {
                livenessRecogDTO.spParams = "sp_no=" + hashMap.get("supPro");
            }
            livenessRecogDTO.processid = b();
            if (hashMap.get(LightInvokerImpl.LIVENESSSERVICE_ID) != null) {
                livenessRecogDTO.livenessServiceId = hashMap.get(LightInvokerImpl.LIVENESSSERVICE_ID) + "";
            }
            com.baidu.fsg.face.liveness.beans.c.a().a("request_data", livenessRecogDTO);
            return livenessRecogDTO;
        }
        return (LivenessRecogDTO) invokeL.objValue;
    }
}
