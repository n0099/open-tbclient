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
    public static final String INIT_COOKIE_DURATION = "initCookie";
    public static final String INIT_HOME_FRAGMENT_CONTROLLER_DURATION = "initHomeFragmentController";
    public static final String INIT_TABS_ON_ACTIVITY_CREATED_DURATION = "initTabsOnActivityCreated";
    public static final String MAINACTIVITY_ONCREATE_DURAION = "onCreate";
    public static final String MAINACTIVITY_SUPER_ONCREATE_DURAION = "superOnCreate";
    public static final String MAIN_ACTIVITY_TOTAL_DURATION = "mainActivityTotal";
    public static final String ONRESUME_DURATION = "onResume";
    public static final String ONSTART_DURATION = "onStart";
    public static final String REG_RECEIVER_DURATION = "regReceiverDuration";
    public static final String SPLASH_ACTIVITY2MAINACTIVITY_GAP = "splashMainGap";
    public static final String SPLASH_ACTIVITY_DURATION = "splash";
    public static final String SPLASH_LOADAD_DURATION = "splashLoadAd";
    public static final String SPLASH_ONCREATE_DURATION = "splashOnCreate";
    public static final String SPLASH_SHOW_DURATION = "splashShow";
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
    public long mInitCookieEndTimeStamp;
    public long mInitCookieStartTimeStamp;
    public long mInitHomeFragmentControllerEndTimeStamp;
    public long mInitHomeFragmentControllerStartTimeStamp;
    public long mInitTabsOnActivityCreatedEndTimeStamp;
    public long mInitTabsOnActivityCreatedStartTimeStamp;
    public long mMainActivityCreateEndTimeStamp;
    public long mMainActivityCreateStartTimeStamp;
    public long mMainActivityOnResumeEndTimeStamp;
    public long mMainActivityOnResumeStartTimeStamp;
    public long mMainActivityOnstartEndTimeStamp;
    public long mMainActivityOnstartStartTimeStamp;
    public long mMainActivitySuperCreateEndTimeStamp;
    public long mRegReceiverEndTimeStamp;
    public long mRegReceiverStartTimeStamp;
    public long mSplashActivityEndTimeStamp;
    public long mSplashActivityStartTimeStamp;
    public long mSplashAdShowEndTimeStamp;
    public long mSplashAdShowStartTimeStamp;
    public long mSplashAdloadEndTimeStamp;
    public long mSplashAdloadStartTimeStamp;
    public long mSplashOnCreateEndTimeStamp;
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
        this.mSplashAdloadStartTimeStamp = -1L;
        this.mSplashAdloadEndTimeStamp = -1L;
        this.mSplashAdShowStartTimeStamp = -1L;
        this.mSplashAdShowEndTimeStamp = -1L;
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
                case SpeedStatsStampTable.SPLASHACTIVITY_ADLOAD_END_STAMP_KEY /* 3035 */:
                    this.mSplashAdloadEndTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_START_STAMP_KEY /* 3036 */:
                    this.mSplashAdShowStartTimeStamp = j2;
                    return;
                case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_END_STAMP_KEY /* 3037 */:
                    this.mSplashAdShowEndTimeStamp = j2;
                    return;
                default:
                    return;
            }
        }
    }

    public long getMainActivityCreateStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMainActivityCreateStartTimeStamp : invokeV.longValue;
    }

    public long getSplashActivityConstTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSplashActivityEndTimeStamp - this.mSplashActivityStartTimeStamp : invokeV.longValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSplashActivityStartTimeStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j2 = this.mMainActivityOnResumeEndTimeStamp;
            long j3 = this.mSplashActivityStartTimeStamp;
            long j4 = j2 - j3;
            long j5 = this.mSplashActivityEndTimeStamp;
            long j6 = j5 - j3;
            long j7 = this.mSplashOnCreateEndTimeStamp - j3;
            long j8 = this.mSplashAdloadEndTimeStamp - this.mSplashAdloadStartTimeStamp;
            long j9 = this.mSplashAdShowEndTimeStamp - this.mSplashAdShowStartTimeStamp;
            long j10 = this.mMainActivityCreateStartTimeStamp;
            long j11 = j10 - j5;
            long j12 = this.mMainActivityCreateEndTimeStamp - j10;
            long j13 = this.mMainActivitySuperCreateEndTimeStamp - j10;
            long j14 = this.mInitHomeFragmentControllerEndTimeStamp - this.mInitHomeFragmentControllerStartTimeStamp;
            long j15 = this.mCheckPluginEntranceStateEndTimeStamp - this.mCheckPluginEntranceStateStartTimeStamp;
            long j16 = this.mRegReceiverEndTimeStamp - this.mRegReceiverStartTimeStamp;
            long j17 = this.mCheckClientConfigMessageEndTimeStamp - this.mCheckClientConfigMessageStartTimeStamp;
            long j18 = this.mCheckAndSendActiveConfigMessageEndTimeStamp - this.mCheckAndSendActiveConfigMessageStartTimeStamp;
            long j19 = this.mInitTabsOnActivityCreatedEndTimeStamp - this.mInitTabsOnActivityCreatedStartTimeStamp;
            long j20 = this.mInitCookieEndTimeStamp - this.mInitCookieStartTimeStamp;
            long j21 = this.mStartTrackConfigRequestEndTimeStamp - this.mStartTrackConfigRequestStartTimeStamp;
            long j22 = this.mCheckRealNameEndTimeStamp - this.mCheckRealNameStartTimeStamp;
            long j23 = this.mClearConcernCacheWhenVersionUpdateEndTimeStamp - this.mClearConcernCacheWhenVersionUpdateStartTimeStamp;
            long j24 = this.mUpdateProfileInfoEndTimeStamp - this.mUpdateProfileInfoStartTimeStamp;
            long j25 = this.mTryLoadNativeFunAdEndTimeStamp - this.mTryLoadNativeFunAdStartTimeStamp;
            long j26 = this.mMainActivityOnstartEndTimeStamp - this.mMainActivityOnstartStartTimeStamp;
            long j27 = j2 - this.mMainActivityOnResumeStartTimeStamp;
            if (j4 < 0 || j4 > 60000 || j6 < 0 || j6 > 60000 || j7 < 0 || j7 > 60000 || j11 < 0 || j11 > 60000 || j12 < 0 || j12 > 60000 || j13 < 0 || j13 > 60000 || j14 < 0 || j14 > 60000 || j15 < 0 || j15 > 60000 || j16 < 0 || j16 > 60000 || j17 < 0 || j17 > 60000 || j18 < 0 || j18 > 60000 || j19 < 0 || j19 > 60000 || j20 < 0 || j20 > 60000 || j21 < 0 || j21 > 60000 || j22 < 0 || j22 > 60000 || j23 < 0 || j23 > 60000 || j24 < 0 || j24 > 60000 || j25 < 0 || j25 > 60000 || j26 < 0 || j26 > 60000 || j27 < 0 || j27 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(MAIN_ACTIVITY_TOTAL_DURATION, String.valueOf(j4));
            hashMap.put("splash", String.valueOf(j6));
            hashMap.put(SPLASH_ONCREATE_DURATION, String.valueOf(j7));
            hashMap.put(SPLASH_LOADAD_DURATION, String.valueOf(j8));
            hashMap.put(SPLASH_SHOW_DURATION, String.valueOf(j9));
            hashMap.put(SPLASH_ACTIVITY2MAINACTIVITY_GAP, String.valueOf(j11));
            hashMap.put("onCreate", String.valueOf(j12));
            hashMap.put(MAINACTIVITY_SUPER_ONCREATE_DURAION, String.valueOf(j13));
            hashMap.put(INIT_HOME_FRAGMENT_CONTROLLER_DURATION, String.valueOf(j14));
            hashMap.put(CHECK_PLUGIN_ENTRANCE_STATE_DURATION, String.valueOf(j15));
            hashMap.put(REG_RECEIVER_DURATION, String.valueOf(j16));
            hashMap.put(CHECK_CLIENT_CONFIG_MESSAGE_DURATION, String.valueOf(j17));
            hashMap.put(CHECK_AND_SEND_ACTIVE_CONFIG_DURATION, String.valueOf(j18));
            hashMap.put(INIT_TABS_ON_ACTIVITY_CREATED_DURATION, String.valueOf(j19));
            hashMap.put(INIT_COOKIE_DURATION, String.valueOf(j20));
            hashMap.put(START_TRACK_CONFIG_REQUEST_DURATION, String.valueOf(j21));
            hashMap.put(CHECK_REAL_NAME_DURATION, String.valueOf(j22));
            hashMap.put(CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_DURATION, String.valueOf(j23));
            hashMap.put(UPDATE_PROFILE_INFO_DURATION, String.valueOf(j24));
            hashMap.put(TRY_LOAD_NATIVE_FUN_AD_DURATION, String.valueOf(j25));
            hashMap.put("onStart", String.valueOf(j26));
            hashMap.put("onResume", String.valueOf(j27));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j4, hashMap);
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
        }
    }
}
