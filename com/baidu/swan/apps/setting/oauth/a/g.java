package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dJP;
    private final String dKe;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dKe = str2;
        this.dJP = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aKz() {
        ct("data", aKX().toString());
        return true;
    }

    public JSONObject aKX() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aKZ = aKZ();
            jSONObject.put("ma_id", aKZ.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aKZ.getAppKey());
            if (aKZ.afZ() != null && aKZ.afZ().aza() != null) {
                jSONObject.put("scene", aKZ.afZ().aza());
            }
            if (this.dJP) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String aip = com.baidu.swan.apps.t.a.axi().aip();
            if (!TextUtils.isEmpty(aip)) {
                jSONObject.put("host_api_key", aip);
            }
            if (!TextUtils.isEmpty(this.dKe)) {
                jSONObject.put("provider_appkey", this.dKe);
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
        return com.baidu.swan.apps.t.a.axi().k(this.mActivity, hVar.aLa());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: cc */
    public JSONObject bV(JSONObject jSONObject) throws JSONException {
        JSONObject bX = com.baidu.swan.apps.setting.oauth.c.bX(jSONObject);
        int optInt = bX.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bX.optString("errms"));
        }
        return bX;
    }
}
