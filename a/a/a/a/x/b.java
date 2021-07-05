package a.a.a.a.x;

import a.a.a.a.v.e;
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
    public static a f1365c;

    /* renamed from: d  reason: collision with root package name */
    public static final Random f1366d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e.a f1367a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Object, p> f1368b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1837025772, "La/a/a/a/x/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1837025772, "La/a/a/a/x/b;");
                return;
            }
        }
        f1365c = new d();
        f1366d = new Random();
    }

    public b(e.a aVar) {
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
        this.f1368b = new HashMap<>();
        this.f1367a = aVar;
    }

    @Override // a.a.a.a.x.a
    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.f1368b) {
                this.f1368b.remove(obj);
            }
        }
    }

    @Override // a.a.a.a.x.a
    public void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
        }
    }

    @Override // a.a.a.a.x.a
    public final p b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            synchronized (this.f1368b) {
                p pVar = this.f1368b.get(obj);
                if (pVar != null) {
                    return pVar;
                }
                p c2 = c(obj);
                if (c2 == null) {
                    return null;
                }
                this.f1368b.put(obj, c2);
                return c2;
            }
        }
        return (p) invokeL.objValue;
    }

    @Override // a.a.a.a.x.a
    public final void b(Object obj, String str) {
        p c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, obj, str) == null) || !a.a.a.a.d.f1020a.booleanValue() || obj == null || f1366d.nextFloat() >= this.f1367a.f1348f || (c2 = c(obj)) == null) {
            return;
        }
        synchronized (this.f1368b) {
            this.f1368b.put(obj, c2);
        }
    }

    public abstract p c(Object obj);
}
