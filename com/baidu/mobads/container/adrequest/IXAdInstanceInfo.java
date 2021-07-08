package com.baidu.mobads.container.adrequest;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IXAdInstanceInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class CreativeType {
        public static final /* synthetic */ CreativeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CreativeType GIF;
        public static final CreativeType HTML;
        public static final CreativeType HYBRID;
        public static final CreativeType NONE;
        public static final CreativeType RM;
        public static final CreativeType STATIC_IMAGE;
        public static final CreativeType TEXT;
        public static final CreativeType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-441816155, "Lcom/baidu/mobads/container/adrequest/IXAdInstanceInfo$CreativeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-441816155, "Lcom/baidu/mobads/container/adrequest/IXAdInstanceInfo$CreativeType;");
                    return;
                }
            }
            NONE = new CreativeType("NONE", 0, "none");
            TEXT = new CreativeType("TEXT", 1, "text");
            STATIC_IMAGE = new CreativeType("STATIC_IMAGE", 2, "static_image");
            GIF = new CreativeType("GIF", 3, "gif");
            RM = new CreativeType("RM", 4, "rich_media");
            HTML = new CreativeType("HTML", 5, "html");
            HYBRID = new CreativeType("HYBRID", 6, "hybrid");
            CreativeType creativeType = new CreativeType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 7, "video");
            VIDEO = creativeType;
            $VALUES = new CreativeType[]{NONE, TEXT, STATIC_IMAGE, GIF, RM, HTML, HYBRID, creativeType};
        }

        public CreativeType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static CreativeType parse(String str) {
            InterceptResult invokeL;
            CreativeType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (CreativeType creativeType : values()) {
                    if (creativeType.value.equalsIgnoreCase(str)) {
                        return creativeType;
                    }
                }
                return null;
            }
            return (CreativeType) invokeL.objValue;
        }

        public static CreativeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CreativeType) Enum.valueOf(CreativeType.class, str) : (CreativeType) invokeL.objValue;
        }

        public static CreativeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CreativeType[]) $VALUES.clone() : (CreativeType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    boolean getAPOOpen();

    String getAction();

    int getActionType();

    int getAdContainerHeight();

    int getAdContainerSizeType();

    int getAdContainerWidth();

    boolean getAdHasDisplayed();

    String getAdId();

    String getAdSource();

    int getAntiTag();

    String getAppName();

    String getAppOpenStrs();

    String getAppPackageName();

    long getAppSize();

    String getAppStoreLink();

    String getBannerHtmlSnippet();

    String getBuyer();

    List<String> getCacheExpireTrackers();

    List<String> getCacheFailTrackers();

    List<String> getCacheSuccTrackers();

    List<String> getCcardTrackers();

    String getClickThroughUrl();

    String getClklogurl();

    List<String> getCloseTrackers();

    int getCloseType();

    String getConfirmBorderPercent();

    long getCreateTime();

    CreativeType getCreativeType();

    List<String> getCstartcardTrackers();

    String getDescription();

    int getDlTunnel();

    String getExp2ForSingleAd();

    int getExpiration();

    JSONObject getExtraParams();

    int getFeedAdStyleType();

    List<String> getFullScreenTrackers();

    String getFwt();

    int getHoursInADayToShowAd();

    String getHtmlSnippet();

    String getIconUrl();

    Set<String> getImpressionUrls();

    String getIntHtmlSnippet();

    String getLocalCreativeURL();

    int getMainMaterialHeight();

    int getMainMaterialWidth();

    String getMainPictureUrl();

    String getMaterialType();

    String getMute();

    JSONArray getNwinurl();

    String getOriginClickUrl();

    JSONObject getOriginJsonObject();

    String getPage();

    String getPhoneForLocalBranding();

    int getPointsForWall();

    String getQueryKey();

    List<String> getScardTrackers();

    List<String> getSkipTrackers();

    String getSponsorUrl();

    List<String> getStartTrackers();

    int getSwitchButton();

    List<String> getThirdClickTrackingUrls();

    List<String> getThirdImpressionTrackingUrls();

    String getTitle();

    String getUniqueId();

    String getUrl();

    int getVideoDuration();

    int getVideoHeight();

    String getVideoUrl();

    int getVideoWidth();

    String getVurl();

    String getWebUrl();

    String getWinurl();

    boolean isActionOnlyWifi();

    boolean isAutoOpen();

    boolean isCanCancel();

    boolean isCanDelete();

    boolean isClose();

    @Deprecated
    boolean isIconVisibleForImageType();

    boolean isInapp();

    boolean isNoticeDlNonWifi();

    boolean isNoticeDlNonWifiSecJump();

    boolean isPopNotif();

    boolean isSecondConfirmed();

    boolean isTaskDoneForWall();

    boolean isTooLarge();

    Boolean isValid();

    boolean isVideoMuted();

    boolean isWifiTargeted();

    void setAPOOpen(boolean z);

    void setAction(String str);

    void setActionOnlyWifi(boolean z);

    void setActionType(int i2);

    void setAdContainerHeight(int i2);

    void setAdContainerSizeType(int i2);

    void setAdContainerWidth(int i2);

    void setAdHasDisplayed(boolean z);

    void setAdId(String str);

    void setAdSource(String str);

    void setAntiTag(int i2);

    void setAppName(String str);

    void setAppOpenStrs(String str);

    void setAppPackageName(String str);

    void setAppSize(long j);

    void setAutoOpen(boolean z);

    void setBannerHtmlSnippet(String str);

    void setBuyer(String str);

    void setCacheExpireTrackers(List<String> list);

    void setCacheFailTrackers(List<String> list);

    void setCacheSuccTrackers(List<String> list);

    void setCanCancel(boolean z);

    void setCanDelete(boolean z);

    void setCcardTrackers(List<String> list);

    void setClickThroughUrl(String str);

    void setClklogurl(String str);

    void setClose(boolean z);

    void setCloseTrackers(List<String> list);

    void setCloseType(int i2);

    void setConfirmBorderPercent(String str);

    void setCreateTime(long j);

    void setCreativeType(CreativeType creativeType);

    void setCstartcardTrackers(List<String> list);

    void setDescription(String str);

    void setDlTunnel(int i2);

    void setExp2ForSingleAd(String str);

    void setExpiration(int i2);

    void setFeedAdStyleType(int i2);

    void setFullScreenTrackers(List<String> list);

    void setFwt(String str);

    @Deprecated
    void setHoursInADayToShowAd(int i2);

    void setHtmlSnippet(String str);

    void setIconUrl(String str);

    @Deprecated
    void setIconVisibleForImageType(boolean z);

    void setImpressionUrls(Set<String> set);

    void setInapp(boolean z);

    void setIntHtmlSnippet(String str);

    void setLocalCreativeURL(String str);

    void setMainMaterialHeight(int i2);

    void setMainMaterialWidth(int i2);

    void setMainPictureUrl(String str);

    void setMaterialType(String str);

    void setMute(String str);

    void setNwinurl(JSONArray jSONArray);

    void setOriginClickUrl(String str);

    void setPage(String str);

    void setPhoneForLocalBranding(String str);

    void setPointsForWall(int i2);

    void setPopNotif(boolean z);

    void setQueryKey(String str);

    void setScardTrackers(List<String> list);

    void setSecondConfirmed(boolean z);

    void setSkipTrackers(List<String> list);

    void setSponsorUrl(String str);

    void setStartTrackers(List<String> list);

    void setSwitchButton(int i2);

    void setTaskDoneForWall(boolean z);

    void setThirdClickTrackingUrls(Set<String> set);

    void setThirdImpressionTrackingUrls(Set<String> set);

    void setTitle(String str);

    void setTooLarge(boolean z);

    void setUrl(String str);

    void setVideoDuration(int i2);

    void setVideoHeight(int i2);

    void setVideoMuted(boolean z);

    void setVideoUrl(String str);

    void setVideoWidth(int i2);

    void setVurl(String str);

    void setWebUrl(String str);

    void setWifiTargeted(boolean z);

    void setWinurl(String str);
}
