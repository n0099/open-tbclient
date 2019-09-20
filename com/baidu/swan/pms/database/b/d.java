package com.baidu.swan.pms.database.b;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.sapi2.activity.social.WXLoginActivity;
/* loaded from: classes2.dex */
public class d implements a<com.baidu.swan.pms.model.d> {
    public String Wl() {
        return "framework";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(Wm());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private String Wm() {
        return "CREATE TABLE " + Wl() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT UNIQUE,category INT NOT NULL,version_name TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0,md5 TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL,file_path TEXT,current_size LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0," + WXLoginActivity.KEY_BASE_RESP_STATE + " INT DEFAULT 0);";
    }
}
