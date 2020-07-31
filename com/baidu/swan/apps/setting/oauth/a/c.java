package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends g<JSONObject> {
    protected final Activity mActivity;
    protected String mAppKey;

    public c(Activity activity, String str) {
        this.mAppKey = str;
        this.mActivity = activity;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean ato() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", this.mAppKey);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String Uj = com.baidu.swan.apps.t.a.ahv().Uj();
            if (!TextUtils.isEmpty(Uj)) {
                jSONObject.put("host_api_key", Uj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bS("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bA */
    public JSONObject bt(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bv(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.t.a.ahv().g(this.mActivity, gVar.atO());
    }
}
