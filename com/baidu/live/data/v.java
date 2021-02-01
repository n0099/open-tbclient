package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class v extends BaseData {
    private long aIh;
    private List<u> aIj;
    private List<u> aIk;
    public String liveId;
    private long mAudienceCount;
    private long aIi = 5000;
    private boolean aIl = false;

    public long getCount() {
        return this.aIl ? this.aIh : this.mAudienceCount;
    }

    public long getInterval() {
        return this.aIi;
    }

    public List<u> getList() {
        return this.aIl ? this.aIk : this.aIj;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIi = jSONObject.optLong("interval", 5L);
            if (this.aIi < 5) {
                this.aIi = 5000L;
            } else {
                this.aIi *= 1000;
            }
            if (jSONObject.has("user_count")) {
                this.aIl = true;
                this.aIh = jSONObject.optLong("user_count");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_info");
                if (optJSONArray != null) {
                    this.aIk = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        u uVar = new u();
                        uVar.parserJson(optJSONObject);
                        this.aIk.add(uVar);
                    }
                } else {
                    return;
                }
            }
            if (jSONObject.has("audience_count")) {
                this.aIl = false;
                this.mAudienceCount = jSONObject.optLong("audience_count");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("initmacy_rank");
                if (optJSONArray2 != null) {
                    this.aIj = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        u uVar2 = new u();
                        uVar2.parserJson(optJSONObject2);
                        this.aIj.add(uVar2);
                    }
                }
            }
        }
    }
}
