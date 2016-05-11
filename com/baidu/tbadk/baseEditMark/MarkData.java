package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MarkData implements Serializable {
    private static final long serialVersionUID = 2647743141824773827L;
    private long cartoonId;
    private int chapterId;
    private boolean isManga;
    private String mAccount;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private boolean mIsPhotoLiveThread = false;
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
    private boolean isApp = false;

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

    public boolean isPhotoLiveThread() {
        return this.mIsPhotoLiveThread;
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

    public boolean isApp() {
        return this.isApp;
    }

    public void setApp(boolean z) {
        this.isApp = z;
    }

    public boolean isManga() {
        return this.isManga;
    }

    public void setManga(boolean z) {
        this.isManga = z;
    }

    public long getCartoonId() {
        return this.cartoonId;
    }

    public void setCartoonId(long j) {
        this.cartoonId = j;
    }

    public int getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(int i) {
        this.chapterId = i;
    }

    public JSONObject toJson() {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.mThreadId);
            jSONObject.put(Info.kBaiduPIDKey, this.mPostId);
            if (this.mSequence) {
                i = 1;
            } else {
                i = 4;
            }
            if (this.mHostMode) {
                i += 2;
            }
            jSONObject.put("status", i);
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
            this.mAuthorName = jSONObject.optJSONObject("author").optString(IntentConfig.NAME_SHOW);
            this.mId = this.mThreadId;
            this.mReplyNum = jSONObject.optInt("reply_num");
            this.mNewCounts = jSONObject.optInt("count");
            this.mIsPhotoLiveThread = "33".equals(String.valueOf(jSONObject.optInt("thread_type")));
            int optInt = jSONObject.optInt("mark_status");
            JSONObject optJSONObject = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject != null) {
                this.isManga = true;
                this.cartoonId = optJSONObject.optLong("cartoon_id");
                this.chapterId = optJSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            }
            if (optInt == 0) {
                this.mSequence = true;
                this.mHostMode = false;
                return;
            }
            if ((optInt & 1) != 0) {
                this.mSequence = true;
            } else {
                this.mSequence = false;
            }
            if ((optInt & 2) != 0) {
                this.mHostMode = true;
            } else {
                this.mHostMode = false;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
