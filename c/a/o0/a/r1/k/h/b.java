package c.a.o0.a.r1.k.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.r1.l.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class b implements c.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f8365f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f8366b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c.a.o0.a.r1.k.h.a> f8367c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8368d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.r1.r.c.a f8369e;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8370b;

        public a(b bVar) {
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
            this.f8370b = bVar;
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8370b.f8368d = false;
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f8370b.f8368d = false;
                if (this.f8370b.f8367c.isEmpty()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<c.a.o0.a.r1.k.h.a> it = this.f8370b.f8367c.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (c.a.o0.a.f1.f.a.f5674a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + this.f8370b.f8367c.size();
                }
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f8370b.f8368d = true;
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GlobalJsBridge" : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.o0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0357b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f8371a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1680857056, "Lc/a/o0/a/r1/k/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1680857056, "Lc/a/o0/a/r1/k/h/b$b;");
                    return;
                }
            }
            f8371a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2022829666, "Lc/a/o0/a/r1/k/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2022829666, "Lc/a/o0/a/r1/k/h/b;");
                return;
            }
        }
        f8365f = e.d();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0357b.f8371a : (b) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && f8365f > 0 && this.f8368d) {
                for (String str2 : this.f8366b) {
                    if (str.startsWith(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(c.a.o0.a.r1.k.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (f8365f <= 0) {
            if (c.a.o0.a.f1.f.a.f5674a) {
                String str = "pending api close, can't register. duration = " + f8365f;
                return;
            }
            return;
        }
        this.f8367c.add(aVar);
        c.a.o0.a.r1.r.a.f().h(this.f8369e, f8365f);
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
        this.f8366b = new ArrayList();
        this.f8367c = new CopyOnWriteArrayList<>();
        this.f8368d = false;
        this.f8369e = new a(this);
        this.f8366b.clear();
        List<String> list = this.f8366b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
