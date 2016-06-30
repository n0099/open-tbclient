package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bd {
    private int RC = 0;
    private int RD = 0;
    private String link = "";

    public int rG() {
        return this.RC;
    }

    public int rH() {
        return this.RD;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.RC = jSONObject.optInt("is_lpost", 0);
                this.RD = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.RC = topic.is_lpost.intValue();
            this.RD = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
