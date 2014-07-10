package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public abstract class f {
    public long n;
    public int o = 0;

    public f(long j) {
        this.n = 0L;
        this.n = j;
    }

    public f(Cursor cursor) {
        this.n = 0L;
        this.n = cursor.getLong(cursor.getColumnIndex("startstamp"));
    }

    public String toString() {
        return super.toString();
    }
}
