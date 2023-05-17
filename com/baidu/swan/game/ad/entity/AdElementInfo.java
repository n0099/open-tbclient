package com.baidu.swan.game.ad.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdElementInfo implements Parcelable {
    public static final int ACTION_TYPE_DOWNLOAD = 2;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int CLOSE_TYPE_TO_NEW_STRATEGY = 6;
    public static final Parcelable.Creator<AdElementInfo> CREATOR = new a();
    public static final String TAG = "AdElementInfo";
    public long createTime;
    public int mActionType;
    public String mAdId;
    public JSONObject mAdJsonObject;
    public JSONObject mAdMonitors;
    public int mAntiTag;
    public String mApkName;
    public String mAppName;
    public long mAppSize;
    public String mBannerHtml;
    public String mClickUrl;
    public Set<String> mCloseTrackers;
    public int mCloseType;
    public Set<String> mConversionUrls;
    public String mDescription;
    public int mDuration;
    public String mEndFrameHtml;
    public String mEndFrameUrl;
    public int mExpire;
    public String mFallback;
    public String mFbAct;
    public boolean mGdtAd;
    public String mIconUrl;
    public Set<String> mImpressionUrls;
    public String mLandBannerHtml;
    public Set<String> mMonitorClickers;
    public String mPackageName;
    public String mPage;
    public String mPermissionUrl;
    public String mPictureUrl;
    public String mPrivacyUrl;
    public String mQueryKey;
    public int mRewardTime;
    public int mRewardTimeDefault;
    public int mSkipTime;
    public int mSkipTimeDefault;
    public Set<String> mSkipTrackers;
    public Set<String> mStartTrackers;
    public Set<String> mThirdClickMonitorTrackers;
    public Set<String> mThirdImpMonitorTrackers;
    public String mTitle;
    public String mType;
    public String mUniqueId;
    public String mVersion;
    public int mVideoHeight;
    public String mVideoUrl;
    public int mVideoWidth;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActionType() {
        return this.mActionType;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public JSONObject getAdJsonObject() {
        return this.mAdJsonObject;
    }

    public JSONObject getAdMonitors() {
        return this.mAdMonitors;
    }

    public int getAntiTag() {
        return this.mAntiTag;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public long getAppSize() {
        return this.mAppSize;
    }

    public String getBannerHtml() {
        return this.mBannerHtml;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.mCloseTrackers);
    }

    public int getCloseType() {
        return this.mCloseType;
    }

    public List<String> getConversionUrls() {
        return new ArrayList(this.mConversionUrls);
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getEndFrameHtml() {
        return this.mEndFrameHtml;
    }

    public String getEndFrameUrl() {
        return this.mEndFrameUrl;
    }

    public int getExpired() {
        return this.mExpire;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public List<String> getImpressionUrls() {
        return new ArrayList(this.mImpressionUrls);
    }

    public String getLandBannerHtml() {
        return this.mLandBannerHtml;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getPermissionUrl() {
        return this.mPermissionUrl;
    }

    public String getPictureUrl() {
        return this.mPictureUrl;
    }

    public String getPrivacyUrl() {
        return this.mPrivacyUrl;
    }

    public String getQueryKey() {
        return this.mQueryKey;
    }

    public int getRewardTime() {
        if (getCloseType() == 6) {
            return this.mRewardTime;
        }
        return this.mRewardTimeDefault;
    }

    public int getSkipTime() {
        if (getCloseType() == 6) {
            return this.mSkipTime;
        }
        return this.mSkipTimeDefault;
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.mSkipTrackers);
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.mStartTrackers);
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.mThirdClickMonitorTrackers);
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.mThirdImpMonitorTrackers);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getType() {
        return this.mType;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isGdtAd() {
        return this.mGdtAd;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<AdElementInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdElementInfo createFromParcel(Parcel parcel) {
            return new AdElementInfo(parcel, (a) null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdElementInfo[] newArray(int i) {
            return new AdElementInfo[i];
        }
    }

    public AdElementInfo(Parcel parcel) {
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mQueryKey = parcel.readString();
        this.mAdId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mIconUrl = parcel.readString();
        this.mType = parcel.readString();
        this.mActionType = parcel.readInt();
        this.mAntiTag = parcel.readInt();
        this.mClickUrl = parcel.readString();
        this.mPictureUrl = parcel.readString();
        this.mVideoUrl = parcel.readString();
        this.mVideoWidth = parcel.readInt();
        this.mVideoHeight = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mCloseType = parcel.readInt();
        this.mExpire = parcel.readInt();
        this.mAppName = parcel.readString();
        this.mPackageName = parcel.readString();
        this.mApkName = parcel.readString();
        this.mAppSize = parcel.readLong();
        this.mPage = parcel.readString();
        this.mVersion = parcel.readString();
        this.mFallback = parcel.readString();
        this.mFbAct = parcel.readString();
        this.mRewardTime = parcel.readInt();
        this.mSkipTime = parcel.readInt();
    }

    public /* synthetic */ AdElementInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @SuppressLint({"DefaultLocale"})
    public AdElementInfo(JSONObject jSONObject) {
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mAdJsonObject = jSONObject;
        try {
            this.createTime = System.currentTimeMillis();
            this.mQueryKey = jSONObject.optString("qk", "");
            this.mAdId = jSONObject.optString("id", "-1");
            String optString = jSONObject.optString("winurl", "");
            if (!TextUtils.isEmpty(optString)) {
                this.mImpressionUrls.add(optString);
            }
            this.mTitle = jSONObject.optString("tit", "");
            this.mDescription = jSONObject.optString("desc", "");
            this.mIconUrl = jSONObject.optString("icon", "");
            this.mType = jSONObject.optString("type");
            this.mActionType = jSONObject.optInt("act");
            this.mAntiTag = jSONObject.optInt("anti_tag");
            this.mClickUrl = jSONObject.optString("curl", "");
            this.mPictureUrl = jSONObject.optString("w_picurl", "");
            this.mVideoUrl = jSONObject.optString("vurl", "");
            this.mPrivacyUrl = jSONObject.optString("privacy_link", "");
            this.mPermissionUrl = jSONObject.optString("permission_link", "");
            this.mVideoWidth = jSONObject.optInt("w", 0);
            this.mVideoHeight = jSONObject.optInt("h", 0);
            this.mDuration = jSONObject.optInt("duration", 0);
            this.mCloseType = jSONObject.optInt("closetype", 0);
            this.mExpire = jSONObject.optInt("expiration", 0);
            this.mRewardTime = jSONObject.optInt("rewardtime", this.mRewardTimeDefault);
            this.mSkipTime = jSONObject.optInt("skiptime", this.mSkipTimeDefault);
            this.mEndFrameUrl = jSONObject.optString("end_frame", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            this.mAdMonitors = optJSONObject;
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("s")) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            addThirdImpMonitorTrackers(optJSONArray.optString(i));
                        }
                    } else if (next.equals("vskip")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i2));
                        }
                    } else if (next.equals("vstart")) {
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray(next);
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            addStartMonitorTrackers(optJSONArray3.optString(i3));
                        }
                    } else if (next.equals("vclose")) {
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(next);
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            addCloseMonitorTrackers(optJSONArray4.optString(i4));
                        }
                    } else if (next.equals("click")) {
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(next);
                        for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                            addMonitorClickTrackers(optJSONArray5.optString(i5));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            addThirdClickMonitorTrackers(optJSONArray6.optString(i6));
                        }
                    }
                }
            }
            this.mAppName = jSONObject.optString("appname", "");
            this.mPackageName = jSONObject.optString(PushConstants.URI_PACKAGE_NAME, "");
            this.mApkName = jSONObject.optString("apk_name", "");
            this.mAppSize = jSONObject.optLong("sz", 0L);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ad_html");
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2.equals("banner_snippet")) {
                        this.mBannerHtml = optJSONObject2.optString(next2);
                    } else if (next2.equals("int_snippet")) {
                        this.mEndFrameHtml = optJSONObject2.optString(next2);
                    } else if (next2.equals("banner_land_snippet")) {
                        this.mLandBannerHtml = optJSONObject2.optString(next2);
                    }
                }
            }
            if (jSONObject.optJSONObject("apo") != null) {
                this.mPage = jSONObject.optString("page", "");
                this.mVersion = jSONObject.optString("version", "");
                this.mFallback = jSONObject.optString("fallback", "");
                this.mFbAct = jSONObject.optString("fb_act", "");
            }
            this.mUniqueId = this.mQueryKey + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.mGdtAd = false;
        } catch (Exception unused) {
        }
    }

    public AdElementInfo(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        this.mAdId = "-1";
        this.mImpressionUrls = new HashSet();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mMonitorClickers = new HashSet();
        this.mRewardTimeDefault = 15;
        this.mSkipTimeDefault = 5;
        this.mConversionUrls = new HashSet();
        this.mAdJsonObject = jSONObject;
        try {
            this.mGdtAd = true;
            this.mAdId = jSONObject.optString("adid", "-1");
            this.mIconUrl = jSONObject.optString("icon_url", "");
            this.mTitle = jSONObject.optString("title", "");
            this.mDescription = jSONObject.optString("description", "");
            this.mAppName = jSONObject.optString("app_name", "");
            this.mPackageName = jSONObject.optString("app_bundle", "");
            this.mActionType = jSONObject.optInt("interact_type") + 1;
            this.mClickUrl = jSONObject.optString("target_url");
            this.createTime = System.currentTimeMillis();
            if (jSONObject.has("images") && (optJSONArray = jSONObject.optJSONArray("images")) != null && optJSONArray.length() > 0 && (optJSONObject2 = optJSONArray.optJSONObject(0)) != null) {
                this.mPictureUrl = optJSONObject2.optString("url", "");
            }
            if (jSONObject.has("video") && (optJSONObject = jSONObject.optJSONObject("video")) != null) {
                this.mVideoUrl = optJSONObject.optString("url", "");
                this.mVideoWidth = optJSONObject.optInt("width", 0);
                this.mVideoHeight = optJSONObject.optInt("height", 0);
                this.mDuration = optJSONObject.optInt("duration", 0);
            }
            if (jSONObject.has("imp_urls")) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("imp_urls");
                for (int i = 0; optJSONArray2 != null && i < optJSONArray2.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i))) {
                        this.mImpressionUrls.add(optJSONArray2.optString(i));
                    }
                }
            }
            if (jSONObject.has("click_urls")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("click_urls");
                for (int i2 = 0; optJSONArray3 != null && i2 < optJSONArray3.length(); i2++) {
                    addThirdClickMonitorTrackers(optJSONArray3.optString(i2));
                }
            }
            if (jSONObject.has("video_play_urls")) {
                JSONArray optJSONArray4 = jSONObject.optJSONArray("video_play_urls");
                for (int i3 = 0; optJSONArray4 != null && i3 < optJSONArray4.length(); i3++) {
                    addCloseMonitorTrackers(optJSONArray4.optString(i3));
                }
            }
            if (jSONObject.has("conversion_urls")) {
                JSONArray optJSONArray5 = jSONObject.optJSONArray("conversion_urls");
                for (int i4 = 0; optJSONArray5 != null && i4 < optJSONArray5.length(); i4++) {
                    addConversionUrls(optJSONArray5.optString(i4));
                }
            }
            this.mExpire = jSONObject.optInt("expiration", 0);
            this.mUniqueId = this.mAdId + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception unused) {
        }
    }

    private void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.mCloseTrackers.add(str);
        }
    }

    private void addConversionUrls(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mConversionUrls.add(str);
        }
    }

    private void addMonitorClickTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.mMonitorClickers.add(str);
        }
    }

    private void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSkipTrackers.add(str);
        }
    }

    private void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mStartTrackers.add(str);
        }
    }

    private void addThirdClickMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mThirdClickMonitorTrackers.add(str);
        }
    }

    private void addThirdImpMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mThirdImpMonitorTrackers.add(str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mQueryKey);
        parcel.writeString(this.mAdId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mIconUrl);
        parcel.writeString(this.mType);
        parcel.writeInt(this.mActionType);
        parcel.writeInt(this.mAntiTag);
        parcel.writeString(this.mClickUrl);
        parcel.writeString(this.mPictureUrl);
        parcel.writeString(this.mVideoUrl);
        parcel.writeInt(this.mVideoWidth);
        parcel.writeInt(this.mVideoHeight);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mCloseType);
        parcel.writeInt(this.mExpire);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mApkName);
        parcel.writeLong(this.mAppSize);
        parcel.writeString(this.mPage);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mFallback);
        parcel.writeString(this.mFbAct);
        parcel.writeInt(this.mRewardTime);
        parcel.writeInt(this.mSkipTime);
    }
}
