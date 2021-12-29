package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.Hashtable;
/* loaded from: classes10.dex */
public final class AppCreateSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLEAN_DIRECTORY = "cleanDirectory";
    public static final String CMDROUTER_INIT = "cmdRouterInit";
    public static final String GROWTH_FUNNEL = "growthFunnel";
    public static final String IDLE_AND_FH = "idleAndFH";
    public static final String INIT_ACCOUNT = "initAccount";
    public static final String INIT_ACCOUNT_CHANGE = "initAccountChange";
    public static final String INIT_ADRUNTIME = "initAdRuntime";
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
    public static final String INIT_PERSON_STATIC = "initPersonStatic";
    public static final String INIT_PLAYER = "initPlayer";
    public static final String INIT_PLUGIN = "initPlugin";
    public static final String INIT_RUKA = "initRuka";
    public static final String INIT_SAPI = "initSapi";
    public static final String INIT_SWAN = "initSwan";
    public static final String INIT_TASKS = "initTasks";
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
    public static final String SUPER_ON_CREATE = "superOnCreate";
    public static final String WEBVIEW_SUFFIX = "webviewSuffix";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppCreateEndTimestamp;
    public long mCleanDirectoryEndTimestamp;
    public long mCmdRouterInitEndTimestamp;
    public long mCreateStartTimestamp;
    public long mGrowthFunnelEndTimestamp;
    public long mIdleAndFHEndTimeStamp;
    public long mInitAREndTimestamp;
    public long mInitAccountChangeTimestamp;
    public long mInitAdapterDimonEndTimestamp;
    public long mInitAllEndTimestamp;
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
    public long mInitPersonalizeStaticEndTimestamp;
    public long mInitPlayerEndTimestamp;
    public long mInitPluginEndTimestamp;
    public long mInitRukaEndTimestamp;
    public long mInitSapiEndTimestamp;
    public long mInitSwanEndTimestamp;
    public long mInitTasksEndTimestamp;
    public long mInitUbcEndTimestamp;
    public long mInitVersionEndTimestamp;
    public Hashtable<String, Long> mLaunchTaskDuration;
    public long mLaunchTaskScheduleEndTimestamp;
    public long mPermissionUtilEndTimestamp;
    public long mSharePEndTimestamp;
    public long mSuperEndTimeStamp;
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
        this.mIdleAndFHEndTimeStamp = -1L;
        this.mSuperEndTimeStamp = -1L;
        this.mInitPersonalizeStaticEndTimestamp = -1L;
        this.mLaunchTaskScheduleEndTimestamp = -1L;
        this.mInitModuleContextEndTimestamp = -1L;
        this.mCleanDirectoryEndTimestamp = -1L;
        this.mInitAccountChangeTimestamp = -1L;
        this.mPermissionUtilEndTimestamp = -1L;
        this.mInitAdapterDimonEndTimestamp = -1L;
        this.mWebViewSufEndTimestamp = -1L;
        this.mGrowthFunnelEndTimestamp = -1L;
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
        this.mInitLokiEndTimestamp = -1L;
        this.mInitCountStatsEndTimestamp = -1L;
        this.mInitUbcEndTimestamp = -1L;
        this.mInitRukaEndTimestamp = -1L;
        this.mInitAxeEndTimestamp = -1L;
        this.mInitAREndTimestamp = -1L;
        this.mInitPlayerEndTimestamp = -1L;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:183:0x042f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r94) {
        /*
            r93 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.AppCreateSpeedStats.$ic
            if (r0 != 0) goto L46f
        L4:
            r1 = r93
            r2 = r94
            super.packData(r94)
            r3 = 1
            if (r2 != 0) goto Lf
            return r3
        Lf:
            long r4 = r1.mAppCreateEndTimestamp
            long r6 = r1.mCreateStartTimestamp
            long r8 = r4 - r6
            long r10 = r4 - r6
            long r12 = r1.mInitBearEndTimestamp
            long r6 = r12 - r6
            long r14 = r1.mIdleAndFHEndTimeStamp
            long r12 = r14 - r12
            r16 = r4
            long r3 = r1.mSuperEndTimeStamp
            long r14 = r3 - r14
            r18 = r14
            long r14 = r1.mInitPersonalizeStaticEndTimestamp
            long r3 = r14 - r3
            r20 = r3
            long r2 = r1.mInitAccountChangeTimestamp
            long r4 = r2 - r14
            long r14 = r1.mInitFaceEndTimestamp
            long r2 = r14 - r2
            r22 = r12
            long r12 = r1.mWebViewSufEndTimestamp
            long r14 = r12 - r14
            r24 = r10
            long r10 = r1.mGrowthFunnelEndTimestamp
            long r12 = r10 - r12
            r26 = r12
            long r12 = r1.mInitVersionEndTimestamp
            long r10 = r12 - r10
            r28 = r6
            long r6 = r1.mInitTasksEndTimestamp
            long r12 = r6 - r12
            r30 = r12
            long r12 = r1.mPermissionUtilEndTimestamp
            long r6 = r12 - r6
            r32 = r2
            long r2 = r1.mInitAdapterDimonEndTimestamp
            long r12 = r2 - r12
            r34 = r10
            long r10 = r1.mCleanDirectoryEndTimestamp
            long r2 = r10 - r2
            r36 = r14
            long r14 = r1.mSharePEndTimestamp
            long r10 = r14 - r10
            r38 = r10
            long r10 = r1.mCmdRouterInitEndTimestamp
            long r14 = r10 - r14
            r40 = r14
            long r14 = r1.mInitCmdEndTimestamp
            long r10 = r14 - r10
            r42 = r10
            long r10 = r1.mInitAllEndTimestamp
            long r14 = r10 - r14
            r44 = r14
            long r14 = r1.mInitGOEndTimestamp
            long r10 = r14 - r10
            r46 = r10
            long r10 = r1.mInitLoginEndTimestamp
            long r14 = r10 - r14
            r48 = r14
            long r14 = r1.mInitInterruptEndTimestamp
            long r10 = r14 - r10
            r50 = r10
            long r10 = r1.mInitSapiEndTimestamp
            long r14 = r10 - r14
            r52 = r14
            long r14 = r1.mInitPluginEndTimestamp
            long r10 = r14 - r10
            r54 = r10
            long r10 = r1.mInitSwanEndTimestamp
            long r14 = r10 - r14
            r56 = r14
            long r14 = r1.mInitLokiEndTimestamp
            long r10 = r14 - r10
            r58 = r10
            long r10 = r1.mInitCountStatsEndTimestamp
            long r14 = r10 - r14
            r60 = r14
            long r14 = r1.mInitUbcEndTimestamp
            long r10 = r14 - r10
            r62 = r10
            long r10 = r1.mInitRukaEndTimestamp
            long r14 = r10 - r14
            r64 = r14
            long r14 = r1.mInitAxeEndTimestamp
            long r10 = r14 - r10
            r66 = r10
            long r10 = r1.mInitAREndTimestamp
            long r14 = r10 - r14
            r68 = r14
            long r14 = r1.mInitPlayerEndTimestamp
            long r10 = r14 - r10
            long r14 = r16 - r14
            r16 = r14
            long r14 = r1.mInitMsgOneEndTimestamp
            r70 = r10
            long r10 = r1.mInitMsgOneStartTimestamp
            long r14 = r14 - r10
            long r10 = r1.mInitMsgTwoEndTimestamp
            r72 = r14
            long r14 = r1.mInitMsgTwoStartTimestamp
            long r10 = r10 - r14
            long r14 = r1.mInitMsgThreeEndTimestamp
            r74 = r10
            long r10 = r1.mInitMsgThreeStartTimestamp
            long r14 = r14 - r10
            long r10 = r1.mInitMsgFourEndTimestamp
            r76 = r14
            long r14 = r1.mInitMsgFourStartTimestamp
            long r10 = r10 - r14
            long r14 = r1.mInitMsgFiveEndTimestamp
            r78 = r10
            long r10 = r1.mInitMsgFiveStartTimestamp
            long r14 = r14 - r10
            long r10 = r1.mInitMsgSixEndTimestamp
            r80 = r14
            long r14 = r1.mInitMsgSixStartTimestamp
            long r10 = r10 - r14
            long r14 = r1.mInitMsgSevenEndTimestamp
            r82 = r10
            long r10 = r1.mInitMsgSevenStartTimestamp
            long r14 = r14 - r10
            long r10 = r1.mInitMsgEightEndTimestamp
            r84 = r14
            long r14 = r1.mInitMsgEightStartTimestamp
            long r10 = r10 - r14
            long r14 = r1.mInitMsgNineEndTimestamp
            r86 = r10
            long r10 = r1.mInitMsgNineStartTimestamp
            long r14 = r14 - r10
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r10 = r0.getActivityStartTime()
            r88 = r14
            long r14 = r1.mAppCreateEndTimestamp
            long r10 = r10 - r14
            r14 = 0
            int r90 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r90 < 0) goto L46d
            r90 = 60000(0xea60, double:2.9644E-319)
            int r92 = (r8 > r90 ? 1 : (r8 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r4 > r90 ? 1 : (r4 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r10 > r90 ? 1 : (r10 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r6 > r90 ? 1 : (r6 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r12 > r90 ? 1 : (r12 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r2 > r90 ? 1 : (r2 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r38 > r14 ? 1 : (r38 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r38 > r90 ? 1 : (r38 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r40 > r14 ? 1 : (r40 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r40 > r90 ? 1 : (r40 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r36 > r14 ? 1 : (r36 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r36 > r90 ? 1 : (r36 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r42 > r14 ? 1 : (r42 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r42 > r90 ? 1 : (r42 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r34 > r14 ? 1 : (r34 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r34 > r90 ? 1 : (r34 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r44 > r14 ? 1 : (r44 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r44 > r90 ? 1 : (r44 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r32 > r14 ? 1 : (r32 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r32 > r90 ? 1 : (r32 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r30 > r14 ? 1 : (r30 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r30 > r90 ? 1 : (r30 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r46 > r14 ? 1 : (r46 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r46 > r90 ? 1 : (r46 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r48 > r14 ? 1 : (r48 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r48 > r90 ? 1 : (r48 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r50 > r14 ? 1 : (r50 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r50 > r90 ? 1 : (r50 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r52 > r14 ? 1 : (r52 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r52 > r90 ? 1 : (r52 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r54 > r14 ? 1 : (r54 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r54 > r90 ? 1 : (r54 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r56 > r14 ? 1 : (r56 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r56 > r90 ? 1 : (r56 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r28 > r90 ? 1 : (r28 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r58 > r14 ? 1 : (r58 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r58 > r90 ? 1 : (r58 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r60 > r14 ? 1 : (r60 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r60 > r90 ? 1 : (r60 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r62 > r14 ? 1 : (r62 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r62 > r90 ? 1 : (r62 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r64 > r14 ? 1 : (r64 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r64 > r90 ? 1 : (r64 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r66 > r14 ? 1 : (r66 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r66 > r90 ? 1 : (r66 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r68 > r14 ? 1 : (r68 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r68 > r90 ? 1 : (r68 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r70 > r14 ? 1 : (r70 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r70 > r90 ? 1 : (r70 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r16 > r90 ? 1 : (r16 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r72 > r14 ? 1 : (r72 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r72 > r90 ? 1 : (r72 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r74 > r14 ? 1 : (r74 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r74 > r90 ? 1 : (r74 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r76 > r14 ? 1 : (r76 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r76 > r90 ? 1 : (r76 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r78 > r14 ? 1 : (r78 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r78 > r90 ? 1 : (r78 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r80 > r14 ? 1 : (r80 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r80 > r90 ? 1 : (r80 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r82 > r14 ? 1 : (r82 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r82 > r90 ? 1 : (r82 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r84 > r14 ? 1 : (r84 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r84 > r90 ? 1 : (r84 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r86 > r14 ? 1 : (r86 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r86 > r90 ? 1 : (r86 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r88 > r14 ? 1 : (r88 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r92 = (r88 > r90 ? 1 : (r88 == r90 ? 0 : -1))
            if (r92 > 0) goto L46d
            int r92 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r92 < 0) goto L46d
            int r14 = (r24 > r90 ? 1 : (r24 == r90 ? 0 : -1))
            if (r14 <= 0) goto L254
            goto L46d
        L254:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            java.lang.String r15 = java.lang.String.valueOf(r22)
            java.lang.String r0 = "idleAndFH"
            r14.put(r0, r15)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r15 = "superOnCreate"
            r14.put(r15, r0)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r15 = "initPersonStatic"
            r14.put(r15, r0)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r4 = "initAccountChange"
            r14.put(r4, r0)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r4 = "permissionUtil"
            r14.put(r4, r0)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r4 = "initDimonAdapter"
            r14.put(r4, r0)
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "cleanDirectory"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r2 = "sharePreferGet"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r2 = "cmdRouterInit"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r36)
            java.lang.String r2 = "webviewSuffix"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r26)
            java.lang.String r2 = "growthFunnel"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r2 = "initCmd"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r34)
            java.lang.String r2 = "initVersion"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r2 = "initAll"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r32)
            java.lang.String r2 = "initFace"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "initTasks"
            r14.put(r2, r0)
            c.a.s0.s.g0.b r0 = c.a.s0.s.g0.b.j()
            java.lang.String r2 = "static_opt_open"
            r3 = 0
            int r0 = r0.k(r2, r3)
            if (r0 <= 0) goto L2f9
            r0 = 1
            goto L2fa
        L2f9:
            r0 = 0
        L2fa:
            if (r0 == 0) goto L306
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "noStaticinitTasksCost"
            r14.put(r2, r0)
            goto L30f
        L306:
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "staticInitTasksCost"
            r14.put(r2, r0)
        L30f:
            java.lang.String r0 = java.lang.String.valueOf(r46)
            java.lang.String r2 = "initGoAction"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r2 = "initAccount"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r50)
            java.lang.String r2 = "initInterruptRule"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r52)
            java.lang.String r2 = "initSapi"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r54)
            java.lang.String r2 = "initPlugin"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r56)
            java.lang.String r2 = "initSwan"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r28)
            java.lang.String r2 = "initBear"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r58)
            java.lang.String r2 = "initLoki"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r60)
            java.lang.String r2 = "initCountStats"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r64)
            java.lang.String r2 = "initRuka"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r62)
            java.lang.String r2 = "initUBC"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r66)
            java.lang.String r2 = "initAxe"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r68)
            java.lang.String r2 = "initAR"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r70)
            java.lang.String r2 = "initPlayer"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r2 = "initAdRuntime"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r72)
            java.lang.String r2 = "initMsgOne"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r74)
            java.lang.String r2 = "initMsgTwo"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r76)
            java.lang.String r2 = "initMsgThree"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r78)
            java.lang.String r2 = "initMsgFour"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r80)
            java.lang.String r2 = "initMsgFive"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r82)
            java.lang.String r2 = "initMsgSix"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r84)
            java.lang.String r2 = "initMsgSeven"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r86)
            java.lang.String r2 = "initMsgEight"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r88)
            java.lang.String r2 = "initMsgNine"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r24)
            java.lang.String r2 = "onAppStart2End"
            r14.put(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r3 = "onAppEnd2ActivityStartGap"
            r14.put(r3, r0)
            java.util.Hashtable<java.lang.String, java.lang.Long> r0 = r1.mLaunchTaskDuration
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L403:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41f
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r14.put(r5, r4)
            goto L403
        L41f:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r8, r14)
            if (r0 == 0) goto L43c
            java.lang.String r4 = "appCreate"
            r5 = r94
            r5.put(r4, r0)     // Catch: org.json.JSONException -> L42d
            goto L43e
        L42d:
            r0 = move-exception
            goto L432
        L42f:
            r0 = move-exception
            r5 = r94
        L432:
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L43e
            r0.printStackTrace()
            goto L43e
        L43c:
            r5 = r94
        L43e:
            r4 = 0
            r6 = r24
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r6, r4)
            if (r0 == 0) goto L456
            r5.put(r2, r0)     // Catch: org.json.JSONException -> L44b
            goto L456
        L44b:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L456
            r2.printStackTrace()
        L456:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r10, r4)
            if (r0 == 0) goto L46b
            r5.put(r3, r0)     // Catch: org.json.JSONException -> L460
            goto L46b
        L460:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L46b
            r2.printStackTrace()
        L46b:
            r2 = 1
            return r2
        L46d:
            r0 = 0
            return r0
        L46f:
            r91 = r0
            r92 = 1048581(0x100005, float:1.469375E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r91.invokeL(r92, r93, r94)
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
            this.mIdleAndFHEndTimeStamp = -1L;
            this.mSuperEndTimeStamp = -1L;
            this.mInitPersonalizeStaticEndTimestamp = -1L;
            this.mLaunchTaskScheduleEndTimestamp = -1L;
            this.mInitModuleContextEndTimestamp = -1L;
            this.mInitAccountChangeTimestamp = -1L;
            this.mPermissionUtilEndTimestamp = -1L;
            this.mCleanDirectoryEndTimestamp = -1L;
            this.mSharePEndTimestamp = -1L;
            this.mCmdRouterInitEndTimestamp = -1L;
            this.mWebViewSufEndTimestamp = -1L;
            this.mGrowthFunnelEndTimestamp = -1L;
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
            this.mInitLokiEndTimestamp = -1L;
            this.mInitCountStatsEndTimestamp = -1L;
            this.mInitUbcEndTimestamp = -1L;
            this.mInitRukaEndTimestamp = -1L;
            this.mInitAxeEndTimestamp = -1L;
            this.mInitAREndTimestamp = -1L;
            this.mInitPlayerEndTimestamp = -1L;
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
                    this.mIdleAndFHEndTimeStamp = j2;
                    return;
                case 2002:
                    this.mSuperEndTimeStamp = j2;
                    return;
                case 2003:
                    this.mLaunchTaskScheduleEndTimestamp = j2;
                    return;
                case 2004:
                    this.mInitPersonalizeStaticEndTimestamp = j2;
                    return;
                case 2005:
                    this.mGrowthFunnelEndTimestamp = j2;
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
                case RevenueServerConst.GetHasChargeInActivityResponse /* 2026 */:
                case SpeedStatsStampTable.APP_CREATE_VIRTUAL_START_STAMP_KEY /* 2051 */:
                case 2052:
                default:
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
                case SpeedStatsStampTable.INIT_PLAYER_STAMP_KEY /* 2053 */:
                    this.mInitPlayerEndTimestamp = j2;
                    return;
            }
        }
    }
}
