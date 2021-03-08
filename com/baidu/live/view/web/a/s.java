package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class s extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "ruleBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913259, jSONObject));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
