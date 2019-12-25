package com.baidu.live.view.web.a;

import android.app.Activity;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends com.baidu.live.view.web.a {
    private Activity context;

    public g(Activity activity) {
        this.context = activity;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "personalCenterBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void dT(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl PersonalCenterBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uid");
            if (jSONObject.optBoolean("isCard")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), optString)));
            } else {
                ExtraJumpManager.getInstance().buildJumpExtra().jumpToPersonalCenter(this.context, optString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
