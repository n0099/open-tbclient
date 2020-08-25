package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n extends BaseData {
    public boolean aDP = true;
    public List<m> aDQ;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aDP = jSONObject.optInt("has_more") == 1;
            this.aDQ = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i)) != null; i++) {
                    m mVar = new m();
                    mVar.parserJson(optJSONObject);
                    this.aDQ.add(mVar);
                }
            }
        }
    }
}
