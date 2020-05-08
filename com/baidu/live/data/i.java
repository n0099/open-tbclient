package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.u.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends BaseData {
    private int aqq;
    public String aqr;
    public String aqs;
    public String aqt;
    public String[] aqu;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqq = jSONObject.optInt("contact_authority_bar_switch");
            this.aqr = jSONObject.optString("qq", "");
            this.aqs = jSONObject.optString("live_assistent_url", "");
            this.aqt = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray != null) {
                this.aqu = new String[optJSONArray.length()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.aqu[i2] = (String) optJSONArray.opt(i2);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
