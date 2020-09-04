package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class ca {
    private int eeN = 0;
    private int eeO = 0;
    private String link = "";

    public int bgT() {
        return this.eeN;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeN = jSONObject.optInt("is_lpost", 0);
                this.eeO = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eeN = topic.is_lpost.intValue();
            this.eeO = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
