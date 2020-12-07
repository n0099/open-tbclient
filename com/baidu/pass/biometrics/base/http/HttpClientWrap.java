package com.baidu.pass.biometrics.base.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
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
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes9.dex */
public class HttpClientWrap {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2708a = "encode";
    private static final String b = "ua";
    private static final String c = "cuid_2";
    private static final String d = "reqid";
    private static final String e = "sp_params";
    private static final String f = "s1";
    private PassHttpClient g = new PassHttpClient();
    private Context h;

    public HttpClientWrap(Context context) {
        this.h = context;
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.h, BeanConstants.tpl);
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = true;
        return passHttpParamDTO;
    }

    public static Map<String, String> appendCertification(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(f2708a, "utf-8");
        hashMap.put("ua", PassBiometricUtil.getUA(context, BeanConstants.tpl));
        hashMap.put("time", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("appid", BeanConstants.appid);
        hashMap.put("tpl", BeanConstants.tpl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(c, PhoneUtils.getCUID2(context));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("wcp", PassBioDataEncryptor.encryptParams(new String(jSONObject.toString().getBytes())));
        return hashMap;
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
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
                    sb.append(str3).append("=").append(URLEncoder.encode(str4, "UTF-8")).append(ETAG.ITEM_SEPARATOR);
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        sb.append("sign_key=").append(str);
        return SecurityUtil.md5(sb.toString().getBytes(), false);
    }

    public static String getNonce(Context context, String str, Map<String, String> map) {
        map.put(d, PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
        map.put(e, PassBioDataEncryptor.encryptParams(str));
        map.put(f, a(context, context.getPackageName()));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
        }
        return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context, arrayList));
    }

    public void cancelRequest() {
        PassHttpClient passHttpClient = this.g;
        if (passHttpClient != null) {
            passHttpClient.cancelRequests(true);
        }
    }

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.g.get(this.h, a(str, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.1
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }
        });
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.g.post(this.h, a(str, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }
        });
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, (List<HttpCookie>) null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        this.g.get(this.h, a(str, httpHashMap, list, i), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str2) {
                binaryHttpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                binaryHttpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                binaryHttpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.BinaryHttpResponseHandler
            protected void onSuccess(int i2, byte[] bArr) {
                binaryHttpHandlerWrap.onSuccess(i2, bArr);
            }
        });
    }

    private static String a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null) {
                return Crypto.sha1(packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return "";
    }
}
