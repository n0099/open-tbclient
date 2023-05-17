package com.baidu.searchbox.ui.animview.praise;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.io.BufferedReader;
import java.io.FileReader;
/* loaded from: classes4.dex */
public class PraiseEnvironment {
    public static final int RAM_THRESHOLD_GB = 3;
    public static final String TAG = "PraiseEnvironment";
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static Performance sPerformanceLevel = Performance.LEVEL_NONE;

    /* loaded from: classes4.dex */
    public enum Performance {
        LEVEL_NONE,
        LEVEL_1,
        LEVEL_2,
        LEVEL_3
    }

    static {
        analyzePerformance();
    }

    public static Performance getPerformanceLevel() {
        return sPerformanceLevel;
    }

    public static void analyzePerformance() {
        if (Build.VERSION.SDK_INT < 23) {
            sPerformanceLevel = Performance.LEVEL_1;
            if (DEBUG) {
                Log.d(TAG, "Performance.LEVEL_1, less than Build.VERSION_CODES.M");
                return;
            }
            return;
        }
        int totalRam = getTotalRam();
        if (totalRam > 0 && totalRam < 3) {
            sPerformanceLevel = Performance.LEVEL_1;
            if (DEBUG) {
                Log.d(TAG, "Performance.LEVEL_1, totalRam = " + totalRam);
                return;
            }
            return;
        }
        sPerformanceLevel = Performance.LEVEL_3;
        if (DEBUG) {
            Log.d(TAG, "Performance.LEVEL_3");
        }
    }

    @SuppressLint({"UseValueOf"})
    public static int getTotalRam() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            String str = bufferedReader.readLine().split("\\s+")[1];
            bufferedReader.close();
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isCancelPraiseEnabled(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains("h5_") && !str.contains("hn_") && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_IMMERSIVE_VIDEO_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_BAR) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMGTXT_DETAIL_BAR) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMUNITY_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_HOT_DISCUSSION) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_YOULIAO) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_TAB_MOMENT) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMMERSIVE) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_LIVE_ASK_ANSWER) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_DETAIL) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_MERGE_VIDEO_LANDING) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FANCY_COMMENT_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_CRIUS)) {
            return false;
        }
        return true;
    }

    public static boolean isFirstPraiseAnimSupported(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d(TAG, "isFirstPraiseAnimSupported: praiseSource is null");
            }
            return false;
        } else if (!str.contains("h5_") && !str.contains("hn_")) {
            if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT)) {
                return true;
            }
            if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FANCY_COMMENT_LIST)) {
                return false;
            }
            if (TextUtils.equals(str, PraiseSourceDef.PRAISE_EFFECT_SOURCE)) {
                return true;
            }
            if (DEBUG) {
                Log.d(TAG, "isFirstPraiseAnimSupported: match failed");
            }
            return false;
        } else {
            if (DEBUG) {
                Log.d(TAG, "isFirstPraiseAnimSupported: web");
            }
            return false;
        }
    }

    public static boolean isPraiseLoginSupported(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseLoginSupported: praiseSource is null");
            }
            return false;
        } else if (!str.contains("h5_") && !str.contains("hn_")) {
            if (ComboPraiseRuntime.getContext() != null && !ComboPraiseRuntime.getContext().isPraiseLoginSupported()) {
                if (DEBUG) {
                    Log.d(TAG, "ab switch is false");
                }
                return false;
            } else if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT)) {
                return true;
            } else {
                if (DEBUG) {
                    Log.d(TAG, "isPraiseLoginSupported: match failed");
                }
                return false;
            }
        } else {
            if (DEBUG) {
                Log.d(TAG, "isPraiseLoginSupported: web");
            }
            return false;
        }
    }
}
