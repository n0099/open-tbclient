package com.baidu.searchbox.aideviceperformance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class DataBaseOpenHelper extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "DataBaseOpenHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public OnSqliteUpdateListener onSqliteUpdateListener;

    /* loaded from: classes4.dex */
    public interface OnSqliteUpdateListener {
        void onSqliteUpdateListener(SQLiteDatabase sQLiteDatabase, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(440206458, "Lcom/baidu/searchbox/aideviceperformance/data/DataBaseOpenHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(440206458, "Lcom/baidu/searchbox/aideviceperformance/data/DataBaseOpenHelper;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataBaseOpenHelper(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void delete(String str, String str2, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, strArr) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    synchronized (this) {
                        sQLiteDatabase = getWritableDatabase();
                        sQLiteDatabase.delete(str, str2, strArr);
                    }
                } catch (Exception unused) {
                    boolean z = DEBUG;
                    if (sQLiteDatabase == null) {
                        return;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    public void deleteAll(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            delete(str, null, null);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void execSQL(String str, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    synchronized (this) {
                        sQLiteDatabase = getWritableDatabase();
                        sQLiteDatabase.execSQL(str, objArr);
                    }
                } catch (Exception unused) {
                    boolean z = DEBUG;
                    if (sQLiteDatabase == null) {
                        return;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    public abstract String getBatchDeleteSqlStr();

    public abstract int getRestrictionNum();

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x009e */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0093, code lost:
        if (r9 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        if (r9 == null) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void insert(String str, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, contentValues) == null) {
            synchronized (this) {
                SQLiteDatabase sQLiteDatabase2 = 0;
                r0 = null;
                Cursor cursor = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase2 = 1048581;
                }
                try {
                    sQLiteDatabase = getWritableDatabase();
                    try {
                        sQLiteDatabase.insert(str, null, contentValues);
                        if (isEnableCountRestriction().booleanValue()) {
                            try {
                                try {
                                    cursor = sQLiteDatabase.query(str, new String[]{"count(*)"}, null, null, null, null, null);
                                    cursor.moveToFirst();
                                    int i2 = cursor.getInt(0);
                                    if (DEBUG) {
                                        String str2 = "db name: " + getDatabaseName() + " total count: " + i2;
                                    }
                                    if (i2 > getRestrictionNum()) {
                                        String batchDeleteSqlStr = getBatchDeleteSqlStr();
                                        if (DEBUG) {
                                            String str3 = "delete sql str: " + batchDeleteSqlStr;
                                        }
                                        sQLiteDatabase.execSQL(batchDeleteSqlStr);
                                    }
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (Exception unused) {
                                    boolean z = DEBUG;
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            e = e3;
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Exception unused2) {
                        if (0 != 0) {
                            sQLiteDatabase2.close();
                        }
                        boolean z2 = DEBUG;
                    }
                } catch (Exception unused3) {
                    sQLiteDatabase = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase2 != 0) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            }
        }
    }

    public Boolean isEnableCountRestriction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Boolean.FALSE : (Boolean) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        OnSqliteUpdateListener onSqliteUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048583, this, sQLiteDatabase, i2, i3) == null) || (onSqliteUpdateListener = this.onSqliteUpdateListener) == null) {
            return;
        }
        onSqliteUpdateListener.onSqliteUpdateListener(sQLiteDatabase, i2, i3);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor query;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, strArr, str2, strArr2, str3, str4, str5})) == null) {
            try {
                synchronized (this) {
                    query = getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
                }
                return query;
            } catch (Exception unused) {
                boolean z = DEBUG;
                return null;
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        Cursor rawQuery;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, strArr)) == null) {
            try {
                synchronized (this) {
                    rawQuery = getReadableDatabase().rawQuery(str, strArr);
                }
                return rawQuery;
            } catch (Exception unused) {
                boolean z = DEBUG;
                return null;
            }
        }
        return (Cursor) invokeLL.objValue;
    }

    public void setOnSqliteUpdateListener(OnSqliteUpdateListener onSqliteUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onSqliteUpdateListener) == null) {
            this.onSqliteUpdateListener = onSqliteUpdateListener;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, contentValues, str2, strArr) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    synchronized (this) {
                        sQLiteDatabase = getWritableDatabase();
                        sQLiteDatabase.update(str, contentValues, str2, strArr);
                    }
                } catch (Exception unused) {
                    boolean z = DEBUG;
                    if (sQLiteDatabase == null) {
                        return;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, strArr, str2, strArr2, str3, str4, str5, str6})) == null) {
            try {
                synchronized (this) {
                    query = getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
                return query;
            } catch (Exception unused) {
                boolean z = DEBUG;
                return null;
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public Cursor query(String str, String str2) {
        Cursor query;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            try {
                synchronized (this) {
                    query = getReadableDatabase().query(str, null, str2, null, null, null, null);
                }
                return query;
            } catch (Exception unused) {
                boolean z = DEBUG;
                return null;
            }
        }
        return (Cursor) invokeLL.objValue;
    }
}
