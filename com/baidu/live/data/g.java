package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends BaseData {
    public List<f> OY;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.OY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i)) != null; i++) {
                    f fVar = new f();
                    fVar.parserJson(optJSONObject);
                    this.OY.add(fVar);
                }
            }
        }
    }
}
