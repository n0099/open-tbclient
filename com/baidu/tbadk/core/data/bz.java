package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bz {
    private int dVj = 0;
    private int dVk = 0;
    private String link = "";

    public int aYy() {
        return this.dVj;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dVj = jSONObject.optInt("is_lpost", 0);
                this.dVk = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.dVj = topic.is_lpost.intValue();
            this.dVk = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
