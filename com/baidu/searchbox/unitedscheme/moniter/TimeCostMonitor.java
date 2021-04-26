package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class TimeCostMonitor {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "TimeCostMonitor";
    public Hashtable<String, Long> mEventRecorder = new Hashtable<>();
    public long mThresholdValue;
    public TimeCostHandler mTimeoutHandler;

    public TimeCostMonitor(TimeCostHandler timeCostHandler, long j) {
        this.mTimeoutHandler = timeCostHandler;
        this.mThresholdValue = j;
    }

    public void recordEnd(String str) {
        Hashtable<String, Long> hashtable;
        Long l;
        TimeCostHandler timeCostHandler;
        if (TextUtils.isEmpty(str) || (hashtable = this.mEventRecorder) == null || (l = hashtable.get(str)) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - l.longValue();
        if (longValue > this.mThresholdValue && (timeCostHandler = this.mTimeoutHandler) != null) {
            timeCostHandler.handle(l.longValue(), currentTimeMillis, this.mThresholdValue, str);
        }
        if (DEBUG) {
            Log.i(TAG, "执行耗时：" + longValue + "，开始时间：" + l + "，结束时间：" + currentTimeMillis + "，event：" + str);
        }
        this.mEventRecorder.remove(str);
    }

    public void recordStart(String str) {
        Hashtable<String, Long> hashtable;
        if (TextUtils.isEmpty(str) || (hashtable = this.mEventRecorder) == null) {
            return;
        }
        hashtable.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
