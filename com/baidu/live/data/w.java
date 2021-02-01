package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class w extends BaseData {
    private int aIm;
    public String aIn;
    public String aIo;
    public String aIp;
    public List<p> aIq;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aIm = jSONObject.optInt("contact_authority_bar_switch");
            this.aIn = jSONObject.optString("qq", "");
            this.aIo = jSONObject.optString("live_assistent_url", "");
            this.aIp = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aIq = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    p y = p.y(optJSONArray.optJSONObject(i));
                    if (y != null) {
                        this.aIq.add(y);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aIq == null) {
                    this.aIq = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    p pVar = new p();
                    pVar.fv(this.aIo);
                    pVar.setText(optJSONArray2.optString(i));
                    this.aIq.add(pVar);
                    i++;
                }
            }
        }
    }
}
