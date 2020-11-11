package com.baidu.live.talentshow.b;

import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseData {
    public boolean aJj = true;
    public String bxE = "";
    public List<d> bxF;
    public List<d> bxG;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aJj = jSONObject.optInt("has_more") == 1;
            this.bxF = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(optJSONObject2);
                        this.bxF.add(dVar);
                    } else {
                        return;
                    }
                }
            }
            this.bxG = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray(VerticalTranslateLayout.TOP);
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    d dVar2 = new d();
                    dVar2.parserJson(optJSONObject);
                    this.bxG.add(dVar2);
                }
            }
        }
    }
}
