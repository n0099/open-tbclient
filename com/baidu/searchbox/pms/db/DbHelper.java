package com.baidu.searchbox.pms.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DbHelper extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME = "pms.db";
    public static final int DB_VERSION = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void alterAddAbi(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE package_info ADD COLUMN " + PackageTable.ABI + " TEXT;");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void alterAddDependencies(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append("package_info");
            sb.append(" ADD COLUMN ");
            sb.append(PackageTable.UPDATE_SIGN);
            sb.append(" TEXT;");
            try {
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.delete(0, sb.length());
            sb.append("ALTER TABLE ");
            sb.append("package_info");
            sb.append(" ADD COLUMN ");
            sb.append(PackageTable.IS_MAIN_ENTRANCE);
            sb.append(" INTEGER DEFAULT 1;");
            try {
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sb.delete(0, sb.length());
            sb.append("ALTER TABLE ");
            sb.append("package_info");
            sb.append(" ADD COLUMN ");
            sb.append(PackageTable.DEPENDENCY_PACKAGE);
            sb.append(" TEXT");
            sb.append(";");
            try {
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private String getCreateDBSql() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return "CREATE TABLE package_info(_id INTEGER PRIMARY KEY,channel_id TEXT NOT NULL,package_name TEXT NOT NULL,name TEXT NOT NULL,version LONG,update_version LONG," + PackageTable.MIN_HOST_VERSION + " TEXT," + PackageTable.MAX_HOST_VERSION + " TEXT,download_url TEXT,type INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT,size TEXT," + PackageTable.DOWNLOAD_OPTION + " INTEGER DEFAULT 0,wifi INTEGER DEFAULT 0," + PackageTable.IS_SILENCE + " INTEGER DEFAULT 0," + PackageTable.DISABLE + " INTEGER DEFAULT 0,sign TEXT," + PackageTable.EXTRA_FROM_SERVER + " TEXT," + PackageTable.EXTRA_FROM_LOCAL + " TEXT," + PackageTable.FILE_PATH + " TEXT," + PackageTable.TOTAL_SIZE + " LONG," + PackageTable.CURRENT_SIZE + " LONG,create_time LONG,update_time LONG," + PackageTable.UPDATE_SIGN + " TEXT," + PackageTable.IS_MAIN_ENTRANCE + " INTEGER DEFAULT 1," + PackageTable.DEPENDENCY_PACKAGE + " TEXT," + PackageTable.ABI + " TEXT );";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(getCreateDBSql());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        alterAddAbi(sQLiteDatabase);
                        return;
                    }
                    return;
                }
                alterAddDependencies(sQLiteDatabase);
                alterAddAbi(sQLiteDatabase);
                return;
            }
            alterAddDependencies(sQLiteDatabase);
            alterAddAbi(sQLiteDatabase);
        }
    }
}
