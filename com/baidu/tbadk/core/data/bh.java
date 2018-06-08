package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int akh = 0;
    private int aki = 0;
    private String link = "";

    public int wO() {
        return this.akh;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akh = jSONObject.optInt("is_lpost", 0);
                this.aki = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.akh = topic.is_lpost.intValue();
            this.aki = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
