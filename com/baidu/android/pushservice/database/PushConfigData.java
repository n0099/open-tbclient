package com.baidu.android.pushservice.database;
/* loaded from: classes.dex */
public class PushConfigData {
    public String dataValue;
    public long timeInterval;

    public PushConfigData(String str, long j) {
        this.dataValue = str;
        this.timeInterval = j;
    }

    public String getDataValue() {
        return this.dataValue;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }
}
