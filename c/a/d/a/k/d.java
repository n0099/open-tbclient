package c.a.d.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import c.a.d.a.k.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0104a callback;
    public SQLiteDatabase database;
    public final String dbFileFullPath;
    public int mVersion;

    public d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVersion = 1;
        this.database = null;
        this.mVersion = i2;
        this.dbFileFullPath = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        a.InterfaceC0104a interfaceC0104a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) || (interfaceC0104a = this.callback) == null) {
            return;
        }
        interfaceC0104a.onDatabaseCreated(sQLiteDatabase);
    }

    private void onCreateDatabase(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            onCreate(sQLiteDatabase);
            exeCallback(sQLiteDatabase);
        }
    }

    private void onUpdateDatabase(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, sQLiteDatabase, i2, i3) == null) {
            if (i3 > i2) {
                onUpgrade(sQLiteDatabase, i2, i3);
            } else {
                onDowngrade(sQLiteDatabase, i2, i3);
            }
            exeCallback(sQLiteDatabase);
        }
    }

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // c.a.d.a.k.a
    public boolean dropDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            File file = new File(this.dbFileFullPath);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sQLiteDatabase, str)) == null) {
            try {
                sQLiteDatabase.execSQL(str);
                return true;
            } catch (Throwable th) {
                BdLog.e(str + ":" + th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.d.a.k.a
    public SQLiteDatabase getWritableDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(this.dbFileFullPath);
            if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
                boolean exists = file.exists();
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.dbFileFullPath, (SQLiteDatabase.CursorFactory) null);
                this.database = openOrCreateDatabase;
                if (openOrCreateDatabase != null) {
                    if (!exists) {
                        onCreateDatabase(openOrCreateDatabase);
                        this.database.setVersion(this.mVersion);
                    } else {
                        int version = openOrCreateDatabase.getVersion();
                        int i2 = this.mVersion;
                        if (version != i2) {
                            onUpdateDatabase(this.database, version, i2);
                            this.database.setVersion(this.mVersion);
                        }
                    }
                }
            }
            return this.database;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            createAllTables(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
            clearAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
        }
    }

    @Override // c.a.d.a.k.a
    public void setOnCreateCallback(a.InterfaceC0104a interfaceC0104a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC0104a) == null) {
            this.callback = interfaceC0104a;
        }
    }
}
