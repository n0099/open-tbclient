package com.baidu.sapi2.a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.cmic.sso.sdk.auth.AuthnHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b {
    static final String a = "CM";
    static final String b = "CT";
    private static final String c = "login";
    private static final String d = "init";
    private static final String e = b.class.getSimpleName();
    private static final int f = 16000;
    private static final int g = 8000;
    private static final int h = 8000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, String str2, boolean z) {
        if (z) {
            JSONObject networkType = AuthnHelper.getInstance(context, "rsa2048").getNetworkType(context);
            if (networkType != null) {
                String optString = networkType.optString("operatortype");
                String optString2 = networkType.optString("networktype");
                if (!"3".equals(optString) || "0".equals(optString2)) {
                    return;
                }
            } else {
                return;
            }
        }
        CtAuth.getInstance().init(context, str, str2, (TraceLogger) null);
        a(context, (a) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiConfiguration sapiConfiguration, final c.a aVar) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > SapiContext.getInstance(sapiConfiguration.context).getLong(SapiContext.CHINA_TELECOM_EXPIRED_TIME, currentTimeMillis)) {
            a(sapiConfiguration.context, new a() { // from class: com.baidu.sapi2.a.b.1
                @Override // com.baidu.sapi2.a.b.a
                public void a() {
                    b.this.a(sapiConfiguration, c.c, aVar);
                }

                @Override // com.baidu.sapi2.a.b.a
                public void b() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    aVar.onGetTokenComplete(jSONObject);
                }
            });
        } else {
            a(sapiConfiguration, c.c, aVar);
        }
    }

    private void a(final Context context, final a aVar) {
        CtSetting ctSetting = new CtSetting(8000, 8000, (int) f);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        CtAuth.getInstance().requestPreLogin(ctSetting, new ResultListener() { // from class: com.baidu.sapi2.a.b.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [150=4] */
            public void onResult(String str) {
                String str2;
                int i;
                Log.i(b.e, "requestPreLogin result = " + str);
                String str3 = aVar == null ? b.d : b.c;
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("result");
                        String str4 = optInt + "";
                        if (optInt != 0) {
                            if (aVar != null) {
                                aVar.b();
                            }
                            SapiStatUtil.statChinaMobile(0, str4, b.b, str3);
                            return;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (!b.b.equals(optJSONObject.optString("operatorType"))) {
                            if (aVar != null) {
                                aVar.b();
                            }
                            SapiStatUtil.statChinaMobile(0, str4, b.b, str3);
                            return;
                        }
                        c.c = optJSONObject.optString("accessCode");
                        c.b = optJSONObject.optString("number");
                        int i2 = TextUtils.isEmpty(c.c) ? 0 : 1;
                        try {
                            SapiContext.getInstance(context).put(SapiContext.CHINA_TELECOM_EXPIRED_TIME, (optJSONObject.optLong("expiredTime") + currentTimeMillis) - 16);
                            if (aVar != null) {
                                aVar.a();
                            }
                            SapiStatUtil.statChinaMobile(i2, str4, b.b, str3);
                        } catch (Throwable th) {
                            th = th;
                            str2 = str4;
                            i = i2;
                            SapiStatUtil.statChinaMobile(i, str2, b.b, str3);
                            throw th;
                        }
                    } catch (JSONException e2) {
                        Log.e(e2);
                        SapiStatUtil.statChinaMobile(0, "-202", b.b, str3);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = LivenessStat.TYPE_STRING_DEFAULT;
                    i = 0;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiConfiguration sapiConfiguration, String str, final c.a aVar) {
        CtAuth.getInstance().requestLogin(str, new CtSetting(8000, 8000, (int) f), new ResultListener() { // from class: com.baidu.sapi2.a.b.3
            public void onResult(String str2) {
                Log.i(b.e, "requestLogin result = " + str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    jSONObject.put("appid", sapiConfiguration.chinaTelecomAppKey);
                    JSONObject jSONObject2 = new JSONObject(str2);
                    if (jSONObject2.optInt("result") == 0) {
                        jSONObject.put("token", jSONObject2.optJSONObject("responseData").optString("accessToken"));
                    }
                    SapiContext.getInstance(sapiConfiguration.context).put(SapiContext.CHINA_TELECOM_EXPIRED_TIME, 0L);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                aVar.onGetTokenComplete(jSONObject);
            }
        });
    }
}
