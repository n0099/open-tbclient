package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class FirstFrameSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_LIVE_TAB_ON_CREATE_DURATION = "AlaLiveTabFragmentOnCreate";
    public static final String ALA_LIVE_TAB_ON_CREATE_VIEW_DURATION = "AlaLiveTabFragmentOnCreateView";
    public static final String ALA_LIVE_TAB_ON_RESUME_DURATION = "AlaLiveTabFragmentOnResume";
    public static final String CONCERN_TAB_ON_CREATE_VIEW_DURATION = "ConcernTabFragmentOnCreateView";
    public static final String CONCERN_TAB_ON_RESUME_DURATION = "ConcernTabFragmentOnResume";
    public static final String FIRST_DISPATCH_DRAW = "firstDispatchDraw";
    public static final String FIRST_LAYOUT = "firstLayout";
    public static final String FIRST_MEASURE = "firstMeasure";
    public static final String GAME_VIDEO_TAB_ON_CREATE_DURATION = "GameVideoTabFragmentOnCreate";
    public static final String GAME_VIDEO_TAB_ON_CREATE_VIEW_DURATION = "GameVideoTabFragmentOnCreateView";
    public static final String HOME_TAB_BAR_VIEW_ON_LAYOUT = "feedTabLayoutOnLayout";
    public static final String HOME_TAB_BAR_VIEW_ON_LAYOUT_COUNT = "feedTabLayoutOnLayoutCount";
    public static final String HOME_TAB_BAR_VIEW_ON_MEASURE = "feedTabLayoutOnMeasure";
    public static final String HOME_TAB_BAR_VIEW_ON_MEASURE_COUNT = "feedTabLayoutMeasureCount";
    public static final String HOT_TOPIC_TAB_ON_CREATE_DURATION = "HotTopicTabFragmentOnCreate";
    public static final String HOT_TOPIC_TAB_ON_CREATE_VIEW_DURATION = "HotTopicTabFragmentOnCreateView";
    public static final String INIT = "init";
    public static final String PERSONALIZE_TAB_ON_CREATE_DURATION = "PersonalizedTabFragmentOnCreate";
    public static final String PERSONALIZE_TAB_ON_CREATE_VIEW_DURATION = "PersonalizedTabFragmentOnCreateView";
    public static final String PERSONALIZE_TAB_ON_RESUME_DURATION = "PersonalizedTabFragmentOnResume";
    public static final String SCROLL_FRAGMENT_TAB_HOST_LAYOUT_COUNT = "scrollLayoutCount";
    public static final String SCROLL_FRAGMENT_TAB_HOST_MEASURE_COUNT = "scrollMeasureCount";
    public static final String SEARCHBOX_VIEW_ON_LAYOUT = "searchboxViewOnLayout";
    public static final String SEARCHBOX_VIEW_ON_LAYOUT_COUNT = "searchboxViewOnLayoutCount";
    public static final String SEARCHBOX_VIEW_ON_MEASURE = "searchboxViewOnMeasure";
    public static final String SEARCHBOX_VIEW_ON_MEASURE_COUNT = "searchboxViewMeasureCount";
    public static final String SECOND_LAYOUT = "secondLayout";
    public static final String SECOND_MEASURE = "secondMeasure";
    public static final String TAB_VIEW_PAGER_ON_LAYOUT = "tabViewPagerOnLayout";
    public static final String TAB_VIEW_PAGER_ON_LAYOUT_COUNT = "tabViewPagerOnLayoutCount";
    public static final String TAB_VIEW_PAGER_ON_MEASURE = "tabViewPagerOnMeasure";
    public static final String TAB_VIEW_PAGER_ON_MEASURE_COUNT = "tabViewPagerMeasureCount";
    public static final String THIRD_MEASURE = "thirdMeasure";
    public static final String VIDEO_TAB_ON_CREATE_DURATION = "VideoTabFragmentOnCreate";
    public static final String VIDEO_TAB_ON_CREATE_VIEW_DURATION = "VideoTabFragmentOnCreateView";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp;
    public long mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp;
    public long mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp;
    public long mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp;
    public long mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp;
    public long mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp;
    public long mConcernTabFragmentOnCreateViewEndTimeStamp;
    public long mConcernTabFragmentOnCreateViewStartTimeStamp;
    public long mConcernTabFragmentOnResumeEndTimeStamp;
    public long mConcernTabFragmentOnResumeStartTimeStamp;
    public int mDispatchDrawCount;
    public int mFeedTabLayoutOnLayoutCount;
    public long mFeedTabLayoutOnLayoutEndStamp;
    public long mFeedTabLayoutOnLayoutStartStamp;
    public long mFeedTabLayoutOnLayoutTotal;
    public int mFeedTabLayoutOnMeasureCount;
    public long mFeedTabLayoutOnMeasureEndStamp;
    public long mFeedTabLayoutOnMeasureStartStamp;
    public long mFeedTabLayoutOnMeasureTotal;
    public long mFirstDispatchDrawEndStamp;
    public long mFirstDispatchDrawStartStamp;
    public long mFirstLayoutEndStamp;
    public long mFirstLayoutStartStamp;
    public long mFirstMeasureEndStamp;
    public long mFirstMeasureStartStamp;
    public long mGameVideoFragmentOnCreateEndTimeStamp;
    public long mGameVideoFragmentOnCreateStartTimeStamp;
    public long mGameVideoFragmentOnCreateViewEndTimeStamp;
    public long mGameVideoFragmentOnCreateViewStartTimeStamp;
    public long mHotTopicTabFragmentOnCreateEndTimeStamp;
    public long mHotTopicTabFragmentOnCreateStartTimeStamp;
    public long mHotTopicTabFragmentOnCreateViewEndTimeStamp;
    public long mHotTopicTabFragmentOnCreateViewStartTimeStamp;
    public int mLayoutCount;
    public int mMeasureCount;
    public long mPersonalizeFragmentOnCreateEndTimeStamp;
    public long mPersonalizeFragmentOnCreateStartTimeStamp;
    public long mPersonalizeFragmentOnCreateViewEndTimeStamp;
    public long mPersonalizeFragmentOnCreateViewStartTimeStamp;
    public long mPersonalizeFragmentOnResumeEndTimeStamp;
    public long mPersonalizeFragmentOnResumeStartTimeStamp;
    public long mSearchBoxViewOnLayoutEndStamp;
    public long mSearchBoxViewOnLayoutStartStamp;
    public long mSearchBoxViewOnMeasureEndStamp;
    public long mSearchBoxViewOnMeasureStartStamp;
    public int mSearchboxViewOnLayoutCount;
    public long mSearchboxViewOnLayoutTotal;
    public int mSearchboxViewOnMeasureCount;
    public long mSearchboxViewOnMeasureTotal;
    public long mSecondDispatchDrawEndStamp;
    public long mSecondDispatchDrawStartStamp;
    public long mSecondLayoutEndStamp;
    public long mSecondLayoutStartStamp;
    public long mSecondMeasureEndStamp;
    public long mSecondMeasureStartStamp;
    public long mTabOnLayoutCoreDuration;
    public long mTabOnLayoutCoreEndStamp;
    public long mTabOnLayoutCoreStartStamp;
    public int mTabViewPagerOnLayoutCount;
    public long mTabViewPagerOnLayoutEndStamp;
    public long mTabViewPagerOnLayoutStartStamp;
    public long mTabViewPagerOnLayoutTotal;
    public int mTabViewPagerOnMeasureCount;
    public long mTabViewPagerOnMeasureEndStamp;
    public long mTabViewPagerOnMeasureStartStamp;
    public long mTabViewPagerOnMeasureTotal;
    public long mThirdMeasureEndStamp;
    public long mThirdMeasureStartStamp;
    public long mVideoTabFragmentOnCreateEndTimeStamp;
    public long mVideoTabFragmentOnCreateStartTimeStamp;
    public long mVideoTabFragmentOnCreateViewEndTimeStamp;
    public long mVideoTabFragmentOnCreateViewStartTimeStamp;

    public FirstFrameSpeedStats() {
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
        this.mMeasureCount = 0;
        this.mLayoutCount = 0;
        this.mDispatchDrawCount = 0;
        this.mFirstMeasureStartStamp = -1L;
        this.mFirstMeasureEndStamp = -1L;
        this.mSecondMeasureStartStamp = -1L;
        this.mSecondMeasureEndStamp = -1L;
        this.mThirdMeasureStartStamp = -1L;
        this.mThirdMeasureEndStamp = -1L;
        this.mFirstLayoutStartStamp = -1L;
        this.mFirstLayoutEndStamp = -1L;
        this.mSecondLayoutStartStamp = -1L;
        this.mSecondLayoutEndStamp = -1L;
        this.mFirstDispatchDrawStartStamp = -1L;
        this.mFirstDispatchDrawEndStamp = -1L;
        this.mSecondDispatchDrawStartStamp = -1L;
        this.mSecondDispatchDrawEndStamp = -1L;
        this.mSearchBoxViewOnMeasureStartStamp = -1L;
        this.mSearchBoxViewOnMeasureEndStamp = -1L;
        this.mSearchBoxViewOnLayoutStartStamp = -1L;
        this.mSearchBoxViewOnLayoutEndStamp = -1L;
        this.mFeedTabLayoutOnMeasureStartStamp = -1L;
        this.mFeedTabLayoutOnMeasureEndStamp = -1L;
        this.mFeedTabLayoutOnLayoutStartStamp = -1L;
        this.mFeedTabLayoutOnLayoutEndStamp = -1L;
        this.mTabViewPagerOnMeasureStartStamp = -1L;
        this.mTabViewPagerOnMeasureEndStamp = -1L;
        this.mTabViewPagerOnLayoutStartStamp = -1L;
        this.mTabOnLayoutCoreStartStamp = -1L;
        this.mTabOnLayoutCoreEndStamp = -1L;
        this.mTabViewPagerOnLayoutEndStamp = -1L;
        this.mSearchboxViewOnMeasureTotal = 0L;
        this.mSearchboxViewOnMeasureCount = 0;
        this.mSearchboxViewOnLayoutTotal = 0L;
        this.mSearchboxViewOnLayoutCount = 0;
        this.mFeedTabLayoutOnMeasureTotal = 0L;
        this.mFeedTabLayoutOnMeasureCount = 0;
        this.mFeedTabLayoutOnLayoutTotal = 0L;
        this.mFeedTabLayoutOnLayoutCount = 0;
        this.mTabViewPagerOnMeasureTotal = 0L;
        this.mTabViewPagerOnMeasureCount = 0;
        this.mTabViewPagerOnLayoutTotal = 0L;
        this.mTabViewPagerOnLayoutCount = 0;
        this.mVideoTabFragmentOnCreateStartTimeStamp = -1L;
        this.mVideoTabFragmentOnCreateEndTimeStamp = -1L;
        this.mVideoTabFragmentOnCreateViewStartTimeStamp = -1L;
        this.mVideoTabFragmentOnCreateViewEndTimeStamp = -1L;
        this.mConcernTabFragmentOnCreateViewStartTimeStamp = -1L;
        this.mConcernTabFragmentOnCreateViewEndTimeStamp = -1L;
        this.mConcernTabFragmentOnResumeStartTimeStamp = -1L;
        this.mConcernTabFragmentOnResumeEndTimeStamp = -1L;
        this.mHotTopicTabFragmentOnCreateViewStartTimeStamp = -1L;
        this.mHotTopicTabFragmentOnCreateViewEndTimeStamp = -1L;
        this.mHotTopicTabFragmentOnCreateStartTimeStamp = -1L;
        this.mHotTopicTabFragmentOnCreateEndTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp = -1L;
        this.mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp = -1L;
        this.mGameVideoFragmentOnCreateStartTimeStamp = -1L;
        this.mGameVideoFragmentOnCreateEndTimeStamp = -1L;
        this.mGameVideoFragmentOnCreateViewStartTimeStamp = -1L;
        this.mGameVideoFragmentOnCreateViewEndTimeStamp = -1L;
        this.mPersonalizeFragmentOnCreateStartTimeStamp = -1L;
        this.mPersonalizeFragmentOnCreateEndTimeStamp = -1L;
        this.mPersonalizeFragmentOnCreateViewStartTimeStamp = -1L;
        this.mPersonalizeFragmentOnCreateViewEndTimeStamp = -1L;
        this.mPersonalizeFragmentOnResumeStartTimeStamp = -1L;
        this.mPersonalizeFragmentOnResumeEndTimeStamp = -1L;
        this.mTabOnLayoutCoreDuration = 0L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            switch (i) {
                case 5000:
                    int i2 = this.mMeasureCount;
                    if (i2 == 0) {
                        this.mFirstMeasureStartStamp = j;
                        return;
                    } else if (i2 == 1) {
                        this.mSecondMeasureStartStamp = j;
                        return;
                    } else if (i2 == 2) {
                        this.mThirdMeasureStartStamp = j;
                        return;
                    } else {
                        return;
                    }
                case 5001:
                    this.mSearchBoxViewOnMeasureStartStamp = j;
                    return;
                case 5002:
                    this.mSearchBoxViewOnMeasureEndStamp = j;
                    this.mSearchboxViewOnMeasureTotal = (this.mSearchboxViewOnMeasureTotal + j) - this.mSearchBoxViewOnMeasureStartStamp;
                    this.mSearchboxViewOnMeasureCount++;
                    return;
                case 5003:
                    this.mFeedTabLayoutOnMeasureStartStamp = j;
                    return;
                case 5004:
                    this.mFeedTabLayoutOnMeasureEndStamp = j;
                    this.mFeedTabLayoutOnMeasureTotal = (this.mFeedTabLayoutOnMeasureTotal + j) - this.mFeedTabLayoutOnMeasureStartStamp;
                    this.mFeedTabLayoutOnMeasureCount++;
                    return;
                case 5005:
                    this.mTabViewPagerOnMeasureStartStamp = j;
                    return;
                case 5006:
                    this.mTabViewPagerOnMeasureEndStamp = j;
                    this.mTabViewPagerOnMeasureTotal = (this.mTabViewPagerOnMeasureTotal + j) - this.mTabViewPagerOnMeasureStartStamp;
                    this.mTabViewPagerOnMeasureCount++;
                    return;
                case 5007:
                    int i3 = this.mMeasureCount;
                    if (i3 == 0) {
                        this.mFirstMeasureEndStamp = j;
                    } else if (i3 == 1) {
                        this.mSecondMeasureEndStamp = j;
                    } else if (i3 == 2) {
                        this.mThirdMeasureEndStamp = j;
                    }
                    this.mMeasureCount++;
                    return;
                case 5008:
                    int i4 = this.mLayoutCount;
                    if (i4 == 0) {
                        this.mFirstLayoutStartStamp = j;
                        return;
                    } else if (i4 == 1) {
                        this.mSecondLayoutStartStamp = j;
                        return;
                    } else {
                        return;
                    }
                case 5009:
                    this.mSearchBoxViewOnLayoutStartStamp = j;
                    return;
                case 5010:
                    this.mSearchBoxViewOnLayoutEndStamp = j;
                    this.mSearchboxViewOnLayoutTotal = (this.mSearchboxViewOnLayoutTotal + j) - this.mSearchBoxViewOnLayoutStartStamp;
                    this.mSearchboxViewOnLayoutCount++;
                    return;
                case 5011:
                    this.mFeedTabLayoutOnLayoutStartStamp = j;
                    return;
                case 5012:
                    this.mFeedTabLayoutOnLayoutEndStamp = j;
                    this.mFeedTabLayoutOnLayoutTotal = (this.mFeedTabLayoutOnLayoutTotal + j) - this.mFeedTabLayoutOnLayoutStartStamp;
                    this.mFeedTabLayoutOnLayoutCount++;
                    return;
                case 5013:
                    this.mTabViewPagerOnLayoutStartStamp = j;
                    return;
                case 5014:
                    this.mTabViewPagerOnLayoutEndStamp = j;
                    long j2 = this.mTabViewPagerOnLayoutStartStamp;
                    if (j - j2 > this.mTabOnLayoutCoreDuration) {
                        this.mTabOnLayoutCoreDuration = j - j2;
                        this.mTabOnLayoutCoreStartStamp = j2;
                        this.mTabOnLayoutCoreEndStamp = j;
                    }
                    this.mTabViewPagerOnLayoutTotal = (this.mTabViewPagerOnLayoutTotal + this.mTabViewPagerOnLayoutEndStamp) - this.mTabViewPagerOnLayoutStartStamp;
                    this.mTabViewPagerOnLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                    int i5 = this.mLayoutCount;
                    if (i5 == 0) {
                        this.mFirstLayoutEndStamp = j;
                    } else if (i5 == 1) {
                        this.mSecondLayoutEndStamp = j;
                    }
                    this.mLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY /* 5016 */:
                    int i6 = this.mDispatchDrawCount;
                    if (i6 == 0) {
                        this.mFirstDispatchDrawStartStamp = j;
                        return;
                    } else if (i6 == 1) {
                        this.mSecondDispatchDrawStartStamp = j;
                        return;
                    } else {
                        return;
                    }
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                    int i7 = this.mDispatchDrawCount;
                    if (i7 == 0) {
                        this.mFirstDispatchDrawEndStamp = j;
                    } else if (i7 == 1) {
                        this.mSecondDispatchDrawEndStamp = j;
                    }
                    this.mDispatchDrawCount++;
                    return;
                case 5018:
                case 5019:
                case 5020:
                case 5021:
                case SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY /* 5026 */:
                case 5027:
                case SpeedStatsStampTable.PERSONALIZE_TAB_START_STAMP_KEY /* 5046 */:
                case 5047:
                default:
                    return;
                case 5022:
                    this.mConcernTabFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.CONCERN_TAB_ON_CREATE_VIEW_END_STAMP_KEY /* 5023 */:
                    this.mConcernTabFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case 5024:
                    this.mConcernTabFragmentOnResumeStartTimeStamp = j;
                    return;
                case 5025:
                    this.mConcernTabFragmentOnResumeEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_START_STAMP_KEY /* 5028 */:
                    this.mHotTopicTabFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY /* 5029 */:
                    this.mHotTopicTabFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY /* 5030 */:
                    this.mHotTopicTabFragmentOnCreateStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_END_STAMP_KEY /* 5031 */:
                    this.mHotTopicTabFragmentOnCreateEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_START_STAMP_KEY /* 5032 */:
                    this.mVideoTabFragmentOnCreateStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_END_STAMP_KEY /* 5033 */:
                    this.mVideoTabFragmentOnCreateEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_VIEW_START_STAMP_KEY /* 5034 */:
                    this.mVideoTabFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.VIDEO_TAB_ON_CREATE_VIEW_END_STAMP_KEY /* 5035 */:
                    this.mVideoTabFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_START_STAMP_KEY /* 5036 */:
                    this.mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_END_STAMP_KEY /* 5037 */:
                    this.mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp = j;
                    return;
                case 5038:
                    this.mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case 5039:
                    this.mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case 5040:
                    this.mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp = j;
                    return;
                case 5041:
                    this.mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp = j;
                    return;
                case 5042:
                    this.mGameVideoFragmentOnCreateStartTimeStamp = j;
                    return;
                case 5043:
                    this.mGameVideoFragmentOnCreateEndTimeStamp = j;
                    return;
                case 5044:
                    this.mGameVideoFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case 5045:
                    this.mGameVideoFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_START_STAMP_KEY /* 5048 */:
                    this.mPersonalizeFragmentOnCreateStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_END_STAMP_KEY /* 5049 */:
                    this.mPersonalizeFragmentOnCreateEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_VIEW_START_STAMP_KEY /* 5050 */:
                    this.mPersonalizeFragmentOnCreateViewStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_CREATE_VIEW_END_STAMP_KEY /* 5051 */:
                    this.mPersonalizeFragmentOnCreateViewEndTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_RESUME_START_STAMP_KEY /* 5052 */:
                    this.mPersonalizeFragmentOnResumeStartTimeStamp = j;
                    return;
                case SpeedStatsStampTable.PERSONALIZE_TAB_ON_RESUME_END_STAMP_KEY /* 5053 */:
                    this.mPersonalizeFragmentOnResumeEndTimeStamp = j;
                    return;
            }
        }
    }

    public int getDrawCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDispatchDrawCount : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFirstDispatchDrawEndStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFirstMeasureStartStamp : invokeV.longValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:128:0x02f4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r58) {
        /*
            r57 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.FirstFrameSpeedStats.$ic
            if (r0 != 0) goto L362
        L4:
            r1 = r57
            r2 = r58
            super.packData(r58)
            r3 = 1
            if (r2 != 0) goto Lf
            return r3
        Lf:
            long r4 = r1.mFirstDispatchDrawEndStamp
            long r6 = r1.mFirstMeasureStartStamp
            long r8 = r4 - r6
            long r10 = r1.mFirstMeasureEndStamp
            long r10 = r10 - r6
            long r6 = r1.mSecondMeasureEndStamp
            long r12 = r1.mSecondMeasureStartStamp
            long r6 = r6 - r12
            long r12 = r1.mFirstLayoutEndStamp
            long r14 = r1.mFirstLayoutStartStamp
            long r12 = r12 - r14
            long r14 = r1.mThirdMeasureEndStamp
            r16 = r4
            long r3 = r1.mThirdMeasureStartStamp
            long r14 = r14 - r3
            long r3 = r1.mFirstDispatchDrawStartStamp
            long r4 = r16 - r3
            long r2 = r1.mSecondLayoutEndStamp
            r16 = r4
            long r4 = r1.mSecondLayoutStartStamp
            long r2 = r2 - r4
            long r4 = r1.mVideoTabFragmentOnCreateEndTimeStamp
            r18 = r2
            long r2 = r1.mVideoTabFragmentOnCreateStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mVideoTabFragmentOnCreateViewEndTimeStamp
            r20 = r4
            long r4 = r1.mVideoTabFragmentOnCreateViewStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp
            r22 = r2
            long r2 = r1.mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp
            r24 = r4
            long r4 = r1.mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp
            r26 = r2
            long r2 = r1.mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mGameVideoFragmentOnCreateEndTimeStamp
            r28 = r4
            long r4 = r1.mGameVideoFragmentOnCreateStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mGameVideoFragmentOnCreateViewEndTimeStamp
            r30 = r2
            long r2 = r1.mGameVideoFragmentOnCreateViewStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mConcernTabFragmentOnCreateViewEndTimeStamp
            r32 = r4
            long r4 = r1.mConcernTabFragmentOnCreateViewStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mConcernTabFragmentOnResumeEndTimeStamp
            r34 = r2
            long r2 = r1.mConcernTabFragmentOnResumeStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mHotTopicTabFragmentOnCreateEndTimeStamp
            r36 = r4
            long r4 = r1.mHotTopicTabFragmentOnCreateStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mHotTopicTabFragmentOnCreateViewEndTimeStamp
            r38 = r2
            long r2 = r1.mHotTopicTabFragmentOnCreateViewStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mPersonalizeFragmentOnCreateEndTimeStamp
            r40 = r4
            long r4 = r1.mPersonalizeFragmentOnCreateStartTimeStamp
            long r2 = r2 - r4
            long r4 = r1.mPersonalizeFragmentOnCreateViewEndTimeStamp
            r42 = r2
            long r2 = r1.mPersonalizeFragmentOnCreateViewStartTimeStamp
            long r4 = r4 - r2
            long r2 = r1.mPersonalizeFragmentOnResumeEndTimeStamp
            r44 = r4
            long r4 = r1.mPersonalizeFragmentOnResumeStartTimeStamp
            long r2 = r2 - r4
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r4 = r1.mFirstMeasureStartStamp
            r46 = r2
            long r2 = r1.mFirstDispatchDrawEndStamp
            long r2 = r0.getDurationWithoutAD(r4, r2)
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            com.baidu.searchbox.launch.stats.SpeedStatsManager r4 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r4 = r4.getAttachWindowEndTime()
            r48 = r14
            long r14 = r1.mFirstMeasureStartStamp
            long r4 = r0.getDurationWithoutAD(r4, r14)
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r14 = r1.mFirstDispatchDrawEndStamp
            r50 = r4
            long r4 = r1.mTabOnLayoutCoreStartStamp
            long r4 = r0.getDurationWithoutAD(r14, r4)
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r14 = r1.mTabOnLayoutCoreEndStamp
            com.baidu.searchbox.launch.stats.SpeedStatsManager r52 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            r53 = r4
            long r4 = r52.getAppLaunchEndTimeStamp()
            long r4 = r0.getDurationWithoutAD(r14, r4)
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            r55 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r2 > r55 ? 1 : (r2 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r10 > r55 ? 1 : (r10 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r6 > r55 ? 1 : (r6 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r12 > r55 ? 1 : (r12 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r48 > r14 ? 1 : (r48 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r48 > r55 ? 1 : (r48 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r16 > r55 ? 1 : (r16 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r18 > r55 ? 1 : (r18 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r20 > r55 ? 1 : (r20 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r22 > r55 ? 1 : (r22 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r24 > r55 ? 1 : (r24 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r26 > r55 ? 1 : (r26 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r28 > r55 ? 1 : (r28 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r42 > r14 ? 1 : (r42 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r42 > r55 ? 1 : (r42 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r44 > r14 ? 1 : (r44 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r44 > r55 ? 1 : (r44 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r46 > r14 ? 1 : (r46 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r46 > r55 ? 1 : (r46 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r38 > r14 ? 1 : (r38 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r38 > r55 ? 1 : (r38 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r40 > r14 ? 1 : (r40 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r40 > r55 ? 1 : (r40 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r34 > r14 ? 1 : (r34 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r34 > r55 ? 1 : (r34 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r36 > r14 ? 1 : (r36 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r36 > r55 ? 1 : (r36 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r30 > r14 ? 1 : (r30 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r30 > r55 ? 1 : (r30 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            int r0 = (r32 > r14 ? 1 : (r32 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r32 > r55 ? 1 : (r32 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mSearchboxViewOnMeasureTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mSearchboxViewOnLayoutTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mFeedTabLayoutOnMeasureTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mFeedTabLayoutOnLayoutTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mTabViewPagerOnMeasureTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 > 0) goto L360
            long r8 = r1.mTabViewPagerOnLayoutTotal
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 < 0) goto L360
            int r0 = (r8 > r55 ? 1 : (r8 == r55 ? 0 : -1))
            if (r0 <= 0) goto L1cd
            goto L360
        L1cd:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r9 = "firstMeasure"
            r8.put(r9, r0)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "secondMeasure"
            r8.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r6 = "firstLayout"
            r8.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r48)
            java.lang.String r6 = "thirdMeasure"
            r8.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r16)
            java.lang.String r6 = "firstDispatchDraw"
            r8.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r18)
            java.lang.String r6 = "secondLayout"
            r8.put(r6, r0)
            long r6 = r1.mSearchboxViewOnMeasureTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "searchboxViewOnMeasure"
            r8.put(r6, r0)
            long r6 = r1.mSearchboxViewOnLayoutTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "searchboxViewOnLayout"
            r8.put(r6, r0)
            long r6 = r1.mFeedTabLayoutOnMeasureTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "feedTabLayoutOnMeasure"
            r8.put(r6, r0)
            long r6 = r1.mFeedTabLayoutOnLayoutTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "feedTabLayoutOnLayout"
            r8.put(r6, r0)
            long r6 = r1.mTabViewPagerOnMeasureTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "tabViewPagerOnMeasure"
            r8.put(r6, r0)
            long r6 = r1.mTabViewPagerOnLayoutTotal
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "tabViewPagerOnLayout"
            r8.put(r6, r0)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r7 = "VideoTabFragmentOnCreate"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r22)
            java.lang.String r7 = "VideoTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r24)
            java.lang.String r7 = "AlaLiveTabFragmentOnCreate"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r26)
            java.lang.String r7 = "AlaLiveTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r28)
            java.lang.String r7 = "AlaLiveTabFragmentOnResume"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r30)
            java.lang.String r7 = "GameVideoTabFragmentOnCreate"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r32)
            java.lang.String r7 = "GameVideoTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r34)
            java.lang.String r7 = "ConcernTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r36)
            java.lang.String r7 = "ConcernTabFragmentOnResume"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r38)
            java.lang.String r7 = "HotTopicTabFragmentOnCreate"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r40)
            java.lang.String r7 = "HotTopicTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r42)
            java.lang.String r7 = "PersonalizedTabFragmentOnCreate"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r44)
            java.lang.String r7 = "PersonalizedTabFragmentOnCreateView"
            r8.put(r7, r0)
            java.lang.String r0 = java.lang.String.valueOf(r46)
            java.lang.String r7 = "PersonalizedTabFragmentOnResume"
            r8.put(r7, r0)
            int r0 = r1.mMeasureCount
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r7 = "scrollMeasureCount"
            r8.put(r7, r0)
            int r0 = r1.mLayoutCount
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r7 = "scrollLayoutCount"
            r8.put(r7, r0)
            r7 = 0
            r9 = r50
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r9, r7)
            if (r0 == 0) goto L301
            java.lang.String r9 = "attach2frame"
            r10 = r58
            r10.put(r9, r0)     // Catch: org.json.JSONException -> L2f2
            goto L303
        L2f2:
            r0 = move-exception
            goto L2f7
        L2f4:
            r0 = move-exception
            r10 = r58
        L2f7:
            boolean r9 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r9 == 0) goto L303
            r0.printStackTrace()
            goto L303
        L301:
            r10 = r58
        L303:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r2, r8)
            if (r0 == 0) goto L319
            java.lang.String r2 = "firstFrame"
            r10.put(r2, r0)     // Catch: org.json.JSONException -> L30f
            goto L319
        L30f:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L319
            r0.printStackTrace()
        L319:
            r2 = r53
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r2, r7)
            if (r0 == 0) goto L331
            java.lang.String r2 = "frame2layout"
            r10.put(r2, r0)     // Catch: org.json.JSONException -> L327
            goto L331
        L327:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L331
            r0.printStackTrace()
        L331:
            long r2 = r1.mTabOnLayoutCoreDuration
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r2, r7)
            if (r0 == 0) goto L348
            r10.put(r6, r0)     // Catch: org.json.JSONException -> L33d
            goto L348
        L33d:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto L348
            r2.printStackTrace()
        L348:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r4, r7)
            if (r0 == 0) goto L35e
            java.lang.String r2 = "layout2end"
            r10.put(r2, r0)     // Catch: org.json.JSONException -> L354
            goto L35e
        L354:
            r0 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L35e
            r0.printStackTrace()
        L35e:
            r2 = 1
            return r2
        L360:
            r0 = 0
            return r0
        L362:
            r55 = r0
            r56 = 1048580(0x100004, float:1.469374E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r55.invokeL(r56, r57, r58)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.FirstFrameSpeedStats.packData(org.json.JSONObject):boolean");
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mFirstMeasureStartStamp = -1L;
            this.mFirstMeasureEndStamp = -1L;
            this.mSecondMeasureStartStamp = -1L;
            this.mSecondMeasureEndStamp = -1L;
            this.mThirdMeasureStartStamp = -1L;
            this.mThirdMeasureEndStamp = -1L;
            this.mFirstLayoutStartStamp = -1L;
            this.mFirstLayoutEndStamp = -1L;
            this.mSecondLayoutStartStamp = -1L;
            this.mSecondLayoutEndStamp = -1L;
            this.mFirstDispatchDrawStartStamp = -1L;
            this.mFirstDispatchDrawEndStamp = -1L;
            this.mSecondDispatchDrawStartStamp = -1L;
            this.mSecondDispatchDrawEndStamp = -1L;
            this.mSearchBoxViewOnMeasureStartStamp = -1L;
            this.mSearchBoxViewOnMeasureEndStamp = -1L;
            this.mSearchBoxViewOnLayoutStartStamp = -1L;
            this.mSearchBoxViewOnLayoutEndStamp = -1L;
            this.mFeedTabLayoutOnMeasureStartStamp = -1L;
            this.mFeedTabLayoutOnMeasureEndStamp = -1L;
            this.mFeedTabLayoutOnLayoutStartStamp = -1L;
            this.mFeedTabLayoutOnLayoutEndStamp = -1L;
            this.mTabViewPagerOnMeasureStartStamp = -1L;
            this.mTabViewPagerOnMeasureEndStamp = -1L;
            this.mTabViewPagerOnLayoutStartStamp = -1L;
            this.mTabViewPagerOnLayoutEndStamp = -1L;
            this.mDispatchDrawCount = 0;
            this.mMeasureCount = 0;
            this.mLayoutCount = 0;
            this.mFeedTabLayoutOnLayoutCount = 0;
            this.mFeedTabLayoutOnMeasureCount = 0;
            this.mSearchboxViewOnLayoutCount = 0;
            this.mSearchboxViewOnMeasureCount = 0;
            this.mTabViewPagerOnLayoutCount = 0;
            this.mTabViewPagerOnMeasureCount = 0;
            this.mVideoTabFragmentOnCreateStartTimeStamp = -1L;
            this.mVideoTabFragmentOnCreateEndTimeStamp = -1L;
            this.mVideoTabFragmentOnCreateViewStartTimeStamp = -1L;
            this.mVideoTabFragmentOnCreateViewEndTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp = -1L;
            this.mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp = -1L;
            this.mGameVideoFragmentOnCreateStartTimeStamp = -1L;
            this.mGameVideoFragmentOnCreateEndTimeStamp = -1L;
            this.mGameVideoFragmentOnCreateViewStartTimeStamp = -1L;
            this.mGameVideoFragmentOnCreateViewEndTimeStamp = -1L;
            this.mConcernTabFragmentOnCreateViewStartTimeStamp = -1L;
            this.mConcernTabFragmentOnCreateViewEndTimeStamp = -1L;
            this.mConcernTabFragmentOnResumeStartTimeStamp = -1L;
            this.mConcernTabFragmentOnResumeEndTimeStamp = -1L;
            this.mHotTopicTabFragmentOnCreateViewStartTimeStamp = -1L;
            this.mHotTopicTabFragmentOnCreateViewEndTimeStamp = -1L;
            this.mHotTopicTabFragmentOnCreateStartTimeStamp = -1L;
            this.mHotTopicTabFragmentOnCreateEndTimeStamp = -1L;
            this.mPersonalizeFragmentOnCreateStartTimeStamp = -1L;
            this.mPersonalizeFragmentOnCreateEndTimeStamp = -1L;
            this.mPersonalizeFragmentOnCreateViewStartTimeStamp = -1L;
            this.mPersonalizeFragmentOnCreateViewEndTimeStamp = -1L;
            this.mPersonalizeFragmentOnResumeStartTimeStamp = -1L;
            this.mPersonalizeFragmentOnResumeEndTimeStamp = -1L;
        }
    }
}
