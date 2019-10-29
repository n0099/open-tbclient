package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends BaseData {
    private long Pw = 5000;
    private List<d> Px;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.Pw;
    }

    public List<d> getList() {
        return this.Px;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.Pw = jSONObject.optLong("interval", 5L);
            if (this.Pw < 5) {
                this.Pw = 5000L;
            } else {
                this.Pw *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.Px = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    d dVar = new d();
                    dVar.parserJson(optJSONObject);
                    this.Px.add(dVar);
                }
            }
        }
    }
}
