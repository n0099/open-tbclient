package com.baidu.swan.apps.setting.oauth.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends h<JSONObject> {
    protected String mAppKey;
    protected final Context mContext;

    public c(Context context, String str) {
        this.mAppKey = str;
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aLJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", this.mAppKey);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String akA = com.baidu.swan.apps.t.a.azm().akA();
            if (!TextUtils.isEmpty(akA)) {
                jSONObject.put("host_api_key", akA);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cB("data", jSONObject.toString());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bX */
    public JSONObject bQ(JSONObject jSONObject) throws JSONException {
        return com.baidu.swan.apps.setting.oauth.c.bS(jSONObject);
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.azm().h(this.mContext, hVar.aMk());
    }
}
