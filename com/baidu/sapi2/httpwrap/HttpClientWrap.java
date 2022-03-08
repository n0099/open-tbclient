package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpClientRequest;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes4.dex */
public class HttpClientWrap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appSignKey;
    public Context context;
    public String domain;
    public PassHttpClient passHttpClient;
    public boolean supportNetwork;

    public HttpClientWrap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.passHttpClient = PassHttpClient.getInstance();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation != null) {
            this.context = confignation.context;
            this.domain = confignation.environment.getURL();
            this.appSignKey = confignation.appSignKey;
            this.supportNetwork = confignation.supportNetwork;
        }
    }

    private PassHttpParamDTO buildParamDTO(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, reqPriority, httpHashMap, hashMap, list, str2, Integer.valueOf(i2)})) == null) {
            PassHttpParamDTO buildParamDTO = buildParamDTO(str, httpHashMap, hashMap, list, str2, i2);
            buildParamDTO.priority = reqPriority;
            return buildParamDTO;
        }
        return (PassHttpParamDTO) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnfailure(HttpHandlerWrap httpHandlerWrap, Throwable th, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpHandlerWrap, th, str) == null) {
            if (th == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                i2 = -202;
            } else {
                i2 = -203;
                StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"));
            }
            httpHandlerWrap.onFailure(th, i2, str);
        }
    }

    private boolean preHandle(HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, httpHandlerWrap)) == null) {
            Context context = this.context;
            if (context == null) {
                httpHandlerWrap.onFailure(null, -801, "服务异常，请稍后再试");
                httpHandlerWrap.onFinish();
                return false;
            } else if (!SapiUtils.hasActiveNetwork(context)) {
                httpHandlerWrap.onFailure(null, -201, "网络连接不可用，请检查网络设置");
                httpHandlerWrap.onFinish();
                return false;
            } else if (this.supportNetwork) {
                return true;
            } else {
                httpHandlerWrap.onFailure(null, -201, "网络连接不可用，请检查网络设置");
                httpHandlerWrap.onFinish();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void get(String str, ReqPriority reqPriority, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, reqPriority, httpHandlerWrap) == null) {
            get(str, reqPriority, null, httpHandlerWrap);
        }
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, reqPriority, httpHashMap, httpHandlerWrap) == null) {
            post(str, reqPriority, httpHashMap, null, null, httpHandlerWrap);
        }
    }

    public void get(String str, ReqPriority reqPriority, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, reqPriority, list, httpHandlerWrap) == null) {
            get(str, reqPriority, null, list, null, httpHandlerWrap);
        }
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, httpHashMap, list, str2, httpHandlerWrap) == null) {
            post(str, ReqPriority.IMMEDIATE, httpHashMap, null, list, str2, 0, httpHandlerWrap);
        }
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, httpHashMap, hashMap, list, str2, Integer.valueOf(i2)})) == null) {
            PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
            if (str != null && !str.contains("://")) {
                str = this.domain + str;
            }
            passHttpParamDTO.url = str;
            if (httpHashMap != null) {
                httpHashMap.doSign(this.appSignKey);
            }
            passHttpParamDTO.paramsMap = httpHashMap;
            passHttpParamDTO.headers = hashMap;
            passHttpParamDTO.cookie = list;
            passHttpParamDTO.userAgent = str2;
            passHttpParamDTO.connectTimeout = i2;
            passHttpParamDTO.asyncCookie = SapiContext.getInstance().getAsyncCookie();
            return passHttpParamDTO;
        }
        return (PassHttpParamDTO) invokeCommon.objValue;
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, reqPriority, httpHashMap, list, str2, httpHandlerWrap}) == null) {
            get(str, reqPriority, httpHashMap, null, list, str2, 0, httpHandlerWrap);
        }
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, reqPriority, httpHashMap, list, str2, httpHandlerWrap})) == null) ? post(str, reqPriority, httpHashMap, null, list, str2, 0, httpHandlerWrap) : (PassHttpClientRequest) invokeCommon.objValue;
    }

    public PassHttpClientRequest get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, reqPriority, httpHashMap, list, str2, Integer.valueOf(i2), httpHandlerWrap})) == null) ? get(str, reqPriority, httpHashMap, null, list, str2, i2, httpHandlerWrap) : (PassHttpClientRequest) invokeCommon.objValue;
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, reqPriority, httpHashMap, hashMap, list, str2, httpHandlerWrap})) == null) ? post(str, reqPriority, httpHashMap, null, list, null, 0, httpHandlerWrap) : (PassHttpClientRequest) invokeCommon.objValue;
    }

    public PassHttpClientRequest get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, reqPriority, httpHashMap, hashMap, list, str2, Integer.valueOf(i2), httpHandlerWrap})) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, httpHandlerWrap) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpClientWrap this$0;
                public final /* synthetic */ HttpHandlerWrap val$handlerWrap;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, httpHandlerWrap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handlerWrap = httpHandlerWrap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$handlerWrap.onStart();
                    }
                }
            });
            if (preHandle(httpHandlerWrap)) {
                return this.passHttpClient.get(this.context, buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i2), new HttpResponseHandler(this, Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread(), httpHandlerWrap, str) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HttpClientWrap this$0;
                    public final /* synthetic */ HttpHandlerWrap val$handlerWrap;
                    public final /* synthetic */ String val$url;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, Boolean.valueOf(r10), httpHandlerWrap, str};
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
                        this.this$0 = this;
                        this.val$handlerWrap = httpHandlerWrap;
                        this.val$url = str;
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str3) == null) {
                            this.this$0.handleOnfailure(this.val$handlerWrap, th, str3);
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.val$handlerWrap.onFinish();
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onSuccess(int i3, String str3, HashMap<String, String> hashMap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048579, this, i3, str3, hashMap2) == null) {
                            try {
                                this.val$handlerWrap.onSuccess(i3, str3, hashMap2);
                            } catch (Throwable th) {
                                onFailure(th, str3);
                                if (TextUtils.isEmpty(this.val$url)) {
                                    return;
                                }
                                StatService.onEvent("http_client_response_error", Collections.singletonMap("url", SecurityUtil.base64Encode(this.val$url.getBytes())));
                            }
                        }
                    }
                });
            }
            return null;
        }
        return (PassHttpClientRequest) invokeCommon.objValue;
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, reqPriority, httpHashMap, hashMap, list, str2, Integer.valueOf(i2), httpHandlerWrap})) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, httpHandlerWrap) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpClientWrap this$0;
                public final /* synthetic */ HttpHandlerWrap val$handlerWrap;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, httpHandlerWrap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handlerWrap = httpHandlerWrap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$handlerWrap.onStart();
                    }
                }
            });
            if (preHandle(httpHandlerWrap)) {
                return this.passHttpClient.post(this.context, buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i2), new HttpResponseHandler(this, Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread(), httpHandlerWrap, str) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HttpClientWrap this$0;
                    public final /* synthetic */ HttpHandlerWrap val$handlerWrap;
                    public final /* synthetic */ String val$url;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, Boolean.valueOf(r10), httpHandlerWrap, str};
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
                        this.this$0 = this;
                        this.val$handlerWrap = httpHandlerWrap;
                        this.val$url = str;
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, th, str3) == null) {
                            this.this$0.handleOnfailure(this.val$handlerWrap, th, str3);
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.val$handlerWrap.onFinish();
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onSuccess(int i3, String str3, HashMap<String, String> hashMap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048579, this, i3, str3, hashMap2) == null) {
                            try {
                                this.val$handlerWrap.onSuccess(i3, str3, hashMap2);
                            } catch (Throwable th) {
                                onFailure(th, str3);
                                if (TextUtils.isEmpty(this.val$url)) {
                                    return;
                                }
                                StatService.onEvent("http_client_response_error", Collections.singletonMap("url", SecurityUtil.base64Encode(this.val$url.getBytes())));
                            }
                        }
                    }
                });
            }
            return null;
        }
        return (PassHttpClientRequest) invokeCommon.objValue;
    }
}
