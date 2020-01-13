package com.baidu.minivideo.plugin.capture.bean;

import android.support.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class VideoDraftBean implements Jsonable, Serializable, Cloneable, Comparable<VideoDraftBean> {
    private int mBackUpType;
    private String mCoverPath;
    private String mDraftName;
    private String mEffectData;
    private String mFilterValue;
    private String mFollowData;
    private String mLocalAlbumData;
    private String mLocalAlbumThemeData;
    private String mLocation;
    private String mMainTitle;
    private String mMusicData;
    private String mPreProcessVideoPath;
    private int mResumePage;
    private int mResumeRoute;
    private String mSubTitle;
    private long mTimeStamp;
    private String mTopicData;
    private String mUserID;
    private String mVideoPath;
    private String mVideoTempData;
    private int mVisibility;
    private float mOriginMusicVolume = 1.0f;
    private boolean mSelected = false;

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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
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
        } catch (JSONException e) {
            return false;
        }
    }

    public VideoDraftBean(String str, String str2, long j, int i) {
        this.mDraftName = str;
        this.mUserID = str2;
        this.mTimeStamp = j;
        this.mResumeRoute = i;
    }

    public VideoDraftBean() {
    }

    public String getDraftName() {
        return this.mDraftName;
    }

    public void setDraftName(String str) {
        this.mDraftName = str;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public String getVideoTempData() {
        return this.mVideoTempData;
    }

    public void setVideoTempData(String str) {
        this.mVideoTempData = str;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
    }

    public String getMusicData() {
        return this.mMusicData;
    }

    public void setMusicData(String str) {
        this.mMusicData = str;
    }

    public String getMainTitle() {
        return this.mMainTitle;
    }

    public void setMainTitle(String str) {
        this.mMainTitle = str;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public String getTopicData() {
        return this.mTopicData;
    }

    public void setTopicData(String str) {
        this.mTopicData = str;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getResumeRoute() {
        return this.mResumeRoute;
    }

    public void setResumeRoute(int i) {
        this.mResumeRoute = i;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setDraftSelected(boolean z) {
        this.mSelected = z;
    }

    public boolean getDraftSelectedStatus() {
        return this.mSelected;
    }

    public void setBackUpType(int i) {
        this.mBackUpType = i;
    }

    public int getBackupType() {
        return this.mBackUpType;
    }

    public int getResumePage() {
        return this.mResumePage;
    }

    public void setResumePage(int i) {
        this.mResumePage = i;
    }

    public String getEffectData() {
        return this.mEffectData;
    }

    public void setEffectData(String str) {
        this.mEffectData = str;
    }

    public String getCoverPath() {
        return this.mCoverPath;
    }

    public void setCoverPath(String str) {
        this.mCoverPath = str;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public void setLocation(String str) {
        this.mLocation = str;
    }

    public String getPreProcessVideoPath() {
        return this.mPreProcessVideoPath;
    }

    public void setPreProcessVideoPath(String str) {
        this.mPreProcessVideoPath = str;
    }

    public String getFollowData() {
        return this.mFollowData;
    }

    public void setFollowData(String str) {
        this.mFollowData = str;
    }

    public float getOriginMusicVolume() {
        return this.mOriginMusicVolume;
    }

    public void setOriginMusicVolume(float f) {
        this.mOriginMusicVolume = f;
    }

    public String getFilterValue() {
        return this.mFilterValue;
    }

    public void setFilterValue(String str) {
        this.mFilterValue = str;
    }

    public String getLocalAlbumData() {
        return this.mLocalAlbumData;
    }

    public void setLocalAlbumData(String str) {
        this.mLocalAlbumData = str;
    }

    public String getLocalAlbumThemeData() {
        return this.mLocalAlbumThemeData;
    }

    public void setLocalAlbumThemeData(String str) {
        this.mLocalAlbumThemeData = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull VideoDraftBean videoDraftBean) {
        if (videoDraftBean == null) {
            return -1;
        }
        if (this.mTimeStamp > videoDraftBean.mTimeStamp) {
            return 1;
        }
        return this.mTimeStamp >= videoDraftBean.mTimeStamp ? 0 : -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public VideoDraftBean m17clone() {
        try {
            return (VideoDraftBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int hashCode() {
        return this.mDraftName.hashCode() + (this.mMusicData.hashCode() * 31) + (this.mVideoTempData.hashCode() * 31);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
        if (this.mDraftName.equals(videoDraftBean.getDraftName())) {
            if ((this.mVideoTempData == null || videoDraftBean.getVideoTempData() == null || !this.mVideoTempData.equals(videoDraftBean.getVideoTempData())) && this.mResumeRoute != 1) {
                return false;
            }
            if (this.mMusicData == null || videoDraftBean.getMusicData() == null) {
                return this.mMusicData == null && videoDraftBean.getMusicData() == null;
            }
            int indexOf = this.mMusicData.indexOf("sk");
            return this.mMusicData.substring(indexOf).equals(videoDraftBean.getMusicData().substring(indexOf));
        }
        return false;
    }

    public boolean equalsMusic(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoDraftBean videoDraftBean = (VideoDraftBean) obj;
        if (this.mDraftName.equals(videoDraftBean.getDraftName())) {
            if (this.mMusicData == null || videoDraftBean.getMusicData() == null) {
                return this.mMusicData == null && videoDraftBean.getMusicData() == null;
            }
            int indexOf = this.mMusicData.indexOf("sk");
            if (indexOf == -1 || indexOf >= videoDraftBean.getMusicData().length()) {
                return false;
            }
            String substring = this.mMusicData.substring(indexOf);
            if (indexOf >= videoDraftBean.getMusicData().length()) {
                return false;
            }
            return substring.equals(videoDraftBean.getMusicData().substring(indexOf));
        }
        return false;
    }
}
