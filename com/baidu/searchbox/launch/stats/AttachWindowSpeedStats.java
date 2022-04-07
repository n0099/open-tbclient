package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class AttachWindowSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONCERN_TAB_DURATION = "ConcernTabFragment";
    public static final String CUSTOM_VIEW_PAPER_INIT = "CustomViewPagerInit";
    public static final String FIRST_FRAGMENT_ATTACH_DURATION = "fFlutterFragmentAttach";
    public static final String HOME_FRAGMENT_CHECK_CONCERN_RED_TIP = "homeFragmentCheckConcernRedTip";
    public static final String HOME_FRAGMENT_FIRST_LOAD = "homeFragmentStartFirstLoad";
    public static final String HOME_FRAGMENT_INIT_MODEL = "homeFragmentInitModel";
    public static final String HOME_FRAGMENT_INIT_TABLE = "homeFragmentInitTable";
    public static final String HOME_FRAGMENT_INIT_VIEW_PAPER = "homeFragmentInitViewPaper";
    public static final String HOME_FRAGMENT_ON_ACTIVITY_CREATED = "homeFragmentOnActivityCreated";
    public static final String HOME_FRAGMENT_ON_ATTACH = "homeFragmentOnAttach";
    public static final String HOME_FRAGMENT_ON_CREATE = "homeFragmentOnCreate";
    public static final String HOME_FRAGMENT_ON_CREATE_VIEW = "homeFragmentOnCreateView";
    public static final String HOME_FRAGMENT_ON_RESUME = "homeFragmentOnResume";
    public static final String HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS = "homeFragmentShowConcernTabTips";
    public static final String HOME_FRAGMENT_TOTAL_TIME = "homeFragmentTotal";
    public static final String HOME_TAB_BAR_VIEW_INIT = "HomeTabBarViewInit";
    public static final String HOT_TOPIC_TAB_DURATION = "HotTopicTabFragment";
    public static final String NESTED_SCROLL_HEADER_INIT = "NestedScrollHeaderInit";
    public static final String PERSONALIZE_TAB_DURATION = "PersonalizeTabFragment";
    public static final String SCROLL_FRAGMENT_TAB_HOST_INIT = "homeFragmentTabHostInit";
    public static final String SECOND_FRAGMENT_ATTACH_DURATION = "sFragmentFragmentAttach";
    public transient /* synthetic */ FieldHolder $fh;
    public long mConcernTabFragmentEndTimeStamp;
    public long mConcernTabFragmentStartTimeStamp;
    public long mCustomViewPagerEndStamp;
    public long mCustomViewPagerStartStamp;
    public long mFirstFlutterFragmentAttachEndTimeStamp;
    public long mFirstFlutterFragmentAttachStartTimeStamp;
    public long mHomeFragmentCheckConcernRedTipEndStamp;
    public long mHomeFragmentCheckConcernRedTipStartStamp;
    public long mHomeFragmentInitModelEndStamp;
    public long mHomeFragmentInitModelStartStamp;
    public long mHomeFragmentInitTableEndStamp;
    public long mHomeFragmentInitTableStartStamp;
    public long mHomeFragmentInitViewPaperEndStamp;
    public long mHomeFragmentInitViewPaperStartStamp;
    public long mHomeFragmentOnActivityCreatedEndStamp;
    public long mHomeFragmentOnActivityCreatedStartStamp;
    public long mHomeFragmentOnCreateViewEndStamp;
    public long mHomeFragmentOnCreateViewStartStamp;
    public long mHomeFragmentOnResumeEndStamp;
    public long mHomeFragmentOnResumeStartStamp;
    public long mHomeFragmentShowConcernTabTipsEndStamp;
    public long mHomeFragmentShowConcernTabTipsStartStamp;
    public long mHomeFragmentStartFirstLoadPaperEndStamp;
    public long mHomeFragmentStartFirstLoadStartStamp;
    public long mHomeTabAttachWindowEndStamp;
    public long mHomeTabBarViewInitEndStamp;
    public long mHomeTabBarViewInitStartStamp;
    public long mHomeTabOnAttachEndStamp;
    public long mHomeTabOnAttachStartStamp;
    public long mHomeTabOnCreateEndStamp;
    public long mHomeTabOnCreateStartStamp;
    public long mHotTopicTabFragmentEndTimeStamp;
    public long mHotTopicTabFragmentStartTimeStamp;
    public long mNestedScrollHeaderEndStamp;
    public long mNestedScrollHeaderStartStamp;
    public long mPersonalizeTabFragmentEndTimeStamp;
    public long mPersonalizeTabFragmentStartTimeStamp;
    public long mScrollFragmentTabHostInitEndStamp;
    public long mScrollFragmentTabHostInitStartStamp;
    public long mSecondFlutterFragmentAttachEndTimeStamp;
    public long mSecondFlutterFragmentAttachStartTimeStamp;
    public int mTBFlutterAttachCount;

    public AttachWindowSpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHomeTabOnAttachStartStamp = -1L;
        this.mHomeTabOnAttachEndStamp = -1L;
        this.mHomeTabOnCreateStartStamp = -1L;
        this.mHomeTabOnCreateEndStamp = -1L;
        this.mHomeFragmentOnCreateViewStartStamp = -1L;
        this.mScrollFragmentTabHostInitStartStamp = -1L;
        this.mScrollFragmentTabHostInitEndStamp = -1L;
        this.mHomeTabBarViewInitStartStamp = -1L;
        this.mHomeTabBarViewInitEndStamp = -1L;
        this.mCustomViewPagerStartStamp = -1L;
        this.mCustomViewPagerEndStamp = -1L;
        this.mNestedScrollHeaderStartStamp = -1L;
        this.mNestedScrollHeaderEndStamp = -1L;
        this.mHomeFragmentOnCreateViewEndStamp = -1L;
        this.mHomeFragmentOnActivityCreatedStartStamp = -1L;
        this.mHomeFragmentOnActivityCreatedEndStamp = -1L;
        this.mHomeFragmentInitModelStartStamp = -1L;
        this.mHomeFragmentInitModelEndStamp = -1L;
        this.mHomeFragmentInitTableStartStamp = -1L;
        this.mHomeFragmentInitTableEndStamp = -1L;
        this.mHomeFragmentInitViewPaperStartStamp = -1L;
        this.mHomeFragmentInitViewPaperEndStamp = -1L;
        this.mHomeFragmentStartFirstLoadStartStamp = -1L;
        this.mHomeFragmentStartFirstLoadPaperEndStamp = -1L;
        this.mHomeFragmentCheckConcernRedTipStartStamp = -1L;
        this.mHomeFragmentCheckConcernRedTipEndStamp = -1L;
        this.mHomeFragmentShowConcernTabTipsStartStamp = -1L;
        this.mHomeFragmentShowConcernTabTipsEndStamp = -1L;
        this.mHomeFragmentOnResumeStartStamp = -1L;
        this.mHomeFragmentOnResumeEndStamp = -1L;
        this.mHomeTabAttachWindowEndStamp = -1L;
        this.mTBFlutterAttachCount = 0;
        this.mFirstFlutterFragmentAttachStartTimeStamp = -1L;
        this.mFirstFlutterFragmentAttachEndTimeStamp = -1L;
        this.mSecondFlutterFragmentAttachStartTimeStamp = -1L;
        this.mSecondFlutterFragmentAttachEndTimeStamp = -1L;
        this.mConcernTabFragmentStartTimeStamp = -1L;
        this.mConcernTabFragmentEndTimeStamp = -1L;
        this.mHotTopicTabFragmentStartTimeStamp = -1L;
        this.mHotTopicTabFragmentEndTimeStamp = -1L;
        this.mPersonalizeTabFragmentStartTimeStamp = -1L;
        this.mPersonalizeTabFragmentEndTimeStamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            addStatsTimeStamp(i, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Math.max(this.mHomeFragmentOnResumeEndStamp, this.mHomeFragmentOnActivityCreatedStartStamp) : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHomeTabOnAttachStartStamp : invokeV.longValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:100:0x0236
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r51) {
        /*
            r50 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.AttachWindowSpeedStats.$ic
            if (r0 != 0) goto L25f
        L4:
            r1 = r50
            r2 = r51
            super.packData(r51)
            r3 = 1
            if (r2 != 0) goto Lf
            return r3
        Lf:
            long r4 = r1.mHomeFragmentOnResumeEndStamp
            long r6 = r1.mHomeTabOnAttachStartStamp
            long r8 = r4 - r6
            long r10 = r1.mHomeTabOnAttachEndStamp
            long r10 = r10 - r6
            long r6 = r1.mHomeTabOnCreateEndStamp
            long r12 = r1.mHomeTabOnCreateStartStamp
            long r6 = r6 - r12
            long r12 = r1.mHomeFragmentOnCreateViewEndStamp
            long r14 = r1.mHomeFragmentOnCreateViewStartStamp
            long r12 = r12 - r14
            long r14 = r1.mScrollFragmentTabHostInitEndStamp
            r16 = r4
            long r3 = r1.mScrollFragmentTabHostInitStartStamp
            long r14 = r14 - r3
            long r3 = r1.mHomeTabBarViewInitEndStamp
            r18 = r14
            long r14 = r1.mHomeTabBarViewInitStartStamp
            long r3 = r3 - r14
            long r14 = r1.mCustomViewPagerEndStamp
            r20 = r3
            long r2 = r1.mCustomViewPagerStartStamp
            long r14 = r14 - r2
            long r2 = r1.mNestedScrollHeaderEndStamp
            long r4 = r1.mNestedScrollHeaderStartStamp
            long r2 = r2 - r4
            long r4 = r1.mHomeFragmentInitModelEndStamp
            r22 = r2
            long r2 = r1.mHomeFragmentInitModelStartStamp
            long r4 = r4 - r2
            long r2 = r1.mHomeFragmentInitTableEndStamp
            r24 = r4
            long r4 = r1.mHomeFragmentInitTableStartStamp
            long r2 = r2 - r4
            long r4 = r1.mHomeFragmentInitViewPaperEndStamp
            r26 = r2
            long r2 = r1.mHomeFragmentInitViewPaperStartStamp
            long r4 = r4 - r2
            long r2 = r1.mHomeFragmentStartFirstLoadPaperEndStamp
            r28 = r4
            long r4 = r1.mHomeFragmentStartFirstLoadStartStamp
            long r2 = r2 - r4
            long r4 = r1.mHomeFragmentCheckConcernRedTipEndStamp
            r30 = r2
            long r2 = r1.mHomeFragmentCheckConcernRedTipStartStamp
            long r4 = r4 - r2
            long r2 = r1.mHomeFragmentShowConcernTabTipsEndStamp
            r32 = r4
            long r4 = r1.mHomeFragmentShowConcernTabTipsStartStamp
            long r2 = r2 - r4
            long r4 = r1.mHomeFragmentOnActivityCreatedEndStamp
            r34 = r2
            long r2 = r1.mHomeFragmentOnActivityCreatedStartStamp
            long r4 = r4 - r2
            long r2 = r1.mHomeFragmentOnResumeStartStamp
            long r2 = r16 - r2
            r16 = r2
            long r2 = r1.mConcernTabFragmentEndTimeStamp
            r36 = r14
            long r14 = r1.mConcernTabFragmentStartTimeStamp
            long r2 = r2 - r14
            long r14 = r1.mHotTopicTabFragmentEndTimeStamp
            r38 = r12
            long r12 = r1.mHotTopicTabFragmentStartTimeStamp
            long r14 = r14 - r12
            long r12 = r1.mPersonalizeTabFragmentEndTimeStamp
            r40 = r2
            long r2 = r1.mPersonalizeTabFragmentStartTimeStamp
            long r12 = r12 - r2
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r2 = r1.mHomeTabOnAttachStartStamp
            r42 = r12
            long r12 = r1.mHomeFragmentOnResumeEndStamp
            long r2 = r0.getDurationWithoutAD(r2, r12)
            long r12 = r1.mHomeFragmentOnActivityCreatedStartStamp
            r44 = r14
            long r14 = r1.mHomeFragmentOnResumeEndStamp
            r46 = 0
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 <= 0) goto Lb0
            long r2 = r2 + r4
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r12 = r1.mHomeFragmentOnActivityCreatedStartStamp
            long r14 = r1.mHomeFragmentOnResumeEndStamp
            long r12 = r0.getDurationWithoutAD(r12, r14)
            goto Lb2
        Lb0:
            r12 = r46
        Lb2:
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            com.baidu.searchbox.launch.stats.SpeedStatsManager r14 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r14 = r14.getMainTabActivityEndDuration()
            r48 = r4
            long r4 = r1.mHomeTabOnAttachStartStamp
            long r4 = r0.getDurationWithoutAD(r14, r4)
            long r12 = r12 + r4
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r4 = r0.getExtraSecondCreateDuration()
            long r12 = r12 - r4
            int r0 = (r8 > r46 ? 1 : (r8 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            r4 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r2 > r46 ? 1 : (r2 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r10 > r46 ? 1 : (r10 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r6 > r46 ? 1 : (r6 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r44 > r46 ? 1 : (r44 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r44 > r4 ? 1 : (r44 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r40 > r46 ? 1 : (r40 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r42 > r46 ? 1 : (r42 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r38 > r46 ? 1 : (r38 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r18 > r46 ? 1 : (r18 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r20 > r46 ? 1 : (r20 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r36 > r46 ? 1 : (r36 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r22 > r46 ? 1 : (r22 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r24 > r46 ? 1 : (r24 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r26 > r46 ? 1 : (r26 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r28 > r46 ? 1 : (r28 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r30 > r46 ? 1 : (r30 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r32 > r46 ? 1 : (r32 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r34 > r46 ? 1 : (r34 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r48 > r46 ? 1 : (r48 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r48 > r4 ? 1 : (r48 == r4 ? 0 : -1))
            if (r0 > 0) goto L25d
            int r0 = (r16 > r46 ? 1 : (r16 == r46 ? 0 : -1))
            if (r0 < 0) goto L25d
            int r0 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r0 <= 0) goto L175
            goto L25d
        L175:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r5 = "homeFragmentTotal"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r5 = "homeFragmentOnAttach"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r5 = "homeFragmentOnCreate"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r5 = "homeFragmentOnCreateView"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r5 = "homeFragmentTabHostInit"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r5 = "HomeTabBarViewInit"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r36)
            java.lang.String r5 = "CustomViewPagerInit"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r22)
            java.lang.String r5 = "NestedScrollHeaderInit"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r24)
            java.lang.String r5 = "homeFragmentInitModel"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r26)
            java.lang.String r5 = "homeFragmentInitTable"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r28)
            java.lang.String r5 = "homeFragmentInitViewPaper"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r5 = "homeFragmentStartFirstLoad"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r32)
            java.lang.String r5 = "homeFragmentCheckConcernRedTip"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r34)
            java.lang.String r5 = "homeFragmentShowConcernTabTips"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r5 = "homeFragmentOnActivityCreated"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r5 = "homeFragmentOnResume"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r5 = "ConcernTabFragment"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r5 = "HotTopicTabFragment"
            r4.put(r5, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r5 = "PersonalizeTabFragment"
            r4.put(r5, r0)
            r0 = 0
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r12, r0)
            if (r0 == 0) goto L243
            java.lang.String r5 = "activity2attach"
            r6 = r51
            r6.put(r5, r0)     // Catch: org.json.JSONException -> L234
            goto L245
        L234:
            r0 = move-exception
            goto L239
        L236:
            r0 = move-exception
            r6 = r51
        L239:
            boolean r5 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r5 == 0) goto L245
            r0.printStackTrace()
            goto L245
        L243:
            r6 = r51
        L245:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r2, r4)
            if (r0 == 0) goto L25b
            java.lang.String r2 = "attachWindow"
            r6.put(r2, r0)     // Catch: org.json.JSONException -> L251
            goto L25b
        L251:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L25b
            r0.printStackTrace()
        L25b:
            r2 = 1
            return r2
        L25d:
            r0 = 0
            return r0
        L25f:
            r48 = r0
            r49 = 1048580(0x100004, float:1.469374E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r48.invokeL(r49, r50, r51)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.AttachWindowSpeedStats.packData(org.json.JSONObject):boolean");
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHomeTabOnAttachStartStamp = -1L;
            this.mHomeTabOnAttachEndStamp = -1L;
            this.mHomeTabOnCreateStartStamp = -1L;
            this.mHomeTabOnCreateEndStamp = -1L;
            this.mHomeFragmentOnCreateViewStartStamp = -1L;
            this.mHomeFragmentOnCreateViewEndStamp = -1L;
            this.mScrollFragmentTabHostInitStartStamp = -1L;
            this.mScrollFragmentTabHostInitEndStamp = -1L;
            this.mHomeTabBarViewInitStartStamp = -1L;
            this.mHomeTabBarViewInitEndStamp = -1L;
            this.mCustomViewPagerStartStamp = -1L;
            this.mCustomViewPagerEndStamp = -1L;
            this.mHomeFragmentOnResumeEndStamp = -1L;
            this.mNestedScrollHeaderStartStamp = -1L;
            this.mNestedScrollHeaderEndStamp = -1L;
            this.mHomeFragmentInitModelStartStamp = -1L;
            this.mHomeFragmentInitModelEndStamp = -1L;
            this.mHomeFragmentInitTableStartStamp = -1L;
            this.mHomeFragmentInitTableEndStamp = -1L;
            this.mHomeFragmentInitViewPaperStartStamp = -1L;
            this.mHomeFragmentInitViewPaperEndStamp = -1L;
            this.mHomeFragmentStartFirstLoadStartStamp = -1L;
            this.mHomeFragmentStartFirstLoadPaperEndStamp = -1L;
            this.mHomeFragmentCheckConcernRedTipStartStamp = -1L;
            this.mHomeFragmentCheckConcernRedTipEndStamp = -1L;
            this.mHomeFragmentShowConcernTabTipsStartStamp = -1L;
            this.mHomeFragmentShowConcernTabTipsEndStamp = -1L;
            this.mHomeFragmentOnActivityCreatedStartStamp = -1L;
            this.mHomeFragmentOnActivityCreatedEndStamp = -1L;
            this.mHomeFragmentOnResumeStartStamp = -1L;
            this.mHomeFragmentOnResumeEndStamp = -1L;
            this.mConcernTabFragmentStartTimeStamp = -1L;
            this.mConcernTabFragmentEndTimeStamp = -1L;
            this.mHotTopicTabFragmentStartTimeStamp = -1L;
            this.mHotTopicTabFragmentEndTimeStamp = -1L;
            this.mPersonalizeTabFragmentStartTimeStamp = -1L;
            this.mPersonalizeTabFragmentEndTimeStamp = -1L;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            if (i == 5020) {
                this.mConcernTabFragmentStartTimeStamp = j;
            } else if (i == 5021) {
                this.mConcernTabFragmentEndTimeStamp = j;
            } else if (i == 5026) {
                this.mHotTopicTabFragmentStartTimeStamp = j;
            } else if (i == 5027) {
                this.mHotTopicTabFragmentEndTimeStamp = j;
            } else if (i == 5046) {
                this.mPersonalizeTabFragmentStartTimeStamp = j;
            } else if (i != 5047) {
                switch (i) {
                    case 4000:
                        this.mHomeTabOnAttachStartStamp = j;
                        return;
                    case 4001:
                        this.mHomeTabOnAttachEndStamp = j;
                        return;
                    case 4002:
                        this.mHomeTabOnCreateStartStamp = j;
                        return;
                    case 4003:
                        this.mHomeTabOnCreateEndStamp = j;
                        return;
                    case 4004:
                        this.mHomeFragmentOnCreateViewStartStamp = j;
                        return;
                    case 4005:
                        this.mHomeFragmentOnCreateViewEndStamp = j;
                        return;
                    case 4006:
                        this.mScrollFragmentTabHostInitStartStamp = j;
                        return;
                    case 4007:
                        this.mScrollFragmentTabHostInitEndStamp = j;
                        return;
                    case 4008:
                        this.mHomeTabBarViewInitStartStamp = j;
                        return;
                    case 4009:
                        this.mHomeTabBarViewInitEndStamp = j;
                        return;
                    case 4010:
                        this.mCustomViewPagerStartStamp = j;
                        return;
                    case 4011:
                        this.mCustomViewPagerEndStamp = j;
                        return;
                    case 4012:
                        this.mNestedScrollHeaderStartStamp = j;
                        return;
                    case 4013:
                        this.mNestedScrollHeaderEndStamp = j;
                        return;
                    case 4014:
                        this.mHomeFragmentOnActivityCreatedStartStamp = j;
                        return;
                    case 4015:
                        this.mHomeFragmentInitModelStartStamp = j;
                        return;
                    case 4016:
                        this.mHomeFragmentInitModelEndStamp = j;
                        return;
                    case 4017:
                        this.mHomeFragmentInitTableStartStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY /* 4018 */:
                        this.mHomeFragmentInitTableEndStamp = j;
                        return;
                    case 4019:
                        this.mHomeFragmentInitViewPaperStartStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY /* 4020 */:
                        this.mHomeFragmentInitViewPaperEndStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY /* 4021 */:
                        this.mHomeFragmentStartFirstLoadStartStamp = j;
                        return;
                    case 4022:
                        this.mHomeFragmentStartFirstLoadPaperEndStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_START_STAMP_KEY /* 4023 */:
                        this.mHomeFragmentCheckConcernRedTipStartStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_END_STAMP_KEY /* 4024 */:
                        this.mHomeFragmentCheckConcernRedTipEndStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY /* 4025 */:
                        this.mHomeFragmentShowConcernTabTipsStartStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY /* 4026 */:
                        this.mHomeFragmentShowConcernTabTipsEndStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY /* 4027 */:
                        this.mHomeFragmentOnActivityCreatedEndStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY /* 4028 */:
                        this.mHomeFragmentOnResumeStartStamp = j;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY /* 4029 */:
                        this.mHomeFragmentOnResumeEndStamp = j;
                        return;
                    default:
                        return;
                }
            } else {
                this.mPersonalizeTabFragmentEndTimeStamp = j;
            }
        }
    }
}
