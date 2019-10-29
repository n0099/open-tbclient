package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaLiveUserPermData extends BaseData implements Serializable {
    public int canNotAttend;
    public int canNotJoin;
    public int canNotLive;
    public int canNotTalk;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.canNotLive = jSONObject.optInt("cannot_start_live");
            this.canNotJoin = jSONObject.optInt("cannot_join_live");
            this.canNotAttend = jSONObject.optInt("cannot_attend_live");
            this.canNotTalk = jSONObject.optInt("cannot_talk");
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cannot_start_live", this.canNotLive);
            jSONObject.put("cannot_join_live", this.canNotJoin);
            jSONObject.put("cannot_attend_live", this.canNotAttend);
            jSONObject.put("cannot_talk", this.canNotTalk);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
