package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int ZJ = 0;
    private int ZK = 0;
    private String link = "";

    public int sU() {
        return this.ZJ;
    }

    public int sV() {
        return this.ZK;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZJ = jSONObject.optInt("is_lpost", 0);
                this.ZK = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ZJ = topic.is_lpost.intValue();
            this.ZK = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
