package c.a.p0.a.f2.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5324c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5325b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630969744, "Lc/a/p0/a/f2/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-630969744, "Lc/a/p0/a/f2/d/b;");
                return;
            }
        }
        f5324c = c.a.p0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public synchronized void a(c.a.p0.a.f2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (!TextUtils.isEmpty(aVar.a) && !TextUtils.isEmpty(aVar.f5303c) && !TextUtils.isEmpty(aVar.f5302b)) {
                        if (aVar.f5305e == -1) {
                            return;
                        }
                        SQLiteDatabase f2 = f();
                        if (f2 == null) {
                            return;
                        }
                        if (f5324c) {
                            String str = "addCookie cookie=" + aVar.toString();
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", aVar.a);
                        contentValues.put("path", aVar.f5302b);
                        contentValues.put("name", aVar.f5303c);
                        contentValues.put("value", aVar.f5304d);
                        contentValues.put("expires", Long.valueOf(aVar.f5305e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(aVar.f5306f));
                        f2.insert("cookies", null, contentValues);
                    }
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                boolean z = f5324c;
                f2.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                try {
                    boolean z = f5324c;
                    this.a.close();
                    this.a = null;
                    this.f5325b = true;
                } catch (Exception e2) {
                    d.k("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e2));
                }
            }
        }
    }

    public synchronized void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                if (f5324c) {
                    String str4 = "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3;
                }
                f2.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    public synchronized ArrayList<c.a.p0.a.f2.a> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (f5324c) {
                    String str2 = "getCookiesForDomain baseDomain=" + str;
                }
                ArrayList<c.a.p0.a.f2.a> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return arrayList;
                }
                Cursor query = f2.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
                if (query == null) {
                    return arrayList;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("domain");
                    int columnIndex2 = query.getColumnIndex("path");
                    int columnIndex3 = query.getColumnIndex("name");
                    int columnIndex4 = query.getColumnIndex("value");
                    int columnIndex5 = query.getColumnIndex("expires");
                    int columnIndex6 = query.getColumnIndex(ClientCookie.SECURE_ATTR);
                    do {
                        c.a.p0.a.f2.a aVar = new c.a.p0.a.f2.a();
                        aVar.a = query.getString(columnIndex);
                        aVar.f5302b = query.getString(columnIndex2);
                        aVar.f5303c = query.getString(columnIndex3);
                        aVar.f5304d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            aVar.f5305e = -1L;
                        } else {
                            aVar.f5305e = query.getLong(columnIndex5);
                        }
                        aVar.f5306f = query.getShort(columnIndex6) != 0;
                        aVar.f5309i = 1;
                        if (aVar.f5305e > currentTimeMillis) {
                            arrayList.add(aVar);
                            if (f5324c) {
                                String str3 = "getCookiesForDomain cookie=" + aVar.toString();
                            }
                        }
                    } while (query.moveToNext());
                    c.a.p0.a.z0.e.a.a(query);
                    return arrayList;
                }
                c.a.p0.a.z0.e.a.a(query);
                return arrayList;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public final SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5325b) {
                return null;
            }
            a aVar = this.a;
            if (aVar != null) {
                return aVar.getWritableDatabase();
            }
            String appId = c.a.p0.a.t1.d.J().getAppId();
            if (!c.a.p0.a.t1.d.J().D()) {
                d.k("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = c.a.p0.a.e2.b.t(c.a.p0.a.t1.d.J().r());
            d.k("SwanCookieDatabase", "initDbHelper name =" + t);
            a aVar2 = new a(c.a.p0.a.s0.a.c(), t);
            this.a = aVar2;
            return aVar2.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                try {
                    f2.beginTransaction();
                    runnable.run();
                    f2.setTransactionSuccessful();
                    try {
                        f2.endTransaction();
                    } catch (Exception e2) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e2);
                        d.k(str, stackTraceString);
                    }
                } catch (Exception e3) {
                    d.k("SwanCookieDatabase", Log.getStackTraceString(e3));
                    try {
                        f2.endTransaction();
                    } catch (Exception e4) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e4);
                        d.k(str, stackTraceString);
                    }
                }
            }
        }
    }

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                f();
            }
        }
    }
}
