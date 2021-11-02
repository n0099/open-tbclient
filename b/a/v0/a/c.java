package b.a.v0.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29075a;

    /* renamed from: b  reason: collision with root package name */
    public String f29076b;

    /* renamed from: c  reason: collision with root package name */
    public String f29077c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29078d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f29079e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, com.baidu.ubs.analytics.a.g> f29080f;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f29081a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974365399, "Lb/a/v0/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(974365399, "Lb/a/v0/a/c$a;");
                    return;
                }
            }
            f29081a = new c((byte) 0);
        }
    }

    /* loaded from: classes6.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public C1403c f29082a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29082a = new C1403c();
        }

        public final List<com.baidu.ubs.analytics.a.a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29082a.a() : (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29082a.b(i2);
            }
        }

        public final void c(com.baidu.ubs.analytics.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f29082a.c(aVar);
            }
        }
    }

    /* renamed from: b.a.v0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1403c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f29083a;

        public C1403c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29083a = f.a().c();
        }

        public final List<com.baidu.ubs.analytics.a.a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Cursor rawQuery = this.f29083a.rawQuery("SELECT * FROM tb_ab_click_log order by _id ", null);
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
                    aVar.v(rawQuery.getString(rawQuery.getColumnIndex("_eventId")));
                    aVar.w(rawQuery.getString(rawQuery.getColumnIndex("_parameter")));
                    aVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                    aVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                    aVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                    aVar.s(rawQuery.getString(rawQuery.getColumnIndex("_productLine")));
                    aVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                    arrayList.add(aVar);
                }
                rawQuery.close();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29083a.execSQL("delete from tb_ab_click_log where _id <= " + i2);
            }
        }

        public final void c(com.baidu.ubs.analytics.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f29083a.execSQL("INSERT INTO tb_ab_click_log(_eventId,_parameter,_sessionId,_timeStamp,_pagerName,_productLine) VALUES (?,?,?,?,?,?);", new String[]{aVar.G(), aVar.H(), aVar.I(), aVar.F(), aVar.E(), aVar.D()});
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(context, "BaiDuAb.db", (SQLiteDatabase.CursorFactory) null, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, sQLiteDatabase) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                String[] strArr = e.f29084a;
                if (i2 >= strArr.length) {
                    return;
                }
                sQLiteDatabase.execSQL(strArr[i2]);
                i2++;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f29084a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974365523, "Lb/a/v0/a/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(974365523, "Lb/a/v0/a/c$e;");
                    return;
                }
            }
            f29084a = new String[]{"CREATE TABLE if not exists tb_ab_click_log (\n  _eventId varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _parameter varchar,\n  _timeStamp varchar,\n  _sessionId varchar,\n  _productLine varchar,\n  _pagerName varchar\n);", "CREATE TABLE if not exists tb_ab_netlog (\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _parameters varchar,\n  _timeStamp varchar,\n  _type varchar,\n  _url varchar,\n  _sessionId varchar\n);", "CREATE TABLE if not exists tb_ab_page_log (\n  _endTime varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _pagerName varchar,\n  _path varchar,\n  _startTime varchar,\n  _sessionId varchar\n);", "CREATE TABLE if not exists tb_ab_sessionlog (\n  _endTime varchar,\n  _id integer PRIMARY KEY AUTOINCREMENT,\n  _keepTime varchar,\n  _sessionId varchar,\n  _startTime varchar\n);"};
        }
    }

    /* loaded from: classes6.dex */
    public final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static f f29085c;

        /* renamed from: d  reason: collision with root package name */
        public static SQLiteOpenHelper f29086d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f29087a;

        /* renamed from: b  reason: collision with root package name */
        public SQLiteDatabase f29088b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29087a = new AtomicInteger();
        }

        public static synchronized f a() {
            InterceptResult invokeV;
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (f.class) {
                    if (f29085c == null) {
                        b(c.h().getContext());
                    }
                    fVar = f29085c;
                }
                return fVar;
            }
            return (f) invokeV.objValue;
        }

        public static synchronized void b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
                synchronized (f.class) {
                    if (f29085c == null) {
                        f29085c = new f();
                        f29086d = new d(context);
                    }
                }
            }
        }

        public final synchronized SQLiteDatabase c() {
            InterceptResult invokeV;
            SQLiteDatabase sQLiteDatabase;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (this.f29087a.incrementAndGet() == 1) {
                        b.a.v0.a.f.a.a("***************新建立了 一个数据库的实例****************");
                        this.f29088b = f29086d.getWritableDatabase();
                    }
                    sQLiteDatabase = this.f29088b;
                }
                return sQLiteDatabase;
            }
            return (SQLiteDatabase) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f29089a;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29089a = f.a().c();
        }

        public final List<com.baidu.ubs.analytics.a.i> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Cursor rawQuery = this.f29089a.rawQuery("SELECT * FROM tb_ab_netlog order by _id ", null);
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    com.baidu.ubs.analytics.a.i iVar = new com.baidu.ubs.analytics.a.i();
                    iVar.setUrl(rawQuery.getString(rawQuery.getColumnIndex("_url")));
                    iVar.setType(rawQuery.getString(rawQuery.getColumnIndex("_type")));
                    iVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                    iVar.setParameters(rawQuery.getString(rawQuery.getColumnIndex("_parameters")));
                    iVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                    iVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                    arrayList.add(iVar);
                }
                rawQuery.close();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29089a.execSQL("delete from tb_ab_netlog where _id <= " + i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public g f29090a;

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
                    return;
                }
            }
            this.f29090a = new g();
        }

        public final List<com.baidu.ubs.analytics.a.i> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29090a.a() : (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29090a.b(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f29091a;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29091a = f.a().c();
        }

        public final List<com.baidu.ubs.analytics.a.l> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Cursor rawQuery = this.f29091a.rawQuery("SELECT * FROM  tb_ab_page_log order by _id ", null);
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
                    lVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                    lVar.setPath(rawQuery.getString(rawQuery.getColumnIndex("_path")));
                    lVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                    lVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                    lVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                    lVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                    arrayList.add(lVar);
                }
                rawQuery.close();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29091a.execSQL("delete from tb_ab_page_log where _id <= " + i2);
            }
        }

        public final void c(com.baidu.ubs.analytics.a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                this.f29091a.execSQL("INSERT INTO tb_ab_page_log(_startTime,_endTime,_pagerName,_path,_sessionId) VALUES (?,?,?,?,?);", new String[]{lVar.N(), lVar.O(), lVar.E(), lVar.getPath(), lVar.I()});
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public i f29092a;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29092a = new i();
        }

        public final List<com.baidu.ubs.analytics.a.l> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29092a.a() : (List) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f29092a.b(i2);
            }
        }

        public final void c(com.baidu.ubs.analytics.a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                this.f29092a.c(lVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f29093a;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29093a = f.a().c();
        }

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29093a.execSQL("delete from tb_ab_sessionlog where not ( _sessionId = ? )", new String[]{str});
            }
        }

        public final boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                Cursor rawQuery = this.f29093a.rawQuery("select * from tb_ab_sessionlog where _sessionId = ? ", new String[]{str});
                int count = rawQuery.getCount();
                rawQuery.close();
                return count > 0;
            }
            return invokeL.booleanValue;
        }

        public final List<n> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Cursor rawQuery = this.f29093a.rawQuery("SELECT * FROM  tb_ab_sessionlog", null);
                ArrayList arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    n nVar = new n();
                    nVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                    nVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                    nVar.A(rawQuery.getString(rawQuery.getColumnIndex("_keepTime")));
                    nVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                    arrayList.add(nVar);
                }
                rawQuery.close();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final void d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, nVar) == null) {
                this.f29093a.execSQL("INSERT INTO tb_ab_sessionlog(_startTime,_keepTime,_endTime,_sessionId) VALUES (?,?,?,?);", new String[]{nVar.N(), nVar.P(), nVar.O(), nVar.I()});
            }
        }

        public final void e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
                this.f29093a.execSQL("UPDATE tb_ab_sessionlog SET _keepTime= ? , _endTime = ? WHERE _sessionId= ?", new String[]{nVar.P(), nVar.O(), nVar.I()});
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public k f29094a;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29094a = new k();
        }

        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29094a.a(str);
            }
        }

        public final boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f29094a.b(str) : invokeL.booleanValue;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f29094a.a(str);
            }
        }

        public final List<n> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29094a.c() : (List) invokeV.objValue;
        }

        public final void e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
                this.f29094a.e(nVar);
            }
        }

        public final void f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, nVar) == null) {
                this.f29094a.d(nVar);
            }
        }
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f29081a : (c) invokeV.objValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f29075a = context;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f29076b = str;
        }
    }

    public final synchronized void c(List<com.baidu.ubs.analytics.a.g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            synchronized (this) {
                this.f29080f = new HashMap();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) != null) {
                        this.f29080f.put(list.get(i2).getId(), list.get(i2));
                    }
                }
            }
        }
    }

    public final synchronized void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this) {
                this.f29078d = z;
            }
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f29077c = str;
        }
    }

    public final SampleResult f(String str) {
        InterceptResult invokeL;
        Map<String, com.baidu.ubs.analytics.a.g> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.f29079e == null) {
                if (str != null && (map = this.f29080f) != null) {
                    if (map.containsKey(str)) {
                        return b.a.v0.a.f.h.a(this.f29080f.get(str).getGroup());
                    }
                    return SampleResult.OTHERE;
                }
                return SampleResult.OTHERE;
            }
            for (int i2 = 0; i2 < this.f29079e.length(); i2++) {
                JSONObject optJSONObject = this.f29079e.optJSONObject(i2);
                if (optJSONObject != null && str.equals(optJSONObject.optString("exid"))) {
                    return b.a.v0.a.f.h.a(optJSONObject.optString("group"));
                }
            }
            return SampleResult.OTHERE;
        }
        return (SampleResult) invokeL.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29078d : invokeV.booleanValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29075a : (Context) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29076b : (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29077c : (String) invokeV.objValue;
    }

    public final Map<String, com.baidu.ubs.analytics.a.g> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29080f : (Map) invokeV.objValue;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29078d = true;
    }
}
