package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends h<C0472a> {
    protected final boolean dLm;
    private final String dLn;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dLm = z;
        this.dLn = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aLc().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aLc().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String ais = com.baidu.swan.apps.t.a.axl().ais();
            if (!TextUtils.isEmpty(ais)) {
                jSONObject2.put("host_api_key", ais);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dLm));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dLn)) {
                jSONObject.put("provider_appkey", this.dLn);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ct("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.axl().f(this.mActivity, hVar.aLd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cc */
    public C0472a bX(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject bZ = com.baidu.swan.apps.setting.oauth.c.bZ(jSONObject);
        int optInt = bZ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bZ.optString("errms"));
        }
        String str = "";
        JSONObject jSONObject3 = bZ.getJSONObject("data");
        if (jSONObject3 != null) {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        } else {
            jSONObject2 = null;
        }
        return new C0472a(this.dLm, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aKX() {
        super.aKX();
        com.baidu.swan.apps.network.c.b.a.aDu();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0472a {
        public final String code;
        public final boolean dKD;
        public final JSONObject dLo;

        private C0472a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dKD = z;
            this.dLo = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dKD), this.code);
        }
    }
}
