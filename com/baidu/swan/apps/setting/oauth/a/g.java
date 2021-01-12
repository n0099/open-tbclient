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
    private boolean dHL;
    private final String dIa;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dIa = str2;
        this.dHL = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKg() {
        cz("data", aKE().toString());
        return true;
    }

    public JSONObject aKE() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aKG = aKG();
            jSONObject.put("ma_id", aKG.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aKG.getAppKey());
            if (aKG.afB() != null && aKG.afB().ayC() != null) {
                jSONObject.put("scene", aKG.afB().ayC());
            }
            if (this.dHL) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String ahR = com.baidu.swan.apps.t.a.awK().ahR();
            if (!TextUtils.isEmpty(ahR)) {
                jSONObject.put("host_api_key", ahR);
            }
            if (!TextUtils.isEmpty(this.dIa)) {
                jSONObject.put("provider_appkey", this.dIa);
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
        return com.baidu.swan.apps.t.a.awK().k(this.mActivity, hVar.aKH());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cf */
    public JSONObject bY(JSONObject jSONObject) throws JSONException {
        JSONObject ca = com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
        int optInt = ca.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ca.optString("errms"));
        }
        return ca;
    }
}
