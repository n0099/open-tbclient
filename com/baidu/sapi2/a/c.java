package com.baidu.sapi2.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    static String a;
    static String b;
    static String c;

    /* loaded from: classes.dex */
    public interface a {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    public void a(SapiConfiguration sapiConfiguration, int i, int i2) {
        boolean z = false;
        if (a(sapiConfiguration.context, sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, i)) {
            new com.baidu.sapi2.a.a().a(sapiConfiguration.context, sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey);
            z = true;
        }
        if (b(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, i2)) {
            new b().a(sapiConfiguration.context, sapiConfiguration.chinaTelecomAppKey, sapiConfiguration.chinaTelecomAppSecret, z);
        }
    }

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (b(context)) {
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put("phone", a);
                    jSONObject.put("operator", "CM");
                } else {
                    jSONObject.put("phone", b);
                    jSONObject.put("operator", "CT");
                }
            }
        } catch (JSONException e) {
            Log.e(e);
        }
        return jSONObject;
    }

    public void a(SapiConfiguration sapiConfiguration, a aVar) {
        if (!TextUtils.isEmpty(a)) {
            new com.baidu.sapi2.a.a().a(sapiConfiguration, aVar);
        } else if (!TextUtils.isEmpty(c)) {
            new b().a(sapiConfiguration, aVar);
        } else {
            aVar.onGetTokenComplete(new JSONObject());
        }
    }

    private boolean a(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || SapiAccountManager.getInstance().isLogin() || !SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
            return false;
        }
        int chinaMobileOauthGray = SapiContext.getInstance(context).getChinaMobileOauthGray();
        if (chinaMobileOauthGray == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            chinaMobileOauthGray = random.nextInt(1000000);
            SapiContext.getInstance(context).setChinaMobileOauthGray(chinaMobileOauthGray);
        }
        return chinaMobileOauthGray <= i;
    }

    private boolean b(Context context, String str, String str2, int i) {
        if (SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int chinaTelecomGray = SapiContext.getInstance(context).getChinaTelecomGray();
        if (chinaTelecomGray == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            chinaTelecomGray = random.nextInt(1000000);
            SapiContext.getInstance(context).setChinaTelecomGray(chinaTelecomGray);
        }
        return chinaTelecomGray <= i;
    }

    public boolean b(Context context) {
        if (TextUtils.isEmpty(b)) {
            return !TextUtils.isEmpty(a) && SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", context);
        }
        return true;
    }
}
