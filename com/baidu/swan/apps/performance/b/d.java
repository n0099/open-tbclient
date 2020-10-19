package com.baidu.swan.apps.performance.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.AnyThread;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes10.dex */
public class d {
    private static int cVD = -1;

    @AnyThread
    public static void azL() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aDb = e.aDb();
                if (aDb != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aDb.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aFU()));
                    contentValues.put("source", aDb.aDe().auj());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.asf().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.aoy(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int qw(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.asf().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.aoy(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qx(@NonNull String str) {
        int qw = qw(str);
        int i = azO().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qw + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int qy(@NonNull final String str) {
        int i = azO().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.azO().putInt(str, d.qx(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int azM() {
        String appId = com.baidu.swan.apps.runtime.d.aCW().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qy(appId);
    }

    public static int azN() {
        if (cVD != -1) {
            return cVD;
        }
        switch (com.baidu.swan.apps.t.a.asi().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                cVD = 300;
                break;
            case 1:
                cVD = com.baidu.swan.apps.t.a.asi().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                azO().putInt("step", com.baidu.swan.apps.t.a.asi().getSwitch("swan_backstage_interval_setting", 300));
                cVD = azM();
                break;
        }
        if (cVD < 60) {
            cVD = 60;
        } else if (cVD > 3600) {
            cVD = 3600;
        }
        return cVD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b azO() {
        return h.tg("sp_launch_behavior");
    }
}
