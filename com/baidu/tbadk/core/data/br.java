package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class br {
    private int Zr = 0;
    private int Zs = 0;
    private String link = "";

    public int sN() {
        return this.Zr;
    }

    public int sO() {
        return this.Zs;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zr = jSONObject.optInt("is_lpost", 0);
                this.Zs = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Zr = topic.is_lpost.intValue();
            this.Zs = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
