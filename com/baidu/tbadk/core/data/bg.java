package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bg {
    private int akG = 0;
    private int akH = 0;
    private String link = "";

    public int xb() {
        return this.akG;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akG = jSONObject.optInt("is_lpost", 0);
                this.akH = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.akG = topic.is_lpost.intValue();
            this.akH = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
