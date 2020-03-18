package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bUf;
    private final String bUu;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bUu = str2;
        this.bUf = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aej() {
        bk("data", aeD().toString());
        return true;
    }

    public JSONObject aeD() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e ade = ade();
            jSONObject.put("ma_id", ade.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", ade.getAppKey());
            if (ade.GJ() != null && ade.GJ().VM() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, ade.GJ().VM());
            }
            if (this.bUf) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String If = com.baidu.swan.apps.w.a.Ul().If();
            if (!TextUtils.isEmpty(If)) {
                jSONObject.put("host_api_key", If);
            }
            if (!TextUtils.isEmpty(this.bUu)) {
                jSONObject.put("provider_appkey", this.bUu);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.Ul().i(this.mActivity, gVar.aeE());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: aU */
    public JSONObject aN(JSONObject jSONObject) throws JSONException {
        JSONObject aP = com.baidu.swan.apps.setting.oauth.c.aP(jSONObject);
        int optInt = aP.optInt("errno", 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + aP.optString("errms"));
        }
        return aP;
    }
}
