package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bk {
    private int bMB = 0;
    private int bMC = 0;
    private String link = "";

    public int agx() {
        return this.bMB;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bMB = jSONObject.optInt("is_lpost", 0);
                this.bMC = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.bMB = topic.is_lpost.intValue();
            this.bMC = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
