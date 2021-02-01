package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.gesture.GestureAR;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String appName;
    public boolean eKP;
    public String eKQ;
    public String eKR;
    public float eKS = -1.0f;
    @Nullable
    public b eKT;
    @Nullable
    public a eKU;
    public String version;

    /* loaded from: classes.dex */
    public static class b {
        public String desc;
        public String url;

        @Nullable
        public static b dn(JSONObject jSONObject) {
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
        public static a dm(JSONObject jSONObject) {
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
    public static c dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.eKP = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        cVar.eKQ = jSONObject.optString("app_icon");
        cVar.appName = jSONObject.optString("app_name");
        cVar.eKR = jSONObject.optString("developer_name");
        cVar.version = jSONObject.optString("version");
        cVar.eKT = b.dn(jSONObject.optJSONObject("privacy"));
        cVar.eKU = a.dm(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.eKS = parseFloat;
            } else {
                cVar.eKS = -1.0f;
            }
            return cVar;
        } catch (NumberFormatException e) {
            cVar.eKS = -1.0f;
            return cVar;
        }
    }

    public static boolean a(c cVar) {
        if (cVar != null && cVar.eKP) {
            return (TextUtils.isEmpty(cVar.version) || TextUtils.isEmpty(cVar.eKR) || cVar.eKT == null || TextUtils.isEmpty(cVar.eKT.url) || cVar.eKU == null || TextUtils.isEmpty(cVar.eKU.url)) ? false : true;
        }
        return true;
    }

    public static boolean b(c cVar) {
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.version) && TextUtils.isEmpty(cVar.eKR) && (cVar.eKT == null || TextUtils.isEmpty(cVar.eKT.desc)) && (cVar.eKU == null || TextUtils.isEmpty(cVar.eKU.desc))) ? false : true;
    }
}
