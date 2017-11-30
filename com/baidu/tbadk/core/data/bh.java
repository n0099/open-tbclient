package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aaT = 0;
    private int aaU = 0;
    private String link = "";

    public int sY() {
        return this.aaT;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaT = jSONObject.optInt("is_lpost", 0);
                this.aaU = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aaT = topic.is_lpost.intValue();
            this.aaU = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
