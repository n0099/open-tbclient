package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import java.net.HttpCookie;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes2.dex */
public class HttpClientWrap {
    public String appSignKey;
    public Context context;
    public String domain;
    public PassHttpClient passHttpClient = PassHttpClient.getInstance();
    public boolean supportNetwork;

    public HttpClientWrap() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation != null) {
            this.context = confignation.context;
            this.domain = confignation.environment.getURL();
            this.appSignKey = confignation.appSignKey;
            this.supportNetwork = confignation.supportNetwork;
        }
    }

    public void get(String str, ReqPriority reqPriority, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, null, list, null, httpHandlerWrap);
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, null, null, httpHandlerWrap);
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i) {
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
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = SapiContext.getInstance().getAsyncCookie();
        return passHttpParamDTO;
    }

    private PassHttpParamDTO buildParamDTO(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO buildParamDTO = buildParamDTO(str, httpHashMap, hashMap, list, str2, i);
        buildParamDTO.priority = reqPriority;
        return buildParamDTO;
    }

    public PassHttpClientRequest get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, HttpHandlerWrap httpHandlerWrap) {
        return get(str, reqPriority, httpHashMap, null, list, str2, i, httpHandlerWrap);
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        return post(str, reqPriority, httpHashMap, null, list, null, 0, httpHandlerWrap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnfailure(HttpHandlerWrap httpHandlerWrap, Throwable th, String str) {
        int i;
        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
            i = -203;
            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"));
        } else {
            i = -202;
        }
        httpHandlerWrap.onFailure(th, i, str);
    }

    public void get(String str, ReqPriority reqPriority, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, null, httpHandlerWrap);
    }

    private boolean preHandle(HttpHandlerWrap httpHandlerWrap) {
        Context context = this.context;
        if (context == null) {
            httpHandlerWrap.onFailure(null, -801, "服务异常，请稍后再试");
            httpHandlerWrap.onFinish();
            return false;
        } else if (!SapiUtils.hasActiveNetwork(context)) {
            httpHandlerWrap.onFailure(null, -201, "网络连接不可用，请检查网络设置");
            httpHandlerWrap.onFinish();
            return false;
        } else if (!this.supportNetwork) {
            httpHandlerWrap.onFailure(null, -201, "网络连接不可用，请检查网络设置");
            httpHandlerWrap.onFinish();
            return false;
        } else {
            return true;
        }
    }

    public PassHttpClientRequest get(final String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.1
            @Override // java.lang.Runnable
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (!preHandle(httpHandlerWrap)) {
            return null;
        }
        return this.passHttpClient.get(this.context, buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                HttpClientWrap.this.handleOnfailure(httpHandlerWrap, th, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i2, String str3, HashMap<String, String> hashMap2) {
                try {
                    httpHandlerWrap.onSuccess(i2, str3, hashMap2);
                } catch (Throwable th) {
                    onFailure(th, str3);
                    if (!TextUtils.isEmpty(str)) {
                        StatService.onEvent("http_client_response_error", Collections.singletonMap("url", SecurityUtil.base64Encode(str.getBytes())));
                    }
                }
            }
        });
    }

    public PassHttpClientRequest post(final String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.3
            @Override // java.lang.Runnable
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (!preHandle(httpHandlerWrap)) {
            return null;
        }
        return this.passHttpClient.post(this.context, buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.4
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                HttpClientWrap.this.handleOnfailure(httpHandlerWrap, th, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i2, String str3, HashMap<String, String> hashMap2) {
                try {
                    httpHandlerWrap.onSuccess(i2, str3, hashMap2);
                } catch (Throwable th) {
                    onFailure(th, str3);
                    if (!TextUtils.isEmpty(str)) {
                        StatService.onEvent("http_client_response_error", Collections.singletonMap("url", SecurityUtil.base64Encode(str.getBytes())));
                    }
                }
            }
        });
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        return post(str, reqPriority, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        post(str, ReqPriority.IMMEDIATE, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }
}
