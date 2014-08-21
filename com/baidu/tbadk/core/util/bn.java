package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
class bn implements Callable<Boolean> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [486=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Boolean call() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.a.openOrCreateDatabase("webviewCache.db", 0, null);
        } catch (Throwable th) {
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e(th.getMessage());
                }
            } finally {
                com.baidu.adp.lib.util.m.a(sQLiteDatabase);
            }
        }
        if (sQLiteDatabase != null) {
            return false;
        }
        com.baidu.adp.lib.util.m.a(sQLiteDatabase);
        return true;
    }
}
