package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bk {
    private int bEh = 0;
    private int bEi = 0;
    private String link = "";

    public int aaL() {
        return this.bEh;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEh = jSONObject.optInt("is_lpost", 0);
                this.bEi = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.bEh = topic.is_lpost.intValue();
            this.bEi = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
