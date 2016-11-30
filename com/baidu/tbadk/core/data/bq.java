package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bq {
    private int VK = 0;
    private int VL = 0;
    private String link = "";

    public int td() {
        return this.VK;
    }

    public int te() {
        return this.VL;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VK = jSONObject.optInt("is_lpost", 0);
                this.VL = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.VK = topic.is_lpost.intValue();
            this.VL = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
