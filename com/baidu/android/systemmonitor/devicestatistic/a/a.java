package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class a extends f {
    public String a;
    public String b;

    public a(long j) {
        super(j);
        this.o = 5;
    }

    public a(long j, String str, String str2) {
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

    public a(Cursor cursor) {
        super(cursor);
        this.o = 5;
        String string = cursor.getString(cursor.getColumnIndex("dnpath"));
        String string2 = cursor.getString(cursor.getColumnIndex("downame"));
        try {
            string = TextUtils.isEmpty(string) ? string : com.baidu.android.systemmonitor.security.a.b(string);
            if (!TextUtils.isEmpty(string2)) {
                string2 = com.baidu.android.systemmonitor.security.a.b(string2);
            }
        } catch (Exception e) {
            string = "";
            string2 = "";
        }
        this.a = string;
        this.b = string2;
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "ApkDownloadEvent : downloadPath =" + this.a + " apkName = " + this.b + " StartStamp = " + this.n;
    }
}
