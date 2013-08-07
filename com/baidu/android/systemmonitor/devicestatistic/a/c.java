package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public abstract class c {
    public long g;
    public int h = 0;

    public c(long j) {
        this.g = 0L;
        this.g = j;
    }

    public c(Cursor cursor) {
        this.g = 0L;
        this.g = cursor.getLong(cursor.getColumnIndex("startstamp"));
    }

    public String toString() {
        return super.toString();
    }
}
