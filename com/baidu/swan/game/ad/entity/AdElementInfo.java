package com.baidu.swan.game.ad.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
    public String mPictureUrl;
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

    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator<AdElementInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new AdElementInfo(parcel, (a) null) : (AdElementInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdElementInfo[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new AdElementInfo[i2] : (AdElementInfo[]) invokeI.objValue;
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

    public /* synthetic */ AdElementInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void addCloseMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        this.mCloseTrackers.add(str);
    }

    private void addConversionUrls(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mConversionUrls.add(str);
    }

    private void addMonitorClickTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        this.mMonitorClickers.add(str);
    }

    private void addSkipMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mSkipTrackers.add(str);
    }

    private void addStartMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mStartTrackers.add(str);
    }

    private void addThirdClickMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdClickMonitorTrackers.add(str);
    }

    private void addThirdImpMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdImpMonitorTrackers.add(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActionType : invokeV.intValue;
    }

    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdId : (String) invokeV.objValue;
    }

    public JSONObject getAdJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdJsonObject : (JSONObject) invokeV.objValue;
    }

    public JSONObject getAdMonitors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAdMonitors : (JSONObject) invokeV.objValue;
    }

    public int getAntiTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAntiTag : invokeV.intValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAppSize : invokeV.longValue;
    }

    public String getBannerHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBannerHtml : (String) invokeV.objValue;
    }

    public String getClickUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mClickUrl : (String) invokeV.objValue;
    }

    public List<String> getCloseTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new ArrayList(this.mCloseTrackers) : (List) invokeV.objValue;
    }

    public int getCloseType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCloseType : invokeV.intValue;
    }

    public List<String> getConversionUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new ArrayList(this.mConversionUrls) : (List) invokeV.objValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.createTime : invokeV.longValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mDescription : (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mDuration : invokeV.intValue;
    }

    public String getEndFrameHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mEndFrameHtml : (String) invokeV.objValue;
    }

    public String getEndFrameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mEndFrameUrl : (String) invokeV.objValue;
    }

    public int getExpired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mExpire : invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIconUrl : (String) invokeV.objValue;
    }

    public List<String> getImpressionUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new ArrayList(this.mImpressionUrls) : (List) invokeV.objValue;
    }

    public String getLandBannerHtml() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mLandBannerHtml : (String) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mPage : (String) invokeV.objValue;
    }

    public String getPictureUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mPictureUrl : (String) invokeV.objValue;
    }

    public String getQueryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mQueryKey : (String) invokeV.objValue;
    }

    public int getRewardTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? new ArrayList(this.mSkipTrackers) : (List) invokeV.objValue;
    }

    public List<String> getStartTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new ArrayList(this.mStartTrackers) : (List) invokeV.objValue;
    }

    public List<String> getThirdClickTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? new ArrayList(this.mThirdClickMonitorTrackers) : (List) invokeV.objValue;
    }

    public List<String> getThirdImpressionTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? new ArrayList(this.mThirdImpMonitorTrackers) : (List) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mUniqueId : (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mVideoUrl : (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    public boolean isGdtAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mGdtAd : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, parcel, i2) == null) {
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

    @SuppressLint({"DefaultLocale"})
    public AdElementInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mQueryKey = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK, "");
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
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            addThirdImpMonitorTrackers(optJSONArray.optString(i4));
                        }
                    } else if (next.equals("vskip")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                        for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i5));
                        }
                    } else if (next.equals("vstart")) {
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                            addStartMonitorTrackers(optJSONArray3.optString(i6));
                        }
                    } else if (next.equals("vclose")) {
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(next);
                        for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                            addCloseMonitorTrackers(optJSONArray4.optString(i7));
                        }
                    } else if (next.equals(PrefetchEvent.STATE_CLICK)) {
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(next);
                        for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                            addMonitorClickTrackers(optJSONArray5.optString(i8));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i9 = 0; i9 < optJSONArray6.length(); i9++) {
                            addThirdClickMonitorTrackers(optJSONArray6.optString(i9));
                        }
                    }
                }
            }
            this.mAppName = jSONObject.optString("appname", "");
            this.mPackageName = jSONObject.optString("pk", "");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mAdId = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.ADID, "-1");
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
                for (int i4 = 0; optJSONArray2 != null && i4 < optJSONArray2.length(); i4++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i4))) {
                        this.mImpressionUrls.add(optJSONArray2.optString(i4));
                    }
                }
            }
            if (jSONObject.has("click_urls")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("click_urls");
                for (int i5 = 0; optJSONArray3 != null && i5 < optJSONArray3.length(); i5++) {
                    addThirdClickMonitorTrackers(optJSONArray3.optString(i5));
                }
            }
            if (jSONObject.has("video_play_urls")) {
                JSONArray optJSONArray4 = jSONObject.optJSONArray("video_play_urls");
                for (int i6 = 0; optJSONArray4 != null && i6 < optJSONArray4.length(); i6++) {
                    addCloseMonitorTrackers(optJSONArray4.optString(i6));
                }
            }
            if (jSONObject.has("conversion_urls")) {
                JSONArray optJSONArray5 = jSONObject.optJSONArray("conversion_urls");
                for (int i7 = 0; optJSONArray5 != null && i7 < optJSONArray5.length(); i7++) {
                    addConversionUrls(optJSONArray5.optString(i7));
                }
            }
            this.mExpire = jSONObject.optInt("expiration", 0);
            this.mUniqueId = this.mAdId + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception unused) {
        }
    }

    public AdElementInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
