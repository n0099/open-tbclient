package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cUX = 0;
    private int cUY = 0;
    private String link = "";

    public int aEx() {
        return this.cUX;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUX = jSONObject.optInt("is_lpost", 0);
                this.cUY = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cUX = topic.is_lpost.intValue();
            this.cUY = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
