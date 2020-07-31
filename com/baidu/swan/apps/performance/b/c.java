package com.baidu.swan.apps.performance.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.AnyThread;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.database.favorite.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes7.dex */
public class c {
    private static int czn = -1;

    @AnyThread
    public static void aoq() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                e arw = e.arw();
                if (arw != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", arw.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aus()));
                    contentValues.put("source", arw.arz().ajg());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.ahj().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(d.aeu(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int ns(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.ahj().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(d.aeu(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.d.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int nt(@NonNull String str) {
        int ns = ns(str);
        int i = aot().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (ns + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int nu(@NonNull final String str) {
        int i = aot().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.aot().putInt(str, c.nt(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aor() {
        String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return nu(appId);
    }

    public static int aos() {
        if (czn != -1) {
            return czn;
        }
        switch (com.baidu.swan.apps.t.a.ahm().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                czn = 300;
                break;
            case 1:
                czn = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aot().putInt("step", com.baidu.swan.apps.t.a.ahm().getSwitch("swan_backstage_interval_setting", 300));
                czn = aor();
                break;
        }
        if (czn < 300) {
            czn = 300;
        } else if (czn > 3600) {
            czn = 3600;
        }
        return czn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aot() {
        return h.pZ("sp_launch_behavior");
    }
}
