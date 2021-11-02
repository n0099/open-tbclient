package b.a.e.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b.a.e.e.d.e;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.e.a.k.b f1673a;

    /* renamed from: b  reason: collision with root package name */
    public String f1674b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f1675c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f1676d;

    /* renamed from: e  reason: collision with root package name */
    public int f1677e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<String> f1678f;

    /* renamed from: g  reason: collision with root package name */
    public Object f1679g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f1680e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1680e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1680e.m();
            }
        }
    }

    public c(b.a.e.a.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1678f = new LinkedList<>();
        this.f1679g = new Object();
        this.f1673a = bVar;
    }

    public synchronized void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            synchronized (this) {
                synchronized (this.f1679g) {
                    if (this.f1678f.contains(str)) {
                        return;
                    }
                    this.f1678f.addLast(str);
                    if (z) {
                        j();
                    }
                }
            }
        }
    }

    public void b(g<T> gVar) {
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            try {
                synchronized (this.f1679g) {
                    this.f1678f.remove(gVar.f1687a);
                }
                ContentValues p = p(gVar);
                SQLiteDatabase f2 = this.f1673a.f();
                if (f2.update(this.f1674b, p, "m_key = ?", new String[]{gVar.f1687a}) == 0) {
                    f2.insert(this.f1674b, null, p);
                    if (this.f1676d != null) {
                        j();
                    }
                }
                if (this.f1675c == null || (d2 = this.f1675c.d(gVar)) == null) {
                    return;
                }
                e(d2);
            } catch (Throwable th) {
                this.f1673a.i(th, "addOrUpdateTextCacheItem");
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f1677e = 0;
            synchronized (this.f1679g) {
                this.f1678f.clear();
            }
            if (d(str)) {
                BdCacheService.k().f().delete(str);
            }
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.f1673a.f().delete(this.f1674b, "m_key = ?", new String[]{str});
            } catch (Throwable th) {
                this.f1673a.i(th, "deleteCacheItem");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public g<T> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return i(this.f1673a.f(), str);
            } catch (Throwable th) {
                this.f1673a.i(th, "get");
                return null;
            }
        }
        return (g) invokeL.objValue;
    }

    public abstract int g();

    public b.a.e.a.k.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1673a : (b.a.e.a.k.b) invokeV.objValue;
    }

    public abstract g<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f1676d) == null) {
            return;
        }
        this.f1677e++;
        if (this.f1677e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
            this.f1677e = 0;
            b.a.e.e.m.h.a().b(new a(this));
        }
    }

    public abstract void k(String str, String str2, int i2, int i3);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f1678f.isEmpty()) {
            return;
        }
        SQLiteDatabase f2 = this.f1673a.f();
        f2.beginTransaction();
        while (true) {
            try {
                synchronized (this.f1679g) {
                    if (this.f1678f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f1678f.removeFirst();
                }
                f2.delete(this.f1674b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f2.setTransactionSuccessful();
        this.f1677e = 0;
    }

    public void n(String str) {
        e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (aVar = this.f1676d) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.f1673a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f1687a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f1690d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f1691e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f1692f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h2 = this.f1676d.h(gVar);
                if (h2 != null) {
                    a(h2, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void o(String str) {
        e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (bVar = this.f1675c) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.f1673a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.f1687a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f1690d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f1691e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f1692f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g2 = this.f1675c.g(gVar);
                if (g2 != null) {
                    a(g2, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    public abstract ContentValues p(g<T> gVar);

    public abstract Cursor q(SQLiteDatabase sQLiteDatabase, String str);

    public void r(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, eVar, str) == null) {
            this.f1674b = str;
            if (eVar instanceof e.b) {
                this.f1675c = (e.b) eVar;
            }
            if (eVar instanceof e.a) {
                this.f1676d = (e.a) eVar;
            }
        }
    }
}
