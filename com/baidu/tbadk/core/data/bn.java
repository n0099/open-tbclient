package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int dum = 0;
    private int dun = 0;
    private String link = "";

    public int aMJ() {
        return this.dum;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dum = jSONObject.optInt("is_lpost", 0);
                this.dun = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.dum = topic.is_lpost.intValue();
            this.dun = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
