package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class ac {
    private int WV = 0;
    private int WW = 0;
    private String link = "";

    public int tp() {
        return this.WV;
    }

    public int tq() {
        return this.WW;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.WV = jSONObject.optInt("is_lpost", 0);
                this.WW = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.WV = topic.is_lpost.intValue();
            this.WW = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
