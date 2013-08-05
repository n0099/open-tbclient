package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    public long f682a;

    public c(long j) {
        super(j);
        this.f682a = 0L;
        this.o = 1;
    }

    public c(Cursor cursor) {
        super(cursor);
        this.f682a = 0L;
        this.o = 1;
        this.f682a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "PowerEvent : startStamp" + this.n + " stopStamp =" + this.f682a;
    }
}
