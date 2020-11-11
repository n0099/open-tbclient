package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "giftBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iO(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final ah ahVar = new ah();
            ahVar.aKr = jSONObject.optInt("tab", -1);
            ahVar.aKs = jSONObject.optInt("category_id", -1);
            ahVar.aKt = jSONObject.optInt(LogConfig.LOG_GIFT_ID, -1);
            if (jSONObject.optInt("close", 0) == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.view.web.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.a(ahVar);
                    }
                }, 250L);
            } else {
                a(ahVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ah ahVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }
}
