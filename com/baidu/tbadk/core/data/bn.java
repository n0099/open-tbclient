package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cUK = 0;
    private int cUL = 0;
    private String link = "";

    public int aEt() {
        return this.cUK;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUK = jSONObject.optInt("is_lpost", 0);
                this.cUL = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cUK = topic.is_lpost.intValue();
            this.cUL = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
