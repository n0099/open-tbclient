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
    private int aEI;
    public String aEJ;
    public String aEK;
    public String aEL;
    public List<j> aEM;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            this.aEI = jSONObject.optInt("contact_authority_bar_switch");
            this.aEJ = jSONObject.optString("qq", "");
            this.aEK = jSONObject.optString("live_assistent_url", "");
            this.aEL = jSONObject.optString("live_assistent_msg", BdBaseApplication.getInst().getResources().getString(a.i.ala_live_assistant_msg));
            JSONArray optJSONArray = jSONObject.optJSONArray("rolling_msg_conf");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aEM = new ArrayList();
                int length = optJSONArray.length();
                while (i < length) {
                    j v = j.v(optJSONArray.optJSONObject(i));
                    if (v != null) {
                        this.aEM.add(v);
                    }
                    i++;
                }
                return;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rolling_msg");
            if (optJSONArray2 != null) {
                if (this.aEM == null) {
                    this.aEM = new ArrayList();
                }
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    j jVar = new j();
                    jVar.fT(this.aEK);
                    jVar.setText(optJSONArray2.optString(i));
                    this.aEM.add(jVar);
                    i++;
                }
            }
        }
    }
}
