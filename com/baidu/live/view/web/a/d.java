package com.baidu.live.view.web.a;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.live.view.web.a {
    private SchemeCallback atB;

    public d(SchemeCallback schemeCallback) {
        this.atB = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "loginBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void cZ(final String str) {
        if (this.atB != null) {
            ExtraParamsManager.addLoginCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.d.1
                @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                public void onCallback(JSONObject jSONObject) {
                    d.this.atB.doJsCallback(jSONObject.optBoolean("status") ? 1 : 0, "", null, str);
                }
            });
        }
        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
    }
}
