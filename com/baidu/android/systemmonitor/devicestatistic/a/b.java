package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f807a;
    public int b;
    public int c;
    public int d;
    public long e;
    public int f;

    public b(long j) {
        super(j);
        this.f807a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = -1;
        this.h = 2;
    }

    public b(Cursor cursor) {
        super(cursor);
        this.f807a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = -1;
        this.h = 2;
        this.e = cursor.getLong(cursor.getColumnIndex("stopstamp"));
        this.f = cursor.getInt(cursor.getColumnIndex("chargetype"));
        this.b = cursor.getInt(cursor.getColumnIndex("startlevel"));
        this.c = cursor.getInt(cursor.getColumnIndex("stoplevel"));
        this.d = cursor.getInt(cursor.getColumnIndex("netype"));
        String string = cursor.getString(cursor.getColumnIndex("loc"));
        if (!TextUtils.isEmpty(string)) {
            try {
                string = com.baidu.android.systemmonitor.security.a.b(string);
            } catch (Exception e) {
                string = "";
            }
        }
        this.f807a = string;
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.c
    public String toString() {
        return "ChargeEvent : startStamp =" + this.g + " stopStamp =" + this.e + " chargeType =" + this.f + " startBtLevel =" + this.b + " stopBtLevel =" + this.c + " netType =" + this.d + " location =" + this.f807a;
    }
}
