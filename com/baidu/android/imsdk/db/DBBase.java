package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBBase";
    public static Object mSyncLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes.dex */
    public class UpdateArgs {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] args;
        public String query;
        public final /* synthetic */ DBBase this$0;
        public ContentValues values;

        public UpdateArgs(DBBase dBBase, String str, String[] strArr, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBBase, str, strArr, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBBase;
            this.query = str;
            this.args = strArr;
            this.values = contentValues;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1627734242, "Lcom/baidu/android/imsdk/db/DBBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1627734242, "Lcom/baidu/android/imsdk/db/DBBase;");
                return;
            }
        }
        mSyncLock = new Object();
    }

    public DBBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    public long add(String str, String[] strArr, String str2, String[] strArr2, ContentValues contentValues) {
        InterceptResult invokeLLLLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, str, strArr, str2, strArr2, contentValues)) != null) {
            return invokeLLLLL.longValue;
        }
        SQLiteDatabase openDatabase = openDatabase();
        if (openDatabase == null) {
            LogUtils.d(TAG, "getWritableDb fail!");
            return -1L;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = openDatabase.query(str, strArr, str2, strArr2, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return -1L;
                }
                try {
                    if (query.getCount() > 0) {
                        insert = openDatabase.update(str, contentValues, str2, strArr2);
                    } else {
                        insert = openDatabase.insert(str, null, contentValues);
                    }
                    if (query != null) {
                        query.close();
                    }
                    return insert;
                } catch (Exception e) {
                    e = e;
                    cursor = query;
                    LogUtils.e(TAG, "deleteCmdMsg:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, strArr)) == null) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            try {
                return openDatabase.delete(str, str2, strArr);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "deleteCmdMsg:", e);
                return -1;
            }
        }
        return invokeLLL.intValue;
    }

    public long insert(String str, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, contentValues)) == null) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            try {
                return openDatabase.insert(str, null, contentValues);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "saveCmdMsg:", e);
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public String makePlaceholders(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i < 1) {
                return null;
            }
            StringBuilder sb = new StringBuilder((i * 2) - 1);
            sb.append("?");
            for (int i2 = 1; i2 < i; i2++) {
                sb.append(",?");
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public SQLiteDatabase openDatabase() {
        InterceptResult invokeV;
        SQLiteDatabase openDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (mSyncLock) {
                openDatabase = DBResource.getInstance(this.mContext).openDatabase();
            }
            return openDatabase;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, CursorParse cursorParse) {
        SQLiteDatabase openDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, str2, strArr2, str3, str4, str5, cursorParse}) == null) || (openDatabase = openDatabase()) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
                cursorParse.parseCursor(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e) {
            try {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "query:", e);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    public long queryCount(String str, String[] strArr, String str2, String[] strArr2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, str, strArr, str2, strArr2)) == null) {
            try {
                return queryCount(openDatabase(), str, strArr, str2, strArr2);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(LogUtils.TAG, "queryCount", e);
                return -1L;
            }
        }
        return invokeLLLL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, INVOKE, INVOKE, SGET, INVOKE] complete} */
    public Long querymax(String str) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = openDatabase().rawQuery(str, null);
                    cursor.moveToFirst();
                    j = cursor.getLong(0);
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused) {
                            LogUtils.e(TAG, "close curse exception");
                        }
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                            LogUtils.e(TAG, "close curse exception");
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                String str2 = TAG;
                LogUtils.e(str2, "querymax " + e.getMessage());
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
                j = 0;
            }
            return Long.valueOf(j);
        }
        return (Long) invokeL.objValue;
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, context) == null) || context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
    }

    public int update(String str, String str2, String[] strArr, ContentValues contentValues) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, str2, strArr, contentValues)) == null) {
            UpdateArgs updateArgs = new UpdateArgs(this, str2, strArr, contentValues);
            ArrayList arrayList = new ArrayList();
            if (arrayList.add(updateArgs)) {
                return updateBatch(str, arrayList);
            }
            return -1;
        }
        return invokeLLLL.intValue;
    }

    public int updateBatch(String str, List<UpdateArgs> list) {
        InterceptResult invokeLL;
        IMTrack.CrashBuilder crashBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, list)) == null) {
            int i = -1;
            if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
                return -1;
            }
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                LogUtils.e(TAG, "updateBatch open db = null");
                return -1;
            }
            try {
                try {
                    openDatabase.beginTransaction();
                    for (UpdateArgs updateArgs : list) {
                        i = openDatabase.update(str, updateArgs.values, updateArgs.query, updateArgs.args);
                        if (i < 0) {
                            break;
                        }
                    }
                    if (i >= 0) {
                        openDatabase.setTransactionSuccessful();
                    }
                    if (openDatabase != null) {
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e) {
                            e = e;
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "updateBatch", e);
                            return i;
                        }
                    }
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, String.format("update table %s exception!", str), e2);
                    if (openDatabase != null) {
                        try {
                            openDatabase.endTransaction();
                        } catch (Exception e3) {
                            e = e3;
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "updateBatch", e);
                            return i;
                        }
                    }
                }
                return i;
            } catch (Throwable th) {
                if (openDatabase != null) {
                    try {
                        openDatabase.endTransaction();
                    } catch (Exception e4) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                        LogUtils.e(TAG, "updateBatch", e4);
                    }
                }
                throw th;
            }
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long queryCount(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, str, strArr, str2, strArr2)) == null) {
            if (sQLiteDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1L;
            }
            Cursor cursor = null;
            try {
                try {
                    Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, null, null, null);
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return -1L;
                    }
                    long count = query.getCount();
                    if (query != null) {
                        query.close();
                    }
                    return count;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e) {
                try {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "queryCount", e);
                    if (0 != 0) {
                        cursor.close();
                    }
                    return -1L;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                    }
                    throw th;
                }
            }
        }
        return invokeLLLLL.longValue;
    }

    public int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, str, str2, strArr)) == null) {
            if (sQLiteDatabase == null) {
                LogUtils.d(TAG, "getWritableDb fail!");
                return -1;
            }
            try {
                return sQLiteDatabase.delete(str, str2, strArr);
            } catch (Exception e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                LogUtils.e(TAG, "deleteCmdMsg:", e);
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CursorParse cursorParse) {
        SQLiteDatabase openDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, strArr, str2, strArr2, str3, str4, str5, str6, cursorParse}) == null) || (openDatabase = openDatabase()) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = openDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                cursorParse.parseCursor(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                try {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, "query:", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
