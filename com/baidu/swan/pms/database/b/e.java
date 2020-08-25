package com.baidu.swan.pms.database.b;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes14.dex */
public class e implements a<com.baidu.swan.pms.model.f> {
    public String aTx() {
        return "pkg_main";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aTy());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private String aTy() {
        return "CREATE TABLE " + aTx() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT UNIQUE,category INT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL,pkg_type INT DEFAULT 0,file_path TEXT,current_size LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0);";
    }
}
