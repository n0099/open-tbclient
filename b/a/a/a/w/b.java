package b.a.a.a.w;

import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
public abstract class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f1477c;

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1478d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h.a f1479a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, p> f1480b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1707972844, "Lb/a/a/a/w/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1707972844, "Lb/a/a/a/w/b;");
                return;
            }
        }
        f1477c = new d();
        f1478d = new Random();
    }

    public b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1480b = new HashMap<>();
        this.f1479a = aVar;
    }

    @Override // b.a.a.a.w.a
    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.f1480b) {
                this.f1480b.remove(obj);
            }
        }
    }

    @Override // b.a.a.a.w.a
    public void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
        }
    }

    @Override // b.a.a.a.w.a
    public final p b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            synchronized (this.f1480b) {
                p pVar = this.f1480b.get(obj);
                if (pVar != null) {
                    return pVar;
                }
                p d2 = d(obj);
                if (d2 == null) {
                    return null;
                }
                this.f1480b.put(obj, d2);
                return d2;
            }
        }
        return (p) invokeL.objValue;
    }

    @Override // b.a.a.a.w.a
    public final void c(Object obj, String str) {
        p d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, obj, str) == null) || !b.a.a.a.d.f1061a.booleanValue() || obj == null || f1478d.nextFloat() >= this.f1479a.f1451f || (d2 = d(obj)) == null) {
            return;
        }
        synchronized (this.f1480b) {
            this.f1480b.put(obj, d2);
        }
    }

    public abstract p d(Object obj);
}
