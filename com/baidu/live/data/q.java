package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    private long aJZ;
    private List<p> aKb;
    private List<p> aKc;
    public String liveId;
    private long mAudienceCount;
    private long aKa = 5000;
    private boolean aKd = false;

    public long getCount() {
        return this.aKd ? this.aJZ : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aKa;
    }

    public List<p> getList() {
        return this.aKd ? this.aKc : this.aKb;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKa = jSONObject.optLong("interval", 5L);
            if (this.aKa < 5) {
                this.aKa = 5000L;
            } else {
                this.aKa *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aKd = true;
                this.aJZ = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aKc = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        p pVar = new p();
                        pVar.parserJson(optJSONObject);
                        this.aKc.add(pVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aKd = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aKb = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        p pVar2 = new p();
                        pVar2.parserJson(optJSONObject2);
                        this.aKb.add(pVar2);
                    }
                }
            }
        }
    }
}
