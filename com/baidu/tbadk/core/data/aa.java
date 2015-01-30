package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class aa {
    private int Fg = 0;
    private int Fh = 0;
    private String link = "";

    public int nS() {
        return this.Fg;
    }

    public int nT() {
        return this.Fh;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Fg = jSONObject.optInt("is_lpost", 0);
                this.Fh = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Fg = topic.is_lpost.intValue();
            this.Fh = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
