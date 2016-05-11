package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bb {
    private int Rk = 0;
    private int Rl = 0;
    private String link = "";

    public int rI() {
        return this.Rk;
    }

    public int rJ() {
        return this.Rl;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rk = jSONObject.optInt("is_lpost", 0);
                this.Rl = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Rk = topic.is_lpost.intValue();
            this.Rl = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
