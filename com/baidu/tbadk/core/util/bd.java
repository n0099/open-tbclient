package com.baidu.tbadk.core.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.a.e {
    public bd() {
        super(s.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_DATABASE_NAME, 11);
    }

    @Override // com.baidu.adp.base.a.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 9) {
            d(sQLiteDatabase);
        }
        if (i < 11) {
            a(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
            a(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
            if (i > 9) {
                a(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
            }
        }
    }

    @Override // com.baidu.adp.base.a.e
    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        a(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
        a(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        a(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        d(sQLiteDatabase);
    }

    @Override // com.baidu.adp.base.a.e
    public void b(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "DROP TABLE IF EXISTS pb_photo");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS friend_photo");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS user_icon");
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        a(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }
}
