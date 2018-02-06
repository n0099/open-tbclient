package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aQL = 0;
    private int aQM = 0;
    private String link = "";

    public int AI() {
        return this.aQL;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQL = jSONObject.optInt("is_lpost", 0);
                this.aQM = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aQL = topic.is_lpost.intValue();
            this.aQM = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
