package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes9.dex */
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:178:0x03dc
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r85) {
        /*
            r84 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.AppCreateSpeedStats.$ic
            if (r0 != 0) goto L41b
        L4:
            r1 = r84
            r2 = r85
            super.packData(r85)
            r3 = 1
            if (r2 != 0) goto Lf
            return r3
        Lf:
            long r4 = r1.mAppCreateEndTimestamp
            long r6 = r1.mCreateStartTimestamp
            long r8 = r4 - r6
            long r4 = r4 - r6
            long r10 = r1.mInitBearEndTimestamp
            long r6 = r10 - r6
            long r12 = r1.mInitVersionEndTimestamp
            long r10 = r12 - r10
            long r14 = r1.mInitAccountChangeTimestamp
            long r12 = r14 - r12
            r16 = r4
            long r3 = r1.mInitFaceEndTimestamp
            long r14 = r3 - r14
            r18 = r6
            long r5 = r1.mWebViewSufEndTimestamp
            long r3 = r5 - r3
            r20 = r14
            long r14 = r1.mInitTasksEndTimestamp
            long r5 = r14 - r5
            r22 = r5
            long r5 = r1.mPermissionUtilEndTimestamp
            long r14 = r5 - r14
            r24 = r10
            long r10 = r1.mInitAdapterDimonEndTimestamp
            long r5 = r10 - r5
            r26 = r3
            long r2 = r1.mCleanDirectoryEndTimestamp
            long r10 = r2 - r10
            r28 = r10
            long r10 = r1.mSharePEndTimestamp
            long r2 = r10 - r2
            r30 = r2
            long r2 = r1.mCmdRouterInitEndTimestamp
            long r10 = r2 - r10
            r32 = r10
            long r10 = r1.mInitCmdEndTimestamp
            long r2 = r10 - r2
            r34 = r2
            long r2 = r1.mInitAllEndTimestamp
            long r10 = r2 - r10
            r36 = r10
            long r10 = r1.mInitGOEndTimestamp
            long r2 = r10 - r2
            r38 = r2
            long r2 = r1.mInitLoginEndTimestamp
            long r10 = r2 - r10
            r40 = r10
            long r10 = r1.mInitInterruptEndTimestamp
            long r2 = r10 - r2
            r42 = r2
            long r2 = r1.mInitSapiEndTimestamp
            long r10 = r2 - r10
            r44 = r10
            long r10 = r1.mInitPluginEndTimestamp
            long r2 = r10 - r2
            r46 = r2
            long r2 = r1.mInitSwanEndTimestamp
            long r10 = r2 - r10
            r48 = r10
            long r10 = r1.mInitToLogoEndTimestamp
            long r2 = r10 - r2
            r50 = r2
            long r2 = r1.mInitLokiEndTimestamp
            long r10 = r2 - r10
            r52 = r10
            long r10 = r1.mInitCountStatsEndTimestamp
            long r2 = r10 - r2
            r54 = r2
            long r2 = r1.mInitUbcEndTimestamp
            long r10 = r2 - r10
            r56 = r10
            long r10 = r1.mInitRukaEndTimestamp
            long r2 = r10 - r2
            r58 = r2
            long r2 = r1.mInitAxeEndTimestamp
            long r10 = r2 - r10
            r60 = r10
            long r10 = r1.mInitAREndTimestamp
            long r10 = r10 - r2
            long r2 = r1.mInitMsgOneEndTimestamp
            r62 = r10
            long r10 = r1.mInitMsgOneStartTimestamp
            long r2 = r2 - r10
            long r10 = r1.mInitMsgTwoEndTimestamp
            r64 = r2
            long r2 = r1.mInitMsgTwoStartTimestamp
            long r10 = r10 - r2
            long r2 = r1.mInitMsgThreeEndTimestamp
            r66 = r10
            long r10 = r1.mInitMsgThreeStartTimestamp
            long r2 = r2 - r10
            long r10 = r1.mInitMsgFourEndTimestamp
            r68 = r2
            long r2 = r1.mInitMsgFourStartTimestamp
            long r10 = r10 - r2
            long r2 = r1.mInitMsgFiveEndTimestamp
            r70 = r10
            long r10 = r1.mInitMsgFiveStartTimestamp
            long r2 = r2 - r10
            long r10 = r1.mInitMsgSixEndTimestamp
            r72 = r2
            long r2 = r1.mInitMsgSixStartTimestamp
            long r10 = r10 - r2
            long r2 = r1.mInitMsgSevenEndTimestamp
            r74 = r10
            long r10 = r1.mInitMsgSevenStartTimestamp
            long r2 = r2 - r10
            long r10 = r1.mInitMsgEightEndTimestamp
            r76 = r2
            long r2 = r1.mInitMsgEightStartTimestamp
            long r10 = r10 - r2
            long r2 = r1.mInitMsgNineEndTimestamp
            r78 = r10
            long r10 = r1.mInitMsgNineStartTimestamp
            long r2 = r2 - r10
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r10 = r0.getActivityStartTime()
            r80 = r2
            long r2 = r1.mAppCreateEndTimestamp
            long r10 = r10 - r2
            r0 = 0
            r2 = 0
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            r82 = 60000(0xea60, double:2.9644E-319)
            int r4 = (r8 > r82 ? 1 : (r8 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r12 > r82 ? 1 : (r12 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r10 > r82 ? 1 : (r10 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r14 > r82 ? 1 : (r14 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r5 > r82 ? 1 : (r5 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r28 > r2 ? 1 : (r28 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r28 > r82 ? 1 : (r28 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r30 > r2 ? 1 : (r30 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r30 > r82 ? 1 : (r30 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r32 > r2 ? 1 : (r32 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r32 > r82 ? 1 : (r32 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r26 > r2 ? 1 : (r26 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r26 > r82 ? 1 : (r26 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r34 > r2 ? 1 : (r34 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r34 > r82 ? 1 : (r34 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r24 > r2 ? 1 : (r24 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r24 > r82 ? 1 : (r24 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r36 > r2 ? 1 : (r36 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r36 > r82 ? 1 : (r36 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r20 > r82 ? 1 : (r20 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r22 > r82 ? 1 : (r22 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r38 > r2 ? 1 : (r38 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r38 > r82 ? 1 : (r38 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r40 > r2 ? 1 : (r40 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r40 > r82 ? 1 : (r40 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r42 > r2 ? 1 : (r42 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r42 > r82 ? 1 : (r42 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r44 > r2 ? 1 : (r44 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r44 > r82 ? 1 : (r44 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r46 > r2 ? 1 : (r46 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r46 > r82 ? 1 : (r46 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r48 > r2 ? 1 : (r48 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r48 > r82 ? 1 : (r48 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r18 > r82 ? 1 : (r18 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r50 > r2 ? 1 : (r50 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r50 > r82 ? 1 : (r50 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r52 > r2 ? 1 : (r52 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r52 > r82 ? 1 : (r52 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r54 > r2 ? 1 : (r54 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r54 > r82 ? 1 : (r54 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r56 > r2 ? 1 : (r56 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r56 > r82 ? 1 : (r56 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r58 > r2 ? 1 : (r58 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r58 > r82 ? 1 : (r58 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r60 > r2 ? 1 : (r60 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r60 > r82 ? 1 : (r60 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r62 > r2 ? 1 : (r62 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r62 > r82 ? 1 : (r62 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r64 > r2 ? 1 : (r64 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r64 > r82 ? 1 : (r64 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r66 > r2 ? 1 : (r66 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r66 > r82 ? 1 : (r66 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r68 > r2 ? 1 : (r68 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r68 > r82 ? 1 : (r68 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r70 > r2 ? 1 : (r70 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r70 > r82 ? 1 : (r70 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r72 > r2 ? 1 : (r72 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r72 > r82 ? 1 : (r72 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r74 > r2 ? 1 : (r74 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r74 > r82 ? 1 : (r74 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r76 > r2 ? 1 : (r76 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r76 > r82 ? 1 : (r76 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r78 > r2 ? 1 : (r78 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r78 > r82 ? 1 : (r78 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r80 > r2 ? 1 : (r80 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r4 = (r80 > r82 ? 1 : (r80 == r82 ? 0 : -1))
            if (r4 > 0) goto L41a
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 < 0) goto L41a
            int r2 = (r16 > r82 ? 1 : (r16 == r82 ? 0 : -1))
            if (r2 <= 0) goto L22f
            goto L41a
        L22f:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = java.lang.String.valueOf(r12)
            java.lang.String r4 = "initAccountChange"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r14)
            java.lang.String r4 = "permissionUtil"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r4 = "initDimonAdapter"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r28)
            java.lang.String r4 = "cleanDirectory"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r30)
            java.lang.String r4 = "sharePreferGet"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r32)
            java.lang.String r4 = "cmdRouterInit"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r26)
            java.lang.String r4 = "webviewSuffix"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r34)
            java.lang.String r4 = "initCmd"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r24)
            java.lang.String r4 = "initVersion"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r36)
            java.lang.String r4 = "initAll"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r20)
            java.lang.String r4 = "initFace"
            r2.put(r4, r3)
            java.lang.String r3 = java.lang.String.valueOf(r22)
            java.lang.String r4 = "initTasks"
            r2.put(r4, r3)
            c.a.q0.s.e0.b r3 = c.a.q0.s.e0.b.j()
            java.lang.String r4 = "static_opt_open"
            int r3 = r3.k(r4, r0)
            if (r3 <= 0) goto L2af
            r0 = 1
        L2af:
            if (r0 == 0) goto L2bb
            java.lang.String r0 = java.lang.String.valueOf(r22)
            java.lang.String r3 = "noStaticinitTasksCost"
            r2.put(r3, r0)
            goto L2c5
        L2bb:
            java.lang.String r0 = java.lang.String.valueOf(r22)
            java.lang.String r3 = "staticInitTasksCost"
            r2.put(r3, r0)
        L2c5:
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r3 = "initGoAction"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r3 = "initAccount"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r3 = "initInterruptRule"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r3 = "initSapi"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r46)
            java.lang.String r3 = "initPlugin"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r3 = "initSwan"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r3 = "initBear"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r50)
            java.lang.String r3 = "initToLogo"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r52)
            java.lang.String r3 = "initLoki"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r54)
            java.lang.String r3 = "initCountStats"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r58)
            java.lang.String r3 = "initRuka"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r56)
            java.lang.String r3 = "initUBC"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r60)
            java.lang.String r3 = "initAxe"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r62)
            java.lang.String r3 = "initAR"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r64)
            java.lang.String r3 = "initMsgOne"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r66)
            java.lang.String r3 = "initMsgTwo"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r68)
            java.lang.String r3 = "initMsgThree"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r70)
            java.lang.String r3 = "initMsgFour"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r72)
            java.lang.String r3 = "initMsgFive"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r74)
            java.lang.String r3 = "initMsgSix"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r76)
            java.lang.String r3 = "initMsgSeven"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r78)
            java.lang.String r3 = "initMsgEight"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r80)
            java.lang.String r3 = "initMsgNine"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r3 = "onAppStart2End"
            r2.put(r3, r0)
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r4 = "onAppEnd2ActivityStartGap"
            r2.put(r4, r0)
            java.util.Hashtable<java.lang.String, java.lang.Long> r0 = r1.mLaunchTaskDuration
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L3b0:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L3cc
            java.lang.Object r5 = r0.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.put(r6, r5)
            goto L3b0
        L3cc:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r8, r2)
            if (r0 == 0) goto L3e9
            java.lang.String r2 = "appCreate"
            r5 = r85
            r5.put(r2, r0)     // Catch: org.json.JSONException -> L3da
            goto L3eb
        L3da:
            r0 = move-exception
            goto L3df
        L3dc:
            r0 = move-exception
            r5 = r85
        L3df:
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L3eb
            r0.printStackTrace()
            goto L3eb
        L3e9:
            r5 = r85
        L3eb:
            r2 = 0
            r6 = r16
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r6, r2)
            if (r0 == 0) goto L403
            r5.put(r3, r0)     // Catch: org.json.JSONException -> L3f8
            goto L403
        L3f8:
            r0 = move-exception
            r3 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L403
            r3.printStackTrace()
        L403:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r10, r2)
            if (r0 == 0) goto L418
            r5.put(r4, r0)     // Catch: org.json.JSONException -> L40d
            goto L418
        L40d:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L418
            r2.printStackTrace()
        L418:
            r2 = 1
            return r2
        L41a:
            return r0
        L41b:
            r82 = r0
            r83 = 1048581(0x100005, float:1.469375E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r82.invokeL(r83, r84, r85)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.AppCreateSpeedStats.packData(org.json.JSONObject):boolean");
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
