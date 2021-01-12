package com.baidu.swan.game.ad.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class AdElementInfo implements Parcelable {
    public static final int ACTION_TYPE_DOWNLOAD = 2;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int CLOSE_TYPE_TO_NEW_STRATEGY = 6;
    public static final Parcelable.Creator<AdElementInfo> CREATOR = new Parcelable.Creator<AdElementInfo>() { // from class: com.baidu.swan.game.ad.entity.AdElementInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: C */
        public AdElementInfo createFromParcel(Parcel parcel) {
            return new AdElementInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: kJ */
        public AdElementInfo[] newArray(int i) {
            return new AdElementInfo[i];
        }
    };
    public static final String TAG = "AdElementInfo";
    private long createTime;
    private int mActionType;
    private String mAdId;
    private JSONObject mAdJsonObject;
    private JSONObject mAdMonitors;
    private int mAntiTag;
    private String mApkName;
    private String mAppName;
    private long mAppSize;
    private String mBannerHtml;
    private String mClickUrl;
    private Set<String> mCloseTrackers;
    private int mCloseType;
    private Set<String> mConversionUrls;
    private String mDescription;
    private int mDuration;
    private String mEndFrameHtml;
    private String mEndFrameUrl;
    private int mExpire;
    private String mFallback;
    private String mFbAct;
    private boolean mGdtAd;
    private String mIconUrl;
    private Set<String> mImpressionUrls;
    private String mLandBannerHtml;
    private Set<String> mMonitorClickers;
    private String mPackageName;
    private String mPage;
    private String mPictureUrl;
    private String mQueryKey;
    private int mRewardTime;
    private int mRewardTimeDefault;
    private int mSkipTime;
    private int mSkipTimeDefault;
    private Set<String> mSkipTrackers;
    private Set<String> mStartTrackers;
    private Set<String> mThirdClickMonitorTrackers;
    private Set<String> mThirdImpMonitorTrackers;
    private String mTitle;
    private String mType;
    private String mUniqueId;
    private String mVersion;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;

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
            this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
            this.mType = jSONObject.optString("type");
            this.mActionType = jSONObject.optInt("act");
            this.mAntiTag = jSONObject.optInt("anti_tag");
            this.mClickUrl = jSONObject.optString("curl", "");
            this.mPictureUrl = jSONObject.optString("w_picurl", "");
            this.mVideoUrl = jSONObject.optString("vurl", "");
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
                            uO(optJSONArray.optString(i));
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
                            uQ(optJSONArray5.optString(i5));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            uP(optJSONArray6.optString(i6));
                        }
                    }
                }
            }
            this.mAppName = jSONObject.optString("appname", "");
            this.mPackageName = jSONObject.optString("pk", "");
            this.mApkName = jSONObject.optString(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, "");
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
            this.mUniqueId = this.mQueryKey + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.mGdtAd = false;
        } catch (Exception e) {
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
            if (jSONObject.has(TbConfig.IMAGE_CACHE_DIR_NAME) && (optJSONArray = jSONObject.optJSONArray(TbConfig.IMAGE_CACHE_DIR_NAME)) != null && optJSONArray.length() > 0 && (optJSONObject2 = optJSONArray.optJSONObject(0)) != null) {
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
                    uP(optJSONArray3.optString(i2));
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
                    uR(optJSONArray5.optString(i4));
                }
            }
            this.mExpire = jSONObject.optInt("expiration", 0);
            this.mUniqueId = this.mAdId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception e) {
        }
    }

    private AdElementInfo(Parcel parcel) {
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

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String aRx() {
        return this.mPictureUrl;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int aRy() {
        return aRB() == 6 ? this.mRewardTime : this.mRewardTimeDefault;
    }

    public int aRz() {
        return aRB() == 6 ? this.mSkipTime : this.mSkipTimeDefault;
    }

    public String aRA() {
        return this.mEndFrameUrl;
    }

    public int aRB() {
        return this.mCloseType;
    }

    public String aRC() {
        return this.mClickUrl;
    }

    public int getActionType() {
        return this.mActionType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int aRD() {
        return this.mExpire;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public String aRE() {
        return this.mBannerHtml;
    }

    public String aRF() {
        return this.mLandBannerHtml;
    }

    public String aRG() {
        return this.mEndFrameHtml;
    }

    public List<String> aRH() {
        return new ArrayList(this.mImpressionUrls);
    }

    public JSONObject aRI() {
        return this.mAdMonitors;
    }

    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.mThirdImpMonitorTrackers);
    }

    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.mThirdClickMonitorTrackers);
    }

    public List<String> getStartTrackers() {
        return new ArrayList(this.mStartTrackers);
    }

    public List<String> getSkipTrackers() {
        return new ArrayList(this.mSkipTrackers);
    }

    public List<String> getCloseTrackers() {
        return new ArrayList(this.mCloseTrackers);
    }

    public List<String> aRJ() {
        return new ArrayList(this.mConversionUrls);
    }

    private void uO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mThirdImpMonitorTrackers.add(str);
        }
    }

    private void uP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mThirdClickMonitorTrackers.add(str);
        }
    }

    private void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mStartTrackers.add(str);
        }
    }

    private void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSkipTrackers.add(str);
        }
    }

    private void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.mCloseTrackers.add(str);
        }
    }

    private void uQ(String str) {
        if (str != null && !str.equals("")) {
            this.mMonitorClickers.add(str);
        }
    }

    private void uR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mConversionUrls.add(str);
        }
    }

    public boolean aRK() {
        return this.mGdtAd;
    }
}
