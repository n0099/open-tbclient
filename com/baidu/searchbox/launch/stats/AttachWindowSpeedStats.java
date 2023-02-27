package com.baidu.searchbox.launch.stats;
/* loaded from: classes2.dex */
public final class AttachWindowSpeedStats extends AbstractSpeedStats {
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
    public static final String HOME_FRAGMENT_ON_RESUME_2_ON_ACTIVITY_CREATED = "homeFragmentOnR2AC";
    public static final String HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS = "homeFragmentShowConcernTabTips";
    public static final String HOME_FRAGMENT_TOTAL_TIME = "homeFragmentTotal";
    public static final String HOME_TAB_BAR_VIEW_INIT = "HomeTabBarViewInit";
    public static final String HOT_TOPIC_TAB_DURATION = "HotTopicTabFragment";
    public static final String NESTED_SCROLL_HEADER_INIT = "NestedScrollHeaderInit";
    public static final String PERSONALIZE_TAB_DURATION = "PersonalizeTabFragment";
    public static final String SCROLL_FRAGMENT_TAB_HOST_INIT = "homeFragmentTabHostInit";
    public static final String SECOND_FRAGMENT_ATTACH_DURATION = "sFragmentFragmentAttach";
    public long mHomeTabOnAttachStartStamp = -1;
    public long mHomeTabOnAttachEndStamp = -1;
    public long mHomeTabOnCreateStartStamp = -1;
    public long mHomeTabOnCreateEndStamp = -1;
    public long mHomeFragmentOnCreateViewStartStamp = -1;
    public long mScrollFragmentTabHostInitStartStamp = -1;
    public long mScrollFragmentTabHostInitEndStamp = -1;
    public long mHomeTabBarViewInitStartStamp = -1;
    public long mHomeTabBarViewInitEndStamp = -1;
    public long mCustomViewPagerStartStamp = -1;
    public long mCustomViewPagerEndStamp = -1;
    public long mNestedScrollHeaderStartStamp = -1;
    public long mNestedScrollHeaderEndStamp = -1;
    public long mHomeFragmentOnCreateViewEndStamp = -1;
    public long mHomeFragmentOnActivityCreatedStartStamp = -1;
    public long mHomeFragmentOnActivityCreatedEndStamp = -1;
    public long mHomeFragmentInitModelStartStamp = -1;
    public long mHomeFragmentInitModelEndStamp = -1;
    public long mHomeFragmentInitTableStartStamp = -1;
    public long mHomeFragmentInitTableEndStamp = -1;
    public long mHomeFragmentInitViewPaperStartStamp = -1;
    public long mHomeFragmentInitViewPaperEndStamp = -1;
    public long mHomeFragmentStartFirstLoadStartStamp = -1;
    public long mHomeFragmentStartFirstLoadPaperEndStamp = -1;
    public long mHomeFragmentCheckConcernRedTipStartStamp = -1;
    public long mHomeFragmentCheckConcernRedTipEndStamp = -1;
    public long mHomeFragmentShowConcernTabTipsStartStamp = -1;
    public long mHomeFragmentShowConcernTabTipsEndStamp = -1;
    public long mHomeFragmentOnResumeStartStamp = -1;
    public long mHomeFragmentOnResumeEndStamp = -1;
    public long mHomeTabAttachWindowEndStamp = -1;
    public int mTBFlutterAttachCount = 0;
    public long mFirstFlutterFragmentAttachStartTimeStamp = -1;
    public long mFirstFlutterFragmentAttachEndTimeStamp = -1;
    public long mSecondFlutterFragmentAttachStartTimeStamp = -1;
    public long mSecondFlutterFragmentAttachEndTimeStamp = -1;
    public long mConcernTabFragmentStartTimeStamp = -1;
    public long mConcernTabFragmentEndTimeStamp = -1;
    public long mHotTopicTabFragmentStartTimeStamp = -1;
    public long mHotTopicTabFragmentEndTimeStamp = -1;
    public long mPersonalizeTabFragmentStartTimeStamp = -1;
    public long mPersonalizeTabFragmentEndTimeStamp = -1;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        addStatsTimeStamp(i, System.currentTimeMillis());
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        super.addStatsTimeStamp(i, j);
        if (i != 5020) {
            if (i != 5021) {
                if (i != 5026) {
                    if (i != 5027) {
                        if (i != 5046) {
                            if (i != 5047) {
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
                                    case SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY /* 4022 */:
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
                            }
                            this.mPersonalizeTabFragmentEndTimeStamp = j;
                            return;
                        }
                        this.mPersonalizeTabFragmentStartTimeStamp = j;
                        return;
                    }
                    this.mHotTopicTabFragmentEndTimeStamp = j;
                    return;
                }
                this.mHotTopicTabFragmentStartTimeStamp = j;
                return;
            }
            this.mConcernTabFragmentEndTimeStamp = j;
            return;
        }
        this.mConcernTabFragmentStartTimeStamp = j;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        return Math.max(this.mHomeFragmentOnResumeEndStamp, this.mHomeFragmentOnActivityCreatedStartStamp);
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        return this.mHomeTabOnAttachStartStamp;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:98:0x023b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r51) {
        /*
            r50 = this;
            r1 = r50
            r2 = r51
            super.packData(r51)
            r3 = 1
            if (r2 != 0) goto Lb
            return r3
        Lb:
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
            if (r0 <= 0) goto Lac
            long r2 = r2 + r4
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r12 = r1.mHomeFragmentOnResumeEndStamp
            long r14 = r1.mHomeFragmentOnActivityCreatedStartStamp
            long r12 = r0.getDurationWithoutAD(r12, r14)
            goto Lae
        Lac:
            r12 = r46
        Lae:
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            com.baidu.searchbox.launch.stats.SpeedStatsManager r14 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r14 = r14.getMainTabActivityEndDuration()
            r48 = r4
            long r4 = r1.mHomeTabOnAttachStartStamp
            long r4 = r0.getDurationWithoutAD(r14, r4)
            long r4 = r4 + r12
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r14 = r0.getExtraSecondCreateDuration()
            long r4 = r4 - r14
            int r0 = (r8 > r46 ? 1 : (r8 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            r14 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r2 > r46 ? 1 : (r2 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r10 > r46 ? 1 : (r10 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r6 > r46 ? 1 : (r6 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r44 > r46 ? 1 : (r44 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r44 > r14 ? 1 : (r44 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r40 > r46 ? 1 : (r40 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r40 > r14 ? 1 : (r40 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r42 > r46 ? 1 : (r42 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r42 > r14 ? 1 : (r42 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r38 > r46 ? 1 : (r38 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r38 > r14 ? 1 : (r38 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r18 > r46 ? 1 : (r18 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r20 > r46 ? 1 : (r20 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r36 > r46 ? 1 : (r36 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r36 > r14 ? 1 : (r36 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r22 > r46 ? 1 : (r22 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r24 > r46 ? 1 : (r24 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r26 > r46 ? 1 : (r26 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r28 > r46 ? 1 : (r28 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r30 > r46 ? 1 : (r30 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r30 > r14 ? 1 : (r30 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r32 > r46 ? 1 : (r32 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r32 > r14 ? 1 : (r32 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r34 > r46 ? 1 : (r34 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r34 > r14 ? 1 : (r34 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r48 > r46 ? 1 : (r48 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r48 > r14 ? 1 : (r48 == r14 ? 0 : -1))
            if (r0 > 0) goto L262
            int r0 = (r16 > r46 ? 1 : (r16 == r46 ? 0 : -1))
            if (r0 < 0) goto L262
            int r0 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r0 <= 0) goto L171
            goto L262
        L171:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r8 = "homeFragmentTotal"
            r14.put(r8, r0)
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r8 = "homeFragmentOnAttach"
            r14.put(r8, r0)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "homeFragmentOnCreate"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r6 = "homeFragmentOnCreateView"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r6 = "homeFragmentTabHostInit"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r6 = "HomeTabBarViewInit"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r36)
            java.lang.String r6 = "CustomViewPagerInit"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r22)
            java.lang.String r6 = "NestedScrollHeaderInit"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r24)
            java.lang.String r6 = "homeFragmentInitModel"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r26)
            java.lang.String r6 = "homeFragmentInitTable"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r28)
            java.lang.String r6 = "homeFragmentInitViewPaper"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r6 = "homeFragmentStartFirstLoad"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r32)
            java.lang.String r6 = "homeFragmentCheckConcernRedTip"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r34)
            java.lang.String r6 = "homeFragmentShowConcernTabTips"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r6 = "homeFragmentOnActivityCreated"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r6 = "homeFragmentOnResume"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r6 = "ConcernTabFragment"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r6 = "HotTopicTabFragment"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r6 = "PersonalizeTabFragment"
            r14.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r6 = "homeFragmentOnR2AC"
            r14.put(r6, r0)
            r0 = 0
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r4, r0)
            if (r0 == 0) goto L248
            java.lang.String r4 = "activity2attach"
            r5 = r51
            r5.put(r4, r0)     // Catch: org.json.JSONException -> L239
            goto L24a
        L239:
            r0 = move-exception
            goto L23e
        L23b:
            r0 = move-exception
            r5 = r51
        L23e:
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L24a
            r0.printStackTrace()
            goto L24a
        L248:
            r5 = r51
        L24a:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r2, r14)
            if (r0 == 0) goto L260
            java.lang.String r2 = "attachWindow"
            r5.put(r2, r0)     // Catch: org.json.JSONException -> L256
            goto L260
        L256:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L260
            r0.printStackTrace()
        L260:
            r2 = 1
            return r2
        L262:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.AttachWindowSpeedStats.packData(org.json.JSONObject):boolean");
    }
}
