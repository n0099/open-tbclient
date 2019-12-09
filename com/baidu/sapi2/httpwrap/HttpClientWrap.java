package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.r;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes2.dex */
public class HttpClientWrap {
    private PassHttpClient a = new PassHttpClient();
    private Context b;
    private String c;
    private String d;

    public HttpClientWrap() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation != null) {
            this.b = confignation.context;
            this.c = confignation.environment.getURL();
            this.d = confignation.appSignKey;
        }
    }

    public void cancelRequest() {
        PassHttpClient passHttpClient = this.a;
        if (passHttpClient != null) {
            passHttpClient.cancelRequests(true);
        }
    }

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, null, httpHandlerWrap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpHandlerWrap httpHandlerWrap, Throwable th, String str) {
        int i = -202;
        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
            i = -203;
            r.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"));
        }
        httpHandlerWrap.onFailure(th, i, str);
    }

    public void get(String str, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, list, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, hashMap, null, null, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, (HashMap<String, String>) null, list, str2, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, (HashMap<String, String>) null, list, str2, i, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.4
            @Override // java.lang.Runnable
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (!a(httpHandlerWrap)) {
            return;
        }
        this.a.post(this.b, a(str, httpHashMap, hashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.5
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                HttpClientWrap.this.a(httpHandlerWrap, th, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str3, HashMap<String, String> hashMap2) {
                httpHandlerWrap.onSuccess(i2, str3, hashMap2);
            }
        });
    }

    public void get(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.1
            @Override // java.lang.Runnable
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (!a(httpHandlerWrap)) {
            return;
        }
        this.a.get(this.b, a(str, httpHashMap, hashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                HttpClientWrap.this.a(httpHandlerWrap, th, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str3, HashMap<String, String> hashMap2) {
                httpHandlerWrap.onSuccess(i2, str3, hashMap2);
            }
        });
    }

    private boolean a(HttpHandlerWrap httpHandlerWrap) {
        Context context = this.b;
        if (context == null) {
            httpHandlerWrap.onFailure(null, SapiResult.ERROR_CODE_SDK_NOT_INIT, "服务异常，请稍后再试");
            httpHandlerWrap.onFinish();
            return false;
        } else if (SapiUtils.hasActiveNetwork(context)) {
            return true;
        } else {
            httpHandlerWrap.onFailure(null, -201, SapiResult.ERROR_MSG_NETWORK_UNAVAILABLE);
            httpHandlerWrap.onFinish();
            return false;
        }
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, (HashMap<String, String>) null, (List<HttpCookie>) null, (String) null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        binaryHttpHandlerWrap.onStart();
        if (!a(binaryHttpHandlerWrap)) {
            return;
        }
        this.a.get(this.b, a(str, httpHashMap, hashMap, list, str2, i), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                HttpClientWrap.this.a(binaryHttpHandlerWrap, th, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                binaryHttpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str3, HashMap<String, String> hashMap2) {
                binaryHttpHandlerWrap.onSuccess(i2, str3, hashMap2);
            }
        });
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        if (str != null && !str.contains("://")) {
            str = this.c + str;
        }
        passHttpParamDTO.url = str;
        if (httpHashMap != null) {
            httpHashMap.doSign(this.d);
        }
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.headers = hashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = str2;
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = SapiContext.getInstance(this.b).getAsyncCookie();
        return passHttpParamDTO;
    }
}
