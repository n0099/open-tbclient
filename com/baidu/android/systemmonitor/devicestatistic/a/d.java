package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class d extends f {
    public long a;
    public int b;
    public long c;

    public d(long j) {
        super(j);
        this.a = 0L;
        this.b = 0;
        this.c = 0L;
        this.o = 3;
    }

    public d(Cursor cursor) {
        super(cursor);
        this.a = 0L;
        this.b = 0;
        this.c = 0L;
        this.o = 3;
        this.a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
        this.b = cursor.getInt(cursor.getColumnIndex("netype"));
        this.c = cursor.getLong(cursor.getColumnIndex("flow"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "NetworkEvent : startStamp" + this.n + " stopStamp =" + this.a + " netType = " + this.b + " netFlow=" + this.c;
    }
}
