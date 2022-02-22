package c.a.d0.c0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.c0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f2576b;

    public c(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, sQLiteDatabase2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = sQLiteDatabase;
        this.f2576b = sQLiteDatabase2;
    }

    @Override // c.a.d0.c0.d
    public d.a a(k kVar, b... bVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bVarArr)) == null) {
            String g2 = kVar.b().g();
            ContentValues a = kVar.a();
            String b2 = g.b(c(kVar, bVarArr));
            this.a.beginTransaction();
            try {
                int update = this.a.update(g2, a, b2, null);
                long insert = update == 0 ? insert(kVar) : 0L;
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                return new d.a(insert, update);
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        }
        return (d.a) invokeLL.objValue;
    }

    public final boolean b(k kVar, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar, str, strArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                Column[] c2 = c(kVar, new b[0]);
                int length = c2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!d(c2[i2])) {
                        throw new IllegalArgumentException("perform query with out where condition or invalid keys.");
                    }
                }
                str = g.j(c2);
            }
            Cursor rawQuery = this.f2576b.rawQuery(g.i(kVar, str), strArr);
            boolean moveToFirst = rawQuery.moveToFirst();
            if (moveToFirst) {
                i.a(rawQuery, kVar);
            }
            rawQuery.close();
            return moveToFirst;
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.d0.c0.d
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    public final Column[] c(k kVar, b... bVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, kVar, bVarArr)) == null) {
            if (bVarArr.length > 0) {
                return h.d(kVar, bVarArr);
            }
            return h.d(kVar, kVar.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public final boolean d(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, columnArr)) == null) {
            for (Column column : columnArr) {
                if (column == null || !column.isAssignedValue) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int delete(String str, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, aVar)) == null) ? this.a.delete(str, aVar.l(), aVar.e()) : invokeLL.intValue;
    }

    @Override // c.a.d0.c0.d
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar)) == null) {
            j b2 = kVar.b();
            String g2 = b2.g();
            b[] f2 = b2.f();
            if (f2.length != 1) {
                return this.a.insert(g2, null, kVar.a());
            }
            Column column = h.d(kVar, f2[0])[0];
            boolean m = h.m(column);
            if (m && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + kVar.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g2, null, kVar.a());
            if (m) {
                int type = column.type();
                if (type == 2) {
                    ((IntegerColumn) column).setValue((int) insert);
                } else if (type == 3) {
                    ((LongColumn) column).setValue(insert);
                } else {
                    throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    public boolean query(k kVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, kVar, str)) == null) ? b(kVar, str, null) : invokeLL.booleanValue;
    }

    @Override // c.a.d0.c0.d
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // c.a.d0.c0.d
    public int update(k kVar, b... bVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, kVar, bVarArr)) == null) ? this.a.update(kVar.b().g(), kVar.a(), g.b(c(kVar, bVarArr)), null) : invokeLL.intValue;
    }

    public int delete(k kVar, b... bVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, kVar, bVarArr)) == null) {
            String g2 = kVar.b().g();
            Column[] c2 = c(kVar, bVarArr);
            int length = c2.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!d(c2[i2])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g2, c.a.d0.c0.l.a.j(c2));
        }
        return invokeLL.intValue;
    }

    public boolean query(k kVar, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, kVar, aVar)) == null) ? b(kVar, aVar.k(), aVar.e()) : invokeLL.booleanValue;
    }

    public boolean query(k kVar, b... bVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, kVar, bVarArr)) == null) {
            return query(kVar, bVarArr.length > 0 ? g.j(h.d(kVar, bVarArr)) : null);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(SQLiteDatabase sQLiteDatabase) {
        this(sQLiteDatabase, sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SQLiteDatabase) objArr2[0], (SQLiteDatabase) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int update(Class<? extends k> cls, c.a.d0.c0.l.a aVar, b[] bVarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048595, this, cls, aVar, bVarArr, objArr)) == null) {
            if (bVarArr.length != 0 && objArr.length == bVarArr.length) {
                return update(e.b(cls).g(), h.c(bVarArr, objArr), aVar);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public Cursor query(String str, b[] bVarArr, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, bVarArr, aVar)) == null) {
            return this.f2576b.rawQuery("SELECT " + g.f(bVarArr) + aVar.k(), aVar.e());
        }
        return (Cursor) invokeLLL.objValue;
    }

    public Cursor query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.f2576b.rawQuery(str, null) : (Cursor) invokeL.objValue;
    }

    public int update(k kVar, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, kVar, aVar)) == null) ? update(kVar.b().g(), kVar.a(), aVar) : invokeLL.intValue;
    }

    public Cursor query(c.a.d0.c0.l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) ? this.f2576b.rawQuery(bVar.b(), bVar.a()) : (Cursor) invokeL.objValue;
    }

    public int update(String str, ContentValues contentValues, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, str, contentValues, aVar)) == null) {
            return this.a.update(str, contentValues, aVar != null ? aVar.l() : null, aVar != null ? aVar.e() : null);
        }
        return invokeLLL.intValue;
    }

    public int update(String str, Column[] columnArr, c.a.d0.c0.l.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, str, columnArr, aVar)) == null) ? update(str, h.e(columnArr), aVar) : invokeLLL.intValue;
    }

    public long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, strArr, objArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                contentValues.put(strArr[i2], String.valueOf(objArr[i2]));
            }
            return this.a.insert(str, null, contentValues);
        }
        return invokeLLL.longValue;
    }
}
