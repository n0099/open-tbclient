package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends g<C0171a> {
    protected final boolean aRw;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str) {
        this.mActivity = activity;
        this.mScope = str;
        this.aRw = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean Cd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Jl().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", Jl().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String vC = com.baidu.swan.apps.u.a.CI().vC();
            if (!TextUtils.isEmpty(vC)) {
                jSONObject2.put("host_api_key", vC);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.aRw));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ay("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.u.a.CI().e(this.mActivity, gVar.Kj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: B */
    public C0171a C(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject ae = com.baidu.swan.apps.setting.oauth.c.ae(jSONObject);
        int optInt = ae.optInt("errno", SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ae.optString("errms"));
        }
        JSONObject jSONObject3 = ae.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0171a(this.aRw, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void Ce() {
        super.Ce();
        com.baidu.swan.apps.network.c.b.a.Fk();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0171a {
        public final boolean aRx;
        public final JSONObject aRy;
        public final String code;

        private C0171a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.aRx = z;
            this.aRy = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.aRx), this.code);
        }
    }
}
