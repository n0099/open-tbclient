package com.baidu.tbadk.core.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.a.d {
    public aw() {
        super(m.FK + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_DATABASE_NAME, 11);
    }

    @Override // com.baidu.adp.base.a.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 9) {
            T(sQLiteDatabase);
        }
        if (i < 11) {
            b(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
            b(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
            if (i > 9) {
                b(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
            }
        }
    }

    @Override // com.baidu.adp.base.a.d
    public void d(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        b(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
        b(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        b(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        T(sQLiteDatabase);
    }

    @Override // com.baidu.adp.base.a.d
    public void e(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "DROP TABLE IF EXISTS pb_photo");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS friend_photo");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS user_icon");
    }

    private void T(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        b(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }
}
