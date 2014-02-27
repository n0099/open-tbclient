package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class e extends f {
    public String a;
    public int b;
    public int c;
    public int d;
    public long e;
    public int f;

    public e(long j) {
        super(j);
        this.a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = -1;
        this.o = 2;
    }

    public e(Cursor cursor) {
        super(cursor);
        this.a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = -1;
        this.o = 2;
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
        this.a = string;
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public final String toString() {
        return "ChargeEvent : startStamp =" + this.n + " stopStamp =" + this.e + " chargeType =" + this.f + " startBtLevel =" + this.b + " stopBtLevel =" + this.c + " netType =" + this.d + " location =" + this.a;
    }
}
