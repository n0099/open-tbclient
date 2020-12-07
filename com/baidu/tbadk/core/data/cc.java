package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class cc {
    private int eMR = 0;
    private int eMS = 0;
    private String link = "";

    public int bri() {
        return this.eMR;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMR = jSONObject.optInt("is_lpost", 0);
                this.eMS = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eMR = topic.is_lpost.intValue();
            this.eMS = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
