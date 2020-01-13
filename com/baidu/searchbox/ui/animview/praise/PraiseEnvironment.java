package com.baidu.searchbox.ui.animview.praise;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.io.BufferedReader;
import java.io.FileReader;
/* loaded from: classes12.dex */
public class PraiseEnvironment {
    private static final int RAM_THRESHOLD_GB = 3;
    private static final String TAG = "PraiseEnvironment";
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static Performance sPerformanceLevel = Performance.LEVEL_NONE;

    /* loaded from: classes12.dex */
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

    private static void analyzePerformance() {
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
        sPerformanceLevel = Performance.LEVEL_2;
        if (DEBUG) {
            Log.d(TAG, "Performance.LEVEL_2");
        }
    }

    private static int getTotalRam() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
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
        if (str.contains("h5_") || str.contains("hn_")) {
            return true;
        }
        if (!TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_COMMENT_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER) && !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED)) {
            if (TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST_OUT) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_IMMERSIVE_VIDEO_LIST)) {
                return true;
            }
            return TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_BAR) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_IMGTXT_DETAIL_BAR) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMUNITY_LIST) || TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT);
        }
        return true;
    }
}
