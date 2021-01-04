package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends BaseData {
    private List<q> aKA;
    private List<q> aKB;
    private long aKy;
    public String liveId;
    private long mAudienceCount;
    private long aKz = 5000;
    private boolean aKC = false;

    public long getCount() {
        return this.aKC ? this.aKy : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aKz;
    }

    public List<q> getList() {
        return this.aKC ? this.aKB : this.aKA;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKz = jSONObject.optLong("interval", 5L);
            if (this.aKz < 5) {
                this.aKz = 5000L;
            } else {
                this.aKz *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aKC = true;
                this.aKy = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aKB = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        q qVar = new q();
                        qVar.parserJson(optJSONObject);
                        this.aKB.add(qVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aKC = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aKA = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        q qVar2 = new q();
                        qVar2.parserJson(optJSONObject2);
                        this.aKA.add(qVar2);
                    }
                }
            }
        }
    }
}
