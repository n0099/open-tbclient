package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private List<String> aCY;
    private boolean aCZ = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCZ = jSONObject.optInt("tags_switch", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aCY = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && !StringUtils.isNull(optJSONObject.optString("member"))) {
                        this.aCY.add(optJSONObject.optString("member"));
                    }
                }
            }
        }
    }

    public List<String> Cp() {
        return this.aCY;
    }

    public boolean Cq() {
        return this.aCZ;
    }
}
