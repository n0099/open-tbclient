package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class ca {
    private int ehb = 0;
    private int ehc = 0;
    private String link = "";

    public int bhN() {
        return this.ehb;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ehb = jSONObject.optInt("is_lpost", 0);
                this.ehc = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ehb = topic.is_lpost.intValue();
            this.ehc = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
