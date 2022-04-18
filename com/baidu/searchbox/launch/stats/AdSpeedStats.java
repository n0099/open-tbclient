package com.baidu.searchbox.launch.stats;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_BEAR_LOAD_DURATION = "bearLoad";
    public static final String AD_FAIL_COUNT = "adFailCount";
    public static final String AD_LOAD_HANDLER_A_DURATION = "loadHandlerA";
    public static final String AD_LOAD_HANDLER_B_DURATION = "loadHandlerB";
    public static final String AD_LOAD_IDLE_DURATION = "loadIdle";
    public static final String AD_LOAD_METHOD_DURATION = "loadMethod";
    public static final String AD_LOAD_RESULT = "adResult";
    public static final String AD_LOAD_TOTAL_DURATION = "loadTotal";
    public static final String AD_NET_TYPE = "adNetType";
    public static final String AD_NO_SHOW_DURATION = "adDurNoShow";
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
    public long mAdShowEndTimeStamp;
    public long mAdShowMethodEndTimeStamp;
    public long mAdShowMethodStartTimeStamp;
    public long mAdShowPolicySoEndStamp;
    public long mAdShowStartTimeStamp;
    public long mAdViewEndTimeStamp;
    public int mFailCount;
    public HashMap<String, Long> mLaunchTaskDuration;
    public long mLoadBearEndTimeStamp;
    public long mLoadPrologueEndTimeStamp;
    public int mLoadResult;
    public String mNetType;
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
        this.adSource = "0";
        this.mLoadResult = 0;
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
                        this.mNetType = mi.m();
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
                    default:
                        return;
                }
            }
            this.mSecondDrawDispatchedTimeStamp = j;
        }
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

    public long getDurationWithoutAD(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j > j2) {
                return 0L;
            }
            long j3 = this.mAdShowEndTimeStamp;
            if (this.mAdShowStartTimeStamp > 0 && j3 < 0) {
                j3 = this.mAdViewEndTimeStamp;
            }
            long j4 = this.mAdShowStartTimeStamp;
            if (j4 <= 0 || j4 >= j2 || j3 <= j) {
                return j2 - j;
            }
            if (j4 > j || j3 < j2) {
                long j5 = this.mAdShowStartTimeStamp;
                if (j5 <= j || j3 >= j2) {
                    if (this.mAdShowStartTimeStamp > j || j3 >= j2) {
                        long j6 = this.mAdShowStartTimeStamp;
                        return (j6 <= j || j3 < j2) ? j2 - j : j6 - j;
                    }
                    return j2 - j3;
                }
                return (j2 - j) - (j3 - j5);
            }
            return 0L;
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x0313 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132  */
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
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, jSONObject)) != null) {
            return invokeL.booleanValue;
        }
        super.packData(jSONObject);
        if (jSONObject == null) {
            return false;
        }
        long j11 = this.mAdShowEndTimeStamp;
        if (j11 < 0) {
            j11 = this.mAdViewEndTimeStamp;
        }
        long j12 = this.mAdLoadMethodEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
        long j13 = this.mAdShowStartTimeStamp > 0 ? this.mAdShowMethodStartTimeStamp : j11;
        long j14 = j13 - this.mAdLoadMethodEndTimeStamp;
        if (j14 < 0) {
            j14 = 0;
        }
        long j15 = this.mAdLoadIdleEndTimeStamp;
        if (j15 <= 0 || j15 >= j13) {
            j = j11;
            j2 = 0;
        } else {
            j2 = j13 - j15;
            j = j11;
        }
        long j16 = this.mAdLoadHandlerEndTimeStamp;
        long j17 = (j16 >= j13 || j16 <= 0) ? 0L : j13 - j16;
        long j18 = this.mAdLoadHandlerEndTimeStamp;
        long j19 = j17;
        if (j18 < j13) {
            long j20 = this.mAdLoadMethodEndTimeStamp;
            if (j18 > j20) {
                j3 = j18 - j20;
                long j21 = this.mLoadPrologueEndTimeStamp;
                long j22 = j3;
                long j23 = j21 <= 0 ? j21 - this.mAdLoadMethodStartTimeStamp : 0L;
                long j24 = this.mLoadBearEndTimeStamp;
                long j25 = j14;
                j4 = j24 <= 0 ? j24 - this.mAdLoadMethodStartTimeStamp : 0L;
                if (this.mAdShowStartTimeStamp <= 0 && this.mAdShowPolicySoEndStamp > 0) {
                    if ("5".equals(this.adSource)) {
                        long j26 = this.mAdShowPolicySoEndStamp;
                        j5 = j4;
                        long j27 = this.mLoadPrologueEndTimeStamp;
                        j7 = j26 - j27;
                        j6 = this.mAdShowMethodStartTimeStamp - j27;
                    } else {
                        j5 = j4;
                        if ("6".equals(this.adSource)) {
                            long j28 = this.mAdShowPolicySoEndStamp;
                            long j29 = this.mLoadBearEndTimeStamp;
                            j7 = j28 - j29;
                            j6 = this.mAdShowMethodStartTimeStamp - j29;
                        }
                    }
                    long j30 = j13 - this.mAdLoadMethodStartTimeStamp;
                    long j31 = j13;
                    long j32 = j6;
                    long j33 = this.mAdShowStartTimeStamp > 0 ? 1L : 0L;
                    if (this.mAdShowStartTimeStamp > 0) {
                        j8 = j33;
                        j9 = this.mAdShowMethodEndTimeStamp - this.mAdShowMethodStartTimeStamp;
                    } else {
                        j8 = j33;
                        j9 = 0;
                    }
                    long j34 = this.mAdShowStartTimeStamp;
                    long j35 = j23;
                    long j36 = j34 > 0 ? j34 - this.mAdShowMethodEndTimeStamp : 0L;
                    long j37 = this.mAdShowStartTimeStamp;
                    long j38 = j37 > 0 ? j - j37 : 0L;
                    long j39 = this.mAdShowStartTimeStamp;
                    long j40 = j36;
                    long j41 = j39 > 0 ? j39 - this.mAdShowMethodStartTimeStamp : 0L;
                    j10 = j - this.mAdLoadMethodStartTimeStamp;
                    long j42 = j30 + j41;
                    long j43 = j41;
                    this.mAdLoadCostPure = j12 + j2 + j9 + j40 + j38;
                    if (j10 < 0 || j10 > 60000 || j42 < 0 || j42 > 60000 || j12 < 0 || j12 > 60000 || j2 < 0 || j2 > 60000 || j35 < 0 || j35 > 60000 || j5 < 0 || j5 > 60000 || j30 < 0 || j30 > 60000 || j9 < 0 || j9 > 60000 || j40 < 0 || j40 > 60000 || j38 < 0 || j38 > 60000 || j43 < 0 || j43 > 60000) {
                        return false;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(AD_WITH_SHOW_DURATION, String.valueOf(j10));
                    hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j42));
                    hashMap.put(AD_SHOW_SOURCE, String.valueOf(this.adSource));
                    hashMap.put(AD_LOAD_RESULT, String.valueOf(this.mLoadResult));
                    hashMap.put(IS_AD_SHOW_SOURCE, String.valueOf(j8));
                    hashMap.put(IS_AD_TIMEOUT, this.isTimeout ? "1" : "0");
                    hashMap.put(IS_NEED_BEAR, this.isNeedBear ? "1" : "0");
                    hashMap.put(IS_NEED_PLG, this.isNeedPlg ? "1" : "0");
                    hashMap.put(AD_FAIL_COUNT, String.valueOf(this.mFailCount));
                    hashMap.put(AD_NET_TYPE, this.mNetType);
                    hashMap.put(AD_LOAD_METHOD_DURATION, String.valueOf(j12));
                    hashMap.put(AD_WAIT_LOAD_DURATION, String.valueOf(j25));
                    hashMap.put(AD_LOAD_TOTAL_DURATION, String.valueOf(j30));
                    if (j8 == 1) {
                        hashMap.put(AD_SHOW_METHOD_DURATION, String.valueOf(j9));
                        hashMap.put(AD_WAIT_SHOW_DURATION, String.valueOf(j40));
                        hashMap.put(AD_SHOW_VIEW_DURATION, String.valueOf(j38));
                        hashMap.put(AD_SHOW_TOTAL_DURATION, String.valueOf(j43));
                    }
                    hashMap.put(AD_LOAD_IDLE_DURATION, String.valueOf(j2));
                    hashMap.put(AD_LOAD_HANDLER_B_DURATION, String.valueOf(j19));
                    hashMap.put(AD_LOAD_HANDLER_A_DURATION, String.valueOf(j22));
                    if (i > 0 && i2 < 0) {
                        hashMap.put(AD_PROLOGUE_LOAD_DURATION, String.valueOf(j35));
                    }
                    if (i3 > 0 && i4 < 0) {
                        hashMap.put(AD_BEAR_LOAD_DURATION, String.valueOf(j5));
                    }
                    if (j7 > 0 && j7 < 60000) {
                        hashMap.put(AD_POLICY_SO_DURATION, String.valueOf(j7));
                    }
                    if (j32 > 0 && j32 < 60000) {
                        hashMap.put(AD_POST_SHOW_GAP_DURATION, String.valueOf(j32));
                    }
                    long j44 = this.mAdShowMethodStartTimeStamp - this.mSecondDrawDispatchedTimeStamp;
                    if (j44 > 0 && j44 < 60000) {
                        hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j44));
                    }
                    long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - j31;
                    if (appLaunchEndTimeStamp > 0 && appLaunchEndTimeStamp < 60000) {
                        hashMap.put(AD_TO_END_DURATION, String.valueOf(appLaunchEndTimeStamp));
                    }
                    synchronized (this.mLaunchTaskDuration) {
                        for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                            hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                        }
                    }
                    JSONObject jsonData = SpeedStatsUtils.getJsonData(j42, hashMap);
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
                j5 = j4;
                j6 = 0;
                j7 = 0;
                long j302 = j13 - this.mAdLoadMethodStartTimeStamp;
                long j312 = j13;
                long j322 = j6;
                if (this.mAdShowStartTimeStamp > 0) {
                }
                if (this.mAdShowStartTimeStamp > 0) {
                }
                long j342 = this.mAdShowStartTimeStamp;
                long j352 = j23;
                if (j342 > 0) {
                }
                long j372 = this.mAdShowStartTimeStamp;
                if (j372 > 0) {
                }
                long j392 = this.mAdShowStartTimeStamp;
                long j402 = j36;
                if (j392 > 0) {
                }
                j10 = j - this.mAdLoadMethodStartTimeStamp;
                long j422 = j302 + j41;
                long j432 = j41;
                this.mAdLoadCostPure = j12 + j2 + j9 + j402 + j38;
                return j10 < 0 ? false : false;
            }
        }
        j3 = 0;
        long j212 = this.mLoadPrologueEndTimeStamp;
        long j222 = j3;
        if (j212 <= 0) {
        }
        long j242 = this.mLoadBearEndTimeStamp;
        long j252 = j14;
        if (j242 <= 0) {
        }
        if (this.mAdShowStartTimeStamp <= 0) {
        }
        j5 = j4;
        j6 = 0;
        j7 = 0;
        long j3022 = j13 - this.mAdLoadMethodStartTimeStamp;
        long j3122 = j13;
        long j3222 = j6;
        if (this.mAdShowStartTimeStamp > 0) {
        }
        if (this.mAdShowStartTimeStamp > 0) {
        }
        long j3422 = this.mAdShowStartTimeStamp;
        long j3522 = j23;
        if (j3422 > 0) {
        }
        long j3722 = this.mAdShowStartTimeStamp;
        if (j3722 > 0) {
        }
        long j3922 = this.mAdShowStartTimeStamp;
        long j4022 = j36;
        if (j3922 > 0) {
        }
        j10 = j - this.mAdLoadMethodStartTimeStamp;
        long j4222 = j3022 + j41;
        long j4322 = j41;
        this.mAdLoadCostPure = j12 + j2 + j9 + j4022 + j38;
        if (j10 < 0) {
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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

    public void setAdFailCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mFailCount = i;
        }
    }

    public void setAdLoadResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mLoadResult = i;
        }
    }

    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.adSource = str;
        }
    }

    public void setIsNeedBear(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.isNeedBear = z;
        }
    }

    public void setIsNeedPlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.isNeedPlg = z;
        }
    }

    public void setIsTimeout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isTimeout = z;
        }
    }
}
