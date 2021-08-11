package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.db.DownloadDatabaseHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DatabaseMng {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME = "bddownloads.db";
    public static final int DB_VERSION = 1;
    public static final String DEFAULT_SORT_ORDER = "_id DESC";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public DownloadDatabaseHelper mDBHelper;
    public SQLiteDatabase mDb;
    public DownloadDataConstants mDownLoad;

    public DatabaseMng(Context context) {
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
        DownloadDatabaseHelper downloadDatabaseHelper = new DownloadDatabaseHelper(context);
        this.mDBHelper = downloadDatabaseHelper;
        try {
            this.mDb = downloadDatabaseHelper.getWritableDatabase();
        } catch (SQLiteException unused) {
        }
        this.mDownLoad = new DownloadDataConstants(this.mContext);
    }

    public int delete(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) ? this.mDownLoad.delete(this.mDb, str, strArr) : invokeLL.intValue;
    }

    public DownloadDataConstants getDownLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDownLoad : (DownloadDataConstants) invokeV.objValue;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDb : (SQLiteDatabase) invokeV.objValue;
    }

    public long insert(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, contentValues)) == null) ? this.mDownLoad.insert(this.mDb, contentValues) : invokeL.longValue;
    }

    public int insertOrUpdate(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, contentValues)) == null) ? this.mDownLoad.insertOrUpdate(this.mDb, contentValues) : invokeL.intValue;
    }

    public long insertToDatabase(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, str, str2, str3, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", str);
            contentValues.put("name", str2);
            contentValues.put("path", str3);
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(i2));
            return this.mDownLoad.insert(this.mDb, contentValues);
        }
        return invokeLLLI.longValue;
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{strArr, str, strArr2, str2, str3, str4})) == null) ? this.mDownLoad.query(this.mDb, strArr, str, strArr2, str2, str3, str4) : (Cursor) invokeCommon.objValue;
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, contentValues, str, strArr)) == null) ? this.mDownLoad.update(this.mDb, contentValues, str, strArr) : invokeLLL.intValue;
    }
}
