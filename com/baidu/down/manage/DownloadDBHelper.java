package com.baidu.down.manage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.down.manage.DownloadConstants;
/* loaded from: classes15.dex */
public final class DownloadDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DaoMaster";
    private static DownloadDBHelper mInstance;
    private final Context mCtx;
    private static final boolean DEBUG = DownloadConstants.mDebug;
    private static int DATA_VERSION = 2;

    private DownloadDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.mCtx = context;
    }

    public static synchronized DownloadDBHelper getInstance(Context context) {
        DownloadDBHelper downloadDBHelper;
        synchronized (DownloadDBHelper.class) {
            if (mInstance == null) {
                mInstance = new DownloadDBHelper(context, "downloads", null, DATA_VERSION);
            }
            downloadDBHelper = mInstance;
        }
        return downloadDBHelper;
    }

    private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE downloads ADD COLUMN " + str + " " + str2);
        } catch (SQLException e) {
            Log.e(TAG, "couldn't add column: " + e.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(DownloadDao.CREATE_TABLE_SQL);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 == 2) {
            addColumn(sQLiteDatabase, DownloadConstants.DownloadColumns.COLUMN_DOWN_DIR, "TEXT");
            addColumn(sQLiteDatabase, DownloadConstants.DownloadColumns.COLUMN_FROM_PARAM, "TEXT");
        }
    }
}
