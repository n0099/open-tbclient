package com.baidu.live.view.web.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o extends com.baidu.live.view.web.a {
    private SchemeCallback bRj;

    public o(SchemeCallback schemeCallback) {
        this.bRj = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "zidBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(String str) {
        JSONObject jSONObject;
        JSONException e;
        if (this.bRj != null) {
            String baiduzid = ExtraParamsManager.getBaiduzid();
            if (TextUtils.isEmpty(baiduzid)) {
                this.bRj.doJsCallback(0, "", null, str);
                return;
            }
            if (TextUtils.isEmpty(baiduzid)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e2) {
                    jSONObject = null;
                    e = e2;
                }
                try {
                    jSONObject.put("zid", baiduzid);
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.bRj.doJsCallback(1, "", jSONObject, str);
                }
            }
            this.bRj.doJsCallback(1, "", jSONObject, str);
        }
    }
}
