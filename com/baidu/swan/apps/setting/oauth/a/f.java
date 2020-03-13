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
    private boolean bTU;
    private final String bUj;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.bUj = str2;
        this.bTU = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aeg() {
        bl("data", aeA().toString());
        return true;
    }

    public JSONObject aeA() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e adb = adb();
            jSONObject.put("ma_id", adb.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", adb.getAppKey());
            if (adb.GE() != null && adb.GE().VJ() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, adb.GE().VJ());
            }
            if (this.bTU) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String Ic = com.baidu.swan.apps.w.a.Ui().Ic();
            if (!TextUtils.isEmpty(Ic)) {
                jSONObject.put("host_api_key", Ic);
            }
            if (!TextUtils.isEmpty(this.bUj)) {
                jSONObject.put("provider_appkey", this.bUj);
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
        return com.baidu.swan.apps.w.a.Ui().i(this.mActivity, gVar.aeB());
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
