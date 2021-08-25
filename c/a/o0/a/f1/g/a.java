package c.a.o0.a.f1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.f1.g.b;
import c.a.o0.a.k;
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
    public static final boolean f5675d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f5676e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f5677a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5678b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5679c;

    /* renamed from: c.a.o0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0185a implements c.a.o0.a.v2.e1.b<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5680e;

        public C0185a(a aVar) {
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
            this.f5680e = aVar;
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                boolean unused = a.f5675d;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && a.f5675d) {
                c();
            }
        }

        public final synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    a("SwanLaunch", "\n\n\n");
                    a("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.f5680e.f5679c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.f5680e.f5677a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (b.C0186b c0186b : this.f5680e.f5678b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : c0186b.f5687b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : c0186b.f5686a) {
                            String h2 = this.f5680e.f5678b.h();
                            a(TextUtils.isEmpty(c0186b.f5688c) ? h2 : c0186b.f5688c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-788592272, "Lc/a/o0/a/f1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-788592272, "Lc/a/o0/a/f1/g/a;");
                return;
            }
        }
        f5675d = k.f7049a;
        f5676e = new HashMap();
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
        this.f5677a = new HashMap();
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f5678b = bVar;
        this.f5679c = str;
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            a aVar = f5676e.get(str);
            if (aVar == null) {
                a aVar2 = new a(str);
                f5676e.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final c.a.o0.a.v2.e1.b<b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0185a(this) : (c.a.o0.a.v2.e1.b) invokeV.objValue;
    }

    public b.C0186b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5678b.d() : (b.C0186b) invokeV.objValue;
    }

    public b.C0186b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f5678b.e(str) : (b.C0186b) invokeL.objValue;
    }

    public b.C0186b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.f5678b.f(str, str2) : (b.C0186b) invokeLL.objValue;
    }

    public synchronized a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.f5678b.j();
            }
            return this;
        }
        return (a) invokeV.objValue;
    }
}
