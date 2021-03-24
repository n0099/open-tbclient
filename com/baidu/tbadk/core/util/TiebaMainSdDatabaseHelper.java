package com.baidu.tbadk.core.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TbConfig;
import d.b.b.a.k.d;
/* loaded from: classes3.dex */
public class TiebaMainSdDatabaseHelper extends d {
    public static final int DATABASE_VERSION = 11;

    public TiebaMainSdDatabaseHelper() {
        super(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_DATABASE_NAME, 11);
    }

    private void createUserIcon(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }

    @Override // d.b.b.a.k.d
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS pb_photo");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS friend_photo");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_icon");
    }

    @Override // d.b.b.a.k.d
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        createUserIcon(sQLiteDatabase);
    }

    @Override // d.b.b.a.k.a
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
}
