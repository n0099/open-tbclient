package com.baidu.live.view.web.a;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k extends com.baidu.live.view.web.a {
    private SchemeCallback schemeCallback;

    public k(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "loginBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(final String str) {
        if (this.schemeCallback != null) {
            ExtraParamsManager.addLoginCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.k.1
                @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                public void onCallback(JSONObject jSONObject) {
                    k.this.schemeCallback.doJsCallback(jSONObject.optBoolean("status") ? 1 : 0, "", null, str);
                }
            });
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
    }
}
