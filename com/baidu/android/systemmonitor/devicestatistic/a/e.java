package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
/* loaded from: classes.dex */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    public long f704a;

    public e(long j) {
        super(j);
        this.f704a = 0L;
        this.h = 1;
    }

    public e(Cursor cursor) {
        super(cursor);
        this.f704a = 0L;
        this.h = 1;
        this.f704a = cursor.getLong(cursor.getColumnIndex("stopstamp"));
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.c
    public String toString() {
        return "PowerEvent : startStamp" + this.g + " stopStamp =" + this.f704a;
    }
}
