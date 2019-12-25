package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends BaseData {
    private long VT = 5000;
    private List<f> VU;
    private long mAudienceCount;

    public long getCount() {
        return this.mAudienceCount;
    }

    public long getInterval() {
        return this.VT;
    }

    public List<f> getList() {
        return this.VU;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mAudienceCount = jSONObject.optLong("audience_count");
            this.VT = jSONObject.optLong("interval", 5L);
            if (this.VT < 5) {
                this.VT = 5000L;
            } else {
                this.VT *= 1000;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("initmacy_rank");
            if (optJSONArray != null) {
                this.VU = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    f fVar = new f();
                    fVar.parserJson(optJSONObject);
                    this.VU.add(fVar);
                }
            }
        }
    }
}
