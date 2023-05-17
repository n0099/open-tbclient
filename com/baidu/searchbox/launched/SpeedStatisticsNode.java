package com.baidu.searchbox.launched;
/* loaded from: classes3.dex */
public class SpeedStatisticsNode {
    public long begin = System.currentTimeMillis();
    public long end;

    public void end() {
        this.end = System.currentTimeMillis();
    }

    public long getBeginTimestamp() {
        return this.begin;
    }

    public long getDuration() {
        return this.end - this.begin;
    }
}
