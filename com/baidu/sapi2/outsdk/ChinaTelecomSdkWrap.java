package com.baidu.sapi2.outsdk;

import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class ChinaTelecomSdkWrap {
    private static final int a = 30000;
    private static final int b = 15000;
    private static final int c = 15000;
    private static String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface PreLoginCallback {
        void onError(int i);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, String str, String str2, int i, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(OneKeyLoginSdkCall.a, "in china telecom login pre get phone info");
        CtAuth.getInstance().init(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, null);
        d = str2;
        a(str, str2, i, (PreLoginCallback) null, oneKeyLoginCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > SapiContext.getInstance().getLong("china_telecom_expired_time", currentTimeMillis)) {
            a(OneKeyLoginSdkCall.k, d, 0, new PreLoginCallback() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.1
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
                    tokenListener.onGetTokenComplete(jSONObject);
                }

                @Override // com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.PreLoginCallback
                public void onSuccess() {
                    ChinaTelecomSdkWrap.this.a(sapiConfiguration, OneKeyLoginSdkCall.q, tokenListener);
                }
            }, (OneKeyLoginCallback) null);
        } else {
            a(sapiConfiguration, OneKeyLoginSdkCall.q, tokenListener);
        }
    }

    private void a(final String str, final String str2, final int i, final PreLoginCallback preLoginCallback, final OneKeyLoginCallback oneKeyLoginCallback) {
        CtSetting ctSetting;
        if (i == 0) {
            ctSetting = new CtSetting(15000, 15000, 30000);
        } else {
            ctSetting = new CtSetting(i, i, i);
        }
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        CtAuth.getInstance().requestPreLogin(ctSetting, new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [154=4] */
            @Override // cn.com.chinatelecom.account.api.ResultListener
            public void onResult(String str3) {
                int i2 = 0;
                Log.i(OneKeyLoginSdkCall.a, "requestPreLogin result = " + str3);
                String str4 = "-1";
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        int optInt = jSONObject.optInt("result");
                        String str5 = optInt + "";
                        try {
                            if (optInt != 0) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(optInt);
                                }
                                new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                                SapiStatUtil.statPreGetPhoneInfo(0, str5, "CT", str, str2);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (!"CT".equals(optJSONObject.optString("operatorType"))) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(-202);
                                }
                                new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                                SapiStatUtil.statPreGetPhoneInfo(0, str5, "CT", str, str2);
                                return;
                            }
                            OneKeyLoginSdkCall.q = optJSONObject.optString("accessCode");
                            OneKeyLoginSdkCall.p = optJSONObject.optString("number");
                            int i3 = !TextUtils.isEmpty(OneKeyLoginSdkCall.q) ? 1 : 0;
                            try {
                                if (TextUtils.isEmpty(OneKeyLoginSdkCall.p) || oneKeyLoginCallback == null) {
                                    new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                                } else {
                                    int afterConnTimeOut = GetOneKeyLoginStateDTO.getAfterConnTimeOut(i);
                                    if (afterConnTimeOut == 0) {
                                        new OneKeyLoginSdkCall().b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, null);
                                    } else {
                                        SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, OneKeyLoginSdkCall.p, afterConnTimeOut);
                                    }
                                }
                                SapiContext.getInstance().put("china_telecom_expired_time", (optJSONObject.optLong("expiredTime") + currentTimeMillis) - 30);
                                if (preLoginCallback != null) {
                                    preLoginCallback.onSuccess();
                                }
                                SapiStatUtil.statPreGetPhoneInfo(i3, str5, "CT", str, str2);
                            } catch (Throwable th) {
                                th = th;
                                i2 = i3;
                                str4 = str5;
                                SapiStatUtil.statPreGetPhoneInfo(i2, str4, "CT", str, str2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str4 = str5;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e) {
                    Log.e(e);
                    SapiStatUtil.statPreGetPhoneInfo(0, "-202", "CT", str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        CtAuth.getInstance().requestLogin(str, new CtSetting(15000, 15000, 30000), new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.3
            @Override // cn.com.chinatelecom.account.api.ResultListener
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
                    Log.i(OneKeyLoginSdkCall.a, "in china telecom get token: " + jSONObject.toString());
                } catch (Exception e) {
                    Log.e(e);
                }
                tokenListener.onGetTokenComplete(jSONObject);
            }
        });
    }
}
