package com.baidu.live.view.web.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.schemeability.ISchemeAbility;
import com.baidu.live.tbadk.schemeability.SchemeAbilityManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.view.web.a {
    private Activity context;
    private boolean isHost;

    public b(Activity activity) {
        this.context = activity;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "audioPersonalCenterBridge";
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.view.web.a
    public void is(String str) {
        ISchemeAbility buildSchemeAbility;
        Log.d("JsInterface", "@@ JsInterface-impl AudioPersonalCenterBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uid");
            boolean optBoolean = jSONObject.optBoolean("isCard");
            String optString2 = jSONObject.optString("bd_scheme");
            if (StringUtils.isNull(optString)) {
                optString = ExtraParamsManager.getDecryptUserId(jSONObject.optString("uk"));
            }
            if (optBoolean) {
                ab Yq = com.baidu.live.ao.a.Yj().Yq();
                if (Yq != null && Yq.aIz != null && Yq.mLiveInfo != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.context, optString, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Yq.mLiveInfo.group_id), Long.toString(Yq.mLiveInfo.live_id), false, null, null, null, "")));
                }
            } else if (!this.isHost) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(optString2) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(optString2);
                        return;
                    }
                    return;
                }
                ExtraJumpManager.getInstance().buildJumpExtra().jumpToPersonalCenter(this.context, optString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
