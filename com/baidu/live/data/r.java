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
    private int aIn;
    public String aIo;
    public String aIp;
    public String aIq;
    public List<k> aIr;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aIn = jSONObject.optInt("contact_authority_bar_switch");
            this.aIo = jSONObject.optString("qq", "");
            this.aIp = jSONObject.optString("live_assistent_url", "");
            this.aIq = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aIr = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    k v = k.v(optJSONArray.optJSONObject(i));
                    if (v != null) {
                        this.aIr.add(v);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aIr == null) {
                    this.aIr = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    k kVar = new k();
                    kVar.gi(this.aIp);
                    kVar.setText(optJSONArray2.optString(i));
                    this.aIr.add(kVar);
                    i++;
                }
            }
        }
    }
}
