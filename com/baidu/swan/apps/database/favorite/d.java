package com.baidu.swan.apps.database.favorite;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class d {
    private static Uri cLB;

    public static void y(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_behavior(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,launch_type INT NOT NULL,source varchar(100),ext TEXT,time BIGINT);");
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("SwanLaunchBehaviorTable", "createTable", e);
        }
    }

    @NonNull
    public static synchronized Uri aqt() {
        Uri uri;
        synchronized (d.class) {
            if (cLB == null) {
                cLB = b.CONTENT_URI.buildUpon().appendPath("user_behavior").build();
            }
            uri = cLB;
        }
        return uri;
    }
}
