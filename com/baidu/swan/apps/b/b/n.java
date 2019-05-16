package com.baidu.swan.apps.b.b;

import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface n {
    void a(String str, int i, JSONArray jSONArray);

    void a(String str, Object obj, int i);

    void a(String str, String str2, int i, String str3, int i2);

    void a(String str, String str2, int i, String str3, long j, int i2);

    void c(String str, int i, String str2);

    SQLiteDatabase getWritableDatabase();

    void t(String str, int i);

    ExecutorService wf();
}
