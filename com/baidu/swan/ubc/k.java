package com.baidu.swan.ubc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface k {
    int AB();

    ExecutorService BE();

    String JV();

    l Kg();

    String Nc();

    boolean Nd();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    void c(String str, Object obj, int i);

    void e(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    SQLiteDatabase getWritableDatabase();

    boolean gv(String str);

    void t(String str, int i);
}
