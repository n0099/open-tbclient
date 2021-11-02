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
    public static final String DRAW_DONE_2_AD_SHOW_GAP = "draw2AdShow";
    public static final String HAS_AD_DURATION = "hasAdDuration";
    public static final String HAS_AD_DURATION_PURE = "hasAdDurationPure";
    public static final String LOGO_START_2_NEW_LOGO_START = "logoStart2NewLogoStart";
    public static final String NEW_LOGO_2_MAIN = "newLogo2Main";
    public static final String NEW_LOGO_DURATION = "newLogo";
    public static final String NO_AD_DURATION = "noAdDuration";
    public static final int SPLASH_AD_CLOSE_STAMP_KEY = 6001;
    public static final String SPLASH_WILL_CALL_AD_SHOW_DURATION = "splashWillCallShow";
    public transient /* synthetic */ FieldHolder $fh;
    public long mSecondDrawDispatchedTimeStamp;
    public long mSplashAdCloseTimeStamp;
    public long mSplashAdShowEndTimeStamp;
    public long mSplashAdShowStartTimeStamp;
    public long mSplashAdWillCallShowTimeStamp;
    public long mSplashAdloadStartTimeStamp;
    public long mSplashTbAdCallShowTimeStamp;
    public long mSplashTbAdloadEndTimeStamp;

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
        this.mSplashAdloadStartTimeStamp = -1L;
        this.mSplashTbAdloadEndTimeStamp = -1L;
        this.mSplashAdWillCallShowTimeStamp = -1L;
        this.mSplashTbAdCallShowTimeStamp = -1L;
        this.mSplashAdShowStartTimeStamp = -1L;
        this.mSplashAdShowEndTimeStamp = -1L;
        this.mSecondDrawDispatchedTimeStamp = -1L;
        this.mSplashAdCloseTimeStamp = -1L;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i2, j);
            if (i2 == 3042) {
                this.mSplashTbAdCallShowTimeStamp = j;
            } else if (i2 == 3052) {
                this.mSplashAdWillCallShowTimeStamp = j;
            } else if (i2 == 5054) {
                this.mSecondDrawDispatchedTimeStamp = j;
            } else if (i2 != 6001) {
                switch (i2) {
                    case SpeedStatsStampTable.SPLASHACTIVITY_ADLOAD_START_STAMP_KEY /* 3034 */:
                        this.mSplashAdloadStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.SPLASHACTIVITY_TB_ADLOAD_END_STAMP_KEY /* 3035 */:
                        this.mSplashTbAdloadEndTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_START_STAMP_KEY /* 3036 */:
                        this.mSplashAdShowStartTimeStamp = j;
                        return;
                    case SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_END_STAMP_KEY /* 3037 */:
                        this.mSplashAdShowEndTimeStamp = j;
                        return;
                    default:
                        return;
                }
            } else {
                this.mSplashAdCloseTimeStamp = j;
            }
        }
    }

    public long getAdShowDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mSplashAdShowStartTimeStamp <= 0) {
                return 0L;
            }
            long j = this.mSplashAdShowEndTimeStamp - this.mSecondDrawDispatchedTimeStamp;
            if (j > 0) {
                return j;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
        if (r4 > 60000) goto L119;
     */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            super.packData(jSONObject);
            if (jSONObject == null) {
                return false;
            }
            long j15 = this.mSplashTbAdloadEndTimeStamp - this.mSplashAdloadStartTimeStamp;
            if (j15 < 0 || j15 > 60000) {
                j15 = 0;
            }
            long j16 = this.mSplashAdShowStartTimeStamp;
            if (j16 > 0) {
                long j17 = this.mSplashTbAdCallShowTimeStamp;
                j8 = j17 - this.mSplashTbAdloadEndTimeStamp;
                j = j15;
                j3 = j17 - this.mSplashAdWillCallShowTimeStamp;
                j6 = j16 - j17;
                j7 = SpeedStatsManager.getInstance().getSplashActivityDuration();
                long j18 = this.mSplashAdShowEndTimeStamp;
                long j19 = j18 > 0 ? j18 - this.mSplashAdloadStartTimeStamp : 0L;
                j9 = j19 - j7;
                j2 = 0;
                j5 = j19;
                j4 = 0;
            } else {
                j = j15;
                long j20 = this.mSplashAdCloseTimeStamp;
                j2 = 0;
                if (j20 > 0) {
                    j4 = j20 - this.mSplashTbAdloadEndTimeStamp;
                    j3 = 0;
                    j5 = 0;
                } else {
                    j3 = 0;
                    j4 = 0;
                    j5 = 0;
                }
                j6 = j5;
                j7 = j6;
                j8 = j7;
                j9 = j8;
            }
            if (j8 < j2 || j8 > 60000) {
                j8 = j2;
            }
            if (j3 < j2 || j3 > 60000) {
                j3 = j2;
            }
            if (j6 < j2 || j6 > 60000) {
                j6 = j2;
            }
            if (j7 < j2 || j7 > 60000) {
                j10 = j5;
                j7 = j2;
            } else {
                j10 = j5;
            }
            long j21 = j4;
            long j22 = this.mSplashTbAdCallShowTimeStamp - this.mSecondDrawDispatchedTimeStamp;
            if (j22 < j2 || j22 > 60000) {
                j22 = j2;
            }
            long j23 = this.mSplashAdShowEndTimeStamp;
            if (j23 > j2) {
                j11 = j22;
                j12 = j23 - this.mSplashTbAdloadEndTimeStamp;
            } else {
                j11 = j22;
                j12 = this.mSplashAdCloseTimeStamp - this.mSplashTbAdloadEndTimeStamp;
            }
            if (j12 >= j2) {
                j13 = 60000;
            } else {
                j13 = 60000;
            }
            j12 = j2;
            if (j12 < j2 || j12 > j13 || j < j2 || j > j13 || j8 < j2 || j8 > j13 || j6 < j2 || j6 > j13 || j7 < j2 || j7 > j13) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ActivitySpeedStats.SPLASH_TB_LOADAD_DURATION, String.valueOf(j));
            hashMap.put(ActivitySpeedStats.SPLASH_LOAD_SDK_AD_DURATION, String.valueOf(j8));
            hashMap.put(SPLASH_WILL_CALL_AD_SHOW_DURATION, String.valueOf(j3));
            hashMap.put(ActivitySpeedStats.SPLASH_CALL_AD_SHOW_DURATION, String.valueOf(j6));
            hashMap.put(ActivitySpeedStats.SPLASH_SHOW_DURATION, String.valueOf(j7));
            hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j11));
            if (j21 > 0) {
                j14 = 60000;
                if (j21 < 60000) {
                    hashMap.put(NO_AD_DURATION, String.valueOf(j21));
                }
            } else {
                j14 = 60000;
            }
            if (j10 > 0 && j10 < j14) {
                hashMap.put(HAS_AD_DURATION, String.valueOf(j10));
            }
            if (j9 > 0 && j9 < j14) {
                hashMap.put(HAS_AD_DURATION_PURE, String.valueOf(j9));
            }
            long logo2NewLogoDuration = SpeedStatsManager.getInstance().logo2NewLogoDuration();
            if (logo2NewLogoDuration > 0 && logo2NewLogoDuration < 60000) {
                hashMap.put(LOGO_START_2_NEW_LOGO_START, String.valueOf(logo2NewLogoDuration));
            }
            long newLogoDuration = SpeedStatsManager.getInstance().newLogoDuration();
            if (newLogoDuration > 0 && newLogoDuration < 60000) {
                hashMap.put(NEW_LOGO_DURATION, String.valueOf(newLogoDuration));
            }
            long newLogo2MainTabActivityDuration = SpeedStatsManager.getInstance().newLogo2MainTabActivityDuration();
            if (newLogo2MainTabActivityDuration > 0 && newLogo2MainTabActivityDuration < 60000) {
                hashMap.put(NEW_LOGO_2_MAIN, String.valueOf(newLogo2MainTabActivityDuration));
            }
            JSONObject jsonData = SpeedStatsUtils.getJsonData(j12, hashMap);
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
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mSplashAdloadStartTimeStamp = -1L;
            this.mSplashTbAdloadEndTimeStamp = -1L;
            this.mSplashTbAdCallShowTimeStamp = -1L;
            this.mSplashAdShowStartTimeStamp = -1L;
            this.mSplashAdShowEndTimeStamp = -1L;
            this.mSecondDrawDispatchedTimeStamp = -1L;
            this.mSplashAdCloseTimeStamp = -1L;
        }
    }
}
