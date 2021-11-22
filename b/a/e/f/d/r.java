package b.a.e.f.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r extends c<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b.a.e.a.k.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.e.a.k.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.e.f.d.c
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            b.a.e.a.k.b bVar = this.f1676a;
            bVar.d("DROP TABLE IF EXISTS " + this.f1677b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.e.f.d.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, java.lang.String] */
    @Override // b.a.e.f.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) != null) {
            return (g) invokeLL.objValue;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f1677b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    b.a.e.f.m.a.a(rawQuery);
                    return null;
                }
                g<String> gVar = new g<>();
                gVar.f1690a = rawQuery.getString(0);
                gVar.f1693d = rawQuery.getLong(1);
                gVar.f1694e = rawQuery.getLong(2);
                gVar.f1695f = rawQuery.getLong(3);
                gVar.f1691b = rawQuery.getString(4);
                b.a.e.f.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                b.a.e.f.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b.a.e.f.d.c
    public void k(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i2, i3) == null) {
        }
    }

    @Override // b.a.e.f.d.c
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            String str2 = "cache_kv_t" + hashCode;
            this.f1676a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.e.f.d.c
    public ContentValues p(g<String> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", gVar.f1690a);
            contentValues.put("m_value", gVar.f1691b);
            contentValues.put("saveTime", Long.valueOf(gVar.f1693d));
            contentValues.put("lastHitTime", Long.valueOf(gVar.f1694e));
            contentValues.put("timeToExpire", Long.valueOf(gVar.f1695f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // b.a.e.f.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.f1677b, new String[0]);
        }
        return (Cursor) invokeLL.objValue;
    }
}
