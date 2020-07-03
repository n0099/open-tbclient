package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class by {
    private int dOX = 0;
    private int dOY = 0;
    private String link = "";

    public int aUE() {
        return this.dOX;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dOX = jSONObject.optInt("is_lpost", 0);
                this.dOY = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.dOX = topic.is_lpost.intValue();
            this.dOY = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
