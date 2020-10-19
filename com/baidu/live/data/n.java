package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends BaseData {
    private long aHH;
    private List<m> aHJ;
    private List<m> aHK;
    private long mAudienceCount;
    private long aHI = 5000;
    private boolean aHL = false;

    public long getCount() {
        return this.aHL ? this.aHH : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aHI;
    }

    public List<m> getList() {
        return this.aHL ? this.aHK : this.aHJ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHI = jSONObject.optLong("interval", 5L);
            if (this.aHI < 5) {
                this.aHI = 5000L;
            } else {
                this.aHI *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aHL = true;
                this.aHH = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aHK = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        m mVar = new m();
                        mVar.parserJson(optJSONObject);
                        this.aHK.add(mVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aHL = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aHJ = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        m mVar2 = new m();
                        mVar2.parserJson(optJSONObject2);
                        this.aHJ.add(mVar2);
                    }
                }
            }
        }
    }
}
