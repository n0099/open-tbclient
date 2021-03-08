package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class cf {
    private int eVR = 0;
    private int eVS = 0;
    private String link = "";

    public int bql() {
        return this.eVR;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eVR = jSONObject.optInt("is_lpost", 0);
                this.eVS = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eVR = topic.is_lpost.intValue();
            this.eVS = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
