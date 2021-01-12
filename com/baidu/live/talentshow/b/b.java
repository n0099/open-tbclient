package com.baidu.live.talentshow.b;

import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends BaseData {
    public boolean aFV = true;
    public String bBe = "";
    public List<d> bBf;
    public List<d> bBg;
    public int pn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.aFV = jSONObject.optInt("has_more") == 1;
            this.bBf = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(optJSONObject2);
                        this.bBf.add(dVar);
                    } else {
                        return;
                    }
                }
            }
            this.bBg = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray(VerticalTranslateLayout.TOP);
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length() && (optJSONObject = optJSONArray2.optJSONObject(i2)) != null; i2++) {
                    d dVar2 = new d();
                    dVar2.parserJson(optJSONObject);
                    this.bBg.add(dVar2);
                }
            }
        }
    }
}
