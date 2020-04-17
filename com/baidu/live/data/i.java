package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.u.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends BaseData {
    private int aqk;
    public String aql;
    public String aqm;
    public String aqn;
    public String[] aqo;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqk = jSONObject.optInt("contact_authority_bar_switch");
            this.aql = jSONObject.optString("qq", "");
            this.aqm = jSONObject.optString("live_assistent_url", "");
            this.aqn = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray != null) {
                this.aqo = new String[optJSONArray.length()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        this.aqo[i2] = (String) optJSONArray.opt(i2);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
