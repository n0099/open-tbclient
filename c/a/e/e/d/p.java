package c.a.e.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.e.a.k.b f2238a;

    public p(Context context, c.a.e.a.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2238a = bVar;
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", hVar.f2212a);
                contentValues.put("tableName", hVar.f2213b);
                contentValues.put("maxSize", Integer.valueOf(hVar.f2214c));
                contentValues.put("cacheVersion", Integer.valueOf(hVar.f2216e));
                contentValues.put("cacheType", hVar.f2215d);
                contentValues.put("lastActiveTime", Long.valueOf(hVar.f2217f));
                SQLiteDatabase f2 = this.f2238a.f();
                if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f2212a}) != 0) {
                    return;
                }
                f2.insert("cache_meta_info", null, contentValues);
            } catch (Throwable th) {
                this.f2238a.i(th, "addOrUpdate");
            }
        }
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (c(str) == null) {
                    return 0;
                }
                return this.f2238a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                this.f2238a.i(th, "delete");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public h c(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                cursor = this.f2238a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f2212a = cursor.getString(0);
                    hVar.f2213b = cursor.getString(1);
                    hVar.f2214c = cursor.getInt(2);
                    hVar.f2215d = cursor.getString(3);
                    hVar.f2216e = cursor.getInt(4);
                    hVar.f2217f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f2238a.i(th, "get");
                    return null;
                } finally {
                    c.a.e.e.m.a.a(cursor);
                }
            }
            return null;
        }
        return (h) invokeL.objValue;
    }
}
