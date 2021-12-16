package com.baidu.android.imsdk.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
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
/* loaded from: classes9.dex */
public class IMDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static DbOpenHelper mDbHelper;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DbOpenHelper(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                DBVersionManager.getInstance(this.mContext).onCreate(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @TargetApi(11)
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                DBVersionManager.getInstance(this.mContext).onDowngrade(sQLiteDatabase, i2, i3);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) {
                DBVersionManager.getInstance(this.mContext).onUpgrade(sQLiteDatabase, i2, i3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1453033070, "Lcom/baidu/android/imsdk/db/IMDatabase;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1453033070, "Lcom/baidu/android/imsdk/db/IMDatabase;");
        }
    }

    public IMDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized DbOpenHelper getDBOpenHelper(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        String path;
        DbOpenHelper dbOpenHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            synchronized (IMDatabase.class) {
                String path2 = context.getDatabasePath(TableDefine.DB_NAME_PREFIX + str + "_" + j2 + ".db").getPath();
                if (mDbHelper == null) {
                    mDbHelper = new DbOpenHelper(context, path2, 50);
                } else {
                    try {
                        path = mDbHelper.getReadableDatabase().getPath();
                    } catch (SQLiteException e2) {
                        LogUtils.e("IMDatabase", "", e2);
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                    }
                    if (!path.equals(path2)) {
                        mDbHelper.close();
                        mDbHelper = null;
                        mDbHelper = new DbOpenHelper(context, path2, 50);
                    }
                }
                dbOpenHelper = mDbHelper;
            }
            return dbOpenHelper;
        }
        return (DbOpenHelper) invokeCommon.objValue;
    }

    public static synchronized SQLiteDatabase getReadableDb(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            synchronized (IMDatabase.class) {
                DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j2);
                SQLiteDatabase sQLiteDatabase = null;
                if (dBOpenHelper == null) {
                    return null;
                }
                try {
                    sQLiteDatabase = dBOpenHelper.getReadableDatabase();
                } catch (SQLException e2) {
                    mDbHelper = null;
                    LogUtils.e("IMDatabase", "Exception ", e2);
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeCommon.objValue;
    }

    public static synchronized SQLiteDatabase getWritableDb(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            synchronized (IMDatabase.class) {
                DbOpenHelper dBOpenHelper = getDBOpenHelper(context, str, j2);
                SQLiteDatabase sQLiteDatabase = null;
                if (dBOpenHelper == null) {
                    return null;
                }
                try {
                    sQLiteDatabase = dBOpenHelper.getWritableDatabase();
                } catch (Exception e2) {
                    mDbHelper = null;
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeCommon.objValue;
    }
}
