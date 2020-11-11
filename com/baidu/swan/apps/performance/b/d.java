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
    private static int djZ = -1;

    @AnyThread
    public static void aEf() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aHv = e.aHv();
                if (aHv != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aHv.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aKo()));
                    contentValues.put("source", aHv.aHy().ayD());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.awA().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.asU(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int rd(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.awA().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.asU(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int re(@NonNull String str) {
        int rd = rd(str);
        int i = aEi().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (rd + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int rf(@NonNull final String str) {
        int i = aEi().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aEi().putInt(str, d.re(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aEg() {
        String appId = com.baidu.swan.apps.runtime.d.aHq().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return rf(appId);
    }

    public static int aEh() {
        if (djZ != -1) {
            return djZ;
        }
        switch (com.baidu.swan.apps.t.a.awD().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                djZ = 300;
                break;
            case 1:
                djZ = com.baidu.swan.apps.t.a.awD().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aEi().putInt("step", com.baidu.swan.apps.t.a.awD().getSwitch("swan_backstage_interval_setting", 300));
                djZ = aEg();
                break;
        }
        if (djZ < 60) {
            djZ = 60;
        } else if (djZ > 3600) {
            djZ = 3600;
        }
        return djZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aEi() {
        return h.tN("sp_launch_behavior");
    }
}
