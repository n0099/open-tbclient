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
    private int aKe;
    public String aKf;
    public String aKg;
    public String aKh;
    public List<k> aKi;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aKe = jSONObject.optInt("contact_authority_bar_switch");
            this.aKf = jSONObject.optString("qq", "");
            this.aKg = jSONObject.optString("live_assistent_url", "");
            this.aKh = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aKi = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    k s = k.s(optJSONArray.optJSONObject(i));
                    if (s != null) {
                        this.aKi.add(s);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aKi == null) {
                    this.aKi = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    k kVar = new k();
                    kVar.gC(this.aKg);
                    kVar.setText(optJSONArray2.optString(i));
                    this.aKi.add(kVar);
                    i++;
                }
            }
        }
    }
}
