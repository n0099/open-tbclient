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
/* loaded from: classes2.dex */
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

    public List<Download> loadAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return queryList("select * from downloads", null);
        }
        return (List) invokeV.objValue;
    }

    public DownloadDao(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        this.db = DownloadDBHelper.getInstance(context);
    }

    public boolean deleteByKey(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
                writableDatabase.delete("downloads", "_id =? ", new String[]{j + ""});
                return true;
            } catch (Exception e) {
                if (!DEBUG) {
                    return false;
                }
                e.printStackTrace();
                throw e;
            }
        }
        return invokeJ.booleanValue;
    }

    public long insert(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, download)) == null) {
            long j = -1;
            try {
                try {
                    j = this.db.getWritableDatabase().insert("downloads", null, createContentValues(download, true));
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        throw e;
                    }
                }
                return j;
            } finally {
                download.setId(-1L);
            }
        }
        return invokeL.longValue;
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
            } catch (Exception e) {
                if (!DEBUG) {
                    return;
                }
                e.printStackTrace();
                throw e;
            }
        }
    }

    public boolean update(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, download)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.db.getWritableDatabase();
                ContentValues createContentValues = createContentValues(download, false);
                if (writableDatabase.update("downloads", createContentValues, "_id = ?", new String[]{download.getId() + ""}) <= 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                if (!DEBUG) {
                    return false;
                }
                e.printStackTrace();
                throw e;
            }
        }
        return invokeL.booleanValue;
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
                } catch (Exception e) {
                    if (!DEBUG) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        e.printStackTrace();
                        throw e;
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        arrayList.add(readEntity(cursor));
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                    }
                    return arrayList;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (List) invokeLL.objValue;
    }

    public Download readEntity(Cursor cursor) {
        InterceptResult invokeL;
        Long valueOf;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        int i;
        long j;
        String string6;
        String string7;
        String string8;
        long j2;
        int i2;
        String string9;
        String string10;
        String string11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cursor)) == null) {
            Download download = new Download();
            boolean z = false;
            if (cursor.isNull(0)) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(cursor.getLong(0));
            }
            download.setId(valueOf);
            String str = "";
            if (cursor.isNull(1)) {
                string = "";
            } else {
                string = cursor.getString(1);
            }
            download.setUrl(string);
            if (cursor.isNull(2)) {
                string2 = "";
            } else {
                string2 = cursor.getString(2);
            }
            download.setFileName(string2);
            int i3 = 3;
            if (cursor.isNull(3)) {
                string3 = "";
            } else {
                string3 = cursor.getString(3);
            }
            download.setSavedPathForUser(string3);
            if (cursor.isNull(4)) {
                string4 = "";
            } else {
                string4 = cursor.getString(4);
            }
            download.setMimetype(string4);
            if (cursor.isNull(5)) {
                string5 = "";
            } else {
                string5 = cursor.getString(5);
            }
            download.setEtag(string5);
            if (cursor.isNull(6)) {
                i = Download.DownloadState.WAITING.ordinal();
            } else {
                i = cursor.getInt(6);
            }
            download.setStatus(Integer.valueOf(i));
            long j3 = 0;
            if (cursor.isNull(7)) {
                j = 0;
            } else {
                j = cursor.getLong(7);
            }
            download.setTotalbytes(Long.valueOf(j));
            if (!cursor.isNull(8)) {
                j3 = cursor.getLong(8);
            }
            download.setCurrentbytes(Long.valueOf(j3));
            if (!cursor.isNull(9) && cursor.getInt(9) > 0) {
                z = true;
            }
            download.setNotificationNeeded(z);
            if (cursor.isNull(10)) {
                string6 = "";
            } else {
                string6 = cursor.getString(10);
            }
            download.setFailedReason(string6);
            if (cursor.isNull(11)) {
                string7 = "";
            } else {
                string7 = cursor.getString(11);
            }
            download.setProgressmap(string7);
            if (cursor.isNull(12)) {
                string8 = "";
            } else {
                string8 = cursor.getString(12);
            }
            download.setUrihost(string8);
            if (cursor.isNull(13)) {
                j2 = 9;
            } else {
                j2 = cursor.getLong(13);
            }
            download.setControlFlag(Long.valueOf(j2));
            if (cursor.isNull(14)) {
                i2 = -1;
            } else {
                i2 = cursor.getInt(14);
            }
            download.setFailedType(Integer.valueOf(i2));
            if (!cursor.isNull(15)) {
                i3 = cursor.getInt(15);
            }
            download.setPriority(i3);
            if (cursor.isNull(16)) {
                string9 = "";
            } else {
                string9 = cursor.getString(16);
            }
            download.setKeyByUser(string9);
            if (cursor.isNull(17)) {
                string10 = "";
            } else {
                string10 = cursor.getString(17);
            }
            download.setDownDir(string10);
            if (cursor.isNull(18)) {
                string11 = "";
            } else {
                string11 = cursor.getString(18);
            }
            download.setFromParam(string11);
            if (!cursor.isNull(19)) {
                str = cursor.getString(19);
            }
            download.setRealUrl(str);
            return download;
        }
        return (Download) invokeL.objValue;
    }
}
