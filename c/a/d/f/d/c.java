package c.a.d.f.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import c.a.d.f.d.e;
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
    public final c.a.d.a.k.b a;

    /* renamed from: b  reason: collision with root package name */
    public String f2297b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f2298c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f2299d;

    /* renamed from: e  reason: collision with root package name */
    public int f2300e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<String> f2301f;

    /* renamed from: g  reason: collision with root package name */
    public Object f2302g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f2303e;

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
            this.f2303e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2303e.m();
            }
        }
    }

    public c(c.a.d.a.k.b bVar) {
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
        this.f2301f = new LinkedList<>();
        this.f2302g = new Object();
        this.a = bVar;
    }

    public synchronized void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            synchronized (this) {
                synchronized (this.f2302g) {
                    if (this.f2301f.contains(str)) {
                        return;
                    }
                    this.f2301f.addLast(str);
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
                synchronized (this.f2302g) {
                    this.f2301f.remove(gVar.a);
                }
                ContentValues p = p(gVar);
                SQLiteDatabase f2 = this.a.f();
                if (f2.update(this.f2297b, p, "m_key = ?", new String[]{gVar.a}) == 0) {
                    f2.insert(this.f2297b, null, p);
                    if (this.f2299d != null) {
                        j();
                    }
                }
                if (this.f2298c == null || (d2 = this.f2298c.d(gVar)) == null) {
                    return;
                }
                e(d2);
            } catch (Throwable th) {
                this.a.i(th, "addOrUpdateTextCacheItem");
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f2300e = 0;
            synchronized (this.f2302g) {
                this.f2301f.clear();
            }
            if (d(str)) {
                BdCacheService.j().f().delete(str);
            }
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.a.f().delete(this.f2297b, "m_key = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.i(th, "deleteCacheItem");
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
                return i(this.a.f(), str);
            } catch (Throwable th) {
                this.a.i(th, "get");
                return null;
            }
        }
        return (g) invokeL.objValue;
    }

    public abstract int g();

    public c.a.d.a.k.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (c.a.d.a.k.b) invokeV.objValue;
    }

    public abstract g<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f2299d) == null) {
            return;
        }
        this.f2300e++;
        if (this.f2300e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
            this.f2300e = 0;
            c.a.d.f.m.h.a().b(new a(this));
        }
    }

    public abstract void k(String str, String str2, int i2, int i3);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f2301f.isEmpty()) {
            return;
        }
        SQLiteDatabase f2 = this.a.f();
        f2.beginTransaction();
        while (true) {
            try {
                synchronized (this.f2302g) {
                    if (this.f2301f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f2301f.removeFirst();
                }
                f2.delete(this.f2297b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f2.setTransactionSuccessful();
        this.f2300e = 0;
    }

    public void n(String str) {
        e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (aVar = this.f2299d) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f2309d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f2310e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f2311f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h2 = this.f2299d.h(gVar);
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
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (bVar = this.f2298c) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                g<?> gVar = new g<>();
                gVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                gVar.f2309d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                gVar.f2310e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                gVar.f2311f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g2 = this.f2298c.g(gVar);
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
            this.f2297b = str;
            if (eVar instanceof e.b) {
                this.f2298c = (e.b) eVar;
            }
            if (eVar instanceof e.a) {
                this.f2299d = (e.a) eVar;
            }
        }
    }
}
