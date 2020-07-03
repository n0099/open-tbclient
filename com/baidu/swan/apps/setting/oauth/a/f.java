package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cJG;
    private final String cJV;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.cJV = str2;
        this.cJG = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean arw() {
        bR("data", arQ().toString());
        return true;
    }

    public JSONObject arQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aqk = aqk();
            jSONObject.put("ma_id", aqk.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aqk.getAppKey());
            if (aqk.RP() != null && aqk.RP().ahQ() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, aqk.RP().ahQ());
            }
            if (this.cJG) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String TM = com.baidu.swan.apps.u.a.agj().TM();
            if (!TextUtils.isEmpty(TM)) {
                jSONObject.put("host_api_key", TM);
            }
            if (!TextUtils.isEmpty(this.cJV)) {
                jSONObject.put("provider_appkey", this.cJV);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected HttpRequest a(g gVar) {
        return com.baidu.swan.apps.u.a.agj().i(this.mActivity, gVar.arS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bv */
    public JSONObject bo(JSONObject jSONObject) throws JSONException {
        JSONObject bq = com.baidu.swan.apps.setting.oauth.c.bq(jSONObject);
        int optInt = bq.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bq.optString("errms"));
        }
        return bq;
    }
}
