package com.baidu.mobads.sdk.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ISecurityInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADSERV_PHP_URL = "http://mobads.baidu.com/ads/pa/8/reconfig/__pasys_remote_banner.php";
    public static final String AD_CLICK_THRU = "AdClickThru";
    public static final String AD_DATA_LOADED = "AdLoadData";
    public static final String AD_DOWNLOAD_WINDOW = "adDownloadWindow";
    public static final String AD_DURATION_CHANGE = "AdDurationChange";
    public static final String AD_EMPTY = "AdEmptyList";
    public static final String AD_ERROR = "AdError";
    public static final String AD_EXPANDED_CHANGE = "AdExpandedChange";
    public static final String AD_FINISH_ACTIVITY = "AdFinishActivity";
    public static final String AD_IMPRESSION = "AdImpression";
    public static final String AD_INTERACTION = "AdInteraction";
    public static final String AD_LINEAR_CHANGE = "AdLinearChange";
    public static final String AD_LOADED = "AdLoaded";
    public static final String AD_LOG = "AdLog";
    public static final String AD_LOGO = "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    public static final String AD_LP_CLOSED = "AdLpClosed";
    public static final String AD_PAUSED = "AdPaused";
    public static final String AD_PERMISSION_CLICK = "adPermissionClick";
    public static final String AD_PLAYING = "AdPlaying";
    public static final String AD_PLAY_COMPLETION = "playCompletion";
    public static final String AD_PRIVACY_CLICK = "adPrivacyClick";
    public static final String AD_REMAINING_TIME_CHANGE = "AdRemainingTimeChange";
    public static final String AD_RVIDEO_PLAY_ERROR = "AdRvdieoPlayError";
    public static final String AD_SIZE_CHANGE = "AdSizeChange";
    public static final String AD_SKIPPABLE_STATE_CHANGED = "AdSkippableStateChange";
    public static final String AD_SKIPPED = "AdSkipped";
    public static final String AD_STARTED = "AdStarted";
    public static final String AD_START_LP = "AdStartLp";
    public static final String AD_STATUS_CHANGE = "AdStatusChange";
    public static final String AD_STOPPED = "AdStopped";
    public static final String AD_USER_ACCEPT_INVITATION = "AdUserAcceptInvitation";
    public static final String AD_USER_CLICK = "AdUserClick";
    public static final String AD_USER_CLOSE = "AdUserClose";
    public static final String AD_USER_MINIMIZE = "AdUserMinimize";
    public static final String AD_VIDEO_COMPLETE = "AdVideoComplete";
    public static final String AD_VIDEO_FIRST_QUARTILE = "AdVideoFirstQuartile";
    public static final String AD_VIDEO_MIDPOINT = "AdVideoMidpoint";
    public static final String AD_VIDEO_START = "AdVideoStart";
    public static final String AD_VIDEO_THIRD_QUARTILE = "AdVideoThirdQuartile";
    public static final String AD_VOLUME_CHANGE = "AdVolumeChange";
    public static final String BAIDU_LOGO = "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    public static final String CRASH_LOG_URL = "https://mobads-logs.baidu.com/brwhis.log";
    public static final String CRASH_PROXY_ANTI = "com.bd.mobpack";
    public static final String CRASH_PROXY_COMMON = "com.baidu.mobads.sdk";
    public static final String CRASH_REMOTE_CONTAINER = "com.baidu.mobads.container";
    public static final String CRASH_THIRD_MTJ = "com.baidu.mobstat.forbes";
    public static final String FEED_MARKETING_REMOTELABEL = "com.style.widget.RemoteMarketingLabel";
    public static final String FEED_MARKETING_REMOTETextView = "com.style.widget.RemoteMarketingTextView";
    public static final String FEED_SMART_REMOTENATIVEVIEW = "com.style.widget.RemoteNativeView";
    public static final String GENERATE_CLASS_DIR = "com.baidu.mobads.sdk.api.annotation.";
    public static final String HYBRID_REQUEST_INFO = "com.baidu.mobads.container.adrequest.HybridAdRequestInfo";
    public static final String NATIVE_CPU_DATA = "com.baidu.mobads.container.nativecpu.interfaces.ICPUAdInstance";
    public static final String PROD_REQUEST_INFO = "com.baidu.mobads.container.adrequest.ProdAdRequestInfo";
    public static final String REMOTE_AD_FACTORY = "com.baidu.mobads.container.AllInOneXAdContainerFactory";
    public static final String REMOTE_REFLECT_INTERFACE = "com.component.interfaces.RemoteReflectInterface";
    public static final String STATISTICS_LOG_URL = "https://mobads-logs.baidu.com/dz.zb";
    public static final String UNION_LOGO_CLICK = "unionLogoClick";
    public static final String VIDEO_CACHE_FAILED = "vdieoCacheFailed";
    public static final String VIDEO_CACHE_SUCC = "vdieoCacheSucc";
    public static final String __SP_NAME_APK_LOADER__ = "com.baidu.mobads.loader";
    public transient /* synthetic */ FieldHolder $fh;

    public ISecurityInfo() {
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
}
