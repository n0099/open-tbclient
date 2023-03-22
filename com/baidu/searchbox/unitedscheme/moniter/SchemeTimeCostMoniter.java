package com.baidu.searchbox.unitedscheme.moniter;

import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
/* loaded from: classes2.dex */
public final class SchemeTimeCostMoniter {
    public static final boolean DEBUG = SchemeConfig.DEBUG;
    public static final int DEFAULT_THRESHOLD = 100;
    public static final String SP_KEY_OPEN_MONITER = "sp_key_open_moniter";
    public static final String SP_KEY_TIME_COST_THRESHOLD = "sp_key_time_cost_threshold";
    public static final String TAG = "SchemeTimeCostMoniter";
    public boolean mOpenMoniter;
    public TimeCostMonitor mTimeCostMoniter;

    /* loaded from: classes2.dex */
    public static class SchemeTimeCostMoniterHolder {
        public static final SchemeTimeCostMoniter sInstance = new SchemeTimeCostMoniter();
    }

    public static SchemeTimeCostMoniter getInstance() {
        return SchemeTimeCostMoniterHolder.sInstance;
    }

    public SchemeTimeCostMoniter() {
        long j = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getLong(SP_KEY_TIME_COST_THRESHOLD, 100L);
        this.mOpenMoniter = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(SP_KEY_OPEN_MONITER, false);
        this.mTimeCostMoniter = new TimeCostMonitor(new TimeCostHandler() { // from class: com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter.1
            @Override // com.baidu.searchbox.unitedscheme.moniter.TimeCostHandler
            public void handle(long j2, long j3, long j4, String str) {
                String str2 = "端能力执行时间超出阈值（" + j4 + "），耗时：" + (j3 - j2) + "，开始时间：" + j2 + "，结束时间：" + j3 + "，端能力：" + str;
                Log.e(SchemeTimeCostMoniter.TAG, str2);
                Toast.makeText(AppRuntime.getAppContext(), str2, 1).show();
            }
        }, j);
    }

    public void schemeEnd(String str) {
        TimeCostMonitor timeCostMonitor;
        if (DEBUG && this.mOpenMoniter && (timeCostMonitor = this.mTimeCostMoniter) != null) {
            timeCostMonitor.recordEnd(str);
        }
    }

    public void schemeStart(String str) {
        TimeCostMonitor timeCostMonitor;
        if (DEBUG && this.mOpenMoniter && (timeCostMonitor = this.mTimeCostMoniter) != null) {
            timeCostMonitor.recordStart(str);
        }
    }
}
