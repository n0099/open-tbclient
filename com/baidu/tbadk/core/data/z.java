package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class z {
    private int Ro = 0;
    private int Rp = 0;
    private String link = "";

    public int rF() {
        return this.Ro;
    }

    public int rG() {
        return this.Rp;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ro = jSONObject.optInt("is_lpost", 0);
                this.Rp = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Ro = topic.is_lpost.intValue();
            this.Rp = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
