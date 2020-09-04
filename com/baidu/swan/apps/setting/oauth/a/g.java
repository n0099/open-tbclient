package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cVX;
    private final String cWm;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cWm = str2;
        this.cVX = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aBw() {
        cj("data", aBU().toString());
        return true;
    }

    public JSONObject aBU() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aBW = aBW();
            jSONObject.put("ma_id", aBW.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aBW.getAppKey());
            if (aBW.XZ() != null && aBW.XZ().aqN() != null) {
                jSONObject.put("scene", aBW.XZ().aqN());
            }
            if (this.cVX) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String aal = com.baidu.swan.apps.t.a.aoV().aal();
            if (!TextUtils.isEmpty(aal)) {
                jSONObject.put("host_api_key", aal);
            }
            if (!TextUtils.isEmpty(this.cWm)) {
                jSONObject.put("provider_appkey", this.cWm);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.h
    protected HttpRequest a(h hVar) {
        return com.baidu.swan.apps.t.a.aoV().k(this.mActivity, hVar.aBX());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bI */
    public JSONObject bB(JSONObject jSONObject) throws JSONException {
        JSONObject bD = com.baidu.swan.apps.setting.oauth.c.bD(jSONObject);
        int optInt = bD.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bD.optString("errms"));
        }
        return bD;
    }
}
