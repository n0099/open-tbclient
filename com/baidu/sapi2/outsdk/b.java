package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.sdk.base.api.CallBack;
import com.sdk.base.api.ToolUtils;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    private static final int a = 15;
    private static final String b = "login";
    private static final String c = "init";
    private static final String d = "baidu_passport_cu_onekey_login";

    private void b(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        Log.i(c.a, "in getAsynToken");
        ToolUtils.clearCache(sapiConfiguration.context);
        UiOauthManager.getInstance(sapiConfiguration.context).login(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap$1
            public void onFailed(int i, int i2, String str, String str2) {
                aVar.onGetTokenComplete(new JSONObject());
                Log.e(c.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str);
                SapiStatUtil.statChinaMobile(0, i2 + "", "CU", "login");
            }

            public void onSuccess(int i, String str, int i2, Object obj, String str2) {
                Log.i(c.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str + "    response: " + obj + "    seq: " + str2);
                String str3 = i2 + "";
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                        JSONObject jSONObject2 = new JSONObject(obj.toString());
                        int optInt = jSONObject2.optInt("code");
                        jSONObject.put("code", optInt);
                        if (optInt == 0) {
                            jSONObject.put("token", jSONObject2.optString("accessCode"));
                        }
                        SapiStatUtil.statChinaMobile(!TextUtils.isEmpty(jSONObject2.optString("accessCode")) ? 1 : 0, str3, "CU", "login");
                    } catch (JSONException e) {
                        Log.e(e);
                        SapiStatUtil.statChinaMobile(0, str3, "CU", "login");
                    }
                    aVar.onGetTokenComplete(jSONObject);
                } catch (Throwable th) {
                    SapiStatUtil.statChinaMobile(0, str3, "CU", "login");
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration) {
        Log.i(c.a, "in china unicom login pre get phone info");
        SDKManager.init(sapiConfiguration.context, sapiConfiguration.chinaUnicomAppKey, sapiConfiguration.chinaUnicomAppPublicKey);
        SDKManager.setUserAgent(d);
        a(sapiConfiguration.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration, c.a aVar) {
        Log.i(c.a, "in getToken");
        if ((System.currentTimeMillis() / 1000) - SapiContext.getInstance(sapiConfiguration.context).getLong("china_telecom_expired_time", 0L) < 3300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                jSONObject.put("token", c.m);
                jSONObject.put("code", 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            aVar.onGetTokenComplete(jSONObject);
            SapiContext.getInstance(sapiConfiguration.context).put("china_telecom_expired_time", 0L);
            return;
        }
        b(sapiConfiguration, aVar);
    }

    private void a(final Context context) {
        ToolUtils.clearCache(context);
        UiOauthManager.getInstance(context).login(15, new CallBack<Object>() { // from class: com.baidu.sapi2.outsdk.ChinaUnicomSdkWrap$2
            public void onFailed(int i, int i2, String str, String str2) {
                Log.e(c.a, "onFailure  code:   " + i + "   status: " + i2 + "  msg：" + str);
                SapiStatUtil.statChinaMobile(0, i2 + "", "CU", "init");
            }

            public void onSuccess(int i, String str, int i2, Object obj, String str2) {
                int i3 = 0;
                Log.i(c.a, "onSuccess: code:" + i + "   status:" + i2 + "   msg:" + str + "    response: " + obj + "    seq: " + str2);
                String str3 = i2 + "";
                try {
                    JSONObject jSONObject = new JSONObject(obj.toString());
                    if (jSONObject.optInt("code") == 0) {
                        c.m = jSONObject.optString("accessCode");
                        c.l = jSONObject.optString("fakeMobile");
                    }
                    i3 = !TextUtils.isEmpty(c.l) ? 1 : 0;
                    SapiContext.getInstance(context).put("china_telecom_expired_time", System.currentTimeMillis() / 1000);
                } catch (JSONException e) {
                    Log.e(e);
                } finally {
                    SapiStatUtil.statChinaMobile(i3, str3, "CU", "init");
                }
            }
        });
    }
}
