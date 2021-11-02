package com.baidu.mobads.container;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
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
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class XAdInstanceInfoExt implements IXAdInstanceInfo, Cloneable, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<XAdInstanceInfoExt> CREATOR;
    public static final String TAG = "XAdInstanceInfo";
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-127766055, "Lcom/baidu/mobads/container/XAdInstanceInfoExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-127766055, "Lcom/baidu/mobads/container/XAdInstanceInfoExt;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<XAdInstanceInfoExt>() { // from class: com.baidu.mobads.container.XAdInstanceInfoExt.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public XAdInstanceInfoExt createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new XAdInstanceInfoExt(parcel) : (XAdInstanceInfoExt) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public XAdInstanceInfoExt[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new XAdInstanceInfoExt[i2] : (XAdInstanceInfoExt[]) invokeI.objValue;
            }
        };
    }

    public final void addCacheExpireMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheExpireTrackers.add(str);
    }

    public final void addCacheFailMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheFailTrackers.add(str);
    }

    public final void addCacheSuccMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mCacheSuccTrackers.add(str);
    }

    public void addCcardMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mCcardTrackers.add(str);
    }

    public void addCloseMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        this.mCloseTrackers.add(str);
    }

    public void addCstartcardMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        this.mCstartcardTrackers.add(str);
    }

    public void addFullScreenMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null || str.equals("")) {
            return;
        }
        this.mFullScreenTrackers.add(str);
    }

    public void addScardMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mScardTrackers.add(str);
    }

    public void addSkipMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mSkipTrackers.add(str);
    }

    public void addStartMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mStartTrackers.add(str);
    }

    public final void addThirdClickMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdClickMonitorTrackers.add(str);
    }

    public final void addThirdImpMonitorTrackers(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mThirdImpMonitorTrackers.add(str);
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.clone() : invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean getAPOOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mAPOOpen : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.action : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.actionType : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAdContainerHeight : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerSizeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mAdContainerSizeType : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAdContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mAdContainerWidth : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean getAdHasDisplayed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mHasDisplay : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.adId : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.adSource : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getAntiTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.antiTag : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.appName : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppOpenStrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.appOpenStrs : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.appPackageName : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.appSize : invokeV.longValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getAppStoreLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mAsl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getBannerHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.bannerHtmlSnippet : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getBuyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mBuyer : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheExpireTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? new ArrayList(this.mCacheExpireTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheFailTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? new ArrayList(this.mCacheFailTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCacheSuccTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new ArrayList(this.mCacheSuccTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCcardTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? new ArrayList(this.mCcardTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getClickThroughUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.clickThroughUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getClklogurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.clklogurl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCloseTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? new ArrayList(this.mCloseTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getCloseType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.closeType : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getConfirmBorderPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.confirmBorderPercent : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.createTime : invokeV.longValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public IXAdInstanceInfo.CreativeType getCreativeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.creativeType : (IXAdInstanceInfo.CreativeType) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getCstartcardTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? new ArrayList(this.mCstartcardTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.description : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getDlTunnel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.dlTunnel : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getExp2ForSingleAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.exp2ForSingleAd : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.expiration : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONObject getExtraParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mExtraParams : (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getFeedAdStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mFeedAdStyleType : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getFullScreenTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? new ArrayList(this.mFullScreenTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getFwt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.fwt : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getHoursInADayToShowAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.hoursInADayToShowAd : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.htmlSnippet : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public Set<String> getImpressionUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.impressionUrls : (Set) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getIntHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.intHtmlSnippet : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getLocalCreativeURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.localCreativeUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getMainMaterialHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mainMaterialHeight : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getMainMaterialWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mainMaterialWidth : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMainPictureUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mainPictureUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.materialType : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mute : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONArray getNwinurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.nwinurl : (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getOriginClickUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.originClickUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public JSONObject getOriginJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.originJsonObject : (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mPage : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getPhoneForLocalBranding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.phoneForLocalBranding : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getPointsForWall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.pointsForWall : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getQueryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.queryKey : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getScardTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? new ArrayList(this.mScardTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getSkipTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? new ArrayList(this.mSkipTrackers) : (List) invokeV.objValue;
    }

    public String getSplash3DLocalUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.splash3dLocalResUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getSponsorUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.sponsorUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getStartTrackers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? new ArrayList(this.mStartTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getSwitchButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.switchButton : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getThirdClickTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? new ArrayList(this.mThirdClickMonitorTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public List<String> getThirdImpressionTrackingUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? new ArrayList(this.mThirdImpMonitorTrackers) : (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.uniqueId : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.videoDuration : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.videoHeight : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.videoUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.videoWidth : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getVurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.vurl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getWebUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.webUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public String getWinurl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.winurl : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isActionOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.actionOnlyWifi : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isAutoOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.autoOpen : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isCanCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.canCancel : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isCanDelete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.canDelete : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.close : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isIconVisibleForImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.iconVisibleForImageType : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isInapp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.inapp : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isNoticeDlNonWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.mNoticeDlNonWifi == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isNoticeDlNonWifiSecJump() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.mNoticeDlNonWifiSecJump == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isPopNotif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.popNotif : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isSecondConfirmed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.sencondConfirmed : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isTaskDoneForWall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.taskDoneForWall : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isTooLarge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.isTooLarge : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public Boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId())) : (Boolean) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isVideoMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.isVideoMuted : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public boolean isWifiTargeted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.isWifiTargeted : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAPOOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.mAPOOpen = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            this.action = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setActionOnlyWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            this.actionOnlyWifi = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setActionType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            this.actionType = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            this.mAdContainerHeight = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerSizeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            this.mAdContainerSizeType = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdContainerWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i2) == null) {
            this.mAdContainerWidth = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdHasDisplayed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.mHasDisplay = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, str) == null) {
            this.adId = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.adSource = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAntiTag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i2) == null) {
            this.antiTag = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            this.appName = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppOpenStrs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            this.appOpenStrs = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, str) == null) {
            this.appPackageName = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAppSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048693, this, j) == null) {
            this.appSize = j;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setAutoOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            this.autoOpen = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setBannerHtmlSnippet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, str) == null) {
            this.bannerHtmlSnippet = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setBuyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, str) == null) {
            this.mBuyer = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheExpireTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, list) == null) {
            try {
                this.mCacheExpireTrackers.clear();
                this.mCacheExpireTrackers.addAll(list);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheFailTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, list) == null) {
            try {
                this.mCacheFailTrackers.clear();
                this.mCacheFailTrackers.addAll(list);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCacheSuccTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, list) == null) {
            try {
                this.mCacheSuccTrackers.clear();
                this.mCacheSuccTrackers.addAll(list);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCanCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z) == null) {
            this.canCancel = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCanDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z) == null) {
            this.canDelete = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCcardTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, list) == null) {
            this.mCcardTrackers.addAll(list);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClickThroughUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, str) == null) {
            this.clickThroughUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClklogurl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, str) == null) {
            this.clklogurl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z) == null) {
            this.close = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCloseTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, list) == null) {
            try {
                this.mCloseTrackers.clear();
                this.mCloseTrackers.addAll(list);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCloseType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            this.closeType = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setConfirmBorderPercent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.confirmBorderPercent = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048709, this, j) == null) {
            this.createTime = j;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCreativeType(IXAdInstanceInfo.CreativeType creativeType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, creativeType) == null) {
            this.creativeType = creativeType;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setCstartcardTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, list) == null) {
            this.mCstartcardTrackers.clear();
            this.mCstartcardTrackers.addAll(list);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, str) == null) {
            this.description = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setDlTunnel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i2) == null) {
            this.dlTunnel = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setExp2ForSingleAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, str) == null) {
            this.exp2ForSingleAd = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setExpiration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.expiration = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFeedAdStyleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            this.mFeedAdStyleType = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFullScreenTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, list) == null) {
            this.mFullScreenTrackers.addAll(list);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setFwt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.fwt = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setHoursInADayToShowAd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i2) == null) {
            this.hoursInADayToShowAd = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setHtmlSnippet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, str) == null) {
            this.htmlSnippet = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.iconUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIconVisibleForImageType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            this.iconVisibleForImageType = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setImpressionUrls(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, set) == null) {
            this.impressionUrls = set;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setInapp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z) == null) {
            this.inapp = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setIntHtmlSnippet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, str) == null) {
            this.intHtmlSnippet = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setLocalCreativeURL(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.localCreativeUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainMaterialHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i2) == null) {
            this.mainMaterialHeight = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainMaterialWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048728, this, i2) == null) {
            this.mainMaterialWidth = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMainPictureUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, str) == null) {
            this.mainPictureUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMaterialType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            this.materialType = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setMute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            this.mute = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setNwinurl(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, jSONArray) == null) {
            this.nwinurl = jSONArray;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setOriginClickUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, str) == null) {
            this.originClickUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, str) == null) {
            this.mPage = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPhoneForLocalBranding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            this.phoneForLocalBranding = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPointsForWall(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048736, this, i2) == null) {
            this.pointsForWall = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setPopNotif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z) == null) {
            this.popNotif = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setQueryKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, str) == null) {
            this.queryKey = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setScardTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, list) == null) {
            this.mScardTrackers.addAll(list);
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSecondConfirmed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            this.sencondConfirmed = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSkipTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, list) == null) {
            this.mSkipTrackers.addAll(list);
        }
    }

    public void setSplash3DLocalUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.splash3dLocalResUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSponsorUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.sponsorUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setStartTrackers(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, list) == null) {
            try {
                this.mStartTrackers.clear();
                this.mStartTrackers.addAll(list);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setSwitchButton(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048745, this, i2) == null) {
            this.switchButton = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTaskDoneForWall(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            this.taskDoneForWall = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setThirdClickTrackingUrls(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, set) == null) {
            this.mThirdClickMonitorTrackers = set;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setThirdImpressionTrackingUrls(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, set) == null) {
            this.mThirdImpMonitorTrackers = set;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, str) == null) {
            this.title = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setTooLarge(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.isTooLarge = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, str) == null) {
            this.url = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048752, this, i2) == null) {
            this.videoDuration = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i2) == null) {
            this.videoHeight = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoMuted(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z) == null) {
            this.isVideoMuted = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, str) == null) {
            this.videoUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVideoWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048756, this, i2) == null) {
            this.videoWidth = i2;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setVurl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, str) == null) {
            this.vurl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWebUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.webUrl = str;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWifiTargeted(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z) == null) {
            this.isWifiTargeted = z;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IXAdInstanceInfo
    public void setWinurl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, str) == null) {
            this.winurl = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048761, this, parcel, i2) == null) {
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
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfoExt(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
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
            this.adSource = jSONObject.optString("src", "");
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
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.impressionUrls.add(optJSONArray.getString(i4));
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
                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i5);
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
                        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                            addThirdImpMonitorTrackers(optJSONArray3.optString(i6));
                        }
                    } else if (next2.equals("vskip")) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray(next2);
                        for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                            addSkipMonitorTrackers(optJSONArray4.optString(i7));
                        }
                    } else if (next2.equals("scard")) {
                        JSONArray optJSONArray5 = optJSONObject2.optJSONArray(next2);
                        for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                            addScardMonitorTrackers(optJSONArray5.optString(i8));
                        }
                    } else if (next2.equals("ccard")) {
                        JSONArray optJSONArray6 = optJSONObject2.optJSONArray(next2);
                        for (int i9 = 0; i9 < optJSONArray6.length(); i9++) {
                            addCcardMonitorTrackers(optJSONArray6.optString(i9));
                        }
                    } else if (next2.equals("vstart")) {
                        JSONArray optJSONArray7 = optJSONObject2.optJSONArray(next2);
                        for (int i10 = 0; i10 < optJSONArray7.length(); i10++) {
                            addStartMonitorTrackers(optJSONArray7.optString(i10));
                        }
                    } else if (next2.equals("vfullscreen")) {
                        JSONArray optJSONArray8 = optJSONObject2.optJSONArray(next2);
                        for (int i11 = 0; i11 < optJSONArray8.length(); i11++) {
                            addFullScreenMonitorTrackers(optJSONArray8.optString(i11));
                        }
                    } else if (next2.equals("vclose")) {
                        JSONArray optJSONArray9 = optJSONObject2.optJSONArray(next2);
                        for (int i12 = 0; i12 < optJSONArray9.length(); i12++) {
                            addCloseMonitorTrackers(optJSONArray9.optString(i12));
                        }
                    } else if (next2.equals("cstartcard")) {
                        JSONArray optJSONArray10 = optJSONObject2.optJSONArray(next2);
                        for (int i13 = 0; i13 < optJSONArray10.length(); i13++) {
                            addCstartcardMonitorTrackers(optJSONArray10.optString(i13));
                        }
                    } else if (next2.equals("c")) {
                        JSONArray optJSONArray11 = optJSONObject2.optJSONArray(next2);
                        for (int i14 = 0; i14 < optJSONArray11.length(); i14++) {
                            addThirdClickMonitorTrackers(optJSONArray11.optString(i14));
                        }
                    } else if (next2.equals("vcache_succ")) {
                        JSONArray optJSONArray12 = optJSONObject2.optJSONArray(next2);
                        for (int i15 = 0; i15 < optJSONArray12.length(); i15++) {
                            addCacheSuccMonitorTrackers(optJSONArray12.optString(i15));
                        }
                    } else if (next2.equals("vcache_fail")) {
                        JSONArray optJSONArray13 = optJSONObject2.optJSONArray(next2);
                        for (int i16 = 0; i16 < optJSONArray13.length(); i16++) {
                            addCacheFailMonitorTrackers(optJSONArray13.optString(i16));
                        }
                    } else if (next2.equals("vcache_expire")) {
                        JSONArray optJSONArray14 = optJSONObject2.optJSONArray(next2);
                        for (int i17 = 0; i17 < optJSONArray14.length(); i17++) {
                            addCacheExpireMonitorTrackers(optJSONArray14.optString(i17));
                        }
                    }
                }
            }
            this.actionOnlyWifi = true;
            this.confirmBorderPercent = jSONObject.optString("cf", "");
            this.queryKey = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK, "");
            this.uniqueId = this.queryKey + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iXAdInstanceInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
