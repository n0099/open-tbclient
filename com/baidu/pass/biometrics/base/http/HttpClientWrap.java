package com.baidu.pass.biometrics.base.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.http.utils.HttpUtils;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.utils.Crypto;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.pass.http.ReqPriority;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HttpClientWrap {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f36142c = "encode";

    /* renamed from: d  reason: collision with root package name */
    public static final String f36143d = "ua";

    /* renamed from: e  reason: collision with root package name */
    public static final String f36144e = "cuid_2";

    /* renamed from: f  reason: collision with root package name */
    public static final String f36145f = "reqid";

    /* renamed from: g  reason: collision with root package name */
    public static final String f36146g = "sp_params";

    /* renamed from: h  reason: collision with root package name */
    public static final String f36147h = "s1";
    public transient /* synthetic */ FieldHolder $fh;
    public PassHttpClient a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36148b;

    public HttpClientWrap(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = PassHttpClient.getInstance();
        this.f36148b = context;
    }

    private PassHttpParamDTO a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, reqPriority, httpHashMap, list, Integer.valueOf(i2)})) == null) {
            PassHttpParamDTO a = a(str, httpHashMap, list, i2);
            a.priority = reqPriority;
            return a;
        }
        return (PassHttpParamDTO) invokeCommon.objValue;
    }

    public static Map<String, String> appendCertification(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("encode", "utf-8");
            hashMap.put("ua", PassBiometricUtil.getUA(context, BeanConstants.tpl));
            hashMap.put("time", String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("appid", BeanConstants.appid);
            hashMap.put("tpl", BeanConstants.tpl);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid_2", PhoneUtils.getCUID2(context));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("wcp", PassBioDataEncryptor.encryptParams(new String(jSONObject.toString().getBytes())));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String calculateSig(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, map, str)) == null) {
            map.remove(FunAdSdk.PLATFORM_SIG);
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(str2);
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                try {
                    String str4 = map.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        sb.append(str3);
                        sb.append("=");
                        sb.append(URLEncoder.encode(str4, "UTF-8"));
                        sb.append("&");
                    }
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
            sb.append("sign_key=");
            sb.append(str);
            return SecurityUtil.md5(sb.toString().getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    public static String getNonce(Context context, String str, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, map)) == null) {
            map.put("reqid", PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
            map.put("sp_params", PassBioDataEncryptor.encryptParams(str));
            map.put("s1", a(context, context.getPackageName()));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
            return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context, arrayList));
        }
        return (String) invokeLLL.objValue;
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, httpHashMap, list, httpHandlerWrap) == null) {
            get(str, ReqPriority.NORMAL, httpHashMap, list, 0, httpHandlerWrap);
        }
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, reqPriority, httpHashMap, httpHandlerWrap) == null) {
            post(str, reqPriority, httpHashMap, null, httpHandlerWrap);
        }
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, reqPriority, httpHashMap, list, Integer.valueOf(i2), httpHandlerWrap}) == null) {
            this.a.get(this.f36148b, a(str, reqPriority, httpHashMap, list, i2), new HttpResponseHandler(this, Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread(), httpHandlerWrap) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpHandlerWrap a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HttpClientWrap f36149b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Boolean.valueOf(r10), httpHandlerWrap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Looper) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36149b = this;
                    this.a = httpHandlerWrap;
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str2) == null) {
                        this.a.onFailure(th, -1, str2);
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.onFinish();
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.onStart();
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onSuccess(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i3, str2) == null) {
                        this.a.onSuccess(i3, str2);
                    }
                }
            });
        }
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, reqPriority, httpHashMap, list, httpHandlerWrap) == null) {
            post(str, reqPriority, httpHashMap, list, 0, httpHandlerWrap);
        }
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, this, str, httpHashMap, list, i2)) == null) {
            PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
            passHttpParamDTO.url = str;
            passHttpParamDTO.paramsMap = httpHashMap;
            passHttpParamDTO.cookie = list;
            passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.f36148b, BeanConstants.tpl);
            passHttpParamDTO.connectTimeout = i2;
            passHttpParamDTO.asyncCookie = true;
            return passHttpParamDTO;
        }
        return (PassHttpParamDTO) invokeLLLI.objValue;
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, reqPriority, httpHashMap, list, Integer.valueOf(i2), httpHandlerWrap}) == null) {
            this.a.post(this.f36148b, a(str, reqPriority, httpHashMap, list, i2), new HttpResponseHandler(this, Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread(), httpHandlerWrap) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpHandlerWrap a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HttpClientWrap f36151b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Boolean.valueOf(r10), httpHandlerWrap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Looper) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36151b = this;
                    this.a = httpHandlerWrap;
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str2) == null) {
                        this.a.onFailure(th, -1, str2);
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.onFinish();
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.onStart();
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onSuccess(int i3, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i3, str2) == null) {
                        this.a.onSuccess(i3, str2);
                    }
                }
            });
        }
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, binaryHttpHandlerWrap) == null) {
            get(str, null, null, 0, binaryHttpHandlerWrap);
        }
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, httpHashMap, list, Integer.valueOf(i2), binaryHttpHandlerWrap}) == null) {
            this.a.get(this.f36148b, a(str, httpHashMap, list, i2), new BinaryHttpResponseHandler(this, Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread(), binaryHttpHandlerWrap) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BinaryHttpHandlerWrap a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HttpClientWrap f36150b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r10, r11, Boolean.valueOf(r12), binaryHttpHandlerWrap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Looper) objArr2[0], (String[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36150b = this;
                    this.a = binaryHttpHandlerWrap;
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str2) == null) {
                        this.a.onFailure(th, -1, str2);
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.onFinish();
                    }
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.onStart();
                    }
                }

                @Override // com.baidu.pass.http.BinaryHttpResponseHandler
                public void onSuccess(int i3, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i3, bArr) == null) {
                        this.a.onSuccess(i3, bArr);
                    }
                }
            });
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                return (packageInfo == null || packageInfo.signatures == null) ? "" : Crypto.sha1(packageInfo.signatures[0].toByteArray());
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
