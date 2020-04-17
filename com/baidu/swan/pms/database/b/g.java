package com.baidu.swan.pms.database.b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.pms.model.h;
/* loaded from: classes11.dex */
public class g implements a<h> {
    public String aBM() {
        return "swan_plugin";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aBN());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 2:
                    sQLiteDatabase.execSQL(aBN());
                    break;
                case 3:
                    z(sQLiteDatabase);
                    break;
                case 5:
                    A(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private String aBN() {
        return "CREATE TABLE " + aBM() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT NOT NULL,category INT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0," + TiebaInitialize.LogFields.SIZE + " LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL,file_path TEXT,current_size LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0,max_age LONG DEFAULT 0,token TEXT,domains TEXT,app_key TEXT,app_name TEXT, UNIQUE (bundle_id,version_name));";
    }

    private void z(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aBM() + " ADD COLUMN token TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + aBM() + " ADD COLUMN domains TEXT");
        } catch (SQLException e) {
        }
    }

    private void A(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aBM() + " ADD COLUMN app_key TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + aBM() + " ADD COLUMN app_name TEXT");
        } catch (SQLException e) {
        }
    }
}
