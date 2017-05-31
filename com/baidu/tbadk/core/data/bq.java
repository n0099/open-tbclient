package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bq {
    private int Zp = 0;
    private int Zq = 0;
    private String link = "";

    public int sP() {
        return this.Zp;
    }

    public int sQ() {
        return this.Zq;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zp = jSONObject.optInt("is_lpost", 0);
                this.Zq = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Zp = topic.is_lpost.intValue();
            this.Zq = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
