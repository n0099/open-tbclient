package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int ZV = 0;
    private int ZW = 0;
    private String link = "";

    public int tD() {
        return this.ZV;
    }

    public int tE() {
        return this.ZW;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZV = jSONObject.optInt("is_lpost", 0);
                this.ZW = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ZV = topic.is_lpost.intValue();
            this.ZW = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
