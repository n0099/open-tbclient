package com.baidu.minivideo.plugin.capture.bean;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoDraftBean implements Jsonable, Comparable<VideoDraftBean>, Serializable, Cloneable {
    public int mBackUpType;
    public String mCoverPath;
    public String mDraftName;
    public String mEffectData;
    public String mFilterValue;
    public String mFollowData;
    public String mLocalAlbumData;
    public String mLocalAlbumThemeData;
    public String mLocation;
    public String mMainTitle;
    public String mMusicData;
    public String mPreProcessVideoPath;
    public int mResumePage;
    public int mResumeRoute;
    public String mSubTitle;
    public long mTimeStamp;
    public String mTopicData;
    public String mUserID;
    public String mVideoPath;
    public String mVideoTempData;
    public int mVisibility;
    public float mOriginMusicVolume = 1.0f;
    public boolean mSelected = false;

    public VideoDraftBean(String str, String str2, long j, int i2) {
        this.mDraftName = str;
        this.mUserID = str2;
        this.mTimeStamp = j;
        this.mResumeRoute = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && VideoDraftBean.class == obj.getClass()) {
            VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
            if (this.mDraftName.equals(videoDraftBean.getDraftName()) && ((this.mVideoTempData != null && videoDraftBean.getVideoTempData() != null && this.mVideoTempData.equals(videoDraftBean.getVideoTempData())) || this.mResumeRoute == 1)) {
                if (this.mMusicData != null && videoDraftBean.getMusicData() != null) {
                    int indexOf = this.mMusicData.indexOf(ContentUtil.RESULT_KEY_SK);
                    return this.mMusicData.substring(indexOf).equals(videoDraftBean.getMusicData().substring(indexOf));
                } else if (this.mMusicData == null && videoDraftBean.getMusicData() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equalsMusic(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && VideoDraftBean.class == obj.getClass()) {
            VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
            if (this.mDraftName.equals(videoDraftBean.getDraftName())) {
                if (this.mMusicData != null && videoDraftBean.getMusicData() != null) {
                    int indexOf = this.mMusicData.indexOf(ContentUtil.RESULT_KEY_SK);
                    if (indexOf == -1 || indexOf >= videoDraftBean.getMusicData().length()) {
                        return false;
                    }
                    String substring = this.mMusicData.substring(indexOf);
                    if (indexOf >= videoDraftBean.getMusicData().length()) {
                        return false;
                    }
                    return substring.equals(videoDraftBean.getMusicData().substring(indexOf));
                } else if (this.mMusicData == null && videoDraftBean.getMusicData() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getBackupType() {
        return this.mBackUpType;
    }

    public String getCoverPath() {
        return this.mCoverPath;
    }

    public String getDraftName() {
        return this.mDraftName;
    }

    public boolean getDraftSelectedStatus() {
        return this.mSelected;
    }

    public String getEffectData() {
        return this.mEffectData;
    }

    public String getFilterValue() {
        return this.mFilterValue;
    }

    public String getFollowData() {
        return this.mFollowData;
    }

    public String getLocalAlbumData() {
        return this.mLocalAlbumData;
    }

    public String getLocalAlbumThemeData() {
        return this.mLocalAlbumThemeData;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getMainTitle() {
        return this.mMainTitle;
    }

    public String getMusicData() {
        return this.mMusicData;
    }

    public float getOriginMusicVolume() {
        return this.mOriginMusicVolume;
    }

    public String getPreProcessVideoPath() {
        return this.mPreProcessVideoPath;
    }

    public int getResumePage() {
        return this.mResumePage;
    }

    public int getResumeRoute() {
        return this.mResumeRoute;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getTopicData() {
        return this.mTopicData;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public String getVideoTempData() {
        return this.mVideoTempData;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return this.mDraftName.hashCode() + (this.mMusicData.hashCode() * 31) + (this.mVideoTempData.hashCode() * 31);
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mDraftName = jSONObject.optString("mDraftName");
            this.mUserID = jSONObject.optString("mUserID");
            this.mVideoTempData = jSONObject.optString("mVideoTempData");
            this.mVideoPath = jSONObject.optString("mVideoPath");
            this.mMusicData = jSONObject.optString("mMusicData");
            this.mMainTitle = jSONObject.optString("mMainTitle");
            this.mSubTitle = jSONObject.optString("mSubTitle");
            this.mTopicData = jSONObject.optString("mTopicData");
            this.mVisibility = jSONObject.optInt("mVisibility");
            this.mResumeRoute = jSONObject.optInt("mResumeRoute");
            this.mTimeStamp = jSONObject.optLong("mTimeStamp");
            this.mResumePage = jSONObject.optInt("mResumePage");
            this.mBackUpType = jSONObject.optInt("mBackUpType");
            this.mEffectData = jSONObject.optString("mEffectData");
            this.mCoverPath = jSONObject.optString("mCoverPath");
            this.mLocation = jSONObject.optString("mLocation");
            this.mPreProcessVideoPath = jSONObject.optString("mPreProcessVideoPath");
            this.mFollowData = jSONObject.optString("mFollowData");
            this.mOriginMusicVolume = (float) jSONObject.optDouble("mOriginMusicVolume");
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void setBackUpType(int i2) {
        this.mBackUpType = i2;
    }

    public void setCoverPath(String str) {
        this.mCoverPath = str;
    }

    public void setDraftName(String str) {
        this.mDraftName = str;
    }

    public void setDraftSelected(boolean z) {
        this.mSelected = z;
    }

    public void setEffectData(String str) {
        this.mEffectData = str;
    }

    public void setFilterValue(String str) {
        this.mFilterValue = str;
    }

    public void setFollowData(String str) {
        this.mFollowData = str;
    }

    public void setLocalAlbumData(String str) {
        this.mLocalAlbumData = str;
    }

    public void setLocalAlbumThemeData(String str) {
        this.mLocalAlbumThemeData = str;
    }

    public void setLocation(String str) {
        this.mLocation = str;
    }

    public void setMainTitle(String str) {
        this.mMainTitle = str;
    }

    public void setMusicData(String str) {
        this.mMusicData = str;
    }

    public void setOriginMusicVolume(float f2) {
        this.mOriginMusicVolume = f2;
    }

    public void setPreProcessVideoPath(String str) {
        this.mPreProcessVideoPath = str;
    }

    public void setResumePage(int i2) {
        this.mResumePage = i2;
    }

    public void setResumeRoute(int i2) {
        this.mResumeRoute = i2;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setTopicData(String str) {
        this.mTopicData = str;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
    }

    public void setVideoTempData(String str) {
        this.mVideoTempData = str;
    }

    public void setVisibility(int i2) {
        this.mVisibility = i2;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDraftName", this.mDraftName);
            jSONObject.put("mUserID", this.mUserID);
            jSONObject.put("mVideoTempData", this.mVideoTempData);
            jSONObject.put("mVideoPath", this.mVideoPath);
            jSONObject.put("mMusicData", this.mMusicData);
            jSONObject.put("mMainTitle", this.mMainTitle);
            jSONObject.put("mSubTitle", this.mSubTitle);
            jSONObject.put("mTopicData", this.mTopicData);
            jSONObject.put("mVisibility", this.mVisibility);
            jSONObject.put("mResumeRoute", this.mResumeRoute);
            jSONObject.put("mTimeStamp", this.mTimeStamp);
            jSONObject.put("mResumePage", this.mResumePage);
            jSONObject.put("mBackUpType", this.mBackUpType);
            jSONObject.put("mEffectData", this.mEffectData);
            jSONObject.put("mCoverPath", this.mCoverPath);
            jSONObject.put("mLocation", this.mLocation);
            jSONObject.put("mPreProcessVideoPath", this.mPreProcessVideoPath);
            jSONObject.put("mFollowData", this.mFollowData);
            jSONObject.put("mOriginMusicVolume", this.mOriginMusicVolume);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public VideoDraftBean m12clone() {
        try {
            return (VideoDraftBean) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull VideoDraftBean videoDraftBean) {
        if (videoDraftBean == null) {
            return -1;
        }
        long j = this.mTimeStamp;
        long j2 = videoDraftBean.mTimeStamp;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public VideoDraftBean() {
    }
}
