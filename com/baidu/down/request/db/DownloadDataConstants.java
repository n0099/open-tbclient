package com.baidu.down.request.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class DownloadDataConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_TABLE = "downloads";
    public static final String DEFAULT_DL_BINARY_EXTENSION = ".bin";
    public static final String DEFAULT_DL_HTML_EXTENSION = ".html";
    public static final String DEFAULT_DL_TEXT_EXTENSION = ".txt";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes10.dex */
    public static final class Columns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        public static final String COLUMN_ETAG = "etag";
        public static final String COLUMN_FILE_DATA = "data";
        public static final String COLUMN_FILE_NAME = "name";
        public static final String COLUMN_FILE_PATH = "path";
        public static final String COLUMN_LAST_MODIFICATION = "lastmodification";
        public static final String COLUMN_MIME_TYPE = "mimetype";
        public static final String COLUMN_PROGRESS_MAP = "progress_map";
        public static final String COLUMN_RETRY_COUNT = "retry_count";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TASK_TYPE = "tasktype";
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        public static final String COLUMN_URI = "uri";
        public transient /* synthetic */ FieldHolder $fh;

        public Columns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public DownloadDataConstants(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public int delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, sQLiteDatabase, str, strArr)) == null) ? sQLiteDatabase.delete("downloads", str, strArr) : invokeLLL.intValue;
    }

    public long insert(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, contentValues)) == null) ? sQLiteDatabase.insert("downloads", null, contentValues) : invokeLL.longValue;
    }

    public int insertOrUpdate(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, contentValues)) == null) {
            long longValue = contentValues.getAsLong("_id").longValue();
            if (sQLiteDatabase.query("downloads", null, "_id=?", new String[]{longValue + ""}, null, null, null).moveToFirst()) {
                return sQLiteDatabase.update("downloads", contentValues, "_id=?", new String[]{longValue + ""});
            }
            return (int) sQLiteDatabase.insert("downloads", null, contentValues);
        }
        return invokeLL.intValue;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{sQLiteDatabase, strArr, str, strArr2, str2, str3, str4})) == null) ? sQLiteDatabase.query("downloads", strArr, str, strArr2, str2, str3, str4) : (Cursor) invokeCommon.objValue;
    }

    public int update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, sQLiteDatabase, contentValues, str, strArr)) == null) ? sQLiteDatabase.update("downloads", contentValues, str, strArr) : invokeLLLL.intValue;
    }
}
