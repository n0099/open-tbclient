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
    private final String dLF;
    private boolean dLq;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dLF = str2;
        this.dLq = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKC() {
        ct("data", aLa().toString());
        return true;
    }

    public JSONObject aLa() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aLc = aLc();
            jSONObject.put("ma_id", aLc.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aLc.getAppKey());
            if (aLc.agc() != null && aLc.agc().azd() != null) {
                jSONObject.put("scene", aLc.agc().azd());
            }
            if (this.dLq) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String ais = com.baidu.swan.apps.t.a.axl().ais();
            if (!TextUtils.isEmpty(ais)) {
                jSONObject.put("host_api_key", ais);
            }
            if (!TextUtils.isEmpty(this.dLF)) {
                jSONObject.put("provider_appkey", this.dLF);
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
        return com.baidu.swan.apps.t.a.axl().k(this.mActivity, hVar.aLd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: ce */
    public JSONObject bX(JSONObject jSONObject) throws JSONException {
        JSONObject bZ = com.baidu.swan.apps.setting.oauth.c.bZ(jSONObject);
        int optInt = bZ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bZ.optString("errms"));
        }
        return bZ;
    }
}
