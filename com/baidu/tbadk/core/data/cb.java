package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class cb {
    private int eFO = 0;
    private int eFP = 0;
    private String link = "";

    public int bnT() {
        return this.eFO;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eFO = jSONObject.optInt("is_lpost", 0);
                this.eFP = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eFO = topic.is_lpost.intValue();
            this.eFP = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
