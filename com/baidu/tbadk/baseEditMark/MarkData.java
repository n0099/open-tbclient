package com.baidu.tbadk.baseEditMark;

import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidubce.services.vod.VodClient;
import d.a.c.e.p.k;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
/* loaded from: classes3.dex */
public class MarkData implements Serializable {
    public static final long serialVersionUID = 2647743141824773827L;
    public long cartoonId;
    public int chapterId;
    public boolean isManga;
    public boolean isShareThread;
    public int is_deleted;
    public int is_follow;
    public String mAccount;
    public String mForumId;
    public String mForumName;
    public String mPostId;
    public String mThreadId;
    public OriginalThreadInfo originalThreadInfo;
    public String portrait;
    public boolean mIsPhotoLiveThread = false;
    public String mId = null;
    public int mFloor = 0;
    public long mTime = 0;
    public String mTitle = null;
    public boolean mSequence = true;
    public boolean mHostMode = false;
    public String mAuthorName = null;
    public String mUserName = null;
    public int mReplyNum = 0;
    public int mSubPost = 0;
    public int mNewCounts = 0;
    public boolean isApp = false;
    public MetaData metaData = new MetaData();
    public String mState = null;
    public String mUesrId = null;
    public int is_god = 0;
    public boolean isRedTipShow = true;
    public String pic_url = null;
    public boolean isLikeInPage = false;

    public MarkData() {
        this.is_follow = 0;
        this.is_follow = 0;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getAuthorName() {
        if (!k.isEmpty(this.mAuthorName)) {
            return this.mAuthorName;
        }
        return this.mUserName;
    }

    public long getCartoonId() {
        return this.cartoonId;
    }

    public int getChapterId() {
        return this.chapterId;
    }

    public int getFloor() {
        return this.mFloor;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public boolean getHostMode() {
        return this.mHostMode;
    }

    public String getId() {
        return this.mId;
    }

    public boolean getIsLike() {
        return this.is_follow == 1;
    }

    public int getIs_god() {
        return this.is_god;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public int getNewCounts() {
        return this.mNewCounts;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        return this.originalThreadInfo;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPostId() {
        return this.mPostId;
    }

    public int getReplyNum() {
        return this.mReplyNum;
    }

    public Boolean getSequence() {
        return Boolean.valueOf(this.mSequence);
    }

    public int getSubPost() {
        return this.mSubPost;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUesrId() {
        return String.valueOf(this.mUesrId);
    }

    public String getmState() {
        return this.mState;
    }

    public boolean isApp() {
        return this.isApp;
    }

    public boolean isGod() {
        return this.is_god == 1;
    }

    public boolean isLikeInPage() {
        return this.isLikeInPage;
    }

    public boolean isManga() {
        return this.isManga;
    }

    public boolean isPhotoLiveThread() {
        return this.mIsPhotoLiveThread;
    }

    public boolean isRedTipShow() {
        return this.isRedTipShow;
    }

    public boolean isShareThread() {
        return this.isShareThread;
    }

    public boolean is_deleted() {
        return this.is_deleted == 1;
    }

    public boolean is_follow() {
        return this.is_follow == 1;
    }

    public void paserJson(JSONObject jSONObject) {
        try {
            this.mThreadId = jSONObject.optString("thread_id");
            this.mPostId = jSONObject.optString("mark_pid");
            this.mForumName = jSONObject.optString("forum_name");
            this.mTitle = jSONObject.optString("title");
            this.mAuthorName = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("name_show");
            this.mUserName = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("name");
            this.portrait = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("user_portrait");
            this.mUesrId = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("lz_uid");
            this.mId = this.mThreadId;
            this.mReplyNum = jSONObject.optInt("reply_num");
            this.mNewCounts = jSONObject.optInt("count");
            this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("origin_thread_info");
            if (this.isShareThread) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.originalThreadInfo = originalThreadInfo;
                originalThreadInfo.l(optJSONObject);
            }
            this.mIsPhotoLiveThread = "33".equals(String.valueOf(jSONObject.optInt("thread_type")));
            int optInt = jSONObject.optInt("mark_status");
            JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                String optString = optJSONArray.getJSONObject(0).optString("type");
                if (StringHelper.equals(optString, "pic")) {
                    this.pic_url = optJSONArray.getJSONObject(0).optString("small_pic");
                } else if (StringHelper.equals(optString, "flash")) {
                    this.pic_url = optJSONArray.getJSONObject(0).optString("vpic");
                }
            }
            this.is_god = jSONObject.optInt("god");
            this.is_follow = jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW);
            this.is_deleted = jSONObject.optInt("is_deleted");
            this.mState = jSONObject.optString("post_no_msg");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optJSONObject("baijiahao_info");
            if (optJSONObject2 != null) {
                BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
                builder.name = optJSONObject2.optString("name");
                builder.avatar = optJSONObject2.optString("avatar");
                builder.avatar_h = optJSONObject2.optString("avatar_h");
                builder.brief = optJSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                builder.auth_id = Integer.valueOf(optJSONObject2.optInt("auth_id"));
                builder.auth_desc = optJSONObject2.optString("auth_desc");
                this.metaData.setBaijiahaoInfo(builder.build(false));
            }
            if (k.isEmpty(this.portrait)) {
                this.metaData.setPortrait(StringUtil.NULL_STRING);
            } else {
                this.metaData.setPortrait(this.portrait);
            }
            this.metaData.setName_show(this.mAuthorName);
            this.metaData.setUserId(this.mUesrId);
            this.metaData.setIsBigV(this.is_god == 5);
            this.metaData.setIsLike(this.is_follow == 1);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject3 != null) {
                this.isManga = true;
                this.cartoonId = optJSONObject3.optLong("cartoon_id");
                this.chapterId = optJSONObject3.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
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
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public void setApp(boolean z) {
        this.isApp = z;
    }

    public void setAuthorName(String str) {
        this.mAuthorName = str;
    }

    public void setCartoonId(long j) {
        this.cartoonId = j;
    }

    public void setChapterId(int i2) {
        this.chapterId = i2;
    }

    public void setFloor(int i2) {
        this.mFloor = i2;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setHostMode(boolean z) {
        this.mHostMode = z;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setIs_god(int i2) {
        this.is_god = i2;
    }

    public void setLikeInPage(boolean z) {
        this.isLikeInPage = z;
    }

    public void setManga(boolean z) {
        this.isManga = z;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public void setNewCounts(int i2) {
        this.mNewCounts = i2;
    }

    public void setPic_url(String str) {
        this.pic_url = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void setRedTipShow(boolean z) {
        this.isRedTipShow = z;
    }

    public void setReplyNum(int i2) {
        this.mReplyNum = i2;
    }

    public void setSequence(Boolean bool) {
        this.mSequence = bool.booleanValue();
    }

    public void setSubPost(int i2) {
        this.mSubPost = i2;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setmState(String str) {
        this.mState = str;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.mThreadId);
            jSONObject.put("pid", this.mPostId);
            int i2 = this.mSequence ? 1 : 4;
            if (this.mHostMode) {
                i2 += 2;
            }
            jSONObject.put("status", i2);
            return jSONObject;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
