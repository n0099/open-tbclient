package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aPl = 0;
    private int aPm = 0;
    private String link = "";

    public int Ao() {
        return this.aPl;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPl = jSONObject.optInt("is_lpost", 0);
                this.aPm = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aPl = topic.is_lpost.intValue();
            this.aPm = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
