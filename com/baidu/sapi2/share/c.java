package com.baidu.sapi2.share;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class c {
    static final String a = "isValid";
    static final String b = "username";
    static final String c = "displayname";
    static final String d = "email";
    static final String e = "phoneNumber";
    static final String f = "bduss";
    static final String g = "ptoken";
    static final String h = "json";
    static final String i = "socialAccounts";

    c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount a(Context context) {
        g gVar = new g(context);
        if ("1".equals(gVar.a(a))) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.displayname = gVar.a("displayname");
            sapiAccount.username = gVar.a(b);
            sapiAccount.email = gVar.a(d);
            sapiAccount.phone = gVar.a(e);
            sapiAccount.bduss = gVar.a("bduss");
            sapiAccount.ptoken = gVar.a("ptoken");
            sapiAccount.extra = gVar.a(h);
            a(sapiAccount, gVar.a(i));
            if (!TextUtils.isEmpty(sapiAccount.extra)) {
                try {
                    JSONObject jSONObject = new JSONObject(sapiAccount.extra);
                    String optString = jSONObject.optString("uid");
                    if (!TextUtils.isEmpty(optString)) {
                        sapiAccount.uid = optString;
                    }
                    String optString2 = jSONObject.optString("bduss");
                    if (!TextUtils.isEmpty(optString2)) {
                        sapiAccount.bduss = optString2;
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("ptoken"))) {
                        sapiAccount.ptoken = jSONObject.optString("ptoken");
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString(SapiAccountManager.SESSION_STOKEN))) {
                        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    }
                    String optString3 = jSONObject.optString("uname");
                    if (!TextUtils.isEmpty(optString3)) {
                        sapiAccount.username = optString3;
                    }
                    String optString4 = jSONObject.optString("displayname");
                    if (!TextUtils.isEmpty(optString4)) {
                        sapiAccount.displayname = optString4;
                    }
                } catch (JSONException e2) {
                    L.e(e2);
                }
            }
            if (!SapiUtils.isValidAccount(sapiAccount)) {
                sapiAccount = null;
            }
            return sapiAccount;
        }
        return null;
    }

    static void a(SapiAccount sapiAccount, String str) {
        if (sapiAccount != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 0) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        com.baidu.sapi2.utils.c.a(sapiAccount, SocialType.getSocialType(jSONObject.optInt("type")), jSONObject.optString("headURL"));
                    } catch (JSONException e2) {
                        L.e(e2);
                    }
                }
            } catch (JSONException e3) {
            }
        }
    }
}
