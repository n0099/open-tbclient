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
/* loaded from: classes7.dex */
public class d {
    private static int diq = -1;

    @AnyThread
    public static void aDx() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aGN = e.aGN();
                if (aGN != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aGN.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aJG()));
                    contentValues.put("source", aGN.aGQ().axV());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.avS().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.asl(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int qX(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.avS().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.asl(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qY(@NonNull String str) {
        int qX = qX(str);
        int i = aDA().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qX + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int qZ(@NonNull final String str) {
        int i = aDA().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aDA().putInt(str, d.qY(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aDy() {
        String appId = com.baidu.swan.apps.runtime.d.aGI().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qZ(appId);
    }

    public static int aDz() {
        if (diq != -1) {
            return diq;
        }
        switch (com.baidu.swan.apps.t.a.avV().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                diq = 300;
                break;
            case 1:
                diq = com.baidu.swan.apps.t.a.avV().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aDA().putInt("step", com.baidu.swan.apps.t.a.avV().getSwitch("swan_backstage_interval_setting", 300));
                diq = aDy();
                break;
        }
        if (diq < 60) {
            diq = 60;
        } else if (diq > 3600) {
            diq = 3600;
        }
        return diq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aDA() {
        return h.tI("sp_launch_behavior");
    }
}
