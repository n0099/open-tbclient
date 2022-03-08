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
/* loaded from: classes4.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_BEAR_LOAD_DURATION = "bearLoad";
    public static final String AD_LOAD_HANDLER_A_DURATION = "loadHandlerA";
    public static final String AD_LOAD_HANDLER_B_DURATION = "loadHandlerB";
    public static final String AD_LOAD_IDLE_DURATION = "loadIdle";
    public static final String AD_LOAD_METHOD_DURATION = "loadMethod";
    public static final String AD_LOAD_TOTAL_DURATION = "loadTotal";
    public static final String AD_NO_SHOW_DURATION = "adDurNoShow";
    public static final String AD_PROLOGUE_LOAD_DURATION = "prologueLoad";
    public static final String AD_SHOW_METHOD_DURATION = "showMethod";
    public static final String AD_SHOW_SOURCE = "adShowSource";
    public static final String AD_SHOW_TOTAL_DURATION = "showTotal";
    public static final String AD_SHOW_VIEW_DURATION = "adShowView";
    public static final String AD_WAIT_LOAD_DURATION = "waitLoad";
    public static final String AD_WAIT_SHOW_DURATION = "waitShow";
    public static final String AD_WITH_SHOW_DURATION = "adDurWithShow";
    public static final String DRAW_DONE_2_AD_SHOW_GAP = "draw2AdShow";
    public static final String IS_AD_SHOW_SOURCE = "isAdShow";
    public transient /* synthetic */ FieldHolder $fh;
    public String adSource;
    public long mAdLoadCostPure;
    public long mAdLoadHandlerEndTimeStamp;
    public long mAdLoadIdleEndTimeStamp;
    public long mAdLoadMethodEndTimeStamp;
    public long mAdLoadMethodStartTimeStamp;
    public long mAdShowEndTimeStamp;
    public long mAdShowMethodEndTimeStamp;
    public long mAdShowMethodStartTimeStamp;
    public long mAdShowStartTimeStamp;
    public long mAdViewEndTimeStamp;
    public long mLoadBearEndTimeStamp;
    public long mLoadPrologueEndTimeStamp;
    public long mSecondDrawDispatchedTimeStamp;

    public AdSpeedStats() {
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
        this.adSource = "0";
        this.mAdLoadCostPure = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            if (i2 != 5054) {
                switch (i2) {
                    case SpeedStatsStampTable.AD_LOAD_START_STAMP_KEY /* 3301 */:
                        this.mAdLoadMethodStartTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_END_STAMP_KEY /* 3302 */:
                        this.mAdLoadMethodEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_PROLOGUE_END_STAMP_KEY /* 3303 */:
                        this.mLoadPrologueEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                        this.mLoadBearEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_IDLE_END_STAMP_KEY /* 3305 */:
                        this.mAdLoadIdleEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_LOAD_HANDLER_END_STAMP_KEY /* 3306 */:
                        this.mAdLoadHandlerEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY /* 3307 */:
                        this.mAdShowMethodStartTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY /* 3308 */:
                        this.mAdShowMethodEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY /* 3309 */:
                        this.mAdShowStartTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY /* 3310 */:
                        this.mAdShowEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY /* 3311 */:
                        this.mAdViewEndTimeStamp = j2;
                        return;
                    default:
                        return;
                }
            }
            this.mSecondDrawDispatchedTimeStamp = j2;
        }
    }

    public long getAdShowDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mAdShowStartTimeStamp <= 0) {
                return 0L;
            }
            long j2 = this.mAdShowEndTimeStamp;
            if (j2 < 0) {
                j2 = this.mAdViewEndTimeStamp;
            }
            return j2 - this.mAdShowStartTimeStamp;
        }
        return invokeV.longValue;
    }

    public long getAdTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mAdLoadCostPure == -1) {
                packData(new JSONObject());
            }
            return this.mAdLoadCostPure;
        }
        return invokeV.longValue;
    }

    public long getDurationWithoutAD(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = this.mAdShowEndTimeStamp;
            if (this.mAdShowStartTimeStamp > 0 && j4 < 0) {
                j4 = this.mAdViewEndTimeStamp;
            }
            long j5 = this.mAdShowStartTimeStamp;
            if (j5 <= 0 || j5 >= j3 || j4 <= j2) {
                return j3 - j2;
            }
            if (j5 > j2 || j4 < j3) {
                long j6 = this.mAdShowStartTimeStamp;
                if (j6 <= j2 || j4 >= j3) {
                    if (this.mAdShowStartTimeStamp > j2 || j4 >= j3) {
                        long j7 = this.mAdShowStartTimeStamp;
                        return (j7 <= j2 || j4 < j3) ? j3 - j2 : j7 - j2;
                    }
                    return j3 - j4;
                }
                return (j3 - j2) - (j4 - j6);
            }
            return 0L;
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef  */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean packData(JSONObject jSONObject) {
        InterceptResult invokeL;
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
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j12 = this.mAdShowEndTimeStamp;
            if (j12 < 0) {
                j12 = this.mAdViewEndTimeStamp;
            }
            long j13 = this.mAdLoadMethodEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
            long j14 = this.mAdShowStartTimeStamp > 0 ? this.mAdShowMethodStartTimeStamp : j12;
            long j15 = j14 - this.mAdLoadMethodEndTimeStamp;
            if (j15 < 0) {
                j15 = 0;
            }
            long j16 = this.mAdLoadIdleEndTimeStamp;
            if (j16 <= 0 || j16 >= j14) {
                j2 = j12;
                j3 = 0;
            } else {
                j3 = j14 - j16;
                j2 = j12;
            }
            long j17 = this.mAdLoadHandlerEndTimeStamp;
            long j18 = (j17 >= j14 || j17 <= 0) ? 0L : j14 - j17;
            long j19 = this.mAdLoadHandlerEndTimeStamp;
            long j20 = j18;
            if (j19 < j14) {
                long j21 = this.mAdLoadMethodEndTimeStamp;
                if (j19 > j21) {
                    j4 = j19 - j21;
                    if (this.mAdShowStartTimeStamp > 0 || !"5".equals(this.adSource)) {
                        j5 = j4;
                        j6 = 0;
                    } else {
                        j5 = j4;
                        j6 = this.mLoadPrologueEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
                    }
                    if (this.mAdShowStartTimeStamp > 0 || !"6".equals(this.adSource)) {
                        j7 = j15;
                        j8 = 0;
                    } else {
                        j7 = j15;
                        j8 = this.mLoadBearEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
                    }
                    long j22 = j14 - this.mAdLoadMethodStartTimeStamp;
                    long j23 = this.mAdShowStartTimeStamp <= 0 ? 1L : 0L;
                    if (this.mAdShowStartTimeStamp <= 0) {
                        j9 = j8;
                        j10 = this.mAdShowMethodEndTimeStamp - this.mAdShowMethodStartTimeStamp;
                    } else {
                        j9 = j8;
                        j10 = 0;
                    }
                    long j24 = this.mAdShowStartTimeStamp;
                    long j25 = j6;
                    long j26 = j24 <= 0 ? j24 - this.mAdShowMethodEndTimeStamp : 0L;
                    long j27 = this.mAdShowStartTimeStamp;
                    long j28 = j27 <= 0 ? j2 - j27 : 0L;
                    long j29 = this.mAdShowStartTimeStamp;
                    long j30 = j26;
                    long j31 = j29 <= 0 ? j29 - this.mAdShowMethodStartTimeStamp : 0L;
                    j11 = j2 - this.mAdLoadMethodStartTimeStamp;
                    long j32 = j22 + j31;
                    long j33 = j31;
                    this.mAdLoadCostPure = j13 + j3 + j10 + j30 + j28;
                    if (j11 >= 0 || j11 > 60000 || j32 < 0 || j32 > 60000 || j13 < 0 || j13 > 60000 || j3 < 0 || j3 > 60000 || j25 < 0 || j25 > 60000 || j9 < 0 || j9 > 60000 || j22 < 0 || j22 > 60000 || j10 < 0 || j10 > 60000 || j30 < 0 || j30 > 60000 || j28 < 0 || j28 > 60000 || j33 < 0 || j33 > 60000) {
                        return false;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(AD_WITH_SHOW_DURATION, String.valueOf(j11));
                    hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j32));
                    hashMap.put(AD_SHOW_SOURCE, String.valueOf(this.adSource));
                    hashMap.put(IS_AD_SHOW_SOURCE, String.valueOf(j23));
                    hashMap.put(AD_LOAD_METHOD_DURATION, String.valueOf(j13));
                    hashMap.put(AD_WAIT_LOAD_DURATION, String.valueOf(j7));
                    hashMap.put(AD_LOAD_TOTAL_DURATION, String.valueOf(j22));
                    hashMap.put(AD_SHOW_METHOD_DURATION, String.valueOf(j10));
                    hashMap.put(AD_WAIT_SHOW_DURATION, String.valueOf(j30));
                    hashMap.put(AD_SHOW_VIEW_DURATION, String.valueOf(j28));
                    hashMap.put(AD_SHOW_TOTAL_DURATION, String.valueOf(j33));
                    hashMap.put(AD_LOAD_IDLE_DURATION, String.valueOf(j3));
                    hashMap.put(AD_LOAD_HANDLER_B_DURATION, String.valueOf(j20));
                    hashMap.put(AD_LOAD_HANDLER_A_DURATION, String.valueOf(j5));
                    if (i2 > 0 && i3 < 0) {
                        hashMap.put(AD_PROLOGUE_LOAD_DURATION, String.valueOf(j25));
                    }
                    if (i4 > 0 && i5 < 0) {
                        hashMap.put(AD_BEAR_LOAD_DURATION, String.valueOf(j9));
                    }
                    long j34 = this.mAdShowMethodStartTimeStamp - this.mSecondDrawDispatchedTimeStamp;
                    if (j34 > 0 && j34 < 60000) {
                        hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j34));
                    }
                    JSONObject jsonData = SpeedStatsUtils.getJsonData(j32, hashMap);
                    if (jsonData != null) {
                        try {
                            jSONObject.put(SpeedStatsMainTable.AD_SHOW, jsonData);
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
            }
            j4 = 0;
            if (this.mAdShowStartTimeStamp > 0) {
            }
            j5 = j4;
            j6 = 0;
            if (this.mAdShowStartTimeStamp > 0) {
            }
            j7 = j15;
            j8 = 0;
            long j222 = j14 - this.mAdLoadMethodStartTimeStamp;
            if (this.mAdShowStartTimeStamp <= 0) {
            }
            if (this.mAdShowStartTimeStamp <= 0) {
            }
            long j242 = this.mAdShowStartTimeStamp;
            long j252 = j6;
            if (j242 <= 0) {
            }
            long j272 = this.mAdShowStartTimeStamp;
            if (j272 <= 0) {
            }
            long j292 = this.mAdShowStartTimeStamp;
            long j302 = j26;
            if (j292 <= 0) {
            }
            j11 = j2 - this.mAdLoadMethodStartTimeStamp;
            long j322 = j222 + j31;
            long j332 = j31;
            this.mAdLoadCostPure = j13 + j3 + j10 + j302 + j28;
            return j11 >= 0 ? false : false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.adSource = str;
        }
    }
}
