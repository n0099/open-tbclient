package com.baidu.live.adp.lib.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.live.adp.base.db.PhoneDatabaseHelper;
import com.baidu.live.adp.framework.MessageManager;
/* loaded from: classes3.dex */
public class BdCacheSQLiteHelper extends PhoneDatabaseHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_CACHE_META_INFO = "cache_meta_info";

    public BdCacheSQLiteHelper(Context context, String str) {
        super(context, str, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 1) {
            prepareTableForVersion1(sQLiteDatabase);
        }
    }

    protected void prepareTableForVersion1(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
    }

    @Override // com.baidu.live.adp.base.db.PhoneDatabaseHelper
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        prepareTableForVersion1(sQLiteDatabase);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new BdDatabaseNewCreatedMessage(sQLiteDatabase));
    }

    @Override // com.baidu.live.adp.base.db.PhoneDatabaseHelper
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
    }
}
