package com.baidu.swan.pms.database.b;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes6.dex */
public class f implements a<com.baidu.swan.pms.model.g> {
    public String bcm() {
        return "pkg_sub";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(bcn());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private String bcn() {
        return "CREATE TABLE " + bcm() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL,bundle_id TEXT NOT NULL,category INT NOT NULL," + SharedPrefConfig.VERSION_NAME + " TEXT NOT NULL,version_code INT DEFAULT 0," + TiebaInitialize.LogFields.SIZE + " LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL,independent INT DEFAULT 0,sub_pkg_name TEXT NOT NULL,file_path TEXT,current_size LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0, UNIQUE (app_id,sub_pkg_name));";
    }
}
