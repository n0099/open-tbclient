package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aaQ = 0;
    private int aaR = 0;
    private String link = "";

    public int sV() {
        return this.aaQ;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaQ = jSONObject.optInt("is_lpost", 0);
                this.aaR = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aaQ = topic.is_lpost.intValue();
            this.aaR = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
