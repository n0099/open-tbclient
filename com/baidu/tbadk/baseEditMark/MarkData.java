package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.as;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
/* loaded from: classes.dex */
public class MarkData implements Serializable {
    private static final long serialVersionUID = 2647743141824773827L;
    private long cartoonId;
    private int chapterId;
    private boolean isManga;
    private boolean isShareThread;
    private int is_deleted;
    private int is_follow;
    private String mAccount;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;
    private OriginalThreadInfo originalThreadInfo;
    private String portrait;
    private boolean mIsPhotoLiveThread = false;
    private String mId = null;
    private int mFloor = 0;
    private long mTime = 0;
    private String mTitle = null;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private String mAuthorName = null;
    private String mUserName = null;
    private int mReplyNum = 0;
    private int mSubPost = 0;
    private int mNewCounts = 0;
    private boolean isApp = false;
    public MetaData metaData = new MetaData();
    private String mState = null;
    private String mUesrId = null;
    private int is_god = 0;
    private boolean isRedTipShow = true;
    private String pic_url = null;
    private boolean isLikeInPage = false;

    public MarkData() {
        this.is_follow = 0;
        this.is_follow = 0;
    }

    public boolean getIsLike() {
        return this.is_follow == 1;
    }

    public String getAuthorName() {
        return !as.isEmpty(this.mAuthorName) ? this.mAuthorName : this.mUserName;
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

    public String getUesrId() {
        return String.valueOf(this.mUesrId);
    }

    public boolean isGod() {
        return this.is_god == 1;
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

    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public String getmState() {
        return this.mState;
    }

    public void setmState(String str) {
        this.mState = str;
    }

    public boolean isRedTipShow() {
        return this.isRedTipShow;
    }

    public void setRedTipShow(boolean z) {
        this.isRedTipShow = z;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getIs_god() {
        return this.is_god;
    }

    public void setIs_god(int i) {
        this.is_god = i;
    }

    public boolean is_follow() {
        return this.is_follow == 1;
    }

    public boolean isLikeInPage() {
        return this.isLikeInPage;
    }

    public void setLikeInPage(boolean z) {
        this.isLikeInPage = z;
    }

    public boolean is_deleted() {
        return this.is_deleted == 1;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public void setPic_url(String str) {
        this.pic_url = str;
    }

    public boolean isShareThread() {
        return this.isShareThread;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        return this.originalThreadInfo;
    }

    public JSONObject toJson() {
        int i;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.mThreadId);
            jSONObject.put("pid", this.mPostId);
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
            this.mAuthorName = jSONObject.optJSONObject("author").optString("name_show");
            this.mUserName = jSONObject.optJSONObject("author").optString("name");
            this.portrait = jSONObject.optJSONObject("author").optString("user_portrait");
            this.mUesrId = jSONObject.optJSONObject("author").optString("lz_uid");
            this.mId = this.mThreadId;
            this.mReplyNum = jSONObject.optInt("reply_num");
            this.mNewCounts = jSONObject.optInt("count");
            this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("origin_thread_info");
            if (this.isShareThread) {
                this.originalThreadInfo = new OriginalThreadInfo();
                this.originalThreadInfo.parserJson(optJSONObject);
            }
            this.mIsPhotoLiveThread = "33".equals(String.valueOf(jSONObject.optInt("thread_type")));
            int optInt = jSONObject.optInt("mark_status");
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                String optString = optJSONArray.getJSONObject(0).optString("type");
                if (as.equals(optString, UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                    this.pic_url = optJSONArray.getJSONObject(0).optString("small_pic");
                } else if (as.equals(optString, "flash")) {
                    this.pic_url = optJSONArray.getJSONObject(0).optString("vpic");
                }
            }
            this.is_god = jSONObject.optInt("god");
            this.is_follow = jSONObject.optInt("is_follow");
            this.is_deleted = jSONObject.optInt("is_deleted");
            this.mState = jSONObject.optString("post_no_msg");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("author").optJSONObject("baijiahao_info");
            if (optJSONObject2 != null) {
                BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
                builder.name = optJSONObject2.optString("name");
                builder.avatar = optJSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                builder.avatar_h = optJSONObject2.optString("avatar_h");
                builder.brief = optJSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                builder.auth_id = Integer.valueOf(optJSONObject2.optInt("auth_id"));
                builder.auth_desc = optJSONObject2.optString("auth_desc");
                this.metaData.setBaijiahaoInfo(builder.build(false));
            }
            if (as.isEmpty(this.portrait)) {
                this.metaData.setPortrait("null");
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
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
