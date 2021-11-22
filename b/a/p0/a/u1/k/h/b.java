package b.a.p0.a.u1.k.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
public class b implements b.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f9028c;

    /* renamed from: d  reason: collision with root package name */
    public CopyOnWriteArrayList<b.a.p0.a.u1.k.h.a> f9029d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9030e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.u1.r.c.a f9031f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9032c;

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
            this.f9032c = bVar;
        }

        @Override // b.a.p0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.p0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9032c.f9030e = false;
            }
        }

        @Override // b.a.p0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
            }
        }

        @Override // b.a.p0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9032c.f9030e = false;
                if (this.f9032c.f9029d.isEmpty()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<b.a.p0.a.u1.k.h.a> it = this.f9032c.f9029d.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (b.a.p0.a.f1.f.a.f4837a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + this.f9032c.f9029d.size();
                }
            }
        }

        @Override // b.a.p0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f9032c.f9030e = true;
            }
        }

        @Override // b.a.p0.a.u1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "GlobalJsBridge" : (String) invokeV.objValue;
        }
    }

    /* renamed from: b.a.p0.a.u1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0447b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f9033a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(483260323, "Lb/a/p0/a/u1/k/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(483260323, "Lb/a/p0/a/u1/k/h/b$b;");
                    return;
                }
            }
            f9033a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0447b.f9033a : (b) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.f9030e) {
                for (String str2 : this.f9028c) {
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

    public void d(b.a.p0.a.u1.k.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f9029d.add(aVar);
        b.a.p0.a.u1.r.a.g().i(this.f9031f, 4000);
    }

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
        this.f9028c = new ArrayList();
        this.f9029d = new CopyOnWriteArrayList<>();
        this.f9030e = false;
        this.f9031f = new a(this);
        this.f9028c.clear();
        List<String> list = this.f9028c;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
