package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ActivitySpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHECK_AND_SEND_ACTIVE_CONFIG_DURATION = "checkAndSendActiveConfig";
    public static final String CHECK_CLIENT_CONFIG_MESSAGE_DURATION = "checkClientConfigMessage";
    public static final String CHECK_PLUGIN_ENTRANCE_STATE_DURATION = "checkPluginEntranceState";
    public static final String CHECK_REAL_NAME_DURATION = "checkRealName";
    public static final String CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_DURATION = "clearConcernCacheWhenVersionUpdate";
    public static final String CREATE_START_GAP_DURATION = "onCreate2StartGap";
    public static final String FIRST_FRAGMENT_CREATE_DURATION = "fFlutterFragmentCreate";
    public static final String INIT_COOKIE_DURATION = "initCookie";
    public static final String INIT_HOME_FRAGMENT_CONTROLLER_DURATION = "initHomeFragmentController";
    public static final String INIT_TABS_ON_ACTIVITY_CREATED_DURATION = "initTabsOnActivityCreated";
    public static final String LOGO_START_2_SPLASH_SHOW = "logoStart2SplashShow";
    public static final String MAINACTIVITY_ONCREATE_DURAION = "onCreate";
    public static final String MAINACTIVITY_SUPER_ONCREATE_DURAION = "superOnCreate";
    public static final String MAIN_ACTIVITY_CREATE_END_DURATION = "mainActivityCreateEndTotal";
    public static final String MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION = "sMainOnCreate2DataLoaded";
    public static final String MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION = "sMainDataLoaded2End";
    public static final String MAIN_ACTIVITY_TOTAL_DURATION = "mainActivityTotal";
    public static final String ONRESUME_DURATION = "onResume";
    public static final String ONSTART_DURATION = "onStart";
    public static final String REG_RECEIVER_DURATION = "regReceiverDuration";
    public static final String SECOND_FRAGMENT_CREATE_DURATION = "sFlutterFragmentCreate";
    public static final String SPLASH_ACTIVITY2MAINACTIVITY_GAP = "splashMainGap";
    public static final String SPLASH_ACTIVITY_DURATION = "splash";
    public static final String SPLASH_AD_LOAD_AND_PREPARE_DURATION = "splashLoadAndPrepareAd";
    public static final String SPLASH_BES_LOADAD_DURATION = "splashBesLoadAd";
    public static final String SPLASH_CALL_AD_SHOW_DURATION = "splashCallShow";
    public static final String SPLASH_FIRST_HANDLER_DURATION = "splashFirstHandler";
    public static final String SPLASH_ONCREATE_DURATION = "splashOnCreate";
    public static final String SPLASH_ONRESUME_DURATION = "splashOnResume";
    public static final String SPLASH_SHOW_DURATION = "splashShow";
    public static final String SPLASH_TB_LOADAD_DURATION = "splashTbLoadAd";
    public static final String START_RESUME_GAP_DURATION = "onStart2ResumeGap";
    public static final String START_TRACK_CONFIG_REQUEST_DURATION = "startTrackConfigRequest";
    public static final String TRY_LOAD_NATIVE_FUN_AD_DURATION = "tryLoadNativeFunAd";
    public static final String UPDATE_PROFILE_INFO_DURATION = "updateProfileInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public long mCheckAndSendActiveConfigMessageEndTimeStamp;
    public long mCheckAndSendActiveConfigMessageStartTimeStamp;
    public long mCheckClientConfigMessageEndTimeStamp;
    public long mCheckClientConfigMessageStartTimeStamp;
    public long mCheckPluginEntranceStateEndTimeStamp;
    public long mCheckPluginEntranceStateStartTimeStamp;
    public long mCheckRealNameEndTimeStamp;
    public long mCheckRealNameStartTimeStamp;
    public long mClearConcernCacheWhenVersionUpdateEndTimeStamp;
    public long mClearConcernCacheWhenVersionUpdateStartTimeStamp;
    public int mCreateFlutterCount;
    public long mFirstFlutterFragmentEndTimeStamp;
    public long mFirstFlutterFragmentStartTimeStamp;
    public long mInitCookieEndTimeStamp;
    public long mInitCookieStartTimeStamp;
    public long mInitHomeFragmentControllerEndTimeStamp;
    public long mInitHomeFragmentControllerStartTimeStamp;
    public long mInitTabsOnActivityCreatedEndTimeStamp;
    public long mInitTabsOnActivityCreatedStartTimeStamp;
    public long mMainActivityCacheDataLoadedTimeStamp;
    public long mMainActivityCreateEndTimeStamp;
    public long mMainActivityCreateStartTimeStamp;
    public long mMainActivityNetDataLoadedTimeStamp;
    public long mMainActivityOnResumeEndTimeStamp;
    public long mMainActivityOnResumeStartTimeStamp;
    public long mMainActivityOnstartEndTimeStamp;
    public long mMainActivityOnstartStartTimeStamp;
    public long mMainActivitySuperCreateEndTimeStamp;
    public long mRegReceiverEndTimeStamp;
    public long mRegReceiverStartTimeStamp;
    public long mSecondFlutterFragmentEndTimeStamp;
    public long mSecondFlutterFragmentStartTimeStamp;
    public long mSplashActivityEndTimeStamp;
    public long mSplashActivityStartTimeStamp;
    public long mSplashAdShowEndTimeStamp;
    public long mSplashAdShowStartTimeStamp;
    public long mSplashAdloadStartTimeStamp;
    public long mSplashFirstHandlerRun;
    public long mSplashOnCreateEndTimeStamp;
    public long mSplashOnResumeEndTimeStamp;
    public long mSplashOnResumeStartTimeStamp;
    public long mSplashTbAdCallShowTimeStamp;
    public long mSplashTbAdloadEndTimeStamp;
    public long mStartTrackConfigRequestEndTimeStamp;
    public long mStartTrackConfigRequestStartTimeStamp;
    public long mTryLoadNativeFunAdEndTimeStamp;
    public long mTryLoadNativeFunAdStartTimeStamp;
    public long mUpdateProfileInfoEndTimeStamp;
    public long mUpdateProfileInfoStartTimeStamp;

    public ActivitySpeedStats() {
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
        this.mSplashActivityStartTimeStamp = -1L;
        this.mSplashActivityEndTimeStamp = -1L;
        this.mSplashOnCreateEndTimeStamp = -1L;
        this.mSplashOnResumeStartTimeStamp = -1L;
        this.mSplashOnResumeEndTimeStamp = -1L;
        this.mSplashAdloadStartTimeStamp = -1L;
        this.mSplashTbAdloadEndTimeStamp = -1L;
        this.mSplashTbAdCallShowTimeStamp = -1L;
        this.mSplashAdShowStartTimeStamp = -1L;
        this.mSplashAdShowEndTimeStamp = -1L;
        this.mSplashFirstHandlerRun = -1L;
        this.mMainActivityCreateStartTimeStamp = -1L;
        this.mMainActivitySuperCreateEndTimeStamp = -1L;
        this.mInitHomeFragmentControllerStartTimeStamp = -1L;
        this.mInitHomeFragmentControllerEndTimeStamp = -1L;
        this.mCheckPluginEntranceStateStartTimeStamp = -1L;
        this.mCheckPluginEntranceStateEndTimeStamp = -1L;
        this.mRegReceiverStartTimeStamp = -1L;
        this.mRegReceiverEndTimeStamp = -1L;
        this.mCheckClientConfigMessageStartTimeStamp = -1L;
        this.mCheckClientConfigMessageEndTimeStamp = -1L;
        this.mCheckAndSendActiveConfigMessageStartTimeStamp = -1L;
        this.mCheckAndSendActiveConfigMessageEndTimeStamp = -1L;
        this.mInitTabsOnActivityCreatedStartTimeStamp = -1L;
        this.mInitTabsOnActivityCreatedEndTimeStamp = -1L;
        this.mInitCookieStartTimeStamp = -1L;
        this.mInitCookieEndTimeStamp = -1L;
        this.mStartTrackConfigRequestStartTimeStamp = -1L;
        this.mStartTrackConfigRequestEndTimeStamp = -1L;
        this.mCheckRealNameStartTimeStamp = -1L;
        this.mCheckRealNameEndTimeStamp = -1L;
        this.mClearConcernCacheWhenVersionUpdateStartTimeStamp = -1L;
        this.mClearConcernCacheWhenVersionUpdateEndTimeStamp = -1L;
        this.mUpdateProfileInfoStartTimeStamp = -1L;
        this.mUpdateProfileInfoEndTimeStamp = -1L;
        this.mTryLoadNativeFunAdStartTimeStamp = -1L;
        this.mTryLoadNativeFunAdEndTimeStamp = -1L;
        this.mMainActivityCreateEndTimeStamp = -1L;
        this.mMainActivityOnstartStartTimeStamp = -1L;
        this.mMainActivityOnstartEndTimeStamp = -1L;
        this.mMainActivityOnResumeStartTimeStamp = -1L;
        this.mMainActivityOnResumeEndTimeStamp = -1L;
        this.mCreateFlutterCount = 0;
        this.mFirstFlutterFragmentStartTimeStamp = -1L;
        this.mFirstFlutterFragmentEndTimeStamp = -1L;
        this.mSecondFlutterFragmentStartTimeStamp = -1L;
        this.mSecondFlutterFragmentEndTimeStamp = -1L;
        this.mMainActivityCacheDataLoadedTimeStamp = -1L;
        this.mMainActivityNetDataLoadedTimeStamp = -1L;
    }

    private long getCreateEndTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - this.mMainActivityCreateStartTimeStamp : invokeV.longValue;
    }

    private long getMainDataLoaded2EndDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp();
            long j2 = this.mMainActivityCacheDataLoadedTimeStamp;
            if (j2 == -1) {
                j2 = this.mMainActivityNetDataLoadedTimeStamp;
            }
            return Math.min(appLaunchEndTimeStamp - j2, appLaunchEndTimeStamp - this.mMainActivityCreateStartTimeStamp);
        }
        return invokeV.longValue;
    }

    private long getMainOnCreate2DataLoadedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            long j2 = this.mMainActivityCacheDataLoadedTimeStamp;
            if (j2 == -1) {
                j2 = this.mMainActivityNetDataLoadedTimeStamp;
            }
            return Math.max(0L, j2 - this.mMainActivityCreateStartTimeStamp);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            switch (i2) {
                case 3000:
                    this.mSplashActivityStartTimeStamp = j2;
                    return;
                case 3001:
                    this.mSplashActivityEndTimeStamp = j2;
                    return;
                case 3002:
                    this.mMainActivityCreateStartTimeStamp = j2;
                    return;
                case 3003:
                    this.mMainActivitySuperCreateEndTimeStamp = j2;
                    return;
                case 3004:
                    this.mInitHomeFragmentControllerStartTimeStamp = j2;
                    return;
                case 3005:
                    this.mInitHomeFragmentControllerEndTimeStamp = j2;
                    return;
                case 3006:
                    this.mCheckPluginEntranceStateStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY /* 3007 */:
                    this.mCheckPluginEntranceStateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY /* 3008 */:
                    this.mRegReceiverStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY /* 3009 */:
                    this.mRegReceiverEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY /* 3010 */:
                    this.mCheckClientConfigMessageStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY /* 3011 */:
                    this.mCheckClientConfigMessageEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_START_STAMP_KEY /* 3012 */:
                    this.mCheckAndSendActiveConfigMessageStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_END_STAMP_KEY /* 3013 */:
                    this.mCheckAndSendActiveConfigMessageEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY /* 3014 */:
                    this.mInitTabsOnActivityCreatedStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY /* 3015 */:
                    this.mInitTabsOnActivityCreatedEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY /* 3016 */:
                    this.mInitCookieStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY /* 3017 */:
                    this.mInitCookieEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_START_STAMP_KEY /* 3018 */:
                    this.mStartTrackConfigRequestStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_END_STAMP_KEY /* 3019 */:
                    this.mStartTrackConfigRequestEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_REAL_NAME_START_STAMP_KEY /* 3020 */:
                    this.mCheckRealNameStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY /* 3021 */:
                    this.mCheckRealNameEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_START_STAMP_KEY /* 3022 */:
                    this.mClearConcernCacheWhenVersionUpdateStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_END_STAMP_KEY /* 3023 */:
                    this.mClearConcernCacheWhenVersionUpdateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY /* 3024 */:
                    this.mUpdateProfileInfoStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY /* 3025 */:
                    this.mUpdateProfileInfoEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY /* 3026 */:
                    this.mTryLoadNativeFunAdStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY /* 3027 */:
                    this.mTryLoadNativeFunAdEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY /* 3028 */:
                    this.mMainActivityCreateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY /* 3029 */:
                    this.mMainActivityOnstartStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY /* 3030 */:
                    this.mMainActivityOnstartEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY /* 3031 */:
                    this.mMainActivityOnResumeStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY /* 3032 */:
                    this.mMainActivityOnResumeEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ONCREATE_END_STAMP_KEY /* 3033 */:
                    this.mSplashOnCreateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ADLOAD_START_STAMP_KEY /* 3034 */:
                    this.mSplashAdloadStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_TB_ADLOAD_END_STAMP_KEY /* 3035 */:
                    this.mSplashTbAdloadEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_START_STAMP_KEY /* 3036 */:
                    this.mSplashAdShowStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_END_STAMP_KEY /* 3037 */:
                    this.mSplashAdShowEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_START_KEY /* 3038 */:
                    int i3 = this.mCreateFlutterCount;
                    if (i3 == 0) {
                        this.mFirstFlutterFragmentStartTimeStamp = j2;
                        return;
                    } else if (i3 == 1) {
                        this.mSecondFlutterFragmentStartTimeStamp = j2;
                        return;
                    } else {
                        return;
                    }
                case SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_END_KEY /* 3039 */:
                    int i4 = this.mCreateFlutterCount;
                    if (i4 == 0) {
                        this.mFirstFlutterFragmentEndTimeStamp = j2;
                    } else if (i4 == 1) {
                        this.mSecondFlutterFragmentEndTimeStamp = j2;
                    }
                    this.mCreateFlutterCount++;
                    return;
                case SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_START_KEY /* 3040 */:
                case SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_END_KEY /* 3041 */:
                default:
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_AD_CALLSHOW_STAMP_KEY /* 3042 */:
                    this.mSplashTbAdCallShowTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY /* 3043 */:
                    if (this.mMainActivityCacheDataLoadedTimeStamp == -1) {
                        this.mMainActivityCacheDataLoadedTimeStamp = j2;
                        return;
                    }
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY /* 3044 */:
                    if (this.mMainActivityNetDataLoadedTimeStamp == -1) {
                        this.mMainActivityNetDataLoadedTimeStamp = j2;
                        return;
                    }
                    return;
                case SpeedStatsStampTable.SPLASH_ACTIVITY_ON_RESUME_START_STAMP_KEY /* 3045 */:
                    this.mSplashOnResumeStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASH_ACTIVITY_ON_RESUME_END_STAMP_KEY /* 3046 */:
                    this.mSplashOnResumeEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASH_ACTIVITY_FIRST_HANDLER_RUN /* 3047 */:
                    this.mSplashFirstHandlerRun = j2;
                    return;
            }
        }
    }

    public long getMainActivityCreateStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMainActivityCreateStartTimeStamp : invokeV.longValue;
    }

    public long getMainActivityOnResumeEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMainActivityOnResumeEndTimeStamp : invokeV.longValue;
    }

    public long getSplashActivityConstTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.mSplashAdShowEndTimeStamp - this.mSplashAdShowStartTimeStamp;
            if (j2 > 0) {
                return j2;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMainActivityOnResumeEndTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSplashActivityStartTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j8 = this.mMainActivityOnResumeEndTimeStamp;
            long j9 = this.mSplashActivityStartTimeStamp;
            long j10 = j8 - j9;
            long j11 = this.mSplashActivityEndTimeStamp - j9;
            long j12 = this.mSplashOnCreateEndTimeStamp - j9;
            long j13 = this.mSplashOnResumeEndTimeStamp - this.mSplashOnResumeStartTimeStamp;
            long j14 = this.mSplashAdShowStartTimeStamp;
            if (j14 > 0) {
                long j15 = this.mSplashTbAdloadEndTimeStamp;
                long j16 = j15 - this.mSplashAdloadStartTimeStamp;
                long j17 = this.mSplashTbAdCallShowTimeStamp;
                j5 = j17 - j15;
                long j18 = j14 - j17;
                j2 = this.mSplashFirstHandlerRun - j15;
                j3 = j16;
                j4 = j18;
            } else {
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
            }
            long j19 = this.mSplashAdShowStartTimeStamp;
            if (j19 > 0) {
                j6 = j2;
                j7 = j19 - this.mSplashAdloadStartTimeStamp;
            } else {
                j6 = j2;
                j7 = this.mSplashActivityEndTimeStamp - this.mSplashAdloadStartTimeStamp;
            }
            long j20 = j7;
            long j21 = this.mSplashAdShowEndTimeStamp - this.mSplashAdShowStartTimeStamp;
            if (j21 < 0) {
                j21 = 0;
            }
            long j22 = j21;
            long j23 = this.mMainActivityCreateStartTimeStamp - this.mSplashAdShowEndTimeStamp;
            if (j23 < 0 || j23 > 60000) {
                j23 = this.mMainActivityCreateStartTimeStamp - this.mSplashActivityEndTimeStamp;
            }
            long j24 = this.mMainActivityCreateEndTimeStamp;
            long j25 = j3;
            long j26 = this.mMainActivityCreateStartTimeStamp;
            long j27 = j24 - j26;
            long j28 = j23;
            long j29 = this.mMainActivitySuperCreateEndTimeStamp - j26;
            long j30 = this.mInitHomeFragmentControllerEndTimeStamp - this.mInitHomeFragmentControllerStartTimeStamp;
            long j31 = this.mCheckPluginEntranceStateEndTimeStamp - this.mCheckPluginEntranceStateStartTimeStamp;
            long j32 = this.mRegReceiverEndTimeStamp - this.mRegReceiverStartTimeStamp;
            long j33 = this.mCheckClientConfigMessageEndTimeStamp - this.mCheckClientConfigMessageStartTimeStamp;
            long j34 = this.mCheckAndSendActiveConfigMessageEndTimeStamp - this.mCheckAndSendActiveConfigMessageStartTimeStamp;
            long j35 = this.mInitTabsOnActivityCreatedEndTimeStamp - this.mInitTabsOnActivityCreatedStartTimeStamp;
            long j36 = this.mInitCookieEndTimeStamp - this.mInitCookieStartTimeStamp;
            long j37 = this.mStartTrackConfigRequestEndTimeStamp - this.mStartTrackConfigRequestStartTimeStamp;
            long j38 = this.mCheckRealNameEndTimeStamp - this.mCheckRealNameStartTimeStamp;
            long j39 = this.mClearConcernCacheWhenVersionUpdateEndTimeStamp - this.mClearConcernCacheWhenVersionUpdateStartTimeStamp;
            long j40 = this.mUpdateProfileInfoEndTimeStamp - this.mUpdateProfileInfoStartTimeStamp;
            long j41 = this.mTryLoadNativeFunAdEndTimeStamp - this.mTryLoadNativeFunAdStartTimeStamp;
            long j42 = this.mMainActivityOnstartEndTimeStamp;
            long j43 = this.mMainActivityOnstartStartTimeStamp;
            long j44 = j42 - j43;
            long j45 = j43 - j24;
            long j46 = this.mMainActivityOnResumeEndTimeStamp;
            long j47 = this.mMainActivityOnResumeStartTimeStamp;
            long j48 = j46 - j47;
            long j49 = j47 - j42;
            long j50 = this.mFirstFlutterFragmentEndTimeStamp - this.mFirstFlutterFragmentStartTimeStamp;
            long j51 = this.mSecondFlutterFragmentEndTimeStamp - this.mSecondFlutterFragmentStartTimeStamp;
            long mainOnCreate2DataLoadedDuration = getMainOnCreate2DataLoadedDuration();
            long mainDataLoaded2EndDuration = getMainDataLoaded2EndDuration();
            long createEndTotalDuration = getCreateEndTotalDuration();
            if (j10 < 0 || j10 > 60000 || j11 < 0 || j11 > 60000 || j12 < 0 || j12 > 60000 || j13 < 0 || j13 > 60000 || j28 < 0 || j28 > 60000 || j27 < 0 || j27 > 60000 || j29 < 0 || j29 > 60000 || j30 < 0 || j30 > 60000 || j31 < 0 || j31 > 60000 || j32 < 0 || j32 > 60000 || j33 < 0 || j33 > 60000 || j34 < 0 || j34 > 60000 || j35 < 0 || j35 > 60000 || j36 < 0 || j36 > 60000 || j37 < 0 || j37 > 60000 || j38 < 0 || j38 > 60000 || j39 < 0 || j39 > 60000 || j40 < 0 || j40 > 60000 || j41 < 0 || j41 > 60000 || j44 < 0 || j44 > 60000 || j48 < 0 || j48 > 60000 || j45 < 0 || j45 > 60000 || j49 < 0 || j49 > 60000 || mainOnCreate2DataLoadedDuration < 0 || mainOnCreate2DataLoadedDuration > 60000 || mainDataLoaded2EndDuration < 0 || mainDataLoaded2EndDuration > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(MAIN_ACTIVITY_TOTAL_DURATION, String.valueOf(j10));
            hashMap.put("splash", String.valueOf(j11));
            hashMap.put(SPLASH_ONCREATE_DURATION, String.valueOf(j12));
            hashMap.put(SPLASH_ONRESUME_DURATION, String.valueOf(j13));
            hashMap.put(SPLASH_TB_LOADAD_DURATION, String.valueOf(j25));
            hashMap.put(SPLASH_AD_LOAD_AND_PREPARE_DURATION, String.valueOf(j20));
            hashMap.put(SPLASH_BES_LOADAD_DURATION, String.valueOf(j5));
            hashMap.put(SPLASH_FIRST_HANDLER_DURATION, String.valueOf(j6));
            hashMap.put(SPLASH_CALL_AD_SHOW_DURATION, String.valueOf(j4));
            hashMap.put(SPLASH_SHOW_DURATION, String.valueOf(j22));
            hashMap.put(SPLASH_ACTIVITY2MAINACTIVITY_GAP, String.valueOf(j28));
            hashMap.put("onCreate", String.valueOf(j27));
            hashMap.put(MAINACTIVITY_SUPER_ONCREATE_DURAION, String.valueOf(j29));
            hashMap.put(INIT_HOME_FRAGMENT_CONTROLLER_DURATION, String.valueOf(j30));
            hashMap.put(CHECK_PLUGIN_ENTRANCE_STATE_DURATION, String.valueOf(j31));
            hashMap.put(REG_RECEIVER_DURATION, String.valueOf(j32));
            hashMap.put(CHECK_CLIENT_CONFIG_MESSAGE_DURATION, String.valueOf(j33));
            hashMap.put(CHECK_AND_SEND_ACTIVE_CONFIG_DURATION, String.valueOf(j34));
            hashMap.put(INIT_TABS_ON_ACTIVITY_CREATED_DURATION, String.valueOf(j35));
            hashMap.put(INIT_COOKIE_DURATION, String.valueOf(j36));
            hashMap.put(START_TRACK_CONFIG_REQUEST_DURATION, String.valueOf(j37));
            hashMap.put(CHECK_REAL_NAME_DURATION, String.valueOf(j38));
            hashMap.put(CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_DURATION, String.valueOf(j39));
            hashMap.put(UPDATE_PROFILE_INFO_DURATION, String.valueOf(j40));
            hashMap.put(TRY_LOAD_NATIVE_FUN_AD_DURATION, String.valueOf(j41));
            hashMap.put("onStart", String.valueOf(j44));
            hashMap.put("onResume", String.valueOf(j48));
            hashMap.put(CREATE_START_GAP_DURATION, String.valueOf(j45));
            hashMap.put(START_RESUME_GAP_DURATION, String.valueOf(j49));
            hashMap.put(FIRST_FRAGMENT_CREATE_DURATION, String.valueOf(j50));
            hashMap.put(SECOND_FRAGMENT_CREATE_DURATION, String.valueOf(j51));
            hashMap.put(MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION, String.valueOf(mainOnCreate2DataLoadedDuration));
            hashMap.put(MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION, String.valueOf(mainDataLoaded2EndDuration));
            hashMap.put(MAIN_ACTIVITY_CREATE_END_DURATION, String.valueOf(createEndTotalDuration));
            long j52 = this.mSplashAdShowStartTimeStamp - this.mSplashActivityStartTimeStamp;
            if (j52 >= 0 && j52 < 60000) {
                hashMap.put(LOGO_START_2_SPLASH_SHOW, String.valueOf(j52));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j10, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put("activity", jsonData);
                    return true;
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mSplashActivityStartTimeStamp = -1L;
            this.mSplashActivityEndTimeStamp = -1L;
            this.mMainActivityCreateStartTimeStamp = -1L;
            this.mMainActivityCreateEndTimeStamp = -1L;
            this.mMainActivitySuperCreateEndTimeStamp = -1L;
            this.mInitHomeFragmentControllerStartTimeStamp = -1L;
            this.mInitHomeFragmentControllerEndTimeStamp = -1L;
            this.mCheckPluginEntranceStateStartTimeStamp = -1L;
            this.mCheckPluginEntranceStateEndTimeStamp = -1L;
            this.mRegReceiverStartTimeStamp = -1L;
            this.mRegReceiverEndTimeStamp = -1L;
            this.mCheckClientConfigMessageStartTimeStamp = -1L;
            this.mCheckClientConfigMessageEndTimeStamp = -1L;
            this.mCheckAndSendActiveConfigMessageStartTimeStamp = -1L;
            this.mCheckAndSendActiveConfigMessageEndTimeStamp = -1L;
            this.mInitTabsOnActivityCreatedStartTimeStamp = -1L;
            this.mInitTabsOnActivityCreatedEndTimeStamp = -1L;
            this.mInitCookieStartTimeStamp = -1L;
            this.mInitCookieEndTimeStamp = -1L;
            this.mStartTrackConfigRequestStartTimeStamp = -1L;
            this.mStartTrackConfigRequestEndTimeStamp = -1L;
            this.mCheckRealNameStartTimeStamp = -1L;
            this.mCheckRealNameEndTimeStamp = -1L;
            this.mClearConcernCacheWhenVersionUpdateStartTimeStamp = -1L;
            this.mClearConcernCacheWhenVersionUpdateEndTimeStamp = -1L;
            this.mUpdateProfileInfoStartTimeStamp = -1L;
            this.mUpdateProfileInfoEndTimeStamp = -1L;
            this.mTryLoadNativeFunAdStartTimeStamp = -1L;
            this.mTryLoadNativeFunAdEndTimeStamp = -1L;
            this.mMainActivityOnstartStartTimeStamp = -1L;
            this.mMainActivityOnstartEndTimeStamp = -1L;
            this.mMainActivityOnResumeStartTimeStamp = -1L;
            this.mMainActivityOnResumeEndTimeStamp = -1L;
            this.mCreateFlutterCount = 0;
            this.mFirstFlutterFragmentStartTimeStamp = -1L;
            this.mFirstFlutterFragmentEndTimeStamp = -1L;
            this.mSecondFlutterFragmentStartTimeStamp = -1L;
            this.mSecondFlutterFragmentEndTimeStamp = -1L;
            this.mMainActivityCacheDataLoadedTimeStamp = -1L;
            this.mMainActivityNetDataLoadedTimeStamp = -1L;
        }
    }
}
