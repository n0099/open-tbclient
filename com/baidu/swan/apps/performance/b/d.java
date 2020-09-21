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
/* loaded from: classes3.dex */
public class d {
    private static int cJA = -1;

    @AnyThread
    public static void axa() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                e aAs = e.aAs();
                if (aAs != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appKey", aAs.getAppId());
                    contentValues.put("launch_type", Integer.valueOf(g.aDl()));
                    contentValues.put("source", aAs.aAv().arx());
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    ContentResolver contentResolver = com.baidu.swan.apps.t.a.apu().getContentResolver();
                    if (contentResolver != null) {
                        contentResolver.insert(com.baidu.swan.apps.database.favorite.d.alN(), contentValues);
                    }
                }
            }
        }, "SwanLaunchBehavior");
    }

    @WorkerThread
    @IntRange(from = 0)
    private static int pK(@NonNull String str) {
        ContentResolver contentResolver = com.baidu.swan.apps.t.a.apu().getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(com.baidu.swan.apps.database.favorite.d.alN(), null, "time>? and appKey=?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000), str}, null);
            int count = query != null ? query.getCount() : 0;
            com.baidu.swan.c.d.closeSafely(query);
            return count;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static int pL(@NonNull String str) {
        int pK = pK(str);
        int i = axd().getInt("step", 300);
        int i2 = (i > 0 ? i : 300) * (pK + 1);
        if (i2 > 3600) {
            return 3600;
        }
        return i2;
    }

    private static int pM(@NonNull final String str) {
        int i = axd().getInt(str, 300);
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.performance.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.axd().putInt(str, d.pL(str));
            }
        }, "SwanLaunchBehavior");
        return i;
    }

    private static int axb() {
        String appId = com.baidu.swan.apps.runtime.d.aAn().getAppId();
        if (TextUtils.isEmpty(appId)) {
            return 300;
        }
        return pM(appId);
    }

    public static int axc() {
        if (cJA != -1) {
            return cJA;
        }
        switch (com.baidu.swan.apps.t.a.apx().getSwitch("swan_backstage_policy", 0)) {
            case 0:
                cJA = 300;
                break;
            case 1:
                cJA = com.baidu.swan.apps.t.a.apx().getSwitch("swan_backstage_interval_setting", 300);
                break;
            case 2:
                axd().putInt("step", com.baidu.swan.apps.t.a.apx().getSwitch("swan_backstage_interval_setting", 300));
                cJA = axb();
                break;
        }
        if (cJA < 60) {
            cJA = 60;
        } else if (cJA > 3600) {
            cJA = 3600;
        }
        return cJA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.storage.c.b axd() {
        return h.su("sp_launch_behavior");
    }
}
