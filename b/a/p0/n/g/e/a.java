package b.a.p0.n.g.e;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import b.a.p0.n.g.d.c;
import b.a.p0.n.g.d.e;
import b.a.p0.n.h.d;
import b.a.p0.n.h.f;
import b.a.p0.n.h.g;
import b.a.p0.n.h.h;
import b.a.p0.n.h.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f11054f = null;

    /* renamed from: g  reason: collision with root package name */
    public static final int f11055g = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b.a.p0.n.g.d.a> f11056e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-734431915, "Lb/a/p0/n/g/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-734431915, "Lb/a/p0/n/g/e/a;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this("ai_apps_pms.db", f11055g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f11054f == null) {
                synchronized (a.class) {
                    if (f11054f == null) {
                        f11054f = new a();
                    }
                }
            }
            return f11054f;
        }
        return (a) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConcurrentHashMap<Class<?>, b.a.p0.n.g.d.a> concurrentHashMap = new ConcurrentHashMap<>();
            this.f11056e = concurrentHashMap;
            concurrentHashMap.put(f.class, new e());
            this.f11056e.put(g.class, new b.a.p0.n.g.d.f());
            this.f11056e.put(PMSAppInfo.class, new b.a.p0.n.g.d.b());
            this.f11056e.put(d.class, new b.a.p0.n.g.d.d());
            this.f11056e.put(b.a.p0.n.h.b.class, new c());
            this.f11056e.put(h.class, new b.a.p0.n.g.d.g());
            this.f11056e.put(i.class, new b.a.p0.n.g.d.h());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f11054f = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            for (b.a.p0.n.g.d.a aVar : this.f11056e.values()) {
                aVar.a(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
            for (b.a.p0.n.g.d.a aVar : this.f11056e.values()) {
                aVar.onUpgrade(sQLiteDatabase, i2, i3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, int i2) {
        super(AppRuntime.getAppContext(), str, null, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
