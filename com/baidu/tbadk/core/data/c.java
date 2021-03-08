package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String appName;
    public boolean eMq;
    public String eMr;
    public String eMs;
    public float eMt = -1.0f;
    @Nullable
    public b eMu;
    @Nullable
    public a eMv;
    public String version;

    /* loaded from: classes.dex */
    public static class b {
        public String desc;
        public String url;

        @Nullable
        public static b dp(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.desc = jSONObject.optString("desc", "隐私");
            bVar.url = jSONObject.optString("url");
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String desc;
        public String url;

        @Nullable
        /* renamed from: do  reason: not valid java name */
        public static a m33do(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.desc = jSONObject.optString("desc", "权限");
            aVar.url = jSONObject.optString("url");
            return aVar;
        }
    }

    @Nullable
    public static c dn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.eMq = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        cVar.eMr = jSONObject.optString("app_icon");
        cVar.appName = jSONObject.optString("app_name");
        cVar.eMs = jSONObject.optString("developer_name");
        cVar.version = jSONObject.optString("version");
        cVar.eMu = b.dp(jSONObject.optJSONObject("privacy"));
        cVar.eMv = a.m33do(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.eMt = parseFloat;
            } else {
                cVar.eMt = -1.0f;
            }
            return cVar;
        } catch (NumberFormatException e) {
            cVar.eMt = -1.0f;
            return cVar;
        }
    }

    public static boolean a(c cVar) {
        if (cVar != null && cVar.eMq) {
            return (TextUtils.isEmpty(cVar.version) || TextUtils.isEmpty(cVar.eMs) || cVar.eMu == null || TextUtils.isEmpty(cVar.eMu.url) || cVar.eMv == null || TextUtils.isEmpty(cVar.eMv.url)) ? false : true;
        }
        return true;
    }

    public static boolean b(c cVar) {
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.version) && TextUtils.isEmpty(cVar.eMs) && (cVar.eMu == null || TextUtils.isEmpty(cVar.eMu.desc)) && (cVar.eMv == null || TextUtils.isEmpty(cVar.eMv.desc))) ? false : true;
    }
}
