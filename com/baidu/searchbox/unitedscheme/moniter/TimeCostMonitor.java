package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import java.util.Hashtable;
/* loaded from: classes19.dex */
public class TimeCostMonitor {
    private static final boolean DEBUG = false;
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
            if (currentTimeMillis - l.longValue() > this.mThresholdValue && this.mTimeoutHandler != null) {
                this.mTimeoutHandler.handle(l.longValue(), currentTimeMillis, this.mThresholdValue, str);
            }
            this.mEventRecorder.remove(str);
        }
    }
}
