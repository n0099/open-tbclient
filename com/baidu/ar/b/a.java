package com.baidu.ar.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.task.HttpResponseListener;
import com.baidu.ar.util.ARSDKInfo;
import com.baidu.ar.util.MD5Utils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static a a;
    private b b;
    private Context c;
    private String d;
    private String e;
    private Object f;
    private String g;

    private a(Context context) {
        this.c = context;
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    private String a() {
        String a2 = com.baidu.ar.b.a.a.a(b(), "jady@bd");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", a2);
        jSONObject.put("sig", MD5Utils.getMD5String(a2));
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }

    private String b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(GroupActivityActivityConfig.ACTIVITY_ID, this.e);
        jSONObject.put(HttpConstants.TIMESTAMP, System.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("extra_data", this.f);
        jSONObject2.put(ISapiAccount.SAPI_ACCOUNT_PHONE, c());
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", Settings.System.getString(this.c.getContentResolver(), "android_id"));
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("sdk", ARSDKInfo.getVersionCode() + "");
        jSONObject.put("release", Build.VERSION.RELEASE);
        return jSONObject;
    }

    public void a(int i, HttpResponseListener httpResponseListener) {
        try {
            this.g = a();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.g == null) {
            Log.e("AR bbbb Marketing", " uplaod Error");
            return;
        }
        this.b = new b(this.d, this.g, i, httpResponseListener);
        this.b.a();
        this.b.b();
    }

    public void a(String str, String str2, Object obj) {
        this.d = str;
        this.e = str2;
        this.f = obj;
    }
}
