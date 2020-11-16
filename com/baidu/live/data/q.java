package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    private long aHo;
    private List<p> aHq;
    private List<p> aHr;
    public String liveId;
    private long mAudienceCount;
    private long aHp = 5000;
    private boolean aHs = false;

    public long getCount() {
        return this.aHs ? this.aHo : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aHp;
    }

    public List<p> getList() {
        return this.aHs ? this.aHr : this.aHq;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHp = jSONObject.optLong("interval", 5L);
            if (this.aHp < 5) {
                this.aHp = 5000L;
            } else {
                this.aHp *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aHs = true;
                this.aHo = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aHr = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        p pVar = new p();
                        pVar.parserJson(optJSONObject);
                        this.aHr.add(pVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aHs = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aHq = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        p pVar2 = new p();
                        pVar2.parserJson(optJSONObject2);
                        this.aHq.add(pVar2);
                    }
                }
            }
        }
    }
}
