package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class t extends BaseData {
    public boolean aKj = true;
    public List<s> aKk;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aKj = jSONObject.optInt("has_more") == 1;
            this.aKk = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i)) != null; i++) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aKk.add(sVar);
                }
            }
        }
    }
}
