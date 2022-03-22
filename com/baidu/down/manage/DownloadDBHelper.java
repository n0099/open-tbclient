package com.baidu.down.manage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class DownloadDBHelper extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static int DATA_VERSION = 0;
    public static final boolean DEBUG;
    public static final String TAG = "DaoMaster";
    public static DownloadDBHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-870127972, "Lcom/baidu/down/manage/DownloadDBHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-870127972, "Lcom/baidu/down/manage/DownloadDBHelper;");
                return;
            }
        }
        DEBUG = DownloadConstants.mDebug;
        DATA_VERSION = 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cursorFactory, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, sQLiteDatabase, str, str2) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE downloads ADD COLUMN " + str + " " + str2);
            } catch (SQLException e2) {
                Log.e(TAG, "couldn't add column: " + e2.toString());
            }
        }
    }

    public static synchronized DownloadDBHelper getInstance(Context context) {
        InterceptResult invokeL;
        DownloadDBHelper downloadDBHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (DownloadDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new DownloadDBHelper(context, "downloads", null, DATA_VERSION);
                }
                downloadDBHelper = mInstance;
            }
            return downloadDBHelper;
        }
        return (DownloadDBHelper) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL(DownloadDao.CREATE_TABLE_SQL);
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL(DownloadDao.DROP_TABLE_SQL);
                    sQLiteDatabase.execSQL(DownloadDao.CREATE_TABLE_SQL);
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i, i2) == null) || i2 <= i) {
            return;
        }
        int i3 = i + 1;
        if (i3 == 2) {
            addColumn(sQLiteDatabase, DownloadConstants.DownloadColumns.COLUMN_DOWN_DIR, "TEXT");
            addColumn(sQLiteDatabase, DownloadConstants.DownloadColumns.COLUMN_FROM_PARAM, "TEXT");
        } else if (i3 != 3) {
            return;
        }
        addColumn(sQLiteDatabase, DownloadConstants.DownloadColumns.COLUMN_REAL_URI, "TEXT");
    }
}
