package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class a {
    static final String a = "rsa2048";

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, final String str, final String str2, final OneKeyLoginCallback oneKeyLoginCallback) {
        try {
            Object[] objArr = new Object[1];
            objArr[0] = "in china mobile login pre get phone info";
            Log.i(c.a, objArr);
            AuthnHelper.getInstance(sapiConfiguration.context, a).getPhoneInfo(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new TokenListener() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap$1
                public void onGetTokenComplete(final JSONObject jSONObject) {
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap$1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i = 0;
                            Log.i(c.a, "getPhoneInfo", jSONObject);
                            String str3 = "-1";
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                                str3 = jSONObject2.optString("resultCode");
                                if (str3.equals("103000") && jSONObject.optString("desc").equals("true") && !TextUtils.isEmpty(jSONObject.optString("securityphone"))) {
                                    c.o = jSONObject.optString("securityphone");
                                    if (oneKeyLoginCallback != null) {
                                        SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, c.o);
                                    }
                                } else {
                                    new c().b(oneKeyLoginCallback, -101, null);
                                }
                                i = !TextUtils.isEmpty(c.o) ? 1 : 0;
                            } else {
                                new c().b(oneKeyLoginCallback, -101, null);
                            }
                            ChinaMobileSdkWrap$1 chinaMobileSdkWrap$1 = ChinaMobileSdkWrap$1.this;
                            SapiStatUtil.statPreGetPhoneInfo(i, str3, "CM", str, str2);
                        }
                    }));
                }
            });
        } catch (Throwable th) {
            Log.e(th);
            SapiStatUtil.statPreGetPhoneInfo(0, "-202", "CM", str, str2);
            new c().b(oneKeyLoginCallback, -101, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        try {
            AuthnHelper.getInstance(sapiConfiguration.context, a).loginAuth(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new TokenListener() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap$2
                public void onGetTokenComplete(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException e) {
                            e = e;
                            Log.e(e);
                            aVar.onGetTokenComplete(jSONObject);
                        }
                    }
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("appid", sapiConfiguration.chinaMobileAppID);
                        jSONObject.put("code", jSONObject.optString("resultCode"));
                        Object[] objArr = new Object[1];
                        objArr[0] = "in china mobile get token: " + jSONObject.toString();
                        Log.i(c.a, objArr);
                    } catch (JSONException e2) {
                        e = e2;
                        Log.e(e);
                        aVar.onGetTokenComplete(jSONObject);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                }
            });
        } catch (Throwable th) {
            Log.e(th);
            aVar.onGetTokenComplete(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        AuthnHelper.getInstance(sapiConfiguration.context, a).mobileAuth(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new TokenListener() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap$3
            public void onGetTokenComplete(JSONObject jSONObject) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception e) {
                        e = e;
                        Log.e(e);
                        aVar.onGetTokenComplete(jSONObject);
                    }
                }
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CM");
                    jSONObject.put("appid", sapiConfiguration.chinaMobileAppID);
                    Object[] objArr = new Object[1];
                    objArr[0] = "in china mobile get oauth token: " + jSONObject.toString();
                    Log.i(c.a, objArr);
                } catch (Exception e2) {
                    e = e2;
                    Log.e(e);
                    aVar.onGetTokenComplete(jSONObject);
                }
                aVar.onGetTokenComplete(jSONObject);
            }
        });
    }
}
