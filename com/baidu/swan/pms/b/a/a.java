package com.baidu.swan.pms.b.a;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes15.dex */
public class a implements com.baidu.swan.pms.database.b.a<com.baidu.swan.pms.b.a> {
    public String aWS() {
        return "swan_mini_pkg";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aWT());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 4:
                    sQLiteDatabase.execSQL(aWT());
                    break;
            }
            i++;
        }
    }

    private String aWT() {
        return "CREATE TABLE " + aWS() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,bundle_id TEXT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL, UNIQUE (app_id,bundle_id));";
    }
}
