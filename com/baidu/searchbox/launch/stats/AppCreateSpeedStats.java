package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes7.dex */
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
    public void addStatsDuration(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            super.addStatsDuration(str, j);
            this.mLaunchTaskDuration.put(str, Long.valueOf(j));
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:178:0x03db
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r84) {
        /*
            r83 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.AppCreateSpeedStats.$ic
            if (r0 != 0) goto L41a
        L4:
            r1 = r83
            r2 = r84
            super.packData(r84)
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
            long r12 = r1.mInitAccountChangeTimestamp
            long r10 = r12 - r10
            long r14 = r1.mInitFaceEndTimestamp
            long r12 = r14 - r12
            r16 = r4
            long r3 = r1.mWebViewSufEndTimestamp
            long r14 = r3 - r14
            r18 = r6
            long r5 = r1.mInitTasksEndTimestamp
            long r3 = r5 - r3
            r20 = r3
            long r2 = r1.mPermissionUtilEndTimestamp
            long r4 = r2 - r5
            long r6 = r1.mInitAdapterDimonEndTimestamp
            long r2 = r6 - r2
            r22 = r12
            long r12 = r1.mCleanDirectoryEndTimestamp
            long r6 = r12 - r6
            r24 = r14
            long r14 = r1.mSharePEndTimestamp
            long r12 = r14 - r12
            r26 = r12
            long r12 = r1.mCmdRouterInitEndTimestamp
            long r14 = r12 - r14
            r28 = r14
            long r14 = r1.mInitCmdEndTimestamp
            long r12 = r14 - r12
            r30 = r12
            long r12 = r1.mInitVersionEndTimestamp
            long r14 = r12 - r14
            r32 = r14
            long r14 = r1.mInitAllEndTimestamp
            long r12 = r14 - r12
            r34 = r12
            long r12 = r1.mInitGOEndTimestamp
            long r14 = r12 - r14
            r36 = r14
            long r14 = r1.mInitLoginEndTimestamp
            long r12 = r14 - r12
            r38 = r12
            long r12 = r1.mInitInterruptEndTimestamp
            long r14 = r12 - r14
            r40 = r14
            long r14 = r1.mInitSapiEndTimestamp
            long r12 = r14 - r12
            r42 = r12
            long r12 = r1.mInitPluginEndTimestamp
            long r14 = r12 - r14
            r44 = r14
            long r14 = r1.mInitSwanEndTimestamp
            long r12 = r14 - r12
            r46 = r12
            long r12 = r1.mInitToLogoEndTimestamp
            long r14 = r12 - r14
            r48 = r14
            long r14 = r1.mInitLokiEndTimestamp
            long r12 = r14 - r12
            r50 = r12
            long r12 = r1.mInitCountStatsEndTimestamp
            long r14 = r12 - r14
            r52 = r14
            long r14 = r1.mInitUbcEndTimestamp
            long r12 = r14 - r12
            r54 = r12
            long r12 = r1.mInitRukaEndTimestamp
            long r14 = r12 - r14
            r56 = r14
            long r14 = r1.mInitAxeEndTimestamp
            long r12 = r14 - r12
            r58 = r12
            long r12 = r1.mInitAREndTimestamp
            long r12 = r12 - r14
            long r14 = r1.mInitMsgOneEndTimestamp
            r60 = r12
            long r12 = r1.mInitMsgOneStartTimestamp
            long r14 = r14 - r12
            long r12 = r1.mInitMsgTwoEndTimestamp
            r62 = r14
            long r14 = r1.mInitMsgTwoStartTimestamp
            long r12 = r12 - r14
            long r14 = r1.mInitMsgThreeEndTimestamp
            r64 = r12
            long r12 = r1.mInitMsgThreeStartTimestamp
            long r14 = r14 - r12
            long r12 = r1.mInitMsgFourEndTimestamp
            r66 = r14
            long r14 = r1.mInitMsgFourStartTimestamp
            long r12 = r12 - r14
            long r14 = r1.mInitMsgFiveEndTimestamp
            r68 = r12
            long r12 = r1.mInitMsgFiveStartTimestamp
            long r14 = r14 - r12
            long r12 = r1.mInitMsgSixEndTimestamp
            r70 = r14
            long r14 = r1.mInitMsgSixStartTimestamp
            long r12 = r12 - r14
            long r14 = r1.mInitMsgSevenEndTimestamp
            r72 = r12
            long r12 = r1.mInitMsgSevenStartTimestamp
            long r14 = r14 - r12
            long r12 = r1.mInitMsgEightEndTimestamp
            r74 = r14
            long r14 = r1.mInitMsgEightStartTimestamp
            long r12 = r12 - r14
            long r14 = r1.mInitMsgNineEndTimestamp
            r76 = r12
            long r12 = r1.mInitMsgNineStartTimestamp
            long r14 = r14 - r12
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r12 = r0.getActivityStartTime()
            r78 = r14
            long r14 = r1.mAppCreateEndTimestamp
            long r12 = r12 - r14
            r0 = 0
            r14 = 0
            int r80 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r80 < 0) goto L419
            r80 = 60000(0xea60, double:2.9644E-319)
            int r82 = (r8 > r80 ? 1 : (r8 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r10 > r80 ? 1 : (r10 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r12 > r80 ? 1 : (r12 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r4 > r80 ? 1 : (r4 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r2 > r80 ? 1 : (r2 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r6 > r80 ? 1 : (r6 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r26 > r80 ? 1 : (r26 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r28 > r80 ? 1 : (r28 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r24 > r80 ? 1 : (r24 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r30 > r14 ? 1 : (r30 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r30 > r80 ? 1 : (r30 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r32 > r14 ? 1 : (r32 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r32 > r80 ? 1 : (r32 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r34 > r14 ? 1 : (r34 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r34 > r80 ? 1 : (r34 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r22 > r80 ? 1 : (r22 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r20 > r80 ? 1 : (r20 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r36 > r14 ? 1 : (r36 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r36 > r80 ? 1 : (r36 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r38 > r14 ? 1 : (r38 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r38 > r80 ? 1 : (r38 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r40 > r14 ? 1 : (r40 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r40 > r80 ? 1 : (r40 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r42 > r14 ? 1 : (r42 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r42 > r80 ? 1 : (r42 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r44 > r14 ? 1 : (r44 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r44 > r80 ? 1 : (r44 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r46 > r14 ? 1 : (r46 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r46 > r80 ? 1 : (r46 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r18 > r80 ? 1 : (r18 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r48 > r14 ? 1 : (r48 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r48 > r80 ? 1 : (r48 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r50 > r14 ? 1 : (r50 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r50 > r80 ? 1 : (r50 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r52 > r14 ? 1 : (r52 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r52 > r80 ? 1 : (r52 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r54 > r14 ? 1 : (r54 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r54 > r80 ? 1 : (r54 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r56 > r14 ? 1 : (r56 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r56 > r80 ? 1 : (r56 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r58 > r14 ? 1 : (r58 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r58 > r80 ? 1 : (r58 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r60 > r14 ? 1 : (r60 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r60 > r80 ? 1 : (r60 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r62 > r14 ? 1 : (r62 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r62 > r80 ? 1 : (r62 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r64 > r14 ? 1 : (r64 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r64 > r80 ? 1 : (r64 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r66 > r14 ? 1 : (r66 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r66 > r80 ? 1 : (r66 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r68 > r14 ? 1 : (r68 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r68 > r80 ? 1 : (r68 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r70 > r14 ? 1 : (r70 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r70 > r80 ? 1 : (r70 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r72 > r14 ? 1 : (r72 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r72 > r80 ? 1 : (r72 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r74 > r14 ? 1 : (r74 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r74 > r80 ? 1 : (r74 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r76 > r14 ? 1 : (r76 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r76 > r80 ? 1 : (r76 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r78 > r14 ? 1 : (r78 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r82 = (r78 > r80 ? 1 : (r78 == r80 ? 0 : -1))
            if (r82 > 0) goto L419
            int r82 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r82 < 0) goto L419
            int r14 = (r16 > r80 ? 1 : (r16 == r80 ? 0 : -1))
            if (r14 <= 0) goto L22d
            goto L419
        L22d:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r11 = "initAccountChange"
            r14.put(r11, r10)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "permissionUtil"
            r14.put(r5, r4)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "initDimonAdapter"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "cleanDirectory"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r26)
            java.lang.String r3 = "sharePreferGet"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r28)
            java.lang.String r3 = "cmdRouterInit"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r24)
            java.lang.String r3 = "webviewSuffix"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r30)
            java.lang.String r3 = "initCmd"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r32)
            java.lang.String r3 = "initVersion"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r34)
            java.lang.String r3 = "initAll"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r22)
            java.lang.String r3 = "initFace"
            r14.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r20)
            java.lang.String r3 = "initTasks"
            r14.put(r3, r2)
            b.a.q0.s.e0.b r2 = b.a.q0.s.e0.b.j()
            java.lang.String r3 = "static_opt_open"
            int r2 = r2.k(r3, r0)
            if (r2 <= 0) goto L2ae
            r0 = 1
        L2ae:
            if (r0 == 0) goto L2ba
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r2 = "noStaticinitTasksCost"
            r14.put(r2, r0)
            goto L2c4
        L2ba:
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r2 = "staticInitTasksCost"
            r14.put(r2, r0)
        L2c4:
            java.lang.String r0 = java.lang.String.valueOf(r36)
            java.lang.String r2 = "initGoAction"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r2 = "initAccount"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r2 = "initInterruptRule"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r2 = "initSapi"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r2 = "initPlugin"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r46)
            java.lang.String r2 = "initSwan"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r2 = "initBear"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r2 = "initToLogo"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r50)
            java.lang.String r2 = "initLoki"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r52)
            java.lang.String r2 = "initCountStats"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r56)
            java.lang.String r2 = "initRuka"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r54)
            java.lang.String r2 = "initUBC"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r58)
            java.lang.String r2 = "initAxe"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r60)
            java.lang.String r2 = "initAR"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r62)
            java.lang.String r2 = "initMsgOne"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r64)
            java.lang.String r2 = "initMsgTwo"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r66)
            java.lang.String r2 = "initMsgThree"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r68)
            java.lang.String r2 = "initMsgFour"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r70)
            java.lang.String r2 = "initMsgFive"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r72)
            java.lang.String r2 = "initMsgSix"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r74)
            java.lang.String r2 = "initMsgSeven"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r76)
            java.lang.String r2 = "initMsgEight"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r78)
            java.lang.String r2 = "initMsgNine"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r2 = "onAppStart2End"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r3 = "onAppEnd2ActivityStartGap"
            r14.put(r3, r0)
            java.util.Hashtable<java.lang.String, java.lang.Long> r0 = r1.mLaunchTaskDuration
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L3af:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L3cb
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r14.put(r5, r4)
            goto L3af
        L3cb:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r8, r14)
            if (r0 == 0) goto L3e8
            java.lang.String r4 = "appCreate"
            r5 = r84
            r5.put(r4, r0)     // Catch: org.json.JSONException -> L3d9
            goto L3ea
        L3d9:
            r0 = move-exception
            goto L3de
        L3db:
            r0 = move-exception
            r5 = r84
        L3de:
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L3ea
            r0.printStackTrace()
            goto L3ea
        L3e8:
            r5 = r84
        L3ea:
            r4 = 0
            r6 = r16
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r6, r4)
            if (r0 == 0) goto L402
            r5.put(r2, r0)     // Catch: org.json.JSONException -> L3f7
            goto L402
        L3f7:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L402
            r2.printStackTrace()
        L402:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r12, r4)
            if (r0 == 0) goto L417
            r5.put(r3, r0)     // Catch: org.json.JSONException -> L40c
            goto L417
        L40c:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L417
            r2.printStackTrace()
        L417:
            r2 = 1
            return r2
        L419:
            return r0
        L41a:
            r81 = r0
            r82 = 1048581(0x100005, float:1.469375E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r81.invokeL(r82, r83, r84)
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
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i2, j);
            switch (i2) {
                case 2000:
                    this.mCreateStartTimestamp = j;
                    return;
                case 2001:
                    this.mPrcocessUpgradeEndTimeStamp = j;
                    return;
                case 2002:
                    this.mInitAppConfigEndTimeStamp = j;
                    return;
                case 2003:
                    this.mLaunchTaskScheduleEndTimestamp = j;
                    return;
                case 2004:
                default:
                    return;
                case 2005:
                    this.mOnAppCreateEndTimestamp = j;
                    return;
                case 2006:
                    this.mAppCreateEndTimestamp = j;
                    return;
                case 2007:
                    this.mInitAccountChangeTimestamp = j;
                    return;
                case 2008:
                    this.mPermissionUtilEndTimestamp = j;
                    return;
                case 2009:
                    this.mInitAdapterDimonEndTimestamp = j;
                    return;
                case 2010:
                    this.mCleanDirectoryEndTimestamp = j;
                    return;
                case 2011:
                    this.mSharePEndTimestamp = j;
                    return;
                case 2012:
                    this.mCmdRouterInitEndTimestamp = j;
                    return;
                case 2013:
                    this.mWebViewSufEndTimestamp = j;
                    return;
                case 2014:
                    this.mInitCmdEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_VERSION_STAMP_KEY /* 2015 */:
                    this.mInitVersionEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_ALL_STAMP_KEY /* 2016 */:
                    this.mInitAllEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_FACE_STAMP_KEY /* 2017 */:
                    this.mInitFaceEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_TASKS_STAMP_KEY /* 2018 */:
                    this.mInitTasksEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY /* 2019 */:
                    this.mInitGOEndTimestamp = j;
                    return;
                case 2020:
                    this.mInitLoginEndTimestamp = j;
                    return;
                case 2021:
                    this.mInitInterruptEndTimestamp = j;
                    return;
                case 2022:
                    this.mInitSapiEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_PLUGIN_STAMP_KEY /* 2023 */:
                    this.mInitPluginEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_SWAN_DATA_STAMP_KEY /* 2024 */:
                    this.mInitSwanEndTimestamp = j;
                    return;
                case 2025:
                    this.mInitBearEndTimestamp = j;
                    return;
                case 2026:
                    this.mInitToLogoEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_LOKI_STAMP_KEY /* 2027 */:
                    this.mInitLokiEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_COUNT_STATS_STAMP_KEY /* 2028 */:
                    this.mInitCountStatsEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_UBC_STAMP_KEY /* 2029 */:
                    this.mInitUbcEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_RUKA_STAMP_KEY /* 2030 */:
                    this.mInitRukaEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_AXE_STAMP_KEY /* 2031 */:
                    this.mInitAxeEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_AR_STAMP_KEY /* 2032 */:
                    this.mInitAREndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_ONE_STAMP_KEY /* 2033 */:
                    this.mInitMsgOneEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_TWO_STAMP_KEY /* 2034 */:
                    this.mInitMsgTwoEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_THREE_STAMP_KEY /* 2035 */:
                    this.mInitMsgThreeEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_FOUR_STAMP_KEY /* 2036 */:
                    this.mInitMsgFourEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_FIVE_STAMP_KEY /* 2037 */:
                    this.mInitMsgFiveEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY /* 2038 */:
                    this.mInitMsgSixEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_SEVEN_STAMP_KEY /* 2039 */:
                    this.mInitMsgSevenEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_EIGHT_STAMP_KEY /* 2040 */:
                    this.mInitMsgEightEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_NINE_STAMP_KEY /* 2041 */:
                    this.mInitMsgNineEndTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_ONE_START_STAMP_KEY /* 2042 */:
                    this.mInitMsgOneStartTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_TWO_START_STAMP_KEY /* 2043 */:
                    this.mInitMsgTwoStartTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_THREE_START_STAMP_KEY /* 2044 */:
                    this.mInitMsgThreeStartTimestamp = j;
                    return;
                case 2045:
                    this.mInitMsgFourStartTimestamp = j;
                    return;
                case 2046:
                    this.mInitMsgFiveStartTimestamp = j;
                    return;
                case 2047:
                    this.mInitMsgSixStartTimestamp = j;
                    return;
                case 2048:
                    this.mInitMsgSevenStartTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_EIGHT_START_STAMP_KEY /* 2049 */:
                    this.mInitMsgEightStartTimestamp = j;
                    return;
                case SpeedStatsStampTable.INIT_MSG_NINE_START_STAMP_KEY /* 2050 */:
                    this.mInitMsgNineStartTimestamp = j;
                    return;
            }
        }
    }
}
