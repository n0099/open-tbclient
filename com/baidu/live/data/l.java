package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l extends BaseData {
    private int avp;
    public String avq;
    public String avr;
    public String avs;
    public List<h> avt;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.avp = jSONObject.optInt("contact_authority_bar_switch");
            this.avq = jSONObject.optString("qq", "");
            this.avr = jSONObject.optString("live_assistent_url", "");
            this.avs = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.avt = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    h s = h.s(optJSONArray.optJSONObject(i));
                    if (s != null) {
                        this.avt.add(s);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.avt == null) {
                    this.avt = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    h hVar = new h();
                    hVar.er(this.avr);
                    hVar.setText(optJSONArray2.optString(i));
                    this.avt.add(hVar);
                    i++;
                }
            }
        }
    }
}
