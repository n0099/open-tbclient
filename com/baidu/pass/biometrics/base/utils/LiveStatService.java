package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class LiveStatService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOMAIN_NSCLICK_URL = "https://nsclick.baidu.com/v.gif";
    public static final String TAG = "LiveStatService";
    public static final Map<String, String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38132b = "4854";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38133c = "page";

    /* renamed from: d  reason: collision with root package name */
    public static final String f38134d = "source";

    /* renamed from: e  reason: collision with root package name */
    public static final String f38135e = "ext";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38136f = "living_recog";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1663637762, "Lcom/baidu/pass/biometrics/base/utils/LiveStatService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1663637762, "Lcom/baidu/pass/biometrics/base/utils/LiveStatService;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("pid", "111");
        a.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
        a.put("device", "android");
    }

    public LiveStatService() {
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

    public static void onEvent(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (NetworkUtils.isNetworkAvailable(context)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(a);
                map.put("v", String.valueOf(System.currentTimeMillis()));
                hashMap.put("name", str);
                hashMap.put("model", Build.MODEL);
                hashMap.put("tpl", BeanConstants.tpl);
                hashMap.put("clientfrom", "mobilesdk_enhanced");
                hashMap.put("app_version", PassBioBaseUtil.getVersionName(context));
                hashMap.put("sdk_version", PassBiometricDefaultFactory.VERSION_NAME);
                hashMap.put("cuid", SapiUtils.getClientId(context));
                hashMap.put("v", String.valueOf(System.currentTimeMillis()));
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                            hashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
                passHttpParamDTO.url = DOMAIN_NSCLICK_URL;
                passHttpParamDTO.paramsMap.putAll(hashMap);
                passHttpParamDTO.priority = ReqPriority.LOW;
                PassHttpClient.getInstance().get(context.getApplicationContext(), passHttpParamDTO, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.LiveStatService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str2) == null) {
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onSuccess(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        }
                    }
                });
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(hashMap);
                jSONObject.put("page", "living_recog");
                jSONObject.put("source", BeanConstants.tpl);
                jSONObject.put("ext", jSONObject2);
                ServiceManager.getInstance().getIsAccountManager().getUbcUploadImplCallback().onEvent(f38132b, jSONObject);
            }
        } catch (Throwable unused) {
        }
    }
}
