package com.baidu.searchbox.launch.stats;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class AdSpeedStats extends AbstractSpeedStats {
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
    public String mNetType;
    public String mPlgAdType;
    public long mAdLoadMethodStartTimeStamp = -1;
    public long mAdLoadMethodEndTimeStamp = -1;
    public long mAdLoadIdleEndTimeStamp = -1;
    public long mAdLoadHandlerEndTimeStamp = -1;
    public long mLoadPrologueEndTimeStamp = -1;
    public long mLoadBearEndTimeStamp = -1;
    public long mAdShowMethodStartTimeStamp = -1;
    public long mAdShowMethodEndTimeStamp = -1;
    public long mAdShowPolicySoEndStamp = -1;
    public long mAdShowStartTimeStamp = -1;
    public long mAdShowEndTimeStamp = -1;
    public long mAdViewEndTimeStamp = -1;
    public long mSecondDrawDispatchedTimeStamp = -1;
    public long mAdPreLoadBearStartTimeStamp = -1;
    public String adSource = "0";
    public int mAdLoadResult = 0;
    public boolean mBearLoadResult = false;
    public boolean mPlgLoadResult = false;
    public boolean isTimeout = false;
    public long mAdLoadCostPure = -1;
    public HashMap<String, Long> mLaunchTaskDuration = new HashMap<>();
    public boolean isNeedBear = true;
    public boolean isNeedPlg = true;
    public int mFailCount = 0;

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsDuration(String str, long j) {
        super.addStatsDuration(str, j);
        synchronized (this.mLaunchTaskDuration) {
            this.mLaunchTaskDuration.put(str, Long.valueOf(j));
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
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

    public long getDurationWithoutAD(long j, long j2) {
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

    public long getAdShowDuration() {
        if (this.mAdShowStartTimeStamp <= 0) {
            return 0L;
        }
        long j = this.mAdShowEndTimeStamp;
        if (j < 0) {
            j = this.mAdViewEndTimeStamp;
        }
        return j - this.mAdShowStartTimeStamp;
    }

    public long getAdTotalDuration() {
        if (this.mAdLoadCostPure == -1) {
            packData(new JSONObject());
        }
        return this.mAdLoadCostPure;
    }

    public long getAdViewEndTimeStamp() {
        return this.mAdViewEndTimeStamp;
    }

    public boolean isLoadEnd() {
        if (this.mAdShowStartTimeStamp <= 0 && this.mAdViewEndTimeStamp <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
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

    /* JADX WARN: Removed duplicated region for block: B:210:0x0390 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014b  */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean packData(JSONObject jSONObject) {
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
        long j25;
        long j26;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.packData(jSONObject);
        if (jSONObject == null) {
            return false;
        }
        long j27 = this.mAdShowEndTimeStamp;
        if (j27 < 0) {
            j27 = this.mAdViewEndTimeStamp;
        }
        long j28 = this.mAdLoadMethodEndTimeStamp - this.mAdLoadMethodStartTimeStamp;
        if (this.mAdShowStartTimeStamp > 0) {
            j = this.mAdShowMethodStartTimeStamp;
        } else {
            j = j27;
        }
        long j29 = j - this.mAdLoadMethodEndTimeStamp;
        if (j29 < 0) {
            j29 = 0;
        }
        long j30 = this.mAdLoadIdleEndTimeStamp;
        if (j30 > 0 && j30 < j) {
            j3 = j - j30;
            j2 = j27;
        } else {
            j2 = j27;
            j3 = 0;
        }
        long j31 = this.mAdLoadHandlerEndTimeStamp;
        if (j31 < j && j31 > 0) {
            j4 = j - j31;
        } else {
            j4 = 0;
        }
        long j32 = this.mAdLoadHandlerEndTimeStamp;
        long j33 = j4;
        if (j32 < j) {
            long j34 = this.mAdLoadMethodEndTimeStamp;
            if (j32 > j34) {
                j5 = j32 - j34;
                j6 = this.mLoadBearEndTimeStamp;
                if (j6 <= 0) {
                    j7 = j5;
                    j8 = j6 - this.mAdPreLoadBearStartTimeStamp;
                } else {
                    j7 = j5;
                    j8 = 0;
                }
                long j35 = this.mAdLoadMethodStartTimeStamp;
                long j36 = j8;
                long j37 = this.mAdPreLoadBearStartTimeStamp;
                long j38 = j35 - j37;
                long j39 = j29;
                long j40 = this.mAdViewEndTimeStamp - j37;
                j9 = this.mLoadPrologueEndTimeStamp;
                if (j9 <= 0) {
                    j10 = j9 - j35;
                } else {
                    j10 = 0;
                }
                j11 = this.mLoadBearEndTimeStamp;
                if (j11 <= 0) {
                    j12 = j40;
                    j13 = j11 - this.mAdLoadMethodStartTimeStamp;
                } else {
                    j12 = j40;
                    j13 = 0;
                }
                if (this.mAdShowStartTimeStamp <= 0 && this.mAdShowPolicySoEndStamp > 0) {
                    if ("5".equals(this.adSource)) {
                        long j41 = this.mAdShowPolicySoEndStamp;
                        j14 = j13;
                        long j42 = this.mLoadPrologueEndTimeStamp;
                        j16 = j41 - j42;
                        j15 = this.mAdShowMethodStartTimeStamp - j42;
                    } else {
                        j14 = j13;
                        if ("6".equals(this.adSource)) {
                            long j43 = this.mAdShowPolicySoEndStamp;
                            long j44 = this.mLoadBearEndTimeStamp;
                            j16 = j43 - j44;
                            j15 = this.mAdShowMethodStartTimeStamp - j44;
                        }
                    }
                    long j45 = j - this.mAdLoadMethodStartTimeStamp;
                    long j46 = j;
                    long j47 = j15;
                    if (this.mAdShowStartTimeStamp > 0) {
                        j17 = 1;
                    } else {
                        j17 = 0;
                    }
                    if (this.mAdShowStartTimeStamp > 0) {
                        j18 = j17;
                        j19 = this.mAdShowMethodEndTimeStamp - this.mAdShowMethodStartTimeStamp;
                    } else {
                        j18 = j17;
                        j19 = 0;
                    }
                    j20 = this.mAdShowStartTimeStamp;
                    long j48 = j10;
                    if (j20 > 0) {
                        j21 = j20 - this.mAdShowMethodEndTimeStamp;
                    } else {
                        j21 = 0;
                    }
                    j22 = this.mAdShowStartTimeStamp;
                    if (j22 > 0) {
                        j23 = j2 - j22;
                    } else {
                        j23 = 0;
                    }
                    j24 = this.mAdShowStartTimeStamp;
                    long j49 = j21;
                    if (j24 > 0) {
                        j25 = j24 - this.mAdShowMethodStartTimeStamp;
                    } else {
                        j25 = 0;
                    }
                    j26 = j2 - this.mAdLoadMethodStartTimeStamp;
                    long j50 = j45 + j25;
                    long j51 = j25;
                    this.mAdLoadCostPure = j28 + j3 + j19 + j49 + j23;
                    if (j26 >= 0 && j26 <= 60000 && j50 >= 0 && j50 <= 60000 && j28 >= 0 && j28 <= 60000 && j3 >= 0 && j3 <= 60000 && j48 >= 0 && j48 <= 60000 && j14 >= 0 && j14 <= 60000 && j45 >= 0 && j45 <= 60000 && j19 >= 0 && j19 <= 60000 && j49 >= 0 && j49 <= 60000 && j23 >= 0 && j23 <= 60000 && j51 >= 0 && j51 <= 60000) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(AD_WITH_SHOW_DURATION, String.valueOf(j26));
                        hashMap.put(AD_NO_SHOW_DURATION, String.valueOf(j50));
                        hashMap.put(AD_SHOW_SOURCE, String.valueOf(this.adSource));
                        hashMap.put(AD_LOAD_RESULT, String.valueOf(this.mAdLoadResult));
                        hashMap.put(IS_AD_SHOW_SOURCE, String.valueOf(j18));
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
                        hashMap.put(AD_LOAD_METHOD_DURATION, String.valueOf(j28));
                        hashMap.put(AD_WAIT_LOAD_DURATION, String.valueOf(j39));
                        hashMap.put(AD_LOAD_TOTAL_DURATION, String.valueOf(j45));
                        if (j18 == 1) {
                            hashMap.put(AD_SHOW_METHOD_DURATION, String.valueOf(j19));
                            hashMap.put(AD_WAIT_SHOW_DURATION, String.valueOf(j49));
                            hashMap.put(AD_SHOW_VIEW_DURATION, String.valueOf(j23));
                            hashMap.put(AD_SHOW_TOTAL_DURATION, String.valueOf(j51));
                        } else if (j12 > 0 && j12 < 60000) {
                            hashMap.put(AD_BEAR_REAL_TIMEOUT_DURATION, String.valueOf(j12));
                        }
                        hashMap.put(AD_LOAD_IDLE_DURATION, String.valueOf(j3));
                        hashMap.put(AD_LOAD_HANDLER_B_DURATION, String.valueOf(j33));
                        hashMap.put(AD_LOAD_HANDLER_A_DURATION, String.valueOf(j7));
                        if (i > 0 && i2 < 0) {
                            hashMap.put(AD_PROLOGUE_LOAD_DURATION, String.valueOf(j48));
                        }
                        if (i3 > 0 && i4 < 0) {
                            hashMap.put(AD_BEAR_LOAD_DURATION, String.valueOf(j14));
                        }
                        if (j16 > 0 && j16 < 60000) {
                            hashMap.put(AD_POLICY_SO_DURATION, String.valueOf(j16));
                        }
                        if (j47 > 0 && j47 < 60000) {
                            hashMap.put(AD_POST_SHOW_GAP_DURATION, String.valueOf(j47));
                        }
                        long j52 = this.mAdShowMethodStartTimeStamp - this.mSecondDrawDispatchedTimeStamp;
                        if (j52 > 0 && j52 < 60000) {
                            hashMap.put(DRAW_DONE_2_AD_SHOW_GAP, String.valueOf(j52));
                        }
                        if (j36 > 0 && j36 < 60000) {
                            hashMap.put(AD_BEAR_REAL_LOAD_DURATION, String.valueOf(j36));
                        }
                        if (j38 > 0 && j38 < 60000) {
                            hashMap.put(AD_BEAR_PRE_LOAD_DURATION, String.valueOf(j38));
                        }
                        long appLaunchEndTimeStamp = SpeedStatsManager.getInstance().getAppLaunchEndTimeStamp() - j46;
                        if (appLaunchEndTimeStamp > 0 && appLaunchEndTimeStamp < 60000) {
                            hashMap.put(AD_TO_END_DURATION, String.valueOf(appLaunchEndTimeStamp));
                        }
                        synchronized (this.mLaunchTaskDuration) {
                            for (Map.Entry<String, Long> entry : this.mLaunchTaskDuration.entrySet()) {
                                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                            }
                        }
                        JSONObject jsonData = SpeedStatsUtils.getJsonData(j50, hashMap);
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
                j14 = j13;
                j15 = 0;
                j16 = 0;
                long j452 = j - this.mAdLoadMethodStartTimeStamp;
                long j462 = j;
                long j472 = j15;
                if (this.mAdShowStartTimeStamp > 0) {
                }
                if (this.mAdShowStartTimeStamp > 0) {
                }
                j20 = this.mAdShowStartTimeStamp;
                long j482 = j10;
                if (j20 > 0) {
                }
                j22 = this.mAdShowStartTimeStamp;
                if (j22 > 0) {
                }
                j24 = this.mAdShowStartTimeStamp;
                long j492 = j21;
                if (j24 > 0) {
                }
                j26 = j2 - this.mAdLoadMethodStartTimeStamp;
                long j502 = j452 + j25;
                long j512 = j25;
                this.mAdLoadCostPure = j28 + j3 + j19 + j492 + j23;
                return j26 >= 0 ? false : false;
            }
        }
        j5 = 0;
        j6 = this.mLoadBearEndTimeStamp;
        if (j6 <= 0) {
        }
        long j352 = this.mAdLoadMethodStartTimeStamp;
        long j362 = j8;
        long j372 = this.mAdPreLoadBearStartTimeStamp;
        long j382 = j352 - j372;
        long j392 = j29;
        long j402 = this.mAdViewEndTimeStamp - j372;
        j9 = this.mLoadPrologueEndTimeStamp;
        if (j9 <= 0) {
        }
        j11 = this.mLoadBearEndTimeStamp;
        if (j11 <= 0) {
        }
        if (this.mAdShowStartTimeStamp <= 0) {
        }
        j14 = j13;
        j15 = 0;
        j16 = 0;
        long j4522 = j - this.mAdLoadMethodStartTimeStamp;
        long j4622 = j;
        long j4722 = j15;
        if (this.mAdShowStartTimeStamp > 0) {
        }
        if (this.mAdShowStartTimeStamp > 0) {
        }
        j20 = this.mAdShowStartTimeStamp;
        long j4822 = j10;
        if (j20 > 0) {
        }
        j22 = this.mAdShowStartTimeStamp;
        if (j22 > 0) {
        }
        j24 = this.mAdShowStartTimeStamp;
        long j4922 = j21;
        if (j24 > 0) {
        }
        j26 = j2 - this.mAdLoadMethodStartTimeStamp;
        long j5022 = j4522 + j25;
        long j5122 = j25;
        this.mAdLoadCostPure = j28 + j3 + j19 + j4922 + j23;
        if (j26 >= 0) {
        }
    }

    public void setAdFailCount(int i) {
        this.mFailCount = i;
    }

    public void setAdLoadResult(int i) {
        if (this.mAdLoadResult > 0) {
            return;
        }
        this.mAdLoadResult = i;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public void setBearLoadResult(boolean z) {
        this.mBearLoadResult = z;
    }

    public void setIsNeedBear(boolean z) {
        this.isNeedBear = z;
    }

    public void setIsNeedPlg(boolean z) {
        this.isNeedPlg = z;
    }

    public void setIsTimeout(boolean z) {
        this.isTimeout = z;
    }

    public void setPlgAdType(String str) {
        this.mPlgAdType = str;
    }

    public void setPlgLoadResult(boolean z) {
        this.mPlgLoadResult = z;
    }
}
