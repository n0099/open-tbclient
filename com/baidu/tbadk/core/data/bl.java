package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bl {
    private int cdX = 0;
    private int cdY = 0;
    private String link = "";

    public int akD() {
        return this.cdX;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cdX = jSONObject.optInt("is_lpost", 0);
                this.cdY = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cdX = topic.is_lpost.intValue();
            this.cdY = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
