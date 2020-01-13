package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends BaseData {
    private long Wj = 5000;
    private List<f> Wk;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.Wj;
    }

    public List<f> getList() {
        return this.Wk;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.Wj = jSONObject.optLong("interval", 5L);
            if (this.Wj < 5) {
                this.Wj = 5000L;
            } else {
                this.Wj *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.Wk = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    f fVar = new f();
                    fVar.parserJson(optJSONObject);
                    this.Wk.add(fVar);
                }
            }
        }
    }
}
