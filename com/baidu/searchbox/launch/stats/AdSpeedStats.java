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
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i2, j);
            if (i2 != 5054) {
                switch (i2) {
                    case SpeedStatsStampTable.AD_START_STAMP_KEY /* 3301 */:
                        this.mAdStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY /* 3302 */:
                        this.mTbAdloadEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SDK_WILL_SHOW_STAMP_KEY /* 3303 */:
                        this.mSdkAdWillShowTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SDK_DO_SHOW_STAMP_KEY /* 3304 */:
                        this.mSdkAdDoShowTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY /* 3305 */:
                        this.mAdShowStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY /* 3306 */:
                        this.mAdShowEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY /* 3307 */:
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    public long getDurationWithoutAD(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
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

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j9 = this.mAdShowEndTimeStamp;
            if (j9 < 0) {
                j9 = this.mAdViewEndTimeStamp;
            }
            long j10 = this.mAdStartTimeStamp;
            long j11 = j9 - j10;
            long j12 = this.mTbAdloadEndTimeStamp;
            long j13 = j12 - j10;
            long j14 = j9;
            long j15 = this.mAdShowStartTimeStamp;
            if (j15 > 0) {
                long j16 = this.mSdkAdWillShowTimeStamp;
                j8 = j16 - j12;
                long j17 = j15 - j16;
                j3 = j14 - j15;
                j2 = j11 - j3;
                j7 = 0;
                j6 = this.mSdkAdDoShowTimeStamp - j16;
                j5 = (j14 - j10) - j3;
                j4 = j17;
                j = 0;
            } else {
                j = j14 - j12;
                j2 = j11;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                j7 = 0;
                j8 = 0;
            }
            if (j11 < j7 || j11 > 60000 || j13 < j7 || j13 > 60000 || j8 < j7 || j8 > 60000 || j6 < j7 || j6 > 60000 || j4 < j7 || j4 > 60000 || j3 < j7 || j3 > 60000 || j5 < j7 || j5 > 60000 || j < j7 || j > 60000) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AD_DURATION, String.valueOf(j11));
            hashMap.put(AD_TB_LOADAD_DURATION, String.valueOf(j13));
            hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j2));
            if (this.mAdShowStartTimeStamp > 0) {
                hashMap.put(SDK_AD_LOAD_DURATION, String.valueOf(j8));
                hashMap.put(AD_WILL_SHOW_DURATION, String.valueOf(j6));
                hashMap.put(AD_DO_SHOW_DURATION, String.valueOf(j4));
                hashMap.put(AD_SHOW_DURATION, String.valueOf(j3));
                hashMap.put(HAS_AD_DURATION, String.valueOf(j5));
            } else {
                hashMap.put(NO_AD_DURATION, String.valueOf(j));
            }
            long j18 = this.mSdkAdDoShowTimeStamp - this.mSecondDrawDispatchedTimeStamp;
            if (j18 > 0 && j18 < 60000) {
                hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j18));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j2, hashMap);
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
