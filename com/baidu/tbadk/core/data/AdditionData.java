package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbPage.AddPost;
/* loaded from: classes3.dex */
public class AdditionData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -6760087984237848132L;
    public int alreadyCount;
    public long createTime;
    public String lastAdditionContent;
    public long lastAdditionTime;
    public String postId;
    public int totalCount;
    public String warnMsg;

    public void decreaseAlreadyCount() {
        this.alreadyCount--;
    }

    public int getAlreadyCount() {
        return this.alreadyCount;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getLastAdditionContent() {
        return this.lastAdditionContent;
    }

    public long getLastAdditionTime() {
        return this.lastAdditionTime;
    }

    public String getPostId() {
        return this.postId;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String getWarnMsg() {
        return this.warnMsg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.createTime = jSONObject.optLong("create_time", 0L);
            this.postId = jSONObject.optString("post_id");
            this.totalCount = jSONObject.optInt("total_count", 0);
            this.lastAdditionContent = jSONObject.optString("last_addition_content");
            this.lastAdditionTime = jSONObject.optLong("last_addition_time", 0L);
            this.alreadyCount = jSONObject.optInt("already_count", 0);
            this.warnMsg = jSONObject.optString("warn_msg");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtoBuf(AddPost addPost) {
        if (addPost == null) {
            return;
        }
        try {
            this.createTime = addPost.create_time.intValue();
            this.postId = addPost.post_id;
            this.totalCount = addPost.total_count.intValue();
            this.lastAdditionContent = addPost.last_addition_content;
            this.lastAdditionTime = addPost.last_addition_time.intValue();
            this.alreadyCount = addPost.already_count.intValue();
            this.warnMsg = addPost.warn_msg;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setAlreadyCount(int i2) {
        this.alreadyCount = i2;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setLastAdditionContent(String str) {
        this.lastAdditionContent = str;
    }

    public void setLastAdditionTime(long j) {
        this.lastAdditionTime = j;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setTotalCount(int i2) {
        this.totalCount = i2;
    }

    public void setWarnMsg(String str) {
        this.warnMsg = str;
    }
}
