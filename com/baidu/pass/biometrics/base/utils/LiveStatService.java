package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.launch.SmartLaunchStats;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class LiveStatService {
    public static final String DOMAIN_NSCLICK_URL = "https://nsclick.baidu.com/v.gif";
    public static final String TAG = "LiveStatService";
    public static final Map<String, String> a;
    public static final String b = "4854";
    public static final String c = "page";
    public static final String d = "source";
    public static final String e = "ext";
    public static final String f = "living_recog";

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("pid", "111");
        a.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
        a.put(Config.DEVICE_PART, "android");
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(a);
            map.put("v", String.valueOf(System.currentTimeMillis()));
            hashMap.put("name", str);
            hashMap.put("model", Build.MODEL);
            hashMap.put("tpl", BeanConstants.tpl);
            hashMap.put("clientfrom", "mobilesdk_enhanced");
            hashMap.put("app_version", PassBioBaseUtil.getVersionName(context));
            hashMap.put("sdk_version", PassBiometricDefaultFactory.VERSION_NAME);
            hashMap.put("cuid", SapiUtils.getClientId(context));
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
            passHttpParamDTO.priority = ReqPriority.LOW;
            PassHttpClient.getInstance().get(context.getApplicationContext(), passHttpParamDTO, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.LiveStatService.1
                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                }

                @Override // com.baidu.pass.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                }
            });
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(hashMap);
            jSONObject.put("page", "living_recog");
            jSONObject.put("source", BeanConstants.tpl);
            jSONObject.put("ext", jSONObject2);
            ServiceManager.getInstance().getIsAccountManager().getUbcUploadImplCallback().onEvent(b, jSONObject);
        } catch (Throwable unused) {
        }
    }
}
