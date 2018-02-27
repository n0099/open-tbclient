package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aQA = 0;
    private int aQB = 0;
    private String link = "";

    public int AI() {
        return this.aQA;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQA = jSONObject.optInt("is_lpost", 0);
                this.aQB = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aQA = topic.is_lpost.intValue();
            this.aQB = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
