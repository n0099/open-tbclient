package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l extends BaseData {
    private int aDM;
    public String aDN;
    public String aDO;
    public String aDP;
    public List<h> aDQ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aDM = jSONObject.optInt("contact_authority_bar_switch");
            this.aDN = jSONObject.optString("qq", "");
            this.aDO = jSONObject.optString("live_assistent_url", "");
            this.aDP = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aDQ = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    h v = h.v(optJSONArray.optJSONObject(i));
                    if (v != null) {
                        this.aDQ.add(v);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aDQ == null) {
                    this.aDQ = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    h hVar = new h();
                    hVar.fO(this.aDO);
                    hVar.setText(optJSONArray2.optString(i));
                    this.aDQ.add(hVar);
                    i++;
                }
            }
        }
    }
}
