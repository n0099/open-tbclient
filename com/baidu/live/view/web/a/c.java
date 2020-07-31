package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "giftBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fW(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final w wVar = new w();
            wVar.azn = jSONObject.optInt("tab", -1);
            wVar.azo = jSONObject.optInt("category_id", -1);
            wVar.azp = jSONObject.optInt(LogConfig.LOG_GIFT_ID, -1);
            if (jSONObject.optInt("close", 0) == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.view.web.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(wVar);
                    }
                }, 250L);
            } else {
                a(wVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }
}
