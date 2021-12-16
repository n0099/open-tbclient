package c.a.d.a.k;

import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.k.a;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0074a f2163b;

    /* renamed from: c  reason: collision with root package name */
    public a f2164c;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f2163b = null;
        this.f2164c = aVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.a != null) {
                    this.a.close();
                    this.a = null;
                }
            } catch (Exception e2) {
                BdLog.e("closeDatabase：" + e2.getMessage());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        boolean dropDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (b.class) {
                a();
                try {
                    dropDatabase = this.f2164c.dropDatabase(BdBaseApplication.getInst().getContext());
                } catch (Exception e2) {
                    BdLog.e("deleteDatabase：" + e2.getMessage());
                    this.a = null;
                    return false;
                }
            }
            return dropDatabase;
        }
        return invokeV.booleanValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (b.class) {
                if (this.a == null || !this.a.isOpen()) {
                    try {
                        this.f2164c.setOnCreateCallback(this.f2163b);
                        this.a = this.f2164c.getWritableDatabase();
                    } catch (RuntimeException e2) {
                        if (z) {
                            i(e2, "ensureDatabaseReady");
                        } else {
                            throw e2;
                        }
                    }
                }
            }
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SQLiteDatabase f2 = f();
            if (f2 != null) {
                try {
                    f2.execSQL(str);
                    return true;
                } catch (Throwable th) {
                    i(th, "execSQLNoException:" + str);
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, objArr)) == null) {
            SQLiteDatabase f2 = f();
            if (f2 != null) {
                try {
                    f2.execSQL(str, objArr);
                    return true;
                } catch (Throwable th) {
                    i(th, "execSQLNoException:" + str);
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? g(true) : (SQLiteDatabase) invokeV.objValue;
    }

    public SQLiteDatabase g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            c(z);
            return this.a;
        }
        return (SQLiteDatabase) invokeZ.objValue;
    }

    public void h(String str, int i2, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, str2, objArr) == null) {
            try {
                BdStatisticsManager.getInstance().db(str, "", i2, str2, objArr);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void i(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, str) == null) && th != null && (th instanceof SQLiteException)) {
            int i2 = -17;
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    b();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i2 = -14;
                this.a = null;
            } else if (th instanceof SQLiteAbortException) {
                i2 = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i2 = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i2 = -15;
                this.a = null;
            } else if (th instanceof SQLiteFullException) {
                i2 = -16;
                this.a = null;
            } else if (th instanceof SQLiteDoneException) {
                i2 = -19;
                this.a = null;
            } else if (!(th instanceof SQLiteMisuseException)) {
                this.a = null;
            }
            h(str, i2, th.getMessage(), new Object[0]);
        }
    }

    public Cursor j(String str, String[] strArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, strArr)) == null) {
            SQLiteDatabase g2 = g(false);
            if (g2 != null) {
                return g2.rawQuery(str, strArr);
            }
            throw new SQLException("unable to open database.");
        }
        return (Cursor) invokeLL.objValue;
    }

    public void k(a.InterfaceC0074a interfaceC0074a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC0074a) == null) {
            this.f2163b = interfaceC0074a;
        }
    }
}
