package com.baidu.pass.biometrics.base.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* loaded from: classes3.dex */
public class HttpClientWrap {
    public static final String c = "encode";
    public static final String d = "ua";
    public static final String e = "cuid_2";
    public static final String f = "reqid";
    public static final String g = "sp_params";
    public static final String h = "s1";
    public PassHttpClient a = PassHttpClient.getInstance();
    public Context b;

    public HttpClientWrap(Context context) {
        this.b = context;
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.b, BeanConstants.tpl);
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = true;
        return passHttpParamDTO;
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, ReqPriority.NORMAL, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, null, httpHandlerWrap);
    }

    private PassHttpParamDTO a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i) {
        PassHttpParamDTO a = a(str, httpHashMap, list, i);
        a.priority = reqPriority;
        return a;
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        this.a.get(this.b, a(str, httpHashMap, list, i), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                binaryHttpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.BinaryHttpResponseHandler
            public void onSuccess(int i2, byte[] bArr) {
                binaryHttpHandlerWrap.onSuccess(i2, bArr);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                binaryHttpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                binaryHttpHandlerWrap.onStart();
            }
        });
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, list, 0, httpHandlerWrap);
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null) {
                return Crypto.sha1(packageInfo.signatures[0].toByteArray());
            }
            return "";
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, null, null, 0, binaryHttpHandlerWrap);
    }

    public static Map<String, String> appendCertification(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(c, IMAudioTransRequest.CHARSET);
        hashMap.put("ua", PassBiometricUtil.getUA(context, BeanConstants.tpl));
        hashMap.put("time", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("appid", BeanConstants.appid);
        hashMap.put("tpl", BeanConstants.tpl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e, PhoneUtils.getCUID2(context));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("wcp", PassBioDataEncryptor.encryptParams(new String(jSONObject.toString().getBytes())));
        return hashMap;
    }

    public static String calculateSig(Map<String, String> map, String str) {
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

    public static String getNonce(Context context, String str, Map<String, String> map) {
        map.put(f, PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
        map.put(g, PassBioDataEncryptor.encryptParams(str));
        map.put(h, a(context, context.getPackageName()));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
        }
        return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context, arrayList));
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.a.get(this.b, a(str, reqPriority, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.1
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                httpHandlerWrap.onStart();
            }
        });
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.a.post(this.b, a(str, reqPriority, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                httpHandlerWrap.onStart();
            }
        });
    }
}
