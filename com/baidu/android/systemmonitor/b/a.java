package com.baidu.android.systemmonitor.b;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f770a;
    public long b;
    public int c;
    public String d;
    public int e;
    public String f;
    public int g;
    public String h;

    public a(Cursor cursor) {
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
        this.f770a = cursor.getString(columnIndex);
        this.h = cursor.getString(columnIndex8);
        try {
            this.f770a = com.baidu.android.systemmonitor.security.a.b(this.f770a);
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

    public a(String str) {
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f770a = str;
    }

    public String toString() {
        return "AppChange: packageName =" + this.f770a + " appname =" + this.h + "\u3000eventType =" + this.c + " changeStamp =" + this.b + " versionCode =" + this.e + " versionCodeAfter =" + this.g + " versionName =" + this.d + " versionNameAfter =" + this.f;
    }
}
