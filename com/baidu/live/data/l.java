package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l extends BaseData {
    private int ayI;
    public String ayJ;
    public String ayK;
    public String ayL;
    public List<h> ayM;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.ayI = jSONObject.optInt("contact_authority_bar_switch");
            this.ayJ = jSONObject.optString("qq", "");
            this.ayK = jSONObject.optString("live_assistent_url", "");
            this.ayL = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ayM = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    h u = h.u(optJSONArray.optJSONObject(i));
                    if (u != null) {
                        this.ayM.add(u);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.ayM == null) {
                    this.ayM = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    h hVar = new h();
                    hVar.ev(this.ayK);
                    hVar.setText(optJSONArray2.optString(i));
                    this.ayM.add(hVar);
                    i++;
                }
            }
        }
    }
}
