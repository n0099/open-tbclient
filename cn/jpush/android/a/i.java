package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i {
    public static cn.jpush.android.data.a a(Context context, String str, String str2, String str3, String str4) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (TextUtils.isEmpty(str)) {
            e.a("NO MSGID", 996, null, context);
            return null;
        }
        JSONObject a = a(context, "NO_MSGID", str);
        if (a != null) {
            String optString = a.optString("msg_id", "");
            if (TextUtils.isEmpty(optString)) {
                optString = a.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = a.optString("_jmsgid_", "");
            }
            if (!TextUtils.isEmpty(optString)) {
                str4 = optString;
            }
            boolean z = a.optInt("n_only", 0) == 1;
            int optInt = z ? a.optInt("n_builder_id", 0) : 0;
            cn.jpush.android.data.a aVar = new cn.jpush.android.data.a();
            aVar.c = str4;
            aVar.a = a;
            aVar.b = a.optInt("show_type", 3);
            aVar.f = z;
            aVar.g = optInt;
            aVar.h = a.optInt("notificaion_type", 0);
            aVar.j = a.optString("message", "");
            aVar.k = a.optString("content_type", "");
            aVar.m = a.optString("title", "");
            aVar.n = a.optString("extras", "");
            aVar.o = str2;
            aVar.p = str3;
            aVar.d = a.optString("override_msg_id", "");
            return aVar;
        }
        return null;
    }

    private static JSONObject a(Context context, String str, String str2) {
        try {
            return new JSONObject(str2);
        } catch (JSONException e) {
            e.a(str, 996, null, context);
            return null;
        }
    }

    public static JSONObject a(Context context, String str, JSONObject jSONObject, String str2) {
        if (jSONObject == null) {
            e.a(str, 996, null, context);
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            return null;
        } else {
            try {
                if (jSONObject.isNull(str2)) {
                    return null;
                }
                return jSONObject.getJSONObject(str2);
            } catch (JSONException e) {
                e.a(str, 996, null, context);
                return null;
            }
        }
    }

    public static void a(Context context, cn.jpush.android.data.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        int i = aVar.b;
        JSONObject jSONObject = aVar.a;
        String str = aVar.c;
        if (i != 3 && i != 4) {
            e.a(str, 996, null, context);
            return;
        }
        JSONObject a = a(context, str, jSONObject, "m_content");
        if (a == null) {
            return;
        }
        int optInt = a.optInt("ad_t", 0);
        if (optInt != 0) {
            e.a(str, 996, null, context);
            return;
        }
        cn.jpush.android.data.g gVar = new cn.jpush.android.data.g();
        gVar.c = str;
        gVar.b = i;
        gVar.q = optInt;
        gVar.i = aVar.i;
        gVar.f = aVar.f;
        gVar.g = aVar.g;
        gVar.o = aVar.o;
        gVar.d = aVar.d;
        gVar.h = aVar.h;
        if (gVar.a(context, a)) {
            gVar.a(context);
        }
    }

    public static void a(Context context, String str) {
        JSONObject a;
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (TextUtils.isEmpty(str) || (a = a(context, "NO MSGID", str)) == null) {
            return;
        }
        String optString = a.optString("msg_id", "");
        if (TextUtils.isEmpty(optString)) {
            optString = a.optString("ad_id", "");
        }
        int optInt = a.optInt("show_type", -1);
        if (optInt == 2) {
            String trim = a.optString("m_content", "").trim();
            if (!a(trim)) {
                e.a(optString, 996, null, context);
                return;
            } else if (context == null) {
                throw new IllegalArgumentException("NULL context");
            } else {
                cn.jiguang.api.e.a(new j(trim, context, optString), new int[0]);
                return;
            }
        }
        JSONObject a2 = optInt == 1 ? a(context, optString, a, "m_content") : null;
        if (a2 != null) {
            int optInt2 = a2.optInt("ad_t", -1);
            switch (optInt2) {
                case 0:
                    cn.jpush.android.data.g gVar = new cn.jpush.android.data.g();
                    boolean a3 = gVar.a(context, a2);
                    gVar.c = optString;
                    gVar.b = optInt;
                    gVar.q = optInt2;
                    if (a3) {
                        gVar.a(context);
                        return;
                    }
                    return;
                default:
                    e.a(optString, 996, null, context);
                    return;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().matches("^[http|https]+://.*");
    }
}
