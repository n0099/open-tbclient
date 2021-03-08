package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class w extends BaseData {
    private int aJM;
    public String aJN;
    public String aJO;
    public String aJP;
    public List<p> aJQ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aJM = jSONObject.optInt("contact_authority_bar_switch");
            this.aJN = jSONObject.optString("qq", "");
            this.aJO = jSONObject.optString("live_assistent_url", "");
            this.aJP = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aJQ = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    p A = p.A(optJSONArray.optJSONObject(i));
                    if (A != null) {
                        this.aJQ.add(A);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aJQ == null) {
                    this.aJQ = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    p pVar = new p();
                    pVar.fB(this.aJO);
                    pVar.setText(optJSONArray2.optString(i));
                    this.aJQ.add(pVar);
                    i++;
                }
            }
        }
    }
}
