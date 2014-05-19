package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static final String a = "is_social_account";
    public static final String b = "social_type";
    public static final String c = "social_portrait";

    public static void a(SapiAccount sapiAccount, SocialType socialType, String str) {
        a(sapiAccount, a, (Object) true);
        a(sapiAccount, b, Integer.valueOf(socialType.getType()));
        a(sapiAccount, c, str);
    }

    public static void a(SapiAccount sapiAccount, String str, Object obj) {
        if (sapiAccount != null && !TextUtils.isEmpty(str) && obj != null) {
            if (TextUtils.isEmpty(sapiAccount.extra)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, obj);
                    sapiAccount.extra = jSONObject.toString();
                    return;
                } catch (JSONException e) {
                    L.e(e);
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(sapiAccount.extra);
                jSONObject2.put(str, obj);
                sapiAccount.extra = jSONObject2.toString();
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }
}
