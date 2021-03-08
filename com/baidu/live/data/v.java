package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v extends BaseData {
    private long aJH;
    private List<u> aJJ;
    private List<u> aJK;
    public String liveId;
    private long mAudienceCount;
    private long aJI = 5000;
    private boolean aJL = false;

    public long getCount() {
        return this.aJL ? this.aJH : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aJI;
    }

    public List<u> getList() {
        return this.aJL ? this.aJK : this.aJJ;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJI = jSONObject.optLong("interval", 5L);
            if (this.aJI < 5) {
                this.aJI = 5000L;
            } else {
                this.aJI *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aJL = true;
                this.aJH = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aJK = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        u uVar = new u();
                        uVar.parserJson(optJSONObject);
                        this.aJK.add(uVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aJL = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aJJ = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        u uVar2 = new u();
                        uVar2.parserJson(optJSONObject2);
                        this.aJJ.add(uVar2);
                    }
                }
            }
        }
    }
}
