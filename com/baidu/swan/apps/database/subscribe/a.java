package com.baidu.swan.apps.database.subscribe;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.baidu.swan.apps.console.c;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public final class a {
    public static void x(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS swanapp_subscribe_msg(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,templateId varchar(50) NOT NULL,title varchar(100) NOT NULL,tips TEXT,result TINYINT default 0);");
        } catch (Exception e) {
            c.e("SwanAppSubscribeMsg", "createTable", e);
        }
    }

    @WorkerThread
    public static void p(@Nullable String... strArr) {
        Application aoJ;
        if (com.baidu.swan.apps.t.a.aoJ() == null || strArr == null) {
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
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        c.i("SwanAppSubscribeMsg", "deleteAllByAppKey count=" + aoJ.getContentResolver().delete(SwanAppSubscribeMsgProvider.CONTENT_URI, "appKey in (?)", new String[]{sb.toString()}) + ", appKey=" + sb.toString());
    }
}
