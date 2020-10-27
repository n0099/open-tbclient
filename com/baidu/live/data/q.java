package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    private long aIi;
    private List<p> aIk;
    private List<p> aIl;
    public String liveId;
    private long mAudienceCount;
    private long aIj = 5000;
    private boolean aIm = false;

    public long getCount() {
        return this.aIm ? this.aIi : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aIj;
    }

    public List<p> getList() {
        return this.aIm ? this.aIl : this.aIk;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIj = jSONObject.optLong("interval", 5L);
            if (this.aIj < 5) {
                this.aIj = 5000L;
            } else {
                this.aIj *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aIm = true;
                this.aIi = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aIl = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        p pVar = new p();
                        pVar.parserJson(optJSONObject);
                        this.aIl.add(pVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aIm = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aIk = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        p pVar2 = new p();
                        pVar2.parserJson(optJSONObject2);
                        this.aIk.add(pVar2);
                    }
                }
            }
        }
    }
}
