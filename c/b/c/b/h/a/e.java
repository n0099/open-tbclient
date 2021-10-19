package c.b.c.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f31577e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31578a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f31579b;

    /* renamed from: c  reason: collision with root package name */
    public b f31580c;

    /* renamed from: d  reason: collision with root package name */
    public d f31581d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31582a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1938028212, "Lc/b/c/b/h/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1938028212, "Lc/b/c/b/h/a/e$a;");
                    return;
                }
            }
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f31582a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.f69254b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31582a[com.bytedance.tea.crash.c.f69256d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31582a[com.bytedance.tea.crash.c.f69260h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31579b = new HashMap();
        this.f31578a = context;
        this.f31580c = new b(context);
        this.f31581d = new d(this.f31578a);
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31577e != null) {
                return f31577e;
            }
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return (e) invokeV.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && f31577e == null) {
            f31577e = new e(context);
        }
    }

    public c.b.c.b.e.a a(com.bytedance.tea.crash.c cVar, c.b.c.b.e.a aVar) {
        InterceptResult invokeLL;
        c b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, aVar)) == null) ? (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar) : (c.b.c.b.e.a) invokeLL.objValue;
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            c cVar2 = this.f31579b.get(cVar);
            if (cVar2 != null) {
                return cVar2;
            }
            int i2 = a.f31582a[cVar.ordinal()];
            if (i2 == 1) {
                cVar2 = new g(this.f31578a, this.f31580c, this.f31581d);
            } else if (i2 == 2) {
                cVar2 = new c.b.c.b.h.a.a(this.f31578a, this.f31580c, this.f31581d);
            } else if (i2 == 3) {
                cVar2 = new f(this.f31578a, this.f31580c, this.f31581d);
            }
            if (cVar2 != null) {
                this.f31579b.put(cVar, cVar2);
            }
            return cVar2;
        }
        return (c) invokeL.objValue;
    }
}
