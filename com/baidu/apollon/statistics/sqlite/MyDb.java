package com.baidu.apollon.statistics.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public abstract class MyDb extends SQLiteOpenHelper {
    public SQLiteDatabase mDb;

    public MyDb(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        try {
            this.mDb = getWritableDatabase();
        } catch (SQLiteException e2) {
            this.mDb = null;
            e2.printStackTrace();
        }
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        sQLiteDatabase.execSQL("create table if not exists " + str + " (" + str2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void finalize() throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null) {
            if (sQLiteDatabase.isOpen()) {
                this.mDb.close();
            }
            this.mDb = null;
        }
        super.finalize();
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        StringBuilder sb = new StringBuilder("create table if not exists ");
        sb.append(str);
        sb.append(" (");
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append(",");
        }
        int length = sb.length();
        sb.replace(length - 1, length, SmallTailInfo.EMOTION_SUFFIX);
        sQLiteDatabase.execSQL(sb.toString());
    }
}
