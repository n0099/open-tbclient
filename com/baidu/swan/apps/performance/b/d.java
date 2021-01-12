package com.baidu.swan.apps.performance.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.storage.c.h;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes8.dex */
public class d {
    private static int dpB = -1;

    @AnyThread
    public static void aEf() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aIs = e.aIs();
                if (aIs != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aIs.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.getStartType()));
                    contentValues.put("source", aIs.aIv().ayC());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.awy().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.asT(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @IntRange(from = 0)
    @WorkerThread
    private static int qm(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.awy().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.asT(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qn(@NonNull String str) {
        int qm = qm(str);
        int i = aEi().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qm + 1);
        return i2 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : i2;
    }

    private static int qo(@NonNull final String str) {
        int i = aEi().getInt(str, 300);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aEi().putInt(str, d.qn(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aEg() {
        String appId = com.baidu.swan.apps.runtime.d.aIn().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qo(appId);
    }

    public static int aEh() {
        if (dpB != -1) {
            return dpB;
        }
        switch (com.baidu.swan.apps.t.a.awB().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                dpB = 300;
                break;
            case 1:
                dpB = com.baidu.swan.apps.t.a.awB().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aEi().putInt("step", com.baidu.swan.apps.t.a.awB().getSwitch("swan_backstage_interval_setting", 300));
                dpB = aEg();
                break;
        }
        if (dpB < 60) {
            dpB = 60;
        } else if (dpB > 3600) {
            dpB = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        }
        return dpB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aEi() {
        return h.tb("sp_launch_behavior");
    }
}
