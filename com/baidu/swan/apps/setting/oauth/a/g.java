package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends h<JSONObject> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean dsI;
    private final String dsX;
    protected final Activity mActivity;
    private final String mScope;

    public g(Activity activity, String str, String str2, boolean z) {
        this.mActivity = activity;
        this.mScope = str;
        this.dsX = str2;
        this.dsI = z;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean aGJ() {
        cv("data", aHh().toString());
        return true;
    }

    public JSONObject aHh() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.swan.apps.runtime.e aHj = aHj();
            jSONObject.put("ma_id", aHj.id);
            jSONObject.put("scope", this.mScope);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            jSONObject.put("app_key", aHj.getAppKey());
            if (aHj.ado() != null && aHj.ado().awd() != null) {
                jSONObject.put("scene", aHj.ado().awd());
            }
            if (this.dsI) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String afA = com.baidu.swan.apps.t.a.aum().afA();
            if (!TextUtils.isEmpty(afA)) {
                jSONObject.put("host_api_key", afA);
            }
            if (!TextUtils.isEmpty(this.dsX)) {
                jSONObject.put("provider_appkey", this.dsX);
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
        return com.baidu.swan.apps.t.a.aum().k(this.mActivity, hVar.aHk());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bV */
    public JSONObject bO(JSONObject jSONObject) throws JSONException {
        JSONObject bQ = com.baidu.swan.apps.setting.oauth.c.bQ(jSONObject);
        int optInt = bQ.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + bQ.optString("errms"));
        }
        return bQ;
    }
}
