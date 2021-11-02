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
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i2, j);
            switch (i2) {
                case 5000:
                    int i3 = this.mMeasureCount;
                    if (i3 == 0) {
                        this.mFirstMeasureStartStamp = j;
                        return;
                    } else if (i3 == 1) {
                        this.mSecondMeasureStartStamp = j;
                        return;
                    } else if (i3 == 2) {
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
                    int i4 = this.mMeasureCount;
                    if (i4 == 0) {
                        this.mFirstMeasureEndStamp = j;
                    } else if (i4 == 1) {
                        this.mSecondMeasureEndStamp = j;
                    } else if (i4 == 2) {
                        this.mThirdMeasureEndStamp = j;
                    }
                    this.mMeasureCount++;
                    return;
                case 5008:
                    int i5 = this.mLayoutCount;
                    if (i5 == 0) {
                        this.mFirstLayoutStartStamp = j;
                        return;
                    } else if (i5 == 1) {
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
                    this.mTabViewPagerOnLayoutTotal = (this.mTabViewPagerOnLayoutTotal + j) - this.mTabViewPagerOnLayoutStartStamp;
                    this.mTabViewPagerOnLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                    int i6 = this.mLayoutCount;
                    if (i6 == 0) {
                        this.mFirstLayoutEndStamp = j;
                    } else if (i6 == 1) {
                        this.mSecondLayoutEndStamp = j;
                    }
                    this.mLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY /* 5016 */:
                    int i7 = this.mDispatchDrawCount;
                    if (i7 == 0) {
                        this.mFirstDispatchDrawStartStamp = j;
                        return;
                    } else if (i7 == 1) {
                        this.mSecondDispatchDrawStartStamp = j;
                        return;
                    } else {
                        return;
                    }
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                    int i8 = this.mDispatchDrawCount;
                    if (i8 == 0) {
                        this.mFirstDispatchDrawEndStamp = j;
                    } else if (i8 == 1) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return true;
            }
            long j = this.mFirstDispatchDrawEndStamp;
            long j2 = this.mFirstMeasureStartStamp;
            long j3 = j - j2;
            long j4 = this.mFirstMeasureEndStamp - j2;
            long j5 = this.mSecondMeasureEndStamp - this.mSecondMeasureStartStamp;
            long j6 = this.mFirstLayoutEndStamp - this.mFirstLayoutStartStamp;
            long j7 = this.mThirdMeasureEndStamp - this.mThirdMeasureStartStamp;
            long j8 = j - this.mFirstDispatchDrawStartStamp;
            long j9 = this.mSecondLayoutEndStamp - this.mSecondLayoutStartStamp;
            long j10 = this.mVideoTabFragmentOnCreateEndTimeStamp - this.mVideoTabFragmentOnCreateStartTimeStamp;
            long j11 = this.mVideoTabFragmentOnCreateViewEndTimeStamp - this.mVideoTabFragmentOnCreateViewStartTimeStamp;
            long j12 = this.mAlaLiveTabFeedPageFragmentOnCreateEndTimeStamp - this.mAlaLiveTabFeedPageFragmentOnCreateStartTimeStamp;
            long j13 = this.mAlaLiveTabFeedPageFragmentOnCreateViewEndTimeStamp - this.mAlaLiveTabFeedPageFragmentOnCreateViewStartTimeStamp;
            long j14 = this.mAlaLiveTabFeedPageFragmentOnResumeEndTimeStamp - this.mAlaLiveTabFeedPageFragmentOnResumeStartTimeStamp;
            long j15 = this.mGameVideoFragmentOnCreateEndTimeStamp - this.mGameVideoFragmentOnCreateStartTimeStamp;
            long j16 = this.mGameVideoFragmentOnCreateViewEndTimeStamp - this.mGameVideoFragmentOnCreateViewStartTimeStamp;
            long j17 = this.mConcernTabFragmentOnCreateViewEndTimeStamp - this.mConcernTabFragmentOnCreateViewStartTimeStamp;
            long j18 = this.mConcernTabFragmentOnResumeEndTimeStamp - this.mConcernTabFragmentOnResumeStartTimeStamp;
            long j19 = this.mHotTopicTabFragmentOnCreateEndTimeStamp - this.mHotTopicTabFragmentOnCreateStartTimeStamp;
            long j20 = this.mHotTopicTabFragmentOnCreateViewEndTimeStamp - this.mHotTopicTabFragmentOnCreateViewStartTimeStamp;
            long j21 = this.mPersonalizeFragmentOnCreateEndTimeStamp - this.mPersonalizeFragmentOnCreateStartTimeStamp;
            long j22 = this.mPersonalizeFragmentOnCreateViewEndTimeStamp - this.mPersonalizeFragmentOnCreateViewStartTimeStamp;
            long j23 = this.mPersonalizeFragmentOnResumeEndTimeStamp - this.mPersonalizeFragmentOnResumeStartTimeStamp;
            if (j3 < 0 || j3 > 60000 || j4 < 0 || j4 > 60000 || j5 < 0 || j5 > 60000 || j6 < 0 || j6 > 60000 || j7 < 0 || j7 > 60000 || j8 < 0 || j8 > 60000 || j9 < 0 || j9 > 60000 || j10 < 0 || j10 > 60000 || j11 < 0 || j11 > 60000 || j12 < 0 || j12 > 60000 || j13 < 0 || j13 > 60000 || j14 < 0 || j14 > 60000 || j21 < 0 || j21 > 60000 || j22 < 0 || j22 > 60000 || j23 < 0 || j23 > 60000 || j19 < 0 || j19 > 60000 || j20 < 0 || j20 > 60000 || j17 < 0 || j17 > 60000 || j18 < 0 || j18 > 60000 || j15 < 0 || j15 > 60000 || j16 < 0 || j16 > 60000) {
                return false;
            }
            long j24 = this.mSearchboxViewOnMeasureTotal;
            if (j24 < 0 || j24 > 60000) {
                return false;
            }
            long j25 = this.mSearchboxViewOnLayoutTotal;
            if (j25 < 0 || j25 > 60000) {
                return false;
            }
            long j26 = this.mFeedTabLayoutOnMeasureTotal;
            if (j26 < 0 || j26 > 60000) {
                return false;
            }
            long j27 = this.mFeedTabLayoutOnLayoutTotal;
            if (j27 < 0 || j27 > 60000) {
                return false;
            }
            long j28 = this.mTabViewPagerOnMeasureTotal;
            if (j28 < 0 || j28 > 60000) {
                return false;
            }
            long j29 = this.mTabViewPagerOnLayoutTotal;
            if (j29 < 0 || j29 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(FIRST_MEASURE, String.valueOf(j4));
            hashMap.put(SECOND_MEASURE, String.valueOf(j5));
            hashMap.put(FIRST_LAYOUT, String.valueOf(j6));
            hashMap.put(THIRD_MEASURE, String.valueOf(j7));
            hashMap.put(FIRST_DISPATCH_DRAW, String.valueOf(j8));
            hashMap.put(SECOND_LAYOUT, String.valueOf(j9));
            hashMap.put(SEARCHBOX_VIEW_ON_MEASURE, String.valueOf(this.mSearchboxViewOnMeasureTotal));
            hashMap.put(SEARCHBOX_VIEW_ON_LAYOUT, String.valueOf(this.mSearchboxViewOnLayoutTotal));
            hashMap.put(HOME_TAB_BAR_VIEW_ON_MEASURE, String.valueOf(this.mFeedTabLayoutOnMeasureTotal));
            hashMap.put(HOME_TAB_BAR_VIEW_ON_LAYOUT, String.valueOf(this.mFeedTabLayoutOnLayoutTotal));
            hashMap.put(TAB_VIEW_PAGER_ON_MEASURE, String.valueOf(this.mTabViewPagerOnMeasureTotal));
            hashMap.put(TAB_VIEW_PAGER_ON_LAYOUT, String.valueOf(this.mTabViewPagerOnLayoutTotal));
            hashMap.put(VIDEO_TAB_ON_CREATE_DURATION, String.valueOf(j10));
            hashMap.put(VIDEO_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j11));
            hashMap.put(ALA_LIVE_TAB_ON_CREATE_DURATION, String.valueOf(j12));
            hashMap.put(ALA_LIVE_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j13));
            hashMap.put(ALA_LIVE_TAB_ON_RESUME_DURATION, String.valueOf(j14));
            hashMap.put(GAME_VIDEO_TAB_ON_CREATE_DURATION, String.valueOf(j15));
            hashMap.put(GAME_VIDEO_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j16));
            hashMap.put(CONCERN_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j17));
            hashMap.put(CONCERN_TAB_ON_RESUME_DURATION, String.valueOf(j18));
            hashMap.put(HOT_TOPIC_TAB_ON_CREATE_DURATION, String.valueOf(j19));
            hashMap.put(HOT_TOPIC_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j20));
            hashMap.put(PERSONALIZE_TAB_ON_CREATE_DURATION, String.valueOf(j21));
            hashMap.put(PERSONALIZE_TAB_ON_CREATE_VIEW_DURATION, String.valueOf(j22));
            hashMap.put(PERSONALIZE_TAB_ON_RESUME_DURATION, String.valueOf(j23));
            hashMap.put(SCROLL_FRAGMENT_TAB_HOST_MEASURE_COUNT, String.valueOf(this.mMeasureCount));
            hashMap.put(SCROLL_FRAGMENT_TAB_HOST_LAYOUT_COUNT, String.valueOf(this.mLayoutCount));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.FIRST_FRAME_STAGE, jsonData);
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
