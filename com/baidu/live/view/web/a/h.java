package com.baidu.live.view.web.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.data.PayChannelData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h extends com.baidu.live.view.web.a {
    private SchemeCallback bFj;
    private IChannelPayController bFr;
    private BaseActivity baseActivity;

    public h(SchemeCallback schemeCallback) {
        this.bFj = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "payChannelBridge";
    }

    public void b(BaseActivity baseActivity) {
        Log.d(IChannelPayController.TAG, "PayChannelBridgeJsInterface setBaseActivity:" + baseActivity);
        this.baseActivity = baseActivity;
    }

    @Override // com.baidu.live.view.web.a
    public void iq(String str) {
        CustomResponsedMessage runTask;
        Log.d(IChannelPayController.TAG, "@@ PersonalCenterBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
            if (jSONObject.optInt("is_translucent") == 1) {
            }
            PayChannelData payChannelData = new PayChannelData(this.baseActivity, jSONObject.optString("channel"), jSONObject.optString("icon_id"), jSONObject.optString("price"), jSONObject.optString("from"), jSONObject.optString("live_id"), 14);
            payChannelData.setShowToast(false);
            if (this.bFr == null && (runTask = MessageManager.getInstance().runTask(2913197, IChannelPayController.class, payChannelData)) != null && runTask.getData() != null) {
                this.bFr = (IChannelPayController) runTask.getData();
            }
            if (this.bFr != null) {
                this.bFr.pay(payChannelData);
            }
            if (this.bFj != null) {
                ExtraParamsManager.addEnterBuyTBeanCallback(new ResultCallback() { // from class: com.baidu.live.view.web.a.h.1
                    @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                    public void onCallback(JSONObject jSONObject2) {
                        try {
                            int optInt = jSONObject2.optInt("status", 0);
                            String optString2 = jSONObject2.optString("message");
                            String optString3 = jSONObject2.optString("productId");
                            String optString4 = jSONObject2.optString("total");
                            String optString5 = jSONObject2.optString("transitionId");
                            JSONObject jSONObject3 = new JSONObject();
                            if (!TextUtils.isEmpty(optString3)) {
                                jSONObject3.put("productId", optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                jSONObject3.put("total", optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                jSONObject3.put("transitionId", optString5);
                            }
                            h.this.bFj.doJsCallback(optInt, optString2, jSONObject3, optString);
                            Log.d(IChannelPayController.TAG, "@@ doJsCallback status = " + optInt + ", message:" + optString2 + ", data:" + jSONObject3.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
