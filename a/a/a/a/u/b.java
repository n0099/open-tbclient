package a.a.a.a.u;

import a.a.a.a.s.h;
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
    public static a f1389c;

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1390d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h.a f1391a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, p> f1392b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1837115145, "La/a/a/a/u/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1837115145, "La/a/a/a/u/b;");
                return;
            }
        }
        f1389c = new d();
        f1390d = new Random();
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
        this.f1392b = new HashMap<>();
        this.f1391a = aVar;
    }

    @Override // a.a.a.a.u.a
    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.f1392b) {
                this.f1392b.remove(obj);
            }
        }
    }

    @Override // a.a.a.a.u.a
    public void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
        }
    }

    @Override // a.a.a.a.u.a
    public final p b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            synchronized (this.f1392b) {
                p pVar = this.f1392b.get(obj);
                if (pVar != null) {
                    return pVar;
                }
                p c2 = c(obj);
                if (c2 == null) {
                    return null;
                }
                this.f1392b.put(obj, c2);
                return c2;
            }
        }
        return (p) invokeL.objValue;
    }

    @Override // a.a.a.a.u.a
    public final void b(Object obj, String str) {
        p c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, obj, str) == null) || !a.a.a.a.c.f1019a.booleanValue() || obj == null || f1390d.nextFloat() >= this.f1391a.f1364f || (c2 = c(obj)) == null) {
            return;
        }
        synchronized (this.f1392b) {
            this.f1392b.put(obj, c2);
        }
    }

    public abstract p c(Object obj);
}
