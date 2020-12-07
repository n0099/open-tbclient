package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cx {
    public String aUb;
    public String aUc;
    public int aUd;
    public String aUe;
    public int level_id = -1;
    public List<AlaLiveMarkData> live_mark_info_new;
    public String uk;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.uk = jSONObject.optString("uk");
            this.aUb = jSONObject.optString("head_img");
            this.aUc = jSONObject.optString("nick_name");
            this.aUd = jSONObject.optInt("noble_role_id");
            this.aUe = jSONObject.optString("noble_role_name");
            this.level_id = jSONObject.optInt("level_id");
            if (jSONObject.has("identity_icon")) {
                if (this.live_mark_info_new == null) {
                    this.live_mark_info_new = new ArrayList();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("identity_icon");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                        alaLiveMarkData.parserJson(optJSONObject);
                        this.live_mark_info_new.add(alaLiveMarkData);
                    }
                }
            }
        }
    }
}
