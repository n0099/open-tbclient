package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends BaseData {
    private long aDI = 5000;
    private List<j> aDJ;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.aDI;
    }

    public List<j> getList() {
        return this.aDJ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.aDI = jSONObject.optLong("interval", 5L);
            if (this.aDI < 5) {
                this.aDI = 5000L;
            } else {
                this.aDI *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.aDJ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    j jVar = new j();
                    jVar.parserJson(optJSONObject);
                    this.aDJ.add(jVar);
                }
            }
        }
    }
}
