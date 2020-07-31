package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.sdk.base.api.CallBack;
import com.sdk.base.api.ToolUtils;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    private static final int a = 15;
    private static final String b = "baidu_passport_cu_onekey_login";
    private static String c = "";

    private void b(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        Log.i(c.a, "in getAsynToken");
        ToolUtils.clearCache(sapiConfiguration.context);
        UiOauthManager.getInstance(sapiConfiguration.context).login(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap$1
            public void onFailed(int i, int i2, String str, String str2) {
                String str3;
                aVar.onGetTokenComplete(new JSONObject());
                Log.e(c.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str);
                str3 = b.c;
                SapiStatUtil.statPreGetPhoneInfo(0, i2 + "", "CU", c.k, str3);
            }

            public void onSuccess(int i, String str, int i2, Object obj, String str2) {
                String str3;
                String str4;
                String str5;
                Log.i(c.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str + "    response: " + obj + "    seq: " + str2);
                String str6 = i2 + "";
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
                        int i3 = !TextUtils.isEmpty(jSONObject2.optString("accessCode")) ? 1 : 0;
                        str5 = b.c;
                        SapiStatUtil.statPreGetPhoneInfo(i3, str6, "CU", c.k, str5);
                    } catch (Exception e) {
                        Log.e(e);
                        str4 = b.c;
                        SapiStatUtil.statPreGetPhoneInfo(0, str6, "CU", c.k, str4);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                } catch (Throwable th) {
                    str3 = b.c;
                    SapiStatUtil.statPreGetPhoneInfo(0, str6, "CU", c.k, str3);
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(c.a, "in china unicom login pre get phone info");
        a(sapiConfiguration, str2);
        a(sapiConfiguration.context, str, str2, oneKeyLoginCallback);
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
    public void a(SapiConfiguration sapiConfiguration, c.a aVar) {
        Log.i(c.a, "in getToken");
        if ((System.currentTimeMillis() / 1000) - SapiContext.getInstance().getLong("china_telecom_expired_time", 0L) < 3300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                jSONObject.put("token", c.s);
                jSONObject.put("code", 0);
                jSONObject.put("CUVersion", "2");
            } catch (JSONException e) {
                Log.e(e);
            }
            aVar.onGetTokenComplete(jSONObject);
            SapiContext.getInstance().put("china_telecom_expired_time", 0L);
            return;
        }
        b(sapiConfiguration, aVar);
    }

    private void a(Context context, final String str, final String str2, final OneKeyLoginCallback oneKeyLoginCallback) {
        ToolUtils.clearCache(context);
        UiOauthManager.getInstance(context).login(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap$2
            public void onFailed(int i, int i2, String str3, String str4) {
                Log.e(c.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str3);
                SapiStatUtil.statPreGetPhoneInfo(0, i2 + "", "CU", str, str2);
                new c().b(oneKeyLoginCallback, -101, null);
            }

            public void onSuccess(int i, String str3, int i2, Object obj, String str4) {
                int i3;
                Exception e;
                int i4;
                String str5;
                ChinaUnicomSdkWrap$2 chinaUnicomSdkWrap$2;
                int i5 = 0;
                Log.i(c.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str3 + "    response: " + obj + "    seq: " + str4);
                String str6 = i2 + "";
                try {
                    JSONObject jSONObject = new JSONObject(obj.toString());
                    if (jSONObject.optInt("code") == 0) {
                        c.s = jSONObject.optString("accessCode");
                        c.r = jSONObject.optString("fakeMobile");
                    }
                    if (!TextUtils.isEmpty(c.r)) {
                        try {
                            if (oneKeyLoginCallback != null) {
                                SapiAccountManager.getInstance().getAccountService().checkOneKeyLoginIsAvailable(oneKeyLoginCallback, c.r);
                                i3 = 1;
                            } else {
                                i3 = 1;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i3 = 1;
                            Log.e(e);
                            new c().b(oneKeyLoginCallback, -101, null);
                            i4 = i3;
                            str5 = str6;
                            chinaUnicomSdkWrap$2 = this;
                            SapiStatUtil.statPreGetPhoneInfo(i4, str5, "CU", str, str2);
                        } catch (Throwable th) {
                            th = th;
                            i5 = 1;
                            SapiStatUtil.statPreGetPhoneInfo(i5, str6, "CU", str, str2);
                            throw th;
                        }
                    } else {
                        new c().b(oneKeyLoginCallback, -101, null);
                        i3 = 0;
                    }
                    try {
                        try {
                            SapiContext.getInstance().put("china_telecom_expired_time", System.currentTimeMillis() / 1000);
                            i4 = i3;
                            str5 = str6;
                            chinaUnicomSdkWrap$2 = this;
                        } catch (Exception e3) {
                            e = e3;
                            Log.e(e);
                            new c().b(oneKeyLoginCallback, -101, null);
                            i4 = i3;
                            str5 = str6;
                            chinaUnicomSdkWrap$2 = this;
                            SapiStatUtil.statPreGetPhoneInfo(i4, str5, "CU", str, str2);
                        }
                    } catch (Throwable th2) {
                        i5 = i3;
                        th = th2;
                        SapiStatUtil.statPreGetPhoneInfo(i5, str6, "CU", str, str2);
                        throw th;
                    }
                } catch (Exception e4) {
                    i3 = 0;
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                }
                SapiStatUtil.statPreGetPhoneInfo(i4, str5, "CU", str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final c.a aVar) {
        a(sapiConfiguration, str);
        OauthManager.getInstance(sapiConfiguration.context).getAuthoriseCode(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap$3
            public void onFailed(int i, int i2, String str2, String str3) {
                Log.e(c.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CU");
                } catch (JSONException e) {
                }
                aVar.onGetTokenComplete(jSONObject);
            }

            public void onSuccess(int i, String str2, int i2, Object obj, String str3) {
                Log.i(c.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str2 + "    response: " + obj + "    seq: " + str3);
                try {
                    JSONObject jSONObject = obj == null ? new JSONObject() : new JSONObject(obj.toString());
                    jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                    jSONObject.put("operator", "CU");
                    jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                    jSONObject.put("token", jSONObject.optString("accessCode"));
                    aVar.onGetTokenComplete(jSONObject);
                } catch (Exception e) {
                    Log.e(c.a, e);
                    aVar.onGetTokenComplete(new JSONObject());
                }
            }
        });
    }
}
