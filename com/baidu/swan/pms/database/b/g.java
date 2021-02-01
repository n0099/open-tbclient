package com.baidu.swan.pms.database.b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes3.dex */
public class g implements a<com.baidu.swan.pms.model.h> {
    public String bcz() {
        return "swan_plugin";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(bcA());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 2:
                    sQLiteDatabase.execSQL(bcA());
                    break;
                case 3:
                    F(sQLiteDatabase);
                    break;
                case 5:
                    G(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private String bcA() {
        return "CREATE TABLE " + bcz() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT NOT NULL,category INT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0," + TiebaInitialize.LogFields.SIZE + " LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL,file_path TEXT,current_size LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0,max_age LONG DEFAULT 0,token TEXT,domains TEXT,app_key TEXT,app_name TEXT, UNIQUE (bundle_id,version_name));";
    }

    private void F(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + bcz() + " ADD COLUMN token TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + bcz() + " ADD COLUMN domains TEXT");
        } catch (SQLException e) {
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + bcz() + " ADD COLUMN app_key TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + bcz() + " ADD COLUMN app_name TEXT");
        } catch (SQLException e) {
        }
    }
}
