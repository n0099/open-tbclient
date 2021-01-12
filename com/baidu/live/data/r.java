package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r extends BaseData {
    private long aFL;
    private List<q> aFN;
    private List<q> aFO;
    public String liveId;
    private long mAudienceCount;
    private long aFM = 5000;
    private boolean aFP = false;

    public long getCount() {
        return this.aFP ? this.aFL : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aFM;
    }

    public List<q> getList() {
        return this.aFP ? this.aFO : this.aFN;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFM = jSONObject.optLong("interval", 5L);
            if (this.aFM < 5) {
                this.aFM = 5000L;
            } else {
                this.aFM *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aFP = true;
                this.aFL = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aFO = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(optJSONObject);
                        this.aFO.add(qVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aFP = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aFN = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        q qVar2 = new q();
                        qVar2.parserJson(optJSONObject2);
                        this.aFN.add(qVar2);
                    }
                }
            }
        }
    }
}
