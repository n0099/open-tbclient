package c.a.r0.l1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static h f21555a;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public static h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f21555a == null) {
                synchronized (h.class) {
                    if (f21555a == null) {
                        f21555a = new h();
                    }
                }
            }
            return f21555a;
        }
        return (h) invokeV.objValue;
    }

    public SQLiteStatement a(String str) {
        InterceptResult invokeL;
        SQLiteDatabase c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (c2 = g.c()) == null) {
                return null;
            }
            try {
                return c2.compileStatement(str);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (SQLiteStatement) invokeL.objValue;
    }

    public boolean b(String str, String str2, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, strArr)) == null) {
            SQLiteDatabase c2 = g.c();
            if (c2 == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return c2.delete(str, str2, strArr) > 0;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void c() {
        SQLiteDatabase c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c2 = g.c()) == null) {
            return;
        }
        BdLog.i("begin commit transaction");
        if (c2.inTransaction()) {
            try {
                c2.setTransactionSuccessful();
                c2.endTransaction();
                return;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "endTransaction", new Object[0]);
                BdLog.e(e2.getMessage());
                return;
            }
        }
        BdLog.e("there is no current transaction");
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SQLiteDatabase c2 = g.c();
            if (c2 == null) {
                return false;
            }
            try {
                c2.execSQL(str);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public long f(SQLiteStatement sQLiteStatement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sQLiteStatement)) == null) {
            if (sQLiteStatement == null) {
                return -1L;
            }
            try {
                return sQLiteStatement.executeInsert();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public long g(String str, String str2, ContentValues contentValues) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, contentValues)) == null) {
            SQLiteDatabase c2 = g.c();
            if (c2 == null || TextUtils.isEmpty(str)) {
                return -1L;
            }
            try {
                return c2.insert(str, str2, contentValues);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return -1L;
            }
        }
        return invokeLLL.longValue;
    }

    public Cursor h(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, strArr)) == null) {
            SQLiteDatabase c2 = g.c();
            if (c2 == null) {
                return null;
            }
            try {
                return c2.rawQuery(str, strArr);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage() + str);
                return null;
            }
        }
        return (Cursor) invokeLL.objValue;
    }

    public void i() {
        SQLiteDatabase c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (c2 = g.c()) == null) {
            return;
        }
        if (c2.inTransaction()) {
            BdLog.e("there is exist transaction");
            return;
        }
        try {
            c2.beginTransaction();
            BdLog.i("db.beginTransaction");
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "startTransaction", new Object[0]);
            BdLog.e(e2.getMessage());
        }
    }

    public int j(String str, ContentValues contentValues, String str2, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, contentValues, str2, strArr)) == null) {
            SQLiteDatabase c2 = g.c();
            if (c2 == null || TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return c2.update(str, contentValues, str2, strArr);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }
}
