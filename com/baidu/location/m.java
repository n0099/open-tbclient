package com.baidu.location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
class m extends SQLiteOpenHelper {
    private static m a = null;

    /* renamed from: do  reason: not valid java name */
    private static final String f105do = "bd_geofence.db";

    /* renamed from: if  reason: not valid java name */
    private static final int f106if = 2;

    public m(Context context) {
        super(context, f105do, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m(context);
            }
            mVar = a;
        }
        return mVar;
    }

    private String a(String str, String str2, String str3) {
        return "ALTER TABLE " + str + " ADD " + str2 + " " + str3;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS geofence (_id INTEGER PRIMARY KEY AUTOINCREMENT,geofence_id NTEXT,longitude NTEXT,latitude NTEXT,radius_type INTEGER,radius NTEXT,valid_date INTEGER,duration_millis INTEGER,coord_type NTEXT,next_active_time INTEGER,is_lac INTEGER,is_cell INTEGER,is_wifi INTEGER,next_exit_active_time INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS geofence_detail (_id INTEGER PRIMARY KEY AUTOINCREMENT,geofence_id NTEXT,ap NTEXT,ap_backup NTEXT);");
        sQLiteDatabase.execSQL("CREATE INDEX  IF NOT EXISTS ap_index ON geofence_detail (ap);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            a("geofence", "next_exit_active_time", "INTEGER");
        }
        a(sQLiteDatabase);
    }
}
