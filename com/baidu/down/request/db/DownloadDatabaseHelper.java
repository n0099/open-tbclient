package com.baidu.down.request.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.taskmanager.DatabaseMng;
/* loaded from: classes6.dex */
public class DownloadDatabaseHelper extends SQLiteOpenHelper {
    public DownloadDatabaseHelper(Context context) {
        super(context, DatabaseMng.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createDownloadsTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (int i3 = i + 1; i3 <= i2; i3++) {
            upgradeTo(sQLiteDatabase, i3);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        createDownloadsTable(sQLiteDatabase);
    }

    private void upgradeTo(SQLiteDatabase sQLiteDatabase, int i) {
        switch (i) {
            case 2:
                addColumn(sQLiteDatabase, "downloads", DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP, "TEXT");
                return;
            default:
                throw new IllegalStateException("Don't know how to upgrade to " + i);
        }
    }

    private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + HanziToPinyin.Token.SEPARATOR + str3);
    }

    private void createDownloadsTable(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, name TEXT, path TEXT, data TEXT, mimetype TEXT, etag TEXT, tasktype INTEGER, status INTEGER DEFAULT 0, lastmodification BIGINT DEFAULT " + System.currentTimeMillis() + ", " + DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP + " TEXT, " + DownloadDataConstants.Columns.COLUMN_RETRY_COUNT + " INTEGER DEFAULT 0);");
        } catch (SQLException e) {
            throw e;
        }
    }
}
