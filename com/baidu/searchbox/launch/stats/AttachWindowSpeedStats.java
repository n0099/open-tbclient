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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void addStatsTimeStamp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            addStatsTimeStamp(i2, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHomeFragmentOnResumeEndStamp : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHomeTabOnAttachStartStamp : invokeV.longValue;
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
            long j2 = this.mHomeFragmentOnResumeEndStamp;
            long j3 = this.mHomeTabOnAttachStartStamp;
            long j4 = j2 - j3;
            long j5 = this.mHomeTabOnAttachEndStamp - j3;
            long j6 = this.mHomeTabOnCreateEndStamp - this.mHomeTabOnCreateStartStamp;
            long j7 = this.mHomeFragmentOnCreateViewEndStamp - this.mHomeFragmentOnCreateViewStartStamp;
            long j8 = this.mScrollFragmentTabHostInitEndStamp - this.mScrollFragmentTabHostInitStartStamp;
            long j9 = this.mHomeTabBarViewInitEndStamp - this.mHomeTabBarViewInitStartStamp;
            long j10 = this.mCustomViewPagerEndStamp - this.mCustomViewPagerStartStamp;
            long j11 = this.mNestedScrollHeaderEndStamp - this.mNestedScrollHeaderStartStamp;
            long j12 = this.mHomeFragmentInitModelEndStamp - this.mHomeFragmentInitModelStartStamp;
            long j13 = this.mHomeFragmentInitTableEndStamp - this.mHomeFragmentInitTableStartStamp;
            long j14 = this.mHomeFragmentInitViewPaperEndStamp - this.mHomeFragmentInitViewPaperStartStamp;
            long j15 = this.mHomeFragmentStartFirstLoadPaperEndStamp - this.mHomeFragmentStartFirstLoadStartStamp;
            long j16 = this.mHomeFragmentCheckConcernRedTipEndStamp - this.mHomeFragmentCheckConcernRedTipStartStamp;
            long j17 = this.mHomeFragmentShowConcernTabTipsEndStamp - this.mHomeFragmentShowConcernTabTipsStartStamp;
            long j18 = this.mHomeFragmentOnActivityCreatedEndStamp - this.mHomeFragmentOnActivityCreatedStartStamp;
            long j19 = j2 - this.mHomeFragmentOnResumeStartStamp;
            long j20 = this.mConcernTabFragmentEndTimeStamp - this.mConcernTabFragmentStartTimeStamp;
            long j21 = this.mHotTopicTabFragmentEndTimeStamp - this.mHotTopicTabFragmentStartTimeStamp;
            long j22 = this.mPersonalizeTabFragmentEndTimeStamp - this.mPersonalizeTabFragmentStartTimeStamp;
            if (j4 < 0 || j4 > 60000 || j5 < 0 || j5 > 60000 || j6 < 0 || j6 > 60000 || j21 < 0 || j21 > 60000 || j20 < 0 || j20 > 60000 || j22 < 0 || j22 > 60000 || j7 < 0 || j7 > 60000 || j8 < 0 || j8 > 60000 || j9 < 0 || j9 > 60000 || j10 < 0 || j10 > 60000 || j11 < 0 || j11 > 60000 || j12 < 0 || j12 > 60000 || j13 < 0 || j13 > 60000 || j14 < 0 || j14 > 60000 || j15 < 0 || j15 > 60000 || j16 < 0 || j16 > 60000 || j17 < 0 || j17 > 60000 || j18 < 0 || j18 > 60000 || j19 < 0 || j19 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(HOME_FRAGMENT_TOTAL_TIME, String.valueOf(j4));
            hashMap.put(HOME_FRAGMENT_ON_ATTACH, String.valueOf(j5));
            hashMap.put(HOME_FRAGMENT_ON_CREATE, String.valueOf(j6));
            hashMap.put(HOME_FRAGMENT_ON_CREATE_VIEW, String.valueOf(j7));
            hashMap.put(SCROLL_FRAGMENT_TAB_HOST_INIT, String.valueOf(j8));
            hashMap.put(HOME_TAB_BAR_VIEW_INIT, String.valueOf(j9));
            hashMap.put(CUSTOM_VIEW_PAPER_INIT, String.valueOf(j10));
            hashMap.put(NESTED_SCROLL_HEADER_INIT, String.valueOf(j11));
            hashMap.put(HOME_FRAGMENT_INIT_MODEL, String.valueOf(j12));
            hashMap.put(HOME_FRAGMENT_INIT_TABLE, String.valueOf(j13));
            hashMap.put(HOME_FRAGMENT_INIT_VIEW_PAPER, String.valueOf(j14));
            hashMap.put(HOME_FRAGMENT_FIRST_LOAD, String.valueOf(j15));
            hashMap.put(HOME_FRAGMENT_CHECK_CONCERN_RED_TIP, String.valueOf(j16));
            hashMap.put(HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS, String.valueOf(j17));
            hashMap.put(HOME_FRAGMENT_ON_ACTIVITY_CREATED, String.valueOf(j18));
            hashMap.put(HOME_FRAGMENT_ON_RESUME, String.valueOf(j19));
            hashMap.put(CONCERN_TAB_DURATION, String.valueOf(j20));
            hashMap.put(HOT_TOPIC_TAB_DURATION, String.valueOf(j21));
            hashMap.put(PERSONALIZE_TAB_DURATION, String.valueOf(j22));
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j4, hashMap);
            if (jsonData != null) {
                try {
                    jSONObject.put(SpeedStatsMainTable.ATTACH_WINDOW_STAGE, jsonData);
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
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            if (i2 == 5020) {
                this.mConcernTabFragmentStartTimeStamp = j2;
            } else if (i2 == 5021) {
                this.mConcernTabFragmentEndTimeStamp = j2;
            } else if (i2 == 5026) {
                this.mHotTopicTabFragmentStartTimeStamp = j2;
            } else if (i2 == 5027) {
                this.mHotTopicTabFragmentEndTimeStamp = j2;
            } else if (i2 == 5046) {
                this.mPersonalizeTabFragmentStartTimeStamp = j2;
            } else if (i2 != 5047) {
                switch (i2) {
                    case 4000:
                        this.mHomeTabOnAttachStartStamp = j2;
                        return;
                    case 4001:
                        this.mHomeTabOnAttachEndStamp = j2;
                        return;
                    case 4002:
                        this.mHomeTabOnCreateStartStamp = j2;
                        return;
                    case 4003:
                        this.mHomeTabOnCreateEndStamp = j2;
                        return;
                    case 4004:
                        this.mHomeFragmentOnCreateViewStartStamp = j2;
                        return;
                    case 4005:
                        this.mHomeFragmentOnCreateViewEndStamp = j2;
                        return;
                    case 4006:
                        this.mScrollFragmentTabHostInitStartStamp = j2;
                        return;
                    case 4007:
                        this.mScrollFragmentTabHostInitEndStamp = j2;
                        return;
                    case 4008:
                        this.mHomeTabBarViewInitStartStamp = j2;
                        return;
                    case 4009:
                        this.mHomeTabBarViewInitEndStamp = j2;
                        return;
                    case 4010:
                        this.mCustomViewPagerStartStamp = j2;
                        return;
                    case 4011:
                        this.mCustomViewPagerEndStamp = j2;
                        return;
                    case 4012:
                        this.mNestedScrollHeaderStartStamp = j2;
                        return;
                    case 4013:
                        this.mNestedScrollHeaderEndStamp = j2;
                        return;
                    case 4014:
                        this.mHomeFragmentOnActivityCreatedStartStamp = j2;
                        return;
                    case 4015:
                        this.mHomeFragmentInitModelStartStamp = j2;
                        return;
                    case 4016:
                        this.mHomeFragmentInitModelEndStamp = j2;
                        return;
                    case 4017:
                        this.mHomeFragmentInitTableStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY /* 4018 */:
                        this.mHomeFragmentInitTableEndStamp = j2;
                        return;
                    case 4019:
                        this.mHomeFragmentInitViewPaperStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY /* 4020 */:
                        this.mHomeFragmentInitViewPaperEndStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY /* 4021 */:
                        this.mHomeFragmentStartFirstLoadStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY /* 4022 */:
                        this.mHomeFragmentStartFirstLoadPaperEndStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_START_STAMP_KEY /* 4023 */:
                        this.mHomeFragmentCheckConcernRedTipStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_CHECK_CONCERN_RED_TIP_END_STAMP_KEY /* 4024 */:
                        this.mHomeFragmentCheckConcernRedTipEndStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY /* 4025 */:
                        this.mHomeFragmentShowConcernTabTipsStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY /* 4026 */:
                        this.mHomeFragmentShowConcernTabTipsEndStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY /* 4027 */:
                        this.mHomeFragmentOnActivityCreatedEndStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_START_STAMP_KEY /* 4028 */:
                        this.mHomeFragmentOnResumeStartStamp = j2;
                        return;
                    case SpeedStatsStampTable.HOME_FRAGMENT_ONRESUME_END_STAMP_KEY /* 4029 */:
                        this.mHomeFragmentOnResumeEndStamp = j2;
                        return;
                    default:
                        return;
                }
            } else {
                this.mPersonalizeTabFragmentEndTimeStamp = j2;
            }
        }
    }
}
