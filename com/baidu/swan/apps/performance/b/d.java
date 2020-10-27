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
    private static int ded = -1;

    @AnyThread
    public static void aBF() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aEV = e.aEV();
                if (aEV != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aEV.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aHO()));
                    contentValues.put("source", aEV.aEY().awd());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.aua().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.aqt(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int qP(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.aua().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.aqt(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qQ(@NonNull String str) {
        int qP = qP(str);
        int i = aBI().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qP + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int qR(@NonNull final String str) {
        int i = aBI().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aBI().putInt(str, d.qQ(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aBG() {
        String appId = com.baidu.swan.apps.runtime.d.aEQ().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qR(appId);
    }

    public static int aBH() {
        if (ded != -1) {
            return ded;
        }
        switch (com.baidu.swan.apps.t.a.aud().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                ded = 300;
                break;
            case 1:
                ded = com.baidu.swan.apps.t.a.aud().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aBI().putInt("step", com.baidu.swan.apps.t.a.aud().getSwitch("swan_backstage_interval_setting", 300));
                ded = aBG();
                break;
        }
        if (ded < 60) {
            ded = 60;
        } else if (ded > 3600) {
            ded = 3600;
        }
        return ded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aBI() {
        return h.tz("sp_launch_behavior");
    }
}
