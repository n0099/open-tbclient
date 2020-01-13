package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cQG = 0;
    private int cQH = 0;
    private String link = "";

    public int aCg() {
        return this.cQG;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQG = jSONObject.optInt("is_lpost", 0);
                this.cQH = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cQG = topic.is_lpost.intValue();
            this.cQH = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
