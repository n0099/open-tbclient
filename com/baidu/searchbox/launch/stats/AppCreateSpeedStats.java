package com.baidu.searchbox.launch.stats;

import c.a.q0.s.d0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class AppCreateSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLEAN_DIRECTORY = "cleanDirectory";
    public static final String CMDROUTER_INIT = "cmdRouterInit";
    public static final String INIT_ACCOUNT = "initAccount";
    public static final String INIT_ACCOUNT_CHANGE = "initAccountChange";
    public static final String INIT_ALL = "initAll";
    public static final String INIT_APP_CONFIG = "initAppConfig";
    public static final String INIT_AR = "initAR";
    public static final String INIT_AXE = "initAxe";
    public static final String INIT_BEAR = "initBear";
    public static final String INIT_CMD = "initCmd";
    public static final String INIT_COUNT_STATS = "initCountStats";
    public static final String INIT_DIMON_ADAPT = "initDimonAdapter";
    public static final String INIT_FACE = "initFace";
    public static final String INIT_GO_ACTION = "initGoAction";
    public static final String INIT_INTERRUPT_RULE = "initInterruptRule";
    public static final String INIT_LOKI = "initLoki";
    public static final String INIT_MODULE_CONTEXT = "initModuleContext";
    public static final String INIT_MSG_EIGHT = "initMsgEight";
    public static final String INIT_MSG_FIVE = "initMsgFive";
    public static final String INIT_MSG_FOUR = "initMsgFour";
    public static final String INIT_MSG_NINE = "initMsgNine";
    public static final String INIT_MSG_ONE = "initMsgOne";
    public static final String INIT_MSG_SEVEN = "initMsgSeven";
    public static final String INIT_MSG_SIX = "initMsgSix";
    public static final String INIT_MSG_THREE = "initMsgThree";
    public static final String INIT_MSG_TWO = "initMsgTwo";
    public static final String INIT_PLUGIN = "initPlugin";
    public static final String INIT_RUKA = "initRuka";
    public static final String INIT_SAPI = "initSapi";
    public static final String INIT_SWAN = "initSwan";
    public static final String INIT_TASKS = "initTasks";
    public static final String INIT_TO_LOGO = "initToLogo";
    public static final String INIT_UBC = "initUBC";
    public static final String INIT_VERSION = "initVersion";
    public static final String LAUNCH_TASK_SCHEDULE = "launchTaskSchedule";
    public static final String NOSTATIC_INIT_TASKS_COST = "noStaticinitTasksCost";
    public static final String ON_APP_END_2_ACTIVITY_START_GAP = "onAppEnd2ActivityStartGap";
    public static final String ON_APP_START_2_ACTIVITY_START_DURATION = "onAppStart2ActivityStartDuration";
    public static final String ON_APP_START_END = "onAppStart2End";
    public static final String PERMMISSION_UTIL = "permissionUtil";
    public static final String PROCESS_UPGRADE = "processUpgrade";
    public static final String SHAREP_GET = "sharePreferGet";
    public static final String STATIC_INIT_TASKS_COST = "staticInitTasksCost";
    public static final String WEBVIEW_SUFFIX = "webviewSuffix";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppCreateEndTimestamp;
    public long mCleanDirectoryEndTimestamp;
    public long mCmdRouterInitEndTimestamp;
    public long mCreateStartTimestamp;
    public long mInitAREndTimestamp;
    public long mInitAccountChangeTimestamp;
    public long mInitAdapterDimonEndTimestamp;
    public long mInitAllEndTimestamp;
    public long mInitAppConfigEndTimeStamp;
    public long mInitAxeEndTimestamp;
    public long mInitBearEndTimestamp;
    public long mInitCmdEndTimestamp;
    public long mInitCountStatsEndTimestamp;
    public long mInitFaceEndTimestamp;
    public long mInitGOEndTimestamp;
    public long mInitInterruptEndTimestamp;
    public long mInitLoginEndTimestamp;
    public long mInitLokiEndTimestamp;
    public long mInitModuleContextEndTimestamp;
    public long mInitMsgEightEndTimestamp;
    public long mInitMsgEightStartTimestamp;
    public long mInitMsgFiveEndTimestamp;
    public long mInitMsgFiveStartTimestamp;
    public long mInitMsgFourEndTimestamp;
    public long mInitMsgFourStartTimestamp;
    public long mInitMsgNineEndTimestamp;
    public long mInitMsgNineStartTimestamp;
    public long mInitMsgOneEndTimestamp;
    public long mInitMsgOneStartTimestamp;
    public long mInitMsgSevenEndTimestamp;
    public long mInitMsgSevenStartTimestamp;
    public long mInitMsgSixEndTimestamp;
    public long mInitMsgSixStartTimestamp;
    public long mInitMsgThreeEndTimestamp;
    public long mInitMsgThreeStartTimestamp;
    public long mInitMsgTwoEndTimestamp;
    public long mInitMsgTwoStartTimestamp;
    public long mInitPluginEndTimestamp;
    public long mInitRukaEndTimestamp;
    public long mInitSapiEndTimestamp;
    public long mInitSwanEndTimestamp;
    public long mInitTasksEndTimestamp;
    public long mInitToLogoEndTimestamp;
    public long mInitUbcEndTimestamp;
    public long mInitVersionEndTimestamp;
    public Hashtable<String, Long> mLaunchTaskDuration;
    public long mLaunchTaskScheduleEndTimestamp;
    public long mOnAppCreateEndTimestamp;
    public long mPermissionUtilEndTimestamp;
    public long mPrcocessUpgradeEndTimeStamp;
    public long mSharePEndTimestamp;
    public long mWebViewSufEndTimestamp;

    public AppCreateSpeedStats() {
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
        this.mCreateStartTimestamp = -1L;
        this.mPrcocessUpgradeEndTimeStamp = -1L;
        this.mInitAppConfigEndTimeStamp = -1L;
        this.mLaunchTaskScheduleEndTimestamp = -1L;
        this.mInitModuleContextEndTimestamp = -1L;
        this.mOnAppCreateEndTimestamp = -1L;
        this.mCleanDirectoryEndTimestamp = -1L;
        this.mInitAccountChangeTimestamp = -1L;
        this.mPermissionUtilEndTimestamp = -1L;
        this.mInitAdapterDimonEndTimestamp = -1L;
        this.mWebViewSufEndTimestamp = -1L;
        this.mSharePEndTimestamp = -1L;
        this.mCmdRouterInitEndTimestamp = -1L;
        this.mInitCmdEndTimestamp = -1L;
        this.mInitVersionEndTimestamp = -1L;
        this.mInitAllEndTimestamp = -1L;
        this.mInitFaceEndTimestamp = -1L;
        this.mInitTasksEndTimestamp = -1L;
        this.mInitGOEndTimestamp = -1L;
        this.mInitLoginEndTimestamp = -1L;
        this.mInitInterruptEndTimestamp = -1L;
        this.mInitSapiEndTimestamp = -1L;
        this.mInitPluginEndTimestamp = -1L;
        this.mInitSwanEndTimestamp = -1L;
        this.mInitBearEndTimestamp = -1L;
        this.mInitToLogoEndTimestamp = -1L;
        this.mInitLokiEndTimestamp = -1L;
        this.mInitCountStatsEndTimestamp = -1L;
        this.mInitUbcEndTimestamp = -1L;
        this.mInitRukaEndTimestamp = -1L;
        this.mInitAxeEndTimestamp = -1L;
        this.mInitAREndTimestamp = -1L;
        this.mInitMsgOneStartTimestamp = -1L;
        this.mInitMsgOneEndTimestamp = -1L;
        this.mInitMsgTwoStartTimestamp = -1L;
        this.mInitMsgTwoEndTimestamp = -1L;
        this.mInitMsgThreeStartTimestamp = -1L;
        this.mInitMsgThreeEndTimestamp = -1L;
        this.mInitMsgFourStartTimestamp = -1L;
        this.mInitMsgFourEndTimestamp = -1L;
        this.mInitMsgFiveStartTimestamp = -1L;
        this.mInitMsgFiveEndTimestamp = -1L;
        this.mInitMsgSixStartTimestamp = -1L;
        this.mInitMsgSixEndTimestamp = -1L;
        this.mInitMsgSevenStartTimestamp = -1L;
        this.mInitMsgSevenEndTimestamp = -1L;
        this.mInitMsgEightStartTimestamp = -1L;
        this.mInitMsgEightEndTimestamp = -1L;
        this.mInitMsgNineStartTimestamp = -1L;
        this.mInitMsgNineEndTimestamp = -1L;
        this.mAppCreateEndTimestamp = -1L;
        this.mLaunchTaskDuration = new Hashtable<>();
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            super.addStatsDuration(str, j2);
            this.mLaunchTaskDuration.put(str, Long.valueOf(j2));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            addStatsTimeStamp(i2, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppCreateEndTimestamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCreateStartTimestamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return true;
            }
            long j2 = this.mAppCreateEndTimestamp;
            long j3 = this.mCreateStartTimestamp;
            long j4 = j2 - j3;
            long j5 = j2 - j3;
            long j6 = this.mInitAccountChangeTimestamp;
            long j7 = j6 - j3;
            long j8 = this.mPermissionUtilEndTimestamp;
            long j9 = this.mInitTasksEndTimestamp;
            long j10 = j8 - j9;
            long j11 = this.mInitAdapterDimonEndTimestamp;
            long j12 = j11 - j8;
            long j13 = this.mCleanDirectoryEndTimestamp;
            long j14 = j13 - j11;
            long j15 = this.mSharePEndTimestamp;
            long j16 = j15 - j13;
            long j17 = this.mCmdRouterInitEndTimestamp;
            long j18 = j17 - j15;
            long j19 = this.mWebViewSufEndTimestamp;
            long j20 = j19 - j17;
            long j21 = this.mInitCmdEndTimestamp;
            long j22 = j21 - j19;
            long j23 = this.mInitVersionEndTimestamp;
            long j24 = j23 - j21;
            long j25 = this.mInitAllEndTimestamp;
            long j26 = j25 - j23;
            long j27 = this.mInitFaceEndTimestamp;
            long j28 = j27 - j6;
            long j29 = j9 - j27;
            long j30 = this.mInitGOEndTimestamp;
            long j31 = j30 - j25;
            long j32 = this.mInitLoginEndTimestamp;
            long j33 = j32 - j30;
            long j34 = this.mInitInterruptEndTimestamp;
            long j35 = j34 - j32;
            long j36 = this.mInitSapiEndTimestamp;
            long j37 = j36 - j34;
            long j38 = this.mInitPluginEndTimestamp;
            long j39 = j38 - j36;
            long j40 = this.mInitSwanEndTimestamp;
            long j41 = j40 - j38;
            long j42 = this.mInitBearEndTimestamp - j3;
            long j43 = this.mInitToLogoEndTimestamp;
            long j44 = j43 - j40;
            long j45 = this.mInitLokiEndTimestamp;
            long j46 = j45 - j43;
            long j47 = this.mInitCountStatsEndTimestamp;
            long j48 = j47 - j45;
            long j49 = this.mInitUbcEndTimestamp;
            long j50 = j49 - j47;
            long j51 = this.mInitRukaEndTimestamp;
            long j52 = j51 - j49;
            long j53 = this.mInitAxeEndTimestamp;
            long j54 = j53 - j51;
            long j55 = this.mInitAREndTimestamp - j53;
            long j56 = this.mInitMsgOneEndTimestamp - this.mInitMsgOneStartTimestamp;
            long j57 = this.mInitMsgTwoEndTimestamp - this.mInitMsgTwoStartTimestamp;
            long j58 = this.mInitMsgThreeEndTimestamp - this.mInitMsgThreeStartTimestamp;
            long j59 = this.mInitMsgFourEndTimestamp - this.mInitMsgFourStartTimestamp;
            long j60 = this.mInitMsgFiveEndTimestamp - this.mInitMsgFiveStartTimestamp;
            long j61 = this.mInitMsgSixEndTimestamp - this.mInitMsgSixStartTimestamp;
            long j62 = this.mInitMsgSevenEndTimestamp - this.mInitMsgSevenStartTimestamp;
            long j63 = this.mInitMsgEightEndTimestamp - this.mInitMsgEightStartTimestamp;
            long j64 = this.mInitMsgNineEndTimestamp - this.mInitMsgNineStartTimestamp;
            long splashActivityStartTime = SpeedStatsManager.getInstance().getSplashActivityStartTime() - this.mAppCreateEndTimestamp;
            long splashActivityStartTime2 = SpeedStatsManager.getInstance().getSplashActivityStartTime() - this.mCreateStartTimestamp;
            if (j4 < 0 || j4 > 60000 || j7 < 0 || j7 > 60000 || splashActivityStartTime < 0 || splashActivityStartTime > 60000 || splashActivityStartTime2 < 0 || splashActivityStartTime2 > 60000 || j10 < 0 || j10 > 60000 || j12 < 0 || j12 > 60000 || j14 < 0 || j14 > 60000 || j16 < 0 || j16 > 60000 || j18 < 0 || j18 > 60000 || j20 < 0 || j20 > 60000 || j22 < 0 || j22 > 60000 || j24 < 0 || j24 > 60000 || j26 < 0 || j26 > 60000 || j28 < 0 || j28 > 60000 || j29 < 0 || j29 > 60000 || j31 < 0 || j31 > 60000 || j33 < 0 || j33 > 60000 || j35 < 0 || j35 > 60000 || j37 < 0 || j37 > 60000 || j39 < 0 || j39 > 60000 || j41 < 0 || j41 > 60000 || j42 < 0 || j42 > 60000 || j44 < 0 || j44 > 60000 || j46 < 0 || j46 > 60000 || j48 < 0 || j48 > 60000 || j50 < 0 || j50 > 60000 || j52 < 0 || j52 > 60000 || j54 < 0 || j54 > 60000 || j55 < 0 || j55 > 60000 || j56 < 0 || j56 > 60000 || j57 < 0 || j57 > 60000 || j58 < 0 || j58 > 60000 || j59 < 0 || j59 > 60000 || j60 < 0 || j60 > 60000 || j61 < 0 || j61 > 60000 || j62 < 0 || j62 > 60000 || j63 < 0 || j63 > 60000 || j64 < 0 || j64 > 60000 || j5 < 0 || j5 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(INIT_ACCOUNT_CHANGE, String.valueOf(j7));
            hashMap.put(PERMMISSION_UTIL, String.valueOf(j10));
            hashMap.put(INIT_DIMON_ADAPT, String.valueOf(j12));
            hashMap.put(CLEAN_DIRECTORY, String.valueOf(j14));
            hashMap.put(SHAREP_GET, String.valueOf(j16));
            hashMap.put(CMDROUTER_INIT, String.valueOf(j18));
            hashMap.put(WEBVIEW_SUFFIX, String.valueOf(j20));
            hashMap.put(INIT_CMD, String.valueOf(j22));
            hashMap.put(INIT_VERSION, String.valueOf(j24));
            hashMap.put(INIT_ALL, String.valueOf(j26));
            hashMap.put(INIT_FACE, String.valueOf(j28));
            hashMap.put(INIT_TASKS, String.valueOf(j29));
            if (b.j().k("static_opt_open", 0) > 0) {
                hashMap.put(NOSTATIC_INIT_TASKS_COST, String.valueOf(j29));
            } else {
                hashMap.put(STATIC_INIT_TASKS_COST, String.valueOf(j29));
            }
            hashMap.put(INIT_GO_ACTION, String.valueOf(j31));
            hashMap.put(INIT_ACCOUNT, String.valueOf(j33));
            hashMap.put(INIT_INTERRUPT_RULE, String.valueOf(j35));
            hashMap.put(INIT_SAPI, String.valueOf(j37));
            hashMap.put(INIT_PLUGIN, String.valueOf(j39));
            hashMap.put(INIT_SWAN, String.valueOf(j41));
            hashMap.put(INIT_BEAR, String.valueOf(j42));
            hashMap.put(INIT_TO_LOGO, String.valueOf(j44));
            hashMap.put(INIT_LOKI, String.valueOf(j46));
            hashMap.put(INIT_COUNT_STATS, String.valueOf(j48));
            hashMap.put(INIT_RUKA, String.valueOf(j52));
            hashMap.put(INIT_UBC, String.valueOf(j50));
            hashMap.put(INIT_AXE, String.valueOf(j54));
            hashMap.put(INIT_AR, String.valueOf(j55));
            hashMap.put(INIT_MSG_ONE, String.valueOf(j56));
            hashMap.put(INIT_MSG_TWO, String.valueOf(j57));
            hashMap.put(INIT_MSG_THREE, String.valueOf(j58));
            hashMap.put(INIT_MSG_FOUR, String.valueOf(j59));
            hashMap.put(INIT_MSG_FIVE, String.valueOf(j60));
            hashMap.put(INIT_MSG_SIX, String.valueOf(j61));
            hashMap.put(INIT_MSG_SEVEN, String.valueOf(j62));
            hashMap.put(INIT_MSG_EIGHT, String.valueOf(j63));
            hashMap.put(INIT_MSG_NINE, String.valueOf(j64));
            hashMap.put(ON_APP_START_END, String.valueOf(j5));
            hashMap.put(ON_APP_END_2_ACTIVITY_START_GAP, String.valueOf(splashActivityStartTime));
            hashMap.put(ON_APP_START_2_ACTIVITY_START_DURATION, String.valueOf(splashActivityStartTime2));
            for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j4, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.APP_CREATE_STAGE, jsonData);
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
            this.mCreateStartTimestamp = -1L;
            this.mPrcocessUpgradeEndTimeStamp = -1L;
            this.mInitAppConfigEndTimeStamp = -1L;
            this.mLaunchTaskScheduleEndTimestamp = -1L;
            this.mInitModuleContextEndTimestamp = -1L;
            this.mOnAppCreateEndTimestamp = -1L;
            this.mInitAccountChangeTimestamp = -1L;
            this.mPermissionUtilEndTimestamp = -1L;
            this.mCleanDirectoryEndTimestamp = -1L;
            this.mSharePEndTimestamp = -1L;
            this.mCmdRouterInitEndTimestamp = -1L;
            this.mWebViewSufEndTimestamp = -1L;
            this.mInitCmdEndTimestamp = -1L;
            this.mInitVersionEndTimestamp = -1L;
            this.mInitAllEndTimestamp = -1L;
            this.mInitFaceEndTimestamp = -1L;
            this.mInitTasksEndTimestamp = -1L;
            this.mInitGOEndTimestamp = -1L;
            this.mInitLoginEndTimestamp = -1L;
            this.mInitInterruptEndTimestamp = -1L;
            this.mInitSapiEndTimestamp = -1L;
            this.mInitPluginEndTimestamp = -1L;
            this.mInitSwanEndTimestamp = -1L;
            this.mInitBearEndTimestamp = -1L;
            this.mInitToLogoEndTimestamp = -1L;
            this.mInitLokiEndTimestamp = -1L;
            this.mInitCountStatsEndTimestamp = -1L;
            this.mInitUbcEndTimestamp = -1L;
            this.mInitRukaEndTimestamp = -1L;
            this.mInitAxeEndTimestamp = -1L;
            this.mInitAREndTimestamp = -1L;
            this.mInitMsgOneEndTimestamp = -1L;
            this.mInitMsgTwoEndTimestamp = -1L;
            this.mInitMsgThreeEndTimestamp = -1L;
            this.mInitMsgFourEndTimestamp = -1L;
            this.mInitMsgFiveEndTimestamp = -1L;
            this.mInitMsgSixEndTimestamp = -1L;
            this.mInitMsgSevenEndTimestamp = -1L;
            this.mInitMsgEightEndTimestamp = -1L;
            this.mInitMsgNineEndTimestamp = -1L;
            this.mInitMsgOneStartTimestamp = -1L;
            this.mInitMsgTwoStartTimestamp = -1L;
            this.mInitMsgThreeStartTimestamp = -1L;
            this.mInitMsgFourStartTimestamp = -1L;
            this.mInitMsgFiveStartTimestamp = -1L;
            this.mInitMsgSixStartTimestamp = -1L;
            this.mInitMsgSevenStartTimestamp = -1L;
            this.mInitMsgEightStartTimestamp = -1L;
            this.mInitMsgNineStartTimestamp = -1L;
            this.mAppCreateEndTimestamp = -1L;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            switch (i2) {
                case 2000:
                    this.mCreateStartTimestamp = j2;
                    return;
                case 2001:
                    this.mPrcocessUpgradeEndTimeStamp = j2;
                    return;
                case 2002:
                    this.mInitAppConfigEndTimeStamp = j2;
                    return;
                case 2003:
                    this.mLaunchTaskScheduleEndTimestamp = j2;
                    return;
                case 2004:
                default:
                    return;
                case 2005:
                    this.mOnAppCreateEndTimestamp = j2;
                    return;
                case 2006:
                    this.mAppCreateEndTimestamp = j2;
                    return;
                case 2007:
                    this.mInitAccountChangeTimestamp = j2;
                    return;
                case 2008:
                    this.mPermissionUtilEndTimestamp = j2;
                    return;
                case 2009:
                    this.mInitAdapterDimonEndTimestamp = j2;
                    return;
                case 2010:
                    this.mCleanDirectoryEndTimestamp = j2;
                    return;
                case 2011:
                    this.mSharePEndTimestamp = j2;
                    return;
                case 2012:
                    this.mCmdRouterInitEndTimestamp = j2;
                    return;
                case 2013:
                    this.mWebViewSufEndTimestamp = j2;
                    return;
                case 2014:
                    this.mInitCmdEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_VERSION_STAMP_KEY /* 2015 */:
                    this.mInitVersionEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_ALL_STAMP_KEY /* 2016 */:
                    this.mInitAllEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_FACE_STAMP_KEY /* 2017 */:
                    this.mInitFaceEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_TASKS_STAMP_KEY /* 2018 */:
                    this.mInitTasksEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY /* 2019 */:
                    this.mInitGOEndTimestamp = j2;
                    return;
                case 2020:
                    this.mInitLoginEndTimestamp = j2;
                    return;
                case 2021:
                    this.mInitInterruptEndTimestamp = j2;
                    return;
                case 2022:
                    this.mInitSapiEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_PLUGIN_STAMP_KEY /* 2023 */:
                    this.mInitPluginEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_SWAN_DATA_STAMP_KEY /* 2024 */:
                    this.mInitSwanEndTimestamp = j2;
                    return;
                case 2025:
                    this.mInitBearEndTimestamp = j2;
                    return;
                case 2026:
                    this.mInitToLogoEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_LOKI_STAMP_KEY /* 2027 */:
                    this.mInitLokiEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_COUNT_STATS_STAMP_KEY /* 2028 */:
                    this.mInitCountStatsEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_UBC_STAMP_KEY /* 2029 */:
                    this.mInitUbcEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_RUKA_STAMP_KEY /* 2030 */:
                    this.mInitRukaEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_AXE_STAMP_KEY /* 2031 */:
                    this.mInitAxeEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_AR_STAMP_KEY /* 2032 */:
                    this.mInitAREndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_ONE_STAMP_KEY /* 2033 */:
                    this.mInitMsgOneEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_TWO_STAMP_KEY /* 2034 */:
                    this.mInitMsgTwoEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_THREE_STAMP_KEY /* 2035 */:
                    this.mInitMsgThreeEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_FOUR_STAMP_KEY /* 2036 */:
                    this.mInitMsgFourEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_FIVE_STAMP_KEY /* 2037 */:
                    this.mInitMsgFiveEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY /* 2038 */:
                    this.mInitMsgSixEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_SEVEN_STAMP_KEY /* 2039 */:
                    this.mInitMsgSevenEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_EIGHT_STAMP_KEY /* 2040 */:
                    this.mInitMsgEightEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_NINE_STAMP_KEY /* 2041 */:
                    this.mInitMsgNineEndTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_ONE_START_STAMP_KEY /* 2042 */:
                    this.mInitMsgOneStartTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_TWO_START_STAMP_KEY /* 2043 */:
                    this.mInitMsgTwoStartTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_THREE_START_STAMP_KEY /* 2044 */:
                    this.mInitMsgThreeStartTimestamp = j2;
                    return;
                case 2045:
                    this.mInitMsgFourStartTimestamp = j2;
                    return;
                case 2046:
                    this.mInitMsgFiveStartTimestamp = j2;
                    return;
                case 2047:
                    this.mInitMsgSixStartTimestamp = j2;
                    return;
                case 2048:
                    this.mInitMsgSevenStartTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_EIGHT_START_STAMP_KEY /* 2049 */:
                    this.mInitMsgEightStartTimestamp = j2;
                    return;
                case SpeedStatsStampTable.INIT_MSG_NINE_START_STAMP_KEY /* 2050 */:
                    this.mInitMsgNineStartTimestamp = j2;
                    return;
            }
        }
    }
}
