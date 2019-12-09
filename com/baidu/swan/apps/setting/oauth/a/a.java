package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends g<C0216a> {
    protected final boolean bof;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str) {
        this.mActivity = activity;
        this.mScope = str;
        this.bof = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean IN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Rs().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Rs().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String BR = com.baidu.swan.apps.u.a.Jv().BR();
            if (!TextUtils.isEmpty(BR)) {
                jSONObject2.put("host_api_key", BR);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.bof));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aI("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.Jv().e(this.mActivity, gVar.Su());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: X */
    public C0216a Y(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject aE = com.baidu.swan.apps.setting.oauth.c.aE(jSONObject);
        int optInt = aE.optInt("errno", 11001);
        if (optInt != 0) {
            if (11001 == optInt) {
                com.baidu.swan.apps.setting.oauth.c.aD(aE);
                com.baidu.swan.apps.setting.oauth.c.aH("Accredit", aE.toString());
            }
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aE.optString("errms"));
        }
        JSONObject jSONObject3 = aE.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0216a(this.bof, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void IO() {
        super.IO();
        com.baidu.swan.apps.network.c.b.a.Na();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0216a {
        public final boolean bog;
        public final JSONObject boh;
        public final String code;

        private C0216a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.bog = z;
            this.boh = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.bog), this.code);
        }
    }
}
