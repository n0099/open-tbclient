package com.baidu.android.systemmonitor.d;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public String f408a;
    public long b;
    public long c;
    public String d;
    public int e;
    public int f;
    public int g;
    public long h;

    public n(Cursor cursor) {
        this.d = "";
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0L;
        int columnIndex = cursor.getColumnIndex("startstamp");
        int columnIndex2 = cursor.getColumnIndex("stopstamp");
        int columnIndex3 = cursor.getColumnIndex("loc");
        int columnIndex4 = cursor.getColumnIndex("startlevel");
        int columnIndex5 = cursor.getColumnIndex("stoplevel");
        int columnIndex6 = cursor.getColumnIndex("netype");
        int columnIndex7 = cursor.getColumnIndex("flow");
        this.f408a = cursor.getString(cursor.getColumnIndex("pn"));
        this.b = cursor.getLong(columnIndex);
        this.c = cursor.getLong(columnIndex2);
        this.d = cursor.getString(columnIndex3);
        if (!TextUtils.isEmpty(this.d)) {
            try {
                this.d = com.baidu.android.systemmonitor.security.a.b(this.d);
            } catch (Exception e) {
            }
        }
        this.e = cursor.getInt(columnIndex4);
        this.f = cursor.getInt(columnIndex5);
        this.g = cursor.getInt(columnIndex6);
        this.h = cursor.getLong(columnIndex7);
    }

    public n(String str) {
        this.d = "";
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0L;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f408a = str;
    }

    public String toString() {
        return "apptrace :  packageName =" + this.f408a + "  startStamp =" + this.b + " stopStamp =" + this.c + " location =" + this.d + " startBtLevel =" + this.e + " stopBtLevel =" + this.f + " netType =" + this.g + " netFlow =" + this.h;
    }
}
