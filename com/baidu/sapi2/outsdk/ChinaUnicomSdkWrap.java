package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.text.TextUtils;
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
import com.sdk.base.api.CallBack;
import com.sdk.base.api.ToolUtils;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class ChinaUnicomSdkWrap {
    private static final int a = 15;
    private static final String b = "baidu_passport_cu_onekey_login";
    private static String c = "";

    private void b(final SapiConfiguration sapiConfiguration, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        Log.i(OneKeyLoginSdkCall.a, "in getAsynToken");
        ToolUtils.clearCache(sapiConfiguration.context);
        UiOauthManager.getInstance(sapiConfiguration.context).login(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap.1
            @Override // com.sdk.base.api.CallBack
            public void onFailed(int i, int i2, String str, String str2) {
                tokenListener.onGetTokenComplete(new JSONObject());
                Log.e(OneKeyLoginSdkCall.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str);
                SapiStatUtil.statPreGetPhoneInfo(0, i2 + "", "CU", OneKeyLoginSdkCall.k, ChinaUnicomSdkWrap.c);
            }

            @Override // com.sdk.base.api.CallBack
            public void onSuccess(int i, String str, int i2, Object obj, String str2) {
                Log.i(OneKeyLoginSdkCall.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str + "    response: " + obj + "    seq: " + str2);
                String str3 = i2 + "";
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                        jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                        JSONObject jSONObject2 = new JSONObject(obj.toString());
                        jSONObject.put("CUVersion", "2");
                        int optInt = jSONObject2.optInt("code");
                        jSONObject.put("code", optInt);
                        if (optInt == 0) {
                            jSONObject.put("token", jSONObject2.optString("accessCode"));
                        }
                        SapiStatUtil.statPreGetPhoneInfo(!TextUtils.isEmpty(jSONObject2.optString("accessCode")) ? 1 : 0, str3, "CU", OneKeyLoginSdkCall.k, ChinaUnicomSdkWrap.c);
                    } catch (Exception e) {
                        Log.e(e);
                        SapiStatUtil.statPreGetPhoneInfo(0, str3, "CU", OneKeyLoginSdkCall.k, ChinaUnicomSdkWrap.c);
                    }
                    tokenListener.onGetTokenComplete(jSONObject);
                } catch (Throwable th) {
                    SapiStatUtil.statPreGetPhoneInfo(0, str3, "CU", OneKeyLoginSdkCall.k, ChinaUnicomSdkWrap.c);
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, String str, String str2, int i, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(OneKeyLoginSdkCall.a, "in china unicom login pre get phone info");
        a(sapiConfiguration, str2);
        a(sapiConfiguration.context, str, str2, i, oneKeyLoginCallback);
    }

    void a(SapiConfiguration sapiConfiguration, String str) {
        SDKManager.init(sapiConfiguration.context, sapiConfiguration.chinaUnicomAppKey, sapiConfiguration.chinaUnicomAppPublicKey);
        SDKManager.closePermission(true);
        SDKManager.setUserAgent(b);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, OneKeyLoginSdkCall.TokenListener tokenListener) {
        Log.i(OneKeyLoginSdkCall.a, "in getToken");
        if ((System.currentTimeMillis() / 1000) - SapiContext.getInstance().getLong("china_telecom_expired_time", 0L) < 3300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                jSONObject.put("token", OneKeyLoginSdkCall.s);
                jSONObject.put("code", 0);
                jSONObject.put("CUVersion", "2");
            } catch (JSONException e) {
                Log.e(e);
            }
            tokenListener.onGetTokenComplete(jSONObject);
            SapiContext.getInstance().put("china_telecom_expired_time", 0L);
            return;
        }
        b(sapiConfiguration, tokenListener);
    }

    private void a(Context context, final String str, final String str2, final int i, final OneKeyLoginCallback oneKeyLoginCallback) {
        ToolUtils.clearCache(context);
        UiOauthManager.getInstance(context).login(i == 0 ? 15 : i / 1000, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap.2
            @Override // com.sdk.base.api.CallBack
            public void onFailed(int i2, int i3, String str3, String str4) {
                Log.e(OneKeyLoginSdkCall.a, "onFailure  code:   " + i2 + "   status: " + i3 + "  msg：" + str3);
                SapiStatUtil.statPreGetPhoneInfo(0, i3 + "", "CU", str, str2);
                new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x008c */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v17 */
            /* JADX WARN: Type inference failed for: r1v38, types: [com.baidu.sapi2.outsdk.OneKeyLoginSdkCall] */
            /* JADX WARN: Type inference failed for: r3v7, types: [com.baidu.sapi2.callback.OneKeyLoginCallback] */
            @Override // com.sdk.base.api.CallBack
            public void onSuccess(int i2, String str3, int i3, Object obj, String str4) {
                int i4;
                Exception e;
                int i5;
                AnonymousClass2 anonymousClass2;
                int i6 = 1;
                i6 = 1;
                i6 = 1;
                i6 = 1;
                i6 = 1;
                int i7 = 0;
                Log.i(OneKeyLoginSdkCall.a, "onSuccess: code:" + i2 + "   status:" + i3 + "   msg:" + str3 + "    response: " + obj + "    seq: " + str4);
                String str5 = "";
                String str6 = i3 + "";
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(obj.toString());
                        if (jSONObject.optInt("code") == 0) {
                            OneKeyLoginSdkCall.s = jSONObject.optString("accessCode");
                            OneKeyLoginSdkCall.r = jSONObject.optString("fakeMobile");
                        }
                        if (!TextUtils.isEmpty(OneKeyLoginSdkCall.r)) {
                            try {
                                if (oneKeyLoginCallback != null) {
                                    int afterConnTimeOut = GetOneKeyLoginStateDTO.getAfterConnTimeOut(i);
                                    if (afterConnTimeOut == 0) {
                                        new OneKeyLoginSdkCall().b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, null);
                                        i4 = 1;
                                    } else {
                                        SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, OneKeyLoginSdkCall.r, afterConnTimeOut);
                                        i4 = 1;
                                    }
                                } else {
                                    i4 = 1;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                i4 = i6;
                                Log.e(e);
                                new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                                i5 = i4;
                                str5 = str6;
                                anonymousClass2 = this;
                                String str7 = str;
                                str6 = str2;
                                SapiStatUtil.statPreGetPhoneInfo(i5, str5, "CU", str7, str6);
                            } catch (Throwable th) {
                                th = th;
                                i7 = i6;
                                SapiStatUtil.statPreGetPhoneInfo(i7, str6, "CU", str, str2);
                                throw th;
                            }
                        } else {
                            ?? oneKeyLoginSdkCall = new OneKeyLoginSdkCall();
                            ?? r3 = oneKeyLoginCallback;
                            oneKeyLoginSdkCall.b(r3, -101, null);
                            i4 = 0;
                            i6 = r3;
                        }
                        try {
                            SapiContext.getInstance().put("china_telecom_expired_time", System.currentTimeMillis() / 1000);
                            i5 = i4;
                            str5 = str6;
                            anonymousClass2 = this;
                        } catch (Exception e3) {
                            e = e3;
                            Log.e(e);
                            new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -101, null);
                            i5 = i4;
                            str5 = str6;
                            anonymousClass2 = this;
                            String str72 = str;
                            str6 = str2;
                            SapiStatUtil.statPreGetPhoneInfo(i5, str5, "CU", str72, str6);
                        }
                    } catch (Throwable th2) {
                        i7 = str5;
                        th = th2;
                    }
                } catch (Exception e4) {
                    i4 = 0;
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                }
                String str722 = str;
                str6 = str2;
                SapiStatUtil.statPreGetPhoneInfo(i5, str5, "CU", str722, str6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final OneKeyLoginSdkCall.TokenListener tokenListener) {
        a(sapiConfiguration, str);
        OauthManager.getInstance(sapiConfiguration.context).getAuthoriseCode(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap.3
            @Override // com.sdk.base.api.CallBack
            public void onFailed(int i, int i2, String str2, String str3) {
                Log.e(OneKeyLoginSdkCall.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CU");
                } catch (JSONException e) {
                }
                tokenListener.onGetTokenComplete(jSONObject);
            }

            @Override // com.sdk.base.api.CallBack
            public void onSuccess(int i, String str2, int i2, Object obj, String str3) {
                Log.i(OneKeyLoginSdkCall.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str2 + "    response: " + obj + "    seq: " + str3);
                try {
                    JSONObject jSONObject = obj == null ? new JSONObject() : new JSONObject(obj.toString());
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CU");
                    jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                    jSONObject.put("token", jSONObject.optString("accessCode"));
                    tokenListener.onGetTokenComplete(jSONObject);
                } catch (Exception e) {
                    Log.e(OneKeyLoginSdkCall.a, e);
                    tokenListener.onGetTokenComplete(new JSONObject());
                }
            }
        });
    }
}
