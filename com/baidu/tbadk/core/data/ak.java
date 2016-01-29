package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class ak {
    private int XF = 0;
    private int XG = 0;
    private String link = "";

    public int tX() {
        return this.XF;
    }

    public int tY() {
        return this.XG;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XF = jSONObject.optInt("is_lpost", 0);
                this.XG = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.XF = topic.is_lpost.intValue();
            this.XG = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
