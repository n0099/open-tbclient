package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n extends BaseData {
    private long aED;
    private List<m> aEF;
    private List<m> aEG;
    private long mAudienceCount;
    private long aEE = 5000;
    private boolean aEH = false;

    public long getCount() {
        return this.aEH ? this.aED : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aEE;
    }

    public List<m> getList() {
        return this.aEH ? this.aEG : this.aEF;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEE = jSONObject.optLong("interval", 5L);
            if (this.aEE < 5) {
                this.aEE = 5000L;
            } else {
                this.aEE *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aEH = true;
                this.aED = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aEG = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        m mVar = new m();
                        mVar.parserJson(optJSONObject);
                        this.aEG.add(mVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aEH = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aEF = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        m mVar2 = new m();
                        mVar2.parserJson(optJSONObject2);
                        this.aEF.add(mVar2);
                    }
                }
            }
        }
    }
}
