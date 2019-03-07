package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Looper;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import java.net.HttpCookie;
import java.util.List;
/* loaded from: classes.dex */
public class HttpClientWrap {
    private static final String TAG = HttpClientWrap.class.getSimpleName();
    private PassHttpClient passHttpClient = new PassHttpClient();
    private Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, null, null, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, list, str2, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.get(this.context, buildParamDTO(str, httpHashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.1
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str3) {
                httpHandlerWrap.onSuccess(i2, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                httpHandlerWrap.onFailure(th, str3);
            }
        });
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, (List<HttpCookie>) null, (String) null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        this.passHttpClient.get(this.context, buildParamDTO(str, httpHashMap, list, str2, i), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                binaryHttpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                binaryHttpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.BinaryHttpResponseHandler
            protected void onSuccess(int i2, byte[] bArr) {
                binaryHttpHandlerWrap.onSuccess(i2, bArr);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                binaryHttpHandlerWrap.onFailure(th, str3);
            }
        });
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, list, str2, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.post(this.context, buildParamDTO(str, httpHashMap, list, str2, i), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.httpwrap.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str3) {
                httpHandlerWrap.onSuccess(i2, str3);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str3) {
                httpHandlerWrap.onFailure(th, str3);
            }
        });
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = str2;
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = SapiContext.getInstance(this.context).getAsyncCookie();
        return passHttpParamDTO;
    }

    public void cancelRequest() {
        if (this.passHttpClient != null) {
            this.passHttpClient.cancelRequests(true);
        }
    }
}
