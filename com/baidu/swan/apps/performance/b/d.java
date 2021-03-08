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
    private static int dto = -1;

    @AnyThread
    public static void aED() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aIO = e.aIO();
                if (aIO != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aIO.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.getStartType()));
                    contentValues.put("source", aIO.aIR().azd());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.awZ().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.atu(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @IntRange(from = 0)
    @WorkerThread
    private static int qL(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.awZ().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.atu(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qM(@NonNull String str) {
        int qL = qL(str);
        int i = aEG().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qL + 1);
        return i2 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : i2;
    }

    private static int qN(@NonNull final String str) {
        int i = aEG().getInt(str, 300);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aEG().putInt(str, d.qM(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aEE() {
        String appId = com.baidu.swan.apps.runtime.d.aIJ().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qN(appId);
    }

    public static int aEF() {
        if (dto != -1) {
            return dto;
        }
        switch (com.baidu.swan.apps.t.a.axc().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                dto = 300;
                break;
            case 1:
                dto = com.baidu.swan.apps.t.a.axc().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aEG().putInt("step", com.baidu.swan.apps.t.a.axc().getSwitch("swan_backstage_interval_setting", 300));
                dto = aEE();
                break;
        }
        if (dto < 60) {
            dto = 60;
        } else if (dto > 3600) {
            dto = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        }
        return dto;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aEG() {
        return h.tB("sp_launch_behavior");
    }
}
