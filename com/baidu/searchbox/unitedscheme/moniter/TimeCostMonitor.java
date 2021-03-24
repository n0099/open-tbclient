package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class TimeCostMonitor {
    public static final boolean DEBUG = false;
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
        if (currentTimeMillis - l.longValue() > this.mThresholdValue && (timeCostHandler = this.mTimeoutHandler) != null) {
            timeCostHandler.handle(l.longValue(), currentTimeMillis, this.mThresholdValue, str);
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
