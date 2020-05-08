package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends g<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cta;
    private final String ctp;
    protected final Activity mActivity;
    private final String mScope;

    public f(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.ctp = str2;
        this.cta = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        bu("data", amH().toString());
        return true;
    }

    public JSONObject amH() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e ali = ali();
            jSONObject.put("ma_id", ali.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", ali.getAppKey());
            if (ali.Ov() != null && ali.Ov().adA() != null) {
                jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, ali.Ov().adA());
            }
            if (this.cta) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String PQ = com.baidu.swan.apps.w.a.abZ().PQ();
            if (!TextUtils.isEmpty(PQ)) {
                jSONObject.put("host_api_key", PQ);
            }
            if (!TextUtils.isEmpty(this.ctp)) {
                jSONObject.put("provider_appkey", this.ctp);
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
        return com.baidu.swan.apps.w.a.abZ().i(this.mActivity, gVar.amI());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bf */
    public JSONObject aY(JSONObject jSONObject) throws JSONException {
        JSONObject ba = com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
        int optInt = ba.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ba.optString("errms"));
        }
        return ba;
    }
}
