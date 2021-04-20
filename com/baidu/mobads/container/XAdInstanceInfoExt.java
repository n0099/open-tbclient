package com.baidu.mobads.container;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdInstanceInfoExt implements IXAdInstanceInfo, Cloneable, Parcelable {
    public static final Parcelable.Creator<XAdInstanceInfoExt> CREATOR = new Parcelable.Creator<XAdInstanceInfoExt>() { // from class: com.baidu.mobads.container.XAdInstanceInfoExt.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdInstanceInfoExt createFromParcel(Parcel parcel) {
            return new XAdInstanceInfoExt(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdInstanceInfoExt[] newArray(int i) {
            return new XAdInstanceInfoExt[i];
        }
    };
    public static final String TAG = "XAdInstanceInfo";
    public String action;
    public boolean actionOnlyWifi;
    public int actionType;
    public String adId;
    public String adSource;
    public int antiTag;
    public String appName;
    public String appOpenStrs;
    public String appPackageName;
    public long appSize;
    public boolean autoOpen;
    public String bannerHtmlSnippet;
    public boolean canCancel;
    public boolean canDelete;
    public String clickThroughUrl;
    public String clklogurl;
    public boolean close;
    public int closeType;
    public String confirmBorderPercent;
    public long createTime;
    public IXAdInstanceInfo.CreativeType creativeType;
    public String description;
    public int dlTunnel;
    public String exp2ForSingleAd;
    public int expiration;
    public String fwt;
    @Deprecated
    public int hoursInADayToShowAd;
    public String htmlSnippet;
    public String iconUrl;
    @Deprecated
    public boolean iconVisibleForImageType;
    public Set<String> impressionUrls;
    public boolean inapp;
    public String intHtmlSnippet;
    public boolean isTooLarge;
    public boolean isVideoMuted;
    public boolean isWifiTargeted;
    public String localCreativeUrl;
    public boolean mAPOOpen;
    public int mAdContainerHeight;
    public int mAdContainerSizeType;
    public int mAdContainerWidth;
    public String mAsl;
    public String mBuyer;
    public Set<String> mCacheExpireTrackers;
    public Set<String> mCacheFailTrackers;
    public Set<String> mCacheSuccTrackers;
    public Set<String> mCcardTrackers;
    public Set<String> mCloseTrackers;
    public Set<String> mCstartcardTrackers;
    public JSONObject mExtraParams;
    public int mFeedAdStyleType;
    public Set<String> mFullScreenTrackers;
    public boolean mHasDisplay;
    public int mNoticeDlNonWifi;
    public int mNoticeDlNonWifiSecJump;
    public String mPage;
    public Set<String> mScardTrackers;
    public Set<String> mSkipTrackers;
    public Set<String> mStartTrackers;
    public Set<String> mThirdClickMonitorTrackers;
    public Set<String> mThirdImpMonitorTrackers;
    public int mainMaterialHeight;
    public int mainMaterialWidth;
    public String mainPictureUrl;
    public String materialType;
    public String mute;
    public JSONArray nwinurl;
    public String originClickUrl;
    public JSONObject originJsonObject;
    @Deprecated
    public String phoneForLocalBranding;
    public int pointsForWall;
    public boolean popNotif;
    public String queryKey;
    public boolean sencondConfirmed;
    public String splash3dLocalResUrl;
    public String sponsorUrl;
    public int switchButton;
    public boolean taskDoneForWall;
    public String title;
    public String uniqueId;
    public String url;
    public int videoDuration;
    public int videoHeight;
    public String videoUrl;
    public int videoWidth;
    public String vurl;
    public String webUrl;
    public String winurl;

    public final void addCacheExpireMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheExpireTrackers.add(str);
    }

    public final void addCacheFailMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheFailTrackers.add(str);
    }

    public final void addCacheSuccMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheSuccTrackers.add(str);
    }

    public void addCcardMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCcardTrackers.add(str);
    }

    public void addCloseMonitorTrackers(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.mCloseTrackers.add(str);
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.mCstartcardTrackers.add(str);
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        this.mFullScreenTrackers.add(str);
    }

    public void addScardMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mScardTrackers.add(str);
    }

    public void addSkipMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSkipTrackers.add(str);
    }

    public void addStartMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mStartTrackers.add(str);
    }

    public final void addThirdClickMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdClickMonitorTrackers.add(str);
    }

    public final void addThirdImpMonitorTrackers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdImpMonitorTrackers.add(str);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean getAPOOpen() {
        return this.mAPOOpen;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAction() {
        return this.action;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getActionType() {
        return this.actionType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerHeight() {
        return this.mAdContainerHeight;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerSizeType() {
        return this.mAdContainerSizeType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerWidth() {
        return this.mAdContainerWidth;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean getAdHasDisplayed() {
        return this.mHasDisplay;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAdId() {
        return this.adId;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAdSource() {
        return this.adSource;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAntiTag() {
        return this.antiTag;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppOpenStrs() {
        return this.appOpenStrs;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppPackageName() {
        return this.appPackageName;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppStoreLink() {
        return this.mAsl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getBannerHtmlSnippet() {
        return this.bannerHtmlSnippet;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getBuyer() {
        return this.mBuyer;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheExpireTrackers() {
        return new ArrayList(this.mCacheExpireTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheFailTrackers() {
        return new ArrayList(this.mCacheFailTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheSuccTrackers() {
        return new ArrayList(this.mCacheSuccTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCcardTrackers() {
        return new ArrayList(this.mCcardTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getClklogurl() {
        return this.clklogurl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCloseTrackers() {
        return new ArrayList(this.mCloseTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getCloseType() {
        return this.closeType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getConfirmBorderPercent() {
        return this.confirmBorderPercent;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public IXAdInstanceInfo.CreativeType getCreativeType() {
        return this.creativeType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCstartcardTrackers() {
        return new ArrayList(this.mCstartcardTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getDescription() {
        return this.description;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getDlTunnel() {
        return this.dlTunnel;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getExp2ForSingleAd() {
        return this.exp2ForSingleAd;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getExpiration() {
        return this.expiration;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONObject getExtraParams() {
        return this.mExtraParams;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getFeedAdStyleType() {
        return this.mFeedAdStyleType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getFullScreenTrackers() {
        return new ArrayList(this.mFullScreenTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getFwt() {
        return this.fwt;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getHoursInADayToShowAd() {
        return this.hoursInADayToShowAd;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getHtmlSnippet() {
        return this.htmlSnippet;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public Set<String> getImpressionUrls() {
        return this.impressionUrls;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getIntHtmlSnippet() {
        return this.intHtmlSnippet;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getLocalCreativeURL() {
        return this.localCreativeUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getMainMaterialHeight() {
        return this.mainMaterialHeight;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getMainMaterialWidth() {
        return this.mainMaterialWidth;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMainPictureUrl() {
        return this.mainPictureUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMaterialType() {
        return this.materialType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMute() {
        return this.mute;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONArray getNwinurl() {
        return this.nwinurl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getOriginClickUrl() {
        return this.originClickUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONObject getOriginJsonObject() {
        return this.originJsonObject;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getPage() {
        return this.mPage;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getPhoneForLocalBranding() {
        return this.phoneForLocalBranding;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getPointsForWall() {
        return this.pointsForWall;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getQueryKey() {
        return this.queryKey;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getScardTrackers() {
        return new ArrayList(this.mScardTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getSkipTrackers() {
        return new ArrayList(this.mSkipTrackers);
    }

    public String getSplash3DLocalUrl() {
        return this.splash3dLocalResUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getSponsorUrl() {
        return this.sponsorUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getStartTrackers() {
        return new ArrayList(this.mStartTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getSwitchButton() {
        return this.switchButton;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.mThirdClickMonitorTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.mThirdImpMonitorTrackers);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getUrl() {
        return this.url;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoHeight() {
        return this.videoHeight;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoWidth() {
        return this.videoWidth;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getVurl() {
        return this.vurl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getWebUrl() {
        return this.webUrl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getWinurl() {
        return this.winurl;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isActionOnlyWifi() {
        return this.actionOnlyWifi;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isAutoOpen() {
        return this.autoOpen;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isCanCancel() {
        return this.canCancel;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isCanDelete() {
        return this.canDelete;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isClose() {
        return this.close;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isIconVisibleForImageType() {
        return this.iconVisibleForImageType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isInapp() {
        return this.inapp;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isNoticeDlNonWifi() {
        return this.mNoticeDlNonWifi == 1;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isNoticeDlNonWifiSecJump() {
        return this.mNoticeDlNonWifiSecJump == 1;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isPopNotif() {
        return this.popNotif;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isSecondConfirmed() {
        return this.sencondConfirmed;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isTaskDoneForWall() {
        return this.taskDoneForWall;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isTooLarge() {
        return this.isTooLarge;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public Boolean isValid() {
        return Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId()));
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isVideoMuted() {
        return this.isVideoMuted;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isWifiTargeted() {
        return this.isWifiTargeted;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAPOOpen(boolean z) {
        this.mAPOOpen = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAction(String str) {
        this.action = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setActionOnlyWifi(boolean z) {
        this.actionOnlyWifi = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setActionType(int i) {
        this.actionType = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerHeight(int i) {
        this.mAdContainerHeight = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerSizeType(int i) {
        this.mAdContainerSizeType = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerWidth(int i) {
        this.mAdContainerWidth = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdHasDisplayed(boolean z) {
        this.mHasDisplay = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdId(String str) {
        this.adId = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdSource(String str) {
        this.adSource = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAntiTag(int i) {
        this.antiTag = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppName(String str) {
        this.appName = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppOpenStrs(String str) {
        this.appOpenStrs = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppSize(long j) {
        this.appSize = j;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAutoOpen(boolean z) {
        this.autoOpen = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setBannerHtmlSnippet(String str) {
        this.bannerHtmlSnippet = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setBuyer(String str) {
        this.mBuyer = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheExpireTrackers(List<String> list) {
        try {
            this.mCacheExpireTrackers.clear();
            this.mCacheExpireTrackers.addAll(list);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheFailTrackers(List<String> list) {
        try {
            this.mCacheFailTrackers.clear();
            this.mCacheFailTrackers.addAll(list);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheSuccTrackers(List<String> list) {
        try {
            this.mCacheSuccTrackers.clear();
            this.mCacheSuccTrackers.addAll(list);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCanCancel(boolean z) {
        this.canCancel = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCanDelete(boolean z) {
        this.canDelete = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCcardTrackers(List<String> list) {
        this.mCcardTrackers.addAll(list);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClklogurl(String str) {
        this.clklogurl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClose(boolean z) {
        this.close = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCloseTrackers(List<String> list) {
        try {
            this.mCloseTrackers.clear();
            this.mCloseTrackers.addAll(list);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCloseType(int i) {
        this.closeType = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setConfirmBorderPercent(String str) {
        this.confirmBorderPercent = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCreateTime(long j) {
        this.createTime = j;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCreativeType(IXAdInstanceInfo.CreativeType creativeType) {
        this.creativeType = creativeType;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCstartcardTrackers(List<String> list) {
        this.mCstartcardTrackers.clear();
        this.mCstartcardTrackers.addAll(list);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setDlTunnel(int i) {
        this.dlTunnel = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setExp2ForSingleAd(String str) {
        this.exp2ForSingleAd = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setExpiration(int i) {
        this.expiration = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFeedAdStyleType(int i) {
        this.mFeedAdStyleType = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFullScreenTrackers(List<String> list) {
        this.mFullScreenTrackers.addAll(list);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFwt(String str) {
        this.fwt = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setHoursInADayToShowAd(int i) {
        this.hoursInADayToShowAd = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setHtmlSnippet(String str) {
        this.htmlSnippet = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIconVisibleForImageType(boolean z) {
        this.iconVisibleForImageType = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setImpressionUrls(Set<String> set) {
        this.impressionUrls = set;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setInapp(boolean z) {
        this.inapp = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIntHtmlSnippet(String str) {
        this.intHtmlSnippet = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setLocalCreativeURL(String str) {
        this.localCreativeUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainMaterialHeight(int i) {
        this.mainMaterialHeight = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainMaterialWidth(int i) {
        this.mainMaterialWidth = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainPictureUrl(String str) {
        this.mainPictureUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMaterialType(String str) {
        this.materialType = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMute(String str) {
        this.mute = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setNwinurl(JSONArray jSONArray) {
        this.nwinurl = jSONArray;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setOriginClickUrl(String str) {
        this.originClickUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPage(String str) {
        this.mPage = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPhoneForLocalBranding(String str) {
        this.phoneForLocalBranding = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPointsForWall(int i) {
        this.pointsForWall = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPopNotif(boolean z) {
        this.popNotif = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setQueryKey(String str) {
        this.queryKey = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setScardTrackers(List<String> list) {
        this.mScardTrackers.addAll(list);
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSecondConfirmed(boolean z) {
        this.sencondConfirmed = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSkipTrackers(List<String> list) {
        this.mSkipTrackers.addAll(list);
    }

    public void setSplash3DLocalUrl(String str) {
        this.splash3dLocalResUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSponsorUrl(String str) {
        this.sponsorUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setStartTrackers(List<String> list) {
        try {
            this.mStartTrackers.clear();
            this.mStartTrackers.addAll(list);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSwitchButton(int i) {
        this.switchButton = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTaskDoneForWall(boolean z) {
        this.taskDoneForWall = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setThirdClickTrackingUrls(Set<String> set) {
        this.mThirdClickMonitorTrackers = set;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setThirdImpressionTrackingUrls(Set<String> set) {
        this.mThirdImpMonitorTrackers = set;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTooLarge(boolean z) {
        this.isTooLarge = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoMuted(boolean z) {
        this.isVideoMuted = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVurl(String str) {
        this.vurl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWifiTargeted(boolean z) {
        this.isWifiTargeted = z;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWinurl(String str) {
        this.winurl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.adId);
        parcel.writeString(this.adSource);
        parcel.writeString(this.appName);
        parcel.writeString(this.appOpenStrs);
        parcel.writeString(this.appPackageName);
        parcel.writeString(this.clickThroughUrl);
        parcel.writeString(this.clklogurl);
        parcel.writeString(this.confirmBorderPercent);
        parcel.writeString(this.description);
        parcel.writeString(this.title);
        parcel.writeString(this.exp2ForSingleAd);
        parcel.writeString(this.fwt);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.mainPictureUrl);
        parcel.writeString(this.materialType);
        parcel.writeInt(this.mainMaterialHeight);
        parcel.writeInt(this.mainMaterialWidth);
        parcel.writeString(this.originClickUrl);
        parcel.writeString(this.phoneForLocalBranding);
        parcel.writeString(this.queryKey);
        parcel.writeString(this.sponsorUrl);
        parcel.writeString(this.url);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.videoDuration);
        parcel.writeString(this.vurl);
        parcel.writeString(this.winurl);
        parcel.writeString(this.action);
        parcel.writeString(this.webUrl);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeInt(this.closeType);
        parcel.writeInt(this.expiration);
        parcel.writeString(this.mute);
        parcel.writeStringList(getStartTrackers());
        parcel.writeStringList(getCloseTrackers());
        parcel.writeInt(this.actionType);
        parcel.writeInt(this.mAdContainerWidth);
        parcel.writeInt(this.mAdContainerHeight);
        parcel.writeInt(this.mAdContainerSizeType);
        parcel.writeInt(this.mFeedAdStyleType);
        parcel.writeString(this.mBuyer);
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.mNoticeDlNonWifi);
        parcel.writeInt(this.mNoticeDlNonWifiSecJump);
        JSONObject jSONObject = this.mExtraParams;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : "");
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfoExt(JSONObject jSONObject) {
        this.adId = "-1";
        this.action = "";
        this.webUrl = "";
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.impressionUrls = new HashSet();
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mScardTrackers = new HashSet();
        this.mCcardTrackers = new HashSet();
        this.mFullScreenTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mCstartcardTrackers = new HashSet();
        this.mCacheSuccTrackers = new HashSet();
        this.mCacheFailTrackers = new HashSet();
        this.mCacheExpireTrackers = new HashSet();
        this.actionOnlyWifi = true;
        this.creativeType = IXAdInstanceInfo.CreativeType.NONE;
        this.inapp = true;
        this.autoOpen = true;
        this.popNotif = true;
        this.sencondConfirmed = false;
        this.mNoticeDlNonWifi = 0;
        this.mNoticeDlNonWifiSecJump = 0;
        this.mAPOOpen = false;
        this.mPage = null;
        this.originJsonObject = jSONObject;
        try {
            this.createTime = System.currentTimeMillis();
            this.actionType = jSONObject.optInt("act");
            this.htmlSnippet = jSONObject.optString("html", null);
            this.adId = jSONObject.optString("id", "-1");
            this.adSource = jSONObject.optString(UserAccountActionItem.KEY_SRC, "");
            this.title = jSONObject.optString("tit", "");
            this.description = jSONObject.optString("desc", "");
            this.sponsorUrl = jSONObject.optString("surl", "");
            this.mainPictureUrl = jSONObject.optString("w_picurl", "");
            this.iconUrl = jSONObject.optString("icon", "");
            this.exp2ForSingleAd = jSONObject.optString("exp2", StringUtil.EMPTY_ARRAY);
            this.antiTag = jSONObject.optInt("anti_tag");
            this.mBuyer = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.BUYER, "");
            this.mNoticeDlNonWifi = jSONObject.optInt("notice_dl_non_wifi", 0);
            this.mNoticeDlNonWifiSecJump = jSONObject.optInt("notice_dl_non_wifi_sec_jump", 0);
            this.mAsl = jSONObject.optString("app_store_link", "");
            this.videoUrl = jSONObject.optString("vurl", "");
            this.videoDuration = jSONObject.optInt("duration", 0);
            this.isVideoMuted = jSONObject.optInt("sound", 0) != 1;
            this.iconVisibleForImageType = jSONObject.optInt("iv", 0) == 1;
            this.hoursInADayToShowAd = jSONObject.optInt("dur", 0);
            this.clickThroughUrl = jSONObject.optString("curl", "");
            this.originClickUrl = jSONObject.optString("ori_curl", "");
            this.closeType = jSONObject.optInt("closetype");
            this.expiration = jSONObject.optInt("expiration");
            this.mute = jSONObject.optString("mute");
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_html");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("banner_snippet")) {
                        this.bannerHtmlSnippet = optJSONObject.optString(next);
                    } else if (next.equals("int_snippet")) {
                        this.intHtmlSnippet = optJSONObject.optString(next);
                    }
                }
            }
            this.materialType = jSONObject.optString("type");
            if (this.htmlSnippet != null && this.htmlSnippet.length() > 0) {
                this.creativeType = IXAdInstanceInfo.CreativeType.HTML;
            } else if (this.materialType != null) {
                if (this.materialType.equals("text")) {
                    this.creativeType = IXAdInstanceInfo.CreativeType.TEXT;
                } else if (this.materialType.equals("image")) {
                    if (this.mainPictureUrl != null && !this.mainPictureUrl.equals("")) {
                        int lastIndexOf = this.mainPictureUrl.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        if ((lastIndexOf >= 0 ? this.mainPictureUrl.toLowerCase(Locale.getDefault()).substring(lastIndexOf) : "").equals(".gif")) {
                            this.creativeType = IXAdInstanceInfo.CreativeType.GIF;
                        } else {
                            this.creativeType = IXAdInstanceInfo.CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.materialType.equals("rm")) {
                    this.creativeType = IXAdInstanceInfo.CreativeType.RM;
                } else if (this.materialType.equals("video")) {
                    this.creativeType = IXAdInstanceInfo.CreativeType.VIDEO;
                }
            }
            this.mainMaterialWidth = jSONObject.optInt("w");
            this.mainMaterialHeight = jSONObject.optInt("h");
            this.phoneForLocalBranding = jSONObject.optString("lb_phone", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.impressionUrls.add(optJSONArray.getString(i));
                }
            } else {
                String optString = jSONObject.optString("winurl", "");
                if (!optString.equals("")) {
                    this.impressionUrls.add(optString);
                }
            }
            String optString2 = jSONObject.optString("clklogurl", "");
            if (!optString2.equals("")) {
                this.impressionUrls.add(optString2);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mon");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString3 = jSONObject2.optString("s", "");
                    String optString4 = jSONObject2.optString("c", "");
                    addThirdImpMonitorTrackers(optString3);
                    addThirdClickMonitorTrackers(optString4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("monitors");
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2.equals("s")) {
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray(next2);
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            addThirdImpMonitorTrackers(optJSONArray3.optString(i3));
                        }
                    } else if (next2.equals("vskip")) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray(next2);
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            addSkipMonitorTrackers(optJSONArray4.optString(i4));
                        }
                    } else if (next2.equals("scard")) {
                        JSONArray optJSONArray5 = optJSONObject2.optJSONArray(next2);
                        for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                            addScardMonitorTrackers(optJSONArray5.optString(i5));
                        }
                    } else if (next2.equals("ccard")) {
                        JSONArray optJSONArray6 = optJSONObject2.optJSONArray(next2);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            addCcardMonitorTrackers(optJSONArray6.optString(i6));
                        }
                    } else if (next2.equals("vstart")) {
                        JSONArray optJSONArray7 = optJSONObject2.optJSONArray(next2);
                        for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                            addStartMonitorTrackers(optJSONArray7.optString(i7));
                        }
                    } else if (next2.equals("vfullscreen")) {
                        JSONArray optJSONArray8 = optJSONObject2.optJSONArray(next2);
                        for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                            addFullScreenMonitorTrackers(optJSONArray8.optString(i8));
                        }
                    } else if (next2.equals("vclose")) {
                        JSONArray optJSONArray9 = optJSONObject2.optJSONArray(next2);
                        for (int i9 = 0; i9 < optJSONArray9.length(); i9++) {
                            addCloseMonitorTrackers(optJSONArray9.optString(i9));
                        }
                    } else if (next2.equals("cstartcard")) {
                        JSONArray optJSONArray10 = optJSONObject2.optJSONArray(next2);
                        for (int i10 = 0; i10 < optJSONArray10.length(); i10++) {
                            addCstartcardMonitorTrackers(optJSONArray10.optString(i10));
                        }
                    } else if (next2.equals("c")) {
                        JSONArray optJSONArray11 = optJSONObject2.optJSONArray(next2);
                        for (int i11 = 0; i11 < optJSONArray11.length(); i11++) {
                            addThirdClickMonitorTrackers(optJSONArray11.optString(i11));
                        }
                    } else if (next2.equals("vcache_succ")) {
                        JSONArray optJSONArray12 = optJSONObject2.optJSONArray(next2);
                        for (int i12 = 0; i12 < optJSONArray12.length(); i12++) {
                            addCacheSuccMonitorTrackers(optJSONArray12.optString(i12));
                        }
                    } else if (next2.equals("vcache_fail")) {
                        JSONArray optJSONArray13 = optJSONObject2.optJSONArray(next2);
                        for (int i13 = 0; i13 < optJSONArray13.length(); i13++) {
                            addCacheFailMonitorTrackers(optJSONArray13.optString(i13));
                        }
                    } else if (next2.equals("vcache_expire")) {
                        JSONArray optJSONArray14 = optJSONObject2.optJSONArray(next2);
                        for (int i14 = 0; i14 < optJSONArray14.length(); i14++) {
                            addCacheExpireMonitorTrackers(optJSONArray14.optString(i14));
                        }
                    }
                }
            }
            this.actionOnlyWifi = true;
            this.confirmBorderPercent = jSONObject.optString("cf", "");
            this.queryKey = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK, "");
            this.uniqueId = this.queryKey + "_" + new Random().nextLong() + System.currentTimeMillis() + FieldBuilder.SE;
            this.appName = jSONObject.optString("appname", "");
            this.appPackageName = jSONObject.optString("pk", "");
            this.appSize = jSONObject.optLong("sz", 0L);
            this.switchButton = jSONObject.optInt("sb", 0);
            this.appOpenStrs = jSONObject.optString("apo", "");
            this.pointsForWall = jSONObject.optInt("po", 0);
            this.taskDoneForWall = jSONObject.optInt("st", 0) == 1;
            this.webUrl = jSONObject.optString("murl", "");
            if (this.materialType.equals("video") && this.webUrl.length() > 0) {
                this.videoWidth = jSONObject.optInt("w", 0);
                this.videoHeight = jSONObject.optInt("h", 0);
                this.action = "video";
                if (this.actionType == 1) {
                    this.webUrl = this.clickThroughUrl;
                }
            }
            this.mAdContainerWidth = jSONObject.optInt("container_width");
            this.mAdContainerHeight = jSONObject.optInt("container_height");
            this.mAdContainerSizeType = jSONObject.optInt("size_type");
            this.mFeedAdStyleType = jSONObject.optInt("style_type");
            String optString5 = jSONObject.optString("thumburl");
            String optString6 = jSONObject.optString("contenttype");
            if (!jSONObject.has("remoteParams")) {
                JSONObject jSONObject3 = new JSONObject();
                this.mExtraParams = jSONObject3;
                jSONObject3.put("createTime", this.createTime);
                this.mExtraParams.put("expireTime", 1800000L);
                this.mExtraParams.put("uniqueId", this.uniqueId);
                this.mExtraParams.put("adLogo", "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
                this.mExtraParams.put("baiduLogo", "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
                this.mExtraParams.put("thumburl", optString5);
                this.mExtraParams.put("contenttype", optString6);
                jSONObject.put("remoteParams", this.mExtraParams);
                return;
            }
            this.mExtraParams = jSONObject.optJSONObject("remoteParams");
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
        }
    }

    public XAdInstanceInfoExt(IXAdInstanceInfo iXAdInstanceInfo) {
        this.adId = "-1";
        this.action = "";
        this.webUrl = "";
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.impressionUrls = new HashSet();
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mScardTrackers = new HashSet();
        this.mCcardTrackers = new HashSet();
        this.mFullScreenTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mCstartcardTrackers = new HashSet();
        this.mCacheSuccTrackers = new HashSet();
        this.mCacheFailTrackers = new HashSet();
        this.mCacheExpireTrackers = new HashSet();
        this.actionOnlyWifi = true;
        this.creativeType = IXAdInstanceInfo.CreativeType.NONE;
        this.inapp = true;
        this.autoOpen = true;
        this.popNotif = true;
        this.sencondConfirmed = false;
        this.mNoticeDlNonWifi = 0;
        this.mNoticeDlNonWifiSecJump = 0;
        this.mAPOOpen = false;
        this.mPage = null;
        try {
            this.appOpenStrs = iXAdInstanceInfo.getAppOpenStrs();
            this.originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
            this.createTime = iXAdInstanceInfo.getCreateTime();
            this.actionType = iXAdInstanceInfo.getActionType();
            this.htmlSnippet = iXAdInstanceInfo.getHtmlSnippet();
            this.adId = iXAdInstanceInfo.getAdId();
            this.adSource = iXAdInstanceInfo.getAdSource();
            this.title = iXAdInstanceInfo.getTitle();
            this.description = iXAdInstanceInfo.getDescription();
            this.sponsorUrl = iXAdInstanceInfo.getSponsorUrl();
            this.mainPictureUrl = iXAdInstanceInfo.getMainPictureUrl();
            this.iconUrl = iXAdInstanceInfo.getIconUrl();
            this.exp2ForSingleAd = iXAdInstanceInfo.getExp2ForSingleAd();
            this.antiTag = iXAdInstanceInfo.getAntiTag();
            this.mNoticeDlNonWifi = iXAdInstanceInfo.isNoticeDlNonWifi() ? 1 : 0;
            this.mNoticeDlNonWifiSecJump = iXAdInstanceInfo.isNoticeDlNonWifiSecJump() ? 1 : 0;
            this.mAsl = iXAdInstanceInfo.getAppStoreLink();
            this.videoUrl = iXAdInstanceInfo.getVideoUrl();
            this.videoDuration = iXAdInstanceInfo.getVideoDuration();
            this.isVideoMuted = iXAdInstanceInfo.isVideoMuted();
            this.iconVisibleForImageType = iXAdInstanceInfo.isIconVisibleForImageType();
            this.hoursInADayToShowAd = iXAdInstanceInfo.getHoursInADayToShowAd();
            this.clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
            this.originClickUrl = iXAdInstanceInfo.getOriginClickUrl();
            this.materialType = iXAdInstanceInfo.getMaterialType();
            this.creativeType = iXAdInstanceInfo.getCreativeType();
            this.mainMaterialWidth = iXAdInstanceInfo.getMainMaterialWidth();
            this.mainMaterialHeight = iXAdInstanceInfo.getMainMaterialHeight();
            this.phoneForLocalBranding = iXAdInstanceInfo.getPhoneForLocalBranding();
            this.impressionUrls = iXAdInstanceInfo.getImpressionUrls();
            this.mThirdImpMonitorTrackers = new HashSet(iXAdInstanceInfo.getThirdImpressionTrackingUrls());
            this.mThirdClickMonitorTrackers = new HashSet(iXAdInstanceInfo.getThirdClickTrackingUrls());
            this.mStartTrackers = new HashSet(iXAdInstanceInfo.getStartTrackers());
            this.mSkipTrackers = new HashSet(iXAdInstanceInfo.getSkipTrackers());
            this.mScardTrackers = new HashSet(iXAdInstanceInfo.getScardTrackers());
            this.mCcardTrackers = new HashSet(iXAdInstanceInfo.getCcardTrackers());
            this.mFullScreenTrackers = new HashSet(iXAdInstanceInfo.getFullScreenTrackers());
            this.mCloseTrackers = new HashSet(iXAdInstanceInfo.getCloseTrackers());
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getCstartcardTrackers", new Class[0])) {
                this.mCstartcardTrackers = new HashSet(iXAdInstanceInfo.getCstartcardTrackers());
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getCacheExpireTrackers", new Class[0])) {
                this.mCacheExpireTrackers = new HashSet(iXAdInstanceInfo.getCacheExpireTrackers());
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getCacheFailTrackers", new Class[0])) {
                this.mCacheFailTrackers = new HashSet(iXAdInstanceInfo.getCacheFailTrackers());
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getCacheSuccTrackers", new Class[0])) {
                this.mCacheSuccTrackers = new HashSet(iXAdInstanceInfo.getCacheSuccTrackers());
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getIntHtmlSnippet", new Class[0])) {
                this.intHtmlSnippet = iXAdInstanceInfo.getIntHtmlSnippet();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getBannerHtmlSnippet", new Class[0])) {
                this.bannerHtmlSnippet = iXAdInstanceInfo.getBannerHtmlSnippet();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getMute", new Class[0])) {
                this.mute = iXAdInstanceInfo.getMute();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getExpiration", new Class[0])) {
                this.expiration = iXAdInstanceInfo.getExpiration();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getCloseType", new Class[0])) {
                this.closeType = iXAdInstanceInfo.getCloseType();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getWebUrl", new Class[0])) {
                this.webUrl = iXAdInstanceInfo.getWebUrl();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getVideoWidth", new Class[0])) {
                this.videoWidth = iXAdInstanceInfo.getVideoWidth();
            }
            if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getVideoHeight", new Class[0])) {
                this.videoHeight = iXAdInstanceInfo.getVideoHeight();
            }
            this.actionOnlyWifi = iXAdInstanceInfo.isActionOnlyWifi();
            this.confirmBorderPercent = iXAdInstanceInfo.getConfirmBorderPercent();
            this.queryKey = iXAdInstanceInfo.getQueryKey();
            this.uniqueId = iXAdInstanceInfo.getUniqueId();
            this.appName = iXAdInstanceInfo.getAppName();
            this.appPackageName = iXAdInstanceInfo.getAppPackageName();
            this.appSize = iXAdInstanceInfo.getAppSize();
            this.switchButton = iXAdInstanceInfo.getSwitchButton();
            this.appOpenStrs = iXAdInstanceInfo.getAppOpenStrs();
            this.pointsForWall = iXAdInstanceInfo.getPointsForWall();
            this.taskDoneForWall = true;
            this.mExtraParams = iXAdInstanceInfo.getExtraParams();
        } catch (Throwable unused) {
        }
    }

    public XAdInstanceInfoExt(Parcel parcel) {
        this.adId = "-1";
        this.action = "";
        this.webUrl = "";
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.impressionUrls = new HashSet();
        this.mThirdImpMonitorTrackers = new HashSet();
        this.mThirdClickMonitorTrackers = new HashSet();
        this.mStartTrackers = new HashSet();
        this.mSkipTrackers = new HashSet();
        this.mScardTrackers = new HashSet();
        this.mCcardTrackers = new HashSet();
        this.mFullScreenTrackers = new HashSet();
        this.mCloseTrackers = new HashSet();
        this.mCstartcardTrackers = new HashSet();
        this.mCacheSuccTrackers = new HashSet();
        this.mCacheFailTrackers = new HashSet();
        this.mCacheExpireTrackers = new HashSet();
        this.actionOnlyWifi = true;
        this.creativeType = IXAdInstanceInfo.CreativeType.NONE;
        this.inapp = true;
        this.autoOpen = true;
        this.popNotif = true;
        this.sencondConfirmed = false;
        this.mNoticeDlNonWifi = 0;
        this.mNoticeDlNonWifiSecJump = 0;
        this.mAPOOpen = false;
        this.mPage = null;
        this.adId = parcel.readString();
        this.adSource = parcel.readString();
        this.appName = parcel.readString();
        this.appOpenStrs = parcel.readString();
        this.appPackageName = parcel.readString();
        this.clickThroughUrl = parcel.readString();
        this.clklogurl = parcel.readString();
        this.confirmBorderPercent = parcel.readString();
        this.description = parcel.readString();
        this.title = parcel.readString();
        this.exp2ForSingleAd = parcel.readString();
        this.fwt = parcel.readString();
        this.iconUrl = parcel.readString();
        this.mainPictureUrl = parcel.readString();
        this.materialType = parcel.readString();
        this.mainMaterialHeight = parcel.readInt();
        this.mainMaterialWidth = parcel.readInt();
        this.originClickUrl = parcel.readString();
        this.phoneForLocalBranding = parcel.readString();
        this.queryKey = parcel.readString();
        this.sponsorUrl = parcel.readString();
        this.url = parcel.readString();
        this.videoUrl = parcel.readString();
        this.videoDuration = parcel.readInt();
        this.vurl = parcel.readString();
        this.winurl = parcel.readString();
        this.action = parcel.readString();
        this.webUrl = parcel.readString();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.closeType = parcel.readInt();
        this.expiration = parcel.readInt();
        this.mute = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setStartTrackers(arrayList);
        ArrayList arrayList2 = new ArrayList();
        parcel.readStringList(arrayList2);
        setCloseTrackers(arrayList2);
        this.actionType = parcel.readInt();
        this.mAdContainerWidth = parcel.readInt();
        this.mAdContainerHeight = parcel.readInt();
        this.mAdContainerSizeType = parcel.readInt();
        this.mFeedAdStyleType = parcel.readInt();
        this.mBuyer = parcel.readString();
        this.uniqueId = parcel.readString();
        this.mNoticeDlNonWifi = parcel.readInt();
        this.mNoticeDlNonWifiSecJump = parcel.readInt();
        try {
            this.mExtraParams = new JSONObject(parcel.readString());
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(TAG, e2.getMessage());
        }
    }
}
