package com.baidu.live.view.web.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends com.baidu.live.view.web.a {
    private SchemeCallback bpB;

    public f(SchemeCallback schemeCallback) {
        this.bpB = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "payBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fW(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl PersonalCenterBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
            boolean z = jSONObject.optInt("is_translucent") == 1;
            String optString2 = jSONObject.optString("from");
            if (this.bpB != null) {
                ExtraParamsManager.addEnterBuyTBeanCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.f.1
                    @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                    public void onCallback(JSONObject jSONObject2) {
                        try {
                            int optInt = jSONObject2.optInt("status", 0);
                            String optString3 = jSONObject2.optString("message");
                            String optString4 = jSONObject2.optString("productId");
                            String optString5 = jSONObject2.optString("total");
                            String optString6 = jSONObject2.optString("transitionId");
                            JSONObject jSONObject3 = new JSONObject();
                            if (!TextUtils.isEmpty(optString4)) {
                                jSONObject3.put("productId", optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                jSONObject3.put("total", optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                jSONObject3.put("transitionId", optString6);
                            }
                            f.this.bpB.doJsCallback(optInt, optString3, jSONObject3, optString);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst(), 0L, true);
            if (!TextUtils.isEmpty(optString)) {
                buyTBeanActivityConfig.setCallback(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                buyTBeanActivityConfig.setFrom(optString2);
            }
            buyTBeanActivityConfig.setIsTranslucent(z);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
