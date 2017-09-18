package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.j.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;

    public PublicMsg a(Context context) {
        PublicMsg publicMsg = new PublicMsg();
        try {
            publicMsg.mMsgId = this.l;
            publicMsg.mAppId = this.k;
            if (TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.h)) {
                publicMsg.mTitle = this.e;
                publicMsg.mDescription = this.f;
                publicMsg.mUrl = this.a;
                publicMsg.mPkgContent = this.c;
            } else {
                publicMsg.mTitle = this.g;
                publicMsg.mDescription = this.h;
                publicMsg.mUrl = this.b;
                publicMsg.mPkgContent = this.d;
            }
            return publicMsg;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.b.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e.getMessage(), context.getApplicationContext());
            com.baidu.android.pushservice.g.a.a("ProxyPushMessage", e);
            return null;
        }
    }

    public String a(Context context, String str) {
        String str2;
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(jSONArray);
                    if (!TextUtils.isEmpty(this.n)) {
                        JSONObject jSONObject2 = new JSONObject(new String(this.n));
                        if (jSONObject2.isNull("custom_content")) {
                            str2 = null;
                        } else {
                            str2 = jSONObject2.getString("custom_content");
                            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "customcontent = " + str2);
                        }
                        if (jSONObject2.isNull("hwsigninfo")) {
                            m.a(context, "bdpush_hwsignresult", 0);
                            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", " passthrough message has not hwsigninfo!");
                            return null;
                        }
                        String string = jSONObject2.getString("hwsigninfo");
                        com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "hwsigninfo_passthrough = " + string);
                        if (!TextUtils.isEmpty(string)) {
                            String str3 = this.l + str2;
                            if (!PushManager.hwMessageVerify(context, string, str3)) {
                                m.a(context, "bdpush_hwsignresult", 0);
                                com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "hwsigninfo_passthrough check not pass   " + str3);
                                return null;
                            }
                            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "hwsigninfo_passthrough check pass " + str3);
                            m.a(context, "bdpush_hwsignresult", 1);
                        }
                        return str2;
                    }
                }
            }
            str2 = null;
            return str2;
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "not receive correct huawei passthrough message");
            m.a(context, "bdpush_hwsignresult", 0);
            return null;
        }
    }

    public void a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.isNull("Appid")) {
                    this.k = jSONObject.getString("Appid");
                }
                if (!jSONObject.isNull("Msgid")) {
                    this.l = jSONObject.getString("Msgid");
                }
                if (!jSONObject.isNull("Type")) {
                    this.m = jSONObject.getInt("Type");
                }
                if (!jSONObject.isNull("push_type")) {
                    this.i = jSONObject.getInt("push_type");
                }
                if (!jSONObject.isNull("gid")) {
                    this.j = jSONObject.getString("gid");
                }
                if (!jSONObject.isNull("msgBody")) {
                    this.n = jSONObject.getString("msgBody");
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("ProxyPushMessage", e);
                return;
            }
        }
    }

    public String b(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(jSONArray);
                    if (!TextUtils.isEmpty(this.n)) {
                        JSONObject jSONObject2 = new JSONObject(new String(this.n));
                        if (!jSONObject2.isNull("custom_content")) {
                            String string = jSONObject2.getString("custom_content");
                            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "customcontent = " + string);
                            return string;
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.a.c("ProxyPushMessage", "not receive correct xiaomi passthrough message");
            return null;
        }
    }
}
