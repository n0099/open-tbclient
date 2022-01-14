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
/* loaded from: classes11.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_DO_SHOW_DURATION = "adDoShow";
    public static final String AD_DURATION = "adDuration";
    public static final String AD_NO_SHOW_DURATION = "adNoShowDuration";
    public static final String AD_SHOW_DURATION = "adShow";
    public static final String AD_SHOW_SOURCE_DURATION = "adShowSource";
    public static final String AD_TB_LOADAD_DURATION = "tbAdLoad";
    public static final String AD_WILL_SHOW_DURATION = "adWillShow";
    public static final String AD_XIAOXIONG_LOADAD_DURATION = "xiaoxiongAdLoad";
    public static final String AD_XUZHANG_LOADAD_DURATION = "xuzhangAdLoad";
    public static final String DRAW_DONE_2_AD_SHOW_GAP = "draw2AdShow";
    public static final String HAS_AD_DURATION = "hasAdDuration";
    public static final String NO_AD_DURATION = "noAdDuration";
    public static final String SDK_AD_LOAD_DURATION = "SdkAdLoad";
    public transient /* synthetic */ FieldHolder $fh;
    public String adSource;
    public long mAdShowEndTimeStamp;
    public long mAdShowStartTimeStamp;
    public long mAdStartTimeStamp;
    public long mAdViewEndTimeStamp;
    public long mSdkAdDoShowTimeStamp;
    public long mSdkAdWillShowTimeStamp;
    public long mSecondDrawDispatchedTimeStamp;
    public long mTbAdloadEndTimeStamp;
    public long mXiaoxiongAdloadEndTimeStamp;
    public long mXuzhangAdloadEndTimeStamp;

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
        this.adSource = "0";
        this.mAdStartTimeStamp = -1L;
        this.mTbAdloadEndTimeStamp = -1L;
        this.mSdkAdDoShowTimeStamp = -1L;
        this.mSdkAdWillShowTimeStamp = -1L;
        this.mAdShowStartTimeStamp = -1L;
        this.mAdShowEndTimeStamp = -1L;
        this.mAdViewEndTimeStamp = -1L;
        this.mSecondDrawDispatchedTimeStamp = -1L;
        this.mXuzhangAdloadEndTimeStamp = -1L;
        this.mXiaoxiongAdloadEndTimeStamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.addStatsTimeStamp(i2, j2);
            if (i2 != 5054) {
                switch (i2) {
                    case SpeedStatsStampTable.AD_START_STAMP_KEY /* 3301 */:
                        this.mAdStartTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY /* 3302 */:
                        this.mTbAdloadEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SDK_WILL_SHOW_STAMP_KEY /* 3303 */:
                        this.mSdkAdWillShowTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SDK_DO_SHOW_STAMP_KEY /* 3304 */:
                        this.mSdkAdDoShowTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY /* 3305 */:
                        this.mAdShowStartTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY /* 3306 */:
                        this.mAdShowEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY /* 3307 */:
                        this.mAdViewEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_XUZHANG_LOAD_END_STAMP_KEY /* 3308 */:
                        this.mXuzhangAdloadEndTimeStamp = j2;
                        return;
                    case SpeedStatsStampTable.AD_XIAOXIONG_LOAD_END_STAMP_KEY /* 3309 */:
                        this.mXiaoxiongAdloadEndTimeStamp = j2;
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

    public long getDurationWithoutAD(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j12 = this.mAdShowEndTimeStamp;
            if (j12 < 0) {
                j12 = this.mAdViewEndTimeStamp;
            }
            long j13 = this.mAdStartTimeStamp;
            long j14 = j12 - j13;
            long j15 = this.mTbAdloadEndTimeStamp;
            long j16 = j15 - j13;
            long j17 = this.mXuzhangAdloadEndTimeStamp;
            long j18 = j17 > 0 ? j17 - j15 : 0L;
            long j19 = this.mXiaoxiongAdloadEndTimeStamp;
            long j20 = j12;
            long j21 = j19 > 0 ? j19 - this.mTbAdloadEndTimeStamp : 0L;
            long j22 = this.mAdShowStartTimeStamp;
            if (j22 > 0) {
                long j23 = this.mSdkAdWillShowTimeStamp;
                j2 = j21;
                long j24 = this.mTbAdloadEndTimeStamp;
                long j25 = j23 - j24;
                j3 = j18;
                long j26 = this.mSdkAdDoShowTimeStamp;
                long j27 = j26 - j23;
                long j28 = j22 - j26;
                long j29 = j20 - j22;
                j6 = j22 - j24;
                long j30 = j14 - j29;
                j11 = j25;
                j9 = 0;
                j10 = j29;
                j8 = j28;
                j5 = j30;
                j7 = j27;
                j4 = 0;
            } else {
                j2 = j21;
                j3 = j18;
                j4 = j20 - this.mTbAdloadEndTimeStamp;
                j5 = j14;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
                j10 = 0;
                j11 = 0;
            }
            if (j14 < j9 || j14 > 60000 || j16 < j9 || j16 > 60000 || j11 < j9 || j11 > 60000 || j7 < j9 || j7 > 60000 || j8 < j9 || j8 > 60000 || j10 < j9 || j10 > 60000 || j6 < j9 || j6 > 60000 || j4 < j9 || j4 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AD_DURATION, String.valueOf(j14));
            hashMap.put(AD_TB_LOADAD_DURATION, String.valueOf(j16));
            hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j5));
            hashMap.put(AD_SHOW_SOURCE_DURATION, String.valueOf(this.adSource));
            hashMap.put(AD_XUZHANG_LOADAD_DURATION, String.valueOf(j3));
            hashMap.put(AD_XIAOXIONG_LOADAD_DURATION, String.valueOf(j2));
            if (this.mAdShowStartTimeStamp > 0) {
                hashMap.put(SDK_AD_LOAD_DURATION, String.valueOf(j11));
                hashMap.put(AD_WILL_SHOW_DURATION, String.valueOf(j7));
                hashMap.put(AD_DO_SHOW_DURATION, String.valueOf(j8));
                hashMap.put(AD_SHOW_DURATION, String.valueOf(j10));
                hashMap.put(HAS_AD_DURATION, String.valueOf(j6));
            } else {
                hashMap.put(NO_AD_DURATION, String.valueOf(j4));
            }
            long j31 = this.mSdkAdDoShowTimeStamp - this.mSecondDrawDispatchedTimeStamp;
            if (j31 > 0 && j31 < 60000) {
                hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j31));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j5, hashMap);
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mAdStartTimeStamp = -1L;
            this.mTbAdloadEndTimeStamp = -1L;
            this.mSdkAdWillShowTimeStamp = -1L;
            this.mAdShowStartTimeStamp = -1L;
            this.mAdShowEndTimeStamp = -1L;
            this.mAdViewEndTimeStamp = -1L;
            this.mSecondDrawDispatchedTimeStamp = -1L;
        }
    }

    public void setAdSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.adSource = str;
        }
    }
}
