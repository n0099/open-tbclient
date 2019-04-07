package com.baidu.swan.ubc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface j {
    String Dj();

    String Fn();

    boolean Fo();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    void b(String str, Object obj, int i);

    void c(String str, int i, String str2);

    boolean fv(String str);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();

    k uX();

    int us();

    void y(String str, int i);
}
