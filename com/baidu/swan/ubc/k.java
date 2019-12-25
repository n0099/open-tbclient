package com.baidu.swan.ubc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public interface k {
    int DH();

    l FO();

    ExecutorService Fb();

    String Sk();

    String WD();

    boolean WE();

    boolean WF();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    void c(String str, Object obj, int i);

    String cl(Context context);

    void e(String str, int i, String str2);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    String getHostName();

    String getUserId(Context context);

    SQLiteDatabase getWritableDatabase();

    boolean jr(String str);

    void w(String str, int i);
}
