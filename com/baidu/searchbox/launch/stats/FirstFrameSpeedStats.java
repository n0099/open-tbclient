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
public final class FirstFrameSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FIRST_DISPATCH_DRAW = "firstDispatchDraw";
    public static final String FIRST_LAYOUT = "firstLayout";
    public static final String FIRST_MEASURE = "firstMeasure";
    public static final String HOME_TAB_BAR_VIEW_ON_LAYOUT = "feedTabLayoutOnLayout";
    public static final String HOME_TAB_BAR_VIEW_ON_LAYOUT_COUNT = "feedTabLayoutOnLayoutCount";
    public static final String HOME_TAB_BAR_VIEW_ON_MEASURE = "feedTabLayoutOnMeasure";
    public static final String HOME_TAB_BAR_VIEW_ON_MEASURE_COUNT = "feedTabLayoutMeasureCount";
    public static final String INIT = "init";
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
    public transient /* synthetic */ FieldHolder $fh;
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
    public int mLayoutCount;
    public int mMeasureCount;
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
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            switch (i2) {
                case 5000:
                    int i3 = this.mMeasureCount;
                    if (i3 == 0) {
                        this.mFirstMeasureStartStamp = j2;
                        return;
                    } else if (i3 == 1) {
                        this.mSecondMeasureStartStamp = j2;
                        return;
                    } else if (i3 == 2) {
                        this.mThirdMeasureStartStamp = j2;
                        return;
                    } else {
                        return;
                    }
                case 5001:
                    this.mSearchBoxViewOnMeasureStartStamp = j2;
                    return;
                case 5002:
                    this.mSearchBoxViewOnMeasureEndStamp = j2;
                    this.mSearchboxViewOnMeasureTotal = (this.mSearchboxViewOnMeasureTotal + j2) - this.mSearchBoxViewOnMeasureStartStamp;
                    this.mSearchboxViewOnMeasureCount++;
                    return;
                case 5003:
                    this.mFeedTabLayoutOnMeasureStartStamp = j2;
                    return;
                case 5004:
                    this.mFeedTabLayoutOnMeasureEndStamp = j2;
                    this.mFeedTabLayoutOnMeasureTotal = (this.mFeedTabLayoutOnMeasureTotal + j2) - this.mFeedTabLayoutOnMeasureStartStamp;
                    this.mFeedTabLayoutOnMeasureCount++;
                    return;
                case 5005:
                    this.mTabViewPagerOnMeasureStartStamp = j2;
                    return;
                case 5006:
                    this.mTabViewPagerOnMeasureEndStamp = j2;
                    this.mTabViewPagerOnMeasureTotal = (this.mTabViewPagerOnMeasureTotal + j2) - this.mTabViewPagerOnMeasureStartStamp;
                    this.mTabViewPagerOnMeasureCount++;
                    return;
                case 5007:
                    int i4 = this.mMeasureCount;
                    if (i4 == 0) {
                        this.mFirstMeasureEndStamp = j2;
                    } else if (i4 == 1) {
                        this.mSecondMeasureEndStamp = j2;
                    } else if (i4 == 2) {
                        this.mThirdMeasureEndStamp = j2;
                    }
                    this.mMeasureCount++;
                    return;
                case 5008:
                    int i5 = this.mLayoutCount;
                    if (i5 == 0) {
                        this.mFirstLayoutStartStamp = j2;
                        return;
                    } else if (i5 == 1) {
                        this.mSecondLayoutStartStamp = j2;
                        return;
                    } else {
                        return;
                    }
                case 5009:
                    this.mSearchBoxViewOnLayoutStartStamp = j2;
                    return;
                case 5010:
                    this.mSearchBoxViewOnLayoutEndStamp = j2;
                    this.mSearchboxViewOnLayoutTotal = (this.mSearchboxViewOnLayoutTotal + j2) - this.mSearchBoxViewOnLayoutStartStamp;
                    this.mSearchboxViewOnLayoutCount++;
                    return;
                case 5011:
                    this.mFeedTabLayoutOnLayoutStartStamp = j2;
                    return;
                case 5012:
                    this.mFeedTabLayoutOnLayoutEndStamp = j2;
                    this.mFeedTabLayoutOnLayoutTotal = (this.mFeedTabLayoutOnLayoutTotal + j2) - this.mFeedTabLayoutOnLayoutStartStamp;
                    this.mFeedTabLayoutOnLayoutCount++;
                    return;
                case 5013:
                    this.mTabViewPagerOnLayoutStartStamp = j2;
                    return;
                case 5014:
                    this.mTabViewPagerOnLayoutEndStamp = j2;
                    this.mTabViewPagerOnLayoutTotal = (this.mTabViewPagerOnLayoutTotal + j2) - this.mTabViewPagerOnLayoutStartStamp;
                    this.mTabViewPagerOnLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                    int i6 = this.mLayoutCount;
                    if (i6 == 0) {
                        this.mFirstLayoutEndStamp = j2;
                    } else if (i6 == 1) {
                        this.mSecondLayoutEndStamp = j2;
                    }
                    this.mLayoutCount++;
                    return;
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_START_STAMP_KEY /* 5016 */:
                    int i7 = this.mDispatchDrawCount;
                    if (i7 == 0) {
                        this.mFirstDispatchDrawStartStamp = j2;
                        return;
                    } else if (i7 == 1) {
                        this.mSecondDispatchDrawStartStamp = j2;
                        return;
                    } else {
                        return;
                    }
                case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                    int i8 = this.mDispatchDrawCount;
                    if (i8 == 0) {
                        this.mFirstDispatchDrawEndStamp = j2;
                    } else if (i8 == 1) {
                        this.mSecondDispatchDrawEndStamp = j2;
                    }
                    this.mDispatchDrawCount++;
                    return;
                default:
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
            long j2 = this.mFirstDispatchDrawEndStamp;
            long j3 = this.mFirstMeasureStartStamp;
            long j4 = j2 - j3;
            long j5 = this.mFirstMeasureEndStamp - j3;
            long j6 = this.mSecondMeasureEndStamp - this.mSecondMeasureStartStamp;
            long j7 = this.mFirstLayoutEndStamp - this.mFirstLayoutStartStamp;
            long j8 = this.mThirdMeasureEndStamp - this.mThirdMeasureStartStamp;
            long j9 = j2 - this.mFirstDispatchDrawStartStamp;
            long j10 = this.mSecondLayoutEndStamp - this.mSecondLayoutStartStamp;
            if (j4 < 0 || j4 > 60000 || j5 < 0 || j5 > 60000 || j6 < 0 || j6 > 60000 || j7 < 0 || j7 > 60000 || j8 < 0 || j8 > 60000 || j9 < 0 || j9 > 60000 || j10 < 0 || j10 > 60000) {
                return false;
            }
            long j11 = this.mSearchboxViewOnMeasureTotal;
            if (j11 < 0 || j11 > 60000) {
                return false;
            }
            long j12 = this.mSearchboxViewOnLayoutTotal;
            if (j12 < 0 || j12 > 60000) {
                return false;
            }
            long j13 = this.mFeedTabLayoutOnMeasureTotal;
            if (j13 < 0 || j13 > 60000) {
                return false;
            }
            long j14 = this.mFeedTabLayoutOnLayoutTotal;
            if (j14 < 0 || j14 > 60000) {
                return false;
            }
            long j15 = this.mTabViewPagerOnMeasureTotal;
            if (j15 < 0 || j15 > 60000) {
                return false;
            }
            long j16 = this.mTabViewPagerOnLayoutTotal;
            if (j16 < 0 || j16 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(FIRST_MEASURE, String.valueOf(j5));
            hashMap.put(SECOND_MEASURE, String.valueOf(j6));
            hashMap.put(FIRST_LAYOUT, String.valueOf(j7));
            hashMap.put(THIRD_MEASURE, String.valueOf(j8));
            hashMap.put(FIRST_DISPATCH_DRAW, String.valueOf(j9));
            hashMap.put(SECOND_LAYOUT, String.valueOf(j10));
            hashMap.put(SEARCHBOX_VIEW_ON_MEASURE, String.valueOf(this.mSearchboxViewOnMeasureTotal));
            hashMap.put(SEARCHBOX_VIEW_ON_LAYOUT, String.valueOf(this.mSearchboxViewOnLayoutTotal));
            hashMap.put(HOME_TAB_BAR_VIEW_ON_MEASURE, String.valueOf(this.mFeedTabLayoutOnMeasureTotal));
            hashMap.put(HOME_TAB_BAR_VIEW_ON_LAYOUT, String.valueOf(this.mFeedTabLayoutOnLayoutTotal));
            hashMap.put(TAB_VIEW_PAGER_ON_MEASURE, String.valueOf(this.mTabViewPagerOnMeasureTotal));
            hashMap.put(TAB_VIEW_PAGER_ON_LAYOUT, String.valueOf(this.mTabViewPagerOnLayoutTotal));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j4, hashMap);
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
        }
    }
}
