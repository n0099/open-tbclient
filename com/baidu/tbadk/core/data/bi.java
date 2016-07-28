package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bi {
    private int Sm = 0;
    private int Sn = 0;
    private String link = "";

    public int rF() {
        return this.Sm;
    }

    public int rG() {
        return this.Sn;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Sm = jSONObject.optInt("is_lpost", 0);
                this.Sn = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Sm = topic.is_lpost.intValue();
            this.Sn = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
