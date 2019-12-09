package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ChinaTelecomSdkWrap {
    private static final String a = "login";
    private static final String b = "init";
    private static final int c = 30000;
    private static final int d = 15000;
    private static final int e = 15000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface PreLoginCallback {
        void onError(int i);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration) {
        Log.i(c.a, "in china telecom login pre get phone info");
        CtAuth.getInstance().init(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, (TraceLogger) null);
        a(sapiConfiguration.context, (PreLoginCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > SapiContext.getInstance(sapiConfiguration.context).getLong("china_telecom_expired_time", currentTimeMillis)) {
            a(sapiConfiguration.context, new PreLoginCallback() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.1
                @Override // com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.PreLoginCallback
                public void onError(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                        jSONObject.put("code", i);
                        jSONObject.put("msg", "request pre login error");
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                }

                @Override // com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.PreLoginCallback
                public void onSuccess() {
                    ChinaTelecomSdkWrap.this.a(sapiConfiguration, c.k, aVar);
                }
            });
        } else {
            a(sapiConfiguration, c.k, aVar);
        }
    }

    private void a(final Context context, final PreLoginCallback preLoginCallback) {
        CtSetting ctSetting = new CtSetting((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, (int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, 30000);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        CtAuth.getInstance().requestPreLogin(ctSetting, new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.2
            public void onResult(String str) {
                int i = 0;
                Log.i(c.a, "requestPreLogin result = " + str);
                String str2 = LivenessStat.TYPE_STRING_DEFAULT;
                String str3 = preLoginCallback == null ? ChinaTelecomSdkWrap.b : ChinaTelecomSdkWrap.a;
                try {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("result");
                            str2 = optInt + "";
                            if (optInt != 0) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(optInt);
                                }
                                SapiStatUtil.statChinaMobile(0, str2, "CT", str3);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (!"CT".equals(optJSONObject.optString("operatorType"))) {
                                if (preLoginCallback != null) {
                                    preLoginCallback.onError(-202);
                                }
                                SapiStatUtil.statChinaMobile(0, str2, "CT", str3);
                                return;
                            }
                            c.k = optJSONObject.optString("accessCode");
                            c.j = optJSONObject.optString("number");
                            int i2 = !TextUtils.isEmpty(c.k) ? 1 : 0;
                            try {
                                SapiContext.getInstance(context).put("china_telecom_expired_time", (optJSONObject.optLong("expiredTime") + currentTimeMillis) - 30);
                                if (preLoginCallback != null) {
                                    preLoginCallback.onSuccess();
                                }
                                SapiStatUtil.statChinaMobile(i2, str2, "CT", str3);
                            } catch (Throwable th) {
                                th = th;
                                i = i2;
                                SapiStatUtil.statChinaMobile(i, str2, "CT", str3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (JSONException e2) {
                        Log.e(e2);
                        SapiStatUtil.statChinaMobile(0, "-202", "CT", str3);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final c.a aVar) {
        CtAuth.getInstance().requestLogin(str, new CtSetting((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, (int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, 30000), new ResultListener() { // from class: com.baidu.sapi2.outsdk.ChinaTelecomSdkWrap.3
            public void onResult(String str2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                    JSONObject jSONObject2 = new JSONObject(str2);
                    if (jSONObject2.optInt("result") == 0) {
                        jSONObject.put("token", jSONObject2.optJSONObject("responseData").optString("accessToken"));
                    }
                    jSONObject.put("code", jSONObject2.optInt("result"));
                    SapiContext.getInstance(sapiConfiguration.context).put("china_telecom_expired_time", 0L);
                    Object[] objArr = new Object[1];
                    objArr[0] = "in china telecom get token: " + jSONObject.toString();
                    Log.i(c.a, objArr);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                aVar.onGetTokenComplete(jSONObject);
            }
        });
    }
}
