package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class t {
    private int AO = 0;
    private int AP = 0;
    private String link = "";

    public int kP() {
        return this.AO;
    }

    public int kQ() {
        return this.AP;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.AO = jSONObject.optInt("is_lpost", 0);
                this.AP = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.AO = topic.is_lpost.intValue();
            this.AP = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
