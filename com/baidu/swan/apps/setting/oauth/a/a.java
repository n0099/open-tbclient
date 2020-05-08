package com.baidu.swan.apps.setting.oauth.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends g<C0345a> {
    protected final boolean csW;
    private final String csX;
    protected final Activity mActivity;
    protected final String mScope;

    public a(Activity activity, boolean z, String str, String str2) {
        this.mActivity = activity;
        this.mScope = str;
        this.csW = z;
        this.csX = str2;
    }

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected boolean amn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", ali().id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", ali().getAppKey());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", com.baidu.swan.apps.setting.oauth.c.getKeyHash());
            String PQ = com.baidu.swan.apps.w.a.abZ().PQ();
            if (!TextUtils.isEmpty(PQ)) {
                jSONObject2.put("host_api_key", PQ);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.csW));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.mScope, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
            if (!TextUtils.isEmpty(this.csX)) {
                jSONObject.put("provider_appkey", this.csX);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bu("data", jSONObject.toString());
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.a.g
    protected Request a(g gVar) {
        return com.baidu.swan.apps.w.a.abZ().e(this.mActivity, gVar.amI());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.b
    /* renamed from: bd */
    public C0345a aY(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2;
        JSONObject ba = com.baidu.swan.apps.setting.oauth.c.ba(jSONObject);
        int optInt = ba.optInt(BaseJsonData.TAG_ERRNO, 10001);
        if (optInt != 0) {
            throw new JSONException("Illegal errno=" + optInt + " errms=" + ba.optString("errms"));
        }
        JSONObject jSONObject3 = ba.getJSONObject("data");
        if (jSONObject3 == null) {
            str = "";
            jSONObject2 = null;
        } else {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        }
        return new C0345a(this.csW, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.setting.oauth.a.g
    public void amF() {
        super.amF();
        com.baidu.swan.apps.network.c.b.a.aht();
    }

    /* renamed from: com.baidu.swan.apps.setting.oauth.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0345a {
        public final String code;
        public final JSONObject csY;
        public final boolean cst;

        private C0345a(boolean z, String str, JSONObject jSONObject) {
            this.code = str == null ? "" : str;
            this.cst = z;
            this.csY = jSONObject;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.cst), this.code);
        }
    }
}
