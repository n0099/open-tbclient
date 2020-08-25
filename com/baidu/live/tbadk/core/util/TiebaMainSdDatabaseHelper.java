package com.baidu.live.tbadk.core.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.SDCardDatabaseHelper;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class TiebaMainSdDatabaseHelper extends SDCardDatabaseHelper {
    public static final int DATABASE_VERSION = 11;

    public TiebaMainSdDatabaseHelper() {
        super(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/tieba_database.db", 11);
    }

    @Override // com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 9) {
            createUserIcon(sQLiteDatabase);
        }
        if (i < 11) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
            if (i > 9) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
            }
        }
    }

    @Override // com.baidu.live.adp.base.db.SDCardDatabaseHelper
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        createUserIcon(sQLiteDatabase);
    }

    @Override // com.baidu.live.adp.base.db.SDCardDatabaseHelper
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS pb_photo");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS friend_photo");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_icon");
    }

    private void createUserIcon(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }
}
