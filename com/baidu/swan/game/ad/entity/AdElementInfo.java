package com.baidu.swan.game.ad.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AdElementInfo implements Parcelable {
    public static final Parcelable.Creator<AdElementInfo> CREATOR = new Parcelable.Creator<AdElementInfo>() { // from class: com.baidu.swan.game.ad.entity.AdElementInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: F */
        public AdElementInfo createFromParcel(Parcel parcel) {
            return new AdElementInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: hC */
        public AdElementInfo[] newArray(int i) {
            return new AdElementInfo[i];
        }
    };
    public static final String TAG = "AdElementInfo";
    private long createTime;
    private int mActionType;
    private String mAdId;
    private JSONObject mAdJsonObject;
    private int mAntiTag;
    private String mApkName;
    private String mAppName;
    private long mAppSize;
    private String mBannerHtml;
    private String mClickUrl;
    private Set<String> mCloseTrackers;
    private int mCloseType;
    private String mDescription;
    private int mDuration;
    private String mEndFrameHtml;
    private int mExpire;
    private String mFallback;
    private String mFbAct;
    private String mIconUrl;
    private Set<String> mImpressionUrls;
    private Set<String> mMonitorClickers;
    private String mPackageName;
    private String mPage;
    private String mPictureUrl;
    private String mQueryKey;
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
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("s")) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            nE(optJSONArray.optString(i));
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
                            nG(optJSONArray5.optString(i5));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            nF(optJSONArray6.optString(i6));
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
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getPictureUrl() {
        return this.mPictureUrl;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public String ako() {
        return this.mClickUrl;
    }

    public int getActionType() {
        return this.mActionType;
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

    public int akp() {
        return this.mExpire;
    }

    public String akq() {
        return this.mBannerHtml;
    }

    public String akr() {
        return this.mEndFrameHtml;
    }

    public List<String> aks() {
        return new ArrayList(this.mImpressionUrls);
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

    private void nE(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mThirdImpMonitorTrackers.add(str);
        }
    }

    private void nF(String str) {
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

    private void nG(String str) {
        if (str != null && !str.equals("")) {
            this.mMonitorClickers.add(str);
        }
    }
}
