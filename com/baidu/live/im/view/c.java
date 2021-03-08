package com.baidu.live.im.view;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    boolean bsO = false;
    String date = "";
    int bsP = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasInput", this.bsO);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bsP);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
