package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    private long aIZ;
    private List<p> aJb;
    private List<p> aJc;
    public String liveId;
    private long mAudienceCount;
    private long aJa = 5000;
    private boolean aJd = false;

    public long getCount() {
        return this.aJd ? this.aIZ : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aJa;
    }

    public List<p> getList() {
        return this.aJd ? this.aJc : this.aJb;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJa = jSONObject.optLong("interval", 5L);
            if (this.aJa < 5) {
                this.aJa = 5000L;
            } else {
                this.aJa *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aJd = true;
                this.aIZ = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aJc = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        p pVar = new p();
                        pVar.parserJson(optJSONObject);
                        this.aJc.add(pVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aJd = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aJb = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        p pVar2 = new p();
                        pVar2.parserJson(optJSONObject2);
                        this.aJb.add(pVar2);
                    }
                }
            }
        }
    }
}
