package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bf {
    private int avT = 0;
    private int avU = 0;
    private String link = "";

    public int Bt() {
        return this.avT;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.avT = jSONObject.optInt("is_lpost", 0);
                this.avU = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.avT = topic.is_lpost.intValue();
            this.avU = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
