package com.baidu.android.pushservice.message;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static PublicMsg a(byte[] bArr) {
        PublicMsg publicMsg = new PublicMsg();
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            publicMsg.a = jSONObject.getString("title");
            publicMsg.b = jSONObject.getString("description");
            publicMsg.c = jSONObject.getString("url");
            if (!jSONObject.isNull("net_support")) {
                publicMsg.g = jSONObject.getInt("net_support");
            }
            if (!jSONObject.isNull("app_situation")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("app_situation");
                publicMsg.i = jSONObject2.getInt("as_is_support") == 1;
                publicMsg.h = jSONObject2.getString("as_pkg_name");
            }
            if (!jSONObject.isNull("pkg_name")) {
                publicMsg.d = jSONObject.getString("pkg_name");
            }
            if (!jSONObject.isNull("pkg_vercode")) {
                publicMsg.e = jSONObject.getInt("pkg_vercode");
            }
            if (jSONObject.isNull("pkg_content")) {
                return publicMsg;
            }
            publicMsg.f = jSONObject.getString("pkg_content");
            return publicMsg;
        } catch (JSONException e) {
            return null;
        }
    }
}
