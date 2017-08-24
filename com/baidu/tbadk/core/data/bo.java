package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int abi = 0;
    private int abj = 0;
    private String link = "";

    public int tf() {
        return this.abi;
    }

    public int tg() {
        return this.abj;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abi = jSONObject.optInt("is_lpost", 0);
                this.abj = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.abi = topic.is_lpost.intValue();
            this.abj = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
