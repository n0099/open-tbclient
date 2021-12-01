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
/* loaded from: classes9.dex */
public final class ActivitySpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHECK_AND_SEND_ACTIVE_CONFIG_DURATION = "checkAndSendActiveConfig";
    public static final String CHECK_CLIENT_CONFIG_MESSAGE_DURATION = "checkClientConfigMessage";
    public static final String CHECK_PLUGIN_ENTRANCE_STATE_DURATION = "checkPluginEntranceState";
    public static final String CHECK_REAL_NAME_DURATION = "checkRealName";
    public static final String CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_DURATION = "clearConcernCacheWhenVersionUpdate";
    public static final String CREATE_START_GAP_DURATION = "onCreate2StartGap";
    public static final String FLUTTER_FRAGMENT_CREATE_DURATION = "flutterFragmentCreate";
    public static final String INIT_COOKIE_DURATION = "initCookie";
    public static final String INIT_HOME_FRAGMENT_CONTROLLER_DURATION = "initHomeFragmentController";
    public static final String INIT_TABS_ON_ACTIVITY_CREATED_DURATION = "initTabsOnActivityCreated";
    public static final String LOGO_ACTIVITY_DURATION = "logoActivity";
    public static final String LOGO_ONCREATE_DURATION = "logoOnCreate";
    public static final String LOGO_ONDESTROY_DURATION = "logoOnDestroy";
    public static final String LOGO_ONRESUME_DURATION = "logoOnResume";
    public static final String LOGO_TO_MAIN_GAP = "logo2MainGap";
    public static final String LOGO_TO_NEWLOGO_GAP = "logo2NewLogoGap";
    public static final String MAINACTIVITY_ONCREATE_DURAION = "onCreate";
    public static final String MAINACTIVITY_SUPER_ONCREATE_DURAION = "superOnCreate";
    public static final String MAIN_ACTIVITY_ALL_PURE = "mainActivityAllPure";
    public static final String MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION = "sMainOnCreate2DataLoaded";
    public static final String MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION = "sMainDataLoaded2End";
    public static final String MAIN_ACTIVITY_TOTAL_DURATION = "mainActivityTotal";
    public static final String NEWLOGO_TO_MAIN_GAP = "newLogo2MainGap";
    public static final String NEW_LOGO_ACTIVITY_DURATION = "newLogoActivity";
    public static final String NEW_LOGO_ONCREATE_DURATION = "newLogoOnCreate";
    public static final String NEW_LOGO_ONDESTROY_DURATION = "newLogoOnDestroy";
    public static final String ONRESUME_DURATION = "onResume";
    public static final String ONSTART_DURATION = "onStart";
    public static final String REG_RECEIVER_DURATION = "regReceiverDuration";
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
    public long mFlutterFragmentEndTimeStamp;
    public long mFlutterFragmentStartTimeStamp;
    public long mInitCookieEndTimeStamp;
    public long mInitCookieStartTimeStamp;
    public long mInitHomeFragmentControllerEndTimeStamp;
    public long mInitHomeFragmentControllerStartTimeStamp;
    public long mInitTabsOnActivityCreatedEndTimeStamp;
    public long mInitTabsOnActivityCreatedStartTimeStamp;
    public long mLogoActivityEndTimeStamp;
    public long mLogoActivityOnCreateEndTimeStamp;
    public long mLogoActivityOnDestroyEndTimeStamp;
    public long mLogoActivityOnDestroyStartTimeStamp;
    public long mLogoActivityOnResumeEndTimeStamp;
    public long mLogoActivityOnResumeStartTimeStamp;
    public long mLogoActivityStartTimeStamp;
    public long mMainActivityCacheDataLoadedTimeStamp;
    public long mMainActivityCreateEndTimeStamp;
    public long mMainActivityCreateStartTimeStamp;
    public long mMainActivityNetDataLoadedTimeStamp;
    public long mMainActivityOnResumeEndTimeStamp;
    public long mMainActivityOnResumeStartTimeStamp;
    public long mMainActivityOnstartEndTimeStamp;
    public long mMainActivityOnstartStartTimeStamp;
    public long mMainActivitySuperCreateEndTimeStamp;
    public long mNewLogoActivityEndTimeStamp;
    public long mNewLogoActivityOnCreateEndTimeStamp;
    public long mNewLogoActivityOnDestroyEndTimeStamp;
    public long mNewLogoActivityOnDestroyStartTimeStamp;
    public long mNewLogoActivityStartTimeStamp;
    public long mRegReceiverEndTimeStamp;
    public long mRegReceiverStartTimeStamp;
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
        this.mLogoActivityStartTimeStamp = -1L;
        this.mLogoActivityOnCreateEndTimeStamp = -1L;
        this.mLogoActivityOnResumeStartTimeStamp = -1L;
        this.mLogoActivityOnResumeEndTimeStamp = -1L;
        this.mLogoActivityOnDestroyStartTimeStamp = -1L;
        this.mLogoActivityOnDestroyEndTimeStamp = -1L;
        this.mLogoActivityEndTimeStamp = -1L;
        this.mNewLogoActivityStartTimeStamp = -1L;
        this.mNewLogoActivityOnCreateEndTimeStamp = -1L;
        this.mNewLogoActivityOnDestroyStartTimeStamp = -1L;
        this.mNewLogoActivityOnDestroyEndTimeStamp = -1L;
        this.mNewLogoActivityEndTimeStamp = -1L;
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
        this.mFlutterFragmentStartTimeStamp = -1L;
        this.mFlutterFragmentEndTimeStamp = -1L;
        this.mMainActivityCacheDataLoadedTimeStamp = -1L;
        this.mMainActivityNetDataLoadedTimeStamp = -1L;
    }

    private long getMainDataLoaded2EndDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
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
                    this.mLogoActivityStartTimeStamp = j2;
                    return;
                case 3001:
                    this.mLogoActivityOnCreateEndTimeStamp = j2;
                    return;
                case 3002:
                    this.mLogoActivityOnResumeStartTimeStamp = j2;
                    return;
                case 3003:
                    this.mLogoActivityOnResumeEndTimeStamp = j2;
                    return;
                case 3004:
                    this.mLogoActivityOnDestroyStartTimeStamp = j2;
                    return;
                case 3005:
                    this.mLogoActivityOnDestroyEndTimeStamp = j2;
                    return;
                case 3006:
                    this.mLogoActivityEndTimeStamp = j2;
                    return;
                case 3007:
                    this.mNewLogoActivityStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY /* 3008 */:
                    this.mNewLogoActivityOnCreateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_START_STAMP_KEY /* 3009 */:
                    this.mNewLogoActivityOnDestroyStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_END_STAMP_KEY /* 3010 */:
                    this.mNewLogoActivityOnDestroyEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.NEW_LOGO_ACTIVITY_END_STAMP_KEY /* 3011 */:
                    this.mNewLogoActivityEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY /* 3012 */:
                    this.mMainActivityCreateStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY /* 3013 */:
                    this.mMainActivitySuperCreateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY /* 3014 */:
                    this.mInitHomeFragmentControllerStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY /* 3015 */:
                    this.mInitHomeFragmentControllerEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_START_STAMP_KEY /* 3016 */:
                    this.mCheckPluginEntranceStateStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY /* 3017 */:
                    this.mCheckPluginEntranceStateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY /* 3018 */:
                    this.mRegReceiverStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY /* 3019 */:
                    this.mRegReceiverEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY /* 3020 */:
                    this.mCheckClientConfigMessageStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY /* 3021 */:
                    this.mCheckClientConfigMessageEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_START_STAMP_KEY /* 3022 */:
                    this.mCheckAndSendActiveConfigMessageStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_END_STAMP_KEY /* 3023 */:
                    this.mCheckAndSendActiveConfigMessageEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY /* 3024 */:
                    this.mInitTabsOnActivityCreatedStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY /* 3025 */:
                    this.mInitTabsOnActivityCreatedEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY /* 3026 */:
                    this.mInitCookieStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY /* 3027 */:
                    this.mInitCookieEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_START_STAMP_KEY /* 3028 */:
                    this.mStartTrackConfigRequestStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_END_STAMP_KEY /* 3029 */:
                    this.mStartTrackConfigRequestEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_REAL_NAME_START_STAMP_KEY /* 3030 */:
                    this.mCheckRealNameStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY /* 3031 */:
                    this.mCheckRealNameEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_START_STAMP_KEY /* 3032 */:
                    this.mClearConcernCacheWhenVersionUpdateStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_END_STAMP_KEY /* 3033 */:
                    this.mClearConcernCacheWhenVersionUpdateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY /* 3034 */:
                    this.mUpdateProfileInfoStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY /* 3035 */:
                    this.mUpdateProfileInfoEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY /* 3036 */:
                    this.mTryLoadNativeFunAdStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY /* 3037 */:
                    this.mTryLoadNativeFunAdEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY /* 3038 */:
                    this.mMainActivityCreateEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY /* 3039 */:
                    this.mMainActivityOnstartStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY /* 3040 */:
                    this.mMainActivityOnstartEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY /* 3041 */:
                    this.mMainActivityOnResumeStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY /* 3042 */:
                    this.mMainActivityOnResumeEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_START_KEY /* 3043 */:
                    this.mFlutterFragmentStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_END_KEY /* 3044 */:
                    this.mFlutterFragmentEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_START_KEY /* 3045 */:
                case SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_END_KEY /* 3046 */:
                default:
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY /* 3047 */:
                    if (this.mMainActivityCacheDataLoadedTimeStamp == -1) {
                        this.mMainActivityCacheDataLoadedTimeStamp = j2;
                        return;
                    }
                    return;
                case SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY /* 3048 */:
                    if (this.mMainActivityNetDataLoadedTimeStamp == -1) {
                        this.mMainActivityNetDataLoadedTimeStamp = j2;
                        return;
                    }
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMainActivityOnResumeEndTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLogoActivityStartTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j4 = this.mMainActivityOnResumeEndTimeStamp;
            long j5 = this.mLogoActivityStartTimeStamp;
            long j6 = j4 - j5;
            long j7 = this.mLogoActivityEndTimeStamp;
            long j8 = j7 - j5;
            long j9 = this.mLogoActivityOnCreateEndTimeStamp - j5;
            long j10 = this.mLogoActivityOnResumeEndTimeStamp - this.mLogoActivityOnResumeStartTimeStamp;
            long j11 = this.mLogoActivityOnDestroyEndTimeStamp - this.mLogoActivityOnDestroyStartTimeStamp;
            long j12 = this.mNewLogoActivityOnDestroyEndTimeStamp - this.mNewLogoActivityOnDestroyStartTimeStamp;
            long j13 = this.mNewLogoActivityEndTimeStamp;
            long j14 = this.mNewLogoActivityStartTimeStamp;
            long j15 = j13 - j14;
            long j16 = this.mNewLogoActivityOnCreateEndTimeStamp - j14;
            if (j14 > 0) {
                j3 = this.mMainActivityCreateStartTimeStamp - j13;
                j2 = 0;
            } else {
                j2 = this.mMainActivityCreateStartTimeStamp - j7;
                j3 = 0;
            }
            long j17 = this.mMainActivityCreateEndTimeStamp;
            long j18 = j3;
            long j19 = this.mMainActivityCreateStartTimeStamp;
            long j20 = j17 - j19;
            long j21 = this.mMainActivitySuperCreateEndTimeStamp - j19;
            long j22 = this.mInitHomeFragmentControllerEndTimeStamp - this.mInitHomeFragmentControllerStartTimeStamp;
            long j23 = this.mCheckPluginEntranceStateEndTimeStamp - this.mCheckPluginEntranceStateStartTimeStamp;
            long j24 = this.mRegReceiverEndTimeStamp - this.mRegReceiverStartTimeStamp;
            long j25 = this.mCheckClientConfigMessageEndTimeStamp - this.mCheckClientConfigMessageStartTimeStamp;
            long j26 = this.mCheckAndSendActiveConfigMessageEndTimeStamp - this.mCheckAndSendActiveConfigMessageStartTimeStamp;
            long j27 = this.mInitTabsOnActivityCreatedEndTimeStamp - this.mInitTabsOnActivityCreatedStartTimeStamp;
            long j28 = this.mInitCookieEndTimeStamp - this.mInitCookieStartTimeStamp;
            long j29 = this.mStartTrackConfigRequestEndTimeStamp - this.mStartTrackConfigRequestStartTimeStamp;
            long j30 = this.mCheckRealNameEndTimeStamp - this.mCheckRealNameStartTimeStamp;
            long j31 = this.mClearConcernCacheWhenVersionUpdateEndTimeStamp - this.mClearConcernCacheWhenVersionUpdateStartTimeStamp;
            long j32 = this.mUpdateProfileInfoEndTimeStamp - this.mUpdateProfileInfoStartTimeStamp;
            long j33 = this.mTryLoadNativeFunAdEndTimeStamp - this.mTryLoadNativeFunAdStartTimeStamp;
            long j34 = this.mMainActivityOnstartStartTimeStamp;
            long j35 = j34 - j17;
            long j36 = this.mMainActivityOnstartEndTimeStamp;
            long j37 = j36 - j34;
            long j38 = this.mMainActivityOnResumeStartTimeStamp;
            long j39 = j38 - j36;
            long j40 = this.mMainActivityOnResumeEndTimeStamp - j38;
            long j41 = this.mFlutterFragmentEndTimeStamp - this.mFlutterFragmentStartTimeStamp;
            long mainOnCreate2DataLoadedDuration = getMainOnCreate2DataLoadedDuration();
            long mainDataLoaded2EndDuration = getMainDataLoaded2EndDuration();
            long durationWithoutAD = SpeedStatsManager.getInstance().getDurationWithoutAD(this.mLogoActivityStartTimeStamp, this.mMainActivityOnResumeEndTimeStamp);
            if (j6 < 0 || j6 > 60000 || durationWithoutAD < 0 || durationWithoutAD > 60000 || j8 < 0 || j8 > 60000 || j9 < 0 || j9 > 60000 || j10 < 0 || j10 > 60000 || j11 < 0 || j11 > 60000 || j2 < 0 || j2 > 60000 || j15 < 0 || j15 > 60000 || j16 < 0 || j16 > 60000 || j12 < 0 || j12 > 60000 || j18 < 0 || j18 > 60000 || j20 < 0 || j20 > 60000 || j21 < 0 || j21 > 60000 || j22 < 0 || j22 > 60000 || j23 < 0 || j23 > 60000 || j24 < 0 || j24 > 60000 || j25 < 0 || j25 > 60000 || j26 < 0 || j26 > 60000 || j27 < 0 || j27 > 60000 || j28 < 0 || j28 > 60000 || j29 < 0 || j29 > 60000 || j30 < 0 || j30 > 60000 || j31 < 0 || j31 > 60000 || j32 < 0 || j32 > 60000 || j33 < 0 || j33 > 60000 || j35 < 0 || j35 > 60000 || j37 < 0 || j37 > 60000 || j39 < 0 || j39 > 60000 || j40 < 0 || j40 > 60000 || mainOnCreate2DataLoadedDuration < 0 || mainOnCreate2DataLoadedDuration > 60000 || mainDataLoaded2EndDuration < 0 || mainDataLoaded2EndDuration > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(MAIN_ACTIVITY_TOTAL_DURATION, String.valueOf(j6));
            hashMap.put(LOGO_ACTIVITY_DURATION, String.valueOf(j8));
            hashMap.put(LOGO_ONCREATE_DURATION, String.valueOf(j9));
            hashMap.put(LOGO_ONRESUME_DURATION, String.valueOf(j10));
            hashMap.put(LOGO_ONDESTROY_DURATION, String.valueOf(j11));
            hashMap.put(LOGO_TO_MAIN_GAP, String.valueOf(j2));
            hashMap.put(NEW_LOGO_ACTIVITY_DURATION, String.valueOf(j15));
            hashMap.put(NEW_LOGO_ONCREATE_DURATION, String.valueOf(j16));
            hashMap.put(NEW_LOGO_ONDESTROY_DURATION, String.valueOf(j12));
            hashMap.put(NEWLOGO_TO_MAIN_GAP, String.valueOf(j18));
            hashMap.put("onCreate", String.valueOf(j20));
            hashMap.put(MAINACTIVITY_SUPER_ONCREATE_DURAION, String.valueOf(j21));
            hashMap.put(INIT_HOME_FRAGMENT_CONTROLLER_DURATION, String.valueOf(j22));
            hashMap.put(CHECK_PLUGIN_ENTRANCE_STATE_DURATION, String.valueOf(j23));
            hashMap.put(REG_RECEIVER_DURATION, String.valueOf(j24));
            hashMap.put(CHECK_CLIENT_CONFIG_MESSAGE_DURATION, String.valueOf(j25));
            hashMap.put(CHECK_AND_SEND_ACTIVE_CONFIG_DURATION, String.valueOf(j26));
            hashMap.put(INIT_TABS_ON_ACTIVITY_CREATED_DURATION, String.valueOf(j27));
            hashMap.put(INIT_COOKIE_DURATION, String.valueOf(j28));
            hashMap.put(START_TRACK_CONFIG_REQUEST_DURATION, String.valueOf(j29));
            hashMap.put(CHECK_REAL_NAME_DURATION, String.valueOf(j30));
            hashMap.put(CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_DURATION, String.valueOf(j31));
            hashMap.put(UPDATE_PROFILE_INFO_DURATION, String.valueOf(j32));
            hashMap.put(TRY_LOAD_NATIVE_FUN_AD_DURATION, String.valueOf(j33));
            hashMap.put(CREATE_START_GAP_DURATION, String.valueOf(j35));
            hashMap.put("onStart", String.valueOf(j37));
            hashMap.put(START_RESUME_GAP_DURATION, String.valueOf(j39));
            hashMap.put("onResume", String.valueOf(j40));
            hashMap.put(FLUTTER_FRAGMENT_CREATE_DURATION, String.valueOf(j41));
            hashMap.put(MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION, String.valueOf(mainOnCreate2DataLoadedDuration));
            hashMap.put(MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION, String.valueOf(mainDataLoaded2EndDuration));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(durationWithoutAD, hashMap);
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mLogoActivityStartTimeStamp = -1L;
            this.mLogoActivityOnCreateEndTimeStamp = -1L;
            this.mLogoActivityOnResumeStartTimeStamp = -1L;
            this.mLogoActivityOnResumeEndTimeStamp = -1L;
            this.mLogoActivityOnDestroyStartTimeStamp = -1L;
            this.mLogoActivityOnDestroyEndTimeStamp = -1L;
            this.mLogoActivityEndTimeStamp = -1L;
            this.mNewLogoActivityStartTimeStamp = -1L;
            this.mNewLogoActivityOnCreateEndTimeStamp = -1L;
            this.mNewLogoActivityOnDestroyStartTimeStamp = -1L;
            this.mNewLogoActivityOnDestroyEndTimeStamp = -1L;
            this.mNewLogoActivityEndTimeStamp = -1L;
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
            this.mFlutterFragmentStartTimeStamp = -1L;
            this.mFlutterFragmentEndTimeStamp = -1L;
            this.mMainActivityCacheDataLoadedTimeStamp = -1L;
            this.mMainActivityNetDataLoadedTimeStamp = -1L;
        }
    }
}
