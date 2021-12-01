package c.a.d.f.d;

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
public class q extends c<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f2371h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c.a.d.a.k.b bVar, String str) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.k.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2371h = str;
    }

    @Override // c.a.d.f.d.c
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                this.a.f().delete(this.f2333b, "m_ns = ?", new String[]{str});
                return true;
            } catch (Throwable th) {
                this.a.i(th, "clearData");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.f.d.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    @Override // c.a.d.f.d.c
    public g<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) != null) {
            return (g) invokeLL.objValue;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f2333b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    c.a.d.f.m.a.a(rawQuery);
                    return null;
                }
                g<String> gVar = new g<>();
                gVar.a = rawQuery.getString(0);
                gVar.f2344c = rawQuery.getString(1);
                gVar.f2345d = rawQuery.getLong(2);
                gVar.f2346e = rawQuery.getLong(3);
                gVar.f2347f = rawQuery.getLong(4);
                gVar.f2343b = rawQuery.getString(5);
                c.a.d.f.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                c.a.d.f.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // c.a.d.f.d.c
    public void k(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i2, i3) == null) {
        }
    }

    @Override // c.a.d.f.d.c
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.a.d("CREATE TABLE IF NOT EXISTS " + this.f2371h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
            this.a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f2371h + "(m_ns)");
            return this.f2371h;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.d.f.d.c
    public ContentValues p(g<String> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", gVar.a);
            contentValues.put("m_ns", gVar.f2344c);
            contentValues.put("m_value", gVar.f2343b);
            contentValues.put("saveTime", Long.valueOf(gVar.f2345d));
            contentValues.put("lastHitTime", Long.valueOf(gVar.f2346e));
            contentValues.put("timeToExpire", Long.valueOf(gVar.f2347f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // c.a.d.f.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.f2333b + " where m_ns = ?", new String[]{str});
        }
        return (Cursor) invokeLL.objValue;
    }
}
