package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int ZU = 0;
    private int ZV = 0;
    private String link = "";

    public int tD() {
        return this.ZU;
    }

    public int tE() {
        return this.ZV;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZU = jSONObject.optInt("is_lpost", 0);
                this.ZV = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ZU = topic.is_lpost.intValue();
            this.ZV = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
