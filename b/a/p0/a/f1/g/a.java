package b.a.p0.a.f1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.g.b;
import b.a.p0.a.k;
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
    public static final boolean f5063d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f5064e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f5065a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5066b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5067c;

    /* renamed from: b.a.p0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0182a implements b.a.p0.a.v2.e1.b<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5068e;

        public C0182a(a aVar) {
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
            this.f5068e = aVar;
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                boolean unused = a.f5063d;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && a.f5063d) {
                c();
            }
        }

        public final synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    a("SwanLaunch", "\n\n\n");
                    a("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.f5068e.f5067c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.f5068e.f5065a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (b.C0183b c0183b : this.f5068e.f5066b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : c0183b.f5075b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : c0183b.f5074a) {
                            String h2 = this.f5068e.f5066b.h();
                            a(TextUtils.isEmpty(c0183b.f5076c) ? h2 : c0183b.f5076c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-148975376, "Lb/a/p0/a/f1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-148975376, "Lb/a/p0/a/f1/g/a;");
                return;
            }
        }
        f5063d = k.f6397a;
        f5064e = new HashMap();
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
        this.f5065a = new HashMap();
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f5066b = bVar;
        this.f5067c = str;
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            a aVar = f5064e.get(str);
            if (aVar == null) {
                a aVar2 = new a(str);
                f5064e.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final b.a.p0.a.v2.e1.b<b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0182a(this) : (b.a.p0.a.v2.e1.b) invokeV.objValue;
    }

    public b.C0183b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5066b.d() : (b.C0183b) invokeV.objValue;
    }

    public b.C0183b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f5066b.e(str) : (b.C0183b) invokeL.objValue;
    }

    public b.C0183b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.f5066b.f(str, str2) : (b.C0183b) invokeLL.objValue;
    }

    public synchronized a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.f5066b.j();
            }
            return this;
        }
        return (a) invokeV.objValue;
    }
}
