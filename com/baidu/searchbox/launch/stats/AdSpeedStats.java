package com.baidu.searchbox.launch.stats;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_BEAR_LOAD_DURATION = "bearLoad";
    public static final String AD_BEAR_LOAD_RESULT = "bearResult";
    public static final String AD_BEAR_PRE_LOAD_DURATION = "bearPreLoad";
    public static final String AD_BEAR_REAL_LOAD_DURATION = "bearRealLoad";
    public static final String AD_BEAR_REAL_TIMEOUT_DURATION = "bearRealTimeout";
    public static final String AD_FAIL_COUNT = "adFailCount";
    public static final String AD_LOAD_HANDLER_A_DURATION = "loadHandlerA";
    public static final String AD_LOAD_HANDLER_B_DURATION = "loadHandlerB";
    public static final String AD_LOAD_IDLE_DURATION = "loadIdle";
    public static final String AD_LOAD_METHOD_DURATION = "loadMethod";
    public static final String AD_LOAD_RESULT = "adResult";
    public static final String AD_LOAD_TOTAL_DURATION = "loadTotal";
    public static final String AD_NET_TYPE = "adNetType";
    public static final String AD_NO_SHOW_DURATION = "adDurNoShow";
    public static final String AD_PLG_AD_TYPE = "plgType";
    public static final String AD_PLG_LOAD_RESULT = "plgResult";
    public static final String AD_POLICY_SO_DURATION = "policySo";
    public static final String AD_POST_SHOW_GAP_DURATION = "postShowGap";
    public static final String AD_PROLOGUE_LOAD_DURATION = "prologueLoad";
    public static final String AD_SHOW_METHOD_DURATION = "showMethod";
    public static final String AD_SHOW_SOURCE = "adShowSource";
    public static final String AD_SHOW_TOTAL_DURATION = "showTotal";
    public static final String AD_SHOW_VIEW_DURATION = "adShowView";
    public static final String AD_TO_END_DURATION = "ad2End";
    public static final String AD_WAIT_LOAD_DURATION = "waitLoad";
    public static final String AD_WAIT_SHOW_DURATION = "waitShow";
    public static final String AD_WITH_SHOW_DURATION = "adDurWithShow";
    public static final String DRAW_DONE_2_AD_SHOW_GAP = "draw2AdShow";
    public static final String IS_AD_SHOW_SOURCE = "isAdShow";
    public static final String IS_AD_TIMEOUT = "isTimeout";
    public static final String IS_NEED_BEAR = "isNeedBear";
    public static final String IS_NEED_PLG = "isNeedPlg";
    public transient /* synthetic */ FieldHolder $fh;
    public String adSource;
    public boolean isNeedBear;
    public boolean isNeedPlg;
    public boolean isTimeout;
    public long mAdLoadCostPure;
    public long mAdLoadHandlerEndTimeStamp;
    public long mAdLoadIdleEndTimeStamp;
    public long mAdLoadMethodEndTimeStamp;
    public long mAdLoadMethodStartTimeStamp;
    public int mAdLoadResult;
    public long mAdPreLoadBearStartTimeStamp;
    public long mAdShowEndTimeStamp;
    public long mAdShowMethodEndTimeStamp;
    public long mAdShowMethodStartTimeStamp;
    public long mAdShowPolicySoEndStamp;
    public long mAdShowStartTimeStamp;
    public long mAdViewEndTimeStamp;
    public boolean mBearLoadResult;
    public int mFailCount;
    public HashMap<String, Long> mLaunchTaskDuration;
    public long mLoadBearEndTimeStamp;
    public long mLoadPrologueEndTimeStamp;
    public String mNetType;
    public String mPlgAdType;
    public boolean mPlgLoadResult;
    public long mSecondDrawDispatchedTimeStamp;

    public AdSpeedStats() {
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
        this.mAdLoadMethodStartTimeStamp = -1L;
        this.mAdLoadMethodEndTimeStamp = -1L;
        this.mAdLoadIdleEndTimeStamp = -1L;
        this.mAdLoadHandlerEndTimeStamp = -1L;
        this.mLoadPrologueEndTimeStamp = -1L;
        this.mLoadBearEndTimeStamp = -1L;
        this.mAdShowMethodStartTimeStamp = -1L;
        this.mAdShowMethodEndTimeStamp = -1L;
        this.mAdShowPolicySoEndStamp = -1L;
        this.mAdShowStartTimeStamp = -1L;
        this.mAdShowEndTimeStamp = -1L;
        this.mAdViewEndTimeStamp = -1L;
        this.mSecondDrawDispatchedTimeStamp = -1L;
        this.mAdPreLoadBearStartTimeStamp = -1L;
        this.adSource = "0";
        this.mAdLoadResult = 0;
        this.mBearLoadResult = false;
        this.mPlgLoadResult = false;
        this.isTimeout = false;
        this.mAdLoadCostPure = -1L;
        this.mLaunchTaskDuration = new HashMap<>();
        this.isNeedBear = true;
        this.isNeedPlg = true;
        this.mFailCount = 0;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            super.addStatsDuration(str, j);
            synchronized (this.mLaunchTaskDuration) {
                this.mLaunchTaskDuration.put(str, Long.valueOf(j));
            }
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            if (i != 5054) {
                switch (i) {
                    case SpeedStatsStampTable.AD_LOAD_METHOD_START_STAMP_KEY /* 3301 */:
                        this.mNetType = BdNetTypeUtil.getNetType();
                        this.mAdLoadMethodStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_METHOD_END_STAMP_KEY /* 3302 */:
                        this.mAdLoadMethodEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_PROLOGUE_END_STAMP_KEY /* 3303 */:
                        this.mLoadPrologueEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                        this.mLoadBearEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_IDLE_END_STAMP_KEY /* 3305 */:
                        this.mAdLoadIdleEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_HANDLER_END_STAMP_KEY /* 3306 */:
                        this.mAdLoadHandlerEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY /* 3307 */:
                        this.mAdShowMethodStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY /* 3308 */:
                        this.mAdShowMethodEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_POLICY_SO_END /* 3309 */:
                        this.mAdShowPolicySoEndStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY /* 3310 */:
                        this.mAdShowStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY /* 3311 */:
                        this.mAdShowEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY /* 3312 */:
                        this.mAdViewEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_PRELOAD_BEAR_START_STAMP_KEY /* 3313 */:
                        this.mAdPreLoadBearStartTimeStamp = j;
                        return;
                    default:
                        return;
                }
            }
            this.mSecondDrawDispatchedTimeStamp = j;
        }
    }

    public long getDurationWithoutAD(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j > j2) {
                return 0L;
            }
            long j3 = this.mAdShowEndTimeStamp;
            if (this.mAdShowStartTimeStamp > 0 && j3 < 0) {
                j3 = this.mAdViewEndTimeStamp;
            }
            long j4 = this.mAdShowStartTimeStamp;
            if (j4 > 0 && j4 < j2 && j3 > j) {
                if (j4 <= j && j3 >= j2) {
                    return 0L;
                }
                long j5 = this.mAdShowStartTimeStamp;
                if (j5 > j && j3 < j2) {
                    return (j2 - j) - (j3 - j5);
                }
                if (this.mAdShowStartTimeStamp <= j && j3 < j2) {
                    return j2 - j3;
                }
                long j6 = this.mAdShowStartTimeStamp;
                if (j6 > j && j3 >= j2) {
                    return j6 - j;
                }
                return j2 - j;
            }
            return j2 - j;
        }
        return invokeCommon.longValue;
    }

    public long getAdShowDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mAdShowStartTimeStamp <= 0) {
                return 0L;
            }
            long j = this.mAdShowEndTimeStamp;
            if (j < 0) {
                j = this.mAdViewEndTimeStamp;
            }
            return j - this.mAdShowStartTimeStamp;
        }
        return invokeV.longValue;
    }

    public long getAdTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mAdLoadCostPure == -1) {
                packData(new JSONObject());
            }
            return this.mAdLoadCostPure;
        }
        return invokeV.longValue;
    }

    public long getAdViewEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAdViewEndTimeStamp;
        }
        return invokeV.longValue;
    }

    public boolean isLoadEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mAdShowStartTimeStamp <= 0 && this.mAdViewEndTimeStamp <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mAdLoadMethodStartTimeStamp = -1L;
            this.mAdLoadMethodEndTimeStamp = -1L;
            this.mAdLoadIdleEndTimeStamp = -1L;
            this.mAdLoadHandlerEndTimeStamp = -1L;
            this.mLoadPrologueEndTimeStamp = -1L;
            this.mLoadBearEndTimeStamp = -1L;
            this.mAdShowMethodStartTimeStamp = -1L;
            this.mAdShowMethodEndTimeStamp = -1L;
            this.mAdShowStartTimeStamp = -1L;
            this.mAdShowEndTimeStamp = -1L;
            this.mAdViewEndTimeStamp = -1L;
            this.mSecondDrawDispatchedTimeStamp = -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:212:0x038b A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j25 = this.mAdShowEndTimeStamp;
            if (j25 < 0) {
                j25 = this.mAdViewEndTimeStamp;
            }
            long j26 = this.mAdLoadMethodEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
            if (this.mAdShowStartTimeStamp > 0) {
                j = this.mAdShowMethodStartTimeStamp;
            } else {
                j = j25;
            }
            long j27 = j - this.mAdLoadMethodEndTimeStamp;
            if (j27 < 0) {
                j27 = 0;
            }
            long j28 = this.mAdLoadIdleEndTimeStamp;
            if (j28 > 0 && j28 < j) {
                j3 = j - j28;
                j2 = j25;
            } else {
                j2 = j25;
                j3 = 0;
            }
            long j29 = this.mAdLoadHandlerEndTimeStamp;
            if (j29 < j && j29 > 0) {
                j4 = j - j29;
            } else {
                j4 = 0;
            }
            long j30 = this.mAdLoadHandlerEndTimeStamp;
            long j31 = j4;
            if (j30 < j) {
                long j32 = this.mAdLoadMethodEndTimeStamp;
                if (j30 > j32) {
                    j5 = j30 - j32;
                    j6 = this.mLoadBearEndTimeStamp;
                    long j33 = j5;
                    if (j6 <= 0) {
                        j7 = j6 - this.mAdPreLoadBearStartTimeStamp;
                    } else {
                        j7 = 0;
                    }
                    long j34 = this.mAdLoadMethodStartTimeStamp;
                    long j35 = j7;
                    long j36 = this.mAdPreLoadBearStartTimeStamp;
                    long j37 = j34 - j36;
                    long j38 = j27;
                    long j39 = this.mAdViewEndTimeStamp - j36;
                    j8 = this.mLoadPrologueEndTimeStamp;
                    if (j8 <= 0) {
                        j9 = j8 - j34;
                    } else {
                        j9 = 0;
                    }
                    j10 = this.mLoadBearEndTimeStamp;
                    if (j10 <= 0) {
                        j11 = j10 - this.mAdLoadMethodStartTimeStamp;
                    } else {
                        j11 = 0;
                    }
                    if (this.mAdShowStartTimeStamp <= 0 && this.mAdShowPolicySoEndStamp > 0) {
                        if ("5".equals(this.adSource)) {
                            long j40 = this.mAdShowPolicySoEndStamp;
                            j12 = j11;
                            long j41 = this.mLoadPrologueEndTimeStamp;
                            j14 = j40 - j41;
                            j13 = this.mAdShowMethodStartTimeStamp - j41;
                        } else {
                            j12 = j11;
                            if ("6".equals(this.adSource)) {
                                long j42 = this.mAdShowPolicySoEndStamp;
                                long j43 = this.mLoadBearEndTimeStamp;
                                j14 = j42 - j43;
                                j13 = this.mAdShowMethodStartTimeStamp - j43;
                            }
                        }
                        long j44 = j - this.mAdLoadMethodStartTimeStamp;
                        long j45 = j;
                        long j46 = j13;
                        if (this.mAdShowStartTimeStamp > 0) {
                            j15 = 1;
                        } else {
                            j15 = 0;
                        }
                        if (this.mAdShowStartTimeStamp > 0) {
                            j16 = j15;
                            j17 = this.mAdShowMethodEndTimeStamp - this.mAdShowMethodStartTimeStamp;
                        } else {
                            j16 = j15;
                            j17 = 0;
                        }
                        j18 = this.mAdShowStartTimeStamp;
                        long j47 = j9;
                        if (j18 > 0) {
                            j19 = j18 - this.mAdShowMethodEndTimeStamp;
                        } else {
                            j19 = 0;
                        }
                        j20 = this.mAdShowStartTimeStamp;
                        if (j20 > 0) {
                            j21 = j2 - j20;
                        } else {
                            j21 = 0;
                        }
                        j22 = this.mAdShowStartTimeStamp;
                        long j48 = j19;
                        if (j22 > 0) {
                            j23 = j22 - this.mAdShowMethodStartTimeStamp;
                        } else {
                            j23 = 0;
                        }
                        j24 = j2 - this.mAdLoadMethodStartTimeStamp;
                        long j49 = j44 + j23;
                        long j50 = j23;
                        this.mAdLoadCostPure = j26 + j3 + j17 + j48 + j21;
                        if (j24 >= 0 && j24 <= 60000 && j49 >= 0 && j49 <= 60000 && j26 >= 0 && j26 <= 60000 && j3 >= 0 && j3 <= 60000 && j47 >= 0 && j47 <= 60000 && j12 >= 0 && j12 <= 60000 && j44 >= 0 && j44 <= 60000 && j17 >= 0 && j17 <= 60000 && j48 >= 0 && j48 <= 60000 && j21 >= 0 && j21 <= 60000 && j50 >= 0 && j50 <= 60000) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(AD_WITH_SHOW_DURATION, String.valueOf(j24));
                            hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j49));
                            hashMap.put(AD_SHOW_SOURCE, String.valueOf(this.adSource));
                            hashMap.put(AD_LOAD_RESULT, String.valueOf(this.mAdLoadResult));
                            hashMap.put(IS_AD_SHOW_SOURCE, String.valueOf(j16));
                            if (this.isTimeout) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            hashMap.put(IS_AD_TIMEOUT, str);
                            if (this.isNeedBear) {
                                str2 = "1";
                            } else {
                                str2 = "0";
                            }
                            hashMap.put(IS_NEED_BEAR, str2);
                            if (this.isNeedPlg) {
                                str3 = "1";
                            } else {
                                str3 = "0";
                            }
                            hashMap.put(IS_NEED_PLG, str3);
                            hashMap.put(AD_FAIL_COUNT, String.valueOf(this.mFailCount));
                            hashMap.put(AD_NET_TYPE, this.mNetType);
                            if (this.mBearLoadResult) {
                                str4 = "1";
                            } else {
                                str4 = "0";
                            }
                            hashMap.put(AD_BEAR_LOAD_RESULT, str4);
                            if (this.mPlgLoadResult) {
                                str5 = "1";
                            } else {
                                str5 = "0";
                            }
                            hashMap.put(AD_PLG_LOAD_RESULT, str5);
                            String str6 = this.mPlgAdType;
                            if (str6 != null) {
                                hashMap.put(AD_PLG_AD_TYPE, str6);
                            }
                            hashMap.put(AD_LOAD_METHOD_DURATION, String.valueOf(j26));
                            hashMap.put(AD_WAIT_LOAD_DURATION, String.valueOf(j38));
                            hashMap.put(AD_LOAD_TOTAL_DURATION, String.valueOf(j44));
                            if (j16 == 1) {
                                hashMap.put(AD_SHOW_METHOD_DURATION, String.valueOf(j17));
                                hashMap.put(AD_WAIT_SHOW_DURATION, String.valueOf(j48));
                                hashMap.put(AD_SHOW_VIEW_DURATION, String.valueOf(j21));
                                hashMap.put(AD_SHOW_TOTAL_DURATION, String.valueOf(j50));
                            } else if (j39 > 0 && j39 < 60000) {
                                hashMap.put(AD_BEAR_REAL_TIMEOUT_DURATION, String.valueOf(j39));
                            }
                            hashMap.put(AD_LOAD_IDLE_DURATION, String.valueOf(j3));
                            hashMap.put(AD_LOAD_HANDLER_B_DURATION, String.valueOf(j31));
                            hashMap.put(AD_LOAD_HANDLER_A_DURATION, String.valueOf(j33));
                            if (i > 0 && i2 < 0) {
                                hashMap.put(AD_PROLOGUE_LOAD_DURATION, String.valueOf(j47));
                            }
                            if (i3 > 0 && i4 < 0) {
                                hashMap.put(AD_BEAR_LOAD_DURATION, String.valueOf(j12));
                            }
                            if (j14 > 0 && j14 < 60000) {
                                hashMap.put(AD_POLICY_SO_DURATION, String.valueOf(j14));
                            }
                            if (j46 > 0 && j46 < 60000) {
                                hashMap.put(AD_POST_SHOW_GAP_DURATION, String.valueOf(j46));
                            }
                            long j51 = this.mAdShowMethodStartTimeStamp - this.mSecondDrawDispatchedTimeStamp;
                            if (j51 > 0 && j51 < 60000) {
                                hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j51));
                            }
                            if (j35 > 0 && j35 < 60000) {
                                hashMap.put(AD_BEAR_REAL_LOAD_DURATION, String.valueOf(j35));
                            }
                            if (j37 > 0 && j37 < 60000) {
                                hashMap.put(AD_BEAR_PRE_LOAD_DURATION, String.valueOf(j37));
                            }
                            long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - j45;
                            if (appLaunchEndTimeStamp > 0 && appLaunchEndTimeStamp < 60000) {
                                hashMap.put(AD_TO_END_DURATION, String.valueOf(appLaunchEndTimeStamp));
                            }
                            synchronized (this.mLaunchTaskDuration) {
                                for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                                    hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                                }
                            }
                            JSONObject jsonData = SpeedStatsUtils.getJsonData(j49, hashMap);
                            if (jsonData != null) {
                                try {
                                    jSONObject.put(SpeedStatsMainTable.AD_SHOW, jsonData);
                                    return true;
                                } catch (JSONException e) {
                                    if (AppConfig.isDebug()) {
                                        e.printStackTrace();
                                        return true;
                                    }
                                    return true;
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                    j12 = j11;
                    j13 = 0;
                    j14 = 0;
                    long j442 = j - this.mAdLoadMethodStartTimeStamp;
                    long j452 = j;
                    long j462 = j13;
                    if (this.mAdShowStartTimeStamp > 0) {
                    }
                    if (this.mAdShowStartTimeStamp > 0) {
                    }
                    j18 = this.mAdShowStartTimeStamp;
                    long j472 = j9;
                    if (j18 > 0) {
                    }
                    j20 = this.mAdShowStartTimeStamp;
                    if (j20 > 0) {
                    }
                    j22 = this.mAdShowStartTimeStamp;
                    long j482 = j19;
                    if (j22 > 0) {
                    }
                    j24 = j2 - this.mAdLoadMethodStartTimeStamp;
                    long j492 = j442 + j23;
                    long j502 = j23;
                    this.mAdLoadCostPure = j26 + j3 + j17 + j482 + j21;
                    return j24 >= 0 ? false : false;
                }
            }
            j5 = 0;
            j6 = this.mLoadBearEndTimeStamp;
            long j332 = j5;
            if (j6 <= 0) {
            }
            long j342 = this.mAdLoadMethodStartTimeStamp;
            long j352 = j7;
            long j362 = this.mAdPreLoadBearStartTimeStamp;
            long j372 = j342 - j362;
            long j382 = j27;
            long j392 = this.mAdViewEndTimeStamp - j362;
            j8 = this.mLoadPrologueEndTimeStamp;
            if (j8 <= 0) {
            }
            j10 = this.mLoadBearEndTimeStamp;
            if (j10 <= 0) {
            }
            if (this.mAdShowStartTimeStamp <= 0) {
            }
            j12 = j11;
            j13 = 0;
            j14 = 0;
            long j4422 = j - this.mAdLoadMethodStartTimeStamp;
            long j4522 = j;
            long j4622 = j13;
            if (this.mAdShowStartTimeStamp > 0) {
            }
            if (this.mAdShowStartTimeStamp > 0) {
            }
            j18 = this.mAdShowStartTimeStamp;
            long j4722 = j9;
            if (j18 > 0) {
            }
            j20 = this.mAdShowStartTimeStamp;
            if (j20 > 0) {
            }
            j22 = this.mAdShowStartTimeStamp;
            long j4822 = j19;
            if (j22 > 0) {
            }
            j24 = j2 - this.mAdLoadMethodStartTimeStamp;
            long j4922 = j4422 + j23;
            long j5022 = j23;
            this.mAdLoadCostPure = j26 + j3 + j17 + j4822 + j21;
            if (j24 >= 0) {
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public void setAdFailCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mFailCount = i;
        }
    }

    public void setAdLoadResult(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || this.mAdLoadResult > 0) {
            return;
        }
        this.mAdLoadResult = i;
    }

    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.adSource = str;
        }
    }

    public void setBearLoadResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mBearLoadResult = z;
        }
    }

    public void setIsNeedBear(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isNeedBear = z;
        }
    }

    public void setIsNeedPlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isNeedPlg = z;
        }
    }

    public void setIsTimeout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.isTimeout = z;
        }
    }

    public void setPlgAdType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mPlgAdType = str;
        }
    }

    public void setPlgLoadResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mPlgLoadResult = z;
        }
    }
}
