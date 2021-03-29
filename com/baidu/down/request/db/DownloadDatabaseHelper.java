package com.baidu.down.request.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.taskmanager.DatabaseMng;
/* loaded from: classes.dex */
public class DownloadDatabaseHelper extends SQLiteOpenHelper {
    public DownloadDatabaseHelper(Context context) {
        super(context, DatabaseMng.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
    }

    private void createDownloadsTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, name TEXT, path TEXT, data TEXT, mimetype TEXT, etag TEXT, tasktype INTEGER, status INTEGER DEFAULT 0, lastmodification BIGINT DEFAULT " + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "total_bytes BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP + " TEXT, retry_count INTEGER DEFAULT 0);");
        } catch (SQLException e2) {
            throw e2;
        }
    }

    private void upgradeTo(SQLiteDatabase sQLiteDatabase, int i) {
        if (i == 2) {
            addColumn(sQLiteDatabase, "downloads", DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP, "TEXT");
            return;
        }
        throw new IllegalStateException("Don't know how to upgrade to " + i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createDownloadsTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        createDownloadsTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (true) {
            i++;
            if (i > i2) {
                return;
            }
            upgradeTo(sQLiteDatabase, i);
        }
    }
}
