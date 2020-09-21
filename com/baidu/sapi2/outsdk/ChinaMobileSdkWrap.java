package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.cmic.sso.sdk.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class ChinaMobileSdkWrap {
    static final String a = "rsa2048";
    private static final int b = 15000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, final String str, final String str2, final int i, final OneKeyLoginCallback oneKeyLoginCallback) {
        try {
            Log.i(OneKeyLoginSdkCall.a, "in china mobile login pre get phone info");
            com.cmic.sso.sdk.b.a bl = com.cmic.sso.sdk.b.a.bl(sapiConfiguration.context, a);
            if (i == 0) {
                bl.gw(15000L);
            } else {
                bl.gw(i);
            }
            bl.c(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new b() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap.1
                @Override // com.cmic.sso.sdk.b.b
                public void onGetTokenComplete(final JSONObject jSONObject) {
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = 0;
                            Log.i(OneKeyLoginSdkCall.a, "getPhoneInfo", jSONObject);
                            String str3 = "-1";
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                                str3 = jSONObject2.optString("resultCode");
                                if (str3.equals("103000") && jSONObject.optString("desc").equals("true") && !TextUtils.isEmpty(jSONObject.optString("securityphone"))) {
                                    OneKeyLoginSdkCall.o = jSONObject.optString("securityphone");
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (oneKeyLoginCallback != null) {
                                        int afterConnTimeOut = GetOneKeyLoginStateDTO.getAfterConnTimeOut(i);
                                        if (afterConnTimeOut == 0) {
                                            new OneKeyLoginSdkCall().b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, null);
                                        } else {
                                            SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, OneKeyLoginSdkCall.o, afterConnTimeOut);
                                        }
                                    }
                                } else {
                                    new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                                }
                                i2 = !TextUtils.isEmpty(OneKeyLoginSdkCall.o) ? 1 : 0;
                            } else {
                                new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                            }
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            SapiStatUtil.statPreGetPhoneInfo(i2, str3, "CM", str, str2);
                        }
                    }));
                }
            });
        } catch (Throwable th) {
            Log.e(th);
            SapiStatUtil.statPreGetPhoneInfo(0, "-202", "CM", str, str2);
            new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiConfiguration sapiConfiguration, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        try {
            com.cmic.sso.sdk.b.a bl = com.cmic.sso.sdk.b.a.bl(sapiConfiguration.context, a);
            bl.gw(15000L);
            bl.a(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new b() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap.2
                @Override // com.cmic.sso.sdk.b.b
                public void onGetTokenComplete(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException e) {
                            e = e;
                            Log.e(e);
                            tokenListener.onGetTokenComplete(jSONObject);
                        }
                    }
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("appid", sapiConfiguration.chinaMobileAppID);
                        jSONObject.put("code", jSONObject.optString("resultCode"));
                        Log.i(OneKeyLoginSdkCall.a, "in china mobile get token: " + jSONObject.toString());
                    } catch (JSONException e2) {
                        e = e2;
                        Log.e(e);
                        tokenListener.onGetTokenComplete(jSONObject);
                    }
                    tokenListener.onGetTokenComplete(jSONObject);
                }
            });
        } catch (Throwable th) {
            Log.e(th);
            tokenListener.onGetTokenComplete(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        com.cmic.sso.sdk.b.a bl = com.cmic.sso.sdk.b.a.bl(sapiConfiguration.context, a);
        bl.gw(15000L);
        bl.b(sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, new b() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSdkWrap.3
            @Override // com.cmic.sso.sdk.b.b
            public void onGetTokenComplete(JSONObject jSONObject) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception e) {
                        e = e;
                        Log.e(e);
                        tokenListener.onGetTokenComplete(jSONObject);
                    }
                }
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CM");
                    jSONObject.put("appid", sapiConfiguration.chinaMobileAppID);
                    Log.i(OneKeyLoginSdkCall.a, "in china mobile get oauth token: " + jSONObject.toString());
                } catch (Exception e2) {
                    e = e2;
                    Log.e(e);
                    tokenListener.onGetTokenComplete(jSONObject);
                }
                tokenListener.onGetTokenComplete(jSONObject);
            }
        });
    }
}
