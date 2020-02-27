package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cUI = 0;
    private int cUJ = 0;
    private String link = "";

    public int aEr() {
        return this.cUI;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUI = jSONObject.optInt("is_lpost", 0);
                this.cUJ = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cUI = topic.is_lpost.intValue();
            this.cUJ = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
