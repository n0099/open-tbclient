package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public String o;

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
            com.baidu.android.pushservice.g.a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e.getMessage(), context.getApplicationContext());
            return null;
        }
    }

    public String a(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(jSONArray);
                    if (!TextUtils.isEmpty(this.n)) {
                        JSONObject jSONObject2 = new JSONObject(new String(this.n));
                        String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                        if (jSONObject2.isNull("hwsigninfo")) {
                            return string;
                        }
                        this.o = jSONObject2.getString("hwsigninfo");
                        return string;
                    }
                }
            }
            return null;
        } catch (JSONException e) {
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
                if (!jSONObject.isNull(PushConstants.PUSH_TYPE)) {
                    this.i = jSONObject.getInt(PushConstants.PUSH_TYPE);
                }
                if (!jSONObject.isNull("gid")) {
                    this.j = jSONObject.getString("gid");
                }
                if (!jSONObject.isNull("msgBody")) {
                    this.n = jSONObject.getString("msgBody");
                }
            } catch (Exception e) {
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
            a(jSONArray);
            if (TextUtils.isEmpty(this.n)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(this.n);
            if (jSONObject2.isNull("custom_content")) {
                return null;
            }
            return jSONObject2.getString("custom_content");
        } catch (JSONException e) {
            return null;
        }
    }

    public String c(Context context, String str) {
        JSONArray jSONArray;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras") && (jSONArray = jSONObject.getJSONArray("extras")) != null) {
                    a(jSONArray);
                    if (!TextUtils.isEmpty(this.n)) {
                        JSONObject jSONObject2 = new JSONObject(this.n);
                        String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                        if (jSONObject2.isNull("mzsigninfo")) {
                            return string;
                        }
                        this.o = jSONObject2.getString("mzsigninfo");
                        return string;
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }
}
