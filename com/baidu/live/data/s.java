package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class s extends BaseData {
    private int aFQ;
    public String aFR;
    public String aFS;
    public String aFT;
    public List<l> aFU;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aFQ = jSONObject.optInt("contact_authority_bar_switch");
            this.aFR = jSONObject.optString("qq", "");
            this.aFS = jSONObject.optString("live_assistent_url", "");
            this.aFT = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aFU = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    l y = l.y(optJSONArray.optJSONObject(i));
                    if (y != null) {
                        this.aFU.add(y);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aFU == null) {
                    this.aFU = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    l lVar = new l();
                    lVar.fa(this.aFS);
                    lVar.setText(optJSONArray2.optString(i));
                    this.aFU.add(lVar);
                    i++;
                }
            }
        }
    }
}
