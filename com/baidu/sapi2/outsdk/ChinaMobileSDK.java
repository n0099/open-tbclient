package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChinaMobileSDK {
    public static final String a = ChinaMobileSDK.class.getSimpleName();
    public static final String b = "103000";
    public static final String c = "1";
    public static final String d = "2";
    public static final String e = "3";
    public static final String f = "0";
    public static String g;

    public void preGetPhoneInfo(Context context, String str, String str2, int i) {
        AuthnHelper authnHelper;
        JSONObject networkType;
        try {
            if (a(context, str, str2, i) && (networkType = (authnHelper = AuthnHelper.getInstance(context)).getNetworkType(context)) != null) {
                Log.e(a, "chinaMobileSDKGetPhoneInfo", "networktype", networkType);
                String optString = networkType.optString("operatortype");
                String optString2 = networkType.optString("networktype");
                if (TextUtils.isEmpty(optString) || optString.equals("2") || optString.equals("3") || TextUtils.isEmpty(optString2) || optString2.equals("0")) {
                    Log.e(a, "preGetPhoneInfo", "unsupport");
                } else {
                    authnHelper.getPhoneInfo(str, str2, new TokenListener() { // from class: com.baidu.sapi2.outsdk.ChinaMobileSDK.1
                        public void onGetTokenComplete(JSONObject jSONObject) {
                            Log.e(ChinaMobileSDK.a, "getPhoneInfo", jSONObject);
                            SapiStatUtil sapiStatUtil = new SapiStatUtil();
                            sapiStatUtil.getClass();
                            SapiStatUtil.a aVar = new SapiStatUtil.a();
                            if (jSONObject != null) {
                                String optString3 = jSONObject.optString("resultCode");
                                if (optString3.equals(ChinaMobileSDK.b) && jSONObject.optString("desc").equals("true") && !TextUtils.isEmpty(jSONObject.optString("securityphone"))) {
                                    ChinaMobileSDK.g = jSONObject.optString("securityphone");
                                }
                                aVar.d = optString3;
                                if (!TextUtils.isEmpty(ChinaMobileSDK.g)) {
                                    aVar.c = 1;
                                }
                            }
                            SapiStatUtil.statInit(aVar);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            Log.e(th);
            SapiStatUtil sapiStatUtil = new SapiStatUtil();
            sapiStatUtil.getClass();
            SapiStatUtil.a aVar = new SapiStatUtil.a();
            aVar.d = "-202";
            SapiStatUtil.statInit(aVar);
        }
    }

    public void loginOauth(Context context, String str, String str2, TokenListener tokenListener) {
        try {
            AuthnHelper.getInstance(context).loginAuth(str, str2, tokenListener);
        } catch (Throwable th) {
            Log.e(th);
            tokenListener.onGetTokenComplete(new JSONObject());
        }
    }

    public static void statRecordAuth(Context context, String str) {
        try {
            AuthnHelper.getInstance(context).recordAuthEvent(str);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static boolean checkSupOauth(Context context) {
        return SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", context) && !TextUtils.isEmpty(g);
    }

    private boolean a(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(a, "chinaMobileAppID or chinaMobileAppKey is empty ");
            return false;
        } else if (!SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
            Log.d(a, "no permission ");
            return false;
        } else if (SapiAccountManager.getInstance().isLogin()) {
            Log.d(a, "is already login");
            return false;
        } else {
            int chinaMobileOauthGray = SapiContext.getInstance(context).getChinaMobileOauthGray();
            if (chinaMobileOauthGray == -1) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                chinaMobileOauthGray = random.nextInt(1000000);
                SapiContext.getInstance(context).setChinaMobileOauthGray(chinaMobileOauthGray);
            }
            if (chinaMobileOauthGray > i) {
                Log.d(a, " meet gray false");
                return false;
            }
            return true;
        }
    }
}
