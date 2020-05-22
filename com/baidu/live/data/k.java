package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends BaseData {
    private long avn = 5000;
    private List<j> avo;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.avn;
    }

    public List<j> getList() {
        return this.avo;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.avn = jSONObject.optLong("interval", 5L);
            if (this.avn < 5) {
                this.avn = 5000L;
            } else {
                this.avn *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.avo = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    j jVar = new j();
                    jVar.parserJson(optJSONObject);
                    this.avo.add(jVar);
                }
            }
        }
    }
}
