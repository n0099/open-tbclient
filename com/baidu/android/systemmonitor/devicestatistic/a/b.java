package com.baidu.android.systemmonitor.devicestatistic.a;

import android.database.Cursor;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public String f411a;
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
            this.f411a = com.baidu.android.systemmonitor.security.a.a(str);
            this.b = com.baidu.android.systemmonitor.security.a.a(str2);
        } catch (Exception e) {
        }
    }

    public b(Cursor cursor) {
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
        this.f411a = string;
        this.b = string2;
    }

    @Override // com.baidu.android.systemmonitor.devicestatistic.a.f
    public String toString() {
        return "ApkDownloadEvent : downloadPath =" + this.f411a + " apkName = " + this.b + " StartStamp = " + this.n;
    }
}
