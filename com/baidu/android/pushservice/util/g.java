package com.baidu.android.pushservice.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends SQLiteOpenHelper {
    public g(Context context, String str, int i) {
        super(new f(context), str, (SQLiteDatabase.CursorFactory) null, i);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgResultInfo");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE MsgResultInfo (" + k.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + k.msg_id.name() + " TEXT NOT NULL, " + k.result_code.name() + " INTEGER NOT NULL, " + k.app_id.name() + " TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE StatisticsInfo (" + m.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + m.packageName.name() + " TEXT NOT NULL, " + m.open_type.name() + " TEXT NOT NULL, " + m.msgid.name() + " TEXT, " + m.app_open_time.name() + " TEXT NOT NULL, " + m.app_close_time.name() + " TEXT NOT NULL, " + m.use_duration.name() + " TEXT NOT NULL, " + m.extra.name() + " TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE FileDownloadingInfo (" + h.belongTo.name() + " TEXT, " + h.downloadUrl.name() + " TEXT PRIMARY KEY, " + h.savePath.name() + " TEXT NOT NULL, " + h.title.name() + " TEXT, " + h.description.name() + " TEXT, " + h.fileName.name() + " TEXT NOT NULL, " + h.downloadBytes.name() + " INTEGER NOT NULL, " + h.totalBytes.name() + " INTEGER NOT NULL, " + h.downloadStatus.name() + " INTEGER NOT NULL," + h.timeStamp.name() + " INTEGER NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
