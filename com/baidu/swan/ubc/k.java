package com.baidu.swan.ubc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface k {
    String Eo();

    l Ez();

    String Hs();

    boolean Ht();

    void a(String str, int i, JSONArray jSONArray);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    void b(String str, Object obj, int i);

    void c(String str, int i, String str2);

    boolean fK(String str);

    String getAppId();

    String getAppVersion();

    String getDeviceId(Context context);

    SQLiteDatabase getWritableDatabase();

    void t(String str, int i);

    int vc();

    ExecutorService wf();
}
