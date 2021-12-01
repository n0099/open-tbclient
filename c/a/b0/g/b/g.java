package c.a.b0.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.z.d;
import c.a.b0.z.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g extends c.a.b0.z.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SQLiteDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.b0.z.c, c.a.b0.z.d
    public synchronized d.a a(k kVar, c.a.b0.z.b... bVarArr) {
        InterceptResult invokeLL;
        d.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bVarArr)) == null) {
            synchronized (this) {
                a = super.a(kVar, bVarArr);
            }
            return a;
        }
        return (d.a) invokeLL.objValue;
    }

    @Override // c.a.b0.z.c, c.a.b0.z.d
    public synchronized void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                super.beginTransaction();
            }
        }
    }

    @Override // c.a.b0.z.c
    public synchronized int delete(String str, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, aVar)) == null) {
            synchronized (this) {
                delete = super.delete(str, aVar);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // c.a.b0.z.c, c.a.b0.z.d
    public synchronized void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                super.endTransaction();
            }
        }
    }

    @Override // c.a.b0.z.c
    public synchronized long insert(k kVar) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kVar)) == null) {
            synchronized (this) {
                insert = super.insert(kVar);
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // c.a.b0.z.c
    public synchronized boolean query(k kVar, String str) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, kVar, str)) == null) {
            synchronized (this) {
                query = super.query(kVar, str);
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.b0.z.c, c.a.b0.z.d
    public synchronized void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                super.setTransactionSuccessful();
            }
        }
    }

    @Override // c.a.b0.z.c, c.a.b0.z.d
    public synchronized int update(k kVar, c.a.b0.z.b... bVarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, kVar, bVarArr)) == null) {
            synchronized (this) {
                update = super.update(kVar, bVarArr);
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized int delete(k kVar, c.a.b0.z.b... bVarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kVar, bVarArr)) == null) {
            synchronized (this) {
                delete = super.delete(kVar, bVarArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, strArr, objArr)) == null) {
            synchronized (this) {
                insert = super.insert(str, strArr, objArr);
            }
            return insert;
        }
        return invokeLLL.longValue;
    }

    @Override // c.a.b0.z.c
    public synchronized boolean query(k kVar, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, kVar, aVar)) == null) {
            synchronized (this) {
                query = super.query(kVar, aVar);
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.b0.z.c
    public synchronized int update(Class<? extends k> cls, c.a.b0.z.l.a aVar, c.a.b0.z.b[] bVarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, aVar, bVarArr, objArr)) == null) {
            synchronized (this) {
                update = super.update(cls, aVar, bVarArr, objArr);
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized boolean query(k kVar, c.a.b0.z.b... bVarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, kVar, bVarArr)) == null) {
            synchronized (this) {
                query = super.query(kVar, bVarArr);
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.b0.z.c
    public synchronized int update(k kVar, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, kVar, aVar)) == null) {
            synchronized (this) {
                update = super.update(kVar, aVar);
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized Cursor query(String str, c.a.b0.z.b[] bVarArr, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, bVarArr, aVar)) == null) {
            synchronized (this) {
                query = super.query(str, bVarArr, aVar);
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // c.a.b0.z.c
    public synchronized int update(String str, ContentValues contentValues, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, aVar)) == null) {
            synchronized (this) {
                update = super.update(str, contentValues, aVar);
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized Cursor query(String str) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                query = super.query(str);
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // c.a.b0.z.c
    public synchronized int update(String str, Column[] columnArr, c.a.b0.z.l.a aVar) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, aVar)) == null) {
            synchronized (this) {
                update = super.update(str, columnArr, aVar);
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // c.a.b0.z.c
    public synchronized Cursor query(c.a.b0.z.l.b bVar) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            synchronized (this) {
                query = super.query(bVar);
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }
}
