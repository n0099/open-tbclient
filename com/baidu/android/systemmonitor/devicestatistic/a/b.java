package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class b extends f {
    public long a;

    public b(long j) {
        super(j);
        this.a = 0L;
        this.o = 1;
    }

    public b(Cursor cursor) {
        super(cursor);
        this.a = 0L;
        this.o = 1;
        this.a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "PowerEvent : startStamp" + this.n + " stopStamp =" + this.a;
    }
}
