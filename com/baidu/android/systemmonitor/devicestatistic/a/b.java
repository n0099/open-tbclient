package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class b extends f {
    public String a;
    public String b;

    public b(long j) {
        super(j);
        this.o = 5;
    }

    public b(long j, String str, String str2) {
        super(j);
        this.o = 5;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.a = com.baidu.android.systemmonitor.security.a.a(str);
            this.b = com.baidu.android.systemmonitor.security.a.a(str2);
        } catch (Exception e) {
        }
    }

    public b(Cursor cursor) {
        super(cursor);
        String str;
        String str2;
        this.o = 5;
        String string = cursor.getString(cursor.getColumnIndex("dnpath"));
        String string2 = cursor.getString(cursor.getColumnIndex("downame"));
        try {
            String b = TextUtils.isEmpty(string) ? string : com.baidu.android.systemmonitor.security.a.b(string);
            str2 = TextUtils.isEmpty(string2) ? string2 : com.baidu.android.systemmonitor.security.a.b(string2);
            str = b;
        } catch (Exception e) {
            str = "";
            str2 = "";
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public final String toString() {
        return "ApkDownloadEvent : downloadPath =" + this.a + " apkName = " + this.b + " StartStamp = " + this.n;
    }
}
