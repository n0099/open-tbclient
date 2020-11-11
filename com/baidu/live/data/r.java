package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r extends BaseData {
    private int aJe;
    public String aJf;
    public String aJg;
    public String aJh;
    public List<k> aJi;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aJe = jSONObject.optInt("contact_authority_bar_switch");
            this.aJf = jSONObject.optString("qq", "");
            this.aJg = jSONObject.optString("live_assistent_url", "");
            this.aJh = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aJi = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    k y = k.y(optJSONArray.optJSONObject(i));
                    if (y != null) {
                        this.aJi.add(y);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aJi == null) {
                    this.aJi = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    k kVar = new k();
                    kVar.gm(this.aJg);
                    kVar.setText(optJSONArray2.optString(i));
                    this.aJi.add(kVar);
                    i++;
                }
            }
        }
    }
}
