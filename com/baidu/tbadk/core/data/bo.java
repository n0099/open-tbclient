package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int dIh = 0;
    private int dIi = 0;
    private String link = "";

    public int aSK() {
        return this.dIh;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dIh = jSONObject.optInt("is_lpost", 0);
                this.dIi = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.dIh = topic.is_lpost.intValue();
            this.dIi = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
