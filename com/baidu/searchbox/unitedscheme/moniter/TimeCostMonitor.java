package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Hashtable;
/* loaded from: classes12.dex */
public class TimeCostMonitor {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "TimeCostMonitor";
    private Hashtable<String, Long> mEventRecorder = new Hashtable<>();
    private long mThresholdValue;
    private TimeCostHandler mTimeoutHandler;

    public TimeCostMonitor(TimeCostHandler timeCostHandler, long j) {
        this.mTimeoutHandler = timeCostHandler;
        this.mThresholdValue = j;
    }

    public void recordStart(String str) {
        if (!TextUtils.isEmpty(str) && this.mEventRecorder != null) {
            this.mEventRecorder.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void recordEnd(String str) {
        Long l;
        if (!TextUtils.isEmpty(str) && this.mEventRecorder != null && (l = this.mEventRecorder.get(str)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = currentTimeMillis - l.longValue();
            if (longValue > this.mThresholdValue && this.mTimeoutHandler != null) {
                this.mTimeoutHandler.handle(l.longValue(), currentTimeMillis, this.mThresholdValue, str);
            }
            if (DEBUG) {
                Log.i(TAG, "执行耗时：" + longValue + "，开始时间：" + l + "，结束时间：" + currentTimeMillis + "，event：" + str);
            }
            this.mEventRecorder.remove(str);
        }
    }
}
