package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bl {
    private int bNf = 0;
    private int bNg = 0;
    private String link = "";

    public int agD() {
        return this.bNf;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bNf = jSONObject.optInt("is_lpost", 0);
                this.bNg = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.bNf = topic.is_lpost.intValue();
            this.bNg = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
