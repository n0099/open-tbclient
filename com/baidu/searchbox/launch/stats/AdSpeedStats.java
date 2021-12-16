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
/* loaded from: classes10.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_DO_SHOW_DURATION = "adDoShow";
    public static final String AD_DURATION = "adDuration";
    public static final String AD_NO_SHOW_DURATION = "adNoShowDuration";
    public static final String AD_SHOW_DURATION = "adShow";
    public static final String AD_TB_LOADAD_DURATION = "tbAdLoad";
    public static final String AD_WILL_SHOW_DURATION = "adWillShow";
    public static final String DRAW_DONE_2_AD_SHOW_GAP = "draw2AdShow";
    public static final String HAS_AD_DURATION = "hasAdDuration";
    public static final String NO_AD_DURATION = "noAdDuration";
    public static final String SDK_AD_LOAD_DURATION = "SdkAdLoad";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAdShowEndTimeStamp;
    public long mAdShowStartTimeStamp;
    public long mAdStartTimeStamp;
    public long mAdViewEndTimeStamp;
    public long mSdkAdDoShowTimeStamp;
    public long mSdkAdWillShowTimeStamp;
    public long mSecondDrawDispatchedTimeStamp;
    public long mTbAdloadEndTimeStamp;

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
        this.mAdStartTimeStamp = -1L;
        this.mTbAdloadEndTimeStamp = -1L;
        this.mSdkAdDoShowTimeStamp = -1L;
        this.mSdkAdWillShowTimeStamp = -1L;
        this.mAdShowStartTimeStamp = -1L;
        this.mAdShowEndTimeStamp = -1L;
        this.mAdViewEndTimeStamp = -1L;
        this.mSecondDrawDispatchedTimeStamp = -1L;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j10 = this.mAdShowEndTimeStamp;
            if (j10 < 0) {
                j10 = this.mAdViewEndTimeStamp;
            }
            long j11 = this.mAdStartTimeStamp;
            long j12 = j10 - j11;
            long j13 = this.mTbAdloadEndTimeStamp;
            long j14 = j13 - j11;
            long j15 = this.mAdShowStartTimeStamp;
            if (j15 > 0) {
                long j16 = this.mSdkAdWillShowTimeStamp;
                long j17 = j16 - j13;
                long j18 = this.mSdkAdDoShowTimeStamp;
                long j19 = j18 - j16;
                j4 = j15 - j18;
                long j20 = j10 - j15;
                long j21 = j15 - j13;
                long j22 = j12 - j20;
                j9 = j20;
                j7 = 0;
                j8 = j17;
                j3 = j22;
                j6 = j21;
                j5 = j19;
                j2 = 0;
            } else {
                j2 = j10 - j13;
                j3 = j12;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
                j9 = 0;
            }
            if (j12 < j7 || j12 > 60000 || j14 < j7 || j14 > 60000 || j8 < j7 || j8 > 60000 || j5 < j7 || j5 > 60000 || j4 < j7 || j4 > 60000 || j9 < j7 || j9 > 60000 || j6 < j7 || j6 > 60000 || j2 < j7 || j2 > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AD_DURATION, String.valueOf(j12));
            hashMap.put(AD_TB_LOADAD_DURATION, String.valueOf(j14));
            hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j3));
            if (this.mAdShowStartTimeStamp > 0) {
                hashMap.put(SDK_AD_LOAD_DURATION, String.valueOf(j8));
                hashMap.put(AD_WILL_SHOW_DURATION, String.valueOf(j5));
                hashMap.put(AD_DO_SHOW_DURATION, String.valueOf(j4));
                hashMap.put(AD_SHOW_DURATION, String.valueOf(j9));
                hashMap.put(HAS_AD_DURATION, String.valueOf(j6));
            } else {
                hashMap.put(NO_AD_DURATION, String.valueOf(j2));
            }
            long j23 = this.mSdkAdDoShowTimeStamp - this.mSecondDrawDispatchedTimeStamp;
            if (j23 > 0 && j23 < 60000) {
                hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j23));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j3, hashMap);
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
}
