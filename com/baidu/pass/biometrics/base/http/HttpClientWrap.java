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
import com.baidu.pass.http.ReqPriority;
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
/* loaded from: classes2.dex */
public class HttpClientWrap {

    /* renamed from: c  reason: collision with root package name */
    public static final String f9013c = "encode";

    /* renamed from: d  reason: collision with root package name */
    public static final String f9014d = "ua";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9015e = "cuid_2";

    /* renamed from: f  reason: collision with root package name */
    public static final String f9016f = "reqid";

    /* renamed from: g  reason: collision with root package name */
    public static final String f9017g = "sp_params";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9018h = "s1";

    /* renamed from: a  reason: collision with root package name */
    public PassHttpClient f9019a = PassHttpClient.getInstance();

    /* renamed from: b  reason: collision with root package name */
    public Context f9020b;

    public HttpClientWrap(Context context) {
        this.f9020b = context;
    }

    private PassHttpParamDTO a(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2) {
        PassHttpParamDTO a2 = a(str, httpHashMap, list, i2);
        a2.priority = reqPriority;
        return a2;
    }

    public static Map<String, String> appendCertification(Context context) {
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
        map.put("reqid", PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
        map.put("sp_params", PassBioDataEncryptor.encryptParams(str));
        map.put("s1", a(context, context.getPackageName()));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
        }
        return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context, arrayList));
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, ReqPriority.NORMAL, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, null, httpHandlerWrap);
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, final HttpHandlerWrap httpHandlerWrap) {
        this.f9019a.get(this.f9020b, a(str, reqPriority, httpHashMap, list, i2), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.1
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i3, String str2) {
                httpHandlerWrap.onSuccess(i3, str2);
            }
        });
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, list, 0, httpHandlerWrap);
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.f9020b, BeanConstants.tpl);
        passHttpParamDTO.connectTimeout = i2;
        passHttpParamDTO.asyncCookie = true;
        return passHttpParamDTO;
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, final HttpHandlerWrap httpHandlerWrap) {
        this.f9019a.post(this.f9020b, a(str, reqPriority, httpHashMap, list, i2), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onSuccess(int i3, String str2) {
                httpHandlerWrap.onSuccess(i3, str2);
            }
        });
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, null, null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        this.f9019a.get(this.f9020b, a(str, httpHashMap, list, i2), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.2
            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                binaryHttpHandlerWrap.onFailure(th, -1, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onFinish() {
                binaryHttpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            public void onStart() {
                binaryHttpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.BinaryHttpResponseHandler
            public void onSuccess(int i3, byte[] bArr) {
                binaryHttpHandlerWrap.onSuccess(i3, bArr);
            }
        });
    }

    public static String a(Context context, String str) {
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
}
