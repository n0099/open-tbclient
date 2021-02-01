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
/* loaded from: classes9.dex */
public class d {
    private static int drM = -1;

    @AnyThread
    public static void aEA() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aIL = e.aIL();
                if (aIL != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aIL.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.getStartType()));
                    contentValues.put("source", aIL.aIO().aza());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.awW().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.atr(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @IntRange(from = 0)
    @WorkerThread
    private static int qE(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.awW().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.atr(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int qF(@NonNull String str) {
        int qE = qE(str);
        int i = aED().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (qE + 1);
        return i2 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : i2;
    }

    private static int qG(@NonNull final String str) {
        int i = aED().getInt(str, 300);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aED().putInt(str, d.qF(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aEB() {
        String appId = com.baidu.swan.apps.runtime.d.aIG().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return qG(appId);
    }

    public static int aEC() {
        if (drM != -1) {
            return drM;
        }
        switch (com.baidu.swan.apps.t.a.awZ().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                drM = 300;
                break;
            case 1:
                drM = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aED().putInt("step", com.baidu.swan.apps.t.a.awZ().getSwitch("swan_backstage_interval_setting", 300));
                drM = aEB();
                break;
        }
        if (drM < 60) {
            drM = 60;
        } else if (drM > 3600) {
            drM = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        }
        return drM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aED() {
        return h.tu("sp_launch_behavior");
    }
}
