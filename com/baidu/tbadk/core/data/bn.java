package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int cQw = 0;
    private int cQx = 0;
    private String link = "";

    public int aBN() {
        return this.cQw;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQw = jSONObject.optInt("is_lpost", 0);
                this.cQx = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.cQw = topic.is_lpost.intValue();
            this.cQx = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
