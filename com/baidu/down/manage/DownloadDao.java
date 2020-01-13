package com.baidu.down.manage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class DownloadDao {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS downloads (_id  INTEGER PRIMARY KEY AUTOINCREMENT ,URI  TEXT,_DATA  TEXT,SAVED_PATH_FOR_USER  TEXT,MIMETYPE  TEXT,ETAG  TEXT,STATUS  INTEGER,TOTAL_BYTES  INTEGER,CURRENT_BYTES  INTEGER,NOTIFICATIONNEEDED  INTEGER,FAILEDREASON  TEXT,PROGRESSMAP  TEXT,URI_HOST  TEXT,CONTROL_FLAG  INTEGER,FAILED_TYPE  INTEGER,DOWNLOAD_PRIORITY INTEGER, SAVED_SOURCE_KEY_USER TEXT,DOWN_DIR TEXT,FROM_PARAM TEXT); ";
    private static final boolean DEBUG = DownloadConstants.mDebug;
    public static final String TABLENAME = "downloads";
    private static DownloadDao mInstance;
    private DownloadDBHelper db;
    private Context mContext;

    private DownloadDao(Context context) {
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        this.db = DownloadDBHelper.getInstance(context);
    }

    public static synchronized DownloadDao getInstance(Context context) {
        DownloadDao downloadDao;
        synchronized (DownloadDao.class) {
            if (mInstance == null) {
                mInstance = new DownloadDao(context);
            }
            downloadDao = mInstance;
        }
        return downloadDao;
    }

    public static void releaseSingleInstance() {
        if (mInstance.db != null) {
            mInstance.db.close();
        }
        mInstance = null;
    }

    private ContentValues createContentValues(Download download, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put(IMConstants.MSG_ROW_ID.toUpperCase(), download.getId());
        }
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_URI.toUpperCase(), download.getUrl());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_FILE_NAME.toUpperCase(), download.getFileName());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_SAVED_PATH.toUpperCase(), download.getSavedPathForUser());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_MIME_TYPE.toUpperCase(), download.getMimetype());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_ETAG.toUpperCase(), download.getEtag());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_STATUS.toUpperCase(), Integer.valueOf(download.getState().ordinal()));
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_TOTAL_BYTES.toUpperCase(), download.getTotalbytes());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_CURRENT_BYTES.toUpperCase(), download.getCurrentbytes());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_NEED_N_KEY.toUpperCase(), Integer.valueOf(download.getNotificationNeeded() ? 1 : 0));
        contentValues.put(DownloadConstants.DownloadColumns.FAILED_REASON, download.getFailedReason());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_PROGRESS_MAP.toUpperCase(), download.getProgressmap());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_URI_HOST.toUpperCase(), download.getUrihost());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_CONTROL_FLAG.toUpperCase(), download.getControlFlag());
        contentValues.put(DownloadConstants.DownloadColumns.FAILED_TYPE.toUpperCase(), download.getFailedType());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_DOWNLOAD_PRIORITY.toUpperCase(), Integer.valueOf(download.getPriority()));
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_SOURCE_KEY.toUpperCase(), download.getKeyByUser());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_FROM_PARAM.toUpperCase(), download.getFromParam());
        contentValues.put(DownloadConstants.DownloadColumns.COLUMN_DOWN_DIR.toUpperCase(), download.getRealDownloadDir());
        return contentValues;
    }

    public Download readEntity(Cursor cursor) {
        boolean z;
        Download download = new Download();
        download.setId(cursor.isNull(0) ? null : Long.valueOf(cursor.getLong(0)));
        download.setUrl(cursor.isNull(1) ? "" : cursor.getString(1));
        download.setFileName(cursor.isNull(2) ? "" : cursor.getString(2));
        download.setSavedPathForUser(cursor.isNull(3) ? "" : cursor.getString(3));
        download.setMimetype(cursor.isNull(4) ? "" : cursor.getString(4));
        download.setEtag(cursor.isNull(5) ? "" : cursor.getString(5));
        download.setStatus(Integer.valueOf(cursor.isNull(6) ? Download.DownloadState.WAITING.ordinal() : cursor.getInt(6)));
        download.setTotalbytes(Long.valueOf(cursor.isNull(7) ? 0L : cursor.getLong(7)));
        download.setCurrentbytes(Long.valueOf(cursor.isNull(8) ? 0L : cursor.getLong(8)));
        if (cursor.isNull(9)) {
            z = false;
        } else {
            z = cursor.getInt(9) > 0;
        }
        download.setNotificationNeeded(z);
        download.setFailedReason(cursor.isNull(10) ? "" : cursor.getString(10));
        download.setProgressmap(cursor.isNull(11) ? "" : cursor.getString(11));
        download.setUrihost(cursor.isNull(12) ? "" : cursor.getString(12));
        download.setControlFlag(Long.valueOf(cursor.isNull(13) ? 9L : cursor.getLong(13)));
        download.setFailedType(Integer.valueOf(cursor.isNull(14) ? -1 : cursor.getInt(14)));
        download.setPriority(cursor.isNull(15) ? 3 : cursor.getInt(15));
        download.setKeyByUser(cursor.isNull(16) ? "" : cursor.getString(16));
        download.setDownDir(cursor.isNull(17) ? "" : cursor.getString(17));
        download.setFromParam(cursor.isNull(18) ? "" : cursor.getString(18));
        return download;
    }

    public long insert(Download download) {
        long j = -1;
        try {
            j = this.db.getWritableDatabase().insert("downloads", null, createContentValues(download, true));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                throw e;
            }
        } finally {
            download.setId(-1L);
        }
        return j;
    }

    public boolean update(Download download) {
        try {
            return this.db.getWritableDatabase().update("downloads", createContentValues(download, false), "_id = ?", new String[]{new StringBuilder().append(download.getId()).append("").toString()}) > 0;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                throw e;
            }
            return false;
        }
    }

    public void insertInTx(List<Download> list) {
        try {
            SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (Download download : list) {
                download.setId(Long.valueOf(writableDatabase.insert("downloads", null, createContentValues(download, true))));
            }
            writableDatabase.endTransaction();
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public boolean deleteByKey(long j) {
        try {
            this.db.getWritableDatabase().delete("downloads", "_id =? ", new String[]{j + ""});
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                throw e;
            }
            return false;
        }
    }

    public List<Download> loadAll() {
        return queryList("select * from downloads", null);
    }

    public List<Download> queryFinshDownload() {
        return queryList("select * from downloads where STATUS = ?", new String[]{Download.DownloadState.FINISH.ordinal() + ""});
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Download> queryList(String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.db.getReadableDatabase().rawQuery(str, strArr);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                arrayList.add(readEntity(cursor));
                            } while (cursor.moveToNext());
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                            throw e;
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        return arrayList;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                Cursor cursor3 = null;
                if (0 != 0) {
                    try {
                        cursor3.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return arrayList;
    }
}
