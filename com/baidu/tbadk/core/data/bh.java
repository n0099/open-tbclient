package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aQC = 0;
    private int aQD = 0;
    private String link = "";

    public int AJ() {
        return this.aQC;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQC = jSONObject.optInt("is_lpost", 0);
                this.aQD = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aQC = topic.is_lpost.intValue();
            this.aQD = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
