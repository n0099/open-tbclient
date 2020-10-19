package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private List<String> aGN;
    private boolean aGO = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGO = jSONObject.optInt("tags_switch", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aGN = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && !StringUtils.isNull(optJSONObject.optString("member"))) {
                        this.aGN.add(optJSONObject.optString("member"));
                    }
                }
            }
        }
    }

    public List<String> DB() {
        return this.aGN;
    }

    public boolean DC() {
        return this.aGO;
    }
}
