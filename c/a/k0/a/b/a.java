package c.a.k0.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a<T> implements c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.k0.a.a<T> f4272b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.k0.a.a<T> f4273c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.k0.a.b.c
    public void a(c.a.k0.a.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f4272b = aVar;
            this.a = null;
        }
    }

    @Override // c.a.k0.a.b.c
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t != null) {
                return t;
            }
            c.a.k0.a.a<T> aVar = this.f4272b;
            if (aVar != null) {
                T t2 = aVar.get();
                this.a = t2;
                return t2;
            }
            c.a.k0.a.a<T> aVar2 = this.f4273c;
            if (aVar2 != null) {
                return aVar2.get();
            }
            return null;
        }
        return (T) invokeV.objValue;
    }
}
