package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdElementInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_EXPIRED_TIME = 1800000;
    public static final String GIF = "gif";
    public static final String HTML = "html";
    public static final String HYBRID = "hybrid";
    public static final String NONE = "none";
    public static final String RM = "rich_media";
    public static final String STATIC_IMAGE = "static_image";
    public static final String TEXT = "text";
    public static final String VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
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
    public int mAutoPlayNonWifi;
    public String mBaiduLogoUrl;
    public long mCreateTime;
    public String mCreativeType;
    public String mECPMLevel;
    public long mExpireTime;
    public HashMap<String, Object> mExtData;
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

    public AdElementInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAutoPlayNonWifi = 1;
        this.mCreativeType = "none";
        this.mExtData = new HashMap<>();
    }

    public static AdElementInfo fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
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
        return (AdElementInfo) invokeL.objValue;
    }

    public static List<AdElementInfo> fromJsonArray(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
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
        return (List) invokeL.objValue;
    }

    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mActionType : invokeV.intValue;
    }

    public String getAdBrandName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdBrandName : (String) invokeV.objValue;
    }

    public int getAdContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdContainerHeight : invokeV.intValue;
    }

    public int getAdContainerSizeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdContainerSizeType : invokeV.intValue;
    }

    public int getAdContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAdContainerWidth : invokeV.intValue;
    }

    public String getAdDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAdDesc : (String) invokeV.objValue;
    }

    public String getAdIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAdIconUrl : (String) invokeV.objValue;
    }

    public String getAdImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAdImageUrl : (String) invokeV.objValue;
    }

    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdLogoUrl : (String) invokeV.objValue;
    }

    public int getAdMainPicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAdMainPicHeight : invokeV.intValue;
    }

    public int getAdMainPicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAdMainPicWidth : invokeV.intValue;
    }

    public String getAdTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mAdTitle : (String) invokeV.objValue;
    }

    public String getAppOpenStrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mAppOpenStrs : (String) invokeV.objValue;
    }

    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mAppPackage : (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mAppSize : invokeV.longValue;
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mAppVersion : (String) invokeV.objValue;
    }

    public int getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAutoPlay : invokeV.intValue;
    }

    public int getAutoPlayNonWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAutoPlayNonWifi : invokeV.intValue;
    }

    public String getBaiduLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mBaiduLogoUrl : (String) invokeV.objValue;
    }

    public JSONObject getBaseAdJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mCreateTime : invokeV.longValue;
    }

    public String getCreativeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mCreativeType : (String) invokeV.objValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mECPMLevel : (String) invokeV.objValue;
    }

    public long getExpireTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mExpireTime : invokeV.longValue;
    }

    public HashMap<String, Object> getExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mExtData : (HashMap) invokeV.objValue;
    }

    public JSONObject getExtraParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mRemoteParams : (JSONObject) invokeV.objValue;
    }

    public int getFeedAdStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFeedAdStyleType : invokeV.intValue;
    }

    public String getHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mHtmlSnippet : (String) invokeV.objValue;
    }

    public String getMarketingDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mMarketingDesc : (String) invokeV.objValue;
    }

    public String getMarketingICONUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mMarketingICONUrl : (String) invokeV.objValue;
    }

    public String getMarketingPendant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mMarketingPendant : (String) invokeV.objValue;
    }

    public List<String> getMultiPicUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mMultiPics : (List) invokeV.objValue;
    }

    public String getPermissionLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPermissionLink : (String) invokeV.objValue;
    }

    public String getPrivacyLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mPrivacyLink : (String) invokeV.objValue;
    }

    public String getPublisher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mPublisher : (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mUniqueId : (String) invokeV.objValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mVideoDuration : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mVideoUrl : (String) invokeV.objValue;
    }
}
