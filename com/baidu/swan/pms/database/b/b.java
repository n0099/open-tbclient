package com.baidu.swan.pms.database.b;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.SocialConstants;
/* loaded from: classes2.dex */
public class b implements a<com.baidu.swan.pms.model.a> {
    public String RD() {
        return "swan_app";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(RE());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private String RE() {
        return "CREATE TABLE " + RD() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT UNIQUE,app_key TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0,version_name TEXT," + SocialConstants.PARAM_COMMENT + " TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT,bear_info TEXT,server_ext TEXT);";
    }
}
