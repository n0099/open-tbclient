package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int abh = 0;
    private int abi = 0;
    private String link = "";

    public int te() {
        return this.abh;
    }

    public int tf() {
        return this.abi;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abh = jSONObject.optInt("is_lpost", 0);
                this.abi = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.abh = topic.is_lpost.intValue();
            this.abi = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
