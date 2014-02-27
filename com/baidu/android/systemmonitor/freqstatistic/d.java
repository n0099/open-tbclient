package com.baidu.android.systemmonitor.freqstatistic;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class d {
    public String a;
    public long b;
    public int c;
    public String d;
    public int e;
    public String f;
    public int g;
    public String h;

    public d(Cursor cursor) {
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = 0;
        int columnIndex = cursor.getColumnIndex("pn");
        int columnIndex2 = cursor.getColumnIndex("time");
        int columnIndex3 = cursor.getColumnIndex("event");
        int columnIndex4 = cursor.getColumnIndex("vcode");
        int columnIndex5 = cursor.getColumnIndex("vn");
        int columnIndex6 = cursor.getColumnIndex("vcodeaft");
        int columnIndex7 = cursor.getColumnIndex("vnaft");
        int columnIndex8 = cursor.getColumnIndex("an");
        this.a = cursor.getString(columnIndex);
        this.h = cursor.getString(columnIndex8);
        try {
            this.a = com.baidu.android.systemmonitor.security.a.b(this.a);
            this.h = com.baidu.android.systemmonitor.security.a.b(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = cursor.getInt(columnIndex3);
        this.b = cursor.getLong(columnIndex2);
        this.e = cursor.getInt(columnIndex4);
        this.d = cursor.getString(columnIndex5);
        this.g = cursor.getInt(columnIndex6);
        this.f = cursor.getString(columnIndex7);
    }

    public d(String str) {
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a = str;
    }

    public final String toString() {
        return "AppChange: packageName =" + this.a + " appname =" + this.h + "\u3000eventType =" + this.c + " changeStamp =" + this.b + " versionCode =" + this.e + " versionCodeAfter =" + this.g + " versionName =" + this.d + " versionNameAfter =" + this.f;
    }
}
