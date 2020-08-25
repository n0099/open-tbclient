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
/* loaded from: classes8.dex */
public class d {
    private static int cHw = -1;

    @AnyThread
    public static void awr() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e azJ = e.azJ();
                if (azJ != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", azJ.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aCB()));
                    contentValues.put("source", azJ.azM().aqN());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.aoJ().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.ald(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int pq(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.aoJ().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.ald(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int pr(@NonNull String str) {
        int pq = pq(str);
        int i = awu().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (pq + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int ps(@NonNull final String str) {
        int i = awu().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.awu().putInt(str, d.pr(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aws() {
        String appId = com.baidu.swan.apps.runtime.d.azE().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return ps(appId);
    }

    public static int awt() {
        if (cHw != -1) {
            return cHw;
        }
        switch (com.baidu.swan.apps.t.a.aoM().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                cHw = 300;
                break;
            case 1:
                cHw = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                awu().putInt("step", com.baidu.swan.apps.t.a.aoM().getSwitch("swan_backstage_interval_setting", 300));
                cHw = aws();
                break;
        }
        if (cHw < 60) {
            cHw = 60;
        } else if (cHw > 3600) {
            cHw = 3600;
        }
        return cHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b awu() {
        return h.rZ("sp_launch_behavior");
    }
}
