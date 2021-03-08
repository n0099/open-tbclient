package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveFeedDiversionData extends BaseData implements Serializable {
    public int needToast;
    public long watchDuration;
    public long watchDurationMust;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.needToast = jSONObject.optInt("need_toast");
            this.watchDurationMust = jSONObject.optLong("watch_duration_must") * 1000;
            this.watchDuration = jSONObject.optLong("watch_duration") * 1000;
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("need_toast", this.needToast);
            jSONObject.put("watch_duration_must", this.watchDurationMust);
            jSONObject.put("watch_duration", this.watchDuration);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
