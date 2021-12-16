package com.baidu.down.manage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class DownloadDao {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS downloads (_id  INTEGER PRIMARY KEY AUTOINCREMENT ,URI  TEXT,_DATA  TEXT,SAVED_PATH_FOR_USER  TEXT,MIMETYPE  TEXT,ETAG  TEXT,STATUS  INTEGER,TOTAL_BYTES  INTEGER,CURRENT_BYTES  INTEGER,NOTIFICATIONNEEDED  INTEGER,FAILEDREASON  TEXT,PROGRESSMAP  TEXT,URI_HOST  TEXT,CONTROL_FLAG  INTEGER,FAILED_TYPE  INTEGER,DOWNLOAD_PRIORITY INTEGER, SAVED_SOURCE_KEY_USER TEXT,DOWN_DIR TEXT,FROM_PARAM TEXT,REAL_URI TEXT); ";
    public static final boolean DEBUG;
    public static final String DROP_TABLE_SQL = "DROP TABLE downloads;";
    public static final String TABLENAME = "downloads";
    public static DownloadDao mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadDBHelper db;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1542213692, "Lcom/baidu/down/manage/DownloadDao;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1542213692, "Lcom/baidu/down/manage/DownloadDao;");
                return;
            }
        }
        DEBUG = DownloadConstants.mDebug;
    }

    public DownloadDao(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        this.db = DownloadDBHelper.getInstance(context);
    }

    private ContentValues createContentValues(Download download, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, download, z)) == null) {
            ContentValues contentValues = new ContentValues();
            if (!z) {
                contentValues.put("_id".toUpperCase(), download.getId());
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
            contentValues.put(DownloadConstants.DownloadColumns.COLUMN_DOWN_DIR.toUpperCase(), download.getRealDownloadDir());
            contentValues.put(DownloadConstants.DownloadColumns.COLUMN_FROM_PARAM.toUpperCase(), download.getFromParam());
            contentValues.put(DownloadConstants.DownloadColumns.COLUMN_REAL_URI.toUpperCase(), download.getRealUrl());
            return contentValues;
        }
        return (ContentValues) invokeLZ.objValue;
    }

    public static synchronized DownloadDao getInstance(Context context) {
        InterceptResult invokeL;
        DownloadDao downloadDao;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (DownloadDao.class) {
                if (mInstance == null) {
                    mInstance = new DownloadDao(context);
                }
                downloadDao = mInstance;
            }
            return downloadDao;
        }
        return (DownloadDao) invokeL.objValue;
    }

    public static void releaseSingleInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            DownloadDBHelper downloadDBHelper = mInstance.db;
            if (downloadDBHelper != null) {
                downloadDBHelper.close();
            }
            mInstance = null;
        }
    }

    public boolean deleteByKey(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
                writableDatabase.delete("downloads", "_id =? ", new String[]{j2 + ""});
                return true;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    throw e2;
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public long insert(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, download)) == null) {
            long j2 = -1;
            try {
                try {
                    j2 = this.db.getWritableDatabase().insert("downloads", null, createContentValues(download, true));
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        throw e2;
                    }
                }
                return j2;
            } finally {
                download.setId(-1L);
            }
        }
        return invokeL.longValue;
    }

    public void insertInTx(List<Download> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            try {
                SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
                writableDatabase.beginTransaction();
                for (Download download : list) {
                    download.setId(Long.valueOf(writableDatabase.insert("downloads", null, createContentValues(download, true))));
                }
                writableDatabase.endTransaction();
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    throw e2;
                }
            }
        }
    }

    public List<Download> loadAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? queryList("select * from downloads", null) : (List) invokeV.objValue;
    }

    public List<Download> queryFinshDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return queryList("select * from downloads where STATUS = ?", new String[]{Download.DownloadState.FINISH.ordinal() + ""});
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b A[Catch: all -> 0x002f, Exception -> 0x0031, TRY_LEAVE, TryCatch #2 {Exception -> 0x0031, blocks: (B:5:0x000a, B:7:0x0016, B:9:0x001c, B:12:0x002b), top: B:41:0x000a, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Download> queryList(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = this.db.getReadableDatabase().rawQuery(str, strArr);
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                        throw e2;
                    } else if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    arrayList.add(readEntity(cursor));
                } while (cursor.moveToNext());
                if (cursor != null) {
                }
                return arrayList;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (List) invokeLL.objValue;
    }

    public Download readEntity(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cursor)) == null) {
            Download download = new Download();
            boolean z = false;
            download.setId(cursor.isNull(0) ? null : Long.valueOf(cursor.getLong(0)));
            download.setUrl(cursor.isNull(1) ? "" : cursor.getString(1));
            download.setFileName(cursor.isNull(2) ? "" : cursor.getString(2));
            download.setSavedPathForUser(cursor.isNull(3) ? "" : cursor.getString(3));
            download.setMimetype(cursor.isNull(4) ? "" : cursor.getString(4));
            download.setEtag(cursor.isNull(5) ? "" : cursor.getString(5));
            download.setStatus(Integer.valueOf(cursor.isNull(6) ? Download.DownloadState.WAITING.ordinal() : cursor.getInt(6)));
            download.setTotalbytes(Long.valueOf(cursor.isNull(7) ? 0L : cursor.getLong(7)));
            download.setCurrentbytes(Long.valueOf(cursor.isNull(8) ? 0L : cursor.getLong(8)));
            if (!cursor.isNull(9) && cursor.getInt(9) > 0) {
                z = true;
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
            download.setRealUrl(cursor.isNull(19) ? "" : cursor.getString(19));
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public boolean update(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, download)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
                ContentValues createContentValues = createContentValues(download, false);
                StringBuilder sb = new StringBuilder();
                sb.append(download.getId());
                sb.append("");
                return writableDatabase.update("downloads", createContentValues, "_id = ?", new String[]{sb.toString()}) > 0;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    throw e2;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
