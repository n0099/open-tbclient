package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbPage.AddPost;
/* loaded from: classes2.dex */
public class AdditionData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -6760087984237848132L;
    private int alreadyCount;
    private long createTime;
    private String lastAdditionContent;
    private long lastAdditionTime;
    private String postId;
    private int totalCount;
    private String warnMsg;

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public String getLastAdditionContent() {
        return this.lastAdditionContent;
    }

    public void setLastAdditionContent(String str) {
        this.lastAdditionContent = str;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getLastAdditionTime() {
        return this.lastAdditionTime;
    }

    public void setLastAdditionTime(long j) {
        this.lastAdditionTime = j;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public int getAlreadyCount() {
        return this.alreadyCount;
    }

    public void setAlreadyCount(int i) {
        this.alreadyCount = i;
    }

    public void decreaseAlreadyCount() {
        this.alreadyCount--;
    }

    public String getWarnMsg() {
        return this.warnMsg;
    }

    public void setWarnMsg(String str) {
        this.warnMsg = str;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.createTime = jSONObject.optLong("create_time", 0L);
                this.postId = jSONObject.optString("post_id");
                this.totalCount = jSONObject.optInt("total_count", 0);
                this.lastAdditionContent = jSONObject.optString("last_addition_content");
                this.lastAdditionTime = jSONObject.optLong("last_addition_time", 0L);
                this.alreadyCount = jSONObject.optInt("already_count", 0);
                this.warnMsg = jSONObject.optString("warn_msg");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtoBuf(AddPost addPost) {
        if (addPost != null) {
            try {
                this.createTime = addPost.create_time.intValue();
                this.postId = addPost.post_id;
                this.totalCount = addPost.total_count.intValue();
                this.lastAdditionContent = addPost.last_addition_content;
                this.lastAdditionTime = addPost.last_addition_time.intValue();
                this.alreadyCount = addPost.already_count.intValue();
                this.warnMsg = addPost.warn_msg;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
