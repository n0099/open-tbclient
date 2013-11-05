package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    public long f795a;

    public e(long j) {
        super(j);
        this.f795a = 0L;
        this.h = 1;
    }

    public e(Cursor cursor) {
        super(cursor);
        this.f795a = 0L;
        this.h = 1;
        this.f795a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.c
    public String toString() {
        return "PowerEvent : startStamp" + this.g + " stopStamp =" + this.f795a;
    }
}
