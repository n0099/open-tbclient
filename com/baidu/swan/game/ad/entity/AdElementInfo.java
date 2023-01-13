package com.baidu.swan.game.ad.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdElementInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_TYPE_DOWNLOAD = 2;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int CLOSE_TYPE_TO_NEW_STRATEGY = 6;
    public static final Parcelable.Creator<AdElementInfo> CREATOR;
    public static final String TAG = "AdElementInfo";
    public transient /* synthetic */ FieldHolder $fh;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<AdElementInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdElementInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new AdElementInfo(parcel, (a) null);
            }
            return (AdElementInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdElementInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new AdElementInfo[i];
            }
            return (AdElementInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1183660385, "Lcom/baidu/swan/game/ad/entity/AdElementInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1183660385, "Lcom/baidu/swan/game/ad/entity/AdElementInfo;");
                return;
            }
        }
        CREATOR = new a();
    }

    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActionType;
        }
        return invokeV.intValue;
    }

    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAdId;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject getAdJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAdJsonObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getAdMonitors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAdMonitors;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int getAntiTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAntiTag;
        }
        return invokeV.intValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mAppName;
        }
        return (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mAppSize;
        }
        return invokeV.longValue;
    }

    public String getBannerHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mBannerHtml;
        }
        return (String) invokeV.objValue;
    }

    public String getClickUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mClickUrl;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getCloseTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new ArrayList(this.mCloseTrackers);
        }
        return (List) invokeV.objValue;
    }

    public int getCloseType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mCloseType;
        }
        return invokeV.intValue;
    }

    public List<String> getConversionUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new ArrayList(this.mConversionUrls);
        }
        return (List) invokeV.objValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.createTime;
        }
        return invokeV.longValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mDescription;
        }
        return (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mDuration;
        }
        return invokeV.intValue;
    }

    public String getEndFrameHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mEndFrameHtml;
        }
        return (String) invokeV.objValue;
    }

    public String getEndFrameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mEndFrameUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getExpired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mExpire;
        }
        return invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getImpressionUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new ArrayList(this.mImpressionUrls);
        }
        return (List) invokeV.objValue;
    }

    public String getLandBannerHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mLandBannerHtml;
        }
        return (String) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mPackageName;
        }
        return (String) invokeV.objValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mPage;
        }
        return (String) invokeV.objValue;
    }

    public String getPermissionUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mPermissionUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getPictureUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mPictureUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mPrivacyUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getQueryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mQueryKey;
        }
        return (String) invokeV.objValue;
    }

    public int getRewardTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (getCloseType() == 6) {
                return this.mRewardTime;
            }
            return this.mRewardTimeDefault;
        }
        return invokeV.intValue;
    }

    public int getSkipTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getCloseType() == 6) {
                return this.mSkipTime;
            }
            return this.mSkipTimeDefault;
        }
        return invokeV.intValue;
    }

    public List<String> getSkipTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return new ArrayList(this.mSkipTrackers);
        }
        return (List) invokeV.objValue;
    }

    public List<String> getStartTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return new ArrayList(this.mStartTrackers);
        }
        return (List) invokeV.objValue;
    }

    public List<String> getThirdClickTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return new ArrayList(this.mThirdClickMonitorTrackers);
        }
        return (List) invokeV.objValue;
    }

    public List<String> getThirdImpressionTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new ArrayList(this.mThirdImpMonitorTrackers);
        }
        return (List) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mUniqueId;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mVideoHeight;
        }
        return invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mVideoUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mVideoWidth;
        }
        return invokeV.intValue;
    }

    public boolean isGdtAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mGdtAd;
        }
        return invokeV.booleanValue;
    }

    public AdElementInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            addThirdImpMonitorTrackers(optJSONArray.optString(i3));
                        }
                    } else if (next.equals("vskip")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                        for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i4));
                        }
                    } else if (next.equals("vstart")) {
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray(next);
                        for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                            addStartMonitorTrackers(optJSONArray3.optString(i5));
                        }
                    } else if (next.equals("vclose")) {
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                            addCloseMonitorTrackers(optJSONArray4.optString(i6));
                        }
                    } else if (next.equals("click")) {
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(next);
                        for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                            addMonitorClickTrackers(optJSONArray5.optString(i7));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                            addThirdClickMonitorTrackers(optJSONArray6.optString(i8));
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
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
                for (int i3 = 0; optJSONArray2 != null && i3 < optJSONArray2.length(); i3++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i3))) {
                        this.mImpressionUrls.add(optJSONArray2.optString(i3));
                    }
                }
            }
            if (jSONObject.has("click_urls")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("click_urls");
                for (int i4 = 0; optJSONArray3 != null && i4 < optJSONArray3.length(); i4++) {
                    addThirdClickMonitorTrackers(optJSONArray3.optString(i4));
                }
            }
            if (jSONObject.has("video_play_urls")) {
                JSONArray optJSONArray4 = jSONObject.optJSONArray("video_play_urls");
                for (int i5 = 0; optJSONArray4 != null && i5 < optJSONArray4.length(); i5++) {
                    addCloseMonitorTrackers(optJSONArray4.optString(i5));
                }
            }
            if (jSONObject.has("conversion_urls")) {
                JSONArray optJSONArray5 = jSONObject.optJSONArray("conversion_urls");
                for (int i6 = 0; optJSONArray5 != null && i6 < optJSONArray5.length(); i6++) {
                    addConversionUrls(optJSONArray5.optString(i6));
                }
            }
            this.mExpire = jSONObject.optInt("expiration", 0);
            this.mUniqueId = this.mAdId + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception unused) {
        }
    }

    private void addCloseMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, str) == null) && str != null && !str.equals("")) {
            this.mCloseTrackers.add(str);
        }
    }

    private void addConversionUrls(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mConversionUrls.add(str);
        }
    }

    private void addMonitorClickTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && str != null && !str.equals("")) {
            this.mMonitorClickers.add(str);
        }
    }

    private void addSkipMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mSkipTrackers.add(str);
        }
    }

    private void addStartMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mStartTrackers.add(str);
        }
    }

    private void addThirdClickMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mThirdClickMonitorTrackers.add(str);
        }
    }

    private void addThirdImpMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mThirdImpMonitorTrackers.add(str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048617, this, parcel, i) == null) {
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
}
