package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f1474a;

    /* renamed from: b  reason: collision with root package name */
    public String f1475b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;

    public PublicMsg a(Context context) {
        PublicMsg publicMsg = new PublicMsg();
        try {
            publicMsg.mMsgId = this.j;
            publicMsg.mAppId = this.i;
            if (TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.h)) {
                publicMsg.mTitle = this.e;
                publicMsg.mDescription = this.f;
                publicMsg.mUrl = this.f1474a;
                publicMsg.mPkgContent = this.c;
            } else {
                publicMsg.mTitle = this.g;
                publicMsg.mDescription = this.h;
                publicMsg.mUrl = this.f1475b;
                publicMsg.mPkgContent = this.d;
            }
            return publicMsg;
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e.getMessage(), context.getApplicationContext());
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return null;
        }
    }

    public String a(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(context, jSONArray);
                    if (!TextUtils.isEmpty(this.l)) {
                        JSONObject jSONObject2 = new JSONObject(new String(this.l));
                        String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                        if (jSONObject2.isNull("hwprisigninfo")) {
                            return string;
                        }
                        this.m = jSONObject2.getString("hwprisigninfo");
                        return string;
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return null;
        }
    }

    public void a(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.isNull("Appid")) {
                    this.i = jSONObject.getString("Appid");
                }
                if (!jSONObject.isNull("Msgid")) {
                    this.j = jSONObject.getString("Msgid");
                }
                if (!jSONObject.isNull("Type")) {
                    this.k = jSONObject.getInt("Type");
                }
                if (!jSONObject.isNull("msgBody")) {
                    this.l = jSONObject.getString("msgBody");
                }
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return;
            }
        }
    }

    public String b(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("extras") || (jSONArray = jSONObject.getJSONArray("extras")) == null) {
                return null;
            }
            a(context, jSONArray);
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(this.l);
            if (jSONObject2.isNull("custom_content")) {
                return null;
            }
            return jSONObject2.getString("custom_content");
        } catch (JSONException e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return null;
        }
    }

    public String c(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(context, jSONArray);
                    if (!TextUtils.isEmpty(this.l)) {
                        JSONObject jSONObject2 = new JSONObject(this.l);
                        String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                        if (jSONObject2.isNull("mzpri_signinfo")) {
                            return string;
                        }
                        this.m = jSONObject2.getString("mzpri_signinfo");
                        return string;
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return null;
        }
    }
}
