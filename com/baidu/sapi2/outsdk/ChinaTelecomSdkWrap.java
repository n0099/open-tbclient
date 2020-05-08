package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ChinaTelecomSdkWrap {
    private static final int a = 30000;
    private static final int b = 15000;
    private static final int c = 15000;
    private static String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface PreLoginCallback {
        void onError(int i);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(c.a, "in china telecom login pre get phone info");
        CtAuth.getInstance().init(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, (TraceLogger) null);
        d = str2;
        a(str, str2, (PreLoginCallback) null, oneKeyLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > SapiContext.getInstance().getLong("china_telecom_expired_time", currentTimeMillis)) {
            a(c.k, d, new PreLoginCallback() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.1
                @Override // com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.PreLoginCallback
                public void onError(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                        jSONObject.put("code", i);
                        jSONObject.put("msg", "request pre login error");
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                }

                @Override // com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.PreLoginCallback
                public void onSuccess() {
                    ChinaTelecomSdkWrap.this.a(sapiConfiguration, c.q, aVar);
                }
            }, (OneKeyLoginCallback) null);
        } else {
            a(sapiConfiguration, c.q, aVar);
        }
    }

    private void a(final String str, final String str2, final PreLoginCallback preLoginCallback, final OneKeyLoginCallback oneKeyLoginCallback) {
        CtSetting ctSetting = new CtSetting(15000, 15000, 30000);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        CtAuth.getInstance().requestPreLogin(ctSetting, new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.2
            public void onResult(String str3) {
                int i = 0;
                Log.i(c.a, "requestPreLogin result = " + str3);
                String str4 = "-1";
                try {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            int optInt = jSONObject.optInt("result");
                            str4 = optInt + "";
                            if (optInt != 0) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(optInt);
                                }
                                new c().b(oneKeyLoginCallback, -101, null);
                                SapiStatUtil.statPreGetPhoneInfo(0, str4, "CT", str, str2);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (!"CT".equals(optJSONObject.optString("operatorType"))) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(-202);
                                }
                                new c().b(oneKeyLoginCallback, -101, null);
                                SapiStatUtil.statPreGetPhoneInfo(0, str4, "CT", str, str2);
                                return;
                            }
                            c.q = optJSONObject.optString("accessCode");
                            c.p = optJSONObject.optString("number");
                            int i2 = !TextUtils.isEmpty(c.q) ? 1 : 0;
                            try {
                                if (!TextUtils.isEmpty(c.p) && oneKeyLoginCallback != null) {
                                    SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, c.p);
                                } else {
                                    new c().b(oneKeyLoginCallback, -101, null);
                                }
                                SapiContext.getInstance().put("china_telecom_expired_time", (optJSONObject.optLong("expiredTime") + currentTimeMillis) - 30);
                                if (preLoginCallback != null) {
                                    preLoginCallback.onSuccess();
                                }
                                SapiStatUtil.statPreGetPhoneInfo(i2, str4, "CT", str, str2);
                            } catch (Throwable th) {
                                th = th;
                                i = i2;
                                SapiStatUtil.statPreGetPhoneInfo(i, str4, "CT", str, str2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e) {
                        Log.e(e);
                        SapiStatUtil.statPreGetPhoneInfo(0, "-202", "CT", str, str2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final c.a aVar) {
        CtAuth.getInstance().requestLogin(str, new CtSetting(15000, 15000, 30000), new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.3
            public void onResult(String str2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                    JSONObject jSONObject2 = new JSONObject(str2);
                    if (jSONObject2.optInt("result") == 0) {
                        jSONObject.put("token", jSONObject2.optJSONObject("responseData").optString("accessToken"));
                    }
                    jSONObject.put("code", jSONObject2.optInt("result"));
                    SapiContext.getInstance().put("china_telecom_expired_time", 0L);
                    Object[] objArr = new Object[1];
                    objArr[0] = "in china telecom get token: " + jSONObject.toString();
                    Log.i(c.a, objArr);
                } catch (Exception e) {
                    Log.e(e);
                }
                aVar.onGetTokenComplete(jSONObject);
            }
        });
    }
}
