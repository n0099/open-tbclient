package c.a.r0.a.f1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.g.b;
import c.a.r0.a.k;
import c.a.r0.a.z2.g1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5972d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f5973e;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5974b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5975c;

    /* renamed from: c.a.r0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0310a implements c<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5976e;

        public C0310a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5976e = aVar;
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                boolean unused = a.f5972d;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && a.f5972d) {
                c();
            }
        }

        public final synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    a("SwanLaunch", "\n\n\n");
                    a("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.f5976e.f5975c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.f5976e.a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (b.C0311b c0311b : this.f5976e.f5974b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : c0311b.f5981b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : c0311b.a) {
                            String h2 = this.f5976e.f5974b.h();
                            a(TextUtils.isEmpty(c0311b.f5982c) ? h2 : c0311b.f5982c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401344115, "Lc/a/r0/a/f1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401344115, "Lc/a/r0/a/f1/g/a;");
                return;
            }
        }
        f5972d = k.a;
        f5973e = new HashMap();
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f5974b = bVar;
        this.f5975c = str;
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            a aVar = f5973e.get(str);
            if (aVar == null) {
                a aVar2 = new a(str);
                f5973e.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final c<b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0310a(this) : (c) invokeV.objValue;
    }

    public b.C0311b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5974b.d() : (b.C0311b) invokeV.objValue;
    }

    public b.C0311b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f5974b.e(str) : (b.C0311b) invokeL.objValue;
    }

    public b.C0311b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.f5974b.f(str, str2) : (b.C0311b) invokeLL.objValue;
    }

    public synchronized a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.f5974b.j();
            }
            return this;
        }
        return (a) invokeV.objValue;
    }
}
