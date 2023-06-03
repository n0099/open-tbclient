package com.baidu.searchbox.schemedispatch.monitor.bean;

import com.baidu.searchbox.schemedispatch.monitor.control.OpenAppAlertControl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlertConfiguration {
    public static final int max_time_array_size = 10;
    public String scheme;
    public long startTime;
    public List<Long> timeArray = new ArrayList();

    private void checkSize() {
        if (this.timeArray.size() > 10) {
            this.timeArray.remove(0);
        }
    }

    private boolean createControl() {
        int size = this.timeArray.size();
        int i = OpenAppAlertControl.mSelectTimes;
        if (size >= i && i > 0) {
            long longValue = this.timeArray.get(size - 1).longValue() - this.timeArray.get(size - i).longValue();
            if (longValue >= 0 && longValue <= OpenAppAlertControl.mSelectEffectiveTime) {
                this.startTime = System.currentTimeMillis();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean addTime(long j) {
        this.timeArray.add(Long.valueOf(j));
        checkSize();
        return createControl();
    }
}
