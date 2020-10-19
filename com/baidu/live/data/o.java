package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o extends BaseData {
    private int aHM;
    public String aHN;
    public String aHO;
    public String aHP;
    public List<j> aHQ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aHM = jSONObject.optInt("contact_authority_bar_switch");
            this.aHN = jSONObject.optString("qq", "");
            this.aHO = jSONObject.optString("live_assistent_url", "");
            this.aHP = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aHQ = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    j v = j.v(optJSONArray.optJSONObject(i));
                    if (v != null) {
                        this.aHQ.add(v);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aHQ == null) {
                    this.aHQ = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    j jVar = new j();
                    jVar.gh(this.aHO);
                    jVar.setText(optJSONArray2.optString(i));
                    this.aHQ.add(jVar);
                    i++;
                }
            }
        }
    }
}
