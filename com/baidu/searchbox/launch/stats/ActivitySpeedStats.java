package com.baidu.searchbox.launch.stats;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ActivitySpeedStats extends AbstractSpeedStats {
    public static final String CHECK_CLIENT_CONFIG_MESSAGE_DURATION = "checkClientConfigMessage";
    public static final String CREATE_START_GAP_DURATION = "onCreate2StartGap";
    public static final String INIT_COOKIE_DURATION = "initCookie";
    public static final String INIT_HOME_FRAGMENT_CONTROLLER_DURATION = "initHomeFragmentController";
    public static final String INIT_TABS_ON_ACTIVITY_CREATED_DURATION = "initTabsOnActivityCreated";
    public static final String LOGO_ACTIVITY_DURATION = "logoActivity";
    public static final String LOGO_ONCREATE_DURATION = "logoOnCreate";
    public static final String LOGO_ONDESTROY_DURATION = "logoOnDestroy";
    public static final String LOGO_ONRESUME_DURATION = "logoOnResume";
    public static final String LOGO_TO_MAIN_GAP = "logo2MainGap";
    public static final String MAINACTIVITY_ONCREATE_DURAION = "onCreate";
    public static final String MAINACTIVITY_ONSECONDCREATE_DURAION = "onSecondCreate";
    public static final String MAINACTIVITY_SUPER_ONCREATE_DURAION = "superOnCreate";
    public static final String MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION = "sMainOnCreate2DataLoaded";
    public static final String MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION = "sMainDataLoaded2End";
    public static final String MAIN_ACTIVITY_TOTAL_DURATION = "mainActivityTotal";
    public static final String ONRESUME_DURATION = "onResume";
    public static final String ONSTART_DURATION = "onStart";
    public static final String REG_RECEIVER_DURATION = "regReceiverDuration";
    public static final String START_RESUME_GAP_DURATION = "onStart2ResumeGap";
    public static final String TRY_LOAD_NATIVE_FUN_AD_DURATION = "tryLoadNativeFunAd";
    public static final String UPDATE_PROFILE_INFO_DURATION = "updateProfileInfo";
    public long mLogoActivityStartTimeStamp = -1;
    public long mLogoActivityOnCreateEndTimeStamp = -1;
    public long mLogoActivityOnResumeStartTimeStamp = -1;
    public long mLogoActivityOnResumeEndTimeStamp = -1;
    public long mLogoActivityOnDestroyStartTimeStamp = -1;
    public long mLogoActivityOnDestroyEndTimeStamp = -1;
    public long mLogoActivityEndTimeStamp = -1;
    public long mMainActivityCreateStartTimeStamp = -1;
    public long mMainActivitySuperCreateEndTimeStamp = -1;
    public long mInitHomeFragmentControllerStartTimeStamp = -1;
    public long mInitHomeFragmentControllerEndTimeStamp = -1;
    public long mRegReceiverStartTimeStamp = -1;
    public long mRegReceiverEndTimeStamp = -1;
    public long mCheckClientConfigMessageStartTimeStamp = -1;
    public long mCheckClientConfigMessageEndTimeStamp = -1;
    public long mInitTabsOnActivityCreatedStartTimeStamp = -1;
    public long mInitTabsOnActivityCreatedEndTimeStamp = -1;
    public long mInitCookieStartTimeStamp = -1;
    public long mInitCookieEndTimeStamp = -1;
    public long mUpdateProfileInfoStartTimeStamp = -1;
    public long mUpdateProfileInfoEndTimeStamp = -1;
    public long mTryLoadNativeFunAdStartTimeStamp = -1;
    public long mTryLoadNativeFunAdEndTimeStamp = -1;
    public long mMainActivityCreateEndTimeStamp = -1;
    public long mMainActivitySecondCreateStartTimeStamp = -1;
    public long mMainActivitySecondCreateEndTimeStamp = -1;
    public long mMainActivityOnstartStartTimeStamp = -1;
    public long mMainActivityOnstartEndTimeStamp = -1;
    public long mMainActivityOnResumeStartTimeStamp = -1;
    public long mMainActivityOnResumeEndTimeStamp = -1;
    public long mMainActivityCacheDataLoadedTimeStamp = -1;
    public long mMainActivityNetDataLoadedTimeStamp = -1;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        this.mLogoActivityStartTimeStamp = -1L;
        this.mLogoActivityOnCreateEndTimeStamp = -1L;
        this.mLogoActivityOnResumeStartTimeStamp = -1L;
        this.mLogoActivityOnResumeEndTimeStamp = -1L;
        this.mLogoActivityOnDestroyStartTimeStamp = -1L;
        this.mLogoActivityOnDestroyEndTimeStamp = -1L;
        this.mLogoActivityEndTimeStamp = -1L;
        this.mMainActivityCreateStartTimeStamp = -1L;
        this.mMainActivityCreateEndTimeStamp = -1L;
        this.mMainActivitySuperCreateEndTimeStamp = -1L;
        this.mInitHomeFragmentControllerStartTimeStamp = -1L;
        this.mInitHomeFragmentControllerEndTimeStamp = -1L;
        this.mRegReceiverStartTimeStamp = -1L;
        this.mRegReceiverEndTimeStamp = -1L;
        this.mCheckClientConfigMessageStartTimeStamp = -1L;
        this.mCheckClientConfigMessageEndTimeStamp = -1L;
        this.mInitTabsOnActivityCreatedStartTimeStamp = -1L;
        this.mInitTabsOnActivityCreatedEndTimeStamp = -1L;
        this.mUpdateProfileInfoStartTimeStamp = -1L;
        this.mUpdateProfileInfoEndTimeStamp = -1L;
        this.mTryLoadNativeFunAdStartTimeStamp = -1L;
        this.mTryLoadNativeFunAdEndTimeStamp = -1L;
        this.mMainActivityOnstartStartTimeStamp = -1L;
        this.mMainActivityOnstartEndTimeStamp = -1L;
        this.mMainActivityOnResumeStartTimeStamp = -1L;
        this.mMainActivityOnResumeEndTimeStamp = -1L;
        this.mMainActivityCacheDataLoadedTimeStamp = -1L;
        this.mMainActivityNetDataLoadedTimeStamp = -1L;
    }

    private long getMainDataLoaded2EndDuration() {
        long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp();
        long j = this.mMainActivityCacheDataLoadedTimeStamp;
        if (j == -1) {
            j = this.mMainActivityNetDataLoadedTimeStamp;
        }
        return Math.min(appLaunchEndTimeStamp - j, appLaunchEndTimeStamp - this.mMainActivityCreateStartTimeStamp);
    }

    private long getMainOnCreate2DataLoadedDuration() {
        long j = this.mMainActivityCacheDataLoadedTimeStamp;
        if (j == -1) {
            j = this.mMainActivityNetDataLoadedTimeStamp;
        }
        return Math.max(0L, j - this.mMainActivityCreateStartTimeStamp);
    }

    public long getExtraSecondCreateDuration() {
        long j = this.mMainActivitySecondCreateStartTimeStamp;
        if (j > this.mMainActivityOnResumeEndTimeStamp) {
            long j2 = this.mMainActivitySecondCreateEndTimeStamp;
            if (j2 > j) {
                return j2 - j;
            }
            return 0L;
        }
        return 0L;
    }

    public long getMainActivityCreateStartTimeStamp() {
        return this.mMainActivityCreateStartTimeStamp;
    }

    public long getMainActivityOnResumeEndTimeStamp() {
        return this.mMainActivityOnResumeEndTimeStamp;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        return this.mMainActivityOnResumeEndTimeStamp;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        long j = this.mLogoActivityStartTimeStamp;
        if (j > 0) {
            return j;
        }
        return this.mMainActivityCreateStartTimeStamp;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        super.addStatsTimeStamp(i, j);
        switch (i) {
            case 3000:
                this.mLogoActivityStartTimeStamp = j;
                return;
            case 3001:
                this.mLogoActivityOnCreateEndTimeStamp = j;
                return;
            case 3002:
                this.mLogoActivityOnResumeStartTimeStamp = j;
                return;
            case 3003:
                this.mLogoActivityOnResumeEndTimeStamp = j;
                return;
            case 3004:
                this.mLogoActivityOnDestroyStartTimeStamp = j;
                return;
            case 3005:
                this.mLogoActivityOnDestroyEndTimeStamp = j;
                return;
            case 3006:
                this.mLogoActivityEndTimeStamp = j;
                return;
            case 3007:
            case 3008:
            case 3009:
            case 3010:
            case 3011:
            case 3016:
            case 3017:
            case 3022:
            case 3023:
            case 3028:
            case 3029:
            case 3030:
            case 3031:
            case 3032:
            case 3033:
            case 3043:
            case 3044:
            default:
                return;
            case SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY /* 3012 */:
                this.mMainActivityCreateStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY /* 3013 */:
                this.mMainActivitySuperCreateEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY /* 3014 */:
                this.mInitHomeFragmentControllerStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY /* 3015 */:
                this.mInitHomeFragmentControllerEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY /* 3018 */:
                this.mRegReceiverStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY /* 3019 */:
                this.mRegReceiverEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY /* 3020 */:
                this.mCheckClientConfigMessageStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY /* 3021 */:
                this.mCheckClientConfigMessageEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY /* 3024 */:
                this.mInitTabsOnActivityCreatedStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY /* 3025 */:
                this.mInitTabsOnActivityCreatedEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY /* 3026 */:
                this.mInitCookieStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY /* 3027 */:
                this.mInitCookieEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY /* 3034 */:
                this.mUpdateProfileInfoStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY /* 3035 */:
                this.mUpdateProfileInfoEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY /* 3036 */:
                this.mTryLoadNativeFunAdStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY /* 3037 */:
                this.mTryLoadNativeFunAdEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY /* 3038 */:
                this.mMainActivityCreateEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY /* 3039 */:
                this.mMainActivityOnstartStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY /* 3040 */:
                this.mMainActivityOnstartEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY /* 3041 */:
                this.mMainActivityOnResumeStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY /* 3042 */:
                this.mMainActivityOnResumeEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY /* 3045 */:
                this.mMainActivitySecondCreateStartTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY /* 3046 */:
                this.mMainActivitySecondCreateEndTimeStamp = j;
                return;
            case SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY /* 3047 */:
                if (this.mMainActivityCacheDataLoadedTimeStamp == -1) {
                    this.mMainActivityCacheDataLoadedTimeStamp = j;
                    return;
                }
                return;
            case SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY /* 3048 */:
                if (this.mMainActivityNetDataLoadedTimeStamp == -1) {
                    this.mMainActivityNetDataLoadedTimeStamp = j;
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        long j;
        int i;
        super.packData(jSONObject);
        if (jSONObject == null) {
            return false;
        }
        long j2 = this.mMainActivityOnResumeEndTimeStamp - this.mLogoActivityStartTimeStamp;
        if (j2 < 0 || j2 > 60000) {
            j2 = this.mMainActivityOnResumeEndTimeStamp - this.mMainActivityCreateStartTimeStamp;
        }
        long j3 = this.mLogoActivityEndTimeStamp - this.mLogoActivityStartTimeStamp;
        if (j3 < 0 || j3 > 60000) {
            j3 = this.mLogoActivityEndTimeStamp - this.mMainActivityCreateStartTimeStamp;
        }
        long j4 = this.mLogoActivityOnCreateEndTimeStamp - this.mLogoActivityStartTimeStamp;
        if (j4 < 0 || j4 > 60000) {
            j4 = this.mLogoActivityOnCreateEndTimeStamp - this.mMainActivityCreateStartTimeStamp;
        }
        long j5 = j2;
        long j6 = this.mLogoActivityOnResumeEndTimeStamp - this.mLogoActivityOnResumeStartTimeStamp;
        long j7 = this.mLogoActivityOnDestroyEndTimeStamp - this.mLogoActivityOnDestroyStartTimeStamp;
        long j8 = this.mLogoActivityEndTimeStamp;
        if (j8 < 0) {
            j = 0;
        } else {
            j = this.mMainActivityCreateStartTimeStamp - j8;
        }
        long j9 = this.mMainActivityCreateEndTimeStamp;
        long j10 = j;
        long j11 = this.mMainActivityCreateStartTimeStamp;
        long j12 = j9 - j11;
        long j13 = this.mMainActivitySuperCreateEndTimeStamp - j11;
        long j14 = this.mInitHomeFragmentControllerEndTimeStamp - this.mInitHomeFragmentControllerStartTimeStamp;
        long j15 = this.mRegReceiverEndTimeStamp - this.mRegReceiverStartTimeStamp;
        long j16 = this.mCheckClientConfigMessageEndTimeStamp - this.mCheckClientConfigMessageStartTimeStamp;
        long j17 = this.mInitTabsOnActivityCreatedEndTimeStamp - this.mInitTabsOnActivityCreatedStartTimeStamp;
        long j18 = this.mInitCookieEndTimeStamp - this.mInitCookieStartTimeStamp;
        long j19 = this.mUpdateProfileInfoEndTimeStamp - this.mUpdateProfileInfoStartTimeStamp;
        long j20 = this.mTryLoadNativeFunAdEndTimeStamp - this.mTryLoadNativeFunAdStartTimeStamp;
        long j21 = this.mMainActivityOnstartStartTimeStamp;
        long j22 = j21 - j9;
        long j23 = this.mMainActivityOnstartEndTimeStamp;
        long j24 = j23 - j21;
        long j25 = this.mMainActivityOnResumeStartTimeStamp;
        long j26 = j25 - j23;
        long j27 = this.mMainActivityOnResumeEndTimeStamp - j25;
        long mainOnCreate2DataLoadedDuration = getMainOnCreate2DataLoadedDuration();
        long mainDataLoaded2EndDuration = getMainDataLoaded2EndDuration();
        long j28 = this.mMainActivitySecondCreateEndTimeStamp - this.mMainActivitySecondCreateStartTimeStamp;
        long durationWithoutAD = SpeedStatsManager.getInstance().getDurationWithoutAD(this.mLogoActivityStartTimeStamp, this.mMainActivityOnResumeEndTimeStamp);
        if (durationWithoutAD < 0 || durationWithoutAD > 60000) {
            durationWithoutAD = SpeedStatsManager.getInstance().getDurationWithoutAD(this.mMainActivityCreateStartTimeStamp, this.mMainActivityOnResumeEndTimeStamp);
        }
        if (this.mMainActivitySecondCreateStartTimeStamp > this.mMainActivityOnResumeEndTimeStamp) {
            durationWithoutAD += j28;
        }
        if (j5 >= 0 && j5 <= 60000 && durationWithoutAD >= 0 && durationWithoutAD <= 60000 && j3 >= 0 && j3 <= 60000 && j4 >= 0 && j4 <= 60000 && j6 >= 0 && j6 <= 60000 && j7 >= 0 && j7 <= 60000 && j10 >= 0 && j10 <= 60000 && j12 >= 0 && j12 <= 60000 && j13 >= 0 && j13 <= 60000 && j14 >= 0 && j14 <= 60000 && j15 >= 0 && j15 <= 60000 && j16 >= 0 && j16 <= 60000 && j17 >= 0 && j17 <= 60000 && j18 >= 0 && j18 <= 60000 && j19 >= 0 && j19 <= 60000 && j20 >= 0 && j20 <= 60000 && j22 >= 0 && j22 <= 60000 && j24 >= 0 && j24 <= 60000 && j26 >= 0 && j26 <= 60000 && j27 >= 0 && j27 <= 60000 && mainOnCreate2DataLoadedDuration >= 0 && mainOnCreate2DataLoadedDuration <= 60000 && mainDataLoaded2EndDuration >= 0 && mainDataLoaded2EndDuration <= 60000) {
            HashMap hashMap = new HashMap();
            hashMap.put(MAIN_ACTIVITY_TOTAL_DURATION, String.valueOf(j5));
            if (i > 0) {
                hashMap.put(LOGO_ACTIVITY_DURATION, String.valueOf(j3));
                hashMap.put(LOGO_ONCREATE_DURATION, String.valueOf(j4));
                hashMap.put(LOGO_ONRESUME_DURATION, String.valueOf(j6));
                hashMap.put(LOGO_ONDESTROY_DURATION, String.valueOf(j7));
                hashMap.put(LOGO_TO_MAIN_GAP, String.valueOf(j10));
            }
            hashMap.put("onCreate", String.valueOf(j12));
            hashMap.put(MAINACTIVITY_ONSECONDCREATE_DURAION, String.valueOf(j28));
            hashMap.put("superOnCreate", String.valueOf(j13));
            hashMap.put(INIT_HOME_FRAGMENT_CONTROLLER_DURATION, String.valueOf(j14));
            hashMap.put(REG_RECEIVER_DURATION, String.valueOf(j15));
            hashMap.put(CHECK_CLIENT_CONFIG_MESSAGE_DURATION, String.valueOf(j16));
            hashMap.put(INIT_TABS_ON_ACTIVITY_CREATED_DURATION, String.valueOf(j17));
            hashMap.put(INIT_COOKIE_DURATION, String.valueOf(j18));
            hashMap.put(UPDATE_PROFILE_INFO_DURATION, String.valueOf(j19));
            hashMap.put(TRY_LOAD_NATIVE_FUN_AD_DURATION, String.valueOf(j20));
            hashMap.put(CREATE_START_GAP_DURATION, String.valueOf(j22));
            hashMap.put("onStart", String.valueOf(j24));
            hashMap.put(START_RESUME_GAP_DURATION, String.valueOf(j26));
            hashMap.put("onResume", String.valueOf(j27));
            hashMap.put(MAIN_ACTIVITY_CREATE_TO_DATA_LOADED_DURATION, String.valueOf(mainOnCreate2DataLoadedDuration));
            hashMap.put(MAIN_ACTIVITY_DATA_LOADED_TO_END_DURATION, String.valueOf(mainDataLoaded2EndDuration));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(durationWithoutAD, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put("activity", jsonData);
                    return true;
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}
