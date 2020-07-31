package com.baidu.swan.pms.b.a;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes19.dex */
public class a implements com.baidu.swan.pms.database.b.a<com.baidu.swan.pms.b.a> {
    public String aKW() {
        return "swan_mini_pkg";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aKX());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 4:
                    sQLiteDatabase.execSQL(aKX());
                    break;
            }
            i++;
        }
    }

    private String aKX() {
        return "CREATE TABLE " + aKW() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,bundle_id TEXT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0," + TiebaInitialize.LogFields.SIZE + " LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL, UNIQUE (app_id,bundle_id));";
    }
}
