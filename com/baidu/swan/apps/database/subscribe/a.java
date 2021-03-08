package com.baidu.swan.apps.database.subscribe;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public final class a {
    public static void y(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS swanapp_subscribe_msg(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,templateId varchar(50) NOT NULL,title varchar(100) NOT NULL,tips TEXT,result TINYINT default 0);");
        } catch (Exception e) {
            c.e("SwanAppSubscribeMsg", "createTable", e);
        }
    }

    @WorkerThread
    public static void y(@Nullable String... strArr) {
        Application awZ;
        if (com.baidu.swan.apps.t.a.awZ() == null || strArr == null) {
            c.w("SwanAppSubscribeMsg", "deleteAllByAppKey fail");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                if (i < length - 1) {
                    sb.append(",");
                }
            }
        }
        c.i("SwanAppSubscribeMsg", "deleteAllByAppKey count=" + awZ.getContentResolver().delete(SwanAppSubscribeMsgProvider.CONTENT_URI, "appKey in (?)", new String[]{sb.toString()}) + ", appKey=" + sb.toString());
    }
}
