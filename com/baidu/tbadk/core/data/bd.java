package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bd {
    private String avatar;
    private String forumId;
    private int forumLevel;
    private String forumName;

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int qU() {
        return this.forumLevel;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumLevel(int i) {
        this.forumLevel = i;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.forumId = String.valueOf(jSONObject.optLong("id", 0L));
                this.forumName = jSONObject.optString("name");
                this.avatar = jSONObject.optString("avatar");
                this.forumLevel = jSONObject.optInt("level_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.forumLevel = simpleForum.level_id.intValue();
        }
    }
}
