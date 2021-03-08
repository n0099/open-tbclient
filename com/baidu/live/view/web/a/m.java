package com.baidu.live.view.web.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m extends com.baidu.live.view.web.a {
    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "openNewH5Bridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                    cVar.url = jSONObject.optString("url", "");
                    cVar.isFullScreen = jSONObject.optBoolean("isFullScreen", false);
                    if (!cVar.isFullScreen) {
                        cVar.bXS = (float) jSONObject.optDouble("aspectRatio", 0.7d);
                    }
                    if (!cVar.url.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
