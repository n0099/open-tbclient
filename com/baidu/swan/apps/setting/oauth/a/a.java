package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends h<C0493a> {
    protected final boolean dDP;
    private final String dDQ;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.dDP = z;
        this.dDQ = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", aMj().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", aMj().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject2.put("host_api_key", akA);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.dDP));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.dDQ)) {
                jSONObject.put("provider_appkey", this.dDQ);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cB("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.azm().f(this.mActivity, hVar.aMk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bV */
    public C0493a bQ(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject bS = com.baidu.swan.apps.setting.oauth.c.bS(jSONObject);
        int optInt = bS.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bS.optString("errms"));
        }
        JSONObject jSONObject3 = bS.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0493a(this.dDP, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.h
    public void aMe() {
        super.aMe();
        com.baidu.swan.apps.network.c.b.a.aFu();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0493a {
        public final String code;
        public final JSONObject dDR;
        public final boolean dDg;

        private C0493a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.dDg = z;
            this.dDR = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.dDg), this.code);
        }
    }
}
