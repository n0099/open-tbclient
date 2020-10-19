package com.baidu.live.view.web.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.schemeability.ISchemeAbility;
import com.baidu.live.tbadk.schemeability.SchemeAbilityManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i extends com.baidu.live.view.web.a {
    private Activity context;
    private boolean isHost;

    public i(Activity activity) {
        this.context = activity;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "personalCenterBridge";
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.view.web.a
    public void iq(String str) {
        ISchemeAbility buildSchemeAbility;
        Log.d("JsInterface", "@@ JsInterface-impl PersonalCenterBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uid");
            boolean optBoolean = jSONObject.optBoolean("isCard");
            String optString2 = jSONObject.optString("bd_scheme");
            if (optBoolean) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), optString)));
            } else if (!this.isHost) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(optString2) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(optString2);
                    }
                } else {
                    ExtraJumpManager.getInstance().buildJumpExtra().jumpToPersonalCenter(this.context, optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
