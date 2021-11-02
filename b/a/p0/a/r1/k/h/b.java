package b.a.p0.a.r1.k.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.r1.l.e;
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

    /* renamed from: f  reason: collision with root package name */
    public static final int f7675f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f7676b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<b.a.p0.a.r1.k.h.a> f7677c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7678d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.r1.r.c.a f7679e;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f7680b;

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
            this.f7680b = bVar;
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7680b.f7678d = false;
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f7680b.f7678d = false;
                if (this.f7680b.f7677c.isEmpty()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<b.a.p0.a.r1.k.h.a> it = this.f7680b.f7677c.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (b.a.p0.a.f1.f.a.f5062a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "pending api dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms, listener count = " + this.f7680b.f7677c.size();
                }
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f7680b.f7678d = true;
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GlobalJsBridge" : (String) invokeV.objValue;
        }
    }

    /* renamed from: b.a.p0.a.r1.k.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0354b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f7681a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1579147104, "Lb/a/p0/a/r1/k/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1579147104, "Lb/a/p0/a/r1/k/h/b$b;");
                    return;
                }
            }
            f7681a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1531315938, "Lb/a/p0/a/r1/k/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1531315938, "Lb/a/p0/a/r1/k/h/b;");
                return;
            }
        }
        f7675f = e.d();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0354b.f7681a : (b) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && f7675f > 0 && this.f7678d) {
                for (String str2 : this.f7676b) {
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

    public void d(b.a.p0.a.r1.k.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (f7675f <= 0) {
            if (b.a.p0.a.f1.f.a.f5062a) {
                String str = "pending api close, can't register. duration = " + f7675f;
                return;
            }
            return;
        }
        this.f7677c.add(aVar);
        b.a.p0.a.r1.r.a.f().h(this.f7679e, f7675f);
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
        this.f7676b = new ArrayList();
        this.f7677c = new CopyOnWriteArrayList<>();
        this.f7678d = false;
        this.f7679e = new a(this);
        this.f7676b.clear();
        List<String> list = this.f7676b;
        list.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI/openStatisticEvent?");
    }
}
