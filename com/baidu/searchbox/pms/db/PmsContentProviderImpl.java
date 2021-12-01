package com.baidu.searchbox.pms.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PmsContentProviderImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTHORITY;
    public static final Uri BASE_URI;
    public static final int CODE_EXECUTE_SQL = 102;
    public static final int CODE_QUERY_SQL = 101;
    public static final int CODE_TABLE_PACKAGE_INFO = 100;
    public static final String COLUMN_ID = "id";
    public static final Uri CONTENT_URI_EXECUTE_SQL;
    public static final Uri CONTENT_URI_PACKAGE_INFO;
    public static final Uri CONTENT_URI_QUERY_SQL;
    public static final String PATH_EXECUTE_SQL = "execute_sql";
    public static final String PATH_QUERY_SQL = "query_sql";
    public static final String PATH_TABLE_PACKAGE_INFO = "package_info";
    public static final UriMatcher sUriMatcher;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public DbHelper mDbHelper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1872703561, "Lcom/baidu/searchbox/pms/db/PmsContentProviderImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1872703561, "Lcom/baidu/searchbox/pms/db/PmsContentProviderImpl;");
                return;
            }
        }
        AUTHORITY = AppRuntime.getApplication().getPackageName() + ".pms.db.provider";
        Uri parse = Uri.parse("content://" + AUTHORITY);
        BASE_URI = parse;
        CONTENT_URI_PACKAGE_INFO = parse.buildUpon().appendPath("package_info").build();
        CONTENT_URI_QUERY_SQL = BASE_URI.buildUpon().appendPath(PATH_QUERY_SQL).build();
        CONTENT_URI_EXECUTE_SQL = BASE_URI.buildUpon().appendPath(PATH_EXECUTE_SQL).build();
        UriMatcher uriMatcher = new UriMatcher(-1);
        sUriMatcher = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "package_info", 100);
        sUriMatcher.addURI(AUTHORITY, PATH_QUERY_SQL, 101);
        sUriMatcher.addURI(AUTHORITY, PATH_EXECUTE_SQL, 102);
    }

    public PmsContentProviderImpl(Context context) {
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
        this.mContext = context;
    }

    public static int deleteExt(Context context, Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, strArr)) == null) {
            try {
                return context.getContentResolver().delete(uri, str, strArr);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }

    public static void execSqlExt(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                context.getContentResolver().query(CONTENT_URI_EXECUTE_SQL, null, str, null, null);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
            }
        }
    }

    private DbHelper getDbHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mDbHelper == null) {
                this.mDbHelper = new DbHelper(this.mContext);
            }
            return this.mDbHelper;
        }
        return (DbHelper) invokeV.objValue;
    }

    @Nullable
    public static String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            if (sUriMatcher.match(uri) != 100) {
                return null;
            }
            return "package_info";
        }
        return (String) invokeL.objValue;
    }

    public static long insertExt(Context context, Uri uri, ContentValues contentValues) {
        Uri uri2;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, uri, contentValues)) == null) {
            try {
                uri2 = context.getContentResolver().insert(uri, contentValues);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
                uri2 = null;
            }
            if (uri2 == null) {
                return 0L;
            }
            try {
                return Long.parseLong(uri2.getQueryParameter("id"));
            } catch (Exception e3) {
                e3.printStackTrace();
                return 0L;
            }
        }
        return invokeLLL.longValue;
    }

    public static Cursor queryExt(Context context, Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, uri, strArr, str, strArr2, str2})) == null) {
            try {
                return context.getContentResolver().query(uri, strArr, str, strArr2, str2);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
                return null;
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static int updateExt(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65545, null, context, uri, contentValues, str, strArr)) == null) {
            try {
                return context.getContentResolver().update(uri, contentValues, str, strArr);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
                return 0;
            }
        }
        return invokeLLLLL.intValue;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            String type = getType(uri);
            if (TextUtils.isEmpty(type)) {
                return 0;
            }
            try {
                return getDbHelper().getWritableDatabase().delete(type, str, strArr);
            } catch (SQLiteFullException e2) {
                DebugUtils.printStackTrace(e2);
                return 0;
            } catch (SQLiteReadOnlyDatabaseException e3) {
                DebugUtils.printStackTrace(e3);
                return 0;
            }
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, contentValues)) == null) {
            String type = getType(uri);
            if (TextUtils.isEmpty(type)) {
                return null;
            }
            long j2 = 0;
            try {
                j2 = getDbHelper().getWritableDatabase().insert(type, null, contentValues);
            } catch (SQLiteFullException e2) {
                DebugUtils.printStackTrace(e2);
            } catch (SQLiteReadOnlyDatabaseException e3) {
                DebugUtils.printStackTrace(e3);
            }
            Uri.Builder appendPath = BASE_URI.buildUpon().appendPath(type);
            return appendPath.appendQueryParameter("id", j2 + "").build();
        }
        return (Uri) invokeLL.objValue;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) {
            try {
                String type = getType(uri);
                if (!TextUtils.isEmpty(type)) {
                    return getDbHelper().getReadableDatabase().query(type, strArr, str, strArr2, null, null, str2);
                }
                int match = sUriMatcher.match(uri);
                if (match != 101) {
                    if (match != 102) {
                        return null;
                    }
                    getDbHelper().getWritableDatabase().execSQL(str);
                    return null;
                }
                return getDbHelper().getReadableDatabase().rawQuery(str, strArr2);
            } catch (Exception e2) {
                DebugUtils.printStackTrace(e2);
                return null;
            }
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, uri, contentValues, str, strArr)) == null) {
            String type = getType(uri);
            if (TextUtils.isEmpty(type)) {
                return 0;
            }
            try {
                return getDbHelper().getWritableDatabase().update(type, contentValues, str, strArr);
            } catch (SQLiteFullException e2) {
                DebugUtils.printStackTrace(e2);
                return 0;
            } catch (SQLiteReadOnlyDatabaseException e3) {
                DebugUtils.printStackTrace(e3);
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }

    public static Cursor queryExt(Context context, String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, strArr)) == null) {
            try {
                return context.getContentResolver().query(CONTENT_URI_QUERY_SQL, null, str, strArr, null);
            } catch (IllegalArgumentException e2) {
                DebugUtils.throwExceptionForDebug(e2);
                return null;
            }
        }
        return (Cursor) invokeLLL.objValue;
    }
}
