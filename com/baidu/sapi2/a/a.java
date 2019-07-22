package com.baidu.sapi2.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class a {
    public static final String a = a.class.getSimpleName();
    static final String b = "3";
    static final String c = "rsa2048";
    static final String d = "0";
    private static final String e = "1";

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, String str2) {
        try {
            AuthnHelper authnHelper = AuthnHelper.getInstance(context, c);
            JSONObject networkType = authnHelper.getNetworkType(context);
            if (networkType != null) {
                Log.e(a, "chinaMobileSDKGetPhoneInfo", "networktype", networkType);
                String optString = networkType.optString("operatortype");
                String optString2 = networkType.optString("networktype");
                if (!"1".equals(optString) || "0".equals(optString2)) {
                    Log.e(a, "preGetPhoneInfo", "unsupport");
                } else {
                    authnHelper.getPhoneInfo(str, str2, new TokenListener() { // from class: com.baidu.sapi2.a.a.1
                        public void onGetTokenComplete(final JSONObject jSONObject) {
                            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.a.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    String str3;
                                    int i = 1;
                                    Log.e(a.a, "getPhoneInfo", jSONObject);
                                    String str4 = LivenessStat.TYPE_STRING_DEFAULT;
                                    if (jSONObject != null) {
                                        str4 = jSONObject.optString("resultCode");
                                        if (str4.equals("103000") && jSONObject.optString("desc").equals("true") && !TextUtils.isEmpty(jSONObject.optString("securityphone"))) {
                                            c.a = jSONObject.optString("securityphone");
                                        }
                                        if (!TextUtils.isEmpty(c.a)) {
                                            str3 = str4;
                                            SapiStatUtil.statChinaMobile(i, str3, null, null);
                                        }
                                    }
                                    i = 0;
                                    str3 = str4;
                                    SapiStatUtil.statChinaMobile(i, str3, null, null);
                                }
                            }));
                        }
                    });
                }
            }
        } catch (Throwable th) {
            Log.e(th);
            SapiStatUtil.statChinaMobile(0, "-202", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        try {
            AuthnHelper.getInstance(sapiConfiguration.context, c).loginAuth(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new TokenListener() { // from class: com.baidu.sapi2.a.a.2
                public void onGetTokenComplete(JSONObject jSONObject) {
                    JSONException e2;
                    JSONObject jSONObject2;
                    if (jSONObject == null) {
                        try {
                            jSONObject2 = new JSONObject();
                        } catch (JSONException e3) {
                            e2 = e3;
                            jSONObject2 = jSONObject;
                            Log.e(e2);
                            aVar.onGetTokenComplete(jSONObject2);
                        }
                    } else {
                        jSONObject2 = jSONObject;
                    }
                    try {
                        jSONObject2.put("errno", 0);
                        jSONObject2.put("appid", sapiConfiguration.chinaMobileAppID);
                    } catch (JSONException e4) {
                        e2 = e4;
                        Log.e(e2);
                        aVar.onGetTokenComplete(jSONObject2);
                    }
                    aVar.onGetTokenComplete(jSONObject2);
                }
            });
        } catch (Throwable th) {
            Log.e(th);
            aVar.onGetTokenComplete(new JSONObject());
        }
    }
}
