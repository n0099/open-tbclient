package com.baidu.pass.biometrics.base.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.http.utils.HttpUtils;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.utils.Crypto;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpClientWrap {
    private static final String KEY_REQID = "reqid";
    private static final String PARAM_CUID_2 = "cuid_2";
    private static final String PARAM_ENCODE = "encode";
    private static final String PARAM_UA = "ua";
    private static final String SING_SHA1 = "s1";
    private static final String SP_PARAMETER = "sp_params";
    private Context context;
    private PassHttpClient passHttpClient = new PassHttpClient();

    public HttpClientWrap(Context context) {
        this.context = context;
    }

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, null, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.get(this.context, buildParamDTO(str, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.1
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }
        });
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, (List<HttpCookie>) null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        this.passHttpClient.get(this.context, buildParamDTO(str, httpHashMap, list, i), new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.2
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
            protected void onFailure(Throwable th, String str2) {
                binaryHttpHandlerWrap.onFailure(th, -1, str2);
            }
        });
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.post(this.context, buildParamDTO(str, httpHashMap, list, i), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) { // from class: com.baidu.pass.biometrics.base.http.HttpClientWrap.3
            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onStart() {
                httpHandlerWrap.onStart();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFinish() {
                httpHandlerWrap.onFinish();
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onSuccess(int i2, String str2) {
                httpHandlerWrap.onSuccess(i2, str2);
            }

            @Override // com.baidu.pass.http.HttpResponseHandler
            protected void onFailure(Throwable th, String str2) {
                httpHandlerWrap.onFailure(th, -1, str2);
            }
        });
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.context, BeanConstants.tpl);
        passHttpParamDTO.connectTimeout = i;
        passHttpParamDTO.asyncCookie = true;
        return passHttpParamDTO;
    }

    public void cancelRequest() {
        if (this.passHttpClient != null) {
            this.passHttpClient.cancelRequests(true);
        }
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
                    sb.append(str3).append("=").append(URLEncoder.encode(str4, HTTP.UTF_8)).append("&");
                }
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    public static String getNonce(Context context, String str, Map<String, String> map) {
        map.put(KEY_REQID, PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
        map.put(SP_PARAMETER, PassBioDataEncryptor.encryptParams(str));
        map.put(SING_SHA1, getAppSignatureSha1(context, context.getPackageName()));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
        }
        return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context, arrayList));
    }

    public static Map<String, String> appendCertification(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_ENCODE, "utf-8");
        hashMap.put(PARAM_UA, PassBiometricUtil.getUA(context, BeanConstants.tpl));
        hashMap.put("time", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("appid", BeanConstants.appid);
        hashMap.put(TableDefine.PaSubscribeColumns.COLUMN_TPL, BeanConstants.tpl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_CUID_2, PhoneUtils.getCUID2(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put("wcp", PassBioDataEncryptor.encryptParams(new String(jSONObject.toString().getBytes())));
        return hashMap;
    }

    private static String getAppSignatureSha1(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null) {
                return Crypto.sha1(packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }
}
