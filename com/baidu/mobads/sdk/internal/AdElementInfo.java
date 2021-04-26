package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdElementInfo {
    public static final long DEFAULT_EXPIRED_TIME = 1800000;
    public static final String GIF = "gif";
    public static final String HTML = "html";
    public static final String HYBRID = "hybrid";
    public static final String NONE = "none";
    public static final String RM = "rich_media";
    public static final String STATIC_IMAGE = "static_image";
    public static final String TEXT = "text";
    public static final String VIDEO = "video";
    public int mActionType;
    public String mAdBrandName;
    public int mAdContainerHeight;
    public int mAdContainerSizeType;
    public int mAdContainerWidth;
    public String mAdDesc;
    public String mAdIconUrl;
    public String mAdImageUrl;
    public String mAdLogoUrl;
    public int mAdMainPicHeight;
    public int mAdMainPicWidth;
    public String mAdTitle;
    public String mAppOpenStrs;
    public String mAppPackage;
    public long mAppSize;
    public String mAppVersion;
    public int mAutoPlay;
    public String mBaiduLogoUrl;
    public long mCreateTime;
    public String mECPMLevel;
    public long mExpireTime;
    public int mFeedAdStyleType;
    public String mHtmlSnippet;
    public String mMarketingDesc;
    public String mMarketingICONUrl;
    public String mMarketingPendant;
    public String mMaterialType;
    public List<String> mMultiPics;
    public String mPermissionLink;
    public String mPrivacyLink;
    public String mPublisher;
    public JSONObject mRemoteParams;
    public String mUniqueId;
    public int mVideoDuration;
    public String mVideoUrl;
    public int mAutoPlayNonWifi = 1;
    public String mCreativeType = "none";
    public HashMap<String, Object> mExtData = new HashMap<>();

    public static AdElementInfo fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            AdElementInfo adElementInfo = new AdElementInfo();
            adElementInfo.mRemoteParams = jSONObject.optJSONObject("remoteParams");
            adElementInfo.mAdTitle = jSONObject.optString("tit");
            adElementInfo.mAdDesc = jSONObject.optString("desc");
            adElementInfo.mAdIconUrl = jSONObject.optString("icon");
            adElementInfo.mAdImageUrl = jSONObject.optString("w_picurl");
            adElementInfo.mAdMainPicWidth = jSONObject.optInt("w");
            adElementInfo.mAdMainPicHeight = jSONObject.optInt("h");
            adElementInfo.mAdBrandName = jSONObject.optString("appname");
            adElementInfo.mAdLogoUrl = jSONObject.optString("adLogo");
            adElementInfo.mBaiduLogoUrl = jSONObject.optString("baiduLogo");
            try {
                String optString = jSONObject.optString("control_flags");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString("innovate");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        adElementInfo.mMarketingICONUrl = jSONObject2.optString("gjico");
                        adElementInfo.mMarketingDesc = jSONObject2.optString("gjtxt");
                        adElementInfo.mMarketingPendant = jSONObject2.optString("gjurl");
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            adElementInfo.mAppSize = jSONObject.optLong("sz");
            adElementInfo.mAutoPlay = jSONObject.optInt("auto_play", 0);
            adElementInfo.mAutoPlayNonWifi = jSONObject.optInt("auto_play_non_wifi", 1);
            adElementInfo.mAppPackage = jSONObject.optString("pk");
            adElementInfo.mActionType = jSONObject.optInt("act");
            adElementInfo.mAppOpenStrs = jSONObject.optString("apo", "");
            adElementInfo.mECPMLevel = jSONObject.optString("bidlayer", "");
            adElementInfo.mAdContainerWidth = jSONObject.optInt("container_width");
            adElementInfo.mAdContainerHeight = jSONObject.optInt("container_height");
            adElementInfo.mAdContainerSizeType = jSONObject.optInt("size_type");
            adElementInfo.mFeedAdStyleType = jSONObject.optInt("style_type");
            adElementInfo.mVideoUrl = jSONObject.optString("vurl", "");
            adElementInfo.mVideoDuration = jSONObject.optInt("duration", 0);
            adElementInfo.mMaterialType = jSONObject.optString("type");
            adElementInfo.mHtmlSnippet = jSONObject.optString("html", null);
            adElementInfo.mAppVersion = jSONObject.optString("app_version", "");
            adElementInfo.mPublisher = jSONObject.optString("publisher", "");
            adElementInfo.mPermissionLink = jSONObject.optString("permission_link", "");
            adElementInfo.mPrivacyLink = jSONObject.optString(AppPriActivity.PRIVACY_LINK, "");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("morepics");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    adElementInfo.mMultiPics = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        adElementInfo.mMultiPics.add(optJSONArray.getString(i2));
                    }
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(adElementInfo.mHtmlSnippet)) {
                adElementInfo.mCreativeType = "html";
            } else {
                String str = adElementInfo.mMaterialType;
                if (str != null) {
                    if (str.equals("text")) {
                        adElementInfo.mMaterialType = "text";
                    } else if (adElementInfo.mMaterialType.equals("image")) {
                        if (!TextUtils.isEmpty(adElementInfo.mAdImageUrl)) {
                            int lastIndexOf = adElementInfo.mAdImageUrl.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                            if ((lastIndexOf >= 0 ? adElementInfo.mAdImageUrl.toLowerCase(Locale.getDefault()).substring(lastIndexOf) : "").equals(".gif")) {
                                adElementInfo.mCreativeType = "gif";
                            } else {
                                adElementInfo.mCreativeType = "static_image";
                            }
                        }
                    } else if (adElementInfo.mMaterialType.equals("rm")) {
                        adElementInfo.mCreativeType = "rich_media";
                    } else if (adElementInfo.mMaterialType.equals("video")) {
                        adElementInfo.mCreativeType = "video";
                    }
                }
            }
            try {
                if (jSONObject.has("custom_ext_data")) {
                    adElementInfo.mExtData.put("custom_ext_data", jSONObject.optString("custom_ext_data"));
                }
                if (jSONObject.optInt("pattern") == 1 || jSONObject.optInt("pattern") == 2) {
                    adElementInfo.mExtData.put("pattern", Integer.valueOf(jSONObject.optInt("pattern")));
                }
                if (jSONObject.has("btn_pos")) {
                    adElementInfo.mExtData.put("btn_pos", Double.valueOf(jSONObject.optDouble("btn_pos")));
                }
            } catch (Throwable unused2) {
            }
            JSONObject jSONObject3 = adElementInfo.mRemoteParams;
            if (jSONObject3 != null) {
                adElementInfo.mCreateTime = jSONObject3.optLong("createTime", 0L);
                adElementInfo.mExpireTime = adElementInfo.mRemoteParams.optLong("expireTime", 1800000L);
                adElementInfo.mAdLogoUrl = adElementInfo.mRemoteParams.optString("adLogo", "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
                adElementInfo.mBaiduLogoUrl = adElementInfo.mRemoteParams.optString("baiduLogo", "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
                adElementInfo.mUniqueId = adElementInfo.mRemoteParams.optString("uniqueId", "");
            }
            return adElementInfo;
        }
        return null;
    }

    public static List<AdElementInfo> fromJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(fromJson(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public int getActionType() {
        return this.mActionType;
    }

    public String getAdBrandName() {
        return this.mAdBrandName;
    }

    public int getAdContainerHeight() {
        return this.mAdContainerHeight;
    }

    public int getAdContainerSizeType() {
        return this.mAdContainerSizeType;
    }

    public int getAdContainerWidth() {
        return this.mAdContainerWidth;
    }

    public String getAdDesc() {
        return this.mAdDesc;
    }

    public String getAdIconUrl() {
        return this.mAdIconUrl;
    }

    public String getAdImageUrl() {
        return this.mAdImageUrl;
    }

    public String getAdLogoUrl() {
        return this.mAdLogoUrl;
    }

    public int getAdMainPicHeight() {
        return this.mAdMainPicHeight;
    }

    public int getAdMainPicWidth() {
        return this.mAdMainPicWidth;
    }

    public String getAdTitle() {
        return this.mAdTitle;
    }

    public String getAppOpenStrs() {
        return this.mAppOpenStrs;
    }

    public String getAppPackageName() {
        return this.mAppPackage;
    }

    public long getAppSize() {
        return this.mAppSize;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public int getAutoPlay() {
        return this.mAutoPlay;
    }

    public int getAutoPlayNonWifi() {
        return this.mAutoPlayNonWifi;
    }

    public String getBaiduLogoUrl() {
        return this.mBaiduLogoUrl;
    }

    public JSONObject getBaseAdJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.mUniqueId);
            jSONObject.put("tit", this.mAdTitle);
            jSONObject.put("desc", this.mAdDesc);
            jSONObject.put("pk", this.mAppPackage);
            jSONObject.put("appname", this.mAdBrandName);
            jSONObject.put("act", this.mActionType);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getCreativeType() {
        return this.mCreativeType;
    }

    public String getECPMLevel() {
        return this.mECPMLevel;
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public HashMap<String, Object> getExtData() {
        return this.mExtData;
    }

    public JSONObject getExtraParams() {
        return this.mRemoteParams;
    }

    public int getFeedAdStyleType() {
        return this.mFeedAdStyleType;
    }

    public String getHtmlSnippet() {
        return this.mHtmlSnippet;
    }

    public String getMarketingDesc() {
        return this.mMarketingDesc;
    }

    public String getMarketingICONUrl() {
        return this.mMarketingICONUrl;
    }

    public String getMarketingPendant() {
        return this.mMarketingPendant;
    }

    public List<String> getMultiPicUrls() {
        return this.mMultiPics;
    }

    public String getPermissionLink() {
        return this.mPermissionLink;
    }

    public String getPrivacyLink() {
        return this.mPrivacyLink;
    }

    public String getPublisher() {
        return this.mPublisher;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public int getVideoDuration() {
        return this.mVideoDuration;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }
}
