package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.view.web.a {
    private SchemeCallback aGM;

    public b(SchemeCallback schemeCallback) {
        this.aGM = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "cuidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void ej(String str) {
        JSONObject jSONObject;
        JSONException e;
        if (this.aGM != null) {
            String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
            if (TextUtils.isEmpty(cuid)) {
                this.aGM.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(cuid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cuid", cuid);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        this.aGM.doJsCallback(1, "", jSONObject, str);
                    }
                } catch (JSONException e3) {
                    jSONObject = null;
                    e = e3;
                }
            }
            this.aGM.doJsCallback(1, "", jSONObject, str);
        }
    }
}
