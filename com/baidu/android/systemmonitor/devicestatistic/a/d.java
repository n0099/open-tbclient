package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public long f808a;
    public int b;
    public long c;

    public d(long j) {
        super(j);
        this.f808a = 0L;
        this.b = 0;
        this.c = 0L;
        this.h = 3;
    }

    public d(Cursor cursor) {
        super(cursor);
        this.f808a = 0L;
        this.b = 0;
        this.c = 0L;
        this.h = 3;
        this.f808a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
        this.b = cursor.getInt(cursor.getColumnIndex("netype"));
        this.c = cursor.getLong(cursor.getColumnIndex("flow"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.c
    public String toString() {
        return "NetworkEvent : startStamp" + this.g + " stopStamp =" + this.f808a + " netType = " + this.b + " netFlow=" + this.c;
    }
}
