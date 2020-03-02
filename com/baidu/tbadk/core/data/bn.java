package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cUJ = 0;
    private int cUK = 0;
    private String link = "";

    public int aEt() {
        return this.cUJ;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUJ = jSONObject.optInt("is_lpost", 0);
                this.cUK = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cUJ = topic.is_lpost.intValue();
            this.cUK = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
