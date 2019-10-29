package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bl {
    private int ceO = 0;
    private int ceP = 0;
    private String link = "";

    public int akF() {
        return this.ceO;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ceO = jSONObject.optInt("is_lpost", 0);
                this.ceP = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ceO = topic.is_lpost.intValue();
            this.ceP = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
