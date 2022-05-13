package com.baidu.tbadk.baseEditMark;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.repackage.li;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
/* loaded from: classes2.dex */
public class MarkData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2647743141824773827L;
    public transient /* synthetic */ FieldHolder $fh;
    public long cartoonId;
    public int chapterId;
    public boolean isApp;
    public boolean isLikeInPage;
    public boolean isManga;
    public boolean isRedTipShow;
    public boolean isShareThread;
    public int is_deleted;
    public int is_follow;
    public int is_god;
    public String mAccount;
    public String mAuthorName;
    public int mFloor;
    public String mForumId;
    public String mForumName;
    public boolean mHostMode;
    public String mId;
    public boolean mIsPhotoLiveThread;
    public int mNewCounts;
    public String mPostId;
    public int mReplyNum;
    public boolean mSequence;
    public String mState;
    public int mSubPost;
    public String mThreadId;
    public long mTime;
    public String mTitle;
    public String mUesrId;
    public String mUserName;
    public MetaData metaData;
    public OriginalThreadInfo originalThreadInfo;
    public String pic_url;
    public String portrait;
    public int threadType;

    public MarkData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsPhotoLiveThread = false;
        this.mId = null;
        this.mFloor = 0;
        this.mTime = 0L;
        this.mTitle = null;
        this.mSequence = true;
        this.mHostMode = false;
        this.mAuthorName = null;
        this.mUserName = null;
        this.mReplyNum = 0;
        this.mSubPost = 0;
        this.mNewCounts = 0;
        this.isApp = false;
        this.metaData = new MetaData();
        this.mState = null;
        this.mUesrId = null;
        this.is_god = 0;
        this.isRedTipShow = true;
        this.is_follow = 0;
        this.is_follow = 0;
        this.pic_url = null;
        this.isLikeInPage = false;
    }

    public String getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAccount : (String) invokeV.objValue;
    }

    public String getAuthorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!li.isEmpty(this.mAuthorName)) {
                return this.mAuthorName;
            }
            return this.mUserName;
        }
        return (String) invokeV.objValue;
    }

    public long getCartoonId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cartoonId : invokeV.longValue;
    }

    public int getChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.chapterId : invokeV.intValue;
    }

    public int getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFloor : invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mForumId : (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mForumName : (String) invokeV.objValue;
    }

    public boolean getHostMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mHostMode : invokeV.booleanValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.is_follow == 1 : invokeV.booleanValue;
    }

    public int getIs_god() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.is_god : invokeV.intValue;
    }

    public MetaData getMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.metaData : (MetaData) invokeV.objValue;
    }

    public int getNewCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mNewCounts : invokeV.intValue;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.originalThreadInfo : (OriginalThreadInfo) invokeV.objValue;
    }

    public String getPic_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.pic_url : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPostId : (String) invokeV.objValue;
    }

    public int getReplyNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mReplyNum : invokeV.intValue;
    }

    public Boolean getSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Boolean.valueOf(this.mSequence) : (Boolean) invokeV.objValue;
    }

    public int getSubPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mSubPost : invokeV.intValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mThreadId : (String) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.threadType : invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mTime : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public String getUesrId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? String.valueOf(this.mUesrId) : (String) invokeV.objValue;
    }

    public String getmState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mState : (String) invokeV.objValue;
    }

    public boolean isApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.isApp : invokeV.booleanValue;
    }

    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.is_god == 1 : invokeV.booleanValue;
    }

    public boolean isLikeInPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.isLikeInPage : invokeV.booleanValue;
    }

    public boolean isManga() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.isManga : invokeV.booleanValue;
    }

    public boolean isPhotoLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mIsPhotoLiveThread : invokeV.booleanValue;
    }

    public boolean isRedTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.isRedTipShow : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.isShareThread : invokeV.booleanValue;
    }

    public boolean is_deleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.is_deleted == 1 : invokeV.booleanValue;
    }

    public boolean is_follow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.is_follow == 1 : invokeV.booleanValue;
    }

    public void paserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, jSONObject) == null) {
            try {
                this.mThreadId = jSONObject.optString("thread_id");
                this.mPostId = jSONObject.optString("mark_pid");
                this.mForumName = jSONObject.optString("forum_name");
                this.mTitle = jSONObject.optString("title");
                this.mAuthorName = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("name_show");
                this.mUserName = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("name");
                this.portrait = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString(RecommendDetailActivityConfig.USER_PORTRAIT);
                this.mUesrId = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR).optString("lz_uid");
                this.mId = this.mThreadId;
                this.mReplyNum = jSONObject.optInt("reply_num");
                this.mNewCounts = jSONObject.optInt("count");
                this.isShareThread = jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD, 0) == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("origin_thread_info");
                if (this.isShareThread) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.originalThreadInfo = originalThreadInfo;
                    originalThreadInfo.q(optJSONObject);
                }
                int optInt = jSONObject.optInt("thread_type");
                this.threadType = optInt;
                this.mIsPhotoLiveThread = "33".equals(String.valueOf(optInt));
                int optInt2 = jSONObject.optInt("mark_status");
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
                if (li.isEmpty(this.portrait)) {
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
                if (optInt2 == 0) {
                    this.mSequence = true;
                    this.mHostMode = false;
                    return;
                }
                if ((optInt2 & 1) != 0) {
                    this.mSequence = true;
                } else {
                    this.mSequence = false;
                }
                if ((optInt2 & 2) != 0) {
                    this.mHostMode = true;
                } else {
                    this.mHostMode = false;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void setAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mAccount = str;
        }
    }

    public void setApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isApp = z;
        }
    }

    public void setAuthorName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mAuthorName = str;
        }
    }

    public void setCartoonId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.cartoonId = j;
        }
    }

    public void setChapterId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.chapterId = i;
        }
    }

    public void setFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mFloor = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mForumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.mForumName = str;
        }
    }

    public void setHostMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.mHostMode = z;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.mId = str;
        }
    }

    public void setIs_god(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.is_god = i;
        }
    }

    public void setLikeInPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.isLikeInPage = z;
        }
    }

    public void setManga(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isManga = z;
        }
    }

    public void setMetaData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, metaData) == null) {
            this.metaData = metaData;
        }
    }

    public void setNewCounts(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.mNewCounts = i;
        }
    }

    public void setPic_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.pic_url = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.mPostId = str;
        }
    }

    public void setRedTipShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.isRedTipShow = z;
        }
    }

    public void setReplyNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mReplyNum = i;
        }
    }

    public void setSequence(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bool) == null) {
            this.mSequence = bool.booleanValue();
        }
    }

    public void setSubPost(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.mSubPost = i;
        }
    }

    public void setThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.mThreadId = str;
        }
    }

    public void setThreadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.threadType = i;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j) == null) {
            this.mTime = j;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setmState(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.mState = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", this.mThreadId);
                jSONObject.put("pid", this.mPostId);
                int i = this.mSequence ? 1 : 4;
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
        return (JSONObject) invokeV.objValue;
    }
}
