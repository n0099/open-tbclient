package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MarkData implements Serializable {
    private static final long serialVersionUID = 2647743141824773827L;
    private String mAccount;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private String mId = null;
    private int mFloor = 0;
    private long mTime = 0;
    private String mTitle = null;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private String mAuthorName = null;
    private int mReplyNum = 0;
    private int mSubPost = 0;
    private int mNewCounts = 0;

    public String getAuthorName() {
        return this.mAuthorName;
    }

    public void setAuthorName(String str) {
        this.mAuthorName = str;
    }

    public int getReplyNum() {
        return this.mReplyNum;
    }

    public void setReplyNum(int i) {
        this.mReplyNum = i;
    }

    public void setSubPost(int i) {
        this.mSubPost = i;
    }

    public int getSubPost() {
        return this.mSubPost;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int getFloor() {
        return this.mFloor;
    }

    public void setFloor(int i) {
        this.mFloor = i;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setSequence(Boolean bool) {
        this.mSequence = bool.booleanValue();
    }

    public Boolean getSequence() {
        return Boolean.valueOf(this.mSequence);
    }

    public void setHostMode(boolean z) {
        this.mHostMode = z;
    }

    public boolean getHostMode() {
        return this.mHostMode;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public String getPostId() {
        return this.mPostId;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public int getNewCounts() {
        return this.mNewCounts;
    }

    public void setNewCounts(int i) {
        this.mNewCounts = i;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.mThreadId);
            jSONObject.put("pid", this.mPostId);
            if (this.mHostMode) {
                jSONObject.put("status", "1");
            } else if (!this.mSequence) {
                jSONObject.put("status", "2");
            } else {
                jSONObject.put("status", "0");
            }
            return jSONObject;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void paserJson(JSONObject jSONObject) {
        try {
            this.mThreadId = jSONObject.optString("thread_id");
            this.mPostId = jSONObject.optString("mark_pid");
            this.mForumName = jSONObject.optString("forum_name");
            this.mTitle = jSONObject.optString("title");
            this.mAuthorName = jSONObject.optJSONObject("author").optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
            this.mId = this.mThreadId;
            this.mReplyNum = jSONObject.optInt("reply_num");
            this.mNewCounts = jSONObject.optInt(ImageViewerConfig.COUNT);
            int optInt = jSONObject.optInt("mark_status");
            if (optInt == 1) {
                this.mHostMode = true;
            } else if (optInt == 2) {
                this.mSequence = false;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
