package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f3545a;

    /* renamed from: b  reason: collision with root package name */
    public String f3546b;

    /* renamed from: c  reason: collision with root package name */
    public String f3547c;

    /* renamed from: d  reason: collision with root package name */
    public String f3548d;

    /* renamed from: e  reason: collision with root package name */
    public String f3549e;

    /* renamed from: f  reason: collision with root package name */
    public String f3550f;

    /* renamed from: g  reason: collision with root package name */
    public String f3551g;

    /* renamed from: h  reason: collision with root package name */
    public String f3552h;

    /* renamed from: i  reason: collision with root package name */
    public String f3553i;
    public String j;
    public int k;
    public String l;
    public String m;

    public PublicMsg a(Context context) {
        String str;
        PublicMsg publicMsg = new PublicMsg();
        try {
            publicMsg.mMsgId = this.j;
            publicMsg.mAppId = this.f3553i;
            if (TextUtils.isEmpty(this.f3551g) && TextUtils.isEmpty(this.f3552h)) {
                publicMsg.mTitle = this.f3549e;
                publicMsg.mDescription = this.f3550f;
                publicMsg.mUrl = this.f3545a;
                str = this.f3547c;
            } else {
                publicMsg.mTitle = this.f3551g;
                publicMsg.mDescription = this.f3552h;
                publicMsg.mUrl = this.f3546b;
                str = this.f3548d;
            }
            publicMsg.mPkgContent = str;
            return publicMsg;
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e2.getMessage(), context.getApplicationContext());
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
    }

    public String a(Context context, String str) {
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
            JSONObject jSONObject2 = new JSONObject(new String(this.l));
            String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
            if (!jSONObject2.isNull("hwprisigninfo")) {
                this.m = jSONObject2.getString("hwprisigninfo");
            }
            return string;
        } catch (JSONException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
    }

    public void a(Context context, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (!jSONObject.isNull("Appid")) {
                    this.f3553i = jSONObject.getString("Appid");
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
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
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
        } catch (JSONException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
    }

    public String c(Context context, String str) {
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
            String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
            if (!jSONObject2.isNull("mzpri_signinfo")) {
                this.m = jSONObject2.getString("mzpri_signinfo");
            }
            return string;
        } catch (JSONException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
    }
}
