package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k extends BaseData {
    private long ayG = 5000;
    private List<j> ayH;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.ayG;
    }

    public List<j> getList() {
        return this.ayH;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.ayG = jSONObject.optLong("interval", 5L);
            if (this.ayG < 5) {
                this.ayG = 5000L;
            } else {
                this.ayG *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.ayH = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    j jVar = new j();
                    jVar.parserJson(optJSONObject);
                    this.ayH.add(jVar);
                }
            }
        }
    }
}
