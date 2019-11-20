package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends BaseData {
    private long OW = 5000;
    private List<d> OX;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.OW;
    }

    public List<d> getList() {
        return this.OX;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.OW = jSONObject.optLong("interval", 5L);
            if (this.OW < 5) {
                this.OW = 5000L;
            } else {
                this.OW *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.OX = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    d dVar = new d();
                    dVar.parserJson(optJSONObject);
                    this.OX.add(dVar);
                }
            }
        }
    }
}
