package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class StatService {
    public static final String DOMAIN_NSCLICK_URL = "https://nsclick.baidu.com/v.gif";
    public static final String TAG = "StatService";

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f9589a;

    static {
        HashMap hashMap = new HashMap();
        f9589a = hashMap;
        hashMap.put("pid", "111");
        f9589a.put("type", "1023");
        f9589a.put("device", "android");
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (NetworkUtils.isNetworkAvailable(context)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(f9589a);
                map.put("v", String.valueOf(System.currentTimeMillis()));
                hashMap.put("name", str);
                hashMap.put("model", Build.MODEL);
                hashMap.put("tpl", BeanConstants.tpl);
                hashMap.put("clientfrom", "mobilesdk_enhanced");
                hashMap.put("app_version", PassBioBaseUtil.getVersionName(context));
                hashMap.put("sdk_version", PassBiometricDefaultFactory.VERSION_NAME);
                hashMap.put("cuid", PassBioBaseUtil.getClientId(context));
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
                new PassHttpClient().get(context.getApplicationContext(), passHttpParamDTO, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.StatService.1
                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str2) {
                    }

                    @Override // com.baidu.pass.http.HttpResponseHandler
                    public void onSuccess(int i, String str2) {
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
