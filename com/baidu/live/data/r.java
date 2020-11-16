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
    private int aHt;
    public String aHu;
    public String aHv;
    public String aHw;
    public List<k> aHx;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aHt = jSONObject.optInt("contact_authority_bar_switch");
            this.aHu = jSONObject.optString("qq", "");
            this.aHv = jSONObject.optString("live_assistent_url", "");
            this.aHw = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aHx = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    k s = k.s(optJSONArray.optJSONObject(i));
                    if (s != null) {
                        this.aHx.add(s);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aHx == null) {
                    this.aHx = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    k kVar = new k();
                    kVar.gg(this.aHv);
                    kVar.setText(optJSONArray2.optString(i));
                    this.aHx.add(kVar);
                    i++;
                }
            }
        }
    }
}
