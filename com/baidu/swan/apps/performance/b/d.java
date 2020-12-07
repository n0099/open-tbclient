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
/* loaded from: classes25.dex */
public class d {
    private static int dpr = -1;

    @AnyThread
    public static void aGF() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aJV = e.aJV();
                if (aJV != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aJV.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.getStartType()));
                    contentValues.put("source", aJV.aJY().aBe());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.aza().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.avu(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int rE(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.aza().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.avu(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int rF(@NonNull String str) {
        int rE = rE(str);
        int i = aGI().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (rE + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int rG(@NonNull final String str) {
        int i = aGI().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aGI().putInt(str, d.rF(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aGG() {
        String appId = com.baidu.swan.apps.runtime.d.aJQ().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return rG(appId);
    }

    public static int aGH() {
        if (dpr != -1) {
            return dpr;
        }
        switch (com.baidu.swan.apps.t.a.azd().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                dpr = 300;
                break;
            case 1:
                dpr = com.baidu.swan.apps.t.a.azd().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aGI().putInt("step", com.baidu.swan.apps.t.a.azd().getSwitch("swan_backstage_interval_setting", 300));
                dpr = aGG();
                break;
        }
        if (dpr < 60) {
            dpr = 60;
        } else if (dpr > 3600) {
            dpr = 3600;
        }
        return dpr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aGI() {
        return h.up("sp_launch_behavior");
    }
}
