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
    private static int duq = -1;

    @AnyThread
    public static void aHZ() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aMm = e.aMm();
                if (aMm != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aMm.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.getStartType()));
                    contentValues.put("source", aMm.aMp().aCw());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.aAs().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.awN(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @IntRange(from = 0)
    @WorkerThread
    private static int rx(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.aAs().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.awN(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int ry(@NonNull String str) {
        int rx2 = rx(str);
        int i = aIc().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (rx2 + 1);
        return i2 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : i2;
    }

    private static int rz(@NonNull final String str) {
        int i = aIc().getInt(str, 300);
        p.a(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.aIc().putInt(str, d.ry(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int aIa() {
        String appId = com.baidu.swan.apps.runtime.d.aMh().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return rz(appId);
    }

    public static int aIb() {
        if (duq != -1) {
            return duq;
        }
        switch (com.baidu.swan.apps.t.a.aAv().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                duq = 300;
                break;
            case 1:
                duq = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                aIc().putInt("step", com.baidu.swan.apps.t.a.aAv().getSwitch("swan_backstage_interval_setting", 300));
                duq = aIa();
                break;
        }
        if (duq < 60) {
            duq = 60;
        } else if (duq > 3600) {
            duq = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        }
        return duq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b aIc() {
        return h.um("sp_launch_behavior");
    }
}
