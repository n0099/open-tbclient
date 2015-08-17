package com.baidu.adp.lib.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.a.c {
    public j(Context context, String str) {
        super(context, str, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.adp.base.a.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 1) {
            g(sQLiteDatabase);
        }
    }

    protected void g(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
    }

    @Override // com.baidu.adp.base.a.c
    public void c(SQLiteDatabase sQLiteDatabase) {
        g(sQLiteDatabase);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new BdDatabaseNewCreatedMessage(sQLiteDatabase));
    }
}
