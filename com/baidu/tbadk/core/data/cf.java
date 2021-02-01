package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class cf {
    private int eUs = 0;
    private int eUt = 0;
    private String link = "";

    public int bqj() {
        return this.eUs;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eUs = jSONObject.optInt("is_lpost", 0);
                this.eUt = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eUs = topic.is_lpost.intValue();
            this.eUt = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
