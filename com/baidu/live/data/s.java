package com.baidu.live.data;

import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s extends BaseData {
    private int aKD;
    public String aKE;
    public String aKF;
    public String aKG;
    public List<l> aKH;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aKD = jSONObject.optInt("contact_authority_bar_switch");
            this.aKE = jSONObject.optString("qq", "");
            this.aKF = jSONObject.optString("live_assistent_url", "");
            this.aKG = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.h.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aKH = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    l y = l.y(optJSONArray.optJSONObject(i));
                    if (y != null) {
                        this.aKH.add(y);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aKH == null) {
                    this.aKH = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    l lVar = new l();
                    lVar.gl(this.aKF);
                    lVar.setText(optJSONArray2.optString(i));
                    this.aKH.add(lVar);
                    i++;
                }
            }
        }
    }
}
