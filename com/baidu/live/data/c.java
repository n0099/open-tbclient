package com.baidu.live.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private List<String> aHD;
    private boolean aHE = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHE = jSONObject.optInt("tags_switch", 0) == 1;
            JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aHD = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && !StringUtils.isNull(optJSONObject.optString("member"))) {
                        this.aHD.add(optJSONObject.optString("member"));
                    }
                }
            }
        }
    }

    public List<String> Bj() {
        return this.aHD;
    }

    public boolean Bk() {
        return this.aHE;
    }
}
